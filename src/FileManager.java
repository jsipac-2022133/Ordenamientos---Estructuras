import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class FileManager {

    // cuantos numeros generar (maximo 3000)
    public static void generarNumeros(String nombreArchivo, int cantidad) {

        if (cantidad > 3000) {
            cantidad = 3000;
            System.out.println("La cantidad maxima es 3000. Se generaran 3000 numeros.");
        }

        Random random = new Random();

        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            BufferedWriter buffer = new BufferedWriter(escritor);

            for (int i = 0; i < cantidad; i++) {
                int numero = random.nextInt(10000); // numeros entre 0 y 9999
                buffer.write(numero + "\n");
            }

            buffer.close();
            System.out.println("Se generaron " + cantidad + " numeros en el archivo: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static Integer[] leerNumeros(String nombreArchivo) {

        ArrayList<Integer> lista = new ArrayList<>();

        try {
            FileReader lector = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(lector);

            String linea = buffer.readLine();

            while (linea != null) {
                if (!linea.trim().equals("")) {
                    int numero = Integer.parseInt(linea.trim());
                    lista.add(numero);
                }
                linea = buffer.readLine();
            }

            buffer.close();
            System.out.println("Se leyeron " + lista.size() + " numeros del archivo.");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el archivo contiene datos que no son numeros.");
        }

        Integer[] arreglo = new Integer[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arreglo[i] = lista.get(i);
        }

        return arreglo;
    }

    public static Integer[] copiarArreglo(Integer[] original) {
        Integer[] copia = new Integer[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public static void imprimirArreglo(Integer[] arreglo, int cantidad) {
        int limite = Math.min(cantidad, arreglo.length);
        System.out.print("[ ");
        for (int i = 0; i < limite; i++) {
            System.out.print(arreglo[i]);
            if (i < limite - 1) {
                System.out.print(", ");
            }
        }
        if (arreglo.length > cantidad) {
            System.out.print(", ...");
        }
        System.out.println(" ]");
    }
}