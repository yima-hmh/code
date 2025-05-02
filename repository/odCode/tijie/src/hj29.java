import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class hj29 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String text1 = bf.readLine();
        String text2 = bf.readLine();
        encode(text1);
//        System.out.println(text1);
        decode(text2);
//        System.out.println(text2);

    }

    //加密 后一个字母替换,大写
    public static void encode(String text) {
         char[] chars = text.toCharArray();
        StringBuilder sb= new StringBuilder();
        //处理字母:小写变大写,然后往后顺移一位
        for (int i = 0; i < chars.length; i++) {
            //处理小写
            if(chars[i]>='a'&&chars[i]<='z') {
                if(chars[i]=='z'){
                    sb.append('A');
                }
                else sb.append((char) (chars[i] - 32 + 1));
            }
            //处理大写
            else if(chars[i]>='A'&&chars[i]<='Z') {
                if(chars[i]=='Z'){
                    sb.append('a');
                }
                else sb.append((char) (chars[i] +32 + 1));
            }
            //处理数字
            else if(chars[i]>='0'&&chars[i]<='9') {
                if(chars[i]=='9'){
                    sb.append('0');
                }
                else sb.append((char) (chars[i]+1));
            }
        }
        System.out.println(sb.toString());
    }

    //解密
    public static void decode(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb= new StringBuilder();
        //处理字母:小写变大写,然后往前顺移一位
        for (int i = 0; i < chars.length; i++) {
            //处理小写
            if(chars[i]>='a'&&chars[i]<='z') {
                if(chars[i]=='a'){
                    sb.append('Z');
                }
                else sb.append((char)(chars[i] - 32 - 1));
            }
            //处理大写
            else if(chars[i]>='A'&&chars[i]<='Z') {
                if(chars[i]=='A'){
                    sb.append('z');
                }
                else sb.append((char) (chars[i] +32 - 1));
            }
            //处理数字
            else if(chars[i]>='0'&&chars[i]<='9') {
                if(chars[i]=='0'){
                    sb.append('9');
                }
                else  sb.append((char) (chars[i]-1));
            }
        }
        System.out.println(sb.toString());
    }
}
