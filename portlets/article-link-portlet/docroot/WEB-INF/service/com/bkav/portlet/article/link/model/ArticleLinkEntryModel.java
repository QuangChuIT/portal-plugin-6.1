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

package com.bkav.portlet.article.link.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ArticleLinkEntry service. Represents a row in the &quot;ArticleLinkEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bkav.portlet.article.link.model.impl.ArticleLinkEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bkav.portlet.article.link.model.impl.ArticleLinkEntryImpl}.
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntry
 * @see com.bkav.portlet.article.link.model.impl.ArticleLinkEntryImpl
 * @see com.bkav.portlet.article.link.model.impl.ArticleLinkEntryModelImpl
 * @generated
 */
public interface ArticleLinkEntryModel extends AuditedModel,
	BaseModel<ArticleLinkEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a article link entry model instance should use the {@link ArticleLinkEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this article link entry.
	 *
	 * @return the primary key of this article link entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this article link entry.
	 *
	 * @param primaryKey the primary key of this article link entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the entry ID of this article link entry.
	 *
	 * @return the entry ID of this article link entry
	 */
	public long getEntryId();

	/**
	 * Sets the entry ID of this article link entry.
	 *
	 * @param entryId the entry ID of this article link entry
	 */
	public void setEntryId(long entryId);

	/**
	 * Returns the company ID of this article link entry.
	 *
	 * @return the company ID of this article link entry
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this article link entry.
	 *
	 * @param companyId the company ID of this article link entry
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this article link entry.
	 *
	 * @return the user ID of this article link entry
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this article link entry.
	 *
	 * @param userId the user ID of this article link entry
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this article link entry.
	 *
	 * @return the user uuid of this article link entry
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this article link entry.
	 *
	 * @param userUuid the user uuid of this article link entry
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this article link entry.
	 *
	 * @return the user name of this article link entry
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this article link entry.
	 *
	 * @param userName the user name of this article link entry
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this article link entry.
	 *
	 * @return the create date of this article link entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this article link entry.
	 *
	 * @param createDate the create date of this article link entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this article link entry.
	 *
	 * @return the modified date of this article link entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this article link entry.
	 *
	 * @param modifiedDate the modified date of this article link entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the publish date of this article link entry.
	 *
	 * @return the publish date of this article link entry
	 */
	public Date getPublishDate();

	/**
	 * Sets the publish date of this article link entry.
	 *
	 * @param publishDate the publish date of this article link entry
	 */
	public void setPublishDate(Date publishDate);

	/**
	 * Returns the title of this article link entry.
	 *
	 * @return the title of this article link entry
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this article link entry.
	 *
	 * @param title the title of this article link entry
	 */
	public void setTitle(String title);

	/**
	 * Returns the link of this article link entry.
	 *
	 * @return the link of this article link entry
	 */
	@AutoEscape
	public String getLink();

	/**
	 * Sets the link of this article link entry.
	 *
	 * @param link the link of this article link entry
	 */
	public void setLink(String link);

	/**
	 * Returns the description of this article link entry.
	 *
	 * @return the description of this article link entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this article link entry.
	 *
	 * @param description the description of this article link entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the status of this article link entry.
	 *
	 * @return the status of this article link entry
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this article link entry is status.
	 *
	 * @return <code>true</code> if this article link entry is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this article link entry is status.
	 *
	 * @param status the status of this article link entry
	 */
	public void setStatus(boolean status);

	/**
	 * Returns the url title of this article link entry.
	 *
	 * @return the url title of this article link entry
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this article link entry.
	 *
	 * @param urlTitle the url title of this article link entry
	 */
	public void setUrlTitle(String urlTitle);

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

	public int compareTo(ArticleLinkEntry articleLinkEntry);

	public int hashCode();

	public CacheModel<ArticleLinkEntry> toCacheModel();

	public ArticleLinkEntry toEscapedModel();

	public String toString();

	public String toXmlString();
}