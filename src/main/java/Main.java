import java.io.IOException;
import java.lang.reflect.Type;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner reaedr = new Scanner(System.in);

            System.out.println("*****************************************************+");
            System.out.println("Bienvenido al conversor de monedas más importante");
            System.out.println("  1) Dolar       => Sol peruano");
            System.out.println("  2) Sol peruano => Dolar");
            System.out.println("  3) Yen         => Sol peruano");
            System.out.println("  4) Sol peruano => Yen");
            System.out.println("  5) Euro        => Sol peruano");
            System.out.println("  6) Sol peruano => Euro");
            System.out.println("  7) Salir");
            System.out.print("  Elija una opción válida: ");

            String option = reaedr.nextLine();

            try {
                int optionNumber = Integer.parseInt(option);
                if(optionNumber==7) {break;}
                System.out.print("Ingrese el monto a convertir: ");
                double monto = reaedr.nextDouble();
                if (optionNumber>0 & optionNumber<7) {
                    ConsultaMoneda miConsulta = new ConsultaMoneda();
                    TypeChange cambio;
                    double montoConvertido;
                    switch (optionNumber) {
                        case 1:
                            cambio = miConsulta.conversion("USD");
                            montoConvertido = cambio.convertQuantity(monto, "PEN");
                            System.out.println("La conversión es: "+monto+" dólares equivale a "+montoConvertido+" soles");
                            break;
                        case 2:
                            cambio = miConsulta.conversion("PEN");
                            montoConvertido = cambio.convertQuantity(monto, "USD");
                            System.out.println("La conversión es: "+monto+" soles equivale a "+montoConvertido+" dólares");
                            break;
                        case 3:
                            cambio = miConsulta.conversion("JPY");
                            montoConvertido = cambio.convertQuantity(monto, "PEN");
                            System.out.println("La conversión es: "+monto+" yenes equivale a "+montoConvertido+" soles");
                            break;
                        case 4:
                            cambio = miConsulta.conversion("PEN");
                            montoConvertido = cambio.convertQuantity(monto, "JPY");
                            System.out.println("La conversión es: "+monto+" soles equivale a "+montoConvertido+" yenes");
                            break;
                        case 5:
                            cambio = miConsulta.conversion("EUR");
                            montoConvertido = cambio.convertQuantity(monto, "PEN");
                            System.out.println("La conversión es: "+monto+" euros equivale a "+montoConvertido+" soles");
                            break;
                        case 6:
                            cambio = miConsulta.conversion("PEN");
                            montoConvertido = cambio.convertQuantity(monto, "EUR");
                            System.out.println("La conversión es: "+monto+" soles equivale a "+montoConvertido+" euros");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa una opción válida");
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println("El monto ingresado es inválido");
            }


        }
    }
}
