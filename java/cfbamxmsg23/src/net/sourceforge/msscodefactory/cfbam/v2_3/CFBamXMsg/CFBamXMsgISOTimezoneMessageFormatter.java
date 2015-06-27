
// Description: Java 7 XML Message message formatter for CFBam.ISOTimezone

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
 *	CFBamXMsgISOTimezoneMessageFormatter XML message formatter
 *	for CFBam.ISOTimezone.
 */
public class CFBamXMsgISOTimezoneMessageFormatter
{
	public CFBamXMsgISOTimezoneMessageFormatter() {
	}

	public static String formatISOTimezonePKeyAttributes( String separator, CFBamISOTimezonePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"ISOTimezoneId",
				pkey.getRequiredISOTimezoneId() );
		return( retval );
	}

	public static String formatISOTimezonePKeyAttributes( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOTimezoneId",
					buff.getRequiredISOTimezoneId() );
		return( retval );
	}

	public static String formatISOTimezoneBuffAttributes( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = CFBamXMsgISOTimezoneMessageFormatter.formatISOTimezonePKeyAttributes( separator, buff )
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
					"Iso8601",
					buff.getRequiredIso8601() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TZName",
					buff.getRequiredTZName() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"TZHourOffset",
					buff.getRequiredTZHourOffset() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"TZMinOffset",
					buff.getRequiredTZMinOffset() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					buff.getRequiredDescription() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"Visible",
					buff.getRequiredVisible() );
		return( retval );
	}

	public static String formatISOTimezoneRqstCreate( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RqstISOTimezoneCreate "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstRead( String separator, CFBamISOTimezonePKey pkey ) {
		String retval = "<RqstISOTimezoneRead "
			+	formatISOTimezonePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstRead( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RqstISOTimezoneRead "
			+	formatISOTimezonePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstRead( String separator,
		short argISOTimezoneId )
	{
		String retval = "<RqstISOTimezoneRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOTimezoneId",
					argISOTimezoneId )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstReadAll( String separator ) {
		String retval = "<RqstISOTimezoneReadAll />";
		return( retval );
	}

	public static String formatISOTimezoneRqstReadByIdIdx( String separator,
		short argISOTimezoneId )
	{
		String retval = "<RqstISOTimezoneRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOTimezoneId",
					argISOTimezoneId )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstReadByOffsetIdx( String separator,
		short argTZHourOffset,
		short argTZMinOffset )
	{
		String retval = "<RqstISOTimezoneReadByOffsetIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"TZHourOffset",
					argTZHourOffset )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"TZMinOffset",
					argTZMinOffset )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstReadByUTZNameIdx( String separator,
		String argTZName )
	{
		String retval = "<RqstISOTimezoneReadByUTZNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"TZName",
					argTZName )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstReadByIso8601Idx( String separator,
		String argIso8601 )
	{
		String retval = "<RqstISOTimezoneReadByIso8601Idx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Iso8601",
					argIso8601 )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstLock( String separator, CFBamISOTimezonePKey pkey ) {
		String retval = "<RqstISOTimezoneLock "
			+	formatISOTimezonePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstLock( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RqstISOTimezoneLock "
			+	formatISOTimezonePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstLock( String separator,
		short argISOTimezoneId )
	{
		String retval = "<RqstISOTimezoneLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOTimezoneId",
					argISOTimezoneId )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstUpdate( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RqstISOTimezoneUpdate "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstDelete( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RqstISOTimezoneDelete "
				+	formatISOTimezonePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstDeleteByIdIdx( String separator,
		short argISOTimezoneId )
	{
		String retval = "<RqstISOTimezoneDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOTimezoneId",
					argISOTimezoneId )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstDeleteByOffsetIdx( String separator,
		short argTZHourOffset,
		short argTZMinOffset )
	{
		String retval = "<RqstISOTimezoneDeleteByOffsetIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"TZHourOffset",
					argTZHourOffset )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"TZMinOffset",
					argTZMinOffset )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstDeleteByUTZNameIdx( String separator,
		String argTZName )
	{
		String retval = "<RqstISOTimezoneDeleteByUTZNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"TZName",
					argTZName )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRqstDeleteByIso8601Idx( String separator,
		String argIso8601 )
	{
		String retval = "<RqstISOTimezoneDeleteByIso8601Idx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Iso8601",
					argIso8601 )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRspnSingleOpenTag() {
		final String retval = "<RspnISOTimezoneReadSingle>";
		return( retval );
	}

	public static String formatISOTimezoneRspnSingleCloseTag() {
		final String retval = "</RspnISOTimezoneReadSingle>";
		return( retval );
	}

	public static String formatISOTimezoneRspnListOpenTag() {
		final String retval = "<RspnISOTimezoneReadList>";
		return( retval );
	}

	public static String formatISOTimezoneRspnListCloseTag() {
		final String retval = "</RspnISOTimezoneReadList>";
		return( retval );
	}

	public static String formatISOTimezoneRspnRec( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<ISOTimezone "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRspnDerivedRec( String separator, CFBamISOTimezoneBuff buff ) {
		String retval;
		retval = formatISOTimezoneRspnRec( separator, buff );
		return( retval );
	}

	public static String formatISOTimezoneRspnCreated( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RspnISOTimezoneCreated "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRspnLocked( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RspnISOTimezoneLocked "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRspnUpdated( String separator, CFBamISOTimezoneBuff buff ) {
		String retval = "<RspnISOTimezoneUpdated "
			+	formatISOTimezoneBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOTimezoneRspnDeleted() {
		String retval = "<RspnISOTimezoneDeleted />";
		return( retval );
	}
}
