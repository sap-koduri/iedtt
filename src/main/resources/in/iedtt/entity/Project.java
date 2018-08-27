package in.iedtt.entity;

public class Project {
	private int projectId;
	private int module;
	private String projectName;
	public Project() {
		super();
	}
	public Project(int projectId, int module, String projectName) {
		super();
		this.projectId = projectId;
		this.module = module;
		this.projectName = projectName;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
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
