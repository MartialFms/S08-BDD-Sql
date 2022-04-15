package fr.fms.job;

public class CreateConfigFile {

	private String dbClass;
	private String dbUrl;
	private String dbLogin;
	private String dbPassword;
	
	public CreateConfigFile (String dbClass, String dbUrl, String dbLogin, String dbPassword) {
		this.dbClass=dbClass;
		this.dbUrl=dbUrl;
		this.dbLogin=dbLogin;
		this.dbPassword=dbPassword;
	}
	public String getDbClass() {
		return dbClass;
	}
	public void setDbClass(String dbClass) {
		this.dbClass = dbClass;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbLogin() {
		return dbLogin;
	}

	public void setDbLogin(String dbLogin) {
		this.dbLogin = dbLogin;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	@Override
	public String toString() {
		return "CreateConfigFile [dbClass=" + dbClass + ", dbUrl=" + dbUrl + ", dbLogin=" + dbLogin + ", dbPassword="
				+ dbPassword + "]";
	}
}
