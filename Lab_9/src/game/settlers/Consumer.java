package game.settlers;

import game.warehouse.Warehouse;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer extends  Thread{

    private Settlers settler;
    private Warehouse warehouse = null;
    private static final int MAX_AMOUNT = 10;

    public Consumer(Warehouse w, Settlers s){
        this.warehouse = w;
        this.settler = s;
    }

    public void run(){
        String name = this.settler.getTypeOfGood();
        Random ran = new Random();
        Integer amount = ran.nextInt(MAX_AMOUNT) + 1;
        System.out.println( "Proba pobrania: " + name + " " + amount);
        this.warehouse.getGood(name,amount);
        try {
            TimeUnit.SECONDS.sleep(ran.nextInt(5) + 1);
        }catch (InterruptedException e){
            System.out.print(e.getMessage());
        }
    }

}
