package in.iedtt.entity;

public class Project {
	private String projectDescription;
	private String module;
	private String projectName;
	public Project() {
		super();
	}
	public Project(String projectId, String module, String projectName) {
		super();
		this.projectDescription = projectId;
		this.module = module;
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "\nProject [projectId=" + projectDescription + ", module=" + module + ", projectName=" + projectName + "]";
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
}
