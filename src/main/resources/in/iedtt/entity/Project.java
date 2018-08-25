package in.iedtt.entity;

public class Project {
	private String projectId;
	private int module;
	private String projectName;
	public Project(String projectId, int module, String projectName) {
		super();
		this.projectId = projectId;
		this.module = module;
		this.projectName = projectName;
	}
	public Project() {
		super();
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", module=" + module + ", projectName=" + projectName + "]";
	}

}
