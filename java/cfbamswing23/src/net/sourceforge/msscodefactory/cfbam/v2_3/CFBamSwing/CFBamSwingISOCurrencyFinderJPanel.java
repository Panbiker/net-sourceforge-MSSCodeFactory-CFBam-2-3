// Description: Java 7 Swing Finder JPanel implementation for ISOCurrency.

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
import javax.swing.event.*;
import javax.swing.table.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingISOCurrencyFinderJPanel Swing Finder JPanel implementation
 *	for ISOCurrency.
 */
public class CFBamSwingISOCurrencyFinderJPanel
extends CFJPanel
implements ICFJRefreshCallback
{
	protected ICFBamSwingSchema swingSchema = null;
	protected boolean swingIsInitializing = true;
	protected java.util.List<ICFBamISOCurrencyObj> listOfISOCurrency = null;
	protected ICFBamISOCurrencyObj arrayOfISOCurrency[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_ID = 1;
	public final static int COLID_ISOCODE = 2;
	public final static int COLID_NAME = 3;
	public final static int COLID_UNITSYMBOL = 4;
	public final static int COLID_FRACSYMBOL = 5;
	public final static int COLID_PRECIS = 6;
	public final static int NUM_COLS = 7;

	public class FinderTableModel
	extends AbstractTableModel
	{
		public FinderTableModel() {
			super();
		}

		public int getRowCount() {
			int retval;
			if( arrayOfISOCurrency != null ) {
				retval = arrayOfISOCurrency.length;
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
					retval = "ISO Currency";
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = "Qualified Name";
					break;
				case COLID_ID:
					retval = "Id";
					break;
				case COLID_ISOCODE:
					retval = "ISOCode";
					break;
				case COLID_NAME:
					retval = "Name";
					break;
				case COLID_UNITSYMBOL:
					retval = "UnitSymbol";
					break;
				case COLID_FRACSYMBOL:
					retval = "FracSymbol";
					break;
				case COLID_PRECIS:
					retval = "Precis";
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
			if( arrayOfISOCurrency == null ) {
				return( null );
			}
			int len = arrayOfISOCurrency.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamISOCurrencyObj obj = arrayOfISOCurrency[row];
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
				case COLID_ISOCODE:
					retval = obj.getRequiredISOCode();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_NAME:
					retval = obj.getRequiredName();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_UNITSYMBOL:
					retval = obj.getOptionalUnitSymbol();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_FRACSYMBOL:
					retval = obj.getOptionalFracSymbol();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_PRECIS:
					retval = new Short( obj.getRequiredPrecis() );
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

	public class FinderTableColumnModel
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

		public class ISOCodeColumn
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
				return( "ISOCode" );
			}

			public ISOCodeColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_ISOCODE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class NameColumn
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
				return( "Name" );
			}

			public NameColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_NAME );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class UnitSymbolColumn
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
				return( "UnitSymbol" );
			}

			public UnitSymbolColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_UNITSYMBOL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class FracSymbolColumn
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
				return( "FracSymbol" );
			}

			public FracSymbolColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_FRACSYMBOL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PrecisColumn
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
				return( "Precis" );
			}

			public PrecisColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_PRECIS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public FinderTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new IdColumn() );
			addColumn( new ISOCodeColumn() );
			addColumn( new NameColumn() );
			addColumn( new UnitSymbolColumn() );
			addColumn( new FracSymbolColumn() );
			addColumn( new PrecisColumn() );
		}
	}

	public class FinderListSelectionModel
	extends DefaultListSelectionModel
	{
		public FinderListSelectionModel() {
			super();
			setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		}
	}

	public class FinderListSelectionListener
	implements ListSelectionListener
	{
		public FinderListSelectionListener() {
		}

		public void valueChanged( ListSelectionEvent lse ) {
			final String S_ProcName = "valueChanged";
			ICFBamISOCurrencyObj selectedObj;
			if( lse.getValueIsAdjusting() ) {
				return;
			}
			if( dataTable == null ) {
				return;
			}
			int dataRow = dataTable.getSelectedRow();
			int modelIndex = dataTable.convertRowIndexToModel( dataRow );
			FinderTableModel tblDataModel = getDataModel();
			Object selectedRowData = tblDataModel.getValueAt( modelIndex, COLID_ROW_HEADER );
			if( selectedRowData != null ) {
				if( selectedRowData instanceof ICFBamISOCurrencyObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamISOCurrencyObj)selectedRowData;
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
						"ICFBamISOCurrencyObj" );
				}
			}
			else {
				selectedObj = null;
			}
			Container cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof CFJInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				CFJInternalFrame frame = (CFJInternalFrame)cont;
				if( frame instanceof ICFBamSwingISOCurrencyJPanelCommon ) {
					ICFBamSwingISOCurrencyJPanelCommon jpanelCommon = (ICFBamSwingISOCurrencyJPanelCommon)frame;
					jpanelCommon.setSwingFocus( selectedObj );
				}
			}
		}
	}

	public class FinderListMouseAdapter
	extends MouseAdapter
	{
		public FinderListMouseAdapter() {
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
			FinderTableModel model = getDataModel();
			ICFBamISOCurrencyObj o = (ICFBamISOCurrencyObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = swingSchema.getISOCurrencyFactory().newViewEditJInternalFrame( o );
			((ICFBamSwingISOCurrencyJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected FinderTableModel dataModel = null;
	protected FinderTableColumnModel dataColumnModel = null;
	protected FinderListSelectionModel dataListSelectionModel = null;
	protected FinderListMouseAdapter dataListMouseAdapter = null;
	protected FinderListSelectionListener dataListSelectionListener = null;
	protected JTable dataTable = null;
	protected JTableHeader dataTableHeader = null;
	protected JScrollPane dataScrollPane = null;
	protected ViewEditInternalFrameListener viewEditInternalFrameListener = null;
	protected class ViewEditInternalFrameListener
	implements InternalFrameListener
	{
		public ViewEditInternalFrameListener() {
		}

		public void internalFrameActivated( InternalFrameEvent e ) {
		}

		public void internalFrameClosed( InternalFrameEvent e ) {
			refreshMe();
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


	public CFBamSwingISOCurrencyFinderJPanel( ICFBamSwingSchema argSchema ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		swingSchema = argSchema;
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
		add( dataScrollPane );
		loadData( true );
		doLayout();
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public class ISOCurrencyByQualNameComparator
	implements Comparator<ICFBamISOCurrencyObj>
	{
		public ISOCurrencyByQualNameComparator() {
		}

		public int compare( ICFBamISOCurrencyObj lhs, ICFBamISOCurrencyObj rhs ) {
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

	protected ISOCurrencyByQualNameComparator compareISOCurrencyByQualName = new ISOCurrencyByQualNameComparator();

	public void loadData( boolean forceReload ) {
		ICFBamSchemaObj schemaObj = swingSchema.getSchema();
		if( ( listOfISOCurrency == null ) || forceReload ) {
			arrayOfISOCurrency = null;
			listOfISOCurrency = schemaObj.getISOCurrencyTableObj().readAllISOCurrency( swingIsInitializing );
			if( listOfISOCurrency != null ) {
				Object objArray[] = listOfISOCurrency.toArray();
				if( objArray != null ) {
					int len = objArray.length;
					arrayOfISOCurrency = new ICFBamISOCurrencyObj[ len ];
					for( int i = 0; i < len; i++ ) {
						arrayOfISOCurrency[i] = (ICFBamISOCurrencyObj)objArray[i];
					}
					Arrays.sort( arrayOfISOCurrency, compareISOCurrencyByQualName );
				}
			}
		}
	}

	public FinderTableModel getDataModel() {
		if( dataModel == null ) {
			dataModel = new FinderTableModel();
		}
		return( dataModel );
	}

	public FinderTableColumnModel getDataColumnModel() {
		if( dataColumnModel == null ) {
			dataColumnModel = new FinderTableColumnModel();
		}
		return( dataColumnModel );
	}

	public FinderListSelectionModel getDataListSelectionModel() {
		if( dataListSelectionModel == null ) {
			dataListSelectionModel = new FinderListSelectionModel();
		}
		return( dataListSelectionModel );
	}

	public FinderListSelectionListener getDataListSelectionListener() {
		if( dataListSelectionListener == null ) {
			dataListSelectionListener = new FinderListSelectionListener();
		}
		return( dataListSelectionListener );
	}

	public FinderListMouseAdapter getDataListMouseAdapter() {
		if( dataListMouseAdapter == null ) {
			dataListMouseAdapter = new FinderListMouseAdapter();
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

	public void doLayout() {
		Dimension sz = getSize();
		dataScrollPane.setBounds( 0, 0, sz.width, sz.height );
		dataScrollPane.doLayout();
	}

	protected ViewEditInternalFrameListener getViewEditInternalFrameListener() {
		if( viewEditInternalFrameListener == null ) {
			viewEditInternalFrameListener = new ViewEditInternalFrameListener();
		}
		return( viewEditInternalFrameListener );
	}

	public void refreshMe() {
		loadData( true );
	}
}
