package com.cal.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cal.user.User;
import com.cal.user.dao.UserDao;
import com.cal.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User u) {
		if(u == null){
			throw new IllegalArgumentException();
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into user(email,title,essay) values(?,?,?)");
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getTitle());
			stmt.setString(3, u.getEssay());
			stmt.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException();
		}finally{
			JdbcUtil.Liahjie(rs, stmt, conn);
		}
 	}

	@Override
	public void Tosuccess(String email, String title, String essay) {
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.sina.com");
			props.setProperty("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("hcwswjf@sina.com"));
			message.addRecipients(Message.RecipientType.TO, email);
			message.setSubject(title);
			
			message.setText(essay);
			message.saveChanges();
			
			Transport ts = session.getTransport();
			ts.connect("hcwswjf@sina.com", "123456789wjf");
			ts.sendMessage(message, message.getAllRecipients());
			
			ts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
