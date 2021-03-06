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

package com.bkav.portal.portlet.employee.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Department service. Represents a row in the &quot;Department&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bkav.portal.portlet.employee.model.impl.DepartmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bkav.portal.portlet.employee.model.impl.DepartmentImpl}.
 * </p>
 *
 * @author ducdvd
 * @see Department
 * @see com.bkav.portal.portlet.employee.model.impl.DepartmentImpl
 * @see com.bkav.portal.portlet.employee.model.impl.DepartmentModelImpl
 * @generated
 */
public interface DepartmentModel extends BaseModel<Department>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a department model instance should use the {@link Department} interface instead.
	 */

	/**
	 * Returns the primary key of this department.
	 *
	 * @return the primary key of this department
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this department.
	 *
	 * @param primaryKey the primary key of this department
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the dep ID of this department.
	 *
	 * @return the dep ID of this department
	 */
	public long getDepId();

	/**
	 * Sets the dep ID of this department.
	 *
	 * @param depId the dep ID of this department
	 */
	public void setDepId(long depId);

	/**
	 * Returns the group ID of this department.
	 *
	 * @return the group ID of this department
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this department.
	 *
	 * @param groupId the group ID of this department
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this department.
	 *
	 * @return the company ID of this department
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this department.
	 *
	 * @param companyId the company ID of this department
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this department.
	 *
	 * @return the user ID of this department
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this department.
	 *
	 * @param userId the user ID of this department
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this department.
	 *
	 * @return the user uuid of this department
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this department.
	 *
	 * @param userUuid the user uuid of this department
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this department.
	 *
	 * @return the user name of this department
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this department.
	 *
	 * @param userName the user name of this department
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this department.
	 *
	 * @return the create date of this department
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this department.
	 *
	 * @param createDate the create date of this department
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this department.
	 *
	 * @return the modified date of this department
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this department.
	 *
	 * @param modifiedDate the modified date of this department
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the dep name of this department.
	 *
	 * @return the dep name of this department
	 */
	@AutoEscape
	public String getDepName();

	/**
	 * Sets the dep name of this department.
	 *
	 * @param depName the dep name of this department
	 */
	public void setDepName(String depName);

	/**
	 * Returns the dep addres of this department.
	 *
	 * @return the dep addres of this department
	 */
	@AutoEscape
	public String getDepAddres();

	/**
	 * Sets the dep addres of this department.
	 *
	 * @param depAddres the dep addres of this department
	 */
	public void setDepAddres(String depAddres);

	/**
	 * Returns the dep phone of this department.
	 *
	 * @return the dep phone of this department
	 */
	@AutoEscape
	public String getDepPhone();

	/**
	 * Sets the dep phone of this department.
	 *
	 * @param depPhone the dep phone of this department
	 */
	public void setDepPhone(String depPhone);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Department department);

	public int hashCode();

	public CacheModel<Department> toCacheModel();

	public Department toEscapedModel();

	public String toString();

	public String toXmlString();
}