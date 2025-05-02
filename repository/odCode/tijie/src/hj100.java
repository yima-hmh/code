import java.util.Scanner;

public class hj100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int shouxiang= 2;
        int moxiang=shouxiang+(n-1)*3;
        int res=((shouxiang+moxiang)*n)/2;

        System.out.println(res);
    }
}
