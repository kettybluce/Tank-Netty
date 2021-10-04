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
    public static int WIDTH=ResourceMgr.bulletD.getWidth();
    public static int HEIGHT=ResourceMgr.bulletD.getHeight();
//  子弹发出的坐标
    private  int x,y;
//  子弹的方向
    private Dir dir;
//  子弹内部需要对画图的载体进行操作,将这个画图工具传入对象引用
    private TankFrame tf=null;

    private Group group=Group.BAD;
//  子弹是否存在
    private boolean living=true;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(){

    }
//  构造器可以控制画图的工具类进行对象的引用传递操作
    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;
    }

//  画子弹的操作
    public void paint(Graphics graphics){
//      判断子弹是否存在
        if (!living){
            tf.bullets.remove(this);
        }

//        Color c=graphics.getColor();
//        graphics.setColor(Color.RED);
//        // 绘制一个坐标x,y,宽50和高50的矩形
//        graphics.fillOval(x,y, WEIGTH, HEIGHT);
//        graphics.setColor(c);
//     根据坦克图片大小，计算子弹的位置
        switch (dir){// 根据不同的操作，调用内存中不同的图片
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();

    }
//  键盘移动对应实现坦克的移动
    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;

        }
//  移动的坐标超出边框的设计,表示状态死亡
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }
    // 实际碰撞方法
    public void collideWith(Tank tank) {
//       如果是自身，不做处理
        if (this.group==tank.getGroup())return;
//        用一个rect记录子弹的位置
        Rectangle rect1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2=new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
//        碰撞检测
        if (rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }
    // 死亡方法
    private void die() {
        this.living=false;
    }
}
