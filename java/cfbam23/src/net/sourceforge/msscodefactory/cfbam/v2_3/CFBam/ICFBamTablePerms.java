// Description: Java7 CFBam Table Permissions Interface.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;

public interface ICFBamTablePerms
{
	/**
	 *	Is the session allowed to create AccessFrequency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateAccessFrequency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read AccessFrequency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadAccessFrequency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update AccessFrequency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateAccessFrequency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete AccessFrequency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteAccessFrequency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create AccessSecurity instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateAccessSecurity( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read AccessSecurity instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadAccessSecurity( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update AccessSecurity instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateAccessSecurity( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete AccessSecurity instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteAccessSecurity( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateAtom( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadAtom( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateAtom( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteAtom( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create AuditAction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateAuditAction( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read AuditAction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadAuditAction( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update AuditAction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateAuditAction( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete AuditAction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteAuditAction( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateChain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadChain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateChain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteChain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DataScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDataScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DataScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDataScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DataScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDataScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DataScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDataScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Domain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Domain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Domain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Domain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DomainBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDomainBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DomainBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDomainBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DomainBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDomainBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DomainBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDomainBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumTag( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumTag( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumTag( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumTag( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateHostNode( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadHostNode( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateHostNode( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteHostNode( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCountry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCountry( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCountry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCountry( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCountry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCountry( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCountry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCountry( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCountryCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCountryCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCountryCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCountryCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCountryCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCountryCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCountryCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCountryCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCountryLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCountryLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCountryLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCountryLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCountryLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCountryLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCountryLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCountryLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCurrency instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCurrency( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOLanguage instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOLanguage( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOTimezone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOTimezone( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOTimezone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOTimezone( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOTimezone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOTimezone( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOTimezone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOTimezone( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId16Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId16Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId16Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId16Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId32Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId32Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId32Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId32Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId64Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId64Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId64Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId64Gen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateIndex( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadIndex( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateIndex( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteIndex( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateIndexCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadIndexCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateIndexCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteIndexCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateLicense( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadLicense( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateLicense( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteLicense( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create LoaderBehaviour instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateLoaderBehaviour( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read LoaderBehaviour instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadLoaderBehaviour( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update LoaderBehaviour instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateLoaderBehaviour( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete LoaderBehaviour instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteLoaderBehaviour( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMajorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMajorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMajorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMajorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMinorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMinorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMinorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMinorVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateParam( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadParam( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateParam( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteParam( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep1( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep2( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep3( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopTopDep( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ProjectBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateProjectBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ProjectBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadProjectBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ProjectBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateProjectBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ProjectBase instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteProjectBase( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create RealProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRealProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read RealProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRealProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update RealProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRealProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RealProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRealProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRelation( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRelation( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRelation( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRelation( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRelationCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRelationCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRelationCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRelationCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create RelationType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRelationType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read RelationType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRelationType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update RelationType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRelationType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RelationType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRelationType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaRef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaRef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaRef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaRef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecApp( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecApp( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecApp( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecApp( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecDevice( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecDevice( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecDevice( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecDevice( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroupForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroupForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroupForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroupForm( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSession( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSession( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSession( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSession( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUser( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUser( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUser( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUser( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecurityScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecurityScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecurityScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecurityScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecurityScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecurityScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecurityScope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecurityScope( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerListFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerListFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerListFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerListFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerMethod( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerMethod( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerMethod( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerMethod( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerObjFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerObjFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerObjFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerObjFunc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerProc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerProc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerProc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerProc( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Service instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateService( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Service instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadService( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Service instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateService( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Service instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteService( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServiceType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServiceType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServiceType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServiceType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServiceType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServiceType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServiceType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServiceType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSubProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSubProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSubProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSubProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSysCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSysCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSysCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSysCluster( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGroup( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGroupInclude instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGroupInclude( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGroupMember instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGroupMember( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTable( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTable( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTable( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTable( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTableCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTableCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTableCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTableCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTenant( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTenant( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTenant( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTenant( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTld( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTld( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTld( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTld( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopDomain( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopProject( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Col( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Def( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Type( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateURLProtocol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadURLProtocol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateURLProtocol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteURLProtocol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidCol( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidDef( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidGen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidGen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidGen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidGen( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidType( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateValue( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadValue( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateValue( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteValue( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to create Version instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to read Version instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to update Version instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateVersion( CFBamAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Version instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteVersion( CFBamAuthorization Authorization );
}
