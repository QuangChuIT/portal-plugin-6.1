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

package com.bkav.portal.portlet.video.comparator;

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * @author HungDX
 *
 */
public class VideoUserNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "VideoEntry.userName ASC";

	public static final String ORDER_BY_DESC = "VideoEntry.userName DESC";

	public static final String[] ORDER_BY_FIELDS = {"userName"};

	public VideoUserNameComparator() {

		this(false);
	}

	public VideoUserNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		VideoEntry video1 = (VideoEntry) obj1;
		VideoEntry video2 = (VideoEntry) obj2;

		int value = video1.getUserName().toLowerCase().compareTo(video2.getUserName().toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}

	private boolean _ascending;

}