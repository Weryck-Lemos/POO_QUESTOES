class Towel{
    String color;
    char size;
    int wetness;

    public Towel(String color, char size){
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    void writeOut(){
        wetness = 0;
    }

    int umity(){
        if(size == 'P') return 10;
        else if(size == 'M') return 20;
        else return 30;
    }

    boolean isDry(){
        return wetness == 0 ? true : false;
    }

    void dry(int amount){
        wetness += amount;

        if(wetness > umity()){
            System.out.println("toalha encharcada");
            wetness = umity();
        }
    }
}

public class TestTowel {
    public static void main(String[] args) {
        Towel t1 = new Towel("azul", 'M');

        System.out.println("Seca? " + t1.isDry());

        t1.dry(5);
        System.out.println("Wetness = " + t1.wetness);

        t1.dry(20);
        System.out.println("Wetness = " + t1.wetness);

        t1.writeOut();
        System.out.println("Depois de espremer, seca? " + t1.isDry());
    }
}
