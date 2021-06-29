package com.mashibing.ketty;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ketty
 * @create 2021-06-25 10:56
 * 负责加载项目中对应的
 */
public class resourceMgr {

    public  static BufferedImage tankL,tankU,tankR,tankD;

//  当resourceMgr.class这个类被loader进内存的时候，静态代码块自动执行，一执行，这些图片就被缓存进内存
    static {
        try {
            tankL= ImageIO.read(resourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU= ImageIO.read(resourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR= ImageIO.read(resourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD= ImageIO.read(resourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
