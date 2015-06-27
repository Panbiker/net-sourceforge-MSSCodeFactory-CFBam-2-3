// Description: Java 7 Swing Element JTabbedPane implementation for SecUser.

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
 *	CFBamSwingSecUserEltJTabbedPane Swing Element JTabbedPane implementation
 *	for SecUser.
 */
public class CFBamSwingSecUserEltJTabbedPane
extends CFJTabbedPane
implements ICFBamSwingSecUserJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected boolean swingIsInitializing = true;
	public final String LABEL_TabComponentsSecDevList = "Optional Components Security Device";
	public final String LABEL_TabComponentsSecSessList = "Optional Components Security Session";
	public final String LABEL_TabChildrenSecProxyList = "Optional Children Security Proxy Session";
	public final String LABEL_TabChildrenSecGroupMemberList = "Optional Children Security Group Members";
	public final String LABEL_TabChildrenTSecGroupMemberList = "Optional Children Tenant Security Group Members";
	protected JPanel tabViewComponentsSecDevListJPanel = null;
	protected JPanel tabViewComponentsSecSessListJPanel = null;
	protected JPanel tabViewChildrenSecProxyListJPanel = null;
	protected JPanel tabViewChildrenSecGroupMemberListJPanel = null;
	protected JPanel tabViewChildrenTSecGroupMemberListJPanel = null;

	public CFBamSwingSecUserEltJTabbedPane( ICFBamSwingSchema argSchema, ICFBamSecUserObj argFocus ) {
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
		setSwingFocusAsSecUser( argFocus );
		// Wire the newly constructed JPanels/Tabs to this JTabbedPane
		addTab( LABEL_TabComponentsSecDevList, getTabViewComponentsSecDevListJPanel() );
		addTab( LABEL_TabComponentsSecSessList, getTabViewComponentsSecSessListJPanel() );
		addTab( LABEL_TabChildrenSecProxyList, getTabViewChildrenSecProxyListJPanel() );
		addTab( LABEL_TabChildrenSecGroupMemberList, getTabViewChildrenSecGroupMemberListJPanel() );
		addTab( LABEL_TabChildrenTSecGroupMemberList, getTabViewChildrenTSecGroupMemberListJPanel() );
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamSecUserObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSecUserObj" );
		}
	}

	public void setSwingFocusAsSecUser( ICFBamSecUserObj value ) {
		setSwingFocus( value );
	}

	public ICFBamSecUserObj getSwingFocusAsSecUser() {
		return( (ICFBamSecUserObj)getSwingFocus() );
	}

	protected class RefreshComponentsSecDevList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsSecDevList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecDeviceObj> dataCollection;
					ICFBamSecUserObj focus = getSwingFocusAsSecUser();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsSecDev( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsSecDevListJPanel();
					ICFBamSwingSecDeviceJPanelList jpList = (ICFBamSwingSecDeviceJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsSecDevListJPanel() {
		if( tabViewComponentsSecDevListJPanel == null ) {
			Collection<ICFBamSecDeviceObj> dataCollection;
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecDev( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSecUserObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSecUserObj ) ) {
				swingContainer = (ICFBamSecUserObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsSecDevListJPanel = swingSchema.getSecDeviceFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsSecDevList(), false );
		}
		return( tabViewComponentsSecDevListJPanel );
	}

	protected class RefreshComponentsSecSessList
	implements ICFJRefreshCallback
	{
		public RefreshComponentsSecSessList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecSessionObj> dataCollection;
					ICFBamSecUserObj focus = getSwingFocusAsSecUser();
					if( focus != null ) {
						dataCollection = focus.getOptionalComponentsSecSess( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewComponentsSecSessListJPanel();
					ICFBamSwingSecSessionJPanelList jpList = (ICFBamSwingSecSessionJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewComponentsSecSessListJPanel() {
		if( tabViewComponentsSecSessListJPanel == null ) {
			Collection<ICFBamSecSessionObj> dataCollection;
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecSess( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSecUserObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSecUserObj ) ) {
				swingContainer = (ICFBamSecUserObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewComponentsSecSessListJPanel = swingSchema.getSecSessionFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshComponentsSecSessList(), false );
		}
		return( tabViewComponentsSecSessListJPanel );
	}

	protected class RefreshChildrenSecProxyList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenSecProxyList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecSessionObj> dataCollection;
					ICFBamSecUserObj focus = getSwingFocusAsSecUser();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenSecProxy( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenSecProxyListJPanel();
					ICFBamSwingSecSessionJPanelList jpList = (ICFBamSwingSecSessionJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenSecProxyListJPanel() {
		if( tabViewChildrenSecProxyListJPanel == null ) {
			Collection<ICFBamSecSessionObj> dataCollection;
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenSecProxy( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSecUserObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSecUserObj ) ) {
				swingContainer = (ICFBamSecUserObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenSecProxyListJPanel = swingSchema.getSecSessionFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenSecProxyList(), false );
		}
		return( tabViewChildrenSecProxyListJPanel );
	}

	protected class RefreshChildrenSecGroupMemberList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenSecGroupMemberList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamSecGroupMemberObj> dataCollection;
					ICFBamSecUserObj focus = getSwingFocusAsSecUser();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenSecGroupMember( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenSecGroupMemberListJPanel();
					ICFBamSwingSecGroupMemberJPanelList jpList = (ICFBamSwingSecGroupMemberJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenSecGroupMemberListJPanel() {
		if( tabViewChildrenSecGroupMemberListJPanel == null ) {
			Collection<ICFBamSecGroupMemberObj> dataCollection;
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenSecGroupMember( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamSecGroupObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamSecGroupObj ) ) {
				swingContainer = (ICFBamSecGroupObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenSecGroupMemberListJPanel = swingSchema.getSecGroupMemberFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenSecGroupMemberList(), false );
		}
		return( tabViewChildrenSecGroupMemberListJPanel );
	}

	protected class RefreshChildrenTSecGroupMemberList
	implements ICFJRefreshCallback
	{
		public RefreshChildrenTSecGroupMemberList() {
		}

		public void refreshMe() {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					Collection<ICFBamTSecGroupMemberObj> dataCollection;
					ICFBamSecUserObj focus = getSwingFocusAsSecUser();
					if( focus != null ) {
						dataCollection = focus.getOptionalChildrenTSecGroupMember( swingIsInitializing );
					}
					else {
						dataCollection = null;
					}
					JPanel panel = getTabViewChildrenTSecGroupMemberListJPanel();
					ICFBamSwingTSecGroupMemberJPanelList jpList = (ICFBamSwingTSecGroupMemberJPanelList)panel;
					jpList.setSwingDataCollection( dataCollection );
				}
			}
		}
	}

	public JPanel getTabViewChildrenTSecGroupMemberListJPanel() {
		if( tabViewChildrenTSecGroupMemberListJPanel == null ) {
			Collection<ICFBamTSecGroupMemberObj> dataCollection;
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenTSecGroupMember( swingIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTSecGroupObj swingContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTSecGroupObj ) ) {
				swingContainer = (ICFBamTSecGroupObj)focus;
			}
			else {
				swingContainer = null;
			}
			tabViewChildrenTSecGroupMemberListJPanel = swingSchema.getTSecGroupMemberFactory().newListJPanel( null, swingContainer, dataCollection, new RefreshChildrenTSecGroupMemberList(), false );
		}
		return( tabViewChildrenTSecGroupMemberListJPanel );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		CFJPanel.PanelMode oldMode = getPanelMode();
		super.setPanelMode( value );
		if( tabViewComponentsSecDevListJPanel != null ) {
			((ICFBamSwingSecDeviceJPanelCommon)tabViewComponentsSecDevListJPanel).setPanelMode( value );
		}
		if( tabViewComponentsSecSessListJPanel != null ) {
			((ICFBamSwingSecSessionJPanelCommon)tabViewComponentsSecSessListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenSecProxyListJPanel != null ) {
			((ICFBamSwingSecSessionJPanelCommon)tabViewChildrenSecProxyListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenSecGroupMemberListJPanel != null ) {
			((ICFBamSwingSecGroupMemberJPanelCommon)tabViewChildrenSecGroupMemberListJPanel).setPanelMode( value );
		}
		if( tabViewChildrenTSecGroupMemberListJPanel != null ) {
			((ICFBamSwingTSecGroupMemberJPanelCommon)tabViewChildrenTSecGroupMemberListJPanel).setPanelMode( value );
		}
	}
}
