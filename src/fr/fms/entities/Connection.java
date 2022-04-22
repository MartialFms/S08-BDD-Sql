package fr.fms.entities;

public class Connection {
	private int ref;
	private String className;
	private String path;
	private String login;
	private String password;

	public Connection(int ref, String login, String password) {
		this.ref = ref;
		this.login = login;
		this.password = password;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Connection [ref=" + ref + ", className=" + className + ", path=" + path + ", login=" + login
				+ ", password=" + password + "]";
	}

}