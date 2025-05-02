import java.util.*;
//手机防沉迷系统
/*
题目描述
智能手机方便了我们生活的同时，也侵占了我们不少的时间。
“手机App防沉迷系统”能够让我们每天合理的规划手机App使用时间，在正确的时间做正确的事。它的大概原理是这样的:
1、在一天24小时内，可注册每个App的允许使用时段;
00:00 ______App1_________App2________________App3__________ 24:00
2、一个时段只能使用一个App，举例说明:不能同时在09:00-10:00注册App2和App3;
00:00 ___________________App3______________________________ 24:00
00:00 ______App1_________App2______________________________ 24:00
3、App有优先级，数值越高，优先级越高。注册使用时段时，如果高优先级的App时间和低优先级的时段有冲突，则系统会自动注销低优先级的时段;如果App的优先级相
同，则后添加的 App不能注册。举例1:
(1)注册App3前:
00:00 ______App1_________App2优先级：1______________________ 24:00
(2)App3注册时段和App2有冲突:
___App3___
00:00 ______App1_________App2优先级：1______________________ 24:00
(3)App3优先级高，系统接受App3的注册，自动注销App2的注册:
00:00 ______App1___________App3优先级：3_____________________ 24:00
举例2:
(1)注册App4:
______App4优先级2________
00:00 ______App1_______App2优先级：1_____App3优先级：2_______ 24:00
(2)App4和App2及App3都有冲突，优先级比App2高，但比 App3低，这种场景下App4注册不上，最终的注册效果如下:
00:00 ______App1_________App2优先级：1_______App3优先级：2___ 24:00
4、一个App可以在一天内注册多个时段。
00:00 ______App1_______App3优先级：2_______App1______________ 24:00
请编程实现，根据输入数据注册App，并根据输入的时间点，返回该时间点可用的App名称，如果该时间点没有注册任何App，请返回 字符串 "NA"。
输入描述
输入分3部分:
第一行表示注册的App数N(N≤100);
第二部分包括N行，每行表示一条App注册数据;
最后一行输入一个时间点，程序即返回该时间点的可用App。
2
App1 1 09:00 10:00
App2 2 11:00 11:30
09:30
数据说明如下:
1、N行注册数据以空格分隔，四项数据依次表示:App名称、优先级、起始时间、结束时间
2、优先级1-5，数字值越大，优先级越高
3、 时间格式 HH:MM，小时和分钟都是两位，不足两位前面补0
4、起始时间需小于结束时间，否则注册不上
5、注册信息中的时间段包含起始时间点，不包含结束时间点
输出描述
输出一个字符串，表示App名称，或NA表示空闲时间。
补充说明
1、用例保证时间都介于00:00-24:00之间;
2、用例保证 数据格式 都是正确的，不用考虑数据输入行数不够、注册信息不完整、字符串非法、优先级超限、时间格式不正确的问题。
示例1
输入
1
App1 1 09:00 10:00
09:30
输出
App1
说明
App1注册在9点到10点间，9点半可用的应用名是App1
示例2
输入
2
App1 1 09:00 10:00
App2 2 09:10 09:30
09:20
输出
App2
说明
App1和App2的时段有冲突，App2的优先级比App1高，注册App2后，系统将App1的注册信息自动注销后，09:20时刻可用应用名是 App2.
示例3
输入
2
App1 1 09:00 10:00
App2 2 09:10 09:30
09:50
输出
NA
说明
App1被注销后，09:50时刻没有应用注册，因此输出NA。
 */
//自定义类
class Slot {
    String name;
    int index;

    Slot(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
public class t32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n表示注册的app数
        scanner.nextLine();

        Slot[] slots = new Slot[24 * 60];

        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot("NA", 0);
        }

        HashMap<Map.Entry<String, Integer>, Integer> priority = new HashMap<>();//存对应APP的顺序以及其对应的优先级的
        ArrayList<int[]> timeRange = new ArrayList<>(Collections.nCopies(n, new int[2]));//存开始和结束时间的

        //读取所有注册app的信息
        for (int i = 0; i < n; i++) {
            String app = scanner.next();
            int prio = scanner.nextInt();
            String start = scanner.next();
            String end = scanner.next();
            //正常处理数据,获取开始和结束的Time
            int startHour = Integer.parseInt(start.substring(0, 2));
            int startMinute = Integer.parseInt(start.substring(3, 5));
            int endHour = Integer.parseInt(end.substring(0, 2));
            int endMinute = Integer.parseInt(end.substring(3, 5));
            int startTime = startHour * 60 + startMinute;
            int endTime = endHour * 60 + endMinute;

            if (startTime >= endTime) continue;

            priority.put(new AbstractMap.SimpleEntry<>(app, i), prio);//将当前app的顺序和优先级按照注册顺序注入
            timeRange.set(i, new int[]{startTime, endTime});//每个APP的开始和结束时间按顺序注入

            //目前这一条是否有优先级冲突
            boolean conflict = true;//记录是否冲突,他妈的冲突得把冲突的都他妈
            Set<Integer> conflictingIndexs = new HashSet<>();
            for (int j = startTime; j < endTime; j++) {
                //如果这个时间有app已经注册在前的话,进入
                if (!slots[j].name.equals("NA")) {
                    //检查是否有优先级高于当前注册的App
                    if (priority.get(new AbstractMap.SimpleEntry<>(slots[j].name, slots[j].index)) >= prio) {
                        // 没有超过,不需要更改,也就是该条app数据无法插入
                        conflict = false;
                        break;//但凡有一个优先级比当前的app优先级大的,直接不能改变,下一套app数据
                    } else {
                        //当前优先级大于之前app的优先级,记录下所有不大于的记录,也就是需要打扫掉再注册新的
                        conflictingIndexs.add(slots[j].index);
                    }
                }
            }

            //1.时间段为空的,会进来
            //2.时间段不空的,但是有app优先级小于当前优先级的,会进来,然后打扫干净屋子再请客.
            if (conflict) {
                //需要清除掉低优先级APP的注册信息
                for (Integer idx : conflictingIndexs) {
                    int[] range = timeRange.get(idx);//获取其时间间隔
                    for (int j = range[0]; j < range[1]; j++) {
                        slots[j] = new Slot("NA", 0);
                    }
                }
                for (int j = startTime; j < endTime; j++) {
                    slots[j] = new Slot(app, i);//注册高优先级App
                }
            }
        }

        //读取查询时间
        scanner.nextLine();
        String queryTime = scanner.nextLine();
        int queryHour = Integer.parseInt(queryTime.substring(0, 2));
        int queryMin = Integer.parseInt(queryTime.substring(3, 5));
        int queryStart=queryHour*60+queryMin;
        System.out.println(slots[queryStart].name);
    }
}
