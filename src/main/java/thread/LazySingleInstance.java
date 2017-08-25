package thread;

public class LazySingleInstance {
    private static LazySingleInstance instance = null;
    private String name = "";

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static LazySingleInstance getLanHanInstance() {
        if(instance == null) {
            synchronized (LazySingleInstance.class) {
                if(instance == null) {
                    instance = new LazySingleInstance();
                }
            }
        }
        return instance;
    }

    private static synchronized LazySingleInstance getLanHanInstance2() {
        if(instance == null) {
            instance = new LazySingleInstance();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleInstance instance1 = LazySingleInstance.getLanHanInstance2();
        instance1.setName("instance1");
        LazySingleInstance instance2 = LazySingleInstance.getLanHanInstance2();
        instance2.setName("instance2");

        System.out.println(instance1.getName());
        System.out.println(instance2.getName());
    }
}
/*
instance2
instance2
*/
