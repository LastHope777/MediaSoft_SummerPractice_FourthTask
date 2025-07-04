import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // 1. Printable
        Printable printable = () -> System.out.println("Печать через лямбда");
        printable.print();

        // 2. Predicate
        Predicate<String> isNotNull = s -> s != null;
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isValid = isNotNull.and(isNotEmpty);
        String input = "Hello";
        System.out.println("Валидность строки: " + isValid.test(input));

        // 3. Predicate - startsWith и endsWith
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");
        Predicate<String> condition = startsWithJorN.and(endsWithA);
        System.out.println("Проверка строки JavaA: " + condition.test("JavaA"));
        System.out.println("Проверка строки NikaA: " + condition.test("NikaA"));

        // 4. HeavyBox + Consumer
        HeavyBox box = new HeavyBox(25);
        Consumer<HeavyBox> ship = b -> System.out.println("Отгрузка ящика весом: " + b.getWeight());
        Consumer<HeavyBox> send = b -> System.out.println("Отправка ящика весом: " + b.getWeight());
        ship.andThen(send).accept(box);

        // 5. Function
        Function<Integer, String> checkNumber = n -> {
            if (n > 0) return "Положительное";
            if (n < 0) return "Отрицательное";
            return "Ноль";
        };
        System.out.println(checkNumber.apply(7));
        System.out.println(checkNumber.apply(-3));
        System.out.println(checkNumber.apply(0));

        // 6. Supplier
        Supplier<Integer> random = () -> new Random().nextInt(11);
        System.out.println("Случайное число от 0 до 10: " + random.get());

        // 7. DeprecatedChecker
        DeprecatedChecker.checkDeprecated(OldService.class);

        // 8. JsonSerializer
        Person person = new Person("Иван", 30);
        String json = JsonSerializer.toJson(person);
        System.out.println("JSON: " + json);
    }
}
