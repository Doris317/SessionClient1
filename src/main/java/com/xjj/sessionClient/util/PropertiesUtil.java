package com.xjj.sessionClient.util;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: ProportiesUtil
 */
public class PropertiesUtil {

    private static Logger logger = Logger.getLogger(PropertiesUtil.class);

    private Properties props;

    /**
     * 在构造函数中加载配置文件
     */
    public PropertiesUtil(InputStream inputStream) {
        try {
            props = new Properties();
            props.load(inputStream);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据key读取对应的value
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return props.getProperty(key);
    }
}
