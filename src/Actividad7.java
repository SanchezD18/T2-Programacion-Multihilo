public class Actividad7 {
    public static void main(String[] args) {
        Tienda tienda = new Tienda(10);

        Cliente cliente1 = new Cliente(tienda, 5, "Cliente 1");
        Cliente cliente2 = new Cliente(tienda, 8, "Cliente 2");
        Cliente cliente3 = new Cliente(tienda, 3, "Cliente 3");

        Thread hilo1 = new Thread(cliente1);
        Thread hilo2 = new Thread(cliente2);
        Thread hilo3 = new Thread(cliente3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tienda {
    private int stock;

    public Tienda(int stockInicial) {
        this.stock = stockInicial;
    }

    public synchronized void comprarProducto(int cantidad, String nombreCliente) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println(nombreCliente + " compró " + cantidad + " productos.");
            System.out.println("Stock disponible: " + stock);
        } else {
            System.out.println(nombreCliente + " intentó comprar " + cantidad +
                    " productos, pero no hay suficiente stock.");
        }
    }

    public synchronized int getStock() {
        return stock;
    }
}

class Cliente implements Runnable {
    private final Tienda tienda;
    private final int cantidad;
    private final String nombre;

    public Cliente(Tienda tienda, int cantidad, String nombre) {
        this.tienda = tienda;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        tienda.comprarProducto(cantidad, nombre);
    }
}