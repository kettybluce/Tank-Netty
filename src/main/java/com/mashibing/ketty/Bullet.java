package com.mashibing.ketty;

import java.awt.*;

/**
 * @author ketty
 * @create 2021-04-27 16:26
 * 子弹类,需要由坦克中调用产生子弹对象
 */
public class Bullet {
//  子弹速度
    private static final int SPEED = 30;
//  子弹的宽高
    private static int WEIGTH=5,HEIGHT=5;
//  子弹发出的坐标
    private  int x,y;
//  子弹的方向
    private Dir dir;
//  子弹内部需要对画图的载体进行操作,将这个画图工具传入对象引用
    private TankFrame tf=null;
//  子弹是否存在
    private boolean live=true;

    public Bullet(){

    }
//  构造器可以控制画图的工具类进行对象的引用传递操作
    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

//  画子弹的操作
    public void paint(Graphics graphics){
//      判断子弹是否存在
        if (!live){
            tf.bullets.remove(this);
        }

        Color c=graphics.getColor();
        graphics.setColor(Color.RED);
        // 绘制一个坐标x,y,宽50和高50的矩形
        graphics.fillOval(x,y, WEIGTH, HEIGHT);
        graphics.setColor(c);
        move();

    }

    private void move() {

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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WEITH || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
