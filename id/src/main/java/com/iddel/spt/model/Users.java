/*
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.iddel.spt.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Java bean for 'Users' entity
 * 
 * @author Telosys Tools
 *
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    // DB : USER_ID INT 
    private Integer userId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    // DB : USER_FIRST_NAME VARCHAR 
    private String userFirstName;

    // DB : USER_LAST_NAME VARCHAR 
    private String userLastName;

    // DB : USER_EMAIL VARCHAR 
    private String userEmail;

    // DB : USER_PASSWORD VARCHAR 
    private String userPassword;

    // DB : USER_STATUS CHAR A-> Active , D -> Disabled
    private String userStatus;

    // DB : USER_PHONE VARCHAR 
    private String userPhone;

    // DB : USER_ADDRESS VARCHAR 
    private String userAddress;

    // DB : USER_COUNTRY VARCHAR 
    private String userCountry;

    // DB : IS_ADMIN TINYINT 1 --> Admin ,0 --> Not an Admin
    private Byte isAdmin;

    private String createdBy;
    
    private Timestamp createdDate;
    
    private String updatedBy;
    
    private Timestamp updatedDate;
    

    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	//----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUserId( Integer userId ) {
        this.userId = userId ;
    }

    public Integer getUserId() {
        return this.userId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setUserFirstName( String userFirstName ) {
        this.userFirstName = userFirstName;
    }
    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserLastName( String userLastName ) {
        this.userLastName = userLastName;
    }
    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserEmail( String userEmail ) {
        this.userEmail = userEmail;
    }
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserPassword( String userPassword ) {
        this.userPassword = userPassword;
    }
    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserStatus( String userStatus ) {
        this.userStatus = userStatus;
    }
    public String getUserStatus() {
        return this.userStatus;
    }

    public void setUserPhone( String userPhone ) {
        this.userPhone = userPhone;
    }
    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserAddress( String userAddress ) {
        this.userAddress = userAddress;
    }
    public String getUserAddress() {
        return this.userAddress;
    }

    public void setUserCountry( String userCountry ) {
        this.userCountry = userCountry;
    }
    public String getUserCountry() {
        return this.userCountry;
    }

    public void setIsAdmin( Byte isAdmin ) {
        this.isAdmin = isAdmin;
    }
    public Byte getIsAdmin() {
        return this.isAdmin;
    }

}
