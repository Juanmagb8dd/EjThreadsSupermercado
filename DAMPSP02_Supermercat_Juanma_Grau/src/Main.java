public class Main {

    public static void main(String[] args) {
        int cant_clientes=10;
        Clientes[] clientes = new Clientes[cant_clientes];
        GestorSupermercat gestor = new GestorSupermercat();
        for (int x=0;x<cant_clientes;x++){
            clientes[x]=new Clientes("Cliente "+(x+1)+" del supermercado",gestor);
        }
        Thread fils[]= new Thread[cant_clientes];
        for (int i=0;i<cant_clientes;i++){
            fils[i]=new Thread(clientes[i]);
            fils[i].start();
        }
        for (int i = 0; i < cant_clientes; i++) {
            try {
                fils[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El supermercado ha recaudado hoy " + Math.round(gestor.getDineroRecaudado()*100.0)/100.0 + " euros.");
    }
}