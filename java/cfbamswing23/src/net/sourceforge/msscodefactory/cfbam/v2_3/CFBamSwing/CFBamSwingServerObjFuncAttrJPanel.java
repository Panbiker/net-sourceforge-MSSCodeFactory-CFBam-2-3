// Description: Java 7 Swing Attribute JPanel implementation for ServerObjFunc.

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
 *	CFBamSwingServerObjFuncAttrJPanel Swing Attribute JPanel implementation
 *	for ServerObjFunc.
 */
public class CFBamSwingServerObjFuncAttrJPanel
extends CFJPanel
implements ICFBamSwingServerObjFuncJPanelCommon
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
						ICFBamServerObjFuncObj cur = getSwingFocusAsServerObjFunc();
						if( cur != null ) {
							ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)cur.getEdit();
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
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			if( focus != null ) {
				ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
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
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
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

	protected class ForTableJLabel
		extends JLabel
	{
		public ForTableJLabel() {
			super();
			setText( "For Table" );
		}
	}

	protected class CallbackForTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackForTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerForTable != null ) {
						ICFBamServerObjFuncObj cur = getSwingFocusAsServerObjFunc();
						if( cur != null ) {
							ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerForTable.setReferencedObject( value );
									editObj.setRequiredContainerForTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewForTableReference
	extends AbstractAction
	{
		public ActionViewForTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			if( focus != null ) {
				ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getRequiredContainerForTable( swingIsInitializing );
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

	protected class ActionPickForTableReference
	extends AbstractAction
	{
		public ActionPickForTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getRequiredContainerForTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			Collection<ICFBamTableObj> cltn = null;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackForTableChosen() );
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

	protected class ForTableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ForTableCFJReferenceEditor() {
			super( new ActionPickForTableReference(), new ActionViewForTableReference() );
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
						ICFBamServerObjFuncObj cur = getSwingFocusAsServerObjFunc();
						if( cur != null ) {
							ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)cur.getEdit();
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
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			if( focus != null ) {
				ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
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
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
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

	protected class RetTableJLabel
		extends JLabel
	{
		public RetTableJLabel() {
			super();
			setText( "Ret Table" );
		}
	}

	protected class CallbackRetTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackRetTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupRetTable != null ) {
						ICFBamServerObjFuncObj cur = getSwingFocusAsServerObjFunc();
						if( cur != null ) {
							ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupRetTable.setReferencedObject( value );
									editObj.setOptionalLookupRetTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewRetTableReference
	extends AbstractAction
	{
		public ActionViewRetTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			if( focus != null ) {
				ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getOptionalLookupRetTable( swingIsInitializing );
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

	protected class ActionPickRetTableReference
	extends AbstractAction
	{
		public ActionPickRetTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
			ICFBamServerObjFuncEditObj editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getOptionalLookupRetTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			Collection<ICFBamTableObj> cltn = null;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackRetTableChosen() );
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

	protected class RetTableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public RetTableCFJReferenceEditor() {
			super( new ActionPickRetTableReference(), new ActionViewRetTableReference() );
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

	protected class SuffixJLabel
		extends JLabel
	{
		public SuffixJLabel() {
			super();
			setText( "Suffix" );
		}
	}

	protected class SuffixJEditor
		extends CFJStringEditor
	{
		public SuffixJEditor() {
			super();
			setMaxLen( 16 );
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

	protected class IsInstanceMethodJLabel
		extends JLabel
	{
		public IsInstanceMethodJLabel() {
			super();
			setText( "IsInstanceMethod" );
		}
	}

	protected class IsInstanceMethodJEditor
		extends CFJBoolEditor
	{
		public IsInstanceMethodJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class JMethodBodyJLabel
		extends JLabel
	{
		public JMethodBodyJLabel() {
			super();
			setText( "JMethodBody" );
		}
	}

	protected class JMethodBodyJEditor
		extends CFJTextEditor
	{
		public JMethodBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected ICFBamTenantObj swingOwnerTenantObj = null;
	protected TenantJLabel swingLabelOwnerTenant = null;
	protected TenantCFJReferenceEditor swingReferenceOwnerTenant = null;
	protected ICFBamTableObj swingContainerForTableObj = null;
	protected ForTableJLabel swingLabelContainerForTable = null;
	protected ForTableCFJReferenceEditor swingReferenceContainerForTable = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamTableObj swingLookupRetTableObj = null;
	protected RetTableJLabel swingLabelLookupRetTable = null;
	protected RetTableCFJReferenceEditor swingReferenceLookupRetTable = null;
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
	protected SuffixJLabel swingLabelSuffix = null;
	protected SuffixJEditor swingEditorSuffix = null;
	protected DefaultVisibilityJLabel swingLabelDefaultVisibility = null;
	protected DefaultVisibilityJEditor swingEditorDefaultVisibility = null;
	protected IsInstanceMethodJLabel swingLabelIsInstanceMethod = null;
	protected IsInstanceMethodJEditor swingEditorIsInstanceMethod = null;
	protected JMethodBodyJLabel swingLabelJMethodBody = null;
	protected JMethodBodyJEditor swingEditorJMethodBody = null;

	public CFBamSwingServerObjFuncAttrJPanel( ICFBamSwingSchema argSchema, ICFBamServerObjFuncObj argFocus ) {
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
		setSwingFocusAsServerObjFunc( argFocus );
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

		label = getSwingLabelContainerForTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerForTable();
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

		label = getSwingLabelLookupRetTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupRetTable();
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

		label = getSwingLabelSuffix();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSuffix();
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

		label = getSwingLabelIsInstanceMethod();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsInstanceMethod();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelJMethodBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMethodBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

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
		if( ( value == null ) || ( value instanceof ICFBamServerObjFuncObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamServerObjFuncObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamServerObjFuncObj getSwingFocusAsServerObjFunc() {
		return( (ICFBamServerObjFuncObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsServerObjFunc( ICFBamServerObjFuncObj value ) {
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

	public ICFBamTableObj getSwingContainerForTableObj() {
		if( swingContainerForTableObj == null ) {
		}
		return( swingContainerForTableObj );
	}

	public void setSwingContainerForTableObj( ICFBamTableObj value ) {
		swingContainerForTableObj = value;
	}

	public ForTableJLabel getSwingLabelContainerForTable() {
		if( swingLabelContainerForTable == null ) {
			swingLabelContainerForTable = new ForTableJLabel();
		}
		return( swingLabelContainerForTable );
	}

	public ForTableCFJReferenceEditor getSwingReferenceContainerForTable() {
		if( swingReferenceContainerForTable == null ) {
			swingReferenceContainerForTable = new ForTableCFJReferenceEditor();
		}
		return( swingReferenceContainerForTable );
	}

	public void setSwingReferenceContainerForTable( ForTableCFJReferenceEditor value ) {
		swingReferenceContainerForTable = value;
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

	public ICFBamTableObj getSwingLookupRetTableObj() {
		return( swingLookupRetTableObj );
	}

	public void setSwingLookupRetTableObj( ICFBamTableObj value ) {
		swingLookupRetTableObj = value;
	}

	public JLabel getSwingLabelLookupRetTable() {
		if( swingLabelLookupRetTable == null ) {
			swingLabelLookupRetTable = new RetTableJLabel();
		}
		return( swingLabelLookupRetTable );
	}

	public CFJReferenceEditor getSwingReferenceLookupRetTable() {
		if( swingReferenceLookupRetTable == null ) {
			swingReferenceLookupRetTable = new RetTableCFJReferenceEditor();
		}
		return( swingReferenceLookupRetTable );
	}

	public void setSwingReferenceLookupRetTable( RetTableCFJReferenceEditor value ) {
		swingReferenceLookupRetTable = value;
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

	public SuffixJLabel getSwingLabelSuffix() {
		if( swingLabelSuffix == null ) {
			swingLabelSuffix = new SuffixJLabel();
		}
		return( swingLabelSuffix );
	}

	public void setSwingLabelSuffix( SuffixJLabel value ) {
		swingLabelSuffix = value;
	}

	public SuffixJEditor getSwingEditorSuffix() {
		if( swingEditorSuffix == null ) {
			swingEditorSuffix = new SuffixJEditor();
		}
		return( swingEditorSuffix );
	}

	public void setSwingEditorSuffix( SuffixJEditor value ) {
		swingEditorSuffix = value;
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

	public IsInstanceMethodJLabel getSwingLabelIsInstanceMethod() {
		if( swingLabelIsInstanceMethod == null ) {
			swingLabelIsInstanceMethod = new IsInstanceMethodJLabel();
		}
		return( swingLabelIsInstanceMethod );
	}

	public void setSwingLabelIsInstanceMethod( IsInstanceMethodJLabel value ) {
		swingLabelIsInstanceMethod = value;
	}

	public IsInstanceMethodJEditor getSwingEditorIsInstanceMethod() {
		if( swingEditorIsInstanceMethod == null ) {
			swingEditorIsInstanceMethod = new IsInstanceMethodJEditor();
		}
		return( swingEditorIsInstanceMethod );
	}

	public void setSwingEditorIsInstanceMethod( IsInstanceMethodJEditor value ) {
		swingEditorIsInstanceMethod = value;
	}

	public JMethodBodyJLabel getSwingLabelJMethodBody() {
		if( swingLabelJMethodBody == null ) {
			swingLabelJMethodBody = new JMethodBodyJLabel();
		}
		return( swingLabelJMethodBody );
	}

	public void setSwingLabelJMethodBody( JMethodBodyJLabel value ) {
		swingLabelJMethodBody = value;
	}

	public JMethodBodyJEditor getSwingEditorJMethodBody() {
		if( swingEditorJMethodBody == null ) {
			swingEditorJMethodBody = new JMethodBodyJEditor();
		}
		return( swingEditorJMethodBody );
	}

	public void setSwingEditorJMethodBody( JMethodBodyJEditor value ) {
		swingEditorJMethodBody = value;
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

		label = getSwingLabelContainerForTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerForTable();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupRetTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupRetTable();
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

		label = getSwingLabelSuffix();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSuffix();
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

		label = getSwingLabelIsInstanceMethod();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsInstanceMethod();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelJMethodBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMethodBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

	}

	public void populateFields()
	{
		ICFBamServerObjFuncObj popObj;
		ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
		if( focus != null ) {
			popObj = (ICFBamServerObjFuncObj)(focus.getEdit());
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
			swingContainerForTableObj = null;
		}
		else {
			swingContainerForTableObj = popObj.getRequiredContainerForTable( swingIsInitializing );
		}
		if( swingReferenceContainerForTable != null ) {
			swingReferenceContainerForTable.setReferencedObject( swingContainerForTableObj );
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
			swingLookupRetTableObj = null;
		}
		else {
			swingLookupRetTableObj = popObj.getOptionalLookupRetTable( swingIsInitializing );
		}
		if( swingReferenceLookupRetTable != null ) {
			swingReferenceLookupRetTable.setReferencedObject( swingLookupRetTableObj );
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
			getSwingEditorSuffix().setStringValue( null );
		}
		else {
			getSwingEditorSuffix().setStringValue( popObj.getOptionalSuffix() );
		}

		if( popObj == null ) {
			getSwingEditorDefaultVisibility().setBooleanValue( null );
		}
		else {
			getSwingEditorDefaultVisibility().setBooleanValue( popObj.getRequiredDefaultVisibility() );
		}

		if( popObj == null ) {
			getSwingEditorIsInstanceMethod().setBooleanValue( null );
		}
		else {
			getSwingEditorIsInstanceMethod().setBooleanValue( popObj.getRequiredIsInstanceMethod() );
		}

		if( popObj == null ) {
			getSwingEditorJMethodBody().setTextValue( null );
		}
		else {
			getSwingEditorJMethodBody().setTextValue( popObj.getRequiredJMethodBody() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
		ICFBamServerObjFuncEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamServerObjFuncEditObj)(focus.getEdit());
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

		swingLookupRetTableObj = (ICFBamTableObj)( swingReferenceLookupRetTable.getReferencedObject() );
		editObj.setOptionalLookupRetTable( swingLookupRetTableObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setOptionalSuffix( getSwingEditorSuffix().getStringValue() );

		editObj.setRequiredDefaultVisibility( getSwingEditorDefaultVisibility().getBooleanValue() );

		editObj.setRequiredIsInstanceMethod( getSwingEditorIsInstanceMethod().getBooleanValue() );

		editObj.setRequiredJMethodBody( getSwingEditorJMethodBody().getTextValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamServerObjFuncEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamServerObjFuncEditObj)focus.getEdit();
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
								editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
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
							editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
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
						focus = (ICFBamServerObjFuncObj)editObj.create();
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
								editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
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
								editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
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
							editObj = (ICFBamServerObjFuncEditObj)focus.beginEdit();
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
			ICFBamServerObjFuncObj focus = getSwingFocusAsServerObjFunc();
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
		if( swingReferenceContainerForTable != null ) {
			swingReferenceContainerForTable.setEnabled( false );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupRetTable != null ) {
			swingReferenceLookupRetTable.setEnabled( isEditing );
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
		if( swingEditorSuffix != null ) {
			swingEditorSuffix.setEnabled( isEditing );
		}
		if( swingEditorDefaultVisibility != null ) {
			swingEditorDefaultVisibility.setEnabled( isEditing );
		}
		if( swingEditorIsInstanceMethod != null ) {
			swingEditorIsInstanceMethod.setEnabled( isEditing );
		}
		if( swingEditorJMethodBody != null ) {
			swingEditorJMethodBody.setEnabled( isEditing );
		}
	}
}
