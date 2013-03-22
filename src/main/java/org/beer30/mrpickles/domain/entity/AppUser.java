package org.beer30.mrpickles.domain.entity;

import org.beer30.mrpickles.domain.enums.UserStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
public class AppUser implements Serializable {
    private static final long serialVersionUID = 3398394021253290285L;

    public AppUser() {
    }

    private String userHash;

    private String email;

    @NotNull
    private UserStatus status;

    private String lastName;

    private String firstName;

    private String userName;



    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dob;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String getUserHash() {
        return this.userHash;
    }

	public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

	public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	public UserStatus getStatus() {
        return this.status;
    }

	public void setStatus(UserStatus status) {
        this.status = status;
    }

	public String getLastName() {
        return this.lastName;
    }

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getFirstName() {
        return this.firstName;
    }

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public String getUserName() {
        return this.userName;
    }

	public void setUserName(String userName) {
        this.userName = userName;
    }

	public Date getDob() {
        return this.dob;
    }

	public void setDob(Date dob) {
        this.dob = dob;
    }

	/*public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }*/
    @Basic
    private String phoneMobile;

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

}
