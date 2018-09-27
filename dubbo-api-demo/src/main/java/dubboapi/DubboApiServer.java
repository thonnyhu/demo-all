package dubboapi;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Created by Mirana on 16/3/9.
 */
public class DubboApiServer {


    public static void main(String[] args) {
        IHello hello = new HelloImpl();
        //当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("hello-app");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        //服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setHost("127.0.0.1");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);

        ServiceConfig<IHello> service = new ServiceConfig<IHello>();
        service.setApplication(application);
        service.setRegistry(registryConfig);
        service.setProtocol(protocolConfig);
        service.setInterface(IHello.class);
        service.setRef(hello);
        service.setVersion("1.0.0");

        service.export();


        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
