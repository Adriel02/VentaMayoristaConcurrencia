public class Main{
    public static void main(String[] args){
        Supermercado[] supermercados= new Supermercado[8];
        Agricultor[] agricultores= new Agricultor[3];
        Mayorista mayorista= new Mayorista(1200);
        for(int i=0; i<agricultores.length; i++){
            agricultores[i] = new Agricultor("Agricultor "+i+1,mayorista);
            //Descomente la siguiente línea cuando quiera probar
            agricultores[i].start();
        }
        for(int i=0; i<supermercados.length; i++){
            supermercados[i] = new Supermercado("Supermercado "+i+1,mayorista);
            //Descomente la siguiente línea cuando quiera probar
            supermercados[i].start();
        }
        //Inicio de simulación
        System.out.println("Inicio de simulación");
        try{
            Thread.sleep(30000);
        }catch(Exception e){}
        //Descomente la siguiente línea cuando quiera probar
        
        for(int i=0; i<agricultores.length; i++){
            agricultores[i].interrupt();
        }
        for(int i=0; i<supermercados.length; i++){
            supermercados[i].interrupt();
        }
        
        for(int i=0; i<agricultores.length; i++){
            //Descomente la siguiente línea cuando quiera probar
            //try{agricultores[i].join();}catch(Exception e){}
        }
        for(int i=0; i<supermercados.length; i++){
            //Descomente la siguiente línea cuando quiera probar
            //try{supermercados[i].join();}catch(Exception e){}
        }
        int vendido=0;
        int comprado=0;
        for(int i=0; i<agricultores.length; i++){
            vendido+=agricultores[i].vendido();
        }
        for(int i=0; i<supermercados.length; i++){
            comprado+=supermercados[i].comprado();
        }
        Log.resumen(vendido,comprado,mayorista.stock());
    }
}