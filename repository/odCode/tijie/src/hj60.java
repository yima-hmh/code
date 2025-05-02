import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int job= in.nextInt();
        finishjob(job);
    }
    static void finishjob(int job){
        //这个是用来获取最靠近的两个素数的穷举算法
        /*int sum=0;
        int one=0,two=0;
        for (int i = job; i >=2; i--) {
            if(check(i)&&sum==0){
                one=i;
                sum++;
            }else if(check(i)&&sum==1){
                two=i;
                sum++;
            }
            if(sum==2){
                break;
            }
        }
        System.out.println(one);
        System.out.println(two);
*/
        //这个是用来获取两个素数加起来等于n且差值最小的两个素数
        //用一个数组来存结果
        int[] res=new int[2];
        //求差值最小问题,也是求最值,所以
        int min=Integer.MAX_VALUE;
        for (int i = 2; i < job; i++) {
            //首先两个都需要是素数
            if(check(i)&&check(job-i)){
                //差值取最小
                if(Math.abs(2*i-job)<min){
                    min=Math.abs(2*i-job);
                    res[0]=i;
                    res[1]=job-i;
                }
            }
        }
        //两数简单排序
        if(res[0]>res[1]){
            int temp=res[0];
            res[0]=res[1];
            res[1]=temp;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
    }

    static boolean check(int n){
        if(n==2) return true;
        for (int i = 2; i*i<=n; i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}