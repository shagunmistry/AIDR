/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qa.qcri.aidr.predictui.util;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import qa.qcri.aidr.dbmanager.dto.CollectionDTO;
import qa.qcri.aidr.dbmanager.dto.CrisisAttributesDTO;
import qa.qcri.aidr.dbmanager.dto.CrisisTypeDTO;
import qa.qcri.aidr.dbmanager.dto.DocumentDTO;
import qa.qcri.aidr.dbmanager.dto.HumanLabeledDocumentDTO;
import qa.qcri.aidr.dbmanager.dto.ModelDTO;
import qa.qcri.aidr.dbmanager.dto.ModelFamilyDTO;
import qa.qcri.aidr.dbmanager.dto.ModelNominalLabelDTO;
import qa.qcri.aidr.dbmanager.dto.NominalAttributeDTO;
import qa.qcri.aidr.dbmanager.dto.NominalLabelDTO;
import qa.qcri.aidr.dbmanager.dto.taggerapi.ModelHistoryWrapper;
import qa.qcri.aidr.dbmanager.dto.taggerapi.ModelWrapper;
import qa.qcri.aidr.dbmanager.dto.taggerapi.TaggersForCodes;
import qa.qcri.aidr.dbmanager.dto.taggerapi.TrainingDataDTO;
import qa.qcri.aidr.dbmanager.entities.misc.Collection;
import qa.qcri.aidr.dbmanager.entities.model.ModelNominalLabel;
import qa.qcri.aidr.predictui.entities.AidrCollection;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 * @author Muhammad Imran
 */
@XmlRootElement(name = "responseWrapper")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    protected String statusCode;
    @XmlElement
    protected String message;
    @XmlElement
    protected Object dataObject;
    @XmlElement
    private List<CrisisTypeDTO> crisisTypes;
    @XmlElement
    private List<CollectionDTO> crisises;
    @XmlElement
    private List<NominalLabelDTO> nominalLabels;
    @XmlElement
    private List<NominalAttributeDTO> nominalAttributes;
    @XmlElement
    private List<ModelDTO> models;
    @XmlElement
    private List<DocumentDTO> documents;
    @XmlElement
    private List<ModelFamilyDTO> modelFamilies;
    @XmlElement
    private List<ModelNominalLabel> modelNominalLabels;
    @XmlElement
    private List<ModelNominalLabelDTO> modelNominalLabelsDTO;
    @XmlElement
    private List<Collection> collections;
    @XmlElement
    private List<ModelWrapper> modelWrapper;
    @XmlElement
    private List<ModelHistoryWrapper> modelHistoryWrapper;
    @XmlElement
    private List<TaggersForCodes> taggersForCodes;
    @XmlElement
    private List<CrisisAttributesDTO> crisisAttributes;
    @XmlElement
    private List<TrainingDataDTO> trainingData;
    
    @XmlElement 
    List<HumanLabeledDocumentDTO> items;
    
    @XmlElement
    private Integer total;
    
    @XmlElement
    private Long entityID; // use this field to send IDs to manager

    public ResponseWrapper(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseWrapper(String statusCode) {
        this.statusCode = statusCode;
    }
    
    public ResponseWrapper(String statusCode, Object obj) {
        this.statusCode = statusCode;
        this.dataObject = obj;
    }

    public ResponseWrapper(String statusCode, String message, Object obj) {
        this.statusCode = statusCode;
        this.message = message;
        this.dataObject = obj;
    }

    public ResponseWrapper() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the dataObject
     */
    public Object getDataObject() {
        return dataObject;
    }

    /**
     * @param dataObject the dataObject to set
     */
    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    /**
     * @return the crisisTypes
     */
    public List<CrisisTypeDTO> getCrisisTypes() {
        return crisisTypes;
    }

    /**
     * @param crisisTypes the crisisTypes to set
     */
    public void setCrisisTypes(List<CrisisTypeDTO> crisisTypes) {
        this.crisisTypes = crisisTypes;
    }

    /**
     * @return the crisises
     */
    public List<CollectionDTO> getCrisises() {
        return crisises;
    }

    /**
     * @param crisises the crisises to set
     */
    public void setCrisises(List<CollectionDTO> crisises) {
        this.crisises = crisises;
    }

    /**
     * @return the nominalLabels
     */
    public List<NominalLabelDTO> getNominalLabels() {
        return nominalLabels;
    }

    /**
     * @param nominalLabels the nominalLabels to set
     */
    public void setNominalLabels(List<NominalLabelDTO> nominalLabels) {
        this.nominalLabels = nominalLabels;
    }

    /**
     * @return the nominalAttributes
     */
    public List<NominalAttributeDTO> getNominalAttributes() {
        return nominalAttributes;
    }

    /**
     * @param nominalAttributes the nominalAttributes to set
     */
    public void setNominalAttributes(List<NominalAttributeDTO> nominalAttributes) {
        this.nominalAttributes = nominalAttributes;
    }

    /**
     * @return the models
     */
    public List<ModelDTO> getModels() {
        return models;
    }

    /**
     * @param models the models to set
     */
    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    /**
     * @return the documents
     */
    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

    /**
     * @return the modelFamilies
     */
    public List<ModelFamilyDTO> getModelFamilies() {
        return modelFamilies;
    }

    /**
     * @param modelFamilies the modelFamilies to set
     */
    public void setModelFamilies(List<ModelFamilyDTO> modelFamilies) {
        this.modelFamilies = modelFamilies;
    }

    /**
     * @return the modelNominalLabels
     */
    public List<ModelNominalLabel> getModelNominalLabels() {
        return modelNominalLabels;
    }

    /**
     * @param modelNominalLabels the modelNominalLabels to set
     */
    public void setModelNominalLabels(List<ModelNominalLabel> modelNominalLabels) {
        this.modelNominalLabels = modelNominalLabels;
    }

    /**
     * @return the collections
     */
    public List<Collection> getCollections() {
        return collections;
    }

    /**
     * @param collections the collections to set
     */
    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    /**
     * @return the modelWrapper
     */
    public List<ModelWrapper> getModelWrapper() {
        return modelWrapper;
    }

    /**
     * @param modelWrapper the modelWrapper to set
     */
    public void setModelWrapper(List<ModelWrapper> modelWrapper) {
        this.modelWrapper = modelWrapper;
    }

    /**
     * @return the modelHistoryWrapper
     */
    public List<ModelHistoryWrapper> getModelHistoryWrapper() {
        return modelHistoryWrapper;
    }

    /**
     * @param modelHistoryWrapper the modelHistoryWrapper to set
     */
    public void setModelHistoryWrapper(List<ModelHistoryWrapper> modelHistoryWrapper) {
        this.modelHistoryWrapper = modelHistoryWrapper;
    }

    /**
     * @return the taggersForCodes
     */
    public List<TaggersForCodes> getTaggersForCodes() {
        return taggersForCodes;
    }

    /**
     * @param taggersForCodes the taggersForCodes to set
     */
    public void setTaggersForCodes(List<TaggersForCodes> taggersForCodes) {
        this.taggersForCodes = taggersForCodes;
    }

    /**
     * @return the crisisAttributes
     */
    public List<CrisisAttributesDTO> getCrisisAttributes() {
        return crisisAttributes;
    }

    /**
     * @param crisisAttributes the crisisAttributes to set
     */
    public void setCrisisAttributes(List<CrisisAttributesDTO> crisisAttributes) {
        this.crisisAttributes = crisisAttributes;
    }

    /**
     * @return the trainingData
     */
    public List<TrainingDataDTO> getTrainingData() {
        return trainingData;
    }

    /**
     * @param trainingData the trainingData to set
     */
    public void setTrainingData(List<TrainingDataDTO> trainingData) {
        this.trainingData = trainingData;
    }

    /**
     * @return the modelNominalLabelsDTO
     */
    public List<ModelNominalLabelDTO> getModelNominalLabelsDTO() {
        return modelNominalLabelsDTO;
    }

    /**
     * @param modelNominalLabelsDTO the modelNominalLabelsDTO to set
     */
    public void setModelNominalLabelsDTO(List<ModelNominalLabelDTO> modelNominalLabelsDTO) {
        this.modelNominalLabelsDTO = modelNominalLabelsDTO;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the entityID
     */
    public Long getEntityID() {
        return entityID;
    }

    /**
     * @param entityID the entityID to set
     */
    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }
    
    public List<HumanLabeledDocumentDTO> getItems() {
    	return this.items;
    }
    
    public void setItems(List<HumanLabeledDocumentDTO> items) {
    	this.items = items;
    	if (items != null && !items.isEmpty()) {
    		this.setTotal(items.size());
    	}
    }
}
