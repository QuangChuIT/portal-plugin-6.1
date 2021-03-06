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

package com.portal_egov.portlet.vbpq.service.base;

import com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class VBPQ_DlFileEntriesLocalServiceClpInvoker {
	public VBPQ_DlFileEntriesLocalServiceClpInvoker() {
		_methodName0 = "addVBPQ_DlFileEntries";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries"
			};

		_methodName1 = "createVBPQ_DlFileEntries";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVBPQ_DlFileEntries";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVBPQ_DlFileEntries";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries"
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

		_methodName9 = "fetchVBPQ_DlFileEntries";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getVBPQ_DlFileEntries";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getVBPQ_DlFileEntrieses";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getVBPQ_DlFileEntriesesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateVBPQ_DlFileEntries";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries"
			};

		_methodName15 = "updateVBPQ_DlFileEntries";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries",
				"boolean"
			};

		_methodName54 = "getBeanIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "setBeanIdentifier";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName60 = "countByVBPQEntry";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "findByVBPQEntry";

		_methodParameterTypes61 = new String[] { "long" };

		_methodName62 = "findByDLFileEntry";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "updateMapping";

		_methodParameterTypes63 = new String[] { "long", "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.addVBPQ_DlFileEntries((com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.createVBPQ_DlFileEntries(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.deleteVBPQ_DlFileEntries(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.deleteVBPQ_DlFileEntries((com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.fetchVBPQ_DlFileEntries(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.getVBPQ_DlFileEntries(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.getVBPQ_DlFileEntrieses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.getVBPQ_DlFileEntriesesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.updateVBPQ_DlFileEntries((com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.updateVBPQ_DlFileEntries((com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			VBPQ_DlFileEntriesLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.countByVBPQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.findByVBPQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return VBPQ_DlFileEntriesLocalServiceUtil.findByDLFileEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			VBPQ_DlFileEntriesLocalServiceUtil.updateMapping(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
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
}