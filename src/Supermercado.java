public class Supermercado extends Thread {

    private String identificador;
    private Mayorista mayorista;
    private int comprado;


    public Supermercado(String identificador, Mayorista mayorista) {
        this.identificador = identificador;
        this.mayorista = mayorista;
        this.comprado = 0;
    }

    @Override
    public void run() {
        int kilos = 0;
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(ValoresSimulacion.tiempoCosecha());
            } catch (InterruptedException e) {
            }
            kilos = ValoresSimulacion.cantidadCosechada();
            mayorista.sacaPapas(this.identificador, kilos);
        }


    }

    public int comprado() {
        return this.comprado;
    }
}
