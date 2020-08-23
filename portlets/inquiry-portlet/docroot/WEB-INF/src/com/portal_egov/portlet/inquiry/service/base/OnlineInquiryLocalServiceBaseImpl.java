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

package com.portal_egov.portlet.inquiry.service.base;

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

import com.portal_egov.portlet.inquiry.model.OnlineInquiry;
import com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalService;
import com.portal_egov.portlet.inquiry.service.OnlineInquiryService;
import com.portal_egov.portlet.inquiry.service.persistence.OnlineInquiryFinder;
import com.portal_egov.portlet.inquiry.service.persistence.OnlineInquiryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the online inquiry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl
 * @see com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil
 * @generated
 */
public abstract class OnlineInquiryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements OnlineInquiryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil} to access the online inquiry local service.
	 */

	/**
	 * Adds the online inquiry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param onlineInquiry the online inquiry
	 * @return the online inquiry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OnlineInquiry addOnlineInquiry(OnlineInquiry onlineInquiry)
		throws SystemException {
		onlineInquiry.setNew(true);

		return onlineInquiryPersistence.update(onlineInquiry, false);
	}

	/**
	 * Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	 *
	 * @param inquiryId the primary key for the new online inquiry
	 * @return the new online inquiry
	 */
	public OnlineInquiry createOnlineInquiry(long inquiryId) {
		return onlineInquiryPersistence.create(inquiryId);
	}

	/**
	 * Deletes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inquiryId the primary key of the online inquiry
	 * @return the online inquiry that was removed
	 * @throws PortalException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public OnlineInquiry deleteOnlineInquiry(long inquiryId)
		throws PortalException, SystemException {
		return onlineInquiryPersistence.remove(inquiryId);
	}

	/**
	 * Deletes the online inquiry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param onlineInquiry the online inquiry
	 * @return the online inquiry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public OnlineInquiry deleteOnlineInquiry(OnlineInquiry onlineInquiry)
		throws SystemException {
		return onlineInquiryPersistence.remove(onlineInquiry);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(OnlineInquiry.class,
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
		return onlineInquiryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return onlineInquiryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return onlineInquiryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return onlineInquiryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public OnlineInquiry fetchOnlineInquiry(long inquiryId)
		throws SystemException {
		return onlineInquiryPersistence.fetchByPrimaryKey(inquiryId);
	}

	/**
	 * Returns the online inquiry with the primary key.
	 *
	 * @param inquiryId the primary key of the online inquiry
	 * @return the online inquiry
	 * @throws PortalException if a online inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OnlineInquiry getOnlineInquiry(long inquiryId)
		throws PortalException, SystemException {
		return onlineInquiryPersistence.findByPrimaryKey(inquiryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return onlineInquiryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the online inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of online inquiries
	 * @param end the upper bound of the range of online inquiries (not inclusive)
	 * @return the range of online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<OnlineInquiry> getOnlineInquiries(int start, int end)
		throws SystemException {
		return onlineInquiryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of online inquiries.
	 *
	 * @return the number of online inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int getOnlineInquiriesCount() throws SystemException {
		return onlineInquiryPersistence.countAll();
	}

	/**
	 * Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param onlineInquiry the online inquiry
	 * @return the online inquiry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OnlineInquiry updateOnlineInquiry(OnlineInquiry onlineInquiry)
		throws SystemException {
		return updateOnlineInquiry(onlineInquiry, true);
	}

	/**
	 * Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param onlineInquiry the online inquiry
	 * @param merge whether to merge the online inquiry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the online inquiry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OnlineInquiry updateOnlineInquiry(OnlineInquiry onlineInquiry,
		boolean merge) throws SystemException {
		onlineInquiry.setNew(false);

		return onlineInquiryPersistence.update(onlineInquiry, merge);
	}

	/**
	 * Returns the online inquiry local service.
	 *
	 * @return the online inquiry local service
	 */
	public OnlineInquiryLocalService getOnlineInquiryLocalService() {
		return onlineInquiryLocalService;
	}

	/**
	 * Sets the online inquiry local service.
	 *
	 * @param onlineInquiryLocalService the online inquiry local service
	 */
	public void setOnlineInquiryLocalService(
		OnlineInquiryLocalService onlineInquiryLocalService) {
		this.onlineInquiryLocalService = onlineInquiryLocalService;
	}

	/**
	 * Returns the online inquiry remote service.
	 *
	 * @return the online inquiry remote service
	 */
	public OnlineInquiryService getOnlineInquiryService() {
		return onlineInquiryService;
	}

	/**
	 * Sets the online inquiry remote service.
	 *
	 * @param onlineInquiryService the online inquiry remote service
	 */
	public void setOnlineInquiryService(
		OnlineInquiryService onlineInquiryService) {
		this.onlineInquiryService = onlineInquiryService;
	}

	/**
	 * Returns the online inquiry persistence.
	 *
	 * @return the online inquiry persistence
	 */
	public OnlineInquiryPersistence getOnlineInquiryPersistence() {
		return onlineInquiryPersistence;
	}

	/**
	 * Sets the online inquiry persistence.
	 *
	 * @param onlineInquiryPersistence the online inquiry persistence
	 */
	public void setOnlineInquiryPersistence(
		OnlineInquiryPersistence onlineInquiryPersistence) {
		this.onlineInquiryPersistence = onlineInquiryPersistence;
	}

	/**
	 * Returns the online inquiry finder.
	 *
	 * @return the online inquiry finder
	 */
	public OnlineInquiryFinder getOnlineInquiryFinder() {
		return onlineInquiryFinder;
	}

	/**
	 * Sets the online inquiry finder.
	 *
	 * @param onlineInquiryFinder the online inquiry finder
	 */
	public void setOnlineInquiryFinder(OnlineInquiryFinder onlineInquiryFinder) {
		this.onlineInquiryFinder = onlineInquiryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.inquiry.model.OnlineInquiry",
			onlineInquiryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.inquiry.model.OnlineInquiry");
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
		return OnlineInquiry.class;
	}

	protected String getModelClassName() {
		return OnlineInquiry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = onlineInquiryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = OnlineInquiryLocalService.class)
	protected OnlineInquiryLocalService onlineInquiryLocalService;
	@BeanReference(type = OnlineInquiryService.class)
	protected OnlineInquiryService onlineInquiryService;
	@BeanReference(type = OnlineInquiryPersistence.class)
	protected OnlineInquiryPersistence onlineInquiryPersistence;
	@BeanReference(type = OnlineInquiryFinder.class)
	protected OnlineInquiryFinder onlineInquiryFinder;
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
	private OnlineInquiryLocalServiceClpInvoker _clpInvoker = new OnlineInquiryLocalServiceClpInvoker();
}