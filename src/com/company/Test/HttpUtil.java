package com.company.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
    public static String httpDoPut(String requestUrl, String bodyStr) throws Exception {
        System.out.printf("--- http put 请求地址:%s 内容:%s", requestUrl, bodyStr);
        // 初始化

        URL url = new URL(requestUrl);
        HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

        // 以下参照http请求
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setConnectTimeout(20000);
        httpsURLConnection.setReadTimeout(300000);
        httpsURLConnection.setRequestProperty("Content-Type", "text/plain");
        httpsURLConnection.setRequestProperty("Content-Length", "text/plain");
        httpsURLConnection.setRequestMethod("PUT");
        httpsURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        httpsURLConnection.connect();

        // 读写内容
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer;
        try {
            if (null != bodyStr) {
                outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(bodyStr.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            if(httpsURLConnection.getResponseCode()>=400){
                inputStream = httpsURLConnection.getErrorStream();
            }else{
                inputStream = httpsURLConnection.getInputStream();
                Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
                Set<String> strings = headerFields.keySet();
                strings.stream().forEach(key->{
                    System.out.println(key);
                    System.out.println(httpsURLConnection.getHeaderField(key));
                });
            }
            streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(streamReader);
            stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (streamReader != null) {
                streamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        System.out.printf("--- http put 返回内容:%s", stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("15426541254");
        String s = httpDoPut("http://smspackagetest.woa.com/v1/package?rtx=v_xmjtsu&package_type=1&file_desc=%E8%8B%8F%E6%B1%9F%E6%B6%9B457-45%E9%83%BD%E6%98%AF%E5%87%8B",
                stringBuilder.toString());
        System.out.println(s);
    }
}
