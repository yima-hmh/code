import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hj32_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(validLen(s));
        }
        br.close();
    }

    public static int validLen(String s) {
        int len = s.length();
        // 状态：对比的两个字符索引起始和终止索引位置
        // 定义: 字符串s的i到j字符组成的子串是否为回文子串
        boolean[][] dp = new boolean[len][len];
        int res = 1;

        // base case
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //自底向上迭代
        //r表示游标将从左到右遍历所有情况
        for(int r = 1; r < len; r++) {
            //dp[l][r]表示从l到r的之间是回文字符串
            for(int l = 0; l < r; l++) {
                // 状态转移：如果左右两字符相等,同时[l+1...r-1]范围内的字符是回文子串
                // 则 [l...r] 也是回文子串
                if(s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    // 不断更新最大长度
                    res = Math.max(res, r - l + 1);
                }
            }
        }
        return res;
    }
}
