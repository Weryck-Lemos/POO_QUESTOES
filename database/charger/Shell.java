import java.util.Scanner;

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

    public void setCarga(int carga) {
        this.carga = carga;
    }

    void consumir(int tempo){
        carga = Math.max(0, carga - tempo);
    }

    void carregar(int potencia, int tempo){
        carga = Math.min(capacidade, carga+potencia * tempo);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", carga, capacidade);
    }
}

class Notebook{
    private boolean ligado;
    private Bateria bateria;
    private Carregador carregador;
    private int tempo;

    public Notebook(){
        this.ligado = false;
        this.tempo = 0;
    }

    void ligar(){
        if ( (bateria != null && bateria.getCarga() >0) || (carregador != null)){
            if(!ligado) ligado =true;
            else System.out.println("Notebook ja esta ligado");
            return;
        }

        else{
            System.out.println("fail: não foi possível ligar");
        }
    }

    void desligar(){
        if(ligado){
            ligado = false;
            return;
        }

        System.out.println("Notebook ja esta desligado");
    }

    void show(){
        if(!ligado) System.out.print("Notebook: desligado");
        else System.out.print("Notebook: ligado por " + tempo + " min");

        if(carregador != null){
            System.out.print(", Carregador "+ carregador.getPotencia()+"W");
        }

        if(bateria != null){
            System.out.print(", Bateria "+ bateria.toString());
        }

        System.out.println("");
    }

    void usar(int tempo){
        if(!ligado){
            System.out.println("fail: desligado");
            return;
        }

        if(bateria == null && carregador == null){
            System.out.println("Sem carga na bateria ou carregador");
            desligar();
            return;
        }

        if(bateria == null && carregador != null){
            this.tempo += tempo;
            return;
        }

        if(carregador != null){
            bateria.carregar(carregador.getPotencia(), tempo);
            this.tempo += tempo;
            return;
        }

        
        int tempoUsado = Math.min(tempo, bateria.getCarga());
        bateria.consumir(tempoUsado);
        this.tempo += tempo;

        if(bateria.getCarga() == 0){
            System.out.println("fail: descarregou");
            desligar();
        }
    
    }

    void SetBateria(Bateria bateria){
        if(this.bateria == null){
            this.bateria = bateria;
            return;
        }

        System.out.println("fail: bateria ja conectado");
    }

    void rmBateria(){
        if(bateria == null){
            System.out.println("fail: Sem bateria");
            return;
        }

        System.out.println("Removido " + bateria.toString());
        if(carregador == null) desligar();

        this.bateria = null;
    }

    void setCarregador(Carregador carregador){
        if(this.carregador == null){
            this.carregador = carregador;
            return;
        }

        System.out.println("fail: carregador já conectado");
    }

    void rmCarregador(){
        if(this.carregador == null){
            System.out.println("fail: Sem carregador");
            return;
        }

        System.out.println("Removido "+carregador.getPotencia()+"W");
        this.carregador = null;

        if(bateria == null ||bateria.getCarga() == 0)desligar();
    }

}

public class Shell {
    public static void main(String[] _args) {
        Notebook notebook = new Notebook();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if(cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) { 
                notebook.show();
            }
            else if(cmd.equals("turn_on")) { 
                notebook.ligar();
            }
            else if(cmd.equals("turn_off")) { 
                notebook.desligar();
            }
            else if(cmd.equals("use")) { 
                var minutes = Integer.parseInt(par[1]);
                notebook.usar(minutes);
            }
            else if(cmd.equals("set_battery")) {
                var capacity = Integer.parseInt(par[1]);
                Bateria bateria = new Bateria(capacity);
                notebook.SetBateria(bateria);
            }
            else if(cmd.equals("rm_battery")) {
                notebook.rmBateria();
            }
            else if(cmd.equals("set_charger")) {
                var power = Integer.parseInt(par[1]);
                Carregador carregador = new Carregador(power);
                notebook.setCarregador(carregador);
            }
            else if(cmd.equals("rm_charger")) {
                notebook.rmCarregador();
            }
            else {
                System.out.println("fail: comando inválido");
            }

        }
    }
    private static Scanner scanner = new Scanner(System.in);
}
