// Description: Java 7 Swing Attribute JPanel implementation for Service.

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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingServiceAttrJPanel Swing Attribute JPanel implementation
 *	for Service.
 */
public class CFBamSwingServiceAttrJPanel
extends CFJPanel
implements ICFBamSwingServiceJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class ServiceClusterJLabel
		extends JLabel
	{
		public ServiceClusterJLabel() {
			super();
			setText( "Cluster" );
		}
	}

	protected class CallbackServiceClusterChosen
	implements ICFBamSwingClusterChosen
	{
		public CallbackServiceClusterChosen() {
		}

		public void choseCluster( ICFBamClusterObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerCluster != null ) {
						ICFBamServiceObj cur = getSwingFocusAsService();
						if( cur != null ) {
							ICFBamServiceEditObj editObj = (ICFBamServiceEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerCluster.setReferencedObject( value );
									editObj.setRequiredOwnerCluster( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewServiceClusterReference
	extends AbstractAction
	{
		public ActionViewServiceClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamServiceObj focus = getSwingFocusAsService();
			if( focus != null ) {
				ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamClusterObj referencedObj = focus.getRequiredOwnerCluster( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "CLUS".equals( classCode ) ) {
						frame = swingSchema.getClusterFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"swingFocus",
							focus,
							"ICFBamClusterObj" );
					}
				}
			}
		}
	}

	protected class ActionPickServiceClusterReference
	extends AbstractAction
	{
		public ActionPickServiceClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServiceObj focus = getSwingFocusAsService();
			ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamClusterObj referencedObj = focus.getRequiredOwnerCluster( swingIsInitializing );
			java.util.List<ICFBamClusterObj> listOfCluster = null;
			listOfCluster = schemaObj.getClusterTableObj().readAllCluster();
			if( listOfCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfCluster" );
			}
			Collection<ICFBamClusterObj> cltn = listOfCluster;
			JInternalFrame frame = swingSchema.getClusterFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackServiceClusterChosen() );
			((ICFBamSwingClusterJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				JInternalFrame myInternalFrame = (JInternalFrame)cont;
				myInternalFrame.getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	protected class ServiceClusterCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ServiceClusterCFJReferenceEditor() {
			super( new ActionPickServiceClusterReference(), new ActionViewServiceClusterReference() );
		}
	}

	protected class ServiceHostJLabel
		extends JLabel
	{
		public ServiceHostJLabel() {
			super();
			setText( "Host" );
		}
	}

	protected class CallbackServiceHostChosen
	implements ICFBamSwingHostNodeChosen
	{
		public CallbackServiceHostChosen() {
		}

		public void choseHostNode( ICFBamHostNodeObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerHost != null ) {
						ICFBamServiceObj cur = getSwingFocusAsService();
						if( cur != null ) {
							ICFBamServiceEditObj editObj = (ICFBamServiceEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerHost.setReferencedObject( value );
									editObj.setOptionalContainerHost( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewServiceHostReference
	extends AbstractAction
	{
		public ActionViewServiceHostReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamServiceObj focus = getSwingFocusAsService();
			if( focus != null ) {
				ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamHostNodeObj referencedObj = focus.getOptionalContainerHost( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "HSND".equals( classCode ) ) {
						frame = swingSchema.getHostNodeFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"swingFocus",
							focus,
							"ICFBamHostNodeObj" );
					}
				}
			}
		}
	}

	protected class ActionPickServiceHostReference
	extends AbstractAction
	{
		public ActionPickServiceHostReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServiceObj focus = getSwingFocusAsService();
			ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamHostNodeObj referencedObj = focus.getOptionalContainerHost( swingIsInitializing );
			java.util.List<ICFBamHostNodeObj> listOfHostNode = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfHostNode = schemaObj.getHostNodeTableObj().readHostNodeByClusterIdx( containingClusterId );
			if( listOfHostNode == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfHostNode" );
			}
			Collection<ICFBamHostNodeObj> cltn = listOfHostNode;
			JInternalFrame frame = swingSchema.getHostNodeFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackServiceHostChosen() );
			((ICFBamSwingHostNodeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				JInternalFrame myInternalFrame = (JInternalFrame)cont;
				myInternalFrame.getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	protected class ServiceHostCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ServiceHostCFJReferenceEditor() {
			super( new ActionPickServiceHostReference(), new ActionViewServiceHostReference() );
		}
	}

	protected class ServiceSvcTypeJLabel
		extends JLabel
	{
		public ServiceSvcTypeJLabel() {
			super();
			setText( "Service Type" );
		}
	}

	protected class CallbackServiceSvcTypeChosen
	implements ICFBamSwingServiceTypeChosen
	{
		public CallbackServiceSvcTypeChosen() {
		}

		public void choseServiceType( ICFBamServiceTypeObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceParentServiceType != null ) {
						ICFBamServiceObj cur = getSwingFocusAsService();
						if( cur != null ) {
							ICFBamServiceEditObj editObj = (ICFBamServiceEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceParentServiceType.setReferencedObject( value );
									editObj.setOptionalParentServiceType( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewServiceSvcTypeReference
	extends AbstractAction
	{
		public ActionViewServiceSvcTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamServiceObj focus = getSwingFocusAsService();
			if( focus != null ) {
				ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamServiceTypeObj referencedObj = focus.getOptionalParentServiceType( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SVCT".equals( classCode ) ) {
						frame = swingSchema.getServiceTypeFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"swingFocus",
							focus,
							"ICFBamServiceTypeObj" );
					}
				}
			}
		}
	}

	protected class ActionPickServiceSvcTypeReference
	extends AbstractAction
	{
		public ActionPickServiceSvcTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServiceObj focus = getSwingFocusAsService();
			ICFBamServiceEditObj editObj  = (ICFBamServiceEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamServiceTypeObj referencedObj = focus.getOptionalParentServiceType( swingIsInitializing );
			java.util.List<ICFBamServiceTypeObj> listOfServiceType = null;
			listOfServiceType = schemaObj.getServiceTypeTableObj().readAllServiceType();
			if( listOfServiceType == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfServiceType" );
			}
			Collection<ICFBamServiceTypeObj> cltn = listOfServiceType;
			JInternalFrame frame = swingSchema.getServiceTypeFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackServiceSvcTypeChosen() );
			((ICFBamSwingServiceTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				JInternalFrame myInternalFrame = (JInternalFrame)cont;
				myInternalFrame.getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	protected class ServiceSvcTypeCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ServiceSvcTypeCFJReferenceEditor() {
			super( new ActionPickServiceSvcTypeReference(), new ActionViewServiceSvcTypeReference() );
		}
	}

	protected class ServiceIdJLabel
		extends JLabel
	{
		public ServiceIdJLabel() {
			super();
			setText( "Service Id" );
		}
	}

	protected class ServiceIdJEditor
		extends CFJInt64Editor
	{
		public ServiceIdJEditor() {
			super();
			setMinValue( 0L );
		}
	}

	protected class HostPortJLabel
		extends JLabel
	{
		public HostPortJLabel() {
			super();
			setText( "Host Port" );
		}
	}

	protected class HostPortJEditor
		extends CFJInt16Editor
	{
		public HostPortJEditor() {
			super();
			setMinValue( (short)0 );
		}
	}

	protected ICFBamClusterObj swingOwnerClusterObj = null;
	protected ServiceClusterJLabel swingLabelOwnerCluster = null;
	protected ServiceClusterCFJReferenceEditor swingReferenceOwnerCluster = null;
	protected ICFBamHostNodeObj swingContainerHostObj = null;
	protected ServiceHostJLabel swingLabelContainerHost = null;
	protected ServiceHostCFJReferenceEditor swingReferenceContainerHost = null;
	protected ICFBamServiceTypeObj swingParentServiceTypeObj = null;
	protected ServiceSvcTypeJLabel swingLabelParentServiceType = null;
	protected ServiceSvcTypeCFJReferenceEditor swingReferenceParentServiceType = null;
	protected ServiceIdJLabel swingLabelServiceId = null;
	protected ServiceIdJEditor swingEditorServiceId = null;
	protected HostPortJLabel swingLabelHostPort = null;
	protected HostPortJEditor swingEditorHostPort = null;

	public CFBamSwingServiceAttrJPanel( ICFBamSwingSchema argSchema, ICFBamServiceObj argFocus ) {
		super();
		JLabel label;
		JComponent compo;
		CFJReferenceEditor reference;
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
		setSwingFocusAsService( argFocus );
		final int spacing = 5;
		int y = spacing;
		final int height = 25;
		final int textheight = 80;
		final int vspacing = height + spacing;
		final int textvspacing = textheight + spacing;
		final int labelx = spacing;
		final int labelwidth = 200;
		final int fieldx = labelx + labelwidth + spacing;
		final int fieldwidth = 785;
		final int panelwidth = fieldx + fieldwidth + spacing;
		// temporary -- I think you have to have a panel bigger than the coordinates initially
		setSize( panelwidth, 100000 );

		label = getSwingLabelOwnerCluster();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCluster();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerHost();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerHost();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentServiceType();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentServiceType();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelServiceId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorServiceId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHostPort();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostPort();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		// Now we can set the proper size based on the fields and references populated
		setSize( panelwidth, y );
		Dimension pfsz = new Dimension( panelwidth, y );
		setPreferredSize( pfsz );
		Dimension min = new Dimension( 400, y );
		setMinimumSize( min );
		populateFields();
		adjustComponentEnableStates();
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamServiceObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamServiceObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamServiceObj getSwingFocusAsService() {
		return( (ICFBamServiceObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsService( ICFBamServiceObj value ) {
		setSwingFocus( value );
	}

	public ICFBamClusterObj getSwingOwnerClusterObj() {
		return( swingOwnerClusterObj );
	}

	public void setSwingOwnerClusterObj( ICFBamClusterObj value ) {
		swingOwnerClusterObj = value;
	}

	public ServiceClusterJLabel getSwingLabelOwnerCluster() {
		if( swingLabelOwnerCluster == null ) {
			swingLabelOwnerCluster = new ServiceClusterJLabel();
		}
		return( swingLabelOwnerCluster );
	}

	public CFJReferenceEditor getSwingReferenceOwnerCluster() {
		if( swingReferenceOwnerCluster == null ) {
			swingReferenceOwnerCluster = new ServiceClusterCFJReferenceEditor();
		}
		return( swingReferenceOwnerCluster );
	}

	public void setSwingReferenceOwnerCluster( ServiceClusterCFJReferenceEditor value ) {
		swingReferenceOwnerCluster = value;
	}

	public ICFBamHostNodeObj getSwingContainerHostObj() {
		if( swingContainerHostObj == null ) {
		}
		return( swingContainerHostObj );
	}

	public void setSwingContainerHostObj( ICFBamHostNodeObj value ) {
		swingContainerHostObj = value;
	}

	public ServiceHostJLabel getSwingLabelContainerHost() {
		if( swingLabelContainerHost == null ) {
			swingLabelContainerHost = new ServiceHostJLabel();
		}
		return( swingLabelContainerHost );
	}

	public ServiceHostCFJReferenceEditor getSwingReferenceContainerHost() {
		if( swingReferenceContainerHost == null ) {
			swingReferenceContainerHost = new ServiceHostCFJReferenceEditor();
		}
		return( swingReferenceContainerHost );
	}

	public void setSwingReferenceContainerHost( ServiceHostCFJReferenceEditor value ) {
		swingReferenceContainerHost = value;
	}

	public ICFBamServiceTypeObj getSwingParentServiceTypeObj() {
		return( swingParentServiceTypeObj );
	}

	public void setSwingParentServiceTypeObj( ICFBamServiceTypeObj value ) {
		swingParentServiceTypeObj = value;
	}

	public JLabel getSwingLabelParentServiceType() {
		if( swingLabelParentServiceType == null ) {
			swingLabelParentServiceType = new ServiceSvcTypeJLabel();
		}
		return( swingLabelParentServiceType );
	}

	public CFJReferenceEditor getSwingReferenceParentServiceType() {
		if( swingReferenceParentServiceType == null ) {
			swingReferenceParentServiceType = new ServiceSvcTypeCFJReferenceEditor();
		}
		return( swingReferenceParentServiceType );
	}

	public void setSwingReferenceParentServiceType( ServiceSvcTypeCFJReferenceEditor value ) {
		swingReferenceParentServiceType = value;
	}

	public ServiceIdJLabel getSwingLabelServiceId() {
		if( swingLabelServiceId == null ) {
			swingLabelServiceId = new ServiceIdJLabel();
		}
		return( swingLabelServiceId );
	}

	public void setSwingLabelServiceId( ServiceIdJLabel value ) {
		swingLabelServiceId = value;
	}

	public ServiceIdJEditor getSwingEditorServiceId() {
		if( swingEditorServiceId == null ) {
			swingEditorServiceId = new ServiceIdJEditor();
		}
		return( swingEditorServiceId );
	}

	public void setSwingEditorServiceId( ServiceIdJEditor value ) {
		swingEditorServiceId = value;
	}

	public HostPortJLabel getSwingLabelHostPort() {
		if( swingLabelHostPort == null ) {
			swingLabelHostPort = new HostPortJLabel();
		}
		return( swingLabelHostPort );
	}

	public void setSwingLabelHostPort( HostPortJLabel value ) {
		swingLabelHostPort = value;
	}

	public HostPortJEditor getSwingEditorHostPort() {
		if( swingEditorHostPort == null ) {
			swingEditorHostPort = new HostPortJEditor();
		}
		return( swingEditorHostPort );
	}

	public void setSwingEditorHostPort( HostPortJEditor value ) {
		swingEditorHostPort = value;
	}

	public void doLayout() {
		JLabel label;
		JComponent compo;
		CFJReferenceEditor reference;
		Dimension dim;
		final int spacing = 5;
		int y = spacing;
		final int height = 25;
		final int textheight = 80;
		final int vspacing = height + spacing;
		final int textvspacing = textheight + spacing;
		final int labelx = spacing;
		final int labelwidth = 200;
		final int fieldx = labelx + labelwidth + spacing;
		final int fieldwidth = 1024;
		Dimension jpsz = getSize();
		int usefieldwidth = jpsz.width - 215;

		label = getSwingLabelOwnerCluster();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCluster();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerHost();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerHost();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentServiceType();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentServiceType();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelServiceId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorServiceId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelHostPort();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostPort();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

	}

	public void populateFields()
	{
		ICFBamServiceObj popObj;
		ICFBamServiceObj focus = getSwingFocusAsService();
		if( focus != null ) {
			popObj = (ICFBamServiceObj)(focus.getEdit());
			if( popObj == null ) {
				popObj = focus;
			}
		}
		else {
			popObj = null;
		}
		if( getPanelMode() == CFJPanel.PanelMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			swingOwnerClusterObj = null;
		}
		else {
			swingOwnerClusterObj = popObj.getRequiredOwnerCluster( swingIsInitializing );
		}
		if( swingReferenceOwnerCluster != null ) {
			swingReferenceOwnerCluster.setReferencedObject( swingOwnerClusterObj );
		}

		if( popObj == null ) {
			swingContainerHostObj = null;
		}
		else {
			swingContainerHostObj = popObj.getOptionalContainerHost( swingIsInitializing );
		}
		if( swingReferenceContainerHost != null ) {
			swingReferenceContainerHost.setReferencedObject( swingContainerHostObj );
		}

		if( popObj == null ) {
			swingParentServiceTypeObj = null;
		}
		else {
			swingParentServiceTypeObj = popObj.getOptionalParentServiceType( swingIsInitializing );
		}
		if( swingReferenceParentServiceType != null ) {
			swingReferenceParentServiceType.setReferencedObject( swingParentServiceTypeObj );
		}

		if( popObj == null ) {
			getSwingEditorServiceId().setInt64Value( null );
		}
		else {
			getSwingEditorServiceId().setInt64Value( popObj.getRequiredServiceId() );
		}

		if( popObj == null ) {
			getSwingEditorHostPort().setInt16Value( null );
		}
		else {
			getSwingEditorHostPort().setInt16Value( popObj.getRequiredHostPort() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamServiceObj focus = getSwingFocusAsService();
		ICFBamServiceEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamServiceEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Panel is unfocused or is not editing the focus object" );
		}
		// You are not allowed to edit the Container or Owner references, so they're not retrieved

		swingParentServiceTypeObj = (ICFBamServiceTypeObj)( swingReferenceParentServiceType.getReferencedObject() );
		editObj.setOptionalParentServiceType( swingParentServiceTypeObj );

		editObj.setRequiredHostPort( getSwingEditorHostPort().getInt16Value() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamServiceObj focus = getSwingFocusAsService();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamServiceEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamServiceEditObj)focus.getEdit();
		}
		else {
			editObj = null;
		}
		switch( value ) {
			case Unknown:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
						}
						break;
				}
				break;
			case Add:
				switch( oldValue ) {
					case Unknown:
					case Add:
					case View:
						if( editObj == null ) {
							if( focus != null ) {
								if( ! focus.getIsNew() ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Transitioning to PanelMode Add requires Focus.getIsNew() to be true" );
								}
								editObj = (ICFBamServiceEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
							else {
								throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
									S_ProcName,
									0,
									"focus" );
							}
						}
						break;
					case Edit:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Edit to Add" );
					case Update:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Update to Add" );
					case Delete:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Delete to Add" );
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode default to Add" );
				}
				break;
			case View:
				switch( oldValue ) {
					case Unknown:
						break;
					case View:
						break;
					case Edit:
						break;
					case Update:
						break;
					case Delete:
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to View" );
				}
				if( editObj != null ) {
					editObj.endEdit();
				}
				break;
			case Edit:
				switch( oldValue ) {
					case Unknown:
						if( editObj == null ) {
							editObj = (ICFBamServiceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamServiceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamServiceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to Edit" ); 
				}
				break;
			case Update:
				if( ( oldValue != CFJPanel.PanelMode.Edit ) && ( oldValue != CFJPanel.PanelMode.Add ) ) {
					throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
						S_ProcName,
						"Cannot transition from mode " + oldValue + " to Update" );
				}
				super.setPanelMode( value );
				if( editObj != null ) {
					postFields();
					if( editObj.getIsNew() ) {
						focus = (ICFBamServiceObj)editObj.create();
						setSwingFocus( focus );
					}
					else {
						editObj.update();
					}
					editObj.endEdit();
					editObj = null;
				}
				setPanelMode( CFJPanel.PanelMode.View );
				break;
			case Delete:
				switch( oldValue ) {
					case View:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFBamServiceEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Edit:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFBamServiceEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Update:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Update to Delete" ); 
					case Delete:
						if( editObj == null ) {
							editObj = (ICFBamServiceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to Delete" ); 
				}
				editObj.delete();
				editObj.endEdit();
				setSwingFocus( null );
				setPanelMode( CFJPanel.PanelMode.Unknown );
				break;
			default:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
						}
						break;
				}
				break;
		}
		super.setPanelMode( value );
		populateFields();
		adjustComponentEnableStates();
	}

	public void adjustComponentEnableStates() {
		CFJPanel.PanelMode mode = getPanelMode();
		boolean isEditing;
		switch( mode ) {
			case Unknown:
			case View:
			case Delete:
				isEditing = false;
				break;
			case Add:
			case Edit:
			case Update:
				isEditing = true;
				break;
			default:
				isEditing = false;
				break;
		}
		if( isEditing ) {
			ICFBamServiceObj focus = getSwingFocusAsService();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerCluster != null ) {
			swingReferenceOwnerCluster.setEnabled( false );
		}
		if( swingReferenceContainerHost != null ) {
			swingReferenceContainerHost.setEnabled( false );
		}
		if( swingReferenceParentServiceType != null ) {
			swingReferenceParentServiceType.setEnabled( isEditing );
		}
		if( swingEditorServiceId != null ) {
			swingEditorServiceId.setEnabled( false );
		}
		if( swingEditorHostPort != null ) {
			swingEditorHostPort.setEnabled( isEditing );
		}
	}
}
