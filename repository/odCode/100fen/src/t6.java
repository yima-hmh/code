import java.util.ArrayList;
import java.util.Scanner;

//猜数字
public class t6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        //获取所有人的推测以及提示结果
        ArrayList<String[]> chaices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            chaices.add(scanner.nextLine().split(" "));
        }

        //初始化全部的答案,后面就从这里面选就行了,这就是穷举法,后面跟猜测对比,提示相同的保留
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            results.add(i);
        }

        //遍历所有的猜测比较,遍历所有的答案,将提示结果一样的更新为结果
        for (String[] chaice : chaices) {
            //新的可能结果暂存集合
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer result : results) {
                if (getTishi(result, chaice[0]).equals(chaice[1])) {
                    temp.add(result);
                }
            }
            //不断更新新的result中,最后若只剩一个结果,那就是对的
            results = temp;
        }
        if (results.size() == 1) {
            System.out.println(results.get(0));
        } else System.out.println("NA");
    }

    //获取该答案和推测会得出的提示
    static String getTishi(int result, String chaice) {
        int x = 0;//数字正确且位置正确
        int y = 0;//数字正确但位置错误
        /*
        "%04d"：这是一个格式字符串，用于指定输出的格式。
                %：表示开始格式化的标记。
                0：表示如果数值的位数不足，用0来填充。
                4：表示总共需要的位数是4位。
                d：表示要格式化的数据类型是十进制整数。
         */
        String siwei = String.format("%04d", result);
        //0到9,待会记录数字正确但是位置错误的情况
        int[] shuzi1 = new int[10];
        int[] shuzi2 = new int[10];
        //获取这种情况下拿到的提示
        for (int i = 0; i < 4; i++) {
            //字符相等的话
            if (siwei.charAt(i) == chaice.charAt(i)) {
                x++;
            } else {
                //最关键也是最难的地方,不相等,但是记下来
                shuzi1[siwei.charAt(i) - '0']++;
                shuzi2[chaice.charAt(i) - '0']++;
            }
        }
        //计算数字正确但位置错误的情况
        //用这个算最小,如果最小是0,表示并没有数字正确,不会记上,如果最小都不是0,表示有相同的数字
        //只是位置错误
        for (int i = 0; i < 10; i++) {
            y += Math.min(shuzi1[i], shuzi2[i]);
        }

        return x + "A" + y + "B";
    }


}
