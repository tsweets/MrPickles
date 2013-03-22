package org.beer30.mrpickles.domain.repository;

import org.beer30.mrpickles.domain.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/19/13
 * Time: 5:11 PM
 */
@Repository("appUserRepository")
public interface AppUserRepository extends CrudRepository<AppUser,Long> {

}
