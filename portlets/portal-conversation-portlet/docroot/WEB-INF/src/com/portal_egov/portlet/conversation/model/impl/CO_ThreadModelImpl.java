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

import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.model.CO_ThreadModel;
import com.portal_egov.portlet.conversation.model.CO_ThreadSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CO_Thread service. Represents a row in the &quot;CO_Thread&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.conversation.model.CO_ThreadModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CO_ThreadImpl}.
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadImpl
 * @see com.portal_egov.portlet.conversation.model.CO_Thread
 * @see com.portal_egov.portlet.conversation.model.CO_ThreadModel
 * @generated
 */
@JSON(strict = true)
public class CO_ThreadModelImpl extends BaseModelImpl<CO_Thread>
	implements CO_ThreadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c o_ thread model instance should use the {@link com.portal_egov.portlet.conversation.model.CO_Thread} interface instead.
	 */
	public static final String TABLE_NAME = "CO_Thread";
	public static final Object[][] TABLE_COLUMNS = {
			{ "threadId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "parentThreadId", Types.BIGINT },
			{ "categoryId", Types.BIGINT },
			{ "threadName", Types.VARCHAR },
			{ "departmentName", Types.VARCHAR },
			{ "participants", Types.VARCHAR },
			{ "threadDesc", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "viewCount", Types.INTEGER },
			{ "conversationCount", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table CO_Thread (threadId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,parentThreadId LONG,categoryId LONG,threadName VARCHAR(75) null,departmentName VARCHAR(75) null,participants VARCHAR(75) null,threadDesc VARCHAR(75) null,startDate DATE null,endDate DATE null,createDate DATE null,modifiedDate DATE null,viewCount INTEGER,conversationCount INTEGER,status INTEGER,statusByUserId LONG,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CO_Thread";
	public static final String ORDER_BY_JPQL = " ORDER BY co_Thread.startDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CO_Thread.startDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Thread"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Thread"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.conversation.model.CO_Thread"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long PARENTTHREADID_COLUMN_BITMASK = 8L;
	public static long STATUS_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CO_Thread toModel(CO_ThreadSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CO_Thread model = new CO_ThreadImpl();

		model.setThreadId(soapModel.getThreadId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setParentThreadId(soapModel.getParentThreadId());
		model.setCategoryId(soapModel.getCategoryId());
		model.setThreadName(soapModel.getThreadName());
		model.setDepartmentName(soapModel.getDepartmentName());
		model.setParticipants(soapModel.getParticipants());
		model.setThreadDesc(soapModel.getThreadDesc());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setViewCount(soapModel.getViewCount());
		model.setConversationCount(soapModel.getConversationCount());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CO_Thread> toModels(CO_ThreadSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CO_Thread> models = new ArrayList<CO_Thread>(soapModels.length);

		for (CO_ThreadSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.conversation.model.CO_Thread"));

	public CO_ThreadModelImpl() {
	}

	public long getPrimaryKey() {
		return _threadId;
	}

	public void setPrimaryKey(long primaryKey) {
		setThreadId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_threadId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CO_Thread.class;
	}

	public String getModelClassName() {
		return CO_Thread.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("threadId", getThreadId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("parentThreadId", getParentThreadId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("threadName", getThreadName());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("participants", getParticipants());
		attributes.put("threadDesc", getThreadDesc());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("conversationCount", getConversationCount());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long threadId = (Long)attributes.get("threadId");

		if (threadId != null) {
			setThreadId(threadId);
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

		Long parentThreadId = (Long)attributes.get("parentThreadId");

		if (parentThreadId != null) {
			setParentThreadId(parentThreadId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String threadName = (String)attributes.get("threadName");

		if (threadName != null) {
			setThreadName(threadName);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String participants = (String)attributes.get("participants");

		if (participants != null) {
			setParticipants(participants);
		}

		String threadDesc = (String)attributes.get("threadDesc");

		if (threadDesc != null) {
			setThreadDesc(threadDesc);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer conversationCount = (Integer)attributes.get("conversationCount");

		if (conversationCount != null) {
			setConversationCount(conversationCount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@JSON
	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_threadId = threadId;
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
	public long getParentThreadId() {
		return _parentThreadId;
	}

	public void setParentThreadId(long parentThreadId) {
		_columnBitmask |= PARENTTHREADID_COLUMN_BITMASK;

		if (!_setOriginalParentThreadId) {
			_setOriginalParentThreadId = true;

			_originalParentThreadId = _parentThreadId;
		}

		_parentThreadId = parentThreadId;
	}

	public long getOriginalParentThreadId() {
		return _originalParentThreadId;
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	public String getThreadName() {
		if (_threadName == null) {
			return StringPool.BLANK;
		}
		else {
			return _threadName;
		}
	}

	public void setThreadName(String threadName) {
		_threadName = threadName;
	}

	@JSON
	public String getDepartmentName() {
		if (_departmentName == null) {
			return StringPool.BLANK;
		}
		else {
			return _departmentName;
		}
	}

	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;
	}

	@JSON
	public String getParticipants() {
		if (_participants == null) {
			return StringPool.BLANK;
		}
		else {
			return _participants;
		}
	}

	public void setParticipants(String participants) {
		_participants = participants;
	}

	@JSON
	public String getThreadDesc() {
		if (_threadDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _threadDesc;
		}
	}

	public void setThreadDesc(String threadDesc) {
		_threadDesc = threadDesc;
	}

	@JSON
	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_columnBitmask = -1L;

		_startDate = startDate;
	}

	@JSON
	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
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

	@JSON
	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	@JSON
	public int getConversationCount() {
		return _conversationCount;
	}

	public void setConversationCount(int conversationCount) {
		_conversationCount = conversationCount;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CO_Thread.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CO_Thread toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CO_Thread)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CO_ThreadImpl co_ThreadImpl = new CO_ThreadImpl();

		co_ThreadImpl.setThreadId(getThreadId());
		co_ThreadImpl.setCompanyId(getCompanyId());
		co_ThreadImpl.setGroupId(getGroupId());
		co_ThreadImpl.setUserId(getUserId());
		co_ThreadImpl.setParentThreadId(getParentThreadId());
		co_ThreadImpl.setCategoryId(getCategoryId());
		co_ThreadImpl.setThreadName(getThreadName());
		co_ThreadImpl.setDepartmentName(getDepartmentName());
		co_ThreadImpl.setParticipants(getParticipants());
		co_ThreadImpl.setThreadDesc(getThreadDesc());
		co_ThreadImpl.setStartDate(getStartDate());
		co_ThreadImpl.setEndDate(getEndDate());
		co_ThreadImpl.setCreateDate(getCreateDate());
		co_ThreadImpl.setModifiedDate(getModifiedDate());
		co_ThreadImpl.setViewCount(getViewCount());
		co_ThreadImpl.setConversationCount(getConversationCount());
		co_ThreadImpl.setStatus(getStatus());
		co_ThreadImpl.setStatusByUserId(getStatusByUserId());
		co_ThreadImpl.setStatusDate(getStatusDate());

		co_ThreadImpl.resetOriginalValues();

		return co_ThreadImpl;
	}

	public int compareTo(CO_Thread co_Thread) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), co_Thread.getStartDate());

		value = value * -1;

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

		CO_Thread co_Thread = null;

		try {
			co_Thread = (CO_Thread)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = co_Thread.getPrimaryKey();

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
		CO_ThreadModelImpl co_ThreadModelImpl = this;

		co_ThreadModelImpl._originalCompanyId = co_ThreadModelImpl._companyId;

		co_ThreadModelImpl._setOriginalCompanyId = false;

		co_ThreadModelImpl._originalGroupId = co_ThreadModelImpl._groupId;

		co_ThreadModelImpl._setOriginalGroupId = false;

		co_ThreadModelImpl._originalParentThreadId = co_ThreadModelImpl._parentThreadId;

		co_ThreadModelImpl._setOriginalParentThreadId = false;

		co_ThreadModelImpl._originalCategoryId = co_ThreadModelImpl._categoryId;

		co_ThreadModelImpl._setOriginalCategoryId = false;

		co_ThreadModelImpl._originalStatus = co_ThreadModelImpl._status;

		co_ThreadModelImpl._setOriginalStatus = false;

		co_ThreadModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CO_Thread> toCacheModel() {
		CO_ThreadCacheModel co_ThreadCacheModel = new CO_ThreadCacheModel();

		co_ThreadCacheModel.threadId = getThreadId();

		co_ThreadCacheModel.companyId = getCompanyId();

		co_ThreadCacheModel.groupId = getGroupId();

		co_ThreadCacheModel.userId = getUserId();

		co_ThreadCacheModel.parentThreadId = getParentThreadId();

		co_ThreadCacheModel.categoryId = getCategoryId();

		co_ThreadCacheModel.threadName = getThreadName();

		String threadName = co_ThreadCacheModel.threadName;

		if ((threadName != null) && (threadName.length() == 0)) {
			co_ThreadCacheModel.threadName = null;
		}

		co_ThreadCacheModel.departmentName = getDepartmentName();

		String departmentName = co_ThreadCacheModel.departmentName;

		if ((departmentName != null) && (departmentName.length() == 0)) {
			co_ThreadCacheModel.departmentName = null;
		}

		co_ThreadCacheModel.participants = getParticipants();

		String participants = co_ThreadCacheModel.participants;

		if ((participants != null) && (participants.length() == 0)) {
			co_ThreadCacheModel.participants = null;
		}

		co_ThreadCacheModel.threadDesc = getThreadDesc();

		String threadDesc = co_ThreadCacheModel.threadDesc;

		if ((threadDesc != null) && (threadDesc.length() == 0)) {
			co_ThreadCacheModel.threadDesc = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			co_ThreadCacheModel.startDate = startDate.getTime();
		}
		else {
			co_ThreadCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			co_ThreadCacheModel.endDate = endDate.getTime();
		}
		else {
			co_ThreadCacheModel.endDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			co_ThreadCacheModel.createDate = createDate.getTime();
		}
		else {
			co_ThreadCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			co_ThreadCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			co_ThreadCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		co_ThreadCacheModel.viewCount = getViewCount();

		co_ThreadCacheModel.conversationCount = getConversationCount();

		co_ThreadCacheModel.status = getStatus();

		co_ThreadCacheModel.statusByUserId = getStatusByUserId();

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			co_ThreadCacheModel.statusDate = statusDate.getTime();
		}
		else {
			co_ThreadCacheModel.statusDate = Long.MIN_VALUE;
		}

		return co_ThreadCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{threadId=");
		sb.append(getThreadId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", parentThreadId=");
		sb.append(getParentThreadId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", threadName=");
		sb.append(getThreadName());
		sb.append(", departmentName=");
		sb.append(getDepartmentName());
		sb.append(", participants=");
		sb.append(getParticipants());
		sb.append(", threadDesc=");
		sb.append(getThreadDesc());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", conversationCount=");
		sb.append(getConversationCount());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.conversation.model.CO_Thread");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
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
			"<column><column-name>parentThreadId</column-name><column-value><![CDATA[");
		sb.append(getParentThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadName</column-name><column-value><![CDATA[");
		sb.append(getThreadName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentName</column-name><column-value><![CDATA[");
		sb.append(getDepartmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participants</column-name><column-value><![CDATA[");
		sb.append(getParticipants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadDesc</column-name><column-value><![CDATA[");
		sb.append(getThreadDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
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
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conversationCount</column-name><column-value><![CDATA[");
		sb.append(getConversationCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CO_Thread.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CO_Thread.class
		};
	private long _threadId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _parentThreadId;
	private long _originalParentThreadId;
	private boolean _setOriginalParentThreadId;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _threadName;
	private String _departmentName;
	private String _participants;
	private String _threadDesc;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _viewCount;
	private int _conversationCount;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private long _columnBitmask;
	private CO_Thread _escapedModelProxy;
}