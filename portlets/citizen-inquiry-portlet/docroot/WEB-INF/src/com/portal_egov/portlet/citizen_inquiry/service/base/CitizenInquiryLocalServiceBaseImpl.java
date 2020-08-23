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

package com.portal_egov.portlet.citizen_inquiry.service.base;

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

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryLocalService;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryService;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalService;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryService;
import com.portal_egov.portlet.citizen_inquiry.service.persistence.CitizenInquiryCategoryPersistence;
import com.portal_egov.portlet.citizen_inquiry.service.persistence.CitizenInquiryFinder;
import com.portal_egov.portlet.citizen_inquiry.service.persistence.CitizenInquiryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the citizen inquiry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.citizen_inquiry.service.impl.CitizenInquiryLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.citizen_inquiry.service.impl.CitizenInquiryLocalServiceImpl
 * @see com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil
 * @generated
 */
public abstract class CitizenInquiryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CitizenInquiryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil} to access the citizen inquiry local service.
	 */

	/**
	 * Adds the citizen inquiry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param citizenInquiry the citizen inquiry
	 * @return the citizen inquiry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CitizenInquiry addCitizenInquiry(CitizenInquiry citizenInquiry)
		throws SystemException {
		citizenInquiry.setNew(true);

		return citizenInquiryPersistence.update(citizenInquiry, false);
	}

	/**
	 * Creates a new citizen inquiry with the primary key. Does not add the citizen inquiry to the database.
	 *
	 * @param inquiryId the primary key for the new citizen inquiry
	 * @return the new citizen inquiry
	 */
	public CitizenInquiry createCitizenInquiry(long inquiryId) {
		return citizenInquiryPersistence.create(inquiryId);
	}

	/**
	 * Deletes the citizen inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inquiryId the primary key of the citizen inquiry
	 * @return the citizen inquiry that was removed
	 * @throws PortalException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CitizenInquiry deleteCitizenInquiry(long inquiryId)
		throws PortalException, SystemException {
		return citizenInquiryPersistence.remove(inquiryId);
	}

	/**
	 * Deletes the citizen inquiry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param citizenInquiry the citizen inquiry
	 * @return the citizen inquiry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CitizenInquiry deleteCitizenInquiry(CitizenInquiry citizenInquiry)
		throws SystemException {
		return citizenInquiryPersistence.remove(citizenInquiry);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CitizenInquiry.class,
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
		return citizenInquiryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return citizenInquiryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return citizenInquiryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return citizenInquiryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public CitizenInquiry fetchCitizenInquiry(long inquiryId)
		throws SystemException {
		return citizenInquiryPersistence.fetchByPrimaryKey(inquiryId);
	}

	/**
	 * Returns the citizen inquiry with the primary key.
	 *
	 * @param inquiryId the primary key of the citizen inquiry
	 * @return the citizen inquiry
	 * @throws PortalException if a citizen inquiry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiry getCitizenInquiry(long inquiryId)
		throws PortalException, SystemException {
		return citizenInquiryPersistence.findByPrimaryKey(inquiryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return citizenInquiryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the citizen inquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizen inquiries
	 * @param end the upper bound of the range of citizen inquiries (not inclusive)
	 * @return the range of citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiry> getCitizenInquiries(int start, int end)
		throws SystemException {
		return citizenInquiryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of citizen inquiries.
	 *
	 * @return the number of citizen inquiries
	 * @throws SystemException if a system exception occurred
	 */
	public int getCitizenInquiriesCount() throws SystemException {
		return citizenInquiryPersistence.countAll();
	}

	/**
	 * Updates the citizen inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param citizenInquiry the citizen inquiry
	 * @return the citizen inquiry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CitizenInquiry updateCitizenInquiry(CitizenInquiry citizenInquiry)
		throws SystemException {
		return updateCitizenInquiry(citizenInquiry, true);
	}

	/**
	 * Updates the citizen inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param citizenInquiry the citizen inquiry
	 * @param merge whether to merge the citizen inquiry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the citizen inquiry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CitizenInquiry updateCitizenInquiry(CitizenInquiry citizenInquiry,
		boolean merge) throws SystemException {
		citizenInquiry.setNew(false);

		return citizenInquiryPersistence.update(citizenInquiry, merge);
	}

	/**
	 * Returns the citizen inquiry local service.
	 *
	 * @return the citizen inquiry local service
	 */
	public CitizenInquiryLocalService getCitizenInquiryLocalService() {
		return citizenInquiryLocalService;
	}

	/**
	 * Sets the citizen inquiry local service.
	 *
	 * @param citizenInquiryLocalService the citizen inquiry local service
	 */
	public void setCitizenInquiryLocalService(
		CitizenInquiryLocalService citizenInquiryLocalService) {
		this.citizenInquiryLocalService = citizenInquiryLocalService;
	}

	/**
	 * Returns the citizen inquiry remote service.
	 *
	 * @return the citizen inquiry remote service
	 */
	public CitizenInquiryService getCitizenInquiryService() {
		return citizenInquiryService;
	}

	/**
	 * Sets the citizen inquiry remote service.
	 *
	 * @param citizenInquiryService the citizen inquiry remote service
	 */
	public void setCitizenInquiryService(
		CitizenInquiryService citizenInquiryService) {
		this.citizenInquiryService = citizenInquiryService;
	}

	/**
	 * Returns the citizen inquiry persistence.
	 *
	 * @return the citizen inquiry persistence
	 */
	public CitizenInquiryPersistence getCitizenInquiryPersistence() {
		return citizenInquiryPersistence;
	}

	/**
	 * Sets the citizen inquiry persistence.
	 *
	 * @param citizenInquiryPersistence the citizen inquiry persistence
	 */
	public void setCitizenInquiryPersistence(
		CitizenInquiryPersistence citizenInquiryPersistence) {
		this.citizenInquiryPersistence = citizenInquiryPersistence;
	}

	/**
	 * Returns the citizen inquiry finder.
	 *
	 * @return the citizen inquiry finder
	 */
	public CitizenInquiryFinder getCitizenInquiryFinder() {
		return citizenInquiryFinder;
	}

	/**
	 * Sets the citizen inquiry finder.
	 *
	 * @param citizenInquiryFinder the citizen inquiry finder
	 */
	public void setCitizenInquiryFinder(
		CitizenInquiryFinder citizenInquiryFinder) {
		this.citizenInquiryFinder = citizenInquiryFinder;
	}

	/**
	 * Returns the citizen inquiry category local service.
	 *
	 * @return the citizen inquiry category local service
	 */
	public CitizenInquiryCategoryLocalService getCitizenInquiryCategoryLocalService() {
		return citizenInquiryCategoryLocalService;
	}

	/**
	 * Sets the citizen inquiry category local service.
	 *
	 * @param citizenInquiryCategoryLocalService the citizen inquiry category local service
	 */
	public void setCitizenInquiryCategoryLocalService(
		CitizenInquiryCategoryLocalService citizenInquiryCategoryLocalService) {
		this.citizenInquiryCategoryLocalService = citizenInquiryCategoryLocalService;
	}

	/**
	 * Returns the citizen inquiry category remote service.
	 *
	 * @return the citizen inquiry category remote service
	 */
	public CitizenInquiryCategoryService getCitizenInquiryCategoryService() {
		return citizenInquiryCategoryService;
	}

	/**
	 * Sets the citizen inquiry category remote service.
	 *
	 * @param citizenInquiryCategoryService the citizen inquiry category remote service
	 */
	public void setCitizenInquiryCategoryService(
		CitizenInquiryCategoryService citizenInquiryCategoryService) {
		this.citizenInquiryCategoryService = citizenInquiryCategoryService;
	}

	/**
	 * Returns the citizen inquiry category persistence.
	 *
	 * @return the citizen inquiry category persistence
	 */
	public CitizenInquiryCategoryPersistence getCitizenInquiryCategoryPersistence() {
		return citizenInquiryCategoryPersistence;
	}

	/**
	 * Sets the citizen inquiry category persistence.
	 *
	 * @param citizenInquiryCategoryPersistence the citizen inquiry category persistence
	 */
	public void setCitizenInquiryCategoryPersistence(
		CitizenInquiryCategoryPersistence citizenInquiryCategoryPersistence) {
		this.citizenInquiryCategoryPersistence = citizenInquiryCategoryPersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry",
			citizenInquiryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry");
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
		return CitizenInquiry.class;
	}

	protected String getModelClassName() {
		return CitizenInquiry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = citizenInquiryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CitizenInquiryLocalService.class)
	protected CitizenInquiryLocalService citizenInquiryLocalService;
	@BeanReference(type = CitizenInquiryService.class)
	protected CitizenInquiryService citizenInquiryService;
	@BeanReference(type = CitizenInquiryPersistence.class)
	protected CitizenInquiryPersistence citizenInquiryPersistence;
	@BeanReference(type = CitizenInquiryFinder.class)
	protected CitizenInquiryFinder citizenInquiryFinder;
	@BeanReference(type = CitizenInquiryCategoryLocalService.class)
	protected CitizenInquiryCategoryLocalService citizenInquiryCategoryLocalService;
	@BeanReference(type = CitizenInquiryCategoryService.class)
	protected CitizenInquiryCategoryService citizenInquiryCategoryService;
	@BeanReference(type = CitizenInquiryCategoryPersistence.class)
	protected CitizenInquiryCategoryPersistence citizenInquiryCategoryPersistence;
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
	private CitizenInquiryLocalServiceClpInvoker _clpInvoker = new CitizenInquiryLocalServiceClpInvoker();
}