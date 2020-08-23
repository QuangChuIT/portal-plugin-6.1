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

package com.bkav.portal.portlet.video.service.base;

import com.bkav.portal.portlet.video.model.VideoCategory;
import com.bkav.portal.portlet.video.service.VideoCategoryLocalService;
import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalService;
import com.bkav.portal.portlet.video.service.VideoCategoryMapService;
import com.bkav.portal.portlet.video.service.VideoCategoryService;
import com.bkav.portal.portlet.video.service.VideoEntryLocalService;
import com.bkav.portal.portlet.video.service.VideoEntryService;
import com.bkav.portal.portlet.video.service.persistence.VideoCategoryMapPersistence;
import com.bkav.portal.portlet.video.service.persistence.VideoCategoryPersistence;
import com.bkav.portal.portlet.video.service.persistence.VideoEntryFinder;
import com.bkav.portal.portlet.video.service.persistence.VideoEntryPersistence;

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
 * The base implementation of the video category local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.video.service.impl.VideoCategoryLocalServiceImpl}.
 * </p>
 *
 * @author hungdx
 * @see com.bkav.portal.portlet.video.service.impl.VideoCategoryLocalServiceImpl
 * @see com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil
 * @generated
 */
public abstract class VideoCategoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements VideoCategoryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil} to access the video category local service.
	 */

	/**
	 * Adds the video category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategory the video category
	 * @return the video category that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public VideoCategory addVideoCategory(VideoCategory videoCategory)
		throws SystemException {
		videoCategory.setNew(true);

		return videoCategoryPersistence.update(videoCategory, false);
	}

	/**
	 * Creates a new video category with the primary key. Does not add the video category to the database.
	 *
	 * @param categoryId the primary key for the new video category
	 * @return the new video category
	 */
	public VideoCategory createVideoCategory(long categoryId) {
		return videoCategoryPersistence.create(categoryId);
	}

	/**
	 * Deletes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the video category
	 * @return the video category that was removed
	 * @throws PortalException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public VideoCategory deleteVideoCategory(long categoryId)
		throws PortalException, SystemException {
		return videoCategoryPersistence.remove(categoryId);
	}

	/**
	 * Deletes the video category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategory the video category
	 * @return the video category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public VideoCategory deleteVideoCategory(VideoCategory videoCategory)
		throws SystemException {
		return videoCategoryPersistence.remove(videoCategory);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(VideoCategory.class,
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
		return videoCategoryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return videoCategoryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
		return videoCategoryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return videoCategoryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public VideoCategory fetchVideoCategory(long categoryId)
		throws SystemException {
		return videoCategoryPersistence.fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns the video category with the primary key.
	 *
	 * @param categoryId the primary key of the video category
	 * @return the video category
	 * @throws PortalException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory getVideoCategory(long categoryId)
		throws PortalException, SystemException {
		return videoCategoryPersistence.findByPrimaryKey(categoryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return videoCategoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @return the range of video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> getVideoCategories(int start, int end)
		throws SystemException {
		return videoCategoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of video categories.
	 *
	 * @return the number of video categories
	 * @throws SystemException if a system exception occurred
	 */
	public int getVideoCategoriesCount() throws SystemException {
		return videoCategoryPersistence.countAll();
	}

	/**
	 * Updates the video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategory the video category
	 * @return the video category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public VideoCategory updateVideoCategory(VideoCategory videoCategory)
		throws SystemException {
		return updateVideoCategory(videoCategory, true);
	}

	/**
	 * Updates the video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategory the video category
	 * @param merge whether to merge the video category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the video category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public VideoCategory updateVideoCategory(VideoCategory videoCategory,
		boolean merge) throws SystemException {
		videoCategory.setNew(false);

		return videoCategoryPersistence.update(videoCategory, merge);
	}

	/**
	 * Returns the video category local service.
	 *
	 * @return the video category local service
	 */
	public VideoCategoryLocalService getVideoCategoryLocalService() {
		return videoCategoryLocalService;
	}

	/**
	 * Sets the video category local service.
	 *
	 * @param videoCategoryLocalService the video category local service
	 */
	public void setVideoCategoryLocalService(
		VideoCategoryLocalService videoCategoryLocalService) {
		this.videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	 * Returns the video category remote service.
	 *
	 * @return the video category remote service
	 */
	public VideoCategoryService getVideoCategoryService() {
		return videoCategoryService;
	}

	/**
	 * Sets the video category remote service.
	 *
	 * @param videoCategoryService the video category remote service
	 */
	public void setVideoCategoryService(
		VideoCategoryService videoCategoryService) {
		this.videoCategoryService = videoCategoryService;
	}

	/**
	 * Returns the video category persistence.
	 *
	 * @return the video category persistence
	 */
	public VideoCategoryPersistence getVideoCategoryPersistence() {
		return videoCategoryPersistence;
	}

	/**
	 * Sets the video category persistence.
	 *
	 * @param videoCategoryPersistence the video category persistence
	 */
	public void setVideoCategoryPersistence(
		VideoCategoryPersistence videoCategoryPersistence) {
		this.videoCategoryPersistence = videoCategoryPersistence;
	}

	/**
	 * Returns the video category map local service.
	 *
	 * @return the video category map local service
	 */
	public VideoCategoryMapLocalService getVideoCategoryMapLocalService() {
		return videoCategoryMapLocalService;
	}

	/**
	 * Sets the video category map local service.
	 *
	 * @param videoCategoryMapLocalService the video category map local service
	 */
	public void setVideoCategoryMapLocalService(
		VideoCategoryMapLocalService videoCategoryMapLocalService) {
		this.videoCategoryMapLocalService = videoCategoryMapLocalService;
	}

	/**
	 * Returns the video category map remote service.
	 *
	 * @return the video category map remote service
	 */
	public VideoCategoryMapService getVideoCategoryMapService() {
		return videoCategoryMapService;
	}

	/**
	 * Sets the video category map remote service.
	 *
	 * @param videoCategoryMapService the video category map remote service
	 */
	public void setVideoCategoryMapService(
		VideoCategoryMapService videoCategoryMapService) {
		this.videoCategoryMapService = videoCategoryMapService;
	}

	/**
	 * Returns the video category map persistence.
	 *
	 * @return the video category map persistence
	 */
	public VideoCategoryMapPersistence getVideoCategoryMapPersistence() {
		return videoCategoryMapPersistence;
	}

	/**
	 * Sets the video category map persistence.
	 *
	 * @param videoCategoryMapPersistence the video category map persistence
	 */
	public void setVideoCategoryMapPersistence(
		VideoCategoryMapPersistence videoCategoryMapPersistence) {
		this.videoCategoryMapPersistence = videoCategoryMapPersistence;
	}

	/**
	 * Returns the video entry local service.
	 *
	 * @return the video entry local service
	 */
	public VideoEntryLocalService getVideoEntryLocalService() {
		return videoEntryLocalService;
	}

	/**
	 * Sets the video entry local service.
	 *
	 * @param videoEntryLocalService the video entry local service
	 */
	public void setVideoEntryLocalService(
		VideoEntryLocalService videoEntryLocalService) {
		this.videoEntryLocalService = videoEntryLocalService;
	}

	/**
	 * Returns the video entry remote service.
	 *
	 * @return the video entry remote service
	 */
	public VideoEntryService getVideoEntryService() {
		return videoEntryService;
	}

	/**
	 * Sets the video entry remote service.
	 *
	 * @param videoEntryService the video entry remote service
	 */
	public void setVideoEntryService(VideoEntryService videoEntryService) {
		this.videoEntryService = videoEntryService;
	}

	/**
	 * Returns the video entry persistence.
	 *
	 * @return the video entry persistence
	 */
	public VideoEntryPersistence getVideoEntryPersistence() {
		return videoEntryPersistence;
	}

	/**
	 * Sets the video entry persistence.
	 *
	 * @param videoEntryPersistence the video entry persistence
	 */
	public void setVideoEntryPersistence(
		VideoEntryPersistence videoEntryPersistence) {
		this.videoEntryPersistence = videoEntryPersistence;
	}

	/**
	 * Returns the video entry finder.
	 *
	 * @return the video entry finder
	 */
	public VideoEntryFinder getVideoEntryFinder() {
		return videoEntryFinder;
	}

	/**
	 * Sets the video entry finder.
	 *
	 * @param videoEntryFinder the video entry finder
	 */
	public void setVideoEntryFinder(VideoEntryFinder videoEntryFinder) {
		this.videoEntryFinder = videoEntryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.bkav.portal.portlet.video.model.VideoCategory",
			videoCategoryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.bkav.portal.portlet.video.model.VideoCategory");
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
		return VideoCategory.class;
	}

	protected String getModelClassName() {
		return VideoCategory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = videoCategoryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = VideoCategoryLocalService.class)
	protected VideoCategoryLocalService videoCategoryLocalService;
	@BeanReference(type = VideoCategoryService.class)
	protected VideoCategoryService videoCategoryService;
	@BeanReference(type = VideoCategoryPersistence.class)
	protected VideoCategoryPersistence videoCategoryPersistence;
	@BeanReference(type = VideoCategoryMapLocalService.class)
	protected VideoCategoryMapLocalService videoCategoryMapLocalService;
	@BeanReference(type = VideoCategoryMapService.class)
	protected VideoCategoryMapService videoCategoryMapService;
	@BeanReference(type = VideoCategoryMapPersistence.class)
	protected VideoCategoryMapPersistence videoCategoryMapPersistence;
	@BeanReference(type = VideoEntryLocalService.class)
	protected VideoEntryLocalService videoEntryLocalService;
	@BeanReference(type = VideoEntryService.class)
	protected VideoEntryService videoEntryService;
	@BeanReference(type = VideoEntryPersistence.class)
	protected VideoEntryPersistence videoEntryPersistence;
	@BeanReference(type = VideoEntryFinder.class)
	protected VideoEntryFinder videoEntryFinder;
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
	private VideoCategoryLocalServiceClpInvoker _clpInvoker = new VideoCategoryLocalServiceClpInvoker();
}