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

package com.portal_egov.portlet.tthc.service.base;

import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class TTHC_AttributeLocalServiceClpInvoker {
	public TTHC_AttributeLocalServiceClpInvoker() {
		_methodName0 = "addTTHC_Attribute";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.tthc.model.TTHC_Attribute"
			};

		_methodName1 = "createTTHC_Attribute";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTTHC_Attribute";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTTHC_Attribute";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.tthc.model.TTHC_Attribute"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchTTHC_Attribute";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getTTHC_Attribute";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getTTHC_Attributes";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getTTHC_AttributesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateTTHC_Attribute";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.tthc.model.TTHC_Attribute"
			};

		_methodName15 = "updateTTHC_Attribute";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.tthc.model.TTHC_Attribute", "boolean"
			};

		_methodName54 = "getBeanIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "setBeanIdentifier";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName60 = "countAll";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "findByTTHCEntryAndCompany";

		_methodParameterTypes61 = new String[] { "long", "long" };

		_methodName62 = "findByTTHCEntryAndCompany";

		_methodParameterTypes62 = new String[] { "long", "long", "int", "int" };

		_methodName63 = "findByTTHCEntryAndGroup";

		_methodParameterTypes63 = new String[] { "long", "long" };

		_methodName64 = "findByTTHCEntryAndGroup";

		_methodParameterTypes64 = new String[] { "long", "long", "int", "int" };

		_methodName65 = "findByTTHCEntryAndAttrTypeAndCompany";

		_methodParameterTypes65 = new String[] { "long", "long", "int" };

		_methodName66 = "findByTTHCEntryAndAttrTypeAndCompany";

		_methodParameterTypes66 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName67 = "findByTTHCEntryAndAttrTypeAndGroup";

		_methodParameterTypes67 = new String[] { "long", "long", "int" };

		_methodName68 = "findByTTHCEntryAndAttrTypeAndGroup";

		_methodParameterTypes68 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName69 = "addTTHCAttribute";

		_methodParameterTypes69 = new String[] {
				"long", "long", "long", "long", "int", "int", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName70 = "updateTTHCAttribute";

		_methodParameterTypes70 = new String[] {
				"long", "long", "long", "long", "long", "int", "int",
				"java.lang.String", "java.lang.String"
			};

		_methodName71 = "deleteTTHCAttribute";

		_methodParameterTypes71 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.addTTHC_Attribute((com.portal_egov.portlet.tthc.model.TTHC_Attribute)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.createTTHC_Attribute(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.deleteTTHC_Attribute(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.deleteTTHC_Attribute((com.portal_egov.portlet.tthc.model.TTHC_Attribute)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.fetchTTHC_Attribute(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.getTTHC_Attribute(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.getTTHC_Attributes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.getTTHC_AttributesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.updateTTHC_Attribute((com.portal_egov.portlet.tthc.model.TTHC_Attribute)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.updateTTHC_Attribute((com.portal_egov.portlet.tthc.model.TTHC_Attribute)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			TTHC_AttributeLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.countAll();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.addTTHCAttribute(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return TTHC_AttributeLocalServiceUtil.updateTTHCAttribute(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			TTHC_AttributeLocalServiceUtil.deleteTTHCAttribute(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
}