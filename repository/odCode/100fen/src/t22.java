import java.util.Scanner;
//简单的自动曝光
//这道题也是把答案穷举出来的+模拟
public class t22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int n=strs.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(strs[i]);
            //处理边界情况
            if(arr[i]<0)arr[i]=0;
            if(arr[i]>255)arr[i]=255;
        }

        //如何做这道题呢,应该怎么遍历?答案永远再-128到128
        int max=Integer.MAX_VALUE;
        int index=0;

        int count=-255;
        while (count!=255){
            int sum=0;
            for (int i = 0; i < n; i++) {
                int q=arr[i]+count;
                if(q<0) q=0;
                if(q>255)q=255;
                sum+=q;
            }
            //用这招避免float运算,全都是整数运算,目标:不用除法,想想看
            int diff = Math.abs(sum - 128 * n);
            if(diff<max){
                max=diff;
                index=count;//默认存储最小的,等于的时候不会改变index值
            }
            count++;
        }
        System.out.println(index);
    }
}
