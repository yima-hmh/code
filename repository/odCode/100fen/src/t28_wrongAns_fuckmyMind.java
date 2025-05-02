import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class t28_wrongAns_fuckmyMind {
    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine();
        String code = scanner.nextLine();
        String[] s = code.split("_");
        StringBuilder sb = new StringBuilder();



        //------------------------------------------------------------获取正常字符串
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("")) {
                continue;
            }
            //如果后面是引号,但是最后一个却不是引号
            if (i+1<s.length&&s[i].charAt(0) == '"' && s[i].charAt(s[i].length() - 1) != '"') {
                sb.append(s[i], 0, s[i].length()).append("_").append(s[i + 1], 0, s[i + 1].length()).append("_");
                i++;
                continue;
            }
            if(i<s.length-1){
                sb.append(s[i]).append("_");
            }else sb.append(s[i]);
        }
        String newCode = sb.toString();


        // 迅速计算能到的index范围
            int sum=1;
            for (int i = 0; i < newCode.length(); i++) {
                if(newCode.charAt(i)=='"'){
                    while (i<newCode.length()-1&&newCode.charAt(i+1)!='"'){
                        i++;
                    }
                    i++;
                }
                if(newCode.charAt(i)=='_'){
                    sum++;
                }
            }

            if(index>sum){
                System.out.println("ERROR");
                return;
            }

        //-------------------------------------------------------------------------------加密
            int count = 1;

            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < newCode.length(); i++) {

                //处理index==0的
                if (index == 0) {
                    sb2.append("******");
                    //跳过此字符不append
                    while (i < newCode.length()-1 && newCode.charAt(i+1) != '_') {
                        i++;
                    }
                    index=-1;//不要影响到后面了
                    continue;
                }


                //处理1开始的后面的
                if (newCode.charAt(i) == '_') {
                    sb2.append(newCode.charAt(i));
                    //如果是""的要以双引号为结尾
                    if (count == index&&newCode.charAt(i+1)=='"') {
                        sb2.append("******");
                        //跳过此字符不append
                        while (i < newCode.length() && newCode.charAt(i+2) != '"') {
                            i++;
                        }
                        i+=2;
                    }else if(count == index&&newCode.charAt(i+1)!='"'){
                        sb2.append("******_");
                        //跳过此字符不append
                        while (i < newCode.length() && newCode.charAt(i+1) != '_') {
                            i++;
                        }
                        i++;
                    } else if(count != index&&newCode.charAt(i+1)!='"'){
                        while (i < newCode.length() && newCode.charAt(i+1) != '_') {
                            i++;
                        }
                        i++;
                    }
                    count++;
                    continue;
                }


                sb2.append(newCode.charAt(i));
            }
            System.out.println(sb2.toString());
        }catch (Exception e){
            System.out.println("ERROR");
        }
    }
}
