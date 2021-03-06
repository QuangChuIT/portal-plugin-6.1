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

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.PortalPluginsModel;
import com.bkav.portal.portlet.portalplugins.model.PortalPluginsSoap;

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
 * The base model implementation for the PortalPlugins service. Represents a row in the &quot;PortalPlugins&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.portalplugins.model.PortalPluginsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortalPluginsImpl}.
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsImpl
 * @see com.bkav.portal.portlet.portalplugins.model.PortalPlugins
 * @see com.bkav.portal.portlet.portalplugins.model.PortalPluginsModel
 * @generated
 */
@JSON(strict = true)
public class PortalPluginsModelImpl extends BaseModelImpl<PortalPlugins>
	implements PortalPluginsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a portal plugins model instance should use the {@link com.bkav.portal.portlet.portalplugins.model.PortalPlugins} interface instead.
	 */
	public static final String TABLE_NAME = "PortalPlugins";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pluginId", Types.BIGINT },
			{ "pluginName", Types.VARCHAR },
			{ "pluginCode", Types.VARCHAR },
			{ "pluginVersion", Types.DOUBLE },
			{ "pluginType", Types.INTEGER },
			{ "ePortalId", Types.BIGINT },
			{ "isImportant", Types.INTEGER },
			{ "pluginDescription", Types.VARCHAR },
			{ "pluginUpdateInfo", Types.VARCHAR },
			{ "pluginSize", Types.DOUBLE },
			{ "warFileId", Types.BIGINT },
			{ "signFileId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table PortalPlugins (pluginId LONG not null primary key,pluginName VARCHAR(75) null,pluginCode VARCHAR(75) null,pluginVersion DOUBLE,pluginType INTEGER,ePortalId LONG,isImportant INTEGER,pluginDescription TEXT null,pluginUpdateInfo TEXT null,pluginSize DOUBLE,warFileId LONG,signFileId LONG,createDate DATE null,modifyDate DATE null,groupId LONG,userId LONG,companyId LONG,userName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table PortalPlugins";
	public static final String ORDER_BY_JPQL = " ORDER BY portalPlugins.pluginVersion DESC, portalPlugins.modifyDate DESC, portalPlugins.pluginName DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PortalPlugins.pluginVersion DESC, PortalPlugins.modifyDate DESC, PortalPlugins.pluginName DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.portalplugins.model.PortalPlugins"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.portalplugins.model.PortalPlugins"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.portalplugins.model.PortalPlugins"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long EPORTALID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long PLUGINCODE_COLUMN_BITMASK = 8L;
	public static long PLUGINVERSION_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PortalPlugins toModel(PortalPluginsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PortalPlugins model = new PortalPluginsImpl();

		model.setPluginId(soapModel.getPluginId());
		model.setPluginName(soapModel.getPluginName());
		model.setPluginCode(soapModel.getPluginCode());
		model.setPluginVersion(soapModel.getPluginVersion());
		model.setPluginType(soapModel.getPluginType());
		model.setEPortalId(soapModel.getEPortalId());
		model.setIsImportant(soapModel.getIsImportant());
		model.setPluginDescription(soapModel.getPluginDescription());
		model.setPluginUpdateInfo(soapModel.getPluginUpdateInfo());
		model.setPluginSize(soapModel.getPluginSize());
		model.setWarFileId(soapModel.getWarFileId());
		model.setSignFileId(soapModel.getSignFileId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifyDate(soapModel.getModifyDate());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserName(soapModel.getUserName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PortalPlugins> toModels(PortalPluginsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PortalPlugins> models = new ArrayList<PortalPlugins>(soapModels.length);

		for (PortalPluginsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.portalplugins.model.PortalPlugins"));

	public PortalPluginsModelImpl() {
	}

	public long getPrimaryKey() {
		return _pluginId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPluginId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pluginId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return PortalPlugins.class;
	}

	public String getModelClassName() {
		return PortalPlugins.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pluginId", getPluginId());
		attributes.put("pluginName", getPluginName());
		attributes.put("pluginCode", getPluginCode());
		attributes.put("pluginVersion", getPluginVersion());
		attributes.put("pluginType", getPluginType());
		attributes.put("ePortalId", getEPortalId());
		attributes.put("isImportant", getIsImportant());
		attributes.put("pluginDescription", getPluginDescription());
		attributes.put("pluginUpdateInfo", getPluginUpdateInfo());
		attributes.put("pluginSize", getPluginSize());
		attributes.put("warFileId", getWarFileId());
		attributes.put("signFileId", getSignFileId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pluginId = (Long)attributes.get("pluginId");

		if (pluginId != null) {
			setPluginId(pluginId);
		}

		String pluginName = (String)attributes.get("pluginName");

		if (pluginName != null) {
			setPluginName(pluginName);
		}

		String pluginCode = (String)attributes.get("pluginCode");

		if (pluginCode != null) {
			setPluginCode(pluginCode);
		}

		Double pluginVersion = (Double)attributes.get("pluginVersion");

		if (pluginVersion != null) {
			setPluginVersion(pluginVersion);
		}

		Integer pluginType = (Integer)attributes.get("pluginType");

		if (pluginType != null) {
			setPluginType(pluginType);
		}

		Long ePortalId = (Long)attributes.get("ePortalId");

		if (ePortalId != null) {
			setEPortalId(ePortalId);
		}

		Integer isImportant = (Integer)attributes.get("isImportant");

		if (isImportant != null) {
			setIsImportant(isImportant);
		}

		String pluginDescription = (String)attributes.get("pluginDescription");

		if (pluginDescription != null) {
			setPluginDescription(pluginDescription);
		}

		String pluginUpdateInfo = (String)attributes.get("pluginUpdateInfo");

		if (pluginUpdateInfo != null) {
			setPluginUpdateInfo(pluginUpdateInfo);
		}

		Double pluginSize = (Double)attributes.get("pluginSize");

		if (pluginSize != null) {
			setPluginSize(pluginSize);
		}

		Long warFileId = (Long)attributes.get("warFileId");

		if (warFileId != null) {
			setWarFileId(warFileId);
		}

		Long signFileId = (Long)attributes.get("signFileId");

		if (signFileId != null) {
			setSignFileId(signFileId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	@JSON
	public long getPluginId() {
		return _pluginId;
	}

	public void setPluginId(long pluginId) {
		_pluginId = pluginId;
	}

	@JSON
	public String getPluginName() {
		if (_pluginName == null) {
			return StringPool.BLANK;
		}
		else {
			return _pluginName;
		}
	}

	public void setPluginName(String pluginName) {
		_columnBitmask = -1L;

		_pluginName = pluginName;
	}

	@JSON
	public String getPluginCode() {
		if (_pluginCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _pluginCode;
		}
	}

	public void setPluginCode(String pluginCode) {
		_columnBitmask |= PLUGINCODE_COLUMN_BITMASK;

		if (_originalPluginCode == null) {
			_originalPluginCode = _pluginCode;
		}

		_pluginCode = pluginCode;
	}

	public String getOriginalPluginCode() {
		return GetterUtil.getString(_originalPluginCode);
	}

	@JSON
	public double getPluginVersion() {
		return _pluginVersion;
	}

	public void setPluginVersion(double pluginVersion) {
		_columnBitmask = -1L;

		if (!_setOriginalPluginVersion) {
			_setOriginalPluginVersion = true;

			_originalPluginVersion = _pluginVersion;
		}

		_pluginVersion = pluginVersion;
	}

	public double getOriginalPluginVersion() {
		return _originalPluginVersion;
	}

	@JSON
	public int getPluginType() {
		return _pluginType;
	}

	public void setPluginType(int pluginType) {
		_pluginType = pluginType;
	}

	@JSON
	public long getEPortalId() {
		return _ePortalId;
	}

	public void setEPortalId(long ePortalId) {
		_columnBitmask |= EPORTALID_COLUMN_BITMASK;

		if (!_setOriginalEPortalId) {
			_setOriginalEPortalId = true;

			_originalEPortalId = _ePortalId;
		}

		_ePortalId = ePortalId;
	}

	public long getOriginalEPortalId() {
		return _originalEPortalId;
	}

	@JSON
	public int getIsImportant() {
		return _isImportant;
	}

	public void setIsImportant(int isImportant) {
		_isImportant = isImportant;
	}

	@JSON
	public String getPluginDescription() {
		if (_pluginDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _pluginDescription;
		}
	}

	public void setPluginDescription(String pluginDescription) {
		_pluginDescription = pluginDescription;
	}

	@JSON
	public String getPluginUpdateInfo() {
		if (_pluginUpdateInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _pluginUpdateInfo;
		}
	}

	public void setPluginUpdateInfo(String pluginUpdateInfo) {
		_pluginUpdateInfo = pluginUpdateInfo;
	}

	@JSON
	public double getPluginSize() {
		return _pluginSize;
	}

	public void setPluginSize(double pluginSize) {
		_pluginSize = pluginSize;
	}

	@JSON
	public long getWarFileId() {
		return _warFileId;
	}

	public void setWarFileId(long warFileId) {
		_warFileId = warFileId;
	}

	@JSON
	public long getSignFileId() {
		return _signFileId;
	}

	public void setSignFileId(long signFileId) {
		_signFileId = signFileId;
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
			PortalPlugins.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PortalPlugins toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (PortalPlugins)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PortalPluginsImpl portalPluginsImpl = new PortalPluginsImpl();

		portalPluginsImpl.setPluginId(getPluginId());
		portalPluginsImpl.setPluginName(getPluginName());
		portalPluginsImpl.setPluginCode(getPluginCode());
		portalPluginsImpl.setPluginVersion(getPluginVersion());
		portalPluginsImpl.setPluginType(getPluginType());
		portalPluginsImpl.setEPortalId(getEPortalId());
		portalPluginsImpl.setIsImportant(getIsImportant());
		portalPluginsImpl.setPluginDescription(getPluginDescription());
		portalPluginsImpl.setPluginUpdateInfo(getPluginUpdateInfo());
		portalPluginsImpl.setPluginSize(getPluginSize());
		portalPluginsImpl.setWarFileId(getWarFileId());
		portalPluginsImpl.setSignFileId(getSignFileId());
		portalPluginsImpl.setCreateDate(getCreateDate());
		portalPluginsImpl.setModifyDate(getModifyDate());
		portalPluginsImpl.setGroupId(getGroupId());
		portalPluginsImpl.setUserId(getUserId());
		portalPluginsImpl.setCompanyId(getCompanyId());
		portalPluginsImpl.setUserName(getUserName());

		portalPluginsImpl.resetOriginalValues();

		return portalPluginsImpl;
	}

	public int compareTo(PortalPlugins portalPlugins) {
		int value = 0;

		if (getPluginVersion() < portalPlugins.getPluginVersion()) {
			value = -1;
		}
		else if (getPluginVersion() > portalPlugins.getPluginVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getModifyDate(),
				portalPlugins.getModifyDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getPluginName().compareTo(portalPlugins.getPluginName());

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

		PortalPlugins portalPlugins = null;

		try {
			portalPlugins = (PortalPlugins)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portalPlugins.getPrimaryKey();

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
		PortalPluginsModelImpl portalPluginsModelImpl = this;

		portalPluginsModelImpl._originalPluginCode = portalPluginsModelImpl._pluginCode;

		portalPluginsModelImpl._originalPluginVersion = portalPluginsModelImpl._pluginVersion;

		portalPluginsModelImpl._setOriginalPluginVersion = false;

		portalPluginsModelImpl._originalEPortalId = portalPluginsModelImpl._ePortalId;

		portalPluginsModelImpl._setOriginalEPortalId = false;

		portalPluginsModelImpl._originalGroupId = portalPluginsModelImpl._groupId;

		portalPluginsModelImpl._setOriginalGroupId = false;

		portalPluginsModelImpl._originalCompanyId = portalPluginsModelImpl._companyId;

		portalPluginsModelImpl._setOriginalCompanyId = false;

		portalPluginsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PortalPlugins> toCacheModel() {
		PortalPluginsCacheModel portalPluginsCacheModel = new PortalPluginsCacheModel();

		portalPluginsCacheModel.pluginId = getPluginId();

		portalPluginsCacheModel.pluginName = getPluginName();

		String pluginName = portalPluginsCacheModel.pluginName;

		if ((pluginName != null) && (pluginName.length() == 0)) {
			portalPluginsCacheModel.pluginName = null;
		}

		portalPluginsCacheModel.pluginCode = getPluginCode();

		String pluginCode = portalPluginsCacheModel.pluginCode;

		if ((pluginCode != null) && (pluginCode.length() == 0)) {
			portalPluginsCacheModel.pluginCode = null;
		}

		portalPluginsCacheModel.pluginVersion = getPluginVersion();

		portalPluginsCacheModel.pluginType = getPluginType();

		portalPluginsCacheModel.ePortalId = getEPortalId();

		portalPluginsCacheModel.isImportant = getIsImportant();

		portalPluginsCacheModel.pluginDescription = getPluginDescription();

		String pluginDescription = portalPluginsCacheModel.pluginDescription;

		if ((pluginDescription != null) && (pluginDescription.length() == 0)) {
			portalPluginsCacheModel.pluginDescription = null;
		}

		portalPluginsCacheModel.pluginUpdateInfo = getPluginUpdateInfo();

		String pluginUpdateInfo = portalPluginsCacheModel.pluginUpdateInfo;

		if ((pluginUpdateInfo != null) && (pluginUpdateInfo.length() == 0)) {
			portalPluginsCacheModel.pluginUpdateInfo = null;
		}

		portalPluginsCacheModel.pluginSize = getPluginSize();

		portalPluginsCacheModel.warFileId = getWarFileId();

		portalPluginsCacheModel.signFileId = getSignFileId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			portalPluginsCacheModel.createDate = createDate.getTime();
		}
		else {
			portalPluginsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			portalPluginsCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			portalPluginsCacheModel.modifyDate = Long.MIN_VALUE;
		}

		portalPluginsCacheModel.groupId = getGroupId();

		portalPluginsCacheModel.userId = getUserId();

		portalPluginsCacheModel.companyId = getCompanyId();

		portalPluginsCacheModel.userName = getUserName();

		String userName = portalPluginsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			portalPluginsCacheModel.userName = null;
		}

		return portalPluginsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{pluginId=");
		sb.append(getPluginId());
		sb.append(", pluginName=");
		sb.append(getPluginName());
		sb.append(", pluginCode=");
		sb.append(getPluginCode());
		sb.append(", pluginVersion=");
		sb.append(getPluginVersion());
		sb.append(", pluginType=");
		sb.append(getPluginType());
		sb.append(", ePortalId=");
		sb.append(getEPortalId());
		sb.append(", isImportant=");
		sb.append(getIsImportant());
		sb.append(", pluginDescription=");
		sb.append(getPluginDescription());
		sb.append(", pluginUpdateInfo=");
		sb.append(getPluginUpdateInfo());
		sb.append(", pluginSize=");
		sb.append(getPluginSize());
		sb.append(", warFileId=");
		sb.append(getWarFileId());
		sb.append(", signFileId=");
		sb.append(getSignFileId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.portalplugins.model.PortalPlugins");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pluginId</column-name><column-value><![CDATA[");
		sb.append(getPluginId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginName</column-name><column-value><![CDATA[");
		sb.append(getPluginName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginCode</column-name><column-value><![CDATA[");
		sb.append(getPluginCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginVersion</column-name><column-value><![CDATA[");
		sb.append(getPluginVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginType</column-name><column-value><![CDATA[");
		sb.append(getPluginType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ePortalId</column-name><column-value><![CDATA[");
		sb.append(getEPortalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isImportant</column-name><column-value><![CDATA[");
		sb.append(getIsImportant());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginDescription</column-name><column-value><![CDATA[");
		sb.append(getPluginDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginUpdateInfo</column-name><column-value><![CDATA[");
		sb.append(getPluginUpdateInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginSize</column-name><column-value><![CDATA[");
		sb.append(getPluginSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>warFileId</column-name><column-value><![CDATA[");
		sb.append(getWarFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signFileId</column-name><column-value><![CDATA[");
		sb.append(getSignFileId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PortalPlugins.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			PortalPlugins.class
		};
	private long _pluginId;
	private String _pluginName;
	private String _pluginCode;
	private String _originalPluginCode;
	private double _pluginVersion;
	private double _originalPluginVersion;
	private boolean _setOriginalPluginVersion;
	private int _pluginType;
	private long _ePortalId;
	private long _originalEPortalId;
	private boolean _setOriginalEPortalId;
	private int _isImportant;
	private String _pluginDescription;
	private String _pluginUpdateInfo;
	private double _pluginSize;
	private long _warFileId;
	private long _signFileId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _userName;
	private long _columnBitmask;
	private PortalPlugins _escapedModelProxy;
}