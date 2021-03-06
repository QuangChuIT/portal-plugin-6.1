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

package com.portal_egov.portlet.citymaps.service.base;

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

import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.service.CityMapLocalService;
import com.portal_egov.portlet.citymaps.service.CityMapService;
import com.portal_egov.portlet.citymaps.service.CityMapTypeLocalService;
import com.portal_egov.portlet.citymaps.service.CityMapTypeService;
import com.portal_egov.portlet.citymaps.service.persistence.CityMapFinder;
import com.portal_egov.portlet.citymaps.service.persistence.CityMapPersistence;
import com.portal_egov.portlet.citymaps.service.persistence.CityMapTypePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the city map local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.citymaps.service.impl.CityMapLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.citymaps.service.impl.CityMapLocalServiceImpl
 * @see com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil
 * @generated
 */
public abstract class CityMapLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CityMapLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil} to access the city map local service.
	 */

	/**
	 * Adds the city map to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityMap the city map
	 * @return the city map that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CityMap addCityMap(CityMap cityMap) throws SystemException {
		cityMap.setNew(true);

		return cityMapPersistence.update(cityMap, false);
	}

	/**
	 * Creates a new city map with the primary key. Does not add the city map to the database.
	 *
	 * @param mapId the primary key for the new city map
	 * @return the new city map
	 */
	public CityMap createCityMap(long mapId) {
		return cityMapPersistence.create(mapId);
	}

	/**
	 * Deletes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapId the primary key of the city map
	 * @return the city map that was removed
	 * @throws PortalException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CityMap deleteCityMap(long mapId)
		throws PortalException, SystemException {
		return cityMapPersistence.remove(mapId);
	}

	/**
	 * Deletes the city map from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityMap the city map
	 * @return the city map that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CityMap deleteCityMap(CityMap cityMap) throws SystemException {
		return cityMapPersistence.remove(cityMap);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CityMap.class,
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
		return cityMapPersistence.findWithDynamicQuery(dynamicQuery);
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
		return cityMapPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return cityMapPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return cityMapPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public CityMap fetchCityMap(long mapId) throws SystemException {
		return cityMapPersistence.fetchByPrimaryKey(mapId);
	}

	/**
	 * Returns the city map with the primary key.
	 *
	 * @param mapId the primary key of the city map
	 * @return the city map
	 * @throws PortalException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap getCityMap(long mapId)
		throws PortalException, SystemException {
		return cityMapPersistence.findByPrimaryKey(mapId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return cityMapPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the city maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> getCityMaps(int start, int end)
		throws SystemException {
		return cityMapPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of city maps.
	 *
	 * @return the number of city maps
	 * @throws SystemException if a system exception occurred
	 */
	public int getCityMapsCount() throws SystemException {
		return cityMapPersistence.countAll();
	}

	/**
	 * Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cityMap the city map
	 * @return the city map that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CityMap updateCityMap(CityMap cityMap) throws SystemException {
		return updateCityMap(cityMap, true);
	}

	/**
	 * Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cityMap the city map
	 * @param merge whether to merge the city map with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the city map that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CityMap updateCityMap(CityMap cityMap, boolean merge)
		throws SystemException {
		cityMap.setNew(false);

		return cityMapPersistence.update(cityMap, merge);
	}

	/**
	 * Returns the city map local service.
	 *
	 * @return the city map local service
	 */
	public CityMapLocalService getCityMapLocalService() {
		return cityMapLocalService;
	}

	/**
	 * Sets the city map local service.
	 *
	 * @param cityMapLocalService the city map local service
	 */
	public void setCityMapLocalService(CityMapLocalService cityMapLocalService) {
		this.cityMapLocalService = cityMapLocalService;
	}

	/**
	 * Returns the city map remote service.
	 *
	 * @return the city map remote service
	 */
	public CityMapService getCityMapService() {
		return cityMapService;
	}

	/**
	 * Sets the city map remote service.
	 *
	 * @param cityMapService the city map remote service
	 */
	public void setCityMapService(CityMapService cityMapService) {
		this.cityMapService = cityMapService;
	}

	/**
	 * Returns the city map persistence.
	 *
	 * @return the city map persistence
	 */
	public CityMapPersistence getCityMapPersistence() {
		return cityMapPersistence;
	}

	/**
	 * Sets the city map persistence.
	 *
	 * @param cityMapPersistence the city map persistence
	 */
	public void setCityMapPersistence(CityMapPersistence cityMapPersistence) {
		this.cityMapPersistence = cityMapPersistence;
	}

	/**
	 * Returns the city map finder.
	 *
	 * @return the city map finder
	 */
	public CityMapFinder getCityMapFinder() {
		return cityMapFinder;
	}

	/**
	 * Sets the city map finder.
	 *
	 * @param cityMapFinder the city map finder
	 */
	public void setCityMapFinder(CityMapFinder cityMapFinder) {
		this.cityMapFinder = cityMapFinder;
	}

	/**
	 * Returns the city map type local service.
	 *
	 * @return the city map type local service
	 */
	public CityMapTypeLocalService getCityMapTypeLocalService() {
		return cityMapTypeLocalService;
	}

	/**
	 * Sets the city map type local service.
	 *
	 * @param cityMapTypeLocalService the city map type local service
	 */
	public void setCityMapTypeLocalService(
		CityMapTypeLocalService cityMapTypeLocalService) {
		this.cityMapTypeLocalService = cityMapTypeLocalService;
	}

	/**
	 * Returns the city map type remote service.
	 *
	 * @return the city map type remote service
	 */
	public CityMapTypeService getCityMapTypeService() {
		return cityMapTypeService;
	}

	/**
	 * Sets the city map type remote service.
	 *
	 * @param cityMapTypeService the city map type remote service
	 */
	public void setCityMapTypeService(CityMapTypeService cityMapTypeService) {
		this.cityMapTypeService = cityMapTypeService;
	}

	/**
	 * Returns the city map type persistence.
	 *
	 * @return the city map type persistence
	 */
	public CityMapTypePersistence getCityMapTypePersistence() {
		return cityMapTypePersistence;
	}

	/**
	 * Sets the city map type persistence.
	 *
	 * @param cityMapTypePersistence the city map type persistence
	 */
	public void setCityMapTypePersistence(
		CityMapTypePersistence cityMapTypePersistence) {
		this.cityMapTypePersistence = cityMapTypePersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.citymaps.model.CityMap",
			cityMapLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.citymaps.model.CityMap");
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
		return CityMap.class;
	}

	protected String getModelClassName() {
		return CityMap.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cityMapPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CityMapLocalService.class)
	protected CityMapLocalService cityMapLocalService;
	@BeanReference(type = CityMapService.class)
	protected CityMapService cityMapService;
	@BeanReference(type = CityMapPersistence.class)
	protected CityMapPersistence cityMapPersistence;
	@BeanReference(type = CityMapFinder.class)
	protected CityMapFinder cityMapFinder;
	@BeanReference(type = CityMapTypeLocalService.class)
	protected CityMapTypeLocalService cityMapTypeLocalService;
	@BeanReference(type = CityMapTypeService.class)
	protected CityMapTypeService cityMapTypeService;
	@BeanReference(type = CityMapTypePersistence.class)
	protected CityMapTypePersistence cityMapTypePersistence;
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
	private CityMapLocalServiceClpInvoker _clpInvoker = new CityMapLocalServiceClpInvoker();
}