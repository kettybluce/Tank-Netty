package com.mashibing.ketty;

import java.awt.*;
import java.awt.event.*;


/**
 * @author 孺子韫
 * @create 2021-04-22 14:16
 */
public class TankFrame extends Frame {

    int x = 200, y = 200;

    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public TankFrame() {
        //      设置窗口的大小
        setSize(800, 600);
//      设置是否可以改变大小
        setResizable(false);
//      设置窗口的标题
        setTitle("Tank War");
//      调用程序窗口显示
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
//      添加windows的监听器，重写windowClosing方法,监听窗口关闭事件
        addWindowListener(new WindowAdapter() {

            // 设置可以手动关闭当前的窗口
            @Override
            public void windowClosing(WindowEvent e) {
                //  系统退出
                System.exit(0);
            }
        });
    }

    /**
     * 创建awt图形界面后系统自动调用paint方法
     *
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
//        绘制一个坐标x,y,宽50和高50的矩形
        graphics.fillRect(x, y, 50, 50);

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case REIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;

        }
//        x+=10;
//        y+=10;
    }


    /**
     * 内部类,键盘监听
     * 处理键盘事件
     */
    class MyKeyListener extends KeyAdapter {


        //      设定变量,上下左右
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        /**
         * Invoked when a key has been pressed.
         * 键盘按下事件
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
//          判断当前按键的状态,如果按下则进行对呀的方法执行
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
            }
            serMainTankDir();
        }


        /**
         * Invoked when a key has been released.
         * 键盘抬起事件
         *
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
//          判断当前按键的状态,如果抬起则进行对呀的方法执行
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
            }
            serMainTankDir();
        }


        /**
         * 设置根据操作，修改坦克的方向
         */
        private void serMainTankDir() {
            if (bL) dir = Dir.LEFT;
            if (bU) dir = Dir.UP;
            if (bR) dir = Dir.REIGHT;
            if (bD) dir = Dir.DOWN;
        }

    }

}
