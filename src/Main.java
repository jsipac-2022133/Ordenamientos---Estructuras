import java.util.Scanner;

public class Main {

    static final String NOMBRE_ARCHIVO = "datos.txt";

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
            System.out.println("7. Medir tiempos de todos los algoritmos (Profiler)");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Cuantos numeros deseas generar? (maximo 3000): ");
                    int cantidad = scanner.nextInt();
                    FileManager.generarNumeros(NOMBRE_ARCHIVO, cantidad);
                    break;

                case 2: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }
                    System.out.print("Primeros 10 numeros ANTES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);

                    Profiler profiler = new Profiler();
                    profiler.iniciar();
                    SortAlgorithms.gnomeSort(datos);
                    profiler.detener();

                    System.out.print("Primeros 10 numeros DESPUES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);
                    profiler.imprimirResultado("Gnome Sort", datos.length);
                    break;
                }

                case 3: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }
                    System.out.print("Primeros 10 numeros ANTES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);

                    Profiler profiler = new Profiler();
                    profiler.iniciar();
                    SortAlgorithms.mergeSort(datos, 0, datos.length - 1);
                    profiler.detener();

                    System.out.print("Primeros 10 numeros DESPUES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);
                    profiler.imprimirResultado("Merge Sort", datos.length);
                    break;
                }

                case 4: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }
                    System.out.print("Primeros 10 numeros ANTES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);

                    Profiler profiler = new Profiler();
                    profiler.iniciar();
                    SortAlgorithms.quickSort(datos, 0, datos.length - 1);
                    profiler.detener();

                    System.out.print("Primeros 10 numeros DESPUES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);
                    profiler.imprimirResultado("Quick Sort", datos.length);
                    break;
                }

                case 5: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }
                    System.out.print("Primeros 10 numeros ANTES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);

                    Profiler profiler = new Profiler();
                    profiler.iniciar();
                    SortAlgorithms.radixSort(datos);
                    profiler.detener();

                    System.out.print("Primeros 10 numeros DESPUES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);
                    profiler.imprimirResultado("Radix Sort", datos.length);
                    break;
                }

                case 6: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }
                    System.out.print("Primeros 10 numeros ANTES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);

                    Profiler profiler = new Profiler();
                    profiler.iniciar();
                    SortAlgorithms.shellSort(datos);
                    profiler.detener();

                    System.out.print("Primeros 10 numeros DESPUES de ordenar: ");
                    FileManager.imprimirArreglo(datos, 10);
                    profiler.imprimirResultado("Shell Sort", datos.length);
                    break;
                }

                case 7: {
                    Integer[] datos = FileManager.leerNumeros(NOMBRE_ARCHIVO);
                    if (datos.length == 0) {
                        System.out.println("Primero genera los numeros (opcion 1).");
                        break;
                    }

                    // Primera corrida: datos DESORDENADOS (tal como se leen del archivo)
                    Profiler.medirTiemposEnIntervalos(datos, false);

                    // Ordenamos el arreglo para la segunda corrida
                    Integer[] datosOrdenados = FileManager.copiarArreglo(datos);
                    SortAlgorithms.mergeSort(datosOrdenados, 0, datosOrdenados.length - 1);

                    // Segunda corrida: datos YA ORDENADOS
                    Profiler.medirTiemposEnIntervalos(datosOrdenados, true);
                    break;
                }

                case 8:
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