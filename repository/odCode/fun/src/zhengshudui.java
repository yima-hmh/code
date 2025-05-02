import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class zhengshudui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");

        int k = scanner.nextInt();
        int sum=0;
        ArrayList<Integer> res = new ArrayList<>();
        //先将所有有可能的升序存到数组中,再遍历计算前k个和就行了
        for (int i = 1; i <= Integer.parseInt(str1[0]); i++) {
            for (int j = 1; j <= Integer.parseInt(str2[0]); j++) {
                res.add(Integer.parseInt(str1[i])+Integer.parseInt(str2[j]));
            }
        }
        res.sort(Comparator.naturalOrder());
        for (int i = 0; i < k; i++) {
            sum+=res.get(i);
        }
        System.out.println(sum);
    }
}
