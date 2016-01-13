package jp.start;

public class Str {
	private String FIRST_NAME;
	private String LAST_NAME;

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String LAST_NAME) {
		this.LAST_NAME = LAST_NAME;
	}

	public Str(String FIRST_NAME, String LAST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
		this.LAST_NAME = LAST_NAME;
	}
}
