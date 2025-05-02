import java.util.Scanner;

//so fucking easy
//工号不够用了怎么办
public class t15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people=scanner.nextInt();
        int zimuchangdu=scanner.nextInt();
        System.out.println(getZ(people,zimuchangdu));
    }
    static int getZ(int people,int zimichangdu){
        //数字的最短长度
        int res=0;
        int zimusum=1;
        int shuzisum=1;
        //首先要知道目前的字母长度能表示多少个人
        for (int i = 0; i < zimichangdu; i++) {
            zimusum*=26;
        }
        int temp=people/zimusum;
        while(shuzisum<temp){
            shuzisum*=10;
            res++;
        }
        if(res!=0){
            return res;
        }else return 1;
    }
}
