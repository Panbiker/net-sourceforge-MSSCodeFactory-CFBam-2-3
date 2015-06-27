// Description: Java 7 Swing List of Obj JPanel implementation for Scope.

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
 *	CFBamSwingScopeListJPanel Swing List of Obj JPanel implementation
 *	for Scope.
 */
public class CFBamSwingScopeListJPanel
extends CFJPanel
implements ICFBamSwingScopeJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamScopeObj> swingDataCollection = null;
	protected ICFBamScopeObj arrayOfScope[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_OBJKIND = 1;
	public final static int COLID_ID = 2;
	public final static int NUM_COLS = 3;
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

	protected class ActionAddSchemaRef
	extends AbstractAction
	{
		public ActionAddSchemaRef() {
			super();
			putValue( Action.NAME, "Add SchemaRef..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSchemaRefObj obj = schemaObj.getSchemaRefTableObj().newInstance();
			JInternalFrame frame = swingSchema.getSchemaRefFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamSchemaRefEditObj edit = (ICFBamSchemaRefEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerSchema( container );
			ICFBamSwingSchemaRefJPanelCommon jpanelCommon = (ICFBamSwingSchemaRefJPanelCommon)frame;
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

	protected class ActionAddTable
	extends AbstractAction
	{
		public ActionAddTable() {
			super();
			putValue( Action.NAME, "Add Table..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj obj = schemaObj.getTableTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTableFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTableEditObj edit = (ICFBamTableEditObj)( obj.beginEdit() );
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
			ICFBamSwingTableJPanelCommon jpanelCommon = (ICFBamSwingTableJPanelCommon)frame;
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

	protected class ActionAddDelTopDep
	extends AbstractAction
	{
		public ActionAddDelTopDep() {
			super();
			putValue( Action.NAME, "Add DelTopDep..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDelTopDepObj obj = schemaObj.getDelTopDepTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDelTopDepFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDelTopDepEditObj edit = (ICFBamDelTopDepEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerContTable( container );
			ICFBamSwingDelTopDepJPanelCommon jpanelCommon = (ICFBamSwingDelTopDepJPanelCommon)frame;
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

	protected class ActionAddDelSubDep1
	extends AbstractAction
	{
		public ActionAddDelSubDep1() {
			super();
			putValue( Action.NAME, "Add DelSubDep1..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDelSubDep1Obj obj = schemaObj.getDelSubDep1TableObj().newInstance();
			JInternalFrame frame = swingSchema.getDelSubDep1Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDelSubDep1EditObj edit = (ICFBamDelSubDep1EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamDelTopDepObj container = (ICFBamDelTopDepObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContDelTopDep( container );
			ICFBamSwingDelSubDep1JPanelCommon jpanelCommon = (ICFBamSwingDelSubDep1JPanelCommon)frame;
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

	protected class ActionAddDelSubDep2
	extends AbstractAction
	{
		public ActionAddDelSubDep2() {
			super();
			putValue( Action.NAME, "Add DelSubDep2..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDelSubDep2Obj obj = schemaObj.getDelSubDep2TableObj().newInstance();
			JInternalFrame frame = swingSchema.getDelSubDep2Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDelSubDep2EditObj edit = (ICFBamDelSubDep2EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamDelSubDep1Obj container = (ICFBamDelSubDep1Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContDelSubDep1( container );
			ICFBamSwingDelSubDep2JPanelCommon jpanelCommon = (ICFBamSwingDelSubDep2JPanelCommon)frame;
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

	protected class ActionAddDelSubDep3
	extends AbstractAction
	{
		public ActionAddDelSubDep3() {
			super();
			putValue( Action.NAME, "Add DelSubDep3..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDelSubDep3Obj obj = schemaObj.getDelSubDep3TableObj().newInstance();
			JInternalFrame frame = swingSchema.getDelSubDep3Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDelSubDep3EditObj edit = (ICFBamDelSubDep3EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamDelSubDep2Obj container = (ICFBamDelSubDep2Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContDelSubDep2( container );
			ICFBamSwingDelSubDep3JPanelCommon jpanelCommon = (ICFBamSwingDelSubDep3JPanelCommon)frame;
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

	protected class ActionAddIndex
	extends AbstractAction
	{
		public ActionAddIndex() {
			super();
			putValue( Action.NAME, "Add Index..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamIndexObj obj = schemaObj.getIndexTableObj().newInstance();
			JInternalFrame frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamIndexEditObj edit = (ICFBamIndexEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerIdxTenant( secTenant );
			ICFBamTableObj container = (ICFBamTableObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerTable( container );
			ICFBamSwingIndexJPanelCommon jpanelCommon = (ICFBamSwingIndexJPanelCommon)frame;
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

	protected class ActionAddRelation
	extends AbstractAction
	{
		public ActionAddRelation() {
			super();
			putValue( Action.NAME, "Add Relation..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj obj = schemaObj.getRelationTableObj().newInstance();
			JInternalFrame frame = swingSchema.getRelationFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamRelationEditObj edit = (ICFBamRelationEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerRelTenant( secTenant );
			ICFBamTableObj container = (ICFBamTableObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerFromTable( container );
			ICFBamSwingRelationJPanelCommon jpanelCommon = (ICFBamSwingRelationJPanelCommon)frame;
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

	protected class ActionAddServerMethod
	extends AbstractAction
	{
		public ActionAddServerMethod() {
			super();
			putValue( Action.NAME, "Add ServerMethod..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerMethodObj obj = schemaObj.getServerMethodTableObj().newInstance();
			JInternalFrame frame = swingSchema.getServerMethodFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamServerMethodEditObj edit = (ICFBamServerMethodEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerForTable( container );
			ICFBamSwingServerMethodJPanelCommon jpanelCommon = (ICFBamSwingServerMethodJPanelCommon)frame;
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

	protected class ActionAddServerProc
	extends AbstractAction
	{
		public ActionAddServerProc() {
			super();
			putValue( Action.NAME, "Add ServerProc..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerProcObj obj = schemaObj.getServerProcTableObj().newInstance();
			JInternalFrame frame = swingSchema.getServerProcFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamServerProcEditObj edit = (ICFBamServerProcEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerForTable( container );
			ICFBamSwingServerProcJPanelCommon jpanelCommon = (ICFBamSwingServerProcJPanelCommon)frame;
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

	protected class ActionAddServerObjFunc
	extends AbstractAction
	{
		public ActionAddServerObjFunc() {
			super();
			putValue( Action.NAME, "Add ServerObjFunc..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerObjFuncObj obj = schemaObj.getServerObjFuncTableObj().newInstance();
			JInternalFrame frame = swingSchema.getServerObjFuncFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamServerObjFuncEditObj edit = (ICFBamServerObjFuncEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerForTable( container );
			ICFBamSwingServerObjFuncJPanelCommon jpanelCommon = (ICFBamSwingServerObjFuncJPanelCommon)frame;
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

	protected class ActionAddServerListFunc
	extends AbstractAction
	{
		public ActionAddServerListFunc() {
			super();
			putValue( Action.NAME, "Add ServerListFunc..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerListFuncObj obj = schemaObj.getServerListFuncTableObj().newInstance();
			JInternalFrame frame = swingSchema.getServerListFuncFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamServerListFuncEditObj edit = (ICFBamServerListFuncEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerForTable( container );
			ICFBamSwingServerListFuncJPanelCommon jpanelCommon = (ICFBamSwingServerListFuncJPanelCommon)frame;
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

	protected class ActionAddPopTopDep
	extends AbstractAction
	{
		public ActionAddPopTopDep() {
			super();
			putValue( Action.NAME, "Add PopTopDep..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamPopTopDepObj obj = schemaObj.getPopTopDepTableObj().newInstance();
			JInternalFrame frame = swingSchema.getPopTopDepFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamPopTopDepEditObj edit = (ICFBamPopTopDepEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamRelationObj container = (ICFBamRelationObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContRelation( container );
			ICFBamSwingPopTopDepJPanelCommon jpanelCommon = (ICFBamSwingPopTopDepJPanelCommon)frame;
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

	protected class ActionAddPopSubDep1
	extends AbstractAction
	{
		public ActionAddPopSubDep1() {
			super();
			putValue( Action.NAME, "Add PopSubDep1..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamPopSubDep1Obj obj = schemaObj.getPopSubDep1TableObj().newInstance();
			JInternalFrame frame = swingSchema.getPopSubDep1Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamPopSubDep1EditObj edit = (ICFBamPopSubDep1EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamPopTopDepObj container = (ICFBamPopTopDepObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContPopTopDep( container );
			ICFBamSwingPopSubDep1JPanelCommon jpanelCommon = (ICFBamSwingPopSubDep1JPanelCommon)frame;
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

	protected class ActionAddPopSubDep2
	extends AbstractAction
	{
		public ActionAddPopSubDep2() {
			super();
			putValue( Action.NAME, "Add PopSubDep2..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamPopSubDep2Obj obj = schemaObj.getPopSubDep2TableObj().newInstance();
			JInternalFrame frame = swingSchema.getPopSubDep2Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamPopSubDep2EditObj edit = (ICFBamPopSubDep2EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamPopSubDep1Obj container = (ICFBamPopSubDep1Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContPopSubDep1( container );
			ICFBamSwingPopSubDep2JPanelCommon jpanelCommon = (ICFBamSwingPopSubDep2JPanelCommon)frame;
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

	protected class ActionAddPopSubDep3
	extends AbstractAction
	{
		public ActionAddPopSubDep3() {
			super();
			putValue( Action.NAME, "Add PopSubDep3..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamPopSubDep3Obj obj = schemaObj.getPopSubDep3TableObj().newInstance();
			JInternalFrame frame = swingSchema.getPopSubDep3Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamPopSubDep3EditObj edit = (ICFBamPopSubDep3EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamPopSubDep2Obj container = (ICFBamPopSubDep2Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContPopSubDep2( container );
			ICFBamSwingPopSubDep3JPanelCommon jpanelCommon = (ICFBamSwingPopSubDep3JPanelCommon)frame;
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

	protected class ActionAddClearTopDep
	extends AbstractAction
	{
		public ActionAddClearTopDep() {
			super();
			putValue( Action.NAME, "Add ClearTopDep..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamClearTopDepObj obj = schemaObj.getClearTopDepTableObj().newInstance();
			JInternalFrame frame = swingSchema.getClearTopDepFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamClearTopDepEditObj edit = (ICFBamClearTopDepEditObj)( obj.beginEdit() );
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
			edit.setRequiredContainerContTable( container );
			ICFBamSwingClearTopDepJPanelCommon jpanelCommon = (ICFBamSwingClearTopDepJPanelCommon)frame;
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

	protected class ActionAddClearSubDep1
	extends AbstractAction
	{
		public ActionAddClearSubDep1() {
			super();
			putValue( Action.NAME, "Add ClearSubDep1..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamClearSubDep1Obj obj = schemaObj.getClearSubDep1TableObj().newInstance();
			JInternalFrame frame = swingSchema.getClearSubDep1Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamClearSubDep1EditObj edit = (ICFBamClearSubDep1EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamClearTopDepObj container = (ICFBamClearTopDepObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContClearTopDep( container );
			ICFBamSwingClearSubDep1JPanelCommon jpanelCommon = (ICFBamSwingClearSubDep1JPanelCommon)frame;
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

	protected class ActionAddClearSubDep2
	extends AbstractAction
	{
		public ActionAddClearSubDep2() {
			super();
			putValue( Action.NAME, "Add ClearSubDep2..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamClearSubDep2Obj obj = schemaObj.getClearSubDep2TableObj().newInstance();
			JInternalFrame frame = swingSchema.getClearSubDep2Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamClearSubDep2EditObj edit = (ICFBamClearSubDep2EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamClearSubDep1Obj container = (ICFBamClearSubDep1Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContClearSubDep1( container );
			ICFBamSwingClearSubDep2JPanelCommon jpanelCommon = (ICFBamSwingClearSubDep2JPanelCommon)frame;
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

	protected class ActionAddClearSubDep3
	extends AbstractAction
	{
		public ActionAddClearSubDep3() {
			super();
			putValue( Action.NAME, "Add ClearSubDep3..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamClearSubDep3Obj obj = schemaObj.getClearSubDep3TableObj().newInstance();
			JInternalFrame frame = swingSchema.getClearSubDep3Factory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamClearSubDep3EditObj edit = (ICFBamClearSubDep3EditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamClearSubDep2Obj container = (ICFBamClearSubDep2Obj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerContClearSubDep2( container );
			ICFBamSwingClearSubDep3JPanelCommon jpanelCommon = (ICFBamSwingClearSubDep3JPanelCommon)frame;
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

	protected class ViewSelectedActionScope
	extends AbstractAction
	{
		public ViewSelectedActionScope() {
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
			ICFBamScopeObj selectedInstance = getSwingFocusAsScope();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCOP".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getScopeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SCHM".equals( classCode ) ) {
					ICFBamSchemaDefObj obj = (ICFBamSchemaDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( obj );
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
				else if( "SCRF".equals( classCode ) ) {
					ICFBamSchemaRefObj obj = (ICFBamSchemaRefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaRefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSchemaRefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TBLD".equals( classCode ) ) {
					ICFBamTableObj obj = (ICFBamTableObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTableFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTableJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DELD".equals( classCode ) ) {
					ICFBamDelDepObj obj = (ICFBamDelDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DELT".equals( classCode ) ) {
					ICFBamDelTopDepObj obj = (ICFBamDelTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL1".equals( classCode ) ) {
					ICFBamDelSubDep1Obj obj = (ICFBamDelSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL2".equals( classCode ) ) {
					ICFBamDelSubDep2Obj obj = (ICFBamDelSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL3".equals( classCode ) ) {
					ICFBamDelSubDep3Obj obj = (ICFBamDelSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "IDXD".equals( classCode ) ) {
					ICFBamIndexObj obj = (ICFBamIndexObj)selectedInstance;
					JInternalFrame frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "RELD".equals( classCode ) ) {
					ICFBamRelationObj obj = (ICFBamRelationObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRelationFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRelationJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVM".equals( classCode ) ) {
					ICFBamServerMethodObj obj = (ICFBamServerMethodObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerMethodFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerMethodJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVP".equals( classCode ) ) {
					ICFBamServerProcObj obj = (ICFBamServerProcObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerProcFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerProcJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVO".equals( classCode ) ) {
					ICFBamServerObjFuncObj obj = (ICFBamServerObjFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerObjFuncFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerObjFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVL".equals( classCode ) ) {
					ICFBamServerListFuncObj obj = (ICFBamServerListFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerListFuncFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerListFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POPD".equals( classCode ) ) {
					ICFBamPopDepObj obj = (ICFBamPopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POPT".equals( classCode ) ) {
					ICFBamPopTopDepObj obj = (ICFBamPopTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP1".equals( classCode ) ) {
					ICFBamPopSubDep1Obj obj = (ICFBamPopSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP2".equals( classCode ) ) {
					ICFBamPopSubDep2Obj obj = (ICFBamPopSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP3".equals( classCode ) ) {
					ICFBamPopSubDep3Obj obj = (ICFBamPopSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLRD".equals( classCode ) ) {
					ICFBamClearDepObj obj = (ICFBamClearDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLRT".equals( classCode ) ) {
					ICFBamClearTopDepObj obj = (ICFBamClearTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR1".equals( classCode ) ) {
					ICFBamClearSubDep1Obj obj = (ICFBamClearSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR2".equals( classCode ) ) {
					ICFBamClearSubDep2Obj obj = (ICFBamClearSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR3".equals( classCode ) ) {
					ICFBamClearSubDep3Obj obj = (ICFBamClearSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
						"ICFBamScopeObj, ICFBamSchemaDefObj, ICFBamSchemaRefObj, ICFBamTableObj, ICFBamDelDepObj, ICFBamDelTopDepObj, ICFBamDelSubDep1Obj, ICFBamDelSubDep2Obj, ICFBamDelSubDep3Obj, ICFBamIndexObj, ICFBamRelationObj, ICFBamServerMethodObj, ICFBamServerProcObj, ICFBamServerObjFuncObj, ICFBamServerListFuncObj, ICFBamPopDepObj, ICFBamPopTopDepObj, ICFBamPopSubDep1Obj, ICFBamPopSubDep2Obj, ICFBamPopSubDep3Obj, ICFBamClearDepObj, ICFBamClearTopDepObj, ICFBamClearSubDep1Obj, ICFBamClearSubDep2Obj, ICFBamClearSubDep3Obj" );
				}
			}
		}
	}

	protected class EditSelectedActionScope
	extends AbstractAction
	{
		public EditSelectedActionScope() {
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
			ICFBamScopeObj selectedInstance = getSwingFocusAsScope();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCOP".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getScopeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SCHM".equals( classCode ) ) {
					ICFBamSchemaDefObj obj = (ICFBamSchemaDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( obj );
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
				else if( "SCRF".equals( classCode ) ) {
					ICFBamSchemaRefObj obj = (ICFBamSchemaRefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaRefFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSchemaRefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TBLD".equals( classCode ) ) {
					ICFBamTableObj obj = (ICFBamTableObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTableFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTableJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DELD".equals( classCode ) ) {
					ICFBamDelDepObj obj = (ICFBamDelDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DELT".equals( classCode ) ) {
					ICFBamDelTopDepObj obj = (ICFBamDelTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL1".equals( classCode ) ) {
					ICFBamDelSubDep1Obj obj = (ICFBamDelSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL2".equals( classCode ) ) {
					ICFBamDelSubDep2Obj obj = (ICFBamDelSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DEL3".equals( classCode ) ) {
					ICFBamDelSubDep3Obj obj = (ICFBamDelSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDelSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "IDXD".equals( classCode ) ) {
					ICFBamIndexObj obj = (ICFBamIndexObj)selectedInstance;
					JInternalFrame frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "RELD".equals( classCode ) ) {
					ICFBamRelationObj obj = (ICFBamRelationObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRelationFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRelationJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVM".equals( classCode ) ) {
					ICFBamServerMethodObj obj = (ICFBamServerMethodObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerMethodFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerMethodJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVP".equals( classCode ) ) {
					ICFBamServerProcObj obj = (ICFBamServerProcObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerProcFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerProcJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVO".equals( classCode ) ) {
					ICFBamServerObjFuncObj obj = (ICFBamServerObjFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerObjFuncFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerObjFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SRVL".equals( classCode ) ) {
					ICFBamServerListFuncObj obj = (ICFBamServerListFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerListFuncFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingServerListFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POPD".equals( classCode ) ) {
					ICFBamPopDepObj obj = (ICFBamPopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POPT".equals( classCode ) ) {
					ICFBamPopTopDepObj obj = (ICFBamPopTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP1".equals( classCode ) ) {
					ICFBamPopSubDep1Obj obj = (ICFBamPopSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP2".equals( classCode ) ) {
					ICFBamPopSubDep2Obj obj = (ICFBamPopSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "POP3".equals( classCode ) ) {
					ICFBamPopSubDep3Obj obj = (ICFBamPopSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingPopSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLRD".equals( classCode ) ) {
					ICFBamClearDepObj obj = (ICFBamClearDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLRT".equals( classCode ) ) {
					ICFBamClearTopDepObj obj = (ICFBamClearTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearTopDepFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR1".equals( classCode ) ) {
					ICFBamClearSubDep1Obj obj = (ICFBamClearSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep1Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR2".equals( classCode ) ) {
					ICFBamClearSubDep2Obj obj = (ICFBamClearSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep2Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "CLR3".equals( classCode ) ) {
					ICFBamClearSubDep3Obj obj = (ICFBamClearSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep3Factory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingClearSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
						"ICFBamScopeObj, ICFBamSchemaDefObj, ICFBamSchemaRefObj, ICFBamTableObj, ICFBamDelDepObj, ICFBamDelTopDepObj, ICFBamDelSubDep1Obj, ICFBamDelSubDep2Obj, ICFBamDelSubDep3Obj, ICFBamIndexObj, ICFBamRelationObj, ICFBamServerMethodObj, ICFBamServerProcObj, ICFBamServerObjFuncObj, ICFBamServerListFuncObj, ICFBamPopDepObj, ICFBamPopTopDepObj, ICFBamPopSubDep1Obj, ICFBamPopSubDep2Obj, ICFBamPopSubDep3Obj, ICFBamClearDepObj, ICFBamClearTopDepObj, ICFBamClearSubDep1Obj, ICFBamClearSubDep2Obj, ICFBamClearSubDep3Obj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionScope
	extends AbstractAction
	{
		public DeleteSelectedActionScope() {
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
			ICFBamScopeObj selectedInstance = getSwingFocusAsScope();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "SCOP".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getScopeFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SCHM".equals( classCode ) ) {
					ICFBamSchemaDefObj obj = (ICFBamSchemaDefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaDefFactory().newAskDeleteJInternalFrame( obj );
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
				else if( "SCRF".equals( classCode ) ) {
					ICFBamSchemaRefObj obj = (ICFBamSchemaRefObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSchemaRefFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingSchemaRefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TBLD".equals( classCode ) ) {
					ICFBamTableObj obj = (ICFBamTableObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTableFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTableJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DELD".equals( classCode ) ) {
					ICFBamDelDepObj obj = (ICFBamDelDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDelDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DELT".equals( classCode ) ) {
					ICFBamDelTopDepObj obj = (ICFBamDelTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelTopDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDelTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DEL1".equals( classCode ) ) {
					ICFBamDelSubDep1Obj obj = (ICFBamDelSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep1Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDelSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DEL2".equals( classCode ) ) {
					ICFBamDelSubDep2Obj obj = (ICFBamDelSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep2Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDelSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DEL3".equals( classCode ) ) {
					ICFBamDelSubDep3Obj obj = (ICFBamDelSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getDelSubDep3Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDelSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "IDXD".equals( classCode ) ) {
					ICFBamIndexObj obj = (ICFBamIndexObj)selectedInstance;
					JInternalFrame frame = swingSchema.getIndexFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "RELD".equals( classCode ) ) {
					ICFBamRelationObj obj = (ICFBamRelationObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRelationFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingRelationJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SRVM".equals( classCode ) ) {
					ICFBamServerMethodObj obj = (ICFBamServerMethodObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerMethodFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingServerMethodJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SRVP".equals( classCode ) ) {
					ICFBamServerProcObj obj = (ICFBamServerProcObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerProcFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingServerProcJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SRVO".equals( classCode ) ) {
					ICFBamServerObjFuncObj obj = (ICFBamServerObjFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerObjFuncFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingServerObjFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SRVL".equals( classCode ) ) {
					ICFBamServerListFuncObj obj = (ICFBamServerListFuncObj)selectedInstance;
					JInternalFrame frame = swingSchema.getServerListFuncFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingServerListFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "POPD".equals( classCode ) ) {
					ICFBamPopDepObj obj = (ICFBamPopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingPopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "POPT".equals( classCode ) ) {
					ICFBamPopTopDepObj obj = (ICFBamPopTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopTopDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingPopTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "POP1".equals( classCode ) ) {
					ICFBamPopSubDep1Obj obj = (ICFBamPopSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep1Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingPopSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "POP2".equals( classCode ) ) {
					ICFBamPopSubDep2Obj obj = (ICFBamPopSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep2Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingPopSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "POP3".equals( classCode ) ) {
					ICFBamPopSubDep3Obj obj = (ICFBamPopSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getPopSubDep3Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingPopSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "CLRD".equals( classCode ) ) {
					ICFBamClearDepObj obj = (ICFBamClearDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingClearDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "CLRT".equals( classCode ) ) {
					ICFBamClearTopDepObj obj = (ICFBamClearTopDepObj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearTopDepFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingClearTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "CLR1".equals( classCode ) ) {
					ICFBamClearSubDep1Obj obj = (ICFBamClearSubDep1Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep1Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingClearSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "CLR2".equals( classCode ) ) {
					ICFBamClearSubDep2Obj obj = (ICFBamClearSubDep2Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep2Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingClearSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "CLR3".equals( classCode ) ) {
					ICFBamClearSubDep3Obj obj = (ICFBamClearSubDep3Obj)selectedInstance;
					JInternalFrame frame = swingSchema.getClearSubDep3Factory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingClearSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamScopeObj, ICFBamSchemaDefObj, ICFBamSchemaRefObj, ICFBamTableObj, ICFBamDelDepObj, ICFBamDelTopDepObj, ICFBamDelSubDep1Obj, ICFBamDelSubDep2Obj, ICFBamDelSubDep3Obj, ICFBamIndexObj, ICFBamRelationObj, ICFBamServerMethodObj, ICFBamServerProcObj, ICFBamServerObjFuncObj, ICFBamServerListFuncObj, ICFBamPopDepObj, ICFBamPopTopDepObj, ICFBamPopSubDep1Obj, ICFBamPopSubDep2Obj, ICFBamPopSubDep3Obj, ICFBamClearDepObj, ICFBamClearTopDepObj, ICFBamClearSubDep1Obj, ICFBamClearSubDep2Obj, ICFBamClearSubDep3Obj" );
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
			if( arrayOfScope != null ) {
				retval = arrayOfScope.length;
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
					retval = "Scope";
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
			if( arrayOfScope == null ) {
				return( null );
			}
			int len = arrayOfScope.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamScopeObj obj = arrayOfScope[row];
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
					if( classCode.equals( "SCOP" ) ) {
						retval = "Scope";
					}
					else if( classCode.equals( "SCHM" ) ) {
						retval = "SchemaDef";
					}
					else if( classCode.equals( "SCRF" ) ) {
						retval = "SchemaRef";
					}
					else if( classCode.equals( "TBLD" ) ) {
						retval = "Table";
					}
					else if( classCode.equals( "DELD" ) ) {
						retval = "DelDep";
					}
					else if( classCode.equals( "DELT" ) ) {
						retval = "DelTopDep";
					}
					else if( classCode.equals( "DEL1" ) ) {
						retval = "DelSubDep1";
					}
					else if( classCode.equals( "DEL2" ) ) {
						retval = "DelSubDep2";
					}
					else if( classCode.equals( "DEL3" ) ) {
						retval = "DelSubDep3";
					}
					else if( classCode.equals( "IDXD" ) ) {
						retval = "Index";
					}
					else if( classCode.equals( "RELD" ) ) {
						retval = "Relation";
					}
					else if( classCode.equals( "SRVM" ) ) {
						retval = "ServerMethod";
					}
					else if( classCode.equals( "SRVP" ) ) {
						retval = "ServerProc";
					}
					else if( classCode.equals( "SRVO" ) ) {
						retval = "ServerObjFunc";
					}
					else if( classCode.equals( "SRVL" ) ) {
						retval = "ServerListFunc";
					}
					else if( classCode.equals( "POPD" ) ) {
						retval = "PopDep";
					}
					else if( classCode.equals( "POPT" ) ) {
						retval = "PopTopDep";
					}
					else if( classCode.equals( "POP1" ) ) {
						retval = "PopSubDep1";
					}
					else if( classCode.equals( "POP2" ) ) {
						retval = "PopSubDep2";
					}
					else if( classCode.equals( "POP3" ) ) {
						retval = "PopSubDep3";
					}
					else if( classCode.equals( "CLRD" ) ) {
						retval = "ClearDep";
					}
					else if( classCode.equals( "CLRT" ) ) {
						retval = "ClearTopDep";
					}
					else if( classCode.equals( "CLR1" ) ) {
						retval = "ClearSubDep1";
					}
					else if( classCode.equals( "CLR2" ) ) {
						retval = "ClearSubDep2";
					}
					else if( classCode.equals( "CLR3" ) ) {
						retval = "ClearSubDep3";
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

		public ListTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new ObjKindColumn() );
			addColumn( new IdColumn() );
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
			ICFBamScopeObj selectedObj;
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
				if( selectedRowData instanceof ICFBamScopeObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamScopeObj)selectedRowData;
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
						"ICFBamScopeObj" );
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
			ICFBamScopeObj o = (ICFBamScopeObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = null;
			String classCode = o.getClassCode();
			if( classCode.equals( "SCOP" ) ) {
				frame = swingSchema.getScopeFactory().newViewEditJInternalFrame( o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SCHM" ) ) {
				frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( (ICFBamSchemaDefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SCRF" ) ) {
				frame = swingSchema.getSchemaRefFactory().newViewEditJInternalFrame( (ICFBamSchemaRefObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingSchemaRefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TBLD" ) ) {
				frame = swingSchema.getTableFactory().newViewEditJInternalFrame( (ICFBamTableObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTableJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DELD" ) ) {
				frame = swingSchema.getDelDepFactory().newViewEditJInternalFrame( (ICFBamDelDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDelDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DELT" ) ) {
				frame = swingSchema.getDelTopDepFactory().newViewEditJInternalFrame( (ICFBamDelTopDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDelTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DEL1" ) ) {
				frame = swingSchema.getDelSubDep1Factory().newViewEditJInternalFrame( (ICFBamDelSubDep1Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDelSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DEL2" ) ) {
				frame = swingSchema.getDelSubDep2Factory().newViewEditJInternalFrame( (ICFBamDelSubDep2Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDelSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DEL3" ) ) {
				frame = swingSchema.getDelSubDep3Factory().newViewEditJInternalFrame( (ICFBamDelSubDep3Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDelSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "IDXD" ) ) {
				frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( (ICFBamIndexObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "RELD" ) ) {
				frame = swingSchema.getRelationFactory().newViewEditJInternalFrame( (ICFBamRelationObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingRelationJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SRVM" ) ) {
				frame = swingSchema.getServerMethodFactory().newViewEditJInternalFrame( (ICFBamServerMethodObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingServerMethodJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SRVP" ) ) {
				frame = swingSchema.getServerProcFactory().newViewEditJInternalFrame( (ICFBamServerProcObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingServerProcJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SRVO" ) ) {
				frame = swingSchema.getServerObjFuncFactory().newViewEditJInternalFrame( (ICFBamServerObjFuncObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingServerObjFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SRVL" ) ) {
				frame = swingSchema.getServerListFuncFactory().newViewEditJInternalFrame( (ICFBamServerListFuncObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingServerListFuncJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "POPD" ) ) {
				frame = swingSchema.getPopDepFactory().newViewEditJInternalFrame( (ICFBamPopDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingPopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "POPT" ) ) {
				frame = swingSchema.getPopTopDepFactory().newViewEditJInternalFrame( (ICFBamPopTopDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingPopTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "POP1" ) ) {
				frame = swingSchema.getPopSubDep1Factory().newViewEditJInternalFrame( (ICFBamPopSubDep1Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingPopSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "POP2" ) ) {
				frame = swingSchema.getPopSubDep2Factory().newViewEditJInternalFrame( (ICFBamPopSubDep2Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingPopSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "POP3" ) ) {
				frame = swingSchema.getPopSubDep3Factory().newViewEditJInternalFrame( (ICFBamPopSubDep3Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingPopSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "CLRD" ) ) {
				frame = swingSchema.getClearDepFactory().newViewEditJInternalFrame( (ICFBamClearDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingClearDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "CLRT" ) ) {
				frame = swingSchema.getClearTopDepFactory().newViewEditJInternalFrame( (ICFBamClearTopDepObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingClearTopDepJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "CLR1" ) ) {
				frame = swingSchema.getClearSubDep1Factory().newViewEditJInternalFrame( (ICFBamClearSubDep1Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingClearSubDep1JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "CLR2" ) ) {
				frame = swingSchema.getClearSubDep2Factory().newViewEditJInternalFrame( (ICFBamClearSubDep2Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingClearSubDep2JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "CLR3" ) ) {
				frame = swingSchema.getClearSubDep3Factory().newViewEditJInternalFrame( (ICFBamClearSubDep3Obj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingClearSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	protected ActionAddSchemaDef actionAddSchemaDef = null;
	protected ActionAddSchemaRef actionAddSchemaRef = null;
	protected ActionAddTable actionAddTable = null;
	protected ActionAddDelTopDep actionAddDelTopDep = null;
	protected ActionAddDelSubDep1 actionAddDelSubDep1 = null;
	protected ActionAddDelSubDep2 actionAddDelSubDep2 = null;
	protected ActionAddDelSubDep3 actionAddDelSubDep3 = null;
	protected ActionAddIndex actionAddIndex = null;
	protected ActionAddRelation actionAddRelation = null;
	protected ActionAddServerMethod actionAddServerMethod = null;
	protected ActionAddServerProc actionAddServerProc = null;
	protected ActionAddServerObjFunc actionAddServerObjFunc = null;
	protected ActionAddServerListFunc actionAddServerListFunc = null;
	protected ActionAddPopTopDep actionAddPopTopDep = null;
	protected ActionAddPopSubDep1 actionAddPopSubDep1 = null;
	protected ActionAddPopSubDep2 actionAddPopSubDep2 = null;
	protected ActionAddPopSubDep3 actionAddPopSubDep3 = null;
	protected ActionAddClearTopDep actionAddClearTopDep = null;
	protected ActionAddClearSubDep1 actionAddClearSubDep1 = null;
	protected ActionAddClearSubDep2 actionAddClearSubDep2 = null;
	protected ActionAddClearSubDep3 actionAddClearSubDep3 = null;
	protected ViewSelectedActionScope actionViewSelected = null;
	protected EditSelectedActionScope actionEditSelected = null;
	protected DeleteSelectedActionScope actionDeleteSelected = null;
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


	public CFBamSwingScopeListJPanel( ICFBamSwingSchema argSchema,
		ICFLibAnyObj argContainer,
		ICFBamScopeObj argFocus,
		Collection<ICFBamScopeObj> argDataCollection,
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
		if( ( value == null ) || ( value instanceof ICFBamScopeObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamScopeObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamScopeObj getSwingFocusAsScope() {
		return( (ICFBamScopeObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsScope( ICFBamScopeObj value ) {
		setSwingFocus( value );
	}

	public class ScopeByQualNameComparator
	implements Comparator<ICFBamScopeObj>
	{
		public ScopeByQualNameComparator() {
		}

		public int compare( ICFBamScopeObj lhs, ICFBamScopeObj rhs ) {
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

	protected ScopeByQualNameComparator compareScopeByQualName = new ScopeByQualNameComparator();

	public Collection<ICFBamScopeObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamScopeObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfScope = new ICFBamScopeObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfScope = new ICFBamScopeObj[ len ];
				Iterator<ICFBamScopeObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfScope[idx++] = iter.next();
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
				Arrays.sort( arrayOfScope, compareScopeByQualName );
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
					actionAddSchemaRef = new ActionAddSchemaRef();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddSchemaRef );
						menuAdd.add( menuItem );
					}
					actionAddTable = new ActionAddTable();
					if( container instanceof ICFBamSchemaDefObj ) {
						menuItem = new JMenuItem( actionAddTable );
						menuAdd.add( menuItem );
					}
					actionAddDelTopDep = new ActionAddDelTopDep();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddDelTopDep );
						menuAdd.add( menuItem );
					}
					actionAddDelSubDep1 = new ActionAddDelSubDep1();
					if( container instanceof ICFBamDelTopDepObj ) {
						menuItem = new JMenuItem( actionAddDelSubDep1 );
						menuAdd.add( menuItem );
					}
					actionAddDelSubDep2 = new ActionAddDelSubDep2();
					if( container instanceof ICFBamDelSubDep1Obj ) {
						menuItem = new JMenuItem( actionAddDelSubDep2 );
						menuAdd.add( menuItem );
					}
					actionAddDelSubDep3 = new ActionAddDelSubDep3();
					if( container instanceof ICFBamDelSubDep2Obj ) {
						menuItem = new JMenuItem( actionAddDelSubDep3 );
						menuAdd.add( menuItem );
					}
					actionAddIndex = new ActionAddIndex();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddIndex );
						menuAdd.add( menuItem );
					}
					actionAddRelation = new ActionAddRelation();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddRelation );
						menuAdd.add( menuItem );
					}
					actionAddServerMethod = new ActionAddServerMethod();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddServerMethod );
						menuAdd.add( menuItem );
					}
					actionAddServerProc = new ActionAddServerProc();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddServerProc );
						menuAdd.add( menuItem );
					}
					actionAddServerObjFunc = new ActionAddServerObjFunc();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddServerObjFunc );
						menuAdd.add( menuItem );
					}
					actionAddServerListFunc = new ActionAddServerListFunc();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddServerListFunc );
						menuAdd.add( menuItem );
					}
					actionAddPopTopDep = new ActionAddPopTopDep();
					if( container instanceof ICFBamRelationObj ) {
						menuItem = new JMenuItem( actionAddPopTopDep );
						menuAdd.add( menuItem );
					}
					actionAddPopSubDep1 = new ActionAddPopSubDep1();
					if( container instanceof ICFBamPopTopDepObj ) {
						menuItem = new JMenuItem( actionAddPopSubDep1 );
						menuAdd.add( menuItem );
					}
					actionAddPopSubDep2 = new ActionAddPopSubDep2();
					if( container instanceof ICFBamPopSubDep1Obj ) {
						menuItem = new JMenuItem( actionAddPopSubDep2 );
						menuAdd.add( menuItem );
					}
					actionAddPopSubDep3 = new ActionAddPopSubDep3();
					if( container instanceof ICFBamPopSubDep2Obj ) {
						menuItem = new JMenuItem( actionAddPopSubDep3 );
						menuAdd.add( menuItem );
					}
					actionAddClearTopDep = new ActionAddClearTopDep();
					if( container instanceof ICFBamTableObj ) {
						menuItem = new JMenuItem( actionAddClearTopDep );
						menuAdd.add( menuItem );
					}
					actionAddClearSubDep1 = new ActionAddClearSubDep1();
					if( container instanceof ICFBamClearTopDepObj ) {
						menuItem = new JMenuItem( actionAddClearSubDep1 );
						menuAdd.add( menuItem );
					}
					actionAddClearSubDep2 = new ActionAddClearSubDep2();
					if( container instanceof ICFBamClearSubDep1Obj ) {
						menuItem = new JMenuItem( actionAddClearSubDep2 );
						menuAdd.add( menuItem );
					}
					actionAddClearSubDep3 = new ActionAddClearSubDep3();
					if( container instanceof ICFBamClearSubDep2Obj ) {
						menuItem = new JMenuItem( actionAddClearSubDep3 );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionScope();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionScope();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionScope();
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
		ICFBamScopeObj selectedObj = getSwingFocusAsScope();
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
