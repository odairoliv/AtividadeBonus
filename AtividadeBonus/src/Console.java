import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt() {
        int valor = 0;
        while (true) {
            try {
                valor = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("O valor informado não é um inteiro. Digite novamente: ");
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static float lerFloat() {
        float valor = 0;
        while (true) {
            try {
                valor = scanner.nextFloat();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("O valor informado não é um 'float'. Digite novamente: ");
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static String lerString() {
        String valor = "";
        while (true) {
            valor = scanner.nextLine();
            if (!valor.trim().isEmpty()) {
                break;
            } else {
                System.out.print("O valor não pode ser vazio. Digite novamente: ");
            }
        }
        return valor;
    }
}
