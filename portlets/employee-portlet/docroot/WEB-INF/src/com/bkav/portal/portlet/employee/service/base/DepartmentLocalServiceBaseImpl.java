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

package com.bkav.portal.portlet.employee.service.base;

import com.bkav.portal.portlet.employee.model.Department;
import com.bkav.portal.portlet.employee.service.DepartmentLocalService;
import com.bkav.portal.portlet.employee.service.DepartmentService;
import com.bkav.portal.portlet.employee.service.EmployeeLocalService;
import com.bkav.portal.portlet.employee.service.EmployeeService;
import com.bkav.portal.portlet.employee.service.PostLocalService;
import com.bkav.portal.portlet.employee.service.PostService;
import com.bkav.portal.portlet.employee.service.persistence.DepartmentFinder;
import com.bkav.portal.portlet.employee.service.persistence.DepartmentPersistence;
import com.bkav.portal.portlet.employee.service.persistence.EmployeeFinder;
import com.bkav.portal.portlet.employee.service.persistence.EmployeePersistence;
import com.bkav.portal.portlet.employee.service.persistence.PostFinder;
import com.bkav.portal.portlet.employee.service.persistence.PostPersistence;

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
 * The base implementation of the department local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.employee.service.impl.DepartmentLocalServiceImpl}.
 * </p>
 *
 * @author ducdvd
 * @see com.bkav.portal.portlet.employee.service.impl.DepartmentLocalServiceImpl
 * @see com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil
 * @generated
 */
public abstract class DepartmentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DepartmentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil} to access the department local service.
	 */

	/**
	 * Adds the department to the database. Also notifies the appropriate model listeners.
	 *
	 * @param department the department
	 * @return the department that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Department addDepartment(Department department)
		throws SystemException {
		department.setNew(true);

		return departmentPersistence.update(department, false);
	}

	/**
	 * Creates a new department with the primary key. Does not add the department to the database.
	 *
	 * @param depId the primary key for the new department
	 * @return the new department
	 */
	public Department createDepartment(long depId) {
		return departmentPersistence.create(depId);
	}

	/**
	 * Deletes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param depId the primary key of the department
	 * @return the department that was removed
	 * @throws PortalException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Department deleteDepartment(long depId)
		throws PortalException, SystemException {
		return departmentPersistence.remove(depId);
	}

	/**
	 * Deletes the department from the database. Also notifies the appropriate model listeners.
	 *
	 * @param department the department
	 * @return the department that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Department deleteDepartment(Department department)
		throws SystemException {
		return departmentPersistence.remove(department);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Department.class,
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
		return departmentPersistence.findWithDynamicQuery(dynamicQuery);
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
		return departmentPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return departmentPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return departmentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Department fetchDepartment(long depId) throws SystemException {
		return departmentPersistence.fetchByPrimaryKey(depId);
	}

	/**
	 * Returns the department with the primary key.
	 *
	 * @param depId the primary key of the department
	 * @return the department
	 * @throws PortalException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Department getDepartment(long depId)
		throws PortalException, SystemException {
		return departmentPersistence.findByPrimaryKey(depId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return departmentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @return the range of departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Department> getDepartments(int start, int end)
		throws SystemException {
		return departmentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of departments.
	 *
	 * @return the number of departments
	 * @throws SystemException if a system exception occurred
	 */
	public int getDepartmentsCount() throws SystemException {
		return departmentPersistence.countAll();
	}

	/**
	 * Updates the department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param department the department
	 * @return the department that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Department updateDepartment(Department department)
		throws SystemException {
		return updateDepartment(department, true);
	}

	/**
	 * Updates the department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param department the department
	 * @param merge whether to merge the department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the department that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Department updateDepartment(Department department, boolean merge)
		throws SystemException {
		department.setNew(false);

		return departmentPersistence.update(department, merge);
	}

	/**
	 * Returns the department local service.
	 *
	 * @return the department local service
	 */
	public DepartmentLocalService getDepartmentLocalService() {
		return departmentLocalService;
	}

	/**
	 * Sets the department local service.
	 *
	 * @param departmentLocalService the department local service
	 */
	public void setDepartmentLocalService(
		DepartmentLocalService departmentLocalService) {
		this.departmentLocalService = departmentLocalService;
	}

	/**
	 * Returns the department remote service.
	 *
	 * @return the department remote service
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * Sets the department remote service.
	 *
	 * @param departmentService the department remote service
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * Returns the department persistence.
	 *
	 * @return the department persistence
	 */
	public DepartmentPersistence getDepartmentPersistence() {
		return departmentPersistence;
	}

	/**
	 * Sets the department persistence.
	 *
	 * @param departmentPersistence the department persistence
	 */
	public void setDepartmentPersistence(
		DepartmentPersistence departmentPersistence) {
		this.departmentPersistence = departmentPersistence;
	}

	/**
	 * Returns the department finder.
	 *
	 * @return the department finder
	 */
	public DepartmentFinder getDepartmentFinder() {
		return departmentFinder;
	}

	/**
	 * Sets the department finder.
	 *
	 * @param departmentFinder the department finder
	 */
	public void setDepartmentFinder(DepartmentFinder departmentFinder) {
		this.departmentFinder = departmentFinder;
	}

	/**
	 * Returns the employee local service.
	 *
	 * @return the employee local service
	 */
	public EmployeeLocalService getEmployeeLocalService() {
		return employeeLocalService;
	}

	/**
	 * Sets the employee local service.
	 *
	 * @param employeeLocalService the employee local service
	 */
	public void setEmployeeLocalService(
		EmployeeLocalService employeeLocalService) {
		this.employeeLocalService = employeeLocalService;
	}

	/**
	 * Returns the employee remote service.
	 *
	 * @return the employee remote service
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * Sets the employee remote service.
	 *
	 * @param employeeService the employee remote service
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Returns the employee persistence.
	 *
	 * @return the employee persistence
	 */
	public EmployeePersistence getEmployeePersistence() {
		return employeePersistence;
	}

	/**
	 * Sets the employee persistence.
	 *
	 * @param employeePersistence the employee persistence
	 */
	public void setEmployeePersistence(EmployeePersistence employeePersistence) {
		this.employeePersistence = employeePersistence;
	}

	/**
	 * Returns the employee finder.
	 *
	 * @return the employee finder
	 */
	public EmployeeFinder getEmployeeFinder() {
		return employeeFinder;
	}

	/**
	 * Sets the employee finder.
	 *
	 * @param employeeFinder the employee finder
	 */
	public void setEmployeeFinder(EmployeeFinder employeeFinder) {
		this.employeeFinder = employeeFinder;
	}

	/**
	 * Returns the post local service.
	 *
	 * @return the post local service
	 */
	public PostLocalService getPostLocalService() {
		return postLocalService;
	}

	/**
	 * Sets the post local service.
	 *
	 * @param postLocalService the post local service
	 */
	public void setPostLocalService(PostLocalService postLocalService) {
		this.postLocalService = postLocalService;
	}

	/**
	 * Returns the post remote service.
	 *
	 * @return the post remote service
	 */
	public PostService getPostService() {
		return postService;
	}

	/**
	 * Sets the post remote service.
	 *
	 * @param postService the post remote service
	 */
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	/**
	 * Returns the post persistence.
	 *
	 * @return the post persistence
	 */
	public PostPersistence getPostPersistence() {
		return postPersistence;
	}

	/**
	 * Sets the post persistence.
	 *
	 * @param postPersistence the post persistence
	 */
	public void setPostPersistence(PostPersistence postPersistence) {
		this.postPersistence = postPersistence;
	}

	/**
	 * Returns the post finder.
	 *
	 * @return the post finder
	 */
	public PostFinder getPostFinder() {
		return postFinder;
	}

	/**
	 * Sets the post finder.
	 *
	 * @param postFinder the post finder
	 */
	public void setPostFinder(PostFinder postFinder) {
		this.postFinder = postFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.bkav.portal.portlet.employee.model.Department",
			departmentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.bkav.portal.portlet.employee.model.Department");
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
		return Department.class;
	}

	protected String getModelClassName() {
		return Department.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = departmentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DepartmentLocalService.class)
	protected DepartmentLocalService departmentLocalService;
	@BeanReference(type = DepartmentService.class)
	protected DepartmentService departmentService;
	@BeanReference(type = DepartmentPersistence.class)
	protected DepartmentPersistence departmentPersistence;
	@BeanReference(type = DepartmentFinder.class)
	protected DepartmentFinder departmentFinder;
	@BeanReference(type = EmployeeLocalService.class)
	protected EmployeeLocalService employeeLocalService;
	@BeanReference(type = EmployeeService.class)
	protected EmployeeService employeeService;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = EmployeeFinder.class)
	protected EmployeeFinder employeeFinder;
	@BeanReference(type = PostLocalService.class)
	protected PostLocalService postLocalService;
	@BeanReference(type = PostService.class)
	protected PostService postService;
	@BeanReference(type = PostPersistence.class)
	protected PostPersistence postPersistence;
	@BeanReference(type = PostFinder.class)
	protected PostFinder postFinder;
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
	private DepartmentLocalServiceClpInvoker _clpInvoker = new DepartmentLocalServiceClpInvoker();
}