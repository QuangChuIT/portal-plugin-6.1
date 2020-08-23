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

package com.portal_egov.portlet.tthc.service.base;

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

import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalService;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeService;
import com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalService;
import com.portal_egov.portlet.tthc.service.TTHC_CategoryService;
import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalService;
import com.portal_egov.portlet.tthc.service.TTHC_EntryService;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_AttributePersistence;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_CategoryFinder;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_CategoryPersistence;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_EntryFinder;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_EntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the t t h c_ attribute local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.tthc.service.impl.TTHC_AttributeLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.tthc.service.impl.TTHC_AttributeLocalServiceImpl
 * @see com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil
 * @generated
 */
public abstract class TTHC_AttributeLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TTHC_AttributeLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil} to access the t t h c_ attribute local service.
	 */

	/**
	 * Adds the t t h c_ attribute to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tthc_Attribute the t t h c_ attribute
	 * @return the t t h c_ attribute that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TTHC_Attribute addTTHC_Attribute(TTHC_Attribute tthc_Attribute)
		throws SystemException {
		tthc_Attribute.setNew(true);

		return tthc_AttributePersistence.update(tthc_Attribute, false);
	}

	/**
	 * Creates a new t t h c_ attribute with the primary key. Does not add the t t h c_ attribute to the database.
	 *
	 * @param attributeId the primary key for the new t t h c_ attribute
	 * @return the new t t h c_ attribute
	 */
	public TTHC_Attribute createTTHC_Attribute(long attributeId) {
		return tthc_AttributePersistence.create(attributeId);
	}

	/**
	 * Deletes the t t h c_ attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attributeId the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute that was removed
	 * @throws PortalException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TTHC_Attribute deleteTTHC_Attribute(long attributeId)
		throws PortalException, SystemException {
		return tthc_AttributePersistence.remove(attributeId);
	}

	/**
	 * Deletes the t t h c_ attribute from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tthc_Attribute the t t h c_ attribute
	 * @return the t t h c_ attribute that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TTHC_Attribute deleteTTHC_Attribute(TTHC_Attribute tthc_Attribute)
		throws SystemException {
		return tthc_AttributePersistence.remove(tthc_Attribute);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TTHC_Attribute.class,
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
		return tthc_AttributePersistence.findWithDynamicQuery(dynamicQuery);
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
		return tthc_AttributePersistence.findWithDynamicQuery(dynamicQuery,
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
		return tthc_AttributePersistence.findWithDynamicQuery(dynamicQuery,
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
		return tthc_AttributePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public TTHC_Attribute fetchTTHC_Attribute(long attributeId)
		throws SystemException {
		return tthc_AttributePersistence.fetchByPrimaryKey(attributeId);
	}

	/**
	 * Returns the t t h c_ attribute with the primary key.
	 *
	 * @param attributeId the primary key of the t t h c_ attribute
	 * @return the t t h c_ attribute
	 * @throws PortalException if a t t h c_ attribute with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Attribute getTTHC_Attribute(long attributeId)
		throws PortalException, SystemException {
		return tthc_AttributePersistence.findByPrimaryKey(attributeId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return tthc_AttributePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the t t h c_ attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ attributes
	 * @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	 * @return the range of t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Attribute> getTTHC_Attributes(int start, int end)
		throws SystemException {
		return tthc_AttributePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of t t h c_ attributes.
	 *
	 * @return the number of t t h c_ attributes
	 * @throws SystemException if a system exception occurred
	 */
	public int getTTHC_AttributesCount() throws SystemException {
		return tthc_AttributePersistence.countAll();
	}

	/**
	 * Updates the t t h c_ attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tthc_Attribute the t t h c_ attribute
	 * @return the t t h c_ attribute that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TTHC_Attribute updateTTHC_Attribute(TTHC_Attribute tthc_Attribute)
		throws SystemException {
		return updateTTHC_Attribute(tthc_Attribute, true);
	}

	/**
	 * Updates the t t h c_ attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tthc_Attribute the t t h c_ attribute
	 * @param merge whether to merge the t t h c_ attribute with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the t t h c_ attribute that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TTHC_Attribute updateTTHC_Attribute(TTHC_Attribute tthc_Attribute,
		boolean merge) throws SystemException {
		tthc_Attribute.setNew(false);

		return tthc_AttributePersistence.update(tthc_Attribute, merge);
	}

	/**
	 * Returns the t t h c_ attribute local service.
	 *
	 * @return the t t h c_ attribute local service
	 */
	public TTHC_AttributeLocalService getTTHC_AttributeLocalService() {
		return tthc_AttributeLocalService;
	}

	/**
	 * Sets the t t h c_ attribute local service.
	 *
	 * @param tthc_AttributeLocalService the t t h c_ attribute local service
	 */
	public void setTTHC_AttributeLocalService(
		TTHC_AttributeLocalService tthc_AttributeLocalService) {
		this.tthc_AttributeLocalService = tthc_AttributeLocalService;
	}

	/**
	 * Returns the t t h c_ attribute remote service.
	 *
	 * @return the t t h c_ attribute remote service
	 */
	public TTHC_AttributeService getTTHC_AttributeService() {
		return tthc_AttributeService;
	}

	/**
	 * Sets the t t h c_ attribute remote service.
	 *
	 * @param tthc_AttributeService the t t h c_ attribute remote service
	 */
	public void setTTHC_AttributeService(
		TTHC_AttributeService tthc_AttributeService) {
		this.tthc_AttributeService = tthc_AttributeService;
	}

	/**
	 * Returns the t t h c_ attribute persistence.
	 *
	 * @return the t t h c_ attribute persistence
	 */
	public TTHC_AttributePersistence getTTHC_AttributePersistence() {
		return tthc_AttributePersistence;
	}

	/**
	 * Sets the t t h c_ attribute persistence.
	 *
	 * @param tthc_AttributePersistence the t t h c_ attribute persistence
	 */
	public void setTTHC_AttributePersistence(
		TTHC_AttributePersistence tthc_AttributePersistence) {
		this.tthc_AttributePersistence = tthc_AttributePersistence;
	}

	/**
	 * Returns the t t h c_ category local service.
	 *
	 * @return the t t h c_ category local service
	 */
	public TTHC_CategoryLocalService getTTHC_CategoryLocalService() {
		return tthc_CategoryLocalService;
	}

	/**
	 * Sets the t t h c_ category local service.
	 *
	 * @param tthc_CategoryLocalService the t t h c_ category local service
	 */
	public void setTTHC_CategoryLocalService(
		TTHC_CategoryLocalService tthc_CategoryLocalService) {
		this.tthc_CategoryLocalService = tthc_CategoryLocalService;
	}

	/**
	 * Returns the t t h c_ category remote service.
	 *
	 * @return the t t h c_ category remote service
	 */
	public TTHC_CategoryService getTTHC_CategoryService() {
		return tthc_CategoryService;
	}

	/**
	 * Sets the t t h c_ category remote service.
	 *
	 * @param tthc_CategoryService the t t h c_ category remote service
	 */
	public void setTTHC_CategoryService(
		TTHC_CategoryService tthc_CategoryService) {
		this.tthc_CategoryService = tthc_CategoryService;
	}

	/**
	 * Returns the t t h c_ category persistence.
	 *
	 * @return the t t h c_ category persistence
	 */
	public TTHC_CategoryPersistence getTTHC_CategoryPersistence() {
		return tthc_CategoryPersistence;
	}

	/**
	 * Sets the t t h c_ category persistence.
	 *
	 * @param tthc_CategoryPersistence the t t h c_ category persistence
	 */
	public void setTTHC_CategoryPersistence(
		TTHC_CategoryPersistence tthc_CategoryPersistence) {
		this.tthc_CategoryPersistence = tthc_CategoryPersistence;
	}

	/**
	 * Returns the t t h c_ category finder.
	 *
	 * @return the t t h c_ category finder
	 */
	public TTHC_CategoryFinder getTTHC_CategoryFinder() {
		return tthc_CategoryFinder;
	}

	/**
	 * Sets the t t h c_ category finder.
	 *
	 * @param tthc_CategoryFinder the t t h c_ category finder
	 */
	public void setTTHC_CategoryFinder(TTHC_CategoryFinder tthc_CategoryFinder) {
		this.tthc_CategoryFinder = tthc_CategoryFinder;
	}

	/**
	 * Returns the t t h c_ entry local service.
	 *
	 * @return the t t h c_ entry local service
	 */
	public TTHC_EntryLocalService getTTHC_EntryLocalService() {
		return tthc_EntryLocalService;
	}

	/**
	 * Sets the t t h c_ entry local service.
	 *
	 * @param tthc_EntryLocalService the t t h c_ entry local service
	 */
	public void setTTHC_EntryLocalService(
		TTHC_EntryLocalService tthc_EntryLocalService) {
		this.tthc_EntryLocalService = tthc_EntryLocalService;
	}

	/**
	 * Returns the t t h c_ entry remote service.
	 *
	 * @return the t t h c_ entry remote service
	 */
	public TTHC_EntryService getTTHC_EntryService() {
		return tthc_EntryService;
	}

	/**
	 * Sets the t t h c_ entry remote service.
	 *
	 * @param tthc_EntryService the t t h c_ entry remote service
	 */
	public void setTTHC_EntryService(TTHC_EntryService tthc_EntryService) {
		this.tthc_EntryService = tthc_EntryService;
	}

	/**
	 * Returns the t t h c_ entry persistence.
	 *
	 * @return the t t h c_ entry persistence
	 */
	public TTHC_EntryPersistence getTTHC_EntryPersistence() {
		return tthc_EntryPersistence;
	}

	/**
	 * Sets the t t h c_ entry persistence.
	 *
	 * @param tthc_EntryPersistence the t t h c_ entry persistence
	 */
	public void setTTHC_EntryPersistence(
		TTHC_EntryPersistence tthc_EntryPersistence) {
		this.tthc_EntryPersistence = tthc_EntryPersistence;
	}

	/**
	 * Returns the t t h c_ entry finder.
	 *
	 * @return the t t h c_ entry finder
	 */
	public TTHC_EntryFinder getTTHC_EntryFinder() {
		return tthc_EntryFinder;
	}

	/**
	 * Sets the t t h c_ entry finder.
	 *
	 * @param tthc_EntryFinder the t t h c_ entry finder
	 */
	public void setTTHC_EntryFinder(TTHC_EntryFinder tthc_EntryFinder) {
		this.tthc_EntryFinder = tthc_EntryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.tthc.model.TTHC_Attribute",
			tthc_AttributeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.tthc.model.TTHC_Attribute");
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
		return TTHC_Attribute.class;
	}

	protected String getModelClassName() {
		return TTHC_Attribute.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tthc_AttributePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TTHC_AttributeLocalService.class)
	protected TTHC_AttributeLocalService tthc_AttributeLocalService;
	@BeanReference(type = TTHC_AttributeService.class)
	protected TTHC_AttributeService tthc_AttributeService;
	@BeanReference(type = TTHC_AttributePersistence.class)
	protected TTHC_AttributePersistence tthc_AttributePersistence;
	@BeanReference(type = TTHC_CategoryLocalService.class)
	protected TTHC_CategoryLocalService tthc_CategoryLocalService;
	@BeanReference(type = TTHC_CategoryService.class)
	protected TTHC_CategoryService tthc_CategoryService;
	@BeanReference(type = TTHC_CategoryPersistence.class)
	protected TTHC_CategoryPersistence tthc_CategoryPersistence;
	@BeanReference(type = TTHC_CategoryFinder.class)
	protected TTHC_CategoryFinder tthc_CategoryFinder;
	@BeanReference(type = TTHC_EntryLocalService.class)
	protected TTHC_EntryLocalService tthc_EntryLocalService;
	@BeanReference(type = TTHC_EntryService.class)
	protected TTHC_EntryService tthc_EntryService;
	@BeanReference(type = TTHC_EntryPersistence.class)
	protected TTHC_EntryPersistence tthc_EntryPersistence;
	@BeanReference(type = TTHC_EntryFinder.class)
	protected TTHC_EntryFinder tthc_EntryFinder;
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
	private TTHC_AttributeLocalServiceClpInvoker _clpInvoker = new TTHC_AttributeLocalServiceClpInvoker();
}