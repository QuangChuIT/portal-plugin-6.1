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

import com.bkav.portlet.article.link.NoSuchArticleLinkEntryException;
import com.bkav.portlet.article.link.model.ArticleLinkEntry;
import com.bkav.portlet.article.link.model.impl.ArticleLinkEntryImpl;
import com.bkav.portlet.article.link.model.impl.ArticleLinkEntryModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the article link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quangcv
 * @see ArticleLinkEntryPersistence
 * @see ArticleLinkEntryUtil
 * @generated
 */
public class ArticleLinkEntryPersistenceImpl extends BasePersistenceImpl<ArticleLinkEntry>
	implements ArticleLinkEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArticleLinkEntryUtil} to access the article link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArticleLinkEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			ArticleLinkEntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ArticleLinkEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			ArticleLinkEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDSTATUS = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Boolean.class.getName() },
			ArticleLinkEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ArticleLinkEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the article link entry in the entity cache if it is enabled.
	 *
	 * @param articleLinkEntry the article link entry
	 */
	public void cacheResult(ArticleLinkEntry articleLinkEntry) {
		EntityCacheUtil.putResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, articleLinkEntry.getPrimaryKey(),
			articleLinkEntry);

		articleLinkEntry.resetOriginalValues();
	}

	/**
	 * Caches the article link entries in the entity cache if it is enabled.
	 *
	 * @param articleLinkEntries the article link entries
	 */
	public void cacheResult(List<ArticleLinkEntry> articleLinkEntries) {
		for (ArticleLinkEntry articleLinkEntry : articleLinkEntries) {
			if (EntityCacheUtil.getResult(
						ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
						ArticleLinkEntryImpl.class,
						articleLinkEntry.getPrimaryKey()) == null) {
				cacheResult(articleLinkEntry);
			}
			else {
				articleLinkEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all article link entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArticleLinkEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArticleLinkEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article link entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArticleLinkEntry articleLinkEntry) {
		EntityCacheUtil.removeResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, articleLinkEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ArticleLinkEntry> articleLinkEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArticleLinkEntry articleLinkEntry : articleLinkEntries) {
			EntityCacheUtil.removeResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
				ArticleLinkEntryImpl.class, articleLinkEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new article link entry with the primary key. Does not add the article link entry to the database.
	 *
	 * @param entryId the primary key for the new article link entry
	 * @return the new article link entry
	 */
	public ArticleLinkEntry create(long entryId) {
		ArticleLinkEntry articleLinkEntry = new ArticleLinkEntryImpl();

		articleLinkEntry.setNew(true);
		articleLinkEntry.setPrimaryKey(entryId);

		return articleLinkEntry;
	}

	/**
	 * Removes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the article link entry
	 * @return the article link entry that was removed
	 * @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry remove(long entryId)
		throws NoSuchArticleLinkEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the article link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article link entry
	 * @return the article link entry that was removed
	 * @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArticleLinkEntry remove(Serializable primaryKey)
		throws NoSuchArticleLinkEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ArticleLinkEntry articleLinkEntry = (ArticleLinkEntry)session.get(ArticleLinkEntryImpl.class,
					primaryKey);

			if (articleLinkEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleLinkEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(articleLinkEntry);
		}
		catch (NoSuchArticleLinkEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ArticleLinkEntry removeImpl(ArticleLinkEntry articleLinkEntry)
		throws SystemException {
		articleLinkEntry = toUnwrappedModel(articleLinkEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, articleLinkEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(articleLinkEntry);

		return articleLinkEntry;
	}

	@Override
	public ArticleLinkEntry updateImpl(
		com.bkav.portlet.article.link.model.ArticleLinkEntry articleLinkEntry,
		boolean merge) throws SystemException {
		articleLinkEntry = toUnwrappedModel(articleLinkEntry);

		boolean isNew = articleLinkEntry.isNew();

		ArticleLinkEntryModelImpl articleLinkEntryModelImpl = (ArticleLinkEntryModelImpl)articleLinkEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, articleLinkEntry, merge);

			articleLinkEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ArticleLinkEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((articleLinkEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(articleLinkEntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(articleLinkEntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((articleLinkEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(articleLinkEntryModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(articleLinkEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(articleLinkEntryModelImpl.getCompanyId()),
						Boolean.valueOf(articleLinkEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);
			}

			if ((articleLinkEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(articleLinkEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Boolean.valueOf(articleLinkEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ArticleLinkEntryImpl.class, articleLinkEntry.getPrimaryKey(),
			articleLinkEntry);

		return articleLinkEntry;
	}

	protected ArticleLinkEntry toUnwrappedModel(
		ArticleLinkEntry articleLinkEntry) {
		if (articleLinkEntry instanceof ArticleLinkEntryImpl) {
			return articleLinkEntry;
		}

		ArticleLinkEntryImpl articleLinkEntryImpl = new ArticleLinkEntryImpl();

		articleLinkEntryImpl.setNew(articleLinkEntry.isNew());
		articleLinkEntryImpl.setPrimaryKey(articleLinkEntry.getPrimaryKey());

		articleLinkEntryImpl.setEntryId(articleLinkEntry.getEntryId());
		articleLinkEntryImpl.setCompanyId(articleLinkEntry.getCompanyId());
		articleLinkEntryImpl.setUserId(articleLinkEntry.getUserId());
		articleLinkEntryImpl.setUserName(articleLinkEntry.getUserName());
		articleLinkEntryImpl.setCreateDate(articleLinkEntry.getCreateDate());
		articleLinkEntryImpl.setModifiedDate(articleLinkEntry.getModifiedDate());
		articleLinkEntryImpl.setPublishDate(articleLinkEntry.getPublishDate());
		articleLinkEntryImpl.setTitle(articleLinkEntry.getTitle());
		articleLinkEntryImpl.setLink(articleLinkEntry.getLink());
		articleLinkEntryImpl.setDescription(articleLinkEntry.getDescription());
		articleLinkEntryImpl.setStatus(articleLinkEntry.isStatus());
		articleLinkEntryImpl.setUrlTitle(articleLinkEntry.getUrlTitle());

		return articleLinkEntryImpl;
	}

	/**
	 * Returns the article link entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the article link entry
	 * @return the article link entry
	 * @throws com.liferay.portal.NoSuchModelException if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArticleLinkEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the article link entry with the primary key or throws a {@link com.bkav.portlet.article.link.NoSuchArticleLinkEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the article link entry
	 * @return the article link entry
	 * @throws com.bkav.portlet.article.link.NoSuchArticleLinkEntryException if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry findByPrimaryKey(long entryId)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByPrimaryKey(entryId);

		if (articleLinkEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchArticleLinkEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return articleLinkEntry;
	}

	/**
	 * Returns the article link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article link entry
	 * @return the article link entry, or <code>null</code> if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArticleLinkEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the article link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the article link entry
	 * @return the article link entry, or <code>null</code> if a article link entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry fetchByPrimaryKey(long entryId)
		throws SystemException {
		ArticleLinkEntry articleLinkEntry = (ArticleLinkEntry)EntityCacheUtil.getResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
				ArticleLinkEntryImpl.class, entryId);

		if (articleLinkEntry == _nullArticleLinkEntry) {
			return null;
		}

		if (articleLinkEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				articleLinkEntry = (ArticleLinkEntry)session.get(ArticleLinkEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (articleLinkEntry != null) {
					cacheResult(articleLinkEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ArticleLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
						ArticleLinkEntryImpl.class, entryId,
						_nullArticleLinkEntry);
				}

				closeSession(session);
			}
		}

		return articleLinkEntry;
	}

	/**
	 * Returns all the article link entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ArticleLinkEntry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<ArticleLinkEntry> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
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
	public List<ArticleLinkEntry> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<ArticleLinkEntry> list = (List<ArticleLinkEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ArticleLinkEntry articleLinkEntry : list) {
				if ((companyId != articleLinkEntry.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<ArticleLinkEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public ArticleLinkEntry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByCompany_First(companyId,
				orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
	}

	/**
	 * Returns the first article link entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ArticleLinkEntry> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByCompany_Last(companyId,
				orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
	}

	/**
	 * Returns the last article link entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<ArticleLinkEntry> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry[] findByCompany_PrevAndNext(long entryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			ArticleLinkEntry[] array = new ArticleLinkEntryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, articleLinkEntry,
					companyId, orderByComparator, true);

			array[1] = articleLinkEntry;

			array[2] = getByCompany_PrevAndNext(session, articleLinkEntry,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleLinkEntry getByCompany_PrevAndNext(Session session,
		ArticleLinkEntry articleLinkEntry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(articleLinkEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ArticleLinkEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the article link entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ArticleLinkEntry> findByCompanyAndStatus(long companyId,
		boolean status) throws SystemException {
		return findByCompanyAndStatus(companyId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<ArticleLinkEntry> findByCompanyAndStatus(long companyId,
		boolean status, int start, int end) throws SystemException {
		return findByCompanyAndStatus(companyId, status, start, end, null);
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
	public List<ArticleLinkEntry> findByCompanyAndStatus(long companyId,
		boolean status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] { companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] {
					companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<ArticleLinkEntry> list = (List<ArticleLinkEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ArticleLinkEntry articleLinkEntry : list) {
				if ((companyId != articleLinkEntry.getCompanyId()) ||
						(status != articleLinkEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<ArticleLinkEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public ArticleLinkEntry findByCompanyAndStatus_First(long companyId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByCompanyAndStatus_First(companyId,
				status, orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
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
	public ArticleLinkEntry fetchByCompanyAndStatus_First(long companyId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ArticleLinkEntry> list = findByCompanyAndStatus(companyId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry findByCompanyAndStatus_Last(long companyId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByCompanyAndStatus_Last(companyId,
				status, orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
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
	public ArticleLinkEntry fetchByCompanyAndStatus_Last(long companyId,
		boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyAndStatus(companyId, status);

		List<ArticleLinkEntry> list = findByCompanyAndStatus(companyId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry[] findByCompanyAndStatus_PrevAndNext(long entryId,
		long companyId, boolean status, OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			ArticleLinkEntry[] array = new ArticleLinkEntryImpl[3];

			array[0] = getByCompanyAndStatus_PrevAndNext(session,
					articleLinkEntry, companyId, status, orderByComparator, true);

			array[1] = articleLinkEntry;

			array[2] = getByCompanyAndStatus_PrevAndNext(session,
					articleLinkEntry, companyId, status, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleLinkEntry getByCompanyAndStatus_PrevAndNext(
		Session session, ArticleLinkEntry articleLinkEntry, long companyId,
		boolean status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(articleLinkEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ArticleLinkEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the article link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ArticleLinkEntry> findByStatus(boolean status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ArticleLinkEntry> findByStatus(boolean status, int start,
		int end) throws SystemException {
		return findByStatus(status, start, end, null);
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
	public List<ArticleLinkEntry> findByStatus(boolean status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ArticleLinkEntry> list = (List<ArticleLinkEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ArticleLinkEntry articleLinkEntry : list) {
				if ((status != articleLinkEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ArticleLinkEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public ArticleLinkEntry findByStatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByStatus_First(status,
				orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
	}

	/**
	 * Returns the first article link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article link entry, or <code>null</code> if a matching article link entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry fetchByStatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ArticleLinkEntry> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry findByStatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = fetchByStatus_Last(status,
				orderByComparator);

		if (articleLinkEntry != null) {
			return articleLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleLinkEntryException(msg.toString());
	}

	/**
	 * Returns the last article link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article link entry, or <code>null</code> if a matching article link entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ArticleLinkEntry fetchByStatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		List<ArticleLinkEntry> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ArticleLinkEntry[] findByStatus_PrevAndNext(long entryId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchArticleLinkEntryException, SystemException {
		ArticleLinkEntry articleLinkEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			ArticleLinkEntry[] array = new ArticleLinkEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, articleLinkEntry,
					status, orderByComparator, true);

			array[1] = articleLinkEntry;

			array[2] = getByStatus_PrevAndNext(session, articleLinkEntry,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleLinkEntry getByStatus_PrevAndNext(Session session,
		ArticleLinkEntry articleLinkEntry, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLELINKENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(articleLinkEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ArticleLinkEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the article link entries.
	 *
	 * @return the article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ArticleLinkEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ArticleLinkEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ArticleLinkEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ArticleLinkEntry> list = (List<ArticleLinkEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTICLELINKENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLELINKENTRY.concat(ArticleLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ArticleLinkEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ArticleLinkEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the article link entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (ArticleLinkEntry articleLinkEntry : findByCompany(companyId)) {
			remove(articleLinkEntry);
		}
	}

	/**
	 * Removes all the article link entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyAndStatus(long companyId, boolean status)
		throws SystemException {
		for (ArticleLinkEntry articleLinkEntry : findByCompanyAndStatus(
				companyId, status)) {
			remove(articleLinkEntry);
		}
	}

	/**
	 * Removes all the article link entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(boolean status) throws SystemException {
		for (ArticleLinkEntry articleLinkEntry : findByStatus(status)) {
			remove(articleLinkEntry);
		}
	}

	/**
	 * Removes all the article link entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ArticleLinkEntry articleLinkEntry : findAll()) {
			remove(articleLinkEntry);
		}
	}

	/**
	 * Returns the number of article link entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of article link entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyAndStatus(long companyId, boolean status)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of article link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(boolean status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLELINKENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of article link entries.
	 *
	 * @return the number of article link entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLELINKENTRY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the article link entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portlet.article.link.model.ArticleLinkEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ArticleLinkEntry>> listenersList = new ArrayList<ModelListener<ArticleLinkEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ArticleLinkEntry>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ArticleLinkEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ArticleLinkEntryPersistence.class)
	protected ArticleLinkEntryPersistence articleLinkEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ARTICLELINKENTRY = "SELECT articleLinkEntry FROM ArticleLinkEntry articleLinkEntry";
	private static final String _SQL_SELECT_ARTICLELINKENTRY_WHERE = "SELECT articleLinkEntry FROM ArticleLinkEntry articleLinkEntry WHERE ";
	private static final String _SQL_COUNT_ARTICLELINKENTRY = "SELECT COUNT(articleLinkEntry) FROM ArticleLinkEntry articleLinkEntry";
	private static final String _SQL_COUNT_ARTICLELINKENTRY_WHERE = "SELECT COUNT(articleLinkEntry) FROM ArticleLinkEntry articleLinkEntry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "articleLinkEntry.companyId = ?";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2 = "articleLinkEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2 = "articleLinkEntry.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "articleLinkEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "articleLinkEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ArticleLinkEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ArticleLinkEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArticleLinkEntryPersistenceImpl.class);
	private static ArticleLinkEntry _nullArticleLinkEntry = new ArticleLinkEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ArticleLinkEntry> toCacheModel() {
				return _nullArticleLinkEntryCacheModel;
			}
		};

	private static CacheModel<ArticleLinkEntry> _nullArticleLinkEntryCacheModel = new CacheModel<ArticleLinkEntry>() {
			public ArticleLinkEntry toEntityModel() {
				return _nullArticleLinkEntry;
			}
		};
}