import java.util.Scanner;

public class RepartoHilos {
    private static int N;
    private static int M;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cantidad total de trabajo (N): ");
        N = scanner.nextInt();

        System.out.print("Introduce el número de hilos (M): ");
        M = scanner.nextInt();

        scanner.close();

        System.out.println("COMIENZA LA IMPLEMENTACIÓN POR BLOQUES");
        RepartoBloques();
        System.out.println();

        System.out.println("COMIENZA LA IMPLEMENTACIÓN CÍCLICA");
        RepartoCiclico();

        System.out.println("FIN DEL PROGRAMA");
    }

    private static void RepartoBloques() throws InterruptedException {
        Thread[] hilos = new Thread[M];

        for (int i = 0; i < M; i++) {
            int elementosPorHilo = N / M;
            int elementosExtra = N % M;
            int inicio = i * elementosPorHilo + Math.min(i, elementosExtra);
            int fin = inicio + elementosPorHilo + (i < elementosExtra ? 1 : 0);

            hilos[i] = new Thread(new HiloBloques(i, inicio, fin));
        }

        for (Thread hilo : hilos) { hilo.start(); }
        for (Thread hilo : hilos) { hilo.join(); }
    }

    private static void RepartoCiclico() throws InterruptedException {
        Thread[] hilos = new Thread[M];

        for (int i = 0; i < M; i++) {
            hilos[i] = new Thread(new HiloCiclico(i, M, N));
        }

        for (Thread hilo : hilos) { hilo.start(); }
        for (Thread hilo : hilos) { hilo.join(); }
    }
}

class HiloBloques implements Runnable {
    private final int idHilo;
    private final int inicio;
    private final int fin;

    public HiloBloques(int idHilo, int inicio, int fin) {
        this.idHilo = idHilo;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int j = inicio; j < fin; j++) {
            System.out.println("Soy el hilo " + idHilo + " digo el num " + j + " y el cuadrado es " + (j * j));
        }
    }
}

class HiloCiclico implements Runnable {
    private final int idHilo;
    private final int M;
    private final int N;

    public HiloCiclico(int idHilo, int M, int N) {
        this.idHilo = idHilo;
        this.M = M;
        this.N = N;
    }

    @Override
    public void run() {
        for (int j = idHilo; j < N; j += M) {
            System.out.println("Soy el hilo " + idHilo + " digo el num " + j + " y el cuadrado es " + (j * j));
        }
    }
}