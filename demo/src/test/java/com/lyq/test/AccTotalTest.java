package com.lyq.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

/**
 * 余额测试
 * Created by 云强 on 2017/11/26.
 */
public class AccTotalTest {

    public static void addMoney() {
        String url = "http://localhost:8081/accTotal/update/1?money=100";
        post(url);
    }

    private static void post(String url) {
        try {
            Document document =  Jsoup.connect(url).ignoreContentType(true).get();
            String rvalue = document.text().toString();
            System.out.println(rvalue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMoney2() {
        String url = "http://localhost:8082/accTotal/update/1?money=100";
        post(url);
    }

}
