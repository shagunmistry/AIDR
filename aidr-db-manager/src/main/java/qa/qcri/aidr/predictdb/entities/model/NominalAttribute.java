// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.model;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import qa.qcri.aidr.predictdb.entities.misc.Crisis;
import qa.qcri.aidr.predictdb.entities.misc.Users;

/**
 * NominalAttribute generated by hbm2java
 */
@Entity
@Table(name = "nominal_attribute", catalog = "aidr_predict", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class NominalAttribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8597872499380166539L;
	private Long nominalAttributeId;
	private Users users;
	private String name;
	private String description;
	private String code;
	private List<ModelFamily> modelFamilies = null;
	private List<NominalAttributeDependentLabel> nominalAttributeDependentLabels = null;
	private List<Crisis> crisises = null;
	private List<NominalLabel> nominalLabels = null;

	public NominalAttribute() {
	}

	public NominalAttribute(Users users, String name, String description,
			String code) {
		this.users = users;
		this.name = name;
		this.description = description;
		this.code = code;
	}

	public NominalAttribute(Users users, String name, String description,
			String code, List<ModelFamily> modelFamilies,
			List<NominalAttributeDependentLabel> nominalAttributeDependentLabels, 
			List<Crisis> crisises, List<NominalLabel> nominalLabels) {
		this.users = users;
		this.name = name;
		this.description = description;
		this.code = code;
		this.modelFamilies = modelFamilies;
		this.nominalAttributeDependentLabels = nominalAttributeDependentLabels;
		this.crisises = crisises;
		this.nominalLabels = nominalLabels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "nominalAttributeID", unique = true, nullable = false)
	public Long getNominalAttributeId() {
		return this.nominalAttributeId;
	}

	public void setNominalAttributeId(Long nominalAttributeId) {
		this.nominalAttributeId = nominalAttributeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", nullable = false, length = 140)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 600)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "code", unique = true, nullable = false, length = 64)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nominalAttribute")
	public List<ModelFamily> getModelFamilies() {
		return this.modelFamilies;
	}

	public void setModelFamilies(List<ModelFamily> modelFamilies) {
		this.modelFamilies = modelFamilies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nominalAttribute")
	public List<NominalAttributeDependentLabel> getNominalAttributeDependentLabels() {
		return this.nominalAttributeDependentLabels;
	}

	public void setNominalAttributeDependentLabels(
			List<NominalAttributeDependentLabel> nominalAttributeDependentLabels) {
		this.nominalAttributeDependentLabels = nominalAttributeDependentLabels;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "nominalAttributes")
	public List<Crisis> getCrisises() {
		return this.crisises;
	}

	public void setCrisises(List<Crisis> crisises) {
		this.crisises = crisises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nominalAttribute")
	public List<NominalLabel> getNominalLabels() {
		return this.nominalLabels;
	}

	public void setNominalLabels(List<NominalLabel> nominalLabels) {
		this.nominalLabels = nominalLabels;
	}

}
