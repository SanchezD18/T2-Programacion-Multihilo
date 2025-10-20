public class EjPrimo {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 400000; i++) {
            esPrimo(i);
        }
        long fin = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución secuencial: " + (fin - inicio) + " ms");
    }

    public static boolean esPrimo(int numero){
        if (numero <= 1){
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}


