package examples.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {
    private static final Logger log = LoggerFactory.getLogger(MyEventListener.class);
    
    @Async
    @EventListener
    public void handleMessageEvent(MessageEvent event) {
        log.debug("processing message event");
        log.debug("received message : {}", event.getMessage());
    }
    
    @Async
    @EventListener
    public void handleMessageEventAsyc(MessageEvent event) {
        log.debug("processing message event");
        log.debug("received message : {}", event.getMessage());
    }
}
