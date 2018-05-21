import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("test1");
        list.add("test2");
        list.add("test3");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(2));

    }
}
