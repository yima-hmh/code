import java.util.Scanner; // 导入Scanner类用于读取用户输入
/*
其实挺简单的
遍历整个字符串
1.根据00判断是否判断终点
2.如果里面遇到了连续两个1就记录下来
3.只要没有连续两个1,又没有连续的两个0,说明一定是0101010交替的,获得其长度
4.获取所有符合条件的方波,得到其最大长度
5.根据最大长度来生成01010字符串即可,而不是一定要在原来的地方截取.非要截取也许,那就得记录一下序列号咯,比较麻烦
 */
public class t20_kimi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象读取用户输入
        String s = scanner.nextLine(); // 读取用户输入的一行字符串 s

        // 去除字符串两端的空白字符
        s = s.trim();

        // 获取字符串 s 的长度
        int n = s.length();

        // 初始化最大长度为 0
        int MaxLen = 0;

        // 遍历字符串的每一个字符
        for (int i = 0; i < n; i++) {
            // 初始化标志位 flag，用于标识是否遇到连续的 "11"
            int flag = 0;

            // 如果当前字符是 '0'
            if (s.charAt(i) == '0') {
                int j = i + 1; // 设置 j 为 i 的下一个位置

                // 向后遍历字符串，寻找最长的符合条件的子串
                while (j < n) {
                    // 如果连续遇到两个 '0'，则退出循环，因为此时子串不符合要求
                    if (s.charAt(j) == '0' && s.charAt(j - 1) == '0') {
                        break;
                    }

                    // 如果连续遇到两个 '1'，则设置标志位 flag 为 1
                    if (s.charAt(j) == '1' && s.charAt(j - 1) == '1') {
                        flag = 1;
                    }

                    j++; // 继续向后遍历
                }

                // 如果找到的子串长度大于等于 3 且未遇到连续的 "11"
                if (j - i >= 3 && flag == 0) {
                    // 更新最大长度 MaxLen
                    if (MaxLen < (j - i)) {
                        MaxLen = j - i;
                    }
                }

                // 将 i 移动到子串的最后一个位置,因为要配合待会的i++
                i = j - 1;
            }
        }

        // 如果没有找到符合条件的子串，输出 -1
        if (MaxLen == 0) {
            System.out.println("-1");
            return;
        }

        // 构建符合条件的最长子串
        //我操,原来是根据长度直接生成,而不是截取,麻痹的这有点高级啊
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < MaxLen; i++) {
            // 按照 "010101..." 的模式生成子串
            if (i % 2 == 0) {
                ans.append('0');
            } else {
                ans.append('1');
            }
        }

        // 输出结果
        System.out.println(ans.toString());

        scanner.close(); // 关闭Scanner对象
    }
}