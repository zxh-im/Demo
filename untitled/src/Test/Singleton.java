package Test;

import java.util.Random;

/**
 * 单例模式 饥汉和懒汉
 */
public class Singleton {

    //懒汉
    private static final Singleton s = new Singleton(new Random().nextInt(10)+"");

    //饥汉
    private static volatile   Singleton s2 ;
    private String id;
    //构造方法私有化
    private Singleton(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    //饥汉
    private static synchronized Singleton singletonFactory(){
        if (s2 == null) {
            synchronized (Singleton.class){
                if (s2 == null) {
                    s2 = new Singleton(new Random().nextInt(10)+"");
                }
            }
        }
        return s2;
    }

    public static Singleton getSingleton(){
        return s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(Singleton.singletonFactory().toString());
        }
    }
}

