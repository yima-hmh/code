import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class hj10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashSet<Character> hashSet = new HashSet<>();
        System.out.println(GetTotal(hashSet, str));
    }
    static int GetTotal(HashSet hashSet, String str) {
        int diff = 1;
        char[] chars = str.toCharArray();
        //遍历
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>=0&&chars[i]<=127){
                hashSet.add(chars[i]);
            }

        }
        return hashSet.size();
    }
}
