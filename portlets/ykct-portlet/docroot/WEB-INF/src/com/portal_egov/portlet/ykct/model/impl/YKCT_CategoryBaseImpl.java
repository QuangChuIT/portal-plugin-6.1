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

package com.portal_egov.portlet.ykct.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.portal_egov.portlet.ykct.model.YKCT_Category;
import com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil;

/**
 * The extended model base implementation for the YKCT_Category service. Represents a row in the &quot;YKCT_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link YKCT_CategoryImpl}.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_CategoryImpl
 * @see com.portal_egov.portlet.ykct.model.YKCT_Category
 * @generated
 */
public abstract class YKCT_CategoryBaseImpl extends YKCT_CategoryModelImpl
	implements YKCT_Category {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a y k c t_ category model instance should use the {@link YKCT_Category} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			YKCT_CategoryLocalServiceUtil.addYKCT_Category(this);
		}
		else {
			YKCT_CategoryLocalServiceUtil.updateYKCT_Category(this);
		}
	}
}