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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class LegalFAQCategoryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static LegalFAQCategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (LegalFAQCategoryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.legal_faq.service.ClpSerializer.getServletContextName(),
					LegalFAQCategoryFinder.class.getName());

			ReferenceRegistry.registerReference(LegalFAQCategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LegalFAQCategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LegalFAQCategoryFinderUtil.class,
			"_finder");
	}

	private static LegalFAQCategoryFinder _finder;
}