package com.xjj.sessionClient;

import org.apache.log4j.Logger;

import com.xjj.sessionClient.core.SessionClient;
import com.xjj.sessionClient.util.PropertiesUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        PropertiesUtil propertiesUtil = new PropertiesUtil(App.class.getClassLoader().getResourceAsStream("sessionClient.properties"));
        //   concurrency是为了动态调节并发数，所以存储在配置文件中
        int concurrency = Integer.parseInt(propertiesUtil.get("Concurrency"));
        int time = Integer.parseInt(propertiesUtil.get("time"));
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(concurrency);
        //  count是实际请求数
        int count = 100;
        for (int i = 0; i < count; i++) {
            final int id = i;
            fixedThreadPool.execute(() -> new SessionClient(id, time));
        }
        fixedThreadPool.shutdown();
    }
}
