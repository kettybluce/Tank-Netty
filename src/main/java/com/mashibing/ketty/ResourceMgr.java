package com.mashibing.ketty;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ketty
 * @create 2021-06-25 10:56
 * 负责加载项目中对应的
 *
 * 资源加载类
 */
public class ResourceMgr {

    public  static BufferedImage tankL,tankU,tankR,tankD;

    public  static BufferedImage bulletL,bulletU,bulletR,bulletD;

    public static  BufferedImage[] explodes=new BufferedImage[16];

//  当resourceMgr.class这个类被loader进内存的时候，静态代码块自动执行，一执行，这些图片就被缓存进内存
    static {
        try {
//          坦克的上下左右图片
            tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

//          子弹的上下左右图片
            bulletL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

//          爆炸的图片
            for (int i = 0; i < 16; i++) explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
