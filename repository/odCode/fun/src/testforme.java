import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class testforme {
    public static void main1(String[] args) throws IOException {
        test4();
    }

    static void test1() {
        for (int j = 0; j < 10000; j++) {
            System.out.println(j);
        }
    }

    static void win() throws IOException {
        try {
            // 执行Windows命令，例如打开命令提示符
            String command = "cmd.exe";
            Process process = Runtime.getRuntime().exec(command);

            // 读取命令行输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待命令执行完成
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
       /* try {
            String url = "https://www.busfan.help/forum/forum.php?mod=viewthread&tid=144906"; // 你想要浏览的网页地址

            // Chrome 浏览器的可执行文件通常安装在以下路径
            String command = "cmd.exe /c start \"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" " + url;

            // 在Windows中打开Chrome浏览器
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        test4();
    }
    static void test2(){
        char[]fuck=new char['z'];
        System.out.println(fuck.length);
        for (int i = 0; i < fuck.length; i++) {
            System.out.println(fuck[i]=='\u0000');
        }
    }
    static void test3(){
        int[][] arr = new int[3][4];
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
    static void test4(){
        ArrayList<String> res = new ArrayList<>();
        res.add("ac");
        res.add("f");
        res.add("ab");
        res.sort(Comparator.naturalOrder());
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }

}
