import java.util.HashMap;
import java.util.Scanner;

//最左侧冗余覆盖子串
//最左侧只是用来简化题目的,第一个满足条件的直接输出后返回
//这个还可以用滑动窗口来做
public class t49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();//最左侧的s2以长度k冗余覆盖s1的子串首个元素下标
        int k = scanner.nextInt();
        //---------------------------------------------方法二:滑动窗口法
        windowsJob(str1, str2, k);

        //-----------------------------方法一:模拟法,获取每一个长度为n+k的子串
        //然后统计子串的数据
        //子串的数据是否满足要求,输出第一个满足的然后return
        char[] chars1 = str1.toCharArray();
        int[] arr = new int[26];
        int n = chars1.length;
        for (int i = 0; i < n; i++) {
                arr[chars1[i]-'a']++;
        }

        int add=k+n;
        for (int i = 0; i+add <= str2.length(); i+=add) {
            //取子串
            //长度为n+k
            String now = str2.substring(i, i+add);
            //统计
            boolean ok=true;
            int[] nowarr = new int[26];
            for (int j = 0; j < now.length(); j++) {
                nowarr[now.charAt(j)-'a']++;
            }
            for (int g = 0; g < 26; g++) {
                if(arr[g]!=0){
                    if(nowarr[g]==0||arr[g]>nowarr[g]){
                        ok=false;//如果没改,就是ok的
                    }
                }
            }
            if(ok){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }



    static void windowsJob(String str1,String str2,int k) {
        //为什么可以用滑动窗口,题目有什么特征,首先,字字符串的长度是确定的,这个很重要
        int res = 0;//首先匹配成功的坐标
        //每移动一下,最左边的元素对应的位置减1,下一个元素对应的位置加1

        //记录str1的情况
        int[] str1_status = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            str1_status[str1.charAt(i) - 'a']++;
        }

        //开始工作,这会就会知道为什么数组定名为help了
        //子串长度
        int len = str1.length() + k;
        int[] help = new int[26];
        if (str2.length() < len) {
            System.out.println(-1);
            return;
        }
        //记录len个就好
        for (int i = 0; i < len; i++) {
            help[str2.charAt(i) - 'a']++;
        }

        for (int i = len; i <= str2.length(); i++) {
            boolean notgood = false;
            for (int j = 0; j < 26; j++) {
                if (help[j] < str1_status[j]) {
                    notgood = true;
                    break;
                }
            }
            if (!notgood) {
                System.out.println(i - len);
                return;
            }
            if (i == str2.length()) break;//避免溢出

            //不满足进入调整
            help[str2.charAt(i) - 'a']--;//第一个字符的数量--
            help[str2.charAt(i + 1) - 'a']++;//第二个字符的数量++
        }
        System.out.println(-1);
    }
}
