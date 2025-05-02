import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//整数对最小和
public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         //获取数,初始化
        int size1=scanner.nextInt();
        ArrayList<Integer> arr1=new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            arr1.add(scanner.nextInt());
        }

        int size2=scanner.nextInt();
        ArrayList<Integer> arr2=new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            arr2.add(scanner.nextInt());
        }
        int k= scanner.nextInt();
        System.out.println(getMinSum(arr1,arr2,k));
    }

    static int getMinSum(ArrayList arr1,ArrayList arr2,int k){
        int res=0;
        ArrayList<Integer> sum=new ArrayList<>();
        //遍历两个数组,存起其所有的加起来的结果,本来就是从小到大排序
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                  sum.add((int)arr1.get(i)+(int)arr2.get(j));
            }
        }
        sum.sort(Comparator.naturalOrder());
        for (int i = 0; i < k; i++) {
            res+=sum.get(i);
        }
        return res;
    }
}
