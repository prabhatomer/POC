package mailer;

public class Mail {
	private String Subject;
	private String From;
	private String Text;
	
	

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
}
