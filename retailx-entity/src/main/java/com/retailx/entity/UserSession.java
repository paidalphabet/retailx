package com.retailx.entity;

import javax.persistence.*;

/**
 * <b><author>Mahavir</author></b>
 *
 */
@Entity
@Table(name = "USER_SESSION")
public class UserSession extends BaseObject {

	@Id
	@Column(name = "SESSION_ID", length = 50)
	//@SequenceGenerator(name = "USER_SESSION_SEQ", sequenceName = "USER_SESSION_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SESSION_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sessionID;

	@Column(name = "USER_ID", length = 50)
	private String userID;

	@Column(name = "SHOPPER_IP_ADDRESS", length = 50)
	private String shopperIPAddress;

	@Column(name = "IS_AUTHENTICATED", length = 2)
	private String isAuthenticated;

	/**
	 * @return the sessionID 
	 */
	public long getSessionID() {
		return sessionID;
	}

	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(final long sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(final String userID) {
		this.userID = userID;
	}

	/**
	 * @return the shopperIPAddress
	 */
	public String getShopperIPAddress() {
		return shopperIPAddress;
	}

	/**
	 * @param shopperIPAddress the shopperIPAddress to set
	 */
	public void setShopperIPAddress(final String shopperIPAddress) {
		this.shopperIPAddress = shopperIPAddress;
	}

	/**
	 * @return the isAuthenticated
	 */
	public String getIsAuthenticated() {
		return isAuthenticated;
	}

	/**
	 * @param isAuthenticated the isAuthenticated to set
	 */
	public void setIsAuthenticated(String isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}
