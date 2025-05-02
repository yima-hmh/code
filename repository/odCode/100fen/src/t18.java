import java.util.ArrayList;
import java.util.Scanner;

//喊七的次数重排
//纯自己做的,帅死了
public class t18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //处理数据集合jobs
        String[] s = scanner.nextLine().split(" ");
        ArrayList<Integer> jobs = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            jobs.add(Integer.parseInt(s[i]));
        }

        //获取需要喊过的次数
        int guo=0;
        int totalPeople=jobs.size();
        for (int i = 0; i <totalPeople ; i++) {
            guo += jobs.get(i);
        }
        //遍历到count等于喊过的次数,返回答案,主打就是一个穷举
        int count=0;
        int num=1;//模拟从1开始函数
        int[] people = new int[totalPeople+1];//模拟人数组开始穷举,从1开始
        t18 fuck = new t18();
        while (count!=guo){
            if(fuck.ishanSeven(num)||fuck.isSevenPlus(num)){
                count++;
                //极致细心的一步
                if(num%totalPeople==0){
                    people[1]++;
                }else {
                    people[num%totalPeople]++;
                }
            }
            num++;
        }
        for (int i = 0; i <totalPeople ; i++) {
            System.out.print(people[i+1]+" ");
        }
    }

    //判断此数字是否含7
     boolean ishanSeven(int n){
        while (n!=0){
            if(n%10==7){
                return true;
            }
            n/=10;
        }
        return false;
    }
    //判断是否7的倍数
     boolean isSevenPlus(int n){
        if(n%7==0){
            return true;
        }
        return false;
    }
}
