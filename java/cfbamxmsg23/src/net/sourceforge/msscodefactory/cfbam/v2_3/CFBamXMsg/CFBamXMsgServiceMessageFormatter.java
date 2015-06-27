
// Description: Java 7 XML Message message formatter for CFBam.Service

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
 *	CFBamXMsgServiceMessageFormatter XML message formatter
 *	for CFBam.Service.
 */
public class CFBamXMsgServiceMessageFormatter
{
	public CFBamXMsgServiceMessageFormatter() {
	}

	public static String formatServicePKeyAttributes( String separator, CFBamServicePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"ServiceId",
				pkey.getRequiredServiceId() );
		return( retval );
	}

	public static String formatServicePKeyAttributes( String separator, CFBamServiceBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServiceId",
					buff.getRequiredServiceId() );
		return( retval );
	}

	public static String formatServiceBuffAttributes( String separator, CFBamServiceBuff buff ) {
		String retval = CFBamXMsgServiceMessageFormatter.formatServicePKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"CreatedBy",
					buff.getCreatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"CreatedAt",
					buff.getCreatedAt() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"UpdatedBy",
					buff.getUpdatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"UpdatedAt",
					buff.getUpdatedAt() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					buff.getRequiredHostNodeId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"ServiceTypeId",
					buff.getRequiredServiceTypeId() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"HostPort",
					buff.getRequiredHostPort() );
		return( retval );
	}

	public static String formatServiceRqstCreate( String separator, CFBamServiceBuff buff ) {
		String retval = "<RqstServiceCreate "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstRead( String separator, CFBamServicePKey pkey ) {
		String retval = "<RqstServiceRead "
			+	formatServicePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstRead( String separator, CFBamServiceBuff buff ) {
		String retval = "<RqstServiceRead "
			+	formatServicePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstRead( String separator,
		long argClusterId,
		long argServiceId )
	{
		String retval = "<RqstServiceRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServiceId",
					argServiceId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadAll( String separator ) {
		String retval = "<RqstServiceReadAll />";
		return( retval );
	}

	public static String formatServiceRqstReadByIdIdx( String separator,
		long argClusterId,
		long argServiceId )
	{
		String retval = "<RqstServiceRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServiceId",
					argServiceId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstServiceReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadByHostIdx( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstServiceReadByHostIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadByTypeIdx( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceReadByTypeIdx "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadByUTypeIdx( String separator,
		long argClusterId,
		long argHostNodeId,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceReadByUTypeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstReadByUHostPortIdx( String separator,
		long argClusterId,
		long argHostNodeId,
		short argHostPort )
	{
		String retval = "<RqstServiceReadByUHostPortIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"HostPort",
					argHostPort )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstLock( String separator, CFBamServicePKey pkey ) {
		String retval = "<RqstServiceLock "
			+	formatServicePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstLock( String separator, CFBamServiceBuff buff ) {
		String retval = "<RqstServiceLock "
			+	formatServicePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstLock( String separator,
		long argClusterId,
		long argServiceId )
	{
		String retval = "<RqstServiceLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServiceId",
					argServiceId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstUpdate( String separator, CFBamServiceBuff buff ) {
		String retval = "<RqstServiceUpdate "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDelete( String separator, CFBamServiceBuff buff ) {
		String retval = "<RqstServiceDelete "
				+	formatServicePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByIdIdx( String separator,
		long argClusterId,
		long argServiceId )
	{
		String retval = "<RqstServiceDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServiceId",
					argServiceId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstServiceDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByHostIdx( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstServiceDeleteByHostIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByTypeIdx( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceDeleteByTypeIdx "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByUTypeIdx( String separator,
		long argClusterId,
		long argHostNodeId,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceDeleteByUTypeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceRqstDeleteByUHostPortIdx( String separator,
		long argClusterId,
		long argHostNodeId,
		short argHostPort )
	{
		String retval = "<RqstServiceDeleteByUHostPortIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"HostPort",
					argHostPort )
			+	" />";
		return( retval );
	}

	public static String formatServiceRspnSingleOpenTag() {
		final String retval = "<RspnServiceReadSingle>";
		return( retval );
	}

	public static String formatServiceRspnSingleCloseTag() {
		final String retval = "</RspnServiceReadSingle>";
		return( retval );
	}

	public static String formatServiceRspnListOpenTag() {
		final String retval = "<RspnServiceReadList>";
		return( retval );
	}

	public static String formatServiceRspnListCloseTag() {
		final String retval = "</RspnServiceReadList>";
		return( retval );
	}

	public static String formatServiceRspnRec( String separator, CFBamServiceBuff buff ) {
		String retval = "<Service "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRspnDerivedRec( String separator, CFBamServiceBuff buff ) {
		String retval;
		retval = formatServiceRspnRec( separator, buff );
		return( retval );
	}

	public static String formatServiceRspnCreated( String separator, CFBamServiceBuff buff ) {
		String retval = "<RspnServiceCreated "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRspnLocked( String separator, CFBamServiceBuff buff ) {
		String retval = "<RspnServiceLocked "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRspnUpdated( String separator, CFBamServiceBuff buff ) {
		String retval = "<RspnServiceUpdated "
			+	formatServiceBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceRspnDeleted() {
		String retval = "<RspnServiceDeleted />";
		return( retval );
	}
}
