// Description: Java7 Object interface for CFBam Relation.

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

public interface ICFBamRelationObj
	extends ICFBamScopeObj
{

	/**
	 *	Get the current edition of this Relation instance as a ICFBamRelationEditObj.
	 *
	 *	@return	The ICFBamRelationEditObj edition of this instance.
	 */
	ICFBamRelationEditObj getEditAsRelation();

	/**
	 *	Get the ICFBamRelationTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamRelationTableObj table cache which manages this instance.
	 */
	ICFBamRelationTableObj getRelationTable();

	/**
	 *	Get the CFBamRelationBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamRelationBuff instance which currently backs this object.
	 */
	CFBamRelationBuff getRelationBuff();

	/**
	 *	Get the required long attribute TableId.
	 *
	 *	@return	The required long attribute TableId.
	 */
	long getRequiredTableId();

	/**
	 *	Get the optional Long attribute DefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute DefSchemaTenantId.
	 */
	Long getOptionalDefSchemaTenantId();

	/**
	 *	Get the optional Long attribute DefSchemaId.
	 *
	 *	@return	The optional Long attribute DefSchemaId.
	 */
	Long getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required short attribute RelationTypeId.
	 *
	 *	@return	The required short attribute RelationTypeId.
	 */
	short getRequiredRelationTypeId();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The optional String attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Get the required long attribute FromIndexId.
	 *
	 *	@return	The required long attribute FromIndexId.
	 */
	long getRequiredFromIndexId();

	/**
	 *	Get the required long attribute ToTableId.
	 *
	 *	@return	The required long attribute ToTableId.
	 */
	long getRequiredToTableId();

	/**
	 *	Get the required long attribute ToIndexId.
	 *
	 *	@return	The required long attribute ToIndexId.
	 */
	long getRequiredToIndexId();

	/**
	 *	Get the required boolean attribute IsRequired.
	 *
	 *	@return	The required boolean attribute IsRequired.
	 */
	boolean getRequiredIsRequired();

	/**
	 *	Get the required boolean attribute IsAbstract.
	 *
	 *	@return	The required boolean attribute IsAbstract.
	 */
	boolean getRequiredIsAbstract();

	/**
	 *	Get the required boolean attribute IsXsdContainer.
	 *
	 *	@return	The required boolean attribute IsXsdContainer.
	 */
	boolean getRequiredIsXsdContainer();

	/**
	 *	Get the optional Long attribute NarrowedTenantId.
	 *
	 *	@return	The optional Long attribute NarrowedTenantId.
	 */
	Long getOptionalNarrowedTenantId();

	/**
	 *	Get the optional Long attribute NarrowedId.
	 *
	 *	@return	The optional Long attribute NarrowedId.
	 */
	Long getOptionalNarrowedId();

	/**
	 *	Get the required boolean attribute DefaultVisibility.
	 *
	 *	@return	The required boolean attribute DefaultVisibility.
	 */
	boolean getRequiredDefaultVisibility();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the RelTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the RelTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerRelTenant();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the RelTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the RelTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerRelTenant( boolean forceRead );

	/**
	 *	Get the required ICFBamRelationTypeObj instance referenced by the RelationType key.
	 *
	 *	@return	The required ICFBamRelationTypeObj instance referenced by the RelationType key.
	 */
	ICFBamRelationTypeObj getRequiredLookupRelationType();

	/**
	 *	Get the required ICFBamRelationTypeObj instance referenced by the RelationType key.
	 *
	 *	@return	The required ICFBamRelationTypeObj instance referenced by the RelationType key.
	 */
	ICFBamRelationTypeObj getRequiredLookupRelationType( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the required ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the FromTable key.
	 */
	ICFBamTableObj getRequiredContainerFromTable();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the FromTable key.
	 */
	ICFBamTableObj getRequiredContainerFromTable( boolean forceRead );

	/**
	 *	Get the required ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the FromIndex key.
	 */
	ICFBamIndexObj getRequiredLookupFromIndex();

	/**
	 *	Get the required ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the FromIndex key.
	 */
	ICFBamIndexObj getRequiredLookupFromIndex( boolean forceRead );

	/**
	 *	Get the required ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the ToTable key.
	 */
	ICFBamTableObj getRequiredLookupToTable();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the ToTable key.
	 */
	ICFBamTableObj getRequiredLookupToTable( boolean forceRead );

	/**
	 *	Get the required ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the ToIndex key.
	 */
	ICFBamIndexObj getRequiredLookupToIndex();

	/**
	 *	Get the required ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the ToIndex key.
	 */
	ICFBamIndexObj getRequiredLookupToIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The optional ICFBamRelationObj instance referenced by the Narrowed key.
	 */
	ICFBamRelationObj getOptionalLookupNarrowed();

	/**
	 *	Get the optional ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The optional ICFBamRelationObj instance referenced by the Narrowed key.
	 */
	ICFBamRelationObj getOptionalLookupNarrowed( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamRelationColObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamRelationColObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPopTopDepObj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopTopDepObj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopTopDepObj> getOptionalComponentsPopDep();

	/**
	 *	Get the array of optional ICFBamPopTopDepObj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopTopDepObj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead );

    ICFBamProjectBaseObj getProject();
    ICFBamTopDomainObj getCompany();
    ICFBamSchemaDefObj getSchemaDef();
    ICFBamVersionObj getVersionLeaf();
    String getVersionString();
    String getPackedVersionString();
	Boolean isColumnInOwnerRelation();
}
