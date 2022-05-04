//package Email发送.emailto;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Date;
//import java.util.Properties;
//
///*
//* @author zhuangzilian
//* @param Session.getDefaultInstance 获取身份验证信息
//*
//*
//*
//* */
////bkikkahrbxcnhfaa
//public class EmailToTset extends Thread{
//    public static void main(String [] args)
//    throws IOException {
//
//            // 收件人电子邮箱
//            String to = "2665289691@qq.com";
//
//            // 发件人电子邮箱
//            String from = "1540821469@qq.com";
//
//            // 指定发送邮件的主机为 smtp.qq.com
//            String host = "smtp.qq.com";  //QQ 邮件服务器
//
//            // 获取系统属性
//            Properties properties = System.getProperties();
//
//            // 设置邮件服务器
//            properties.setProperty("mail.smtp.host", host);
//            properties.put("mail.smtp.auth", "true");
//
//            // 通过session 获取身份验证 getPasswordAuthentication
//            Session session = Session.getDefaultInstance(properties, new Authenticator() {
//                public PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication("1540821469@qq.com", "bkikkahrbxcnhfaa"); //发件人邮件用户名、授权码
//                }
//            });
//
//            //发送内容
//            try {
//                // 创建默认的 MimeMessage 对象
//                MimeMessage message = new MimeMessage(session);
//
//                // 指定发件人账号
//                message.setFrom(new InternetAddress(from));
//
//                // 指向收件人账号
//                message.addRecipient(Message.RecipientType.TO,
//                        new InternetAddress(to));
//
//                //----------------------------发送凡方式----------------------------------------------
//                // 邮箱title信息
//                message.setSubject("这是idea中发送给你的邮件信息", "UTF-8");
//
//                // 设置消息体
//                //message.setText("您已经注册了该xxx的账号，信息安全");
//
//                // Content: 邮件正文（可以使用html标签）
//                message.setContent("这是邮件正文", "text/html;charset=UTF-8");
//
//                //附带文件
//                //message.setFileName("");
//                // 设置显示的发件时间
//                message.setSentDate(new Date());
//                // 保存前面的设置
//                message.saveChanges();
//                // 将该邮件保存到本地
//                OutputStream out = new FileOutputStream("myEmail.eml");
//                message.writeTo(out);
//                out.flush();
//                out.close();
//
//                Transport.send(message);
//
//                System.out.println("发送成功！");
//            } catch (MessagingException mex) {
//                mex.printStackTrace();
//            }
//        }
//
//    }