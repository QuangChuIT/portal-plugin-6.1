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

package com.bkav.portal_egov.portlet.asset_statistics.model;

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
 * The base model interface for the StatisticEntity service. Represents a row in the &quot;StatisticEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityImpl}.
 * </p>
 *
 * @author HungDX
 * @see StatisticEntity
 * @see com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityImpl
 * @see com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityModelImpl
 * @generated
 */
public interface StatisticEntityModel extends BaseModel<StatisticEntity>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a statistic entity model instance should use the {@link StatisticEntity} interface instead.
	 */

	/**
	 * Returns the primary key of this statistic entity.
	 *
	 * @return the primary key of this statistic entity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this statistic entity.
	 *
	 * @param primaryKey the primary key of this statistic entity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the entity ID of this statistic entity.
	 *
	 * @return the entity ID of this statistic entity
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this statistic entity.
	 *
	 * @param entityId the entity ID of this statistic entity
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the company ID of this statistic entity.
	 *
	 * @return the company ID of this statistic entity
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this statistic entity.
	 *
	 * @param companyId the company ID of this statistic entity
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this statistic entity.
	 *
	 * @return the group ID of this statistic entity
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this statistic entity.
	 *
	 * @param groupId the group ID of this statistic entity
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this statistic entity.
	 *
	 * @return the user ID of this statistic entity
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this statistic entity.
	 *
	 * @param userId the user ID of this statistic entity
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this statistic entity.
	 *
	 * @return the user uuid of this statistic entity
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this statistic entity.
	 *
	 * @param userUuid the user uuid of this statistic entity
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this statistic entity.
	 *
	 * @return the user name of this statistic entity
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this statistic entity.
	 *
	 * @param userName the user name of this statistic entity
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this statistic entity.
	 *
	 * @return the create date of this statistic entity
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this statistic entity.
	 *
	 * @param createDate the create date of this statistic entity
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this statistic entity.
	 *
	 * @return the modified date of this statistic entity
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this statistic entity.
	 *
	 * @param modifiedDate the modified date of this statistic entity
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the entity name of this statistic entity.
	 *
	 * @return the entity name of this statistic entity
	 */
	@AutoEscape
	public String getEntityName();

	/**
	 * Sets the entity name of this statistic entity.
	 *
	 * @param entityName the entity name of this statistic entity
	 */
	public void setEntityName(String entityName);

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

	public int compareTo(StatisticEntity statisticEntity);

	public int hashCode();

	public CacheModel<StatisticEntity> toCacheModel();

	public StatisticEntity toEscapedModel();

	public String toString();

	public String toXmlString();
}