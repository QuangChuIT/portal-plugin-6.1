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

package com.bkav.portal.portlet.dynamic_menu.model.impl;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItemModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DynamicMenuItem service. Represents a row in the &quot;DynamicMenuItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DynamicMenuItemImpl}.
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuItemImpl
 * @see com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem
 * @see com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItemModel
 * @generated
 */
public class DynamicMenuItemModelImpl extends BaseModelImpl<DynamicMenuItem>
	implements DynamicMenuItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dynamic menu item model instance should use the {@link com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem} interface instead.
	 */
	public static final String TABLE_NAME = "DynamicMenuItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "menuId", Types.BIGINT },
			{ "parentId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "url", Types.VARCHAR },
			{ "urlType", Types.VARCHAR },
			{ "position", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table DynamicMenuItem (itemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,menuId LONG,parentId LONG,name VARCHAR(75) null,url VARCHAR(75) null,urlType VARCHAR(75) null,position INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table DynamicMenuItem";
	public static final String ORDER_BY_JPQL = " ORDER BY dynamicMenuItem.parentId ASC, dynamicMenuItem.position ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DynamicMenuItem.parentId ASC, DynamicMenuItem.position ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long MENUID_COLUMN_BITMASK = 2L;
	public static long PARENTID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"));

	public DynamicMenuItemModelImpl() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DynamicMenuItem.class;
	}

	public String getModelClassName() {
		return DynamicMenuItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("menuId", getMenuId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("urlType", getUrlType());
		attributes.put("position", getPosition());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
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

		Long menuId = (Long)attributes.get("menuId");

		if (menuId != null) {
			setMenuId(menuId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String urlType = (String)attributes.get("urlType");

		if (urlType != null) {
			setUrlType(urlType);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

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

	public long getMenuId() {
		return _menuId;
	}

	public void setMenuId(long menuId) {
		_columnBitmask |= MENUID_COLUMN_BITMASK;

		if (!_setOriginalMenuId) {
			_setOriginalMenuId = true;

			_originalMenuId = _menuId;
		}

		_menuId = menuId;
	}

	public long getOriginalMenuId() {
		return _originalMenuId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_columnBitmask = -1L;

		if (!_setOriginalParentId) {
			_setOriginalParentId = true;

			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public long getOriginalParentId() {
		return _originalParentId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getUrlType() {
		if (_urlType == null) {
			return StringPool.BLANK;
		}
		else {
			return _urlType;
		}
	}

	public void setUrlType(String urlType) {
		_urlType = urlType;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_columnBitmask = -1L;

		_position = position;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DynamicMenuItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DynamicMenuItem toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DynamicMenuItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		DynamicMenuItemImpl dynamicMenuItemImpl = new DynamicMenuItemImpl();

		dynamicMenuItemImpl.setItemId(getItemId());
		dynamicMenuItemImpl.setGroupId(getGroupId());
		dynamicMenuItemImpl.setCompanyId(getCompanyId());
		dynamicMenuItemImpl.setUserId(getUserId());
		dynamicMenuItemImpl.setUserName(getUserName());
		dynamicMenuItemImpl.setCreateDate(getCreateDate());
		dynamicMenuItemImpl.setModifiedDate(getModifiedDate());
		dynamicMenuItemImpl.setMenuId(getMenuId());
		dynamicMenuItemImpl.setParentId(getParentId());
		dynamicMenuItemImpl.setName(getName());
		dynamicMenuItemImpl.setUrl(getUrl());
		dynamicMenuItemImpl.setUrlType(getUrlType());
		dynamicMenuItemImpl.setPosition(getPosition());

		dynamicMenuItemImpl.resetOriginalValues();

		return dynamicMenuItemImpl;
	}

	public int compareTo(DynamicMenuItem dynamicMenuItem) {
		int value = 0;

		if (getParentId() < dynamicMenuItem.getParentId()) {
			value = -1;
		}
		else if (getParentId() > dynamicMenuItem.getParentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getPosition() < dynamicMenuItem.getPosition()) {
			value = -1;
		}
		else if (getPosition() > dynamicMenuItem.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		DynamicMenuItem dynamicMenuItem = null;

		try {
			dynamicMenuItem = (DynamicMenuItem)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dynamicMenuItem.getPrimaryKey();

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
		DynamicMenuItemModelImpl dynamicMenuItemModelImpl = this;

		dynamicMenuItemModelImpl._originalGroupId = dynamicMenuItemModelImpl._groupId;

		dynamicMenuItemModelImpl._setOriginalGroupId = false;

		dynamicMenuItemModelImpl._originalMenuId = dynamicMenuItemModelImpl._menuId;

		dynamicMenuItemModelImpl._setOriginalMenuId = false;

		dynamicMenuItemModelImpl._originalParentId = dynamicMenuItemModelImpl._parentId;

		dynamicMenuItemModelImpl._setOriginalParentId = false;

		dynamicMenuItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DynamicMenuItem> toCacheModel() {
		DynamicMenuItemCacheModel dynamicMenuItemCacheModel = new DynamicMenuItemCacheModel();

		dynamicMenuItemCacheModel.itemId = getItemId();

		dynamicMenuItemCacheModel.groupId = getGroupId();

		dynamicMenuItemCacheModel.companyId = getCompanyId();

		dynamicMenuItemCacheModel.userId = getUserId();

		dynamicMenuItemCacheModel.userName = getUserName();

		String userName = dynamicMenuItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dynamicMenuItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dynamicMenuItemCacheModel.createDate = createDate.getTime();
		}
		else {
			dynamicMenuItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dynamicMenuItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dynamicMenuItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dynamicMenuItemCacheModel.menuId = getMenuId();

		dynamicMenuItemCacheModel.parentId = getParentId();

		dynamicMenuItemCacheModel.name = getName();

		String name = dynamicMenuItemCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dynamicMenuItemCacheModel.name = null;
		}

		dynamicMenuItemCacheModel.url = getUrl();

		String url = dynamicMenuItemCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			dynamicMenuItemCacheModel.url = null;
		}

		dynamicMenuItemCacheModel.urlType = getUrlType();

		String urlType = dynamicMenuItemCacheModel.urlType;

		if ((urlType != null) && (urlType.length() == 0)) {
			dynamicMenuItemCacheModel.urlType = null;
		}

		dynamicMenuItemCacheModel.position = getPosition();

		return dynamicMenuItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{itemId=");
		sb.append(getItemId());
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
		sb.append(", menuId=");
		sb.append(getMenuId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", urlType=");
		sb.append(getUrlType());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
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
			"<column><column-name>menuId</column-name><column-value><![CDATA[");
		sb.append(getMenuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlType</column-name><column-value><![CDATA[");
		sb.append(getUrlType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DynamicMenuItem.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DynamicMenuItem.class
		};
	private long _itemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _menuId;
	private long _originalMenuId;
	private boolean _setOriginalMenuId;
	private long _parentId;
	private long _originalParentId;
	private boolean _setOriginalParentId;
	private String _name;
	private String _url;
	private String _urlType;
	private int _position;
	private long _columnBitmask;
	private DynamicMenuItem _escapedModelProxy;
}