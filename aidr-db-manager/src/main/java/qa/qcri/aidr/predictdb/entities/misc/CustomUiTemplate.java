// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.misc;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustomUiTemplate generated by hbm2java
 */
@Entity
@Table(name = "custom_ui_template", catalog = "aidr_predict")
public class CustomUiTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4549440030648604692L;
	private Long customUitemplateId;
	private Long crisisId;
	private Long nominalAttributeId;
	private Integer templateType;
	private String templateValue;
	private Integer status;
	private Boolean isActive;
	private Date updated;

	public CustomUiTemplate() {
	}

	public CustomUiTemplate(Long crisisId, Integer templateType,
			String templateValue, Boolean isActive, Date updated) {
		this.crisisId = crisisId;
		this.templateType = templateType;
		this.templateValue = templateValue;
		this.isActive = isActive;
		this.updated = updated;
	}

	public CustomUiTemplate(Long crisisId, Long nominalAttributeId,
			Integer templateType, String templateValue, Integer status,
			Boolean isActive, Date updated) {
		this.crisisId = crisisId;
		this.nominalAttributeId = nominalAttributeId;
		this.templateType = templateType;
		this.templateValue = templateValue;
		this.status = status;
		this.isActive = isActive;
		this.updated = updated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customUITemplateID", unique = true, nullable = false)
	public Long getCustomUitemplateId() {
		return this.customUitemplateId;
	}

	public void setCustomUitemplateId(Long customUitemplateId) {
		this.customUitemplateId = customUitemplateId;
	}

	@Column(name = "crisisID", nullable = false)
	public Long getCrisisId() {
		return this.crisisId;
	}

	public void setCrisisId(long crisisId) {
		this.crisisId = crisisId;
	}

	@Column(name = "nominalAttributeID")
	public Long getNominalAttributeId() {
		return this.nominalAttributeId;
	}

	public void setNominalAttributeId(Long nominalAttributeId) {
		this.nominalAttributeId = nominalAttributeId;
	}

	@Column(name = "templateType", nullable = false)
	public Integer getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	@Column(name = "templateValue", nullable = false, length = 65535)
	public String getTemplateValue() {
		return this.templateValue;
	}

	public void setTemplateValue(String templateValue) {
		this.templateValue = templateValue;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "isActive", nullable = false)
	public Boolean isIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false, length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
