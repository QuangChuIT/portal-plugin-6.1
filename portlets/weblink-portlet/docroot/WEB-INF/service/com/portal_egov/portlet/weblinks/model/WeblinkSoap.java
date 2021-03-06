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

package com.portal_egov.portlet.weblinks.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.weblinks.service.http.WeblinkServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.weblinks.service.http.WeblinkServiceSoap
 * @generated
 */
public class WeblinkSoap implements Serializable {
	public static WeblinkSoap toSoapModel(Weblink model) {
		WeblinkSoap soapModel = new WeblinkSoap();

		soapModel.setWeblinkId(model.getWeblinkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setWeblinkCategoryId(model.getWeblinkCategoryId());
		soapModel.setWeblinkName(model.getWeblinkName());
		soapModel.setWeblinkDesc(model.getWeblinkDesc());
		soapModel.setWeblinkURL(model.getWeblinkURL());
		soapModel.setWeblinkIconId(model.getWeblinkIconId());

		return soapModel;
	}

	public static WeblinkSoap[] toSoapModels(Weblink[] models) {
		WeblinkSoap[] soapModels = new WeblinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WeblinkSoap[][] toSoapModels(Weblink[][] models) {
		WeblinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WeblinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WeblinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WeblinkSoap[] toSoapModels(List<Weblink> models) {
		List<WeblinkSoap> soapModels = new ArrayList<WeblinkSoap>(models.size());

		for (Weblink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WeblinkSoap[soapModels.size()]);
	}

	public WeblinkSoap() {
	}

	public long getPrimaryKey() {
		return _weblinkId;
	}

	public void setPrimaryKey(long pk) {
		setWeblinkId(pk);
	}

	public long getWeblinkId() {
		return _weblinkId;
	}

	public void setWeblinkId(long weblinkId) {
		_weblinkId = weblinkId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getWeblinkCategoryId() {
		return _weblinkCategoryId;
	}

	public void setWeblinkCategoryId(long weblinkCategoryId) {
		_weblinkCategoryId = weblinkCategoryId;
	}

	public String getWeblinkName() {
		return _weblinkName;
	}

	public void setWeblinkName(String weblinkName) {
		_weblinkName = weblinkName;
	}

	public String getWeblinkDesc() {
		return _weblinkDesc;
	}

	public void setWeblinkDesc(String weblinkDesc) {
		_weblinkDesc = weblinkDesc;
	}

	public String getWeblinkURL() {
		return _weblinkURL;
	}

	public void setWeblinkURL(String weblinkURL) {
		_weblinkURL = weblinkURL;
	}

	public long getWeblinkIconId() {
		return _weblinkIconId;
	}

	public void setWeblinkIconId(long weblinkIconId) {
		_weblinkIconId = weblinkIconId;
	}

	private long _weblinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _weblinkCategoryId;
	private String _weblinkName;
	private String _weblinkDesc;
	private String _weblinkURL;
	private long _weblinkIconId;
}