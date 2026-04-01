public class Profiler {

    private long tiempoInicio;

    private long tiempoFin;

    public void iniciar() {
        tiempoInicio = System.nanoTime();
    }

    public void detener() {
        tiempoFin = System.nanoTime();
    }

    public long getTiempoNanosegundos() {
        return tiempoFin - tiempoInicio;
    }

    public double getTiempoMilisegundos() {
        return (tiempoFin - tiempoInicio) / 1_000_000.0;
    }

    public void imprimirResultado(String nombreAlgoritmo, int cantidadElementos) {
        System.out.println("Algoritmo: " + nombreAlgoritmo
                + " | Elementos: " + cantidadElementos
                + " | Tiempo: " + getTiempoMilisegundos() + " ms");
    }

    public static void medirTiemposEnIntervalos(Integer[] arregloOriginal, boolean yaOrdenado) {

        int[] intervalos = { 10, 100, 500, 1000, 1200, 1600, 1800, 2000, 3000 };

        String estado = yaOrdenado ? "ORDENADO" : "DESORDENADO";
        System.out.println("\n=== Medicion de tiempos - Datos " + estado + " ===");
        System.out.println("Tamaño\t\tGnome\t\tMerge\t\tQuick\t\tRadix\t\tShell");
        System.out.println("------\t\t-----\t\t-----\t\t-----\t\t-----\t\t-----");

        Profiler profiler = new Profiler();

        for (int intervalo : intervalos) {

            if (intervalo > arregloOriginal.length) {
                continue;
            }

            Integer[] subarreglo = new Integer[intervalo];
            for (int i = 0; i < intervalo; i++) {
                subarreglo[i] = arregloOriginal[i];
            }

            // GNOME SORT
            Integer[] copia = FileManager.copiarArreglo(subarreglo);
            profiler.iniciar();
            SortAlgorithms.gnomeSort(copia);
            profiler.detener();
            double tiempoGnome = profiler.getTiempoMilisegundos();

            // MERGE SORT
            copia = FileManager.copiarArreglo(subarreglo);
            profiler.iniciar();
            SortAlgorithms.mergeSort(copia, 0, copia.length - 1);
            profiler.detener();
            double tiempoMerge = profiler.getTiempoMilisegundos();

            // QUICK SORT
            copia = FileManager.copiarArreglo(subarreglo);
            profiler.iniciar();
            SortAlgorithms.quickSort(copia, 0, copia.length - 1);
            profiler.detener();
            double tiempoQuick = profiler.getTiempoMilisegundos();

            // RADIX SORT
            copia = FileManager.copiarArreglo(subarreglo);
            profiler.iniciar();
            SortAlgorithms.radixSort(copia);
            profiler.detener();
            double tiempoRadix = profiler.getTiempoMilisegundos();

            // SHELL SORT
            copia = FileManager.copiarArreglo(subarreglo);
            profiler.iniciar();
            SortAlgorithms.shellSort(copia);
            profiler.detener();
            double tiempoShell = profiler.getTiempoMilisegundos();

            System.out.printf("%d\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f%n",
                    intervalo, tiempoGnome, tiempoMerge, tiempoQuick, tiempoRadix, tiempoShell);
        }
    }

}