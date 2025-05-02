import java.util.Scanner;

//最长连续交替方波信号
/*
基本的想法是:取出每一段符合0开始,0结尾的字符串
判断是不是交替方波,不是的话继续检查,直到检查结束
 */
public class t20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        //去除空白字符
        code=code.trim();
        int length = code.length();
        int MaxLen=0;
        //遍历字符串的每一个字符
        for (int i = 0; i < length; i++) {
            //用来标志是否遇到连续的'11'
            int flag=0;
            if(code.charAt(i)=='0') {
                int j = i + 1;
                while (j < length) {
                    //连续碰到两个0就退出循环,因为此时子串不符合要求
                    if (code.charAt(j) == '0' && code.charAt(j - 1) == '0') {
                        break;
                    }
                    //连续遇到两个1的话,则设置标志位flag为1
                    if (code.charAt(j) == '1' && code.charAt(j - 1) == '1') {
                        flag = 1;
                    }
                    j++;//向后遍历
                }
                //如果找到的子串长度大于等于3,且未遇到连续的'11'
//                if()
            }
        }

    }
}
