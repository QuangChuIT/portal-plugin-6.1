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

import com.liferay.portal.kernel.exception.SystemException;

import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil;

/**
 * The extended model base implementation for the CO_Thread service. Represents a row in the &quot;CO_Thread&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CO_ThreadImpl}.
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadImpl
 * @see com.portal_egov.portlet.conversation.model.CO_Thread
 * @generated
 */
public abstract class CO_ThreadBaseImpl extends CO_ThreadModelImpl
	implements CO_Thread {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c o_ thread model instance should use the {@link CO_Thread} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			CO_ThreadLocalServiceUtil.addCO_Thread(this);
		}
		else {
			CO_ThreadLocalServiceUtil.updateCO_Thread(this);
		}
	}
}