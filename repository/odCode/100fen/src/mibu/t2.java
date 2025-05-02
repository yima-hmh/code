package mibu;
import java.util.Arrays;
import java.util.Scanner;

//分苹果
public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//输入苹果数量
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();//输入每个苹果的重量
        }
        //满足A的要求
        int weight=0;
        for (int i = 0; i < n; i++) {
            weight^=arr[i];
        }
        if(weight!=0){
            System.out.println(-1);
        }else {
            Arrays.sort(arr);
            int totalweight=0;
            for (int i = 1; i < n ; i++) {
                totalweight+=arr[i];
            }
            System.out.println(totalweight);
        }
    }
}
