import java.util.*;

class Blusa{
    private String tamanho;

    List <String> validos = new ArrayList<>(Arrays.asList("PP", "P", "M", "G", "GG", "XG"));

    public Blusa(){
        tamanho = "";
    }

    void setTamanho(String t){
        if(validos.contains(t))tamanho = t;
        else System.out.println("fail: Valor inválido, tente PP, P, M, G, GG ou XG");
    }

    String getTamanho(){
        return tamanho;
    }
}

public class Shell {    
    public static void main(String[] args) {
        Blusa blusa = new Blusa();
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);
            
            var par = line.split(" ");
            var cmd = par[0];
            
            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("size")) { 
                String size = par[1];
                blusa.setTamanho(size);
            }
            else if (cmd.equals("show")) {
                System.out.println("size: ("+blusa.getTamanho()+")");
            }
            else {
                System.out.println("fail: Comando inválido");
            }
        }
    }
    private static Scanner scanner = new Scanner(System.in);
}
