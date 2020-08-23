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

package com.bkav.portlet.article.link.model.impl;

import com.bkav.portlet.article.link.model.ArticleLinkEntry;
import com.bkav.portlet.article.link.model.ArticleLinkEntryModel;
import com.bkav.portlet.article.link.model.ArticleLinkEntrySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ArticleLinkEntry service. Represents a row in the &quot;ArticleLinkEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portlet.article.link.model.ArticleLinkEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ArticleLinkEntryImpl}.
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntryImpl
 * @see com.bkav.portlet.article.link.model.ArticleLinkEntry
 * @see com.bkav.portlet.article.link.model.ArticleLinkEntryModel
 * @generated
 */
@JSON(strict = true)
public class ArticleLinkEntryModelImpl extends BaseModelImpl<ArticleLinkEntry>
	implements ArticleLinkEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a article link entry model instance should use the {@link com.bkav.portlet.article.link.model.ArticleLinkEntry} interface instead.
	 */
	public static final String TABLE_NAME = "ArticleLinkEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entryId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "publishDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "link", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "status", Types.BOOLEAN },
			{ "urlTitle", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ArticleLinkEntry (entryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,publishDate DATE null,title VARCHAR(75) null,link VARCHAR(75) null,description VARCHAR(75) null,status BOOLEAN,urlTitle VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ArticleLinkEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY articleLinkEntry.publishDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ArticleLinkEntry.publishDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portlet.article.link.model.ArticleLinkEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portlet.article.link.model.ArticleLinkEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portlet.article.link.model.ArticleLinkEntry"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long STATUS_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ArticleLinkEntry toModel(ArticleLinkEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ArticleLinkEntry model = new ArticleLinkEntryImpl();

		model.setEntryId(soapModel.getEntryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPublishDate(soapModel.getPublishDate());
		model.setTitle(soapModel.getTitle());
		model.setLink(soapModel.getLink());
		model.setDescription(soapModel.getDescription());
		model.setStatus(soapModel.getStatus());
		model.setUrlTitle(soapModel.getUrlTitle());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ArticleLinkEntry> toModels(
		ArticleLinkEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ArticleLinkEntry> models = new ArrayList<ArticleLinkEntry>(soapModels.length);

		for (ArticleLinkEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portlet.article.link.model.ArticleLinkEntry"));

	public ArticleLinkEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ArticleLinkEntry.class;
	}

	public String getModelClassName() {
		return ArticleLinkEntry.class.getName();
	}

	@Override
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

	@Override
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

	@JSON
	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_columnBitmask = -1L;

		_publishDate = publishDate;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	public String getLink() {
		if (_link == null) {
			return StringPool.BLANK;
		}
		else {
			return _link;
		}
	}

	public void setLink(String link) {
		_link = link;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public boolean getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public String getUrlTitle() {
		if (_urlTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _urlTitle;
		}
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ArticleLinkEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ArticleLinkEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ArticleLinkEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ArticleLinkEntryImpl articleLinkEntryImpl = new ArticleLinkEntryImpl();

		articleLinkEntryImpl.setEntryId(getEntryId());
		articleLinkEntryImpl.setCompanyId(getCompanyId());
		articleLinkEntryImpl.setUserId(getUserId());
		articleLinkEntryImpl.setUserName(getUserName());
		articleLinkEntryImpl.setCreateDate(getCreateDate());
		articleLinkEntryImpl.setModifiedDate(getModifiedDate());
		articleLinkEntryImpl.setPublishDate(getPublishDate());
		articleLinkEntryImpl.setTitle(getTitle());
		articleLinkEntryImpl.setLink(getLink());
		articleLinkEntryImpl.setDescription(getDescription());
		articleLinkEntryImpl.setStatus(getStatus());
		articleLinkEntryImpl.setUrlTitle(getUrlTitle());

		articleLinkEntryImpl.resetOriginalValues();

		return articleLinkEntryImpl;
	}

	public int compareTo(ArticleLinkEntry articleLinkEntry) {
		int value = 0;

		value = DateUtil.compareTo(getPublishDate(),
				articleLinkEntry.getPublishDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ArticleLinkEntry articleLinkEntry = null;

		try {
			articleLinkEntry = (ArticleLinkEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = articleLinkEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ArticleLinkEntryModelImpl articleLinkEntryModelImpl = this;

		articleLinkEntryModelImpl._originalCompanyId = articleLinkEntryModelImpl._companyId;

		articleLinkEntryModelImpl._setOriginalCompanyId = false;

		articleLinkEntryModelImpl._originalStatus = articleLinkEntryModelImpl._status;

		articleLinkEntryModelImpl._setOriginalStatus = false;

		articleLinkEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ArticleLinkEntry> toCacheModel() {
		ArticleLinkEntryCacheModel articleLinkEntryCacheModel = new ArticleLinkEntryCacheModel();

		articleLinkEntryCacheModel.entryId = getEntryId();

		articleLinkEntryCacheModel.companyId = getCompanyId();

		articleLinkEntryCacheModel.userId = getUserId();

		articleLinkEntryCacheModel.userName = getUserName();

		String userName = articleLinkEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			articleLinkEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			articleLinkEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			articleLinkEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			articleLinkEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			articleLinkEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date publishDate = getPublishDate();

		if (publishDate != null) {
			articleLinkEntryCacheModel.publishDate = publishDate.getTime();
		}
		else {
			articleLinkEntryCacheModel.publishDate = Long.MIN_VALUE;
		}

		articleLinkEntryCacheModel.title = getTitle();

		String title = articleLinkEntryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			articleLinkEntryCacheModel.title = null;
		}

		articleLinkEntryCacheModel.link = getLink();

		String link = articleLinkEntryCacheModel.link;

		if ((link != null) && (link.length() == 0)) {
			articleLinkEntryCacheModel.link = null;
		}

		articleLinkEntryCacheModel.description = getDescription();

		String description = articleLinkEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			articleLinkEntryCacheModel.description = null;
		}

		articleLinkEntryCacheModel.status = getStatus();

		articleLinkEntryCacheModel.urlTitle = getUrlTitle();

		String urlTitle = articleLinkEntryCacheModel.urlTitle;

		if ((urlTitle != null) && (urlTitle.length() == 0)) {
			articleLinkEntryCacheModel.urlTitle = null;
		}

		return articleLinkEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portlet.article.link.model.ArticleLinkEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ArticleLinkEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ArticleLinkEntry.class
		};
	private long _entryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private String _title;
	private String _link;
	private String _description;
	private boolean _status;
	private boolean _originalStatus;
	private boolean _setOriginalStatus;
	private String _urlTitle;
	private long _columnBitmask;
	private ArticleLinkEntry _escapedModelProxy;
}