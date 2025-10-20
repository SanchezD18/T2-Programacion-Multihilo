public class HiloPrimos extends Thread {
    private int inicio;
    private int fin;

    public HiloPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
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
        for (int i = inicio; i <= fin; i++) {
            esPrimo(i);
        }
    }
}
