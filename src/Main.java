import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean choice;
        System.out.println("Input 'false' for BC. \nInput 'true' for AC");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextBoolean();
        SomeBean sb = new Injector().inject(new SomeBean(), choice);
        sb.foo();
    }
}