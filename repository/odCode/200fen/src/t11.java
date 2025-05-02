import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//项目排期
//最少时间交付
//贪心算法 + 排序
//将任务按照工作量从大到小排序：这样我们可以优先分配重的任务给开发人员。
//将开发人员视为从1到N的序列。
//为每个任务分配开发人员：为每个任务分配一个开发人员，优先分配给编号最小的开发人员，如果该开发人员已经被分配了任务，则尝试下一个编号的开发人员。
public class t11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int length = split.length;
        Integer[] arr = new Integer[length];

        for (int i = 0; i < length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }

        int n = scanner.nextInt();//员工数量
        scanner.close();
        Arrays.sort(arr,Comparator.reverseOrder());//逆序使得重的任务在前
        int[] developers=new int[n];
        int maxTime=0;
        //寻找当前工作量最少的,将任务交给他,也就是他所需要完成的工作量增加
        for (Integer workload : arr) {
            int minIndex=finMinIndex(developers);
            developers[minIndex]+=workload;
            maxTime=Math.max(maxTime,developers[minIndex]);
        }
        System.out.println(maxTime);
    }

    private static int finMinIndex(int[]arrray){
        int index=0;
        for (int i = 1; i < arrray.length; i++) {
            if(arrray[i]<arrray[index]){
                index=i;
            }
        }
        return index;
    }
}
