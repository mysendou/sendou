package com.aug.lakana.newmedia.sitesearch;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class Demo {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = new HttpClient();
        HttpMethod httpget = new GetMethod("http://www.google.com/cse");
        httpget.setQueryString("cx=008384073847112824709:6b1gok1cv5g&client=google-csbe&output=xml_no_dtd&q=%E5%9C%A3%E8%AF%9E+more:PageMap:Site+more:PageMap:Story&start=0&num=9&hl=en&as_dt=i&as_sitesearch=me.nextmedia.com");
        System.out.println("The responces Status: "+httpClient.executeMethod(httpget));
        if (httpClient.executeMethod(httpget) == HttpStatus.SC_OK) {
            System.out.println("The response data: " + httpget.getResponseBodyAsString());
        }
        System.out.println("End Test");
    }
}
