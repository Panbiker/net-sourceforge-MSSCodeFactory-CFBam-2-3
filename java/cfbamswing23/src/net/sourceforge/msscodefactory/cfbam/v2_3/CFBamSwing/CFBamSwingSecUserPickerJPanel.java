// Description: Java 7 Swing Picker of Obj JPanel implementation for SecUser.

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
import javax.swing.event.*;
import javax.swing.table.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingSecUserPickerJPanel Swing Pick Obj JPanel implementation
 *	for SecUser.
 */
public class CFBamSwingSecUserPickerJPanel
extends CFJPanel
implements ICFBamSwingSecUserJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamSecUserObj> swingDataCollection = null;
	protected ICFBamSecUserObj arrayOfSecUser[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_SECUSERID = 1;
	public final static int COLID_LOGINID = 2;
	public final static int COLID_EMAILADDRESS = 3;
	public final static int COLID_EMAILCONFIRMATIONUUID = 4;
	public final static int COLID_PASSWORDHASH = 5;
	public final static int COLID_PASSWORDRESETUUID = 6;
	public final static int COLID_LOOKUP_DEFDEV = 7;
	public final static int NUM_COLS = 8;
	protected JTable swingJTable = null;
	public class PickerTableModel
	extends AbstractTableModel
	{
		public PickerTableModel() {
			super();
		}

		public int getRowCount() {
			int retval;
			if( arrayOfSecUser != null ) {
				retval = arrayOfSecUser.length;
			}
			else {
				retval = 0;
			}
			return( retval );
		}

		public int getColumnCount() {
			return( NUM_COLS );
		}

		public String getColumnName( int column ) {
			String retval;
			switch( column ) {
				case COLID_ROW_HEADER:
					retval = "Security User";
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = "Qualified Name";
					break;
				case COLID_SECUSERID:
					retval = "Security User Id";
					break;
				case COLID_LOGINID:
					retval = "Login Id";
					break;
				case COLID_EMAILADDRESS:
					retval = "EMail Address";
					break;
				case COLID_EMAILCONFIRMATIONUUID:
					retval = "EMail Confirmation UUID";
					break;
				case COLID_PASSWORDHASH:
					retval = "Password Hash";
					break;
				case COLID_PASSWORDRESETUUID:
					retval = "Password Reset UUID";
					break;
				case COLID_LOOKUP_DEFDEV:
					retval = "Default Security Device";
					break;
				default:
					retval = null;
					break;
			}
			return( retval );
		}

		public Object getValueAt( int row, int column ) {
			if( ( row < 0 ) || ( column < -1 ) ) {
				return( null );
			}
			if( arrayOfSecUser == null ) {
				return( null );
			}
			int len = arrayOfSecUser.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamSecUserObj obj = arrayOfSecUser[row];
			if( obj == null ) {
				return( null );
			}
			Object retval;
			switch( column ) {
				case COLID_ROW_HEADER:
					retval = obj;
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = obj.getObjQualifiedName();
					break;
				case COLID_SECUSERID:
					retval = obj.getRequiredSecUserId();
					break;
				case COLID_LOGINID:
					retval = obj.getRequiredLoginId();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_EMAILADDRESS:
					retval = obj.getRequiredEMailAddress();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_EMAILCONFIRMATIONUUID:
					retval = obj.getOptionalEMailConfirmationUuid();
					break;
				case COLID_PASSWORDHASH:
					retval = obj.getRequiredPasswordHash();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_PASSWORDRESETUUID:
					retval = obj.getOptionalPasswordResetUuid();
					break;
				case COLID_LOOKUP_DEFDEV:
					retval = obj.getOptionalLookupDefDev();
					break;
				default:
					retval = null;
					break;
			}
			return( retval );
		}

		public boolean isCellEditable( int row, int column ) {
			return( false );
		}
	}

	public class PickerTableColumnModel
	extends DefaultTableColumnModel
	{
		protected class QualifiedNameColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFStringColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Qualified Name" );
			}

			public QualifiedNameColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_OBJQUALIFIEDNAME );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class SecUserIdColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFUuidColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Security User Id" );
			}

			public SecUserIdColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_SECUSERID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class LoginIdColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFStringColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Login Id" );
			}

			public LoginIdColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOGINID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class EMailAddressColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFStringColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "EMail Address" );
			}

			public EMailAddressColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_EMAILADDRESS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class EMailConfirmationUuidColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFUuidColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "EMail Confirmation UUID" );
			}

			public EMailConfirmationUuidColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_EMAILCONFIRMATIONUUID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PasswordHashColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFStringColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Password Hash" );
			}

			public PasswordHashColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_PASSWORDHASH );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PasswordResetUuidColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFUuidColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Password Reset UUID" );
			}

			public PasswordResetUuidColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_PASSWORDRESETUUID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DefDevColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFReferenceColumnCellRenderer
			{
				public ColumnCellRenderer() {
					super();
				}
			}

			protected class ColumnHeaderRenderer
			extends CFHeaderColumnCellRenderer
			{
				public ColumnHeaderRenderer() {
					super();
				}
			}

			public Object getHeaderValue() {
				return( "Default Security Device" );
			}

			public DefDevColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_DEFDEV );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public PickerTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new SecUserIdColumn() );
			addColumn( new LoginIdColumn() );
			addColumn( new EMailAddressColumn() );
			addColumn( new EMailConfirmationUuidColumn() );
			addColumn( new PasswordHashColumn() );
			addColumn( new PasswordResetUuidColumn() );
			addColumn( new DefDevColumn() );
		}
	}

	public class PickerListSelectionModel
	extends DefaultListSelectionModel
	{
		public PickerListSelectionModel() {
			super();
			setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		}
	}

	public class PickerListSelectionListener
	implements ListSelectionListener
	{
		public PickerListSelectionListener() {
		}

		public void valueChanged( ListSelectionEvent lse ) {
			final String S_ProcName = "valueChanged";
			ICFBamSecUserObj selectedObj;
			if( lse.getValueIsAdjusting() ) {
				return;
			}
			if( dataTable == null ) {
				return;
			}
			int dataRow = dataTable.getSelectedRow();
			int modelIndex = dataTable.convertRowIndexToModel( dataRow );
			PickerTableModel tblDataModel = getDataModel();
			Object selectedRowData = tblDataModel.getValueAt( modelIndex, COLID_ROW_HEADER );
			if( selectedRowData != null ) {
				if( selectedRowData instanceof ICFBamSecUserObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamSecUserObj)selectedRowData;
					}
					else {
						selectedObj = null;
					}
				}
				else {
					selectedObj = null;
					throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
						S_ProcName,
						"selectedRowData",
						selectedRowData,
						"ICFBamSecUserObj" );
				}
			}
			else {
				selectedObj = null;
			}
			setSwingFocus( selectedObj );
			adjustFeedback();
		}
	}

	public class PickerListMouseAdapter
	extends MouseAdapter
	{
		public PickerListMouseAdapter() {
			super();
		}

		public void mousePressed( MouseEvent e ) {
			if( e.getButton() != MouseEvent.BUTTON1 ) {
				return;
			}
			if( e.getClickCount() != 2 ) {
				return;
			}
			JTable table = (JTable)e.getSource();
			Point p = e.getPoint();
			int row = table.rowAtPoint( p );
			if( row < 0 ) {
				return;
			}
			PickerTableModel model = getDataModel();
			ICFBamSecUserObj o = (ICFBamSecUserObj)model.getValueAt( row, COLID_ROW_HEADER );
			invokeWhenChosen.choseSecUser( o );
			try {
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
					cont = cont.getParent();
				}
				if( cont != null ) {
					((JInternalFrame)cont).setClosed( true );
				}
			}
			catch( Exception x ) {
			}
		}
	}

	protected PickerTableModel dataModel = null;
	protected PickerTableColumnModel dataColumnModel = null;
	protected PickerListSelectionModel dataListSelectionModel = null;
	protected PickerListMouseAdapter dataListMouseAdapter = null;
	protected PickerListSelectionListener dataListSelectionListener = null;
	protected JTable dataTable = null;
	protected JTableHeader dataTableHeader = null;
	protected JScrollPane dataScrollPane = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFBamSwingSecUserChosen invokeWhenChosen = null;
	protected ICFLibAnyObj swingContainer = null;
	protected Action actionCancel = null;
	protected Action actionChooseNone = null;
	protected Action actionChooseSelected = null;
	protected JButton buttonCancel = null;
	protected JButton buttonChooseNone = null;
	protected JButton buttonChooseSelected = null;
	protected class ActionCancel
	extends AbstractAction
	{
		public ActionCancel() {
			super();
			putValue( Action.NAME, "Cancel" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			try {
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
					cont = cont.getParent();
				}
				if( cont != null ) {
					((JInternalFrame)cont).setClosed( true );
				}
			}
			catch( Exception x ) {
			}
		}
	}

	protected class ActionChooseNone
	extends AbstractAction
	{
		public ActionChooseNone() {
			super();
			putValue( Action.NAME, "Choose None" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			invokeWhenChosen.choseSecUser( null );
			try {
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
					cont = cont.getParent();
				}
				if( cont != null ) {
					((JInternalFrame)cont).setClosed( true );
				}
			}
			catch( Exception x ) {
			}
		}
	}

	protected class ActionChooseSelectedSecUser
	extends AbstractAction
	{
		public ActionChooseSelectedSecUser() {
			super();
			putValue( Action.NAME, "Choose Selected Security User" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			ICFBamSecUserObj selectedInstance = getSwingFocusAsSecUser();
			invokeWhenChosen.choseSecUser( selectedInstance );
			try {
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
					cont = cont.getParent();
				}
				if( cont != null ) {
					((JInternalFrame)cont).setClosed( true );
				}
			}
			catch( Exception x ) {
			}
		}
	}

	public CFBamSwingSecUserPickerJPanel( ICFBamSwingSchema argSchema,
		ICFBamSecUserObj argFocus,
		ICFLibAnyObj argContainer,
		Collection<ICFBamSecUserObj> argDataCollection,
		ICFBamSwingSecUserChosen whenChosen )
	{
		super();
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		if( whenChosen == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				5,
				"whenChosen" );
		}
		invokeWhenChosen = whenChosen;
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		swingSchema = argSchema;
		swingFocus = argFocus;
		swingContainer = argContainer;
		setSwingDataCollection( argDataCollection );
		dataTable = new JTable( getDataModel(), getDataColumnModel(), getDataListSelectionModel() );
		dataTable.addMouseListener( getDataListMouseAdapter() );
		dataTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		dataTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		dataTable.setUpdateSelectionOnSort( true );
		dataTable.setRowHeight( 25 );
		getDataListSelectionModel().addListSelectionListener( getDataListSelectionListener() );
		dataScrollPane = new JScrollPane( dataTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		dataScrollPane.setColumnHeader( new JViewport() {
					@Override public Dimension getPreferredSize() {
						Dimension sz = super.getPreferredSize();
						sz.height = 25;
						return( sz );
					}
				} );
		dataTable.setFillsViewportHeight( true );
		actionCancel = new ActionCancel();
		buttonCancel = new JButton( actionCancel );
		actionChooseNone = new ActionChooseNone();
		buttonChooseNone = new JButton( actionChooseNone );
		actionChooseSelected = new ActionChooseSelectedSecUser();
		buttonChooseSelected = new JButton( actionChooseSelected );
		// Do initial layout
		setSize( 1024, 480 );
		add( buttonChooseNone );
		add( buttonChooseSelected );
		add( buttonCancel );
		add( dataScrollPane );
		dataScrollPane.setBounds( 0, 35, 1024, 455 );
		doLayout();
		setSwingFocusAsSecUser( argFocus );
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
		if( dataTable == null ) {
			return;
		}
		if( value == null ) {
			dataTable.clearSelection();
		}
		else {
			ICFBamSecUserObj curSelected;
			PickerTableModel tblDataModel = getDataModel();
			int selectedRow = dataTable.getSelectedRow();
			int modelIndex = dataTable.convertRowIndexToModel( selectedRow );
			if( selectedRow >= 0 ) {
				Object selectedRowData = tblDataModel.getValueAt( modelIndex, COLID_ROW_HEADER );
				curSelected = (ICFBamSecUserObj)selectedRowData;
			}
			else {
				curSelected = null;
			}
			if( curSelected != value ) {
				int len = tblDataModel.getRowCount();
				int idx = 0;
				while( ( idx < len ) && ( tblDataModel.getValueAt( idx, COLID_ROW_HEADER ) != value ) ) {
					idx ++;
				}
				if( idx < len ) {
					int viewRow = dataTable.convertRowIndexToView( idx );
					dataTable.clearSelection();
					dataTable.addRowSelectionInterval( viewRow, viewRow );
				}
			}
		}
	}

	public ICFBamSecUserObj getSwingFocusAsSecUser() {
		return( (ICFBamSecUserObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecUser( ICFBamSecUserObj value ) {
		setSwingFocus( value );
	}

	public class SecUserByQualNameComparator
	implements Comparator<ICFBamSecUserObj>
	{
		public SecUserByQualNameComparator() {
		}

		public int compare( ICFBamSecUserObj lhs, ICFBamSecUserObj rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsValue = lhs.getObjQualifiedName();
				String rhsValue = rhs.getObjQualifiedName();
				if( lhsValue == null ) {
					if( rhsValue == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsValue == null ) {
					return( 1 );
				}
				else {
					return( lhsValue.compareTo( rhsValue ) );
				}
			}
		}
	}

	protected SecUserByQualNameComparator compareSecUserByQualName = new SecUserByQualNameComparator();

	public Collection<ICFBamSecUserObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamSecUserObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfSecUser = new ICFBamSecUserObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfSecUser = new ICFBamSecUserObj[ len ];
			Iterator<ICFBamSecUserObj> iter = swingDataCollection.iterator();
			int idx = 0;
			while( iter.hasNext() && ( idx < len ) ) {
				arrayOfSecUser[idx++] = iter.next();
			}
			if( idx < len ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Collection iterator did not fully populate the array copy" );
			}
			if( iter.hasNext() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Collection iterator had left over items when done populating array copy" );
			}
			Arrays.sort( arrayOfSecUser, compareSecUserByQualName );
		}
		PickerTableModel tblDataModel = getDataModel();
		if( tblDataModel != null ) {
			tblDataModel.fireTableDataChanged();
		}
	}

	public void doLayout() {
		Dimension sz = getSize();
		final int buttonWidth = 100;
		final int buttonHeight = 25;
		final int buttonSpacing = 10;
		final int spTop = buttonSpacing + buttonHeight + buttonSpacing;
		int buttonStart = ( sz.width - (( 3 * buttonWidth ) + ( 2 * buttonSpacing )) ) / 2;
		if( buttonStart < 0 ) {
			buttonStart = 0;
		}
		int spHeight = sz.height - spTop;
		if( spHeight < 0 ) {
			spHeight = 0;
		}
		buttonChooseNone.setBounds( buttonStart, buttonSpacing, buttonWidth, buttonHeight );
		buttonChooseSelected.setBounds( buttonStart + buttonWidth + buttonSpacing, buttonSpacing, buttonWidth, buttonHeight );
		buttonCancel.setBounds( buttonStart + buttonWidth + buttonSpacing + buttonWidth + buttonSpacing, buttonSpacing, buttonWidth, buttonHeight );
		dataScrollPane.setBounds( 0, spTop, sz.width, spHeight );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		super.setPanelMode( value );
	}

	public PickerTableModel getDataModel() {
		if( dataModel == null ) {
			dataModel = new PickerTableModel();
		}
		return( dataModel );
	}

	public PickerTableColumnModel getDataColumnModel() {
		if( dataColumnModel == null ) {
			dataColumnModel = new PickerTableColumnModel();
		}
		return( dataColumnModel );
	}

	public PickerListSelectionModel getDataListSelectionModel() {
		if( dataListSelectionModel == null ) {
			dataListSelectionModel = new PickerListSelectionModel();
		}
		return( dataListSelectionModel );
	}

	public PickerListSelectionListener getDataListSelectionListener() {
		if( dataListSelectionListener == null ) {
			dataListSelectionListener = new PickerListSelectionListener();
		}
		return( dataListSelectionListener );
	}

	public PickerListMouseAdapter getDataListMouseAdapter() {
		if( dataListMouseAdapter == null ) {
			dataListMouseAdapter = new PickerListMouseAdapter();
		}
		return( dataListMouseAdapter );
	}

	protected JTableHeader createDefaultTableHeader() {
		if( dataTableHeader == null ) {
			dataTableHeader = new JTableHeader( getDataColumnModel() );
			dataTableHeader.setResizingAllowed( true );
			dataTableHeader.setTable( dataTable );
		}
		return( dataTableHeader );
	}

	public ICFLibAnyObj getSwingContainer() {
		return( swingContainer );
	}

	public void setSwingContainer( ICFLibAnyObj value ) {
		swingContainer = value;
	}

		public void adjustFeedback() {
			actionCancel.setEnabled( true );
			actionChooseNone.setEnabled( true );
			if( getSwingFocus() == null ) {
				actionChooseSelected.setEnabled( false );
			}
			else {
				actionChooseSelected.setEnabled( true );
			}
		}
}

