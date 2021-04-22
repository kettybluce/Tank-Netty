package com.mashibing.ketty;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 * @author 孺子韫
 * @create 2021-04-22 10:13
 */
public class Main {
    /**
     * 游戏启动页面
     *
     * @param args
     */
    public static void main(String[] args) {

//       new Frame() 一个窗口
        Frame frame = new Frame();
//      设置窗口的大小
        frame.setSize(800, 600);
//      设置是否可以改变大小
        frame.setResizable(false);
//      设置窗口的标题
        frame.setTitle("Tank War");
//      调用程序窗口显示
        frame.setVisible(true);
//      添加windows的监听器，重写windowClosing方法,监听窗口关闭事件
        frame.addWindowListener(new WindowAdapter() {

            // 设置可以手动关闭当前的窗口
            @Override
            public void windowClosing(WindowEvent e) {
                //  系统退出
                System.exit(0);
            }
        });

    }
}