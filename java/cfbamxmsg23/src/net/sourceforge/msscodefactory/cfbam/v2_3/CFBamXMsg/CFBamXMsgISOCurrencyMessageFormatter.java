
// Description: Java 7 XML Message message formatter for CFBam.ISOCurrency

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
 *	CFBamXMsgISOCurrencyMessageFormatter XML message formatter
 *	for CFBam.ISOCurrency.
 */
public class CFBamXMsgISOCurrencyMessageFormatter
{
	public CFBamXMsgISOCurrencyMessageFormatter() {
	}

	public static String formatISOCurrencyPKeyAttributes( String separator, CFBamISOCurrencyPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatISOCurrencyPKeyAttributes( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatISOCurrencyBuffAttributes( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = CFBamXMsgISOCurrencyMessageFormatter.formatISOCurrencyPKeyAttributes( separator, buff )
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
					"ISOCode",
					buff.getRequiredISOCode() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"UnitSymbol",
					buff.getOptionalUnitSymbol() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"FracSymbol",
					buff.getOptionalFracSymbol() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"Precis",
					buff.getRequiredPrecis() );
		return( retval );
	}

	public static String formatISOCurrencyRqstCreate( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RqstISOCurrencyCreate "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstRead( String separator, CFBamISOCurrencyPKey pkey ) {
		String retval = "<RqstISOCurrencyRead "
			+	formatISOCurrencyPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstRead( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RqstISOCurrencyRead "
			+	formatISOCurrencyPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstRead( String separator,
		short argId )
	{
		String retval = "<RqstISOCurrencyRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstReadAll( String separator ) {
		String retval = "<RqstISOCurrencyReadAll />";
		return( retval );
	}

	public static String formatISOCurrencyRqstReadByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstISOCurrencyRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstReadByCcyCdIdx( String separator,
		String argISOCode )
	{
		String retval = "<RqstISOCurrencyReadByCcyCdIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"ISOCode",
					argISOCode )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstReadByCcyNmIdx( String separator,
		String argName )
	{
		String retval = "<RqstISOCurrencyReadByCcyNmIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstLock( String separator, CFBamISOCurrencyPKey pkey ) {
		String retval = "<RqstISOCurrencyLock "
			+	formatISOCurrencyPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstLock( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RqstISOCurrencyLock "
			+	formatISOCurrencyPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstLock( String separator,
		short argId )
	{
		String retval = "<RqstISOCurrencyLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstUpdate( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RqstISOCurrencyUpdate "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstDelete( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RqstISOCurrencyDelete "
				+	formatISOCurrencyPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstDeleteByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstISOCurrencyDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstDeleteByCcyCdIdx( String separator,
		String argISOCode )
	{
		String retval = "<RqstISOCurrencyDeleteByCcyCdIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"ISOCode",
					argISOCode )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRqstDeleteByCcyNmIdx( String separator,
		String argName )
	{
		String retval = "<RqstISOCurrencyDeleteByCcyNmIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRspnSingleOpenTag() {
		final String retval = "<RspnISOCurrencyReadSingle>";
		return( retval );
	}

	public static String formatISOCurrencyRspnSingleCloseTag() {
		final String retval = "</RspnISOCurrencyReadSingle>";
		return( retval );
	}

	public static String formatISOCurrencyRspnListOpenTag() {
		final String retval = "<RspnISOCurrencyReadList>";
		return( retval );
	}

	public static String formatISOCurrencyRspnListCloseTag() {
		final String retval = "</RspnISOCurrencyReadList>";
		return( retval );
	}

	public static String formatISOCurrencyRspnRec( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<ISOCurrency "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRspnDerivedRec( String separator, CFBamISOCurrencyBuff buff ) {
		String retval;
		retval = formatISOCurrencyRspnRec( separator, buff );
		return( retval );
	}

	public static String formatISOCurrencyRspnCreated( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RspnISOCurrencyCreated "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRspnLocked( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RspnISOCurrencyLocked "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRspnUpdated( String separator, CFBamISOCurrencyBuff buff ) {
		String retval = "<RspnISOCurrencyUpdated "
			+	formatISOCurrencyBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCurrencyRspnDeleted() {
		String retval = "<RspnISOCurrencyDeleted />";
		return( retval );
	}
}
