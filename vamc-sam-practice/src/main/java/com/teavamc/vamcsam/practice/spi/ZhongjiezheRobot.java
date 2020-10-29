package com.teavamc.vamcsam.practice.spi;

import com.teavamc.vamcsam.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.spi
 * @date 2020/10/26 10:25
 */
public class ZhongjiezheRobot implements Robot {
    @Override
    public void sayHello() {
        PrintTools.printInfo("我是终结者");
    }
}