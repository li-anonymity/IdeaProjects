import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.test.AgentMain;
import javassist.*;
import sun.management.Agent;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.management.ManagementFactory;
import java.util.List;

import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class AgentmainAttachMain {
    public static void main(String[] args) throws Exception {
//        for (VirtualMachineDescriptor descriptor : list) {
//            if (descriptor.displayName().endsWith("AgentTargetSample")) {
//                VirtualMachine virtualMachine = VirtualMachine.attach(descriptor.id());
//                virtualMachine.loadAgent("I:\J-Projects\instrument-sample\premain-agent\target\premain-agent.jar", "arg1");
//                virtualMachine.detach();
//            }
//            System.out.println("我出现了几次？");
//            System.out.println("virtualMachine name = " + descriptor.displayName() + ",id = " + descriptor.id());
//        }


        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);

        VirtualMachine vm = null;
        vm = VirtualMachine.attach(pid);
        vm.loadAgent("C:\\Users\\likun\\IdeaProjects\\helloworld\\out\\artifacts\\Agent\\Agent.jar","ha la ge ha");
        vm.detach();

        getInfo();
        testhot();
    }

    public final static void testhot(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    try {
                        if(AgentMain.INST != null){
//                            FileInputStream is = new FileInputStream("C:\\Users\\likun\\IdeaProjects\\helloworld\\ShowSometing.class");
//                            byte[] array = new byte[is.available()];
//                            is.read(array);
//
                            byte[] array = null;
                            ClassPool pool = ClassPool.getDefault();
                            try {
                                CtClass clazz = pool.get("ShowSometing");
                                CtMethod cm = clazz.getDeclaredMethod("sayHello");
                                cm.insertAt(1,"{System.out.println(\"hello HotSwapper.\");}");  // clazz完全可以是全新的，这里只是为了测试方便而已
                                array = clazz.toBytecode();
                            } catch (CannotCompileException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (NotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            Class cls = Class.forName("ShowSometing");
                            AgentMain.INST.redefineClasses(new ClassDefinition(cls,array));
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public final static void getInfo(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    //System.out.println("=============="+JavaAgent.INST);
                    new ShowSometing().sayHello();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
