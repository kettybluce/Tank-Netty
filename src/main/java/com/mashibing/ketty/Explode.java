package com.mashibing.ketty;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.awt.*;

/**
 * 爆炸的图片
 */
public class Explode {

//  爆炸的图片宽高
        public static int WIDTH=ResourceMgr.explodes[0].getWidth();
        public static int HEIGHT=ResourceMgr.explodes[0].getHeight();
//  坐标
        private  int x,y;

        private boolean living=true;

        private TankFrame tf=null;

        private int step=0;

    public Explode() {
    }

    public Explode(int x, int y,  TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    //画爆炸的图片
        public void paint(Graphics graphics){

            graphics.drawImage(ResourceMgr.explodes[step++],x,y,null);

            if (step>=ResourceMgr.explodes.length){
                step=0;
            }
    }

}
