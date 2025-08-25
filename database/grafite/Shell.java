import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

class Lead{
    private double thickness;
    private String hardness;
    private int size;

    public Lead(double thickness, String hardness, int size){
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    int usagePerSheet(){
        if("HB".equals(hardness)) return 1;
        else if("2B".equals(hardness)) return 2;
        else if("4B".equals(hardness)) return 4;
        else return 6;
    }

    String getHardness() {
        return hardness;
    }

    int getSize(){
        return size;
    }

    double getThickness(){
        return thickness;
    }

    void setSize(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"[%.1f:%s:%d]",thickness, hardness, size);
    }
}

class Pencil{
    private double thickness;
    Lead lead; 

    public Pencil(double thickness){
        this.thickness = thickness;
        this.lead = null;
    }

    boolean hasLead(){
        return lead != null;
    }

    void insert(Lead lead){
        if(thickness != lead.getThickness()){
            System.out.println("fail: calibre incompativel");
            return;
        }

        if(hasLead()){
            System.out.println("fail: ja existe grafite");
            return;
        }

        this.lead = lead;
    }

    void remove(){
        if(!hasLead()){
            System.out.println("fail: nao existe grafite");
            return;
        }

        this.lead = null;
    }

    void write(){
        if(!hasLead()){
            System.out.println("fail: nao existe grafite");
            return;
        }

        else if(lead.getSize() <=10){
            System.out.println("fail: tamanho insuficiente");
            return;
        }

        if((lead.getSize() - lead.usagePerSheet()) <10){
            System.out.println("fail: folha incompleta");
            lead.setSize(10);
            return;
        }

        lead.setSize(lead.getSize() - lead.usagePerSheet());
    }

    @Override
    public String toString() {
        String who = hasLead() ? lead.toString() : "null";
        return String.format(Locale.US,"calibre: %.1f, grafite: %s", thickness, who);
    }
}


public class Shell {
    public static void main(String[] args) {
        Pencil pencil = new Pencil(0);
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) { 
                var thickness = Double.parseDouble(par[1]);
                pencil = new Pencil(thickness);
            }
            else if (cmd.equals("show")) { 
                System.out.println(pencil.toString());
            }
            else if (cmd.equals("insert")) { 
                var thickness = Double.parseDouble(par[1]);
                var hardness = par[2];
                var size = Integer.parseInt(par[3]);
                Lead lead = new Lead(thickness, hardness, size);
                pencil.insert(lead);

            }
            else if (cmd.equals("remove")) { 
                pencil.remove();
            }
            else if (cmd.equals("write")) { 
                pencil.write();
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
