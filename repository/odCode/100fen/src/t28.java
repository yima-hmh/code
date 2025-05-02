import java.util.ArrayList;
import java.util.Scanner;

//敏感字段加密
public class t28 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();

            //标志变量,用于标志是否处于双引号内
            boolean f = false;

            //---------------------------------------------我操
            //用于存储处理后的字符串版本,双引号内的下划线会被替换为'!'
            String str = "";
            //遍历输入的命令字符串s
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (!f) {//不在在双引号内
                    str += x;//即使是双引号也要加到字符串中
                    if (x == '"') {
                        f = true;
                    }
                } else {
                    //处于双引号内
                    if (x == '"')//如果碰到了结束的双引号,就置为false,怀疑了?看第34行,注意if else逻辑啊,小笨蛋
                        f = false;
                    if (x == '_')//将双引号替换为'!'
                        str += "!";
                    else
                        str += x;//添加字符到str,保证了最后一个双引号也会添加到str中
                }
            }



            //现在可以根据下划线分割处理过的字符串了
            String[] arr = str.split("_");

            //存储去出去空命令字后的结果
            ArrayList<String> res = new ArrayList<>();
            for (String i : arr) {
                //添加非空的命令字到结果集中
                if (!i.isEmpty()) {
                    res.add(i);
                }
            }

            //检查索引k是否合法,如果不合法则输出error
            res.set(k, "******");
            //标志变量,用于控制输出时是否添加下划线
            f = false;
            for (String i : res) {
                if (f)
                    System.out.print("_");
                f = true;
                System.out.print(i.replaceAll("!", "_"));
            }
        }catch (Exception e){
            System.out.println("ERROR");
        }

    }
}
