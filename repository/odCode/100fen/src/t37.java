import java.util.Scanner;

//虚拟理财游戏
/*
题目描述
在一款虚拟游戏中生活，你必须进行投资以增强在虚拟游戏中的资产以免被淘汰出局。
现有一家Bank，它提供有若干理财产品 m 个，风险及投资回报不同，你有 N（元）进行投资，能接收的总风险值为X。
你要在可接受范围内选择最优的投资方式获得最大回报。
备注
在虚拟游戏中，每项投资风险值相加为总风险值；
在虚拟游戏中，最多只能投资2个理财产品；
在虚拟游戏中，最小单位为整数，不能拆分为小数；
投资额*回报率=投资回报
输入描述
第一行：
产品数（取值范围[1,20]）
总投资额（整数，取值范围[1, 10000]）
可接受的总风险（整数，取值范围[1,200]）
第二行：产品投资回报率序列，输入为整数，取值范围[1,60]
第三行：产品风险值序列，输入为整数，取值范围[1, 100]
第四行：最大投资额度序列，输入为整数，取值范围[1, 10000]
输出描述
每个产品的投资额序列
用例1
输入
5 100 10
10 20 30 40 50
3 4 5 6 10
20 30 20 40 30
输出
0 30 0 40 0
说明
投资第二项30个单位，第四项40个单位，总的投资风险为两项相加为4+6=10

 */
public class t37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chanpinshu = scanner.nextInt();
        int total = scanner.nextInt();
        int maxRisk = scanner.nextInt();

        //------------------数据处理
        //每个产品的回报率
        int[] reward = new int[chanpinshu];
        for (int i = 0; i < chanpinshu; i++) {
            reward[i]=scanner.nextInt();
        }
        //产品风险值序列
        int[] risk = new int[chanpinshu];
        for (int i = 0; i < chanpinshu; i++) {
            risk[i]=scanner.nextInt();
        }

        //最大投资额度序列
        int[] touziedu = new int[chanpinshu];
        for (int i = 0; i < chanpinshu; i++) {
            touziedu[i]=scanner.nextInt();
        }

        // 主打一个鸡巴的暴力解
        int maxReward=Integer.MIN_VALUE;
        int a1=0,a2=0;//记录选择的两个产品的序号
        int s1=0,s2=0;//记录选择的两个产品的投资额


        //结果投资额度,由于只能选2个产品
        for (int i = 0; i < chanpinshu; i++) {
            if(risk[i]>maxRisk) continue;//风险过大,不行
          /*  //在能承担的范围内全部买了收益是多少
            //在投资额度内假设allin
            int buy=touziedu[i]>total?total:touziedu[i];
            int x=buy*reward[i]*buy;//投资回报=投资额*回报率

            //如果allin这款产品,给我的回报比当前最大回报还要大,那么就要更新最大回报
            if(x>maxReward){
                maxReward=x;
                //假设此时未选第二款产品
                a1=i;
                s1=buy;
            }*/
            //在选了这样一种鸡巴东西的前提下,再去选第二个

            for (int j = i+1; j < chanpinshu; j++) {
                int riskSum=risk[i]+risk[j];
                if(riskSum>maxRisk){
                    continue;//选择下一个j
                }

                //遍历投资额
                int tiaojian=Math.min(total,touziedu[i]);//这样一个组合最多能投的就是这个了,不能大于总投资额total
                for (int k = 1; k <= tiaojian; k++) {
                    //计算分给a1的回报
                    int invest1=reward[i]*k;
                    //计算分给a2的回报
                    int left=total-k;//剩下的能给a2的额度
                    int invest2=reward[j]*Math.min(touziedu[j],left);
                    int totalInvest=invest1+invest2;
                    //如果大于,更新,并记录
                    if(totalInvest>maxReward){
                        maxReward=totalInvest;
                        a1=i;
                        a2=j;
                        s1=k;
                        s2=Math.min(touziedu[j],left);
                    }
                }
            }
        }

        int[] res = new int[chanpinshu];//这里挺妙的
        res[a1]=s1;
        res[a2]=s2;
        for (int i = 0; i < chanpinshu; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
