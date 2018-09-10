package in.iedtt.entity;

public class DefectComment {

	private int defectId;
	private String commentor;
	private String comment;
	private String dateTime;
	public DefectComment(int defectId, String commentor, String comment, String dateTime) {
		super();
		this.defectId = defectId;
		this.commentor = commentor;
		this.comment = comment;
		this.dateTime = dateTime;
	}
	public DefectComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDefectId() {
		return defectId;
	}
	public void setDefectId(int defectId) {
		this.defectId = defectId;
	}
	public String getCommentor() {
		return commentor;
	}
	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "DefectComment [defectId=" + defectId + ", commentor=" + commentor + ", comment=" + comment
				+ ", dateTime=" + dateTime + "]";
	}
	
	
}
