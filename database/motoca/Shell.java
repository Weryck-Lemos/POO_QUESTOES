import java.util.*;

class Pessoa{
    private int age;
    private String name;

    public Pessoa(int age, String name){
        this.age = age;
        this.name = name;
    }

    int getAge(){
        return age;
    }

    String getName(){
        return name;
    }

    @Override
    public String toString() {
        return (this.name+":"+this.age);
    }
}

class Moto{
    private Pessoa pessoa;
    private int power;
    private int time;

    public Moto(){
        this.pessoa = null;
        this.power = 1;
        this.time = 0;
    }

    public Moto(int power){
        this.pessoa = null;
        this.power = power;
        this.time = 0;
    }

    void subir(Pessoa pessoa){
        if(this.pessoa != null){
            System.out.println("fail: busy motorcycle");
            return;
        }

        this.pessoa = pessoa;
    }

    void descer(){
        if(this.pessoa == null){
            System.out.println("fail: empty motorcycle");
            return;
        }
        System.out.println(pessoa.toString());
        this.pessoa = null;
    }

    void comprarTempo(int tempo){
        this.time += tempo;
    }

    void dirigir(int tempo){
        if(this.time ==0){
            System.out.println("fail: buy time first");
            return;
        }

        if(pessoa == null){
            System.out.println("fail: empty motorcycle");
            return;
        }

        if(pessoa.getAge() >10){
            System.out.println("fail: too old to drive");
            return;
        }

        if(this.time < tempo){
            System.out.println("fail: time finished after "+this.time+" minutes");
        }

        this.time -= tempo;
        this.time = Math.max(time,0);
    }

    String buzinar(){
        String e = "e".repeat(power);
        return("P"+e+"m");
    }

    @Override
    public String toString() {
        String who = pessoa==null ? "(empty)" : "("+pessoa.toString()+")";
        return String.format("power:%d, time:%d, person:%s", power, time, who);
    }

}

public class Shell{
    
    public static void main(String[] args) {
        Moto moto = new Moto();

        while(true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
        
                var power = Integer.parseInt(par[1]);
                moto = new Moto(power);
            }
            else if (cmd.equals("show")) {
                System.out.println(moto.toString());
            }
            else if (cmd.equals("enter")){
                var name = par[1];
                var age = Integer.parseInt(par[2]);
                Pessoa pessoa = new Pessoa(age, name);
                moto.subir(pessoa);
            }
            else if (cmd.equals("leave")) {
                moto.descer();
            }
            else if (cmd.equals("buy")) {
                var time = Integer.parseInt(par[1]);
                moto.comprarTempo(time);
            }
            else if (cmd.equals("drive")) {
                var time = Integer.parseInt(par[1]);
                moto.dirigir(time);
            }
            else if (cmd.equals("honk")) {
                System.out.println(moto.buzinar());
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
