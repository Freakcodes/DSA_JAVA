/**
 * Interface
 */
 interface Inter {
    int age=0;
    void show();
    void print();
    String name="Abhay";
    
}

class B implements Inter
{
    public void show()
    {
        System.out.println("Inside show"+name);
    }
    public void print()
    {
        System.out.println("Inside print statement");
    }
    public void kiler()
    {
        System.out.println("Hi i am abhay");
    }
}

public class Interface{
    public static void main(String[] args) {
        B obj=new B();
        obj.show();
        obj.print();
        obj.kiler();
    }
}