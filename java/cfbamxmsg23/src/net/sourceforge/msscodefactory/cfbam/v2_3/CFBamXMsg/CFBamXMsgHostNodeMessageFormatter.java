
// Description: Java 7 XML Message message formatter for CFBam.HostNode

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
 *	CFBamXMsgHostNodeMessageFormatter XML message formatter
 *	for CFBam.HostNode.
 */
public class CFBamXMsgHostNodeMessageFormatter
{
	public CFBamXMsgHostNodeMessageFormatter() {
	}

	public static String formatHostNodePKeyAttributes( String separator, CFBamHostNodePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"HostNodeId",
				pkey.getRequiredHostNodeId() );
		return( retval );
	}

	public static String formatHostNodePKeyAttributes( String separator, CFBamHostNodeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					buff.getRequiredHostNodeId() );
		return( retval );
	}

	public static String formatHostNodeBuffAttributes( String separator, CFBamHostNodeBuff buff ) {
		String retval = CFBamXMsgHostNodeMessageFormatter.formatHostNodePKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					buff.getRequiredDescription() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"HostName",
					buff.getRequiredHostName() );
		return( retval );
	}

	public static String formatHostNodeRqstCreate( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RqstHostNodeCreate "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstRead( String separator, CFBamHostNodePKey pkey ) {
		String retval = "<RqstHostNodeRead "
			+	formatHostNodePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstRead( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RqstHostNodeRead "
			+	formatHostNodePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstRead( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstHostNodeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstReadAll( String separator ) {
		String retval = "<RqstHostNodeReadAll />";
		return( retval );
	}

	public static String formatHostNodeRqstReadByIdIdx( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstHostNodeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstHostNodeReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstReadByUDescrIdx( String separator,
		long argClusterId,
		String argDescription )
	{
		String retval = "<RqstHostNodeReadByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstReadByHostNameIdx( String separator,
		long argClusterId,
		String argHostName )
	{
		String retval = "<RqstHostNodeReadByHostNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"HostName",
					argHostName )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstLock( String separator, CFBamHostNodePKey pkey ) {
		String retval = "<RqstHostNodeLock "
			+	formatHostNodePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstLock( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RqstHostNodeLock "
			+	formatHostNodePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstLock( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstHostNodeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstUpdate( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RqstHostNodeUpdate "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstDelete( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RqstHostNodeDelete "
				+	formatHostNodePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstDeleteByIdIdx( String separator,
		long argClusterId,
		long argHostNodeId )
	{
		String retval = "<RqstHostNodeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"HostNodeId",
					argHostNodeId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstHostNodeDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstDeleteByUDescrIdx( String separator,
		long argClusterId,
		String argDescription )
	{
		String retval = "<RqstHostNodeDeleteByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRqstDeleteByHostNameIdx( String separator,
		long argClusterId,
		String argHostName )
	{
		String retval = "<RqstHostNodeDeleteByHostNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"HostName",
					argHostName )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRspnSingleOpenTag() {
		final String retval = "<RspnHostNodeReadSingle>";
		return( retval );
	}

	public static String formatHostNodeRspnSingleCloseTag() {
		final String retval = "</RspnHostNodeReadSingle>";
		return( retval );
	}

	public static String formatHostNodeRspnListOpenTag() {
		final String retval = "<RspnHostNodeReadList>";
		return( retval );
	}

	public static String formatHostNodeRspnListCloseTag() {
		final String retval = "</RspnHostNodeReadList>";
		return( retval );
	}

	public static String formatHostNodeRspnRec( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<HostNode "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRspnDerivedRec( String separator, CFBamHostNodeBuff buff ) {
		String retval;
		retval = formatHostNodeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatHostNodeRspnCreated( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RspnHostNodeCreated "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRspnLocked( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RspnHostNodeLocked "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRspnUpdated( String separator, CFBamHostNodeBuff buff ) {
		String retval = "<RspnHostNodeUpdated "
			+	formatHostNodeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatHostNodeRspnDeleted() {
		String retval = "<RspnHostNodeDeleted />";
		return( retval );
	}
}
