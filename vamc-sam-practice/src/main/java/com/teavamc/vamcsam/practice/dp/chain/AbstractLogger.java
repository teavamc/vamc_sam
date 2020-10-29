package com.teavamc.vamcsam.practice.dp.chain;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.chain
 * @date 2020/10/29 14:29
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    // 日志级别
    protected int level;

    // 下一个日志节点
    protected AbstractLogger nextLogger;

    // 设置责任链中的下一个元素
    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if (this.level <= level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}
