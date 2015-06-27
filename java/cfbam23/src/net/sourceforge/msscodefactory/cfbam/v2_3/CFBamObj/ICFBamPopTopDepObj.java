// Description: Java7 Object interface for CFBam PopTopDep.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public interface ICFBamPopTopDepObj
	extends ICFBamPopDepObj
{

	/**
	 *	Get the current edition of this PopTopDep instance as a ICFBamPopTopDepEditObj.
	 *
	 *	@return	The ICFBamPopTopDepEditObj edition of this instance.
	 */
	ICFBamPopTopDepEditObj getEditAsPopTopDep();

	/**
	 *	Get the ICFBamPopTopDepTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPopTopDepTableObj table cache which manages this instance.
	 */
	ICFBamPopTopDepTableObj getPopTopDepTable();

	/**
	 *	Get the CFBamPopTopDepBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamPopTopDepBuff instance which currently backs this object.
	 */
	CFBamPopTopDepBuff getPopTopDepBuff();

	/**
	 *	Get the required long attribute ContTenantId.
	 *
	 *	@return	The required long attribute ContTenantId.
	 */
	long getRequiredContTenantId();

	/**
	 *	Get the required long attribute ContRelationId.
	 *
	 *	@return	The required long attribute ContRelationId.
	 */
	long getRequiredContRelationId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamRelationObj instance referenced by the ContRelation key.
	 *
	 *	@return	The required ICFBamRelationObj instance referenced by the ContRelation key.
	 */
	ICFBamRelationObj getRequiredContainerContRelation();

	/**
	 *	Get the required ICFBamRelationObj instance referenced by the ContRelation key.
	 *
	 *	@return	The required ICFBamRelationObj instance referenced by the ContRelation key.
	 */
	ICFBamRelationObj getRequiredContainerContRelation( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPopSubDep1Obj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopSubDep1Obj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopSubDep1Obj> getOptionalComponentsPopDep();

	/**
	 *	Get the array of optional ICFBamPopSubDep1Obj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopSubDep1Obj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopSubDep1Obj> getOptionalComponentsPopDep( boolean forceRead );
}
