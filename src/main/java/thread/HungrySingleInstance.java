package thread;

public class HungrySingleInstance {

    private static HungrySingleInstance instance = new HungrySingleInstance();
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HungrySingleInstance getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        HungrySingleInstance instance1 = HungrySingleInstance.getInstance();
        instance1.setName("instance1");
        HungrySingleInstance instance2 = HungrySingleInstance.getInstance();
        instance2.setName("instance2");

        System.out.println(instance1.getName());
        System.out.println(instance2.getName());
    }
}

/*
instance2
instance2
饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
*/
