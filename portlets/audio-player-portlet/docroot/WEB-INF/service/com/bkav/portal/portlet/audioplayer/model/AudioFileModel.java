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

package com.bkav.portal.portlet.audioplayer.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AudioFile service. Represents a row in the &quot;AudioPlayer_AudioFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bkav.portal.portlet.audioplayer.model.impl.AudioFileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bkav.portal.portlet.audioplayer.model.impl.AudioFileImpl}.
 * </p>
 *
 * @author anhbdb
 * @see AudioFile
 * @see com.bkav.portal.portlet.audioplayer.model.impl.AudioFileImpl
 * @see com.bkav.portal.portlet.audioplayer.model.impl.AudioFileModelImpl
 * @generated
 */
public interface AudioFileModel extends BaseModel<AudioFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a audio file model instance should use the {@link AudioFile} interface instead.
	 */

	/**
	 * Returns the primary key of this audio file.
	 *
	 * @return the primary key of this audio file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this audio file.
	 *
	 * @param primaryKey the primary key of this audio file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the audio ID of this audio file.
	 *
	 * @return the audio ID of this audio file
	 */
	public long getAudioId();

	/**
	 * Sets the audio ID of this audio file.
	 *
	 * @param audioId the audio ID of this audio file
	 */
	public void setAudioId(long audioId);

	/**
	 * Returns the audio name of this audio file.
	 *
	 * @return the audio name of this audio file
	 */
	@AutoEscape
	public String getAudioName();

	/**
	 * Sets the audio name of this audio file.
	 *
	 * @param audioName the audio name of this audio file
	 */
	public void setAudioName(String audioName);

	/**
	 * Returns the audio info of this audio file.
	 *
	 * @return the audio info of this audio file
	 */
	@AutoEscape
	public String getAudioInfo();

	/**
	 * Sets the audio info of this audio file.
	 *
	 * @param audioInfo the audio info of this audio file
	 */
	public void setAudioInfo(String audioInfo);

	/**
	 * Returns the audio type of this audio file.
	 *
	 * @return the audio type of this audio file
	 */
	@AutoEscape
	public String getAudioType();

	/**
	 * Sets the audio type of this audio file.
	 *
	 * @param audioType the audio type of this audio file
	 */
	public void setAudioType(String audioType);

	/**
	 * Returns the audio file ID of this audio file.
	 *
	 * @return the audio file ID of this audio file
	 */
	public long getAudioFileId();

	/**
	 * Sets the audio file ID of this audio file.
	 *
	 * @param audioFileId the audio file ID of this audio file
	 */
	public void setAudioFileId(long audioFileId);

	/**
	 * Returns the create date of this audio file.
	 *
	 * @return the create date of this audio file
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this audio file.
	 *
	 * @param createDate the create date of this audio file
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modify date of this audio file.
	 *
	 * @return the modify date of this audio file
	 */
	public Date getModifyDate();

	/**
	 * Sets the modify date of this audio file.
	 *
	 * @param modifyDate the modify date of this audio file
	 */
	public void setModifyDate(Date modifyDate);

	/**
	 * Returns the group ID of this audio file.
	 *
	 * @return the group ID of this audio file
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this audio file.
	 *
	 * @param groupId the group ID of this audio file
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this audio file.
	 *
	 * @return the company ID of this audio file
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this audio file.
	 *
	 * @param companyId the company ID of this audio file
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this audio file.
	 *
	 * @return the user ID of this audio file
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this audio file.
	 *
	 * @param userId the user ID of this audio file
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this audio file.
	 *
	 * @return the user uuid of this audio file
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this audio file.
	 *
	 * @param userUuid the user uuid of this audio file
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this audio file.
	 *
	 * @return the user name of this audio file
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this audio file.
	 *
	 * @param userName the user name of this audio file
	 */
	public void setUserName(String userName);

	/**
	 * Returns the view counter of this audio file.
	 *
	 * @return the view counter of this audio file
	 */
	public long getViewCounter();

	/**
	 * Sets the view counter of this audio file.
	 *
	 * @param viewCounter the view counter of this audio file
	 */
	public void setViewCounter(long viewCounter);

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

	public int compareTo(AudioFile audioFile);

	public int hashCode();

	public CacheModel<AudioFile> toCacheModel();

	public AudioFile toEscapedModel();

	public String toString();

	public String toXmlString();
}