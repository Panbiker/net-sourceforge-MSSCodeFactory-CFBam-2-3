// Description: Java 7 Swing Element JTabbedPane implementation for Table.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSwing;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingTableEltJTabbedPane Swing Element JTabbedPane implementation
 *	for Table.
 */
public class CFBamSwingTableEltJTabbedPane
extends CFJTabbedPane
implements ICFBamSwingTableJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected boolean swingIsInitializing = true;
	public final String LABEL_TabComponentsRelationList = "Optional Components Relation Definitions";
	public final String LABEL_TabComponentsIndexList = "Optional Components Index Definitions";
	public final String LABEL_TabComponentsColumnsList = "Optional Components Columns";
	public final String LABEL_TabChildrenReverseRelationsList = "Optional Children Reverse Relations";
	public final String LABEL_TabComponentsChainsList = "Optional Components Chains";
	public final String LABEL_TabComponentsDelDepList = "Optional Components Deletion Dependency";
	public final String LABEL_TabComponentsClearDepList = "Optional Components Clear Relationships Dependency";
	public final String LABEL_TabChildrenDispId16GenList = "Optional Children Reverse Relations";
	public final String LABEL_TabChildrenDispId32GenList = "Optional Children Reverse Relations";
	public final String LABEL_TabChildrenDispId64GenList = "Optional Children Reverse Relations";
	public final String LABEL_TabComponentsServerMethodsList = "Optional Components Server Methods";
	protected JPanel tabViewComponentsRelationListJPanel = null;
	protected JPanel tabViewComponentsIndexListJPanel = null;
	protected JPanel tabViewComponentsColumnsListJPanel = null;
	protected JPanel tabViewChildrenReverseRelationsListJPanel = null;
	protected JPanel tabViewComponentsChainsListJPanel = null;
	protected JPanel tabViewComponentsDelDepListJPanel = null;
	protected JPanel tabViewComponentsClearDepListJPanel = null;
	protected JPanel tabViewChildrenDispId16GenListJPanel = null;
	protected JPanel tabViewChildrenDispId32GenListJPanel = null;
	protected JPanel tabViewChildrenDispId64GenListJPanel = null;
	protected JPanel tabViewComponentsServerMethodsListJPanel = null;

	public CFBamSwingTableEltJTabbedPane( ICFBamSwingSchema argSchema, ICFBamTableObj argFocus ) {
		super( JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT );
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		swingSchema = argSchema;
		setSwingFocusAsTable( argFocus );
		// Wire the newly constructed JPanels/Tabs to this JTabbedPane
		addTab( LABEL_TabComponentsRelationList, getTabViewComponentsRelationListJPanel() );
		addTab( LABEL_TabComponentsIndexList, getTabViewComponentsIndexListJPanel() );
		addTab( LABEL_TabComponentsColumnsList, getTabViewComponentsColumnsListJPanel() );
		addTab( LABEL_TabChildrenReverseRelationsList, getTabViewChildrenReverseRelationsListJPanel() );
		addTab( LABEL_TabComponentsChainsList, getTabViewComponentsChainsListJPanel() );
		addTab( LABEL_TabComponentsDelDepList, getTabViewComponentsDelDepListJPanel() );
		addTab( LABEL_TabComponentsClearDepList, getTabViewComponentsClearDepListJPanel() );
		addTab( LABEL_TabChildrenDispId16GenList, getTabViewChildrenDispId16GenListJPanel() );
		addTab( LABEL_TabChildrenDispId32GenList, getTabViewChildrenDispId32GenListJPanel() );
		addTab( LABEL_TabChildrenDispId64GenList, getTabViewChildrenDispId64GenListJPanel() );
		addTab( LABEL_TabComponentsServerMethodsList, getTabViewComponentsServerMethodsListJPanel() );
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamTableObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTableObj" );
		}
	}

	public void setSwingFocusAsTable( ICFBamTableObj value ) {
		setSwingFocus( value );
	}

	public ICFBamTableObj getSwingFocusAsTable() {
		return( (ICFBamTableObj)getSwingFocus() );
	}

	protected class RefreshComponentsRelationList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsRelationList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamRelationObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsRelation( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsRelationListJPanel();
					ICFBamSwingRelationJPanelList jpList = (ICFBamSwingRelationJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsRelationListJPanel() {
		if( tabViewComponentsRelationListJPanel == null ) {
			Collection<ICFBamRelationObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRelation( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsRelationListJPanel = swingSchema.getRelationFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsRelationList(), false );
		}
		return( tabViewComponentsRelationListJPanel );
	}

	protected class RefreshComponentsIndexList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsIndexList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamIndexObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsIndex( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsIndexListJPanel();
					ICFBamSwingIndexJPanelList jpList = (ICFBamSwingIndexJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsIndexListJPanel() {
		if( tabViewComponentsIndexListJPanel == null ) {
			Collection<ICFBamIndexObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsIndex( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsIndexListJPanel = swingSchema.getIndexFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsIndexList(), false );
		}
		return( tabViewComponentsIndexListJPanel );
	}

	protected class RefreshComponentsColumnsList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsColumnsList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamValueObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsColumns( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsColumnsListJPanel();
					ICFBamSwingValueJPanelList jpList = (ICFBamSwingValueJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsColumnsListJPanel() {
		if( tabViewComponentsColumnsListJPanel == null ) {
			Collection<ICFBamValueObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamScopeObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamScopeObj ) ) {
				swingContainer = (ICFBamScopeObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsColumnsListJPanel = swingSchema.getValueFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsColumnsList(), true );
		}
		return( tabViewComponentsColumnsListJPanel );
	}

	protected class RefreshChildrenReverseRelationsList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenReverseRelationsList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamRelationObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenReverseRelations( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenReverseRelationsListJPanel();
					ICFBamSwingRelationJPanelList jpList = (ICFBamSwingRelationJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenReverseRelationsListJPanel() {
		if( tabViewChildrenReverseRelationsListJPanel == null ) {
			Collection<ICFBamRelationObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenReverseRelations( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenReverseRelationsListJPanel = swingSchema.getRelationFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenReverseRelationsList(), false );
		}
		return( tabViewChildrenReverseRelationsListJPanel );
	}

	protected class RefreshComponentsChainsList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsChainsList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamChainObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsChains( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsChainsListJPanel();
					ICFBamSwingChainJPanelList jpList = (ICFBamSwingChainJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsChainsListJPanel() {
		if( tabViewComponentsChainsListJPanel == null ) {
			Collection<ICFBamChainObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsChains( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsChainsListJPanel = swingSchema.getChainFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsChainsList(), false );
		}
		return( tabViewComponentsChainsListJPanel );
	}

	protected class RefreshComponentsDelDepList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsDelDepList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamDelTopDepObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsDelDep( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsDelDepListJPanel();
					ICFBamSwingDelTopDepJPanelList jpList = (ICFBamSwingDelTopDepJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsDelDepListJPanel() {
		if( tabViewComponentsDelDepListJPanel == null ) {
			Collection<ICFBamDelTopDepObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsDelDepListJPanel = swingSchema.getDelTopDepFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsDelDepList(), false );
		}
		return( tabViewComponentsDelDepListJPanel );
	}

	protected class RefreshComponentsClearDepList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsClearDepList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamClearTopDepObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsClearDep( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsClearDepListJPanel();
					ICFBamSwingClearTopDepJPanelList jpList = (ICFBamSwingClearTopDepJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsClearDepListJPanel() {
		if( tabViewComponentsClearDepListJPanel == null ) {
			Collection<ICFBamClearTopDepObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsClearDepListJPanel = swingSchema.getClearTopDepFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsClearDepList(), false );
		}
		return( tabViewComponentsClearDepListJPanel );
	}

	protected class RefreshChildrenDispId16GenList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenDispId16GenList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamId16GenObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenDispId16Gen( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenDispId16GenListJPanel();
					ICFBamSwingId16GenJPanelList jpList = (ICFBamSwingId16GenJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenDispId16GenListJPanel() {
		if( tabViewChildrenDispId16GenListJPanel == null ) {
			Collection<ICFBamId16GenObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenDispId16Gen( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSchemaDefObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSchemaDefObj ) ) {
				swingContainer = (ICFBamSchemaDefObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenDispId16GenListJPanel = swingSchema.getId16GenFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenDispId16GenList(), false );
		}
		return( tabViewChildrenDispId16GenListJPanel );
	}

	protected class RefreshChildrenDispId32GenList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenDispId32GenList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamId32GenObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenDispId32Gen( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenDispId32GenListJPanel();
					ICFBamSwingId32GenJPanelList jpList = (ICFBamSwingId32GenJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenDispId32GenListJPanel() {
		if( tabViewChildrenDispId32GenListJPanel == null ) {
			Collection<ICFBamId32GenObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenDispId32Gen( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSchemaDefObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSchemaDefObj ) ) {
				swingContainer = (ICFBamSchemaDefObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenDispId32GenListJPanel = swingSchema.getId32GenFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenDispId32GenList(), false );
		}
		return( tabViewChildrenDispId32GenListJPanel );
	}

	protected class RefreshChildrenDispId64GenList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenDispId64GenList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamId64GenObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenDispId64Gen( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenDispId64GenListJPanel();
					ICFBamSwingId64GenJPanelList jpList = (ICFBamSwingId64GenJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenDispId64GenListJPanel() {
		if( tabViewChildrenDispId64GenListJPanel == null ) {
			Collection<ICFBamId64GenObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenDispId64Gen( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSchemaDefObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSchemaDefObj ) ) {
				swingContainer = (ICFBamSchemaDefObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenDispId64GenListJPanel = swingSchema.getId64GenFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenDispId64GenList(), false );
		}
		return( tabViewChildrenDispId64GenListJPanel );
	}

	protected class RefreshComponentsServerMethodsList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsServerMethodsList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamServerMethodObj> dataCollection;
					ICFBamTableObj focus = getSwingFocusAsTable();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsServerMethods( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsServerMethodsListJPanel();
					ICFBamSwingServerMethodJPanelList jpList = (ICFBamSwingServerMethodJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsServerMethodsListJPanel() {
		if( tabViewComponentsServerMethodsListJPanel == null ) {
			Collection<ICFBamServerMethodObj> dataCollection;
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsServerMethods( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				swingContainer = (ICFBamTableObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsServerMethodsListJPanel = swingSchema.getServerMethodFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsServerMethodsList(), false );
		}
		return( tabViewComponentsServerMethodsListJPanel );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		CFJPanel.PanelMode oldMode = getPanelMode();
		super.setPanelMode( value );
		if( tabViewComponentsRelationListJPanel != null ) {
			((ICFBamSwingRelationJPanelCommon)tabViewComponentsRelationListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsIndexListJPanel != null ) {
			((ICFBamSwingIndexJPanelCommon)tabViewComponentsIndexListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsColumnsListJPanel != null ) {
			((ICFBamSwingValueJPanelCommon)tabViewComponentsColumnsListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenReverseRelationsListJPanel != null ) {
			((ICFBamSwingRelationJPanelCommon)tabViewChildrenReverseRelationsListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsChainsListJPanel != null ) {
			((ICFBamSwingChainJPanelCommon)tabViewComponentsChainsListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsDelDepListJPanel != null ) {
			((ICFBamSwingDelTopDepJPanelCommon)tabViewComponentsDelDepListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsClearDepListJPanel != null ) {
			((ICFBamSwingClearTopDepJPanelCommon)tabViewComponentsClearDepListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenDispId16GenListJPanel != null ) {
			((ICFBamSwingId16GenJPanelCommon)tabViewChildrenDispId16GenListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenDispId32GenListJPanel != null ) {
			((ICFBamSwingId32GenJPanelCommon)tabViewChildrenDispId32GenListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenDispId64GenListJPanel != null ) {
			((ICFBamSwingId64GenJPanelCommon)tabViewChildrenDispId64GenListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsServerMethodsListJPanel != null ) {
			((ICFBamSwingServerMethodJPanelCommon)tabViewComponentsServerMethodsListJPanel).setPanelMode( value );
		}
	}
}
