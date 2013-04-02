package org.beer30.mrpickles.service;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/31/13
 * Time: 11:34 AM
 */
@Service("auditHistoryService")
@Repository
@Transactional
public class AuditHistoryServiceImpl implements AuditHistoryService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public <T> T findAuditByRevision(Class<T> clazz, Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        Object auditObject = auditReader.find(clazz, id, revision);

        return clazz.cast(auditObject);
    }


}
