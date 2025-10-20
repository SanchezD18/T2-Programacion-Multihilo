
class PrioridadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hilo " + Thread.currentThread().getName() + " con prioridad "
                + Thread.currentThread().getPriority());
    }
}


public class Actividad3 {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new PrioridadRunnable());
        Thread hilo2 = new Thread(new PrioridadRunnable());
        Thread hilo3 = new Thread(new PrioridadRunnable());

        hilo1.setName("1");
        hilo2.setName("2");
        hilo3.setName("3");

        hilo1.setPriority(1);
        hilo2.setPriority(5);
        hilo3.setPriority(10);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
