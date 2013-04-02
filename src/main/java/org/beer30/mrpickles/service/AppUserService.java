package org.beer30.mrpickles.service;

import org.beer30.mrpickles.domain.entity.AppUser;

import java.util.List;


public interface AppUserService {

	public abstract long countAllAppUsers();


	public abstract void deleteAppUser(AppUser appUser);


	public abstract AppUser findAppUser(Long id);


	public abstract List<AppUser> findAllAppUsers();


	public abstract List<AppUser> findAppUserEntries(int firstResult, int maxResults);


	public abstract AppUser saveAppUser(AppUser appUser);


	public abstract AppUser updateAppUser(AppUser appUser);

    public abstract AppUser createNewUser();



}
