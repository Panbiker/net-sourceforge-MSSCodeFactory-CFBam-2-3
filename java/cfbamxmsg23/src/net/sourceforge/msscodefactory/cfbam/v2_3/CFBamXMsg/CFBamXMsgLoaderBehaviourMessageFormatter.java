
// Description: Java 7 XML Message message formatter for CFBam.LoaderBehaviour

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
 *	CFBamXMsgLoaderBehaviourMessageFormatter XML message formatter
 *	for CFBam.LoaderBehaviour.
 */
public class CFBamXMsgLoaderBehaviourMessageFormatter
{
	public CFBamXMsgLoaderBehaviourMessageFormatter() {
	}

	public static String formatLoaderBehaviourPKeyAttributes( String separator, CFBamLoaderBehaviourPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatLoaderBehaviourPKeyAttributes( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatLoaderBehaviourBuffAttributes( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = CFBamXMsgLoaderBehaviourMessageFormatter.formatLoaderBehaviourPKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatLoaderBehaviourRqstCreate( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RqstLoaderBehaviourCreate "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstRead( String separator, CFBamLoaderBehaviourPKey pkey ) {
		String retval = "<RqstLoaderBehaviourRead "
			+	formatLoaderBehaviourPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstRead( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RqstLoaderBehaviourRead "
			+	formatLoaderBehaviourPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstRead( String separator,
		short argId )
	{
		String retval = "<RqstLoaderBehaviourRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstReadAll( String separator ) {
		String retval = "<RqstLoaderBehaviourReadAll />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstReadByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstLoaderBehaviourRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstReadByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstLoaderBehaviourReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstLock( String separator, CFBamLoaderBehaviourPKey pkey ) {
		String retval = "<RqstLoaderBehaviourLock "
			+	formatLoaderBehaviourPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstLock( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RqstLoaderBehaviourLock "
			+	formatLoaderBehaviourPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstLock( String separator,
		short argId )
	{
		String retval = "<RqstLoaderBehaviourLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstUpdate( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RqstLoaderBehaviourUpdate "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstDelete( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RqstLoaderBehaviourDelete "
				+	formatLoaderBehaviourPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstDeleteByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstLoaderBehaviourDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRqstDeleteByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstLoaderBehaviourDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnSingleOpenTag() {
		final String retval = "<RspnLoaderBehaviourReadSingle>";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnSingleCloseTag() {
		final String retval = "</RspnLoaderBehaviourReadSingle>";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnListOpenTag() {
		final String retval = "<RspnLoaderBehaviourReadList>";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnListCloseTag() {
		final String retval = "</RspnLoaderBehaviourReadList>";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnRec( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<LoaderBehaviour "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnDerivedRec( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval;
		retval = formatLoaderBehaviourRspnRec( separator, buff );
		return( retval );
	}

	public static String formatLoaderBehaviourRspnCreated( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RspnLoaderBehaviourCreated "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnLocked( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RspnLoaderBehaviourLocked "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnUpdated( String separator, CFBamLoaderBehaviourBuff buff ) {
		String retval = "<RspnLoaderBehaviourUpdated "
			+	formatLoaderBehaviourBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLoaderBehaviourRspnDeleted() {
		String retval = "<RspnLoaderBehaviourDeleted />";
		return( retval );
	}
}
