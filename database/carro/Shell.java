import java.util.*;

class Carro{
    int pass;
    int km;
    int gas;

    public Carro(){
        pass = 0;
        km = 0;
        gas = 0;
    }

    @Override
    public String toString() {
        return ("pass: "+pass+ ", gas: "+gas+ ", km: "+km);
    }

    void enter(){
        if(pass>=2){
            System.out.println("fail: limite de pessoas atingido");
            return;
        }

        pass+=1;
        pass = Math.min(pass, 2);
    }

    void leave(){
        if(pass <1){
            System.out.println("fail: nao ha ninguem no carro");
            return;
        }

        pass-=1;
        pass = Math.max(pass, 0);
    }

    void fuel(int ic){
        gas+=ic;
        gas = Math.min(gas, 100);
    }

    void drive(int dist){
        if(pass<1){
            System.out.println("fail: nao ha ninguem no carro");
            return;
        }

        if(gas==0){
            System.out.println("fail: tanque vazio");
            return;
        }

        if(dist>gas){
            System.out.println("fail: tanque vazio apos andar " +gas+ " km");
            km+=gas;
            gas=0;
            return;
        }

        km+=dist;
        gas-=dist;
        return;
    }
}


public class Shell {
    
    public static void main(String[] a) {
        Carro car = new Carro();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                System.out.println(car.toString());
            } 
            else if (cmd.equals("enter")) {
                car.enter();
            } 
            else if (cmd.equals("leave")) {
                car.leave();
            } 
            else if (cmd.equals("fuel")) {
                int increment = Integer.parseInt(par[1]);
                car.fuel(increment);
            } 
            else if (cmd.equals("drive")) {
                int distance = Integer.parseInt(par[1]);
                car.drive(distance);
            }  
            else {
                System.out.println("fail: comando invalido");
            }
        }   
    }
    private static Scanner scanner = new Scanner(System.in);
}
