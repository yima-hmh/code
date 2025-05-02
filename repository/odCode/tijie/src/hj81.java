import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class hj81 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String duan=scanner.nextLine();
        String chang=scanner.nextLine();

        System.out.println(getResult(duan,chang));
        return;
    }
    static String getResult(String duan,String chang){
        char[] du = duan.toCharArray();
        char[] ch = chang.toCharArray();
        HashSet<Character> hashSet =new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            hashSet.add(ch[i]);
        }
        int count=0;
        for (int i = 0; i < du.length; i++) {
            if(hashSet.contains(du[i])){
                count++;
            }
        }
        if(count==du.length) return "true";
        else return "false";
    }
}
