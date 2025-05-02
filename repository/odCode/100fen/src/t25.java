import java.util.ArrayList;
import java.util.Scanner;

//考勤信息
public class t25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(work(list.get(i))+" ");
        }
    }

    static int get(String str) {
        //缺勤0,迟到早退2,正常上班3
        if (str.charAt(1) == 'b') {
            return 0;
        } else if (str.charAt(1) == 'a' || str.charAt(1) == 'e') {
            return 1;
        } else return 2;//正常上班
    }

    static String work(String record) {
        int queqin = 0;

        //将字符串信息转化成数字
        String[] s = record.split(" ");
        int n = s.length;
        int[] info = new int[n];
        for (int i = 0; i < n; i++) {
            info[i] = get(s[i]);
            if (info[i] == 0) {
                queqin++;
            }
        }

        //缺勤超过一次
        if (queqin > 1) {
            return "false";
        }

        //迟到/早退没有连续
        for (int i = 1; i < n; i++) {
            if (info[i] == info[i - 1] && info[i] == 1) {
                return "false";
            }
        }

        //任意连续7次考勤,缺勤/迟到/早退不超过3次
        int zhengchang = 0;
        for (int i = 0; i < n - 7; i++) {
            zhengchang=0;
            for (int j = i; j <i+7; j++) {
                if (info[j] == 3) {
                    zhengchang++;
                }
            }
            //异常不超过3次,正常的天数多于等于4天
            if(zhengchang<4){
                return "false";
            }
        }

        return "true";
    }
}
