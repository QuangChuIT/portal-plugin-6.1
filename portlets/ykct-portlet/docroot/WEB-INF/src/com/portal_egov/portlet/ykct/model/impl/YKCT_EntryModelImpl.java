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

package com.portal_egov.portlet.ykct.model.impl;

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

import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.model.YKCT_EntryModel;
import com.portal_egov.portlet.ykct.model.YKCT_EntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the YKCT_Entry service. Represents a row in the &quot;YKCT_Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.ykct.model.YKCT_EntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link YKCT_EntryImpl}.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_EntryImpl
 * @see com.portal_egov.portlet.ykct.model.YKCT_Entry
 * @see com.portal_egov.portlet.ykct.model.YKCT_EntryModel
 * @generated
 */
@JSON(strict = true)
public class YKCT_EntryModelImpl extends BaseModelImpl<YKCT_Entry>
	implements YKCT_EntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a y k c t_ entry model instance should use the {@link com.portal_egov.portlet.ykct.model.YKCT_Entry} interface instead.
	 */
	public static final String TABLE_NAME = "YKCT_Entry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "entryName", Types.VARCHAR },
			{ "categoryId", Types.BIGINT },
			{ "fileAttachmentURL", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table YKCT_Entry (entryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,entryName VARCHAR(75) null,categoryId LONG,fileAttachmentURL VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table YKCT_Entry";
	public static final String ORDER_BY_JPQL = " ORDER BY ykct_Entry.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY YKCT_Entry.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.ykct.model.YKCT_Entry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.ykct.model.YKCT_Entry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.ykct.model.YKCT_Entry"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static YKCT_Entry toModel(YKCT_EntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		YKCT_Entry model = new YKCT_EntryImpl();

		model.setEntryId(soapModel.getEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEntryName(soapModel.getEntryName());
		model.setCategoryId(soapModel.getCategoryId());
		model.setFileAttachmentURL(soapModel.getFileAttachmentURL());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<YKCT_Entry> toModels(YKCT_EntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<YKCT_Entry> models = new ArrayList<YKCT_Entry>(soapModels.length);

		for (YKCT_EntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.ykct.model.YKCT_Entry"));

	public YKCT_EntryModelImpl() {
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
		return YKCT_Entry.class;
	}

	public String getModelClassName() {
		return YKCT_Entry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entryName", getEntryName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
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
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
		_columnBitmask = -1L;

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
	public String getEntryName() {
		if (_entryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _entryName;
		}
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	public String getFileAttachmentURL() {
		if (_fileAttachmentURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileAttachmentURL;
		}
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			YKCT_Entry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public YKCT_Entry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (YKCT_Entry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		YKCT_EntryImpl ykct_EntryImpl = new YKCT_EntryImpl();

		ykct_EntryImpl.setEntryId(getEntryId());
		ykct_EntryImpl.setGroupId(getGroupId());
		ykct_EntryImpl.setCompanyId(getCompanyId());
		ykct_EntryImpl.setUserId(getUserId());
		ykct_EntryImpl.setUserName(getUserName());
		ykct_EntryImpl.setCreateDate(getCreateDate());
		ykct_EntryImpl.setModifiedDate(getModifiedDate());
		ykct_EntryImpl.setEntryName(getEntryName());
		ykct_EntryImpl.setCategoryId(getCategoryId());
		ykct_EntryImpl.setFileAttachmentURL(getFileAttachmentURL());

		ykct_EntryImpl.resetOriginalValues();

		return ykct_EntryImpl;
	}

	public int compareTo(YKCT_Entry ykct_Entry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), ykct_Entry.getCreateDate());

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

		YKCT_Entry ykct_Entry = null;

		try {
			ykct_Entry = (YKCT_Entry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ykct_Entry.getPrimaryKey();

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
		YKCT_EntryModelImpl ykct_EntryModelImpl = this;

		ykct_EntryModelImpl._originalGroupId = ykct_EntryModelImpl._groupId;

		ykct_EntryModelImpl._setOriginalGroupId = false;

		ykct_EntryModelImpl._originalCompanyId = ykct_EntryModelImpl._companyId;

		ykct_EntryModelImpl._setOriginalCompanyId = false;

		ykct_EntryModelImpl._originalCategoryId = ykct_EntryModelImpl._categoryId;

		ykct_EntryModelImpl._setOriginalCategoryId = false;

		ykct_EntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<YKCT_Entry> toCacheModel() {
		YKCT_EntryCacheModel ykct_EntryCacheModel = new YKCT_EntryCacheModel();

		ykct_EntryCacheModel.entryId = getEntryId();

		ykct_EntryCacheModel.groupId = getGroupId();

		ykct_EntryCacheModel.companyId = getCompanyId();

		ykct_EntryCacheModel.userId = getUserId();

		ykct_EntryCacheModel.userName = getUserName();

		String userName = ykct_EntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ykct_EntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ykct_EntryCacheModel.createDate = createDate.getTime();
		}
		else {
			ykct_EntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ykct_EntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ykct_EntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ykct_EntryCacheModel.entryName = getEntryName();

		String entryName = ykct_EntryCacheModel.entryName;

		if ((entryName != null) && (entryName.length() == 0)) {
			ykct_EntryCacheModel.entryName = null;
		}

		ykct_EntryCacheModel.categoryId = getCategoryId();

		ykct_EntryCacheModel.fileAttachmentURL = getFileAttachmentURL();

		String fileAttachmentURL = ykct_EntryCacheModel.fileAttachmentURL;

		if ((fileAttachmentURL != null) && (fileAttachmentURL.length() == 0)) {
			ykct_EntryCacheModel.fileAttachmentURL = null;
		}

		return ykct_EntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", entryName=");
		sb.append(getEntryName());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", fileAttachmentURL=");
		sb.append(getFileAttachmentURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.ykct.model.YKCT_Entry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>entryName</column-name><column-value><![CDATA[");
		sb.append(getEntryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileAttachmentURL</column-name><column-value><![CDATA[");
		sb.append(getFileAttachmentURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = YKCT_Entry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			YKCT_Entry.class
		};
	private long _entryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _entryName;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _fileAttachmentURL;
	private long _columnBitmask;
	private YKCT_Entry _escapedModelProxy;
}