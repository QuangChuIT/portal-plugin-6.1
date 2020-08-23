<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<div class="contact-vungtau-container">
	<ul class="group-contact">
		<li class="contact-item"><liferay-ui:message key="hotline"/></li>
		<li class="contact-item">
			<span class="label"><liferay-ui:message key="enterprise-key"/> : </span><span class="value-text">&nbsp;<%=enterprisePhone %></span>
		</li>
		<li class="contact-item">
			<span class="label"><liferay-ui:message key="citizen-key"/> : </span><span class="value-text">&nbsp;<%=citizenPhone %></span>
		</li>
		<div style="clear: both;"></div>
	</ul>
</div>