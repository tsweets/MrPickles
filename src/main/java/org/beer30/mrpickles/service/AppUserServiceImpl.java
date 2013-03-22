package org.beer30.mrpickles.service;

import org.beer30.mrpickles.domain.entity.AppUser;
import org.beer30.mrpickles.domain.enums.UserStatus;
import org.beer30.mrpickles.domain.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service("appUserService")
@Transactional
public class AppUserServiceImpl implements AppUserService, Serializable {

    @Autowired
    private AppUserRepository appUserRepository;

	public long countAllAppUsers() {
        throw new UnsupportedOperationException("Implement me!");
    }

	public void deleteAppUser(AppUser appUser) {
        throw new UnsupportedOperationException("Implement me!");
    }

	public AppUser findAppUser(Long id) {
        return appUserRepository.findOne(id);
    }

	public List<AppUser> findAllAppUsers() {
        throw new UnsupportedOperationException("Implement me!");
    }

	public List<AppUser> findAppUserEntries(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Implement me!");
    }

	public void saveAppUser(AppUser appUser) {
       appUserRepository.save(appUser);
    }

	public AppUser updateAppUser(AppUser appUser) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public AppUser createNewUser() {
        AppUser user = new AppUser();
        user.setStatus(UserStatus.ACTIVE);
        return user;
    }
}
