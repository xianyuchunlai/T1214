package com.lanou3g.JavsSeTest;

import com.lanou3g.function.Phone.Phone;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final int WEATHER_CODE = 1;
    public static final int PHONE_CODE = 2;
    public static final int GAME_CODE = 3;

    public static void main(String[] args) throws IOException, DocumentException {

        UserOperate.register();
        UserOperate.login();
        System.out.println("1,查询天气" +
                "2,查询手机号归属"
                + "3,手速游戏");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case WEATHER_CODE:

            case PHONE_CODE:
            // Phone.Phone("15629058907");
            case GAME_CODE:

        }
    }
}
