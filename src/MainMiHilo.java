//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainMiHilo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        MiTarea miTarea1 = new MiTarea();
        MiTarea miTarea2 = new MiTarea();
        MiTarea miTarea3 = new MiTarea();
        MiTarea miTarea4 = new MiTarea();
        MiTarea miTarea5 = new MiTarea();
        MiTarea miTarea6 = new MiTarea();
        MiTarea miTarea7 = new MiTarea();
        MiTarea miTarea8 = new MiTarea();
        miTarea1.start();
        miTarea2.start();
        miTarea3.start();
        miTarea4.start();
        miTarea5.start();
        miTarea6.start();
        miTarea7.start();
        miTarea8.start();


    }
}