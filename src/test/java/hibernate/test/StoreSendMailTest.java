package hibernate.test;

import hibernate.*;

public class StoreSendMailTest {
	public static void main(String args[]) {
		StoreSendMail SSM=new StoreSendMail();
		String result=SSM.storeMail("prabhatomer11@gmail.com", "StoreSendMailtest", "StoreSendMailtest");
		System.out.println(result);
	}
}
