import java.util.*;
// 导入Java的util包，包含集合框架等工具类
/*
这道题为什么使用并查集,他妈的还用问,当然是因为好用啊
 */
public class 字符串化繁为简_kimi {
    public static int[] fa = new int[505]; // 并查集数组，用于存储每个字符的父节点

    // 并查集查找函数，带路径压缩
    public static int find(int x) {
        while ((fa[x]!=x)){
            fa[x]=fa[fa[x]];
            x=fa[x];//这一个不要忘记啊
        }
        return fa[x];
//        if (x == fa[x])
//            return x; // 如果x是自己的父节点，返回x
//        return fa[x] = find(fa[x]); // 否则递归查找x的根节点，并进行路径压缩
//
    }

    // 并查集合并函数，按秩合并
    public static void merge(int x, int y) {
        int f1 = find(x); // 找到x的根节点
        int f2 = find(y); // 找到y的根节点
        if (f1 > f2) { // 如果f1的秩大于f2的秩，则交换它们
            int temp = f1;
            f1 = f2;
            f2 = temp;
        }
        //f1是小的那一个字符,完成题目要求的"字典序"
        fa[f2] = f1; // 将f2的根节点设置为f1，完成合并
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象读取输入
        String s = scanner.nextLine(); // 读取一行输入

        for (int i = 0; i < 505; i++) {
            fa[i] = i; // 初始化每个元素为自身的父节点
        }


        List<List<Character>> arr = new ArrayList<>(); // 用于存储小括号中的字符组
        StringBuilder s2 = new StringBuilder(); // 输出字符串
        List<Character> same = new ArrayList<>(); // 暂存小括号内的字符
        boolean f = false; // 标记是否在小括号内

        // 遍历输入字符串，提取括号内外的字符
        for (char c : s.toCharArray()) {
            /*
            四种情况:
            1.读到左括号:进入括号f置true
            2.读到右括号:存储新的小括号内的字符组
            3.括号内字符:加入暂存数组
            4.括号外字符:加入输出字符串,待会处理
             */
            if (c == '(') {
                f = true; // 进入小括号
            } else if (c == ')') {
                if (!same.isEmpty()) {
                    arr.add(new ArrayList<>(same)); // 将括号中的字符组存入arr
                }
                f = false; // 退出小括号
                same.clear(); // 清空暂存字符组
            } else {
                if (f) {
                    same.add(c); // 在括号内，收集字符
                } else {
                    s2.append(c); // 非括号内，直接添加到输出字符串
                }
            }
        }

        Set<Integer> st = new HashSet<>(); // 用于去重所有字符,这个是用来做大小写连接的
        for (List<Character> i : arr) { // 将所有括号内的字符加入集合
            for (char j : i) {
                st.add((int) j);
            }
        }

        // 合并每组括号内的字符
        for (List<Character> i : arr) {
            for (int j = 0; j < i.size(); j++) {
                //在这个过程已经实现了不同组之间但凡有一个相同的元素就相互串联的效果了
                merge(i.get(0), i.get(j)); // 将每组字符合并到一起
            }
        }

        // 将大写字母和对应的小写字母合并
        for (int i = 'A'; i <= 'Z'; i++) {
            //如果没有该大写字母,跳过
            if (!st.contains(i))
                continue;
            //计算大写对应的小写字母
            int j = i - 'A' + 'a';
            //如果没有该小写字母,但是有该大写字母,没有不用合并,跳过
            if (!st.contains(j))
                continue;
            //有该大写,又有该小写,合并,将这个merge会按照字符集大小的顺序从大到小给你排序,设置的,确保最上面的父结点一定是按照ASCII码的顺序排序的
            merge(j, i);
        }

        StringBuilder res = new StringBuilder(); // 存储结果字符串
        for (char i : s2.toString().toCharArray()) {
            res.append((char) find(i)); // 替换为合并后的最小字典序字符
        }


        //输出处理
        if (res.length() == 0) { // 如果结果字符串为空，输出0
            System.out.println(0);
        } else {
            System.out.println(res.toString()); // 否则输出结果字符串
        }
    }
}