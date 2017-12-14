package com.lanou3g.function.weather;

import java.net.*;
import java.io.*;

public class Weather {
    public static void main(String args[]) throws Exception {
        URL url = new URL("http://api.k780.com/?app=weather.future&weaid=1&appkey=APPKEY&sign=SIGN&format=json");
        URLConnection coon = url.openConnection();
        InputStream is = coon.getInputStream();
        byte[] buff = new byte[1024 * 1024];
        int len = is.read(buff);
        String result = new String(buff, 0, len);
        System.out.println(result);


    }
}