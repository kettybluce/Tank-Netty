package com.mashibing.ketty;

import java.awt.*;

/**
 * @author ketty
 * @create 2021-04-27 15:15
 * 坦克的对象类,游戏中所有的坦克抽取封装
 */
public class Tank {
    //坦克唯一的变量
    private int x,y;
    //坦克的方法
    private Dir dir=Dir.DOWN;
    //坦克的速度
    private static final int SPEED = 5;
    //坦克游戏界面的宽高
    private static int WEIGTH=50,HEIGHT=50;
    //坦克默认是不移动的
    private boolean moving=false;
    //坦克操作对象的引用,传递对象操作画子弹,画坦克用
    private TankFrame tf=null;


    public Tank() {
    }
    //坦克的构造器,需要在对象操作引用时,可以将对象传入被操纵对象中
    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    //绘制坦克的图像
    public void paint(Graphics graphics){
    //绘制背景色的方法
        Color c = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        // 绘制一个坐标x,y,宽50和高50的矩形
        graphics.fillRect(x,y, WEIGTH, HEIGHT);
        graphics.setColor(c);
    //移动方法,根据监听事件,操作对应的坦克对象
        move();
    }

    /**
     * 键盘操作，响应坦克的行动
     */
    private void move() {

        if (!moving) return;

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
    }

    /**
     * 使用坦克对象画子弹,需要使用坦克对象,调用创建的TankFrame对象去画这个子弹,
     * 显示是坦克内部调用传递的工具类中的对象去画子弹
     */
    public void fire() {
      tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));
    }
}
