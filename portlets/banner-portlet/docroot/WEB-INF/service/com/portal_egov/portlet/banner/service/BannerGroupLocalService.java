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

package com.portal_egov.portlet.banner.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the banner group local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see BannerGroupLocalServiceUtil
 * @see com.portal_egov.portlet.banner.service.base.BannerGroupLocalServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.impl.BannerGroupLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BannerGroupLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerGroupLocalServiceUtil} to access the banner group local service. Add custom service methods to {@link com.portal_egov.portlet.banner.service.impl.BannerGroupLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the banner group to the database. Also notifies the appropriate model listeners.
	*
	* @param bannerGroup the banner group
	* @return the banner group that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup addBannerGroup(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new banner group with the primary key. Does not add the banner group to the database.
	*
	* @param bannerGroupId the primary key for the new banner group
	* @return the new banner group
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup createBannerGroup(
		long bannerGroupId);

	/**
	* Deletes the banner group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group that was removed
	* @throws PortalException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup deleteBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the banner group from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerGroup the banner group
	* @return the banner group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup deleteBannerGroup(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.banner.model.BannerGroup fetchBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banner group with the primary key.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group
	* @throws PortalException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.banner.model.BannerGroup getBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the banner groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @return the range of banner groups
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> getBannerGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banner groups.
	*
	* @return the number of banner groups
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBannerGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the banner group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bannerGroup the banner group
	* @return the banner group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup updateBannerGroup(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the banner group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bannerGroup the banner group
	* @param merge whether to merge the banner group with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the banner group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup updateBannerGroup(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.banner.model.BannerGroup addBannerGroup(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String groupName, java.lang.String groupDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.banner.model.BannerGroup updateBannerGroup(
		long bannerGroupId, java.lang.String groupName,
		java.lang.String groupDesc)
		throws com.liferay.portal.kernel.exception.SystemException;
}