import java.util.*;

class Watch {
    private int hora;
    private int minuto;
    private int segundo;

    public Watch(){
        hora=0;
        minuto=0;
        segundo=0;
    }

    public Watch(int hora, int minuto, int segundo){
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    void set(int hora, int minuto, int segundo){
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    void setHora(int hora){
        if(hora >=0 && hora<=23){
            this.hora = hora;
        }

        else System.out.println("fail: hora invalida");
    }

    void setMinuto(int minuto){
        if(minuto>=0 && minuto<=59){
            this.minuto = minuto;
        }

        else System.out.println("fail: minuto invalido");
    }

    void setSegundo(int segundo){
        if(segundo >=0 && segundo<=59){
            this.segundo = segundo;
        }

        else System.out.println("fail: segundo invalido");
    }

    public int getHora(){
        return hora;
    }

    public int getMinuto(){
        return minuto;
    }

    public int getSegundo(){
        return segundo;
    }

    @Override
    public String toString() { 
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    void nextSecond(){
        segundo++;

        if(segundo>59){
            segundo =0;
            minuto++;
            
            if(minuto>59){
                minuto=0;
                hora++;

                if(hora>23){
                    hora=0;
                }
            }
        }
    }

}


public class Shell {
    public static void main(String[] a) {
        Watch watch = new Watch();
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                System.out.println(watch.toString());
            }
            else if (cmd.equals("init")) {
                int hour = Integer.parseInt(par[1]);
                int minute = Integer.parseInt(par[2]);
                int second = Integer.parseInt(par[3]);
                watch = new Watch(hour, minute, second);
            }
            else if (cmd.equals("set")) {
                int hour = Integer.parseInt(par[1]);
                int minute = Integer.parseInt(par[2]);
                int second = Integer.parseInt(par[3]);
                watch.set(hour, minute, second);
            }
            else if (cmd.equals("next")) {
                watch.nextSecond();
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
