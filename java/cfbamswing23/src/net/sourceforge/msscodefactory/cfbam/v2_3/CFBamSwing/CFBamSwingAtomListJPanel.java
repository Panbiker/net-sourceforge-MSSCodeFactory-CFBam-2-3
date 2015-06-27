// Description: Java 7 Swing List of Obj JPanel implementation for Atom.

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
 *	CFBamSwingAtomListJPanel Swing List of Obj JPanel implementation
 *	for Atom.
 */
public class CFBamSwingAtomListJPanel
extends CFJPanel
implements ICFBamSwingAtomJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamAtomObj> swingDataCollection = null;
	protected ICFBamAtomObj arrayOfAtom[] = null;
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
	public final static int COLID_LOOKUP_DEFSCHEMA = 12;
	public final static int COLID_LOOKUP_DATASCOPE = 13;
	public final static int COLID_LOOKUP_VACCSEC = 14;
	public final static int COLID_LOOKUP_EACCSEC = 15;
	public final static int COLID_LOOKUP_VACCFREQ = 16;
	public final static int COLID_LOOKUP_EACCFREQ = 17;
	public final static int NUM_COLS = 18;
	protected JTable swingJTable = null;
	protected class ActionAddBlobCol
	extends AbstractAction
	{
		public ActionAddBlobCol() {
			super();
			putValue( Action.NAME, "Add BlobCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamBlobColObj obj = schemaObj.getBlobColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamBlobColEditObj edit = (ICFBamBlobColEditObj)( obj.beginEdit() );
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
			ICFBamSwingBlobColJPanelCommon jpanelCommon = (ICFBamSwingBlobColJPanelCommon)frame;
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

	protected class ActionAddBlobType
	extends AbstractAction
	{
		public ActionAddBlobType() {
			super();
			putValue( Action.NAME, "Add BlobType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamBlobTypeObj obj = schemaObj.getBlobTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamBlobTypeEditObj edit = (ICFBamBlobTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingBlobTypeJPanelCommon jpanelCommon = (ICFBamSwingBlobTypeJPanelCommon)frame;
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

	protected class ActionAddBoolCol
	extends AbstractAction
	{
		public ActionAddBoolCol() {
			super();
			putValue( Action.NAME, "Add BoolCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamBoolColObj obj = schemaObj.getBoolColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamBoolColEditObj edit = (ICFBamBoolColEditObj)( obj.beginEdit() );
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
			ICFBamSwingBoolColJPanelCommon jpanelCommon = (ICFBamSwingBoolColJPanelCommon)frame;
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

	protected class ActionAddBoolType
	extends AbstractAction
	{
		public ActionAddBoolType() {
			super();
			putValue( Action.NAME, "Add BoolType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamBoolTypeObj obj = schemaObj.getBoolTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamBoolTypeEditObj edit = (ICFBamBoolTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingBoolTypeJPanelCommon jpanelCommon = (ICFBamSwingBoolTypeJPanelCommon)frame;
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

	protected class ActionAddInt16Col
	extends AbstractAction
	{
		public ActionAddInt16Col() {
			super();
			putValue( Action.NAME, "Add Int16Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt16ColObj obj = schemaObj.getInt16ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt16ColEditObj edit = (ICFBamInt16ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt16ColJPanelCommon jpanelCommon = (ICFBamSwingInt16ColJPanelCommon)frame;
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

	protected class ActionAddInt16Type
	extends AbstractAction
	{
		public ActionAddInt16Type() {
			super();
			putValue( Action.NAME, "Add Int16Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt16TypeObj obj = schemaObj.getInt16TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt16TypeEditObj edit = (ICFBamInt16TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt16TypeJPanelCommon jpanelCommon = (ICFBamSwingInt16TypeJPanelCommon)frame;
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

	protected class ActionAddId16Gen
	extends AbstractAction
	{
		public ActionAddId16Gen() {
			super();
			putValue( Action.NAME, "Add Id16Gen..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamId16GenObj obj = schemaObj.getId16GenTableObj().newInstance();
			JInternalFrame frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamId16GenEditObj edit = (ICFBamId16GenEditObj)( obj.beginEdit() );
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
			ICFBamSwingId16GenJPanelCommon jpanelCommon = (ICFBamSwingId16GenJPanelCommon)frame;
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

	protected class ActionAddEnumCol
	extends AbstractAction
	{
		public ActionAddEnumCol() {
			super();
			putValue( Action.NAME, "Add EnumCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamEnumColObj obj = schemaObj.getEnumColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamEnumColEditObj edit = (ICFBamEnumColEditObj)( obj.beginEdit() );
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
			ICFBamSwingEnumColJPanelCommon jpanelCommon = (ICFBamSwingEnumColJPanelCommon)frame;
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

	protected class ActionAddEnumType
	extends AbstractAction
	{
		public ActionAddEnumType() {
			super();
			putValue( Action.NAME, "Add EnumType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamEnumTypeObj obj = schemaObj.getEnumTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamEnumTypeEditObj edit = (ICFBamEnumTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingEnumTypeJPanelCommon jpanelCommon = (ICFBamSwingEnumTypeJPanelCommon)frame;
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

	protected class ActionAddInt32Col
	extends AbstractAction
	{
		public ActionAddInt32Col() {
			super();
			putValue( Action.NAME, "Add Int32Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt32ColObj obj = schemaObj.getInt32ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt32ColEditObj edit = (ICFBamInt32ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt32ColJPanelCommon jpanelCommon = (ICFBamSwingInt32ColJPanelCommon)frame;
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

	protected class ActionAddInt32Type
	extends AbstractAction
	{
		public ActionAddInt32Type() {
			super();
			putValue( Action.NAME, "Add Int32Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt32TypeObj obj = schemaObj.getInt32TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt32TypeEditObj edit = (ICFBamInt32TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt32TypeJPanelCommon jpanelCommon = (ICFBamSwingInt32TypeJPanelCommon)frame;
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

	protected class ActionAddId32Gen
	extends AbstractAction
	{
		public ActionAddId32Gen() {
			super();
			putValue( Action.NAME, "Add Id32Gen..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamId32GenObj obj = schemaObj.getId32GenTableObj().newInstance();
			JInternalFrame frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamId32GenEditObj edit = (ICFBamId32GenEditObj)( obj.beginEdit() );
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
			ICFBamSwingId32GenJPanelCommon jpanelCommon = (ICFBamSwingId32GenJPanelCommon)frame;
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

	protected class ActionAddInt64Col
	extends AbstractAction
	{
		public ActionAddInt64Col() {
			super();
			putValue( Action.NAME, "Add Int64Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt64ColObj obj = schemaObj.getInt64ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt64ColEditObj edit = (ICFBamInt64ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt64ColJPanelCommon jpanelCommon = (ICFBamSwingInt64ColJPanelCommon)frame;
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

	protected class ActionAddInt64Type
	extends AbstractAction
	{
		public ActionAddInt64Type() {
			super();
			putValue( Action.NAME, "Add Int64Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamInt64TypeObj obj = schemaObj.getInt64TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamInt64TypeEditObj edit = (ICFBamInt64TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingInt64TypeJPanelCommon jpanelCommon = (ICFBamSwingInt64TypeJPanelCommon)frame;
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

	protected class ActionAddId64Gen
	extends AbstractAction
	{
		public ActionAddId64Gen() {
			super();
			putValue( Action.NAME, "Add Id64Gen..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamId64GenObj obj = schemaObj.getId64GenTableObj().newInstance();
			JInternalFrame frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamId64GenEditObj edit = (ICFBamId64GenEditObj)( obj.beginEdit() );
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
			ICFBamSwingId64GenJPanelCommon jpanelCommon = (ICFBamSwingId64GenJPanelCommon)frame;
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

	protected class ActionAddUInt16Col
	extends AbstractAction
	{
		public ActionAddUInt16Col() {
			super();
			putValue( Action.NAME, "Add UInt16Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt16ColObj obj = schemaObj.getUInt16ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt16ColEditObj edit = (ICFBamUInt16ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt16ColJPanelCommon jpanelCommon = (ICFBamSwingUInt16ColJPanelCommon)frame;
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

	protected class ActionAddUInt16Type
	extends AbstractAction
	{
		public ActionAddUInt16Type() {
			super();
			putValue( Action.NAME, "Add UInt16Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt16TypeObj obj = schemaObj.getUInt16TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt16TypeEditObj edit = (ICFBamUInt16TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt16TypeJPanelCommon jpanelCommon = (ICFBamSwingUInt16TypeJPanelCommon)frame;
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

	protected class ActionAddUInt32Col
	extends AbstractAction
	{
		public ActionAddUInt32Col() {
			super();
			putValue( Action.NAME, "Add UInt32Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt32ColObj obj = schemaObj.getUInt32ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt32ColEditObj edit = (ICFBamUInt32ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt32ColJPanelCommon jpanelCommon = (ICFBamSwingUInt32ColJPanelCommon)frame;
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

	protected class ActionAddUInt32Type
	extends AbstractAction
	{
		public ActionAddUInt32Type() {
			super();
			putValue( Action.NAME, "Add UInt32Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt32TypeObj obj = schemaObj.getUInt32TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt32TypeEditObj edit = (ICFBamUInt32TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt32TypeJPanelCommon jpanelCommon = (ICFBamSwingUInt32TypeJPanelCommon)frame;
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

	protected class ActionAddUInt64Col
	extends AbstractAction
	{
		public ActionAddUInt64Col() {
			super();
			putValue( Action.NAME, "Add UInt64Col..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt64ColObj obj = schemaObj.getUInt64ColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt64ColEditObj edit = (ICFBamUInt64ColEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt64ColJPanelCommon jpanelCommon = (ICFBamSwingUInt64ColJPanelCommon)frame;
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

	protected class ActionAddUInt64Type
	extends AbstractAction
	{
		public ActionAddUInt64Type() {
			super();
			putValue( Action.NAME, "Add UInt64Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUInt64TypeObj obj = schemaObj.getUInt64TypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUInt64TypeEditObj edit = (ICFBamUInt64TypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingUInt64TypeJPanelCommon jpanelCommon = (ICFBamSwingUInt64TypeJPanelCommon)frame;
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

	protected class ActionAddFloatCol
	extends AbstractAction
	{
		public ActionAddFloatCol() {
			super();
			putValue( Action.NAME, "Add FloatCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamFloatColObj obj = schemaObj.getFloatColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamFloatColEditObj edit = (ICFBamFloatColEditObj)( obj.beginEdit() );
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
			ICFBamSwingFloatColJPanelCommon jpanelCommon = (ICFBamSwingFloatColJPanelCommon)frame;
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

	protected class ActionAddFloatType
	extends AbstractAction
	{
		public ActionAddFloatType() {
			super();
			putValue( Action.NAME, "Add FloatType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamFloatTypeObj obj = schemaObj.getFloatTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamFloatTypeEditObj edit = (ICFBamFloatTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingFloatTypeJPanelCommon jpanelCommon = (ICFBamSwingFloatTypeJPanelCommon)frame;
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

	protected class ActionAddDoubleCol
	extends AbstractAction
	{
		public ActionAddDoubleCol() {
			super();
			putValue( Action.NAME, "Add DoubleCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDoubleColObj obj = schemaObj.getDoubleColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDoubleColEditObj edit = (ICFBamDoubleColEditObj)( obj.beginEdit() );
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
			ICFBamSwingDoubleColJPanelCommon jpanelCommon = (ICFBamSwingDoubleColJPanelCommon)frame;
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

	protected class ActionAddDoubleType
	extends AbstractAction
	{
		public ActionAddDoubleType() {
			super();
			putValue( Action.NAME, "Add DoubleType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDoubleTypeObj obj = schemaObj.getDoubleTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDoubleTypeEditObj edit = (ICFBamDoubleTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingDoubleTypeJPanelCommon jpanelCommon = (ICFBamSwingDoubleTypeJPanelCommon)frame;
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

	protected class ActionAddNumberCol
	extends AbstractAction
	{
		public ActionAddNumberCol() {
			super();
			putValue( Action.NAME, "Add NumberCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNumberColObj obj = schemaObj.getNumberColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNumberColEditObj edit = (ICFBamNumberColEditObj)( obj.beginEdit() );
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
			ICFBamSwingNumberColJPanelCommon jpanelCommon = (ICFBamSwingNumberColJPanelCommon)frame;
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

	protected class ActionAddNumberType
	extends AbstractAction
	{
		public ActionAddNumberType() {
			super();
			putValue( Action.NAME, "Add NumberType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNumberTypeObj obj = schemaObj.getNumberTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNumberTypeEditObj edit = (ICFBamNumberTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingNumberTypeJPanelCommon jpanelCommon = (ICFBamSwingNumberTypeJPanelCommon)frame;
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

	protected class ActionAddStringCol
	extends AbstractAction
	{
		public ActionAddStringCol() {
			super();
			putValue( Action.NAME, "Add StringCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamStringColObj obj = schemaObj.getStringColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamStringColEditObj edit = (ICFBamStringColEditObj)( obj.beginEdit() );
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
			ICFBamSwingStringColJPanelCommon jpanelCommon = (ICFBamSwingStringColJPanelCommon)frame;
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

	protected class ActionAddStringType
	extends AbstractAction
	{
		public ActionAddStringType() {
			super();
			putValue( Action.NAME, "Add StringType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamStringTypeObj obj = schemaObj.getStringTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamStringTypeEditObj edit = (ICFBamStringTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingStringTypeJPanelCommon jpanelCommon = (ICFBamSwingStringTypeJPanelCommon)frame;
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

	protected class ActionAddTextCol
	extends AbstractAction
	{
		public ActionAddTextCol() {
			super();
			putValue( Action.NAME, "Add TextCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTextColObj obj = schemaObj.getTextColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTextColEditObj edit = (ICFBamTextColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTextColJPanelCommon jpanelCommon = (ICFBamSwingTextColJPanelCommon)frame;
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

	protected class ActionAddTextType
	extends AbstractAction
	{
		public ActionAddTextType() {
			super();
			putValue( Action.NAME, "Add TextType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTextTypeObj obj = schemaObj.getTextTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTextTypeEditObj edit = (ICFBamTextTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTextTypeJPanelCommon jpanelCommon = (ICFBamSwingTextTypeJPanelCommon)frame;
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

	protected class ActionAddNmTokenCol
	extends AbstractAction
	{
		public ActionAddNmTokenCol() {
			super();
			putValue( Action.NAME, "Add NmTokenCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNmTokenColObj obj = schemaObj.getNmTokenColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNmTokenColEditObj edit = (ICFBamNmTokenColEditObj)( obj.beginEdit() );
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
			ICFBamSwingNmTokenColJPanelCommon jpanelCommon = (ICFBamSwingNmTokenColJPanelCommon)frame;
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

	protected class ActionAddNmTokenType
	extends AbstractAction
	{
		public ActionAddNmTokenType() {
			super();
			putValue( Action.NAME, "Add NmTokenType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNmTokenTypeObj obj = schemaObj.getNmTokenTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNmTokenTypeEditObj edit = (ICFBamNmTokenTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingNmTokenTypeJPanelCommon jpanelCommon = (ICFBamSwingNmTokenTypeJPanelCommon)frame;
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

	protected class ActionAddNmTokensCol
	extends AbstractAction
	{
		public ActionAddNmTokensCol() {
			super();
			putValue( Action.NAME, "Add NmTokensCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNmTokensColObj obj = schemaObj.getNmTokensColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNmTokensColEditObj edit = (ICFBamNmTokensColEditObj)( obj.beginEdit() );
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
			ICFBamSwingNmTokensColJPanelCommon jpanelCommon = (ICFBamSwingNmTokensColJPanelCommon)frame;
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

	protected class ActionAddNmTokensType
	extends AbstractAction
	{
		public ActionAddNmTokensType() {
			super();
			putValue( Action.NAME, "Add NmTokensType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamNmTokensTypeObj obj = schemaObj.getNmTokensTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamNmTokensTypeEditObj edit = (ICFBamNmTokensTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingNmTokensTypeJPanelCommon jpanelCommon = (ICFBamSwingNmTokensTypeJPanelCommon)frame;
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

	protected class ActionAddTokenCol
	extends AbstractAction
	{
		public ActionAddTokenCol() {
			super();
			putValue( Action.NAME, "Add TokenCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTokenColObj obj = schemaObj.getTokenColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTokenColEditObj edit = (ICFBamTokenColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTokenColJPanelCommon jpanelCommon = (ICFBamSwingTokenColJPanelCommon)frame;
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

	protected class ActionAddTokenType
	extends AbstractAction
	{
		public ActionAddTokenType() {
			super();
			putValue( Action.NAME, "Add TokenType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTokenTypeObj obj = schemaObj.getTokenTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTokenTypeEditObj edit = (ICFBamTokenTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTokenTypeJPanelCommon jpanelCommon = (ICFBamSwingTokenTypeJPanelCommon)frame;
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

	protected class ActionAddDateCol
	extends AbstractAction
	{
		public ActionAddDateCol() {
			super();
			putValue( Action.NAME, "Add DateCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDateColObj obj = schemaObj.getDateColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDateColEditObj edit = (ICFBamDateColEditObj)( obj.beginEdit() );
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
			ICFBamSwingDateColJPanelCommon jpanelCommon = (ICFBamSwingDateColJPanelCommon)frame;
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

	protected class ActionAddDateType
	extends AbstractAction
	{
		public ActionAddDateType() {
			super();
			putValue( Action.NAME, "Add DateType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDateTypeObj obj = schemaObj.getDateTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDateTypeEditObj edit = (ICFBamDateTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingDateTypeJPanelCommon jpanelCommon = (ICFBamSwingDateTypeJPanelCommon)frame;
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

	protected class ActionAddTimeCol
	extends AbstractAction
	{
		public ActionAddTimeCol() {
			super();
			putValue( Action.NAME, "Add TimeCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj obj = schemaObj.getTimeColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTimeColEditObj edit = (ICFBamTimeColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTimeColJPanelCommon jpanelCommon = (ICFBamSwingTimeColJPanelCommon)frame;
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

	protected class ActionAddTimeType
	extends AbstractAction
	{
		public ActionAddTimeType() {
			super();
			putValue( Action.NAME, "Add TimeType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeTypeObj obj = schemaObj.getTimeTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTimeTypeEditObj edit = (ICFBamTimeTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTimeTypeJPanelCommon jpanelCommon = (ICFBamSwingTimeTypeJPanelCommon)frame;
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

	protected class ActionAddTimestampCol
	extends AbstractAction
	{
		public ActionAddTimestampCol() {
			super();
			putValue( Action.NAME, "Add TimestampCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimestampColObj obj = schemaObj.getTimestampColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTimestampColEditObj edit = (ICFBamTimestampColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTimestampColJPanelCommon jpanelCommon = (ICFBamSwingTimestampColJPanelCommon)frame;
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

	protected class ActionAddTimestampType
	extends AbstractAction
	{
		public ActionAddTimestampType() {
			super();
			putValue( Action.NAME, "Add TimestampType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimestampTypeObj obj = schemaObj.getTimestampTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTimestampTypeEditObj edit = (ICFBamTimestampTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTimestampTypeJPanelCommon jpanelCommon = (ICFBamSwingTimestampTypeJPanelCommon)frame;
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

	protected class ActionAddTZTimeCol
	extends AbstractAction
	{
		public ActionAddTZTimeCol() {
			super();
			putValue( Action.NAME, "Add TZTimeCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZTimeColObj obj = schemaObj.getTZTimeColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZTimeColEditObj edit = (ICFBamTZTimeColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTZTimeColJPanelCommon jpanelCommon = (ICFBamSwingTZTimeColJPanelCommon)frame;
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

	protected class ActionAddTZTimeType
	extends AbstractAction
	{
		public ActionAddTZTimeType() {
			super();
			putValue( Action.NAME, "Add TZTimeType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZTimeTypeObj obj = schemaObj.getTZTimeTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZTimeTypeEditObj edit = (ICFBamTZTimeTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTZTimeTypeJPanelCommon jpanelCommon = (ICFBamSwingTZTimeTypeJPanelCommon)frame;
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

	protected class ActionAddTZTimestampCol
	extends AbstractAction
	{
		public ActionAddTZTimestampCol() {
			super();
			putValue( Action.NAME, "Add TZTimestampCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZTimestampColObj obj = schemaObj.getTZTimestampColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZTimestampColEditObj edit = (ICFBamTZTimestampColEditObj)( obj.beginEdit() );
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
			ICFBamSwingTZTimestampColJPanelCommon jpanelCommon = (ICFBamSwingTZTimestampColJPanelCommon)frame;
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

	protected class ActionAddTZTimestampType
	extends AbstractAction
	{
		public ActionAddTZTimestampType() {
			super();
			putValue( Action.NAME, "Add TZTimestampType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTZTimestampTypeObj obj = schemaObj.getTZTimestampTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTZTimestampTypeEditObj edit = (ICFBamTZTimestampTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingTZTimestampTypeJPanelCommon jpanelCommon = (ICFBamSwingTZTimestampTypeJPanelCommon)frame;
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

	protected class ActionAddUuidCol
	extends AbstractAction
	{
		public ActionAddUuidCol() {
			super();
			putValue( Action.NAME, "Add UuidCol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUuidColObj obj = schemaObj.getUuidColTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUuidColEditObj edit = (ICFBamUuidColEditObj)( obj.beginEdit() );
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
			ICFBamSwingUuidColJPanelCommon jpanelCommon = (ICFBamSwingUuidColJPanelCommon)frame;
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

	protected class ActionAddUuidType
	extends AbstractAction
	{
		public ActionAddUuidType() {
			super();
			putValue( Action.NAME, "Add UuidType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUuidTypeObj obj = schemaObj.getUuidTypeTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUuidTypeEditObj edit = (ICFBamUuidTypeEditObj)( obj.beginEdit() );
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
			ICFBamSwingUuidTypeJPanelCommon jpanelCommon = (ICFBamSwingUuidTypeJPanelCommon)frame;
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

	protected class ActionAddUuidGen
	extends AbstractAction
	{
		public ActionAddUuidGen() {
			super();
			putValue( Action.NAME, "Add UuidGen..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamUuidGenObj obj = schemaObj.getUuidGenTableObj().newInstance();
			JInternalFrame frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamUuidGenEditObj edit = (ICFBamUuidGenEditObj)( obj.beginEdit() );
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
			ICFBamSwingUuidGenJPanelCommon jpanelCommon = (ICFBamSwingUuidGenJPanelCommon)frame;
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

	protected class ViewSelectedActionAtom
	extends AbstractAction
	{
		public ViewSelectedActionAtom() {
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
			ICFBamAtomObj selectedInstance = getSwingFocusAsAtom();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "ATOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getAtomFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingAtomJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBD".equals( classCode ) ) {
					ICFBamBlobDefObj obj = (ICFBamBlobDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBC".equals( classCode ) ) {
					ICFBamBlobColObj obj = (ICFBamBlobColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBT".equals( classCode ) ) {
					ICFBamBlobTypeObj obj = (ICFBamBlobTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLD".equals( classCode ) ) {
					ICFBamBoolDefObj obj = (ICFBamBoolDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLC".equals( classCode ) ) {
					ICFBamBoolColObj obj = (ICFBamBoolColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLT".equals( classCode ) ) {
					ICFBamBoolTypeObj obj = (ICFBamBoolTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16D".equals( classCode ) ) {
					ICFBamInt16DefObj obj = (ICFBamInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16C".equals( classCode ) ) {
					ICFBamInt16ColObj obj = (ICFBamInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16T".equals( classCode ) ) {
					ICFBamInt16TypeObj obj = (ICFBamInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG16".equals( classCode ) ) {
					ICFBamId16GenObj obj = (ICFBamId16GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId16GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMD".equals( classCode ) ) {
					ICFBamEnumDefObj obj = (ICFBamEnumDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMC".equals( classCode ) ) {
					ICFBamEnumColObj obj = (ICFBamEnumColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMT".equals( classCode ) ) {
					ICFBamEnumTypeObj obj = (ICFBamEnumTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32D".equals( classCode ) ) {
					ICFBamInt32DefObj obj = (ICFBamInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32C".equals( classCode ) ) {
					ICFBamInt32ColObj obj = (ICFBamInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32T".equals( classCode ) ) {
					ICFBamInt32TypeObj obj = (ICFBamInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG32".equals( classCode ) ) {
					ICFBamId32GenObj obj = (ICFBamId32GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId32GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64D".equals( classCode ) ) {
					ICFBamInt64DefObj obj = (ICFBamInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64C".equals( classCode ) ) {
					ICFBamInt64ColObj obj = (ICFBamInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64T".equals( classCode ) ) {
					ICFBamInt64TypeObj obj = (ICFBamInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG64".equals( classCode ) ) {
					ICFBamId64GenObj obj = (ICFBamId64GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId64GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16D".equals( classCode ) ) {
					ICFBamUInt16DefObj obj = (ICFBamUInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16C".equals( classCode ) ) {
					ICFBamUInt16ColObj obj = (ICFBamUInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16T".equals( classCode ) ) {
					ICFBamUInt16TypeObj obj = (ICFBamUInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32D".equals( classCode ) ) {
					ICFBamUInt32DefObj obj = (ICFBamUInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32C".equals( classCode ) ) {
					ICFBamUInt32ColObj obj = (ICFBamUInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32T".equals( classCode ) ) {
					ICFBamUInt32TypeObj obj = (ICFBamUInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64D".equals( classCode ) ) {
					ICFBamUInt64DefObj obj = (ICFBamUInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64C".equals( classCode ) ) {
					ICFBamUInt64ColObj obj = (ICFBamUInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64T".equals( classCode ) ) {
					ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTD".equals( classCode ) ) {
					ICFBamFloatDefObj obj = (ICFBamFloatDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTC".equals( classCode ) ) {
					ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTT".equals( classCode ) ) {
					ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLD".equals( classCode ) ) {
					ICFBamDoubleDefObj obj = (ICFBamDoubleDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLC".equals( classCode ) ) {
					ICFBamDoubleColObj obj = (ICFBamDoubleColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLT".equals( classCode ) ) {
					ICFBamDoubleTypeObj obj = (ICFBamDoubleTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMD".equals( classCode ) ) {
					ICFBamNumberDefObj obj = (ICFBamNumberDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMC".equals( classCode ) ) {
					ICFBamNumberColObj obj = (ICFBamNumberColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMT".equals( classCode ) ) {
					ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRD".equals( classCode ) ) {
					ICFBamStringDefObj obj = (ICFBamStringDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRC".equals( classCode ) ) {
					ICFBamStringColObj obj = (ICFBamStringColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRT".equals( classCode ) ) {
					ICFBamStringTypeObj obj = (ICFBamStringTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTD".equals( classCode ) ) {
					ICFBamTextDefObj obj = (ICFBamTextDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTC".equals( classCode ) ) {
					ICFBamTextColObj obj = (ICFBamTextColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTT".equals( classCode ) ) {
					ICFBamTextTypeObj obj = (ICFBamTextTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKD".equals( classCode ) ) {
					ICFBamNmTokenDefObj obj = (ICFBamNmTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKC".equals( classCode ) ) {
					ICFBamNmTokenColObj obj = (ICFBamNmTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKT".equals( classCode ) ) {
					ICFBamNmTokenTypeObj obj = (ICFBamNmTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTSD".equals( classCode ) ) {
					ICFBamNmTokensDefObj obj = (ICFBamNmTokensDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTSC".equals( classCode ) ) {
					ICFBamNmTokensColObj obj = (ICFBamNmTokensColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTST".equals( classCode ) ) {
					ICFBamNmTokensTypeObj obj = (ICFBamNmTokensTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKND".equals( classCode ) ) {
					ICFBamTokenDefObj obj = (ICFBamTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKNC".equals( classCode ) ) {
					ICFBamTokenColObj obj = (ICFBamTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKNT".equals( classCode ) ) {
					ICFBamTokenTypeObj obj = (ICFBamTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATD".equals( classCode ) ) {
					ICFBamDateDefObj obj = (ICFBamDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATC".equals( classCode ) ) {
					ICFBamDateColObj obj = (ICFBamDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATT".equals( classCode ) ) {
					ICFBamDateTypeObj obj = (ICFBamDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMD".equals( classCode ) ) {
					ICFBamTimeDefObj obj = (ICFBamTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMC".equals( classCode ) ) {
					ICFBamTimeColObj obj = (ICFBamTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMT".equals( classCode ) ) {
					ICFBamTimeTypeObj obj = (ICFBamTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPD".equals( classCode ) ) {
					ICFBamTimestampDefObj obj = (ICFBamTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPC".equals( classCode ) ) {
					ICFBamTimestampColObj obj = (ICFBamTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPT".equals( classCode ) ) {
					ICFBamTimestampTypeObj obj = (ICFBamTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZD".equals( classCode ) ) {
					ICFBamTZDateDefObj obj = (ICFBamTZDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( obj );
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
				else if( "TMZD".equals( classCode ) ) {
					ICFBamTZTimeDefObj obj = (ICFBamTZTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TMZC".equals( classCode ) ) {
					ICFBamTZTimeColObj obj = (ICFBamTZTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TMZT".equals( classCode ) ) {
					ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTD".equals( classCode ) ) {
					ICFBamTZTimestampDefObj obj = (ICFBamTZTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTC".equals( classCode ) ) {
					ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTT".equals( classCode ) ) {
					ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDD".equals( classCode ) ) {
					ICFBamUuidDefObj obj = (ICFBamUuidDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDC".equals( classCode ) ) {
					ICFBamUuidColObj obj = (ICFBamUuidColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDT".equals( classCode ) ) {
					ICFBamUuidTypeObj obj = (ICFBamUuidTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IGUU".equals( classCode ) ) {
					ICFBamUuidGenObj obj = (ICFBamUuidGenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidGenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamAtomObj, ICFBamBlobDefObj, ICFBamBlobColObj, ICFBamBlobTypeObj, ICFBamBoolDefObj, ICFBamBoolColObj, ICFBamBoolTypeObj, ICFBamInt16DefObj, ICFBamInt16ColObj, ICFBamInt16TypeObj, ICFBamId16GenObj, ICFBamEnumDefObj, ICFBamEnumColObj, ICFBamEnumTypeObj, ICFBamInt32DefObj, ICFBamInt32ColObj, ICFBamInt32TypeObj, ICFBamId32GenObj, ICFBamInt64DefObj, ICFBamInt64ColObj, ICFBamInt64TypeObj, ICFBamId64GenObj, ICFBamUInt16DefObj, ICFBamUInt16ColObj, ICFBamUInt16TypeObj, ICFBamUInt32DefObj, ICFBamUInt32ColObj, ICFBamUInt32TypeObj, ICFBamUInt64DefObj, ICFBamUInt64ColObj, ICFBamUInt64TypeObj, ICFBamFloatDefObj, ICFBamFloatColObj, ICFBamFloatTypeObj, ICFBamDoubleDefObj, ICFBamDoubleColObj, ICFBamDoubleTypeObj, ICFBamNumberDefObj, ICFBamNumberColObj, ICFBamNumberTypeObj, ICFBamStringDefObj, ICFBamStringColObj, ICFBamStringTypeObj, ICFBamTextDefObj, ICFBamTextColObj, ICFBamTextTypeObj, ICFBamNmTokenDefObj, ICFBamNmTokenColObj, ICFBamNmTokenTypeObj, ICFBamNmTokensDefObj, ICFBamNmTokensColObj, ICFBamNmTokensTypeObj, ICFBamTokenDefObj, ICFBamTokenColObj, ICFBamTokenTypeObj, ICFBamDateDefObj, ICFBamDateColObj, ICFBamDateTypeObj, ICFBamTimeDefObj, ICFBamTimeColObj, ICFBamTimeTypeObj, ICFBamTimestampDefObj, ICFBamTimestampColObj, ICFBamTimestampTypeObj, ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj, ICFBamTZTimeDefObj, ICFBamTZTimeColObj, ICFBamTZTimeTypeObj, ICFBamTZTimestampDefObj, ICFBamTZTimestampColObj, ICFBamTZTimestampTypeObj, ICFBamUuidDefObj, ICFBamUuidColObj, ICFBamUuidTypeObj, ICFBamUuidGenObj" );
				}
			}
		}
	}

	protected class EditSelectedActionAtom
	extends AbstractAction
	{
		public EditSelectedActionAtom() {
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
			ICFBamAtomObj selectedInstance = getSwingFocusAsAtom();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "ATOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getAtomFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingAtomJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "BLBD".equals( classCode ) ) {
					ICFBamBlobDefObj obj = (ICFBamBlobDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "BLBC".equals( classCode ) ) {
					ICFBamBlobColObj obj = (ICFBamBlobColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBT".equals( classCode ) ) {
					ICFBamBlobTypeObj obj = (ICFBamBlobTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBlobTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLD".equals( classCode ) ) {
					ICFBamBoolDefObj obj = (ICFBamBoolDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "BOLC".equals( classCode ) ) {
					ICFBamBoolColObj obj = (ICFBamBoolColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLT".equals( classCode ) ) {
					ICFBamBoolTypeObj obj = (ICFBamBoolTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingBoolTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16D".equals( classCode ) ) {
					ICFBamInt16DefObj obj = (ICFBamInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "I16C".equals( classCode ) ) {
					ICFBamInt16ColObj obj = (ICFBamInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16T".equals( classCode ) ) {
					ICFBamInt16TypeObj obj = (ICFBamInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG16".equals( classCode ) ) {
					ICFBamId16GenObj obj = (ICFBamId16GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId16GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMD".equals( classCode ) ) {
					ICFBamEnumDefObj obj = (ICFBamEnumDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMC".equals( classCode ) ) {
					ICFBamEnumColObj obj = (ICFBamEnumColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMT".equals( classCode ) ) {
					ICFBamEnumTypeObj obj = (ICFBamEnumTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingEnumTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32D".equals( classCode ) ) {
					ICFBamInt32DefObj obj = (ICFBamInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "I32C".equals( classCode ) ) {
					ICFBamInt32ColObj obj = (ICFBamInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32T".equals( classCode ) ) {
					ICFBamInt32TypeObj obj = (ICFBamInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG32".equals( classCode ) ) {
					ICFBamId32GenObj obj = (ICFBamId32GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId32GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64D".equals( classCode ) ) {
					ICFBamInt64DefObj obj = (ICFBamInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "I64C".equals( classCode ) ) {
					ICFBamInt64ColObj obj = (ICFBamInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64T".equals( classCode ) ) {
					ICFBamInt64TypeObj obj = (ICFBamInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG64".equals( classCode ) ) {
					ICFBamId64GenObj obj = (ICFBamId64GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingId64GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16D".equals( classCode ) ) {
					ICFBamUInt16DefObj obj = (ICFBamUInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "U16C".equals( classCode ) ) {
					ICFBamUInt16ColObj obj = (ICFBamUInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16T".equals( classCode ) ) {
					ICFBamUInt16TypeObj obj = (ICFBamUInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32D".equals( classCode ) ) {
					ICFBamUInt32DefObj obj = (ICFBamUInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "U32C".equals( classCode ) ) {
					ICFBamUInt32ColObj obj = (ICFBamUInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32T".equals( classCode ) ) {
					ICFBamUInt32TypeObj obj = (ICFBamUInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64D".equals( classCode ) ) {
					ICFBamUInt64DefObj obj = (ICFBamUInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64DefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "U64C".equals( classCode ) ) {
					ICFBamUInt64ColObj obj = (ICFBamUInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64T".equals( classCode ) ) {
					ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTD".equals( classCode ) ) {
					ICFBamFloatDefObj obj = (ICFBamFloatDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "FLTC".equals( classCode ) ) {
					ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTT".equals( classCode ) ) {
					ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingFloatTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLD".equals( classCode ) ) {
					ICFBamDoubleDefObj obj = (ICFBamDoubleDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "DBLC".equals( classCode ) ) {
					ICFBamDoubleColObj obj = (ICFBamDoubleColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLT".equals( classCode ) ) {
					ICFBamDoubleTypeObj obj = (ICFBamDoubleTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDoubleTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMD".equals( classCode ) ) {
					ICFBamNumberDefObj obj = (ICFBamNumberDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "NUMC".equals( classCode ) ) {
					ICFBamNumberColObj obj = (ICFBamNumberColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMT".equals( classCode ) ) {
					ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNumberTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRD".equals( classCode ) ) {
					ICFBamStringDefObj obj = (ICFBamStringDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "STRC".equals( classCode ) ) {
					ICFBamStringColObj obj = (ICFBamStringColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRT".equals( classCode ) ) {
					ICFBamStringTypeObj obj = (ICFBamStringTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingStringTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTD".equals( classCode ) ) {
					ICFBamTextDefObj obj = (ICFBamTextDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "TXTC".equals( classCode ) ) {
					ICFBamTextColObj obj = (ICFBamTextColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTT".equals( classCode ) ) {
					ICFBamTextTypeObj obj = (ICFBamTextTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTextTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKD".equals( classCode ) ) {
					ICFBamNmTokenDefObj obj = (ICFBamNmTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "NTKC".equals( classCode ) ) {
					ICFBamNmTokenColObj obj = (ICFBamNmTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKT".equals( classCode ) ) {
					ICFBamNmTokenTypeObj obj = (ICFBamNmTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTSD".equals( classCode ) ) {
					ICFBamNmTokensDefObj obj = (ICFBamNmTokensDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "NTSC".equals( classCode ) ) {
					ICFBamNmTokensColObj obj = (ICFBamNmTokensColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTST".equals( classCode ) ) {
					ICFBamNmTokensTypeObj obj = (ICFBamNmTokensTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingNmTokensTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKND".equals( classCode ) ) {
					ICFBamTokenDefObj obj = (ICFBamTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "TKNC".equals( classCode ) ) {
					ICFBamTokenColObj obj = (ICFBamTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKNT".equals( classCode ) ) {
					ICFBamTokenTypeObj obj = (ICFBamTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATD".equals( classCode ) ) {
					ICFBamDateDefObj obj = (ICFBamDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "DATC".equals( classCode ) ) {
					ICFBamDateColObj obj = (ICFBamDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATT".equals( classCode ) ) {
					ICFBamDateTypeObj obj = (ICFBamDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMD".equals( classCode ) ) {
					ICFBamTimeDefObj obj = (ICFBamTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "TIMC".equals( classCode ) ) {
					ICFBamTimeColObj obj = (ICFBamTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMT".equals( classCode ) ) {
					ICFBamTimeTypeObj obj = (ICFBamTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPD".equals( classCode ) ) {
					ICFBamTimestampDefObj obj = (ICFBamTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "TSPC".equals( classCode ) ) {
					ICFBamTimestampColObj obj = (ICFBamTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPT".equals( classCode ) ) {
					ICFBamTimestampTypeObj obj = (ICFBamTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZD".equals( classCode ) ) {
					ICFBamTZDateDefObj obj = (ICFBamTZDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( obj );
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
				else if( "TMZD".equals( classCode ) ) {
					ICFBamTZTimeDefObj obj = (ICFBamTZTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "TMZC".equals( classCode ) ) {
					ICFBamTZTimeColObj obj = (ICFBamTZTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TMZT".equals( classCode ) ) {
					ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTD".equals( classCode ) ) {
					ICFBamTZTimestampDefObj obj = (ICFBamTZTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "ZSTC".equals( classCode ) ) {
					ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTT".equals( classCode ) ) {
					ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTZTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDD".equals( classCode ) ) {
					ICFBamUuidDefObj obj = (ICFBamUuidDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidDefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
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
				else if( "UIDC".equals( classCode ) ) {
					ICFBamUuidColObj obj = (ICFBamUuidColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDT".equals( classCode ) ) {
					ICFBamUuidTypeObj obj = (ICFBamUuidTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IGUU".equals( classCode ) ) {
					ICFBamUuidGenObj obj = (ICFBamUuidGenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingUuidGenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamAtomObj, ICFBamBlobDefObj, ICFBamBlobColObj, ICFBamBlobTypeObj, ICFBamBoolDefObj, ICFBamBoolColObj, ICFBamBoolTypeObj, ICFBamInt16DefObj, ICFBamInt16ColObj, ICFBamInt16TypeObj, ICFBamId16GenObj, ICFBamEnumDefObj, ICFBamEnumColObj, ICFBamEnumTypeObj, ICFBamInt32DefObj, ICFBamInt32ColObj, ICFBamInt32TypeObj, ICFBamId32GenObj, ICFBamInt64DefObj, ICFBamInt64ColObj, ICFBamInt64TypeObj, ICFBamId64GenObj, ICFBamUInt16DefObj, ICFBamUInt16ColObj, ICFBamUInt16TypeObj, ICFBamUInt32DefObj, ICFBamUInt32ColObj, ICFBamUInt32TypeObj, ICFBamUInt64DefObj, ICFBamUInt64ColObj, ICFBamUInt64TypeObj, ICFBamFloatDefObj, ICFBamFloatColObj, ICFBamFloatTypeObj, ICFBamDoubleDefObj, ICFBamDoubleColObj, ICFBamDoubleTypeObj, ICFBamNumberDefObj, ICFBamNumberColObj, ICFBamNumberTypeObj, ICFBamStringDefObj, ICFBamStringColObj, ICFBamStringTypeObj, ICFBamTextDefObj, ICFBamTextColObj, ICFBamTextTypeObj, ICFBamNmTokenDefObj, ICFBamNmTokenColObj, ICFBamNmTokenTypeObj, ICFBamNmTokensDefObj, ICFBamNmTokensColObj, ICFBamNmTokensTypeObj, ICFBamTokenDefObj, ICFBamTokenColObj, ICFBamTokenTypeObj, ICFBamDateDefObj, ICFBamDateColObj, ICFBamDateTypeObj, ICFBamTimeDefObj, ICFBamTimeColObj, ICFBamTimeTypeObj, ICFBamTimestampDefObj, ICFBamTimestampColObj, ICFBamTimestampTypeObj, ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj, ICFBamTZTimeDefObj, ICFBamTZTimeColObj, ICFBamTZTimeTypeObj, ICFBamTZTimestampDefObj, ICFBamTZTimestampColObj, ICFBamTZTimestampTypeObj, ICFBamUuidDefObj, ICFBamUuidColObj, ICFBamUuidTypeObj, ICFBamUuidGenObj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionAtom
	extends AbstractAction
	{
		public DeleteSelectedActionAtom() {
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
			ICFBamAtomObj selectedInstance = getSwingFocusAsAtom();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "ATOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getAtomFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingAtomJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBD".equals( classCode ) ) {
					ICFBamBlobDefObj obj = (ICFBamBlobDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBlobDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBC".equals( classCode ) ) {
					ICFBamBlobColObj obj = (ICFBamBlobColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBlobColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BLBT".equals( classCode ) ) {
					ICFBamBlobTypeObj obj = (ICFBamBlobTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBlobTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBlobTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLD".equals( classCode ) ) {
					ICFBamBoolDefObj obj = (ICFBamBoolDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBoolDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLC".equals( classCode ) ) {
					ICFBamBoolColObj obj = (ICFBamBoolColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBoolColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BOLT".equals( classCode ) ) {
					ICFBamBoolTypeObj obj = (ICFBamBoolTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getBoolTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingBoolTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16D".equals( classCode ) ) {
					ICFBamInt16DefObj obj = (ICFBamInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16C".equals( classCode ) ) {
					ICFBamInt16ColObj obj = (ICFBamInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I16T".equals( classCode ) ) {
					ICFBamInt16TypeObj obj = (ICFBamInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt16TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG16".equals( classCode ) ) {
					ICFBamId16GenObj obj = (ICFBamId16GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId16GenFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingId16GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMD".equals( classCode ) ) {
					ICFBamEnumDefObj obj = (ICFBamEnumDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingEnumDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMC".equals( classCode ) ) {
					ICFBamEnumColObj obj = (ICFBamEnumColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingEnumColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ENMT".equals( classCode ) ) {
					ICFBamEnumTypeObj obj = (ICFBamEnumTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getEnumTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingEnumTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32D".equals( classCode ) ) {
					ICFBamInt32DefObj obj = (ICFBamInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32C".equals( classCode ) ) {
					ICFBamInt32ColObj obj = (ICFBamInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I32T".equals( classCode ) ) {
					ICFBamInt32TypeObj obj = (ICFBamInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt32TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG32".equals( classCode ) ) {
					ICFBamId32GenObj obj = (ICFBamId32GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId32GenFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingId32GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64D".equals( classCode ) ) {
					ICFBamInt64DefObj obj = (ICFBamInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64C".equals( classCode ) ) {
					ICFBamInt64ColObj obj = (ICFBamInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "I64T".equals( classCode ) ) {
					ICFBamInt64TypeObj obj = (ICFBamInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getInt64TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IG64".equals( classCode ) ) {
					ICFBamId64GenObj obj = (ICFBamId64GenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getId64GenFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingId64GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16D".equals( classCode ) ) {
					ICFBamUInt16DefObj obj = (ICFBamUInt16DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16C".equals( classCode ) ) {
					ICFBamUInt16ColObj obj = (ICFBamUInt16ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U16T".equals( classCode ) ) {
					ICFBamUInt16TypeObj obj = (ICFBamUInt16TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt16TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32D".equals( classCode ) ) {
					ICFBamUInt32DefObj obj = (ICFBamUInt32DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32C".equals( classCode ) ) {
					ICFBamUInt32ColObj obj = (ICFBamUInt32ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U32T".equals( classCode ) ) {
					ICFBamUInt32TypeObj obj = (ICFBamUInt32TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt32TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64D".equals( classCode ) ) {
					ICFBamUInt64DefObj obj = (ICFBamUInt64DefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64DefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64C".equals( classCode ) ) {
					ICFBamUInt64ColObj obj = (ICFBamUInt64ColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64ColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "U64T".equals( classCode ) ) {
					ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUInt64TypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTD".equals( classCode ) ) {
					ICFBamFloatDefObj obj = (ICFBamFloatDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingFloatDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTC".equals( classCode ) ) {
					ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingFloatColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "FLTT".equals( classCode ) ) {
					ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getFloatTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingFloatTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLD".equals( classCode ) ) {
					ICFBamDoubleDefObj obj = (ICFBamDoubleDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDoubleDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLC".equals( classCode ) ) {
					ICFBamDoubleColObj obj = (ICFBamDoubleColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDoubleColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DBLT".equals( classCode ) ) {
					ICFBamDoubleTypeObj obj = (ICFBamDoubleTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDoubleTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDoubleTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMD".equals( classCode ) ) {
					ICFBamNumberDefObj obj = (ICFBamNumberDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNumberDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMC".equals( classCode ) ) {
					ICFBamNumberColObj obj = (ICFBamNumberColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNumberColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NUMT".equals( classCode ) ) {
					ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNumberTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNumberTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRD".equals( classCode ) ) {
					ICFBamStringDefObj obj = (ICFBamStringDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingStringDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRC".equals( classCode ) ) {
					ICFBamStringColObj obj = (ICFBamStringColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingStringColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "STRT".equals( classCode ) ) {
					ICFBamStringTypeObj obj = (ICFBamStringTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getStringTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingStringTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTD".equals( classCode ) ) {
					ICFBamTextDefObj obj = (ICFBamTextDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTextDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTC".equals( classCode ) ) {
					ICFBamTextColObj obj = (ICFBamTextColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTextColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TXTT".equals( classCode ) ) {
					ICFBamTextTypeObj obj = (ICFBamTextTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTextTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTextTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKD".equals( classCode ) ) {
					ICFBamNmTokenDefObj obj = (ICFBamNmTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKC".equals( classCode ) ) {
					ICFBamNmTokenColObj obj = (ICFBamNmTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTKT".equals( classCode ) ) {
					ICFBamNmTokenTypeObj obj = (ICFBamNmTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokenTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTSD".equals( classCode ) ) {
					ICFBamNmTokensDefObj obj = (ICFBamNmTokensDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokensDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTSC".equals( classCode ) ) {
					ICFBamNmTokensColObj obj = (ICFBamNmTokensColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokensColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "NTST".equals( classCode ) ) {
					ICFBamNmTokensTypeObj obj = (ICFBamNmTokensTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getNmTokensTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingNmTokensTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKND".equals( classCode ) ) {
					ICFBamTokenDefObj obj = (ICFBamTokenDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKNC".equals( classCode ) ) {
					ICFBamTokenColObj obj = (ICFBamTokenColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TKNT".equals( classCode ) ) {
					ICFBamTokenTypeObj obj = (ICFBamTokenTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTokenTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATD".equals( classCode ) ) {
					ICFBamDateDefObj obj = (ICFBamDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATC".equals( classCode ) ) {
					ICFBamDateColObj obj = (ICFBamDateColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DATT".equals( classCode ) ) {
					ICFBamDateTypeObj obj = (ICFBamDateTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDateTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMD".equals( classCode ) ) {
					ICFBamTimeDefObj obj = (ICFBamTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMC".equals( classCode ) ) {
					ICFBamTimeColObj obj = (ICFBamTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TIMT".equals( classCode ) ) {
					ICFBamTimeTypeObj obj = (ICFBamTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimeTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPD".equals( classCode ) ) {
					ICFBamTimestampDefObj obj = (ICFBamTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPC".equals( classCode ) ) {
					ICFBamTimestampColObj obj = (ICFBamTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TSPT".equals( classCode ) ) {
					ICFBamTimestampTypeObj obj = (ICFBamTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTimestampTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DAZD".equals( classCode ) ) {
					ICFBamTZDateDefObj obj = (ICFBamTZDateDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZDateDefFactory().newAskDeleteJInternalFrame( obj );
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
				else if( "TMZD".equals( classCode ) ) {
					ICFBamTZTimeDefObj obj = (ICFBamTZTimeDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TMZC".equals( classCode ) ) {
					ICFBamTZTimeColObj obj = (ICFBamTZTimeColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TMZT".equals( classCode ) ) {
					ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimeTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTD".equals( classCode ) ) {
					ICFBamTZTimestampDefObj obj = (ICFBamTZTimestampDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTC".equals( classCode ) ) {
					ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "ZSTT".equals( classCode ) ) {
					ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTZTimestampTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTZTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDD".equals( classCode ) ) {
					ICFBamUuidDefObj obj = (ICFBamUuidDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidDefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUuidDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDC".equals( classCode ) ) {
					ICFBamUuidColObj obj = (ICFBamUuidColObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidColFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUuidColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "UIDT".equals( classCode ) ) {
					ICFBamUuidTypeObj obj = (ICFBamUuidTypeObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidTypeFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUuidTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IGUU".equals( classCode ) ) {
					ICFBamUuidGenObj obj = (ICFBamUuidGenObj)selectedInstance;
					JInternalFrame frame = swingSchema.getUuidGenFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingUuidGenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamAtomObj, ICFBamBlobDefObj, ICFBamBlobColObj, ICFBamBlobTypeObj, ICFBamBoolDefObj, ICFBamBoolColObj, ICFBamBoolTypeObj, ICFBamInt16DefObj, ICFBamInt16ColObj, ICFBamInt16TypeObj, ICFBamId16GenObj, ICFBamEnumDefObj, ICFBamEnumColObj, ICFBamEnumTypeObj, ICFBamInt32DefObj, ICFBamInt32ColObj, ICFBamInt32TypeObj, ICFBamId32GenObj, ICFBamInt64DefObj, ICFBamInt64ColObj, ICFBamInt64TypeObj, ICFBamId64GenObj, ICFBamUInt16DefObj, ICFBamUInt16ColObj, ICFBamUInt16TypeObj, ICFBamUInt32DefObj, ICFBamUInt32ColObj, ICFBamUInt32TypeObj, ICFBamUInt64DefObj, ICFBamUInt64ColObj, ICFBamUInt64TypeObj, ICFBamFloatDefObj, ICFBamFloatColObj, ICFBamFloatTypeObj, ICFBamDoubleDefObj, ICFBamDoubleColObj, ICFBamDoubleTypeObj, ICFBamNumberDefObj, ICFBamNumberColObj, ICFBamNumberTypeObj, ICFBamStringDefObj, ICFBamStringColObj, ICFBamStringTypeObj, ICFBamTextDefObj, ICFBamTextColObj, ICFBamTextTypeObj, ICFBamNmTokenDefObj, ICFBamNmTokenColObj, ICFBamNmTokenTypeObj, ICFBamNmTokensDefObj, ICFBamNmTokensColObj, ICFBamNmTokensTypeObj, ICFBamTokenDefObj, ICFBamTokenColObj, ICFBamTokenTypeObj, ICFBamDateDefObj, ICFBamDateColObj, ICFBamDateTypeObj, ICFBamTimeDefObj, ICFBamTimeColObj, ICFBamTimeTypeObj, ICFBamTimestampDefObj, ICFBamTimestampColObj, ICFBamTimestampTypeObj, ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj, ICFBamTZTimeDefObj, ICFBamTZTimeColObj, ICFBamTZTimeTypeObj, ICFBamTZTimestampDefObj, ICFBamTZTimestampColObj, ICFBamTZTimestampTypeObj, ICFBamUuidDefObj, ICFBamUuidColObj, ICFBamUuidTypeObj, ICFBamUuidGenObj" );
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
			if( arrayOfAtom != null ) {
				retval = arrayOfAtom.length;
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
					retval = "Atom";
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
			if( arrayOfAtom == null ) {
				return( null );
			}
			int len = arrayOfAtom.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamAtomObj obj = arrayOfAtom[row];
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
					if( classCode.equals( "ATOM" ) ) {
						retval = "Atom";
					}
					else if( classCode.equals( "BLBD" ) ) {
						retval = "BlobDef";
					}
					else if( classCode.equals( "BLBC" ) ) {
						retval = "BlobCol";
					}
					else if( classCode.equals( "BLBT" ) ) {
						retval = "BlobType";
					}
					else if( classCode.equals( "BOLD" ) ) {
						retval = "BoolDef";
					}
					else if( classCode.equals( "BOLC" ) ) {
						retval = "BoolCol";
					}
					else if( classCode.equals( "BOLT" ) ) {
						retval = "BoolType";
					}
					else if( classCode.equals( "I16D" ) ) {
						retval = "Int16Def";
					}
					else if( classCode.equals( "I16C" ) ) {
						retval = "Int16Col";
					}
					else if( classCode.equals( "I16T" ) ) {
						retval = "Int16Type";
					}
					else if( classCode.equals( "IG16" ) ) {
						retval = "Id16Gen";
					}
					else if( classCode.equals( "ENMD" ) ) {
						retval = "EnumDef";
					}
					else if( classCode.equals( "ENMC" ) ) {
						retval = "EnumCol";
					}
					else if( classCode.equals( "ENMT" ) ) {
						retval = "EnumType";
					}
					else if( classCode.equals( "I32D" ) ) {
						retval = "Int32Def";
					}
					else if( classCode.equals( "I32C" ) ) {
						retval = "Int32Col";
					}
					else if( classCode.equals( "I32T" ) ) {
						retval = "Int32Type";
					}
					else if( classCode.equals( "IG32" ) ) {
						retval = "Id32Gen";
					}
					else if( classCode.equals( "I64D" ) ) {
						retval = "Int64Def";
					}
					else if( classCode.equals( "I64C" ) ) {
						retval = "Int64Col";
					}
					else if( classCode.equals( "I64T" ) ) {
						retval = "Int64Type";
					}
					else if( classCode.equals( "IG64" ) ) {
						retval = "Id64Gen";
					}
					else if( classCode.equals( "U16D" ) ) {
						retval = "UInt16Def";
					}
					else if( classCode.equals( "U16C" ) ) {
						retval = "UInt16Col";
					}
					else if( classCode.equals( "U16T" ) ) {
						retval = "UInt16Type";
					}
					else if( classCode.equals( "U32D" ) ) {
						retval = "UInt32Def";
					}
					else if( classCode.equals( "U32C" ) ) {
						retval = "UInt32Col";
					}
					else if( classCode.equals( "U32T" ) ) {
						retval = "UInt32Type";
					}
					else if( classCode.equals( "U64D" ) ) {
						retval = "UInt64Def";
					}
					else if( classCode.equals( "U64C" ) ) {
						retval = "UInt64Col";
					}
					else if( classCode.equals( "U64T" ) ) {
						retval = "UInt64Type";
					}
					else if( classCode.equals( "FLTD" ) ) {
						retval = "FloatDef";
					}
					else if( classCode.equals( "FLTC" ) ) {
						retval = "FloatCol";
					}
					else if( classCode.equals( "FLTT" ) ) {
						retval = "FloatType";
					}
					else if( classCode.equals( "DBLD" ) ) {
						retval = "DoubleDef";
					}
					else if( classCode.equals( "DBLC" ) ) {
						retval = "DoubleCol";
					}
					else if( classCode.equals( "DBLT" ) ) {
						retval = "DoubleType";
					}
					else if( classCode.equals( "NUMD" ) ) {
						retval = "NumberDef";
					}
					else if( classCode.equals( "NUMC" ) ) {
						retval = "NumberCol";
					}
					else if( classCode.equals( "NUMT" ) ) {
						retval = "NumberType";
					}
					else if( classCode.equals( "STRD" ) ) {
						retval = "StringDef";
					}
					else if( classCode.equals( "STRC" ) ) {
						retval = "StringCol";
					}
					else if( classCode.equals( "STRT" ) ) {
						retval = "StringType";
					}
					else if( classCode.equals( "TXTD" ) ) {
						retval = "TextDef";
					}
					else if( classCode.equals( "TXTC" ) ) {
						retval = "TextCol";
					}
					else if( classCode.equals( "TXTT" ) ) {
						retval = "TextType";
					}
					else if( classCode.equals( "NTKD" ) ) {
						retval = "NmTokenDef";
					}
					else if( classCode.equals( "NTKC" ) ) {
						retval = "NmTokenCol";
					}
					else if( classCode.equals( "NTKT" ) ) {
						retval = "NmTokenType";
					}
					else if( classCode.equals( "NTSD" ) ) {
						retval = "NmTokensDef";
					}
					else if( classCode.equals( "NTSC" ) ) {
						retval = "NmTokensCol";
					}
					else if( classCode.equals( "NTST" ) ) {
						retval = "NmTokensType";
					}
					else if( classCode.equals( "TKND" ) ) {
						retval = "TokenDef";
					}
					else if( classCode.equals( "TKNC" ) ) {
						retval = "TokenCol";
					}
					else if( classCode.equals( "TKNT" ) ) {
						retval = "TokenType";
					}
					else if( classCode.equals( "DATD" ) ) {
						retval = "DateDef";
					}
					else if( classCode.equals( "DATC" ) ) {
						retval = "DateCol";
					}
					else if( classCode.equals( "DATT" ) ) {
						retval = "DateType";
					}
					else if( classCode.equals( "TIMD" ) ) {
						retval = "TimeDef";
					}
					else if( classCode.equals( "TIMC" ) ) {
						retval = "TimeCol";
					}
					else if( classCode.equals( "TIMT" ) ) {
						retval = "TimeType";
					}
					else if( classCode.equals( "TSPD" ) ) {
						retval = "TimestampDef";
					}
					else if( classCode.equals( "TSPC" ) ) {
						retval = "TimestampCol";
					}
					else if( classCode.equals( "TSPT" ) ) {
						retval = "TimestampType";
					}
					else if( classCode.equals( "DAZD" ) ) {
						retval = "TZDateDef";
					}
					else if( classCode.equals( "DAZC" ) ) {
						retval = "TZDateCol";
					}
					else if( classCode.equals( "DAZT" ) ) {
						retval = "TZDateType";
					}
					else if( classCode.equals( "TMZD" ) ) {
						retval = "TZTimeDef";
					}
					else if( classCode.equals( "TMZC" ) ) {
						retval = "TZTimeCol";
					}
					else if( classCode.equals( "TMZT" ) ) {
						retval = "TZTimeType";
					}
					else if( classCode.equals( "ZSTD" ) ) {
						retval = "TZTimestampDef";
					}
					else if( classCode.equals( "ZSTC" ) ) {
						retval = "TZTimestampCol";
					}
					else if( classCode.equals( "ZSTT" ) ) {
						retval = "TZTimestampType";
					}
					else if( classCode.equals( "UIDD" ) ) {
						retval = "UuidDef";
					}
					else if( classCode.equals( "UIDC" ) ) {
						retval = "UuidCol";
					}
					else if( classCode.equals( "UIDT" ) ) {
						retval = "UuidType";
					}
					else if( classCode.equals( "IGUU" ) ) {
						retval = "UuidGen";
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
			ICFBamAtomObj selectedObj;
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
				if( selectedRowData instanceof ICFBamAtomObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamAtomObj)selectedRowData;
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
						"ICFBamAtomObj" );
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
			ICFBamAtomObj o = (ICFBamAtomObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = null;
			String classCode = o.getClassCode();
			if( classCode.equals( "ATOM" ) ) {
				frame = swingSchema.getAtomFactory().newViewEditJInternalFrame( o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingAtomJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BLBD" ) ) {
				frame = swingSchema.getBlobDefFactory().newViewEditJInternalFrame( (ICFBamBlobDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBlobDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BLBC" ) ) {
				frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( (ICFBamBlobColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBlobColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BLBT" ) ) {
				frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( (ICFBamBlobTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBlobTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BOLD" ) ) {
				frame = swingSchema.getBoolDefFactory().newViewEditJInternalFrame( (ICFBamBoolDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBoolDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BOLC" ) ) {
				frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( (ICFBamBoolColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBoolColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BOLT" ) ) {
				frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( (ICFBamBoolTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingBoolTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I16D" ) ) {
				frame = swingSchema.getInt16DefFactory().newViewEditJInternalFrame( (ICFBamInt16DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I16C" ) ) {
				frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( (ICFBamInt16ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I16T" ) ) {
				frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( (ICFBamInt16TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "IG16" ) ) {
				frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( (ICFBamId16GenObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingId16GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ENMD" ) ) {
				frame = swingSchema.getEnumDefFactory().newViewEditJInternalFrame( (ICFBamEnumDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingEnumDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ENMC" ) ) {
				frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( (ICFBamEnumColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingEnumColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ENMT" ) ) {
				frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( (ICFBamEnumTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingEnumTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I32D" ) ) {
				frame = swingSchema.getInt32DefFactory().newViewEditJInternalFrame( (ICFBamInt32DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I32C" ) ) {
				frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( (ICFBamInt32ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I32T" ) ) {
				frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( (ICFBamInt32TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "IG32" ) ) {
				frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( (ICFBamId32GenObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingId32GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I64D" ) ) {
				frame = swingSchema.getInt64DefFactory().newViewEditJInternalFrame( (ICFBamInt64DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I64C" ) ) {
				frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( (ICFBamInt64ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "I64T" ) ) {
				frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( (ICFBamInt64TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "IG64" ) ) {
				frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( (ICFBamId64GenObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingId64GenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U16D" ) ) {
				frame = swingSchema.getUInt16DefFactory().newViewEditJInternalFrame( (ICFBamUInt16DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt16DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U16C" ) ) {
				frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( (ICFBamUInt16ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt16ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U16T" ) ) {
				frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( (ICFBamUInt16TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt16TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U32D" ) ) {
				frame = swingSchema.getUInt32DefFactory().newViewEditJInternalFrame( (ICFBamUInt32DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt32DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U32C" ) ) {
				frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( (ICFBamUInt32ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt32ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U32T" ) ) {
				frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( (ICFBamUInt32TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt32TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U64D" ) ) {
				frame = swingSchema.getUInt64DefFactory().newViewEditJInternalFrame( (ICFBamUInt64DefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt64DefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U64C" ) ) {
				frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( (ICFBamUInt64ColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt64ColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "U64T" ) ) {
				frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( (ICFBamUInt64TypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUInt64TypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "FLTD" ) ) {
				frame = swingSchema.getFloatDefFactory().newViewEditJInternalFrame( (ICFBamFloatDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingFloatDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "FLTC" ) ) {
				frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( (ICFBamFloatColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingFloatColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "FLTT" ) ) {
				frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( (ICFBamFloatTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingFloatTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DBLD" ) ) {
				frame = swingSchema.getDoubleDefFactory().newViewEditJInternalFrame( (ICFBamDoubleDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDoubleDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DBLC" ) ) {
				frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( (ICFBamDoubleColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDoubleColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DBLT" ) ) {
				frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( (ICFBamDoubleTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDoubleTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NUMD" ) ) {
				frame = swingSchema.getNumberDefFactory().newViewEditJInternalFrame( (ICFBamNumberDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNumberDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NUMC" ) ) {
				frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( (ICFBamNumberColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNumberColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NUMT" ) ) {
				frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( (ICFBamNumberTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNumberTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "STRD" ) ) {
				frame = swingSchema.getStringDefFactory().newViewEditJInternalFrame( (ICFBamStringDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingStringDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "STRC" ) ) {
				frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( (ICFBamStringColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingStringColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "STRT" ) ) {
				frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( (ICFBamStringTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingStringTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TXTD" ) ) {
				frame = swingSchema.getTextDefFactory().newViewEditJInternalFrame( (ICFBamTextDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTextDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TXTC" ) ) {
				frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( (ICFBamTextColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTextColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TXTT" ) ) {
				frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( (ICFBamTextTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTextTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTKD" ) ) {
				frame = swingSchema.getNmTokenDefFactory().newViewEditJInternalFrame( (ICFBamNmTokenDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTKC" ) ) {
				frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( (ICFBamNmTokenColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTKT" ) ) {
				frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( (ICFBamNmTokenTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTSD" ) ) {
				frame = swingSchema.getNmTokensDefFactory().newViewEditJInternalFrame( (ICFBamNmTokensDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokensDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTSC" ) ) {
				frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( (ICFBamNmTokensColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokensColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "NTST" ) ) {
				frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( (ICFBamNmTokensTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingNmTokensTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TKND" ) ) {
				frame = swingSchema.getTokenDefFactory().newViewEditJInternalFrame( (ICFBamTokenDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTokenDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TKNC" ) ) {
				frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( (ICFBamTokenColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTokenColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TKNT" ) ) {
				frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( (ICFBamTokenTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTokenTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DATD" ) ) {
				frame = swingSchema.getDateDefFactory().newViewEditJInternalFrame( (ICFBamDateDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDateDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DATC" ) ) {
				frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( (ICFBamDateColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDateColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DATT" ) ) {
				frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( (ICFBamDateTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDateTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TIMD" ) ) {
				frame = swingSchema.getTimeDefFactory().newViewEditJInternalFrame( (ICFBamTimeDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TIMC" ) ) {
				frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( (ICFBamTimeColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TIMT" ) ) {
				frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( (ICFBamTimeTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TSPD" ) ) {
				frame = swingSchema.getTimestampDefFactory().newViewEditJInternalFrame( (ICFBamTimestampDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TSPC" ) ) {
				frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( (ICFBamTimestampColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TSPT" ) ) {
				frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( (ICFBamTimestampTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DAZD" ) ) {
				frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( (ICFBamTZDateDefObj)o );
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
			else if( classCode.equals( "TMZD" ) ) {
				frame = swingSchema.getTZTimeDefFactory().newViewEditJInternalFrame( (ICFBamTZTimeDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimeDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TMZC" ) ) {
				frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( (ICFBamTZTimeColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimeColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TMZT" ) ) {
				frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( (ICFBamTZTimeTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimeTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				frame = swingSchema.getTZTimestampDefFactory().newViewEditJInternalFrame( (ICFBamTZTimestampDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimestampDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( (ICFBamTZTimestampColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimestampColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( (ICFBamTZTimestampTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTZTimestampTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "UIDD" ) ) {
				frame = swingSchema.getUuidDefFactory().newViewEditJInternalFrame( (ICFBamUuidDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUuidDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "UIDC" ) ) {
				frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( (ICFBamUuidColObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUuidColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "UIDT" ) ) {
				frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( (ICFBamUuidTypeObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUuidTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "IGUU" ) ) {
				frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( (ICFBamUuidGenObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingUuidGenJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	protected ActionAddBlobCol actionAddBlobCol = null;
	protected ActionAddBlobType actionAddBlobType = null;
	protected ActionAddBoolCol actionAddBoolCol = null;
	protected ActionAddBoolType actionAddBoolType = null;
	protected ActionAddInt16Col actionAddInt16Col = null;
	protected ActionAddInt16Type actionAddInt16Type = null;
	protected ActionAddId16Gen actionAddId16Gen = null;
	protected ActionAddEnumCol actionAddEnumCol = null;
	protected ActionAddEnumType actionAddEnumType = null;
	protected ActionAddInt32Col actionAddInt32Col = null;
	protected ActionAddInt32Type actionAddInt32Type = null;
	protected ActionAddId32Gen actionAddId32Gen = null;
	protected ActionAddInt64Col actionAddInt64Col = null;
	protected ActionAddInt64Type actionAddInt64Type = null;
	protected ActionAddId64Gen actionAddId64Gen = null;
	protected ActionAddUInt16Col actionAddUInt16Col = null;
	protected ActionAddUInt16Type actionAddUInt16Type = null;
	protected ActionAddUInt32Col actionAddUInt32Col = null;
	protected ActionAddUInt32Type actionAddUInt32Type = null;
	protected ActionAddUInt64Col actionAddUInt64Col = null;
	protected ActionAddUInt64Type actionAddUInt64Type = null;
	protected ActionAddFloatCol actionAddFloatCol = null;
	protected ActionAddFloatType actionAddFloatType = null;
	protected ActionAddDoubleCol actionAddDoubleCol = null;
	protected ActionAddDoubleType actionAddDoubleType = null;
	protected ActionAddNumberCol actionAddNumberCol = null;
	protected ActionAddNumberType actionAddNumberType = null;
	protected ActionAddStringCol actionAddStringCol = null;
	protected ActionAddStringType actionAddStringType = null;
	protected ActionAddTextCol actionAddTextCol = null;
	protected ActionAddTextType actionAddTextType = null;
	protected ActionAddNmTokenCol actionAddNmTokenCol = null;
	protected ActionAddNmTokenType actionAddNmTokenType = null;
	protected ActionAddNmTokensCol actionAddNmTokensCol = null;
	protected ActionAddNmTokensType actionAddNmTokensType = null;
	protected ActionAddTokenCol actionAddTokenCol = null;
	protected ActionAddTokenType actionAddTokenType = null;
	protected ActionAddDateCol actionAddDateCol = null;
	protected ActionAddDateType actionAddDateType = null;
	protected ActionAddTimeCol actionAddTimeCol = null;
	protected ActionAddTimeType actionAddTimeType = null;
	protected ActionAddTimestampCol actionAddTimestampCol = null;
	protected ActionAddTimestampType actionAddTimestampType = null;
	protected ActionAddTZDateCol actionAddTZDateCol = null;
	protected ActionAddTZDateType actionAddTZDateType = null;
	protected ActionAddTZTimeCol actionAddTZTimeCol = null;
	protected ActionAddTZTimeType actionAddTZTimeType = null;
	protected ActionAddTZTimestampCol actionAddTZTimestampCol = null;
	protected ActionAddTZTimestampType actionAddTZTimestampType = null;
	protected ActionAddUuidCol actionAddUuidCol = null;
	protected ActionAddUuidType actionAddUuidType = null;
	protected ActionAddUuidGen actionAddUuidGen = null;
	protected ViewSelectedActionAtom actionViewSelected = null;
	protected EditSelectedActionAtom actionEditSelected = null;
	protected DeleteSelectedActionAtom actionDeleteSelected = null;
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


	public CFBamSwingAtomListJPanel( ICFBamSwingSchema argSchema,
		ICFBamScopeObj argContainer,
		ICFBamAtomObj argFocus,
		Collection<ICFBamAtomObj> argDataCollection,
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
		if( ( value == null ) || ( value instanceof ICFBamAtomObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamAtomObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamAtomObj getSwingFocusAsAtom() {
		return( (ICFBamAtomObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsAtom( ICFBamAtomObj value ) {
		setSwingFocus( value );
	}

	public class AtomByQualNameComparator
	implements Comparator<ICFBamAtomObj>
	{
		public AtomByQualNameComparator() {
		}

		public int compare( ICFBamAtomObj lhs, ICFBamAtomObj rhs ) {
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

	protected AtomByQualNameComparator compareAtomByQualName = new AtomByQualNameComparator();

	public Collection<ICFBamAtomObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamAtomObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfAtom = new ICFBamAtomObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfAtom = new ICFBamAtomObj[ len ];
				Iterator<ICFBamAtomObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfAtom[idx++] = iter.next();
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
				Arrays.sort( arrayOfAtom, compareAtomByQualName );
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
					actionAddBlobCol = new ActionAddBlobCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddBlobCol );
						menuAdd.add( menuItem );
					}
					actionAddBlobType = new ActionAddBlobType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddBlobType );
						menuAdd.add( menuItem );
					}
					actionAddBoolCol = new ActionAddBoolCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddBoolCol );
						menuAdd.add( menuItem );
					}
					actionAddBoolType = new ActionAddBoolType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddBoolType );
						menuAdd.add( menuItem );
					}
					actionAddInt16Col = new ActionAddInt16Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddInt16Col );
						menuAdd.add( menuItem );
					}
					actionAddInt16Type = new ActionAddInt16Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddInt16Type );
						menuAdd.add( menuItem );
					}
					actionAddId16Gen = new ActionAddId16Gen();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddId16Gen );
						menuAdd.add( menuItem );
					}
					actionAddEnumCol = new ActionAddEnumCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddEnumCol );
						menuAdd.add( menuItem );
					}
					actionAddEnumType = new ActionAddEnumType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddEnumType );
						menuAdd.add( menuItem );
					}
					actionAddInt32Col = new ActionAddInt32Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddInt32Col );
						menuAdd.add( menuItem );
					}
					actionAddInt32Type = new ActionAddInt32Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddInt32Type );
						menuAdd.add( menuItem );
					}
					actionAddId32Gen = new ActionAddId32Gen();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddId32Gen );
						menuAdd.add( menuItem );
					}
					actionAddInt64Col = new ActionAddInt64Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddInt64Col );
						menuAdd.add( menuItem );
					}
					actionAddInt64Type = new ActionAddInt64Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddInt64Type );
						menuAdd.add( menuItem );
					}
					actionAddId64Gen = new ActionAddId64Gen();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddId64Gen );
						menuAdd.add( menuItem );
					}
					actionAddUInt16Col = new ActionAddUInt16Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddUInt16Col );
						menuAdd.add( menuItem );
					}
					actionAddUInt16Type = new ActionAddUInt16Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddUInt16Type );
						menuAdd.add( menuItem );
					}
					actionAddUInt32Col = new ActionAddUInt32Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddUInt32Col );
						menuAdd.add( menuItem );
					}
					actionAddUInt32Type = new ActionAddUInt32Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddUInt32Type );
						menuAdd.add( menuItem );
					}
					actionAddUInt64Col = new ActionAddUInt64Col();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddUInt64Col );
						menuAdd.add( menuItem );
					}
					actionAddUInt64Type = new ActionAddUInt64Type();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddUInt64Type );
						menuAdd.add( menuItem );
					}
					actionAddFloatCol = new ActionAddFloatCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddFloatCol );
						menuAdd.add( menuItem );
					}
					actionAddFloatType = new ActionAddFloatType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddFloatType );
						menuAdd.add( menuItem );
					}
					actionAddDoubleCol = new ActionAddDoubleCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddDoubleCol );
						menuAdd.add( menuItem );
					}
					actionAddDoubleType = new ActionAddDoubleType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddDoubleType );
						menuAdd.add( menuItem );
					}
					actionAddNumberCol = new ActionAddNumberCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddNumberCol );
						menuAdd.add( menuItem );
					}
					actionAddNumberType = new ActionAddNumberType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddNumberType );
						menuAdd.add( menuItem );
					}
					actionAddStringCol = new ActionAddStringCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddStringCol );
						menuAdd.add( menuItem );
					}
					actionAddStringType = new ActionAddStringType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddStringType );
						menuAdd.add( menuItem );
					}
					actionAddTextCol = new ActionAddTextCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTextCol );
						menuAdd.add( menuItem );
					}
					actionAddTextType = new ActionAddTextType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTextType );
						menuAdd.add( menuItem );
					}
					actionAddNmTokenCol = new ActionAddNmTokenCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddNmTokenCol );
						menuAdd.add( menuItem );
					}
					actionAddNmTokenType = new ActionAddNmTokenType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddNmTokenType );
						menuAdd.add( menuItem );
					}
					actionAddNmTokensCol = new ActionAddNmTokensCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddNmTokensCol );
						menuAdd.add( menuItem );
					}
					actionAddNmTokensType = new ActionAddNmTokensType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddNmTokensType );
						menuAdd.add( menuItem );
					}
					actionAddTokenCol = new ActionAddTokenCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTokenCol );
						menuAdd.add( menuItem );
					}
					actionAddTokenType = new ActionAddTokenType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTokenType );
						menuAdd.add( menuItem );
					}
					actionAddDateCol = new ActionAddDateCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddDateCol );
						menuAdd.add( menuItem );
					}
					actionAddDateType = new ActionAddDateType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddDateType );
						menuAdd.add( menuItem );
					}
					actionAddTimeCol = new ActionAddTimeCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTimeCol );
						menuAdd.add( menuItem );
					}
					actionAddTimeType = new ActionAddTimeType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTimeType );
						menuAdd.add( menuItem );
					}
					actionAddTimestampCol = new ActionAddTimestampCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTimestampCol );
						menuAdd.add( menuItem );
					}
					actionAddTimestampType = new ActionAddTimestampType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTimestampType );
						menuAdd.add( menuItem );
					}
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
					actionAddTZTimeCol = new ActionAddTZTimeCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTZTimeCol );
						menuAdd.add( menuItem );
					}
					actionAddTZTimeType = new ActionAddTZTimeType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTZTimeType );
						menuAdd.add( menuItem );
					}
					actionAddTZTimestampCol = new ActionAddTZTimestampCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddTZTimestampCol );
						menuAdd.add( menuItem );
					}
					actionAddTZTimestampType = new ActionAddTZTimestampType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTZTimestampType );
						menuAdd.add( menuItem );
					}
					actionAddUuidCol = new ActionAddUuidCol();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddUuidCol );
						menuAdd.add( menuItem );
					}
					actionAddUuidType = new ActionAddUuidType();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddUuidType );
						menuAdd.add( menuItem );
					}
					actionAddUuidGen = new ActionAddUuidGen();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddUuidGen );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionAtom();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionAtom();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionAtom();
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
		ICFBamAtomObj selectedObj = getSwingFocusAsAtom();
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
