
// Description: Java7 Default Factory implementation for RelationCol.

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

	/*
	 *	CFBamRelationColFactory implementation for RelationCol
	 */
public class CFBamRelationColDefaultFactory
	implements ICFBamRelationColFactory
{

	public CFBamRelationColDefaultFactory() {
	}

	public CFBamRelationColPKey newPKey() {
		CFBamRelationColPKey pkey =
			new CFBamRelationColPKey();
		return( pkey );
	}

	public CFBamRelationColHPKey newHPKey() {
		CFBamRelationColHPKey hpkey =
			new CFBamRelationColHPKey();
		return( hpkey );
	}

	public CFBamRelationColByUNameIdxKey newUNameIdxKey() {
		CFBamRelationColByUNameIdxKey key =
			new CFBamRelationColByUNameIdxKey();
		return( key );
	}

	public CFBamRelationColByRelColTenantIdxKey newRelColTenantIdxKey() {
		CFBamRelationColByRelColTenantIdxKey key =
			new CFBamRelationColByRelColTenantIdxKey();
		return( key );
	}

	public CFBamRelationColByRelationIdxKey newRelationIdxKey() {
		CFBamRelationColByRelationIdxKey key =
			new CFBamRelationColByRelationIdxKey();
		return( key );
	}

	public CFBamRelationColByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamRelationColByDefSchemaIdxKey key =
			new CFBamRelationColByDefSchemaIdxKey();
		return( key );
	}

	public CFBamRelationColByFromColIdxKey newFromColIdxKey() {
		CFBamRelationColByFromColIdxKey key =
			new CFBamRelationColByFromColIdxKey();
		return( key );
	}

	public CFBamRelationColByToColIdxKey newToColIdxKey() {
		CFBamRelationColByToColIdxKey key =
			new CFBamRelationColByToColIdxKey();
		return( key );
	}

	public CFBamRelationColByPrevIdxKey newPrevIdxKey() {
		CFBamRelationColByPrevIdxKey key =
			new CFBamRelationColByPrevIdxKey();
		return( key );
	}

	public CFBamRelationColByNextIdxKey newNextIdxKey() {
		CFBamRelationColByNextIdxKey key =
			new CFBamRelationColByNextIdxKey();
		return( key );
	}

	public CFBamRelationColByRelPrevIdxKey newRelPrevIdxKey() {
		CFBamRelationColByRelPrevIdxKey key =
			new CFBamRelationColByRelPrevIdxKey();
		return( key );
	}

	public CFBamRelationColByRelNextIdxKey newRelNextIdxKey() {
		CFBamRelationColByRelNextIdxKey key =
			new CFBamRelationColByRelNextIdxKey();
		return( key );
	}

	public CFBamRelationColBuff newBuff() {
		CFBamRelationColBuff buff =
			new CFBamRelationColBuff();
		return( buff );
	}

	public CFBamRelationColHBuff newHBuff() {
		CFBamRelationColHBuff hbuff =
			new CFBamRelationColHBuff();
		return( hbuff );
	}
}
