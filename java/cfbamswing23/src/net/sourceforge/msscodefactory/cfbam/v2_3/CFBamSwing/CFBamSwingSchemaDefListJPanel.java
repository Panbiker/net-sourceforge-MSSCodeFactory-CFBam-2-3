// Description: Java 7 Swing List of Obj JPanel implementation for SchemaDef.

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
 *	CFBamSwingSchemaDefListJPanel Swing List of Obj JPanel implementation
 *	for SchemaDef.
 */
public class CFBamSwingSchemaDefListJPanel
extends CFJPanel
implements ICFBamSwingSchemaDefJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamSchemaDefObj> swingDataCollection = null;
	protected ICFBamSchemaDefObj arrayOfSchemaDef[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_ID = 1;
	public final static int COLID_NAME = 2;
	public final static int COLID_DBNAME = 3;
	public final static int COLID_SHORTNAME = 4;
	public final static int COLID_LABEL = 5;
	public final static int COLID_SHORTDESCRIPTION = 6;
	public final static int COLID_DESCRIPTION = 7;
	public final static int COLID_EXTENDCFCORE = 8;
	public final static int COLID_COPYRIGHTPERIOD = 9;
	public final static int COLID_COPYRIGHTHOLDER = 10;
	public final static int COLID_PUBLISHURI = 11;
	public final static int COLID_JSCHEMAOBJIMPORT = 12;
	public final static int COLID_JSCHEMAOBJINTERFACE = 13;
	public final static int COLID_JSCHEMAOBJMEMBERS = 14;
	public final static int COLID_JSCHEMAOBJIMPLEMENTATION = 15;
	public final static int COLID_JDB2LUWSCHEMAOBJMEMBERS = 16;
	public final static int COLID_JDB2LUWSCHEMAOBJIMPL = 17;
	public final static int COLID_JDB2LUWSCHEMAOBJIMPORT = 18;
	public final static int COLID_JMSSQLSCHEMAOBJMEMBERS = 19;
	public final static int COLID_JMSSQLSCHEMAOBJIMPL = 20;
	public final static int COLID_JMSSQLSCHEMAOBJIMPORT = 21;
	public final static int COLID_JMYSQLSCHEMAOBJMEMBERS = 22;
	public final static int COLID_JMYSQLSCHEMAOBJIMPL = 23;
	public final static int COLID_JMYSQLSCHEMAOBJIMPORT = 24;
	public final static int COLID_JORACLESCHEMAOBJMEMBERS = 25;
	public final static int COLID_JORACLESCHEMAOBJIMPL = 26;
	public final static int COLID_JORACLESCHEMAOBJIMPORT = 27;
	public final static int COLID_JPGSQLSCHEMAOBJMEMBERS = 28;
	public final static int COLID_JPGSQLSCHEMAOBJIMPL = 29;
	public final static int COLID_JPGSQLSCHEMAOBJIMPORT = 30;
	public final static int COLID_JSYBASESCHEMAOBJMEMBERS = 31;
	public final static int COLID_JSYBASESCHEMAOBJIMPL = 32;
	public final static int COLID_JSYBASESCHEMAOBJIMPORT = 33;
	public final static int COLID_JRAMSCHEMAOBJMEMBERS = 34;
	public final static int COLID_JRAMSCHEMAOBJIMPL = 35;
	public final static int COLID_JRAMSCHEMAOBJIMPORT = 36;
	public final static int COLID_JXMSGSCHEMAIMPORT = 37;
	public final static int COLID_JXMSGSCHEMAFORMATTERS = 38;
	public final static int COLID_JXMSGCLIENTSCHEMAIMPORT = 39;
	public final static int COLID_JXMSGCLIENTSCHEMABODY = 40;
	public final static int COLID_JXMSGRQSTSCHEMABODY = 41;
	public final static int COLID_JXMSGRQSTSCHEMAIMPORT = 42;
	public final static int COLID_JXMSGRQSTSCHEMAWIREPARSERS = 43;
	public final static int COLID_JXMSGRQSTSCHEMAXSDSPEC = 44;
	public final static int COLID_JXMSGRQSTSCHEMAXSDELEMENTLIST = 45;
	public final static int COLID_JXMSGRSPNSCHEMABODY = 46;
	public final static int COLID_JXMSGRSPNSCHEMAIMPORT = 47;
	public final static int COLID_JXMSGRSPNSCHEMAWIREPARSERS = 48;
	public final static int COLID_JXMSGRSPNSCHEMAXSDELEMENTLIST = 49;
	public final static int COLID_JXMSGRSPNSCHEMAXSDSPEC = 50;
	public final static int COLID_LOOKUP_DEFAULTLICENSE = 51;
	public final static int COLID_LOOKUP_DATASCOPE = 52;
	public final static int COLID_LOOKUP_VACCSEC = 53;
	public final static int COLID_LOOKUP_EACCSEC = 54;
	public final static int COLID_LOOKUP_VACCFREQ = 55;
	public final static int COLID_LOOKUP_EACCFREQ = 56;
	public final static int NUM_COLS = 57;
	protected JTable swingJTable = null;
	protected class ActionAddSchemaDef
	extends AbstractAction
	{
		public ActionAddSchemaDef() {
			super();
			putValue( Action.NAME, "Add SchemaDef..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSchemaDefObj obj = schemaObj.getSchemaDefTableObj().newInstance();
			JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamSchemaDefEditObj edit = (ICFBamSchemaDefEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerCTenant( secTenant );
			ICFBamDomainBaseObj container = (ICFBamDomainBaseObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerDomain( container );
			ICFBamSwingSchemaDefJPanelCommon jpanelCommon = (ICFBamSwingSchemaDefJPanelCommon)frame;
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

	protected class ViewSelectedActionSchemaDef
	extends AbstractAction
	{
		public ViewSelectedActionSchemaDef() {
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
			ICFBamSchemaDefObj selectedInstance = getSwingFocusAsSchemaDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCHM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamSchemaDefObj" );
				}
			}
		}
	}

	protected class EditSelectedActionSchemaDef
	extends AbstractAction
	{
		public EditSelectedActionSchemaDef() {
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
			ICFBamSchemaDefObj selectedInstance = getSwingFocusAsSchemaDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCHM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
						"ICFBamSchemaDefObj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionSchemaDef
	extends AbstractAction
	{
		public DeleteSelectedActionSchemaDef() {
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
			ICFBamSchemaDefObj selectedInstance = getSwingFocusAsSchemaDef();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCHM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamSchemaDefObj" );
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
			if( arrayOfSchemaDef != null ) {
				retval = arrayOfSchemaDef.length;
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
					retval = "SchemaDef";
					break;
				case COLID_OBJQUALIFIEDNAME:
					retval = "Qualified Name";
					break;
				case COLID_ID:
					retval = "Id";
					break;
				case COLID_NAME:
					retval = "Name";
					break;
				case COLID_DBNAME:
					retval = "DbName";
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
				case COLID_EXTENDCFCORE:
					retval = "ExtendCFCore";
					break;
				case COLID_COPYRIGHTPERIOD:
					retval = "CopyrightPeriod";
					break;
				case COLID_COPYRIGHTHOLDER:
					retval = "CopyrightHolder";
					break;
				case COLID_PUBLISHURI:
					retval = "PublishURI";
					break;
				case COLID_JSCHEMAOBJIMPORT:
					retval = "JSchemaObjImport";
					break;
				case COLID_JSCHEMAOBJINTERFACE:
					retval = "JSchemaObjInterface";
					break;
				case COLID_JSCHEMAOBJMEMBERS:
					retval = "JSchemaObjMembers";
					break;
				case COLID_JSCHEMAOBJIMPLEMENTATION:
					retval = "JSchemaObjImplementation";
					break;
				case COLID_JDB2LUWSCHEMAOBJMEMBERS:
					retval = "JDb2LUWSchemaObjMembers";
					break;
				case COLID_JDB2LUWSCHEMAOBJIMPL:
					retval = "JDb2LUWSchemaObjImpl";
					break;
				case COLID_JDB2LUWSCHEMAOBJIMPORT:
					retval = "JDb2LUWSchemaObjImport";
					break;
				case COLID_JMSSQLSCHEMAOBJMEMBERS:
					retval = "JMSSqlSchemaObjMembers";
					break;
				case COLID_JMSSQLSCHEMAOBJIMPL:
					retval = "JMSSqlSchemaObjImpl";
					break;
				case COLID_JMSSQLSCHEMAOBJIMPORT:
					retval = "JMSSqlSchemaObjImport";
					break;
				case COLID_JMYSQLSCHEMAOBJMEMBERS:
					retval = "JMySqlSchemaObjMembers";
					break;
				case COLID_JMYSQLSCHEMAOBJIMPL:
					retval = "JMySqlSchemaObjImpl";
					break;
				case COLID_JMYSQLSCHEMAOBJIMPORT:
					retval = "JMySqlSchemaObjImport";
					break;
				case COLID_JORACLESCHEMAOBJMEMBERS:
					retval = "JOracleSchemaObjMembers";
					break;
				case COLID_JORACLESCHEMAOBJIMPL:
					retval = "JOracleSchemaObjImpl";
					break;
				case COLID_JORACLESCHEMAOBJIMPORT:
					retval = "JOracleSchemaObjImport";
					break;
				case COLID_JPGSQLSCHEMAOBJMEMBERS:
					retval = "JPgSqlSchemaObjMembers";
					break;
				case COLID_JPGSQLSCHEMAOBJIMPL:
					retval = "JPgSqlSchemaObjImpl";
					break;
				case COLID_JPGSQLSCHEMAOBJIMPORT:
					retval = "JPgSqlSchemaObjImport";
					break;
				case COLID_JSYBASESCHEMAOBJMEMBERS:
					retval = "JSybaseSchemaObjMembers";
					break;
				case COLID_JSYBASESCHEMAOBJIMPL:
					retval = "JSybaseSchemaObjImpl";
					break;
				case COLID_JSYBASESCHEMAOBJIMPORT:
					retval = "JSybaseSchemaObjImport";
					break;
				case COLID_JRAMSCHEMAOBJMEMBERS:
					retval = "JRamSchemaObjMembers";
					break;
				case COLID_JRAMSCHEMAOBJIMPL:
					retval = "JRamSchemaObjImpl";
					break;
				case COLID_JRAMSCHEMAOBJIMPORT:
					retval = "JRamSchemaObjImport";
					break;
				case COLID_JXMSGSCHEMAIMPORT:
					retval = "JXMsgSchemaImport";
					break;
				case COLID_JXMSGSCHEMAFORMATTERS:
					retval = "JXMsgSchemaFormatters";
					break;
				case COLID_JXMSGCLIENTSCHEMAIMPORT:
					retval = "JXMsgClientSchemaImport";
					break;
				case COLID_JXMSGCLIENTSCHEMABODY:
					retval = "JXMsgClientSchemaBody";
					break;
				case COLID_JXMSGRQSTSCHEMABODY:
					retval = "JXMsgRqstSchemaBody";
					break;
				case COLID_JXMSGRQSTSCHEMAIMPORT:
					retval = "JXMsgRqstSchemaImport";
					break;
				case COLID_JXMSGRQSTSCHEMAWIREPARSERS:
					retval = "JXMsgRqstSchemaWireParsers";
					break;
				case COLID_JXMSGRQSTSCHEMAXSDSPEC:
					retval = "JXMsgRqstSchemaXsdSpec";
					break;
				case COLID_JXMSGRQSTSCHEMAXSDELEMENTLIST:
					retval = "JXMsgRqstSchemaXsdElementList";
					break;
				case COLID_JXMSGRSPNSCHEMABODY:
					retval = "JXMsgRspnSchemaBody";
					break;
				case COLID_JXMSGRSPNSCHEMAIMPORT:
					retval = "JXMsgRspnSchemaImport";
					break;
				case COLID_JXMSGRSPNSCHEMAWIREPARSERS:
					retval = "JXMsgRspnSchemaWireParsers";
					break;
				case COLID_JXMSGRSPNSCHEMAXSDELEMENTLIST:
					retval = "JXMsgRspnSchemaXsdElementList";
					break;
				case COLID_JXMSGRSPNSCHEMAXSDSPEC:
					retval = "JXMsgRspnSchemaXsdSpec";
					break;
				case COLID_LOOKUP_DEFAULTLICENSE:
					retval = "Default License";
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
			if( arrayOfSchemaDef == null ) {
				return( null );
			}
			int len = arrayOfSchemaDef.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamSchemaDefObj obj = arrayOfSchemaDef[row];
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
					retval = new Long( obj.getRequiredId() );
					break;
				case COLID_NAME:
					retval = obj.getRequiredName();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_DBNAME:
					retval = obj.getOptionalDbName();
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
				case COLID_EXTENDCFCORE:
					retval = new Boolean( obj.getRequiredExtendCFCore() );
					break;
				case COLID_COPYRIGHTPERIOD:
					retval = obj.getRequiredCopyrightPeriod();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_COPYRIGHTHOLDER:
					retval = obj.getRequiredCopyrightHolder();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_PUBLISHURI:
					retval = obj.getRequiredPublishURI();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSCHEMAOBJIMPORT:
					retval = obj.getOptionalJSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSCHEMAOBJINTERFACE:
					retval = obj.getOptionalJSchemaObjInterface();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSCHEMAOBJIMPLEMENTATION:
					retval = obj.getOptionalJSchemaObjImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJDb2LUWSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWSCHEMAOBJIMPL:
					retval = obj.getOptionalJDb2LUWSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWSCHEMAOBJIMPORT:
					retval = obj.getOptionalJDb2LUWSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJMSSqlSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLSCHEMAOBJIMPL:
					retval = obj.getOptionalJMSSqlSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLSCHEMAOBJIMPORT:
					retval = obj.getOptionalJMSSqlSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJMySqlSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLSCHEMAOBJIMPL:
					retval = obj.getOptionalJMySqlSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLSCHEMAOBJIMPORT:
					retval = obj.getOptionalJMySqlSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLESCHEMAOBJMEMBERS:
					retval = obj.getOptionalJOracleSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLESCHEMAOBJIMPL:
					retval = obj.getOptionalJOracleSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLESCHEMAOBJIMPORT:
					retval = obj.getOptionalJOracleSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJPgSqlSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLSCHEMAOBJIMPL:
					retval = obj.getOptionalJPgSqlSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLSCHEMAOBJIMPORT:
					retval = obj.getOptionalJPgSqlSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASESCHEMAOBJMEMBERS:
					retval = obj.getOptionalJSybaseSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASESCHEMAOBJIMPL:
					retval = obj.getOptionalJSybaseSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASESCHEMAOBJIMPORT:
					retval = obj.getOptionalJSybaseSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMSCHEMAOBJMEMBERS:
					retval = obj.getOptionalJRamSchemaObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMSCHEMAOBJIMPL:
					retval = obj.getOptionalJRamSchemaObjImpl();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMSCHEMAOBJIMPORT:
					retval = obj.getOptionalJRamSchemaObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGSCHEMAIMPORT:
					retval = obj.getOptionalJXMsgSchemaImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGSCHEMAFORMATTERS:
					retval = obj.getOptionalJXMsgSchemaFormatters();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGCLIENTSCHEMAIMPORT:
					retval = obj.getOptionalJXMsgClientSchemaImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGCLIENTSCHEMABODY:
					retval = obj.getOptionalJXMsgClientSchemaBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTSCHEMABODY:
					retval = obj.getOptionalJXMsgRqstSchemaBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTSCHEMAIMPORT:
					retval = obj.getOptionalJXMsgRqstSchemaImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTSCHEMAWIREPARSERS:
					retval = obj.getOptionalJXMsgRqstSchemaWireParsers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTSCHEMAXSDSPEC:
					retval = obj.getOptionalJXMsgRqstSchemaXsdSpec();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTSCHEMAXSDELEMENTLIST:
					retval = obj.getOptionalJXMsgRqstSchemaXsdElementList();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNSCHEMABODY:
					retval = obj.getOptionalJXMsgRspnSchemaBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNSCHEMAIMPORT:
					retval = obj.getOptionalJXMsgRspnSchemaImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNSCHEMAWIREPARSERS:
					retval = obj.getOptionalJXMsgRspnSchemaWireParsers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNSCHEMAXSDELEMENTLIST:
					retval = obj.getOptionalJXMsgRspnSchemaXsdElementList();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNSCHEMAXSDSPEC:
					retval = obj.getOptionalJXMsgRspnSchemaXsdSpec();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_LOOKUP_DEFAULTLICENSE:
					retval = obj.getOptionalLookupDefaultLicense( swingIsInitializing );
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

		public class ExtendCFCoreColumn
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
				return( "ExtendCFCore" );
			}

			public ExtendCFCoreColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_EXTENDCFCORE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class CopyrightPeriodColumn
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
				return( "CopyrightPeriod" );
			}

			public CopyrightPeriodColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_COPYRIGHTPERIOD );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class CopyrightHolderColumn
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
				return( "CopyrightHolder" );
			}

			public CopyrightHolderColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_COPYRIGHTHOLDER );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PublishURIColumn
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
				return( "PublishURI" );
			}

			public PublishURIColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_PUBLISHURI );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSchemaObjImport" );
			}

			public JSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSchemaObjInterfaceColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSchemaObjInterface" );
			}

			public JSchemaObjInterfaceColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSCHEMAOBJINTERFACE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSchemaObjMembers" );
			}

			public JSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSchemaObjImplementationColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSchemaObjImplementation" );
			}

			public JSchemaObjImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSCHEMAOBJIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JDb2LUWSchemaObjMembers" );
			}

			public JDb2LUWSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JDb2LUWSchemaObjImpl" );
			}

			public JDb2LUWSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWSCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JDb2LUWSchemaObjImport" );
			}

			public JDb2LUWSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMSSqlSchemaObjMembers" );
			}

			public JMSSqlSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMSSqlSchemaObjImpl" );
			}

			public JMSSqlSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLSCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMSSqlSchemaObjImport" );
			}

			public JMSSqlSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMySqlSchemaObjMembers" );
			}

			public JMySqlSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMySqlSchemaObjImpl" );
			}

			public JMySqlSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLSCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JMySqlSchemaObjImport" );
			}

			public JMySqlSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JOracleSchemaObjMembers" );
			}

			public JOracleSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLESCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JOracleSchemaObjImpl" );
			}

			public JOracleSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLESCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JOracleSchemaObjImport" );
			}

			public JOracleSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLESCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JPgSqlSchemaObjMembers" );
			}

			public JPgSqlSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JPgSqlSchemaObjImpl" );
			}

			public JPgSqlSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLSCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JPgSqlSchemaObjImport" );
			}

			public JPgSqlSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSybaseSchemaObjMembers" );
			}

			public JSybaseSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASESCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSybaseSchemaObjImpl" );
			}

			public JSybaseSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASESCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JSybaseSchemaObjImport" );
			}

			public JSybaseSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASESCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamSchemaObjMembersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JRamSchemaObjMembers" );
			}

			public JRamSchemaObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMSCHEMAOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamSchemaObjImplColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JRamSchemaObjImpl" );
			}

			public JRamSchemaObjImplColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMSCHEMAOBJIMPL );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamSchemaObjImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JRamSchemaObjImport" );
			}

			public JRamSchemaObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMSCHEMAOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgSchemaImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgSchemaImport" );
			}

			public JXMsgSchemaImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGSCHEMAIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgSchemaFormattersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgSchemaFormatters" );
			}

			public JXMsgSchemaFormattersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGSCHEMAFORMATTERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgClientSchemaImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgClientSchemaImport" );
			}

			public JXMsgClientSchemaImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGCLIENTSCHEMAIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgClientSchemaBodyColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgClientSchemaBody" );
			}

			public JXMsgClientSchemaBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGCLIENTSCHEMABODY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstSchemaBodyColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRqstSchemaBody" );
			}

			public JXMsgRqstSchemaBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTSCHEMABODY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstSchemaImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRqstSchemaImport" );
			}

			public JXMsgRqstSchemaImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTSCHEMAIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstSchemaWireParsersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRqstSchemaWireParsers" );
			}

			public JXMsgRqstSchemaWireParsersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTSCHEMAWIREPARSERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstSchemaXsdSpecColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRqstSchemaXsdSpec" );
			}

			public JXMsgRqstSchemaXsdSpecColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTSCHEMAXSDSPEC );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstSchemaXsdElementListColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRqstSchemaXsdElementList" );
			}

			public JXMsgRqstSchemaXsdElementListColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTSCHEMAXSDELEMENTLIST );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnSchemaBodyColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRspnSchemaBody" );
			}

			public JXMsgRspnSchemaBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNSCHEMABODY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnSchemaImportColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRspnSchemaImport" );
			}

			public JXMsgRspnSchemaImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNSCHEMAIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnSchemaWireParsersColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRspnSchemaWireParsers" );
			}

			public JXMsgRspnSchemaWireParsersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNSCHEMAWIREPARSERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnSchemaXsdElementListColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRspnSchemaXsdElementList" );
			}

			public JXMsgRspnSchemaXsdElementListColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNSCHEMAXSDELEMENTLIST );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnSchemaXsdSpecColumn
		extends TableColumn
		{
			protected class ColumnCellRenderer
			extends CFTextColumnCellRenderer
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
				return( "JXMsgRspnSchemaXsdSpec" );
			}

			public JXMsgRspnSchemaXsdSpecColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNSCHEMAXSDSPEC );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class DefaultLicenseColumn
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
				return( "Default License" );
			}

			public DefaultLicenseColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_DEFAULTLICENSE );
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
			addColumn( new IdColumn() );
			addColumn( new NameColumn() );
			addColumn( new DbNameColumn() );
			addColumn( new ShortNameColumn() );
			addColumn( new LabelColumn() );
			addColumn( new ShortDescriptionColumn() );
			addColumn( new DescriptionColumn() );
			addColumn( new ExtendCFCoreColumn() );
			addColumn( new CopyrightPeriodColumn() );
			addColumn( new CopyrightHolderColumn() );
			addColumn( new PublishURIColumn() );
			addColumn( new JSchemaObjImportColumn() );
			addColumn( new JSchemaObjInterfaceColumn() );
			addColumn( new JSchemaObjMembersColumn() );
			addColumn( new JSchemaObjImplementationColumn() );
			addColumn( new JDb2LUWSchemaObjMembersColumn() );
			addColumn( new JDb2LUWSchemaObjImplColumn() );
			addColumn( new JDb2LUWSchemaObjImportColumn() );
			addColumn( new JMSSqlSchemaObjMembersColumn() );
			addColumn( new JMSSqlSchemaObjImplColumn() );
			addColumn( new JMSSqlSchemaObjImportColumn() );
			addColumn( new JMySqlSchemaObjMembersColumn() );
			addColumn( new JMySqlSchemaObjImplColumn() );
			addColumn( new JMySqlSchemaObjImportColumn() );
			addColumn( new JOracleSchemaObjMembersColumn() );
			addColumn( new JOracleSchemaObjImplColumn() );
			addColumn( new JOracleSchemaObjImportColumn() );
			addColumn( new JPgSqlSchemaObjMembersColumn() );
			addColumn( new JPgSqlSchemaObjImplColumn() );
			addColumn( new JPgSqlSchemaObjImportColumn() );
			addColumn( new JSybaseSchemaObjMembersColumn() );
			addColumn( new JSybaseSchemaObjImplColumn() );
			addColumn( new JSybaseSchemaObjImportColumn() );
			addColumn( new JRamSchemaObjMembersColumn() );
			addColumn( new JRamSchemaObjImplColumn() );
			addColumn( new JRamSchemaObjImportColumn() );
			addColumn( new JXMsgSchemaImportColumn() );
			addColumn( new JXMsgSchemaFormattersColumn() );
			addColumn( new JXMsgClientSchemaImportColumn() );
			addColumn( new JXMsgClientSchemaBodyColumn() );
			addColumn( new JXMsgRqstSchemaBodyColumn() );
			addColumn( new JXMsgRqstSchemaImportColumn() );
			addColumn( new JXMsgRqstSchemaWireParsersColumn() );
			addColumn( new JXMsgRqstSchemaXsdSpecColumn() );
			addColumn( new JXMsgRqstSchemaXsdElementListColumn() );
			addColumn( new JXMsgRspnSchemaBodyColumn() );
			addColumn( new JXMsgRspnSchemaImportColumn() );
			addColumn( new JXMsgRspnSchemaWireParsersColumn() );
			addColumn( new JXMsgRspnSchemaXsdElementListColumn() );
			addColumn( new JXMsgRspnSchemaXsdSpecColumn() );
			addColumn( new DefaultLicenseColumn() );
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
			ICFBamSchemaDefObj selectedObj;
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
				if( selectedRowData instanceof ICFBamSchemaDefObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamSchemaDefObj)selectedRowData;
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
						"ICFBamSchemaDefObj" );
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
			ICFBamSchemaDefObj o = (ICFBamSchemaDefObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( o );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	protected ActionAddSchemaDef actionAddSchemaDef = null;
	protected ViewSelectedActionSchemaDef actionViewSelected = null;
	protected EditSelectedActionSchemaDef actionEditSelected = null;
	protected DeleteSelectedActionSchemaDef actionDeleteSelected = null;
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
	protected ICFBamDomainBaseObj swingContainer = null;
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


	public CFBamSwingSchemaDefListJPanel( ICFBamSwingSchema argSchema,
		ICFBamDomainBaseObj argContainer,
		ICFBamSchemaDefObj argFocus,
		Collection<ICFBamSchemaDefObj> argDataCollection,
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
		if( ( value == null ) || ( value instanceof ICFBamSchemaDefObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSchemaDefObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamSchemaDefObj getSwingFocusAsSchemaDef() {
		return( (ICFBamSchemaDefObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSchemaDef( ICFBamSchemaDefObj value ) {
		setSwingFocus( value );
	}

	public class SchemaDefByQualNameComparator
	implements Comparator<ICFBamSchemaDefObj>
	{
		public SchemaDefByQualNameComparator() {
		}

		public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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

	protected SchemaDefByQualNameComparator compareSchemaDefByQualName = new SchemaDefByQualNameComparator();

	public Collection<ICFBamSchemaDefObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamSchemaDefObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfSchemaDef = new ICFBamSchemaDefObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfSchemaDef = new ICFBamSchemaDefObj[ len ];
				Iterator<ICFBamSchemaDefObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfSchemaDef[idx++] = iter.next();
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
				Arrays.sort( arrayOfSchemaDef, compareSchemaDefByQualName );
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
					actionAddSchemaDef = new ActionAddSchemaDef();
					if( container instanceof ICFBamDomainBaseObj ) {
						menuItem = new JMenuItem( actionAddSchemaDef );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionSchemaDef();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionSchemaDef();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionSchemaDef();
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
		ICFBamSchemaDefObj selectedObj = getSwingFocusAsSchemaDef();
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
		if( actionAddSchemaDef != null ) {
			actionAddSchemaDef.setEnabled( allowAdds );
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

	public ICFBamDomainBaseObj getSwingContainer() {
		return( swingContainer );
	}

	public void setSwingContainer( ICFBamDomainBaseObj value ) {
		swingContainer = value;
	}

	public void refreshMe() {
		if( swingRefreshCallback != null ) {
			swingRefreshCallback.refreshMe();
		}
	}
}
