package com.company.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class HttpsUtil {
    /**
     * multipart/form-data 格式发送数据时各个部分分隔符的前缀,必须为 --
     */
    private static final String BOUNDARY_PREFIX = "--";
    /**
     * 回车换行,用于一行的结尾
     */
    private static final String LINE_END = "\r\n";

    /**
     * post 请求：以表单方式提交数据
     * <p>
     * 由于 multipart/form-data 不是 http 标准内容，而是属于扩展类型，
     * 因此需要自己构造数据结构，具体如下：
     * <p>
     * 1、首先，设置 Content-Type
     * <p>
     * Content-Type: multipart/form-data; boundary=${bound}
     * <p>
     * 其中${bound} 是一个占位符，代表我们规定的分割符，可以自己任意规定，
     * 但为了避免和正常文本重复了，尽量要使用复杂一点的内容
     * <p>
     * 2、设置主体内容
     * <p>
     * --${bound}
     * Content-Disposition: form-data; name="userName"
     * <p>
     * Andy
     * --${bound}
     * Content-Disposition: form-data; name="file"; filename="测试.excel"
     * Content-Type: application/octet-stream
     * <p>
     * 文件内容
     * --${bound}--
     * <p>
     * 其中${bound}是之前头信息中的分隔符，如果头信息中规定是123，那这里也要是123；
     * 可以很容易看到，这个请求提是多个相同部分组成的：
     * 每一部分都是以--加分隔符开始的，然后是该部分内容的描述信息，然后一个回车换行，然后是描述信息的具体内容；
     * 如果传送的内容是一个文件的话，那么还会包含文件名信息以及文件内容类型。
     * 上面第二部分是一个文件体的结构，最后以--分隔符--结尾，表示请求体结束
     *
     * @param urlStr      请求的url
     * @param keyValues   普通参数的键值对
     * @param headers
     * @return
     * @throws
     */
    public static HttpsResponse postFormData(String urlStr, Map<String, Object> keyValues, Map<String, Object> headers) throws Exception {
        HttpsResponse response;
        HttpURLConnection conn = getHttpURLConnection(urlStr, headers);
        //分隔符，可以任意设置，这里设置为 MyBoundary+ 时间戳（尽量复杂点，避免和正文重复）
        String boundary = "MyBoundary" + System.currentTimeMillis();
        //设置 Content-Type 为 multipart/form-data; boundary=${boundary}
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        //发送参数数据
        try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
            //发送普通参数
            if (keyValues != null && !keyValues.isEmpty()) {
                for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
                    writeSimpleFormField(boundary, out, entry);
                }
            }

            //写结尾的分隔符--${boundary}--,然后回车换行
            String endStr = BOUNDARY_PREFIX + boundary + BOUNDARY_PREFIX + LINE_END;
            out.write(endStr.getBytes());
        } catch (Exception e) {
            response = new HttpsResponse(500, e.getMessage());
            return response;
        }

        return getHttpResponse(conn);
    }

    /**
     * 获得连接对象
     *
     * @param urlStr
     * @param headers
     * @return
     * @throws
     */
    private static HttpURLConnection getHttpURLConnection(String urlStr, Map<String, Object> headers) throws Exception {

        // 创建SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL");
        TrustManager[] trustManagers = {new X509TrustManager() {
            /*
             * 实例化一个信任连接管理器
             * 空实现是所有的连接都能访问
             */
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        // 初始化
        sslContext.init(null, trustManagers, new SecureRandom());
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        URL url = new URL(urlStr);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setSSLSocketFactory(sslSocketFactory);
        //设置超时时间
        conn.setConnectTimeout(50000);
        conn.setReadTimeout(50000);
        //允许输入流
        conn.setDoInput(true);
        //允许输出流
        conn.setDoOutput(true);
        //不允许使用缓存
        conn.setUseCaches(false);
        //请求方式
        conn.setRequestMethod("POST");
        //设置编码 utf-8
        conn.setRequestProperty("Charset", "UTF-8");
        //设置为长连接
        conn.setRequestProperty("connection", "keep-alive");

        //设置其他自定义 headers
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                conn.setRequestProperty(header.getKey(), header.getValue().toString());
            }
        }

        return conn;
    }

    private static HttpsResponse getHttpResponse(HttpURLConnection conn) {
        HttpsResponse response;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            int responseCode = conn.getResponseCode();
            StringBuilder responseContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            response = new HttpsResponse(responseCode, responseContent.toString());
        } catch (Exception e) {
            response = new HttpsResponse(500, e.getMessage());
        }
        return response;
    }


    /**
     * 写普通的表单参数
     *
     * @param boundary 分隔符
     * @param out
     * @param entry    参数的键值对
     * @throws IOException
     */
    private static void writeSimpleFormField(String boundary, DataOutputStream out, Map.Entry<String, Object> entry) throws IOException {
        //写分隔符--${boundary}，并回车换行
        String boundaryStr = BOUNDARY_PREFIX + boundary + LINE_END;
        out.write(boundaryStr.getBytes());
        //写描述信息：Content-Disposition: form-data; name="参数名"，并两个回车换行
        String contentDispositionStr = String.format("Content-Disposition: form-data; name=\"%s\"", entry.getKey()) + LINE_END + LINE_END;
        out.write(contentDispositionStr.getBytes());
        //写具体内容：参数值，并回车换行
        String valueStr = entry.getValue().toString() + LINE_END;
        out.write(valueStr.getBytes());
    }

    public static void main(String[] args) throws Exception {
        //请求 url
        String url = "https://game.tencentads.com/leapi/List/GetActivity";

        // keyValues 保存普通参数
        Map<String, Object> keyValues = new HashMap<>();
        keyValues.put("currentPage", 1);
        keyValues.put("pageSize", 1);


        //headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("sign","afe3bd1dc4229dde75ded584b4946d38");
        headers.put("timestamp","1603867046004");
        headers.put("random","xUOof");

        HttpsResponse response = postFormData(url, keyValues, headers);
        System.out.println(response);

    }
}




/**
 * @author: sjt
 * @time: 2020/10/27 14:41
 * @since
 */
class HttpsResponse {
    private int code;
    private String content;

    public HttpsResponse(int status, String content) {
        this.code = status;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return new StringBuilder("[ code = ").append(code)
                .append(" , content = ").append(content).append(" ]").toString();
    }
}

