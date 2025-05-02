import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
//猜字谜
public class t7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mimians=scanner.nextLine().split(",");
        String[] midis=scanner.nextLine().split(",");
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();

        //处理谜面
        for (String mimian : mimians) {
            hs.add(convert(mimian));
        }
        //处理谜底
        for (String midi : midis) {
            //如果hs里面有跟谜底一样的字符串,加入到结果中,而且也是有序的
            if(hs.contains(convert(midi))){
                res.add(midi);
            }
        }
        //输出结果
        if(res.size()==0){
            System.out.println("not found");
        }else {
            for (int i = 0; i < res.size(); i++) {
                if(i!=res.size()-1){
                    System.out.print(res.get(i)+",");
                }else System.out.println(res.get(i));
            }
        }
    }

    //获取字符串
    static String convert(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        //将chars从小到大排序,然后再返回
        Arrays.sort(chars);
        sb.append(chars[0]);
        //去除重复字符
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]!=chars[i-1]) {
                sb.append(chars[i]);
            }
        }
                /*
               //
                if(chars[i]!=chars[i-1]){
                sb.append(chars[i]);
                }
            */
        return sb.toString();
    }

}
