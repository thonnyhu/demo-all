package classloader.demo1;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mirana on 07/11/2017.
 */
public class ManagerFactory {


    private static final Map<String,LoadInfo> loadTimeMap = new HashMap<>();

    public static final String CLASS_PATH = System.getProperty("user.dir")+File.separator+"javacoredemo"+File.separator+"hotfix"+File.separator;
    public static final String MY_MANAGER = "classloader.MyManager";

    public static BaseManager getManager(String className){
        File loadFile = new File(CLASS_PATH + className.replace(".", File.separator)+".class");
        long lastModify = loadFile.lastModified();

        if(loadTimeMap.get(className) == null){
            load(className,lastModify);
        }else{
           if( lastModify == loadTimeMap.get(className).getLoadTime()){

           }else{
               load(className,lastModify);
           }
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className, long lastModify){
        MyClassloader myClassloader = new MyClassloader(CLASS_PATH);
        Class<?> loadClass = null;
        try{
            loadClass = myClassloader.loadClass(className);// 由于委托机制，APPClassLoader 和ExtCLassLoader 都没有找到该Class的基础上，委托给了MyClassLoader，MyClassLoader从hotfix文件夹中找到了类,调用了defineClass加载进jvm
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BaseManager manager = newInstantce(loadClass);
        LoadInfo loadInfo2 = new LoadInfo(myClassloader,lastModify);
        loadInfo2.setBaseManager(manager);
        loadTimeMap.put(className,loadInfo2);
    }


    private static BaseManager newInstantce(Class<?> cls){
        try {
            return (BaseManager) cls.getConstructor(new Class[]{}).newInstance(new Object[]{});//必须用原构造器构造,class文件是通过MyClassLoader加载的，在别的ClassLoader中是没有的
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
