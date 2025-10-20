public class MiTarea extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(this.threadId() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
