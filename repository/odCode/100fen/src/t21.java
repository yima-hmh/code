import java.util.Scanner;

//先构造三叉搜索树,再求其的高度
//做这道题的时候,我发现打飞机能让自己平静下来,遂打
public class t21 {
    //三叉搜索树
    static class ThreeNodeSearchTree{
        int val;
        ThreeNodeSearchTree left;//左子树
        ThreeNodeSearchTree mid;//中子树
        ThreeNodeSearchTree right;//右子树
        //构造方法
        ThreeNodeSearchTree(int v){
            this.val=v;
            left=null;
            mid =null;
            right=null;
        }
    }


    //构造树,会自动寻找插入的位置,空的话会自己创建
    static ThreeNodeSearchTree build(ThreeNodeSearchTree Node,int x){
        if(Node==null){
            return new ThreeNodeSearchTree(x);
        }
        //寻找插入的位置插入
        else if(x<(Node.val-500)){
            Node.left=build(Node.left,x);
        }
        else if(x>(Node.val+500)){
            Node.right=build(Node.right,x);
        }else {
            Node.mid=build(Node.mid,x);
        }
        return Node;
    }

    //返回树的高度
    static int dfs(ThreeNodeSearchTree root){
        //若结点为虚空,则返回高度为0
        if(root==null){
            return 0;
        }
        int le=dfs(root.left);
        int mi =dfs(root.mid);
        int ri=dfs(root.right);
        return 1+Math.max(le,Math.max(mi,ri));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//表示有N个数
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=scanner.nextInt();
        }
        ThreeNodeSearchTree root=null;
        for (int x : arr) {
            root=build(root,x);
        }
        System.out.println(dfs(root));//深度优先遍历三叉树,返回起高度
    }




}
