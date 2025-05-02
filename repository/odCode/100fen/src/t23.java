import java.util.Scanner;

//简单压缩算法
public class t23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        //排除有特殊字符的情况
        if(!isValid(code)){
            System.out.println("!error");
            return;
        }
        String decode = Decode(code);//有多少数字就变成多少个字母
        String encode = Encode(decode);//正确加密

        //排除数字为2也压缩的情况:正确加密情况下的字符串是否与原code相同,不同说明code有错
        //5b7dds8ssd7p这种情况也是一开始就给错了code,不可能是这样的
        if(!encode.equals(code)){
            System.out.println("!error");
            return;
        }
        System.out.println(decode);
    }
    /*//判断是否正常,不行,有个2在这,想别的办法
    static boolean isValid(String code){
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]<'a'||chars[i]>'z'){
                //数字3-9是允许的
                if(chars[i]>='1'&&chars[i]<='9'){
                    //直接获取该数字,如果是0或者1或者2
                }
            }
        }
    }*/
    static boolean isValid(String code) {
        char[] chars = code.toCharArray();
        for (char c : chars) {
            if(!Character.isDigit(c)&&!Character.isLowerCase(c))
                return false;
        }
        return true;
    }

    //解密:自己猛干干出来,帅死谁了
    static String Decode(String code){
        char[] chars = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<chars.length)
        {
            //如果是数字字符
            if(Character.isDigit(chars[i])){
                int now=chars[i]-'0';
                i++;
             //获取整个数字
             while (Character.isDigit(chars[i])){
                 now*=10;
                 now+=(chars[i]-'0');
                 i++;
             }
             //变成后面那么多的字符加进去
                for (int i1 = 0; i1 < now; i1++) {
                    sb.append(chars[i]);
                }
                i++;//跳过这个字符
                continue;//跳过后面的添加字符
            }
            //如果是字符
            sb.append(chars[i]);
            i++;
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }


    //加密,输入的都是小写字符串,大于2的缩写
    //来,来,来,我们来开发压缩代码!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    static String Encode(String code){
        char[] chars = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=1;//指针

        //只要遍历完整个数组即可
        while(i<=chars.length){
            int count=1;
            //如果后面的跟目前这个相同,他妈的直接进入杀神领域
            //这里也启用了避免数组越界的问题:从后往前i-1
            //一边调试一边确定数组越界出现在哪里
            if(i<chars.length&&chars[i-1]==chars[i]){
                int temp=i;
                //统计一下count的大小
                while (i<chars.length&&chars[i-1]==chars[i]){
                    count++;
                    i++;
                }
                if(count>2){
                    sb.append(count);
                    sb.append(chars[i-1]);
                    i++;//后一个比前一个,所以佳佳
                    continue;
                }
                else i=temp;
            }
            sb.append(chars[i-1]);
            i++;
        }
        return sb.toString();
    }
}
