package com.zhangyan.myTest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhangyan
 * @Date: 2019/4/9 10:26
 * @Version 1.0
 */
public class TestDemo {

    static long tempcount = System.currentTimeMillis()/1000;// 用于计算每秒时间差
    static int prenum = 30;// 用于计算任务数量差
    static int nums = 30;// 总任务数
    static int res = 30;// 总任务数
    static int uses = 0;// 耗时 计数
    static long allstart = System.currentTimeMillis();
    static long logstime = 0;// 日志总耗时



    public static void main(String[] args) {
        int count = 2;//10万并发
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        int n=0;
        long now = System.nanoTime();

        while (!(res==0)) {
            for (int i = 0; i < count; i++) {
                executorService.execute(new TestDemo().new Task(cyclicBarrier, n));
                n++;
                res--;
            }
        }

        executorService.shutdown();
        //是否有进程在执行
        while (!executorService.isTerminated()) {
            try {
                //System.out.println("!!!!!!");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.nanoTime();
        double time=(end-now)/1000000000.0;
        System.out.println("All is finished!---------"+time+"s");
    }

    public class Task extends Thread implements Runnable {
        private CyclicBarrier cyclicBarrier;
        int n;

        public Task(CyclicBarrier cyclicBarrier,int n) {
            this.cyclicBarrier = cyclicBarrier;
            this.n=n;
        }

        @Override
        public void run() {
            try {
                // 等待所有任务准备就绪

                System.out.println(Thread.currentThread().getName()+"准备就绪");
                cyclicBarrier.await();
                System.out.println(System.currentTimeMillis()+"：开始线程"+Thread.currentThread().getName());
                //
                // 测试内容
                long  start=System.currentTimeMillis();
                task();
                long timeUse=(System.currentTimeMillis()-start);
                getCurrentThreads(timeUse);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {

            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);

            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    public static String sendJsonPost(String url,String data){
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("text/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);//关键一步
                response = EntityUtils
                        .toString(httpresponse.getEntity(),"utf-8");//加上utf-8参数防止中文乱码
                System.out.println(response);
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;


    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数!!
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void getCurrentThreads(long use){
        long start=System.currentTimeMillis();
        prenum=prenum-1;//任务数量，进度扣减
        uses+=use;


        long now = System.currentTimeMillis()/1000;
        if(now > tempcount){// 每秒输出一次
            long freeMemory=Runtime.getRuntime().freeMemory() / 1024 / 1024;//已使用内存
            long totalMemory=Runtime.getRuntime().totalMemory() / 1024 / 1024;//总共可使用内存
            int cpu = Runtime.getRuntime().availableProcessors();//可用cpu逻辑处理器

            System.out.printf("第%s秒: ", now-allstart/1000);
            int ts = (nums-prenum);//每秒事务数
            System.out.printf("每秒处理数:%s ", ts);
            System.out.printf("平均耗时:%s ", ts==0?0:uses/ts);
            System.out.printf("进度:%s ", nums);
            System.out.printf("剩余:%s毫秒 ", nums*ts);
            System.out.printf("可用内存:%sm ", freeMemory);
            System.out.printf("可用总内存:%sm \n", totalMemory);
            tempcount = now;
            nums = prenum;
            uses =0;
        }

        logstime += System.currentTimeMillis()-start;// 日志耗时累计

        // 当任务执行完了以后 计算总耗时
        if(prenum==0){
            long alluse = System.currentTimeMillis()-allstart;
            System.out.printf("总耗时%s毫秒,其中日志耗时%s毫秒\n",alluse,logstime);
            //System.exit(0);
        }
    }

        public void task(){
            //String s=TestDemo.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
            String s= TestDemo.sendGet("http://119.23.11.21:8890",null);
            System.out.println("===================="+Thread.currentThread().getName()+"内容返回"+"====================");
            System.out.println(s);
            System.out.println("====================================");
            //发送 POST 请求
            String sr=TestDemo.sendPost("http://119.23.11.21:8888/member/detail", "name=xiaozhang&appId=wolf&ip=172.18.1.12");
            System.out.println(sr);
        }




}
