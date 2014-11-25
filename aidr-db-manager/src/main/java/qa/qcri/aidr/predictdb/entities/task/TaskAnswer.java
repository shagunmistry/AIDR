// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.task;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * TaskAnswer generated by hbm2java
 */
@Entity
@Table(name = "task_answer", catalog = "aidr_predict", uniqueConstraints = @UniqueConstraint(columnNames = "taskID"))
public class TaskAnswer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5454646279615445606L;
	private TaskAnswerId id;
	private Date timestamp;
	private String answer;
	private boolean fromTrustedUser;

	public TaskAnswer() {
	}

	public TaskAnswer(TaskAnswerId id, String answer, boolean fromTrustedUser) {
		this.id = id;
		this.answer = answer;
		this.fromTrustedUser = fromTrustedUser;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "taskId", column = @Column(name = "taskID", unique = true, nullable = false)),
			@AttributeOverride(name = "documentId", column = @Column(name = "documentID", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "userID", nullable = false)) })
	public TaskAnswerId getId() {
		return this.id;
	}

	public void setId(TaskAnswerId id) {
		this.id = id;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false, length = 19)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "answer", nullable = false, length = 65535)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "fromTrustedUser", nullable = false)
	public boolean isFromTrustedUser() {
		return this.fromTrustedUser;
	}

	public void setFromTrustedUser(boolean fromTrustedUser) {
		this.fromTrustedUser = fromTrustedUser;
	}

}
