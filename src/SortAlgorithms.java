public class SortAlgorithms {

    // GNOME SORT
    public static <T extends Comparable<T>> void gnomeSort(T[] arreglo) {

        int indice = 0;

        while (indice < arreglo.length) {

            if (indice == 0 || arreglo[indice].compareTo(arreglo[indice - 1]) >= 0) {
                indice++;
            } else {
                T temporal = arreglo[indice];
                arreglo[indice] = arreglo[indice - 1];
                arreglo[indice - 1] = temporal;
                indice--;
            }
        }
    }

    // MERGE SORT
    public static <T extends Comparable<T>> void mergeSort(T[] arreglo, int inicio, int fin) {

        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            // Ordenar la mitad izquierda
            mergeSort(arreglo, inicio, medio);
            // Ordenar la mitad derecha
            mergeSort(arreglo, medio + 1, fin);
            // Combinar las dos mitades ordenadas
            merge(arreglo, inicio, medio, fin);
        }
    }

    // Metodo auxiliar que combina dos subarreglos ordenados
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arreglo, int inicio, int medio, int fin) {
        int tamañoIzquierda = medio - inicio + 1;
        int tamañoDerecha = fin - medio;

        T[] izquierda = (T[]) new Comparable[tamañoIzquierda];
        T[] derecha = (T[]) new Comparable[tamañoDerecha];

        for (int i = 0; i < tamañoIzquierda; i++) {
            izquierda[i] = arreglo[inicio + i];
        }
        for (int j = 0; j < tamañoDerecha; j++) {
            derecha[j] = arreglo[medio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamañoIzquierda && j < tamañoDerecha) {
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                arreglo[k] = izquierda[i];
                i++;
            } else {
                arreglo[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < tamañoIzquierda) {
            arreglo[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < tamañoDerecha) {
            arreglo[k] = derecha[j];
            j++;
            k++;
        }
    }
}