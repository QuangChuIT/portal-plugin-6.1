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

package com.portal_egov.portlet.landprice.model;

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
 * The base model interface for the LandPrice service. Represents a row in the &quot;LandPrice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.landprice.model.impl.LandPriceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.landprice.model.impl.LandPriceImpl}.
 * </p>
 *
 * @author HungDX
 * @see LandPrice
 * @see com.portal_egov.portlet.landprice.model.impl.LandPriceImpl
 * @see com.portal_egov.portlet.landprice.model.impl.LandPriceModelImpl
 * @generated
 */
public interface LandPriceModel extends BaseModel<LandPrice>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a land price model instance should use the {@link LandPrice} interface instead.
	 */

	/**
	 * Returns the primary key of this land price.
	 *
	 * @return the primary key of this land price
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this land price.
	 *
	 * @param primaryKey the primary key of this land price
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the price ID of this land price.
	 *
	 * @return the price ID of this land price
	 */
	public long getPriceId();

	/**
	 * Sets the price ID of this land price.
	 *
	 * @param priceId the price ID of this land price
	 */
	public void setPriceId(long priceId);

	/**
	 * Returns the company ID of this land price.
	 *
	 * @return the company ID of this land price
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this land price.
	 *
	 * @param companyId the company ID of this land price
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this land price.
	 *
	 * @return the group ID of this land price
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this land price.
	 *
	 * @param groupId the group ID of this land price
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this land price.
	 *
	 * @return the user ID of this land price
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this land price.
	 *
	 * @param userId the user ID of this land price
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this land price.
	 *
	 * @return the user uuid of this land price
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this land price.
	 *
	 * @param userUuid the user uuid of this land price
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this land price.
	 *
	 * @return the user name of this land price
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this land price.
	 *
	 * @param userName the user name of this land price
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this land price.
	 *
	 * @return the create date of this land price
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this land price.
	 *
	 * @param createDate the create date of this land price
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this land price.
	 *
	 * @return the modified date of this land price
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this land price.
	 *
	 * @param modifiedDate the modified date of this land price
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the location ID of this land price.
	 *
	 * @return the location ID of this land price
	 */
	public long getLocationId();

	/**
	 * Sets the location ID of this land price.
	 *
	 * @param locationId the location ID of this land price
	 */
	public void setLocationId(long locationId);

	/**
	 * Returns the title of this land price.
	 *
	 * @return the title of this land price
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this land price.
	 *
	 * @param title the title of this land price
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this land price.
	 *
	 * @return the content of this land price
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this land price.
	 *
	 * @param content the content of this land price
	 */
	public void setContent(String content);

	/**
	 * Returns the statistic year of this land price.
	 *
	 * @return the statistic year of this land price
	 */
	public int getStatisticYear();

	/**
	 * Sets the statistic year of this land price.
	 *
	 * @param statisticYear the statistic year of this land price
	 */
	public void setStatisticYear(int statisticYear);

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

	public int compareTo(LandPrice landPrice);

	public int hashCode();

	public CacheModel<LandPrice> toCacheModel();

	public LandPrice toEscapedModel();

	public String toString();

	public String toXmlString();
}