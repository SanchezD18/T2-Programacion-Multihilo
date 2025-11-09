public class EjPrimoConHilos {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int totalNumeros = 400000;
        int numHilos = 4;


        HiloPrimos h1 = new HiloPrimos(1,totalNumeros, numHilos);
        HiloPrimos h2 = new HiloPrimos(2,totalNumeros, numHilos);
        HiloPrimos h3 = new HiloPrimos(3,totalNumeros, numHilos);
        HiloPrimos h4 = new HiloPrimos(4,totalNumeros, numHilos);

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long fin = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución con hilos: " + (fin - inicio) + " ms");
    }
}
