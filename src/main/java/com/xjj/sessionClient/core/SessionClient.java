package com.xjj.sessionClient.core;

import java.io.StringWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.xjj.sessionClient.App;
import com.xjj.sessionClient.api.SessionApi;
import com.xjj.sessionClient.util.JaxbWriteXmlUtil;
import com.xjj.sessionClient.util.LoggerUtil;
import org.apache.log4j.Logger;

import com.xjj.sessionClient.util.PropertiesUtil;

import feign.Feign;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * SessionClient
 */
public class SessionClient {
    int id;
    int time = 5;
    // 日志打印
    private static Logger logger = Logger.getLogger(SessionClient.class);
    PropertiesUtil propertiesUtil = new PropertiesUtil(App.class.getClassLoader()
            .getResourceAsStream("sessionClient.properties"));
    String url = propertiesUtil.get("url");

    public SessionClient(int id, int time) {
        this.id = id;
        this.time = time;
        try {
            start();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            logger.error(e.getStackTrace());
        }
    }

    private void start() throws JAXBException {
        post(ActionType.START);
        logger.info("session序号:" + id + " 已开始");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ExecutorService executorService = Executors.newCachedThreadPool();
                try {
                    executorService.submit(() -> {
                        try {
                            stop();
                        } catch (JAXBException e) {
                            logger.error(e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    logger.error(e.getMessage());
                } finally {
                    executorService.shutdown();
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, time * 1000);
    }

    private void stop() throws JAXBException {
        post(ActionType.STOP);
        logger.info(" id:" + id + "session已停止");
    }

    private void post(ActionType type) throws JAXBException {
        Marshaller marshaller = JaxbWriteXmlUtil.getMarshaller(DeliverySessionCreationType.class);
        DeliverySessionCreationType demo = new DeliverySessionCreationType();
        demo.setDeliverySessionId(id);
        demo.setAction(type);
        if (type == ActionType.START) {
            demo.setStartTime(System.currentTimeMillis());
        } else if (type == ActionType.STOP) {
            demo.setStopTime(System.currentTimeMillis());
        }
        final StringWriter stringWriter = new StringWriter();
        marshaller.marshal(demo, stringWriter);
        try {
            Feign.builder().logger(new LoggerUtil(SessionClient.class)).encoder(new JAXBEncoder(null))
                    .decoder(new JAXBDecoder(null)).target(SessionApi.class, url)
                    .sessionTest(stringWriter.toString(), id);
            logger.info("\nurl:" + url + " body:\n" + stringWriter.toString() + " 连接成功 ");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("\nurl:" + url + " body:\n" + stringWriter.toString() + " 连接失败 ");
        }
    }
}
