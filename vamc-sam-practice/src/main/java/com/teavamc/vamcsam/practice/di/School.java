package com.teavamc.vamcsam.practice.di;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dependencyInject
 * @date 2020/10/26 11:33
 */
public class School {

    private Chinese chinese;
    private English english;
    private Math math;

    private School(){
        this.math = new Math();
        this.chinese = new Chinese();
        this.english = new English();
    }

    /**
     * 注入形式
     * @param chinese
     * @param english
     * @param math
     */
    public School(Chinese chinese,English english,Math math){
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }
    
}
