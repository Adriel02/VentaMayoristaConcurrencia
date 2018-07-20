public class ValoresSimulacion {
    private static java.util.Random rnd = new java.util.Random();
    public static int tiempoCosecha(){ //En milisegundos
        return 1000;
    }
    public static int tiempoConsumoKilo(){ //En milisegundos
        return 100;
    }
    public static int cantidadCosechada(){ //En Kg
        return rnd.nextInt(100);
    }
    public static int cantidadAComprar(){ //En Kg
        return rnd.nextInt(50);
    }
}
