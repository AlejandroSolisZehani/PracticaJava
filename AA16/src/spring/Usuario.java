package spring;

public class Usuario {
	private String USER_NAME,USER_EMAIL;
	private int USER_ID;
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public Usuario(String uSER_NAME, String uSER_EMAIL, int uSER_ID) {
		super();
		USER_NAME = uSER_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ID = uSER_ID;
	}
	@Override
	public String toString() {
		return "Usuario [USER_NAME=" + USER_NAME + ", USER_EMAIL=" + USER_EMAIL + ", USER_ID=" + USER_ID + "]";
	}
	
}
