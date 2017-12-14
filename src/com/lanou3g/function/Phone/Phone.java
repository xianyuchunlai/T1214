package com.lanou3g.function.Phone;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Phone {
    static Scanner input = new Scanner(System.in);

   public static void main(String[] args) throws IOException{


  //public static void Phone( String phonenum) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+"15629058907"+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        URLConnection conn = url.openConnection();
        InputStream is = url.openStream();
        byte[] buff = new byte[1024*1024*1024*1024*1024*1024*1024*1024];

        int len = is.read(buff);
        String result = new String(buff, 0, len);
        System.out.println(result);

        JSONObject jsonObject = JSONObject.fromObject(result);
        p.ResultBean phone = (p.ResultBean)
                JSONObject.toBean(
                        jsonObject
                        ,p.class);

        System.out.println("地址"+phone.getAtt());

    }
}
