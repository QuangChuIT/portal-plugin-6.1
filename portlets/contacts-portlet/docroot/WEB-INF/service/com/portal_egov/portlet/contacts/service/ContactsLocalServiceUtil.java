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

package com.portal_egov.portlet.contacts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the contacts local service. This utility wraps {@link com.portal_egov.portlet.contacts.service.impl.ContactsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see ContactsLocalService
 * @see com.portal_egov.portlet.contacts.service.base.ContactsLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsLocalServiceImpl
 * @generated
 */
public class ContactsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contacts to the database. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts addContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContacts(contacts);
	}

	/**
	* Creates a new contacts with the primary key. Does not add the contacts to the database.
	*
	* @param contactId the primary key for the new contacts
	* @return the new contacts
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts createContacts(
		long contactId) {
		return getService().createContacts(contactId);
	}

	/**
	* Deletes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts that was removed
	* @throws PortalException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts deleteContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContacts(contactId);
	}

	/**
	* Deletes the contacts from the database. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts deleteContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContacts(contacts);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.contacts.model.Contacts fetchContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContacts(contactId);
	}

	/**
	* Returns the contacts with the primary key.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts
	* @throws PortalException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts getContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContacts(contactId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> getContactses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactses(start, end);
	}

	/**
	* Returns the number of contactses.
	*
	* @return the number of contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsesCount();
	}

	/**
	* Updates the contacts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts updateContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContacts(contacts);
	}

	/**
	* Updates the contacts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @param merge whether to merge the contacts with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts updateContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContacts(contacts, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByCompanyAndStatus(long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompanyAndStatus(companyId, contactStatus);
	}

	public static int countByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupAndStatus(groupId, contactStatus);
	}

	public static int countByDepartmentAndCompany(long companyId,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDepartmentAndCompany(companyId, departmentId);
	}

	public static int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDepartmentAndGroup(groupId, departmentId);
	}

	public static int countByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus);
	}

	public static int countByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndCompany(companyId, departmentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndCompany(companyId, departmentId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndGroup(groupId, departmentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndGroup(groupId, departmentId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeyword(
		long groupId, java.lang.String keyword, int contactStatus, int start,
		int end) {
		return getService()
				   .findByKeyword(groupId, keyword, contactStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeywordAndDepartment(
		long groupId, long departmentId, java.lang.String keyword,
		int contactStatus, int start, int end) {
		return getService()
				   .findByKeywordAndDepartment(groupId, departmentId, keyword,
			contactStatus, start, end);
	}

	public static com.portal_egov.portlet.contacts.model.Contacts addContact(
		long groupId, long companyId, long userId, java.lang.String userName,
		long departmentId, java.lang.String contactName, long avatarImageId,
		java.lang.String jobTitle, java.lang.String phoneNumbers,
		java.lang.String homePhone, java.lang.String mobile,
		java.lang.String email, int displayPriority, int contactStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContact(groupId, companyId, userId, userName,
			departmentId, contactName, avatarImageId, jobTitle, phoneNumbers,
			homePhone, mobile, email, displayPriority, contactStatus,
			serviceContext);
	}

	public static com.portal_egov.portlet.contacts.model.Contacts updateContact(
		long contactId, long groupId, long companyId, long userId,
		java.lang.String userName, long departmentId,
		java.lang.String contactName, long avatarImageId,
		java.lang.String jobTitle, java.lang.String phoneNumbers,
		java.lang.String homePhone, java.lang.String mobile,
		java.lang.String email, int displayPriority, int contactStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContact(contactId, groupId, companyId, userId,
			userName, departmentId, contactName, avatarImageId, jobTitle,
			phoneNumbers, homePhone, mobile, email, displayPriority,
			contactStatus);
	}

	public static void updateContactState(long contactId, int displayPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateContactState(contactId, displayPriority);
	}

	public static void updateContactDepartment(long contactId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateContactDepartment(contactId, departmentId);
	}

	public static void deleteContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		getService().deleteContact(contactId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactsLocalService.class.getName());

			if (invokableLocalService instanceof ContactsLocalService) {
				_service = (ContactsLocalService)invokableLocalService;
			}
			else {
				_service = new ContactsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ContactsLocalService service) {
	}

	private static ContactsLocalService _service;
}