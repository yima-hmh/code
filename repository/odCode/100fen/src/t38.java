import java.util.*;

//英文输入法:单词联想功能
//悲伤键盘手,这简直就是我,我就是这简直
/*
题目描述
主管期望你来实现英文 输入法 单词联想功能。
需求如下：
依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，
如果联想不到，请输出用户输入的单词前缀。
注意：
1. 英文单词联想时，区分大小写
2. 缩略形式如”don’t”，判定为两个单词，”don”和”t”
3. 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
输入描述
输入为两行。
首行输入一段由英文单词word和标点符号组成的语句str；
接下来一行为一个英文单词前缀pre。
0 < word.length() <= 20
0 < str.length <= 10000
0 < pre <= 20
输出描述
输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
用例1
输入
输出
说明
从用户已输入英文语句”I love you”中提炼出“I”、“love”、“you”三个单词，接下来 用户输入 “He”，
从已输入信息中无法联想到任何符合要求的单词，因此输出用户输入的单词前缀。
 */
public class t38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().replace(".", " ").replace(","," ").split(" ");
        Arrays.sort(words, Comparator.naturalOrder());

        while (!scanner.hasNext("#")){
            List<String> res = new ArrayList<>();
            String input = scanner.nextLine();//获取需要联想的单词前缀
            for (int i = 0; i < words.length; i++) {
                //如果单词的长度大于输入的长度的话,进入判断
                if(words[i].length()>=input.length()){
                    if(words[i].substring(0,input.length()).equals(input)){
                        if(!res.contains(words[i]))
                        res.add(words[i]);
                    }
                }
            }
            if(res.size()>0){
                for (int i = 0; i < res.size(); i++) {
                    System.out.print(res.get(i)+" ");
                }
                System.out.println();
            }
            else System.out.println(input);
        }
    }
}
