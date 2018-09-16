package in.iedtt.entity;

public class DefectComment {

	private int defectId;
	private String commentor;
	private String comment;
	private String date;
	
	public DefectComment() {
		super();
	}

	public DefectComment(int defectId, String commentor, String comment, String date) {
		super();
		this.defectId = defectId;
		this.commentor = commentor;
		this.comment = comment;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DefectComment [defectId=" + defectId + ", commentor=" + commentor + ", comment=" + comment + ", date="
				+ date + "]";
	}
	
}
