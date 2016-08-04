package org.jee.rpc;

/**
 * <p>
 * 
 * <pre>
 * 服务Echo接口类的实现
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-4 9:54
 */
public class EchoServiceImpl implements EchoService {
	
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : "I am ok.";
    }
}
