package com.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {
    public static Instrumentation INST;
    public static void agentmain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException,
            InterruptedException {
        INST = inst;
        System.err.println("傳進來的參數為："+agentArgs);
        System.out.println("Agent Main Done");

//        File f = new File(agentArgs);
//        byte[] targetClassFile = new byte[(int)f.length()];
//        DataInputStream dis = new DataInputStream(new FileInputStream(f));
//        dis.readFully(targetClassFile);
//        dis.close();

//        DynamicClassLoader myLoader = new DynamicClassLoader();
//        Class targetClazz = myLoader.findClass(targetClassFile);
//        System.err.println("目標class類全路徑為"+targetClazz.getName());
//        ClassDefinition clazzDef = new ClassDefinition(Class.forName(targetClazz.getName()), targetClassFile);
//        inst.redefineClasses(clazzDef);
//
//        System.err.println("重新定義"+args+"完成！！");
    }
}
