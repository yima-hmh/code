import java.util.Scanner;


//日志采集系统:上传第一个
/*
题目描述
日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
如果上报太频繁，会对 服务端 造成压力；
如果上报太晚，会降低用户的体验；
如果一次上报的条数太多，会导致超时失败。
为此，项目组设计了如下的上报策略：
1. 每成功上报一条日志，奖励1分
2. 每条日志每延迟上报1秒，扣1分
3. 积累日志达到100条，必须立即上报
给出日志序列，根据该规则，计算首次上报能获得的最多积分数。
输入描述
按时序产生的日志条数 T1,T2...Tn, 其中 1≤n≤1000,0≤Ti≤100
输出描述
首次上报最多能获得的积分数
示例1
输入
输出
说明
采集系统第2个时刻上报，可获得最大积分(98+1)-1=98
示例2
输入
输出
说明
如果第1个时刻上报，获得积分50。
如果第2个时刻上报，最多上报100条，前50条延迟上报1s，每条扣除1分，共获得积分为 100-50=50。
 */
public class t31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] xulie = scanner.nextLine().split(" ");
        int length = xulie.length;
        //获取没个时刻的产生的日志条数
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(xulie[i]);
        }
     /*   //模拟整个过程来找到第几个时刻上报最屌
        int sum = 0;//没积累到100条不用上报,也就是日志条数
        int yanchi = 0;//延迟的分数
        int res = 0;//此时刻上报的话,获得的最高分数,不断迭代的就是这个
        int temp=0;
        //i表示从哪个时刻开始
        for (int i = 0; i < length; i++) {
            sum=0;
            temp=0;
            yanchi+=arr[i];
            for (int j = 0; j < length && sum < 100; j++) {
                sum += arr[j];

            }
            res=Math.max(temp,res);
        }*/

       /* //当前的累计日志条数
        int total=arr[0];
        //当前的最大积分数,初始值为首次读取到的日志条数或100.取较小值
        int ans=Math.min(100,arr[0]);
        //初始化延迟扣分数
        int sub=0;

        //遍历日志条数列表,计算最大积分
        for (int i = 1; i < length; i-=-1) {
            sub+=total;//累计当前日志条数到sub..........好精妙的一步,顺便把要每次后退前面的都要加一的问题解决了
            total+=arr[i];//新读取的日志条数到total
            //计算更大积分
            //即使最极端的条件下,也是能成立的,ans可能等于100,但是后面哪个不可能大于100
            ans=Math.max(ans,Math.min(total,100)-sub);
            if(total>=100){
                break;
            }
        }*/

        //remake 版本
        int total=0;
        int sub=0;
        int ans=0;
        for (int i = 0; i < length; i++) {
            sub+=total;//关键的地方,扣去的积分
            total+=arr[i];
            ans=Math.max(ans,Math.min(100,total)-sub);
            if(total>=100){
                break;
            }
        }
        System.out.println(ans);
    }
}
