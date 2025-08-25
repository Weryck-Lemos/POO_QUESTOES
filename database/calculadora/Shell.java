import java.util.*;
import java.util.Locale;

class Calculadora{
    double display;
    int battery;
    int batteryMax;

    public Calculadora(int batteryMax){
        this.batteryMax = batteryMax;
        display = 0;
        battery = 0;
    }

    @Override
    public String toString(){
        return("display = "+ String.format(Locale.US, "%.2f", display) + ", battery = "+battery);
    }

    void charge(int increment){
        battery += increment;
        battery = Math.min(battery, batteryMax);
        return;
    }

    void Somar(int a, int b){
        if(battery == 0){
            System.out.println("fail: bateria insuficiente");
            return;
        }

        display = a+b;
        battery -=1;
        battery = Math.max(battery, 0);
        return;
    }

    void Divisao(double a, double b){
        if(battery == 0){
            System.out.println("fail: bateria insuficiente");
            return;
        }

        battery -=1;
        battery = Math.max(battery, 0);

        if(b==0){
            System.out.println("fail: divisao por zero");
            return;
        }

        display = a/b;
        return;
    }
}


public class Shell {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora(0);
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                int batteryMax = Integer.parseInt(par[1]);
                calc = new Calculadora(batteryMax);
            } 
            else if (cmd.equals("show")) {
                System.out.println(calc.toString());
            } 
            else if (cmd.equals("charge")) {
                int value = Integer.parseInt(par[1]);
                calc.charge(value);
            } 
            else if (cmd.equals("sum")) {
                int a = Integer.parseInt(par[1]);
                int b = Integer.parseInt(par[2]);
                calc.Somar(a, b);
            } 
            else if (cmd.equals("div")) {
                int num = Integer.parseInt(par[1]);
                int den = Integer.parseInt(par[2]);
                calc.Divisao(num, den);
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
