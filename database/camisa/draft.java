import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Tamanho{
    PP, P, M, G, GG, XG;
    
    static List<String> validos =  new ArrayList<>();
    static{
        for(Tamanho t : values()) validos.add(t.name());
    }  

    static boolean isValid(String s){
        return validos.contains(s); 
    } 
}

class Blusa{
    private String tamanho = "";

    boolean setTamanho(String tamanho){
        if(Tamanho.isValid(tamanho)){
            this.tamanho = tamanho;
            return true;
        }

        return false;
    }

    String getTamanho(){
        return tamanho;
    }

    @Override
    public String toString(){
        return ("Roupa: "+tamanho);
    }
}

public class draft {
    public static void main(String[] args) {
        Blusa blusa = new Blusa();

        Scanner sc = new Scanner(System.in);

        String tamanho="";
        while(!blusa.setTamanho(tamanho)){
            System.out.println("Tamanhos permitidos: PP, P, M, G, GG, XG");
            tamanho =  sc.next();
            blusa.setTamanho(tamanho);
        }

        System.out.println("Tamanho: "+blusa.getTamanho());
        sc.close();
    }
}

