/** @author anhbdb
 * 
 */

package com.bkav.portal.portlet.audioplayer.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;


public class AlbumPermission {
	public static final String VIEW = "VIEW";
	public static final String ADD = "ADD";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, AudioAlbum album, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, album, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, AudioAlbum album, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(album.getGroupId(), AudioAlbum.class.getName(), album.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, AudioAlbum.class.getName(), groupId, actionId);
	}
}
