import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class hj59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(getFirst(str)!=-1) System.out.println((char)getFirst(str));
        else System.out.println("-1");
    }
    static int getFirst(String str){
        char[] c = str.toCharArray();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            hashmap.put(c[i],hashmap.getOrDefault(c[i],0)+1);
        }
        for (int i = 0; i < c.length; i++) {
            if(hashmap.get(c[i])==1){
                return c[i] ;
            }
        }
        return -1;
    }
}