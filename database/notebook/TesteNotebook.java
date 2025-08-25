class Carregador{
    private int potencia;

    public Carregador(int potencia){
        this.potencia = potencia;
    }

    public int getPotencia(){
        return potencia;
    }
}

class Bateria{
    private int carga;
    private int capacidade;

    public Bateria(int capacidade){
        this.carga = capacidade;
        this.capacidade = capacidade;
    }

    int getCarga(){
        return carga;
    }

    int getCapacidade(){
        return capacidade;
    }

    void setCarga(int valor){
        carga = valor;
    }
}

class Notebook{
    private boolean ligado;
    private Bateria bateria;
    private Carregador carregador;

    public Notebook(Bateria bateria, Carregador carregador){
        this.ligado = false;
        this.bateria = bateria;
        this.carregador = carregador;
    }

    void ligar(){
        if ( (bateria != null && bateria.getCarga() >0) || (carregador != null)){
            ligado = true;
        }

        else{
            System.out.println("fail: não foi possível ligar");
        }
    }

    void desligar(){
        ligado = false;
    }

    void mostrar(){
        System.out.println("ligado: "+ligado+
        ", carga: "+bateria.getCarga()+
        ", carregador: " + (carregador != null ? "conectado" : "desconectado"));
    }

    void usar(int tempo){
        if(!ligado){
            System.out.println("fail: desligado");
            return;
        }

        if(bateria != null){
            if(carregador != null){
                int novaCarga = bateria.getCarga() - tempo + (carregador.getPotencia() * tempo);
                if(novaCarga > bateria.getCapacidade()){
                    novaCarga = bateria.getCapacidade();
                }
                bateria.setCarga(novaCarga);
            } else {
                int novaCarga = bateria.getCarga() - tempo;
                if(novaCarga <= 0){
                    bateria.setCarga(0);
                    desligar();
                    System.out.println("Energia acabou");
                    return;
                } else {
                    bateria.setCarga(novaCarga);
                }
            }
        } else if(carregador == null){
            desligar();
            System.out.println("Energia acabou, Notebook desligado.");
            return;
        }

        System.out.println("Uso de " + tempo + " minutos finalizado. Carga atual: "
            + (bateria != null ? bateria.getCarga() : "sem bateria"));
    }

}

public class TesteNotebook {
    public static void main(String[] args) {
        Bateria b = new Bateria(50);
        Carregador c = new Carregador(3);
        Notebook nb = new Notebook(b, c);

        nb.mostrar();
        nb.ligar();
        nb.usar(10);
        nb.usar(60); 
        nb.mostrar();
    }
}