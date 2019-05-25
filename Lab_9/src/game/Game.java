package game;

import game.settlers.Producer;
import game.settlers.Settlers;
import game.warehouse.Warehouse;

public class Game {
    public static void  main(String[] args){
        Warehouse warehouse = new Warehouse();
        Producer p1 = new Producer(warehouse, Settlers.LUMBERMAN);
        Producer p2 = new Producer(warehouse, Settlers.MINER);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        }catch (InterruptedException e){
            System.out.print(e.getMessage());
        }
        //System.out.print("hello");
    }
}
