<%--
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
--%>

<style type="text/css">
	.tag-view-container .taglib-header {
		border-bottom: 1px solid #e4e4e4;
	}
</style>

<%@ include file="/html/portlet/asset_tag_admin/init.jsp" %>

<%
long tagId = ParamUtil.getLong(request, "tagId");

AssetTag tag = AssetTagServiceUtil.getTag(tagId);

List<AssetTagProperty> tagProperties = AssetTagPropertyServiceUtil.getTagProperties(tag.getTagId());
%>

<div class="view-tag">
	<liferay-ui:header
		localizeTitle="<%= false %>"
		title="<%= tag.getName() %>"
	/>

	<c:if test="<%= tag != null %>">
		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetTag.class.getName(), tag.getTagId(), ActionKeys.UPDATE) %>">
			<aui:button id="editTagButton" value="edit" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetTag.class.getName(), tag.getTagId(), ActionKeys.DELETE) %>">
			<aui:button id="deleteTagButton" value="delete" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetTag.class.getName(), tag.getTagId(), ActionKeys.PERMISSIONS) %>">
			<liferay-security:permissionsURL
				modelResource="<%= AssetTag.class.getName() %>"
				modelResourceDescription="<%= tag.getName() %>"
				resourcePrimKey="<%= String.valueOf(tag.getTagId()) %>"
				var="permissionsURL"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			/>

			<aui:button data-url="<%= permissionsURL %>" id="updateTagPermissions" value="permissions" />
		</c:if>
	</c:if>

	<div class="tag-field">
		<c:choose>
			<c:when test="<%= tag.getAssetCount() > 0 %>">
				<liferay-ui:message key="used-in-x-assets" arguments="<%= tag.getAssetCount() %>" />
			</c:when>
			<c:otherwise>
				<div class="portlet-msg-info">
					<liferay-ui:message key="this-tag-is-not-used" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<c:if test="<%= !tagProperties.isEmpty() %>">
		<div class="tag-field">
			<label><liferay-ui:message key="properties" />:</label>

			<%
			for (AssetTagProperty tagProperty : tagProperties) {
			%>

				<span class="property-key"><%= tagProperty.getKey() %></span>: <span class="property-value"><%= tagProperty.getValue() %></span><br />

			<%
			}
			%>

		</div>
	</c:if>
</div>