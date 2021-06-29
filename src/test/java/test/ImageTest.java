package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


import static junit.framework.TestCase.assertNotNull;


/**
 * @author ketty
 * @create 2021-06-25 9:58
 */
public class ImageTest {

    @Test
    public void test01(){
        try {
            BufferedImage read1 = ImageIO.read(new File("E:\\Tank-Netty\\src\\main\\resources\\images\\tankLD.gif"));
            assertNotNull(read1);
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("images/tankLU.gif");
            BufferedImage read2 = ImageIO.read(resourceAsStream);
//          this.getClass()
            assertNotNull(read2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
