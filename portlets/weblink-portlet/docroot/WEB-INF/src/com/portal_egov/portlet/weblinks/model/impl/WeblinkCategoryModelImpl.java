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

import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.model.WeblinkCategoryModel;
import com.portal_egov.portlet.weblinks.model.WeblinkCategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WeblinkCategory service. Represents a row in the &quot;WeblinkCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.weblinks.model.WeblinkCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WeblinkCategoryImpl}.
 * </p>
 *
 * @author HungDX
 * @see WeblinkCategoryImpl
 * @see com.portal_egov.portlet.weblinks.model.WeblinkCategory
 * @see com.portal_egov.portlet.weblinks.model.WeblinkCategoryModel
 * @generated
 */
@JSON(strict = true)
public class WeblinkCategoryModelImpl extends BaseModelImpl<WeblinkCategory>
	implements WeblinkCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a weblink category model instance should use the {@link com.portal_egov.portlet.weblinks.model.WeblinkCategory} interface instead.
	 */
	public static final String TABLE_NAME = "WeblinkCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "categoryName", Types.VARCHAR },
			{ "categoryDesc", Types.VARCHAR },
			{ "categoryIconId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table WeblinkCategory (categoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryName VARCHAR(300) null,categoryDesc VARCHAR(450) null,categoryIconId LONG)";
	public static final String TABLE_SQL_DROP = "drop table WeblinkCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY weblinkCategory.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WeblinkCategory.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.weblinks.model.WeblinkCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.weblinks.model.WeblinkCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.weblinks.model.WeblinkCategory"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WeblinkCategory toModel(WeblinkCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WeblinkCategory model = new WeblinkCategoryImpl();

		model.setCategoryId(soapModel.getCategoryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryName(soapModel.getCategoryName());
		model.setCategoryDesc(soapModel.getCategoryDesc());
		model.setCategoryIconId(soapModel.getCategoryIconId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WeblinkCategory> toModels(
		WeblinkCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WeblinkCategory> models = new ArrayList<WeblinkCategory>(soapModels.length);

		for (WeblinkCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.weblinks.model.WeblinkCategory"));

	public WeblinkCategoryModelImpl() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return WeblinkCategory.class;
	}

	public String getModelClassName() {
		return WeblinkCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("categoryIconId", getCategoryIconId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Long categoryIconId = (Long)attributes.get("categoryIconId");

		if (categoryIconId != null) {
			setCategoryIconId(categoryIconId);
		}
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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
	public String getCategoryName() {
		if (_categoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoryName;
		}
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	@JSON
	public String getCategoryDesc() {
		if (_categoryDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoryDesc;
		}
	}

	public void setCategoryDesc(String categoryDesc) {
		_categoryDesc = categoryDesc;
	}

	@JSON
	public long getCategoryIconId() {
		return _categoryIconId;
	}

	public void setCategoryIconId(long categoryIconId) {
		_categoryIconId = categoryIconId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			WeblinkCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WeblinkCategory toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (WeblinkCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		WeblinkCategoryImpl weblinkCategoryImpl = new WeblinkCategoryImpl();

		weblinkCategoryImpl.setCategoryId(getCategoryId());
		weblinkCategoryImpl.setGroupId(getGroupId());
		weblinkCategoryImpl.setCompanyId(getCompanyId());
		weblinkCategoryImpl.setUserId(getUserId());
		weblinkCategoryImpl.setUserName(getUserName());
		weblinkCategoryImpl.setCreateDate(getCreateDate());
		weblinkCategoryImpl.setModifiedDate(getModifiedDate());
		weblinkCategoryImpl.setCategoryName(getCategoryName());
		weblinkCategoryImpl.setCategoryDesc(getCategoryDesc());
		weblinkCategoryImpl.setCategoryIconId(getCategoryIconId());

		weblinkCategoryImpl.resetOriginalValues();

		return weblinkCategoryImpl;
	}

	public int compareTo(WeblinkCategory weblinkCategory) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				weblinkCategory.getCreateDate());

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

		WeblinkCategory weblinkCategory = null;

		try {
			weblinkCategory = (WeblinkCategory)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = weblinkCategory.getPrimaryKey();

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
		WeblinkCategoryModelImpl weblinkCategoryModelImpl = this;

		weblinkCategoryModelImpl._originalGroupId = weblinkCategoryModelImpl._groupId;

		weblinkCategoryModelImpl._setOriginalGroupId = false;

		weblinkCategoryModelImpl._originalCompanyId = weblinkCategoryModelImpl._companyId;

		weblinkCategoryModelImpl._setOriginalCompanyId = false;

		weblinkCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WeblinkCategory> toCacheModel() {
		WeblinkCategoryCacheModel weblinkCategoryCacheModel = new WeblinkCategoryCacheModel();

		weblinkCategoryCacheModel.categoryId = getCategoryId();

		weblinkCategoryCacheModel.groupId = getGroupId();

		weblinkCategoryCacheModel.companyId = getCompanyId();

		weblinkCategoryCacheModel.userId = getUserId();

		weblinkCategoryCacheModel.userName = getUserName();

		String userName = weblinkCategoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			weblinkCategoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			weblinkCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			weblinkCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			weblinkCategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			weblinkCategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		weblinkCategoryCacheModel.categoryName = getCategoryName();

		String categoryName = weblinkCategoryCacheModel.categoryName;

		if ((categoryName != null) && (categoryName.length() == 0)) {
			weblinkCategoryCacheModel.categoryName = null;
		}

		weblinkCategoryCacheModel.categoryDesc = getCategoryDesc();

		String categoryDesc = weblinkCategoryCacheModel.categoryDesc;

		if ((categoryDesc != null) && (categoryDesc.length() == 0)) {
			weblinkCategoryCacheModel.categoryDesc = null;
		}

		weblinkCategoryCacheModel.categoryIconId = getCategoryIconId();

		return weblinkCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
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
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", categoryDesc=");
		sb.append(getCategoryDesc());
		sb.append(", categoryIconId=");
		sb.append(getCategoryIconId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.weblinks.model.WeblinkCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
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
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryDesc</column-name><column-value><![CDATA[");
		sb.append(getCategoryDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryIconId</column-name><column-value><![CDATA[");
		sb.append(getCategoryIconId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WeblinkCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			WeblinkCategory.class
		};
	private long _categoryId;
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
	private String _categoryName;
	private String _categoryDesc;
	private long _categoryIconId;
	private long _columnBitmask;
	private WeblinkCategory _escapedModelProxy;
}