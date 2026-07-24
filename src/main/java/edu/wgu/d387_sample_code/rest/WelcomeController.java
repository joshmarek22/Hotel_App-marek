package edu.wgu.d387_sample_code.rest;
import edu.wgu.d387_sample_code.locale.DisplayMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin
public class WelcomeController {
    private Executor executor = Executors.newFixedThreadPool(2);

    //Displays both the French and English welcome messages in separate threads.
    @GetMapping("welcome")
    public ResponseEntity<List<String>>getWelcomeMessage(){
        List<String> str_out = new ArrayList<String>();
        executor.execute(()->{
            DisplayMessages enCA = new DisplayMessages("en", "CA");
            System.out.println("Thread 1 " + enCA.getWelcomeMessages());
            str_out.add(enCA.getWelcomeMessages());
        });

        executor.execute(()->{
            DisplayMessages frCA = new DisplayMessages("fr", "CA");
            System.out.println("Thread 2 " + frCA.getWelcomeMessages());
            str_out.add(frCA.getWelcomeMessages());
        });
        return ResponseEntity.ok(str_out);
    }
}
