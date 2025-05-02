import java.util.HashMap;
import java.util.Scanner;

//最长连续子序列
//返回加起来等于sum的最长子序列的长度

//主打的就是,前缀和-sum=某个前缀和的话,这个下标之间的差就是长度.使用hashmap

public class t47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        int sum=scanner.nextInt();
        scanner.close();
//        int res=0;
        //想想看能不能用动态规划,不会,太难了
//        int[] dp = new int[sum + 1];//dp表示达到和为sum时的最大连续子序列长度
        System.out.println(getAns(arr,sum));


        /*      ;//dp[3][4]表示前3个字符组成sum为4的最长连续子序列长度
        //data base
        //前0个字符没有这样的子序列,所以返回0 dp[0][sum]=-1
        // dp[n][0]=0,正整数组成sum为0的只能说返回0,最长的连续子序列长度为0
        for (int i = 0; i < n; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < sum; i++) {
            dp[0][i]=-1;
        }

        //状态分为第几个字符,以及字符加起来
        //我的选择是什么?
        //从1个遍历到n个
        for (int i = 1; i <= n; i++) {
            //从1遍历到sum
            for (int j = 1; j < sum; j++) {
                dp[i][j]=Math.min()
            }
        }*/
    }


    static int getAns(int[]nums,int sum){
        //hashmap方法,键存前缀和,值存对应的数组下标
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int beginSum=0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            beginSum+=nums[i];
            //如果这个sum-目前的前缀和的大小有前缀和能匹配上,那么进入到更新程序
            if(hm.containsKey(beginSum-sum)){
                res=Math.max(res,i-hm.get(beginSum-sum));
            }
            //正整数的话,前n项和一定是不一样的
            hm.put(beginSum,i);
        }
        return res;
    }
}
