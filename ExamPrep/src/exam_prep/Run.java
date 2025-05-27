package exam_prep;

public class Run {
    public void show(int a, double b) {
        System.out.println("int-double");
    }

    public void show(double a, int b) {
        System.out.println("double-int");
    }
    
    public void show(double a, int b, int c) {
        System.out.println("double-int-int");
    }
    
    public void show(int a, int b, double c) {
        System.out.println("double-int-int");
    }
    
    public void show(int a, double b, int c) {
        System.out.println("double-int-int");
    }
    
    public void print(String msg) {
        System.out.println("String: " + msg);
    }

    public void print(int msg) {
        System.out.println("Int: " + msg);
    }

    public void print(double msg) {
        System.out.println("Double: " + msg);
    }
    
    public void func(Integer a) {
    	System.out.println("Integer func called");
    }
    
    public void func(Long a) {
    	System.out.println("long func called");
    }
    
    public static void main(String[] args) {
    	Run ot = new Run();
        //ot.show(10, 20, 30);

//        ot.print("Hello");
//        ot.print(10);
//        ot.print(10f);
        
        ot.func(10);
    }
}
