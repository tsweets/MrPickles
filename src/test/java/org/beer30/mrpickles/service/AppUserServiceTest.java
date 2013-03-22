package org.beer30.mrpickles.service;

import org.beer30.mrpickles.domain.entity.AppUser;
import org.beer30.mrpickles.domain.enums.UserStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/19/13
 * Time: 9:12 PM
 */

@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml","classpath:/META-INF/spring/applicationContext-persistence.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppUserServiceTest {

    @Autowired
    AppUserService appUserService;

    @Test
    public void testCreatingAUser(){

        AppUser user = appUserService.createNewUser();
        user.setFirstName("Tony");
        user.setLastName("Sweets");
        user.setPhoneMobile("303-555-5555");
        user.setStatus(UserStatus.ACTIVE);
        user.setUserHash("password");
        user.setDob(new Date());
        user.setEmail("tony@example.com");
        appUserService.saveAppUser(user);

        Long id = user.getId();

        AppUser foundUser = appUserService.findAppUser(id);
        Assert.assertEquals("Tony",user.getFirstName());


    }
}
