/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.inquiry.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OnlineInquiry service. Represents a row in the &quot;OnlineInquiry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryImpl}.
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiry
 * @see com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryImpl
 * @see com.portal_egov.portlet.inquiry.model.impl.OnlineInquiryModelImpl
 * @generated
 */
public interface OnlineInquiryModel extends BaseModel<OnlineInquiry>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a online inquiry model instance should use the {@link OnlineInquiry} interface instead.
	 */

	/**
	 * Returns the primary key of this online inquiry.
	 *
	 * @return the primary key of this online inquiry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this online inquiry.
	 *
	 * @param primaryKey the primary key of this online inquiry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the inquiry ID of this online inquiry.
	 *
	 * @return the inquiry ID of this online inquiry
	 */
	public long getInquiryId();

	/**
	 * Sets the inquiry ID of this online inquiry.
	 *
	 * @param inquiryId the inquiry ID of this online inquiry
	 */
	public void setInquiryId(long inquiryId);

	/**
	 * Returns the group ID of this online inquiry.
	 *
	 * @return the group ID of this online inquiry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this online inquiry.
	 *
	 * @param groupId the group ID of this online inquiry
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this online inquiry.
	 *
	 * @return the company ID of this online inquiry
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this online inquiry.
	 *
	 * @param companyId the company ID of this online inquiry
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this online inquiry.
	 *
	 * @return the user ID of this online inquiry
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this online inquiry.
	 *
	 * @param userId the user ID of this online inquiry
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this online inquiry.
	 *
	 * @return the user uuid of this online inquiry
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this online inquiry.
	 *
	 * @param userUuid the user uuid of this online inquiry
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this online inquiry.
	 *
	 * @return the user name of this online inquiry
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this online inquiry.
	 *
	 * @param userName the user name of this online inquiry
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this online inquiry.
	 *
	 * @return the create date of this online inquiry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this online inquiry.
	 *
	 * @param createDate the create date of this online inquiry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this online inquiry.
	 *
	 * @return the modified date of this online inquiry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this online inquiry.
	 *
	 * @param modifiedDate the modified date of this online inquiry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the full name of this online inquiry.
	 *
	 * @return the full name of this online inquiry
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this online inquiry.
	 *
	 * @param fullName the full name of this online inquiry
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the phone numbers of this online inquiry.
	 *
	 * @return the phone numbers of this online inquiry
	 */
	@AutoEscape
	public String getPhoneNumbers();

	/**
	 * Sets the phone numbers of this online inquiry.
	 *
	 * @param phoneNumbers the phone numbers of this online inquiry
	 */
	public void setPhoneNumbers(String phoneNumbers);

	/**
	 * Returns the email address of this online inquiry.
	 *
	 * @return the email address of this online inquiry
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this online inquiry.
	 *
	 * @param emailAddress the email address of this online inquiry
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the inquiry content of this online inquiry.
	 *
	 * @return the inquiry content of this online inquiry
	 */
	@AutoEscape
	public String getInquiryContent();

	/**
	 * Sets the inquiry content of this online inquiry.
	 *
	 * @param inquiryContent the inquiry content of this online inquiry
	 */
	public void setInquiryContent(String inquiryContent);

	/**
	 * Returns the inquiry status of this online inquiry.
	 *
	 * @return the inquiry status of this online inquiry
	 */
	public int getInquiryStatus();

	/**
	 * Sets the inquiry status of this online inquiry.
	 *
	 * @param inquiryStatus the inquiry status of this online inquiry
	 */
	public void setInquiryStatus(int inquiryStatus);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(OnlineInquiry onlineInquiry);

	public int hashCode();

	public CacheModel<OnlineInquiry> toCacheModel();

	public OnlineInquiry toEscapedModel();

	public String toString();

	public String toXmlString();
}