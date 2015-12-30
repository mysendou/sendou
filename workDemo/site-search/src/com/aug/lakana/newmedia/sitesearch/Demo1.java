package com.aug.lakana.newmedia.sitesearch;

import org.apache.commons.httpclient.HttpClient;

public class Demo1 {
    /*
     * 1, 创建HttpClient对象
     * 2, 创建method对象 (get,post),并传入url
     * 3, 调用method.setQueryString 设置参数
     * 4, 调用httpClient.executeMethod(method)执行结果并返回状态
     * 5, 调用method.getResponce* 获取返回的结果。
     */
    public static void main(String[] args) {
        // 创建HttpClient对象
        HttpClient client = new HttpClient();
        
    }
}
