package com.teavamc.vamcsam.service.practice.jvm;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.jvm
 * @date 2020/10/27 19:42
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Exception{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            PrintTools.printInfo("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
