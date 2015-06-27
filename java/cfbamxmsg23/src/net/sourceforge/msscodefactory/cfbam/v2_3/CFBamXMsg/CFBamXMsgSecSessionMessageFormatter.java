
// Description: Java 7 XML Message message formatter for CFBam.SecSession

/*
 *	CFBam
 *
 *	Copyright (c) 2014-2015 Mark Sobkow
 *	
 *	This program is available as free software under the GNU GPL v3, under
 *	the Eclipse Public License 1.0, or under a commercial license from Mark
 *	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
 *	
 *	You should have received copies of the complete license text for
 *	GPLv3.txt and EPLv1_0.txt, containing the text
 *	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
 *	
 *	Under the terms of the GPL:
 *	
 *		This program is free software: you can redistribute it and/or modify
 *		it under the terms of the GNU General Public License as published by
 *		the Free Software Foundation, either version 3 of the License, or
 *		(at your option) any later version.
 *	  
 *		This program is distributed in the hope that it will be useful,
 *		but WITHOUT ANY WARRANTY; without even the implied warranty of
 *		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *		GNU General Public License for more details.
 *	  
 *		You should have received a copy of the GNU General Public License
 *		along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	
 *	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
 *	and licensed under the BSD 3-Clause license as written by xfree86.org:
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are
 *	met:
 *	
 *	    (1) Redistributions of source code must retain the above copyright
 *	    notice, this list of conditions and the following disclaimer. 
 *	
 *	    (2) Redistributions in binary form must reproduce the above copyright
 *	    notice, this list of conditions and the following disclaimer in
 *	    the documentation and/or other materials provided with the
 *	    distribution.  
 *	    
 *	    (3)The name of the author may not be used to
 *	    endorse or promote products derived from this software without
 *	    specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
 *	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 *	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 *	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 *	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *	POSSIBILITY OF SUCH DAMAGE.
 *	
 * ***********************************************************************
 *
 *	Code manufactured by MSS Code Factory
 */


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/*
 *	CFBamXMsgSecSessionMessageFormatter XML message formatter
 *	for CFBam.SecSession.
 */
public class CFBamXMsgSecSessionMessageFormatter
{
	public CFBamXMsgSecSessionMessageFormatter() {
	}

	public static String formatSecSessionPKeyAttributes( String separator, CFBamSecSessionPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredUuid( null,
				"SecSessionId",
				pkey.getRequiredSecSessionId() );
		return( retval );
	}

	public static String formatSecSessionPKeyAttributes( String separator, CFBamSecSessionBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredUuid( separator,
					"SecSessionId",
					buff.getRequiredSecSessionId() );
		return( retval );
	}

	public static String formatSecSessionBuffAttributes( String separator, CFBamSecSessionBuff buff ) {
		String retval = CFBamXMsgSecSessionMessageFormatter.formatSecSessionPKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					buff.getRequiredSecUserId() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"SecDevName",
					buff.getOptionalSecDevName() )
			+	CFLibXmlUtil.formatRequiredTimestamp( separator,
					"Start",
					buff.getRequiredStart() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"Finish",
					buff.getOptionalFinish() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"SecProxyId",
					buff.getOptionalSecProxyId() );
		return( retval );
	}

	public static String formatSecSessionRqstCreate( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RqstSecSessionCreate "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstRead( String separator, CFBamSecSessionPKey pkey ) {
		String retval = "<RqstSecSessionRead "
			+	formatSecSessionPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstRead( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RqstSecSessionRead "
			+	formatSecSessionPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstRead( String separator,
		UUID argSecSessionId )
	{
		String retval = "<RqstSecSessionRead "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecSessionId",
					argSecSessionId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadAll( String separator ) {
		String retval = "<RqstSecSessionReadAll />";
		return( retval );
	}

	public static String formatSecSessionRqstReadByIdIdx( String separator,
		UUID argSecSessionId )
	{
		String retval = "<RqstSecSessionRead "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecSessionId",
					argSecSessionId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadBySecUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstSecSessionReadBySecUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadBySecDevIdx( String separator,
		UUID argSecUserId,
		String argSecDevName )
	{
		String retval = "<RqstSecSessionReadBySecDevIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"SecDevName",
					argSecDevName )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadByStartIdx( String separator,
		UUID argSecUserId,
		Calendar argStart )
	{
		String retval = "<RqstSecSessionReadByStartIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatRequiredTimestamp( separator,
					"Start",
					argStart )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadByFinishIdx( String separator,
		UUID argSecUserId,
		Calendar argFinish )
	{
		String retval = "<RqstSecSessionReadByFinishIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"Finish",
					argFinish )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstReadBySecProxyIdx( String separator,
		UUID argSecProxyId )
	{
		String retval = "<RqstSecSessionReadBySecProxyIdx "
			+	CFLibXmlUtil.formatOptionalUuid( null,
					"SecProxyId",
					argSecProxyId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstLock( String separator, CFBamSecSessionPKey pkey ) {
		String retval = "<RqstSecSessionLock "
			+	formatSecSessionPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstLock( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RqstSecSessionLock "
			+	formatSecSessionPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstLock( String separator,
		UUID argSecSessionId )
	{
		String retval = "<RqstSecSessionLock "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecSessionId",
					argSecSessionId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstUpdate( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RqstSecSessionUpdate "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDelete( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RqstSecSessionDelete "
				+	formatSecSessionPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteByIdIdx( String separator,
		UUID argSecSessionId )
	{
		String retval = "<RqstSecSessionDelete "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecSessionId",
					argSecSessionId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteBySecUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstSecSessionDeleteBySecUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteBySecDevIdx( String separator,
		UUID argSecUserId,
		String argSecDevName )
	{
		String retval = "<RqstSecSessionDeleteBySecDevIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"SecDevName",
					argSecDevName )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteByStartIdx( String separator,
		UUID argSecUserId,
		Calendar argStart )
	{
		String retval = "<RqstSecSessionDeleteByStartIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatRequiredTimestamp( separator,
					"Start",
					argStart )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteByFinishIdx( String separator,
		UUID argSecUserId,
		Calendar argFinish )
	{
		String retval = "<RqstSecSessionDeleteByFinishIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"Finish",
					argFinish )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRqstDeleteBySecProxyIdx( String separator,
		UUID argSecProxyId )
	{
		String retval = "<RqstSecSessionDeleteBySecProxyIdx "
			+	CFLibXmlUtil.formatOptionalUuid( null,
					"SecProxyId",
					argSecProxyId )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRspnSingleOpenTag() {
		final String retval = "<RspnSecSessionReadSingle>";
		return( retval );
	}

	public static String formatSecSessionRspnSingleCloseTag() {
		final String retval = "</RspnSecSessionReadSingle>";
		return( retval );
	}

	public static String formatSecSessionRspnListOpenTag() {
		final String retval = "<RspnSecSessionReadList>";
		return( retval );
	}

	public static String formatSecSessionRspnListCloseTag() {
		final String retval = "</RspnSecSessionReadList>";
		return( retval );
	}

	public static String formatSecSessionRspnRec( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<SecSession "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRspnDerivedRec( String separator, CFBamSecSessionBuff buff ) {
		String retval;
		retval = formatSecSessionRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecSessionRspnCreated( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RspnSecSessionCreated "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRspnLocked( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RspnSecSessionLocked "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRspnUpdated( String separator, CFBamSecSessionBuff buff ) {
		String retval = "<RspnSecSessionUpdated "
			+	formatSecSessionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecSessionRspnDeleted() {
		String retval = "<RspnSecSessionDeleted />";
		return( retval );
	}
}
