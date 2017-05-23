package slipp.web;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loads")
public class ApiLoadController {
    @GetMapping("")
    public String load() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(2000);
        stopWatch.stop();
        return String.format("Execution Time : %s", stopWatch.getTotalTimeMillis());
    }
}
