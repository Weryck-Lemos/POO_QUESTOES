import java.util.Scanner;

class Pessoa{
    private String nome;
    private int dinheiro;

    public Pessoa(String nome, int dinheiro){
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    @Override
    public String toString() {
        return String.format("%s:%d", nome, dinheiro);
    }
}

class Moto{
    private Pessoa motorista;
    private Pessoa passageiro;
    private int custo;

    public Moto(){
        this.custo = 0;
    }


    boolean temMotorista(){
        return motorista != null;
    }

    boolean temPassageiro(){
        return passageiro != null;
    }

    @Override
    public String toString() {
        String whoM = temMotorista() ? motorista.toString() : "None";
        String whoP = temPassageiro() ? passageiro.toString() : "None";
        return String.format("Cost: %d, Driver: %s, Passenger: %s", custo, whoM, whoP);
    }

    void setDriver(Pessoa motorista){
        this.motorista = motorista;
    }

    void setPass(Pessoa passageiro){
        if(!temMotorista()){
            System.out.println("fail: sem motorista");
            return;
        }

        this.passageiro = passageiro;
    }

    void Drive(int dist){
        if(!temMotorista()){
            System.out.println("fail: sem motorista");
            return;
        }
        if(temPassageiro()) custo += dist;
    }

    void leavePass(){
        if(!temPassageiro()){
            System.out.println("fail: sem passageiro para descer");
            return;
        }
        
        if(passageiro.getDinheiro() - custo <0){
            System.out.println("fail: Passenger does not have enough money");
        }
        passageiro.setDinheiro( Math.max(0, passageiro.getDinheiro()- custo));
        System.out.println(passageiro.getNome()+":"+passageiro.getDinheiro()+" left");
        motorista.setDinheiro( motorista.getDinheiro() + custo);
        custo = 0;
        passageiro = null;
    }
}

public class Shell {

    public static void main(String[] args) {
        Moto moto = new Moto();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                System.out.println(moto.toString());
            }
            else if (cmd.equals("setDriver")) { 
                String name = par[1];
                int money = Integer.parseInt(par[2]);
                Pessoa driver = new Pessoa(name, money);
                moto.setDriver(driver);
            }
            else if (cmd.equals("setPass")) { 
                String name = par[1];
                int money = Integer.parseInt(par[2]);
                Pessoa pass = new Pessoa(name, money);
                moto.setPass(pass);
            }
            else if (cmd.equals("drive")) { 
                int distance = Integer.parseInt(par[1]);
                moto.Drive(distance);
            }
            else if (cmd.equals("leavePass")) { 
                moto.leavePass();
            }
            else {
                System.out.println("fail: command not found");
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
}
