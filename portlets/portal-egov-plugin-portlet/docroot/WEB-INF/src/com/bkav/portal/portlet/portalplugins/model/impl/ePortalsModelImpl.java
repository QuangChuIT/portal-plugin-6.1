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

package com.bkav.portal.portlet.portalplugins.model.impl;

import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.model.ePortalsModel;
import com.bkav.portal.portlet.portalplugins.model.ePortalsSoap;

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
 * The base model implementation for the ePortals service. Represents a row in the &quot;ePortals&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.portalplugins.model.ePortalsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ePortalsImpl}.
 * </p>
 *
 * @author AnhBDb
 * @see ePortalsImpl
 * @see com.bkav.portal.portlet.portalplugins.model.ePortals
 * @see com.bkav.portal.portlet.portalplugins.model.ePortalsModel
 * @generated
 */
@JSON(strict = true)
public class ePortalsModelImpl extends BaseModelImpl<ePortals>
	implements ePortalsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e portals model instance should use the {@link com.bkav.portal.portlet.portalplugins.model.ePortals} interface instead.
	 */
	public static final String TABLE_NAME = "ePortals";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eportalId", Types.BIGINT },
			{ "eportalName", Types.VARCHAR },
			{ "eportalCode", Types.VARCHAR },
			{ "eportalDomain", Types.VARCHAR },
			{ "eportalVersion", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ePortals (eportalId LONG not null primary key,eportalName VARCHAR(75) null,eportalCode VARCHAR(75) null,eportalDomain VARCHAR(75) null,eportalVersion VARCHAR(75) null,createDate DATE null,modifyDate DATE null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ePortals";
	public static final String ORDER_BY_JPQL = " ORDER BY ePortals.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ePortals.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.portalplugins.model.ePortals"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.portalplugins.model.ePortals"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.portalplugins.model.ePortals"),
			true);
	public static long EPORTALCODE_COLUMN_BITMASK = 1L;
	public static long EPORTALDOMAIN_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ePortals toModel(ePortalsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ePortals model = new ePortalsImpl();

		model.setEportalId(soapModel.getEportalId());
		model.setEportalName(soapModel.getEportalName());
		model.setEportalCode(soapModel.getEportalCode());
		model.setEportalDomain(soapModel.getEportalDomain());
		model.setEportalVersion(soapModel.getEportalVersion());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifyDate(soapModel.getModifyDate());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ePortals> toModels(ePortalsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ePortals> models = new ArrayList<ePortals>(soapModels.length);

		for (ePortalsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.portalplugins.model.ePortals"));

	public ePortalsModelImpl() {
	}

	public long getPrimaryKey() {
		return _eportalId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEportalId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eportalId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ePortals.class;
	}

	public String getModelClassName() {
		return ePortals.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eportalId", getEportalId());
		attributes.put("eportalName", getEportalName());
		attributes.put("eportalCode", getEportalCode());
		attributes.put("eportalDomain", getEportalDomain());
		attributes.put("eportalVersion", getEportalVersion());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eportalId = (Long)attributes.get("eportalId");

		if (eportalId != null) {
			setEportalId(eportalId);
		}

		String eportalName = (String)attributes.get("eportalName");

		if (eportalName != null) {
			setEportalName(eportalName);
		}

		String eportalCode = (String)attributes.get("eportalCode");

		if (eportalCode != null) {
			setEportalCode(eportalCode);
		}

		String eportalDomain = (String)attributes.get("eportalDomain");

		if (eportalDomain != null) {
			setEportalDomain(eportalDomain);
		}

		String eportalVersion = (String)attributes.get("eportalVersion");

		if (eportalVersion != null) {
			setEportalVersion(eportalVersion);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
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
	}

	@JSON
	public long getEportalId() {
		return _eportalId;
	}

	public void setEportalId(long eportalId) {
		_eportalId = eportalId;
	}

	@JSON
	public String getEportalName() {
		if (_eportalName == null) {
			return StringPool.BLANK;
		}
		else {
			return _eportalName;
		}
	}

	public void setEportalName(String eportalName) {
		_eportalName = eportalName;
	}

	@JSON
	public String getEportalCode() {
		if (_eportalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _eportalCode;
		}
	}

	public void setEportalCode(String eportalCode) {
		_columnBitmask |= EPORTALCODE_COLUMN_BITMASK;

		if (_originalEportalCode == null) {
			_originalEportalCode = _eportalCode;
		}

		_eportalCode = eportalCode;
	}

	public String getOriginalEportalCode() {
		return GetterUtil.getString(_originalEportalCode);
	}

	@JSON
	public String getEportalDomain() {
		if (_eportalDomain == null) {
			return StringPool.BLANK;
		}
		else {
			return _eportalDomain;
		}
	}

	public void setEportalDomain(String eportalDomain) {
		_columnBitmask |= EPORTALDOMAIN_COLUMN_BITMASK;

		if (_originalEportalDomain == null) {
			_originalEportalDomain = _eportalDomain;
		}

		_eportalDomain = eportalDomain;
	}

	public String getOriginalEportalDomain() {
		return GetterUtil.getString(_originalEportalDomain);
	}

	@JSON
	public String getEportalVersion() {
		if (_eportalVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _eportalVersion;
		}
	}

	public void setEportalVersion(String eportalVersion) {
		_eportalVersion = eportalVersion;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_columnBitmask = -1L;

		_modifyDate = modifyDate;
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
		_companyId = companyId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ePortals.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ePortals toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ePortals)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ePortalsImpl ePortalsImpl = new ePortalsImpl();

		ePortalsImpl.setEportalId(getEportalId());
		ePortalsImpl.setEportalName(getEportalName());
		ePortalsImpl.setEportalCode(getEportalCode());
		ePortalsImpl.setEportalDomain(getEportalDomain());
		ePortalsImpl.setEportalVersion(getEportalVersion());
		ePortalsImpl.setCreateDate(getCreateDate());
		ePortalsImpl.setModifyDate(getModifyDate());
		ePortalsImpl.setGroupId(getGroupId());
		ePortalsImpl.setCompanyId(getCompanyId());
		ePortalsImpl.setUserId(getUserId());
		ePortalsImpl.setUserName(getUserName());

		ePortalsImpl.resetOriginalValues();

		return ePortalsImpl;
	}

	public int compareTo(ePortals ePortals) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(), ePortals.getModifyDate());

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

		ePortals ePortals = null;

		try {
			ePortals = (ePortals)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ePortals.getPrimaryKey();

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
		ePortalsModelImpl ePortalsModelImpl = this;

		ePortalsModelImpl._originalEportalCode = ePortalsModelImpl._eportalCode;

		ePortalsModelImpl._originalEportalDomain = ePortalsModelImpl._eportalDomain;

		ePortalsModelImpl._originalGroupId = ePortalsModelImpl._groupId;

		ePortalsModelImpl._setOriginalGroupId = false;

		ePortalsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ePortals> toCacheModel() {
		ePortalsCacheModel ePortalsCacheModel = new ePortalsCacheModel();

		ePortalsCacheModel.eportalId = getEportalId();

		ePortalsCacheModel.eportalName = getEportalName();

		String eportalName = ePortalsCacheModel.eportalName;

		if ((eportalName != null) && (eportalName.length() == 0)) {
			ePortalsCacheModel.eportalName = null;
		}

		ePortalsCacheModel.eportalCode = getEportalCode();

		String eportalCode = ePortalsCacheModel.eportalCode;

		if ((eportalCode != null) && (eportalCode.length() == 0)) {
			ePortalsCacheModel.eportalCode = null;
		}

		ePortalsCacheModel.eportalDomain = getEportalDomain();

		String eportalDomain = ePortalsCacheModel.eportalDomain;

		if ((eportalDomain != null) && (eportalDomain.length() == 0)) {
			ePortalsCacheModel.eportalDomain = null;
		}

		ePortalsCacheModel.eportalVersion = getEportalVersion();

		String eportalVersion = ePortalsCacheModel.eportalVersion;

		if ((eportalVersion != null) && (eportalVersion.length() == 0)) {
			ePortalsCacheModel.eportalVersion = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ePortalsCacheModel.createDate = createDate.getTime();
		}
		else {
			ePortalsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			ePortalsCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			ePortalsCacheModel.modifyDate = Long.MIN_VALUE;
		}

		ePortalsCacheModel.groupId = getGroupId();

		ePortalsCacheModel.companyId = getCompanyId();

		ePortalsCacheModel.userId = getUserId();

		ePortalsCacheModel.userName = getUserName();

		String userName = ePortalsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ePortalsCacheModel.userName = null;
		}

		return ePortalsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{eportalId=");
		sb.append(getEportalId());
		sb.append(", eportalName=");
		sb.append(getEportalName());
		sb.append(", eportalCode=");
		sb.append(getEportalCode());
		sb.append(", eportalDomain=");
		sb.append(getEportalDomain());
		sb.append(", eportalVersion=");
		sb.append(getEportalVersion());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.portalplugins.model.ePortals");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eportalId</column-name><column-value><![CDATA[");
		sb.append(getEportalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eportalName</column-name><column-value><![CDATA[");
		sb.append(getEportalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eportalCode</column-name><column-value><![CDATA[");
		sb.append(getEportalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eportalDomain</column-name><column-value><![CDATA[");
		sb.append(getEportalDomain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eportalVersion</column-name><column-value><![CDATA[");
		sb.append(getEportalVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ePortals.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ePortals.class
		};
	private long _eportalId;
	private String _eportalName;
	private String _eportalCode;
	private String _originalEportalCode;
	private String _eportalDomain;
	private String _originalEportalDomain;
	private String _eportalVersion;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _columnBitmask;
	private ePortals _escapedModelProxy;
}