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

package com.portal_egov.portlet.visit_counter.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the VisitCounterDayLog service. Represents a row in the &quot;VisitCounterDayLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogImpl}.
 * </p>
 *
 * @author HungDX
 * @see VisitCounterDayLog
 * @see com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogImpl
 * @see com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogModelImpl
 * @generated
 */
public interface VisitCounterDayLogModel extends BaseModel<VisitCounterDayLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a visit counter day log model instance should use the {@link VisitCounterDayLog} interface instead.
	 */

	/**
	 * Returns the primary key of this visit counter day log.
	 *
	 * @return the primary key of this visit counter day log
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this visit counter day log.
	 *
	 * @param primaryKey the primary key of this visit counter day log
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the daylog ID of this visit counter day log.
	 *
	 * @return the daylog ID of this visit counter day log
	 */
	@AutoEscape
	public String getDaylogId();

	/**
	 * Sets the daylog ID of this visit counter day log.
	 *
	 * @param daylogId the daylog ID of this visit counter day log
	 */
	public void setDaylogId(String daylogId);

	/**
	 * Returns the company ID of this visit counter day log.
	 *
	 * @return the company ID of this visit counter day log
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this visit counter day log.
	 *
	 * @param companyId the company ID of this visit counter day log
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this visit counter day log.
	 *
	 * @return the group ID of this visit counter day log
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this visit counter day log.
	 *
	 * @param groupId the group ID of this visit counter day log
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the hit counter of this visit counter day log.
	 *
	 * @return the hit counter of this visit counter day log
	 */
	public int getHitCounter();

	/**
	 * Sets the hit counter of this visit counter day log.
	 *
	 * @param hitCounter the hit counter of this visit counter day log
	 */
	public void setHitCounter(int hitCounter);

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

	public int compareTo(VisitCounterDayLog visitCounterDayLog);

	public int hashCode();

	public CacheModel<VisitCounterDayLog> toCacheModel();

	public VisitCounterDayLog toEscapedModel();

	public String toString();

	public String toXmlString();
}