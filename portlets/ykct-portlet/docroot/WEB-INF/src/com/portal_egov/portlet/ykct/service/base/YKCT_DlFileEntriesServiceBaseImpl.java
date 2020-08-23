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

package com.portal_egov.portlet.ykct.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalService;
import com.portal_egov.portlet.ykct.service.YKCT_CategoryService;
import com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalService;
import com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesService;
import com.portal_egov.portlet.ykct.service.YKCT_EntryLocalService;
import com.portal_egov.portlet.ykct.service.YKCT_EntryService;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_CategoryFinder;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_CategoryPersistence;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_DlFileEntriesPersistence;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinder;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the y k c t_ dl file entries remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.ykct.service.impl.YKCT_DlFileEntriesServiceImpl}.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.ykct.service.impl.YKCT_DlFileEntriesServiceImpl
 * @see com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesServiceUtil
 * @generated
 */
public abstract class YKCT_DlFileEntriesServiceBaseImpl extends BaseServiceImpl
	implements YKCT_DlFileEntriesService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesServiceUtil} to access the y k c t_ dl file entries remote service.
	 */

	/**
	 * Returns the y k c t_ category local service.
	 *
	 * @return the y k c t_ category local service
	 */
	public YKCT_CategoryLocalService getYKCT_CategoryLocalService() {
		return ykct_CategoryLocalService;
	}

	/**
	 * Sets the y k c t_ category local service.
	 *
	 * @param ykct_CategoryLocalService the y k c t_ category local service
	 */
	public void setYKCT_CategoryLocalService(
		YKCT_CategoryLocalService ykct_CategoryLocalService) {
		this.ykct_CategoryLocalService = ykct_CategoryLocalService;
	}

	/**
	 * Returns the y k c t_ category remote service.
	 *
	 * @return the y k c t_ category remote service
	 */
	public YKCT_CategoryService getYKCT_CategoryService() {
		return ykct_CategoryService;
	}

	/**
	 * Sets the y k c t_ category remote service.
	 *
	 * @param ykct_CategoryService the y k c t_ category remote service
	 */
	public void setYKCT_CategoryService(
		YKCT_CategoryService ykct_CategoryService) {
		this.ykct_CategoryService = ykct_CategoryService;
	}

	/**
	 * Returns the y k c t_ category persistence.
	 *
	 * @return the y k c t_ category persistence
	 */
	public YKCT_CategoryPersistence getYKCT_CategoryPersistence() {
		return ykct_CategoryPersistence;
	}

	/**
	 * Sets the y k c t_ category persistence.
	 *
	 * @param ykct_CategoryPersistence the y k c t_ category persistence
	 */
	public void setYKCT_CategoryPersistence(
		YKCT_CategoryPersistence ykct_CategoryPersistence) {
		this.ykct_CategoryPersistence = ykct_CategoryPersistence;
	}

	/**
	 * Returns the y k c t_ category finder.
	 *
	 * @return the y k c t_ category finder
	 */
	public YKCT_CategoryFinder getYKCT_CategoryFinder() {
		return ykct_CategoryFinder;
	}

	/**
	 * Sets the y k c t_ category finder.
	 *
	 * @param ykct_CategoryFinder the y k c t_ category finder
	 */
	public void setYKCT_CategoryFinder(YKCT_CategoryFinder ykct_CategoryFinder) {
		this.ykct_CategoryFinder = ykct_CategoryFinder;
	}

	/**
	 * Returns the y k c t_ dl file entries local service.
	 *
	 * @return the y k c t_ dl file entries local service
	 */
	public YKCT_DlFileEntriesLocalService getYKCT_DlFileEntriesLocalService() {
		return ykct_DlFileEntriesLocalService;
	}

	/**
	 * Sets the y k c t_ dl file entries local service.
	 *
	 * @param ykct_DlFileEntriesLocalService the y k c t_ dl file entries local service
	 */
	public void setYKCT_DlFileEntriesLocalService(
		YKCT_DlFileEntriesLocalService ykct_DlFileEntriesLocalService) {
		this.ykct_DlFileEntriesLocalService = ykct_DlFileEntriesLocalService;
	}

	/**
	 * Returns the y k c t_ dl file entries remote service.
	 *
	 * @return the y k c t_ dl file entries remote service
	 */
	public YKCT_DlFileEntriesService getYKCT_DlFileEntriesService() {
		return ykct_DlFileEntriesService;
	}

	/**
	 * Sets the y k c t_ dl file entries remote service.
	 *
	 * @param ykct_DlFileEntriesService the y k c t_ dl file entries remote service
	 */
	public void setYKCT_DlFileEntriesService(
		YKCT_DlFileEntriesService ykct_DlFileEntriesService) {
		this.ykct_DlFileEntriesService = ykct_DlFileEntriesService;
	}

	/**
	 * Returns the y k c t_ dl file entries persistence.
	 *
	 * @return the y k c t_ dl file entries persistence
	 */
	public YKCT_DlFileEntriesPersistence getYKCT_DlFileEntriesPersistence() {
		return ykct_DlFileEntriesPersistence;
	}

	/**
	 * Sets the y k c t_ dl file entries persistence.
	 *
	 * @param ykct_DlFileEntriesPersistence the y k c t_ dl file entries persistence
	 */
	public void setYKCT_DlFileEntriesPersistence(
		YKCT_DlFileEntriesPersistence ykct_DlFileEntriesPersistence) {
		this.ykct_DlFileEntriesPersistence = ykct_DlFileEntriesPersistence;
	}

	/**
	 * Returns the y k c t_ entry local service.
	 *
	 * @return the y k c t_ entry local service
	 */
	public YKCT_EntryLocalService getYKCT_EntryLocalService() {
		return ykct_EntryLocalService;
	}

	/**
	 * Sets the y k c t_ entry local service.
	 *
	 * @param ykct_EntryLocalService the y k c t_ entry local service
	 */
	public void setYKCT_EntryLocalService(
		YKCT_EntryLocalService ykct_EntryLocalService) {
		this.ykct_EntryLocalService = ykct_EntryLocalService;
	}

	/**
	 * Returns the y k c t_ entry remote service.
	 *
	 * @return the y k c t_ entry remote service
	 */
	public YKCT_EntryService getYKCT_EntryService() {
		return ykct_EntryService;
	}

	/**
	 * Sets the y k c t_ entry remote service.
	 *
	 * @param ykct_EntryService the y k c t_ entry remote service
	 */
	public void setYKCT_EntryService(YKCT_EntryService ykct_EntryService) {
		this.ykct_EntryService = ykct_EntryService;
	}

	/**
	 * Returns the y k c t_ entry persistence.
	 *
	 * @return the y k c t_ entry persistence
	 */
	public YKCT_EntryPersistence getYKCT_EntryPersistence() {
		return ykct_EntryPersistence;
	}

	/**
	 * Sets the y k c t_ entry persistence.
	 *
	 * @param ykct_EntryPersistence the y k c t_ entry persistence
	 */
	public void setYKCT_EntryPersistence(
		YKCT_EntryPersistence ykct_EntryPersistence) {
		this.ykct_EntryPersistence = ykct_EntryPersistence;
	}

	/**
	 * Returns the y k c t_ entry finder.
	 *
	 * @return the y k c t_ entry finder
	 */
	public YKCT_EntryFinder getYKCT_EntryFinder() {
		return ykct_EntryFinder;
	}

	/**
	 * Sets the y k c t_ entry finder.
	 *
	 * @param ykct_EntryFinder the y k c t_ entry finder
	 */
	public void setYKCT_EntryFinder(YKCT_EntryFinder ykct_EntryFinder) {
		this.ykct_EntryFinder = ykct_EntryFinder;
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
	}

	public void destroy() {
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
		return YKCT_DlFileEntries.class;
	}

	protected String getModelClassName() {
		return YKCT_DlFileEntries.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ykct_DlFileEntriesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = YKCT_CategoryLocalService.class)
	protected YKCT_CategoryLocalService ykct_CategoryLocalService;
	@BeanReference(type = YKCT_CategoryService.class)
	protected YKCT_CategoryService ykct_CategoryService;
	@BeanReference(type = YKCT_CategoryPersistence.class)
	protected YKCT_CategoryPersistence ykct_CategoryPersistence;
	@BeanReference(type = YKCT_CategoryFinder.class)
	protected YKCT_CategoryFinder ykct_CategoryFinder;
	@BeanReference(type = YKCT_DlFileEntriesLocalService.class)
	protected YKCT_DlFileEntriesLocalService ykct_DlFileEntriesLocalService;
	@BeanReference(type = YKCT_DlFileEntriesService.class)
	protected YKCT_DlFileEntriesService ykct_DlFileEntriesService;
	@BeanReference(type = YKCT_DlFileEntriesPersistence.class)
	protected YKCT_DlFileEntriesPersistence ykct_DlFileEntriesPersistence;
	@BeanReference(type = YKCT_EntryLocalService.class)
	protected YKCT_EntryLocalService ykct_EntryLocalService;
	@BeanReference(type = YKCT_EntryService.class)
	protected YKCT_EntryService ykct_EntryService;
	@BeanReference(type = YKCT_EntryPersistence.class)
	protected YKCT_EntryPersistence ykct_EntryPersistence;
	@BeanReference(type = YKCT_EntryFinder.class)
	protected YKCT_EntryFinder ykct_EntryFinder;
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
	private YKCT_DlFileEntriesServiceClpInvoker _clpInvoker = new YKCT_DlFileEntriesServiceClpInvoker();
}