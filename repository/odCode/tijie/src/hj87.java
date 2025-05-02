import java.util.Scanner;

public class hj87 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        System.out.println(judge(code));
    }

    static String judge(String code){
        String codeText="";
        int sum=0;
        //密码长度的影响
        int length=code.length();
        if(length<=4){
            sum+=5;
        }else if(5<=length&&length<=7) {
            sum+=10;
        }
        else if(length>=8){
            sum+=25;
        }

        //遍历一遍,获取全部信息
        int daxie=0;
        int xiaoxie=0;
        int shuzi=0;
        char[] c = code.toCharArray();
        for (int i = 0; i < length; i++) {
            //大写
            if(c[i]>=65&&c[i]<=90){
                daxie++;
            }
            //小写
            else if(c[i]>=97&&c[i]<=122){
                xiaoxie++;
            }
            else if(c[i]>=48&&c[i]<=57){
                shuzi++;
            }
        }
        //大小写
        if(daxie!=0&&xiaoxie!=0){
            sum+=20;
        }else if(daxie!=0||xiaoxie!=0) {
            sum+=10;
        }

        //数字
        if(shuzi>1){
            sum+=20;
        }else if(shuzi==1){
            sum+=10;
        }

        //符号
        int fuhao=length-shuzi-daxie-xiaoxie;
        if(fuhao>1){
            sum+=25;
        }else if(fuhao==1){
            sum+=10;
        }

        //奖励
        if(fuhao!=0&&daxie!=0&&xiaoxie!=0&&shuzi!=0){
            sum+=5;
        }else if((fuhao!=0&&xiaoxie!=0&&shuzi!=0)||fuhao!=0&&daxie!=0&&shuzi!=0){
            sum+=3;
        }else if((xiaoxie!=0&&shuzi!=0)||(daxie!=0&&shuzi!=0)){
            sum+=2;
        }

        //评分
        if(sum>=90){
            codeText="VERY_SECURE";
        }else if(sum>=80){
            codeText="SECURE";
        }else if(sum>=70){
            codeText="VERY_STRONG";
        }else if(sum>=60){
            codeText="STRONG";
        }else if(sum>=50){
            codeText="AVERAGE";
        }else if(sum>=25){
            codeText="WEAK";
        }else if(sum>=0){
            codeText="VERY_WEAK";
        }
        return codeText;
    }
}
