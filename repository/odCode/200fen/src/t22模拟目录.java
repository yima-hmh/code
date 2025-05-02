import java.util.*;

class Sys{
    Sys par;//父目录
    String x;//当前目录名称
    Map<String,Sys>son;//子目录映射
    Sys(String x){
        this.par=null;//初始化父目录为null
        this.x=x;//设置当前目录名称
        this.son=new HashMap<>();
    }
    void pwd(){
        List<String> res = new ArrayList<>();//用于存储路径的列表
        Sys now=this;//从当前目录开始
        while (now.par!=null){
            //循环直到根目录
            res.add(now.x);//将当前目录名加入结果列表
            now=now.par;//向上移动到父目录
        }
        Collections.reverse(res);//反转列表以得到正确的路径顺序
        if(res.isEmpty()){
            //如果结果列表为空,表示在根目录
            System.out.println("/");
        }else {
            System.out.println("/"+String.join("/",res)+"/");//输出完整路径
        }
    }
    void addChild(String c){
        for (char x : c.toCharArray()) {
            if(x<'a'||x>'z'){
                //检查目录名称是否合法
                return;//如果不合法直接返回
            }
        }
        if(!son.containsKey(c)){
            Sys temp = new Sys(c);
            temp.par=this;
            son.put(c,temp);
        }
    }
    Sys getCd(String temp){
        if(temp.equals("..")){
            if(this.par!=null){
                return this.par;
            }
        }
        return son.getOrDefault(temp,this);//返回指定的子目录或当前目录
    }
}

public class t22模拟目录 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sys rt=new Sys("");
        String t="";
        while(scanner.hasNextLine()){
            //读取输入直到结束
            String inp = scanner.nextLine().trim();
            //如果命令是cd
            if(inp.startsWith("cd")){
                String[] parts = inp.split(" ");
                //检查命令格式是否合法
                if(parts.length!=2)continue;
                if(!inp.contains("/")){
                    //检查是否为简单目录名
                    rt= rt.getCd(parts[1]);//进入指定目录
                }
            }//如果命令是mkdir
            else if(inp.startsWith("mkdir")){
                String[] parts = inp.split(" ");
                if(parts.length!=2)continue;// 检查命令格式是否合法
                rt.addChild(parts[1]);//创建新目录
            }
            else if(inp.equals("pwd")){
                rt.pwd();
            }
            if(inp.equals("#"))
                break;
//          //更新最后一条命令
        }
        rt.pwd();
        scanner.close();
    }
}
