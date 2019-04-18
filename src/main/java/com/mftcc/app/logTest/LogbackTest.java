package com.mftcc.app.logTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LogbackTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Thread thread = new LogThread();
        thread.start();

    }

}

class LogThread extends Thread{
   private static Logger logger = LoggerFactory.getLogger(LogThread.class);
    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(1000);
                logger.info("我打印了日志文件，当前时间是："+new Date());

            }


        }catch (Exception e) {
            logger.error("错误");
        }

    }
}
