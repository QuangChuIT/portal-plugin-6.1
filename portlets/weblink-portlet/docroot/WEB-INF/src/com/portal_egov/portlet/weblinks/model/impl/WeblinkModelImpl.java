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

package com.portal_egov.portlet.weblinks.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.model.WeblinkModel;
import com.portal_egov.portlet.weblinks.model.WeblinkSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Weblink service. Represents a row in the &quot;Weblink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.weblinks.model.WeblinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WeblinkImpl}.
 * </p>
 *
 * @author HungDX
 * @see WeblinkImpl
 * @see com.portal_egov.portlet.weblinks.model.Weblink
 * @see com.portal_egov.portlet.weblinks.model.WeblinkModel
 * @generated
 */
@JSON(strict = true)
public class WeblinkModelImpl extends BaseModelImpl<Weblink>
	implements WeblinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a weblink model instance should use the {@link com.portal_egov.portlet.weblinks.model.Weblink} interface instead.
	 */
	public static final String TABLE_NAME = "Weblink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "weblinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "weblinkCategoryId", Types.BIGINT },
			{ "weblinkName", Types.VARCHAR },
			{ "weblinkDesc", Types.VARCHAR },
			{ "weblinkURL", Types.VARCHAR },
			{ "weblinkIconId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Weblink (weblinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,weblinkCategoryId LONG,weblinkName VARCHAR(300) null,weblinkDesc VARCHAR(450) null,weblinkURL VARCHAR(300) null,weblinkIconId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Weblink";
	public static final String ORDER_BY_JPQL = " ORDER BY weblink.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Weblink.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.weblinks.model.Weblink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.weblinks.model.Weblink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.weblinks.model.Weblink"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long WEBLINKCATEGORYID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Weblink toModel(WeblinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Weblink model = new WeblinkImpl();

		model.setWeblinkId(soapModel.getWeblinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setWeblinkCategoryId(soapModel.getWeblinkCategoryId());
		model.setWeblinkName(soapModel.getWeblinkName());
		model.setWeblinkDesc(soapModel.getWeblinkDesc());
		model.setWeblinkURL(soapModel.getWeblinkURL());
		model.setWeblinkIconId(soapModel.getWeblinkIconId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Weblink> toModels(WeblinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Weblink> models = new ArrayList<Weblink>(soapModels.length);

		for (WeblinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.weblinks.model.Weblink"));

	public WeblinkModelImpl() {
	}

	public long getPrimaryKey() {
		return _weblinkId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWeblinkId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_weblinkId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Weblink.class;
	}

	public String getModelClassName() {
		return Weblink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("weblinkId", getWeblinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("weblinkCategoryId", getWeblinkCategoryId());
		attributes.put("weblinkName", getWeblinkName());
		attributes.put("weblinkDesc", getWeblinkDesc());
		attributes.put("weblinkURL", getWeblinkURL());
		attributes.put("weblinkIconId", getWeblinkIconId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long weblinkId = (Long)attributes.get("weblinkId");

		if (weblinkId != null) {
			setWeblinkId(weblinkId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long weblinkCategoryId = (Long)attributes.get("weblinkCategoryId");

		if (weblinkCategoryId != null) {
			setWeblinkCategoryId(weblinkCategoryId);
		}

		String weblinkName = (String)attributes.get("weblinkName");

		if (weblinkName != null) {
			setWeblinkName(weblinkName);
		}

		String weblinkDesc = (String)attributes.get("weblinkDesc");

		if (weblinkDesc != null) {
			setWeblinkDesc(weblinkDesc);
		}

		String weblinkURL = (String)attributes.get("weblinkURL");

		if (weblinkURL != null) {
			setWeblinkURL(weblinkURL);
		}

		Long weblinkIconId = (Long)attributes.get("weblinkIconId");

		if (weblinkIconId != null) {
			setWeblinkIconId(weblinkIconId);
		}
	}

	@JSON
	public long getWeblinkId() {
		return _weblinkId;
	}

	public void setWeblinkId(long weblinkId) {
		_weblinkId = weblinkId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getWeblinkCategoryId() {
		return _weblinkCategoryId;
	}

	public void setWeblinkCategoryId(long weblinkCategoryId) {
		_columnBitmask |= WEBLINKCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalWeblinkCategoryId) {
			_setOriginalWeblinkCategoryId = true;

			_originalWeblinkCategoryId = _weblinkCategoryId;
		}

		_weblinkCategoryId = weblinkCategoryId;
	}

	public long getOriginalWeblinkCategoryId() {
		return _originalWeblinkCategoryId;
	}

	@JSON
	public String getWeblinkName() {
		if (_weblinkName == null) {
			return StringPool.BLANK;
		}
		else {
			return _weblinkName;
		}
	}

	public void setWeblinkName(String weblinkName) {
		_weblinkName = weblinkName;
	}

	@JSON
	public String getWeblinkDesc() {
		if (_weblinkDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _weblinkDesc;
		}
	}

	public void setWeblinkDesc(String weblinkDesc) {
		_weblinkDesc = weblinkDesc;
	}

	@JSON
	public String getWeblinkURL() {
		if (_weblinkURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _weblinkURL;
		}
	}

	public void setWeblinkURL(String weblinkURL) {
		_weblinkURL = weblinkURL;
	}

	@JSON
	public long getWeblinkIconId() {
		return _weblinkIconId;
	}

	public void setWeblinkIconId(long weblinkIconId) {
		_weblinkIconId = weblinkIconId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Weblink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Weblink toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Weblink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		WeblinkImpl weblinkImpl = new WeblinkImpl();

		weblinkImpl.setWeblinkId(getWeblinkId());
		weblinkImpl.setGroupId(getGroupId());
		weblinkImpl.setCompanyId(getCompanyId());
		weblinkImpl.setUserId(getUserId());
		weblinkImpl.setUserName(getUserName());
		weblinkImpl.setCreateDate(getCreateDate());
		weblinkImpl.setModifiedDate(getModifiedDate());
		weblinkImpl.setWeblinkCategoryId(getWeblinkCategoryId());
		weblinkImpl.setWeblinkName(getWeblinkName());
		weblinkImpl.setWeblinkDesc(getWeblinkDesc());
		weblinkImpl.setWeblinkURL(getWeblinkURL());
		weblinkImpl.setWeblinkIconId(getWeblinkIconId());

		weblinkImpl.resetOriginalValues();

		return weblinkImpl;
	}

	public int compareTo(Weblink weblink) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), weblink.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Weblink weblink = null;

		try {
			weblink = (Weblink)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = weblink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		WeblinkModelImpl weblinkModelImpl = this;

		weblinkModelImpl._originalGroupId = weblinkModelImpl._groupId;

		weblinkModelImpl._setOriginalGroupId = false;

		weblinkModelImpl._originalCompanyId = weblinkModelImpl._companyId;

		weblinkModelImpl._setOriginalCompanyId = false;

		weblinkModelImpl._originalWeblinkCategoryId = weblinkModelImpl._weblinkCategoryId;

		weblinkModelImpl._setOriginalWeblinkCategoryId = false;

		weblinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Weblink> toCacheModel() {
		WeblinkCacheModel weblinkCacheModel = new WeblinkCacheModel();

		weblinkCacheModel.weblinkId = getWeblinkId();

		weblinkCacheModel.groupId = getGroupId();

		weblinkCacheModel.companyId = getCompanyId();

		weblinkCacheModel.userId = getUserId();

		weblinkCacheModel.userName = getUserName();

		String userName = weblinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			weblinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			weblinkCacheModel.createDate = createDate.getTime();
		}
		else {
			weblinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			weblinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			weblinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		weblinkCacheModel.weblinkCategoryId = getWeblinkCategoryId();

		weblinkCacheModel.weblinkName = getWeblinkName();

		String weblinkName = weblinkCacheModel.weblinkName;

		if ((weblinkName != null) && (weblinkName.length() == 0)) {
			weblinkCacheModel.weblinkName = null;
		}

		weblinkCacheModel.weblinkDesc = getWeblinkDesc();

		String weblinkDesc = weblinkCacheModel.weblinkDesc;

		if ((weblinkDesc != null) && (weblinkDesc.length() == 0)) {
			weblinkCacheModel.weblinkDesc = null;
		}

		weblinkCacheModel.weblinkURL = getWeblinkURL();

		String weblinkURL = weblinkCacheModel.weblinkURL;

		if ((weblinkURL != null) && (weblinkURL.length() == 0)) {
			weblinkCacheModel.weblinkURL = null;
		}

		weblinkCacheModel.weblinkIconId = getWeblinkIconId();

		return weblinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{weblinkId=");
		sb.append(getWeblinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", weblinkCategoryId=");
		sb.append(getWeblinkCategoryId());
		sb.append(", weblinkName=");
		sb.append(getWeblinkName());
		sb.append(", weblinkDesc=");
		sb.append(getWeblinkDesc());
		sb.append(", weblinkURL=");
		sb.append(getWeblinkURL());
		sb.append(", weblinkIconId=");
		sb.append(getWeblinkIconId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.weblinks.model.Weblink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>weblinkId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkCategoryId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkName</column-name><column-value><![CDATA[");
		sb.append(getWeblinkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkDesc</column-name><column-value><![CDATA[");
		sb.append(getWeblinkDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkURL</column-name><column-value><![CDATA[");
		sb.append(getWeblinkURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkIconId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkIconId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Weblink.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Weblink.class
		};
	private long _weblinkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _weblinkCategoryId;
	private long _originalWeblinkCategoryId;
	private boolean _setOriginalWeblinkCategoryId;
	private String _weblinkName;
	private String _weblinkDesc;
	private String _weblinkURL;
	private long _weblinkIconId;
	private long _columnBitmask;
	private Weblink _escapedModelProxy;
}