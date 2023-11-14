public class GestorSupermercat extends Thread {
    boolean ZonaPagoLibre;
    private double DineroRecaudado;

    public GestorSupermercat() {
        this.ZonaPagoLibre = true;
    }

    public synchronized void IntentarPagar() {
        while (!ZonaPagoLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ZonaPagoLibre = false;
    }

    public synchronized void SalirDelSupermercado() {
        ZonaPagoLibre = true;
        notify();
    }
    public void actualizarDineroRecaudado(double m) {
        DineroRecaudado += m;
    }

    public double getDineroRecaudado() {
        return DineroRecaudado;
    }

}