package org.javacore.base.inter;

import java.util.Arrays;

/**
 * @author taomk
 * @since 2016-8-1 15:51
 * @see
 *  <p>
 *  	<h3>使用接口的接口案例</h3>
 *  	定义一个接口，预留方法，实现类根据自己的逻辑来实现预留方法
 *  </p>
 *  
 */
interface ProcessorInter {
    String name();

    Object process(Object input);
}

class UpcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class SplitcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyInter {
    public static void process(ProcessorInter p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "BYSocket's Blog is www.bysocket.com";
    public static void main(String[] args) {
        process(new UpcaseImpl(),s);
        process(new SplitcaseImpl(),s);
    }
}
