package mibu;
import java.util.Scanner;

//分批萨,还是没搞懂这个dp
public class t1_dp {
    // 定义一个函数来计算吃货能获得的最大披萨大小总和
    public static int maxPizzaSum(int[] pizzaSizes) {
        int n = pizzaSizes.length; // 获取披萨块的数量
        int[][] dp = new int[n][n]; // 创建一个二维数组用于动态规划

        // 初始化 dp 数组，每块披萨单独考虑时的值
        for (int i = 0; i < n; i++) {
            dp[i][i] = pizzaSizes[i];
        }

        // 计算 dp 数组
        for (int length = 2; length <= n; length++) { // 从长度 2 开始计算
            for (int i = 0; i < n; i++) {
                int j = (i + length - 1) % n; // 计算环形数组中的结束位置

                // 选择开始或结束位置，计算最大值
                dp[i][j] = Math.max(
                        pizzaSizes[i] + Math.min(
                                dp[(i + 2) % n][j], // 吃货选择 i 后，馋嘴选择 (i+1)
                                dp[(i + 1) % n][(j - 1 + n) % n] // 吃货选择 i 后，馋嘴选择 j
                        ),
                        pizzaSizes[j] + Math.min(
                                dp[i][(j - 2 + n) % n], // 吃货选择 j 后，馋嘴选择 (j-1)
                                dp[(i + 1) % n][(j - 1 + n) % n] // 吃货选择 j 后，馋嘴选择 i
                        )
                );
            }
        }

        // 找到能得到的最大值
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i][(i - 1 + n) % n]);
        }

        return maxSum; // 返回最大值
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建扫描器对象
        int n = scanner.nextInt(); // 读取披萨块数量
        int[] pizzaSizes = new int[n]; // 创建数组存储披萨块大小
        for (int i = 0; i < n; i++) {
            pizzaSizes[i] = scanner.nextInt(); // 读取每块披萨的大小
        }
        System.out.println(maxPizzaSum(pizzaSizes)); // 输出结果
        scanner.close();
    }
}