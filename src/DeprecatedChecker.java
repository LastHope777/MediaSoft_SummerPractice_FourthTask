import java.lang.reflect.Method;

public class DeprecatedChecker {
    public static void checkDeprecated(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("Класс " + clazz.getSimpleName() + " устарел: " + annotation.message());
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("Метод " + method.getName() + " устарел: " + annotation.message());
            }
        }
    }
}
