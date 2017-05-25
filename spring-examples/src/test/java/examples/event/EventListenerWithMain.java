package examples.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventListenerWithMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(EventConfig.class);
        MyComponent component = ac.getBean(MyComponent.class);
        component.createMessage("Hello Event");
        ac.close();
    }
}
