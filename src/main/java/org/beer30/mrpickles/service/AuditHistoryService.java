package org.beer30.mrpickles.service;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 4/1/13
 * Time: 9:36 AM
 */
public interface AuditHistoryService {
    public <T> T findAuditByRevision(Class<T> clazz, Long id, int revision);
}
