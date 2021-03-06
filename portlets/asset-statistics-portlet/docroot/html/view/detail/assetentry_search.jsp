<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="/html/view/init.jsp"%>

<%
	long userId = ParamUtil.getLong(request, "userId");
	
	long categoryId = ParamUtil.getLong(request, "categoryId");	

	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<%
	int yearRange = 10;
	
	long selectedUserId = ParamUtil.getLong(request, "userId",0L);

	long selectedCategoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	boolean statisticByTimeRange = ParamUtil.getBoolean(request, "statisticByTimeRange",false);
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date currentDate = calendar.getTime();

	int fromDay = ParamUtil.getInteger(request, "fromDay",currentDate.getDate());
	int fromMonth = ParamUtil.getInteger(request, "fromMonth",currentDate.getMonth());
	int fromYear = ParamUtil.getInteger(request, "fromYear",currentDate.getYear() + 1900);

	int endDay = ParamUtil.getInteger(request, "endDay",currentDate.getDate());
	int endMonth = ParamUtil.getInteger(request, "endMonth",currentDate.getMonth());
	int endYear = ParamUtil.getInteger(request, "endYear",currentDate.getYear() + 1900);
	
	List<User> companyUsers = UserLocalServiceUtil.getCompanyUsers(companyId, 0, -1);
	
	List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
%>

<liferay-ui:search-toggle
	buttonLabel="Search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_student_search">
	
	<aui:input type="checkbox" name="statisticByTimeRange" value="<%=statisticByTimeRange%>" />
						
		<div id="<portlet:namespace/>statisticTimeRangeWrapper">
			<div class="form-row">
				<div><liferay-ui:message key="statistic-from-date"/>:</div>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />startDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=fromDay %>" dayParam="fromDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=fromMonth %>" monthParam="fromMonth" 
						yearValue="<%=fromYear  %>" yearParam="fromYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
			<div class="form-row">
				<span><liferay-ui:message key="statistic-to-date"/>:</span>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />endDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=endDay %>" dayParam="endDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=endMonth %>" monthParam="endMonth" 
						yearValue="<%=endYear%>" yearParam="endYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
		</div>
		
		<div>
			<select name="userId" label="user">	
				<aui:option label="all-user" value="0" selected="<%=selectedUserId == 0L %>"/>
				
				<%
				for(User user : companyUsers){
				%>
				<aui:option label="<%=user.getFullName() %>" value="<%=user.getUserId() %>" selected="<%=selectedUserId == user.getUserId() %>"/>
				<%
				}
				%>
			</select>
			
			<select name="categoryId" label="category">
				<aui:option label="all-category" value="0" selected="<%=selectedCategoryId == 0L %>"/>
				<%
				for(AssetVocabulary vocabulary : vocabularies){
					
					List<AssetCategory> rootCategoryList = 
									AssetCategoryLocalServiceUtil.getVocabularyRootCategories(vocabulary.getVocabularyId(), 0, -1, null);
				%>
					<optgroup label="<%=vocabulary.getName()%>">
					<%
					for(AssetCategory rootCategory : rootCategoryList){
					%>
						<aui:option value="<%=rootCategory.getCategoryId()%>" label="<%=rootCategory.getName() %>"
							selected="<%=rootCategory.getCategoryId() == selectedCategoryId%>"
							
						/>
					<%
						buildCategoryTreeSelector(groupId, rootCategory.getCategoryId(),selectedCategoryId, 1, out);
					}
					%>
					</optgroup>
				<%
				}
				%>
			</select>
		</div>

	<aui:script>
		Liferay.Util.toggleBoxes('<portlet:namespace />statisticByTimeRangeCheckbox','<portlet:namespace/>statisticTimeRangeWrapper');
	</aui:script>
	
</liferay-ui:search-toggle>