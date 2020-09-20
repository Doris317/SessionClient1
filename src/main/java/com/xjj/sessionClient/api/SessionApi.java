package com.xjj.sessionClient.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @ClassName: SessionApi
 * 请求行，请求头，请求体
 */
public interface SessionApi {
    @RequestLine("POST /nbi/deliverysession?id={DeliverySessionId}")
    @Headers("Content-Type: application/xml")
    @Body("{body}")
    void sessionTest(@Param("body") String body, @Param("DeliverySessionId") int id);
}
