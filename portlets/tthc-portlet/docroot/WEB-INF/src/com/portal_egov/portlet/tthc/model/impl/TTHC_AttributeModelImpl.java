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

package com.portal_egov.portlet.tthc.model.impl;

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

import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.model.TTHC_AttributeModel;
import com.portal_egov.portlet.tthc.model.TTHC_AttributeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TTHC_Attribute service. Represents a row in the &quot;tthc_attribute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.tthc.model.TTHC_AttributeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TTHC_AttributeImpl}.
 * </p>
 *
 * @author HungDX
 * @see TTHC_AttributeImpl
 * @see com.portal_egov.portlet.tthc.model.TTHC_Attribute
 * @see com.portal_egov.portlet.tthc.model.TTHC_AttributeModel
 * @generated
 */
@JSON(strict = true)
public class TTHC_AttributeModelImpl extends BaseModelImpl<TTHC_Attribute>
	implements TTHC_AttributeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a t t h c_ attribute model instance should use the {@link com.portal_egov.portlet.tthc.model.TTHC_Attribute} interface instead.
	 */
	public static final String TABLE_NAME = "tthc_attribute";
	public static final Object[][] TABLE_COLUMNS = {
			{ "attributeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "tthcEntryId", Types.BIGINT },
			{ "attributeTypeId", Types.INTEGER },
			{ "attributeIndex", Types.INTEGER },
			{ "attributeName", Types.VARCHAR },
			{ "attributeValue", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table tthc_attribute (attributeId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,tthcEntryId LONG,attributeTypeId INTEGER,attributeIndex INTEGER,attributeName VARCHAR(300) null,attributeValue VARCHAR(3000) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table tthc_attribute";
	public static final String ORDER_BY_JPQL = " ORDER BY tthc_Attribute.attributeIndex ASC";
	public static final String ORDER_BY_SQL = " ORDER BY tthc_attribute.attributeIndex ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.tthc.model.TTHC_Attribute"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.tthc.model.TTHC_Attribute"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.tthc.model.TTHC_Attribute"),
			true);
	public static long ATTRIBUTETYPEID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long TTHCENTRYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TTHC_Attribute toModel(TTHC_AttributeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TTHC_Attribute model = new TTHC_AttributeImpl();

		model.setAttributeId(soapModel.getAttributeId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setTthcEntryId(soapModel.getTthcEntryId());
		model.setAttributeTypeId(soapModel.getAttributeTypeId());
		model.setAttributeIndex(soapModel.getAttributeIndex());
		model.setAttributeName(soapModel.getAttributeName());
		model.setAttributeValue(soapModel.getAttributeValue());
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
	public static List<TTHC_Attribute> toModels(TTHC_AttributeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TTHC_Attribute> models = new ArrayList<TTHC_Attribute>(soapModels.length);

		for (TTHC_AttributeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.tthc.model.TTHC_Attribute"));

	public TTHC_AttributeModelImpl() {
	}

	public long getPrimaryKey() {
		return _attributeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAttributeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_attributeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return TTHC_Attribute.class;
	}

	public String getModelClassName() {
		return TTHC_Attribute.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attributeId", getAttributeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("tthcEntryId", getTthcEntryId());
		attributes.put("attributeTypeId", getAttributeTypeId());
		attributes.put("attributeIndex", getAttributeIndex());
		attributes.put("attributeName", getAttributeName());
		attributes.put("attributeValue", getAttributeValue());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attributeId = (Long)attributes.get("attributeId");

		if (attributeId != null) {
			setAttributeId(attributeId);
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

		Long tthcEntryId = (Long)attributes.get("tthcEntryId");

		if (tthcEntryId != null) {
			setTthcEntryId(tthcEntryId);
		}

		Integer attributeTypeId = (Integer)attributes.get("attributeTypeId");

		if (attributeTypeId != null) {
			setAttributeTypeId(attributeTypeId);
		}

		Integer attributeIndex = (Integer)attributes.get("attributeIndex");

		if (attributeIndex != null) {
			setAttributeIndex(attributeIndex);
		}

		String attributeName = (String)attributes.get("attributeName");

		if (attributeName != null) {
			setAttributeName(attributeName);
		}

		String attributeValue = (String)attributes.get("attributeValue");

		if (attributeValue != null) {
			setAttributeValue(attributeValue);
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
	public long getAttributeId() {
		return _attributeId;
	}

	public void setAttributeId(long attributeId) {
		_attributeId = attributeId;
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
	public long getTthcEntryId() {
		return _tthcEntryId;
	}

	public void setTthcEntryId(long tthcEntryId) {
		_columnBitmask |= TTHCENTRYID_COLUMN_BITMASK;

		if (!_setOriginalTthcEntryId) {
			_setOriginalTthcEntryId = true;

			_originalTthcEntryId = _tthcEntryId;
		}

		_tthcEntryId = tthcEntryId;
	}

	public long getOriginalTthcEntryId() {
		return _originalTthcEntryId;
	}

	@JSON
	public int getAttributeTypeId() {
		return _attributeTypeId;
	}

	public void setAttributeTypeId(int attributeTypeId) {
		_columnBitmask |= ATTRIBUTETYPEID_COLUMN_BITMASK;

		if (!_setOriginalAttributeTypeId) {
			_setOriginalAttributeTypeId = true;

			_originalAttributeTypeId = _attributeTypeId;
		}

		_attributeTypeId = attributeTypeId;
	}

	public int getOriginalAttributeTypeId() {
		return _originalAttributeTypeId;
	}

	@JSON
	public int getAttributeIndex() {
		return _attributeIndex;
	}

	public void setAttributeIndex(int attributeIndex) {
		_columnBitmask = -1L;

		_attributeIndex = attributeIndex;
	}

	@JSON
	public String getAttributeName() {
		if (_attributeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _attributeName;
		}
	}

	public void setAttributeName(String attributeName) {
		_attributeName = attributeName;
	}

	@JSON
	public String getAttributeValue() {
		if (_attributeValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _attributeValue;
		}
	}

	public void setAttributeValue(String attributeValue) {
		_attributeValue = attributeValue;
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
			TTHC_Attribute.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TTHC_Attribute toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (TTHC_Attribute)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TTHC_AttributeImpl tthc_AttributeImpl = new TTHC_AttributeImpl();

		tthc_AttributeImpl.setAttributeId(getAttributeId());
		tthc_AttributeImpl.setCompanyId(getCompanyId());
		tthc_AttributeImpl.setGroupId(getGroupId());
		tthc_AttributeImpl.setUserId(getUserId());
		tthc_AttributeImpl.setTthcEntryId(getTthcEntryId());
		tthc_AttributeImpl.setAttributeTypeId(getAttributeTypeId());
		tthc_AttributeImpl.setAttributeIndex(getAttributeIndex());
		tthc_AttributeImpl.setAttributeName(getAttributeName());
		tthc_AttributeImpl.setAttributeValue(getAttributeValue());
		tthc_AttributeImpl.setCreateDate(getCreateDate());
		tthc_AttributeImpl.setModifiedDate(getModifiedDate());

		tthc_AttributeImpl.resetOriginalValues();

		return tthc_AttributeImpl;
	}

	public int compareTo(TTHC_Attribute tthc_Attribute) {
		int value = 0;

		if (getAttributeIndex() < tthc_Attribute.getAttributeIndex()) {
			value = -1;
		}
		else if (getAttributeIndex() > tthc_Attribute.getAttributeIndex()) {
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

		TTHC_Attribute tthc_Attribute = null;

		try {
			tthc_Attribute = (TTHC_Attribute)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tthc_Attribute.getPrimaryKey();

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
		TTHC_AttributeModelImpl tthc_AttributeModelImpl = this;

		tthc_AttributeModelImpl._originalCompanyId = tthc_AttributeModelImpl._companyId;

		tthc_AttributeModelImpl._setOriginalCompanyId = false;

		tthc_AttributeModelImpl._originalGroupId = tthc_AttributeModelImpl._groupId;

		tthc_AttributeModelImpl._setOriginalGroupId = false;

		tthc_AttributeModelImpl._originalTthcEntryId = tthc_AttributeModelImpl._tthcEntryId;

		tthc_AttributeModelImpl._setOriginalTthcEntryId = false;

		tthc_AttributeModelImpl._originalAttributeTypeId = tthc_AttributeModelImpl._attributeTypeId;

		tthc_AttributeModelImpl._setOriginalAttributeTypeId = false;

		tthc_AttributeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TTHC_Attribute> toCacheModel() {
		TTHC_AttributeCacheModel tthc_AttributeCacheModel = new TTHC_AttributeCacheModel();

		tthc_AttributeCacheModel.attributeId = getAttributeId();

		tthc_AttributeCacheModel.companyId = getCompanyId();

		tthc_AttributeCacheModel.groupId = getGroupId();

		tthc_AttributeCacheModel.userId = getUserId();

		tthc_AttributeCacheModel.tthcEntryId = getTthcEntryId();

		tthc_AttributeCacheModel.attributeTypeId = getAttributeTypeId();

		tthc_AttributeCacheModel.attributeIndex = getAttributeIndex();

		tthc_AttributeCacheModel.attributeName = getAttributeName();

		String attributeName = tthc_AttributeCacheModel.attributeName;

		if ((attributeName != null) && (attributeName.length() == 0)) {
			tthc_AttributeCacheModel.attributeName = null;
		}

		tthc_AttributeCacheModel.attributeValue = getAttributeValue();

		String attributeValue = tthc_AttributeCacheModel.attributeValue;

		if ((attributeValue != null) && (attributeValue.length() == 0)) {
			tthc_AttributeCacheModel.attributeValue = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tthc_AttributeCacheModel.createDate = createDate.getTime();
		}
		else {
			tthc_AttributeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tthc_AttributeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tthc_AttributeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return tthc_AttributeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{attributeId=");
		sb.append(getAttributeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", tthcEntryId=");
		sb.append(getTthcEntryId());
		sb.append(", attributeTypeId=");
		sb.append(getAttributeTypeId());
		sb.append(", attributeIndex=");
		sb.append(getAttributeIndex());
		sb.append(", attributeName=");
		sb.append(getAttributeName());
		sb.append(", attributeValue=");
		sb.append(getAttributeValue());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.tthc.model.TTHC_Attribute");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attributeId</column-name><column-value><![CDATA[");
		sb.append(getAttributeId());
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
			"<column><column-name>tthcEntryId</column-name><column-value><![CDATA[");
		sb.append(getTthcEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeTypeId</column-name><column-value><![CDATA[");
		sb.append(getAttributeTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeIndex</column-name><column-value><![CDATA[");
		sb.append(getAttributeIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeName</column-name><column-value><![CDATA[");
		sb.append(getAttributeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeValue</column-name><column-value><![CDATA[");
		sb.append(getAttributeValue());
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

	private static ClassLoader _classLoader = TTHC_Attribute.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			TTHC_Attribute.class
		};
	private long _attributeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _tthcEntryId;
	private long _originalTthcEntryId;
	private boolean _setOriginalTthcEntryId;
	private int _attributeTypeId;
	private int _originalAttributeTypeId;
	private boolean _setOriginalAttributeTypeId;
	private int _attributeIndex;
	private String _attributeName;
	private String _attributeValue;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private TTHC_Attribute _escapedModelProxy;
}