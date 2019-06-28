package concurrent.memory.chapter01;

/**
 * @ClassName chapterVolatile
 * @Description TODO
 * @Author daosheng.huang
 * @Date 2019/6/24 18:18
 * @Version 1.0
 */
public class chapterVolatile {

    private static volatile long count = 0;


    public static void main(String[] args) throws InterruptedException {
        calc();
    }
    private void add10K() {
        while(count++ < 10000) {
            System.out.println("count="+count+",变为count="+(++count));
        }
    }
    public static void calc() throws InterruptedException {
        final chapterVolatile test = new chapterVolatile();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
        Thread th3 = new Thread(()->{
            test.add10K();
        });
//        Thread th4 = new Thread(()->{
//            test.add10K();
//        });
//        Thread th5 = new Thread(()->{
//            test.add10K();
//        });
        // 启动两个线程
        th1.start();
        th2.start();
        th3.start();
//        th4.start();
//        th5.start();
//        // 等待两个线程执行结束
//        th1.join();
//        th2.join();

        Thread.sleep(5000);

        System.out.println(count);
    }
}

