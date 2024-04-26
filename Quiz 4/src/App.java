public class App {
    public static void main(String[] args) throws Exception {
       
    Counter c = new Counter();
    A a1 = new A(c);
    A a2 = new A(c); 
    B b1 = new B(c);
    int num1 = a1.click();
    int num2 = a2.click();
    int num3 = b1.click();

    }
}
