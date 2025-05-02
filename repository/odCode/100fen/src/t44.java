import java.util.*;
import java.util.stream.Collectors;

//字符统计及重排
//个数多的排前面,个数相同的小写排前面,大写排后面

//这是一个精妙的循环语句题
public class t44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();//获得其字符串
        //进行字符统计
        //想想看,应该用什么东西来进行一个统计呢
        char[] chars = code.toCharArray();
        /*
        //me tring to use the hashmap to memorize the fucking char,don't do that
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hm.put(chars[i],hm.getOrDefault(chars[i],0)+1);
        }
        */
        int[] mp = new int[300];
        for (char ch : chars) {
            mp[ch]++;
        }

        while (true){
            //顶级的模拟顺序,每次选最大的,看下是不是小写,小写的话赋值给ch
            //否则是大写

            int mx=0;//记录当前出现次数最多的字符的次数
            Integer ch=null;//用于记录出现次数最多的字符
            //找到出现次数最多的字符,这里的i变成char就是对应的字符
            for (int i = 0; i < 300; i++) {
                if (mp[i]>mx){
                    mx=mp[i];
                }
            }
            if(mx==0){
                //mp中没有一个字符,这个时候也就退出结束循环了
                break;
            }

            // 先招小写,赋值给ch,按顺序排除
            for (int i = 'a'; i <='z' ; i++) {
                if(mp[i]==mx){
                    ch=(int)i;
                    break;
                }
            }

            //检查大写字母中有没有次数最高的
            if(ch==null){
                for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
                    if(mp[i]==mx){
                        ch=(int)i;
                        break;
                    }
                }
            }
            //输出

            System.out.print((char) ch.intValue()+":"+mx+";");
            mp[ch]=0;//将该字符出现次数清零,循环使用了属于是
        }


        //这样子的话,就在hm里面存了所有字符的大小
        //提取hm的entryset转化为list

        //me tring to use the shity stream method
      /*  List<Map.Entry<Character, Integer>> sortedEntries = hm.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Character, Integer> entry) -> entry.getValue(), Comparator.reverseOrder())
                        .thenComparing(entry -> Character.isLowerCase(entry.getKey()) ? entry.getKey() : Character.toUpperCase(entry.getKey()),
                                Comparator.reverseOrder()))
                .collect(Collectors.toList());
        //借助list的方法对数据进行排序
        sortedEntries.forEach(entry-> System.out.print(entry.getKey()+":"+entry.getValue()+" "));
    */

    }
}
