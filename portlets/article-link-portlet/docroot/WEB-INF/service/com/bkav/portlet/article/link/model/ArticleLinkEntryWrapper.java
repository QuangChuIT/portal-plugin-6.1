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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ArticleLinkEntry}.
 * </p>
 *
 * @author    quangcv
 * @see       ArticleLinkEntry
 * @generated
 */
public class ArticleLinkEntryWrapper implements ArticleLinkEntry,
	ModelWrapper<ArticleLinkEntry> {
	public ArticleLinkEntryWrapper(ArticleLinkEntry articleLinkEntry) {
		_articleLinkEntry = articleLinkEntry;
	}

	public Class<?> getModelClass() {
		return ArticleLinkEntry.class;
	}

	public String getModelClassName() {
		return ArticleLinkEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("title", getTitle());
		attributes.put("link", getLink());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("urlTitle", getUrlTitle());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}
	}

	/**
	* Returns the primary key of this article link entry.
	*
	* @return the primary key of this article link entry
	*/
	public long getPrimaryKey() {
		return _articleLinkEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this article link entry.
	*
	* @param primaryKey the primary key of this article link entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_articleLinkEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this article link entry.
	*
	* @return the entry ID of this article link entry
	*/
	public long getEntryId() {
		return _articleLinkEntry.getEntryId();
	}

	/**
	* Sets the entry ID of this article link entry.
	*
	* @param entryId the entry ID of this article link entry
	*/
	public void setEntryId(long entryId) {
		_articleLinkEntry.setEntryId(entryId);
	}

	/**
	* Returns the company ID of this article link entry.
	*
	* @return the company ID of this article link entry
	*/
	public long getCompanyId() {
		return _articleLinkEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this article link entry.
	*
	* @param companyId the company ID of this article link entry
	*/
	public void setCompanyId(long companyId) {
		_articleLinkEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this article link entry.
	*
	* @return the user ID of this article link entry
	*/
	public long getUserId() {
		return _articleLinkEntry.getUserId();
	}

	/**
	* Sets the user ID of this article link entry.
	*
	* @param userId the user ID of this article link entry
	*/
	public void setUserId(long userId) {
		_articleLinkEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this article link entry.
	*
	* @return the user uuid of this article link entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this article link entry.
	*
	* @param userUuid the user uuid of this article link entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_articleLinkEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this article link entry.
	*
	* @return the user name of this article link entry
	*/
	public java.lang.String getUserName() {
		return _articleLinkEntry.getUserName();
	}

	/**
	* Sets the user name of this article link entry.
	*
	* @param userName the user name of this article link entry
	*/
	public void setUserName(java.lang.String userName) {
		_articleLinkEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this article link entry.
	*
	* @return the create date of this article link entry
	*/
	public java.util.Date getCreateDate() {
		return _articleLinkEntry.getCreateDate();
	}

	/**
	* Sets the create date of this article link entry.
	*
	* @param createDate the create date of this article link entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_articleLinkEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this article link entry.
	*
	* @return the modified date of this article link entry
	*/
	public java.util.Date getModifiedDate() {
		return _articleLinkEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this article link entry.
	*
	* @param modifiedDate the modified date of this article link entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_articleLinkEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the publish date of this article link entry.
	*
	* @return the publish date of this article link entry
	*/
	public java.util.Date getPublishDate() {
		return _articleLinkEntry.getPublishDate();
	}

	/**
	* Sets the publish date of this article link entry.
	*
	* @param publishDate the publish date of this article link entry
	*/
	public void setPublishDate(java.util.Date publishDate) {
		_articleLinkEntry.setPublishDate(publishDate);
	}

	/**
	* Returns the title of this article link entry.
	*
	* @return the title of this article link entry
	*/
	public java.lang.String getTitle() {
		return _articleLinkEntry.getTitle();
	}

	/**
	* Sets the title of this article link entry.
	*
	* @param title the title of this article link entry
	*/
	public void setTitle(java.lang.String title) {
		_articleLinkEntry.setTitle(title);
	}

	/**
	* Returns the link of this article link entry.
	*
	* @return the link of this article link entry
	*/
	public java.lang.String getLink() {
		return _articleLinkEntry.getLink();
	}

	/**
	* Sets the link of this article link entry.
	*
	* @param link the link of this article link entry
	*/
	public void setLink(java.lang.String link) {
		_articleLinkEntry.setLink(link);
	}

	/**
	* Returns the description of this article link entry.
	*
	* @return the description of this article link entry
	*/
	public java.lang.String getDescription() {
		return _articleLinkEntry.getDescription();
	}

	/**
	* Sets the description of this article link entry.
	*
	* @param description the description of this article link entry
	*/
	public void setDescription(java.lang.String description) {
		_articleLinkEntry.setDescription(description);
	}

	/**
	* Returns the status of this article link entry.
	*
	* @return the status of this article link entry
	*/
	public boolean getStatus() {
		return _articleLinkEntry.getStatus();
	}

	/**
	* Returns <code>true</code> if this article link entry is status.
	*
	* @return <code>true</code> if this article link entry is status; <code>false</code> otherwise
	*/
	public boolean isStatus() {
		return _articleLinkEntry.isStatus();
	}

	/**
	* Sets whether this article link entry is status.
	*
	* @param status the status of this article link entry
	*/
	public void setStatus(boolean status) {
		_articleLinkEntry.setStatus(status);
	}

	/**
	* Returns the url title of this article link entry.
	*
	* @return the url title of this article link entry
	*/
	public java.lang.String getUrlTitle() {
		return _articleLinkEntry.getUrlTitle();
	}

	/**
	* Sets the url title of this article link entry.
	*
	* @param urlTitle the url title of this article link entry
	*/
	public void setUrlTitle(java.lang.String urlTitle) {
		_articleLinkEntry.setUrlTitle(urlTitle);
	}

	public boolean isNew() {
		return _articleLinkEntry.isNew();
	}

	public void setNew(boolean n) {
		_articleLinkEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _articleLinkEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_articleLinkEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _articleLinkEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _articleLinkEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_articleLinkEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _articleLinkEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_articleLinkEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArticleLinkEntryWrapper((ArticleLinkEntry)_articleLinkEntry.clone());
	}

	public int compareTo(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry) {
		return _articleLinkEntry.compareTo(articleLinkEntry);
	}

	@Override
	public int hashCode() {
		return _articleLinkEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portlet.article.link.model.ArticleLinkEntry> toCacheModel() {
		return _articleLinkEntry.toCacheModel();
	}

	public com.bkav.portlet.article.link.model.ArticleLinkEntry toEscapedModel() {
		return new ArticleLinkEntryWrapper(_articleLinkEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _articleLinkEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _articleLinkEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_articleLinkEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ArticleLinkEntry getWrappedArticleLinkEntry() {
		return _articleLinkEntry;
	}

	public ArticleLinkEntry getWrappedModel() {
		return _articleLinkEntry;
	}

	public void resetOriginalValues() {
		_articleLinkEntry.resetOriginalValues();
	}

	private ArticleLinkEntry _articleLinkEntry;
}