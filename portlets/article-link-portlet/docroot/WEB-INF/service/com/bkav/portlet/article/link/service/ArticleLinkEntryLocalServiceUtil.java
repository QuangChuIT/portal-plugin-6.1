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

package com.bkav.portlet.article.link.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the article link entry local service. This utility wraps {@link com.bkav.portlet.article.link.service.impl.ArticleLinkEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntryLocalService
 * @see com.bkav.portlet.article.link.service.base.ArticleLinkEntryLocalServiceBaseImpl
 * @see com.bkav.portlet.article.link.service.impl.ArticleLinkEntryLocalServiceImpl
 * @generated
 */
public class ArticleLinkEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portlet.article.link.service.impl.ArticleLinkEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the article link entry to the database. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry addArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addArticleLinkEntry(articleLinkEntry);
	}

	/**
	* Creates a new article link entry with the primary key. Does not add the article link entry to the database.
	*
	* @param entryId the primary key for the new article link entry
	* @return the new article link entry
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry createArticleLinkEntry(
		long entryId) {
		return getService().createArticleLinkEntry(entryId);
	}

	/**
	* Deletes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry that was removed
	* @throws PortalException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry deleteArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArticleLinkEntry(entryId);
	}

	/**
	* Deletes the article link entry from the database. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry deleteArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArticleLinkEntry(articleLinkEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchArticleLinkEntry(entryId);
	}

	/**
	* Returns the article link entry with the primary key.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry
	* @throws PortalException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry getArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleLinkEntry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the article link entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @return the range of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> getArticleLinkEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleLinkEntries(start, end);
	}

	/**
	* Returns the number of article link entries.
	*
	* @return the number of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getArticleLinkEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleLinkEntriesCount();
	}

	/**
	* Updates the article link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry updateArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArticleLinkEntry(articleLinkEntry);
	}

	/**
	* Updates the article link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @param merge whether to merge the article link entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the article link entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry updateArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArticleLinkEntry(articleLinkEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ArticleLinkEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ArticleLinkEntryLocalService.class.getName());

			if (invokableLocalService instanceof ArticleLinkEntryLocalService) {
				_service = (ArticleLinkEntryLocalService)invokableLocalService;
			}
			else {
				_service = new ArticleLinkEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ArticleLinkEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ArticleLinkEntryLocalService service) {
	}

	private static ArticleLinkEntryLocalService _service;
}