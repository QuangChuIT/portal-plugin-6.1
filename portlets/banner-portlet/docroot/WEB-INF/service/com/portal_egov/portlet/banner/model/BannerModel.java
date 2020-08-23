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

package com.portal_egov.portlet.banner.model;

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
 * The base model interface for the Banner service. Represents a row in the &quot;Banner&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.banner.model.impl.BannerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.banner.model.impl.BannerImpl}.
 * </p>
 *
 * @author HungDX
 * @see Banner
 * @see com.portal_egov.portlet.banner.model.impl.BannerImpl
 * @see com.portal_egov.portlet.banner.model.impl.BannerModelImpl
 * @generated
 */
public interface BannerModel extends BaseModel<Banner>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a banner model instance should use the {@link Banner} interface instead.
	 */

	/**
	 * Returns the primary key of this banner.
	 *
	 * @return the primary key of this banner
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this banner.
	 *
	 * @param primaryKey the primary key of this banner
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the banner ID of this banner.
	 *
	 * @return the banner ID of this banner
	 */
	public long getBannerId();

	/**
	 * Sets the banner ID of this banner.
	 *
	 * @param bannerId the banner ID of this banner
	 */
	public void setBannerId(long bannerId);

	/**
	 * Returns the company ID of this banner.
	 *
	 * @return the company ID of this banner
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this banner.
	 *
	 * @param companyId the company ID of this banner
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this banner.
	 *
	 * @return the group ID of this banner
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this banner.
	 *
	 * @param groupId the group ID of this banner
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this banner.
	 *
	 * @return the user ID of this banner
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this banner.
	 *
	 * @param userId the user ID of this banner
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this banner.
	 *
	 * @return the user uuid of this banner
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this banner.
	 *
	 * @param userUuid the user uuid of this banner
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this banner.
	 *
	 * @return the user name of this banner
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this banner.
	 *
	 * @param userName the user name of this banner
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this banner.
	 *
	 * @return the create date of this banner
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this banner.
	 *
	 * @param createDate the create date of this banner
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this banner.
	 *
	 * @return the modified date of this banner
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this banner.
	 *
	 * @param modifiedDate the modified date of this banner
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the banner group ID of this banner.
	 *
	 * @return the banner group ID of this banner
	 */
	public long getBannerGroupId();

	/**
	 * Sets the banner group ID of this banner.
	 *
	 * @param bannerGroupId the banner group ID of this banner
	 */
	public void setBannerGroupId(long bannerGroupId);

	/**
	 * Returns the banner title of this banner.
	 *
	 * @return the banner title of this banner
	 */
	@AutoEscape
	public String getBannerTitle();

	/**
	 * Sets the banner title of this banner.
	 *
	 * @param bannerTitle the banner title of this banner
	 */
	public void setBannerTitle(String bannerTitle);

	/**
	 * Returns the banner link of this banner.
	 *
	 * @return the banner link of this banner
	 */
	@AutoEscape
	public String getBannerLink();

	/**
	 * Sets the banner link of this banner.
	 *
	 * @param bannerLink the banner link of this banner
	 */
	public void setBannerLink(String bannerLink);

	/**
	 * Returns the banner image ID of this banner.
	 *
	 * @return the banner image ID of this banner
	 */
	public long getBannerImageId();

	/**
	 * Sets the banner image ID of this banner.
	 *
	 * @param bannerImageId the banner image ID of this banner
	 */
	public void setBannerImageId(long bannerImageId);

	/**
	 * Returns the view counter of this banner.
	 *
	 * @return the view counter of this banner
	 */
	public int getViewCounter();

	/**
	 * Sets the view counter of this banner.
	 *
	 * @param viewCounter the view counter of this banner
	 */
	public void setViewCounter(int viewCounter);

	/**
	 * Returns the banner status of this banner.
	 *
	 * @return the banner status of this banner
	 */
	public int getBannerStatus();

	/**
	 * Sets the banner status of this banner.
	 *
	 * @param bannerStatus the banner status of this banner
	 */
	public void setBannerStatus(int bannerStatus);

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

	public int compareTo(Banner banner);

	public int hashCode();

	public CacheModel<Banner> toCacheModel();

	public Banner toEscapedModel();

	public String toString();

	public String toXmlString();
}