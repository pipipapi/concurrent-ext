package concurrent.memory;

/**
 * @ClassName chapter0101
 * @Description TODO
 * @Author daosheng.huang
 * @Date 2019/6/24 18:18
 * @Version 1.0
 */
public class chapter0101 {


    public static void main(String[] args) {
//        calc();
    }

    private long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }
    public static void calc() throws InterruptedException {
        final chapter0101 test = new chapter0101();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
    }
}

