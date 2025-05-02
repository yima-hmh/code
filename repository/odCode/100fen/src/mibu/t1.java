package mibu;

import java.util.Scanner;

//分披萨
/*
动态规划的问题:
明确状态
明确选择
明确data base
 */

//抄一遍
public class t1 {

    static int[] pizzaSlices;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSlices = scanner.nextInt();
        //读取每块披萨的大小
        pizzaSlices=new int[numberOfSlices];
        for (int i = 0; i < numberOfSlices; i++) {
            pizzaSlices[i]=scanner.nextInt();
        }
        long maxPizza=0;
        for (int i = 0; i < numberOfSlices; i++) {
            maxPizza=Math.max(maxPizza,recursive(geyPreviousIndex(i),geyNextIndex(i))+pizzaSlices[i]);
        }
        System.out.println(maxPizza);
        scanner.close();
    }
    //返回吃货在目前索引下能吃到的最多的东西
    //left和right不是表示之间,而是目前能给吃货做的两个选择
    static long recursive(int leftIndex,int rightIndex){
        //馋嘴永远吃剩下能吃的最大的,剩下的就要建立新索引了
        if(pizzaSlices[leftIndex]>pizzaSlices[rightIndex]){
            leftIndex=geyPreviousIndex(leftIndex);
        }else rightIndex=geyNextIndex(rightIndex);
        //吃货接下来能吃到的
            //还剩一块直接吃了
        if(rightIndex==leftIndex){
            return pizzaSlices[leftIndex];
            //还剩很多还需要筛选
        }else {
            //选择左或者选择右
            return Math.max(recursive(geyPreviousIndex(leftIndex),rightIndex)+pizzaSlices[leftIndex],
                            recursive(leftIndex,geyNextIndex(rightIndex))+pizzaSlices[rightIndex]);

        }
    }
    //循环数组,返回左边的index时,0的话返回数组大小,否则就是currentIndex-1
    static int geyPreviousIndex(int currentIndex){
        if(currentIndex<=0){
            return pizzaSlices.length-1;
        }
        else return currentIndex-1;
    }
    //循环数组,返回右边的index时,length-1的话返回0,否则+1
    static int geyNextIndex(int currentIndex){
        if(currentIndex==pizzaSlices.length-1){
            return 0;
        }
        else return currentIndex+1;
    }
}
