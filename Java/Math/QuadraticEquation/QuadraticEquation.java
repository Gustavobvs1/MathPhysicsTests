
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        boolean runAgain = true;
        while (runAgain) {
            try {
                runAgain = false;
                calculateRoots();
            } catch (UnvalidEquationException e) {
                System.out.println("Erro: " + e.getMessage());
                runAgain = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número!");
                runAgain = true;
            }
        }
    }

    public static void calculateRoots() throws UnvalidEquationException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o valor de a: ");
        int a = scanner.nextInt();

        if (a == 0)
            throw new UnvalidEquationException();

        System.out.print("\nDigite o valor de b: ");
        int b = scanner.nextInt();

        System.out.print("\nDigite o valor de c: ");
        int c = scanner.nextInt();

        scanner.close();

        String equation = String.format("%dx² + %dx + %d", a, b, c);
        System.out.println("\nEquação: " + equation);

        double delta = Math.pow(b, 2) - 4 * a * c;

        System.out.println("\nDelta: " + delta);

        if (delta < 0) {
            double imaginaryNumber = Math.sqrt(Math.abs(delta)) / (2 * a);
            double realNumber = (b * -1) * Math.pow((2 * a), -1);
            System.out.println("\nX1 = " + realNumber + " + " + imaginaryNumber + "i");
            System.out.println("\nX2 = " + realNumber + " - " + imaginaryNumber + "i");

            double module = Math.sqrt(Math.pow(imaginaryNumber, 2) + Math.pow(realNumber, 2));

            int angleX1 = (int) Math.floor(Math.toDegrees(Math.atan2(imaginaryNumber, realNumber)));
            int angleX2 = (int) Math.ceil(Math.toDegrees(Math.atan2(imaginaryNumber * -1, realNumber)));

            System.out.println("\nFormas polares: ");
            System.out.println("\nX1: " + module + " cis " + angleX1 + "º");
            System.out.println("\nX2: " + module + " cis " + angleX2 + "º");

        } else {

            double x1 = ((b * -1) + Math.sqrt(delta)) / (2 * a);
            System.out.println("\nX1: " + x1);

            if (delta != 0) {
                double x2 = ((b * -1) - Math.sqrt(delta)) / (2 * a);
                System.out.println("\nX2: " + x2);
            }
        }
    }
}
