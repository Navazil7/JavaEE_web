//package cn.zm.trip.web.service;
//
//import org.springframework.transaction.annotation.Transactional;
//import javax.mail.MessagingException;
//
//public interface MailSenderSrvServices {
//    /*普通格式发送
//     * @recipient 收件人地址
//     * @subject 主题
//     * @content 正文
//     * */
//    @Transactional
//    void sendEmail(String recipient, String subject, String content);
//
//    /*带抄送
//     * */
//    void sendHtmlEmail(String recipient, String subject, String content) throws MessagingException, Exception;
//
//}