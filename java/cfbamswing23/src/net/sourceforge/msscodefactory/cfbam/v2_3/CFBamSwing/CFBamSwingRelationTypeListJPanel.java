// Description: Java 7 Swing List of Obj JPanel implementation for RelationType.

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
 *	CFBamSwingRelationTypeListJPanel Swing List of Obj JPanel implementation
 *	for RelationType.
 */
public class CFBamSwingRelationTypeListJPanel
extends CFJPanel
implements ICFBamSwingRelationTypeJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamRelationTypeObj> swingDataCollection = null;
	protected ICFBamRelationTypeObj arrayOfRelationType[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_ID = 1;
	public final static int COLID_TAG = 2;
	public final static int NUM_COLS = 3;
	protected JTable swingJTable = null;
	protected class ActionAddRelationType
	extends AbstractAction
	{
		public ActionAddRelationType() {
			super();
			putValue( Action.NAME, "Add RelationType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationTypeObj obj = schemaObj.getRelationTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getRelationTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamRelationTypeEditObj edit = (ICFBamRelationTypeEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
			ICFBamSwingRelationTypeJPanelCommon jpanelCommon = (ICFBamSwingRelationTypeJPanelCommon)frame;
			jpanelCommon.setPanelMode( CFJPanel.PanelMode.Add );
			Container cont = getParent();
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

	protected class ViewSelectedActionRelationType
	extends AbstractAction
	{
		public ViewSelectedActionRelationType() {
			super();
			putValue( Action.NAME, "View Selected..." );
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
			ICFBamRelationTypeObj selectedInstance = getSwingFocusAsRelationType();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "RLT".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getRelationTypeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRelationTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
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
						"selectedInstance",
						selectedInstance,
						"ICFBamRelationTypeObj" );
				}
			}
		}
	}

	protected class EditSelectedActionRelationType
	extends AbstractAction
	{
		public EditSelectedActionRelationType() {
			super();
			putValue( Action.NAME, "Edit Selected..." );
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
			ICFBamRelationTypeObj selectedInstance = getSwingFocusAsRelationType();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "RLT".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getRelationTypeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRelationTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
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
						"selectedInstance",
						selectedInstance,
						"ICFBamRelationTypeObj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionRelationType
	extends AbstractAction
	{
		public DeleteSelectedActionRelationType() {
			super();
			putValue( Action.NAME, "Delete Selected..." );
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
			ICFBamRelationTypeObj selectedInstance = getSwingFocusAsRelationType();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "RLT".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getRelationTypeFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingRelationTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					Container cont = getParent();
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
						"selectedInstance",
						selectedInstance,
						"ICFBamRelationTypeObj" );
				}
			}
		}
	}

	public class ListTableModel
	extends AbstractTableModel
	{
		public ListTableModel() {
			super();
		}

		public int getRowCount() {
			int retval;
			if( arrayOfRelationType != null ) {
				retval = arrayOfRelationType.length;
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
					retval = "RelationType";
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = "Qualified Name";
					break;
				case COLID_ID:
					retval = "Id";
					break;
				case COLID_TAG:
					retval = "Tag";
					break;
				default:
					retval = null;
					break;
			}
			return( retval );
		}

		public Object getValueAt( int row, int column ) {
			final String S_ProcName = "getValueAt";
			if( ( row < 0 ) || ( column < -1 ) ) {
				return( null );
			}
			if( arrayOfRelationType == null ) {
				return( null );
			}
			int len = arrayOfRelationType.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamRelationTypeObj obj = arrayOfRelationType[row];
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
				case COLID_ID:
					retval = new Short( obj.getRequiredId() );
					break;
				case COLID_TAG:
					retval = obj.getRequiredTag();
					if( retval == null ) {
						retval = "";
					}
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

	public class ListTableColumnModel
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

		public class IdColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFInt16ColumnCellRenderer
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
				return( "Id" );
			}

			public IdColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_ID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class TagColumn
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
				return( "Tag" );
			}

			public TagColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_TAG );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public ListTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new IdColumn() );
			addColumn( new TagColumn() );
		}
	}

	public class ListListSelectionModel
	extends DefaultListSelectionModel
	{
		public ListListSelectionModel() {
			super();
			setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		}
	}

	public class ListListSelectionListener
	implements ListSelectionListener
	{
		public ListListSelectionListener() {
		}

		public void valueChanged( ListSelectionEvent lse ) {
			final String S_ProcName = "valueChanged";
			ICFBamRelationTypeObj selectedObj;
			if( lse.getValueIsAdjusting() ) {
				return;
			}
			if( dataTable == null ) {
				return;
			}
			int dataRow = dataTable.getSelectedRow();
			int modelIndex = dataTable.convertRowIndexToModel( dataRow );
			ListTableModel tblDataModel = getDataModel();
			Object selectedRowData = tblDataModel.getValueAt( modelIndex, COLID_ROW_HEADER );
			if( selectedRowData != null ) {
				if( selectedRowData instanceof ICFBamRelationTypeObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamRelationTypeObj)selectedRowData;
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
						"ICFBamRelationTypeObj" );
				}
			}
			else {
				selectedObj = null;
			}
			setSwingFocus( selectedObj );
		}
	}

	public class ListListMouseAdapter
	extends MouseAdapter
	{
		public ListListMouseAdapter() {
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
			ListTableModel model = getDataModel();
			ICFBamRelationTypeObj o = (ICFBamRelationTypeObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = swingSchema.getRelationTypeFactory().newViewEditJInternalFrame( o );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			((ICFBamSwingRelationTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			if( frame == null ) {
				return;
			}
			Container cont = getParent();
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

	protected JMenuBar panelMenuBar = null;
	protected JMenu menuAdd = null;
	protected JMenu menuSelected = null;
	protected ActionAddRelationType actionAddRelationType = null;
	protected ViewSelectedActionRelationType actionViewSelected = null;
	protected EditSelectedActionRelationType actionEditSelected = null;
	protected DeleteSelectedActionRelationType actionDeleteSelected = null;
	protected ListTableModel dataModel = null;
	protected ListTableColumnModel dataColumnModel = null;
	protected ListListSelectionModel dataListSelectionModel = null;
	protected ListListMouseAdapter dataListMouseAdapter = null;
	protected ListListSelectionListener dataListSelectionListener = null;
	protected JTable dataTable = null;
	protected JTableHeader dataTableHeader = null;
	protected JScrollPane dataScrollPane = null;

	public final String S_ColumnNames[] = { "Name" };
	protected boolean swingIsInitializing = true;
	protected boolean swingSortByChain = false;
	protected ICFLibAnyObj swingContainer = null;
	protected ICFJRefreshCallback swingRefreshCallback = null;
	protected ViewEditInternalFrameListener viewEditInternalFrameListener = null;
	protected class ViewEditInternalFrameListener
	implements InternalFrameListener
	{
		public ViewEditInternalFrameListener() {
		}

		public void internalFrameActivated( InternalFrameEvent e ) {
		}

		public void internalFrameClosed( InternalFrameEvent e ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					refreshMe();
				}
			}
		}

		public void internalFrameClosing( InternalFrameEvent e ) {
		}

		public void internalFrameDeactivated( InternalFrameEvent e ) {
		}

		public void internalFrameIconified( InternalFrameEvent e ) {
		}

		public void internalFrameDeiconified( InternalFrameEvent e ) {
		}

		public void internalFrameOpened( InternalFrameEvent e ) {
		}
	}


	public CFBamSwingRelationTypeListJPanel( ICFBamSwingSchema argSchema,
		ICFLibAnyObj argContainer,
		ICFBamRelationTypeObj argFocus,
		Collection<ICFBamRelationTypeObj> argDataCollection,
		ICFJRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		super();
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
		swingFocus = argFocus;
		swingContainer = argContainer;
		swingRefreshCallback = refreshCallback;
		swingSortByChain = sortByChain;
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
		// Do initial layout
		setSize( 1024, 480 );
		JMenuBar menuBar = getPanelMenuBar();
		add( menuBar );
		menuBar.setBounds( 0, 0, 1024, 25 );
		add( dataScrollPane );
		dataScrollPane.setBounds( 0, 25, 1024, 455 );
		adjustListMenuBar();
		doLayout();
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamRelationTypeObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamRelationTypeObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamRelationTypeObj getSwingFocusAsRelationType() {
		return( (ICFBamRelationTypeObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsRelationType( ICFBamRelationTypeObj value ) {
		setSwingFocus( value );
	}

	public class RelationTypeByQualNameComparator
	implements Comparator<ICFBamRelationTypeObj>
	{
		public RelationTypeByQualNameComparator() {
		}

		public int compare( ICFBamRelationTypeObj lhs, ICFBamRelationTypeObj rhs ) {
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

	protected RelationTypeByQualNameComparator compareRelationTypeByQualName = new RelationTypeByQualNameComparator();

	public Collection<ICFBamRelationTypeObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamRelationTypeObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfRelationType = new ICFBamRelationTypeObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfRelationType = new ICFBamRelationTypeObj[ len ];
				Iterator<ICFBamRelationTypeObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfRelationType[idx++] = iter.next();
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
				Arrays.sort( arrayOfRelationType, compareRelationTypeByQualName );
		}
		ListTableModel tblDataModel = getDataModel();
		if( tblDataModel != null ) {
			tblDataModel.fireTableDataChanged();
		}
	}

	protected ViewEditInternalFrameListener getViewEditInternalFrameListener() {
		if( viewEditInternalFrameListener == null ) {
			viewEditInternalFrameListener = new ViewEditInternalFrameListener();
		}
		return( viewEditInternalFrameListener );
	}

	public JMenuBar getPanelMenuBar() {
		if( panelMenuBar == null ) {
			JMenuItem menuItem;
			ICFLibAnyObj container = getSwingContainer();
			panelMenuBar = new JMenuBar();
				menuAdd = new JMenu( "Add" );
					actionAddRelationType = new ActionAddRelationType();
					if( container instanceof ICFLibAnyObj ) {
						menuItem = new JMenuItem( actionAddRelationType );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionRelationType();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionRelationType();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionRelationType();
					menuItem = new JMenuItem( actionDeleteSelected );
					menuSelected.add( menuItem );
				panelMenuBar.add( menuSelected );
		}
		return( panelMenuBar );
	}

	public void doLayout() {
		JComponent compo;
		Dimension sz = getSize();
		compo = getPanelMenuBar();
		compo.setBounds( 0, 0, sz.width, 25 );
		dataScrollPane.setBounds( 0, 25, sz.width, sz.height - 25 );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		super.setPanelMode( value );
		adjustListMenuBar();
	}

	public ListTableModel getDataModel() {
		if( dataModel == null ) {
			dataModel = new ListTableModel();
		}
		return( dataModel );
	}

	public ListTableColumnModel getDataColumnModel() {
		if( dataColumnModel == null ) {
			dataColumnModel = new ListTableColumnModel();
		}
		return( dataColumnModel );
	}

	public ListListSelectionModel getDataListSelectionModel() {
		if( dataListSelectionModel == null ) {
			dataListSelectionModel = new ListListSelectionModel();
		}
		return( dataListSelectionModel );
	}

	public ListListSelectionListener getDataListSelectionListener() {
		if( dataListSelectionListener == null ) {
			dataListSelectionListener = new ListListSelectionListener();
		}
		return( dataListSelectionListener );
	}

	public ListListMouseAdapter getDataListMouseAdapter() {
		if( dataListMouseAdapter == null ) {
			dataListMouseAdapter = new ListListMouseAdapter();
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

	public void adjustListMenuBar() {
		JMenuItem menuItem;
		Action act;
		String itemLabel;
		boolean enableState;
		boolean inEditState;
		boolean allowAdds;
		ICFBamRelationTypeObj selectedObj = getSwingFocusAsRelationType();
		CFJPanel.PanelMode mode = getPanelMode();
		if( mode == CFJPanel.PanelMode.Edit ) {
			inEditState = true;
			if( getSwingContainer() != null ) {
				allowAdds = true;
			}
			else {
				allowAdds = false;
			}
		}
		else {
			inEditState = false;
			allowAdds = false;
		}
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( actionViewSelected != null ) {
			actionViewSelected.setEnabled( enableState );
		}
		if( actionEditSelected != null ) {
			actionEditSelected.setEnabled( inEditState && enableState );
		}
		if( actionDeleteSelected != null ) {
			actionDeleteSelected.setEnabled( inEditState && enableState );
		}
		if( actionAddRelationType != null ) {
			actionAddRelationType.setEnabled( allowAdds );
		}

		if( menuAdd != null ) {
			menuAdd.setEnabled( allowAdds );
		}
		if( menuSelected != null ) {
			menuSelected.setEnabled( enableState );
			int itemCount = menuSelected.getItemCount();
			for( int itemIdx = 0; itemIdx < itemCount; itemIdx ++ ) {
				menuItem = menuSelected.getItem( itemIdx );
				act = menuItem.getAction();
				if( act != null ) {
					if( act == actionViewSelected ) {
						menuItem.setEnabled( enableState );
					}
					else if( act == actionEditSelected ) {
						menuItem.setEnabled( inEditState && enableState );
					}
					else if( act == actionDeleteSelected ) {
						menuItem.setEnabled( inEditState && enableState );
					}
				}
			}
		}
	}

	public ICFLibAnyObj getSwingContainer() {
		return( swingContainer );
	}

	public void setSwingContainer( ICFLibAnyObj value ) {
		swingContainer = value;
	}

	public void refreshMe() {
		if( swingRefreshCallback != null ) {
			swingRefreshCallback.refreshMe();
		}
	}
}