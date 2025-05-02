import java.util.*;

//查找充电设备组合
/*
经典的01背包
n个充电设备---
 */
public class t8_dpdianchi {
    //我想到的暴力解法
    public static void main(String[] args) {/*
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//充电设备总数
        int[] gonglvs=new int[n];
        for (int i = 0; i < n; i++) {
            gonglvs[i]=scanner.nextInt();
        }
        int p_max=scanner.nextInt();//最大输出功率
        //初始化allresult
        ArrayList<Integer> allresult = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allresult.add(gonglvs[i]);
        }

        //获得所有有可能组成的功率,这样的话,时间复杂度就是n^2了
        int temp=0;
        for (int i = 0; i < n; i++) {
            temp=gonglvs[i];
            for (int j = i+1; j < n; j++) {
                temp+=gonglvs[j];
                allresult.add(temp);
            }
        }
        allresult.sort(Comparator.reverseOrder());//能组成的功率从大到小排列
        for (int i = 0; i < allresult.size(); i++) {
            if(allresult.get(i)<=p_max){
                System.out.println(allresult.get(i));
                return;
            }
        }
        System.out.println("0");*/

        //动态规划解法
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//充电设备总数
        int[] gonglvs=new int[n];
        for (int i = 0; i < n; i++) {
            gonglvs[i]=scanner.nextInt();
        }
        int p_max=scanner.nextInt();//最大输出功率
        //dp[i]表示不超过功率i的情况下可以达到的最大输出功率和
        int[] dp=new int[p_max+1];
        //状态就只有功率,选择是这个充电设备
            //base case就是默认是0;
        //遍历所有能够提供的功率,也就是所有充电设备
        for (int i = 0; i < n; i++) {
            for (int j = p_max; j >=gonglvs[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-gonglvs[i]]+gonglvs[i]);
            }
        }
        System.out.println(dp[p_max]);
        scanner.close();
    }





}
