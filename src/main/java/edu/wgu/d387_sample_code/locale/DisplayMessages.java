package edu.wgu.d387_sample_code.locale;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
// a class that displays the welcome message in both en_CA and fr_CA locales
// in two separate threads and displays both of them to the user in the console.
public class DisplayMessages {
    static ExecutorService messageExecutor=newFixedThreadPool(5);
    public static void run(){
        Properties properties = new Properties();
        messageExecutor.execute(()->{
            try{
                InputStream stream = new ClassPathResource("translation_en_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()->{
            try{
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }
}
