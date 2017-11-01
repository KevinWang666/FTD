package com.zuikc.domain;

import java.util.Date;

/*
 * 项目附件
 * */
public class ProjectFile {
	private Integer fileID;
	private String filename;
	private Project project;// 项目
	private String fileDesc;// 描述
	private String filepath;// 先只用一个路径表示
	
/*private List<Filepath> filepaths;// 文件路径集合，有待考证
*/	
	private UserInfo user;// 上传者
	private Date uploaddate;// 上传日期
	private Date modifydate;// 上传日期
	private String comments;// 备注

	public ProjectFile() {
		super();
	}

	public ProjectFile(Integer fileID) {
		super();
		this.fileID = fileID;
	}

	public ProjectFile(Integer fileID, String filename, Project project, String fileDesc, String filepath,
			UserInfo user, Date uploaddate, Date modifydate, String comments) {
		super();
		this.fileID = fileID;
		this.filename = filename;
		this.project = project;
		this.fileDesc = fileDesc;
		this.filepath = filepath;
		this.user = user;
		this.uploaddate = uploaddate;
		this.modifydate = modifydate;
		this.comments = comments;
	}

	public Integer getFileID() {
		return fileID;
	}

	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ProjectFile [fileID=" + fileID + ", filename=" + filename + ", project=" + project + ", fileDesc="
				+ fileDesc + ", filepath=" + filepath + ", user=" + user + ", uploaddate=" + uploaddate
				+ ", modifydate=" + modifydate + ", comments=" + comments + "]";
	}
	
}
