package qa.qcri.aidr.manager.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import qa.qcri.aidr.common.values.UsageType;
import qa.qcri.aidr.manager.dto.CollectionSummaryInfo;
import qa.qcri.aidr.manager.persistence.entities.Collection;
import qa.qcri.aidr.manager.persistence.entities.UserAccount;

public interface CollectionRepository extends GenericRepository<Collection, Serializable> {
    public Integer getPublicCollectionsCount(final Enum statusValue);
    public List<Collection> getPaginatedDataForPublic( Integer start,  Integer limit, Enum statusValue);

    public List<Collection> searchByName(String query, Long userId) throws Exception;

    public List<Collection> getPaginatedData(Integer start, Integer limit, UserAccount user, boolean onlyTrashed);

    public Integer getCollectionsCount(UserAccount user, boolean onlyTrashed);

    public Boolean exist(String code);

    public Boolean existName(String name);

    public Collection getRunningCollectionStatusByUser(Long userId);

    public List<Collection> getRunningCollections();

    public List<Collection> getRunningCollections(Integer start, Integer limit, String terms, String sortColumn, String sortDirection);

    public Long getRunningCollectionsCount(String terms);

    public List<Collection> getStoppedCollections(Integer start, Integer limit, String terms, String sortColumn, String sortDirection);

    public Long getStoppedCollectionsCount(String terms);

    public Collection getInitializingCollectionStatusByUser(Long userId);

    public Collection start(Long collectionId);

    public Collection stop(Long collectionId);

    public Collection findByCode(String code);
    
    public Collection trashCollectionById(Long collectionId);

    public List<Collection> getAllCollectionByUser(Long userId);
    
    @Override
	public void update(Collection collection);

    public List<Collection> getAllCollectionsByUsage(UsageType usageType);
    
    public List<Collection> findMicromappersFilteredCollections(boolean micromappersEnabled);
	Long getTotalCollectionsCount();
	
	public List<String> getEligibleFacebookCollectionsToReRun();
	List<Collection> getUnexpectedlyStoppedCollections(Date today);
	List<CollectionSummaryInfo> getAllCollectionForAidrData();
}
