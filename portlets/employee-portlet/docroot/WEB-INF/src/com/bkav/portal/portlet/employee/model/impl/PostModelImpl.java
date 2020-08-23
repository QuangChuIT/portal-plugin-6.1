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

package com.bkav.portal.portlet.employee.model.impl;

import com.bkav.portal.portlet.employee.model.Post;
import com.bkav.portal.portlet.employee.model.PostModel;
import com.bkav.portal.portlet.employee.model.PostSoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Post service. Represents a row in the &quot;Post&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.employee.model.PostModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PostImpl}.
 * </p>
 *
 * @author ducdvd
 * @see PostImpl
 * @see com.bkav.portal.portlet.employee.model.Post
 * @see com.bkav.portal.portlet.employee.model.PostModel
 * @generated
 */
@JSON(strict = true)
public class PostModelImpl extends BaseModelImpl<Post> implements PostModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a post model instance should use the {@link com.bkav.portal.portlet.employee.model.Post} interface instead.
	 */
	public static final String TABLE_NAME = "Post";
	public static final Object[][] TABLE_COLUMNS = {
			{ "postId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "postName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Post (postId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,postName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Post";
	public static final String ORDER_BY_JPQL = " ORDER BY post.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Post.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.employee.model.Post"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.employee.model.Post"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.employee.model.Post"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Post toModel(PostSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Post model = new PostImpl();

		model.setPostId(soapModel.getPostId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPostName(soapModel.getPostName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Post> toModels(PostSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Post> models = new ArrayList<Post>(soapModels.length);

		for (PostSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.employee.model.Post"));

	public PostModelImpl() {
	}

	public long getPrimaryKey() {
		return _postId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPostId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_postId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Post.class;
	}

	public String getModelClassName() {
		return Post.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postId", getPostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("postName", getPostName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
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

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}
	}

	@JSON
	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
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
	public String getPostName() {
		if (_postName == null) {
			return StringPool.BLANK;
		}
		else {
			return _postName;
		}
	}

	public void setPostName(String postName) {
		_postName = postName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Post.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Post toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Post)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PostImpl postImpl = new PostImpl();

		postImpl.setPostId(getPostId());
		postImpl.setGroupId(getGroupId());
		postImpl.setCompanyId(getCompanyId());
		postImpl.setUserId(getUserId());
		postImpl.setUserName(getUserName());
		postImpl.setCreateDate(getCreateDate());
		postImpl.setModifiedDate(getModifiedDate());
		postImpl.setPostName(getPostName());

		postImpl.resetOriginalValues();

		return postImpl;
	}

	public int compareTo(Post post) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), post.getCreateDate());

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

		Post post = null;

		try {
			post = (Post)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = post.getPrimaryKey();

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
		PostModelImpl postModelImpl = this;

		postModelImpl._originalGroupId = postModelImpl._groupId;

		postModelImpl._setOriginalGroupId = false;

		postModelImpl._originalCompanyId = postModelImpl._companyId;

		postModelImpl._setOriginalCompanyId = false;

		postModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Post> toCacheModel() {
		PostCacheModel postCacheModel = new PostCacheModel();

		postCacheModel.postId = getPostId();

		postCacheModel.groupId = getGroupId();

		postCacheModel.companyId = getCompanyId();

		postCacheModel.userId = getUserId();

		postCacheModel.userName = getUserName();

		String userName = postCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			postCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			postCacheModel.createDate = createDate.getTime();
		}
		else {
			postCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			postCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			postCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		postCacheModel.postName = getPostName();

		String postName = postCacheModel.postName;

		if ((postName != null) && (postName.length() == 0)) {
			postCacheModel.postName = null;
		}

		return postCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{postId=");
		sb.append(getPostId());
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
		sb.append(", postName=");
		sb.append(getPostName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.employee.model.Post");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>postId</column-name><column-value><![CDATA[");
		sb.append(getPostId());
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
			"<column><column-name>postName</column-name><column-value><![CDATA[");
		sb.append(getPostName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Post.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Post.class
		};
	private long _postId;
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
	private String _postName;
	private long _columnBitmask;
	private Post _escapedModelProxy;
}