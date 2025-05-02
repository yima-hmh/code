import java.util.HashMap;
import java.util.Scanner;

//寻找符合要求的最长子串
/*
有种暴力的解法
用不允许出现的字符划分个部分子字符串
然后穷举所有不包含两个字符的子字符串
计算其中最长的
split("cannotcontain")

用双指针法自己做出来了,太帅了
 */
public class t14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cannotContain=scanner.nextLine();//不包含的指定字符
        String[] code =scanner.nextLine().split(cannotContain);//字符串按照不能出现的字符划分,保证了其不会出现
        int max=0;
        for (int i = 0; i < code.length; i++) {
            int curmax=getMaxSubString(code[i]);
            max=Math.max(max,curmax);
        }
        System.out.println(max);
    }
    //双指针法统计最长不包含两个字母的子字符串的长度
    static int getMaxSubString(String code) {
        if(code.length()==1)return 1;
        //对应计数,实现最多出现2次
        HashMap<Character,Integer> hm = new HashMap<>();
        int left=0,right = 0;
        char[] chars = code.toCharArray();
        int maxlen=0;
        while (right<chars.length){
            //统计某字符的长度
            hm.put(chars[right],hm.getOrDefault(chars[right],0)+1);
            //左指针要右移的情况
            while (hm.get(chars[right])>2){
                hm.put(chars[left],hm.getOrDefault(chars[left],0)-1);
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}
