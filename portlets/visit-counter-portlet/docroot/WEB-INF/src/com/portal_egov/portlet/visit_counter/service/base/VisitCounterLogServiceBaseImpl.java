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

package com.portal_egov.portlet.visit_counter.service.base;

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

import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;
import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalService;
import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogService;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLocalService;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalService;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLogService;
import com.portal_egov.portlet.visit_counter.service.VisitCounterService;
import com.portal_egov.portlet.visit_counter.service.persistence.VisitCounterDayLogPersistence;
import com.portal_egov.portlet.visit_counter.service.persistence.VisitCounterLogPersistence;
import com.portal_egov.portlet.visit_counter.service.persistence.VisitCounterPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the visit counter log remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.visit_counter.service.impl.VisitCounterLogServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.visit_counter.service.impl.VisitCounterLogServiceImpl
 * @see com.portal_egov.portlet.visit_counter.service.VisitCounterLogServiceUtil
 * @generated
 */
public abstract class VisitCounterLogServiceBaseImpl extends BaseServiceImpl
	implements VisitCounterLogService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.visit_counter.service.VisitCounterLogServiceUtil} to access the visit counter log remote service.
	 */

	/**
	 * Returns the visit counter local service.
	 *
	 * @return the visit counter local service
	 */
	public VisitCounterLocalService getVisitCounterLocalService() {
		return visitCounterLocalService;
	}

	/**
	 * Sets the visit counter local service.
	 *
	 * @param visitCounterLocalService the visit counter local service
	 */
	public void setVisitCounterLocalService(
		VisitCounterLocalService visitCounterLocalService) {
		this.visitCounterLocalService = visitCounterLocalService;
	}

	/**
	 * Returns the visit counter remote service.
	 *
	 * @return the visit counter remote service
	 */
	public VisitCounterService getVisitCounterService() {
		return visitCounterService;
	}

	/**
	 * Sets the visit counter remote service.
	 *
	 * @param visitCounterService the visit counter remote service
	 */
	public void setVisitCounterService(VisitCounterService visitCounterService) {
		this.visitCounterService = visitCounterService;
	}

	/**
	 * Returns the visit counter persistence.
	 *
	 * @return the visit counter persistence
	 */
	public VisitCounterPersistence getVisitCounterPersistence() {
		return visitCounterPersistence;
	}

	/**
	 * Sets the visit counter persistence.
	 *
	 * @param visitCounterPersistence the visit counter persistence
	 */
	public void setVisitCounterPersistence(
		VisitCounterPersistence visitCounterPersistence) {
		this.visitCounterPersistence = visitCounterPersistence;
	}

	/**
	 * Returns the visit counter day log local service.
	 *
	 * @return the visit counter day log local service
	 */
	public VisitCounterDayLogLocalService getVisitCounterDayLogLocalService() {
		return visitCounterDayLogLocalService;
	}

	/**
	 * Sets the visit counter day log local service.
	 *
	 * @param visitCounterDayLogLocalService the visit counter day log local service
	 */
	public void setVisitCounterDayLogLocalService(
		VisitCounterDayLogLocalService visitCounterDayLogLocalService) {
		this.visitCounterDayLogLocalService = visitCounterDayLogLocalService;
	}

	/**
	 * Returns the visit counter day log remote service.
	 *
	 * @return the visit counter day log remote service
	 */
	public VisitCounterDayLogService getVisitCounterDayLogService() {
		return visitCounterDayLogService;
	}

	/**
	 * Sets the visit counter day log remote service.
	 *
	 * @param visitCounterDayLogService the visit counter day log remote service
	 */
	public void setVisitCounterDayLogService(
		VisitCounterDayLogService visitCounterDayLogService) {
		this.visitCounterDayLogService = visitCounterDayLogService;
	}

	/**
	 * Returns the visit counter day log persistence.
	 *
	 * @return the visit counter day log persistence
	 */
	public VisitCounterDayLogPersistence getVisitCounterDayLogPersistence() {
		return visitCounterDayLogPersistence;
	}

	/**
	 * Sets the visit counter day log persistence.
	 *
	 * @param visitCounterDayLogPersistence the visit counter day log persistence
	 */
	public void setVisitCounterDayLogPersistence(
		VisitCounterDayLogPersistence visitCounterDayLogPersistence) {
		this.visitCounterDayLogPersistence = visitCounterDayLogPersistence;
	}

	/**
	 * Returns the visit counter log local service.
	 *
	 * @return the visit counter log local service
	 */
	public VisitCounterLogLocalService getVisitCounterLogLocalService() {
		return visitCounterLogLocalService;
	}

	/**
	 * Sets the visit counter log local service.
	 *
	 * @param visitCounterLogLocalService the visit counter log local service
	 */
	public void setVisitCounterLogLocalService(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		this.visitCounterLogLocalService = visitCounterLogLocalService;
	}

	/**
	 * Returns the visit counter log remote service.
	 *
	 * @return the visit counter log remote service
	 */
	public VisitCounterLogService getVisitCounterLogService() {
		return visitCounterLogService;
	}

	/**
	 * Sets the visit counter log remote service.
	 *
	 * @param visitCounterLogService the visit counter log remote service
	 */
	public void setVisitCounterLogService(
		VisitCounterLogService visitCounterLogService) {
		this.visitCounterLogService = visitCounterLogService;
	}

	/**
	 * Returns the visit counter log persistence.
	 *
	 * @return the visit counter log persistence
	 */
	public VisitCounterLogPersistence getVisitCounterLogPersistence() {
		return visitCounterLogPersistence;
	}

	/**
	 * Sets the visit counter log persistence.
	 *
	 * @param visitCounterLogPersistence the visit counter log persistence
	 */
	public void setVisitCounterLogPersistence(
		VisitCounterLogPersistence visitCounterLogPersistence) {
		this.visitCounterLogPersistence = visitCounterLogPersistence;
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
		return VisitCounterLog.class;
	}

	protected String getModelClassName() {
		return VisitCounterLog.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = visitCounterLogPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = VisitCounterLocalService.class)
	protected VisitCounterLocalService visitCounterLocalService;
	@BeanReference(type = VisitCounterService.class)
	protected VisitCounterService visitCounterService;
	@BeanReference(type = VisitCounterPersistence.class)
	protected VisitCounterPersistence visitCounterPersistence;
	@BeanReference(type = VisitCounterDayLogLocalService.class)
	protected VisitCounterDayLogLocalService visitCounterDayLogLocalService;
	@BeanReference(type = VisitCounterDayLogService.class)
	protected VisitCounterDayLogService visitCounterDayLogService;
	@BeanReference(type = VisitCounterDayLogPersistence.class)
	protected VisitCounterDayLogPersistence visitCounterDayLogPersistence;
	@BeanReference(type = VisitCounterLogLocalService.class)
	protected VisitCounterLogLocalService visitCounterLogLocalService;
	@BeanReference(type = VisitCounterLogService.class)
	protected VisitCounterLogService visitCounterLogService;
	@BeanReference(type = VisitCounterLogPersistence.class)
	protected VisitCounterLogPersistence visitCounterLogPersistence;
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
	private VisitCounterLogServiceClpInvoker _clpInvoker = new VisitCounterLogServiceClpInvoker();
}