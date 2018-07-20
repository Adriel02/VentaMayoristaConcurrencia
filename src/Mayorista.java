public class Mayorista {
    private int identificador;
    private int stock;
    private int capacidad;

    public Mayorista(int capacidad) {
        this.capacidad = capacidad;
        this.stock = 0;
    }


    public synchronized void añadePapas(String idAgricultor, int kilos) {

        System.out.println("El " + idAgricultor + " quiere vendernos " + kilos + " kilos de comida.");

        while (stock + kilos > capacidad) {
            System.out.println("El " + idAgricultor + " no puede vendernos " + kilos + " kilos de comida. Stock = " + this.stock);
            try {
                wait();
            } catch (Exception e) {
            }

        }
        stock += kilos;
        notifyAll();
        System.out.println("El " + idAgricultor + " no puede vendernos " + kilos + " kilos de comida. Stock = " + this.stock);


    }


    public synchronized void sacaPapas(String idSupermercado, int kilos) {
        System.out.println("El " + idSupermercado + " quiere comprarnos " + kilos + " kilos de comida.");

        if (kilos > stock) {
            System.out.println("El " + idSupermercado + " no puede comprarnos no tenemos suficiente. Stock = " + this.stock);
            try {
                wait();
            } catch (Exception e) {
            }

        }
        stock= stock-kilos;
        notifyAll();
        System.out.println("El " + idSupermercado + " nos compra "+kilos+" kilos. Stock = " + this.stock);


    }


    public int stock() {
        return stock;
    }

}
