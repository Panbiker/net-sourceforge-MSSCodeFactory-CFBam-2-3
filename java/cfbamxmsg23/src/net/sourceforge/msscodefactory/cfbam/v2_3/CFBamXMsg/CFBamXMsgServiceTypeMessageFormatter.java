
// Description: Java 7 XML Message message formatter for CFBam.ServiceType

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
 *	CFBamXMsgServiceTypeMessageFormatter XML message formatter
 *	for CFBam.ServiceType.
 */
public class CFBamXMsgServiceTypeMessageFormatter
{
	public CFBamXMsgServiceTypeMessageFormatter() {
	}

	public static String formatServiceTypePKeyAttributes( String separator, CFBamServiceTypePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt32( null,
				"ServiceTypeId",
				pkey.getRequiredServiceTypeId() );
		return( retval );
	}

	public static String formatServiceTypePKeyAttributes( String separator, CFBamServiceTypeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt32( separator,
					"ServiceTypeId",
					buff.getRequiredServiceTypeId() );
		return( retval );
	}

	public static String formatServiceTypeBuffAttributes( String separator, CFBamServiceTypeBuff buff ) {
		String retval = CFBamXMsgServiceTypeMessageFormatter.formatServiceTypePKeyAttributes( separator, buff )
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
					buff.getRequiredDescription() );
		return( retval );
	}

	public static String formatServiceTypeRqstCreate( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RqstServiceTypeCreate "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstRead( String separator, CFBamServiceTypePKey pkey ) {
		String retval = "<RqstServiceTypeRead "
			+	formatServiceTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstRead( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RqstServiceTypeRead "
			+	formatServiceTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstRead( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceTypeRead "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstReadAll( String separator ) {
		String retval = "<RqstServiceTypeReadAll />";
		return( retval );
	}

	public static String formatServiceTypeRqstReadByIdIdx( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceTypeRead "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstReadByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstServiceTypeReadByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstLock( String separator, CFBamServiceTypePKey pkey ) {
		String retval = "<RqstServiceTypeLock "
			+	formatServiceTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstLock( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RqstServiceTypeLock "
			+	formatServiceTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstLock( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceTypeLock "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstUpdate( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RqstServiceTypeUpdate "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstDelete( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RqstServiceTypeDelete "
				+	formatServiceTypePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstDeleteByIdIdx( String separator,
		int argServiceTypeId )
	{
		String retval = "<RqstServiceTypeDelete "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"ServiceTypeId",
					argServiceTypeId )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRqstDeleteByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstServiceTypeDeleteByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRspnSingleOpenTag() {
		final String retval = "<RspnServiceTypeReadSingle>";
		return( retval );
	}

	public static String formatServiceTypeRspnSingleCloseTag() {
		final String retval = "</RspnServiceTypeReadSingle>";
		return( retval );
	}

	public static String formatServiceTypeRspnListOpenTag() {
		final String retval = "<RspnServiceTypeReadList>";
		return( retval );
	}

	public static String formatServiceTypeRspnListCloseTag() {
		final String retval = "</RspnServiceTypeReadList>";
		return( retval );
	}

	public static String formatServiceTypeRspnRec( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<ServiceType "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRspnDerivedRec( String separator, CFBamServiceTypeBuff buff ) {
		String retval;
		retval = formatServiceTypeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatServiceTypeRspnCreated( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RspnServiceTypeCreated "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRspnLocked( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RspnServiceTypeLocked "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRspnUpdated( String separator, CFBamServiceTypeBuff buff ) {
		String retval = "<RspnServiceTypeUpdated "
			+	formatServiceTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServiceTypeRspnDeleted() {
		String retval = "<RspnServiceTypeDeleted />";
		return( retval );
	}
}
