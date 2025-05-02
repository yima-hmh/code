import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//连续字母的长度
public class t26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        //---------------------------关键----------------------------
        int[] mp = new int[26];
        //暴力穷举,每个连续字串对应的字母映射对应的值
        for (int i = 0; i < str.length(); i++) {
            int j=i;
            int cnt=1;
            //连续的情况
            while (j+1< str.length()&& str.charAt(j+1)== str.charAt(j)){
                j++;
                cnt++;
            }
            //关键就在这,别的思维不难,完成题目中相同字母取最长
            int id=str.charAt(j)-'A';
            mp[id]=Math.max(cnt,mp[id]);
            i=j;
        }
        //获取所有字母的长度
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if(mp[i]>0) res.add(mp[i]);
        }
        //从大到小
        res.sort(Comparator.reverseOrder());
        if(k>res.size()||k<=0){
            System.out.println(-1);
        }else System.out.println(res.get(k-1));
    }
}
