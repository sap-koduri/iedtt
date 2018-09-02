package in.iedtt.entity;

import java.util.Date;

public class Defect {

	private Integer id;
	private String description;
	private String status;
	private String identifiedBy;
	private String assignedTo;
	private Date eta;
	private Date defectDate;
	private String rca;
	public Defect() {
	}
	public Defect(Integer id, String description, String status, String identifiedBy, String assignedTo, Date eta,
			Date defectDate, String rca) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.identifiedBy = identifiedBy;
		this.assignedTo = assignedTo;
		this.eta = eta;
		this.defectDate = defectDate;
		this.rca = rca;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdentifiedBy() {
		return identifiedBy;
	}
	public void setIdentifiedBy(String identifiedBy) {
		this.identifiedBy = identifiedBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public Date getDefectDate() {
		return defectDate;
	}
	public void setDefectDate(Date defectDate) {
		this.defectDate = defectDate;
	}
	public String getRca() {
		return rca;
	}
	public void setRca(String rca) {
		this.rca = rca;
	}
	@Override
	public String toString() {
		return "\nDefect [id=" + id + ", description=" + description + ", status=" + status + ", identifiedBy="
				+ identifiedBy + ", assignedTo=" + assignedTo + ", eta=" + eta + ", defectDate=" + defectDate + ", rca="
				+ rca + "]\n";
	}
	
	
	
}
