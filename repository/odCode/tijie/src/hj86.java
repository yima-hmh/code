import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //转化成二进制数
        int code=in.nextInt();
        String str=Integer.toBinaryString(code);
        char[] c=str.toCharArray();
        //求最大值需要一个res
        int res=0;

        //计算连续的1的数量
        for(int i=0;i<c.length;i++){
            int temp=0;
            //此处注意&&的短路特性,把length判断放前面就不会出现数组溢出的错误了
            while(i<c.length&&c[i]=='1'){
                temp++;
                i++;
            }
            res=Math.max(temp,res);
        }
        System.out.print(res);
    }
}