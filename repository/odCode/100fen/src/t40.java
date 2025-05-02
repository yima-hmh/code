import java.util.Arrays;
import java.util.Scanner;
/*
题目描述
给一个 二维数组 nums，对于每一个元素num[i]，找出距离最近的且值相等的元素，输出横纵坐标差值的绝对值之和，如果没有等值元素，则输出-1。
例如:
输入数组 nums为
0 3 5 4 2
2 5 7 8 3
2 5 4 2 4
对于 num[0][0] =0，不存在相等的值。
对于 num[0][1]= 3，存在一个相等的值，最近的坐标为num[1][4]，最小距离为4。
对于 num[0][2]=5，存在两个相等的值，最近的坐标为num[1][1]，故最小距离为2。
...
对于 num[1][1]=5，存在两个相等的值，最近的坐标为num[2][1]，故最小距离为1。
故输出为
-1 4 2 3 3
1 1 -1 -1 4
1 1 2 3 2
输入描述
输入第一行为二维数组的行
输入第二行为二维数组的列
输入的数字以空格隔开。
输出描述
数组形式返回所有 坐标值 。
补充说明
1.针对数组num[i][j]，满足0<i<=100;0<j<=100。
2.对于每个数字，最多存在100个与其相等的数字。
示例1
输入
3
5
0 3 5 4 2
2 5 7 8 3
2 5 4 2 4
输出
[[-1, 4, 2, 3, 3], [1, 1, -1, -1, 4], [1, 1, 2, 3, 2]]
（注意逗号后面是否有空格以实际题目为准，这里按有空格处理）
 */
//找数字
public class t40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] arr = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        int[][] result = new int[x][y];//结果数组

        //接下来就是暴力解了,遍历所有元素
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int res=-1;//接下来你将受罪
                //遍历二维数组的每一个值,寻找相等的元素
                for (int i1 = 0; i1 < x; i1++) {
                    for (int j1 = 0; j1 < y; j1++) {
                        if(i==i1&&j==j1) continue;
                        if(arr[i1][j1]==arr[i][j]){
                            //如果res没有更新过,那么就更新为当前值
                            int distance=Math.abs(i-i1)+Math.abs(j-j1);
                            if(res==-1){
                                res=distance;
                            }else res=Math.min(res,distance);
                        }
                    }
                }
                result[i][j]=res;
            }
        }
        //输出
        System.out.println(Arrays.deepToString(result));
    }

}
