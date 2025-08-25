import java.util.Scanner;

class Chinela{
    private int tamanho;

    public Chinela(){
        tamanho = 0;
    }

    void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    int getTamanho(){
        return tamanho;
    }
}

public class draft {
    public static void main(String args[]) {
        Chinela chinela = new Chinela();
        
        Scanner sc = new Scanner(System.in);

        int tam=0;
        while(tam %2 ==1 || tam<20 || tam>50){
            tam = sc.nextInt();
            chinela.setTamanho(tam);
        }

        System.out.println("Tamanho: "+ chinela.getTamanho());
        sc.close();

    }
}

