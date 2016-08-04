package org.jee.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * <p>
 * 
 * <pre>
 * RPC测试代码类
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-4 10:03
 */
public class RpcTest {
	
    public static void main(String[] args) {
    	
        // 启动服务提供者
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8088);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 创建服务本地代理
        RpcImporter<EchoService> importer = new RpcImporter<>();

        // 从服务本地代理获取服务对象类
        EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
        
        // 调用远程方法
        System.out.println(echo.echo("Are you OK?"));
    }
}
