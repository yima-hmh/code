import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
//单词接龙
public class t9_dancijielong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index=scanner.nextInt();
        int dancis_size= scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < dancis_size; i++) {
            words.add(scanner.nextLine());
        }


        //创建一个链表数组,并且初始化
        LinkedList<String>[] dq = new LinkedList[505];
        for (int i = 0; i < 505; i++) {
            dq[i]=new LinkedList<String>();
        }

        //创建答案
        ArrayList<String> res = new ArrayList<>();
        String remove = words.remove(index);
        res.add(remove);

        //将首字母相同的放进相同位置的链表中
        for (String word : words) {
            dq[word.charAt(0)].add(word);
        }

        //长度排序,长度相同根据字典排序
        for (int i = 0; i < 505; i++) {
            dq[i].sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()!=o2.length()){
                        return o2.length()-o1.length();
                    }
                    return o1.compareTo(o2);
                }
            });
        }



        //开始处理真正的逻辑,也就是排序
        while (true){
            int size = res.size();
            String now = res.get(size - 1);
//            System.out.println(now);
            //获取now最后一个字符
            int c= now.charAt(now.length() - 1);
            if(dq[c].isEmpty()){
                break;
            }
            res.add(dq[c].removeFirst());
        }
        String join = String.join("", res);
        System.out.println(join);
    }

}
