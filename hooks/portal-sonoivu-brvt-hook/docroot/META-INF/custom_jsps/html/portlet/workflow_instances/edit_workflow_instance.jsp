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
	.lfr-workflow-state{
		font-size: 14px;
		font-weight: bold;
		color: #bc0000;
		text-shadow: 1px 1px white;
	}
</style>

<%@ include file="/html/portlet/workflow_instances/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

WorkflowInstance workflowInstance = (WorkflowInstance)request.getAttribute(WebKeys.WORKFLOW_INSTANCE);

Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();

long companyId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
long groupId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_GROUP_ID));
String className = (String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME);
long classPK = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil.getWorkflowHandler(className);

AssetRenderer assetRenderer = workflowHandler.getAssetRenderer(classPK);
AssetRendererFactory assetRendererFactory = workflowHandler.getAssetRendererFactory();

AssetEntry assetEntry = null;

if (assetRenderer != null) {
	assetEntry = assetRendererFactory.getAssetEntry(assetRendererFactory.getClassName(), assetRenderer.getClassPK());
}

String headerTitle = "";

if (assetEntry != null) {
	headerTitle = headerTitle.concat(assetRenderer.getTitle(locale));
}

PortletURL viewFullContentURL = renderResponse.createRenderURL();

viewFullContentURL.setParameter("struts_action", "/workflow_tasks/view_content");
viewFullContentURL.setParameter("redirect", currentURL);
viewFullContentURL.setParameter("type", assetRendererFactory.getType());

if (assetEntry != null) {
	viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
	viewFullContentURL.setParameter("assetEntryVersionId", String.valueOf(classPK));
}

viewFullContentURL.setParameter("showEditURL", Boolean.FALSE.toString());
viewFullContentURL.setParameter("workflowAssetPreview", Boolean.TRUE.toString());

request.setAttribute(WebKeys.WORKFLOW_ASSET_PREVIEW, Boolean.TRUE);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="struts_action" value="/workflow_instances/view" />
</portlet:renderURL>

<liferay-ui:header
	backURL="<%= backURL.toString() %>"
	localizeTitle="<%= false %>"
	title="<%= headerTitle %>"
/>

<aui:layout>
	<aui:column columnWidth="<%= 75 %>" cssClass="lfr-asset-column lfr-asset-column-details" first="<%= true %>">
		<aui:layout>
			<aui:column columnWidth="60">
				<div class="lfr-asset-status">
					<aui:field-wrapper label="workflow-asset-state">
						<%= LanguageUtil.get(pageContext, workflowInstance.getState()) %>
					</aui:field-wrapper>
				</div>
			</aui:column>

			<aui:column>
				<div class="lfr-asset-date">
					<aui:field-wrapper label="workflow-end-date">
						<%= (workflowInstance.getEndDate() == null) ? LanguageUtil.get(pageContext, "never") : dateFormatDateTime.format(workflowInstance.getEndDate()) %>
					</aui:field-wrapper>
				</div>
			</aui:column>
		</aui:layout>

		<liferay-ui:panel-container cssClass="task-panel-container" id="preview" extended="<%= true %>">

			<c:if test="<%= assetRenderer != null %>">
				<liferay-ui:panel defaultState="open" title="workflow-asset-summary-content">

					<h3 class="task-content-title">
						<img src="<%= workflowHandler.getIconPath(liferayPortletRequest) %>" alt="" /> <%= HtmlUtil.escape(workflowHandler.getTitle(classPK, locale)) %>
					</h3>

					<%
					String path = workflowHandler.render(classPK, renderRequest, renderResponse, AssetRenderer.TEMPLATE_ABSTRACT);

					request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
					request.setAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH, 200);
					%>

					<c:choose>
						<c:when test="<%= path == null %>">
							<%= workflowHandler.getSummary(classPK, locale) %>
						</c:when>
						<c:otherwise>
							<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>" />
						</c:otherwise>
					</c:choose>

					<%
					String selectionStyle = "manual";

					String[] metadataFields = new String[] {"author", "categories", "tags"};
					%>

					<div class="asset-metadata">
						<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
					</div>
				</liferay-ui:panel>
			</c:if>

			<%
			List<WorkflowTask> workflowTasks = null;

			if (portletName.equals(PortletKeys.WORKFLOW_DEFINITIONS)) {
				workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(company.getCompanyId(), null, workflowInstance.getWorkflowInstanceId(), null, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			}
			else {
				workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(company.getCompanyId(), user.getUserId(), workflowInstance.getWorkflowInstanceId(), false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			}
			%>

			<c:if test="<%= !workflowTasks.isEmpty() %>">
				<liferay-ui:panel defaultState="open" title="workflow-tasks">

					<%
					PortletURL portletURL = renderResponse.createRenderURL();
					%>

					<liferay-ui:search-container
						emptyResultsMessage="there-are-no-workflow-tasks"
						iteratorURL="<%= portletURL %>"
					>
						<liferay-ui:search-container-results
							results="<%= workflowTasks %>"
						/>

						<liferay-ui:search-container-row
							className="com.liferay.portal.kernel.workflow.WorkflowTask"
							modelVar="workflowTask"
							stringKey="<%= true %>"
						>
							<liferay-ui:search-container-row-parameter
								name="workflowTask"
								value="<%= workflowTask %>"
							/>

							<liferay-ui:search-container-column-text
								buffer="buffer"
								name="task"
							>

								<%
								buffer.append("<span class=\"task-name\" id=\"");
								buffer.append(workflowTask.getWorkflowTaskId());
								buffer.append("\">");
								buffer.append(LanguageUtil.get(pageContext, workflowTask.getName()));
								buffer.append("</span>");
								%>

							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								buffer="buffer"
								name="due-date"
							>

								<%
								if (workflowTask.getDueDate() == null) {
									buffer.append(LanguageUtil.get(pageContext, "never"));
								}
								else {
									buffer.append(dateFormatDateTime.format(workflowTask.getDueDate()));
								}
								%>

							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								name="completed"
								value='<%= workflowTask.isCompleted() ? LanguageUtil.get(pageContext, "yes") : LanguageUtil.get(pageContext, "no") %>'
							/>

							<liferay-ui:search-container-column-jsp
								align="right"
								path="/html/portlet/workflow_instances/workflow_task_action.jsp"
							/>
						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator />
					</liferay-ui:search-container>
				</liferay-ui:panel>
			</c:if>

			<liferay-ui:panel defaultState="open" title="workflow-activities">

				<%
				List<Integer> logTypes = new ArrayList<Integer>();

				logTypes.add(WorkflowLog.TASK_ASSIGN);
				logTypes.add(WorkflowLog.TASK_COMPLETION);
				logTypes.add(WorkflowLog.TASK_UPDATE);
				logTypes.add(WorkflowLog.TRANSITION);

				List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), workflowInstance.getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
				%>

				<%@ include file="/html/portlet/workflow_instances/workflow_logs.jspf" %>
			</liferay-ui:panel>

		</liferay-ui:panel-container>
	</aui:column>

	<aui:column columnWidth="<%= 25 %>" cssClass="lfr-asset-column lfr-asset-column-actions" last="<%= true %>">
		<div class="lfr-asset-summary">
			<liferay-ui:icon
				cssClass="lfr-asset-avatar"
				image="../file_system/large/task"
				message="download"
			/>

			<div class="lfr-workflow-state">
				<%= LanguageUtil.get(pageContext, workflowInstance.getState()) %>
			</div>
		</div>

		<%
		request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		%>

		<liferay-util:include page="/html/portlet/workflow_instances/workflow_instance_action.jsp" />
	</aui:column>
</aui:layout>

<%
PortalUtil.addPortletBreadcrumbEntry(request, headerTitle, currentURL);
%>