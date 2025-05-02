public class hannoi {
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int n = 100; // Number of disks
        hanoi(n, 'A', 'C', 'B'); // A: source, C: target, B: auxiliary
    }
}