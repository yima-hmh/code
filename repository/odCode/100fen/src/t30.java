import java.util.Scanner;

//判断一组不等式是否满足约束
/*
题目描述
给定一组 不等式 ，判断是否成立并输出不等式的最大差（输出浮点数的整数部分）
要求：
1. 不等式系数为double类型，是一个二维数组
2. 不等式的变量为int类型，是一维数组
3. 不等式的目标值为double类型，是一维数组
4. 不等式约束为字符串数组，只能是大于，大于等于，小于，小于等于，等于
例如：不等式组：
a11*x1+a12*x2+a13*x3+a14*x4+a15*x5<=b1;
a21*x1+a22*x2+a23*x3+a24*x4+a25*x5<=b2;
a31*x1+a32*x2+a33*x3+a34*x4+a35*x5<=b3;
类型为整数(输出 浮点数 的整数部分)
输入描述
1. 不等式组系数（double类型）
a11,a12,a13,a14,a15
a21,a22,a23,a24,a25
a31,a32,a33,a34,a35
2. 不等式变量（int类型）
x1,x2,x3,x4,x5
3. 不等式目标值（double类型）
b1,b2,b3
4. 不等式约束（字符串类型）
<=,<=,<=
输入:
a11,a12,a13,a14,a15;a21,a22,a23,a24,a25;a31,a32,a33,a34,a35;x1,x2,x3,x4,x5;b1,b2,b3;<=,<=,<=
输出描述
true或者false,最大差
 */
public class t30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //以";"划分各部分,得到各个部分
        String[] p = scanner.nextLine().split(";");
        int len = p.length;
        //得到约束条件的符号
        String[] ys = p[len - 1].split(",");
        int n = ys.length;

        //第一部分以,分割,得到变量的个数,同时也是系数的个数
        int m = p[0].split(",").length;
        //存储系数矩阵
        double[][] A = new double[n][m];
        for (int i = 0; i < n; i++) {
            //对n个部分用","分割,并且填入系数矩阵中
            String[] now = p[i].split(",");
            for (int j = 0; j < m; j++) {
                A[i][j] = Double.parseDouble(now[j]);
            }
        }
        //获取变量
        int[] X = new int[m];
        //读取变量的值
        String[] X_str = p[n].split(",");
        for (int i = 0; i < m; i++) {
            X[i] = Integer.parseInt(X_str[i]);
        }

        //存储右侧值
        double[] B = new double[m];
        String[] B_str = p[n + 1].split(",");
        for (int i = 0; i < n; i++) {
            B[i] = Double.parseDouble(B_str[i]);
        }

        //创建数组ans,用于存储每个约束条件的差值
        double[] ans = new double[n];
        int flag = 0;
        double MaxC = -1e18;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < m; j++) {
                //计算当前约束条件左侧的值
                sum += A[i][j] * X[j];
            }
            //判断当前约束条件是否满足,不满足的话,进入
            if (!judge(sum, B[i], state(ys[i]))) {
                flag = 1;
            }
            //计算差值并存入数组
            ans[i] = sum - B[i];
            MaxC = Math.max(ans[i], MaxC);
        }

        if (flag == 0) {
            System.out.print("true" + " ");
        } else System.out.print("false" + " ");
        System.out.println((int) MaxC);
    }

    //根据传入的字符串返回对应的状态码
    static int state(String s) {
        //>
        if (s.equals(">")) return 1;
            //>=
        else if (s.equals(">=")) return 2;
            //<
        else if (s.equals("<")) return 3;
            //<=
        else if (s.equals("<=")) return 4;
            //=
        else return 5;
    }

    //根据传入的a和b,以及符号,判断是否相等
    static boolean judge(double a, double b, int state) {
        if (state == 1) return a > b;
        else if (state == 2) return a >= b;
        else if (state == 3) return a < b;
        else if (state == 4) return a <= b;
        else return a == b;
    }
}
