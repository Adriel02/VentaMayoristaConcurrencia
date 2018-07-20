public class Agricultor extends Thread {
    private String identificador;
    private Mayorista mayorista;
    private int vendido;

    public Agricultor(String identificador, Mayorista mayorista) {
        this.identificador = identificador;
        this.mayorista = mayorista;
        this.vendido = 0;
    }


    @Override
    public void run() {
        int kilos;
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(ValoresSimulacion.tiempoCosecha());
            } catch (Exception e) {

            }
            kilos = ValoresSimulacion.cantidadCosechada();
            mayorista.añadePapas(this.identificador, kilos);
            vendido += kilos;
        }
    }


    public String getID() {
        return this.identificador;
    }

    public int vendido() {
        return this.vendido;

    }


}
