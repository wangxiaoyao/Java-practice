package com.xiaoyao;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // 这里将public改为static就避免了：无法从静态上下文中引用非静态变量，非静态方法
    static boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m=Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }
    public static void main(String[] args) {
        final Byte MONTH = 12;
        Scanner scanner = new Scanner(System.in);
        System.out.println("principal:");
        String principalStr = scanner.next();
        while(true){
            if( !judgeContainsStr(principalStr) ){
                break;
            }
            System.out.println("请重新输入非数字");
            principalStr = scanner.next();
        }
        double principal = Double.parseDouble(principalStr);
        String showResult =  NumberFormat.getCurrencyInstance().format(principal*MONTH);
        System.out.println(showResult);
    }
}
