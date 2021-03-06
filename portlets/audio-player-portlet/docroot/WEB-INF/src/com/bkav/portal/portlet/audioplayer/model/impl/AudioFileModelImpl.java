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

import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.model.AudioFileModel;
import com.bkav.portal.portlet.audioplayer.model.AudioFileSoap;

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
 * The base model implementation for the AudioFile service. Represents a row in the &quot;AudioPlayer_AudioFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.audioplayer.model.AudioFileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AudioFileImpl}.
 * </p>
 *
 * @author anhbdb
 * @see AudioFileImpl
 * @see com.bkav.portal.portlet.audioplayer.model.AudioFile
 * @see com.bkav.portal.portlet.audioplayer.model.AudioFileModel
 * @generated
 */
@JSON(strict = true)
public class AudioFileModelImpl extends BaseModelImpl<AudioFile>
	implements AudioFileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audio file model instance should use the {@link com.bkav.portal.portlet.audioplayer.model.AudioFile} interface instead.
	 */
	public static final String TABLE_NAME = "AudioPlayer_AudioFile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "audioId", Types.BIGINT },
			{ "audioName", Types.VARCHAR },
			{ "audioInfo", Types.VARCHAR },
			{ "audioType", Types.VARCHAR },
			{ "audioFileId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "viewCounter", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table AudioPlayer_AudioFile (audioId LONG not null primary key,audioName VARCHAR(75) null,audioInfo VARCHAR(75) null,audioType VARCHAR(75) null,audioFileId LONG,createDate DATE null,modifyDate DATE null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,viewCounter LONG)";
	public static final String TABLE_SQL_DROP = "drop table AudioPlayer_AudioFile";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.audioplayer.model.AudioFile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.audioplayer.model.AudioFile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.audioplayer.model.AudioFile"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AudioFile toModel(AudioFileSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AudioFile model = new AudioFileImpl();

		model.setAudioId(soapModel.getAudioId());
		model.setAudioName(soapModel.getAudioName());
		model.setAudioInfo(soapModel.getAudioInfo());
		model.setAudioType(soapModel.getAudioType());
		model.setAudioFileId(soapModel.getAudioFileId());
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
	public static List<AudioFile> toModels(AudioFileSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AudioFile> models = new ArrayList<AudioFile>(soapModels.length);

		for (AudioFileSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.audioplayer.model.AudioFile"));

	public AudioFileModelImpl() {
	}

	public long getPrimaryKey() {
		return _audioId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAudioId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_audioId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return AudioFile.class;
	}

	public String getModelClassName() {
		return AudioFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("audioId", getAudioId());
		attributes.put("audioName", getAudioName());
		attributes.put("audioInfo", getAudioInfo());
		attributes.put("audioType", getAudioType());
		attributes.put("audioFileId", getAudioFileId());
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
		Long audioId = (Long)attributes.get("audioId");

		if (audioId != null) {
			setAudioId(audioId);
		}

		String audioName = (String)attributes.get("audioName");

		if (audioName != null) {
			setAudioName(audioName);
		}

		String audioInfo = (String)attributes.get("audioInfo");

		if (audioInfo != null) {
			setAudioInfo(audioInfo);
		}

		String audioType = (String)attributes.get("audioType");

		if (audioType != null) {
			setAudioType(audioType);
		}

		Long audioFileId = (Long)attributes.get("audioFileId");

		if (audioFileId != null) {
			setAudioFileId(audioFileId);
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
	public long getAudioId() {
		return _audioId;
	}

	public void setAudioId(long audioId) {
		_audioId = audioId;
	}

	@JSON
	public String getAudioName() {
		if (_audioName == null) {
			return StringPool.BLANK;
		}
		else {
			return _audioName;
		}
	}

	public void setAudioName(String audioName) {
		_audioName = audioName;
	}

	@JSON
	public String getAudioInfo() {
		if (_audioInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _audioInfo;
		}
	}

	public void setAudioInfo(String audioInfo) {
		_audioInfo = audioInfo;
	}

	@JSON
	public String getAudioType() {
		if (_audioType == null) {
			return StringPool.BLANK;
		}
		else {
			return _audioType;
		}
	}

	public void setAudioType(String audioType) {
		_audioType = audioType;
	}

	@JSON
	public long getAudioFileId() {
		return _audioFileId;
	}

	public void setAudioFileId(long audioFileId) {
		_audioFileId = audioFileId;
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
			AudioFile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AudioFile toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (AudioFile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		AudioFileImpl audioFileImpl = new AudioFileImpl();

		audioFileImpl.setAudioId(getAudioId());
		audioFileImpl.setAudioName(getAudioName());
		audioFileImpl.setAudioInfo(getAudioInfo());
		audioFileImpl.setAudioType(getAudioType());
		audioFileImpl.setAudioFileId(getAudioFileId());
		audioFileImpl.setCreateDate(getCreateDate());
		audioFileImpl.setModifyDate(getModifyDate());
		audioFileImpl.setGroupId(getGroupId());
		audioFileImpl.setCompanyId(getCompanyId());
		audioFileImpl.setUserId(getUserId());
		audioFileImpl.setUserName(getUserName());
		audioFileImpl.setViewCounter(getViewCounter());

		audioFileImpl.resetOriginalValues();

		return audioFileImpl;
	}

	public int compareTo(AudioFile audioFile) {
		long primaryKey = audioFile.getPrimaryKey();

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

		AudioFile audioFile = null;

		try {
			audioFile = (AudioFile)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = audioFile.getPrimaryKey();

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
		AudioFileModelImpl audioFileModelImpl = this;

		audioFileModelImpl._originalGroupId = audioFileModelImpl._groupId;

		audioFileModelImpl._setOriginalGroupId = false;

		audioFileModelImpl._originalCompanyId = audioFileModelImpl._companyId;

		audioFileModelImpl._setOriginalCompanyId = false;

		audioFileModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AudioFile> toCacheModel() {
		AudioFileCacheModel audioFileCacheModel = new AudioFileCacheModel();

		audioFileCacheModel.audioId = getAudioId();

		audioFileCacheModel.audioName = getAudioName();

		String audioName = audioFileCacheModel.audioName;

		if ((audioName != null) && (audioName.length() == 0)) {
			audioFileCacheModel.audioName = null;
		}

		audioFileCacheModel.audioInfo = getAudioInfo();

		String audioInfo = audioFileCacheModel.audioInfo;

		if ((audioInfo != null) && (audioInfo.length() == 0)) {
			audioFileCacheModel.audioInfo = null;
		}

		audioFileCacheModel.audioType = getAudioType();

		String audioType = audioFileCacheModel.audioType;

		if ((audioType != null) && (audioType.length() == 0)) {
			audioFileCacheModel.audioType = null;
		}

		audioFileCacheModel.audioFileId = getAudioFileId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			audioFileCacheModel.createDate = createDate.getTime();
		}
		else {
			audioFileCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			audioFileCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			audioFileCacheModel.modifyDate = Long.MIN_VALUE;
		}

		audioFileCacheModel.groupId = getGroupId();

		audioFileCacheModel.companyId = getCompanyId();

		audioFileCacheModel.userId = getUserId();

		audioFileCacheModel.userName = getUserName();

		String userName = audioFileCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			audioFileCacheModel.userName = null;
		}

		audioFileCacheModel.viewCounter = getViewCounter();

		return audioFileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{audioId=");
		sb.append(getAudioId());
		sb.append(", audioName=");
		sb.append(getAudioName());
		sb.append(", audioInfo=");
		sb.append(getAudioInfo());
		sb.append(", audioType=");
		sb.append(getAudioType());
		sb.append(", audioFileId=");
		sb.append(getAudioFileId());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.audioplayer.model.AudioFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>audioId</column-name><column-value><![CDATA[");
		sb.append(getAudioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioName</column-name><column-value><![CDATA[");
		sb.append(getAudioName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioInfo</column-name><column-value><![CDATA[");
		sb.append(getAudioInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioType</column-name><column-value><![CDATA[");
		sb.append(getAudioType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioFileId</column-name><column-value><![CDATA[");
		sb.append(getAudioFileId());
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

	private static ClassLoader _classLoader = AudioFile.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			AudioFile.class
		};
	private long _audioId;
	private String _audioName;
	private String _audioInfo;
	private String _audioType;
	private long _audioFileId;
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
	private AudioFile _escapedModelProxy;
}