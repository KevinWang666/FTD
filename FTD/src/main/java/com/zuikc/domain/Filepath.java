package com.zuikc.domain;

/*
 * ×ÊÔ´Â·¾¶
 * */
public class Filepath {
	private Integer filepathID;
	private String filepathname;

	public Filepath() {
		super();
	}

	public Filepath(Integer filepathID, String filepathname) {
		super();
		this.filepathID = filepathID;
		this.filepathname = filepathname;
	}

	public Integer getFilepathID() {
		return filepathID;
	}

	public void setFilepathID(Integer filepathID) {
		this.filepathID = filepathID;
	}

	public String getFilepathname() {
		return filepathname;
	}

	public void setFilepathname(String filepathname) {
		this.filepathname = filepathname;
	}

	@Override
	public String toString() {
		return "Filepath [filepathID=" + filepathID + ", filepathname=" + filepathname + "]";
	}

}
