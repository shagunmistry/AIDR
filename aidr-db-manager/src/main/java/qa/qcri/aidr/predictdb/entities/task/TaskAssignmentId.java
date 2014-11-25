// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.task;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TaskAssignmentId generated by hbm2java
 */
@Embeddable
public class TaskAssignmentId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7678926067937496179L;
	private Long documentId;
	private Long userId;

	public TaskAssignmentId() {
	}

	public TaskAssignmentId(Long documentId, Long userId) {
		this.documentId = documentId;
		this.userId = userId;
	}

	@Column(name = "documentID", nullable = false)
	public Long getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	@Column(name = "userID", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TaskAssignmentId))
			return false;
		TaskAssignmentId castOther = (TaskAssignmentId) other;

		return (this.getDocumentId() == castOther.getDocumentId())
				&& (this.getUserId() == castOther.getUserId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getDocumentId().intValue();
		result = 37 * result + this.getUserId().intValue();
		return result;
	}

}
