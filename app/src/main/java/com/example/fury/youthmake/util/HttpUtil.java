package com.example.fury.youthmake.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by flt on 2015/6/1.
 */
public class HttpUtil {

    public static final String BASE_URL="http://192.168.191.1:8080/youth_make/";

    public static HttpGet getHttpGet(String url){
        HttpGet request = new HttpGet(url);
        return request;
    }

    public static HttpPost getHttpPost(String url){
        HttpPost request = new HttpPost(url);
        return request;
    }

    public static HttpResponse getHttpResponse(HttpGet request) throws ClientProtocolException, IOException{
        HttpResponse response = new DefaultHttpClient().execute(request);
        return response;
    }

    public static HttpResponse getHttpResponse(HttpPost request) throws ClientProtocolException, IOException{
        HttpResponse response = new DefaultHttpClient().execute(request);
        return response;
    }


    public static String getHttpPostResultForUrl(String url){
        System.out.println("url==="+url);
        HttpPost httpPost = getHttpPost(url);
        String resultString = null;

        try {
            HttpResponse response = getHttpResponse(httpPost);

            if(response.getStatusLine().getStatusCode() == 200)
                resultString = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            resultString = "exception";
            e.printStackTrace();
        } catch (IOException e) {
            resultString = "exception";
            e.printStackTrace();
        }

        return resultString;
    }


    public static String getHttpPostResultForRequest(HttpPost httpPost){
        String resultString = null;

        try {
            HttpResponse response = getHttpResponse(httpPost);

            if(response.getStatusLine().getStatusCode() == 200)
                resultString = EntityUtils.toString(response.getEntity());

        } catch (ClientProtocolException e) {
            resultString = "exception";
            e.printStackTrace();
        } catch (IOException e) {
            resultString = "exception";
            e.printStackTrace();
        }

        return resultString;
    }


    public static String getHttpGetResultForUrl(String url){

        HttpGet httpGet = getHttpGet(url);
        String resultString = null;

        try {
            HttpResponse response = getHttpResponse(httpGet);
            if(response.getStatusLine().getStatusCode() == 200)
                resultString = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            resultString = "exception";
            e.printStackTrace();
        } catch (IOException e) {
            resultString = "exception";
            e.printStackTrace();
        }

        return resultString;
    }


    public static String getHttpGetResultForRequest(HttpGet httpGet){
        String resultString = null;
        try {
            HttpResponse response = getHttpResponse(httpGet);
            if(response.getStatusLine().getStatusCode() == 200)
                resultString = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            resultString = "exception";
            e.printStackTrace();
        } catch (IOException e) {
            resultString = "exception";
            e.printStackTrace();
        }

        return resultString;
    }
}
