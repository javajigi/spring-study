package slipp.load;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

public class LoadTest {
    private static final Logger log = LoggerFactory.getLogger(LoadTest.class);

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);

        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/api/loads";

        StopWatch main = new StopWatch();
        main.start();

        for (int i = 0; i < 100; i++) {
            es.execute(() -> {
                int idx = counter.addAndGet(1);
                log.info("Thread {}", idx);
                
                StopWatch sw = new StopWatch();
                sw.start();
                
                rt.getForObject(url,  String.class);
                
                sw.stop();
                log.info("Elaspsed: {} -> {}", idx, sw.getTotalTimeSeconds());
            });
        }
        
        es.shutdown();
        es.awaitTermination(100, TimeUnit.SECONDS);
        
        main.stop();
        log.info("Total Elaspsed: {}", main.getTotalTimeSeconds());
    }
}
