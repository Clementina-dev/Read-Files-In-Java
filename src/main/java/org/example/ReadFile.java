package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadFile {
    public static void main(String[] args) {
        String applicationProps = "/Users/apple/Downloads/application.properties";
        Map<String, String> props = new HashMap<>();

        try (InputStream strm = new FileInputStream(applicationProps)) {
            Properties properties = new Properties(){
                @Override
                public synchronized Object put(Object key, Object value){
                    return props.put(key.toString(), value.toString());
                }
            };
            properties.load(strm);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//            Properties prop = new Properties();
//
//try {
//    prop.load(new FileInputStream("conf/filename.properties"));
//} catch (IOException e) {
//    e.printStackTrace();
//}

        System.out.println(props.get("nam"));
    }
}
