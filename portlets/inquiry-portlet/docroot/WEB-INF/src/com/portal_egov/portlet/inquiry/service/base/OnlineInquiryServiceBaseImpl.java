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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
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

import javax.sql.DataSource;

/**
 * The base implementation of the online inquiry remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryServiceImpl
 * @see com.portal_egov.portlet.inquiry.service.OnlineInquiryServiceUtil
 * @generated
 */
public abstract class OnlineInquiryServiceBaseImpl extends BaseServiceImpl
	implements OnlineInquiryService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.inquiry.service.OnlineInquiryServiceUtil} to access the online inquiry remote service.
	 */

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
	private OnlineInquiryServiceClpInvoker _clpInvoker = new OnlineInquiryServiceClpInvoker();
}