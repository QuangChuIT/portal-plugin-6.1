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

import com.bkav.portal.portlet.employee.model.Employee;
import com.bkav.portal.portlet.employee.model.EmployeeModel;
import com.bkav.portal.portlet.employee.model.EmployeeSoap;

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
 * The base model implementation for the Employee service. Represents a row in the &quot;Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.employee.model.EmployeeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author ducdvd
 * @see EmployeeImpl
 * @see com.bkav.portal.portlet.employee.model.Employee
 * @see com.bkav.portal.portlet.employee.model.EmployeeModel
 * @generated
 */
@JSON(strict = true)
public class EmployeeModelImpl extends BaseModelImpl<Employee>
	implements EmployeeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the {@link com.bkav.portal.portlet.employee.model.Employee} interface instead.
	 */
	public static final String TABLE_NAME = "Employee";
	public static final Object[][] TABLE_COLUMNS = {
			{ "emplId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "birthday", Types.TIMESTAMP },
			{ "male", Types.VARCHAR },
			{ "phone", Types.BIGINT },
			{ "addres", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "postId", Types.BIGINT },
			{ "depId", Types.BIGINT },
			{ "sal", Types.BIGINT },
			{ "breakDay", Types.INTEGER },
			{ "addDay", Types.INTEGER },
			{ "endDate", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Employee (emplId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,birthday DATE null,male VARCHAR(75) null,phone LONG,addres VARCHAR(75) null,email VARCHAR(75) null,postId LONG,depId LONG,sal LONG,breakDay INTEGER,addDay INTEGER,endDate VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Employee";
	public static final String ORDER_BY_JPQL = " ORDER BY employee.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Employee.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.employee.model.Employee"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.employee.model.Employee"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.employee.model.Employee"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long DEPID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long POSTID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Employee toModel(EmployeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Employee model = new EmployeeImpl();

		model.setEmplId(soapModel.getEmplId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setBirthday(soapModel.getBirthday());
		model.setMale(soapModel.getMale());
		model.setPhone(soapModel.getPhone());
		model.setAddres(soapModel.getAddres());
		model.setEmail(soapModel.getEmail());
		model.setPostId(soapModel.getPostId());
		model.setDepId(soapModel.getDepId());
		model.setSal(soapModel.getSal());
		model.setBreakDay(soapModel.getBreakDay());
		model.setAddDay(soapModel.getAddDay());
		model.setEndDate(soapModel.getEndDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Employee> toModels(EmployeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Employee> models = new ArrayList<Employee>(soapModels.length);

		for (EmployeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.employee.model.Employee"));

	public EmployeeModelImpl() {
	}

	public long getPrimaryKey() {
		return _emplId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEmplId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_emplId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emplId", getEmplId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("birthday", getBirthday());
		attributes.put("male", getMale());
		attributes.put("phone", getPhone());
		attributes.put("addres", getAddres());
		attributes.put("email", getEmail());
		attributes.put("postId", getPostId());
		attributes.put("depId", getDepId());
		attributes.put("sal", getSal());
		attributes.put("breakDay", getBreakDay());
		attributes.put("addDay", getAddDay());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String male = (String)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String addres = (String)attributes.get("addres");

		if (addres != null) {
			setAddres(addres);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
		}

		Long sal = (Long)attributes.get("sal");

		if (sal != null) {
			setSal(sal);
		}

		Integer breakDay = (Integer)attributes.get("breakDay");

		if (breakDay != null) {
			setBreakDay(breakDay);
		}

		Integer addDay = (Integer)attributes.get("addDay");

		if (addDay != null) {
			setAddDay(addDay);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@JSON
	public long getEmplId() {
		return _emplId;
	}

	public void setEmplId(long emplId) {
		_emplId = emplId;
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

	@JSON
	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	@JSON
	public String getMale() {
		if (_male == null) {
			return StringPool.BLANK;
		}
		else {
			return _male;
		}
	}

	public void setMale(String male) {
		_male = male;
	}

	@JSON
	public long getPhone() {
		return _phone;
	}

	public void setPhone(long phone) {
		_phone = phone;
	}

	@JSON
	public String getAddres() {
		if (_addres == null) {
			return StringPool.BLANK;
		}
		else {
			return _addres;
		}
	}

	public void setAddres(String addres) {
		_addres = addres;
	}

	@JSON
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_columnBitmask |= POSTID_COLUMN_BITMASK;

		if (!_setOriginalPostId) {
			_setOriginalPostId = true;

			_originalPostId = _postId;
		}

		_postId = postId;
	}

	public long getOriginalPostId() {
		return _originalPostId;
	}

	@JSON
	public long getDepId() {
		return _depId;
	}

	public void setDepId(long depId) {
		_columnBitmask |= DEPID_COLUMN_BITMASK;

		if (!_setOriginalDepId) {
			_setOriginalDepId = true;

			_originalDepId = _depId;
		}

		_depId = depId;
	}

	public long getOriginalDepId() {
		return _originalDepId;
	}

	@JSON
	public long getSal() {
		return _sal;
	}

	public void setSal(long sal) {
		_sal = sal;
	}

	@JSON
	public int getBreakDay() {
		return _breakDay;
	}

	public void setBreakDay(int breakDay) {
		_breakDay = breakDay;
	}

	@JSON
	public int getAddDay() {
		return _addDay;
	}

	public void setAddDay(int addDay) {
		_addDay = addDay;
	}

	@JSON
	public String getEndDate() {
		if (_endDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _endDate;
		}
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Employee)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmplId(getEmplId());
		employeeImpl.setGroupId(getGroupId());
		employeeImpl.setCompanyId(getCompanyId());
		employeeImpl.setUserId(getUserId());
		employeeImpl.setUserName(getUserName());
		employeeImpl.setCreateDate(getCreateDate());
		employeeImpl.setModifiedDate(getModifiedDate());
		employeeImpl.setName(getName());
		employeeImpl.setBirthday(getBirthday());
		employeeImpl.setMale(getMale());
		employeeImpl.setPhone(getPhone());
		employeeImpl.setAddres(getAddres());
		employeeImpl.setEmail(getEmail());
		employeeImpl.setPostId(getPostId());
		employeeImpl.setDepId(getDepId());
		employeeImpl.setSal(getSal());
		employeeImpl.setBreakDay(getBreakDay());
		employeeImpl.setAddDay(getAddDay());
		employeeImpl.setEndDate(getEndDate());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	public int compareTo(Employee employee) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), employee.getCreateDate());

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

		Employee employee = null;

		try {
			employee = (Employee)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = employee.getPrimaryKey();

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
		EmployeeModelImpl employeeModelImpl = this;

		employeeModelImpl._originalGroupId = employeeModelImpl._groupId;

		employeeModelImpl._setOriginalGroupId = false;

		employeeModelImpl._originalCompanyId = employeeModelImpl._companyId;

		employeeModelImpl._setOriginalCompanyId = false;

		employeeModelImpl._originalPostId = employeeModelImpl._postId;

		employeeModelImpl._setOriginalPostId = false;

		employeeModelImpl._originalDepId = employeeModelImpl._depId;

		employeeModelImpl._setOriginalDepId = false;

		employeeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.emplId = getEmplId();

		employeeCacheModel.groupId = getGroupId();

		employeeCacheModel.companyId = getCompanyId();

		employeeCacheModel.userId = getUserId();

		employeeCacheModel.userName = getUserName();

		String userName = employeeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeCacheModel.name = getName();

		String name = employeeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			employeeCacheModel.name = null;
		}

		Date birthday = getBirthday();

		if (birthday != null) {
			employeeCacheModel.birthday = birthday.getTime();
		}
		else {
			employeeCacheModel.birthday = Long.MIN_VALUE;
		}

		employeeCacheModel.male = getMale();

		String male = employeeCacheModel.male;

		if ((male != null) && (male.length() == 0)) {
			employeeCacheModel.male = null;
		}

		employeeCacheModel.phone = getPhone();

		employeeCacheModel.addres = getAddres();

		String addres = employeeCacheModel.addres;

		if ((addres != null) && (addres.length() == 0)) {
			employeeCacheModel.addres = null;
		}

		employeeCacheModel.email = getEmail();

		String email = employeeCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			employeeCacheModel.email = null;
		}

		employeeCacheModel.postId = getPostId();

		employeeCacheModel.depId = getDepId();

		employeeCacheModel.sal = getSal();

		employeeCacheModel.breakDay = getBreakDay();

		employeeCacheModel.addDay = getAddDay();

		employeeCacheModel.endDate = getEndDate();

		String endDate = employeeCacheModel.endDate;

		if ((endDate != null) && (endDate.length() == 0)) {
			employeeCacheModel.endDate = null;
		}

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{emplId=");
		sb.append(getEmplId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", male=");
		sb.append(getMale());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", addres=");
		sb.append(getAddres());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", postId=");
		sb.append(getPostId());
		sb.append(", depId=");
		sb.append(getDepId());
		sb.append(", sal=");
		sb.append(getSal());
		sb.append(", breakDay=");
		sb.append(getBreakDay());
		sb.append(", addDay=");
		sb.append(getAddDay());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.employee.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>emplId</column-name><column-value><![CDATA[");
		sb.append(getEmplId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>male</column-name><column-value><![CDATA[");
		sb.append(getMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addres</column-name><column-value><![CDATA[");
		sb.append(getAddres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postId</column-name><column-value><![CDATA[");
		sb.append(getPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depId</column-name><column-value><![CDATA[");
		sb.append(getDepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sal</column-name><column-value><![CDATA[");
		sb.append(getSal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>breakDay</column-name><column-value><![CDATA[");
		sb.append(getBreakDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addDay</column-name><column-value><![CDATA[");
		sb.append(getAddDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Employee.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Employee.class
		};
	private long _emplId;
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
	private String _name;
	private Date _birthday;
	private String _male;
	private long _phone;
	private String _addres;
	private String _email;
	private long _postId;
	private long _originalPostId;
	private boolean _setOriginalPostId;
	private long _depId;
	private long _originalDepId;
	private boolean _setOriginalDepId;
	private long _sal;
	private int _breakDay;
	private int _addDay;
	private String _endDate;
	private long _columnBitmask;
	private Employee _escapedModelProxy;
}