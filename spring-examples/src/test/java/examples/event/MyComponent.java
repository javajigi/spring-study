package examples.event;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    @PostConstruct
    public void init() {
        log.debug("init component");
    }
    
    public void createMessage(String message) {
        log.debug("message : {}", message);
        this.publisher.publishEvent(new MessageEvent(this, message));
    }
}
