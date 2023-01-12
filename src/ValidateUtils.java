public class ValidateUtils {
    public static String checkString(String str) throws WrongInputException {
        if (str == null || str.isEmpty() || str.isBlank()) {
            throw new WrongInputException("Неккоретный ввод");
        } else {
            return str;
        }
    }
}
