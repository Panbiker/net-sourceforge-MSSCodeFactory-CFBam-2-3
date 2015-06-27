// Description: Java 7 Swing Attribute JPanel implementation for Relation.

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
 *	CFBamSwingRelationAttrJPanel Swing Attribute JPanel implementation
 *	for Relation.
 */
public class CFBamSwingRelationAttrJPanel
extends CFJPanel
implements ICFBamSwingRelationJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class RelTenantJLabel
		extends JLabel
	{
		public RelTenantJLabel() {
			super();
			setText( "Relation Tenant" );
		}
	}

	protected class CallbackRelTenantChosen
	implements ICFBamSwingTenantChosen
	{
		public CallbackRelTenantChosen() {
		}

		public void choseTenant( ICFBamTenantObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerRelTenant != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerRelTenant.setReferencedObject( value );
									editObj.setRequiredOwnerRelTenant( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewRelTenantReference
	extends AbstractAction
	{
		public ActionViewRelTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTenantObj referencedObj = focus.getRequiredOwnerRelTenant( swingIsInitializing );
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

	protected class ActionPickRelTenantReference
	extends AbstractAction
	{
		public ActionPickRelTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTenantObj referencedObj = focus.getRequiredOwnerRelTenant( swingIsInitializing );
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
			JInternalFrame frame = swingSchema.getTenantFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackRelTenantChosen() );
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

	protected class RelTenantCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public RelTenantCFJReferenceEditor() {
			super( new ActionPickRelTenantReference(), new ActionViewRelTenantReference() );
		}
	}

	protected class FromTableJLabel
		extends JLabel
	{
		public FromTableJLabel() {
			super();
			setText( "From Table" );
		}
	}

	protected class CallbackFromTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackFromTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerFromTable != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerFromTable.setReferencedObject( value );
									editObj.setRequiredContainerFromTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewFromTableReference
	extends AbstractAction
	{
		public ActionViewFromTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getRequiredContainerFromTable( swingIsInitializing );
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

	protected class ActionPickFromTableReference
	extends AbstractAction
	{
		public ActionPickFromTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getRequiredContainerFromTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			Collection<ICFBamTableObj> cltn = null;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackFromTableChosen() );
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

	protected class FromTableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public FromTableCFJReferenceEditor() {
			super( new ActionPickFromTableReference(), new ActionViewFromTableReference() );
		}
	}

	protected class RelationTypeJLabel
		extends JLabel
	{
		public RelationTypeJLabel() {
			super();
			setText( "Relation Type" );
		}
	}

	protected class CallbackRelationTypeChosen
	implements ICFBamSwingRelationTypeChosen
	{
		public CallbackRelationTypeChosen() {
		}

		public void choseRelationType( ICFBamRelationTypeObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupRelationType != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupRelationType.setReferencedObject( value );
									editObj.setRequiredLookupRelationType( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewRelationTypeReference
	extends AbstractAction
	{
		public ActionViewRelationTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamRelationTypeObj referencedObj = focus.getRequiredLookupRelationType( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "RLT".equals( classCode ) ) {
						frame = swingSchema.getRelationTypeFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamRelationTypeObj" );
					}
				}
			}
		}
	}

	protected class ActionPickRelationTypeReference
	extends AbstractAction
	{
		public ActionPickRelationTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamRelationTypeObj referencedObj = focus.getRequiredLookupRelationType( swingIsInitializing );
			java.util.List<ICFBamRelationTypeObj> listOfRelationType = null;
			listOfRelationType = schemaObj.getRelationTypeTableObj().readAllRelationType();
			if( listOfRelationType == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfRelationType" );
			}
			Collection<ICFBamRelationTypeObj> cltn = listOfRelationType;
			JInternalFrame frame = swingSchema.getRelationTypeFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackRelationTypeChosen() );
			((ICFBamSwingRelationTypeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class RelationTypeCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public RelationTypeCFJReferenceEditor() {
			super( new ActionPickRelationTypeReference(), new ActionViewRelationTypeReference() );
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
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
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
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
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
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
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

	protected class FromIndexJLabel
		extends JLabel
	{
		public FromIndexJLabel() {
			super();
			setText( "From Index" );
		}
	}

	protected class CallbackFromIndexChosen
	implements ICFBamSwingIndexChosen
	{
		public CallbackFromIndexChosen() {
		}

		public void choseIndex( ICFBamIndexObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupFromIndex != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupFromIndex.setReferencedObject( value );
									editObj.setRequiredLookupFromIndex( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewFromIndexReference
	extends AbstractAction
	{
		public ActionViewFromIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexObj referencedObj = focus.getRequiredLookupFromIndex( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "IDXD".equals( classCode ) ) {
						frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamIndexObj" );
					}
				}
			}
		}
	}

	protected class ActionPickFromIndexReference
	extends AbstractAction
	{
		public ActionPickFromIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexObj referencedObj = focus.getRequiredLookupFromIndex( swingIsInitializing );
			java.util.List<ICFBamIndexObj> listOfIndex = null;
			ICFBamTableObj refFromTable = focus.getRequiredContainerFromTable( swingIsInitializing );
			if( refFromTable == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a From Table before selecting a From Index",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfIndex = refFromTable.getOptionalComponentsIndex( swingIsInitializing );
			if( listOfIndex == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<ICFBamIndexObj> cltn = listOfIndex;
			JInternalFrame frame = swingSchema.getIndexFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackFromIndexChosen() );
			((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class FromIndexCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public FromIndexCFJReferenceEditor() {
			super( new ActionPickFromIndexReference(), new ActionViewFromIndexReference() );
		}
	}

	protected class ToTableJLabel
		extends JLabel
	{
		public ToTableJLabel() {
			super();
			setText( "To Table" );
		}
	}

	protected class CallbackToTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackToTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupToTable != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupToTable.setReferencedObject( value );
									editObj.setRequiredLookupToTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewToTableReference
	extends AbstractAction
	{
		public ActionViewToTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getRequiredLookupToTable( swingIsInitializing );
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

	protected class ActionPickToTableReference
	extends AbstractAction
	{
		public ActionPickToTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getRequiredLookupToTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			ICFBamTableObj refFromTable = focus.getRequiredContainerFromTable( swingIsInitializing );
			if( refFromTable == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a From Table before selecting a To Table",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			ICFBamSchemaDefObj refSchemaDef = refFromTable.getRequiredContainerSchemaDef( swingIsInitializing );
			if( refSchemaDef == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a Containing Schema Definition before selecting a To Table",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfTable = refSchemaDef.getOptionalComponentsTables( swingIsInitializing );
			if( listOfTable == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTable" );
			}
			Collection<ICFBamTableObj> cltn = listOfTable;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackToTableChosen() );
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

	protected class ToTableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ToTableCFJReferenceEditor() {
			super( new ActionPickToTableReference(), new ActionViewToTableReference() );
		}
	}

	protected class ToIndexJLabel
		extends JLabel
	{
		public ToIndexJLabel() {
			super();
			setText( "To Index" );
		}
	}

	protected class CallbackToIndexChosen
	implements ICFBamSwingIndexChosen
	{
		public CallbackToIndexChosen() {
		}

		public void choseIndex( ICFBamIndexObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupToIndex != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupToIndex.setReferencedObject( value );
									editObj.setRequiredLookupToIndex( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewToIndexReference
	extends AbstractAction
	{
		public ActionViewToIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexObj referencedObj = focus.getRequiredLookupToIndex( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "IDXD".equals( classCode ) ) {
						frame = swingSchema.getIndexFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamIndexObj" );
					}
				}
			}
		}
	}

	protected class ActionPickToIndexReference
	extends AbstractAction
	{
		public ActionPickToIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexObj referencedObj = focus.getRequiredLookupToIndex( swingIsInitializing );
			java.util.List<ICFBamIndexObj> listOfIndex = null;
			ICFBamTableObj refToTable = focus.getRequiredLookupToTable( swingIsInitializing );
			if( refToTable == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a To Table before selecting a To Index",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfIndex = refToTable.getOptionalComponentsIndex( swingIsInitializing );
			if( listOfIndex == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<ICFBamIndexObj> cltn = listOfIndex;
			JInternalFrame frame = swingSchema.getIndexFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackToIndexChosen() );
			((ICFBamSwingIndexJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class ToIndexCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ToIndexCFJReferenceEditor() {
			super( new ActionPickToIndexReference(), new ActionViewToIndexReference() );
		}
	}

	protected class NarrowedRelationJLabel
		extends JLabel
	{
		public NarrowedRelationJLabel() {
			super();
			setText( "Narrowed Relation" );
		}
	}

	protected class CallbackNarrowedRelationChosen
	implements ICFBamSwingRelationChosen
	{
		public CallbackNarrowedRelationChosen() {
		}

		public void choseRelation( ICFBamRelationObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupNarrowed != null ) {
						ICFBamRelationObj cur = getSwingFocusAsRelation();
						if( cur != null ) {
							ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupNarrowed.setReferencedObject( value );
									editObj.setOptionalLookupNarrowed( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewNarrowedRelationReference
	extends AbstractAction
	{
		public ActionViewNarrowedRelationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus != null ) {
				ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamRelationObj referencedObj = focus.getOptionalLookupNarrowed( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "RELD".equals( classCode ) ) {
						frame = swingSchema.getRelationFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamRelationObj" );
					}
				}
			}
		}
	}

	protected class ActionPickNarrowedRelationReference
	extends AbstractAction
	{
		public ActionPickNarrowedRelationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			ICFBamRelationEditObj editObj  = (ICFBamRelationEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamRelationObj referencedObj = focus.getOptionalLookupNarrowed( swingIsInitializing );
			java.util.List<ICFBamRelationObj> listOfRelation = null;
			ICFBamTableObj refFromTable = focus.getRequiredContainerFromTable( swingIsInitializing );
			if( refFromTable == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a From Table before selecting a Narrowed Relation",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfRelation = refFromTable.getOptionalComponentsRelation( swingIsInitializing );
			if( listOfRelation == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfRelation" );
			}
			Collection<ICFBamRelationObj> cltn = listOfRelation;
			JInternalFrame frame = swingSchema.getRelationFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackNarrowedRelationChosen() );
			((ICFBamSwingRelationJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class NarrowedRelationCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public NarrowedRelationCFJReferenceEditor() {
			super( new ActionPickNarrowedRelationReference(), new ActionViewNarrowedRelationReference() );
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

	protected class IsRequiredJLabel
		extends JLabel
	{
		public IsRequiredJLabel() {
			super();
			setText( "IsRequired" );
		}
	}

	protected class IsRequiredJEditor
		extends CFJBoolEditor
	{
		public IsRequiredJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class IsAbstractJLabel
		extends JLabel
	{
		public IsAbstractJLabel() {
			super();
			setText( "IsAbstract" );
		}
	}

	protected class IsAbstractJEditor
		extends CFJBoolEditor
	{
		public IsAbstractJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class IsXsdContainerJLabel
		extends JLabel
	{
		public IsXsdContainerJLabel() {
			super();
			setText( "IsXsdContainer" );
		}
	}

	protected class IsXsdContainerJEditor
		extends CFJBoolEditor
	{
		public IsXsdContainerJEditor() {
			super();
			setIsNullable( false );
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

	protected ICFBamTenantObj swingOwnerRelTenantObj = null;
	protected RelTenantJLabel swingLabelOwnerRelTenant = null;
	protected RelTenantCFJReferenceEditor swingReferenceOwnerRelTenant = null;
	protected ICFBamTableObj swingContainerFromTableObj = null;
	protected FromTableJLabel swingLabelContainerFromTable = null;
	protected FromTableCFJReferenceEditor swingReferenceContainerFromTable = null;
	protected ICFBamRelationTypeObj swingLookupRelationTypeObj = null;
	protected RelationTypeJLabel swingLabelLookupRelationType = null;
	protected RelationTypeCFJReferenceEditor swingReferenceLookupRelationType = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamIndexObj swingLookupFromIndexObj = null;
	protected FromIndexJLabel swingLabelLookupFromIndex = null;
	protected FromIndexCFJReferenceEditor swingReferenceLookupFromIndex = null;
	protected ICFBamTableObj swingLookupToTableObj = null;
	protected ToTableJLabel swingLabelLookupToTable = null;
	protected ToTableCFJReferenceEditor swingReferenceLookupToTable = null;
	protected ICFBamIndexObj swingLookupToIndexObj = null;
	protected ToIndexJLabel swingLabelLookupToIndex = null;
	protected ToIndexCFJReferenceEditor swingReferenceLookupToIndex = null;
	protected ICFBamRelationObj swingLookupNarrowedObj = null;
	protected NarrowedRelationJLabel swingLabelLookupNarrowed = null;
	protected NarrowedRelationCFJReferenceEditor swingReferenceLookupNarrowed = null;
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
	protected DbNameJLabel swingLabelDbName = null;
	protected DbNameJEditor swingEditorDbName = null;
	protected SuffixJLabel swingLabelSuffix = null;
	protected SuffixJEditor swingEditorSuffix = null;
	protected IsRequiredJLabel swingLabelIsRequired = null;
	protected IsRequiredJEditor swingEditorIsRequired = null;
	protected IsAbstractJLabel swingLabelIsAbstract = null;
	protected IsAbstractJEditor swingEditorIsAbstract = null;
	protected IsXsdContainerJLabel swingLabelIsXsdContainer = null;
	protected IsXsdContainerJEditor swingEditorIsXsdContainer = null;
	protected DefaultVisibilityJLabel swingLabelDefaultVisibility = null;
	protected DefaultVisibilityJEditor swingEditorDefaultVisibility = null;

	public CFBamSwingRelationAttrJPanel( ICFBamSwingSchema argSchema, ICFBamRelationObj argFocus ) {
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
		setSwingFocusAsRelation( argFocus );
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

		label = getSwingLabelOwnerRelTenant();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerRelTenant();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerFromTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerFromTable();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupRelationType();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupRelationType();
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

		label = getSwingLabelLookupFromIndex();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupFromIndex();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToTable();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToIndex();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToIndex();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupNarrowed();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupNarrowed();
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

		label = getSwingLabelDbName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDbName();
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

		label = getSwingLabelIsRequired();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsRequired();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelIsAbstract();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsAbstract();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelIsXsdContainer();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsXsdContainer();
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
		if( ( value == null ) || ( value instanceof ICFBamRelationObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamRelationObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamRelationObj getSwingFocusAsRelation() {
		return( (ICFBamRelationObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsRelation( ICFBamRelationObj value ) {
		setSwingFocus( value );
	}

	public ICFBamTenantObj getSwingOwnerRelTenantObj() {
		return( swingOwnerRelTenantObj );
	}

	public void setSwingOwnerRelTenantObj( ICFBamTenantObj value ) {
		swingOwnerRelTenantObj = value;
	}

	public RelTenantJLabel getSwingLabelOwnerRelTenant() {
		if( swingLabelOwnerRelTenant == null ) {
			swingLabelOwnerRelTenant = new RelTenantJLabel();
		}
		return( swingLabelOwnerRelTenant );
	}

	public CFJReferenceEditor getSwingReferenceOwnerRelTenant() {
		if( swingReferenceOwnerRelTenant == null ) {
			swingReferenceOwnerRelTenant = new RelTenantCFJReferenceEditor();
		}
		return( swingReferenceOwnerRelTenant );
	}

	public void setSwingReferenceOwnerRelTenant( RelTenantCFJReferenceEditor value ) {
		swingReferenceOwnerRelTenant = value;
	}

	public ICFBamTableObj getSwingContainerFromTableObj() {
		if( swingContainerFromTableObj == null ) {
		}
		return( swingContainerFromTableObj );
	}

	public void setSwingContainerFromTableObj( ICFBamTableObj value ) {
		swingContainerFromTableObj = value;
	}

	public FromTableJLabel getSwingLabelContainerFromTable() {
		if( swingLabelContainerFromTable == null ) {
			swingLabelContainerFromTable = new FromTableJLabel();
		}
		return( swingLabelContainerFromTable );
	}

	public FromTableCFJReferenceEditor getSwingReferenceContainerFromTable() {
		if( swingReferenceContainerFromTable == null ) {
			swingReferenceContainerFromTable = new FromTableCFJReferenceEditor();
		}
		return( swingReferenceContainerFromTable );
	}

	public void setSwingReferenceContainerFromTable( FromTableCFJReferenceEditor value ) {
		swingReferenceContainerFromTable = value;
	}

	public ICFBamRelationTypeObj getSwingLookupRelationTypeObj() {
		return( swingLookupRelationTypeObj );
	}

	public void setSwingLookupRelationTypeObj( ICFBamRelationTypeObj value ) {
		swingLookupRelationTypeObj = value;
	}

	public JLabel getSwingLabelLookupRelationType() {
		if( swingLabelLookupRelationType == null ) {
			swingLabelLookupRelationType = new RelationTypeJLabel();
		}
		return( swingLabelLookupRelationType );
	}

	public CFJReferenceEditor getSwingReferenceLookupRelationType() {
		if( swingReferenceLookupRelationType == null ) {
			swingReferenceLookupRelationType = new RelationTypeCFJReferenceEditor();
		}
		return( swingReferenceLookupRelationType );
	}

	public void setSwingReferenceLookupRelationType( RelationTypeCFJReferenceEditor value ) {
		swingReferenceLookupRelationType = value;
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

	public ICFBamIndexObj getSwingLookupFromIndexObj() {
		return( swingLookupFromIndexObj );
	}

	public void setSwingLookupFromIndexObj( ICFBamIndexObj value ) {
		swingLookupFromIndexObj = value;
	}

	public JLabel getSwingLabelLookupFromIndex() {
		if( swingLabelLookupFromIndex == null ) {
			swingLabelLookupFromIndex = new FromIndexJLabel();
		}
		return( swingLabelLookupFromIndex );
	}

	public CFJReferenceEditor getSwingReferenceLookupFromIndex() {
		if( swingReferenceLookupFromIndex == null ) {
			swingReferenceLookupFromIndex = new FromIndexCFJReferenceEditor();
		}
		return( swingReferenceLookupFromIndex );
	}

	public void setSwingReferenceLookupFromIndex( FromIndexCFJReferenceEditor value ) {
		swingReferenceLookupFromIndex = value;
	}

	public ICFBamTableObj getSwingLookupToTableObj() {
		return( swingLookupToTableObj );
	}

	public void setSwingLookupToTableObj( ICFBamTableObj value ) {
		swingLookupToTableObj = value;
	}

	public JLabel getSwingLabelLookupToTable() {
		if( swingLabelLookupToTable == null ) {
			swingLabelLookupToTable = new ToTableJLabel();
		}
		return( swingLabelLookupToTable );
	}

	public CFJReferenceEditor getSwingReferenceLookupToTable() {
		if( swingReferenceLookupToTable == null ) {
			swingReferenceLookupToTable = new ToTableCFJReferenceEditor();
		}
		return( swingReferenceLookupToTable );
	}

	public void setSwingReferenceLookupToTable( ToTableCFJReferenceEditor value ) {
		swingReferenceLookupToTable = value;
	}

	public ICFBamIndexObj getSwingLookupToIndexObj() {
		return( swingLookupToIndexObj );
	}

	public void setSwingLookupToIndexObj( ICFBamIndexObj value ) {
		swingLookupToIndexObj = value;
	}

	public JLabel getSwingLabelLookupToIndex() {
		if( swingLabelLookupToIndex == null ) {
			swingLabelLookupToIndex = new ToIndexJLabel();
		}
		return( swingLabelLookupToIndex );
	}

	public CFJReferenceEditor getSwingReferenceLookupToIndex() {
		if( swingReferenceLookupToIndex == null ) {
			swingReferenceLookupToIndex = new ToIndexCFJReferenceEditor();
		}
		return( swingReferenceLookupToIndex );
	}

	public void setSwingReferenceLookupToIndex( ToIndexCFJReferenceEditor value ) {
		swingReferenceLookupToIndex = value;
	}

	public ICFBamRelationObj getSwingLookupNarrowedObj() {
		return( swingLookupNarrowedObj );
	}

	public void setSwingLookupNarrowedObj( ICFBamRelationObj value ) {
		swingLookupNarrowedObj = value;
	}

	public JLabel getSwingLabelLookupNarrowed() {
		if( swingLabelLookupNarrowed == null ) {
			swingLabelLookupNarrowed = new NarrowedRelationJLabel();
		}
		return( swingLabelLookupNarrowed );
	}

	public CFJReferenceEditor getSwingReferenceLookupNarrowed() {
		if( swingReferenceLookupNarrowed == null ) {
			swingReferenceLookupNarrowed = new NarrowedRelationCFJReferenceEditor();
		}
		return( swingReferenceLookupNarrowed );
	}

	public void setSwingReferenceLookupNarrowed( NarrowedRelationCFJReferenceEditor value ) {
		swingReferenceLookupNarrowed = value;
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

	public IsRequiredJLabel getSwingLabelIsRequired() {
		if( swingLabelIsRequired == null ) {
			swingLabelIsRequired = new IsRequiredJLabel();
		}
		return( swingLabelIsRequired );
	}

	public void setSwingLabelIsRequired( IsRequiredJLabel value ) {
		swingLabelIsRequired = value;
	}

	public IsRequiredJEditor getSwingEditorIsRequired() {
		if( swingEditorIsRequired == null ) {
			swingEditorIsRequired = new IsRequiredJEditor();
		}
		return( swingEditorIsRequired );
	}

	public void setSwingEditorIsRequired( IsRequiredJEditor value ) {
		swingEditorIsRequired = value;
	}

	public IsAbstractJLabel getSwingLabelIsAbstract() {
		if( swingLabelIsAbstract == null ) {
			swingLabelIsAbstract = new IsAbstractJLabel();
		}
		return( swingLabelIsAbstract );
	}

	public void setSwingLabelIsAbstract( IsAbstractJLabel value ) {
		swingLabelIsAbstract = value;
	}

	public IsAbstractJEditor getSwingEditorIsAbstract() {
		if( swingEditorIsAbstract == null ) {
			swingEditorIsAbstract = new IsAbstractJEditor();
		}
		return( swingEditorIsAbstract );
	}

	public void setSwingEditorIsAbstract( IsAbstractJEditor value ) {
		swingEditorIsAbstract = value;
	}

	public IsXsdContainerJLabel getSwingLabelIsXsdContainer() {
		if( swingLabelIsXsdContainer == null ) {
			swingLabelIsXsdContainer = new IsXsdContainerJLabel();
		}
		return( swingLabelIsXsdContainer );
	}

	public void setSwingLabelIsXsdContainer( IsXsdContainerJLabel value ) {
		swingLabelIsXsdContainer = value;
	}

	public IsXsdContainerJEditor getSwingEditorIsXsdContainer() {
		if( swingEditorIsXsdContainer == null ) {
			swingEditorIsXsdContainer = new IsXsdContainerJEditor();
		}
		return( swingEditorIsXsdContainer );
	}

	public void setSwingEditorIsXsdContainer( IsXsdContainerJEditor value ) {
		swingEditorIsXsdContainer = value;
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

		label = getSwingLabelOwnerRelTenant();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerRelTenant();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerFromTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerFromTable();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupRelationType();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupRelationType();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupFromIndex();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupFromIndex();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToTable();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToIndex();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToIndex();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupNarrowed();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupNarrowed();
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

		label = getSwingLabelIsRequired();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsRequired();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelIsAbstract();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsAbstract();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelIsXsdContainer();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsXsdContainer();
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

	}

	public void populateFields()
	{
		ICFBamRelationObj popObj;
		ICFBamRelationObj focus = getSwingFocusAsRelation();
		if( focus != null ) {
			popObj = (ICFBamRelationObj)(focus.getEdit());
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
			swingOwnerRelTenantObj = null;
		}
		else {
			swingOwnerRelTenantObj = popObj.getRequiredOwnerRelTenant( swingIsInitializing );
		}
		if( swingReferenceOwnerRelTenant != null ) {
			swingReferenceOwnerRelTenant.setReferencedObject( swingOwnerRelTenantObj );
		}

		if( popObj == null ) {
			swingContainerFromTableObj = null;
		}
		else {
			swingContainerFromTableObj = popObj.getRequiredContainerFromTable( swingIsInitializing );
		}
		if( swingReferenceContainerFromTable != null ) {
			swingReferenceContainerFromTable.setReferencedObject( swingContainerFromTableObj );
		}

		if( popObj == null ) {
			swingLookupRelationTypeObj = null;
		}
		else {
			swingLookupRelationTypeObj = popObj.getRequiredLookupRelationType( swingIsInitializing );
		}
		if( swingReferenceLookupRelationType != null ) {
			swingReferenceLookupRelationType.setReferencedObject( swingLookupRelationTypeObj );
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
			swingLookupFromIndexObj = null;
		}
		else {
			swingLookupFromIndexObj = popObj.getRequiredLookupFromIndex( swingIsInitializing );
		}
		if( swingReferenceLookupFromIndex != null ) {
			swingReferenceLookupFromIndex.setReferencedObject( swingLookupFromIndexObj );
		}

		if( popObj == null ) {
			swingLookupToTableObj = null;
		}
		else {
			swingLookupToTableObj = popObj.getRequiredLookupToTable( swingIsInitializing );
		}
		if( swingReferenceLookupToTable != null ) {
			swingReferenceLookupToTable.setReferencedObject( swingLookupToTableObj );
		}

		if( popObj == null ) {
			swingLookupToIndexObj = null;
		}
		else {
			swingLookupToIndexObj = popObj.getRequiredLookupToIndex( swingIsInitializing );
		}
		if( swingReferenceLookupToIndex != null ) {
			swingReferenceLookupToIndex.setReferencedObject( swingLookupToIndexObj );
		}

		if( popObj == null ) {
			swingLookupNarrowedObj = null;
		}
		else {
			swingLookupNarrowedObj = popObj.getOptionalLookupNarrowed( swingIsInitializing );
		}
		if( swingReferenceLookupNarrowed != null ) {
			swingReferenceLookupNarrowed.setReferencedObject( swingLookupNarrowedObj );
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
			getSwingEditorDbName().setStringValue( null );
		}
		else {
			getSwingEditorDbName().setStringValue( popObj.getOptionalDbName() );
		}

		if( popObj == null ) {
			getSwingEditorSuffix().setStringValue( null );
		}
		else {
			getSwingEditorSuffix().setStringValue( popObj.getOptionalSuffix() );
		}

		if( popObj == null ) {
			getSwingEditorIsRequired().setBooleanValue( null );
		}
		else {
			getSwingEditorIsRequired().setBooleanValue( popObj.getRequiredIsRequired() );
		}

		if( popObj == null ) {
			getSwingEditorIsAbstract().setBooleanValue( null );
		}
		else {
			getSwingEditorIsAbstract().setBooleanValue( popObj.getRequiredIsAbstract() );
		}

		if( popObj == null ) {
			getSwingEditorIsXsdContainer().setBooleanValue( null );
		}
		else {
			getSwingEditorIsXsdContainer().setBooleanValue( popObj.getRequiredIsXsdContainer() );
		}

		if( popObj == null ) {
			getSwingEditorDefaultVisibility().setBooleanValue( null );
		}
		else {
			getSwingEditorDefaultVisibility().setBooleanValue( popObj.getRequiredDefaultVisibility() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamRelationObj focus = getSwingFocusAsRelation();
		ICFBamRelationEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamRelationEditObj)(focus.getEdit());
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

		swingLookupRelationTypeObj = (ICFBamRelationTypeObj)( swingReferenceLookupRelationType.getReferencedObject() );
		editObj.setRequiredLookupRelationType( swingLookupRelationTypeObj );

		swingLookupDefSchemaObj = (ICFBamSchemaDefObj)( swingReferenceLookupDefSchema.getReferencedObject() );
		editObj.setOptionalLookupDefSchema( swingLookupDefSchemaObj );

		swingLookupFromIndexObj = (ICFBamIndexObj)( swingReferenceLookupFromIndex.getReferencedObject() );
		editObj.setRequiredLookupFromIndex( swingLookupFromIndexObj );

		swingLookupToTableObj = (ICFBamTableObj)( swingReferenceLookupToTable.getReferencedObject() );
		editObj.setRequiredLookupToTable( swingLookupToTableObj );

		swingLookupToIndexObj = (ICFBamIndexObj)( swingReferenceLookupToIndex.getReferencedObject() );
		editObj.setRequiredLookupToIndex( swingLookupToIndexObj );

		swingLookupNarrowedObj = (ICFBamRelationObj)( swingReferenceLookupNarrowed.getReferencedObject() );
		editObj.setOptionalLookupNarrowed( swingLookupNarrowedObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setOptionalDbName( getSwingEditorDbName().getStringValue() );

		editObj.setOptionalSuffix( getSwingEditorSuffix().getStringValue() );

		editObj.setRequiredIsRequired( getSwingEditorIsRequired().getBooleanValue() );

		editObj.setRequiredIsAbstract( getSwingEditorIsAbstract().getBooleanValue() );

		editObj.setRequiredIsXsdContainer( getSwingEditorIsXsdContainer().getBooleanValue() );

		editObj.setRequiredDefaultVisibility( getSwingEditorDefaultVisibility().getBooleanValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamRelationObj focus = getSwingFocusAsRelation();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamRelationEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamRelationEditObj)focus.getEdit();
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
								editObj = (ICFBamRelationEditObj)focus.beginEdit();
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
							editObj = (ICFBamRelationEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamRelationEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamRelationEditObj)focus.beginEdit();
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
						focus = (ICFBamRelationObj)editObj.create();
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
								editObj = (ICFBamRelationEditObj)focus.beginEdit();
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
								editObj = (ICFBamRelationEditObj)focus.beginEdit();
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
							editObj = (ICFBamRelationEditObj)focus.beginEdit();
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
			ICFBamRelationObj focus = getSwingFocusAsRelation();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerRelTenant != null ) {
			swingReferenceOwnerRelTenant.setEnabled( false );
		}
		if( swingReferenceContainerFromTable != null ) {
			swingReferenceContainerFromTable.setEnabled( false );
		}
		if( swingReferenceLookupRelationType != null ) {
			swingReferenceLookupRelationType.setEnabled( isEditing );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupFromIndex != null ) {
			swingReferenceLookupFromIndex.setEnabled( isEditing );
		}
		if( swingReferenceLookupToTable != null ) {
			swingReferenceLookupToTable.setEnabled( isEditing );
		}
		if( swingReferenceLookupToIndex != null ) {
			swingReferenceLookupToIndex.setEnabled( isEditing );
		}
		if( swingReferenceLookupNarrowed != null ) {
			swingReferenceLookupNarrowed.setEnabled( isEditing );
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
		if( swingEditorDbName != null ) {
			swingEditorDbName.setEnabled( isEditing );
		}
		if( swingEditorSuffix != null ) {
			swingEditorSuffix.setEnabled( isEditing );
		}
		if( swingEditorIsRequired != null ) {
			swingEditorIsRequired.setEnabled( isEditing );
		}
		if( swingEditorIsAbstract != null ) {
			swingEditorIsAbstract.setEnabled( isEditing );
		}
		if( swingEditorIsXsdContainer != null ) {
			swingEditorIsXsdContainer.setEnabled( isEditing );
		}
		if( swingEditorDefaultVisibility != null ) {
			swingEditorDefaultVisibility.setEnabled( isEditing );
		}
	}
}
