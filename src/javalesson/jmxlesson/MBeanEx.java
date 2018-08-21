package javalesson.jmxlesson;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MBeanEx{
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("jmxlesson:type=Hello");
        Hello mbean = new Hello();
        server.registerMBean(mbean, name);
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}

