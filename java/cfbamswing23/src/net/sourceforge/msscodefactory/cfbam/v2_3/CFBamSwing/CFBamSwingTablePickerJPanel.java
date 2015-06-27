// Description: Java 7 Swing Picker of Obj JPanel implementation for Table.

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
 *	CFBamSwingTablePickerJPanel Swing Pick Obj JPanel implementation
 *	for Table.
 */
public class CFBamSwingTablePickerJPanel
extends CFJPanel
implements ICFBamSwingTableJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamTableObj> swingDataCollection = null;
	protected ICFBamTableObj arrayOfTable[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_ID = 1;
	public final static int COLID_NAME = 2;
	public final static int COLID_DBNAME = 3;
	public final static int COLID_SHORTNAME = 4;
	public final static int COLID_LABEL = 5;
	public final static int COLID_SHORTDESCRIPTION = 6;
	public final static int COLID_DESCRIPTION = 7;
	public final static int COLID_TABLECLASSCODE = 8;
	public final static int COLID_POLYBASE = 9;
	public final static int COLID_ISINSTANTIABLE = 10;
	public final static int COLID_HASHISTORY = 11;
	public final static int COLID_HASAUDITCOLUMNS = 12;
	public final static int COLID_JOBJMEMBERS = 13;
	public final static int COLID_JOBJINTERFACE = 14;
	public final static int COLID_JOBJIMPORT = 15;
	public final static int COLID_JOBJIMPLEMENTATION = 16;
	public final static int COLID_JEDITOBJMEMBERS = 17;
	public final static int COLID_JEDITOBJINTERFACE = 18;
	public final static int COLID_JEDITOBJIMPORT = 19;
	public final static int COLID_JEDITOBJIMPLEMENTATION = 20;
	public final static int COLID_JTABLEIMPORT = 21;
	public final static int COLID_JTABLEMEMBERS = 22;
	public final static int COLID_JTABLEINTERFACE = 23;
	public final static int COLID_JTABLEIMPLEMENTATION = 24;
	public final static int COLID_JTABLEOBJIMPORT = 25;
	public final static int COLID_JTABLEOBJMEMBERS = 26;
	public final static int COLID_JTABLEOBJINTERFACE = 27;
	public final static int COLID_JTABLEOBJIMPLEMENTATION = 28;
	public final static int COLID_JDB2LUWTABLEIMPORT = 29;
	public final static int COLID_JDB2LUWTABLEMEMBERS = 30;
	public final static int COLID_JDB2LUWTABLEIMPLEMENTATION = 31;
	public final static int COLID_JMSSQLTABLEIMPORT = 32;
	public final static int COLID_JMSSQLTABLEMEMBERS = 33;
	public final static int COLID_JMSSQLTABLEIMPLEMENTATION = 34;
	public final static int COLID_JMYSQLTABLEIMPORT = 35;
	public final static int COLID_JMYSQLTABLEMEMBERS = 36;
	public final static int COLID_JMYSQLTABLEIMPLEMENTATION = 37;
	public final static int COLID_JORACLETABLEIMPORT = 38;
	public final static int COLID_JORACLETABLEMEMBERS = 39;
	public final static int COLID_JORACLETABLEIMPLEMENTATION = 40;
	public final static int COLID_JPGSQLTABLEIMPORT = 41;
	public final static int COLID_JPGSQLTABLEMEMBERS = 42;
	public final static int COLID_JPGSQLTABLEIMPLEMENTATION = 43;
	public final static int COLID_JSYBASETABLEIMPORT = 44;
	public final static int COLID_JSYBASETABLEMEMBERS = 45;
	public final static int COLID_JSYBASETABLEIMPLEMENTATION = 46;
	public final static int COLID_JRAMTABLEIMPORT = 47;
	public final static int COLID_JRAMTABLEMEMBERS = 48;
	public final static int COLID_JRAMTABLEIMPLEMENTATION = 49;
	public final static int COLID_JSAXLOADERIMPORT = 50;
	public final static int COLID_JSAXLOADERSTARTELEMENT = 51;
	public final static int COLID_JSAXLOADERENDELEMENT = 52;
	public final static int COLID_JXMSGTABLEIMPORT = 53;
	public final static int COLID_JXMSGTABLEFORMATTERS = 54;
	public final static int COLID_JXMSGRQSTTABLEIMPORT = 55;
	public final static int COLID_JXMSGRSPNTABLEIMPORT = 56;
	public final static int COLID_JXMSGCLIENTTABLEIMPORT = 57;
	public final static int COLID_JXMSGRQSTTABLEBODY = 58;
	public final static int COLID_JXMSGRSPNTABLEBODY = 59;
	public final static int COLID_JXMSGCLIENTTABLEBODY = 60;
	public final static int COLID_DEFAULTVISIBILITY = 61;
	public final static int COLID_LOOKUP_DEFSCHEMA = 62;
	public final static int COLID_LOOKUP_LOOKUPINDEX = 63;
	public final static int COLID_LOOKUP_ALTINDEX = 64;
	public final static int COLID_LOOKUP_QUALTABLE = 65;
	public final static int COLID_LOOKUP_LOADERBEHAVIOUR = 66;
	public final static int COLID_LOOKUP_PRIMARYINDEX = 67;
	public final static int COLID_LOOKUP_DATASCOPE = 68;
	public final static int COLID_LOOKUP_SECSCOPE = 69;
	public final static int COLID_LOOKUP_VACCSEC = 70;
	public final static int COLID_LOOKUP_EACCSEC = 71;
	public final static int COLID_LOOKUP_VACCFREQ = 72;
	public final static int COLID_LOOKUP_EACCFREQ = 73;
	public final static int NUM_COLS = 74;
	protected JTable swingJTable = null;
	public class PickerTableModel
	extends AbstractTableModel
	{
		public PickerTableModel() {
			super();
		}

		public int getRowCount() {
			int retval;
			if( arrayOfTable != null ) {
				retval = arrayOfTable.length;
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
					retval = "Table";
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
				case COLID_TABLECLASSCODE:
					retval = "TableClassCode";
					break;
				case COLID_POLYBASE:
					retval = "PolyBase";
					break;
				case COLID_ISINSTANTIABLE:
					retval = "IsInstantiable";
					break;
				case COLID_HASHISTORY:
					retval = "HasHistory";
					break;
				case COLID_HASAUDITCOLUMNS:
					retval = "HasAuditColumns";
					break;
				case COLID_JOBJMEMBERS:
					retval = "JObjMembers";
					break;
				case COLID_JOBJINTERFACE:
					retval = "JObjInterface";
					break;
				case COLID_JOBJIMPORT:
					retval = "JObjImport";
					break;
				case COLID_JOBJIMPLEMENTATION:
					retval = "JObjImplementation";
					break;
				case COLID_JEDITOBJMEMBERS:
					retval = "JEditObjMembers";
					break;
				case COLID_JEDITOBJINTERFACE:
					retval = "JEditObjInterface";
					break;
				case COLID_JEDITOBJIMPORT:
					retval = "JEditObjImport";
					break;
				case COLID_JEDITOBJIMPLEMENTATION:
					retval = "JEditObjImplementation";
					break;
				case COLID_JTABLEIMPORT:
					retval = "JTableImport";
					break;
				case COLID_JTABLEMEMBERS:
					retval = "JTableMembers";
					break;
				case COLID_JTABLEINTERFACE:
					retval = "JTableInterface";
					break;
				case COLID_JTABLEIMPLEMENTATION:
					retval = "JTableImplementation";
					break;
				case COLID_JTABLEOBJIMPORT:
					retval = "JTableObjImport";
					break;
				case COLID_JTABLEOBJMEMBERS:
					retval = "JTableObjMembers";
					break;
				case COLID_JTABLEOBJINTERFACE:
					retval = "JTableObjInterface";
					break;
				case COLID_JTABLEOBJIMPLEMENTATION:
					retval = "JTableObjImplementation";
					break;
				case COLID_JDB2LUWTABLEIMPORT:
					retval = "JDb2LUWTableImport";
					break;
				case COLID_JDB2LUWTABLEMEMBERS:
					retval = "JDb2LUWTableMembers";
					break;
				case COLID_JDB2LUWTABLEIMPLEMENTATION:
					retval = "JDb2LUWTableImplementation";
					break;
				case COLID_JMSSQLTABLEIMPORT:
					retval = "JMSSqlTableImport";
					break;
				case COLID_JMSSQLTABLEMEMBERS:
					retval = "JMSSqlTableMembers";
					break;
				case COLID_JMSSQLTABLEIMPLEMENTATION:
					retval = "JMSSqlTableImplementation";
					break;
				case COLID_JMYSQLTABLEIMPORT:
					retval = "JMySqlTableImport";
					break;
				case COLID_JMYSQLTABLEMEMBERS:
					retval = "JMySqlTableMembers";
					break;
				case COLID_JMYSQLTABLEIMPLEMENTATION:
					retval = "JMySqlTableImplementation";
					break;
				case COLID_JORACLETABLEIMPORT:
					retval = "JOracleTableImport";
					break;
				case COLID_JORACLETABLEMEMBERS:
					retval = "JOracleTableMembers";
					break;
				case COLID_JORACLETABLEIMPLEMENTATION:
					retval = "JOracleTableImplementation";
					break;
				case COLID_JPGSQLTABLEIMPORT:
					retval = "JPgSqlTableImport";
					break;
				case COLID_JPGSQLTABLEMEMBERS:
					retval = "JPgSqlTableMembers";
					break;
				case COLID_JPGSQLTABLEIMPLEMENTATION:
					retval = "JPgSqlTableImplementation";
					break;
				case COLID_JSYBASETABLEIMPORT:
					retval = "JSybaseTableImport";
					break;
				case COLID_JSYBASETABLEMEMBERS:
					retval = "JSybaseTableMembers";
					break;
				case COLID_JSYBASETABLEIMPLEMENTATION:
					retval = "JSybaseTableImplementation";
					break;
				case COLID_JRAMTABLEIMPORT:
					retval = "JRamTableImport";
					break;
				case COLID_JRAMTABLEMEMBERS:
					retval = "JRamTableMembers";
					break;
				case COLID_JRAMTABLEIMPLEMENTATION:
					retval = "JRamTableImplementation";
					break;
				case COLID_JSAXLOADERIMPORT:
					retval = "JSaxLoaderImport";
					break;
				case COLID_JSAXLOADERSTARTELEMENT:
					retval = "JSaxLoaderStartElement";
					break;
				case COLID_JSAXLOADERENDELEMENT:
					retval = "JSaxLoaderEndElement";
					break;
				case COLID_JXMSGTABLEIMPORT:
					retval = "JXMsgTableImport";
					break;
				case COLID_JXMSGTABLEFORMATTERS:
					retval = "JXMsgTableFormatters";
					break;
				case COLID_JXMSGRQSTTABLEIMPORT:
					retval = "JXMsgRqstTableImport";
					break;
				case COLID_JXMSGRSPNTABLEIMPORT:
					retval = "JXMsgRspnTableImport";
					break;
				case COLID_JXMSGCLIENTTABLEIMPORT:
					retval = "JXMsgClientTableImport";
					break;
				case COLID_JXMSGRQSTTABLEBODY:
					retval = "JXMsgRqstTableBody";
					break;
				case COLID_JXMSGRSPNTABLEBODY:
					retval = "JXMsgRspnTableBody";
					break;
				case COLID_JXMSGCLIENTTABLEBODY:
					retval = "JXMsgClientTableBody";
					break;
				case COLID_DEFAULTVISIBILITY:
					retval = "DefaultVisibility";
					break;
				case COLID_LOOKUP_DEFSCHEMA:
					retval = "Defining Schema Definition";
					break;
				case COLID_LOOKUP_LOOKUPINDEX:
					retval = "Lookup Index";
					break;
				case COLID_LOOKUP_ALTINDEX:
					retval = "Alt Index";
					break;
				case COLID_LOOKUP_QUALTABLE:
					retval = "Qualifying Table";
					break;
				case COLID_LOOKUP_LOADERBEHAVIOUR:
					retval = "LoaderBehaviour";
					break;
				case COLID_LOOKUP_PRIMARYINDEX:
					retval = "Primary Index";
					break;
				case COLID_LOOKUP_DATASCOPE:
					retval = "DataScope";
					break;
				case COLID_LOOKUP_SECSCOPE:
					retval = "Security Scope";
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
			if( ( row < 0 ) || ( column < -1 ) ) {
				return( null );
			}
			if( arrayOfTable == null ) {
				return( null );
			}
			int len = arrayOfTable.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamTableObj obj = arrayOfTable[row];
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
				case COLID_TABLECLASSCODE:
					retval = obj.getRequiredTableClassCode();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_POLYBASE:
					retval = new Boolean( obj.getRequiredPolyBase() );
					break;
				case COLID_ISINSTANTIABLE:
					retval = new Boolean( obj.getRequiredIsInstantiable() );
					break;
				case COLID_HASHISTORY:
					retval = new Boolean( obj.getRequiredHasHistory() );
					break;
				case COLID_HASAUDITCOLUMNS:
					retval = new Boolean( obj.getRequiredHasAuditColumns() );
					break;
				case COLID_JOBJMEMBERS:
					retval = obj.getOptionalJObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JOBJINTERFACE:
					retval = obj.getOptionalJObjInterface();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JOBJIMPORT:
					retval = obj.getOptionalJObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JOBJIMPLEMENTATION:
					retval = obj.getOptionalJObjImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JEDITOBJMEMBERS:
					retval = obj.getOptionalJEditObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JEDITOBJINTERFACE:
					retval = obj.getOptionalJEditObjInterface();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JEDITOBJIMPORT:
					retval = obj.getOptionalJEditObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JEDITOBJIMPLEMENTATION:
					retval = obj.getOptionalJEditObjImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEIMPORT:
					retval = obj.getOptionalJTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEMEMBERS:
					retval = obj.getOptionalJTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEINTERFACE:
					retval = obj.getOptionalJTableInterface();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEIMPLEMENTATION:
					retval = obj.getOptionalJTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEOBJIMPORT:
					retval = obj.getOptionalJTableObjImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEOBJMEMBERS:
					retval = obj.getOptionalJTableObjMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEOBJINTERFACE:
					retval = obj.getOptionalJTableObjInterface();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JTABLEOBJIMPLEMENTATION:
					retval = obj.getOptionalJTableObjImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWTABLEIMPORT:
					retval = obj.getOptionalJDb2LUWTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWTABLEMEMBERS:
					retval = obj.getOptionalJDb2LUWTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JDB2LUWTABLEIMPLEMENTATION:
					retval = obj.getOptionalJDb2LUWTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLTABLEIMPORT:
					retval = obj.getOptionalJMSSqlTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLTABLEMEMBERS:
					retval = obj.getOptionalJMSSqlTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMSSQLTABLEIMPLEMENTATION:
					retval = obj.getOptionalJMSSqlTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLTABLEIMPORT:
					retval = obj.getOptionalJMySqlTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLTABLEMEMBERS:
					retval = obj.getOptionalJMySqlTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JMYSQLTABLEIMPLEMENTATION:
					retval = obj.getOptionalJMySqlTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLETABLEIMPORT:
					retval = obj.getOptionalJOracleTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLETABLEMEMBERS:
					retval = obj.getOptionalJOracleTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JORACLETABLEIMPLEMENTATION:
					retval = obj.getOptionalJOracleTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLTABLEIMPORT:
					retval = obj.getOptionalJPgSqlTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLTABLEMEMBERS:
					retval = obj.getOptionalJPgSqlTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JPGSQLTABLEIMPLEMENTATION:
					retval = obj.getOptionalJPgSqlTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASETABLEIMPORT:
					retval = obj.getOptionalJSybaseTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASETABLEMEMBERS:
					retval = obj.getOptionalJSybaseTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSYBASETABLEIMPLEMENTATION:
					retval = obj.getOptionalJSybaseTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMTABLEIMPORT:
					retval = obj.getOptionalJRamTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMTABLEMEMBERS:
					retval = obj.getOptionalJRamTableMembers();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JRAMTABLEIMPLEMENTATION:
					retval = obj.getOptionalJRamTableImplementation();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSAXLOADERIMPORT:
					retval = obj.getOptionalJSaxLoaderImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSAXLOADERSTARTELEMENT:
					retval = obj.getOptionalJSaxLoaderStartElement();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JSAXLOADERENDELEMENT:
					retval = obj.getOptionalJSaxLoaderEndElement();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGTABLEIMPORT:
					retval = obj.getOptionalJXMsgTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGTABLEFORMATTERS:
					retval = obj.getOptionalJXMsgTableFormatters();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTTABLEIMPORT:
					retval = obj.getOptionalJXMsgRqstTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNTABLEIMPORT:
					retval = obj.getOptionalJXMsgRspnTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGCLIENTTABLEIMPORT:
					retval = obj.getOptionalJXMsgClientTableImport();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRQSTTABLEBODY:
					retval = obj.getOptionalJXMsgRqstTableBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGRSPNTABLEBODY:
					retval = obj.getOptionalJXMsgRspnTableBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_JXMSGCLIENTTABLEBODY:
					retval = obj.getOptionalJXMsgClientTableBody();
					if( retval == null ) {
						retval = "";
					}
					break;
				case COLID_DEFAULTVISIBILITY:
					retval = new Boolean( obj.getRequiredDefaultVisibility() );
					break;
				case COLID_LOOKUP_DEFSCHEMA:
					retval = obj.getOptionalLookupDefSchema();
					break;
				case COLID_LOOKUP_LOOKUPINDEX:
					retval = obj.getOptionalLookupLookupIndex();
					break;
				case COLID_LOOKUP_ALTINDEX:
					retval = obj.getOptionalLookupAltIndex();
					break;
				case COLID_LOOKUP_QUALTABLE:
					retval = obj.getOptionalLookupQualTable();
					break;
				case COLID_LOOKUP_LOADERBEHAVIOUR:
					retval = obj.getRequiredLookupLoaderBehaviour();
					break;
				case COLID_LOOKUP_PRIMARYINDEX:
					retval = obj.getOptionalLookupPrimaryIndex();
					break;
				case COLID_LOOKUP_DATASCOPE:
					retval = obj.getOptionalLookupDataScope();
					break;
				case COLID_LOOKUP_SECSCOPE:
					retval = obj.getRequiredLookupSecScope();
					break;
				case COLID_LOOKUP_VACCSEC:
					retval = obj.getOptionalLookupVAccSec();
					break;
				case COLID_LOOKUP_EACCSEC:
					retval = obj.getOptionalLookupEAccSec();
					break;
				case COLID_LOOKUP_VACCFREQ:
					retval = obj.getOptionalLookupVAccFreq();
					break;
				case COLID_LOOKUP_EACCFREQ:
					retval = obj.getOptionalLookupEAccFreq();
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

		public class TableClassCodeColumn
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
				return( "TableClassCode" );
			}

			public TableClassCodeColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_TABLECLASSCODE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PolyBaseColumn
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
				return( "PolyBase" );
			}

			public PolyBaseColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_POLYBASE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class IsInstantiableColumn
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
				return( "IsInstantiable" );
			}

			public IsInstantiableColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_ISINSTANTIABLE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class HasHistoryColumn
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
				return( "HasHistory" );
			}

			public HasHistoryColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_HASHISTORY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class HasAuditColumnsColumn
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
				return( "HasAuditColumns" );
			}

			public HasAuditColumnsColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_HASAUDITCOLUMNS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JObjMembersColumn
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
				return( "JObjMembers" );
			}

			public JObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JObjInterfaceColumn
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
				return( "JObjInterface" );
			}

			public JObjInterfaceColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JOBJINTERFACE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JObjImportColumn
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
				return( "JObjImport" );
			}

			public JObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JObjImplementationColumn
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
				return( "JObjImplementation" );
			}

			public JObjImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JOBJIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JEditObjMembersColumn
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
				return( "JEditObjMembers" );
			}

			public JEditObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JEDITOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JEditObjInterfaceColumn
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
				return( "JEditObjInterface" );
			}

			public JEditObjInterfaceColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JEDITOBJINTERFACE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JEditObjImportColumn
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
				return( "JEditObjImport" );
			}

			public JEditObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JEDITOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JEditObjImplementationColumn
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
				return( "JEditObjImplementation" );
			}

			public JEditObjImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JEDITOBJIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableImportColumn
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
				return( "JTableImport" );
			}

			public JTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableMembersColumn
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
				return( "JTableMembers" );
			}

			public JTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableInterfaceColumn
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
				return( "JTableInterface" );
			}

			public JTableInterfaceColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEINTERFACE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableImplementationColumn
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
				return( "JTableImplementation" );
			}

			public JTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableObjImportColumn
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
				return( "JTableObjImport" );
			}

			public JTableObjImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEOBJIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableObjMembersColumn
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
				return( "JTableObjMembers" );
			}

			public JTableObjMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEOBJMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableObjInterfaceColumn
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
				return( "JTableObjInterface" );
			}

			public JTableObjInterfaceColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEOBJINTERFACE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JTableObjImplementationColumn
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
				return( "JTableObjImplementation" );
			}

			public JTableObjImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JTABLEOBJIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWTableImportColumn
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
				return( "JDb2LUWTableImport" );
			}

			public JDb2LUWTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWTableMembersColumn
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
				return( "JDb2LUWTableMembers" );
			}

			public JDb2LUWTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JDb2LUWTableImplementationColumn
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
				return( "JDb2LUWTableImplementation" );
			}

			public JDb2LUWTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JDB2LUWTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlTableImportColumn
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
				return( "JMSSqlTableImport" );
			}

			public JMSSqlTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlTableMembersColumn
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
				return( "JMSSqlTableMembers" );
			}

			public JMSSqlTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMSSqlTableImplementationColumn
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
				return( "JMSSqlTableImplementation" );
			}

			public JMSSqlTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMSSQLTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlTableImportColumn
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
				return( "JMySqlTableImport" );
			}

			public JMySqlTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlTableMembersColumn
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
				return( "JMySqlTableMembers" );
			}

			public JMySqlTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JMySqlTableImplementationColumn
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
				return( "JMySqlTableImplementation" );
			}

			public JMySqlTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JMYSQLTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleTableImportColumn
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
				return( "JOracleTableImport" );
			}

			public JOracleTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLETABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleTableMembersColumn
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
				return( "JOracleTableMembers" );
			}

			public JOracleTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLETABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JOracleTableImplementationColumn
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
				return( "JOracleTableImplementation" );
			}

			public JOracleTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JORACLETABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlTableImportColumn
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
				return( "JPgSqlTableImport" );
			}

			public JPgSqlTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlTableMembersColumn
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
				return( "JPgSqlTableMembers" );
			}

			public JPgSqlTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JPgSqlTableImplementationColumn
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
				return( "JPgSqlTableImplementation" );
			}

			public JPgSqlTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JPGSQLTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseTableImportColumn
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
				return( "JSybaseTableImport" );
			}

			public JSybaseTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASETABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseTableMembersColumn
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
				return( "JSybaseTableMembers" );
			}

			public JSybaseTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASETABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSybaseTableImplementationColumn
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
				return( "JSybaseTableImplementation" );
			}

			public JSybaseTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSYBASETABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamTableImportColumn
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
				return( "JRamTableImport" );
			}

			public JRamTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamTableMembersColumn
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
				return( "JRamTableMembers" );
			}

			public JRamTableMembersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMTABLEMEMBERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JRamTableImplementationColumn
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
				return( "JRamTableImplementation" );
			}

			public JRamTableImplementationColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JRAMTABLEIMPLEMENTATION );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSaxLoaderImportColumn
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
				return( "JSaxLoaderImport" );
			}

			public JSaxLoaderImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSAXLOADERIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSaxLoaderStartElementColumn
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
				return( "JSaxLoaderStartElement" );
			}

			public JSaxLoaderStartElementColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSAXLOADERSTARTELEMENT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JSaxLoaderEndElementColumn
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
				return( "JSaxLoaderEndElement" );
			}

			public JSaxLoaderEndElementColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JSAXLOADERENDELEMENT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgTableImportColumn
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
				return( "JXMsgTableImport" );
			}

			public JXMsgTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgTableFormattersColumn
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
				return( "JXMsgTableFormatters" );
			}

			public JXMsgTableFormattersColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGTABLEFORMATTERS );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstTableImportColumn
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
				return( "JXMsgRqstTableImport" );
			}

			public JXMsgRqstTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnTableImportColumn
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
				return( "JXMsgRspnTableImport" );
			}

			public JXMsgRspnTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgClientTableImportColumn
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
				return( "JXMsgClientTableImport" );
			}

			public JXMsgClientTableImportColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGCLIENTTABLEIMPORT );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRqstTableBodyColumn
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
				return( "JXMsgRqstTableBody" );
			}

			public JXMsgRqstTableBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRQSTTABLEBODY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgRspnTableBodyColumn
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
				return( "JXMsgRspnTableBody" );
			}

			public JXMsgRspnTableBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGRSPNTABLEBODY );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class JXMsgClientTableBodyColumn
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
				return( "JXMsgClientTableBody" );
			}

			public JXMsgClientTableBodyColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_JXMSGCLIENTTABLEBODY );
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

		public class LookupIndexColumn
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
				return( "Lookup Index" );
			}

			public LookupIndexColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_LOOKUPINDEX );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class AltIndexColumn
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
				return( "Alt Index" );
			}

			public AltIndexColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_ALTINDEX );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class QualTableColumn
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
				return( "Qualifying Table" );
			}

			public QualTableColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_QUALTABLE );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class LoaderBehaviourColumn
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
				return( "LoaderBehaviour" );
			}

			public LoaderBehaviourColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_LOADERBEHAVIOUR );
				setMinWidth( 125 );
				setResizable( true );
			}
		}

		public class PrimaryIndexColumn
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
				return( "Primary Index" );
			}

			public PrimaryIndexColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_PRIMARYINDEX );
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

		public class SecScopeColumn
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
				return( "Security Scope" );
			}

			public SecScopeColumn() {
				super();
				setCellRenderer( new ColumnCellRenderer() );
				setHeaderRenderer( new ColumnHeaderRenderer() );
				setModelIndex( COLID_LOOKUP_SECSCOPE );
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

		public PickerTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new IdColumn() );
			addColumn( new NameColumn() );
			addColumn( new DbNameColumn() );
			addColumn( new ShortNameColumn() );
			addColumn( new LabelColumn() );
			addColumn( new ShortDescriptionColumn() );
			addColumn( new DescriptionColumn() );
			addColumn( new TableClassCodeColumn() );
			addColumn( new PolyBaseColumn() );
			addColumn( new IsInstantiableColumn() );
			addColumn( new HasHistoryColumn() );
			addColumn( new HasAuditColumnsColumn() );
			addColumn( new JObjMembersColumn() );
			addColumn( new JObjInterfaceColumn() );
			addColumn( new JObjImportColumn() );
			addColumn( new JObjImplementationColumn() );
			addColumn( new JEditObjMembersColumn() );
			addColumn( new JEditObjInterfaceColumn() );
			addColumn( new JEditObjImportColumn() );
			addColumn( new JEditObjImplementationColumn() );
			addColumn( new JTableImportColumn() );
			addColumn( new JTableMembersColumn() );
			addColumn( new JTableInterfaceColumn() );
			addColumn( new JTableImplementationColumn() );
			addColumn( new JTableObjImportColumn() );
			addColumn( new JTableObjMembersColumn() );
			addColumn( new JTableObjInterfaceColumn() );
			addColumn( new JTableObjImplementationColumn() );
			addColumn( new JDb2LUWTableImportColumn() );
			addColumn( new JDb2LUWTableMembersColumn() );
			addColumn( new JDb2LUWTableImplementationColumn() );
			addColumn( new JMSSqlTableImportColumn() );
			addColumn( new JMSSqlTableMembersColumn() );
			addColumn( new JMSSqlTableImplementationColumn() );
			addColumn( new JMySqlTableImportColumn() );
			addColumn( new JMySqlTableMembersColumn() );
			addColumn( new JMySqlTableImplementationColumn() );
			addColumn( new JOracleTableImportColumn() );
			addColumn( new JOracleTableMembersColumn() );
			addColumn( new JOracleTableImplementationColumn() );
			addColumn( new JPgSqlTableImportColumn() );
			addColumn( new JPgSqlTableMembersColumn() );
			addColumn( new JPgSqlTableImplementationColumn() );
			addColumn( new JSybaseTableImportColumn() );
			addColumn( new JSybaseTableMembersColumn() );
			addColumn( new JSybaseTableImplementationColumn() );
			addColumn( new JRamTableImportColumn() );
			addColumn( new JRamTableMembersColumn() );
			addColumn( new JRamTableImplementationColumn() );
			addColumn( new JSaxLoaderImportColumn() );
			addColumn( new JSaxLoaderStartElementColumn() );
			addColumn( new JSaxLoaderEndElementColumn() );
			addColumn( new JXMsgTableImportColumn() );
			addColumn( new JXMsgTableFormattersColumn() );
			addColumn( new JXMsgRqstTableImportColumn() );
			addColumn( new JXMsgRspnTableImportColumn() );
			addColumn( new JXMsgClientTableImportColumn() );
			addColumn( new JXMsgRqstTableBodyColumn() );
			addColumn( new JXMsgRspnTableBodyColumn() );
			addColumn( new JXMsgClientTableBodyColumn() );
			addColumn( new DefaultVisibilityColumn() );
			addColumn( new DefSchemaColumn() );
			addColumn( new LookupIndexColumn() );
			addColumn( new AltIndexColumn() );
			addColumn( new QualTableColumn() );
			addColumn( new LoaderBehaviourColumn() );
			addColumn( new PrimaryIndexColumn() );
			addColumn( new DataScopeColumn() );
			addColumn( new SecScopeColumn() );
			addColumn( new VAccSecColumn() );
			addColumn( new EAccSecColumn() );
			addColumn( new VAccFreqColumn() );
			addColumn( new EAccFreqColumn() );
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
			ICFBamTableObj selectedObj;
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
				if( selectedRowData instanceof ICFBamTableObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamTableObj)selectedRowData;
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
						"ICFBamTableObj" );
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
			ICFBamTableObj o = (ICFBamTableObj)model.getValueAt( row, COLID_ROW_HEADER );
			invokeWhenChosen.choseTable( o );
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
	protected ICFBamSwingTableChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj swingContainer = null;
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
			invokeWhenChosen.choseTable( null );
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

	protected class ActionChooseSelectedTable
	extends AbstractAction
	{
		public ActionChooseSelectedTable() {
			super();
			putValue( Action.NAME, "Choose Selected Table" );
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
			ICFBamTableObj selectedInstance = getSwingFocusAsTable();
			invokeWhenChosen.choseTable( selectedInstance );
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

	public CFBamSwingTablePickerJPanel( ICFBamSwingSchema argSchema,
		ICFBamTableObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamTableObj> argDataCollection,
		ICFBamSwingTableChosen whenChosen )
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
		actionChooseSelected = new ActionChooseSelectedTable();
		buttonChooseSelected = new JButton( actionChooseSelected );
		// Do initial layout
		setSize( 1024, 480 );
		add( buttonChooseNone );
		add( buttonChooseSelected );
		add( buttonCancel );
		add( dataScrollPane );
		dataScrollPane.setBounds( 0, 35, 1024, 455 );
		doLayout();
		setSwingFocusAsTable( argFocus );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamTableObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTableObj" );
		}
		if( dataTable == null ) {
			return;
		}
		if( value == null ) {
			dataTable.clearSelection();
		}
		else {
			ICFBamTableObj curSelected;
			PickerTableModel tblDataModel = getDataModel();
			int selectedRow = dataTable.getSelectedRow();
			int modelIndex = dataTable.convertRowIndexToModel( selectedRow );
			if( selectedRow >= 0 ) {
				Object selectedRowData = tblDataModel.getValueAt( modelIndex, COLID_ROW_HEADER );
				curSelected = (ICFBamTableObj)selectedRowData;
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

	public ICFBamTableObj getSwingFocusAsTable() {
		return( (ICFBamTableObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsTable( ICFBamTableObj value ) {
		setSwingFocus( value );
	}

	public class TableByQualNameComparator
	implements Comparator<ICFBamTableObj>
	{
		public TableByQualNameComparator() {
		}

		public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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

	protected TableByQualNameComparator compareTableByQualName = new TableByQualNameComparator();

	public Collection<ICFBamTableObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamTableObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfTable = new ICFBamTableObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfTable = new ICFBamTableObj[ len ];
			Iterator<ICFBamTableObj> iter = swingDataCollection.iterator();
			int idx = 0;
			while( iter.hasNext() && ( idx < len ) ) {
				arrayOfTable[idx++] = iter.next();
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
			Arrays.sort( arrayOfTable, compareTableByQualName );
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

	public ICFBamSchemaDefObj getSwingContainer() {
		return( swingContainer );
	}

	public void setSwingContainer( ICFBamSchemaDefObj value ) {
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

