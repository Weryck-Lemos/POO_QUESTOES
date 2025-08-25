import java.util.*;

class Tamagochi{
    private int energyMax;
    private int cleanMax;
    private int energy;
    private int clean;
    private int age;
    private boolean alive;

    public Tamagochi(int energyMax, int cleanMax){
        this.energyMax = energyMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.clean = cleanMax;
        this.age = 0;
        this.alive = true;
    }

    int getEnergy(){
        return energy;
    }

    int getClean(){
        return clean;
    }

    int getAge(){
        return age;
    }

    boolean getAlive(){
        return alive;
    }

    int getEnergyMax(){
        return energyMax;
    }

    int getCleanMax(){
        return cleanMax;
    }

    void setEnergy(int energy){
        this.energy += energy;
        if(this.energy<=0) this.energy = 0;
        if(this.energy > energyMax) this.energy = energyMax;
        if(this.energy == 0){
            System.out.println("fail: pet morreu de fraqueza");
            alive = false;
        }
    }

    void setClean(int clean){
        this.clean += clean;
        if(this.clean<=0) this.clean = 0;
        if(this.clean > cleanMax) this.clean = cleanMax;
        if(this.clean == 0){
            System.out.println("fail: pet morreu de sujeira");
            alive = false;
        }
    }

    void setAge(int age){
        this.age += age;
    }

    @Override
    public String toString() {
        return String.format("E:%d/%d, L:%d/%d, I:%d", energy, energyMax, clean, cleanMax, age);
    }
}

class Game{
    Tamagochi tamagochi;

    public Game(){

    }

    public Game(Tamagochi tamagochi){
        this.tamagochi = tamagochi;
    }

    boolean Alive(){
        if(!tamagochi.getAlive()){
            System.out.println("fail: pet esta morto");
            return true;
        }

        return false;
    }

    void play(){
        if(Alive()){
            return;
        }

        tamagochi.setEnergy(-2);
        tamagochi.setClean(-3);
        tamagochi.setAge(1);
    }

    void sleep(){
        if(Alive()){
            return;
        }

        if(tamagochi.getEnergy() > tamagochi.getEnergyMax()-5){
            System.out.println("fail: nao esta com sono");
            return;
        }

        int sono = tamagochi.getEnergyMax() - tamagochi.getEnergy();
        tamagochi.setEnergy(sono);
        tamagochi.setAge(sono);
    }

    void shower(){
        if(Alive()){
            return;
        }

        tamagochi.setEnergy(-3);
        tamagochi.setClean(tamagochi.getCleanMax());
        tamagochi.setAge(2);
    }

    @Override
    public String toString() {
        return tamagochi.toString();
    }
}

public class Shell {
    public static void main(String[] a) {
        Game game = new Game();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                var energy = Integer.parseInt(par[1]);
                var clean = Integer.parseInt(par[2]);
                Tamagochi tamagochi = new Tamagochi(energy, clean);
                game = new Game(tamagochi);
            }
            else if (cmd.equals("show")) { 
                System.out.println(game.toString());
            }
            else if (cmd.equals("play")) { 
                game.play();
            }
            else if (cmd.equals("shower")) { 
                game.shower();
            }
            else if (cmd.equals("sleep")) { 
                game.sleep();
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
