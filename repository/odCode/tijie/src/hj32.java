import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class hj32 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        getLength(line);
    }

    private static void getLength(String line){
        int max=Integer.MIN_VALUE;
        String temp;
        //暴力切字符串 apple
        for (int i = 0; i <line.length() ; i++) {
            //切割每个获取每个字符串
            for (int j = i+1; j < line.length()+1; j++) {
                temp=line.substring(i,j);
                //如果倒转之后的相等
                if(reverse(temp).equals(temp)){
                    //如果小于就更新
                    if(temp.length()>max){
                        max=temp.length();
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static String reverse(String line){
        StringBuilder sb=new StringBuilder(line);
        return sb.reverse().toString();
    }
}
