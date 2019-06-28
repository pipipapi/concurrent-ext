package concurrent.memory;

/**
 * @ClassName chapter01
 * @Description TODO
 * @Author daosheng.huang
 * @Date 2019/6/24 16:21
 * @Version 1.0
 */
public class chapter01 {

    static int  value=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            add();
        });
        Thread t2=new Thread(()->{
            add();
        });
        Thread t3=new Thread(()->{
            add();
        });
        t.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

//        t3.join();
//        t.join();
//        t2.join();

        t.start();
        t2.start();
        t3.start();

        System.out.println("等待5秒...");
        Thread.sleep(5000);

        System.out.println("value="+value);
    }

    static void add(){
        System.out.println("current-t:"+Thread.currentThread().getName());
        while (value<2000000){
            value += 1;
        }
    }

}
