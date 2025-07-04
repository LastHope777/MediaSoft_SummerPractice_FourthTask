@DeprecatedEx(message = "Используйте NewService вместо этого класса.")
public class OldService {

    @DeprecatedEx(message = "Метод устарел, используйте newMethod()")
    public void oldMethod() {
        System.out.println("Старый метод выполняется");
    }
}
