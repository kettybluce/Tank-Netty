package com.mashibing.ketty;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 孺子韫
 * @create 2021-04-22 14:16
 */
public class TankFrame extends Frame {


    Tank myTank=new Tank(200,200,Dir.DOWN,this);

    List<Bullet> bullets = new ArrayList<>();

//    Bullet b=new Bullet(300,300,Dir.DOWN);

    static final int GAME_WEITH=800,GAME_HEIGHT=600;


    public TankFrame() {
        //      设置窗口的大小
        setSize(GAME_WEITH, GAME_HEIGHT);
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
     * 游戏中的双缓冲效果代码
     * 使用内存作为缓冲去实现画图,然后一次性进行显示器的渲染操作
     * 一般的游戏项目,这样的操作都在框架自身渲染操作
     */
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage=this.createImage(GAME_WEITH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WEITH, GAME_HEIGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 创建awt图形界面后系统自动调用paint方法
     *
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {

        myTank.paint(graphics);

        for (int i = 0; i <bullets.size() ; i++) {
            bullets.get(i).paint(graphics);
        }
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
            }
            serMainTankDir();
        }


        /**
         * 设置根据操作，修改坦克的方向
         */
        private void serMainTankDir() {
            if (!bL && !bU && !bR && !bD) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.REIGHT);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }

    }

}
