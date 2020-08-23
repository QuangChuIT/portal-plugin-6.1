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

package com.portal_egov.portlet.citymaps.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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

import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.model.CityMapModel;
import com.portal_egov.portlet.citymaps.model.CityMapSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CityMap service. Represents a row in the &quot;CityMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.citymaps.model.CityMapModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CityMapImpl}.
 * </p>
 *
 * @author HungDX
 * @see CityMapImpl
 * @see com.portal_egov.portlet.citymaps.model.CityMap
 * @see com.portal_egov.portlet.citymaps.model.CityMapModel
 * @generated
 */
@JSON(strict = true)
public class CityMapModelImpl extends BaseModelImpl<CityMap>
	implements CityMapModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a city map model instance should use the {@link com.portal_egov.portlet.citymaps.model.CityMap} interface instead.
	 */
	public static final String TABLE_NAME = "CityMap";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mapId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "mapTypeId", Types.BIGINT },
			{ "mapImageId", Types.BIGINT },
			{ "mapName", Types.VARCHAR },
			{ "mapDesc", Types.VARCHAR },
			{ "mapSumary", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CityMap (mapId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,mapTypeId LONG,mapImageId LONG,mapName VARCHAR(300) null,mapDesc VARCHAR(1000) null,mapSumary VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CityMap";
	public static final String ORDER_BY_JPQL = " ORDER BY cityMap.mapTypeId ASC, cityMap.mapName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CityMap.mapTypeId ASC, CityMap.mapName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.citymaps.model.CityMap"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.citymaps.model.CityMap"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.citymaps.model.CityMap"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long MAPTYPEID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CityMap toModel(CityMapSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CityMap model = new CityMapImpl();

		model.setMapId(soapModel.getMapId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setMapTypeId(soapModel.getMapTypeId());
		model.setMapImageId(soapModel.getMapImageId());
		model.setMapName(soapModel.getMapName());
		model.setMapDesc(soapModel.getMapDesc());
		model.setMapSumary(soapModel.getMapSumary());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CityMap> toModels(CityMapSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CityMap> models = new ArrayList<CityMap>(soapModels.length);

		for (CityMapSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.citymaps.model.CityMap"));

	public CityMapModelImpl() {
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMapId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mapId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CityMap.class;
	}

	public String getModelClassName() {
		return CityMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mapTypeId", getMapTypeId());
		attributes.put("mapImageId", getMapImageId());
		attributes.put("mapName", getMapName());
		attributes.put("mapDesc", getMapDesc());
		attributes.put("mapSumary", getMapSumary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapId = (Long)attributes.get("mapId");

		if (mapId != null) {
			setMapId(mapId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long mapTypeId = (Long)attributes.get("mapTypeId");

		if (mapTypeId != null) {
			setMapTypeId(mapTypeId);
		}

		Long mapImageId = (Long)attributes.get("mapImageId");

		if (mapImageId != null) {
			setMapImageId(mapImageId);
		}

		String mapName = (String)attributes.get("mapName");

		if (mapName != null) {
			setMapName(mapName);
		}

		String mapDesc = (String)attributes.get("mapDesc");

		if (mapDesc != null) {
			setMapDesc(mapDesc);
		}

		String mapSumary = (String)attributes.get("mapSumary");

		if (mapSumary != null) {
			setMapSumary(mapSumary);
		}
	}

	@JSON
	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
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
	public long getMapTypeId() {
		return _mapTypeId;
	}

	public void setMapTypeId(long mapTypeId) {
		_columnBitmask = -1L;

		if (!_setOriginalMapTypeId) {
			_setOriginalMapTypeId = true;

			_originalMapTypeId = _mapTypeId;
		}

		_mapTypeId = mapTypeId;
	}

	public long getOriginalMapTypeId() {
		return _originalMapTypeId;
	}

	@JSON
	public long getMapImageId() {
		return _mapImageId;
	}

	public void setMapImageId(long mapImageId) {
		_mapImageId = mapImageId;
	}

	@JSON
	public String getMapName() {
		if (_mapName == null) {
			return StringPool.BLANK;
		}
		else {
			return _mapName;
		}
	}

	public void setMapName(String mapName) {
		_columnBitmask = -1L;

		_mapName = mapName;
	}

	@JSON
	public String getMapDesc() {
		if (_mapDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _mapDesc;
		}
	}

	public void setMapDesc(String mapDesc) {
		_mapDesc = mapDesc;
	}

	@JSON
	public String getMapSumary() {
		if (_mapSumary == null) {
			return StringPool.BLANK;
		}
		else {
			return _mapSumary;
		}
	}

	public void setMapSumary(String mapSumary) {
		_mapSumary = mapSumary;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CityMap.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CityMap toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CityMap)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CityMapImpl cityMapImpl = new CityMapImpl();

		cityMapImpl.setMapId(getMapId());
		cityMapImpl.setCompanyId(getCompanyId());
		cityMapImpl.setGroupId(getGroupId());
		cityMapImpl.setUserId(getUserId());
		cityMapImpl.setUserName(getUserName());
		cityMapImpl.setCreateDate(getCreateDate());
		cityMapImpl.setModifiedDate(getModifiedDate());
		cityMapImpl.setMapTypeId(getMapTypeId());
		cityMapImpl.setMapImageId(getMapImageId());
		cityMapImpl.setMapName(getMapName());
		cityMapImpl.setMapDesc(getMapDesc());
		cityMapImpl.setMapSumary(getMapSumary());

		cityMapImpl.resetOriginalValues();

		return cityMapImpl;
	}

	public int compareTo(CityMap cityMap) {
		int value = 0;

		if (getMapTypeId() < cityMap.getMapTypeId()) {
			value = -1;
		}
		else if (getMapTypeId() > cityMap.getMapTypeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getMapName().compareTo(cityMap.getMapName());

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

		CityMap cityMap = null;

		try {
			cityMap = (CityMap)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cityMap.getPrimaryKey();

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
		CityMapModelImpl cityMapModelImpl = this;

		cityMapModelImpl._originalCompanyId = cityMapModelImpl._companyId;

		cityMapModelImpl._setOriginalCompanyId = false;

		cityMapModelImpl._originalGroupId = cityMapModelImpl._groupId;

		cityMapModelImpl._setOriginalGroupId = false;

		cityMapModelImpl._originalMapTypeId = cityMapModelImpl._mapTypeId;

		cityMapModelImpl._setOriginalMapTypeId = false;

		cityMapModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CityMap> toCacheModel() {
		CityMapCacheModel cityMapCacheModel = new CityMapCacheModel();

		cityMapCacheModel.mapId = getMapId();

		cityMapCacheModel.companyId = getCompanyId();

		cityMapCacheModel.groupId = getGroupId();

		cityMapCacheModel.userId = getUserId();

		cityMapCacheModel.userName = getUserName();

		String userName = cityMapCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cityMapCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cityMapCacheModel.createDate = createDate.getTime();
		}
		else {
			cityMapCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cityMapCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cityMapCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cityMapCacheModel.mapTypeId = getMapTypeId();

		cityMapCacheModel.mapImageId = getMapImageId();

		cityMapCacheModel.mapName = getMapName();

		String mapName = cityMapCacheModel.mapName;

		if ((mapName != null) && (mapName.length() == 0)) {
			cityMapCacheModel.mapName = null;
		}

		cityMapCacheModel.mapDesc = getMapDesc();

		String mapDesc = cityMapCacheModel.mapDesc;

		if ((mapDesc != null) && (mapDesc.length() == 0)) {
			cityMapCacheModel.mapDesc = null;
		}

		cityMapCacheModel.mapSumary = getMapSumary();

		String mapSumary = cityMapCacheModel.mapSumary;

		if ((mapSumary != null) && (mapSumary.length() == 0)) {
			cityMapCacheModel.mapSumary = null;
		}

		return cityMapCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mapId=");
		sb.append(getMapId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", mapTypeId=");
		sb.append(getMapTypeId());
		sb.append(", mapImageId=");
		sb.append(getMapImageId());
		sb.append(", mapName=");
		sb.append(getMapName());
		sb.append(", mapDesc=");
		sb.append(getMapDesc());
		sb.append(", mapSumary=");
		sb.append(getMapSumary());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.citymaps.model.CityMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mapId</column-name><column-value><![CDATA[");
		sb.append(getMapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>mapTypeId</column-name><column-value><![CDATA[");
		sb.append(getMapTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapImageId</column-name><column-value><![CDATA[");
		sb.append(getMapImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapName</column-name><column-value><![CDATA[");
		sb.append(getMapName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapDesc</column-name><column-value><![CDATA[");
		sb.append(getMapDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapSumary</column-name><column-value><![CDATA[");
		sb.append(getMapSumary());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CityMap.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CityMap.class
		};
	private long _mapId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mapTypeId;
	private long _originalMapTypeId;
	private boolean _setOriginalMapTypeId;
	private long _mapImageId;
	private String _mapName;
	private String _mapDesc;
	private String _mapSumary;
	private long _columnBitmask;
	private CityMap _escapedModelProxy;
}