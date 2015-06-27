// Description: Java 7 Swing Attribute JPanel implementation for SecDevice.

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
 *	CFBamSwingSecDeviceAttrJPanel Swing Attribute JPanel implementation
 *	for SecDevice.
 */
public class CFBamSwingSecDeviceAttrJPanel
extends CFJPanel
implements ICFBamSwingSecDeviceJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class SecDeviceSecUserJLabel
		extends JLabel
	{
		public SecDeviceSecUserJLabel() {
			super();
			setText( "Security User" );
		}
	}

	protected class CallbackSecDeviceSecUserChosen
	implements ICFBamSwingSecUserChosen
	{
		public CallbackSecDeviceSecUserChosen() {
		}

		public void choseSecUser( ICFBamSecUserObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerSecUser != null ) {
						ICFBamSecDeviceObj cur = getSwingFocusAsSecDevice();
						if( cur != null ) {
							ICFBamSecDeviceEditObj editObj = (ICFBamSecDeviceEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerSecUser.setReferencedObject( value );
									editObj.setRequiredContainerSecUser( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecDeviceSecUserReference
	extends AbstractAction
	{
		public ActionViewSecDeviceSecUserReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
			if( focus != null ) {
				ICFBamSecDeviceEditObj editObj  = (ICFBamSecDeviceEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecUserObj referencedObj = focus.getRequiredContainerSecUser( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SUSR".equals( classCode ) ) {
						frame = swingSchema.getSecUserFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecUserObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecDeviceSecUserReference
	extends AbstractAction
	{
		public ActionPickSecDeviceSecUserReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
			ICFBamSecDeviceEditObj editObj  = (ICFBamSecDeviceEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecUserObj referencedObj = focus.getRequiredContainerSecUser( swingIsInitializing );
			java.util.List<ICFBamSecUserObj> listOfSecUser = null;
			listOfSecUser = schemaObj.getSecUserTableObj().readAllSecUser();
			if( listOfSecUser == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecUser" );
			}
			Collection<ICFBamSecUserObj> cltn = listOfSecUser;
			JInternalFrame frame = swingSchema.getSecUserFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecDeviceSecUserChosen() );
			((ICFBamSwingSecUserJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecDeviceSecUserCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecDeviceSecUserCFJReferenceEditor() {
			super( new ActionPickSecDeviceSecUserReference(), new ActionViewSecDeviceSecUserReference() );
		}
	}

	protected class DevNameJLabel
		extends JLabel
	{
		public DevNameJLabel() {
			super();
			setText( "Device Name" );
		}
	}

	protected class DevNameJEditor
		extends CFJStringEditor
	{
		public DevNameJEditor() {
			super();
			setMaxLen( 127 );
		}
	}

	protected class PubKeyJLabel
		extends JLabel
	{
		public PubKeyJLabel() {
			super();
			setText( "Device Public Key" );
		}
	}

	protected class PubKeyJEditor
		extends CFJTextEditor
	{
		public PubKeyJEditor() {
			super();
			setMaxLen( 10000 );
		}
	}

	protected ICFBamSecUserObj swingContainerSecUserObj = null;
	protected SecDeviceSecUserJLabel swingLabelContainerSecUser = null;
	protected SecDeviceSecUserCFJReferenceEditor swingReferenceContainerSecUser = null;
	protected DevNameJLabel swingLabelDevName = null;
	protected DevNameJEditor swingEditorDevName = null;
	protected PubKeyJLabel swingLabelPubKey = null;
	protected PubKeyJEditor swingEditorPubKey = null;

	public CFBamSwingSecDeviceAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSecDeviceObj argFocus ) {
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
		setSwingFocusAsSecDevice( argFocus );
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

		label = getSwingLabelContainerSecUser();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSecUser();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDevName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDevName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelPubKey();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPubKey();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

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
		if( ( value == null ) || ( value instanceof ICFBamSecDeviceObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSecDeviceObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSecDeviceObj getSwingFocusAsSecDevice() {
		return( (ICFBamSecDeviceObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecDevice( ICFBamSecDeviceObj value ) {
		setSwingFocus( value );
	}

	public ICFBamSecUserObj getSwingContainerSecUserObj() {
		if( swingContainerSecUserObj == null ) {
		}
		return( swingContainerSecUserObj );
	}

	public void setSwingContainerSecUserObj( ICFBamSecUserObj value ) {
		swingContainerSecUserObj = value;
	}

	public SecDeviceSecUserJLabel getSwingLabelContainerSecUser() {
		if( swingLabelContainerSecUser == null ) {
			swingLabelContainerSecUser = new SecDeviceSecUserJLabel();
		}
		return( swingLabelContainerSecUser );
	}

	public SecDeviceSecUserCFJReferenceEditor getSwingReferenceContainerSecUser() {
		if( swingReferenceContainerSecUser == null ) {
			swingReferenceContainerSecUser = new SecDeviceSecUserCFJReferenceEditor();
		}
		return( swingReferenceContainerSecUser );
	}

	public void setSwingReferenceContainerSecUser( SecDeviceSecUserCFJReferenceEditor value ) {
		swingReferenceContainerSecUser = value;
	}

	public DevNameJLabel getSwingLabelDevName() {
		if( swingLabelDevName == null ) {
			swingLabelDevName = new DevNameJLabel();
		}
		return( swingLabelDevName );
	}

	public void setSwingLabelDevName( DevNameJLabel value ) {
		swingLabelDevName = value;
	}

	public DevNameJEditor getSwingEditorDevName() {
		if( swingEditorDevName == null ) {
			swingEditorDevName = new DevNameJEditor();
		}
		return( swingEditorDevName );
	}

	public void setSwingEditorDevName( DevNameJEditor value ) {
		swingEditorDevName = value;
	}

	public PubKeyJLabel getSwingLabelPubKey() {
		if( swingLabelPubKey == null ) {
			swingLabelPubKey = new PubKeyJLabel();
		}
		return( swingLabelPubKey );
	}

	public void setSwingLabelPubKey( PubKeyJLabel value ) {
		swingLabelPubKey = value;
	}

	public PubKeyJEditor getSwingEditorPubKey() {
		if( swingEditorPubKey == null ) {
			swingEditorPubKey = new PubKeyJEditor();
		}
		return( swingEditorPubKey );
	}

	public void setSwingEditorPubKey( PubKeyJEditor value ) {
		swingEditorPubKey = value;
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

		label = getSwingLabelContainerSecUser();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSecUser();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDevName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDevName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelPubKey();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPubKey();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

	}

	public void populateFields()
	{
		ICFBamSecDeviceObj popObj;
		ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
		if( focus != null ) {
			popObj = (ICFBamSecDeviceObj)(focus.getEdit());
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
			swingContainerSecUserObj = null;
		}
		else {
			swingContainerSecUserObj = popObj.getRequiredContainerSecUser( swingIsInitializing );
		}
		if( swingReferenceContainerSecUser != null ) {
			swingReferenceContainerSecUser.setReferencedObject( swingContainerSecUserObj );
		}

		if( popObj == null ) {
			getSwingEditorDevName().setStringValue( null );
		}
		else {
			getSwingEditorDevName().setStringValue( popObj.getRequiredDevName() );
		}

		if( popObj == null ) {
			getSwingEditorPubKey().setTextValue( null );
		}
		else {
			getSwingEditorPubKey().setTextValue( popObj.getOptionalPubKey() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
		ICFBamSecDeviceEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSecDeviceEditObj)(focus.getEdit());
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

		editObj.setOptionalPubKey( getSwingEditorPubKey().getTextValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSecDeviceEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSecDeviceEditObj)focus.getEdit();
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
								editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
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
						focus = (ICFBamSecDeviceObj)editObj.create();
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
								editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
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
								editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecDeviceEditObj)focus.beginEdit();
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
			ICFBamSecDeviceObj focus = getSwingFocusAsSecDevice();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceContainerSecUser != null ) {
			swingReferenceContainerSecUser.setEnabled( false );
		}
		if( swingEditorDevName != null ) {
			swingEditorDevName.setEnabled( false );
		}
		if( swingEditorPubKey != null ) {
			swingEditorPubKey.setEnabled( isEditing );
		}
	}
}
