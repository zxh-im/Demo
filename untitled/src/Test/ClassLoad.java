package Test;

//类的初始化顺序
public class ClassLoad {
    Person person = new Person("person ClassLoad 4");
    static {
        System.out.println(" classload Static 1");
    }

    public ClassLoad() {
        System.out.println("ClassLoad构造器初始化 5");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person {
    static {
        System.out.println("person static 3");
    }

    public Person(String str) {
        System.out.println("Person构造器初始化 :"+str);
    }
}

class MyClass extends ClassLoad{
    Person Person = new Person("person MyClass 6");
    static {
        System.out.println("Mycalss static 2");
    }
    public MyClass(){
        System.out.println("myClass 构造器 construcor 7");
    }
}