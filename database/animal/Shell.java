import java.util.Scanner;

class Animal{
    String specie;
    int age;
    String sound;

    public Animal(String specie, String sound){
        this.specie = specie;
        this.age = 0;
        this.sound = sound;
    }

    @Override
    public String toString() {
        return (specie+":"+age+":"+sound);
    }

    void ageBy(int increment){
        age += increment;
        if(age>=4)age=4;

        if(age>=4){
            System.out.println("warning: "+ specie + " morreu");
            return;
        }
    }

    void makeSound(){
        if(age == 0)System.out.println("---");
        else if(age == 4)System.out.println("RIP");
        else System.out.println(sound);
    }
}

public class Shell {

    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")  ) { 
                break;
            }
            else if (cmd.equals("init") ) {
                // INICIE O ANIMAL UTILIZANDO O CONSTRUTOR
                var species = par[1];
                var noise = par[2];
                animal = new Animal(species, noise);
            } 
            else if (cmd.equals("show")) {
                System.out.println(animal.toString());
            } 
            else if (cmd.equals("noise")) {
                animal.makeSound();
            } 
            else if (cmd.equals("grow") ) {
                // AUMENTE A IDADE DO ANIMAL
                var increment = Integer.parseInt(par[1]);
                animal.ageBy(increment);
            }  
            else {
                System.out.println("fail: comando invalido\n");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}