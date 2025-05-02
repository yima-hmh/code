import java.util.*;

public class t19_chatgpt {
    public static void main(String[] args) {
        int seatNum = 10; // 假设会议室有10个座位
        int[] seatOrLeave = {1, 1, 1, 1, -4, 1}; // 员工的进出记录

        // 调用函数获取最后一个进入的员工所坐的位置
        int result = findLastEmployeeSeat(seatNum, seatOrLeave);

        // 打印结果
        System.out.println("最后进来员工坐在位置: " + result);
    }

    // ----------------------------------------------------------------------查找最后一个进入的员工所坐的座位
    public static int findLastEmployeeSeat(int seatNum, int[] seatOrLeave) {
        Set<Integer> occupiedSeats = new HashSet<>(); // 创建一个集合来跟踪已被占用的座位
        int lastSeated = -1; // 保存最后一个成功进入座位的编号，初值为-1表示无效

        // 遍历每个员工的进出记录
        for (int action : seatOrLeave) {
            if (action > 0) { // 如果动作是正数，表示有员工进入
                // 找到一个最大社交距离的可用座位
                int seatToOccupy = getMaxDistanceSeat(seatNum, occupiedSeats);

                if (seatToOccupy != -1) { // 确保找到了一个可用座位
                    occupiedSeats.add(seatToOccupy); // 将该座位标记为已占用
                    lastSeated = seatToOccupy; // 更新最后进入座位的编号
                }
            } else { // 如果动作是负数，表示有员工离开
                int seatToLeave = -action; // 获取离开的座位号（取绝对值）
                occupiedSeats.remove(seatToLeave); // 从已占用座位中移除该座位
            }
        }

        return lastSeated; // 返回最后一个成功进入的座位编号
    }


    //------------------------------------------------------------------------- 找到一个最远离其他已占用座位的可用座位
    private static int getMaxDistanceSeat(int seatNum, Set<Integer> occupiedSeats) {
        int maxDistance = -1; // 初始化最大距离为-1
        int bestSeat = -1; // 初始化最佳座位为-1

        // 遍历所有座位
        for (int i = 0; i < seatNum; i++) {
            if (occupiedSeats.contains(i)) { // 跳过已占用的座位
                continue;
            }

            //-------------------------------------------- 计算当前座位与所有被占用座位的最小距离
            int minDistance = Integer.MAX_VALUE; // 初始化最小距离为理论最大值

            for (int j : occupiedSeats) { // 遍历已有的占用座位
                int distance = Math.abs(i - j); // 计算当前座位i与占用座位j之间的距离
                minDistance = Math.min(minDistance, distance); // 更新最小距离
            }

            //-------------------------- 如果没有任何座位被占用，最小距离应视为最大
            if (occupiedSeats.isEmpty()) {
                minDistance = seatNum; // 当没有座位被占用时，设置为最大值
            }

            // --------------------------------------判断当前座位的最小距离是否大于之前记录的最大距离:一句话,取那些最小距离中最大的最小距离
            if (minDistance > maxDistance) {
                maxDistance = minDistance; // 更新最大距离
                bestSeat = i; // 更新最佳座位为当前座位
            } else if (minDistance == maxDistance && i < bestSeat) {
                bestSeat = i; // 如果距离相同，选择编号较小的座位
            }
        }

        return bestSeat; // 返回最佳座位编号
    }
}
