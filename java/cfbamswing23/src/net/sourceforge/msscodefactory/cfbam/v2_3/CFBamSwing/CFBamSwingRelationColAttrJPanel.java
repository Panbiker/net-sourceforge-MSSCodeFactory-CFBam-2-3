// Description: Java 7 Swing Attribute JPanel implementation for RelationCol.

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
 *	CFBamSwingRelationColAttrJPanel Swing Attribute JPanel implementation
 *	for RelationCol.
 */
public class CFBamSwingRelationColAttrJPanel
extends CFJPanel
implements ICFBamSwingRelationColJPanelCommon
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
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
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

	protected class RelationJLabel
		extends JLabel
	{
		public RelationJLabel() {
			super();
			setText( "Containing Relation" );
		}
	}

	protected class CallbackRelationChosen
	implements ICFBamSwingRelationChosen
	{
		public CallbackRelationChosen() {
		}

		public void choseRelation( ICFBamRelationObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerRelation != null ) {
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerRelation.setReferencedObject( value );
									editObj.setRequiredContainerRelation( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewRelationReference
	extends AbstractAction
	{
		public ActionViewRelationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamRelationObj referencedObj = focus.getRequiredContainerRelation( swingIsInitializing );
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

	protected class ActionPickRelationReference
	extends AbstractAction
	{
		public ActionPickRelationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamRelationObj referencedObj = focus.getRequiredContainerRelation( swingIsInitializing );
			java.util.List<ICFBamRelationObj> listOfRelation = null;
			Collection<ICFBamRelationObj> cltn = null;
			JInternalFrame frame = swingSchema.getRelationFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackRelationChosen() );
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

	protected class RelationCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public RelationCFJReferenceEditor() {
			super( new ActionPickRelationReference(), new ActionViewRelationReference() );
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
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
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

	protected class LookupFromColJLabel
		extends JLabel
	{
		public LookupFromColJLabel() {
			super();
			setText( "From Column" );
		}
	}

	protected class CallbackLookupFromColChosen
	implements ICFBamSwingIndexColChosen
	{
		public CallbackLookupFromColChosen() {
		}

		public void choseIndexCol( ICFBamIndexColObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupFromCol != null ) {
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupFromCol.setReferencedObject( value );
									editObj.setRequiredLookupFromCol( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewLookupFromColReference
	extends AbstractAction
	{
		public ActionViewLookupFromColReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexColObj referencedObj = focus.getRequiredLookupFromCol( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "IDXC".equals( classCode ) ) {
						frame = swingSchema.getIndexColFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamIndexColObj" );
					}
				}
			}
		}
	}

	protected class ActionPickLookupFromColReference
	extends AbstractAction
	{
		public ActionPickLookupFromColReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexColObj referencedObj = focus.getRequiredLookupFromCol( swingIsInitializing );
			java.util.List<ICFBamIndexColObj> listOfIndexCol = null;
			ICFBamRelationObj refRelation = focus.getRequiredContainerRelation( swingIsInitializing );
			if( refRelation == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a Containing Relation before selecting a From Column",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			ICFBamIndexObj refFromIndex = refRelation.getRequiredLookupFromIndex( swingIsInitializing );
			if( refFromIndex == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a From Index before selecting a From Column",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfIndexCol = refFromIndex.getOptionalComponentsColumns( swingIsInitializing );
			if( listOfIndexCol == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndexCol" );
			}
			Collection<ICFBamIndexColObj> cltn = listOfIndexCol;
			JInternalFrame frame = swingSchema.getIndexColFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackLookupFromColChosen() );
			((ICFBamSwingIndexColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class LookupFromColCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public LookupFromColCFJReferenceEditor() {
			super( new ActionPickLookupFromColReference(), new ActionViewLookupFromColReference() );
		}
	}

	protected class LookupToColJLabel
		extends JLabel
	{
		public LookupToColJLabel() {
			super();
			setText( "To Column" );
		}
	}

	protected class CallbackLookupToColChosen
	implements ICFBamSwingIndexColChosen
	{
		public CallbackLookupToColChosen() {
		}

		public void choseIndexCol( ICFBamIndexColObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupToCol != null ) {
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupToCol.setReferencedObject( value );
									editObj.setRequiredLookupToCol( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewLookupToColReference
	extends AbstractAction
	{
		public ActionViewLookupToColReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexColObj referencedObj = focus.getRequiredLookupToCol( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "IDXC".equals( classCode ) ) {
						frame = swingSchema.getIndexColFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamIndexColObj" );
					}
				}
			}
		}
	}

	protected class ActionPickLookupToColReference
	extends AbstractAction
	{
		public ActionPickLookupToColReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexColObj referencedObj = focus.getRequiredLookupToCol( swingIsInitializing );
			java.util.List<ICFBamIndexColObj> listOfIndexCol = null;
			ICFBamRelationObj refRelation = focus.getRequiredContainerRelation( swingIsInitializing );
			if( refRelation == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a Containing Relation before selecting a To Column",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			ICFBamIndexObj refToIndex = refRelation.getRequiredLookupToIndex( swingIsInitializing );
			if( refToIndex == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a To Index before selecting a To Column",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfIndexCol = refToIndex.getOptionalComponentsColumns( swingIsInitializing );
			if( listOfIndexCol == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndexCol" );
			}
			Collection<ICFBamIndexColObj> cltn = listOfIndexCol;
			JInternalFrame frame = swingSchema.getIndexColFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackLookupToColChosen() );
			((ICFBamSwingIndexColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class LookupToColCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public LookupToColCFJReferenceEditor() {
			super( new ActionPickLookupToColReference(), new ActionViewLookupToColReference() );
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
	implements ICFBamSwingRelationColChosen
	{
		public CallbackPrevChosen() {
		}

		public void choseRelationCol( ICFBamRelationColObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupPrev != null ) {
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamRelationColObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "RELC".equals( classCode ) ) {
						frame = swingSchema.getRelationColFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamRelationColObj" );
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamRelationColObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
			java.util.List<ICFBamRelationColObj> listOfRelationCol = null;
			Collection<ICFBamRelationColObj> cltn = null;
			JInternalFrame frame = swingSchema.getRelationColFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackPrevChosen() );
			((ICFBamSwingRelationColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	implements ICFBamSwingRelationColChosen
	{
		public CallbackNextChosen() {
		}

		public void choseRelationCol( ICFBamRelationColObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupNext != null ) {
						ICFBamRelationColObj cur = getSwingFocusAsRelationCol();
						if( cur != null ) {
							ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)cur.getEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			if( focus != null ) {
				ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamRelationColObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "RELC".equals( classCode ) ) {
						frame = swingSchema.getRelationColFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamRelationColObj" );
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
			ICFBamRelationColEditObj editObj  = (ICFBamRelationColEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamRelationColObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
			java.util.List<ICFBamRelationColObj> listOfRelationCol = null;
			Collection<ICFBamRelationColObj> cltn = null;
			JInternalFrame frame = swingSchema.getRelationColFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackNextChosen() );
			((ICFBamSwingRelationColJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected ICFBamTenantObj swingOwnerTenantObj = null;
	protected TenantJLabel swingLabelOwnerTenant = null;
	protected TenantCFJReferenceEditor swingReferenceOwnerTenant = null;
	protected ICFBamRelationObj swingContainerRelationObj = null;
	protected RelationJLabel swingLabelContainerRelation = null;
	protected RelationCFJReferenceEditor swingReferenceContainerRelation = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamIndexColObj swingLookupFromColObj = null;
	protected LookupFromColJLabel swingLabelLookupFromCol = null;
	protected LookupFromColCFJReferenceEditor swingReferenceLookupFromCol = null;
	protected ICFBamIndexColObj swingLookupToColObj = null;
	protected LookupToColJLabel swingLabelLookupToCol = null;
	protected LookupToColCFJReferenceEditor swingReferenceLookupToCol = null;
	protected ICFBamRelationColObj swingLookupPrevObj = null;
	protected PrevJLabel swingLabelLookupPrev = null;
	protected PrevCFJReferenceEditor swingReferenceLookupPrev = null;
	protected ICFBamRelationColObj swingLookupNextObj = null;
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
	protected DefaultVisibilityJLabel swingLabelDefaultVisibility = null;
	protected DefaultVisibilityJEditor swingEditorDefaultVisibility = null;

	public CFBamSwingRelationColAttrJPanel( ICFBamSwingSchema argSchema, ICFBamRelationColObj argFocus ) {
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
		setSwingFocusAsRelationCol( argFocus );
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

		label = getSwingLabelContainerRelation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerRelation();
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

		label = getSwingLabelLookupFromCol();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupFromCol();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToCol();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToCol();
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
		if( ( value == null ) || ( value instanceof ICFBamRelationColObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamRelationColObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamRelationColObj getSwingFocusAsRelationCol() {
		return( (ICFBamRelationColObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsRelationCol( ICFBamRelationColObj value ) {
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

	public ICFBamRelationObj getSwingContainerRelationObj() {
		if( swingContainerRelationObj == null ) {
		}
		return( swingContainerRelationObj );
	}

	public void setSwingContainerRelationObj( ICFBamRelationObj value ) {
		swingContainerRelationObj = value;
	}

	public RelationJLabel getSwingLabelContainerRelation() {
		if( swingLabelContainerRelation == null ) {
			swingLabelContainerRelation = new RelationJLabel();
		}
		return( swingLabelContainerRelation );
	}

	public RelationCFJReferenceEditor getSwingReferenceContainerRelation() {
		if( swingReferenceContainerRelation == null ) {
			swingReferenceContainerRelation = new RelationCFJReferenceEditor();
		}
		return( swingReferenceContainerRelation );
	}

	public void setSwingReferenceContainerRelation( RelationCFJReferenceEditor value ) {
		swingReferenceContainerRelation = value;
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

	public ICFBamIndexColObj getSwingLookupFromColObj() {
		return( swingLookupFromColObj );
	}

	public void setSwingLookupFromColObj( ICFBamIndexColObj value ) {
		swingLookupFromColObj = value;
	}

	public JLabel getSwingLabelLookupFromCol() {
		if( swingLabelLookupFromCol == null ) {
			swingLabelLookupFromCol = new LookupFromColJLabel();
		}
		return( swingLabelLookupFromCol );
	}

	public CFJReferenceEditor getSwingReferenceLookupFromCol() {
		if( swingReferenceLookupFromCol == null ) {
			swingReferenceLookupFromCol = new LookupFromColCFJReferenceEditor();
		}
		return( swingReferenceLookupFromCol );
	}

	public void setSwingReferenceLookupFromCol( LookupFromColCFJReferenceEditor value ) {
		swingReferenceLookupFromCol = value;
	}

	public ICFBamIndexColObj getSwingLookupToColObj() {
		return( swingLookupToColObj );
	}

	public void setSwingLookupToColObj( ICFBamIndexColObj value ) {
		swingLookupToColObj = value;
	}

	public JLabel getSwingLabelLookupToCol() {
		if( swingLabelLookupToCol == null ) {
			swingLabelLookupToCol = new LookupToColJLabel();
		}
		return( swingLabelLookupToCol );
	}

	public CFJReferenceEditor getSwingReferenceLookupToCol() {
		if( swingReferenceLookupToCol == null ) {
			swingReferenceLookupToCol = new LookupToColCFJReferenceEditor();
		}
		return( swingReferenceLookupToCol );
	}

	public void setSwingReferenceLookupToCol( LookupToColCFJReferenceEditor value ) {
		swingReferenceLookupToCol = value;
	}

	public ICFBamRelationColObj getSwingLookupPrevObj() {
		return( swingLookupPrevObj );
	}

	public void setSwingLookupPrevObj( ICFBamRelationColObj value ) {
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

	public ICFBamRelationColObj getSwingLookupNextObj() {
		return( swingLookupNextObj );
	}

	public void setSwingLookupNextObj( ICFBamRelationColObj value ) {
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

		label = getSwingLabelOwnerTenant();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerTenant();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerRelation();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerRelation();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupFromCol();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupFromCol();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupToCol();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupToCol();
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
		ICFBamRelationColObj popObj;
		ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
		if( focus != null ) {
			popObj = (ICFBamRelationColObj)(focus.getEdit());
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
			swingContainerRelationObj = null;
		}
		else {
			swingContainerRelationObj = popObj.getRequiredContainerRelation( swingIsInitializing );
		}
		if( swingReferenceContainerRelation != null ) {
			swingReferenceContainerRelation.setReferencedObject( swingContainerRelationObj );
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
			swingLookupFromColObj = null;
		}
		else {
			swingLookupFromColObj = popObj.getRequiredLookupFromCol( swingIsInitializing );
		}
		if( swingReferenceLookupFromCol != null ) {
			swingReferenceLookupFromCol.setReferencedObject( swingLookupFromColObj );
		}

		if( popObj == null ) {
			swingLookupToColObj = null;
		}
		else {
			swingLookupToColObj = popObj.getRequiredLookupToCol( swingIsInitializing );
		}
		if( swingReferenceLookupToCol != null ) {
			swingReferenceLookupToCol.setReferencedObject( swingLookupToColObj );
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
			getSwingEditorDefaultVisibility().setBooleanValue( null );
		}
		else {
			getSwingEditorDefaultVisibility().setBooleanValue( popObj.getRequiredDefaultVisibility() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
		ICFBamRelationColEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamRelationColEditObj)(focus.getEdit());
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

		swingLookupFromColObj = (ICFBamIndexColObj)( swingReferenceLookupFromCol.getReferencedObject() );
		editObj.setRequiredLookupFromCol( swingLookupFromColObj );

		swingLookupToColObj = (ICFBamIndexColObj)( swingReferenceLookupToCol.getReferencedObject() );
		editObj.setRequiredLookupToCol( swingLookupToColObj );

		swingLookupPrevObj = (ICFBamRelationColObj)( swingReferenceLookupPrev.getReferencedObject() );
		editObj.setOptionalLookupPrev( swingLookupPrevObj );

		swingLookupNextObj = (ICFBamRelationColObj)( swingReferenceLookupNext.getReferencedObject() );
		editObj.setOptionalLookupNext( swingLookupNextObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredDefaultVisibility( getSwingEditorDefaultVisibility().getBooleanValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamRelationColEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamRelationColEditObj)focus.getEdit();
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
								editObj = (ICFBamRelationColEditObj)focus.beginEdit();
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
							editObj = (ICFBamRelationColEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamRelationColEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamRelationColEditObj)focus.beginEdit();
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
						focus = (ICFBamRelationColObj)editObj.create();
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
								editObj = (ICFBamRelationColEditObj)focus.beginEdit();
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
								editObj = (ICFBamRelationColEditObj)focus.beginEdit();
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
							editObj = (ICFBamRelationColEditObj)focus.beginEdit();
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
			ICFBamRelationColObj focus = getSwingFocusAsRelationCol();
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
		if( swingReferenceContainerRelation != null ) {
			swingReferenceContainerRelation.setEnabled( false );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupFromCol != null ) {
			swingReferenceLookupFromCol.setEnabled( isEditing );
		}
		if( swingReferenceLookupToCol != null ) {
			swingReferenceLookupToCol.setEnabled( isEditing );
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
		if( swingEditorDefaultVisibility != null ) {
			swingEditorDefaultVisibility.setEnabled( isEditing );
		}
	}
}
