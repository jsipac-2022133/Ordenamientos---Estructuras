import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("Hoja de Trabajo 3 - Ordenamientos");

        while (!salir) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Generar numeros aleatorios y guardar en archivo");
            System.out.println("2. Ordenar con Gnome Sort");
            System.out.println("3. Ordenar con Merge Sort");
            System.out.println("4. Ordenar con Quick Sort");
            System.out.println("5. Ordenar con Radix Sort");
            System.out.println("6. Ordenar con Shell Sort");
            System.out.println("7. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Opcion 1 seleccionada (pendiente de implementar)");
                    break;
                case 2:
                    System.out.println("Opcion 2 seleccionada (pendiente de implementar)");
                    break;
                case 3:
                    System.out.println("Opcion 3 seleccionada (pendiente de implementar)");
                    break;
                case 4:
                    System.out.println("Opcion 4 seleccionada (pendiente de implementar)");
                    break;
                case 5:
                    System.out.println("Opcion 5 seleccionada (pendiente de implementar)");
                    break;
                case 6:
                    System.out.println("Opcion 6 seleccionada (pendiente de implementar)");
                    break;
                case 7:
                    salir = true;
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}