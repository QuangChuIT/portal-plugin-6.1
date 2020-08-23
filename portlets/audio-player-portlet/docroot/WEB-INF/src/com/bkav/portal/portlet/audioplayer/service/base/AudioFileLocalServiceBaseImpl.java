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

package com.bkav.portal.portlet.audioplayer.service.base;

import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalService;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapService;
import com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalService;
import com.bkav.portal.portlet.audioplayer.service.AudioAlbumService;
import com.bkav.portal.portlet.audioplayer.service.AudioFileLocalService;
import com.bkav.portal.portlet.audioplayer.service.AudioFileService;
import com.bkav.portal.portlet.audioplayer.service.persistence.AlbumAudioMapPersistence;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioAlbumPersistence;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioFileFinder;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioFilePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the audio file local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.audioplayer.service.impl.AudioFileLocalServiceImpl}.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.audioplayer.service.impl.AudioFileLocalServiceImpl
 * @see com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil
 * @generated
 */
public abstract class AudioFileLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AudioFileLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil} to access the audio file local service.
	 */

	/**
	 * Adds the audio file to the database. Also notifies the appropriate model listeners.
	 *
	 * @param audioFile the audio file
	 * @return the audio file that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AudioFile addAudioFile(AudioFile audioFile)
		throws SystemException {
		audioFile.setNew(true);

		return audioFilePersistence.update(audioFile, false);
	}

	/**
	 * Creates a new audio file with the primary key. Does not add the audio file to the database.
	 *
	 * @param audioId the primary key for the new audio file
	 * @return the new audio file
	 */
	public AudioFile createAudioFile(long audioId) {
		return audioFilePersistence.create(audioId);
	}

	/**
	 * Deletes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param audioId the primary key of the audio file
	 * @return the audio file that was removed
	 * @throws PortalException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public AudioFile deleteAudioFile(long audioId)
		throws PortalException, SystemException {
		return audioFilePersistence.remove(audioId);
	}

	/**
	 * Deletes the audio file from the database. Also notifies the appropriate model listeners.
	 *
	 * @param audioFile the audio file
	 * @return the audio file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public AudioFile deleteAudioFile(AudioFile audioFile)
		throws SystemException {
		return audioFilePersistence.remove(audioFile);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AudioFile.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return audioFilePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return audioFilePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return audioFilePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return audioFilePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public AudioFile fetchAudioFile(long audioId) throws SystemException {
		return audioFilePersistence.fetchByPrimaryKey(audioId);
	}

	/**
	 * Returns the audio file with the primary key.
	 *
	 * @param audioId the primary key of the audio file
	 * @return the audio file
	 * @throws PortalException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile getAudioFile(long audioId)
		throws PortalException, SystemException {
		return audioFilePersistence.findByPrimaryKey(audioId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return audioFilePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the audio files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @return the range of audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> getAudioFiles(int start, int end)
		throws SystemException {
		return audioFilePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of audio files.
	 *
	 * @return the number of audio files
	 * @throws SystemException if a system exception occurred
	 */
	public int getAudioFilesCount() throws SystemException {
		return audioFilePersistence.countAll();
	}

	/**
	 * Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param audioFile the audio file
	 * @return the audio file that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AudioFile updateAudioFile(AudioFile audioFile)
		throws SystemException {
		return updateAudioFile(audioFile, true);
	}

	/**
	 * Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param audioFile the audio file
	 * @param merge whether to merge the audio file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the audio file that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AudioFile updateAudioFile(AudioFile audioFile, boolean merge)
		throws SystemException {
		audioFile.setNew(false);

		return audioFilePersistence.update(audioFile, merge);
	}

	/**
	 * Returns the album audio map local service.
	 *
	 * @return the album audio map local service
	 */
	public AlbumAudioMapLocalService getAlbumAudioMapLocalService() {
		return albumAudioMapLocalService;
	}

	/**
	 * Sets the album audio map local service.
	 *
	 * @param albumAudioMapLocalService the album audio map local service
	 */
	public void setAlbumAudioMapLocalService(
		AlbumAudioMapLocalService albumAudioMapLocalService) {
		this.albumAudioMapLocalService = albumAudioMapLocalService;
	}

	/**
	 * Returns the album audio map remote service.
	 *
	 * @return the album audio map remote service
	 */
	public AlbumAudioMapService getAlbumAudioMapService() {
		return albumAudioMapService;
	}

	/**
	 * Sets the album audio map remote service.
	 *
	 * @param albumAudioMapService the album audio map remote service
	 */
	public void setAlbumAudioMapService(
		AlbumAudioMapService albumAudioMapService) {
		this.albumAudioMapService = albumAudioMapService;
	}

	/**
	 * Returns the album audio map persistence.
	 *
	 * @return the album audio map persistence
	 */
	public AlbumAudioMapPersistence getAlbumAudioMapPersistence() {
		return albumAudioMapPersistence;
	}

	/**
	 * Sets the album audio map persistence.
	 *
	 * @param albumAudioMapPersistence the album audio map persistence
	 */
	public void setAlbumAudioMapPersistence(
		AlbumAudioMapPersistence albumAudioMapPersistence) {
		this.albumAudioMapPersistence = albumAudioMapPersistence;
	}

	/**
	 * Returns the audio album local service.
	 *
	 * @return the audio album local service
	 */
	public AudioAlbumLocalService getAudioAlbumLocalService() {
		return audioAlbumLocalService;
	}

	/**
	 * Sets the audio album local service.
	 *
	 * @param audioAlbumLocalService the audio album local service
	 */
	public void setAudioAlbumLocalService(
		AudioAlbumLocalService audioAlbumLocalService) {
		this.audioAlbumLocalService = audioAlbumLocalService;
	}

	/**
	 * Returns the audio album remote service.
	 *
	 * @return the audio album remote service
	 */
	public AudioAlbumService getAudioAlbumService() {
		return audioAlbumService;
	}

	/**
	 * Sets the audio album remote service.
	 *
	 * @param audioAlbumService the audio album remote service
	 */
	public void setAudioAlbumService(AudioAlbumService audioAlbumService) {
		this.audioAlbumService = audioAlbumService;
	}

	/**
	 * Returns the audio album persistence.
	 *
	 * @return the audio album persistence
	 */
	public AudioAlbumPersistence getAudioAlbumPersistence() {
		return audioAlbumPersistence;
	}

	/**
	 * Sets the audio album persistence.
	 *
	 * @param audioAlbumPersistence the audio album persistence
	 */
	public void setAudioAlbumPersistence(
		AudioAlbumPersistence audioAlbumPersistence) {
		this.audioAlbumPersistence = audioAlbumPersistence;
	}

	/**
	 * Returns the audio file local service.
	 *
	 * @return the audio file local service
	 */
	public AudioFileLocalService getAudioFileLocalService() {
		return audioFileLocalService;
	}

	/**
	 * Sets the audio file local service.
	 *
	 * @param audioFileLocalService the audio file local service
	 */
	public void setAudioFileLocalService(
		AudioFileLocalService audioFileLocalService) {
		this.audioFileLocalService = audioFileLocalService;
	}

	/**
	 * Returns the audio file remote service.
	 *
	 * @return the audio file remote service
	 */
	public AudioFileService getAudioFileService() {
		return audioFileService;
	}

	/**
	 * Sets the audio file remote service.
	 *
	 * @param audioFileService the audio file remote service
	 */
	public void setAudioFileService(AudioFileService audioFileService) {
		this.audioFileService = audioFileService;
	}

	/**
	 * Returns the audio file persistence.
	 *
	 * @return the audio file persistence
	 */
	public AudioFilePersistence getAudioFilePersistence() {
		return audioFilePersistence;
	}

	/**
	 * Sets the audio file persistence.
	 *
	 * @param audioFilePersistence the audio file persistence
	 */
	public void setAudioFilePersistence(
		AudioFilePersistence audioFilePersistence) {
		this.audioFilePersistence = audioFilePersistence;
	}

	/**
	 * Returns the audio file finder.
	 *
	 * @return the audio file finder
	 */
	public AudioFileFinder getAudioFileFinder() {
		return audioFileFinder;
	}

	/**
	 * Sets the audio file finder.
	 *
	 * @param audioFileFinder the audio file finder
	 */
	public void setAudioFileFinder(AudioFileFinder audioFileFinder) {
		this.audioFileFinder = audioFileFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.bkav.portal.portlet.audioplayer.model.AudioFile",
			audioFileLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.bkav.portal.portlet.audioplayer.model.AudioFile");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return AudioFile.class;
	}

	protected String getModelClassName() {
		return AudioFile.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = audioFilePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AlbumAudioMapLocalService.class)
	protected AlbumAudioMapLocalService albumAudioMapLocalService;
	@BeanReference(type = AlbumAudioMapService.class)
	protected AlbumAudioMapService albumAudioMapService;
	@BeanReference(type = AlbumAudioMapPersistence.class)
	protected AlbumAudioMapPersistence albumAudioMapPersistence;
	@BeanReference(type = AudioAlbumLocalService.class)
	protected AudioAlbumLocalService audioAlbumLocalService;
	@BeanReference(type = AudioAlbumService.class)
	protected AudioAlbumService audioAlbumService;
	@BeanReference(type = AudioAlbumPersistence.class)
	protected AudioAlbumPersistence audioAlbumPersistence;
	@BeanReference(type = AudioFileLocalService.class)
	protected AudioFileLocalService audioFileLocalService;
	@BeanReference(type = AudioFileService.class)
	protected AudioFileService audioFileService;
	@BeanReference(type = AudioFilePersistence.class)
	protected AudioFilePersistence audioFilePersistence;
	@BeanReference(type = AudioFileFinder.class)
	protected AudioFileFinder audioFileFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private AudioFileLocalServiceClpInvoker _clpInvoker = new AudioFileLocalServiceClpInvoker();
}