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

	.flag-selector{
		display: none !important;	
	}
</style>

<%@ include file="/html/portlet/layouts_admin/init.jsp" %>

<%@ include file="/html/portlet/layouts_admin/init_attributes.jspf" %>

<%
SitesUtil.addPortletBreadcrumbEntries(group, pagesName, redirectURL, request, renderResponse);
%>

<liferay-ui:error exception="<%= LayoutTypeException.class %>">

	<%
	LayoutTypeException lte = (LayoutTypeException)errorException;

	String type = BeanParamUtil.getString(selLayout, request, "type");
	%>

	<c:if test="<%= lte.getType() == LayoutTypeException.FIRST_LAYOUT %>">
		<liferay-ui:message arguments='<%= Validator.isNull(lte.getLayoutType()) ? type : "layout.types." + lte.getLayoutType() %>' key="the-first-page-cannot-be-of-type-x" />
	</c:if>

	<c:if test="<%= lte.getType() == LayoutTypeException.NOT_PARENTABLE %>">
		<liferay-ui:message arguments="<%= type %>" key="pages-of-type-x-cannot-have-child-pages" />
	</c:if>
</liferay-ui:error>

<liferay-ui:error exception="<%= LayoutNameException.class %>" message="please-enter-a-valid-name" />

<liferay-ui:error exception="<%= RequiredLayoutException.class %>">

	<%
	RequiredLayoutException rle = (RequiredLayoutException)errorException;
	%>

	<c:if test="<%= rle.getType() == RequiredLayoutException.AT_LEAST_ONE %>">
		<liferay-ui:message key="you-must-have-at-least-one-page" />
	</c:if>
</liferay-ui:error>

<aui:layout cssClass="manage-view lfr-app-column-view">
	<c:if test="<%= !group.isLayoutPrototype() %>">
		<aui:column columnWidth="25" cssClass="manage-sitemap">
			<div class="lfr-header-row">
				<div class="lfr-header-row-content">
					<c:if test="<%= stagingGroup != null %>">

						<%
						long layoutSetBranchId = ParamUtil.getLong(request, "layoutSetBranchId");

						if (layoutSetBranchId <= 0) {
							layoutSetBranchId = StagingUtil.getRecentLayoutSetBranchId(user, selLayoutSet.getLayoutSetId());
						}

						LayoutSetBranch layoutSetBranch = null;

						if (layoutSetBranchId > 0) {
							try {
								layoutSetBranch = LayoutSetBranchLocalServiceUtil.getLayoutSetBranch(layoutSetBranchId);
							}
							catch (NoSuchLayoutSetBranchException nslsbe) {
							}
						}

						if (layoutSetBranch == null) {
							try {
								layoutSetBranch = LayoutSetBranchLocalServiceUtil.getMasterLayoutSetBranch(stagingGroup.getGroupId(), privateLayout);
							}
							catch (NoSuchLayoutSetBranchException nslsbe) {
							}
						}

						List<LayoutSetBranch> layoutSetBranches = LayoutSetBranchLocalServiceUtil.getLayoutSetBranches(stagingGroup.getGroupId(), privateLayout);
						%>

						<c:choose>
							<c:when test="<%= layoutSetBranches.size() > 1 %>">
								<liferay-ui:icon-menu align="left" cssClass="layoutset-branches-menu" direction="down" extended="<%= true %>" icon='<%= themeDisplay.getPathThemeImages() + "/dock/staging.png" %>' message="<%= HtmlUtil.escape(layoutSetBranch.getName()) %>">

									<%
									for (int i = 0; i < layoutSetBranches.size(); i++) {
										LayoutSetBranch curLayoutSetBranch = layoutSetBranches.get(i);

										boolean selected = (curLayoutSetBranch.getLayoutSetBranchId() == layoutSetBranch.getLayoutSetBranchId());
									%>

										<portlet:actionURL var="layoutSetBranchURL">
											<portlet:param name="struts_action" value="/dockbar/edit_layouts" />
											<portlet:param name="<%= Constants.CMD %>" value="select_layout_set_branch" />
											<portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
											<portlet:param name="groupId" value="<%= String.valueOf(curLayoutSetBranch.getGroupId()) %>" />
											<portlet:param name="privateLayout" value="<%= String.valueOf(privateLayout) %>" />
											<portlet:param name="layoutSetBranchId" value="<%= String.valueOf(curLayoutSetBranch.getLayoutSetBranchId()) %>" />
										</portlet:actionURL>

										<liferay-ui:icon
											cssClass='<%= selected ? "disabled" : StringPool.BLANK %>'
											image='<%= selected ? "../arrows/01_right" : "copy"  %>'
											message="<%= HtmlUtil.escape(curLayoutSetBranch.getName()) %>"
											url="<%= selected ? null : layoutSetBranchURL %>"
										/>

									<%
									}
									%>

								</liferay-ui:icon-menu>
							</c:when>
							<c:otherwise>
								<liferay-ui:icon
									cssClass="layoutset-branch"
									image="../dock/staging"
									label="<%= true %>"
									message='<%= (layoutSetBranch == null || (layoutSetBranches.size() == 1)) ? "staging" : HtmlUtil.escape(layoutSetBranch.getName()) %>'
								/>
							</c:otherwise>
						</c:choose>

						<liferay-ui:staging cssClass="manage-pages-branch-menu" extended="<%= true %>" groupId="<%= groupId %>" icon="/common/tool.png" message="" privateLayout="<%= privateLayout %>" selPlid="<%= selPlid %>" showManageBranches="<%= true %>"  />
					</c:if>
				</div>
			</div>

			<liferay-util:include page="/html/portlet/layouts_admin/tree_js.jsp">
				<liferay-util:param name="treeId" value="layoutsTree" />
			</liferay-util:include>
		</aui:column>
	</c:if>

	<aui:column columnWidth="<%= group.isLayoutPrototype() ? 100 : 75 %>" cssClass="manage-layout">
		<div id="<portlet:namespace />layoutsContainer">
			<c:choose>
				<c:when test="<%= selPlid > 0 %>">
					<liferay-util:include page="/html/portlet/layouts_admin/edit_layout.jsp" />
				</c:when>
				<c:otherwise>
					<liferay-util:include page="/html/portlet/layouts_admin/edit_layout_set.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
	</aui:column>
</aui:layout>

<c:if test="<%= !group.isLayoutPrototype() %>">
	<aui:script use="aui-io-plugin">
		var layoutsContainer = A.one('#<portlet:namespace />layoutsContainer');

		layoutsContainer.plug(
			A.Plugin.IO,
			{
				autoLoad: false
			}
		);

		A.one('#<portlet:namespace />layoutsTreeOutput').delegate(
			'click',
			function(event) {
				event.preventDefault();

				var hash = location.hash;

				var prefix = '#_LFR_FN_<portlet:namespace />';
				var historyKey = '';

				if (hash.indexOf(prefix) != -1) {
					historyKey = hash.replace(prefix, '');
				}

				var requestUri = A.Lang.sub(
					event.currentTarget.get('href'),
					{
						historyKey: historyKey
					}
				);

				layoutsContainer.io.set('uri', requestUri);

				if (layoutsContainer.ParseContent) {
					layoutsContainer.ParseContent.get('queue').stop();
				}

				layoutsContainer.io.start();
			},
			'.layout-tree'
		);
	</aui:script>
</c:if>