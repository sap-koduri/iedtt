package in.iedtt.entity;

public class Response {
	private String status;
	private String statusMessage;
	private Object responseObject;
 
	public Response() {
	}
	public Response(String status, String statusMessage, Object responseObject) {
		this.status = status;
		this.statusMessage = statusMessage;
		this.responseObject = responseObject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", statusMessage=" + statusMessage + ", responseObject=" + responseObject
				+ "]";
	}
	
}
