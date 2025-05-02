import java.util.*;

//字母组合
public class t18字母组合 {
    static Map<Character, String> map = new HashMap<>();//存映射表
    static Set<Character> st = new HashSet<>();//存屏蔽字符
    static List<String> res = new ArrayList<>();//存结果

    static public void init() {
        map.put('0', "abc");
        map.put('1', "def");
        map.put('2', "ghi");
        map.put('3', "jkl");
        map.put('4', "mno");
        map.put('5', "pqr");
        map.put('6', "st");
        map.put('7', "uv");
        map.put('8', "wx");
        map.put('9', "yz");
    }

    //x是答案对应的长度,也是输出字符对应的长度,对应着n,然后s是code
    //dfs的作用是什么,根据x和now,以及目标长度n和对应的code(s),往res里面添加元素

    static public void dfs(int x, String now, int n, String s) {
        //递归终止条件:当拼接的字符串长度等于输入字符串长度时
        if (x == n) {
            //集合mk用于存储当前组合中出现的禁止字符
            Set<Object> mk = new HashSet<>();
            for (char c : now.toCharArray()) {
                if (st.contains(c)) {
                    mk.add(c);
                }
            }
            if (mk.size() == st.size()) {
                return;
            }
            res.add(now);
            return;
        }

        //获取当前数字对应的字母串
        String temp = map.get(s.charAt(x));
        for (char c : temp.toCharArray()) {
            dfs(x + 1, now + c, n, s);
        }
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();//数字对应
        String pingbi = scanner.nextLine();//屏蔽字符
        //将禁止字符存入set中
        for (int i = 0; i < pingbi.length(); i++) {
            st.add(pingbi.charAt(i));
        }
        dfs(0, "", code.length(), code);
        //输出结果
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.println();

    }
}
