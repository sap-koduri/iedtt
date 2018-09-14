package in.iedtt.entity;

import java.util.Date;

public class Defect {

	private Integer id;
	private String description;
	private String status;
	private String identifiedBy;
	private String assignedTo;
	private String eta;
	private String defectDate;
	private String rca;
	private String projectName;
	private String moduleName;
	
	public Defect() {
	}

	public Defect(Integer id, String description, String status, String identifiedBy, String assignedTo, String eta,
			String defectDate, String rca, String projectName, String moduleName) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.identifiedBy = identifiedBy;
		this.assignedTo = assignedTo;
		this.eta = eta;
		this.defectDate = defectDate;
		this.rca = rca;
		this.projectName = projectName;
		this.moduleName = moduleName;
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

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getDefectDate() {
		return defectDate;
	}

	public void setDefectDate(String defectDate) {
		this.defectDate = defectDate;
	}

	public String getRca() {
		return rca;
	}

	public void setRca(String rca) {
		this.rca = rca;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "Defect [id=" + id + ", description=" + description + ", status=" + status + ", identifiedBy="
				+ identifiedBy + ", assignedTo=" + assignedTo + ", eta=" + eta + ", defectDate=" + defectDate + ", rca="
				+ rca + ", projectName=" + projectName + ", moduleName=" + moduleName + "]";
	}
	
}
