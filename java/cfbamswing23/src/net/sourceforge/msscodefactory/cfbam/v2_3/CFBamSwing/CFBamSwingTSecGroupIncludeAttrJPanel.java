// Description: Java 7 Swing Attribute JPanel implementation for TSecGroupInclude.

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
 *	CFBamSwingTSecGroupIncludeAttrJPanel Swing Attribute JPanel implementation
 *	for TSecGroupInclude.
 */
public class CFBamSwingTSecGroupIncludeAttrJPanel
extends CFJPanel
implements ICFBamSwingTSecGroupIncludeJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class TSecGroupIncludeTenantJLabel
		extends JLabel
	{
		public TSecGroupIncludeTenantJLabel() {
			super();
			setText( "Tenant" );
		}
	}

	protected class CallbackTSecGroupIncludeTenantChosen
	implements ICFBamSwingTenantChosen
	{
		public CallbackTSecGroupIncludeTenantChosen() {
		}

		public void choseTenant( ICFBamTenantObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerTenant != null ) {
						ICFBamTSecGroupIncludeObj cur = getSwingFocusAsTSecGroupInclude();
						if( cur != null ) {
							ICFBamTSecGroupIncludeEditObj editObj = (ICFBamTSecGroupIncludeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerTenant.setReferencedObject( value );
									editObj.setRequiredOwnerTenant( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTSecGroupIncludeTenantReference
	extends AbstractAction
	{
		public ActionViewTSecGroupIncludeTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			if( focus != null ) {
				ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTenantObj referencedObj = focus.getRequiredOwnerTenant( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "TENT".equals( classCode ) ) {
						frame = swingSchema.getTenantFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamTenantObj" );
					}
				}
			}
		}
	}

	protected class ActionPickTSecGroupIncludeTenantReference
	extends AbstractAction
	{
		public ActionPickTSecGroupIncludeTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTenantObj referencedObj = focus.getRequiredOwnerTenant( swingIsInitializing );
			java.util.List<ICFBamTenantObj> listOfTenant = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfTenant = schemaObj.getTenantTableObj().readTenantByClusterIdx( containingClusterId );
			if( listOfTenant == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTenant" );
			}
			Collection<ICFBamTenantObj> cltn = listOfTenant;
			JInternalFrame frame = swingSchema.getTenantFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTSecGroupIncludeTenantChosen() );
			((ICFBamSwingTenantJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class TSecGroupIncludeTenantCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TSecGroupIncludeTenantCFJReferenceEditor() {
			super( new ActionPickTSecGroupIncludeTenantReference(), new ActionViewTSecGroupIncludeTenantReference() );
		}
	}

	protected class TSecGroupIncludeGroupJLabel
		extends JLabel
	{
		public TSecGroupIncludeGroupJLabel() {
			super();
			setText( "Group" );
		}
	}

	protected class CallbackTSecGroupIncludeGroupChosen
	implements ICFBamSwingTSecGroupChosen
	{
		public CallbackTSecGroupIncludeGroupChosen() {
		}

		public void choseTSecGroup( ICFBamTSecGroupObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerGroup != null ) {
						ICFBamTSecGroupIncludeObj cur = getSwingFocusAsTSecGroupInclude();
						if( cur != null ) {
							ICFBamTSecGroupIncludeEditObj editObj = (ICFBamTSecGroupIncludeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerGroup.setReferencedObject( value );
									editObj.setRequiredContainerGroup( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTSecGroupIncludeGroupReference
	extends AbstractAction
	{
		public ActionViewTSecGroupIncludeGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			if( focus != null ) {
				ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTSecGroupObj referencedObj = focus.getRequiredContainerGroup( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "TGRP".equals( classCode ) ) {
						frame = swingSchema.getTSecGroupFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamTSecGroupObj" );
					}
				}
			}
		}
	}

	protected class ActionPickTSecGroupIncludeGroupReference
	extends AbstractAction
	{
		public ActionPickTSecGroupIncludeGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTSecGroupObj referencedObj = focus.getRequiredContainerGroup( swingIsInitializing );
			java.util.List<ICFBamTSecGroupObj> listOfTSecGroup = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingTenantId = auth.getSecTenantId();
			listOfTSecGroup = schemaObj.getTSecGroupTableObj().readTSecGroupByTenantIdx( containingTenantId );
			if( listOfTSecGroup == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTSecGroup" );
			}
			Collection<ICFBamTSecGroupObj> cltn = listOfTSecGroup;
			JInternalFrame frame = swingSchema.getTSecGroupFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTSecGroupIncludeGroupChosen() );
			((ICFBamSwingTSecGroupJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class TSecGroupIncludeGroupCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TSecGroupIncludeGroupCFJReferenceEditor() {
			super( new ActionPickTSecGroupIncludeGroupReference(), new ActionViewTSecGroupIncludeGroupReference() );
		}
	}

	protected class TSecGroupIncludeSubGroupJLabel
		extends JLabel
	{
		public TSecGroupIncludeSubGroupJLabel() {
			super();
			setText( "SubGroup" );
		}
	}

	protected class CallbackTSecGroupIncludeSubGroupChosen
	implements ICFBamSwingTSecGroupChosen
	{
		public CallbackTSecGroupIncludeSubGroupChosen() {
		}

		public void choseTSecGroup( ICFBamTSecGroupObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceParentSubGroup != null ) {
						ICFBamTSecGroupIncludeObj cur = getSwingFocusAsTSecGroupInclude();
						if( cur != null ) {
							ICFBamTSecGroupIncludeEditObj editObj = (ICFBamTSecGroupIncludeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceParentSubGroup.setReferencedObject( value );
									editObj.setRequiredParentSubGroup( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTSecGroupIncludeSubGroupReference
	extends AbstractAction
	{
		public ActionViewTSecGroupIncludeSubGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			if( focus != null ) {
				ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTSecGroupObj referencedObj = focus.getRequiredParentSubGroup( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "TGRP".equals( classCode ) ) {
						frame = swingSchema.getTSecGroupFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamTSecGroupObj" );
					}
				}
			}
		}
	}

	protected class ActionPickTSecGroupIncludeSubGroupReference
	extends AbstractAction
	{
		public ActionPickTSecGroupIncludeSubGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			ICFBamTSecGroupIncludeEditObj editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTSecGroupObj referencedObj = focus.getRequiredParentSubGroup( swingIsInitializing );
			java.util.List<ICFBamTSecGroupObj> listOfTSecGroup = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingTenantId = auth.getSecTenantId();
			listOfTSecGroup = schemaObj.getTSecGroupTableObj().readTSecGroupByTenantIdx( containingTenantId );
			if( listOfTSecGroup == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTSecGroup" );
			}
			Collection<ICFBamTSecGroupObj> cltn = listOfTSecGroup;
			JInternalFrame frame = swingSchema.getTSecGroupFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTSecGroupIncludeSubGroupChosen() );
			((ICFBamSwingTSecGroupJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class TSecGroupIncludeSubGroupCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TSecGroupIncludeSubGroupCFJReferenceEditor() {
			super( new ActionPickTSecGroupIncludeSubGroupReference(), new ActionViewTSecGroupIncludeSubGroupReference() );
		}
	}

	protected class TSecGroupIncludeIdJLabel
		extends JLabel
	{
		public TSecGroupIncludeIdJLabel() {
			super();
			setText( "TSecurity Group Include Id" );
		}
	}

	protected class TSecGroupIncludeIdJEditor
		extends CFJInt64Editor
	{
		public TSecGroupIncludeIdJEditor() {
			super();
			setMinValue( 0L );
		}
	}

	protected ICFBamTenantObj swingOwnerTenantObj = null;
	protected TSecGroupIncludeTenantJLabel swingLabelOwnerTenant = null;
	protected TSecGroupIncludeTenantCFJReferenceEditor swingReferenceOwnerTenant = null;
	protected ICFBamTSecGroupObj swingContainerGroupObj = null;
	protected TSecGroupIncludeGroupJLabel swingLabelContainerGroup = null;
	protected TSecGroupIncludeGroupCFJReferenceEditor swingReferenceContainerGroup = null;
	protected ICFBamTSecGroupObj swingParentSubGroupObj = null;
	protected TSecGroupIncludeSubGroupJLabel swingLabelParentSubGroup = null;
	protected TSecGroupIncludeSubGroupCFJReferenceEditor swingReferenceParentSubGroup = null;
	protected TSecGroupIncludeIdJLabel swingLabelTSecGroupIncludeId = null;
	protected TSecGroupIncludeIdJEditor swingEditorTSecGroupIncludeId = null;

	public CFBamSwingTSecGroupIncludeAttrJPanel( ICFBamSwingSchema argSchema, ICFBamTSecGroupIncludeObj argFocus ) {
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
		setSwingFocusAsTSecGroupInclude( argFocus );
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

		label = getSwingLabelOwnerTenant();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerTenant();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerGroup();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerGroup();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSubGroup();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSubGroup();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelTSecGroupIncludeId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTSecGroupIncludeId();
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
		if( ( value == null ) || ( value instanceof ICFBamTSecGroupIncludeObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTSecGroupIncludeObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamTSecGroupIncludeObj getSwingFocusAsTSecGroupInclude() {
		return( (ICFBamTSecGroupIncludeObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsTSecGroupInclude( ICFBamTSecGroupIncludeObj value ) {
		setSwingFocus( value );
	}

	public ICFBamTenantObj getSwingOwnerTenantObj() {
		return( swingOwnerTenantObj );
	}

	public void setSwingOwnerTenantObj( ICFBamTenantObj value ) {
		swingOwnerTenantObj = value;
	}

	public TSecGroupIncludeTenantJLabel getSwingLabelOwnerTenant() {
		if( swingLabelOwnerTenant == null ) {
			swingLabelOwnerTenant = new TSecGroupIncludeTenantJLabel();
		}
		return( swingLabelOwnerTenant );
	}

	public CFJReferenceEditor getSwingReferenceOwnerTenant() {
		if( swingReferenceOwnerTenant == null ) {
			swingReferenceOwnerTenant = new TSecGroupIncludeTenantCFJReferenceEditor();
		}
		return( swingReferenceOwnerTenant );
	}

	public void setSwingReferenceOwnerTenant( TSecGroupIncludeTenantCFJReferenceEditor value ) {
		swingReferenceOwnerTenant = value;
	}

	public ICFBamTSecGroupObj getSwingContainerGroupObj() {
		if( swingContainerGroupObj == null ) {
		}
		return( swingContainerGroupObj );
	}

	public void setSwingContainerGroupObj( ICFBamTSecGroupObj value ) {
		swingContainerGroupObj = value;
	}

	public TSecGroupIncludeGroupJLabel getSwingLabelContainerGroup() {
		if( swingLabelContainerGroup == null ) {
			swingLabelContainerGroup = new TSecGroupIncludeGroupJLabel();
		}
		return( swingLabelContainerGroup );
	}

	public TSecGroupIncludeGroupCFJReferenceEditor getSwingReferenceContainerGroup() {
		if( swingReferenceContainerGroup == null ) {
			swingReferenceContainerGroup = new TSecGroupIncludeGroupCFJReferenceEditor();
		}
		return( swingReferenceContainerGroup );
	}

	public void setSwingReferenceContainerGroup( TSecGroupIncludeGroupCFJReferenceEditor value ) {
		swingReferenceContainerGroup = value;
	}

	public ICFBamTSecGroupObj getSwingParentSubGroupObj() {
		return( swingParentSubGroupObj );
	}

	public void setSwingParentSubGroupObj( ICFBamTSecGroupObj value ) {
		swingParentSubGroupObj = value;
	}

	public JLabel getSwingLabelParentSubGroup() {
		if( swingLabelParentSubGroup == null ) {
			swingLabelParentSubGroup = new TSecGroupIncludeSubGroupJLabel();
		}
		return( swingLabelParentSubGroup );
	}

	public CFJReferenceEditor getSwingReferenceParentSubGroup() {
		if( swingReferenceParentSubGroup == null ) {
			swingReferenceParentSubGroup = new TSecGroupIncludeSubGroupCFJReferenceEditor();
		}
		return( swingReferenceParentSubGroup );
	}

	public void setSwingReferenceParentSubGroup( TSecGroupIncludeSubGroupCFJReferenceEditor value ) {
		swingReferenceParentSubGroup = value;
	}

	public TSecGroupIncludeIdJLabel getSwingLabelTSecGroupIncludeId() {
		if( swingLabelTSecGroupIncludeId == null ) {
			swingLabelTSecGroupIncludeId = new TSecGroupIncludeIdJLabel();
		}
		return( swingLabelTSecGroupIncludeId );
	}

	public void setSwingLabelTSecGroupIncludeId( TSecGroupIncludeIdJLabel value ) {
		swingLabelTSecGroupIncludeId = value;
	}

	public TSecGroupIncludeIdJEditor getSwingEditorTSecGroupIncludeId() {
		if( swingEditorTSecGroupIncludeId == null ) {
			swingEditorTSecGroupIncludeId = new TSecGroupIncludeIdJEditor();
		}
		return( swingEditorTSecGroupIncludeId );
	}

	public void setSwingEditorTSecGroupIncludeId( TSecGroupIncludeIdJEditor value ) {
		swingEditorTSecGroupIncludeId = value;
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

		label = getSwingLabelOwnerTenant();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerTenant();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerGroup();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerGroup();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSubGroup();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSubGroup();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelTSecGroupIncludeId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTSecGroupIncludeId();
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
		ICFBamTSecGroupIncludeObj popObj;
		ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
		if( focus != null ) {
			popObj = (ICFBamTSecGroupIncludeObj)(focus.getEdit());
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
			swingOwnerTenantObj = null;
		}
		else {
			swingOwnerTenantObj = popObj.getRequiredOwnerTenant( swingIsInitializing );
		}
		if( swingReferenceOwnerTenant != null ) {
			swingReferenceOwnerTenant.setReferencedObject( swingOwnerTenantObj );
		}

		if( popObj == null ) {
			swingContainerGroupObj = null;
		}
		else {
			swingContainerGroupObj = popObj.getRequiredContainerGroup( swingIsInitializing );
		}
		if( swingReferenceContainerGroup != null ) {
			swingReferenceContainerGroup.setReferencedObject( swingContainerGroupObj );
		}

		if( popObj == null ) {
			swingParentSubGroupObj = null;
		}
		else {
			swingParentSubGroupObj = popObj.getRequiredParentSubGroup( swingIsInitializing );
		}
		if( swingReferenceParentSubGroup != null ) {
			swingReferenceParentSubGroup.setReferencedObject( swingParentSubGroupObj );
		}

		if( popObj == null ) {
			getSwingEditorTSecGroupIncludeId().setInt64Value( null );
		}
		else {
			getSwingEditorTSecGroupIncludeId().setInt64Value( popObj.getRequiredTSecGroupIncludeId() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
		ICFBamTSecGroupIncludeEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamTSecGroupIncludeEditObj)(focus.getEdit());
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

		swingParentSubGroupObj = (ICFBamTSecGroupObj)( swingReferenceParentSubGroup.getReferencedObject() );
		editObj.setRequiredParentSubGroup( swingParentSubGroupObj );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamTSecGroupIncludeEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamTSecGroupIncludeEditObj)focus.getEdit();
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
								editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
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
							editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
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
						focus = (ICFBamTSecGroupIncludeObj)editObj.create();
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
								editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
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
								editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
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
							editObj = (ICFBamTSecGroupIncludeEditObj)focus.beginEdit();
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
			ICFBamTSecGroupIncludeObj focus = getSwingFocusAsTSecGroupInclude();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerTenant != null ) {
			swingReferenceOwnerTenant.setEnabled( false );
		}
		if( swingReferenceContainerGroup != null ) {
			swingReferenceContainerGroup.setEnabled( false );
		}
		if( swingReferenceParentSubGroup != null ) {
			swingReferenceParentSubGroup.setEnabled( isEditing );
		}
		if( swingEditorTSecGroupIncludeId != null ) {
			swingEditorTSecGroupIncludeId.setEnabled( false );
		}
	}
}
