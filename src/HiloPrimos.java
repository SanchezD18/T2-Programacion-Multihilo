public class HiloPrimos extends Thread {
    private final int hilo_id;
    private final int totalNumeros;
    private final int numHilos;

    public HiloPrimos(int id, int totalNumeros, int numHilos) {
        hilo_id = id;
        this.totalNumeros = totalNumeros;
        this.numHilos = numHilos;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        int bloque = totalNumeros / numHilos;
        int inicio = hilo_id * bloque + 1;
        int fin = (hilo_id == numHilos - 1) ? totalNumeros : (hilo_id + 1) * bloque;

        for (int i = inicio; i <= fin; i++) {
            esPrimo(i);
        }
    }
}