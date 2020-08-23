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

package com.bkav.portlet.article.link.service.persistence;

import com.bkav.portlet.article.link.model.ArticleLinkEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the article link entry service. This utility wraps {@link ArticleLinkEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntryPersistence
 * @see ArticleLinkEntryPersistenceImpl
 * @generated
 */
public class ArticleLinkEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ArticleLinkEntry articleLinkEntry) {
		getPersistence().clearCache(articleLinkEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ArticleLinkEntry update(ArticleLinkEntry articleLinkEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(articleLinkEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ArticleLinkEntry update(ArticleLinkEntry articleLinkEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(articleLinkEntry, merge, serviceContext);
	}

	/**
	* Caches the article link entry in the entity cache if it is enabled.
	*
	* @param articleLinkEntry the article link entry
	*/
	public static void cacheResult(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry) {
		getPersistence().cacheResult(articleLinkEntry);
	}

	/**
	* Caches the article link entries in the entity cache if it is enabled.
	*
	* @param articleLinkEntries the article link entries
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> articleLinkEntries) {
		getPersistence().cacheResult(articleLinkEntries);
	}

	/**
	* Creates a new article link entry with the primary key. Does not add the article link entry to the database.
	*
	* @param entryId the primary key for the new article link entry
	* @return the new article link entry
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry that was removed
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry remove(
		long entryId)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(entryId);
	}

	public static com.bkav.portlet.article.link.model.ArticleLinkEntry updateImpl(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(articleLinkEntry, merge);
	}

	/**
	* Returns the article link entry with the primary key or throws a {@link com.bkav.portlet.article.link.NoSuchArticleLinkEntryException} if it could not be found.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByPrimaryKey(
		long entryId)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the article link entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry, or <code>null</code> if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the article link entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the article link entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @return the range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the article link entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the article link entries before and after the current article link entry in the ordered set where companyId = &#63;.
	*
	* @param entryId the primary key of the current article link entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the article link entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyAndStatus(companyId, status);
	}

	/**
	* Returns a range of all the article link entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @return the range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, status, start, end);
	}

	/**
	* Returns an ordered range of all the article link entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompanyAndStatus_First(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompanyAndStatus_First(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompanyAndStatus_Last(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompanyAndStatus_Last(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the article link entries before and after the current article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current article link entry
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByCompanyAndStatus_PrevAndNext(
		long entryId, long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_PrevAndNext(entryId, companyId,
			status, orderByComparator);
	}

	/**
	* Returns all the article link entries where status = &#63;.
	*
	* @param status the status
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the article link entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @return the range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the article link entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry findByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the article link entries before and after the current article link entry in the ordered set where status = &#63;.
	*
	* @param entryId the primary key of the current article link entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByStatus_PrevAndNext(
		long entryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(entryId, status, orderByComparator);
	}

	/**
	* Returns all the article link entries.
	*
	* @return the article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the article link entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of article link entries
	* @param end the upper bound of the range of article link entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the article link entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the article link entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndStatus(long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyAndStatus(companyId, status);
	}

	/**
	* Removes all the article link entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the article link entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of article link entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of article link entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndStatus(long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyAndStatus(companyId, status);
	}

	/**
	* Returns the number of article link entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of article link entries.
	*
	* @return the number of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArticleLinkEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArticleLinkEntryPersistence)PortletBeanLocatorUtil.locate(com.bkav.portlet.article.link.service.ClpSerializer.getServletContextName(),
					ArticleLinkEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ArticleLinkEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ArticleLinkEntryPersistence persistence) {
	}

	private static ArticleLinkEntryPersistence _persistence;
}