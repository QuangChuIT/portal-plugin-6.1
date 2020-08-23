<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	long companyId = themeDisplay.getCompanyId();
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	String portletId = PortalUtil.getPortletId(request);
	
	long userId = PortalUtil.getUserId(request);
	
	User user = null;
	
	if(userId > 0){
		user = UserLocalServiceUtil.getUser(userId);
	}
	
	Locale locale = PortalUtil.getLocale(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Kieu hien thi
	String displayStyle = preferences.getValue("displayStyle", "default-display-style");
	
	//Pham vi thu tuc
	String tthcScope = preferences.getValue("tthcScope", StringPool.BLANK);
	
	long departmentScopeId = GetterUtil.getLong(preferences.getValue("departmentScopeId", "0"));
	
	long categoryScopeId = GetterUtil.getLong(preferences.getValue("categoryScopeId", "0"));
	
	long tthcLevelScopeId = GetterUtil.getLong(preferences.getValue("tthcLevelScopeId", "0"));
		
	//Linh vuc hien thi mac dinh
	long defaultCategoryId = GetterUtil.getLong(preferences.getValue("defaultCategoryId", "0"));
	
	//Id cua co quan thuc hien mac dinh
	long defaultDepartmentId = GetterUtil.getLong(preferences.getValue("defaultDepartmentId", "0"));
	
	//So luong tthc moi nhat hien thi trong giao dien mac dinh
	int numbersOfLastestEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfLastestEntriesDisplay", "6"));
		
	//So luong tthc moi nhat hien thi trong giao dien mac dinh
	int numbersOfEntriesDisplayOnSearchResultPage = GetterUtil.getInteger(preferences.getValue("numbersOfEntriesDisplayOnSearchResultPage", "6"));
	
	//Co hien thi form tim kiem thu tuc hay khong?
	boolean displayTTHCSearchForm = GetterUtil.getBoolean(preferences.getValue("displayTTHCSearchForm", "true"));
	
	//Co hien thi nhung thu tuc lien quan khi xem chi tiet noi dung van ban hay ko?(mac dinh la true)
	boolean displayTTHCRelatedEntries = GetterUtil.getBoolean(preferences.getValue("displayTTHCRelatedEntries", "true"));
	
	//Can cu de load danh sach thu tuc lien quan.Mac dinh la load theo Linh vuc thong ke cua thu tuc
	String relatedVBPQFilter = preferences.getValue("relatedVBPQFilter", "tthcCategory");
	
	//So luong thu tuc lien quan khi hien thi chi tiet noi dung van ban
	int numbersOfRelatedEntries = GetterUtil.getInteger(preferences.getValue("numbersOfRelatedEntries", "6"));
%>