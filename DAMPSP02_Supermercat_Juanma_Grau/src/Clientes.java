import java.util.Random;

public class Clientes implements Runnable {
    String cliente_n;
    GestorSupermercat gestor;

    public Clientes(String cliente_n, GestorSupermercat g) {
        this.cliente_n = cliente_n;
        this.gestor = g;
    }

    public void run() {
        comprar();
        ponerseEnCola();
        this.gestor.IntentarPagar();
        pasarPorCaja();
        pagar();
        this.gestor.SalirDelSupermercado();
    }
    public void comprar(){
        esperar();
        System.out.println(this.cliente_n + " está comprando productos.");
    }
    public void ponerseEnCola(){
        esperar();
        Random random = new Random();
        int numeroCaja = random.nextInt(3) + 1;
        System.out.println(this.cliente_n + " se ha puesto en la cola de pago " + numeroCaja + ".");
    }
    public void pasarPorCaja() {
        System.out.println(this.cliente_n + " está pasando por caja su compra.");
    }
    public void pagar(){
        esperar();
        double pago = 10 + (90 * Math.random());
        double pagoRedondeado = Math.round(pago * 100.0) / 100.0;
        System.out.println(this.cliente_n + " ha pagado su compra de un total de "+pagoRedondeado+" euros.");
        this.gestor.actualizarDineroRecaudado(pagoRedondeado);
    }
    public void esperar() {
        int waiter = (int) (1000 + (5000 * Math.random()));
        try {
            Thread.sleep(waiter);
        } catch (InterruptedException e) {
            System.out.println("Error en el método 'esperar()'");
            e.printStackTrace();
        }
    }
}