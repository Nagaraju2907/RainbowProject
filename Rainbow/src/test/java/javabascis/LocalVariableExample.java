package javabascis;

public class LocalVariableExample {

    int a = 10; //global variable
    int h;

    public static void main(String[] args) {


    }

    public void m1(){

        int b= 100;  //local varaiable
        System.out.println(a);
        System.out.println(b);
        h=100;
        System.out.println(h);
    }

    public void m2(){

        System.out.println(a);
        h= 200;
        System.out.println(h);
    }
}
