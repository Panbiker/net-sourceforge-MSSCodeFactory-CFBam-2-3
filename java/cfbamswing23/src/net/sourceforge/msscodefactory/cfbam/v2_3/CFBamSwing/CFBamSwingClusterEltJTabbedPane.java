// Description: Java 7 Swing Element JTabbedPane implementation for Cluster.

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
 *	CFBamSwingClusterEltJTabbedPane Swing Element JTabbedPane implementation
 *	for Cluster.
 */
public class CFBamSwingClusterEltJTabbedPane
extends CFJTabbedPane
implements ICFBamSwingClusterJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected boolean swingIsInitializing = true;
	public final String LABEL_TabComponentsHostNodeList = "Optional Components Host Node";
	public final String LABEL_TabComponentsTenantList = "Optional Components Tenant";
	public final String LABEL_TabComponentsSecAppList = "Optional Components Security Application";
	public final String LABEL_TabComponentsSecGroupList = "Optional Components Security Group";
	public final String LABEL_TabComponentsSysClusterList = "Optional Components System Cluster";
	protected JPanel tabViewComponentsHostNodeListJPanel = null;
	protected JPanel tabViewComponentsTenantListJPanel = null;
	protected JPanel tabViewComponentsSecAppListJPanel = null;
	protected JPanel tabViewComponentsSecGroupListJPanel = null;
	protected JPanel tabViewComponentsSysClusterListJPanel = null;

	public CFBamSwingClusterEltJTabbedPane( ICFBamSwingSchema argSchema, ICFBamClusterObj argFocus ) {
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
		setSwingFocusAsCluster( argFocus );
		// Wire the newly constructed JPanels/Tabs to this JTabbedPane
		addTab( LABEL_TabComponentsHostNodeList, getTabViewComponentsHostNodeListJPanel() );
		addTab( LABEL_TabComponentsTenantList, getTabViewComponentsTenantListJPanel() );
		addTab( LABEL_TabComponentsSecAppList, getTabViewComponentsSecAppListJPanel() );
		addTab( LABEL_TabComponentsSecGroupList, getTabViewComponentsSecGroupListJPanel() );
		addTab( LABEL_TabComponentsSysClusterList, getTabViewComponentsSysClusterListJPanel() );
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamClusterObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamClusterObj" );
		}
	}

	public void setSwingFocusAsCluster( ICFBamClusterObj value ) {
		setSwingFocus( value );
	}

	public ICFBamClusterObj getSwingFocusAsCluster() {
		return( (ICFBamClusterObj)getSwingFocus() );
	}

	protected class RefreshComponentsHostNodeList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsHostNodeList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamHostNodeObj> dataCollection;
					ICFBamClusterObj focus = getSwingFocusAsCluster();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsHostNode( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsHostNodeListJPanel();
					ICFBamSwingHostNodeJPanelList jpList = (ICFBamSwingHostNodeJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsHostNodeListJPanel() {
		if( tabViewComponentsHostNodeListJPanel == null ) {
			Collection<ICFBamHostNodeObj> dataCollection;
			ICFBamClusterObj focus = getSwingFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsHostNode( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClusterObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClusterObj ) ) {
				swingContainer = (ICFBamClusterObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsHostNodeListJPanel = swingSchema.getHostNodeFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsHostNodeList(), false );
		}
		return( tabViewComponentsHostNodeListJPanel );
	}

	protected class RefreshComponentsTenantList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsTenantList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamTenantObj> dataCollection;
					ICFBamClusterObj focus = getSwingFocusAsCluster();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsTenant( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsTenantListJPanel();
					ICFBamSwingTenantJPanelList jpList = (ICFBamSwingTenantJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsTenantListJPanel() {
		if( tabViewComponentsTenantListJPanel == null ) {
			Collection<ICFBamTenantObj> dataCollection;
			ICFBamClusterObj focus = getSwingFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTenant( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClusterObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClusterObj ) ) {
				swingContainer = (ICFBamClusterObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsTenantListJPanel = swingSchema.getTenantFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsTenantList(), false );
		}
		return( tabViewComponentsTenantListJPanel );
	}

	protected class RefreshComponentsSecAppList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsSecAppList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecAppObj> dataCollection;
					ICFBamClusterObj focus = getSwingFocusAsCluster();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsSecApp( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsSecAppListJPanel();
					ICFBamSwingSecAppJPanelList jpList = (ICFBamSwingSecAppJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsSecAppListJPanel() {
		if( tabViewComponentsSecAppListJPanel == null ) {
			Collection<ICFBamSecAppObj> dataCollection;
			ICFBamClusterObj focus = getSwingFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecApp( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClusterObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClusterObj ) ) {
				swingContainer = (ICFBamClusterObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsSecAppListJPanel = swingSchema.getSecAppFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsSecAppList(), false );
		}
		return( tabViewComponentsSecAppListJPanel );
	}

	protected class RefreshComponentsSecGroupList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsSecGroupList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecGroupObj> dataCollection;
					ICFBamClusterObj focus = getSwingFocusAsCluster();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsSecGroup( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsSecGroupListJPanel();
					ICFBamSwingSecGroupJPanelList jpList = (ICFBamSwingSecGroupJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsSecGroupListJPanel() {
		if( tabViewComponentsSecGroupListJPanel == null ) {
			Collection<ICFBamSecGroupObj> dataCollection;
			ICFBamClusterObj focus = getSwingFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecGroup( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClusterObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClusterObj ) ) {
				swingContainer = (ICFBamClusterObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsSecGroupListJPanel = swingSchema.getSecGroupFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsSecGroupList(), false );
		}
		return( tabViewComponentsSecGroupListJPanel );
	}

	protected class RefreshComponentsSysClusterList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsSysClusterList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSysClusterObj> dataCollection;
					ICFBamClusterObj focus = getSwingFocusAsCluster();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsSysCluster( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsSysClusterListJPanel();
					ICFBamSwingSysClusterJPanelList jpList = (ICFBamSwingSysClusterJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsSysClusterListJPanel() {
		if( tabViewComponentsSysClusterListJPanel == null ) {
			Collection<ICFBamSysClusterObj> dataCollection;
			ICFBamClusterObj focus = getSwingFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSysCluster( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClusterObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClusterObj ) ) {
				swingContainer = (ICFBamClusterObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsSysClusterListJPanel = swingSchema.getSysClusterFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsSysClusterList(), false );
		}
		return( tabViewComponentsSysClusterListJPanel );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		CFJPanel.PanelMode oldMode = getPanelMode();
		super.setPanelMode( value );
		if( tabViewComponentsHostNodeListJPanel != null ) {
			((ICFBamSwingHostNodeJPanelCommon)tabViewComponentsHostNodeListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsTenantListJPanel != null ) {
			((ICFBamSwingTenantJPanelCommon)tabViewComponentsTenantListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsSecAppListJPanel != null ) {
			((ICFBamSwingSecAppJPanelCommon)tabViewComponentsSecAppListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsSecGroupListJPanel != null ) {
			((ICFBamSwingSecGroupJPanelCommon)tabViewComponentsSecGroupListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsSysClusterListJPanel != null ) {
			((ICFBamSwingSysClusterJPanelCommon)tabViewComponentsSysClusterListJPanel).setPanelMode( value );
		}
	}
}
