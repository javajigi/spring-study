package examples.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventConfig.class)
public class EventListenerTest {
    @Autowired
    private MyComponent component;
    
    @Test
    public void publish() throws Exception {
        component.createMessage("Hello Event");
    }
}
