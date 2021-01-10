package cn.zm.trip.web.listener;

import cn.zm.trip.web.event.EmailEvent;
import cn.zm.trip.web.service.impl.MailSenderSrvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements ApplicationListener<EmailEvent> {
    @Autowired
    MailSenderSrvServiceImpl mailSenderSrvService;
    public void onApplicationEvent(EmailEvent evt) {
        if (evt instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) evt;
            System.out.println("需要发送邮件的接收地址" +
                    emailEvent.getAddress());
            System.out.println("需要发送邮件的邮件正文" +
                    emailEvent.getText());
            mailSenderSrvService.sendEmail(emailEvent.getAddress(),"ssm框架邮件发送","<p>这是使用spring,springmvc,mybatis整合框架的邮件功能发送的一封邮件,测试验证码</p>"+emailEvent.getText());
        } else {
            System.out.println("容器本身的事件" + evt);
        }
        return;
    }

}