import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class hj14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> arrayList = new ArrayList<>();
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextLine());
        }
        arrayList.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
