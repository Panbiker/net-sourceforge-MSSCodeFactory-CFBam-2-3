// Description: Java 7 Swing List of Obj JPanel implementation for DomainBase.

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
 *	CFBamSwingDomainBaseListJPanel Swing List of Obj JPanel implementation
 *	for DomainBase.
 */
public class CFBamSwingDomainBaseListJPanel
extends CFJPanel
implements ICFBamSwingDomainBaseJPanelList
{
	protected ICFBamSwingSchema swingSchema = null;
	protected Collection<ICFBamDomainBaseObj> swingDataCollection = null;
	protected ICFBamDomainBaseObj arrayOfDomainBase[] = null;
	public final static int COLID_ROW_HEADER = -1;
	public final static int COLID_OBJQUALIFIEDNAME = 0;
	public final static int COLID_OBJKIND = 1;
	public final static int COLID_ID = 2;
	public final static int COLID_DESCRIPTION = 3;
	public final static int NUM_COLS = 4;
	protected JTable swingJTable = null;
	protected class ActionAddTopDomain
	extends AbstractAction
	{
		public ActionAddTopDomain() {
			super();
			putValue( Action.NAME, "Add TopDomain..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTopDomainObj obj = schemaObj.getTopDomainTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTopDomainFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTopDomainEditObj edit = (ICFBamTopDomainEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamTldObj container = (ICFBamTldObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerTld( container );
			ICFBamSwingTopDomainJPanelCommon jpanelCommon = (ICFBamSwingTopDomainJPanelCommon)frame;
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

	protected class ActionAddDomain
	extends AbstractAction
	{
		public ActionAddDomain() {
			super();
			putValue( Action.NAME, "Add Domain..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamDomainObj obj = schemaObj.getDomainTableObj().newInstance();
			JInternalFrame frame = swingSchema.getDomainFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamDomainEditObj edit = (ICFBamDomainEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamDomainBaseObj container = (ICFBamDomainBaseObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerParentDomain( container );
			ICFBamSwingDomainJPanelCommon jpanelCommon = (ICFBamSwingDomainJPanelCommon)frame;
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

	protected class ActionAddTopProject
	extends AbstractAction
	{
		public ActionAddTopProject() {
			super();
			putValue( Action.NAME, "Add TopProject..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTopProjectObj obj = schemaObj.getTopProjectTableObj().newInstance();
			JInternalFrame frame = swingSchema.getTopProjectFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamTopProjectEditObj edit = (ICFBamTopProjectEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamDomainBaseObj container = (ICFBamDomainBaseObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerDomain( container );
			ICFBamSwingTopProjectJPanelCommon jpanelCommon = (ICFBamSwingTopProjectJPanelCommon)frame;
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

	protected class ActionAddSubProject
	extends AbstractAction
	{
		public ActionAddSubProject() {
			super();
			putValue( Action.NAME, "Add SubProject..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSubProjectObj obj = schemaObj.getSubProjectTableObj().newInstance();
			JInternalFrame frame = swingSchema.getSubProjectFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamSubProjectEditObj edit = (ICFBamSubProjectEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamTopProjectObj container = (ICFBamTopProjectObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerParentProject( container );
			ICFBamSwingSubProjectJPanelCommon jpanelCommon = (ICFBamSwingSubProjectJPanelCommon)frame;
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

	protected class ActionAddMajorVersion
	extends AbstractAction
	{
		public ActionAddMajorVersion() {
			super();
			putValue( Action.NAME, "Add MajorVersion..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamMajorVersionObj obj = schemaObj.getMajorVersionTableObj().newInstance();
			JInternalFrame frame = swingSchema.getMajorVersionFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamMajorVersionEditObj edit = (ICFBamMajorVersionEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamRealProjectObj container = (ICFBamRealProjectObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerParent( container );
			ICFBamSwingMajorVersionJPanelCommon jpanelCommon = (ICFBamSwingMajorVersionJPanelCommon)frame;
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

	protected class ActionAddMinorVersion
	extends AbstractAction
	{
		public ActionAddMinorVersion() {
			super();
			putValue( Action.NAME, "Add MinorVersion..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamMinorVersionObj obj = schemaObj.getMinorVersionTableObj().newInstance();
			JInternalFrame frame = swingSchema.getMinorVersionFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamMinorVersionEditObj edit = (ICFBamMinorVersionEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamTenantObj secTenant = schemaObj.getSecTenant();
		edit.setRequiredOwnerTenant( secTenant );
			ICFBamMajorVersionObj container = (ICFBamMajorVersionObj)( getSwingContainer() );
			if( container == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SwingContainer" );
			}
			edit.setRequiredContainerMajorVersion( container );
			ICFBamSwingMinorVersionJPanelCommon jpanelCommon = (ICFBamSwingMinorVersionJPanelCommon)frame;
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

	protected class ViewSelectedActionDomainBase
	extends AbstractAction
	{
		public ViewSelectedActionDomainBase() {
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
			ICFBamDomainBaseObj selectedInstance = getSwingFocusAsDomainBase();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "BDOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getDomainBaseFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDomainBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TDOM".equals( classCode ) ) {
					ICFBamTopDomainObj obj = (ICFBamTopDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopDomainFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTopDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DOMN".equals( classCode ) ) {
					ICFBamDomainObj obj = (ICFBamDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDomainFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "BPRJ".equals( classCode ) ) {
					ICFBamProjectBaseObj obj = (ICFBamProjectBaseObj)selectedInstance;
					JInternalFrame frame = swingSchema.getProjectBaseFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingProjectBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "RPRJ".equals( classCode ) ) {
					ICFBamRealProjectObj obj = (ICFBamRealProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRealProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRealProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TPRJ".equals( classCode ) ) {
					ICFBamTopProjectObj obj = (ICFBamTopProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTopProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SPRJ".equals( classCode ) ) {
					ICFBamSubProjectObj obj = (ICFBamSubProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSubProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSubProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "VERN".equals( classCode ) ) {
					ICFBamVersionObj obj = (ICFBamVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "MJVR".equals( classCode ) ) {
					ICFBamMajorVersionObj obj = (ICFBamMajorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMajorVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingMajorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "MNVR".equals( classCode ) ) {
					ICFBamMinorVersionObj obj = (ICFBamMinorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMinorVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingMinorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
						"ICFBamDomainBaseObj, ICFBamTopDomainObj, ICFBamDomainObj, ICFBamProjectBaseObj, ICFBamRealProjectObj, ICFBamTopProjectObj, ICFBamSubProjectObj, ICFBamVersionObj, ICFBamMajorVersionObj, ICFBamMinorVersionObj" );
				}
			}
		}
	}

	protected class EditSelectedActionDomainBase
	extends AbstractAction
	{
		public EditSelectedActionDomainBase() {
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
			ICFBamDomainBaseObj selectedInstance = getSwingFocusAsDomainBase();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "BDOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getDomainBaseFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDomainBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TDOM".equals( classCode ) ) {
					ICFBamTopDomainObj obj = (ICFBamTopDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopDomainFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTopDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "DOMN".equals( classCode ) ) {
					ICFBamDomainObj obj = (ICFBamDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDomainFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "BPRJ".equals( classCode ) ) {
					ICFBamProjectBaseObj obj = (ICFBamProjectBaseObj)selectedInstance;
					JInternalFrame frame = swingSchema.getProjectBaseFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingProjectBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "RPRJ".equals( classCode ) ) {
					ICFBamRealProjectObj obj = (ICFBamRealProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRealProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingRealProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "TPRJ".equals( classCode ) ) {
					ICFBamTopProjectObj obj = (ICFBamTopProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingTopProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "SPRJ".equals( classCode ) ) {
					ICFBamSubProjectObj obj = (ICFBamSubProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSubProjectFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingSubProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "VERN".equals( classCode ) ) {
					ICFBamVersionObj obj = (ICFBamVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "MJVR".equals( classCode ) ) {
					ICFBamMajorVersionObj obj = (ICFBamMajorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMajorVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingMajorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "MNVR".equals( classCode ) ) {
					ICFBamMinorVersionObj obj = (ICFBamMinorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMinorVersionFactory().newViewEditJInternalFrame( obj );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingMinorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
						"ICFBamDomainBaseObj, ICFBamTopDomainObj, ICFBamDomainObj, ICFBamProjectBaseObj, ICFBamRealProjectObj, ICFBamTopProjectObj, ICFBamSubProjectObj, ICFBamVersionObj, ICFBamMajorVersionObj, ICFBamMinorVersionObj" );
				}
			}
		}
	}

	protected class DeleteSelectedActionDomainBase
	extends AbstractAction
	{
		public DeleteSelectedActionDomainBase() {
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
			ICFBamDomainBaseObj selectedInstance = getSwingFocusAsDomainBase();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "BDOM".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getDomainBaseFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingDomainBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TDOM".equals( classCode ) ) {
					ICFBamTopDomainObj obj = (ICFBamTopDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopDomainFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTopDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "DOMN".equals( classCode ) ) {
					ICFBamDomainObj obj = (ICFBamDomainObj)selectedInstance;
					JInternalFrame frame = swingSchema.getDomainFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "BPRJ".equals( classCode ) ) {
					ICFBamProjectBaseObj obj = (ICFBamProjectBaseObj)selectedInstance;
					JInternalFrame frame = swingSchema.getProjectBaseFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingProjectBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "RPRJ".equals( classCode ) ) {
					ICFBamRealProjectObj obj = (ICFBamRealProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getRealProjectFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingRealProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "TPRJ".equals( classCode ) ) {
					ICFBamTopProjectObj obj = (ICFBamTopProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getTopProjectFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingTopProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "SPRJ".equals( classCode ) ) {
					ICFBamSubProjectObj obj = (ICFBamSubProjectObj)selectedInstance;
					JInternalFrame frame = swingSchema.getSubProjectFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingSubProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "VERN".equals( classCode ) ) {
					ICFBamVersionObj obj = (ICFBamVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getVersionFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "MJVR".equals( classCode ) ) {
					ICFBamMajorVersionObj obj = (ICFBamMajorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMajorVersionFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingMajorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
				else if( "MNVR".equals( classCode ) ) {
					ICFBamMinorVersionObj obj = (ICFBamMinorVersionObj)selectedInstance;
					JInternalFrame frame = swingSchema.getMinorVersionFactory().newAskDeleteJInternalFrame( obj );
					((ICFBamSwingMinorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
						"ICFBamDomainBaseObj, ICFBamTopDomainObj, ICFBamDomainObj, ICFBamProjectBaseObj, ICFBamRealProjectObj, ICFBamTopProjectObj, ICFBamSubProjectObj, ICFBamVersionObj, ICFBamMajorVersionObj, ICFBamMinorVersionObj" );
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
			if( arrayOfDomainBase != null ) {
				retval = arrayOfDomainBase.length;
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
					retval = "DomainBase";
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
				case COLID_DESCRIPTION:
					retval = "Description";
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
			if( arrayOfDomainBase == null ) {
				return( null );
			}
			int len = arrayOfDomainBase.length;
			if( row >= len ) {
				return( null );
			}
			ICFBamDomainBaseObj obj = arrayOfDomainBase[row];
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
					if( classCode.equals( "BDOM" ) ) {
						retval = "DomainBase";
					}
					else if( classCode.equals( "TDOM" ) ) {
						retval = "TopDomain";
					}
					else if( classCode.equals( "DOMN" ) ) {
						retval = "Domain";
					}
					else if( classCode.equals( "BPRJ" ) ) {
						retval = "ProjectBase";
					}
					else if( classCode.equals( "RPRJ" ) ) {
						retval = "RealProject";
					}
					else if( classCode.equals( "TPRJ" ) ) {
						retval = "TopProject";
					}
					else if( classCode.equals( "SPRJ" ) ) {
						retval = "SubProject";
					}
					else if( classCode.equals( "VERN" ) ) {
						retval = "Version";
					}
					else if( classCode.equals( "MJVR" ) ) {
						retval = "MajorVersion";
					}
					else if( classCode.equals( "MNVR" ) ) {
						retval = "MinorVersion";
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
				case COLID_DESCRIPTION:
					retval = obj.getOptionalDescription();
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

		public ListTableColumnModel() {
			super();
			addColumn( new QualifiedNameColumn() );
			addColumn( new ObjKindColumn() );
			addColumn( new IdColumn() );
			addColumn( new DescriptionColumn() );
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
			ICFBamDomainBaseObj selectedObj;
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
				if( selectedRowData instanceof ICFBamDomainBaseObj ) {
					int selectedCount = dataTable.getSelectedRowCount();
					if( selectedCount <= 0 ) {
						selectedObj = null;
					}
					else if( selectedCount == 1 ) {
						selectedObj = (ICFBamDomainBaseObj)selectedRowData;
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
						"ICFBamDomainBaseObj" );
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
			ICFBamDomainBaseObj o = (ICFBamDomainBaseObj)model.getValueAt( row, COLID_ROW_HEADER );
			if( o == null ) {
				return;
			}
			JInternalFrame frame = null;
			String classCode = o.getClassCode();
			if( classCode.equals( "BDOM" ) ) {
				frame = swingSchema.getDomainBaseFactory().newViewEditJInternalFrame( o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDomainBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TDOM" ) ) {
				frame = swingSchema.getTopDomainFactory().newViewEditJInternalFrame( (ICFBamTopDomainObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTopDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "DOMN" ) ) {
				frame = swingSchema.getDomainFactory().newViewEditJInternalFrame( (ICFBamDomainObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingDomainJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "BPRJ" ) ) {
				frame = swingSchema.getProjectBaseFactory().newViewEditJInternalFrame( (ICFBamProjectBaseObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingProjectBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "RPRJ" ) ) {
				frame = swingSchema.getRealProjectFactory().newViewEditJInternalFrame( (ICFBamRealProjectObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingRealProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "TPRJ" ) ) {
				frame = swingSchema.getTopProjectFactory().newViewEditJInternalFrame( (ICFBamTopProjectObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingTopProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "SPRJ" ) ) {
				frame = swingSchema.getSubProjectFactory().newViewEditJInternalFrame( (ICFBamSubProjectObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingSubProjectJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "VERN" ) ) {
				frame = swingSchema.getVersionFactory().newViewEditJInternalFrame( (ICFBamVersionObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "MJVR" ) ) {
				frame = swingSchema.getMajorVersionFactory().newViewEditJInternalFrame( (ICFBamMajorVersionObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingMajorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			}
			else if( classCode.equals( "MNVR" ) ) {
				frame = swingSchema.getMinorVersionFactory().newViewEditJInternalFrame( (ICFBamMinorVersionObj)o );
				frame.addInternalFrameListener( getViewEditInternalFrameListener() );
				((ICFBamSwingMinorVersionJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	protected ActionAddTopDomain actionAddTopDomain = null;
	protected ActionAddDomain actionAddDomain = null;
	protected ActionAddTopProject actionAddTopProject = null;
	protected ActionAddSubProject actionAddSubProject = null;
	protected ActionAddMajorVersion actionAddMajorVersion = null;
	protected ActionAddMinorVersion actionAddMinorVersion = null;
	protected ViewSelectedActionDomainBase actionViewSelected = null;
	protected EditSelectedActionDomainBase actionEditSelected = null;
	protected DeleteSelectedActionDomainBase actionDeleteSelected = null;
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


	public CFBamSwingDomainBaseListJPanel( ICFBamSwingSchema argSchema,
		ICFLibAnyObj argContainer,
		ICFBamDomainBaseObj argFocus,
		Collection<ICFBamDomainBaseObj> argDataCollection,
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
		if( ( value == null ) || ( value instanceof ICFBamDomainBaseObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDomainBaseObj" );
		}
		adjustListMenuBar();
	}

	public ICFBamDomainBaseObj getSwingFocusAsDomainBase() {
		return( (ICFBamDomainBaseObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsDomainBase( ICFBamDomainBaseObj value ) {
		setSwingFocus( value );
	}

	public class DomainBaseByQualNameComparator
	implements Comparator<ICFBamDomainBaseObj>
	{
		public DomainBaseByQualNameComparator() {
		}

		public int compare( ICFBamDomainBaseObj lhs, ICFBamDomainBaseObj rhs ) {
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

	protected DomainBaseByQualNameComparator compareDomainBaseByQualName = new DomainBaseByQualNameComparator();

	public Collection<ICFBamDomainBaseObj> getSwingDataCollection() {
		return( swingDataCollection );
	}

	public void setSwingDataCollection( Collection<ICFBamDomainBaseObj> value ) {
		final String S_ProcName = "setSwingDataCollection";
		swingDataCollection = value;
		if( swingDataCollection == null ) {
			arrayOfDomainBase = new ICFBamDomainBaseObj[ 0 ];
		}
		else {
			int len = value.size();
			arrayOfDomainBase = new ICFBamDomainBaseObj[ len ];
				Iterator<ICFBamDomainBaseObj> iter = swingDataCollection.iterator();
				int idx = 0;
				while( iter.hasNext() && ( idx < len ) ) {
					arrayOfDomainBase[idx++] = iter.next();
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
				Arrays.sort( arrayOfDomainBase, compareDomainBaseByQualName );
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
					actionAddTopDomain = new ActionAddTopDomain();
					if( container instanceof ICFBamTldObj ) {
						menuItem = new JMenuItem( actionAddTopDomain );
						menuAdd.add( menuItem );
					}
					actionAddDomain = new ActionAddDomain();
					if( container instanceof ICFBamDomainBaseObj ) {
						menuItem = new JMenuItem( actionAddDomain );
						menuAdd.add( menuItem );
					}
					actionAddTopProject = new ActionAddTopProject();
					if( container instanceof ICFBamDomainBaseObj ) {
						menuItem = new JMenuItem( actionAddTopProject );
						menuAdd.add( menuItem );
					}
					actionAddSubProject = new ActionAddSubProject();
					if( container instanceof ICFBamTopProjectObj ) {
						menuItem = new JMenuItem( actionAddSubProject );
						menuAdd.add( menuItem );
					}
					actionAddMajorVersion = new ActionAddMajorVersion();
					if( container instanceof ICFBamRealProjectObj ) {
						menuItem = new JMenuItem( actionAddMajorVersion );
						menuAdd.add( menuItem );
					}
					actionAddMinorVersion = new ActionAddMinorVersion();
					if( container instanceof ICFBamMajorVersionObj ) {
						menuItem = new JMenuItem( actionAddMinorVersion );
						menuAdd.add( menuItem );
					}
			if( getSwingContainer() != null ) {
				panelMenuBar.add( menuAdd );
			}
				menuSelected = new JMenu( "Selected" );
				menuSelected.setEnabled( false );
					actionViewSelected = new ViewSelectedActionDomainBase();
					menuItem = new JMenuItem( actionViewSelected );
					menuSelected.add( menuItem );
					actionEditSelected = new EditSelectedActionDomainBase();
					menuItem = new JMenuItem( actionEditSelected );
					menuSelected.add( menuItem );
					actionDeleteSelected = new DeleteSelectedActionDomainBase();
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
		ICFBamDomainBaseObj selectedObj = getSwingFocusAsDomainBase();
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
