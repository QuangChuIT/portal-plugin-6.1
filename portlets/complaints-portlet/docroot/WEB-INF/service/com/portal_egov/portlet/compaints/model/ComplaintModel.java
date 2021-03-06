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

package com.portal_egov.portlet.compaints.model;

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
 * The base model interface for the Complaint service. Represents a row in the &quot;Complaint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.compaints.model.impl.ComplaintModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.compaints.model.impl.ComplaintImpl}.
 * </p>
 *
 * @author HungDX
 * @see Complaint
 * @see com.portal_egov.portlet.compaints.model.impl.ComplaintImpl
 * @see com.portal_egov.portlet.compaints.model.impl.ComplaintModelImpl
 * @generated
 */
public interface ComplaintModel extends BaseModel<Complaint>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a complaint model instance should use the {@link Complaint} interface instead.
	 */

	/**
	 * Returns the primary key of this complaint.
	 *
	 * @return the primary key of this complaint
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this complaint.
	 *
	 * @param primaryKey the primary key of this complaint
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the complaint ID of this complaint.
	 *
	 * @return the complaint ID of this complaint
	 */
	public long getComplaintId();

	/**
	 * Sets the complaint ID of this complaint.
	 *
	 * @param complaintId the complaint ID of this complaint
	 */
	public void setComplaintId(long complaintId);

	/**
	 * Returns the group ID of this complaint.
	 *
	 * @return the group ID of this complaint
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this complaint.
	 *
	 * @param groupId the group ID of this complaint
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this complaint.
	 *
	 * @return the company ID of this complaint
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this complaint.
	 *
	 * @param companyId the company ID of this complaint
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this complaint.
	 *
	 * @return the user ID of this complaint
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this complaint.
	 *
	 * @param userId the user ID of this complaint
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this complaint.
	 *
	 * @return the user uuid of this complaint
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this complaint.
	 *
	 * @param userUuid the user uuid of this complaint
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this complaint.
	 *
	 * @return the user name of this complaint
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this complaint.
	 *
	 * @param userName the user name of this complaint
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this complaint.
	 *
	 * @return the create date of this complaint
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this complaint.
	 *
	 * @param createDate the create date of this complaint
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this complaint.
	 *
	 * @return the modified date of this complaint
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this complaint.
	 *
	 * @param modifiedDate the modified date of this complaint
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the complaint title of this complaint.
	 *
	 * @return the complaint title of this complaint
	 */
	@AutoEscape
	public String getComplaintTitle();

	/**
	 * Sets the complaint title of this complaint.
	 *
	 * @param complaintTitle the complaint title of this complaint
	 */
	public void setComplaintTitle(String complaintTitle);

	/**
	 * Returns the complaint description of this complaint.
	 *
	 * @return the complaint description of this complaint
	 */
	@AutoEscape
	public String getComplaintDescription();

	/**
	 * Sets the complaint description of this complaint.
	 *
	 * @param complaintDescription the complaint description of this complaint
	 */
	public void setComplaintDescription(String complaintDescription);

	/**
	 * Returns the complaint content of this complaint.
	 *
	 * @return the complaint content of this complaint
	 */
	@AutoEscape
	public String getComplaintContent();

	/**
	 * Sets the complaint content of this complaint.
	 *
	 * @param complaintContent the complaint content of this complaint
	 */
	public void setComplaintContent(String complaintContent);

	/**
	 * Returns the file attachment u r l of this complaint.
	 *
	 * @return the file attachment u r l of this complaint
	 */
	@AutoEscape
	public String getFileAttachmentURL();

	/**
	 * Sets the file attachment u r l of this complaint.
	 *
	 * @param fileAttachmentURL the file attachment u r l of this complaint
	 */
	public void setFileAttachmentURL(String fileAttachmentURL);

	/**
	 * Returns the complaint status of this complaint.
	 *
	 * @return the complaint status of this complaint
	 */
	public int getComplaintStatus();

	/**
	 * Sets the complaint status of this complaint.
	 *
	 * @param complaintStatus the complaint status of this complaint
	 */
	public void setComplaintStatus(int complaintStatus);

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

	public int compareTo(Complaint complaint);

	public int hashCode();

	public CacheModel<Complaint> toCacheModel();

	public Complaint toEscapedModel();

	public String toString();

	public String toXmlString();
}