public class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }
    public int getSaldo() {
        return saldo;
    }
    public synchronized void depositar(int cantidad) {
        saldo += cantidad;
    }
    public synchronized void retirar(int cantidad) {
        saldo -= cantidad;
    }
    public void transferir(CuentaBancaria destino, int cantidad) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() +
                    " - Bloqueo de cuenta de origen");

            // Pequeña pausa para aumentar la probabilidad de deadlock
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (destino) {
                System.out.println(Thread.currentThread().getName() +
                        " - Bloqueo de cuenta de destino");

                if (saldo >= cantidad) {
                    retirar(cantidad);
                    destino.depositar(cantidad);
                    System.out.println(Thread.currentThread().getName() +
                            " - Transferencia exitosa: " + cantidad);
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " - Saldo insuficiente");
                }
            }
        }
    }
}

