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

package com.portal_egov.portlet.citizen_inquiry.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CitizenInquiryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       CitizenInquiryLocalService
 * @generated
 */
public class CitizenInquiryLocalServiceWrapper
	implements CitizenInquiryLocalService,
		ServiceWrapper<CitizenInquiryLocalService> {
	public CitizenInquiryLocalServiceWrapper(
		CitizenInquiryLocalService citizenInquiryLocalService) {
		_citizenInquiryLocalService = citizenInquiryLocalService;
	}

	/**
	* Adds the citizen inquiry to the database. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiry the citizen inquiry
	* @return the citizen inquiry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry addCitizenInquiry(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.addCitizenInquiry(citizenInquiry);
	}

	/**
	* Creates a new citizen inquiry with the primary key. Does not add the citizen inquiry to the database.
	*
	* @param inquiryId the primary key for the new citizen inquiry
	* @return the new citizen inquiry
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry createCitizenInquiry(
		long inquiryId) {
		return _citizenInquiryLocalService.createCitizenInquiry(inquiryId);
	}

	/**
	* Deletes the citizen inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the citizen inquiry
	* @return the citizen inquiry that was removed
	* @throws PortalException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry deleteCitizenInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.deleteCitizenInquiry(inquiryId);
	}

	/**
	* Deletes the citizen inquiry from the database. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiry the citizen inquiry
	* @return the citizen inquiry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry deleteCitizenInquiry(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.deleteCitizenInquiry(citizenInquiry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _citizenInquiryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchCitizenInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.fetchCitizenInquiry(inquiryId);
	}

	/**
	* Returns the citizen inquiry with the primary key.
	*
	* @param inquiryId the primary key of the citizen inquiry
	* @return the citizen inquiry
	* @throws PortalException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry getCitizenInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getCitizenInquiry(inquiryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the citizen inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> getCitizenInquiries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getCitizenInquiries(start, end);
	}

	/**
	* Returns the number of citizen inquiries.
	*
	* @return the number of citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int getCitizenInquiriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getCitizenInquiriesCount();
	}

	/**
	* Updates the citizen inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiry the citizen inquiry
	* @return the citizen inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry updateCitizenInquiry(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.updateCitizenInquiry(citizenInquiry);
	}

	/**
	* Updates the citizen inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiry the citizen inquiry
	* @param merge whether to merge the citizen inquiry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the citizen inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry updateCitizenInquiry(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.updateCitizenInquiry(citizenInquiry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _citizenInquiryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_citizenInquiryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _citizenInquiryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> getGroupInquiries(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getGroupInquiries(groupId);
	}

	public int countCategoryInquiries(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.countCategoryInquiries(categoryId);
	}

	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> getCategoryInquiries(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryLocalService.getCategoryInquiries(categoryId);
	}

	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, boolean allInquiry,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _citizenInquiryLocalService.findByKeyword(groupId, categoryId,
			keyword, start, end, allInquiry, obc);
	}

	public void addInquiry(long companyId, long groupId, long userId,
		java.lang.String userName, long categoryId,
		java.lang.String citizenName, java.lang.String citizenPhone,
		java.lang.String citizenEmail, java.lang.String citizenAddress,
		java.lang.String inquiryTitle, java.lang.String inquiryContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryLocalService.addInquiry(companyId, groupId, userId,
			userName, categoryId, citizenName, citizenPhone, citizenEmail,
			citizenAddress, inquiryTitle, inquiryContent, serviceContext);
	}

	public void updateInquiry(long inquiryId, long companyId, long groupId,
		long userId, java.lang.String userName, long categoryId,
		java.lang.String citizenName, java.lang.String citizenPhone,
		java.lang.String citizenEmail, java.lang.String citizenAddress,
		java.lang.String inquiryTitle, java.lang.String inquiryContent,
		java.lang.String inquiryFeedback, java.lang.String inquiryFeedbackUser,
		java.util.Date inquiryFeedbackDate, boolean approved,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryLocalService.updateInquiry(inquiryId, companyId,
			groupId, userId, userName, categoryId, citizenName, citizenPhone,
			citizenEmail, citizenAddress, inquiryTitle, inquiryContent,
			inquiryFeedback, inquiryFeedbackUser, inquiryFeedbackDate,
			approved, serviceContext);
	}

	public void updateInquiryFeedbackContent(long inquiryId,
		java.lang.String feedbackContent, java.lang.String feedbackUserName,
		java.util.Date feedbackDate, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryLocalService.updateInquiryFeedbackContent(inquiryId,
			feedbackContent, feedbackUserName, feedbackDate, approved);
	}

	public void updateInquiryApprovedStatus(long inquiryId,
		boolean approvedStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryLocalService.updateInquiryApprovedStatus(inquiryId,
			approvedStatus);
	}

	public void deleteInquiry(long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryLocalService.deleteInquiry(inquiryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CitizenInquiryLocalService getWrappedCitizenInquiryLocalService() {
		return _citizenInquiryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCitizenInquiryLocalService(
		CitizenInquiryLocalService citizenInquiryLocalService) {
		_citizenInquiryLocalService = citizenInquiryLocalService;
	}

	public CitizenInquiryLocalService getWrappedService() {
		return _citizenInquiryLocalService;
	}

	public void setWrappedService(
		CitizenInquiryLocalService citizenInquiryLocalService) {
		_citizenInquiryLocalService = citizenInquiryLocalService;
	}

	private CitizenInquiryLocalService _citizenInquiryLocalService;
}