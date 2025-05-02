import java.util.Scanner;

//最长子字符串的长度
//环形,偶数o
public class t48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int sum=0;

        for (char c : chars) {
            if(c=='o')
                sum++;
        }
        if(sum==0) {
            System.out.println(0);
            return;
        }
        else if(sum%2==0){
            //本身有偶数个,最长字串就是其本身
            System.out.println(chars.length);
            return;
        }
        //奇数个随便删掉一个
        else System.out.println(chars.length-1);
    }
}
