import java.util.*;

public class draft {
    public static void main(String args[]) {
        //criar um array vazio
        List<Integer> lista = new ArrayList<>();
        System.out.println("Array vazio: "+ lista);

        //criar array preenchido
        List<Integer> preenchido = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Array preenchido: "+ preenchido);

        //adicionar elemento
        preenchido.add(9);
        System.out.println("adicionando elemento: "+ preenchido);

        //remover último elemento
        preenchido.remove(preenchido.size()-1);
        System.out.println("Após remover o último: "+ preenchido);

        //impressao formatada
        System.out.printf("Impressão formatada: %s (tamanho=%d)%n", preenchido, preenchido.size());

        //cria array de 0 a n
        int n=10;
        List<Integer> seq = new ArrayList<>();
        for(int i=0; i<=n; i++)seq.add(i);
        System.out.println("Sequência de 0...10: "+ seq);

        //cria array com valores aleatórios
        Random r = new Random();
        List<Integer> aleatorio = new ArrayList<>();
        for(int i=0; i<8; i++)aleatorio.add(r.nextInt(11)-5);
        System.out.println("Aleatorio: "+aleatorio);

        //acessa elementos por indice
        System.out.println("Elemento seq[3] = "+seq.get(3));

        //for-each
        System.out.println("For-each: ");
        for(int v: aleatorio)System.out.print(v + " ");
        System.out.println();

        //percorrer com for indexado
        System.out.println("For indexado: ");
        for(int i=0; i<aleatorio.size(); i++)System.out.print(aleatorio.get(i)+" ");
        System.out.println();

        //procurar um elemento x
        int x = 1;
        System.out.println("Index of "+x+" em "+preenchido+": "+preenchido.indexOf(x));

        //Novo array filtrado(pares)
        List<Integer> pares = new ArrayList<>();
        for(int v : seq) if(v%2 == 0)pares.add(v);
        System.out.println("Pares: "+ pares);

        //Novo array transformado (ao quadrado)
        List<Integer> quadrados = new ArrayList<>();
        for(int v : pares)quadrados.add(v*v);
        System.out.println("Quadrados: "+quadrados);

        //Buscar e remover um elemento x
        List<Integer> exemplo1 = new ArrayList<>(Arrays.asList(2,7,7,3));
        exemplo1.remove(Integer.valueOf(7));
        System.out.println("Remove primeira ocorrência de 7: "+exemplo1);

        List<Integer> exemplo2 = new ArrayList<>(Arrays.asList(1,2,2,3,3,3));
        exemplo2.removeIf(v -> v ==2);
        System.out.println("Remover todos os 2: "+exemplo2);

        //ordenar
        Collections.sort(aleatorio);
        System.out.println("Ordenado: "+aleatorio);

        
    }
}

