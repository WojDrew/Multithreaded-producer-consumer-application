package game.warehouse;

import java.util.Hashtable;

public class Warehouse {
    private Hashtable<String,Integer> goods;

    public Warehouse(){
        this.goods = new Hashtable<String, Integer>();
    }

    public synchronized void addGood(String name, Integer amount){
        if(this.goods.containsKey(name)){
            Integer a = this.goods.get(name);
            a += amount;
            this.goods.replace(name,a);
        }
        else{
            this.goods.put(name,amount);
        }
        System.out.println("Magazyn: przyjeto " + name + " " + amount);
        this.report();
    }

    public synchronized void getGood(String name, Integer amount){
        if(this.goods.containsKey(name)){
            Integer a = this.goods.get(name);
            if(a > amount){
                a -= amount;
                this.goods.replace(name,a);
                System.out.println("Magazyn: wydano " + name + " " + amount);
                this.report();
                return;
            }
        }
        System.out.println("Odmowa wydania brak towaru");
    }

    public void report(){
        System.out.println(this.goods);
    }

}
