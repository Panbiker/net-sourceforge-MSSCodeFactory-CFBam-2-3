// Description: Java 7 Swing List of Obj JPanel implementation for TZDateDef.

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
 *	CFBamSwingTZDateDefListJPanel Swing List of Obj JPanel implementation
 *	for TZDateDef.
 */
public class CFBamSwingTZDateDefListJPanel
extends CFJPanel
implements ICFBamSwingTZDateDefJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamTZDateDefObj> swingDataCollection = null;
	protected ICFBamTZDateDefObj arrayOfTZDateDef[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_OBJKIND = 1;
	public final static int COLID_ID = 2;
	public final static int COLID_NAME = 3;
	public final static int COLID_SHORTNAME = 4;
	public final static int COLID_LABEL = 5;
	public final static int COLID_SHORTDESCRIPTION = 6;
	public final static int COLID_DESCRIPTION = 7;
	public final static int COLID_ISNULLABLE = 8;
	public final static int COLID_GENERATEID = 9;
	public final static int COLID_DEFAULTVISIBILITY = 10;
	public final static int COLID_DBNAME = 11;
	public final static int COLID_INITVALUE = 12;
	public final static int COLID_DEFAULTVALUE = 13;
	public final static int COLID_MINVALUE = 14;
	public final static int COLID_MAXVALUE = 15;
	public final static int COLID_NULLVALUE = 16;
	public final static int COLID_UNKNOWNVALUE = 17;
	public final static int COLID_LOOKUP_DEFSCHEMA = 18;
	public final static int COLID_LOOKUP_DATASCOPE = 19;
	public final static int COLID_LOOKUP_VACCSEC = 20;
	public final static int COLID_LOOKUP_EACCSEC = 21;
	public final static int COLID_LOOKUP_VACCFREQ = 22;
	public final static int COLID_LOOKUP_EACCFREQ = 23;
	public final static int NUM_COLS = 24;
	protected JTable swingJTable = null;
	protected class ActionAddTZDateCol
	extends AbstractAction
	{
		public ActionAddTZDateCol() {
			super();
			putValue( Action.NAME, "Add TZDateCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZDateColObj obj = schemaObj.getTZDateColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZDateColEditObj edit = (ICFBamTZDateColEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamTableObj container = (ICFBamTableObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerTable( container );
			ICFBamSwingTZDateColJPanelCommon jpanelCommon = (ICFBamSwingTZDateColJPanelCommon)frame;
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

	protected class ActionAddTZDateType
	extends AbstractAction
	{
		public ActionAddTZDateType() {
			super();
			putValue( Action.NAME, "Add TZDateType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZDateTypeObj obj = schemaObj.getTZDateTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZDateTypeEditObj edit = (ICFBamTZDateTypeEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamSchemaDefObj container = (ICFBamSchemaDefObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerSchemaDef( container );
			ICFBamSwingTZDateTypeJPanelCommon jpanelCommon = (ICFBamSwingTZDateTypeJPanelCommon)frame;
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

	protected class ViewSelectedActionTZDateDef
	extends AbstractAction
	{
		public ViewSelectedActionTZDateDef() {
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
			ICFBamTZDateDefObj selectedInstance = getSwingFocusAsTZDateDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "DAZD".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZC".equals( classCode ) ) {
					ICFBamTZDateColObj obj = (ICFBamTZDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZT".equals( classCode ) ) {
					ICFBamTZDateTypeObj obj = (ICFBamTZDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj" );
				}
			}
		}
	}

	protected class EditSelectedActionTZDateDef
	extends AbstractAction
	{
		public EditSelectedActionTZDateDef() {
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
			ICFBamTZDateDefObj selectedInstance = getSwingFocusAsTZDateDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "DAZD".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "DAZC".equals( classCode ) ) {
					ICFBamTZDateColObj obj = (ICFBamTZDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "DAZT".equals( classCode ) ) {
					ICFBamTZDateTypeObj obj = (ICFBamTZDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
						"ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionTZDateDef
	extends AbstractAction
	{
		public DeleteSelectedActionTZDateDef() {
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
			ICFBamTZDateDefObj selectedInstance = getSwingFocusAsTZDateDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "DAZD".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingTZDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZC".equals( classCode ) ) {
					ICFBamTZDateColObj obj = (ICFBamTZDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZT".equals( classCode ) ) {
					ICFBamTZDateTypeObj obj = (ICFBamTZDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj" );
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
			if( arrayOfTZDateDef != null ) {
				retval = arrayOfTZDateDef.length;
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
					retval = "TZDateDef";
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = "Qualified Name";
					break;
				case COLID_OBJKIND:
					retval = "Object Kind";
					break;
				case COLID_ID:
					retval = "Id";
					break;
				case COLID_NAME:
					retval = "Name";
					break;
				case COLID_SHORTNAME:
					retval = "ShortName";
					break;
				case COLID_LABEL:
					retval = "Label";
					break;
				case COLID_SHORTDESCRIPTION:
					retval = "ShortDescription";
					break;
				case COLID_DESCRIPTION:
					retval = "Description";
					break;
				case COLID_ISNULLABLE:
					retval = "IsNullable";
					break;
				case COLID_GENERATEID:
					retval = "GenerateId";
					break;
				case COLID_DEFAULTVISIBILITY:
					retval = "DefaultVisibility";
					break;
				case COLID_DBNAME:
					retval = "DbName";
					break;
				case COLID_INITVALUE:
					retval = "InitValue";
					break;
				case COLID_DEFAULTVALUE:
					retval = "DefaultValue";
					break;
				case COLID_MINVALUE:
					retval = "MinValue";
					break;
				case COLID_MAXVALUE:
					retval = "MaxValue";
					break;
				case COLID_NULLVALUE:
					retval = "NullValue";
					break;
				case COLID_UNKNOWNVALUE:
					retval = "UnknownValue";
					break;
				case COLID_LOOKUP_DEFSCHEMA:
					retval = "Defining Schema Definition";
					break;
				case COLID_LOOKUP_DATASCOPE:
					retval = "DataScope";
					break;
				case COLID_LOOKUP_VACCSEC:
					retval = "ViewAccessSecurity";
					break;
				case COLID_LOOKUP_EACCSEC:
					retval = "EditAccessSecurity";
					break;
				case COLID_LOOKUP_VACCFREQ:
					retval = "ViewAccessFrequency";
					break;
				case COLID_LOOKUP_EACCFREQ:
					retval = "EditAccessFrequency";
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
			if( arrayOfTZDateDef == null ) {
				return( null );
			}
			int len = arrayOfTZDateDef.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamTZDateDefObj obj = arrayOfTZDateDef[row];
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
				case COLID_OBJKIND:
					String classCode = obj.getClassCode();
					if( classCode.equals( "DAZD" ) ) {
						retval = "TZDateDef";
					}
					else if( classCode.equals( "DAZC" ) ) {
						retval = "TZDateCol";
					}
					else if( classCode.equals( "DAZT" ) ) {
						retval = "TZDateType";
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Unsupported class code \"" + classCode + "\" detected" );
					}
					break;
				case COLID_ID:
					retval = new Long( obj.getRequiredId() );
					break;
				case COLID_NAME:
					retval = obj.getRequiredName();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_SHORTNAME:
					retval = obj.getOptionalShortName();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_LABEL:
					retval = obj.getOptionalLabel();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_SHORTDESCRIPTION:
					retval = obj.getOptionalShortDescription();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_DESCRIPTION:
					retval = obj.getOptionalDescription();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_ISNULLABLE:
					retval = new Boolean( obj.getRequiredIsNullable() );
					break;
				case COLID_GENERATEID:
					retval = obj.getOptionalGenerateId();
					break;
				case COLID_DEFAULTVISIBILITY:
					retval = new Boolean( obj.getRequiredDefaultVisibility() );
					break;
				case COLID_DBNAME:
					retval = obj.getOptionalDbName();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_INITVALUE:
					retval = obj.getOptionalInitValue();
					break;
				case COLID_DEFAULTVALUE:
					retval = obj.getOptionalDefaultValue();
					break;
				case COLID_MINVALUE:
					retval = obj.getOptionalMinValue();
					break;
				case COLID_MAXVALUE:
					retval = obj.getOptionalMaxValue();
					break;
				case COLID_NULLVALUE:
					retval = obj.getOptionalNullValue();
					break;
				case COLID_UNKNOWNVALUE:
					retval = obj.getOptionalUnknownValue();
					break;
				case COLID_LOOKUP_DEFSCHEMA:
					retval = obj.getOptionalLookupDefSchema( swingIsInitializing );
					break;
				case COLID_LOOKUP_DATASCOPE:
					retval = obj.getOptionalLookupDataScope( swingIsInitializing );
					break;
				case COLID_LOOKUP_VACCSEC:
					retval = obj.getOptionalLookupVAccSec( swingIsInitializing );
					break;
				case COLID_LOOKUP_EACCSEC:
					retval = obj.getOptionalLookupEAccSec( swingIsInitializing );
					break;
				case COLID_LOOKUP_VACCFREQ:
					retval = obj.getOptionalLookupVAccFreq( swingIsInitializing );
					break;
				case COLID_LOOKUP_EACCFREQ:
					retval = obj.getOptionalLookupEAccFreq( swingIsInitializing );
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

		public class ObjKindColumn
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
				return( "Object Kind" );
			}

			public ObjKindColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_OBJKIND );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class IdColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFInt64ColumnCellRenderer
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

		public class ShortNameColumn
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
				return( "ShortName" );
			}

			public ShortNameColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_SHORTNAME );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class LabelColumn
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
				return( "Label" );
			}

			public LabelColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LABEL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class ShortDescriptionColumn
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
				return( "ShortDescription" );
			}

			public ShortDescriptionColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_SHORTDESCRIPTION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DescriptionColumn
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
				return( "Description" );
			}

			public DescriptionColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_DESCRIPTION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class IsNullableColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFBoolColumnCellRenderer
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
				return( "IsNullable" );
			}

			public IsNullableColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_ISNULLABLE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class GenerateIdColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFBoolColumnCellRenderer
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
				return( "GenerateId" );
			}

			public GenerateIdColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_GENERATEID );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DefaultVisibilityColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFBoolColumnCellRenderer
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
				return( "DefaultVisibility" );
			}

			public DefaultVisibilityColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_DEFAULTVISIBILITY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DbNameColumn
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
				return( "DbName" );
			}

			public DbNameColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_DBNAME );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class InitValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "InitValue" );
			}

			public InitValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_INITVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DefaultValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "DefaultValue" );
			}

			public DefaultValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_DEFAULTVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class MinValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "MinValue" );
			}

			public MinValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_MINVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class MaxValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "MaxValue" );
			}

			public MaxValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_MAXVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class NullValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "NullValue" );
			}

			public NullValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_NULLVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class UnknownValueColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTZDateColumnCellRenderer
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
				return( "UnknownValue" );
			}

			public UnknownValueColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_UNKNOWNVALUE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DefSchemaColumn
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
				return( "Defining Schema Definition" );
			}

			public DefSchemaColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_DEFSCHEMA );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DataScopeColumn
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
				return( "DataScope" );
			}

			public DataScopeColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_DATASCOPE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class VAccSecColumn
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
				return( "ViewAccessSecurity" );
			}

			public VAccSecColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_VACCSEC );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class EAccSecColumn
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
				return( "EditAccessSecurity" );
			}

			public EAccSecColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_EACCSEC );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class VAccFreqColumn
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
				return( "ViewAccessFrequency" );
			}

			public VAccFreqColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_VACCFREQ );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class EAccFreqColumn
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
				return( "EditAccessFrequency" );
			}

			public EAccFreqColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_EACCFREQ );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public ListTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new ObjKindColumn() );
			addColumn( new IdColumn() );
			addColumn( new NameColumn() );
			addColumn( new ShortNameColumn() );
			addColumn( new LabelColumn() );
			addColumn( new ShortDescriptionColumn() );
			addColumn( new DescriptionColumn() );
			addColumn( new IsNullableColumn() );
			addColumn( new GenerateIdColumn() );
			addColumn( new DefaultVisibilityColumn() );
			addColumn( new DbNameColumn() );
			addColumn( new InitValueColumn() );
			addColumn( new DefaultValueColumn() );
			addColumn( new MinValueColumn() );
			addColumn( new MaxValueColumn() );
			addColumn( new NullValueColumn() );
			addColumn( new UnknownValueColumn() );
			addColumn( new DefSchemaColumn() );
			addColumn( new DataScopeColumn() );
			addColumn( new VAccSecColumn() );
			addColumn( new EAccSecColumn() );
			addColumn( new VAccFreqColumn() );
			addColumn( new EAccFreqColumn() );
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
			ICFBamTZDateDefObj selectedObj;
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
				if( selectedRowData instanceof ICFBamTZDateDefObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamTZDateDefObj)selectedRowData;
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
						"ICFBamTZDateDefObj" );
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
			ICFBamTZDateDefObj o = (ICFBamTZDateDefObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = null;
			String classCode = o.getClassCode();
			if( classCode.equals( "DAZD" ) ) {
				frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DAZC" ) ) {
				frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( (ICFBamTZDateColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DAZT" ) ) {
				frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( (ICFBamTZDateTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else {
				frame = null;
			}
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
	protected ActionAddTZDateCol actionAddTZDateCol = null;
	protected ActionAddTZDateType actionAddTZDateType = null;
	protected ViewSelectedActionTZDateDef actionViewSelected = null;
	protected EditSelectedActionTZDateDef actionEditSelected = null;
	protected DeleteSelectedActionTZDateDef actionDeleteSelected = null;
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
	protected ICFBamScopeObj swingContainer = null;
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


	public CFBamSwingTZDateDefListJPanel( ICFBamSwingSchema argSchema,
		ICFBamScopeObj argContainer,
		ICFBamTZDateDefObj argFocus,
		Collection<ICFBamTZDateDefObj> argDataCollection,
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
		if( ( value == null ) || ( value instanceof ICFBamTZDateDefObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTZDateDefObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamTZDateDefObj getSwingFocusAsTZDateDef() {
		return( (ICFBamTZDateDefObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsTZDateDef( ICFBamTZDateDefObj value ) {
		setSwingFocus( value );
	}

	public class TZDateDefByQualNameComparator
	implements Comparator<ICFBamTZDateDefObj>
	{
		public TZDateDefByQualNameComparator() {
		}

		public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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

	protected TZDateDefByQualNameComparator compareTZDateDefByQualName = new TZDateDefByQualNameComparator();

	public Collection<ICFBamTZDateDefObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamTZDateDefObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfTZDateDef = new ICFBamTZDateDefObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfTZDateDef = new ICFBamTZDateDefObj[ len ];
				Iterator<ICFBamTZDateDefObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfTZDateDef[idx++] = iter.next();
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
				Arrays.sort( arrayOfTZDateDef, compareTZDateDefByQualName );
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
					actionAddTZDateCol = new ActionAddTZDateCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTZDateCol );
						menuAdd.add( menuItem );
					}
					actionAddTZDateType = new ActionAddTZDateType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTZDateType );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionTZDateDef();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionTZDateDef();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionTZDateDef();
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
		ICFBamTZDateDefObj selectedObj = getSwingFocusAsTZDateDef();
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

	public ICFBamScopeObj getSwingContainer() {
		return( swingContainer );
	}

	public void setSwingContainer( ICFBamScopeObj value ) {
		swingContainer = value;
	}

	public void refreshMe() {
		if( swingRefreshCallback != null ) {
			swingRefreshCallback.refreshMe();
		}
	}
}
