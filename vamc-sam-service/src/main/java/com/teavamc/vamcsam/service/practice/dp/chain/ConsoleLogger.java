package com.teavamc.vamcsam.service.practice.dp.chain;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.chain
 * @date 2020/10/29 14:37
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        PrintTools.printInfo("Standard Console::Logger: "+ message);
    }
}
