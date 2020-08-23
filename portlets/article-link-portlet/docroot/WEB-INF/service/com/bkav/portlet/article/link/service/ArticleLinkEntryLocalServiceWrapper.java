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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ArticleLinkEntryLocalService}.
 * </p>
 *
 * @author    quangcv
 * @see       ArticleLinkEntryLocalService
 * @generated
 */
public class ArticleLinkEntryLocalServiceWrapper
	implements ArticleLinkEntryLocalService,
		ServiceWrapper<ArticleLinkEntryLocalService> {
	public ArticleLinkEntryLocalServiceWrapper(
		ArticleLinkEntryLocalService articleLinkEntryLocalService) {
		_articleLinkEntryLocalService = articleLinkEntryLocalService;
	}

	/**
	* Adds the article link entry to the database. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry addArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.addArticleLinkEntry(articleLinkEntry);
	}

	/**
	* Creates a new article link entry with the primary key. Does not add the article link entry to the database.
	*
	* @param entryId the primary key for the new article link entry
	* @return the new article link entry
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry createArticleLinkEntry(
		long entryId) {
		return _articleLinkEntryLocalService.createArticleLinkEntry(entryId);
	}

	/**
	* Deletes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry that was removed
	* @throws PortalException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry deleteArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.deleteArticleLinkEntry(entryId);
	}

	/**
	* Deletes the article link entry from the database. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry deleteArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.deleteArticleLinkEntry(articleLinkEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleLinkEntryLocalService.dynamicQuery();
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.dynamicQuery(dynamicQuery, start,
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.fetchArticleLinkEntry(entryId);
	}

	/**
	* Returns the article link entry with the primary key.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry
	* @throws PortalException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry getArticleLinkEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.getArticleLinkEntry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> getArticleLinkEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.getArticleLinkEntries(start, end);
	}

	/**
	* Returns the number of article link entries.
	*
	* @return the number of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public int getArticleLinkEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.getArticleLinkEntriesCount();
	}

	/**
	* Updates the article link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @return the article link entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry updateArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.updateArticleLinkEntry(articleLinkEntry);
	}

	/**
	* Updates the article link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articleLinkEntry the article link entry
	* @param merge whether to merge the article link entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the article link entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry updateArticleLinkEntry(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articleLinkEntryLocalService.updateArticleLinkEntry(articleLinkEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _articleLinkEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_articleLinkEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _articleLinkEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ArticleLinkEntryLocalService getWrappedArticleLinkEntryLocalService() {
		return _articleLinkEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedArticleLinkEntryLocalService(
		ArticleLinkEntryLocalService articleLinkEntryLocalService) {
		_articleLinkEntryLocalService = articleLinkEntryLocalService;
	}

	public ArticleLinkEntryLocalService getWrappedService() {
		return _articleLinkEntryLocalService;
	}

	public void setWrappedService(
		ArticleLinkEntryLocalService articleLinkEntryLocalService) {
		_articleLinkEntryLocalService = articleLinkEntryLocalService;
	}

	private ArticleLinkEntryLocalService _articleLinkEntryLocalService;
}