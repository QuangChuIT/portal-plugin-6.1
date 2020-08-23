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

package com.bkav.portal.portlet.autoupdate.model.impl;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.bkav.portal.portlet.autoupdate.model.UpdatePluginsModel;
import com.bkav.portal.portlet.autoupdate.model.UpdatePluginsSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

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
 * The base model implementation for the UpdatePlugins service. Represents a row in the &quot;AutoUpdate_UpdatePlugins&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.autoupdate.model.UpdatePluginsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UpdatePluginsImpl}.
 * </p>
 *
 * @author anhbdb
 * @see UpdatePluginsImpl
 * @see com.bkav.portal.portlet.autoupdate.model.UpdatePlugins
 * @see com.bkav.portal.portlet.autoupdate.model.UpdatePluginsModel
 * @generated
 */
@JSON(strict = true)
public class UpdatePluginsModelImpl extends BaseModelImpl<UpdatePlugins>
	implements UpdatePluginsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a update plugins model instance should use the {@link com.bkav.portal.portlet.autoupdate.model.UpdatePlugins} interface instead.
	 */
	public static final String TABLE_NAME = "AutoUpdate_UpdatePlugins";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pluginId", Types.BIGINT },
			{ "pluginName", Types.VARCHAR },
			{ "pluginCode", Types.VARCHAR },
			{ "pluginType", Types.INTEGER },
			{ "currentVersion", Types.DOUBLE },
			{ "previousVersions", Types.VARCHAR },
			{ "currentSize", Types.DOUBLE },
			{ "createDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "serverCompanyId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table AutoUpdate_UpdatePlugins (pluginId LONG not null primary key,pluginName VARCHAR(75) null,pluginCode VARCHAR(75) null,pluginType INTEGER,currentVersion DOUBLE,previousVersions VARCHAR(75) null,currentSize DOUBLE,createDate DATE null,modifyDate DATE null,serverCompanyId LONG)";
	public static final String TABLE_SQL_DROP = "drop table AutoUpdate_UpdatePlugins";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"),
			true);
	public static long CURRENTVERSION_COLUMN_BITMASK = 1L;
	public static long PLUGINCODE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UpdatePlugins toModel(UpdatePluginsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UpdatePlugins model = new UpdatePluginsImpl();

		model.setPluginId(soapModel.getPluginId());
		model.setPluginName(soapModel.getPluginName());
		model.setPluginCode(soapModel.getPluginCode());
		model.setPluginType(soapModel.getPluginType());
		model.setCurrentVersion(soapModel.getCurrentVersion());
		model.setPreviousVersions(soapModel.getPreviousVersions());
		model.setCurrentSize(soapModel.getCurrentSize());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifyDate(soapModel.getModifyDate());
		model.setServerCompanyId(soapModel.getServerCompanyId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UpdatePlugins> toModels(UpdatePluginsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UpdatePlugins> models = new ArrayList<UpdatePlugins>(soapModels.length);

		for (UpdatePluginsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"));

	public UpdatePluginsModelImpl() {
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
		return UpdatePlugins.class;
	}

	public String getModelClassName() {
		return UpdatePlugins.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pluginId", getPluginId());
		attributes.put("pluginName", getPluginName());
		attributes.put("pluginCode", getPluginCode());
		attributes.put("pluginType", getPluginType());
		attributes.put("currentVersion", getCurrentVersion());
		attributes.put("previousVersions", getPreviousVersions());
		attributes.put("currentSize", getCurrentSize());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("serverCompanyId", getServerCompanyId());

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

		Integer pluginType = (Integer)attributes.get("pluginType");

		if (pluginType != null) {
			setPluginType(pluginType);
		}

		Double currentVersion = (Double)attributes.get("currentVersion");

		if (currentVersion != null) {
			setCurrentVersion(currentVersion);
		}

		String previousVersions = (String)attributes.get("previousVersions");

		if (previousVersions != null) {
			setPreviousVersions(previousVersions);
		}

		Double currentSize = (Double)attributes.get("currentSize");

		if (currentSize != null) {
			setCurrentSize(currentSize);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Long serverCompanyId = (Long)attributes.get("serverCompanyId");

		if (serverCompanyId != null) {
			setServerCompanyId(serverCompanyId);
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
	public int getPluginType() {
		return _pluginType;
	}

	public void setPluginType(int pluginType) {
		_pluginType = pluginType;
	}

	@JSON
	public double getCurrentVersion() {
		return _currentVersion;
	}

	public void setCurrentVersion(double currentVersion) {
		_columnBitmask |= CURRENTVERSION_COLUMN_BITMASK;

		if (!_setOriginalCurrentVersion) {
			_setOriginalCurrentVersion = true;

			_originalCurrentVersion = _currentVersion;
		}

		_currentVersion = currentVersion;
	}

	public double getOriginalCurrentVersion() {
		return _originalCurrentVersion;
	}

	@JSON
	public String getPreviousVersions() {
		if (_previousVersions == null) {
			return StringPool.BLANK;
		}
		else {
			return _previousVersions;
		}
	}

	public void setPreviousVersions(String previousVersions) {
		_previousVersions = previousVersions;
	}

	@JSON
	public double getCurrentSize() {
		return _currentSize;
	}

	public void setCurrentSize(double currentSize) {
		_currentSize = currentSize;
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
		_modifyDate = modifyDate;
	}

	@JSON
	public long getServerCompanyId() {
		return _serverCompanyId;
	}

	public void setServerCompanyId(long serverCompanyId) {
		_serverCompanyId = serverCompanyId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UpdatePlugins.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UpdatePlugins toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (UpdatePlugins)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		UpdatePluginsImpl updatePluginsImpl = new UpdatePluginsImpl();

		updatePluginsImpl.setPluginId(getPluginId());
		updatePluginsImpl.setPluginName(getPluginName());
		updatePluginsImpl.setPluginCode(getPluginCode());
		updatePluginsImpl.setPluginType(getPluginType());
		updatePluginsImpl.setCurrentVersion(getCurrentVersion());
		updatePluginsImpl.setPreviousVersions(getPreviousVersions());
		updatePluginsImpl.setCurrentSize(getCurrentSize());
		updatePluginsImpl.setCreateDate(getCreateDate());
		updatePluginsImpl.setModifyDate(getModifyDate());
		updatePluginsImpl.setServerCompanyId(getServerCompanyId());

		updatePluginsImpl.resetOriginalValues();

		return updatePluginsImpl;
	}

	public int compareTo(UpdatePlugins updatePlugins) {
		long primaryKey = updatePlugins.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UpdatePlugins updatePlugins = null;

		try {
			updatePlugins = (UpdatePlugins)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = updatePlugins.getPrimaryKey();

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
		UpdatePluginsModelImpl updatePluginsModelImpl = this;

		updatePluginsModelImpl._originalPluginCode = updatePluginsModelImpl._pluginCode;

		updatePluginsModelImpl._originalCurrentVersion = updatePluginsModelImpl._currentVersion;

		updatePluginsModelImpl._setOriginalCurrentVersion = false;

		updatePluginsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UpdatePlugins> toCacheModel() {
		UpdatePluginsCacheModel updatePluginsCacheModel = new UpdatePluginsCacheModel();

		updatePluginsCacheModel.pluginId = getPluginId();

		updatePluginsCacheModel.pluginName = getPluginName();

		String pluginName = updatePluginsCacheModel.pluginName;

		if ((pluginName != null) && (pluginName.length() == 0)) {
			updatePluginsCacheModel.pluginName = null;
		}

		updatePluginsCacheModel.pluginCode = getPluginCode();

		String pluginCode = updatePluginsCacheModel.pluginCode;

		if ((pluginCode != null) && (pluginCode.length() == 0)) {
			updatePluginsCacheModel.pluginCode = null;
		}

		updatePluginsCacheModel.pluginType = getPluginType();

		updatePluginsCacheModel.currentVersion = getCurrentVersion();

		updatePluginsCacheModel.previousVersions = getPreviousVersions();

		String previousVersions = updatePluginsCacheModel.previousVersions;

		if ((previousVersions != null) && (previousVersions.length() == 0)) {
			updatePluginsCacheModel.previousVersions = null;
		}

		updatePluginsCacheModel.currentSize = getCurrentSize();

		Date createDate = getCreateDate();

		if (createDate != null) {
			updatePluginsCacheModel.createDate = createDate.getTime();
		}
		else {
			updatePluginsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			updatePluginsCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			updatePluginsCacheModel.modifyDate = Long.MIN_VALUE;
		}

		updatePluginsCacheModel.serverCompanyId = getServerCompanyId();

		return updatePluginsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{pluginId=");
		sb.append(getPluginId());
		sb.append(", pluginName=");
		sb.append(getPluginName());
		sb.append(", pluginCode=");
		sb.append(getPluginCode());
		sb.append(", pluginType=");
		sb.append(getPluginType());
		sb.append(", currentVersion=");
		sb.append(getCurrentVersion());
		sb.append(", previousVersions=");
		sb.append(getPreviousVersions());
		sb.append(", currentSize=");
		sb.append(getCurrentSize());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", serverCompanyId=");
		sb.append(getServerCompanyId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.autoupdate.model.UpdatePlugins");
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
			"<column><column-name>pluginType</column-name><column-value><![CDATA[");
		sb.append(getPluginType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentVersion</column-name><column-value><![CDATA[");
		sb.append(getCurrentVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousVersions</column-name><column-value><![CDATA[");
		sb.append(getPreviousVersions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentSize</column-name><column-value><![CDATA[");
		sb.append(getCurrentSize());
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
			"<column><column-name>serverCompanyId</column-name><column-value><![CDATA[");
		sb.append(getServerCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UpdatePlugins.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UpdatePlugins.class
		};
	private long _pluginId;
	private String _pluginName;
	private String _pluginCode;
	private String _originalPluginCode;
	private int _pluginType;
	private double _currentVersion;
	private double _originalCurrentVersion;
	private boolean _setOriginalCurrentVersion;
	private String _previousVersions;
	private double _currentSize;
	private Date _createDate;
	private Date _modifyDate;
	private long _serverCompanyId;
	private long _columnBitmask;
	private UpdatePlugins _escapedModelProxy;
}