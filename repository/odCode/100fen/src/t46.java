import java.util.Scanner;

//最小调整次数
//依次添加,从1到n,可以添加在头或者添加在尾,出来只能是头部出来
//这个题目只要是从尾巴进去的,出来时从头出来,都是对的,从头进来的,错,remove时需要移动,除非是其单独一个,一个以上都是需要移动的
//所以很明显要维护一个当前队列的大小,只有大小大于1时需要移动
public class t46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int byoreder=0;//当前队列中的数据是否按顺序排序,0表示是,大于0表示不是   ----------这里答案甚至都错了
        int res=0;//最小次数
        int sz=0;//当前队列中的数据数量
        //遍历2n次操作指令
        for (int i = 0; i < (n << 1); i++) {
            String[] op = scanner.nextLine().split(" ");
            //head add x
            if(op[0].equals("head")){
                if(sz>=1){
                    byoreder++;
                }
                sz+=1;
            }
            //指令是tail,从尾部进来的数据顺序是对的
            else if(op[0].equals("tail")){
                sz+=1;
            }
            //指令是remove
            else if(op[0].equals("remove")){
                //不按顺序进来的数据需要移动,也就是从头进来多少个,就要移动多少次
                if(byoreder>0){
                    byoreder--;
                    res++;
                }
                sz-=1;
            }
        }
        System.out.println(res);
    }
}
