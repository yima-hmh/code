import java.util.Scanner;

/*
题目描述
一群大雁往南飞，给定一个字符串记录地面上的游客听到的大雁叫声，请给出叫声最少由几只大雁发出。具体的:
1.大雁发出的完整叫声为"quack"，因为有多只大雁同一时间嘎嘎作响，所以字符串中可能会混合多个"quack"。
2.大雁会依次完整发出”quack”，即字符串中’q’,‘u’,‘a’,‘℃’,‘k' 这5个字母按顺序完整存在才能计数为一只大雁。如果不完整或者没有按顺序则不予计数。
3.如果字符串不是由'q','u','a','c','k'字符组合而成，或者没有找到一只大雁，请返回-1。
输入描述
一个字符串，包含大雁quack的叫声。1<= 字符串长度 <=1000，字符串中的字符只有'q','u','a','c','k'。
输出描述
大雁的数量
示例1
输入 quackquack
输出 1

示例2
输入 qaauucqckk
输出 -1
 */
//数大雁,模拟题
//关键是理解后面要根据前面的来判断
//previous数组
public class t33 {

    private static final char[]PREVIOUS=new char['z'];
    static {
        //进行初始化操作:这已经变成了一个数组
        char[] chars = "quackq".toCharArray();
        for (int i = 1; i < chars.length; i++) {
            PREVIOUS[chars[i]]=chars[i-1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] job = scanner.nextLine().toCharArray();
        int[]cnt=new int['z'];
        for (int i = 0; i < job.length; i++) {
            //不合规的字符,用\u0000判断是否为空
            if (PREVIOUS[job[i]]=='\u0000'){
                System.out.println("-1");
                return;
            }
            //如果前一个值存在,那就--
            if(cnt[PREVIOUS[job[i]]]!=0){
                //复用大雁
                cnt[PREVIOUS[job[i]]]--;
            }else if(job[i]!='q'){
                //不合规
                System.out.println("-1");
                return;
            }
            cnt[job[i]]++;
        }
        if(cnt['q']!=0||cnt['u']!=0||cnt['a']!=0||cnt['c']!=0||cnt['k']==0){
            System.out.println("-1");
            return;
        }
        System.out.println(cnt['k']);
    }
}
