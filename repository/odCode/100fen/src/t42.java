import java.util.Scanner;

//字符串变换最小字符串
/*
题目描述
给定一个 字符串 s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
变换规则：交换字符串中任意两个不同位置的字符。
输入描述
一串小写字母组成的字符串s
输出描述
一串小写字母组成的字符串s
备注
s是都是小写字符组成
1 ≤ s.length ≤ 1000

用例1
输入
abcdef
输出
abcdef
说明
abcdef已经是最小字符串，不需要交换。

用例2
输入
bcdefa
输出
acdefb
说明
a和b进行位置交换，可以得到最小字符串

 */
public class t42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        //目标,将更靠后的字符和第一个交换
        //贪心思想:找在最后的最小字符和第一个交换
        //为什么能行呢?你想呀,中点是,只能进行一次交换
        //找在最后的字符的坐标
        int min_value='z'+1;
        int x=0;
        for (int i = 0; i < chars.length; i++) {
            if((int)chars[i]<=min_value){
                x=i;//更新到最后一个
                min_value=(int)chars[i];
            }
        }
        //如果是从小到大的话
        if(x==0){
            System.out.println(str);
            return;
        }
        //和第一个交换
        StringBuilder sb = new StringBuilder();
        sb.append(chars[x]);
        for (int i = 1; i < chars.length; i++) {
            if(i!=x){
                sb.append(chars[i]);
            }else {
                sb.append(chars[0]);
            }
        }
        System.out.println(sb.toString());
    }
}
