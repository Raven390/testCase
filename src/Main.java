import java.util.Scanner;

public class Main {
    static int pointer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        for (;;) {
            input = scanner.nextLine();
            if (input.matches("[\\[\\]\\w\\d]*")) {
                break;
            } else {
                System.out.println("Ошибка в введенной строке! Строка может содержать только цифры, латинские буквы и квадратные скобки!");
            }
        }
        System.out.println(stringUnpack(input));
    }

    public static String stringUnpack(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int repetitions = 0;
        while (pointer < input.length() && input.charAt(pointer) != ']') {
            char currentChar = input.charAt(pointer);
            if (currentChar == '[') {
                String buffer = stringUnpack(input);
                stringBuilder.append(buffer.repeat(Math.max(0, repetitions)));
                repetitions = 0;
                pointer++;
            } else if (Character.isDigit(currentChar)) {
                repetitions = Character.getNumericValue(currentChar);
            } else {
                stringBuilder.append(currentChar);
            }
            pointer++;
        }
        return stringBuilder.toString();
    }
}