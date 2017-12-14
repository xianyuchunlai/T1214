package com.lanou3g.JavsSeTest;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserOperate {
    static Scanner input = new Scanner(System.in);


    public static void register() throws IOException {
        System.out.println("请输入用户名：（用户名只能是手机号或者邮箱）");
        String userName = input.next();
        String regex1 = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        String regex2 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        String regex3 = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,14}$";
        if (userName.matches(regex1) == true || userName.matches(regex2) == true) {
            System.out.println("用户名验证通过，请输入密码：");
        }
        String password = input.next();
        if (password.matches(regex3) == true) {
            System.out.println("注册成功");
        }

        Document document = DocumentHelper.createDocument();
        Element users = document.addElement("users");
        Element userName1 = users.addElement("userName");
        Element password1 = users.addElement("password");
        userName1.addAttribute("userName", userName);
        password1.addAttribute("password", password);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/users.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }

    public static void login() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/users.xml"));
        Element root = document.getRootElement();
        Element username1 = root.element("userName");
        Element password1 = root.element("password");
        Attribute username = username1.attribute("userName");
        String usernameValue = username.getValue();
        Attribute password = password1.attribute("password");
        String passwordValue = password.getValue();
        System.out.println("请输入账户：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pass = input.next();
        if (name.equals(usernameValue) && pass.equals(passwordValue)) {
            System.out.println("登录成功");
        } else {
            System.out.println("账户与密码不匹配");
        }
        System.out.println("用户名为：" + usernameValue);
    }

};
