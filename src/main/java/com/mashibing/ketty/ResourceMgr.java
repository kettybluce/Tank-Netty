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
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.gif"));
            tankL= ImageUtil.rotateImage(tankU,-90);
            tankR= ImageUtil.rotateImage(tankU,90);
            tankD= ImageUtil.rotateImage(tankU,180);

//          子弹的上下左右图片
            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletU= ImageUtil.rotateImage(bulletU,-90);
            bulletR= ImageUtil.rotateImage(bulletU,90);
            bulletD= ImageUtil.rotateImage(bulletU,180);

//          爆炸的图片
            for (int i = 0; i < 16; i++) explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
