// Description: Java 7 Swing Attribute JPanel implementation for SecUser.

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
 *	CFBamSwingSecUserAttrJPanel Swing Attribute JPanel implementation
 *	for SecUser.
 */
public class CFBamSwingSecUserAttrJPanel
extends CFJPanel
implements ICFBamSwingSecUserJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class SecUserDefDevJLabel
		extends JLabel
	{
		public SecUserDefDevJLabel() {
			super();
			setText( "Default Security Device" );
		}
	}

	protected class CallbackSecUserDefDevChosen
	implements ICFBamSwingSecDeviceChosen
	{
		public CallbackSecUserDefDevChosen() {
		}

		public void choseSecDevice( ICFBamSecDeviceObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupDefDev != null ) {
						ICFBamSecUserObj cur = getSwingFocusAsSecUser();
						if( cur != null ) {
							ICFBamSecUserEditObj editObj = (ICFBamSecUserEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupDefDev.setReferencedObject( value );
									editObj.setOptionalLookupDefDev( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecUserDefDevReference
	extends AbstractAction
	{
		public ActionViewSecUserDefDevReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus != null ) {
				ICFBamSecUserEditObj editObj  = (ICFBamSecUserEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecDeviceObj referencedObj = focus.getOptionalLookupDefDev( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SDEV".equals( classCode ) ) {
						frame = swingSchema.getSecDeviceFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecDeviceObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecUserDefDevReference
	extends AbstractAction
	{
		public ActionPickSecUserDefDevReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			ICFBamSecUserEditObj editObj  = (ICFBamSecUserEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecDeviceObj referencedObj = focus.getOptionalLookupDefDev( swingIsInitializing );
			java.util.List<ICFBamSecDeviceObj> listOfSecDevice = null;
			Collection<ICFBamSecDeviceObj> cltn = null;
			JInternalFrame frame = swingSchema.getSecDeviceFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecUserDefDevChosen() );
			((ICFBamSwingSecDeviceJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecUserDefDevCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecUserDefDevCFJReferenceEditor() {
			super( new ActionPickSecUserDefDevReference(), new ActionViewSecUserDefDevReference() );
		}
	}

	protected class SecUserIdJLabel
		extends JLabel
	{
		public SecUserIdJLabel() {
			super();
			setText( "Security User Id" );
		}
	}

	protected class SecUserIdJEditor
		extends CFJUuidEditor
	{
		public SecUserIdJEditor() {
			super();
		}
	}

	protected class LoginIdJLabel
		extends JLabel
	{
		public LoginIdJLabel() {
			super();
			setText( "Login Id" );
		}
	}

	protected class LoginIdJEditor
		extends CFJStringEditor
	{
		public LoginIdJEditor() {
			super();
			setMaxLen( 32 );
		}
	}

	protected class EMailAddressJLabel
		extends JLabel
	{
		public EMailAddressJLabel() {
			super();
			setText( "EMail Address" );
		}
	}

	protected class EMailAddressJEditor
		extends CFJStringEditor
	{
		public EMailAddressJEditor() {
			super();
			setMaxLen( 192 );
		}
	}

	protected class EMailConfirmationUuidJLabel
		extends JLabel
	{
		public EMailConfirmationUuidJLabel() {
			super();
			setText( "EMail Confirmation UUID" );
		}
	}

	protected class EMailConfirmationUuidJEditor
		extends CFJUuidEditor
	{
		public EMailConfirmationUuidJEditor() {
			super();
		}
	}

	protected class PasswordHashJLabel
		extends JLabel
	{
		public PasswordHashJLabel() {
			super();
			setText( "Password Hash" );
		}
	}

	protected class PasswordHashJEditor
		extends CFJStringEditor
	{
		public PasswordHashJEditor() {
			super();
			setMaxLen( 256 );
		}
	}

	protected class PasswordResetUuidJLabel
		extends JLabel
	{
		public PasswordResetUuidJLabel() {
			super();
			setText( "Password Reset UUID" );
		}
	}

	protected class PasswordResetUuidJEditor
		extends CFJUuidEditor
	{
		public PasswordResetUuidJEditor() {
			super();
		}
	}

	protected ICFBamSecDeviceObj swingLookupDefDevObj = null;
	protected SecUserDefDevJLabel swingLabelLookupDefDev = null;
	protected SecUserDefDevCFJReferenceEditor swingReferenceLookupDefDev = null;
	protected SecUserIdJLabel swingLabelSecUserId = null;
	protected SecUserIdJEditor swingEditorSecUserId = null;
	protected LoginIdJLabel swingLabelLoginId = null;
	protected LoginIdJEditor swingEditorLoginId = null;
	protected EMailAddressJLabel swingLabelEMailAddress = null;
	protected EMailAddressJEditor swingEditorEMailAddress = null;
	protected EMailConfirmationUuidJLabel swingLabelEMailConfirmationUuid = null;
	protected EMailConfirmationUuidJEditor swingEditorEMailConfirmationUuid = null;
	protected PasswordHashJLabel swingLabelPasswordHash = null;
	protected PasswordHashJEditor swingEditorPasswordHash = null;
	protected PasswordResetUuidJLabel swingLabelPasswordResetUuid = null;
	protected PasswordResetUuidJEditor swingEditorPasswordResetUuid = null;

	public CFBamSwingSecUserAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSecUserObj argFocus ) {
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
		setSwingFocusAsSecUser( argFocus );
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

		label = getSwingLabelLookupDefDev();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefDev();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecUserId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecUserId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLoginId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorLoginId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelEMailAddress();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorEMailAddress();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelEMailConfirmationUuid();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorEMailConfirmationUuid();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelPasswordHash();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPasswordHash();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelPasswordResetUuid();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPasswordResetUuid();
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
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSecUserObj getSwingFocusAsSecUser() {
		return( (ICFBamSecUserObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecUser( ICFBamSecUserObj value ) {
		setSwingFocus( value );
	}

	public ICFBamSecDeviceObj getSwingLookupDefDevObj() {
		return( swingLookupDefDevObj );
	}

	public void setSwingLookupDefDevObj( ICFBamSecDeviceObj value ) {
		swingLookupDefDevObj = value;
	}

	public JLabel getSwingLabelLookupDefDev() {
		if( swingLabelLookupDefDev == null ) {
			swingLabelLookupDefDev = new SecUserDefDevJLabel();
		}
		return( swingLabelLookupDefDev );
	}

	public CFJReferenceEditor getSwingReferenceLookupDefDev() {
		if( swingReferenceLookupDefDev == null ) {
			swingReferenceLookupDefDev = new SecUserDefDevCFJReferenceEditor();
		}
		return( swingReferenceLookupDefDev );
	}

	public void setSwingReferenceLookupDefDev( SecUserDefDevCFJReferenceEditor value ) {
		swingReferenceLookupDefDev = value;
	}

	public SecUserIdJLabel getSwingLabelSecUserId() {
		if( swingLabelSecUserId == null ) {
			swingLabelSecUserId = new SecUserIdJLabel();
		}
		return( swingLabelSecUserId );
	}

	public void setSwingLabelSecUserId( SecUserIdJLabel value ) {
		swingLabelSecUserId = value;
	}

	public SecUserIdJEditor getSwingEditorSecUserId() {
		if( swingEditorSecUserId == null ) {
			swingEditorSecUserId = new SecUserIdJEditor();
		}
		return( swingEditorSecUserId );
	}

	public void setSwingEditorSecUserId( SecUserIdJEditor value ) {
		swingEditorSecUserId = value;
	}

	public LoginIdJLabel getSwingLabelLoginId() {
		if( swingLabelLoginId == null ) {
			swingLabelLoginId = new LoginIdJLabel();
		}
		return( swingLabelLoginId );
	}

	public void setSwingLabelLoginId( LoginIdJLabel value ) {
		swingLabelLoginId = value;
	}

	public LoginIdJEditor getSwingEditorLoginId() {
		if( swingEditorLoginId == null ) {
			swingEditorLoginId = new LoginIdJEditor();
		}
		return( swingEditorLoginId );
	}

	public void setSwingEditorLoginId( LoginIdJEditor value ) {
		swingEditorLoginId = value;
	}

	public EMailAddressJLabel getSwingLabelEMailAddress() {
		if( swingLabelEMailAddress == null ) {
			swingLabelEMailAddress = new EMailAddressJLabel();
		}
		return( swingLabelEMailAddress );
	}

	public void setSwingLabelEMailAddress( EMailAddressJLabel value ) {
		swingLabelEMailAddress = value;
	}

	public EMailAddressJEditor getSwingEditorEMailAddress() {
		if( swingEditorEMailAddress == null ) {
			swingEditorEMailAddress = new EMailAddressJEditor();
		}
		return( swingEditorEMailAddress );
	}

	public void setSwingEditorEMailAddress( EMailAddressJEditor value ) {
		swingEditorEMailAddress = value;
	}

	public EMailConfirmationUuidJLabel getSwingLabelEMailConfirmationUuid() {
		if( swingLabelEMailConfirmationUuid == null ) {
			swingLabelEMailConfirmationUuid = new EMailConfirmationUuidJLabel();
		}
		return( swingLabelEMailConfirmationUuid );
	}

	public void setSwingLabelEMailConfirmationUuid( EMailConfirmationUuidJLabel value ) {
		swingLabelEMailConfirmationUuid = value;
	}

	public EMailConfirmationUuidJEditor getSwingEditorEMailConfirmationUuid() {
		if( swingEditorEMailConfirmationUuid == null ) {
			swingEditorEMailConfirmationUuid = new EMailConfirmationUuidJEditor();
		}
		return( swingEditorEMailConfirmationUuid );
	}

	public void setSwingEditorEMailConfirmationUuid( EMailConfirmationUuidJEditor value ) {
		swingEditorEMailConfirmationUuid = value;
	}

	public PasswordHashJLabel getSwingLabelPasswordHash() {
		if( swingLabelPasswordHash == null ) {
			swingLabelPasswordHash = new PasswordHashJLabel();
		}
		return( swingLabelPasswordHash );
	}

	public void setSwingLabelPasswordHash( PasswordHashJLabel value ) {
		swingLabelPasswordHash = value;
	}

	public PasswordHashJEditor getSwingEditorPasswordHash() {
		if( swingEditorPasswordHash == null ) {
			swingEditorPasswordHash = new PasswordHashJEditor();
		}
		return( swingEditorPasswordHash );
	}

	public void setSwingEditorPasswordHash( PasswordHashJEditor value ) {
		swingEditorPasswordHash = value;
	}

	public PasswordResetUuidJLabel getSwingLabelPasswordResetUuid() {
		if( swingLabelPasswordResetUuid == null ) {
			swingLabelPasswordResetUuid = new PasswordResetUuidJLabel();
		}
		return( swingLabelPasswordResetUuid );
	}

	public void setSwingLabelPasswordResetUuid( PasswordResetUuidJLabel value ) {
		swingLabelPasswordResetUuid = value;
	}

	public PasswordResetUuidJEditor getSwingEditorPasswordResetUuid() {
		if( swingEditorPasswordResetUuid == null ) {
			swingEditorPasswordResetUuid = new PasswordResetUuidJEditor();
		}
		return( swingEditorPasswordResetUuid );
	}

	public void setSwingEditorPasswordResetUuid( PasswordResetUuidJEditor value ) {
		swingEditorPasswordResetUuid = value;
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

		label = getSwingLabelLookupDefDev();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefDev();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecUserId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecUserId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelLoginId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorLoginId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelEMailAddress();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorEMailAddress();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelEMailConfirmationUuid();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorEMailConfirmationUuid();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelPasswordHash();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPasswordHash();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelPasswordResetUuid();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPasswordResetUuid();
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
		ICFBamSecUserObj popObj;
		ICFBamSecUserObj focus = getSwingFocusAsSecUser();
		if( focus != null ) {
			popObj = (ICFBamSecUserObj)(focus.getEdit());
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
			swingLookupDefDevObj = null;
		}
		else {
			swingLookupDefDevObj = popObj.getOptionalLookupDefDev( swingIsInitializing );
		}
		if( swingReferenceLookupDefDev != null ) {
			swingReferenceLookupDefDev.setReferencedObject( swingLookupDefDevObj );
		}

		if( popObj == null ) {
			getSwingEditorSecUserId().setUuidValue( null );
		}
		else {
			getSwingEditorSecUserId().setUuidValue( popObj.getRequiredSecUserId() );
		}

		if( popObj == null ) {
			getSwingEditorLoginId().setStringValue( null );
		}
		else {
			getSwingEditorLoginId().setStringValue( popObj.getRequiredLoginId() );
		}

		if( popObj == null ) {
			getSwingEditorEMailAddress().setStringValue( null );
		}
		else {
			getSwingEditorEMailAddress().setStringValue( popObj.getRequiredEMailAddress() );
		}

		if( popObj == null ) {
			getSwingEditorEMailConfirmationUuid().setUuidValue( null );
		}
		else {
			getSwingEditorEMailConfirmationUuid().setUuidValue( popObj.getOptionalEMailConfirmationUuid() );
		}

		if( popObj == null ) {
			getSwingEditorPasswordHash().setStringValue( null );
		}
		else {
			getSwingEditorPasswordHash().setStringValue( popObj.getRequiredPasswordHash() );
		}

		if( popObj == null ) {
			getSwingEditorPasswordResetUuid().setUuidValue( null );
		}
		else {
			getSwingEditorPasswordResetUuid().setUuidValue( popObj.getOptionalPasswordResetUuid() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSecUserObj focus = getSwingFocusAsSecUser();
		ICFBamSecUserEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSecUserEditObj)(focus.getEdit());
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

		swingLookupDefDevObj = (ICFBamSecDeviceObj)( swingReferenceLookupDefDev.getReferencedObject() );
		editObj.setOptionalLookupDefDev( swingLookupDefDevObj );

		editObj.setRequiredLoginId( getSwingEditorLoginId().getStringValue() );

		editObj.setRequiredEMailAddress( getSwingEditorEMailAddress().getStringValue() );

		editObj.setOptionalEMailConfirmationUuid( getSwingEditorEMailConfirmationUuid().getUuidValue() );

		editObj.setRequiredPasswordHash( getSwingEditorPasswordHash().getStringValue() );

		editObj.setOptionalPasswordResetUuid( getSwingEditorPasswordResetUuid().getUuidValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSecUserObj focus = getSwingFocusAsSecUser();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSecUserEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSecUserEditObj)focus.getEdit();
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
								editObj = (ICFBamSecUserEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecUserEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSecUserEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSecUserEditObj)focus.beginEdit();
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
						focus = (ICFBamSecUserObj)editObj.create();
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
								editObj = (ICFBamSecUserEditObj)focus.beginEdit();
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
								editObj = (ICFBamSecUserEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecUserEditObj)focus.beginEdit();
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
			ICFBamSecUserObj focus = getSwingFocusAsSecUser();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceLookupDefDev != null ) {
			swingReferenceLookupDefDev.setEnabled( isEditing );
		}
		if( swingEditorSecUserId != null ) {
			swingEditorSecUserId.setEnabled( false );
		}
		if( swingEditorLoginId != null ) {
			swingEditorLoginId.setEnabled( isEditing );
		}
		if( swingEditorEMailAddress != null ) {
			swingEditorEMailAddress.setEnabled( isEditing );
		}
		if( swingEditorEMailConfirmationUuid != null ) {
			swingEditorEMailConfirmationUuid.setEnabled( isEditing );
		}
		if( swingEditorPasswordHash != null ) {
			swingEditorPasswordHash.setEnabled( isEditing );
		}
		if( swingEditorPasswordResetUuid != null ) {
			swingEditorPasswordResetUuid.setEnabled( isEditing );
		}
	}
}
