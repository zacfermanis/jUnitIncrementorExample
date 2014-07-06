package test;

import org.junit.rules.ExternalResource;

public class Incrementor extends ExternalResource{
	
	private static Incrementor singleton = null;

	private String basePwd = "basePwd_";
	private String baseUserName = "jUnitTestUser_";
	private int currentPwdIncr;
	private int currentUserNameIncr;
	
	protected Incrementor() {		
	}
	
	public static Incrementor getInstance() {
		if (singleton == null) {
			singleton = new Incrementor();
		}
		return singleton;
	}
	
		
	public String getCurrentPwd() {
		return basePwd + currentPwdIncr;
	}
	
	public String getNextPwd() {
		int nextPwdIncr = currentPwdIncr + 1;
		return basePwd + nextPwdIncr;
	}
	
	public void incrementPwd() {
		currentPwdIncr++;
	}
	
	public String getCurrentUser() {
		return baseUserName + currentUserNameIncr;
	}
	
	public String getNextUser() {
		int nextUserIncr = currentUserNameIncr + 1;
		return baseUserName + nextUserIncr;
	}
	
	public void incrementUser() {
		currentUserNameIncr++;
	}
	
	
	
	
	
	
	
}
