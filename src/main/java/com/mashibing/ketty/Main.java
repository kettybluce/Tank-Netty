package com.mashibing.ketty;


/**
 * @author 孺子韫
 * @create 2021-04-22 10:13
 */
public class Main {
    /**
     * 游戏启动页面
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

//       new Frame() 一个窗口
        TankFrame tankFrame = new TankFrame();

        while(true){

//          主线程沉睡,相当于50毫秒
            Thread.sleep(50);

//          画笔不停的调用,刷新画面
            tankFrame.repaint();

        }


    }
}