class Contador {
    private int cuenta = 0;

    public int getCuenta() {
        return cuenta;
    }

    public synchronized void incrementa() {
        this.cuenta += 1;
    }
}
class Hilo implements Runnable{
    int numHilo, miParte, miCuenta = 0;
    private final Contador cont;

    Hilo(int numHilo, int miParte, Contador c){
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.cont = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < miParte; i++){
            this.cont.incrementa();
            miCuenta++;
        }
        System.out.println("Hilo " + numHilo + " terminado, cuenta: " + miCuenta + "\n");
    }
}
public class HilosCooperantesNoSincr {

    private static final int NUM_HILOS = 3;
    private static final int CUENTA_TOTAL = 1000000;

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        Contador c = new Contador();
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++) {
            Thread th = new Thread(new Hilo(i, CUENTA_TOTAL / NUM_HILOS, c));
            th.start();
            hilos[i] = th;
        }
        for (Thread h : hilos) {
            try{
                h.join();
            } catch (InterruptedException e){}
        }
        System.out.println("Cuenta global: " + c.getCuenta() + "\n");
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución con hilos: " + (fin - inicio) + " ms");
    }
}
