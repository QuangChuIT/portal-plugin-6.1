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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the article link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntryPersistenceImpl
 * @see ArticleLinkEntryUtil
 * @generated
 */
public interface ArticleLinkEntryPersistence extends BasePersistence<ArticleLinkEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleLinkEntryUtil} to access the article link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the article link entry in the entity cache if it is enabled.
	*
	* @param articleLinkEntry the article link entry
	*/
	public void cacheResult(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry);

	/**
	* Caches the article link entries in the entity cache if it is enabled.
	*
	* @param articleLinkEntries the article link entries
	*/
	public void cacheResult(
		java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> articleLinkEntries);

	/**
	* Creates a new article link entry with the primary key. Does not add the article link entry to the database.
	*
	* @param entryId the primary key for the new article link entry
	* @return the new article link entry
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry create(
		long entryId);

	/**
	* Removes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry that was removed
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry remove(
		long entryId)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portlet.article.link.model.ArticleLinkEntry updateImpl(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article link entry with the primary key or throws a {@link com.bkav.portlet.article.link.NoSuchArticleLinkEntryException} if it could not be found.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByPrimaryKey(
		long entryId)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article link entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the article link entry
	* @return the article link entry, or <code>null</code> if a article link entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the article link entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the article link entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByCompanyAndStatus(
		long companyId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompanyAndStatus_First(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompanyAndStatus_First(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByCompanyAndStatus_Last(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article link entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByCompanyAndStatus_Last(
		long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByCompanyAndStatus_PrevAndNext(
		long entryId, long companyId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the article link entries where status = &#63;.
	*
	* @param status the status
	* @return the matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry
	* @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry findByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article link entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portlet.article.link.model.ArticleLinkEntry fetchByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portlet.article.link.model.ArticleLinkEntry[] findByStatus_PrevAndNext(
		long entryId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the article link entries.
	*
	* @return the article link entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portlet.article.link.model.ArticleLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the article link entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the article link entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndStatus(long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the article link entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the article link entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of article link entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of article link entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndStatus(long companyId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of article link entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching article link entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of article link entries.
	*
	* @return the number of article link entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}