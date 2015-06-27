// Description: Java 7 Swing Attribute JPanel implementation for TimeCol.

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
 *	CFBamSwingTimeColAttrJPanel Swing Attribute JPanel implementation
 *	for TimeCol.
 */
public class CFBamSwingTimeColAttrJPanel
extends CFJPanel
implements ICFBamSwingTimeColJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class TenantJLabel
		extends JLabel
	{
		public TenantJLabel() {
			super();
			setText( "Tenant" );
		}
	}

	protected class CallbackTenantChosen
	implements ICFBamSwingTenantChosen
	{
		public CallbackTenantChosen() {
		}

		public void choseTenant( ICFBamTenantObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerTenant != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerTenant.setReferencedObject( value );
									editObj.setRequiredOwnerTenant( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTenantReference
	extends AbstractAction
	{
		public ActionViewTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTenantObj referencedObj = focus.getRequiredOwnerTenant( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "TENT".equals( classCode ) ) {
						frame = swingSchema.getTenantFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamTenantObj" );
					}
				}
			}
		}
	}

	protected class ActionPickTenantReference
	extends AbstractAction
	{
		public ActionPickTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTenantObj referencedObj = focus.getRequiredOwnerTenant( swingIsInitializing );
			java.util.List<ICFBamTenantObj> listOfTenant = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfTenant = schemaObj.getTenantTableObj().readTenantByClusterIdx( containingClusterId );
			if( listOfTenant == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTenant" );
			}
			Collection<ICFBamTenantObj> cltn = listOfTenant;
			JInternalFrame frame = swingSchema.getTenantFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTenantChosen() );
			((ICFBamSwingTenantJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class TenantCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TenantCFJReferenceEditor() {
			super( new ActionPickTenantReference(), new ActionViewTenantReference() );
		}
	}

	protected class TableJLabel
		extends JLabel
	{
		public TableJLabel() {
			super();
			setText( "Containing Table" );
		}
	}

	protected class CallbackTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerTable != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerTable.setReferencedObject( value );
									editObj.setRequiredContainerTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTableReference
	extends AbstractAction
	{
		public ActionViewTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getRequiredContainerTable( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "TBLD".equals( classCode ) ) {
						frame = swingSchema.getTableFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamTableObj" );
					}
				}
			}
		}
	}

	protected class ActionPickTableReference
	extends AbstractAction
	{
		public ActionPickTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getRequiredContainerTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			Collection<ICFBamTableObj> cltn = null;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTableChosen() );
			((ICFBamSwingTableJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class TableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TableCFJReferenceEditor() {
			super( new ActionPickTableReference(), new ActionViewTableReference() );
		}
	}

	protected class DefSchemaJLabel
		extends JLabel
	{
		public DefSchemaJLabel() {
			super();
			setText( "Defining Schema Definition" );
		}
	}

	protected class CallbackDefSchemaChosen
	implements ICFBamSwingSchemaDefChosen
	{
		public CallbackDefSchemaChosen() {
		}

		public void choseSchemaDef( ICFBamSchemaDefObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupDefSchema != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupDefSchema.setReferencedObject( value );
									editObj.setOptionalLookupDefSchema( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewDefSchemaReference
	extends AbstractAction
	{
		public ActionViewDefSchemaReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSchemaDefObj referencedObj = focus.getOptionalLookupDefSchema( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SCHM".equals( classCode ) ) {
						frame = swingSchema.getSchemaDefFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamSchemaDefObj" );
					}
				}
			}
		}
	}

	protected class ActionPickDefSchemaReference
	extends AbstractAction
	{
		public ActionPickDefSchemaReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSchemaDefObj referencedObj = focus.getOptionalLookupDefSchema( swingIsInitializing );
			java.util.List<ICFBamSchemaDefObj> listOfSchemaDef = null;
			Collection<ICFBamSchemaDefObj> cltn = null;
			JInternalFrame frame = swingSchema.getSchemaDefFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackDefSchemaChosen() );
			((ICFBamSwingSchemaDefJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class DefSchemaCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public DefSchemaCFJReferenceEditor() {
			super( new ActionPickDefSchemaReference(), new ActionViewDefSchemaReference() );
		}
	}

	protected class DataScopeJLabel
		extends JLabel
	{
		public DataScopeJLabel() {
			super();
			setText( "DataScope" );
		}
	}

	protected class CallbackDataScopeChosen
	implements ICFBamSwingDataScopeChosen
	{
		public CallbackDataScopeChosen() {
		}

		public void choseDataScope( ICFBamDataScopeObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupDataScope != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupDataScope.setReferencedObject( value );
									editObj.setOptionalLookupDataScope( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewDataScopeReference
	extends AbstractAction
	{
		public ActionViewDataScopeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamDataScopeObj referencedObj = focus.getOptionalLookupDataScope( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "DSCP".equals( classCode ) ) {
						frame = swingSchema.getDataScopeFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamDataScopeObj" );
					}
				}
			}
		}
	}

	protected class ActionPickDataScopeReference
	extends AbstractAction
	{
		public ActionPickDataScopeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamDataScopeObj referencedObj = focus.getOptionalLookupDataScope( swingIsInitializing );
			java.util.List<ICFBamDataScopeObj> listOfDataScope = null;
			listOfDataScope = schemaObj.getDataScopeTableObj().readAllDataScope();
			if( listOfDataScope == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfDataScope" );
			}
			Collection<ICFBamDataScopeObj> cltn = listOfDataScope;
			JInternalFrame frame = swingSchema.getDataScopeFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackDataScopeChosen() );
			((ICFBamSwingDataScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class DataScopeCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public DataScopeCFJReferenceEditor() {
			super( new ActionPickDataScopeReference(), new ActionViewDataScopeReference() );
		}
	}

	protected class ViewAccessSecurityJLabel
		extends JLabel
	{
		public ViewAccessSecurityJLabel() {
			super();
			setText( "ViewAccessSecurity" );
		}
	}

	protected class CallbackViewAccessSecurityChosen
	implements ICFBamSwingAccessSecurityChosen
	{
		public CallbackViewAccessSecurityChosen() {
		}

		public void choseAccessSecurity( ICFBamAccessSecurityObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupVAccSec != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupVAccSec.setReferencedObject( value );
									editObj.setOptionalLookupVAccSec( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewViewAccessSecurityReference
	extends AbstractAction
	{
		public ActionViewViewAccessSecurityReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamAccessSecurityObj referencedObj = focus.getOptionalLookupVAccSec( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "ASEC".equals( classCode ) ) {
						frame = swingSchema.getAccessSecurityFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamAccessSecurityObj" );
					}
				}
			}
		}
	}

	protected class ActionPickViewAccessSecurityReference
	extends AbstractAction
	{
		public ActionPickViewAccessSecurityReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamAccessSecurityObj referencedObj = focus.getOptionalLookupVAccSec( swingIsInitializing );
			java.util.List<ICFBamAccessSecurityObj> listOfAccessSecurity = null;
			listOfAccessSecurity = schemaObj.getAccessSecurityTableObj().readAllAccessSecurity();
			if( listOfAccessSecurity == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfAccessSecurity" );
			}
			Collection<ICFBamAccessSecurityObj> cltn = listOfAccessSecurity;
			JInternalFrame frame = swingSchema.getAccessSecurityFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackViewAccessSecurityChosen() );
			((ICFBamSwingAccessSecurityJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class ViewAccessSecurityCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ViewAccessSecurityCFJReferenceEditor() {
			super( new ActionPickViewAccessSecurityReference(), new ActionViewViewAccessSecurityReference() );
		}
	}

	protected class EditAccessSecurityJLabel
		extends JLabel
	{
		public EditAccessSecurityJLabel() {
			super();
			setText( "EditAccessSecurity" );
		}
	}

	protected class CallbackEditAccessSecurityChosen
	implements ICFBamSwingAccessSecurityChosen
	{
		public CallbackEditAccessSecurityChosen() {
		}

		public void choseAccessSecurity( ICFBamAccessSecurityObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupEAccSec != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupEAccSec.setReferencedObject( value );
									editObj.setOptionalLookupEAccSec( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewEditAccessSecurityReference
	extends AbstractAction
	{
		public ActionViewEditAccessSecurityReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamAccessSecurityObj referencedObj = focus.getOptionalLookupEAccSec( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "ASEC".equals( classCode ) ) {
						frame = swingSchema.getAccessSecurityFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamAccessSecurityObj" );
					}
				}
			}
		}
	}

	protected class ActionPickEditAccessSecurityReference
	extends AbstractAction
	{
		public ActionPickEditAccessSecurityReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamAccessSecurityObj referencedObj = focus.getOptionalLookupEAccSec( swingIsInitializing );
			java.util.List<ICFBamAccessSecurityObj> listOfAccessSecurity = null;
			listOfAccessSecurity = schemaObj.getAccessSecurityTableObj().readAllAccessSecurity();
			if( listOfAccessSecurity == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfAccessSecurity" );
			}
			Collection<ICFBamAccessSecurityObj> cltn = listOfAccessSecurity;
			JInternalFrame frame = swingSchema.getAccessSecurityFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackEditAccessSecurityChosen() );
			((ICFBamSwingAccessSecurityJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class EditAccessSecurityCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public EditAccessSecurityCFJReferenceEditor() {
			super( new ActionPickEditAccessSecurityReference(), new ActionViewEditAccessSecurityReference() );
		}
	}

	protected class ViewAccessFrequencyJLabel
		extends JLabel
	{
		public ViewAccessFrequencyJLabel() {
			super();
			setText( "ViewAccessFrequency" );
		}
	}

	protected class CallbackViewAccessFrequencyChosen
	implements ICFBamSwingAccessFrequencyChosen
	{
		public CallbackViewAccessFrequencyChosen() {
		}

		public void choseAccessFrequency( ICFBamAccessFrequencyObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupVAccFreq != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupVAccFreq.setReferencedObject( value );
									editObj.setOptionalLookupVAccFreq( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewViewAccessFrequencyReference
	extends AbstractAction
	{
		public ActionViewViewAccessFrequencyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamAccessFrequencyObj referencedObj = focus.getOptionalLookupVAccFreq( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "AFRQ".equals( classCode ) ) {
						frame = swingSchema.getAccessFrequencyFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamAccessFrequencyObj" );
					}
				}
			}
		}
	}

	protected class ActionPickViewAccessFrequencyReference
	extends AbstractAction
	{
		public ActionPickViewAccessFrequencyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamAccessFrequencyObj referencedObj = focus.getOptionalLookupVAccFreq( swingIsInitializing );
			java.util.List<ICFBamAccessFrequencyObj> listOfAccessFrequency = null;
			listOfAccessFrequency = schemaObj.getAccessFrequencyTableObj().readAllAccessFrequency();
			if( listOfAccessFrequency == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfAccessFrequency" );
			}
			Collection<ICFBamAccessFrequencyObj> cltn = listOfAccessFrequency;
			JInternalFrame frame = swingSchema.getAccessFrequencyFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackViewAccessFrequencyChosen() );
			((ICFBamSwingAccessFrequencyJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class ViewAccessFrequencyCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ViewAccessFrequencyCFJReferenceEditor() {
			super( new ActionPickViewAccessFrequencyReference(), new ActionViewViewAccessFrequencyReference() );
		}
	}

	protected class EditAccessFrequencyJLabel
		extends JLabel
	{
		public EditAccessFrequencyJLabel() {
			super();
			setText( "EditAccessFrequency" );
		}
	}

	protected class CallbackEditAccessFrequencyChosen
	implements ICFBamSwingAccessFrequencyChosen
	{
		public CallbackEditAccessFrequencyChosen() {
		}

		public void choseAccessFrequency( ICFBamAccessFrequencyObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupEAccFreq != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupEAccFreq.setReferencedObject( value );
									editObj.setOptionalLookupEAccFreq( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewEditAccessFrequencyReference
	extends AbstractAction
	{
		public ActionViewEditAccessFrequencyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamAccessFrequencyObj referencedObj = focus.getOptionalLookupEAccFreq( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "AFRQ".equals( classCode ) ) {
						frame = swingSchema.getAccessFrequencyFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamAccessFrequencyObj" );
					}
				}
			}
		}
	}

	protected class ActionPickEditAccessFrequencyReference
	extends AbstractAction
	{
		public ActionPickEditAccessFrequencyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamAccessFrequencyObj referencedObj = focus.getOptionalLookupEAccFreq( swingIsInitializing );
			java.util.List<ICFBamAccessFrequencyObj> listOfAccessFrequency = null;
			listOfAccessFrequency = schemaObj.getAccessFrequencyTableObj().readAllAccessFrequency();
			if( listOfAccessFrequency == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfAccessFrequency" );
			}
			Collection<ICFBamAccessFrequencyObj> cltn = listOfAccessFrequency;
			JInternalFrame frame = swingSchema.getAccessFrequencyFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackEditAccessFrequencyChosen() );
			((ICFBamSwingAccessFrequencyJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class EditAccessFrequencyCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public EditAccessFrequencyCFJReferenceEditor() {
			super( new ActionPickEditAccessFrequencyReference(), new ActionViewEditAccessFrequencyReference() );
		}
	}

	protected class PrevJLabel
		extends JLabel
	{
		public PrevJLabel() {
			super();
			setText( "Prev" );
		}
	}

	protected class CallbackPrevChosen
	implements ICFBamSwingValueChosen
	{
		public CallbackPrevChosen() {
		}

		public void choseValue( ICFBamValueObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupPrev != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupPrev.setReferencedObject( value );
									editObj.setOptionalLookupPrev( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewPrevReference
	extends AbstractAction
	{
		public ActionViewPrevReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamValueObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "VALU".equals( classCode ) ) {
						frame = swingSchema.getValueFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
				else if( "TBLC".equals( classCode ) ) {
					ICFBamTableColObj obj = (ICFBamTableColObj)referencedObj;
					frame = swingSchema.getTableColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "ATOM".equals( classCode ) ) {
					ICFBamAtomObj obj = (ICFBamAtomObj)referencedObj;
					frame = swingSchema.getAtomFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobDefObj obj = (ICFBamBlobDefObj)referencedObj;
					frame = swingSchema.getBlobDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobColObj obj = (ICFBamBlobColObj)referencedObj;
					frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobTypeObj obj = (ICFBamBlobTypeObj)referencedObj;
					frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolDefObj obj = (ICFBamBoolDefObj)referencedObj;
					frame = swingSchema.getBoolDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolColObj obj = (ICFBamBoolColObj)referencedObj;
					frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolTypeObj obj = (ICFBamBoolTypeObj)referencedObj;
					frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16DefObj obj = (ICFBamInt16DefObj)referencedObj;
					frame = swingSchema.getInt16DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16ColObj obj = (ICFBamInt16ColObj)referencedObj;
					frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16TypeObj obj = (ICFBamInt16TypeObj)referencedObj;
					frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId16GenObj obj = (ICFBamId16GenObj)referencedObj;
					frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumDefObj obj = (ICFBamEnumDefObj)referencedObj;
					frame = swingSchema.getEnumDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumColObj obj = (ICFBamEnumColObj)referencedObj;
					frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumTypeObj obj = (ICFBamEnumTypeObj)referencedObj;
					frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32DefObj obj = (ICFBamInt32DefObj)referencedObj;
					frame = swingSchema.getInt32DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32ColObj obj = (ICFBamInt32ColObj)referencedObj;
					frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32TypeObj obj = (ICFBamInt32TypeObj)referencedObj;
					frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId32GenObj obj = (ICFBamId32GenObj)referencedObj;
					frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64DefObj obj = (ICFBamInt64DefObj)referencedObj;
					frame = swingSchema.getInt64DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64ColObj obj = (ICFBamInt64ColObj)referencedObj;
					frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64TypeObj obj = (ICFBamInt64TypeObj)referencedObj;
					frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId64GenObj obj = (ICFBamId64GenObj)referencedObj;
					frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16DefObj obj = (ICFBamUInt16DefObj)referencedObj;
					frame = swingSchema.getUInt16DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16ColObj obj = (ICFBamUInt16ColObj)referencedObj;
					frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16TypeObj obj = (ICFBamUInt16TypeObj)referencedObj;
					frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32DefObj obj = (ICFBamUInt32DefObj)referencedObj;
					frame = swingSchema.getUInt32DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32ColObj obj = (ICFBamUInt32ColObj)referencedObj;
					frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32TypeObj obj = (ICFBamUInt32TypeObj)referencedObj;
					frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64DefObj obj = (ICFBamUInt64DefObj)referencedObj;
					frame = swingSchema.getUInt64DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64ColObj obj = (ICFBamUInt64ColObj)referencedObj;
					frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)referencedObj;
					frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatDefObj obj = (ICFBamFloatDefObj)referencedObj;
					frame = swingSchema.getFloatDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatColObj obj = (ICFBamFloatColObj)referencedObj;
					frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)referencedObj;
					frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleDefObj obj = (ICFBamDoubleDefObj)referencedObj;
					frame = swingSchema.getDoubleDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleColObj obj = (ICFBamDoubleColObj)referencedObj;
					frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleTypeObj obj = (ICFBamDoubleTypeObj)referencedObj;
					frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberDefObj obj = (ICFBamNumberDefObj)referencedObj;
					frame = swingSchema.getNumberDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberColObj obj = (ICFBamNumberColObj)referencedObj;
					frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)referencedObj;
					frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringDefObj obj = (ICFBamStringDefObj)referencedObj;
					frame = swingSchema.getStringDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringColObj obj = (ICFBamStringColObj)referencedObj;
					frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringTypeObj obj = (ICFBamStringTypeObj)referencedObj;
					frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextDefObj obj = (ICFBamTextDefObj)referencedObj;
					frame = swingSchema.getTextDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextColObj obj = (ICFBamTextColObj)referencedObj;
					frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextTypeObj obj = (ICFBamTextTypeObj)referencedObj;
					frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenDefObj obj = (ICFBamNmTokenDefObj)referencedObj;
					frame = swingSchema.getNmTokenDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenColObj obj = (ICFBamNmTokenColObj)referencedObj;
					frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenTypeObj obj = (ICFBamNmTokenTypeObj)referencedObj;
					frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensDefObj obj = (ICFBamNmTokensDefObj)referencedObj;
					frame = swingSchema.getNmTokensDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensColObj obj = (ICFBamNmTokensColObj)referencedObj;
					frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensTypeObj obj = (ICFBamNmTokensTypeObj)referencedObj;
					frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenDefObj obj = (ICFBamTokenDefObj)referencedObj;
					frame = swingSchema.getTokenDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenColObj obj = (ICFBamTokenColObj)referencedObj;
					frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenTypeObj obj = (ICFBamTokenTypeObj)referencedObj;
					frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateDefObj obj = (ICFBamDateDefObj)referencedObj;
					frame = swingSchema.getDateDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateColObj obj = (ICFBamDateColObj)referencedObj;
					frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateTypeObj obj = (ICFBamDateTypeObj)referencedObj;
					frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeDefObj obj = (ICFBamTimeDefObj)referencedObj;
					frame = swingSchema.getTimeDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeColObj obj = (ICFBamTimeColObj)referencedObj;
					frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeTypeObj obj = (ICFBamTimeTypeObj)referencedObj;
					frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampDefObj obj = (ICFBamTimestampDefObj)referencedObj;
					frame = swingSchema.getTimestampDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampColObj obj = (ICFBamTimestampColObj)referencedObj;
					frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampTypeObj obj = (ICFBamTimestampTypeObj)referencedObj;
					frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateDefObj obj = (ICFBamTZDateDefObj)referencedObj;
					frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateColObj obj = (ICFBamTZDateColObj)referencedObj;
					frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateTypeObj obj = (ICFBamTZDateTypeObj)referencedObj;
					frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeDefObj obj = (ICFBamTZTimeDefObj)referencedObj;
					frame = swingSchema.getTZTimeDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeColObj obj = (ICFBamTZTimeColObj)referencedObj;
					frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)referencedObj;
					frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampDefObj obj = (ICFBamTZTimestampDefObj)referencedObj;
					frame = swingSchema.getTZTimestampDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)referencedObj;
					frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)referencedObj;
					frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidDefObj obj = (ICFBamUuidDefObj)referencedObj;
					frame = swingSchema.getUuidDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidColObj obj = (ICFBamUuidColObj)referencedObj;
					frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidTypeObj obj = (ICFBamUuidTypeObj)referencedObj;
					frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidGenObj obj = (ICFBamUuidGenObj)referencedObj;
					frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamValueObj, ICFBamTableColObj, ICFBamAtomObj, ICFBamBlobDefObj, ICFBamBlobColObj, ICFBamBlobTypeObj, ICFBamBoolDefObj, ICFBamBoolColObj, ICFBamBoolTypeObj, ICFBamInt16DefObj, ICFBamInt16ColObj, ICFBamInt16TypeObj, ICFBamId16GenObj, ICFBamEnumDefObj, ICFBamEnumColObj, ICFBamEnumTypeObj, ICFBamInt32DefObj, ICFBamInt32ColObj, ICFBamInt32TypeObj, ICFBamId32GenObj, ICFBamInt64DefObj, ICFBamInt64ColObj, ICFBamInt64TypeObj, ICFBamId64GenObj, ICFBamUInt16DefObj, ICFBamUInt16ColObj, ICFBamUInt16TypeObj, ICFBamUInt32DefObj, ICFBamUInt32ColObj, ICFBamUInt32TypeObj, ICFBamUInt64DefObj, ICFBamUInt64ColObj, ICFBamUInt64TypeObj, ICFBamFloatDefObj, ICFBamFloatColObj, ICFBamFloatTypeObj, ICFBamDoubleDefObj, ICFBamDoubleColObj, ICFBamDoubleTypeObj, ICFBamNumberDefObj, ICFBamNumberColObj, ICFBamNumberTypeObj, ICFBamStringDefObj, ICFBamStringColObj, ICFBamStringTypeObj, ICFBamTextDefObj, ICFBamTextColObj, ICFBamTextTypeObj, ICFBamNmTokenDefObj, ICFBamNmTokenColObj, ICFBamNmTokenTypeObj, ICFBamNmTokensDefObj, ICFBamNmTokensColObj, ICFBamNmTokensTypeObj, ICFBamTokenDefObj, ICFBamTokenColObj, ICFBamTokenTypeObj, ICFBamDateDefObj, ICFBamDateColObj, ICFBamDateTypeObj, ICFBamTimeDefObj, ICFBamTimeColObj, ICFBamTimeTypeObj, ICFBamTimestampDefObj, ICFBamTimestampColObj, ICFBamTimestampTypeObj, ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj, ICFBamTZTimeDefObj, ICFBamTZTimeColObj, ICFBamTZTimeTypeObj, ICFBamTZTimestampDefObj, ICFBamTZTimestampColObj, ICFBamTZTimestampTypeObj, ICFBamUuidDefObj, ICFBamUuidColObj, ICFBamUuidTypeObj, ICFBamUuidGenObj" );
					}
				}
			}
		}
	}

	protected class ActionPickPrevReference
	extends AbstractAction
	{
		public ActionPickPrevReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamValueObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
			java.util.List<ICFBamValueObj> listOfValue = null;
			Collection<ICFBamValueObj> cltn = null;
			JInternalFrame frame = swingSchema.getValueFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackPrevChosen() );
			((ICFBamSwingValueJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class PrevCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public PrevCFJReferenceEditor() {
			super( new ActionPickPrevReference(), new ActionViewPrevReference() );
		}
	}

	protected class NextJLabel
		extends JLabel
	{
		public NextJLabel() {
			super();
			setText( "Next" );
		}
	}

	protected class CallbackNextChosen
	implements ICFBamSwingValueChosen
	{
		public CallbackNextChosen() {
		}

		public void choseValue( ICFBamValueObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupNext != null ) {
						ICFBamTimeColObj cur = getSwingFocusAsTimeCol();
						if( cur != null ) {
							ICFBamTimeColEditObj editObj = (ICFBamTimeColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupNext.setReferencedObject( value );
									editObj.setOptionalLookupNext( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewNextReference
	extends AbstractAction
	{
		public ActionViewNextReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus != null ) {
				ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamValueObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "VALU".equals( classCode ) ) {
						frame = swingSchema.getValueFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
				else if( "TBLC".equals( classCode ) ) {
					ICFBamTableColObj obj = (ICFBamTableColObj)referencedObj;
					frame = swingSchema.getTableColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame myInternalFrame = (JInternalFrame)cont;
						myInternalFrame.getDesktopPane().add( frame );
						frame.setVisible( true );
						frame.show();
					}
				}
				else if( "ATOM".equals( classCode ) ) {
					ICFBamAtomObj obj = (ICFBamAtomObj)referencedObj;
					frame = swingSchema.getAtomFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobDefObj obj = (ICFBamBlobDefObj)referencedObj;
					frame = swingSchema.getBlobDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobColObj obj = (ICFBamBlobColObj)referencedObj;
					frame = swingSchema.getBlobColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBlobTypeObj obj = (ICFBamBlobTypeObj)referencedObj;
					frame = swingSchema.getBlobTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolDefObj obj = (ICFBamBoolDefObj)referencedObj;
					frame = swingSchema.getBoolDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolColObj obj = (ICFBamBoolColObj)referencedObj;
					frame = swingSchema.getBoolColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamBoolTypeObj obj = (ICFBamBoolTypeObj)referencedObj;
					frame = swingSchema.getBoolTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16DefObj obj = (ICFBamInt16DefObj)referencedObj;
					frame = swingSchema.getInt16DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16ColObj obj = (ICFBamInt16ColObj)referencedObj;
					frame = swingSchema.getInt16ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt16TypeObj obj = (ICFBamInt16TypeObj)referencedObj;
					frame = swingSchema.getInt16TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId16GenObj obj = (ICFBamId16GenObj)referencedObj;
					frame = swingSchema.getId16GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumDefObj obj = (ICFBamEnumDefObj)referencedObj;
					frame = swingSchema.getEnumDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumColObj obj = (ICFBamEnumColObj)referencedObj;
					frame = swingSchema.getEnumColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamEnumTypeObj obj = (ICFBamEnumTypeObj)referencedObj;
					frame = swingSchema.getEnumTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32DefObj obj = (ICFBamInt32DefObj)referencedObj;
					frame = swingSchema.getInt32DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32ColObj obj = (ICFBamInt32ColObj)referencedObj;
					frame = swingSchema.getInt32ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt32TypeObj obj = (ICFBamInt32TypeObj)referencedObj;
					frame = swingSchema.getInt32TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId32GenObj obj = (ICFBamId32GenObj)referencedObj;
					frame = swingSchema.getId32GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64DefObj obj = (ICFBamInt64DefObj)referencedObj;
					frame = swingSchema.getInt64DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64ColObj obj = (ICFBamInt64ColObj)referencedObj;
					frame = swingSchema.getInt64ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamInt64TypeObj obj = (ICFBamInt64TypeObj)referencedObj;
					frame = swingSchema.getInt64TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamId64GenObj obj = (ICFBamId64GenObj)referencedObj;
					frame = swingSchema.getId64GenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16DefObj obj = (ICFBamUInt16DefObj)referencedObj;
					frame = swingSchema.getUInt16DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16ColObj obj = (ICFBamUInt16ColObj)referencedObj;
					frame = swingSchema.getUInt16ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt16TypeObj obj = (ICFBamUInt16TypeObj)referencedObj;
					frame = swingSchema.getUInt16TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32DefObj obj = (ICFBamUInt32DefObj)referencedObj;
					frame = swingSchema.getUInt32DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32ColObj obj = (ICFBamUInt32ColObj)referencedObj;
					frame = swingSchema.getUInt32ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt32TypeObj obj = (ICFBamUInt32TypeObj)referencedObj;
					frame = swingSchema.getUInt32TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64DefObj obj = (ICFBamUInt64DefObj)referencedObj;
					frame = swingSchema.getUInt64DefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64ColObj obj = (ICFBamUInt64ColObj)referencedObj;
					frame = swingSchema.getUInt64ColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)referencedObj;
					frame = swingSchema.getUInt64TypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatDefObj obj = (ICFBamFloatDefObj)referencedObj;
					frame = swingSchema.getFloatDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatColObj obj = (ICFBamFloatColObj)referencedObj;
					frame = swingSchema.getFloatColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)referencedObj;
					frame = swingSchema.getFloatTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleDefObj obj = (ICFBamDoubleDefObj)referencedObj;
					frame = swingSchema.getDoubleDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleColObj obj = (ICFBamDoubleColObj)referencedObj;
					frame = swingSchema.getDoubleColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDoubleTypeObj obj = (ICFBamDoubleTypeObj)referencedObj;
					frame = swingSchema.getDoubleTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberDefObj obj = (ICFBamNumberDefObj)referencedObj;
					frame = swingSchema.getNumberDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberColObj obj = (ICFBamNumberColObj)referencedObj;
					frame = swingSchema.getNumberColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)referencedObj;
					frame = swingSchema.getNumberTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringDefObj obj = (ICFBamStringDefObj)referencedObj;
					frame = swingSchema.getStringDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringColObj obj = (ICFBamStringColObj)referencedObj;
					frame = swingSchema.getStringColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamStringTypeObj obj = (ICFBamStringTypeObj)referencedObj;
					frame = swingSchema.getStringTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextDefObj obj = (ICFBamTextDefObj)referencedObj;
					frame = swingSchema.getTextDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextColObj obj = (ICFBamTextColObj)referencedObj;
					frame = swingSchema.getTextColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTextTypeObj obj = (ICFBamTextTypeObj)referencedObj;
					frame = swingSchema.getTextTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenDefObj obj = (ICFBamNmTokenDefObj)referencedObj;
					frame = swingSchema.getNmTokenDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenColObj obj = (ICFBamNmTokenColObj)referencedObj;
					frame = swingSchema.getNmTokenColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokenTypeObj obj = (ICFBamNmTokenTypeObj)referencedObj;
					frame = swingSchema.getNmTokenTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensDefObj obj = (ICFBamNmTokensDefObj)referencedObj;
					frame = swingSchema.getNmTokensDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensColObj obj = (ICFBamNmTokensColObj)referencedObj;
					frame = swingSchema.getNmTokensColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamNmTokensTypeObj obj = (ICFBamNmTokensTypeObj)referencedObj;
					frame = swingSchema.getNmTokensTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenDefObj obj = (ICFBamTokenDefObj)referencedObj;
					frame = swingSchema.getTokenDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenColObj obj = (ICFBamTokenColObj)referencedObj;
					frame = swingSchema.getTokenColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTokenTypeObj obj = (ICFBamTokenTypeObj)referencedObj;
					frame = swingSchema.getTokenTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateDefObj obj = (ICFBamDateDefObj)referencedObj;
					frame = swingSchema.getDateDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateColObj obj = (ICFBamDateColObj)referencedObj;
					frame = swingSchema.getDateColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDateTypeObj obj = (ICFBamDateTypeObj)referencedObj;
					frame = swingSchema.getDateTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeDefObj obj = (ICFBamTimeDefObj)referencedObj;
					frame = swingSchema.getTimeDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeColObj obj = (ICFBamTimeColObj)referencedObj;
					frame = swingSchema.getTimeColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimeTypeObj obj = (ICFBamTimeTypeObj)referencedObj;
					frame = swingSchema.getTimeTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampDefObj obj = (ICFBamTimestampDefObj)referencedObj;
					frame = swingSchema.getTimestampDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampColObj obj = (ICFBamTimestampColObj)referencedObj;
					frame = swingSchema.getTimestampColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTimestampTypeObj obj = (ICFBamTimestampTypeObj)referencedObj;
					frame = swingSchema.getTimestampTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateDefObj obj = (ICFBamTZDateDefObj)referencedObj;
					frame = swingSchema.getTZDateDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateColObj obj = (ICFBamTZDateColObj)referencedObj;
					frame = swingSchema.getTZDateColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZDateTypeObj obj = (ICFBamTZDateTypeObj)referencedObj;
					frame = swingSchema.getTZDateTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeDefObj obj = (ICFBamTZTimeDefObj)referencedObj;
					frame = swingSchema.getTZTimeDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeColObj obj = (ICFBamTZTimeColObj)referencedObj;
					frame = swingSchema.getTZTimeColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)referencedObj;
					frame = swingSchema.getTZTimeTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampDefObj obj = (ICFBamTZTimestampDefObj)referencedObj;
					frame = swingSchema.getTZTimestampDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)referencedObj;
					frame = swingSchema.getTZTimestampColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)referencedObj;
					frame = swingSchema.getTZTimestampTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidDefObj obj = (ICFBamUuidDefObj)referencedObj;
					frame = swingSchema.getUuidDefFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidColObj obj = (ICFBamUuidColObj)referencedObj;
					frame = swingSchema.getUuidColFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidTypeObj obj = (ICFBamUuidTypeObj)referencedObj;
					frame = swingSchema.getUuidTypeFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamUuidGenObj obj = (ICFBamUuidGenObj)referencedObj;
					frame = swingSchema.getUuidGenFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"swingFocus",
							focus,
							"ICFBamValueObj, ICFBamTableColObj, ICFBamAtomObj, ICFBamBlobDefObj, ICFBamBlobColObj, ICFBamBlobTypeObj, ICFBamBoolDefObj, ICFBamBoolColObj, ICFBamBoolTypeObj, ICFBamInt16DefObj, ICFBamInt16ColObj, ICFBamInt16TypeObj, ICFBamId16GenObj, ICFBamEnumDefObj, ICFBamEnumColObj, ICFBamEnumTypeObj, ICFBamInt32DefObj, ICFBamInt32ColObj, ICFBamInt32TypeObj, ICFBamId32GenObj, ICFBamInt64DefObj, ICFBamInt64ColObj, ICFBamInt64TypeObj, ICFBamId64GenObj, ICFBamUInt16DefObj, ICFBamUInt16ColObj, ICFBamUInt16TypeObj, ICFBamUInt32DefObj, ICFBamUInt32ColObj, ICFBamUInt32TypeObj, ICFBamUInt64DefObj, ICFBamUInt64ColObj, ICFBamUInt64TypeObj, ICFBamFloatDefObj, ICFBamFloatColObj, ICFBamFloatTypeObj, ICFBamDoubleDefObj, ICFBamDoubleColObj, ICFBamDoubleTypeObj, ICFBamNumberDefObj, ICFBamNumberColObj, ICFBamNumberTypeObj, ICFBamStringDefObj, ICFBamStringColObj, ICFBamStringTypeObj, ICFBamTextDefObj, ICFBamTextColObj, ICFBamTextTypeObj, ICFBamNmTokenDefObj, ICFBamNmTokenColObj, ICFBamNmTokenTypeObj, ICFBamNmTokensDefObj, ICFBamNmTokensColObj, ICFBamNmTokensTypeObj, ICFBamTokenDefObj, ICFBamTokenColObj, ICFBamTokenTypeObj, ICFBamDateDefObj, ICFBamDateColObj, ICFBamDateTypeObj, ICFBamTimeDefObj, ICFBamTimeColObj, ICFBamTimeTypeObj, ICFBamTimestampDefObj, ICFBamTimestampColObj, ICFBamTimestampTypeObj, ICFBamTZDateDefObj, ICFBamTZDateColObj, ICFBamTZDateTypeObj, ICFBamTZTimeDefObj, ICFBamTZTimeColObj, ICFBamTZTimeTypeObj, ICFBamTZTimestampDefObj, ICFBamTZTimestampColObj, ICFBamTZTimestampTypeObj, ICFBamUuidDefObj, ICFBamUuidColObj, ICFBamUuidTypeObj, ICFBamUuidGenObj" );
					}
				}
			}
		}
	}

	protected class ActionPickNextReference
	extends AbstractAction
	{
		public ActionPickNextReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			ICFBamTimeColEditObj editObj  = (ICFBamTimeColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamValueObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
			java.util.List<ICFBamValueObj> listOfValue = null;
			Collection<ICFBamValueObj> cltn = null;
			JInternalFrame frame = swingSchema.getValueFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackNextChosen() );
			((ICFBamSwingValueJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class NextCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public NextCFJReferenceEditor() {
			super( new ActionPickNextReference(), new ActionViewNextReference() );
		}
	}

	protected class IdJLabel
		extends JLabel
	{
		public IdJLabel() {
			super();
			setText( "Id" );
		}
	}

	protected class IdJEditor
		extends CFJInt64Editor
	{
		public IdJEditor() {
			super();
			setMinValue( 0L );
		}
	}

	protected class NameJLabel
		extends JLabel
	{
		public NameJLabel() {
			super();
			setText( "Name" );
		}
	}

	protected class NameJEditor
		extends CFJStringEditor
	{
		public NameJEditor() {
			super();
			setMaxLen( 192 );
		}
	}

	protected class ShortNameJLabel
		extends JLabel
	{
		public ShortNameJLabel() {
			super();
			setText( "ShortName" );
		}
	}

	protected class ShortNameJEditor
		extends CFJStringEditor
	{
		public ShortNameJEditor() {
			super();
			setMaxLen( 16 );
		}
	}

	protected class LabelJLabel
		extends JLabel
	{
		public LabelJLabel() {
			super();
			setText( "Label" );
		}
	}

	protected class LabelJEditor
		extends CFJStringEditor
	{
		public LabelJEditor() {
			super();
			setMaxLen( 64 );
		}
	}

	protected class ShortDescriptionJLabel
		extends JLabel
	{
		public ShortDescriptionJLabel() {
			super();
			setText( "ShortDescription" );
		}
	}

	protected class ShortDescriptionJEditor
		extends CFJStringEditor
	{
		public ShortDescriptionJEditor() {
			super();
			setMaxLen( 128 );
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
			setMaxLen( 1023 );
		}
	}

	protected class IsNullableJLabel
		extends JLabel
	{
		public IsNullableJLabel() {
			super();
			setText( "IsNullable" );
		}
	}

	protected class IsNullableJEditor
		extends CFJBoolEditor
	{
		public IsNullableJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class GenerateIdJLabel
		extends JLabel
	{
		public GenerateIdJLabel() {
			super();
			setText( "GenerateId" );
		}
	}

	protected class GenerateIdJEditor
		extends CFJBoolEditor
	{
		public GenerateIdJEditor() {
			super();
			setIsNullable( true );
		}
	}

	protected class DefaultVisibilityJLabel
		extends JLabel
	{
		public DefaultVisibilityJLabel() {
			super();
			setText( "DefaultVisibility" );
		}
	}

	protected class DefaultVisibilityJEditor
		extends CFJBoolEditor
	{
		public DefaultVisibilityJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class DbNameJLabel
		extends JLabel
	{
		public DbNameJLabel() {
			super();
			setText( "DbName" );
		}
	}

	protected class DbNameJEditor
		extends CFJStringEditor
	{
		public DbNameJEditor() {
			super();
			setMaxLen( 32 );
		}
	}

	protected class InitValueJLabel
		extends JLabel
	{
		public InitValueJLabel() {
			super();
			setText( "InitValue" );
		}
	}

	protected class InitValueJEditor
		extends CFJTimeEditor
	{
		public InitValueJEditor() {
			super();
		}
	}

	protected class DefaultValueJLabel
		extends JLabel
	{
		public DefaultValueJLabel() {
			super();
			setText( "DefaultValue" );
		}
	}

	protected class DefaultValueJEditor
		extends CFJTimeEditor
	{
		public DefaultValueJEditor() {
			super();
		}
	}

	protected class NullValueJLabel
		extends JLabel
	{
		public NullValueJLabel() {
			super();
			setText( "NullValue" );
		}
	}

	protected class NullValueJEditor
		extends CFJTimeEditor
	{
		public NullValueJEditor() {
			super();
		}
	}

	protected class UnknownValueJLabel
		extends JLabel
	{
		public UnknownValueJLabel() {
			super();
			setText( "UnknownValue" );
		}
	}

	protected class UnknownValueJEditor
		extends CFJTimeEditor
	{
		public UnknownValueJEditor() {
			super();
		}
	}

	protected ICFBamTenantObj swingOwnerTenantObj = null;
	protected TenantJLabel swingLabelOwnerTenant = null;
	protected TenantCFJReferenceEditor swingReferenceOwnerTenant = null;
	protected ICFBamTableObj swingContainerTableObj = null;
	protected TableJLabel swingLabelContainerTable = null;
	protected TableCFJReferenceEditor swingReferenceContainerTable = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamDataScopeObj swingLookupDataScopeObj = null;
	protected DataScopeJLabel swingLabelLookupDataScope = null;
	protected DataScopeCFJReferenceEditor swingReferenceLookupDataScope = null;
	protected ICFBamAccessSecurityObj swingLookupVAccSecObj = null;
	protected ViewAccessSecurityJLabel swingLabelLookupVAccSec = null;
	protected ViewAccessSecurityCFJReferenceEditor swingReferenceLookupVAccSec = null;
	protected ICFBamAccessSecurityObj swingLookupEAccSecObj = null;
	protected EditAccessSecurityJLabel swingLabelLookupEAccSec = null;
	protected EditAccessSecurityCFJReferenceEditor swingReferenceLookupEAccSec = null;
	protected ICFBamAccessFrequencyObj swingLookupVAccFreqObj = null;
	protected ViewAccessFrequencyJLabel swingLabelLookupVAccFreq = null;
	protected ViewAccessFrequencyCFJReferenceEditor swingReferenceLookupVAccFreq = null;
	protected ICFBamAccessFrequencyObj swingLookupEAccFreqObj = null;
	protected EditAccessFrequencyJLabel swingLabelLookupEAccFreq = null;
	protected EditAccessFrequencyCFJReferenceEditor swingReferenceLookupEAccFreq = null;
	protected ICFBamValueObj swingLookupPrevObj = null;
	protected PrevJLabel swingLabelLookupPrev = null;
	protected PrevCFJReferenceEditor swingReferenceLookupPrev = null;
	protected ICFBamValueObj swingLookupNextObj = null;
	protected NextJLabel swingLabelLookupNext = null;
	protected NextCFJReferenceEditor swingReferenceLookupNext = null;
	protected IdJLabel swingLabelId = null;
	protected IdJEditor swingEditorId = null;
	protected NameJLabel swingLabelName = null;
	protected NameJEditor swingEditorName = null;
	protected ShortNameJLabel swingLabelShortName = null;
	protected ShortNameJEditor swingEditorShortName = null;
	protected LabelJLabel swingLabelLabel = null;
	protected LabelJEditor swingEditorLabel = null;
	protected ShortDescriptionJLabel swingLabelShortDescription = null;
	protected ShortDescriptionJEditor swingEditorShortDescription = null;
	protected DescriptionJLabel swingLabelDescription = null;
	protected DescriptionJEditor swingEditorDescription = null;
	protected IsNullableJLabel swingLabelIsNullable = null;
	protected IsNullableJEditor swingEditorIsNullable = null;
	protected GenerateIdJLabel swingLabelGenerateId = null;
	protected GenerateIdJEditor swingEditorGenerateId = null;
	protected DefaultVisibilityJLabel swingLabelDefaultVisibility = null;
	protected DefaultVisibilityJEditor swingEditorDefaultVisibility = null;
	protected DbNameJLabel swingLabelDbName = null;
	protected DbNameJEditor swingEditorDbName = null;
	protected InitValueJLabel swingLabelInitValue = null;
	protected InitValueJEditor swingEditorInitValue = null;
	protected DefaultValueJLabel swingLabelDefaultValue = null;
	protected DefaultValueJEditor swingEditorDefaultValue = null;
	protected NullValueJLabel swingLabelNullValue = null;
	protected NullValueJEditor swingEditorNullValue = null;
	protected UnknownValueJLabel swingLabelUnknownValue = null;
	protected UnknownValueJEditor swingEditorUnknownValue = null;

	public CFBamSwingTimeColAttrJPanel( ICFBamSwingSchema argSchema, ICFBamTimeColObj argFocus ) {
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
		setSwingFocusAsTimeCol( argFocus );
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

		label = getSwingLabelOwnerTenant();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerTenant();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerTable();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDataScope();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDataScope();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupVAccSec();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupVAccSec();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupEAccSec();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupEAccSec();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupVAccFreq();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupVAccFreq();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupEAccFreq();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupEAccFreq();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupPrev();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupPrev();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupNext();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupNext();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelShortName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorShortName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLabel();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorLabel();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelShortDescription();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorShortDescription();
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

		label = getSwingLabelIsNullable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsNullable();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelGenerateId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorGenerateId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDefaultVisibility();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDefaultVisibility();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDbName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDbName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelInitValue();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorInitValue();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDefaultValue();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDefaultValue();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelNullValue();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorNullValue();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelUnknownValue();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorUnknownValue();
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
		if( ( value == null ) || ( value instanceof ICFBamTimeColObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTimeColObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamTimeColObj getSwingFocusAsTimeCol() {
		return( (ICFBamTimeColObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsTimeCol( ICFBamTimeColObj value ) {
		setSwingFocus( value );
	}

	public ICFBamTenantObj getSwingOwnerTenantObj() {
		return( swingOwnerTenantObj );
	}

	public void setSwingOwnerTenantObj( ICFBamTenantObj value ) {
		swingOwnerTenantObj = value;
	}

	public TenantJLabel getSwingLabelOwnerTenant() {
		if( swingLabelOwnerTenant == null ) {
			swingLabelOwnerTenant = new TenantJLabel();
		}
		return( swingLabelOwnerTenant );
	}

	public CFJReferenceEditor getSwingReferenceOwnerTenant() {
		if( swingReferenceOwnerTenant == null ) {
			swingReferenceOwnerTenant = new TenantCFJReferenceEditor();
		}
		return( swingReferenceOwnerTenant );
	}

	public void setSwingReferenceOwnerTenant( TenantCFJReferenceEditor value ) {
		swingReferenceOwnerTenant = value;
	}

	public ICFBamTableObj getSwingContainerTableObj() {
		if( swingContainerTableObj == null ) {
		}
		return( swingContainerTableObj );
	}

	public void setSwingContainerTableObj( ICFBamTableObj value ) {
		swingContainerTableObj = value;
	}

	public TableJLabel getSwingLabelContainerTable() {
		if( swingLabelContainerTable == null ) {
			swingLabelContainerTable = new TableJLabel();
		}
		return( swingLabelContainerTable );
	}

	public TableCFJReferenceEditor getSwingReferenceContainerTable() {
		if( swingReferenceContainerTable == null ) {
			swingReferenceContainerTable = new TableCFJReferenceEditor();
		}
		return( swingReferenceContainerTable );
	}

	public void setSwingReferenceContainerTable( TableCFJReferenceEditor value ) {
		swingReferenceContainerTable = value;
	}

	public ICFBamSchemaDefObj getSwingLookupDefSchemaObj() {
		return( swingLookupDefSchemaObj );
	}

	public void setSwingLookupDefSchemaObj( ICFBamSchemaDefObj value ) {
		swingLookupDefSchemaObj = value;
	}

	public JLabel getSwingLabelLookupDefSchema() {
		if( swingLabelLookupDefSchema == null ) {
			swingLabelLookupDefSchema = new DefSchemaJLabel();
		}
		return( swingLabelLookupDefSchema );
	}

	public CFJReferenceEditor getSwingReferenceLookupDefSchema() {
		if( swingReferenceLookupDefSchema == null ) {
			swingReferenceLookupDefSchema = new DefSchemaCFJReferenceEditor();
		}
		return( swingReferenceLookupDefSchema );
	}

	public void setSwingReferenceLookupDefSchema( DefSchemaCFJReferenceEditor value ) {
		swingReferenceLookupDefSchema = value;
	}

	public ICFBamDataScopeObj getSwingLookupDataScopeObj() {
		return( swingLookupDataScopeObj );
	}

	public void setSwingLookupDataScopeObj( ICFBamDataScopeObj value ) {
		swingLookupDataScopeObj = value;
	}

	public JLabel getSwingLabelLookupDataScope() {
		if( swingLabelLookupDataScope == null ) {
			swingLabelLookupDataScope = new DataScopeJLabel();
		}
		return( swingLabelLookupDataScope );
	}

	public CFJReferenceEditor getSwingReferenceLookupDataScope() {
		if( swingReferenceLookupDataScope == null ) {
			swingReferenceLookupDataScope = new DataScopeCFJReferenceEditor();
		}
		return( swingReferenceLookupDataScope );
	}

	public void setSwingReferenceLookupDataScope( DataScopeCFJReferenceEditor value ) {
		swingReferenceLookupDataScope = value;
	}

	public ICFBamAccessSecurityObj getSwingLookupVAccSecObj() {
		return( swingLookupVAccSecObj );
	}

	public void setSwingLookupVAccSecObj( ICFBamAccessSecurityObj value ) {
		swingLookupVAccSecObj = value;
	}

	public JLabel getSwingLabelLookupVAccSec() {
		if( swingLabelLookupVAccSec == null ) {
			swingLabelLookupVAccSec = new ViewAccessSecurityJLabel();
		}
		return( swingLabelLookupVAccSec );
	}

	public CFJReferenceEditor getSwingReferenceLookupVAccSec() {
		if( swingReferenceLookupVAccSec == null ) {
			swingReferenceLookupVAccSec = new ViewAccessSecurityCFJReferenceEditor();
		}
		return( swingReferenceLookupVAccSec );
	}

	public void setSwingReferenceLookupVAccSec( ViewAccessSecurityCFJReferenceEditor value ) {
		swingReferenceLookupVAccSec = value;
	}

	public ICFBamAccessSecurityObj getSwingLookupEAccSecObj() {
		return( swingLookupEAccSecObj );
	}

	public void setSwingLookupEAccSecObj( ICFBamAccessSecurityObj value ) {
		swingLookupEAccSecObj = value;
	}

	public JLabel getSwingLabelLookupEAccSec() {
		if( swingLabelLookupEAccSec == null ) {
			swingLabelLookupEAccSec = new EditAccessSecurityJLabel();
		}
		return( swingLabelLookupEAccSec );
	}

	public CFJReferenceEditor getSwingReferenceLookupEAccSec() {
		if( swingReferenceLookupEAccSec == null ) {
			swingReferenceLookupEAccSec = new EditAccessSecurityCFJReferenceEditor();
		}
		return( swingReferenceLookupEAccSec );
	}

	public void setSwingReferenceLookupEAccSec( EditAccessSecurityCFJReferenceEditor value ) {
		swingReferenceLookupEAccSec = value;
	}

	public ICFBamAccessFrequencyObj getSwingLookupVAccFreqObj() {
		return( swingLookupVAccFreqObj );
	}

	public void setSwingLookupVAccFreqObj( ICFBamAccessFrequencyObj value ) {
		swingLookupVAccFreqObj = value;
	}

	public JLabel getSwingLabelLookupVAccFreq() {
		if( swingLabelLookupVAccFreq == null ) {
			swingLabelLookupVAccFreq = new ViewAccessFrequencyJLabel();
		}
		return( swingLabelLookupVAccFreq );
	}

	public CFJReferenceEditor getSwingReferenceLookupVAccFreq() {
		if( swingReferenceLookupVAccFreq == null ) {
			swingReferenceLookupVAccFreq = new ViewAccessFrequencyCFJReferenceEditor();
		}
		return( swingReferenceLookupVAccFreq );
	}

	public void setSwingReferenceLookupVAccFreq( ViewAccessFrequencyCFJReferenceEditor value ) {
		swingReferenceLookupVAccFreq = value;
	}

	public ICFBamAccessFrequencyObj getSwingLookupEAccFreqObj() {
		return( swingLookupEAccFreqObj );
	}

	public void setSwingLookupEAccFreqObj( ICFBamAccessFrequencyObj value ) {
		swingLookupEAccFreqObj = value;
	}

	public JLabel getSwingLabelLookupEAccFreq() {
		if( swingLabelLookupEAccFreq == null ) {
			swingLabelLookupEAccFreq = new EditAccessFrequencyJLabel();
		}
		return( swingLabelLookupEAccFreq );
	}

	public CFJReferenceEditor getSwingReferenceLookupEAccFreq() {
		if( swingReferenceLookupEAccFreq == null ) {
			swingReferenceLookupEAccFreq = new EditAccessFrequencyCFJReferenceEditor();
		}
		return( swingReferenceLookupEAccFreq );
	}

	public void setSwingReferenceLookupEAccFreq( EditAccessFrequencyCFJReferenceEditor value ) {
		swingReferenceLookupEAccFreq = value;
	}

	public ICFBamValueObj getSwingLookupPrevObj() {
		return( swingLookupPrevObj );
	}

	public void setSwingLookupPrevObj( ICFBamValueObj value ) {
		swingLookupPrevObj = value;
	}

	public JLabel getSwingLabelLookupPrev() {
		if( swingLabelLookupPrev == null ) {
			swingLabelLookupPrev = new PrevJLabel();
		}
		return( swingLabelLookupPrev );
	}

	public CFJReferenceEditor getSwingReferenceLookupPrev() {
		if( swingReferenceLookupPrev == null ) {
			swingReferenceLookupPrev = new PrevCFJReferenceEditor();
		}
		return( swingReferenceLookupPrev );
	}

	public void setSwingReferenceLookupPrev( PrevCFJReferenceEditor value ) {
		swingReferenceLookupPrev = value;
	}

	public ICFBamValueObj getSwingLookupNextObj() {
		return( swingLookupNextObj );
	}

	public void setSwingLookupNextObj( ICFBamValueObj value ) {
		swingLookupNextObj = value;
	}

	public JLabel getSwingLabelLookupNext() {
		if( swingLabelLookupNext == null ) {
			swingLabelLookupNext = new NextJLabel();
		}
		return( swingLabelLookupNext );
	}

	public CFJReferenceEditor getSwingReferenceLookupNext() {
		if( swingReferenceLookupNext == null ) {
			swingReferenceLookupNext = new NextCFJReferenceEditor();
		}
		return( swingReferenceLookupNext );
	}

	public void setSwingReferenceLookupNext( NextCFJReferenceEditor value ) {
		swingReferenceLookupNext = value;
	}

	public IdJLabel getSwingLabelId() {
		if( swingLabelId == null ) {
			swingLabelId = new IdJLabel();
		}
		return( swingLabelId );
	}

	public void setSwingLabelId( IdJLabel value ) {
		swingLabelId = value;
	}

	public IdJEditor getSwingEditorId() {
		if( swingEditorId == null ) {
			swingEditorId = new IdJEditor();
		}
		return( swingEditorId );
	}

	public void setSwingEditorId( IdJEditor value ) {
		swingEditorId = value;
	}

	public NameJLabel getSwingLabelName() {
		if( swingLabelName == null ) {
			swingLabelName = new NameJLabel();
		}
		return( swingLabelName );
	}

	public void setSwingLabelName( NameJLabel value ) {
		swingLabelName = value;
	}

	public NameJEditor getSwingEditorName() {
		if( swingEditorName == null ) {
			swingEditorName = new NameJEditor();
		}
		return( swingEditorName );
	}

	public void setSwingEditorName( NameJEditor value ) {
		swingEditorName = value;
	}

	public ShortNameJLabel getSwingLabelShortName() {
		if( swingLabelShortName == null ) {
			swingLabelShortName = new ShortNameJLabel();
		}
		return( swingLabelShortName );
	}

	public void setSwingLabelShortName( ShortNameJLabel value ) {
		swingLabelShortName = value;
	}

	public ShortNameJEditor getSwingEditorShortName() {
		if( swingEditorShortName == null ) {
			swingEditorShortName = new ShortNameJEditor();
		}
		return( swingEditorShortName );
	}

	public void setSwingEditorShortName( ShortNameJEditor value ) {
		swingEditorShortName = value;
	}

	public LabelJLabel getSwingLabelLabel() {
		if( swingLabelLabel == null ) {
			swingLabelLabel = new LabelJLabel();
		}
		return( swingLabelLabel );
	}

	public void setSwingLabelLabel( LabelJLabel value ) {
		swingLabelLabel = value;
	}

	public LabelJEditor getSwingEditorLabel() {
		if( swingEditorLabel == null ) {
			swingEditorLabel = new LabelJEditor();
		}
		return( swingEditorLabel );
	}

	public void setSwingEditorLabel( LabelJEditor value ) {
		swingEditorLabel = value;
	}

	public ShortDescriptionJLabel getSwingLabelShortDescription() {
		if( swingLabelShortDescription == null ) {
			swingLabelShortDescription = new ShortDescriptionJLabel();
		}
		return( swingLabelShortDescription );
	}

	public void setSwingLabelShortDescription( ShortDescriptionJLabel value ) {
		swingLabelShortDescription = value;
	}

	public ShortDescriptionJEditor getSwingEditorShortDescription() {
		if( swingEditorShortDescription == null ) {
			swingEditorShortDescription = new ShortDescriptionJEditor();
		}
		return( swingEditorShortDescription );
	}

	public void setSwingEditorShortDescription( ShortDescriptionJEditor value ) {
		swingEditorShortDescription = value;
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

	public IsNullableJLabel getSwingLabelIsNullable() {
		if( swingLabelIsNullable == null ) {
			swingLabelIsNullable = new IsNullableJLabel();
		}
		return( swingLabelIsNullable );
	}

	public void setSwingLabelIsNullable( IsNullableJLabel value ) {
		swingLabelIsNullable = value;
	}

	public IsNullableJEditor getSwingEditorIsNullable() {
		if( swingEditorIsNullable == null ) {
			swingEditorIsNullable = new IsNullableJEditor();
		}
		return( swingEditorIsNullable );
	}

	public void setSwingEditorIsNullable( IsNullableJEditor value ) {
		swingEditorIsNullable = value;
	}

	public GenerateIdJLabel getSwingLabelGenerateId() {
		if( swingLabelGenerateId == null ) {
			swingLabelGenerateId = new GenerateIdJLabel();
		}
		return( swingLabelGenerateId );
	}

	public void setSwingLabelGenerateId( GenerateIdJLabel value ) {
		swingLabelGenerateId = value;
	}

	public GenerateIdJEditor getSwingEditorGenerateId() {
		if( swingEditorGenerateId == null ) {
			swingEditorGenerateId = new GenerateIdJEditor();
		}
		return( swingEditorGenerateId );
	}

	public void setSwingEditorGenerateId( GenerateIdJEditor value ) {
		swingEditorGenerateId = value;
	}

	public DefaultVisibilityJLabel getSwingLabelDefaultVisibility() {
		if( swingLabelDefaultVisibility == null ) {
			swingLabelDefaultVisibility = new DefaultVisibilityJLabel();
		}
		return( swingLabelDefaultVisibility );
	}

	public void setSwingLabelDefaultVisibility( DefaultVisibilityJLabel value ) {
		swingLabelDefaultVisibility = value;
	}

	public DefaultVisibilityJEditor getSwingEditorDefaultVisibility() {
		if( swingEditorDefaultVisibility == null ) {
			swingEditorDefaultVisibility = new DefaultVisibilityJEditor();
		}
		return( swingEditorDefaultVisibility );
	}

	public void setSwingEditorDefaultVisibility( DefaultVisibilityJEditor value ) {
		swingEditorDefaultVisibility = value;
	}

	public DbNameJLabel getSwingLabelDbName() {
		if( swingLabelDbName == null ) {
			swingLabelDbName = new DbNameJLabel();
		}
		return( swingLabelDbName );
	}

	public void setSwingLabelDbName( DbNameJLabel value ) {
		swingLabelDbName = value;
	}

	public DbNameJEditor getSwingEditorDbName() {
		if( swingEditorDbName == null ) {
			swingEditorDbName = new DbNameJEditor();
		}
		return( swingEditorDbName );
	}

	public void setSwingEditorDbName( DbNameJEditor value ) {
		swingEditorDbName = value;
	}

	public InitValueJLabel getSwingLabelInitValue() {
		if( swingLabelInitValue == null ) {
			swingLabelInitValue = new InitValueJLabel();
		}
		return( swingLabelInitValue );
	}

	public void setSwingLabelInitValue( InitValueJLabel value ) {
		swingLabelInitValue = value;
	}

	public InitValueJEditor getSwingEditorInitValue() {
		if( swingEditorInitValue == null ) {
			swingEditorInitValue = new InitValueJEditor();
		}
		return( swingEditorInitValue );
	}

	public void setSwingEditorInitValue( InitValueJEditor value ) {
		swingEditorInitValue = value;
	}

	public DefaultValueJLabel getSwingLabelDefaultValue() {
		if( swingLabelDefaultValue == null ) {
			swingLabelDefaultValue = new DefaultValueJLabel();
		}
		return( swingLabelDefaultValue );
	}

	public void setSwingLabelDefaultValue( DefaultValueJLabel value ) {
		swingLabelDefaultValue = value;
	}

	public DefaultValueJEditor getSwingEditorDefaultValue() {
		if( swingEditorDefaultValue == null ) {
			swingEditorDefaultValue = new DefaultValueJEditor();
		}
		return( swingEditorDefaultValue );
	}

	public void setSwingEditorDefaultValue( DefaultValueJEditor value ) {
		swingEditorDefaultValue = value;
	}

	public NullValueJLabel getSwingLabelNullValue() {
		if( swingLabelNullValue == null ) {
			swingLabelNullValue = new NullValueJLabel();
		}
		return( swingLabelNullValue );
	}

	public void setSwingLabelNullValue( NullValueJLabel value ) {
		swingLabelNullValue = value;
	}

	public NullValueJEditor getSwingEditorNullValue() {
		if( swingEditorNullValue == null ) {
			swingEditorNullValue = new NullValueJEditor();
		}
		return( swingEditorNullValue );
	}

	public void setSwingEditorNullValue( NullValueJEditor value ) {
		swingEditorNullValue = value;
	}

	public UnknownValueJLabel getSwingLabelUnknownValue() {
		if( swingLabelUnknownValue == null ) {
			swingLabelUnknownValue = new UnknownValueJLabel();
		}
		return( swingLabelUnknownValue );
	}

	public void setSwingLabelUnknownValue( UnknownValueJLabel value ) {
		swingLabelUnknownValue = value;
	}

	public UnknownValueJEditor getSwingEditorUnknownValue() {
		if( swingEditorUnknownValue == null ) {
			swingEditorUnknownValue = new UnknownValueJEditor();
		}
		return( swingEditorUnknownValue );
	}

	public void setSwingEditorUnknownValue( UnknownValueJEditor value ) {
		swingEditorUnknownValue = value;
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

		label = getSwingLabelOwnerTenant();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerTenant();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerTable();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDataScope();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDataScope();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupVAccSec();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupVAccSec();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupEAccSec();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupEAccSec();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupVAccFreq();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupVAccFreq();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupEAccFreq();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupEAccFreq();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupPrev();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupPrev();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupNext();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupNext();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelShortName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorShortName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelLabel();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorLabel();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelShortDescription();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorShortDescription();
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

		label = getSwingLabelIsNullable();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsNullable();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelGenerateId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorGenerateId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelDefaultVisibility();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDefaultVisibility();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelDbName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDbName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelInitValue();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorInitValue();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelDefaultValue();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDefaultValue();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelNullValue();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorNullValue();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelUnknownValue();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorUnknownValue();
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
		ICFBamTimeColObj popObj;
		ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
		if( focus != null ) {
			popObj = (ICFBamTimeColObj)(focus.getEdit());
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
			swingOwnerTenantObj = null;
		}
		else {
			swingOwnerTenantObj = popObj.getRequiredOwnerTenant( swingIsInitializing );
		}
		if( swingReferenceOwnerTenant != null ) {
			swingReferenceOwnerTenant.setReferencedObject( swingOwnerTenantObj );
		}

		if( popObj == null ) {
			swingContainerTableObj = null;
		}
		else {
			swingContainerTableObj = popObj.getRequiredContainerTable( swingIsInitializing );
		}
		if( swingReferenceContainerTable != null ) {
			swingReferenceContainerTable.setReferencedObject( swingContainerTableObj );
		}

		if( popObj == null ) {
			swingLookupDefSchemaObj = null;
		}
		else {
			swingLookupDefSchemaObj = popObj.getOptionalLookupDefSchema( swingIsInitializing );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setReferencedObject( swingLookupDefSchemaObj );
		}

		if( popObj == null ) {
			swingLookupDataScopeObj = null;
		}
		else {
			swingLookupDataScopeObj = popObj.getOptionalLookupDataScope( swingIsInitializing );
		}
		if( swingReferenceLookupDataScope != null ) {
			swingReferenceLookupDataScope.setReferencedObject( swingLookupDataScopeObj );
		}

		if( popObj == null ) {
			swingLookupVAccSecObj = null;
		}
		else {
			swingLookupVAccSecObj = popObj.getOptionalLookupVAccSec( swingIsInitializing );
		}
		if( swingReferenceLookupVAccSec != null ) {
			swingReferenceLookupVAccSec.setReferencedObject( swingLookupVAccSecObj );
		}

		if( popObj == null ) {
			swingLookupEAccSecObj = null;
		}
		else {
			swingLookupEAccSecObj = popObj.getOptionalLookupEAccSec( swingIsInitializing );
		}
		if( swingReferenceLookupEAccSec != null ) {
			swingReferenceLookupEAccSec.setReferencedObject( swingLookupEAccSecObj );
		}

		if( popObj == null ) {
			swingLookupVAccFreqObj = null;
		}
		else {
			swingLookupVAccFreqObj = popObj.getOptionalLookupVAccFreq( swingIsInitializing );
		}
		if( swingReferenceLookupVAccFreq != null ) {
			swingReferenceLookupVAccFreq.setReferencedObject( swingLookupVAccFreqObj );
		}

		if( popObj == null ) {
			swingLookupEAccFreqObj = null;
		}
		else {
			swingLookupEAccFreqObj = popObj.getOptionalLookupEAccFreq( swingIsInitializing );
		}
		if( swingReferenceLookupEAccFreq != null ) {
			swingReferenceLookupEAccFreq.setReferencedObject( swingLookupEAccFreqObj );
		}

		if( popObj == null ) {
			swingLookupPrevObj = null;
		}
		else {
			swingLookupPrevObj = popObj.getOptionalLookupPrev( swingIsInitializing );
		}
		if( swingReferenceLookupPrev != null ) {
			swingReferenceLookupPrev.setReferencedObject( swingLookupPrevObj );
		}

		if( popObj == null ) {
			swingLookupNextObj = null;
		}
		else {
			swingLookupNextObj = popObj.getOptionalLookupNext( swingIsInitializing );
		}
		if( swingReferenceLookupNext != null ) {
			swingReferenceLookupNext.setReferencedObject( swingLookupNextObj );
		}

		if( popObj == null ) {
			getSwingEditorId().setInt64Value( null );
		}
		else {
			getSwingEditorId().setInt64Value( popObj.getRequiredId() );
		}

		if( popObj == null ) {
			getSwingEditorName().setStringValue( null );
		}
		else {
			getSwingEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getSwingEditorShortName().setStringValue( null );
		}
		else {
			getSwingEditorShortName().setStringValue( popObj.getOptionalShortName() );
		}

		if( popObj == null ) {
			getSwingEditorLabel().setStringValue( null );
		}
		else {
			getSwingEditorLabel().setStringValue( popObj.getOptionalLabel() );
		}

		if( popObj == null ) {
			getSwingEditorShortDescription().setStringValue( null );
		}
		else {
			getSwingEditorShortDescription().setStringValue( popObj.getOptionalShortDescription() );
		}

		if( popObj == null ) {
			getSwingEditorDescription().setStringValue( null );
		}
		else {
			getSwingEditorDescription().setStringValue( popObj.getOptionalDescription() );
		}

		if( popObj == null ) {
			getSwingEditorIsNullable().setBooleanValue( null );
		}
		else {
			getSwingEditorIsNullable().setBooleanValue( popObj.getRequiredIsNullable() );
		}

		if( popObj == null ) {
			getSwingEditorGenerateId().setBooleanValue( null );
		}
		else {
			getSwingEditorGenerateId().setBooleanValue( popObj.getOptionalGenerateId() );
		}

		if( popObj == null ) {
			getSwingEditorDefaultVisibility().setBooleanValue( null );
		}
		else {
			getSwingEditorDefaultVisibility().setBooleanValue( popObj.getRequiredDefaultVisibility() );
		}

		if( popObj == null ) {
			getSwingEditorDbName().setStringValue( null );
		}
		else {
			getSwingEditorDbName().setStringValue( popObj.getOptionalDbName() );
		}

		if( popObj == null ) {
			getSwingEditorInitValue().setTimeValue( null );
		}
		else {
			getSwingEditorInitValue().setTimeValue( popObj.getOptionalInitValue() );
		}

		if( popObj == null ) {
			getSwingEditorDefaultValue().setTimeValue( null );
		}
		else {
			getSwingEditorDefaultValue().setTimeValue( popObj.getOptionalDefaultValue() );
		}

		if( popObj == null ) {
			getSwingEditorNullValue().setTimeValue( null );
		}
		else {
			getSwingEditorNullValue().setTimeValue( popObj.getOptionalNullValue() );
		}

		if( popObj == null ) {
			getSwingEditorUnknownValue().setTimeValue( null );
		}
		else {
			getSwingEditorUnknownValue().setTimeValue( popObj.getOptionalUnknownValue() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
		ICFBamTimeColEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamTimeColEditObj)(focus.getEdit());
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

		swingLookupDefSchemaObj = (ICFBamSchemaDefObj)( swingReferenceLookupDefSchema.getReferencedObject() );
		editObj.setOptionalLookupDefSchema( swingLookupDefSchemaObj );

		swingLookupDataScopeObj = (ICFBamDataScopeObj)( swingReferenceLookupDataScope.getReferencedObject() );
		editObj.setOptionalLookupDataScope( swingLookupDataScopeObj );

		swingLookupVAccSecObj = (ICFBamAccessSecurityObj)( swingReferenceLookupVAccSec.getReferencedObject() );
		editObj.setOptionalLookupVAccSec( swingLookupVAccSecObj );

		swingLookupEAccSecObj = (ICFBamAccessSecurityObj)( swingReferenceLookupEAccSec.getReferencedObject() );
		editObj.setOptionalLookupEAccSec( swingLookupEAccSecObj );

		swingLookupVAccFreqObj = (ICFBamAccessFrequencyObj)( swingReferenceLookupVAccFreq.getReferencedObject() );
		editObj.setOptionalLookupVAccFreq( swingLookupVAccFreqObj );

		swingLookupEAccFreqObj = (ICFBamAccessFrequencyObj)( swingReferenceLookupEAccFreq.getReferencedObject() );
		editObj.setOptionalLookupEAccFreq( swingLookupEAccFreqObj );

		swingLookupPrevObj = (ICFBamValueObj)( swingReferenceLookupPrev.getReferencedObject() );
		editObj.setOptionalLookupPrev( swingLookupPrevObj );

		swingLookupNextObj = (ICFBamValueObj)( swingReferenceLookupNext.getReferencedObject() );
		editObj.setOptionalLookupNext( swingLookupNextObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredIsNullable( getSwingEditorIsNullable().getBooleanValue() );

		editObj.setOptionalGenerateId( getSwingEditorGenerateId().getBooleanValue() );

		editObj.setRequiredDefaultVisibility( getSwingEditorDefaultVisibility().getBooleanValue() );

		editObj.setOptionalDbName( getSwingEditorDbName().getStringValue() );

		editObj.setOptionalInitValue( getSwingEditorInitValue().getTimeValue() );

		editObj.setOptionalDefaultValue( getSwingEditorDefaultValue().getTimeValue() );

		editObj.setOptionalNullValue( getSwingEditorNullValue().getTimeValue() );

		editObj.setOptionalUnknownValue( getSwingEditorUnknownValue().getTimeValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamTimeColEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamTimeColEditObj)focus.getEdit();
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
								editObj = (ICFBamTimeColEditObj)focus.beginEdit();
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
							editObj = (ICFBamTimeColEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamTimeColEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamTimeColEditObj)focus.beginEdit();
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
						focus = (ICFBamTimeColObj)editObj.create();
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
								editObj = (ICFBamTimeColEditObj)focus.beginEdit();
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
								editObj = (ICFBamTimeColEditObj)focus.beginEdit();
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
							editObj = (ICFBamTimeColEditObj)focus.beginEdit();
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
			ICFBamTimeColObj focus = getSwingFocusAsTimeCol();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerTenant != null ) {
			swingReferenceOwnerTenant.setEnabled( false );
		}
		if( swingReferenceContainerTable != null ) {
			swingReferenceContainerTable.setEnabled( false );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupDataScope != null ) {
			swingReferenceLookupDataScope.setEnabled( isEditing );
		}
		if( swingReferenceLookupVAccSec != null ) {
			swingReferenceLookupVAccSec.setEnabled( isEditing );
		}
		if( swingReferenceLookupEAccSec != null ) {
			swingReferenceLookupEAccSec.setEnabled( isEditing );
		}
		if( swingReferenceLookupVAccFreq != null ) {
			swingReferenceLookupVAccFreq.setEnabled( isEditing );
		}
		if( swingReferenceLookupEAccFreq != null ) {
			swingReferenceLookupEAccFreq.setEnabled( isEditing );
		}
		if( swingReferenceLookupPrev != null ) {
			swingReferenceLookupPrev.setEnabled( false );
		}
		if( swingReferenceLookupNext != null ) {
			swingReferenceLookupNext.setEnabled( false );
		}
		if( swingEditorId != null ) {
			swingEditorId.setEnabled( false );
		}
		if( swingEditorName != null ) {
			swingEditorName.setEnabled( isEditing );
		}
		if( swingEditorShortName != null ) {
			swingEditorShortName.setEnabled( isEditing );
		}
		if( swingEditorLabel != null ) {
			swingEditorLabel.setEnabled( isEditing );
		}
		if( swingEditorShortDescription != null ) {
			swingEditorShortDescription.setEnabled( isEditing );
		}
		if( swingEditorDescription != null ) {
			swingEditorDescription.setEnabled( isEditing );
		}
		if( swingEditorIsNullable != null ) {
			swingEditorIsNullable.setEnabled( isEditing );
		}
		if( swingEditorGenerateId != null ) {
			swingEditorGenerateId.setEnabled( isEditing );
		}
		if( swingEditorDefaultVisibility != null ) {
			swingEditorDefaultVisibility.setEnabled( isEditing );
		}
		if( swingEditorDbName != null ) {
			swingEditorDbName.setEnabled( isEditing );
		}
		if( swingEditorInitValue != null ) {
			swingEditorInitValue.setEnabled( isEditing );
		}
		if( swingEditorDefaultValue != null ) {
			swingEditorDefaultValue.setEnabled( isEditing );
		}
		if( swingEditorNullValue != null ) {
			swingEditorNullValue.setEnabled( isEditing );
		}
		if( swingEditorUnknownValue != null ) {
			swingEditorUnknownValue.setEnabled( isEditing );
		}
	}
}
