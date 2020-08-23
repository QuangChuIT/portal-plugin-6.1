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

package com.bkav.portal.portlet.audioplayer.model.impl;

import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;
import com.bkav.portal.portlet.audioplayer.model.AudioAlbumModel;
import com.bkav.portal.portlet.audioplayer.model.AudioAlbumSoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AudioAlbum service. Represents a row in the &quot;AudioPlayer_AudioAlbum&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.audioplayer.model.AudioAlbumModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AudioAlbumImpl}.
 * </p>
 *
 * @author anhbdb
 * @see AudioAlbumImpl
 * @see com.bkav.portal.portlet.audioplayer.model.AudioAlbum
 * @see com.bkav.portal.portlet.audioplayer.model.AudioAlbumModel
 * @generated
 */
@JSON(strict = true)
public class AudioAlbumModelImpl extends BaseModelImpl<AudioAlbum>
	implements AudioAlbumModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audio album model instance should use the {@link com.bkav.portal.portlet.audioplayer.model.AudioAlbum} interface instead.
	 */
	public static final String TABLE_NAME = "AudioPlayer_AudioAlbum";
	public static final Object[][] TABLE_COLUMNS = {
			{ "albumId", Types.BIGINT },
			{ "albumName", Types.VARCHAR },
			{ "albumInfo", Types.VARCHAR },
			{ "albumCoverId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "viewCounter", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table AudioPlayer_AudioAlbum (albumId LONG not null primary key,albumName VARCHAR(75) null,albumInfo VARCHAR(75) null,albumCoverId LONG,createDate DATE null,modifyDate DATE null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,viewCounter LONG)";
	public static final String TABLE_SQL_DROP = "drop table AudioPlayer_AudioAlbum";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.audioplayer.model.AudioAlbum"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.audioplayer.model.AudioAlbum"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.audioplayer.model.AudioAlbum"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AudioAlbum toModel(AudioAlbumSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AudioAlbum model = new AudioAlbumImpl();

		model.setAlbumId(soapModel.getAlbumId());
		model.setAlbumName(soapModel.getAlbumName());
		model.setAlbumInfo(soapModel.getAlbumInfo());
		model.setAlbumCoverId(soapModel.getAlbumCoverId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifyDate(soapModel.getModifyDate());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setViewCounter(soapModel.getViewCounter());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AudioAlbum> toModels(AudioAlbumSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AudioAlbum> models = new ArrayList<AudioAlbum>(soapModels.length);

		for (AudioAlbumSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.audioplayer.model.AudioAlbum"));

	public AudioAlbumModelImpl() {
	}

	public long getPrimaryKey() {
		return _albumId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAlbumId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_albumId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return AudioAlbum.class;
	}

	public String getModelClassName() {
		return AudioAlbum.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albumId", getAlbumId());
		attributes.put("albumName", getAlbumName());
		attributes.put("albumInfo", getAlbumInfo());
		attributes.put("albumCoverId", getAlbumCoverId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("viewCounter", getViewCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		String albumName = (String)attributes.get("albumName");

		if (albumName != null) {
			setAlbumName(albumName);
		}

		String albumInfo = (String)attributes.get("albumInfo");

		if (albumInfo != null) {
			setAlbumInfo(albumInfo);
		}

		Long albumCoverId = (Long)attributes.get("albumCoverId");

		if (albumCoverId != null) {
			setAlbumCoverId(albumCoverId);
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

		Long viewCounter = (Long)attributes.get("viewCounter");

		if (viewCounter != null) {
			setViewCounter(viewCounter);
		}
	}

	@JSON
	public long getAlbumId() {
		return _albumId;
	}

	public void setAlbumId(long albumId) {
		_albumId = albumId;
	}

	@JSON
	public String getAlbumName() {
		if (_albumName == null) {
			return StringPool.BLANK;
		}
		else {
			return _albumName;
		}
	}

	public void setAlbumName(String albumName) {
		_albumName = albumName;
	}

	@JSON
	public String getAlbumInfo() {
		if (_albumInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _albumInfo;
		}
	}

	public void setAlbumInfo(String albumInfo) {
		_albumInfo = albumInfo;
	}

	@JSON
	public long getAlbumCoverId() {
		return _albumCoverId;
	}

	public void setAlbumCoverId(long albumCoverId) {
		_albumCoverId = albumCoverId;
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
	public long getViewCounter() {
		return _viewCounter;
	}

	public void setViewCounter(long viewCounter) {
		_viewCounter = viewCounter;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AudioAlbum.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AudioAlbum toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (AudioAlbum)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		AudioAlbumImpl audioAlbumImpl = new AudioAlbumImpl();

		audioAlbumImpl.setAlbumId(getAlbumId());
		audioAlbumImpl.setAlbumName(getAlbumName());
		audioAlbumImpl.setAlbumInfo(getAlbumInfo());
		audioAlbumImpl.setAlbumCoverId(getAlbumCoverId());
		audioAlbumImpl.setCreateDate(getCreateDate());
		audioAlbumImpl.setModifyDate(getModifyDate());
		audioAlbumImpl.setGroupId(getGroupId());
		audioAlbumImpl.setCompanyId(getCompanyId());
		audioAlbumImpl.setUserId(getUserId());
		audioAlbumImpl.setUserName(getUserName());
		audioAlbumImpl.setViewCounter(getViewCounter());

		audioAlbumImpl.resetOriginalValues();

		return audioAlbumImpl;
	}

	public int compareTo(AudioAlbum audioAlbum) {
		long primaryKey = audioAlbum.getPrimaryKey();

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

		AudioAlbum audioAlbum = null;

		try {
			audioAlbum = (AudioAlbum)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = audioAlbum.getPrimaryKey();

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
		AudioAlbumModelImpl audioAlbumModelImpl = this;

		audioAlbumModelImpl._originalGroupId = audioAlbumModelImpl._groupId;

		audioAlbumModelImpl._setOriginalGroupId = false;

		audioAlbumModelImpl._originalCompanyId = audioAlbumModelImpl._companyId;

		audioAlbumModelImpl._setOriginalCompanyId = false;

		audioAlbumModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AudioAlbum> toCacheModel() {
		AudioAlbumCacheModel audioAlbumCacheModel = new AudioAlbumCacheModel();

		audioAlbumCacheModel.albumId = getAlbumId();

		audioAlbumCacheModel.albumName = getAlbumName();

		String albumName = audioAlbumCacheModel.albumName;

		if ((albumName != null) && (albumName.length() == 0)) {
			audioAlbumCacheModel.albumName = null;
		}

		audioAlbumCacheModel.albumInfo = getAlbumInfo();

		String albumInfo = audioAlbumCacheModel.albumInfo;

		if ((albumInfo != null) && (albumInfo.length() == 0)) {
			audioAlbumCacheModel.albumInfo = null;
		}

		audioAlbumCacheModel.albumCoverId = getAlbumCoverId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			audioAlbumCacheModel.createDate = createDate.getTime();
		}
		else {
			audioAlbumCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			audioAlbumCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			audioAlbumCacheModel.modifyDate = Long.MIN_VALUE;
		}

		audioAlbumCacheModel.groupId = getGroupId();

		audioAlbumCacheModel.companyId = getCompanyId();

		audioAlbumCacheModel.userId = getUserId();

		audioAlbumCacheModel.userName = getUserName();

		String userName = audioAlbumCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			audioAlbumCacheModel.userName = null;
		}

		audioAlbumCacheModel.viewCounter = getViewCounter();

		return audioAlbumCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{albumId=");
		sb.append(getAlbumId());
		sb.append(", albumName=");
		sb.append(getAlbumName());
		sb.append(", albumInfo=");
		sb.append(getAlbumInfo());
		sb.append(", albumCoverId=");
		sb.append(getAlbumCoverId());
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
		sb.append(", viewCounter=");
		sb.append(getViewCounter());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.audioplayer.model.AudioAlbum");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumName</column-name><column-value><![CDATA[");
		sb.append(getAlbumName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumInfo</column-name><column-value><![CDATA[");
		sb.append(getAlbumInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumCoverId</column-name><column-value><![CDATA[");
		sb.append(getAlbumCoverId());
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
		sb.append(
			"<column><column-name>viewCounter</column-name><column-value><![CDATA[");
		sb.append(getViewCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AudioAlbum.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			AudioAlbum.class
		};
	private long _albumId;
	private String _albumName;
	private String _albumInfo;
	private long _albumCoverId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _viewCounter;
	private long _columnBitmask;
	private AudioAlbum _escapedModelProxy;
}