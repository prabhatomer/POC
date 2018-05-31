package hibernate;

import java.sql.Date;

public class SendMailPojo {
	private Integer mailid;
	private String to;
	private String subject;
	private String message;
	private Date date;

	public SendMailPojo() {
	}

	public SendMailPojo(Integer mailid, String to, String subject, String message, Date date) {
		this.mailid = mailid;
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.date = date;
	}

	public SendMailPojo(String to, String subject, String message, Date date) {

		this.to = to;
		this.subject = subject;
		this.message = message;
		this.date = date;
	}

	public SendMailPojo(String to, String subject, String message) {

		this.to = to;
		this.subject = subject;
		this.message = message;

	}

	public Integer getMailid() {
		return mailid;
	}

	public void setMailid(Integer mailid) {
		this.mailid = mailid;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
