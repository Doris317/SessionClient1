package com.xjj.sessionClient.util;

import feign.Request;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName: Slf4jLogger
 * 进行日志输出的配置
 */
public class LoggerUtil extends feign.Logger {

    private final Logger logger;

    public LoggerUtil() {
        this(feign.Logger.class);
    }

    public LoggerUtil(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    public LoggerUtil(String name) {
        this(LoggerFactory.getLogger(name));
    }

    public LoggerUtil(Logger logger) {
        this.logger = logger;
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logger.isDebugEnabled()) {
            super.logRequest(configKey, logLevel, request);
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey,
                                              Level logLevel,
                                              Response response,
                                              long elapsedTime)
            throws IOException {
        if (logger.isDebugEnabled()) {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(methodTag(configKey) + format, args));
        }
    }
}
