// Description: Java7 Object interface for CFBam Id16Gen.

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

public interface ICFBamId16GenObj
	extends ICFBamInt16TypeObj
{

	/**
	 *	Get the current edition of this Id16Gen instance as a ICFBamId16GenEditObj.
	 *
	 *	@return	The ICFBamId16GenEditObj edition of this instance.
	 */
	ICFBamId16GenEditObj getEditAsId16Gen();

	/**
	 *	Get the ICFBamId16GenTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamId16GenTableObj table cache which manages this instance.
	 */
	ICFBamId16GenTableObj getId16GenTable();

	/**
	 *	Get the CFBamId16GenBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamId16GenBuff instance which currently backs this object.
	 */
	CFBamId16GenBuff getId16GenBuff();

	/**
	 *	Get the optional Long attribute DispenserTenantId.
	 *
	 *	@return	The optional Long attribute DispenserTenantId.
	 */
	Long getOptionalDispenserTenantId();

	/**
	 *	Get the optional Long attribute DispenserId.
	 *
	 *	@return	The optional Long attribute DispenserId.
	 */
	Long getOptionalDispenserId();

	/**
	 *	Get the required short attribute Slice.
	 *
	 *	@return	The required short attribute Slice.
	 */
	short getRequiredSlice();

	/**
	 *	Get the required short attribute BlockSize.
	 *
	 *	@return	The required short attribute BlockSize.
	 */
	short getRequiredBlockSize();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the Dispenser key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the Dispenser key.
	 */
	ICFBamTableObj getOptionalLookupDispenser();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the Dispenser key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the Dispenser key.
	 */
	ICFBamTableObj getOptionalLookupDispenser( boolean forceRead );
}
