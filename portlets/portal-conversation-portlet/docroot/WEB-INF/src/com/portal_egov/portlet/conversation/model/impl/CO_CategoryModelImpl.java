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

package com.portal_egov.portlet.conversation.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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

import com.portal_egov.portlet.conversation.model.CO_Category;
import com.portal_egov.portlet.conversation.model.CO_CategoryModel;
import com.portal_egov.portlet.conversation.model.CO_CategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CO_Category service. Represents a row in the &quot;CO_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.conversation.model.CO_CategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CO_CategoryImpl}.
 * </p>
 *
 * @author DucDVd
 * @see CO_CategoryImpl
 * @see com.portal_egov.portlet.conversation.model.CO_Category
 * @see com.portal_egov.portlet.conversation.model.CO_CategoryModel
 * @generated
 */
@JSON(strict = true)
public class CO_CategoryModelImpl extends BaseModelImpl<CO_Category>
	implements CO_CategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c o_ category model instance should use the {@link com.portal_egov.portlet.conversation.model.CO_Category} interface instead.
	 */
	public static final String TABLE_NAME = "CO_Category";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "parentCategoryId", Types.BIGINT },
			{ "categoryName", Types.VARCHAR },
			{ "categoryDesc", Types.VARCHAR },
			{ "threadCount", Types.INTEGER },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table CO_Category (categoryId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,parentCategoryId LONG,categoryName VARCHAR(75) null,categoryDesc VARCHAR(75) null,threadCount INTEGER,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CO_Category";
	public static final String ORDER_BY_JPQL = " ORDER BY co_Category.categoryName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CO_Category.categoryName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Category"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Category"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.conversation.model.CO_Category"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PARENTCATEGORYID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CO_Category toModel(CO_CategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CO_Category model = new CO_CategoryImpl();

		model.setCategoryId(soapModel.getCategoryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setParentCategoryId(soapModel.getParentCategoryId());
		model.setCategoryName(soapModel.getCategoryName());
		model.setCategoryDesc(soapModel.getCategoryDesc());
		model.setThreadCount(soapModel.getThreadCount());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CO_Category> toModels(CO_CategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CO_Category> models = new ArrayList<CO_Category>(soapModels.length);

		for (CO_CategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.conversation.model.CO_Category"));

	public CO_CategoryModelImpl() {
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
		return CO_Category.class;
	}

	public String getModelClassName() {
		return CO_Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("parentCategoryId", getParentCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("threadCount", getThreadCount());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Integer threadCount = (Integer)attributes.get("threadCount");

		if (threadCount != null) {
			setThreadCount(threadCount);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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
	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		_columnBitmask |= PARENTCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalParentCategoryId) {
			_setOriginalParentCategoryId = true;

			_originalParentCategoryId = _parentCategoryId;
		}

		_parentCategoryId = parentCategoryId;
	}

	public long getOriginalParentCategoryId() {
		return _originalParentCategoryId;
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
		_columnBitmask = -1L;

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
	public int getThreadCount() {
		return _threadCount;
	}

	public void setThreadCount(int threadCount) {
		_threadCount = threadCount;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CO_Category.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CO_Category toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CO_Category)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CO_CategoryImpl co_CategoryImpl = new CO_CategoryImpl();

		co_CategoryImpl.setCategoryId(getCategoryId());
		co_CategoryImpl.setCompanyId(getCompanyId());
		co_CategoryImpl.setGroupId(getGroupId());
		co_CategoryImpl.setUserId(getUserId());
		co_CategoryImpl.setParentCategoryId(getParentCategoryId());
		co_CategoryImpl.setCategoryName(getCategoryName());
		co_CategoryImpl.setCategoryDesc(getCategoryDesc());
		co_CategoryImpl.setThreadCount(getThreadCount());
		co_CategoryImpl.setCreateDate(getCreateDate());
		co_CategoryImpl.setModifiedDate(getModifiedDate());

		co_CategoryImpl.resetOriginalValues();

		return co_CategoryImpl;
	}

	public int compareTo(CO_Category co_Category) {
		int value = 0;

		value = getCategoryName().compareTo(co_Category.getCategoryName());

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

		CO_Category co_Category = null;

		try {
			co_Category = (CO_Category)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = co_Category.getPrimaryKey();

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
		CO_CategoryModelImpl co_CategoryModelImpl = this;

		co_CategoryModelImpl._originalCompanyId = co_CategoryModelImpl._companyId;

		co_CategoryModelImpl._setOriginalCompanyId = false;

		co_CategoryModelImpl._originalGroupId = co_CategoryModelImpl._groupId;

		co_CategoryModelImpl._setOriginalGroupId = false;

		co_CategoryModelImpl._originalParentCategoryId = co_CategoryModelImpl._parentCategoryId;

		co_CategoryModelImpl._setOriginalParentCategoryId = false;

		co_CategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CO_Category> toCacheModel() {
		CO_CategoryCacheModel co_CategoryCacheModel = new CO_CategoryCacheModel();

		co_CategoryCacheModel.categoryId = getCategoryId();

		co_CategoryCacheModel.companyId = getCompanyId();

		co_CategoryCacheModel.groupId = getGroupId();

		co_CategoryCacheModel.userId = getUserId();

		co_CategoryCacheModel.parentCategoryId = getParentCategoryId();

		co_CategoryCacheModel.categoryName = getCategoryName();

		String categoryName = co_CategoryCacheModel.categoryName;

		if ((categoryName != null) && (categoryName.length() == 0)) {
			co_CategoryCacheModel.categoryName = null;
		}

		co_CategoryCacheModel.categoryDesc = getCategoryDesc();

		String categoryDesc = co_CategoryCacheModel.categoryDesc;

		if ((categoryDesc != null) && (categoryDesc.length() == 0)) {
			co_CategoryCacheModel.categoryDesc = null;
		}

		co_CategoryCacheModel.threadCount = getThreadCount();

		Date createDate = getCreateDate();

		if (createDate != null) {
			co_CategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			co_CategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			co_CategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			co_CategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return co_CategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", parentCategoryId=");
		sb.append(getParentCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", categoryDesc=");
		sb.append(getCategoryDesc());
		sb.append(", threadCount=");
		sb.append(getThreadCount());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.conversation.model.CO_Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCategoryId</column-name><column-value><![CDATA[");
		sb.append(getParentCategoryId());
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
			"<column><column-name>threadCount</column-name><column-value><![CDATA[");
		sb.append(getThreadCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CO_Category.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CO_Category.class
		};
	private long _categoryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _parentCategoryId;
	private long _originalParentCategoryId;
	private boolean _setOriginalParentCategoryId;
	private String _categoryName;
	private String _categoryDesc;
	private int _threadCount;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private CO_Category _escapedModelProxy;
}