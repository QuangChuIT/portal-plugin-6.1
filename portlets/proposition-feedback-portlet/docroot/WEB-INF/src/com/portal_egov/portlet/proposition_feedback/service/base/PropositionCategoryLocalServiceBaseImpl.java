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

package com.portal_egov.portlet.proposition_feedback.service.base;

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

import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;
import com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalService;
import com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryService;
import com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalService;
import com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackService;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalService;
import com.portal_egov.portlet.proposition_feedback.service.PropositionService;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionCategoryPersistence;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFeedbackFinder;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFeedbackPersistence;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFinder;
import com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the proposition category local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.proposition_feedback.service.impl.PropositionCategoryLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.proposition_feedback.service.impl.PropositionCategoryLocalServiceImpl
 * @see com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil
 * @generated
 */
public abstract class PropositionCategoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements PropositionCategoryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil} to access the proposition category local service.
	 */

	/**
	 * Adds the proposition category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param propositionCategory the proposition category
	 * @return the proposition category that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PropositionCategory addPropositionCategory(
		PropositionCategory propositionCategory) throws SystemException {
		propositionCategory.setNew(true);

		return propositionCategoryPersistence.update(propositionCategory, false);
	}

	/**
	 * Creates a new proposition category with the primary key. Does not add the proposition category to the database.
	 *
	 * @param categoryId the primary key for the new proposition category
	 * @return the new proposition category
	 */
	public PropositionCategory createPropositionCategory(long categoryId) {
		return propositionCategoryPersistence.create(categoryId);
	}

	/**
	 * Deletes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the proposition category
	 * @return the proposition category that was removed
	 * @throws PortalException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public PropositionCategory deletePropositionCategory(long categoryId)
		throws PortalException, SystemException {
		return propositionCategoryPersistence.remove(categoryId);
	}

	/**
	 * Deletes the proposition category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propositionCategory the proposition category
	 * @return the proposition category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public PropositionCategory deletePropositionCategory(
		PropositionCategory propositionCategory) throws SystemException {
		return propositionCategoryPersistence.remove(propositionCategory);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PropositionCategory.class,
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
		return propositionCategoryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return propositionCategoryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return propositionCategoryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return propositionCategoryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public PropositionCategory fetchPropositionCategory(long categoryId)
		throws SystemException {
		return propositionCategoryPersistence.fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns the proposition category with the primary key.
	 *
	 * @param categoryId the primary key of the proposition category
	 * @return the proposition category
	 * @throws PortalException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory getPropositionCategory(long categoryId)
		throws PortalException, SystemException {
		return propositionCategoryPersistence.findByPrimaryKey(categoryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return propositionCategoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the proposition categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> getPropositionCategories(int start, int end)
		throws SystemException {
		return propositionCategoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of proposition categories.
	 *
	 * @return the number of proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int getPropositionCategoriesCount() throws SystemException {
		return propositionCategoryPersistence.countAll();
	}

	/**
	 * Updates the proposition category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param propositionCategory the proposition category
	 * @return the proposition category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PropositionCategory updatePropositionCategory(
		PropositionCategory propositionCategory) throws SystemException {
		return updatePropositionCategory(propositionCategory, true);
	}

	/**
	 * Updates the proposition category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param propositionCategory the proposition category
	 * @param merge whether to merge the proposition category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the proposition category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PropositionCategory updatePropositionCategory(
		PropositionCategory propositionCategory, boolean merge)
		throws SystemException {
		propositionCategory.setNew(false);

		return propositionCategoryPersistence.update(propositionCategory, merge);
	}

	/**
	 * Returns the proposition local service.
	 *
	 * @return the proposition local service
	 */
	public PropositionLocalService getPropositionLocalService() {
		return propositionLocalService;
	}

	/**
	 * Sets the proposition local service.
	 *
	 * @param propositionLocalService the proposition local service
	 */
	public void setPropositionLocalService(
		PropositionLocalService propositionLocalService) {
		this.propositionLocalService = propositionLocalService;
	}

	/**
	 * Returns the proposition remote service.
	 *
	 * @return the proposition remote service
	 */
	public PropositionService getPropositionService() {
		return propositionService;
	}

	/**
	 * Sets the proposition remote service.
	 *
	 * @param propositionService the proposition remote service
	 */
	public void setPropositionService(PropositionService propositionService) {
		this.propositionService = propositionService;
	}

	/**
	 * Returns the proposition persistence.
	 *
	 * @return the proposition persistence
	 */
	public PropositionPersistence getPropositionPersistence() {
		return propositionPersistence;
	}

	/**
	 * Sets the proposition persistence.
	 *
	 * @param propositionPersistence the proposition persistence
	 */
	public void setPropositionPersistence(
		PropositionPersistence propositionPersistence) {
		this.propositionPersistence = propositionPersistence;
	}

	/**
	 * Returns the proposition finder.
	 *
	 * @return the proposition finder
	 */
	public PropositionFinder getPropositionFinder() {
		return propositionFinder;
	}

	/**
	 * Sets the proposition finder.
	 *
	 * @param propositionFinder the proposition finder
	 */
	public void setPropositionFinder(PropositionFinder propositionFinder) {
		this.propositionFinder = propositionFinder;
	}

	/**
	 * Returns the proposition category local service.
	 *
	 * @return the proposition category local service
	 */
	public PropositionCategoryLocalService getPropositionCategoryLocalService() {
		return propositionCategoryLocalService;
	}

	/**
	 * Sets the proposition category local service.
	 *
	 * @param propositionCategoryLocalService the proposition category local service
	 */
	public void setPropositionCategoryLocalService(
		PropositionCategoryLocalService propositionCategoryLocalService) {
		this.propositionCategoryLocalService = propositionCategoryLocalService;
	}

	/**
	 * Returns the proposition category remote service.
	 *
	 * @return the proposition category remote service
	 */
	public PropositionCategoryService getPropositionCategoryService() {
		return propositionCategoryService;
	}

	/**
	 * Sets the proposition category remote service.
	 *
	 * @param propositionCategoryService the proposition category remote service
	 */
	public void setPropositionCategoryService(
		PropositionCategoryService propositionCategoryService) {
		this.propositionCategoryService = propositionCategoryService;
	}

	/**
	 * Returns the proposition category persistence.
	 *
	 * @return the proposition category persistence
	 */
	public PropositionCategoryPersistence getPropositionCategoryPersistence() {
		return propositionCategoryPersistence;
	}

	/**
	 * Sets the proposition category persistence.
	 *
	 * @param propositionCategoryPersistence the proposition category persistence
	 */
	public void setPropositionCategoryPersistence(
		PropositionCategoryPersistence propositionCategoryPersistence) {
		this.propositionCategoryPersistence = propositionCategoryPersistence;
	}

	/**
	 * Returns the proposition feedback local service.
	 *
	 * @return the proposition feedback local service
	 */
	public PropositionFeedbackLocalService getPropositionFeedbackLocalService() {
		return propositionFeedbackLocalService;
	}

	/**
	 * Sets the proposition feedback local service.
	 *
	 * @param propositionFeedbackLocalService the proposition feedback local service
	 */
	public void setPropositionFeedbackLocalService(
		PropositionFeedbackLocalService propositionFeedbackLocalService) {
		this.propositionFeedbackLocalService = propositionFeedbackLocalService;
	}

	/**
	 * Returns the proposition feedback remote service.
	 *
	 * @return the proposition feedback remote service
	 */
	public PropositionFeedbackService getPropositionFeedbackService() {
		return propositionFeedbackService;
	}

	/**
	 * Sets the proposition feedback remote service.
	 *
	 * @param propositionFeedbackService the proposition feedback remote service
	 */
	public void setPropositionFeedbackService(
		PropositionFeedbackService propositionFeedbackService) {
		this.propositionFeedbackService = propositionFeedbackService;
	}

	/**
	 * Returns the proposition feedback persistence.
	 *
	 * @return the proposition feedback persistence
	 */
	public PropositionFeedbackPersistence getPropositionFeedbackPersistence() {
		return propositionFeedbackPersistence;
	}

	/**
	 * Sets the proposition feedback persistence.
	 *
	 * @param propositionFeedbackPersistence the proposition feedback persistence
	 */
	public void setPropositionFeedbackPersistence(
		PropositionFeedbackPersistence propositionFeedbackPersistence) {
		this.propositionFeedbackPersistence = propositionFeedbackPersistence;
	}

	/**
	 * Returns the proposition feedback finder.
	 *
	 * @return the proposition feedback finder
	 */
	public PropositionFeedbackFinder getPropositionFeedbackFinder() {
		return propositionFeedbackFinder;
	}

	/**
	 * Sets the proposition feedback finder.
	 *
	 * @param propositionFeedbackFinder the proposition feedback finder
	 */
	public void setPropositionFeedbackFinder(
		PropositionFeedbackFinder propositionFeedbackFinder) {
		this.propositionFeedbackFinder = propositionFeedbackFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.proposition_feedback.model.PropositionCategory",
			propositionCategoryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.proposition_feedback.model.PropositionCategory");
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
		return PropositionCategory.class;
	}

	protected String getModelClassName() {
		return PropositionCategory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = propositionCategoryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PropositionLocalService.class)
	protected PropositionLocalService propositionLocalService;
	@BeanReference(type = PropositionService.class)
	protected PropositionService propositionService;
	@BeanReference(type = PropositionPersistence.class)
	protected PropositionPersistence propositionPersistence;
	@BeanReference(type = PropositionFinder.class)
	protected PropositionFinder propositionFinder;
	@BeanReference(type = PropositionCategoryLocalService.class)
	protected PropositionCategoryLocalService propositionCategoryLocalService;
	@BeanReference(type = PropositionCategoryService.class)
	protected PropositionCategoryService propositionCategoryService;
	@BeanReference(type = PropositionCategoryPersistence.class)
	protected PropositionCategoryPersistence propositionCategoryPersistence;
	@BeanReference(type = PropositionFeedbackLocalService.class)
	protected PropositionFeedbackLocalService propositionFeedbackLocalService;
	@BeanReference(type = PropositionFeedbackService.class)
	protected PropositionFeedbackService propositionFeedbackService;
	@BeanReference(type = PropositionFeedbackPersistence.class)
	protected PropositionFeedbackPersistence propositionFeedbackPersistence;
	@BeanReference(type = PropositionFeedbackFinder.class)
	protected PropositionFeedbackFinder propositionFeedbackFinder;
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
	private PropositionCategoryLocalServiceClpInvoker _clpInvoker = new PropositionCategoryLocalServiceClpInvoker();
}