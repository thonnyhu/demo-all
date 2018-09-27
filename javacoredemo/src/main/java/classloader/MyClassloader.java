package classloader;

import java.io.*;

/**
 * Created by Mirana on 07/11/2017.
 */
public class MyClassloader extends ClassLoader{

    private String classpath;

    public MyClassloader(String path){
        super();
        this.classpath = path;
    }

    public Class<?> findClass(String name){
        System.out.println("加载类=="+ name);
        byte[] bytes = loadClassData(name);
        return defineClass(name,bytes,0,bytes.length);
    }


    public byte[] loadClassData(String name){
        try{
            name = name.replace(".", File.separator);
            FileInputStream fileInputStream = new FileInputStream(new File(classpath + name + ".class"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInputStream.read())!= -1 ){
                byteArrayOutputStream.write(b);
            }
            fileInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
