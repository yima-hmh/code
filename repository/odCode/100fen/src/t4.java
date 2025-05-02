import java.util.Scanner;

//报文最小响应时间
public class t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取查询报文的个数
        int n = scanner.nextInt();
        scanner.nextLine();
        //现在是要找最小的报文响应时间,最值问题你懂的
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            //读取报文的时间T和最大响应时间字段值
            int T = scanner.nextInt();
            int M = scanner.nextInt();
            //计算实际最大响应时间
            int maxResTime = cal(M);
            //更新最小的响应时间
            res = Math.min(res, T + maxResTime);
        }
        System.out.println(res);
    }

    static int cal(int m) {
        if (m < 128) {
            return m;
        } else {
            //取exp的值,先取其高5-7位,用或运算,再移动4位就变成数了
            int exp = (m & 0b01110000) >> 4;
            //取低4位
            int mant = m & 0b1111;
            //加一个第五位 0x表示十六进制
            int base = mant | 0x10;
            //按题目要求做
            int shift = exp + 3;
            return base << shift;
        }
    }
}
