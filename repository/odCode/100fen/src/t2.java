import java.util.*;

//学生类
class Stu {
    String name;
    int[] scores;
    int totalScore;

    public Stu(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        this.totalScore= Arrays.stream(scores).sum();//计算总分
    }
}
//智能成绩表
//关键点在于创建一个学生对象,hashmap存科目
public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();//消耗换行符
//        System.out.println("1"+scanner.nextLine());
        //获取科目
        String[] kemu = scanner.nextLine().split(" ");
        HashMap<String, Integer> kemuIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            kemuIndex.put(kemu[i], i);
        }
//        System.out.println(kemu[0]);

        //获取学生信息
        ArrayList<Stu> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] part=scanner.nextLine().split(" ");
//            System.out.println(part[0]);
            String name=part[0];
            int[] scores=new int[m];
            for (int j = 0; j < m; j++) {
                scores[j]=Integer.parseInt(part[j+1]);
            }
            students.add(new Stu(name,scores));
        }

//        System.out.println("1"+scanner.nextLine());
        //获取最后条件的index
        String situation=scanner.nextLine();
        Integer index=kemuIndex.get(situation);

        if(index!=null){
            //按照指定科目排序
            students.sort(Comparator.comparingInt((Stu s)->s.scores[index]).reversed().thenComparing(s->s.name));
        }else {
            //按照总分排序
            students.sort(Comparator.comparingInt((Stu s)->s.totalScore).reversed().thenComparing( s->s.name));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(students.get(i).name+" ");
        }

    }
}
