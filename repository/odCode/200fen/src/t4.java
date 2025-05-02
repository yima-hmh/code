import java.util.Scanner;
import java.util.Stack;

//堆栈中的剩余数字
//想法1:模拟
public class t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //先处理数据
        String[] s = scanner.nextLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(s[i]);
        }

        //模拟法
        Stack<Integer> res = new Stack<>();

        for (int i = 0; i < n; i++) {
            int sum=0;
            boolean has=false;
            int chuduoshaoge=0;
            for (int j = i-1; j >= 0; j--) {
                //从i开始计算前面有没有加起来等于现在要入栈的元素的
                sum+=arr[j];
                chuduoshaoge++;
                if(sum==arr[i]){
                    has=true;
                    break;
                }
            }
            if(has){
                //如果真的有坐标
                //那么"出多少个"值就有用了
                for (int k = 0; k < chuduoshaoge; k++) {
                    res.pop();
                }
                res.push(arr[i]<<1);//乘2为进入的值
            }
            else res.push(arr[i]);
        }

        int total=res.size();
        for (int i = 0; i < total; i++) {
            System.out.print(res.pop().intValue()+" ");
        }
    }
}
