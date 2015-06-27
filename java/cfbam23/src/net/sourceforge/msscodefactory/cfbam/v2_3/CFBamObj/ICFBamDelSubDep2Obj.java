// Description: Java7 Object interface for CFBam DelSubDep2.

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

public interface ICFBamDelSubDep2Obj
	extends ICFBamDelDepObj
{

	/**
	 *	Get the current edition of this DelSubDep2 instance as a ICFBamDelSubDep2EditObj.
	 *
	 *	@return	The ICFBamDelSubDep2EditObj edition of this instance.
	 */
	ICFBamDelSubDep2EditObj getEditAsDelSubDep2();

	/**
	 *	Get the ICFBamDelSubDep2TableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamDelSubDep2TableObj table cache which manages this instance.
	 */
	ICFBamDelSubDep2TableObj getDelSubDep2Table();

	/**
	 *	Get the CFBamDelSubDep2Buff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamDelSubDep2Buff instance which currently backs this object.
	 */
	CFBamDelSubDep2Buff getDelSubDep2Buff();

	/**
	 *	Get the required long attribute ContTenantId.
	 *
	 *	@return	The required long attribute ContTenantId.
	 */
	long getRequiredContTenantId();

	/**
	 *	Get the required long attribute ContDelDep1Id.
	 *
	 *	@return	The required long attribute ContDelDep1Id.
	 */
	long getRequiredContDelDep1Id();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamDelSubDep1Obj instance referenced by the ContDelSubDep1 key.
	 *
	 *	@return	The required ICFBamDelSubDep1Obj instance referenced by the ContDelSubDep1 key.
	 */
	ICFBamDelSubDep1Obj getRequiredContainerContDelSubDep1();

	/**
	 *	Get the required ICFBamDelSubDep1Obj instance referenced by the ContDelSubDep1 key.
	 *
	 *	@return	The required ICFBamDelSubDep1Obj instance referenced by the ContDelSubDep1 key.
	 */
	ICFBamDelSubDep1Obj getRequiredContainerContDelSubDep1( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamDelSubDep3Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelSubDep3Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamDelSubDep3Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelSubDep3Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep( boolean forceRead );
}