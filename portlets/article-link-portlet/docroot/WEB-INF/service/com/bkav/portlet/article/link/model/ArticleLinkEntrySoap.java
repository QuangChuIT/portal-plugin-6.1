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

package com.bkav.portlet.article.link.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portlet.article.link.service.http.ArticleLinkEntryServiceSoap}.
 *
 * @author    quangcv
 * @see       com.bkav.portlet.article.link.service.http.ArticleLinkEntryServiceSoap
 * @generated
 */
public class ArticleLinkEntrySoap implements Serializable {
	public static ArticleLinkEntrySoap toSoapModel(ArticleLinkEntry model) {
		ArticleLinkEntrySoap soapModel = new ArticleLinkEntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setLink(model.getLink());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setUrlTitle(model.getUrlTitle());

		return soapModel;
	}

	public static ArticleLinkEntrySoap[] toSoapModels(ArticleLinkEntry[] models) {
		ArticleLinkEntrySoap[] soapModels = new ArticleLinkEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleLinkEntrySoap[][] toSoapModels(
		ArticleLinkEntry[][] models) {
		ArticleLinkEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleLinkEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleLinkEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleLinkEntrySoap[] toSoapModels(
		List<ArticleLinkEntry> models) {
		List<ArticleLinkEntrySoap> soapModels = new ArrayList<ArticleLinkEntrySoap>(models.size());

		for (ArticleLinkEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleLinkEntrySoap[soapModels.size()]);
	}

	public ArticleLinkEntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	private long _entryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private String _title;
	private String _link;
	private String _description;
	private boolean _status;
	private String _urlTitle;
}