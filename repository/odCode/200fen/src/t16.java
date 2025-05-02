import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//中文分词模拟器
/*
穷举真的太难爽了
 */
public class t16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取等待分词的语句
        String code = scanner.nextLine();
        //读取词库并分割为数组
        String[] words = scanner.nextLine().split(",");
        //用一个hashSet存储词库便于快速查找
        Set<String> hs = new HashSet<>();
        for (String word : words) {
            hs.add(word);
        }
        String ans = "";
        //分词标记,用于标记是否加逗号,第一个不加,最后一个不加,待会就能看到此人天衣无缝的逻辑
        int f = 0;

        //开始遍历,在这里注意i不要自增,因为由里面的循环去控制
        for (int i = 0; i < code.length();) {
            if (code.charAt(i) < 'a' || code.charAt(i) > 'z') {
                ans += code.charAt(i);
                i++;
                f=0;
                continue;
            }
            //首次处理字符时不加逗号,其余情况下添加逗号
            if (f == 0) f = 1;
            else ans += ",";

            //初始化当前最大分词索引何临时分词字符串
            int idx = i + 1;
            String tmp=""+code.charAt(i);//单个字母,不在词库中则输出单个字母
            StringBuilder now = new StringBuilder("");
            now.append(code.charAt(i));
            //从当前字符开始尝试最大匹配词
            for (int j = i+1; j < code.length(); j++) {
                now.append(code.charAt(j));
                //在词库中的话,就更新最大匹配索引和临时分词字符串
                if(hs.contains(now.toString())){
                    idx=j+1;
                    tmp=now.toString();//如果有更长的,就更新到tmp中,now只是一个辅佐
                }
            }
            i=idx;
            ans+=tmp;
        }
        //输出最终分词结果
        System.out.println(ans);
    }

}
