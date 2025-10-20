public class MiHilo extends Thread {
    public void run(){
        this.setName("MiHilo");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+" Hilo 1:" + i);
        }
    }
}
