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

package com.bkav.portlet.article.link.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ArticleLinkEntryService}.
 * </p>
 *
 * @author    quangcv
 * @see       ArticleLinkEntryService
 * @generated
 */
public class ArticleLinkEntryServiceWrapper implements ArticleLinkEntryService,
	ServiceWrapper<ArticleLinkEntryService> {
	public ArticleLinkEntryServiceWrapper(
		ArticleLinkEntryService articleLinkEntryService) {
		_articleLinkEntryService = articleLinkEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _articleLinkEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_articleLinkEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _articleLinkEntryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ArticleLinkEntryService getWrappedArticleLinkEntryService() {
		return _articleLinkEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedArticleLinkEntryService(
		ArticleLinkEntryService articleLinkEntryService) {
		_articleLinkEntryService = articleLinkEntryService;
	}

	public ArticleLinkEntryService getWrappedService() {
		return _articleLinkEntryService;
	}

	public void setWrappedService(
		ArticleLinkEntryService articleLinkEntryService) {
		_articleLinkEntryService = articleLinkEntryService;
	}

	private ArticleLinkEntryService _articleLinkEntryService;
}