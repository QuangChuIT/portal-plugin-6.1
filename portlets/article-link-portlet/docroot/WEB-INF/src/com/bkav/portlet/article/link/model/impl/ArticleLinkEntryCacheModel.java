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

package com.bkav.portlet.article.link.model.impl;

import com.bkav.portlet.article.link.model.ArticleLinkEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ArticleLinkEntry in entity cache.
 *
 * @author quangcv
 * @see ArticleLinkEntry
 * @generated
 */
public class ArticleLinkEntryCacheModel implements CacheModel<ArticleLinkEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", link=");
		sb.append(link);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append("}");

		return sb.toString();
	}

	public ArticleLinkEntry toEntityModel() {
		ArticleLinkEntryImpl articleLinkEntryImpl = new ArticleLinkEntryImpl();

		articleLinkEntryImpl.setEntryId(entryId);
		articleLinkEntryImpl.setCompanyId(companyId);
		articleLinkEntryImpl.setUserId(userId);

		if (userName == null) {
			articleLinkEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			articleLinkEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			articleLinkEntryImpl.setCreateDate(null);
		}
		else {
			articleLinkEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			articleLinkEntryImpl.setModifiedDate(null);
		}
		else {
			articleLinkEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publishDate == Long.MIN_VALUE) {
			articleLinkEntryImpl.setPublishDate(null);
		}
		else {
			articleLinkEntryImpl.setPublishDate(new Date(publishDate));
		}

		if (title == null) {
			articleLinkEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			articleLinkEntryImpl.setTitle(title);
		}

		if (link == null) {
			articleLinkEntryImpl.setLink(StringPool.BLANK);
		}
		else {
			articleLinkEntryImpl.setLink(link);
		}

		if (description == null) {
			articleLinkEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			articleLinkEntryImpl.setDescription(description);
		}

		articleLinkEntryImpl.setStatus(status);

		if (urlTitle == null) {
			articleLinkEntryImpl.setUrlTitle(StringPool.BLANK);
		}
		else {
			articleLinkEntryImpl.setUrlTitle(urlTitle);
		}

		articleLinkEntryImpl.resetOriginalValues();

		return articleLinkEntryImpl;
	}

	public long entryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long publishDate;
	public String title;
	public String link;
	public String description;
	public boolean status;
	public String urlTitle;
}