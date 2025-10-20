public class EjPrimoConHilos {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        HiloPrimos h1 = new HiloPrimos(1, 100000);
        HiloPrimos h2 = new HiloPrimos(100001, 200000);
        HiloPrimos h3 = new HiloPrimos(200001, 300000);
        HiloPrimos h4 = new HiloPrimos(300001, 400000);

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
