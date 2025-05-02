import java.util.Arrays;
import java.util.Scanner;

//导师请吃火锅
public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//代表往锅里下的菜的个数
        int m = scanner.nextInt();//m代表手速
       /* int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0]=scanner.nextInt();//0存第几秒下的菜
            arr[i][1]=scanner.nextInt();//1存过几秒才变得刚好合适.
        }*/
        //先放下的菜不一定先熟,所以需要的是菜熟的时间,而不是别的
        //所以不用考虑前面的,只是吃刚好合适的
        //这时候就想,能不能用贪心算法呢,你想想看,能不能用
        //用反正法证明如下
        /*
        假设存在一个最优解,其中包含一个非贪心的选择,我们假设其为D,不是变得刚好合适的时间最早的菜
        那么就有一个菜A比他更早变得刚好合适,但是我们没有选A
        现在将D替换成A,由于A变得刚好合适的时间早于D
        所以该替换不会减少总的刚好合适的菜的数量
        但是你选A,有可能能选到D,这就跟假设矛盾了,所以此题满足贪心
         */
        //排序
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            arr[i]=x+y;//刚好做好的时间
        }
        //对刚做好的时间进行从小到大排序,每次吃的都是最早做好的,如果后面做好的,在手速之后的话,很好直接吃
        Arrays.sort(arr);
        //贪心,每次选择最早的
        int res=1;
        int last=arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i]>=last+m){
                res++;
            }
            last=arr[i];
        }
        System.out.println(res);//1<n
    }
}
