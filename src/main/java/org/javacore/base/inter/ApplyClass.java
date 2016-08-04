package org.javacore.base.inter;

import java.util.Arrays;


/**
 * @author taomk
 * @since 2016-8-1 15:51
 * @see
 *  <p>
 *  	<h3>不使用接口的接口案例</h3>
 *  	定义一个基类，预留一个方法，子类根据自己的逻辑来覆盖预留方法
 *  </p>
 *  
 */
class Processor {
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){return input;}
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitcase extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyClass {
    public static void process(Processor p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "BYSocket's Blog is www.bysocket.com";
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Splitcase(),s);
    }
}
