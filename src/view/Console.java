package view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String msg){
        int valor = 0;
        while(true){
            try { // tenta executar a leitura do int
                System.out.print(msg + ": ");
                valor = scanner.nextInt();
                break; // quebra o loop se o valor foi lido
            
            } catch (InputMismatchException e) {
                // senão, a exceção é capturada:
                System.out.println("O valor informado não é um inteiro.");
            
            } finally { // SEMPRE será executado

                scanner.nextLine(); // limpa o buffer
            }
        }
        // retorna o valor lido:
        return valor;
    }

    public static int lerInt() {
        return lerInt("Digite um valor 'int'");
    }

    public static float lerFloat(String msg) {
        float valor = 0;

        while (true) {
            try {
                System.out.print(msg + ": ");
                valor = scanner.nextFloat();
                break;

            } catch (InputMismatchException e) {
              
                System.out.println("O valor informado não é um 'float'. Digite novamente: ");
            }
             finally { // SEMPRE será executado
                scanner.nextLine(); // limpa o buffer
            }
        }
        return valor;
    }

    public static float lerFloat() {
        return lerInt("Digite um valor 'int'");
    }

    public static String lerString(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextLine();
    }

    public static String lerString() {
        return lerString("Digite uma 'string'");
    }


}
