import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
//增强的strstr
//最大亮点:将hashset当做这种可选段的处理手段,然后用arraylist存hashset
/*
题目描述
C语言有一个 库函数 :char*strstr(const char *haystack, const char *needle)，实现在字符haystack 中查找第一次出现字符串needle的位置，如果未找到则返回null。现要
求实现一个strstr的增强函数，可以使用带可选段的字符串来模糊查询，与strstr一样返回首次查找到的字符串位置。可选段使用“[]”标识，表示该位置是可选段中任意一个字
符即可满足匹配条件。比如“a[bc]”表示可以匹配“ab"或“ac”。注意目标字符串中可选段可能出现多次。
输入描述
与 strstr函数 一样，输入参数是两个字符串指针，分别是源字符串和目标字符串。
输出描述
与strstr函数不同，返回的是源字符串中，匹配子字符串相对于源字符串地址的偏移(从0开始算)，如果没有匹配返回-1。
补充说明
源字符串中必定不包含[';目标字符串中叮必定成对出现，且不会出现嵌套。输入的字符串长度在[1,100]之间。
示例1
输入
输出
说明：相当于是在源字符串中查找bc或者bd，bc子字符串相对于abcd的偏移量是1。
 */
public class t39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        String input = scanner.nextLine();
        ArrayList<HashSet<Integer>> check = new ArrayList<>();
        int length = input.length();

        //遍历input字符串,处理一下[],check
        for (int i = 0; i < length; i++) {
            if(input.charAt(i)!='['){
                HashSet<Integer> now = new HashSet<>();
                now.add((int)input.charAt(i));
                check.add(now);
            }
            else {
                //当前字符是'['
                int j=i+1;
                HashSet<Integer> now = new HashSet<>();
                while (input.charAt(j)!=']'){
                    now.add((int)input.charAt(j));
                    j++;
                }
                check.add(now);
                i=j;
            }
        }

        //如果check集合的大小大于string的长度,说明匹配不可能 check的大小是input真正的长度
        if(check.size()>code.length()){
            System.out.println(-1);
            return;
        }
        //寻找开始
        for (int i = 0; i < code.length(); i++) {
            boolean found=true;
            //从code的第i位开始的字串是否满足要求
            for (int j = 0; j < check.size(); j++) {
                HashSet<Integer> now = check.get(j);
                //如果不匹配,直接break
                if(!now.contains((int)code.charAt(i+j))) {
                    found=false;
                    break;
                }
            }
            if(found){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
