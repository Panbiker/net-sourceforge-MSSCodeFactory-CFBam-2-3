// Description: Java 7 Swing Attribute JPanel implementation for ISOTimezone.

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
 *	CFBamSwingISOTimezoneAttrJPanel Swing Attribute JPanel implementation
 *	for ISOTimezone.
 */
public class CFBamSwingISOTimezoneAttrJPanel
extends CFJPanel
implements ICFBamSwingISOTimezoneJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class ISOTimezoneIdJLabel
		extends JLabel
	{
		public ISOTimezoneIdJLabel() {
			super();
			setText( "ISO Timezone Id" );
		}
	}

	protected class ISOTimezoneIdJEditor
		extends CFJInt16Editor
	{
		public ISOTimezoneIdJEditor() {
			super();
			setMinValue( (short)1 );
		}
	}

	protected class Iso8601JLabel
		extends JLabel
	{
		public Iso8601JLabel() {
			super();
			setText( "ISO8601" );
		}
	}

	protected class Iso8601JEditor
		extends CFJStringEditor
	{
		public Iso8601JEditor() {
			super();
			setMaxLen( 5 );
		}
	}

	protected class TZNameJLabel
		extends JLabel
	{
		public TZNameJLabel() {
			super();
			setText( "Timezone Name" );
		}
	}

	protected class TZNameJEditor
		extends CFJStringEditor
	{
		public TZNameJEditor() {
			super();
			setMaxLen( 64 );
		}
	}

	protected class TZHourOffsetJLabel
		extends JLabel
	{
		public TZHourOffsetJLabel() {
			super();
			setText( "Timezone Hour Offset" );
		}
	}

	protected class TZHourOffsetJEditor
		extends CFJInt16Editor
	{
		public TZHourOffsetJEditor() {
			super();
			setMinValue( (short)0 );
			setMaxValue( (short)24 );
		}
	}

	protected class TZMinOffsetJLabel
		extends JLabel
	{
		public TZMinOffsetJLabel() {
			super();
			setText( "Timezone Minute Offset" );
		}
	}

	protected class TZMinOffsetJEditor
		extends CFJInt16Editor
	{
		public TZMinOffsetJEditor() {
			super();
			setMinValue( (short)0 );
			setMaxValue( (short)59 );
		}
	}

	protected class DescriptionJLabel
		extends JLabel
	{
		public DescriptionJLabel() {
			super();
			setText( "Description" );
		}
	}

	protected class DescriptionJEditor
		extends CFJStringEditor
	{
		public DescriptionJEditor() {
			super();
			setMaxLen( 128 );
		}
	}

	protected class VisibleJLabel
		extends JLabel
	{
		public VisibleJLabel() {
			super();
			setText( "Visible" );
		}
	}

	protected class VisibleJEditor
		extends CFJBoolEditor
	{
		public VisibleJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected ISOTimezoneIdJLabel swingLabelISOTimezoneId = null;
	protected ISOTimezoneIdJEditor swingEditorISOTimezoneId = null;
	protected Iso8601JLabel swingLabelIso8601 = null;
	protected Iso8601JEditor swingEditorIso8601 = null;
	protected TZNameJLabel swingLabelTZName = null;
	protected TZNameJEditor swingEditorTZName = null;
	protected TZHourOffsetJLabel swingLabelTZHourOffset = null;
	protected TZHourOffsetJEditor swingEditorTZHourOffset = null;
	protected TZMinOffsetJLabel swingLabelTZMinOffset = null;
	protected TZMinOffsetJEditor swingEditorTZMinOffset = null;
	protected DescriptionJLabel swingLabelDescription = null;
	protected DescriptionJEditor swingEditorDescription = null;
	protected VisibleJLabel swingLabelVisible = null;
	protected VisibleJEditor swingEditorVisible = null;

	public CFBamSwingISOTimezoneAttrJPanel( ICFBamSwingSchema argSchema, ICFBamISOTimezoneObj argFocus ) {
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
		setSwingFocusAsISOTimezone( argFocus );
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

		label = getSwingLabelISOTimezoneId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorISOTimezoneId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelIso8601();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIso8601();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelTZName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelTZHourOffset();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZHourOffset();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelTZMinOffset();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZMinOffset();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDescription();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDescription();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelVisible();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorVisible();
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
		if( ( value == null ) || ( value instanceof ICFBamISOTimezoneObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamISOTimezoneObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamISOTimezoneObj getSwingFocusAsISOTimezone() {
		return( (ICFBamISOTimezoneObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsISOTimezone( ICFBamISOTimezoneObj value ) {
		setSwingFocus( value );
	}

	public ISOTimezoneIdJLabel getSwingLabelISOTimezoneId() {
		if( swingLabelISOTimezoneId == null ) {
			swingLabelISOTimezoneId = new ISOTimezoneIdJLabel();
		}
		return( swingLabelISOTimezoneId );
	}

	public void setSwingLabelISOTimezoneId( ISOTimezoneIdJLabel value ) {
		swingLabelISOTimezoneId = value;
	}

	public ISOTimezoneIdJEditor getSwingEditorISOTimezoneId() {
		if( swingEditorISOTimezoneId == null ) {
			swingEditorISOTimezoneId = new ISOTimezoneIdJEditor();
		}
		return( swingEditorISOTimezoneId );
	}

	public void setSwingEditorISOTimezoneId( ISOTimezoneIdJEditor value ) {
		swingEditorISOTimezoneId = value;
	}

	public Iso8601JLabel getSwingLabelIso8601() {
		if( swingLabelIso8601 == null ) {
			swingLabelIso8601 = new Iso8601JLabel();
		}
		return( swingLabelIso8601 );
	}

	public void setSwingLabelIso8601( Iso8601JLabel value ) {
		swingLabelIso8601 = value;
	}

	public Iso8601JEditor getSwingEditorIso8601() {
		if( swingEditorIso8601 == null ) {
			swingEditorIso8601 = new Iso8601JEditor();
		}
		return( swingEditorIso8601 );
	}

	public void setSwingEditorIso8601( Iso8601JEditor value ) {
		swingEditorIso8601 = value;
	}

	public TZNameJLabel getSwingLabelTZName() {
		if( swingLabelTZName == null ) {
			swingLabelTZName = new TZNameJLabel();
		}
		return( swingLabelTZName );
	}

	public void setSwingLabelTZName( TZNameJLabel value ) {
		swingLabelTZName = value;
	}

	public TZNameJEditor getSwingEditorTZName() {
		if( swingEditorTZName == null ) {
			swingEditorTZName = new TZNameJEditor();
		}
		return( swingEditorTZName );
	}

	public void setSwingEditorTZName( TZNameJEditor value ) {
		swingEditorTZName = value;
	}

	public TZHourOffsetJLabel getSwingLabelTZHourOffset() {
		if( swingLabelTZHourOffset == null ) {
			swingLabelTZHourOffset = new TZHourOffsetJLabel();
		}
		return( swingLabelTZHourOffset );
	}

	public void setSwingLabelTZHourOffset( TZHourOffsetJLabel value ) {
		swingLabelTZHourOffset = value;
	}

	public TZHourOffsetJEditor getSwingEditorTZHourOffset() {
		if( swingEditorTZHourOffset == null ) {
			swingEditorTZHourOffset = new TZHourOffsetJEditor();
		}
		return( swingEditorTZHourOffset );
	}

	public void setSwingEditorTZHourOffset( TZHourOffsetJEditor value ) {
		swingEditorTZHourOffset = value;
	}

	public TZMinOffsetJLabel getSwingLabelTZMinOffset() {
		if( swingLabelTZMinOffset == null ) {
			swingLabelTZMinOffset = new TZMinOffsetJLabel();
		}
		return( swingLabelTZMinOffset );
	}

	public void setSwingLabelTZMinOffset( TZMinOffsetJLabel value ) {
		swingLabelTZMinOffset = value;
	}

	public TZMinOffsetJEditor getSwingEditorTZMinOffset() {
		if( swingEditorTZMinOffset == null ) {
			swingEditorTZMinOffset = new TZMinOffsetJEditor();
		}
		return( swingEditorTZMinOffset );
	}

	public void setSwingEditorTZMinOffset( TZMinOffsetJEditor value ) {
		swingEditorTZMinOffset = value;
	}

	public DescriptionJLabel getSwingLabelDescription() {
		if( swingLabelDescription == null ) {
			swingLabelDescription = new DescriptionJLabel();
		}
		return( swingLabelDescription );
	}

	public void setSwingLabelDescription( DescriptionJLabel value ) {
		swingLabelDescription = value;
	}

	public DescriptionJEditor getSwingEditorDescription() {
		if( swingEditorDescription == null ) {
			swingEditorDescription = new DescriptionJEditor();
		}
		return( swingEditorDescription );
	}

	public void setSwingEditorDescription( DescriptionJEditor value ) {
		swingEditorDescription = value;
	}

	public VisibleJLabel getSwingLabelVisible() {
		if( swingLabelVisible == null ) {
			swingLabelVisible = new VisibleJLabel();
		}
		return( swingLabelVisible );
	}

	public void setSwingLabelVisible( VisibleJLabel value ) {
		swingLabelVisible = value;
	}

	public VisibleJEditor getSwingEditorVisible() {
		if( swingEditorVisible == null ) {
			swingEditorVisible = new VisibleJEditor();
		}
		return( swingEditorVisible );
	}

	public void setSwingEditorVisible( VisibleJEditor value ) {
		swingEditorVisible = value;
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

		label = getSwingLabelISOTimezoneId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorISOTimezoneId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelIso8601();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIso8601();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelTZName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelTZHourOffset();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZHourOffset();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelTZMinOffset();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTZMinOffset();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelDescription();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDescription();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelVisible();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorVisible();
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
		ICFBamISOTimezoneObj popObj;
		ICFBamISOTimezoneObj focus = getSwingFocusAsISOTimezone();
		if( focus != null ) {
			popObj = (ICFBamISOTimezoneObj)(focus.getEdit());
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
			getSwingEditorISOTimezoneId().setInt16Value( null );
		}
		else {
			getSwingEditorISOTimezoneId().setInt16Value( popObj.getRequiredISOTimezoneId() );
		}

		if( popObj == null ) {
			getSwingEditorIso8601().setStringValue( null );
		}
		else {
			getSwingEditorIso8601().setStringValue( popObj.getRequiredIso8601() );
		}

		if( popObj == null ) {
			getSwingEditorTZName().setStringValue( null );
		}
		else {
			getSwingEditorTZName().setStringValue( popObj.getRequiredTZName() );
		}

		if( popObj == null ) {
			getSwingEditorTZHourOffset().setInt16Value( null );
		}
		else {
			getSwingEditorTZHourOffset().setInt16Value( popObj.getRequiredTZHourOffset() );
		}

		if( popObj == null ) {
			getSwingEditorTZMinOffset().setInt16Value( null );
		}
		else {
			getSwingEditorTZMinOffset().setInt16Value( popObj.getRequiredTZMinOffset() );
		}

		if( popObj == null ) {
			getSwingEditorDescription().setStringValue( null );
		}
		else {
			getSwingEditorDescription().setStringValue( popObj.getRequiredDescription() );
		}

		if( popObj == null ) {
			getSwingEditorVisible().setBooleanValue( null );
		}
		else {
			getSwingEditorVisible().setBooleanValue( popObj.getRequiredVisible() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamISOTimezoneObj focus = getSwingFocusAsISOTimezone();
		ICFBamISOTimezoneEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamISOTimezoneEditObj)(focus.getEdit());
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

		editObj.setRequiredIso8601( getSwingEditorIso8601().getStringValue() );

		editObj.setRequiredTZName( getSwingEditorTZName().getStringValue() );

		editObj.setRequiredTZHourOffset( getSwingEditorTZHourOffset().getInt16Value() );

		editObj.setRequiredTZMinOffset( getSwingEditorTZMinOffset().getInt16Value() );

		editObj.setRequiredDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredVisible( getSwingEditorVisible().getBooleanValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamISOTimezoneObj focus = getSwingFocusAsISOTimezone();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamISOTimezoneEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamISOTimezoneEditObj)focus.getEdit();
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
								editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
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
							editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
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
						focus = (ICFBamISOTimezoneObj)editObj.create();
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
								editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
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
								editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
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
							editObj = (ICFBamISOTimezoneEditObj)focus.beginEdit();
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
			ICFBamISOTimezoneObj focus = getSwingFocusAsISOTimezone();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingEditorISOTimezoneId != null ) {
			swingEditorISOTimezoneId.setEnabled( false );
		}
		if( swingEditorIso8601 != null ) {
			swingEditorIso8601.setEnabled( isEditing );
		}
		if( swingEditorTZName != null ) {
			swingEditorTZName.setEnabled( isEditing );
		}
		if( swingEditorTZHourOffset != null ) {
			swingEditorTZHourOffset.setEnabled( isEditing );
		}
		if( swingEditorTZMinOffset != null ) {
			swingEditorTZMinOffset.setEnabled( isEditing );
		}
		if( swingEditorDescription != null ) {
			swingEditorDescription.setEnabled( isEditing );
		}
		if( swingEditorVisible != null ) {
			swingEditorVisible.setEnabled( isEditing );
		}
	}
}
