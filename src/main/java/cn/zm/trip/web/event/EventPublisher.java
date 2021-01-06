package cn.zm.trip.web.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
@Component
public class EventPublisher implements ApplicationContextAware {
    @Autowired
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // 事件发布方法
    public void pushListener(ApplicationEvent evt) {
        applicationContext.publishEvent(evt);
    }
}
