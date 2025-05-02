import java.util.Scanner;

//字符串分割
/*
给定一个非空 字符串 S，其被N个'-分隔成 N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用-分隔。对于新组成的每一个子
串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母;反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换
为大写字母;大小写字母的数量相等时，不做转换。

3
12abc-abCABc-4aB@


 */
public class t43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String []str = scanner.nextLine().split("-");
        StringBuilder sb = new StringBuilder();
       /* if(str.length==1){
            sb.append(str[0]);//第一个字串直接添加
        }else {
            sb.append(str[0]).append("-");//第一个字串直接添加
        }*/

        //如果字符串长度是1的话,直接就是一个输出然后结束
        if(str.length==1){
            System.out.println(str[0]);
            return;
        }
        //获得所有的string
        StringBuilder res = new StringBuilder();
        res.append(str[0]).append("-");//添加第一个字符串到res中
        for (int i = 1; i < str.length; i++) {
            sb.append(str[i]);
        }
        String code = sb.toString();
        for (int i = 0; i <code.length(); i+=k) {
                if(i+k<code.length()){
                    String nowStr = code.substring(i,i+k);
                    res.append(deal(bigorSmall(nowStr),nowStr)).append("-");
                }else {//i+k已经大于code.length了,此时取后面的所有后break即可
                    res.append(deal(bigorSmall(code.substring(i,code.length())),code.substring(i,code.length())));
                    break;
                }
        }
        System.out.println(res.toString());
    }
    //判断字符串中是鸡巴大写多还是小写多
    static int bigorSmall(String str){
        int n=str.length();
        int big=0,small=0;//任意一方大于n/2,break
        //大写返回2,小写返回1,相等返回0
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            if(Character.isLowerCase(chars[i])){
                small++;
            }else if(Character.isUpperCase(chars[i])){
                big++;
            }
        }
        if(big==small){
            return 0;
        }else if(big>small){
            return 2;
        }else{
            return 1;
        }
    }

    //根据大小写的情况处理该字符串
    static String deal(int bigorSamll,String str){
        if(bigorSamll==0){
            return str;
        }else if(bigorSamll==1){
            return str.toLowerCase();
        }else return str.toUpperCase();
    }
}
