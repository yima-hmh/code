import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1=in.nextLine();
        String str2=in.nextLine();
        String s1=str1.length()<str2.length()?str1:str2;//短的
        String s2=str1.length()<str2.length()?str2:str1;//长的

        //最值问题,一定有一个在迭代
        int max=0;
        //从长到短获取短字串的所有情况,然后一个一个判断
        for(int i=0;i<s1.length();i++){
            for(int j=s1.length();j>i;j--){
                if(s2.contains(s1.substring(i,j))){
                    //长的包含小的话,并且长度比现在的max更大,就更新max
                    max=(j-i)>max?(j-i):max;
                    //一旦包含,就是最大的,直接跳过
                    break;
                }
            }
        }
        System.out.println(max);
    }
}