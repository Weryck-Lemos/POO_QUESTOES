import java.util.*;
import java.util.stream.Collectors;

class Person{
    private String nome;
    
    public Person(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}

class Market{
    private ArrayList<Person> counters;
    private LinkedList<Person> waiting;
    private int qtd;

    public Market(int qtd){
        this.qtd = qtd;
        counters = new ArrayList<>(qtd);
        for(int i=0; i<qtd; i++)counters.add(null);
        waiting = new LinkedList<>();
    }

    boolean isValid(int n){
        return (n>=0 && n<qtd);
    }

    void arrive(Person pessoa){
        waiting.add(pessoa);
    }

    void call(int index){
        if(waiting.isEmpty()){
            System.out.println("fail: sem clientes");
            return;
        }

        if(counters.get(index) != null){
            System.out.println("fail: caixa ocupado");
            return;
        }

        counters.set(index, waiting.pollFirst());  
    }

    void finish(int index){
        if(!isValid(index)){
            System.out.println("fail: caixa inexistente");
            return;
        }
        
        Person atual = counters.get(index);
        
        if(atual == null){
            System.out.println("fail: caixa vazio");
            return;
        }

        counters.set(index, null);
        return;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Caixas: [");
        for (int i = 0; i< counters.size(); i++) {
            Person p = counters.get(i);
            if (p==null){
                sb.append("-----");
            } 
            else{
                sb.append(p.toString());
            }
            if(i < counters.size() - 1){
                sb.append(", ");
            }
        }
        sb.append("]\n");

        sb.append("Espera: [");
        int j = 0;
        for (Person p : waiting) {
            sb.append(p.toString());
            if (j < waiting.size()-1) {
                sb.append(", ");
            }
            j++;
        }
        sb.append("]");
        return sb.toString();
    }


}


class Shell {
    public static void main(String[] _args) {
        Market market = new Market(0);
        while(true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) { 
                var qtd_caixas = Integer.parseInt(par[1]);
                market = new Market(qtd_caixas);
            }
            else if (cmd.equals("show")) { 
                System.out.println(market.toString());
            }
            else if (cmd.equals("arrive")) { 
                var nome = par[1];
                Person pessoa = new Person(nome);
                market.arrive(pessoa);
            }
            else if (cmd.equals("call")) { 
                var indice = Integer.parseInt(par[1]);
                market.call(indice);
            }
            else if (cmd.equals("finish")) { 
                var indice = Integer.parseInt(par[1]);
                market.finish(indice);
            }
            else {
                System.out.println("fail: comando invalido");

            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
