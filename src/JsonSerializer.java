import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    if (!first) json.append(", ");
                    json.append("\"").append(annotation.name()).append("\": ");
                    Object value = field.get(obj);
                    json.append(value instanceof String ? "\"" + value + "\"" : value);
                    first = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}
