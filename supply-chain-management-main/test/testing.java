package project.test;

public class testing {
    transient int a = 10;
    int b=10;
    public static void main(String[] args) {
       testing obj = new testing();
        System.out.println(obj.a);
        System.out.println(obj.b);
    }
}


