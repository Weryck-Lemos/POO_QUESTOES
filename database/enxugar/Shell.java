import java.util.Scanner;

class Towel{
    String color;
    String size;
    int wetness;

    public Towel(){};

    public Towel(String color, String size){
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    @Override
    public String toString(){
        return ("Cor: "+color+ ", Tamanho: "+ size+ ", Umidade: "+wetness);
    }

    void writeOut(){
        wetness = 0;
    }

    int umity(){
        if(size.equals("P")) return 10;
        else if(size.equals("M")) return 20;
        else return 30;
    }

    String isDry(){
        return wetness == 0 ? "sim" : "nao";
    }

    void dry(int amount){
        wetness += amount;
        if(wetness >= umity()){
            System.out.println("toalha encharcada");
            wetness = umity();
        }
    }
}

public class Shell {
    
    public static void main(String[] a) {
        Towel toalha = new Towel();
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("criar")) {
                var cor = par[1];
                var tamanho = par[2];
                toalha = new Towel(cor, tamanho);
            }
            else if (cmd.equals("mostrar")) {
                System.out.println(toalha.toString());
            }
            else if (cmd.equals("enxugar")) { 
                var quantidade = Integer.parseInt(par[1]);
                toalha.dry(quantidade);
            }
            else if (cmd.equals("seca")) {
                System.out.println(toalha.isDry());
            }
            else if (cmd.equals("torcer")) { 
                toalha.writeOut();
            }
            else {
                System.out.println("comando invalido");
            }
        }
    }
    private static Scanner scanner = new Scanner(System.in);
}
