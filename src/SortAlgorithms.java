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

    // QUICK SORT
    public static <T extends Comparable<T>> void quickSort(T[] arreglo, int inicio, int fin) {

        if (inicio < fin) {
            int indicePivot = particionar(arreglo, inicio, fin);

            quickSort(arreglo, inicio, indicePivot - 1);

            quickSort(arreglo, indicePivot + 1, fin);
        }
    }

    // Metodo auxiliar: coloca el pivot en su posicion correcta
    private static <T extends Comparable<T>> int particionar(T[] arreglo, int inicio, int fin) {

        T pivot = arreglo[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j].compareTo(pivot) <= 0) {
                i++;
                T temporal = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temporal;
            }
        }

        T temporal = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temporal;

        return i + 1;
    }

    // RADIX SORT
    public static void radixSort(Integer[] arreglo) {

        if (arreglo.length == 0)
            return;

        int maximo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }

        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            conteoSort(arreglo, exp);
        }
    }

    // Metodo auxiliar: ordena segun el digito en posicion exp
    private static void conteoSort(Integer[] arreglo, int exp) {

        int n = arreglo.length;
        Integer[] resultado = new Integer[n];
        int[] conteo = new int[10];

        for (int i = 0; i < 10; i++) {
            conteo[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int digito = (arreglo[i] / exp) % 10;
            conteo[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digito = (arreglo[i] / exp) % 10;
            resultado[conteo[digito] - 1] = arreglo[i];
            conteo[digito]--;
        }

        for (int i = 0; i < n; i++) {
            arreglo[i] = resultado[i];
        }
    }

    // SHELL SORT
    public static <T extends Comparable<T>> void shellSort(T[] arreglo) {

        int n = arreglo.length;

        int gap = n / 2;

        while (gap > 0) {

            for (int i = gap; i < n; i++) {
                T temporal = arreglo[i];
                int j = i;

                while (j >= gap && arreglo[j - gap].compareTo(temporal) > 0) {
                    arreglo[j] = arreglo[j - gap];
                    j -= gap;
                }

                arreglo[j] = temporal;
            }

            gap = gap / 2;
        }
    }

}