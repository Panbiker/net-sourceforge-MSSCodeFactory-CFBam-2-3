// Description: Java 7 Swing Attribute JPanel implementation for Table.

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
 *	CFBamSwingTableAttrJPanel Swing Attribute JPanel implementation
 *	for Table.
 */
public class CFBamSwingTableAttrJPanel
extends CFJPanel
implements ICFBamSwingTableJPanelCommon
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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

	protected class SchemaDefJLabel
		extends JLabel
	{
		public SchemaDefJLabel() {
			super();
			setText( "Containing Schema Definition" );
		}
	}

	protected class CallbackSchemaDefChosen
	implements ICFBamSwingSchemaDefChosen
	{
		public CallbackSchemaDefChosen() {
		}

		public void choseSchemaDef( ICFBamSchemaDefObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerSchemaDef != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerSchemaDef.setReferencedObject( value );
									editObj.setRequiredContainerSchemaDef( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSchemaDefReference
	extends AbstractAction
	{
		public ActionViewSchemaDefReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSchemaDefObj referencedObj = focus.getRequiredContainerSchemaDef( swingIsInitializing );
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

	protected class ActionPickSchemaDefReference
	extends AbstractAction
	{
		public ActionPickSchemaDefReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSchemaDefObj referencedObj = focus.getRequiredContainerSchemaDef( swingIsInitializing );
			java.util.List<ICFBamSchemaDefObj> listOfSchemaDef = null;
			Collection<ICFBamSchemaDefObj> cltn = null;
			JInternalFrame frame = swingSchema.getSchemaDefFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSchemaDefChosen() );
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

	protected class SchemaDefCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SchemaDefCFJReferenceEditor() {
			super( new ActionPickSchemaDefReference(), new ActionViewSchemaDefReference() );
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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

	protected class LookupIndexJLabel
		extends JLabel
	{
		public LookupIndexJLabel() {
			super();
			setText( "Lookup Index" );
		}
	}

	protected class CallbackLookupIndexChosen
	implements ICFBamSwingIndexChosen
	{
		public CallbackLookupIndexChosen() {
		}

		public void choseIndex( ICFBamIndexObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupLookupIndex != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupLookupIndex.setReferencedObject( value );
									editObj.setOptionalLookupLookupIndex( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewLookupIndexReference
	extends AbstractAction
	{
		public ActionViewLookupIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexObj referencedObj = focus.getOptionalLookupLookupIndex( swingIsInitializing );
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

	protected class ActionPickLookupIndexReference
	extends AbstractAction
	{
		public ActionPickLookupIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexObj referencedObj = focus.getOptionalLookupLookupIndex( swingIsInitializing );
			java.util.List<ICFBamIndexObj> listOfIndex = null;
			Collection<ICFBamIndexObj> cltn = null;
			JInternalFrame frame = swingSchema.getIndexFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackLookupIndexChosen() );
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

	protected class LookupIndexCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public LookupIndexCFJReferenceEditor() {
			super( new ActionPickLookupIndexReference(), new ActionViewLookupIndexReference() );
		}
	}

	protected class AltIndexJLabel
		extends JLabel
	{
		public AltIndexJLabel() {
			super();
			setText( "Alt Index" );
		}
	}

	protected class CallbackAltIndexChosen
	implements ICFBamSwingIndexChosen
	{
		public CallbackAltIndexChosen() {
		}

		public void choseIndex( ICFBamIndexObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupAltIndex != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupAltIndex.setReferencedObject( value );
									editObj.setOptionalLookupAltIndex( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewAltIndexReference
	extends AbstractAction
	{
		public ActionViewAltIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexObj referencedObj = focus.getOptionalLookupAltIndex( swingIsInitializing );
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

	protected class ActionPickAltIndexReference
	extends AbstractAction
	{
		public ActionPickAltIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexObj referencedObj = focus.getOptionalLookupAltIndex( swingIsInitializing );
			java.util.List<ICFBamIndexObj> listOfIndex = null;
			Collection<ICFBamIndexObj> cltn = null;
			JInternalFrame frame = swingSchema.getIndexFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackAltIndexChosen() );
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

	protected class AltIndexCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public AltIndexCFJReferenceEditor() {
			super( new ActionPickAltIndexReference(), new ActionViewAltIndexReference() );
		}
	}

	protected class QualifyingTableJLabel
		extends JLabel
	{
		public QualifyingTableJLabel() {
			super();
			setText( "Qualifying Table" );
		}
	}

	protected class CallbackQualifyingTableChosen
	implements ICFBamSwingTableChosen
	{
		public CallbackQualifyingTableChosen() {
		}

		public void choseTable( ICFBamTableObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupQualTable != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupQualTable.setReferencedObject( value );
									editObj.setOptionalLookupQualTable( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewQualifyingTableReference
	extends AbstractAction
	{
		public ActionViewQualifyingTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTableObj referencedObj = focus.getOptionalLookupQualTable( swingIsInitializing );
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

	protected class ActionPickQualifyingTableReference
	extends AbstractAction
	{
		public ActionPickQualifyingTableReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTableObj referencedObj = focus.getOptionalLookupQualTable( swingIsInitializing );
			java.util.List<ICFBamTableObj> listOfTable = null;
			Collection<ICFBamTableObj> cltn = null;
			JInternalFrame frame = swingSchema.getTableFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackQualifyingTableChosen() );
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

	protected class QualifyingTableCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public QualifyingTableCFJReferenceEditor() {
			super( new ActionPickQualifyingTableReference(), new ActionViewQualifyingTableReference() );
		}
	}

	protected class LoaderBehaviourJLabel
		extends JLabel
	{
		public LoaderBehaviourJLabel() {
			super();
			setText( "LoaderBehaviour" );
		}
	}

	protected class CallbackLoaderBehaviourChosen
	implements ICFBamSwingLoaderBehaviourChosen
	{
		public CallbackLoaderBehaviourChosen() {
		}

		public void choseLoaderBehaviour( ICFBamLoaderBehaviourObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupLoaderBehaviour != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupLoaderBehaviour.setReferencedObject( value );
									editObj.setRequiredLookupLoaderBehaviour( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewLoaderBehaviourReference
	extends AbstractAction
	{
		public ActionViewLoaderBehaviourReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamLoaderBehaviourObj referencedObj = focus.getRequiredLookupLoaderBehaviour( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "LDBV".equals( classCode ) ) {
						frame = swingSchema.getLoaderBehaviourFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamLoaderBehaviourObj" );
					}
				}
			}
		}
	}

	protected class ActionPickLoaderBehaviourReference
	extends AbstractAction
	{
		public ActionPickLoaderBehaviourReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamLoaderBehaviourObj referencedObj = focus.getRequiredLookupLoaderBehaviour( swingIsInitializing );
			java.util.List<ICFBamLoaderBehaviourObj> listOfLoaderBehaviour = null;
			listOfLoaderBehaviour = schemaObj.getLoaderBehaviourTableObj().readAllLoaderBehaviour();
			if( listOfLoaderBehaviour == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfLoaderBehaviour" );
			}
			Collection<ICFBamLoaderBehaviourObj> cltn = listOfLoaderBehaviour;
			JInternalFrame frame = swingSchema.getLoaderBehaviourFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackLoaderBehaviourChosen() );
			((ICFBamSwingLoaderBehaviourJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class LoaderBehaviourCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public LoaderBehaviourCFJReferenceEditor() {
			super( new ActionPickLoaderBehaviourReference(), new ActionViewLoaderBehaviourReference() );
		}
	}

	protected class PrimaryIndexJLabel
		extends JLabel
	{
		public PrimaryIndexJLabel() {
			super();
			setText( "Primary Index" );
		}
	}

	protected class CallbackPrimaryIndexChosen
	implements ICFBamSwingIndexChosen
	{
		public CallbackPrimaryIndexChosen() {
		}

		public void choseIndex( ICFBamIndexObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupPrimaryIndex != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupPrimaryIndex.setReferencedObject( value );
									editObj.setOptionalLookupPrimaryIndex( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewPrimaryIndexReference
	extends AbstractAction
	{
		public ActionViewPrimaryIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamIndexObj referencedObj = focus.getOptionalLookupPrimaryIndex( swingIsInitializing );
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

	protected class ActionPickPrimaryIndexReference
	extends AbstractAction
	{
		public ActionPickPrimaryIndexReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamIndexObj referencedObj = focus.getOptionalLookupPrimaryIndex( swingIsInitializing );
			java.util.List<ICFBamIndexObj> listOfIndex = null;
			listOfIndex = focus.getOptionalComponentsIndex( swingIsInitializing );
			if( listOfIndex == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<ICFBamIndexObj> cltn = listOfIndex;
			JInternalFrame frame = swingSchema.getIndexFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackPrimaryIndexChosen() );
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

	protected class PrimaryIndexCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public PrimaryIndexCFJReferenceEditor() {
			super( new ActionPickPrimaryIndexReference(), new ActionViewPrimaryIndexReference() );
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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

	protected class SecurityScopeJLabel
		extends JLabel
	{
		public SecurityScopeJLabel() {
			super();
			setText( "Security Scope" );
		}
	}

	protected class CallbackSecurityScopeChosen
	implements ICFBamSwingSecurityScopeChosen
	{
		public CallbackSecurityScopeChosen() {
		}

		public void choseSecurityScope( ICFBamSecurityScopeObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupSecScope != null ) {
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupSecScope.setReferencedObject( value );
									editObj.setRequiredLookupSecScope( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecurityScopeReference
	extends AbstractAction
	{
		public ActionViewSecurityScopeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecurityScopeObj referencedObj = focus.getRequiredLookupSecScope( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SCSP".equals( classCode ) ) {
						frame = swingSchema.getSecurityScopeFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecurityScopeObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecurityScopeReference
	extends AbstractAction
	{
		public ActionPickSecurityScopeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecurityScopeObj referencedObj = focus.getRequiredLookupSecScope( swingIsInitializing );
			java.util.List<ICFBamSecurityScopeObj> listOfSecurityScope = null;
			listOfSecurityScope = schemaObj.getSecurityScopeTableObj().readAllSecurityScope();
			if( listOfSecurityScope == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecurityScope" );
			}
			Collection<ICFBamSecurityScopeObj> cltn = listOfSecurityScope;
			JInternalFrame frame = swingSchema.getSecurityScopeFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecurityScopeChosen() );
			((ICFBamSwingSecurityScopeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecurityScopeCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecurityScopeCFJReferenceEditor() {
			super( new ActionPickSecurityScopeReference(), new ActionViewSecurityScopeReference() );
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
						ICFBamTableObj cur = getSwingFocusAsTable();
						if( cur != null ) {
							ICFBamTableEditObj editObj = (ICFBamTableEditObj)cur.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			if( focus != null ) {
				ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
			ICFBamTableEditObj editObj  = (ICFBamTableEditObj)focus.getEdit();
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
			setMaxLen( 50 );
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
			setMaxLen( 100 );
		}
	}

	protected class TableClassCodeJLabel
		extends JLabel
	{
		public TableClassCodeJLabel() {
			super();
			setText( "TableClassCode" );
		}
	}

	protected class TableClassCodeJEditor
		extends CFJStringEditor
	{
		public TableClassCodeJEditor() {
			super();
			setMaxLen( 4 );
		}
	}

	protected class PolyBaseJLabel
		extends JLabel
	{
		public PolyBaseJLabel() {
			super();
			setText( "PolyBase" );
		}
	}

	protected class PolyBaseJEditor
		extends CFJBoolEditor
	{
		public PolyBaseJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class IsInstantiableJLabel
		extends JLabel
	{
		public IsInstantiableJLabel() {
			super();
			setText( "IsInstantiable" );
		}
	}

	protected class IsInstantiableJEditor
		extends CFJBoolEditor
	{
		public IsInstantiableJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class HasHistoryJLabel
		extends JLabel
	{
		public HasHistoryJLabel() {
			super();
			setText( "HasHistory" );
		}
	}

	protected class HasHistoryJEditor
		extends CFJBoolEditor
	{
		public HasHistoryJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class HasAuditColumnsJLabel
		extends JLabel
	{
		public HasAuditColumnsJLabel() {
			super();
			setText( "HasAuditColumns" );
		}
	}

	protected class HasAuditColumnsJEditor
		extends CFJBoolEditor
	{
		public HasAuditColumnsJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class JObjMembersJLabel
		extends JLabel
	{
		public JObjMembersJLabel() {
			super();
			setText( "JObjMembers" );
		}
	}

	protected class JObjMembersJEditor
		extends CFJTextEditor
	{
		public JObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JObjInterfaceJLabel
		extends JLabel
	{
		public JObjInterfaceJLabel() {
			super();
			setText( "JObjInterface" );
		}
	}

	protected class JObjInterfaceJEditor
		extends CFJTextEditor
	{
		public JObjInterfaceJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JObjImportJLabel
		extends JLabel
	{
		public JObjImportJLabel() {
			super();
			setText( "JObjImport" );
		}
	}

	protected class JObjImportJEditor
		extends CFJTextEditor
	{
		public JObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JObjImplementationJLabel
		extends JLabel
	{
		public JObjImplementationJLabel() {
			super();
			setText( "JObjImplementation" );
		}
	}

	protected class JObjImplementationJEditor
		extends CFJTextEditor
	{
		public JObjImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JEditObjMembersJLabel
		extends JLabel
	{
		public JEditObjMembersJLabel() {
			super();
			setText( "JEditObjMembers" );
		}
	}

	protected class JEditObjMembersJEditor
		extends CFJTextEditor
	{
		public JEditObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JEditObjInterfaceJLabel
		extends JLabel
	{
		public JEditObjInterfaceJLabel() {
			super();
			setText( "JEditObjInterface" );
		}
	}

	protected class JEditObjInterfaceJEditor
		extends CFJTextEditor
	{
		public JEditObjInterfaceJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JEditObjImportJLabel
		extends JLabel
	{
		public JEditObjImportJLabel() {
			super();
			setText( "JEditObjImport" );
		}
	}

	protected class JEditObjImportJEditor
		extends CFJTextEditor
	{
		public JEditObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JEditObjImplementationJLabel
		extends JLabel
	{
		public JEditObjImplementationJLabel() {
			super();
			setText( "JEditObjImplementation" );
		}
	}

	protected class JEditObjImplementationJEditor
		extends CFJTextEditor
	{
		public JEditObjImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableImportJLabel
		extends JLabel
	{
		public JTableImportJLabel() {
			super();
			setText( "JTableImport" );
		}
	}

	protected class JTableImportJEditor
		extends CFJTextEditor
	{
		public JTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableMembersJLabel
		extends JLabel
	{
		public JTableMembersJLabel() {
			super();
			setText( "JTableMembers" );
		}
	}

	protected class JTableMembersJEditor
		extends CFJTextEditor
	{
		public JTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableInterfaceJLabel
		extends JLabel
	{
		public JTableInterfaceJLabel() {
			super();
			setText( "JTableInterface" );
		}
	}

	protected class JTableInterfaceJEditor
		extends CFJTextEditor
	{
		public JTableInterfaceJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableImplementationJLabel
		extends JLabel
	{
		public JTableImplementationJLabel() {
			super();
			setText( "JTableImplementation" );
		}
	}

	protected class JTableImplementationJEditor
		extends CFJTextEditor
	{
		public JTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableObjImportJLabel
		extends JLabel
	{
		public JTableObjImportJLabel() {
			super();
			setText( "JTableObjImport" );
		}
	}

	protected class JTableObjImportJEditor
		extends CFJTextEditor
	{
		public JTableObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableObjMembersJLabel
		extends JLabel
	{
		public JTableObjMembersJLabel() {
			super();
			setText( "JTableObjMembers" );
		}
	}

	protected class JTableObjMembersJEditor
		extends CFJTextEditor
	{
		public JTableObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableObjInterfaceJLabel
		extends JLabel
	{
		public JTableObjInterfaceJLabel() {
			super();
			setText( "JTableObjInterface" );
		}
	}

	protected class JTableObjInterfaceJEditor
		extends CFJTextEditor
	{
		public JTableObjInterfaceJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JTableObjImplementationJLabel
		extends JLabel
	{
		public JTableObjImplementationJLabel() {
			super();
			setText( "JTableObjImplementation" );
		}
	}

	protected class JTableObjImplementationJEditor
		extends CFJTextEditor
	{
		public JTableObjImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWTableImportJLabel
		extends JLabel
	{
		public JDb2LUWTableImportJLabel() {
			super();
			setText( "JDb2LUWTableImport" );
		}
	}

	protected class JDb2LUWTableImportJEditor
		extends CFJTextEditor
	{
		public JDb2LUWTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWTableMembersJLabel
		extends JLabel
	{
		public JDb2LUWTableMembersJLabel() {
			super();
			setText( "JDb2LUWTableMembers" );
		}
	}

	protected class JDb2LUWTableMembersJEditor
		extends CFJTextEditor
	{
		public JDb2LUWTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWTableImplementationJLabel
		extends JLabel
	{
		public JDb2LUWTableImplementationJLabel() {
			super();
			setText( "JDb2LUWTableImplementation" );
		}
	}

	protected class JDb2LUWTableImplementationJEditor
		extends CFJTextEditor
	{
		public JDb2LUWTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlTableImportJLabel
		extends JLabel
	{
		public JMSSqlTableImportJLabel() {
			super();
			setText( "JMSSqlTableImport" );
		}
	}

	protected class JMSSqlTableImportJEditor
		extends CFJTextEditor
	{
		public JMSSqlTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlTableMembersJLabel
		extends JLabel
	{
		public JMSSqlTableMembersJLabel() {
			super();
			setText( "JMSSqlTableMembers" );
		}
	}

	protected class JMSSqlTableMembersJEditor
		extends CFJTextEditor
	{
		public JMSSqlTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlTableImplementationJLabel
		extends JLabel
	{
		public JMSSqlTableImplementationJLabel() {
			super();
			setText( "JMSSqlTableImplementation" );
		}
	}

	protected class JMSSqlTableImplementationJEditor
		extends CFJTextEditor
	{
		public JMSSqlTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlTableImportJLabel
		extends JLabel
	{
		public JMySqlTableImportJLabel() {
			super();
			setText( "JMySqlTableImport" );
		}
	}

	protected class JMySqlTableImportJEditor
		extends CFJTextEditor
	{
		public JMySqlTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlTableMembersJLabel
		extends JLabel
	{
		public JMySqlTableMembersJLabel() {
			super();
			setText( "JMySqlTableMembers" );
		}
	}

	protected class JMySqlTableMembersJEditor
		extends CFJTextEditor
	{
		public JMySqlTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlTableImplementationJLabel
		extends JLabel
	{
		public JMySqlTableImplementationJLabel() {
			super();
			setText( "JMySqlTableImplementation" );
		}
	}

	protected class JMySqlTableImplementationJEditor
		extends CFJTextEditor
	{
		public JMySqlTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleTableImportJLabel
		extends JLabel
	{
		public JOracleTableImportJLabel() {
			super();
			setText( "JOracleTableImport" );
		}
	}

	protected class JOracleTableImportJEditor
		extends CFJTextEditor
	{
		public JOracleTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleTableMembersJLabel
		extends JLabel
	{
		public JOracleTableMembersJLabel() {
			super();
			setText( "JOracleTableMembers" );
		}
	}

	protected class JOracleTableMembersJEditor
		extends CFJTextEditor
	{
		public JOracleTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleTableImplementationJLabel
		extends JLabel
	{
		public JOracleTableImplementationJLabel() {
			super();
			setText( "JOracleTableImplementation" );
		}
	}

	protected class JOracleTableImplementationJEditor
		extends CFJTextEditor
	{
		public JOracleTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlTableImportJLabel
		extends JLabel
	{
		public JPgSqlTableImportJLabel() {
			super();
			setText( "JPgSqlTableImport" );
		}
	}

	protected class JPgSqlTableImportJEditor
		extends CFJTextEditor
	{
		public JPgSqlTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlTableMembersJLabel
		extends JLabel
	{
		public JPgSqlTableMembersJLabel() {
			super();
			setText( "JPgSqlTableMembers" );
		}
	}

	protected class JPgSqlTableMembersJEditor
		extends CFJTextEditor
	{
		public JPgSqlTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlTableImplementationJLabel
		extends JLabel
	{
		public JPgSqlTableImplementationJLabel() {
			super();
			setText( "JPgSqlTableImplementation" );
		}
	}

	protected class JPgSqlTableImplementationJEditor
		extends CFJTextEditor
	{
		public JPgSqlTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseTableImportJLabel
		extends JLabel
	{
		public JSybaseTableImportJLabel() {
			super();
			setText( "JSybaseTableImport" );
		}
	}

	protected class JSybaseTableImportJEditor
		extends CFJTextEditor
	{
		public JSybaseTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseTableMembersJLabel
		extends JLabel
	{
		public JSybaseTableMembersJLabel() {
			super();
			setText( "JSybaseTableMembers" );
		}
	}

	protected class JSybaseTableMembersJEditor
		extends CFJTextEditor
	{
		public JSybaseTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseTableImplementationJLabel
		extends JLabel
	{
		public JSybaseTableImplementationJLabel() {
			super();
			setText( "JSybaseTableImplementation" );
		}
	}

	protected class JSybaseTableImplementationJEditor
		extends CFJTextEditor
	{
		public JSybaseTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamTableImportJLabel
		extends JLabel
	{
		public JRamTableImportJLabel() {
			super();
			setText( "JRamTableImport" );
		}
	}

	protected class JRamTableImportJEditor
		extends CFJTextEditor
	{
		public JRamTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamTableMembersJLabel
		extends JLabel
	{
		public JRamTableMembersJLabel() {
			super();
			setText( "JRamTableMembers" );
		}
	}

	protected class JRamTableMembersJEditor
		extends CFJTextEditor
	{
		public JRamTableMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamTableImplementationJLabel
		extends JLabel
	{
		public JRamTableImplementationJLabel() {
			super();
			setText( "JRamTableImplementation" );
		}
	}

	protected class JRamTableImplementationJEditor
		extends CFJTextEditor
	{
		public JRamTableImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSaxLoaderImportJLabel
		extends JLabel
	{
		public JSaxLoaderImportJLabel() {
			super();
			setText( "JSaxLoaderImport" );
		}
	}

	protected class JSaxLoaderImportJEditor
		extends CFJTextEditor
	{
		public JSaxLoaderImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSaxLoaderStartElementJLabel
		extends JLabel
	{
		public JSaxLoaderStartElementJLabel() {
			super();
			setText( "JSaxLoaderStartElement" );
		}
	}

	protected class JSaxLoaderStartElementJEditor
		extends CFJTextEditor
	{
		public JSaxLoaderStartElementJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSaxLoaderEndElementJLabel
		extends JLabel
	{
		public JSaxLoaderEndElementJLabel() {
			super();
			setText( "JSaxLoaderEndElement" );
		}
	}

	protected class JSaxLoaderEndElementJEditor
		extends CFJTextEditor
	{
		public JSaxLoaderEndElementJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgTableImportJLabel
		extends JLabel
	{
		public JXMsgTableImportJLabel() {
			super();
			setText( "JXMsgTableImport" );
		}
	}

	protected class JXMsgTableImportJEditor
		extends CFJTextEditor
	{
		public JXMsgTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgTableFormattersJLabel
		extends JLabel
	{
		public JXMsgTableFormattersJLabel() {
			super();
			setText( "JXMsgTableFormatters" );
		}
	}

	protected class JXMsgTableFormattersJEditor
		extends CFJTextEditor
	{
		public JXMsgTableFormattersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstTableImportJLabel
		extends JLabel
	{
		public JXMsgRqstTableImportJLabel() {
			super();
			setText( "JXMsgRqstTableImport" );
		}
	}

	protected class JXMsgRqstTableImportJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnTableImportJLabel
		extends JLabel
	{
		public JXMsgRspnTableImportJLabel() {
			super();
			setText( "JXMsgRspnTableImport" );
		}
	}

	protected class JXMsgRspnTableImportJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgClientTableImportJLabel
		extends JLabel
	{
		public JXMsgClientTableImportJLabel() {
			super();
			setText( "JXMsgClientTableImport" );
		}
	}

	protected class JXMsgClientTableImportJEditor
		extends CFJTextEditor
	{
		public JXMsgClientTableImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstTableBodyJLabel
		extends JLabel
	{
		public JXMsgRqstTableBodyJLabel() {
			super();
			setText( "JXMsgRqstTableBody" );
		}
	}

	protected class JXMsgRqstTableBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstTableBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnTableBodyJLabel
		extends JLabel
	{
		public JXMsgRspnTableBodyJLabel() {
			super();
			setText( "JXMsgRspnTableBody" );
		}
	}

	protected class JXMsgRspnTableBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnTableBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgClientTableBodyJLabel
		extends JLabel
	{
		public JXMsgClientTableBodyJLabel() {
			super();
			setText( "JXMsgClientTableBody" );
		}
	}

	protected class JXMsgClientTableBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgClientTableBodyJEditor() {
			super();
			setMaxLen( 2000000 );
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
	protected ICFBamSchemaDefObj swingContainerSchemaDefObj = null;
	protected SchemaDefJLabel swingLabelContainerSchemaDef = null;
	protected SchemaDefCFJReferenceEditor swingReferenceContainerSchemaDef = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamIndexObj swingLookupLookupIndexObj = null;
	protected LookupIndexJLabel swingLabelLookupLookupIndex = null;
	protected LookupIndexCFJReferenceEditor swingReferenceLookupLookupIndex = null;
	protected ICFBamIndexObj swingLookupAltIndexObj = null;
	protected AltIndexJLabel swingLabelLookupAltIndex = null;
	protected AltIndexCFJReferenceEditor swingReferenceLookupAltIndex = null;
	protected ICFBamTableObj swingLookupQualTableObj = null;
	protected QualifyingTableJLabel swingLabelLookupQualTable = null;
	protected QualifyingTableCFJReferenceEditor swingReferenceLookupQualTable = null;
	protected ICFBamLoaderBehaviourObj swingLookupLoaderBehaviourObj = null;
	protected LoaderBehaviourJLabel swingLabelLookupLoaderBehaviour = null;
	protected LoaderBehaviourCFJReferenceEditor swingReferenceLookupLoaderBehaviour = null;
	protected ICFBamIndexObj swingLookupPrimaryIndexObj = null;
	protected PrimaryIndexJLabel swingLabelLookupPrimaryIndex = null;
	protected PrimaryIndexCFJReferenceEditor swingReferenceLookupPrimaryIndex = null;
	protected ICFBamDataScopeObj swingLookupDataScopeObj = null;
	protected DataScopeJLabel swingLabelLookupDataScope = null;
	protected DataScopeCFJReferenceEditor swingReferenceLookupDataScope = null;
	protected ICFBamSecurityScopeObj swingLookupSecScopeObj = null;
	protected SecurityScopeJLabel swingLabelLookupSecScope = null;
	protected SecurityScopeCFJReferenceEditor swingReferenceLookupSecScope = null;
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
	protected IdJLabel swingLabelId = null;
	protected IdJEditor swingEditorId = null;
	protected NameJLabel swingLabelName = null;
	protected NameJEditor swingEditorName = null;
	protected DbNameJLabel swingLabelDbName = null;
	protected DbNameJEditor swingEditorDbName = null;
	protected ShortNameJLabel swingLabelShortName = null;
	protected ShortNameJEditor swingEditorShortName = null;
	protected LabelJLabel swingLabelLabel = null;
	protected LabelJEditor swingEditorLabel = null;
	protected ShortDescriptionJLabel swingLabelShortDescription = null;
	protected ShortDescriptionJEditor swingEditorShortDescription = null;
	protected DescriptionJLabel swingLabelDescription = null;
	protected DescriptionJEditor swingEditorDescription = null;
	protected TableClassCodeJLabel swingLabelTableClassCode = null;
	protected TableClassCodeJEditor swingEditorTableClassCode = null;
	protected PolyBaseJLabel swingLabelPolyBase = null;
	protected PolyBaseJEditor swingEditorPolyBase = null;
	protected IsInstantiableJLabel swingLabelIsInstantiable = null;
	protected IsInstantiableJEditor swingEditorIsInstantiable = null;
	protected HasHistoryJLabel swingLabelHasHistory = null;
	protected HasHistoryJEditor swingEditorHasHistory = null;
	protected HasAuditColumnsJLabel swingLabelHasAuditColumns = null;
	protected HasAuditColumnsJEditor swingEditorHasAuditColumns = null;
	protected JObjMembersJLabel swingLabelJObjMembers = null;
	protected JObjMembersJEditor swingEditorJObjMembers = null;
	protected JObjInterfaceJLabel swingLabelJObjInterface = null;
	protected JObjInterfaceJEditor swingEditorJObjInterface = null;
	protected JObjImportJLabel swingLabelJObjImport = null;
	protected JObjImportJEditor swingEditorJObjImport = null;
	protected JObjImplementationJLabel swingLabelJObjImplementation = null;
	protected JObjImplementationJEditor swingEditorJObjImplementation = null;
	protected JEditObjMembersJLabel swingLabelJEditObjMembers = null;
	protected JEditObjMembersJEditor swingEditorJEditObjMembers = null;
	protected JEditObjInterfaceJLabel swingLabelJEditObjInterface = null;
	protected JEditObjInterfaceJEditor swingEditorJEditObjInterface = null;
	protected JEditObjImportJLabel swingLabelJEditObjImport = null;
	protected JEditObjImportJEditor swingEditorJEditObjImport = null;
	protected JEditObjImplementationJLabel swingLabelJEditObjImplementation = null;
	protected JEditObjImplementationJEditor swingEditorJEditObjImplementation = null;
	protected JTableImportJLabel swingLabelJTableImport = null;
	protected JTableImportJEditor swingEditorJTableImport = null;
	protected JTableMembersJLabel swingLabelJTableMembers = null;
	protected JTableMembersJEditor swingEditorJTableMembers = null;
	protected JTableInterfaceJLabel swingLabelJTableInterface = null;
	protected JTableInterfaceJEditor swingEditorJTableInterface = null;
	protected JTableImplementationJLabel swingLabelJTableImplementation = null;
	protected JTableImplementationJEditor swingEditorJTableImplementation = null;
	protected JTableObjImportJLabel swingLabelJTableObjImport = null;
	protected JTableObjImportJEditor swingEditorJTableObjImport = null;
	protected JTableObjMembersJLabel swingLabelJTableObjMembers = null;
	protected JTableObjMembersJEditor swingEditorJTableObjMembers = null;
	protected JTableObjInterfaceJLabel swingLabelJTableObjInterface = null;
	protected JTableObjInterfaceJEditor swingEditorJTableObjInterface = null;
	protected JTableObjImplementationJLabel swingLabelJTableObjImplementation = null;
	protected JTableObjImplementationJEditor swingEditorJTableObjImplementation = null;
	protected JDb2LUWTableImportJLabel swingLabelJDb2LUWTableImport = null;
	protected JDb2LUWTableImportJEditor swingEditorJDb2LUWTableImport = null;
	protected JDb2LUWTableMembersJLabel swingLabelJDb2LUWTableMembers = null;
	protected JDb2LUWTableMembersJEditor swingEditorJDb2LUWTableMembers = null;
	protected JDb2LUWTableImplementationJLabel swingLabelJDb2LUWTableImplementation = null;
	protected JDb2LUWTableImplementationJEditor swingEditorJDb2LUWTableImplementation = null;
	protected JMSSqlTableImportJLabel swingLabelJMSSqlTableImport = null;
	protected JMSSqlTableImportJEditor swingEditorJMSSqlTableImport = null;
	protected JMSSqlTableMembersJLabel swingLabelJMSSqlTableMembers = null;
	protected JMSSqlTableMembersJEditor swingEditorJMSSqlTableMembers = null;
	protected JMSSqlTableImplementationJLabel swingLabelJMSSqlTableImplementation = null;
	protected JMSSqlTableImplementationJEditor swingEditorJMSSqlTableImplementation = null;
	protected JMySqlTableImportJLabel swingLabelJMySqlTableImport = null;
	protected JMySqlTableImportJEditor swingEditorJMySqlTableImport = null;
	protected JMySqlTableMembersJLabel swingLabelJMySqlTableMembers = null;
	protected JMySqlTableMembersJEditor swingEditorJMySqlTableMembers = null;
	protected JMySqlTableImplementationJLabel swingLabelJMySqlTableImplementation = null;
	protected JMySqlTableImplementationJEditor swingEditorJMySqlTableImplementation = null;
	protected JOracleTableImportJLabel swingLabelJOracleTableImport = null;
	protected JOracleTableImportJEditor swingEditorJOracleTableImport = null;
	protected JOracleTableMembersJLabel swingLabelJOracleTableMembers = null;
	protected JOracleTableMembersJEditor swingEditorJOracleTableMembers = null;
	protected JOracleTableImplementationJLabel swingLabelJOracleTableImplementation = null;
	protected JOracleTableImplementationJEditor swingEditorJOracleTableImplementation = null;
	protected JPgSqlTableImportJLabel swingLabelJPgSqlTableImport = null;
	protected JPgSqlTableImportJEditor swingEditorJPgSqlTableImport = null;
	protected JPgSqlTableMembersJLabel swingLabelJPgSqlTableMembers = null;
	protected JPgSqlTableMembersJEditor swingEditorJPgSqlTableMembers = null;
	protected JPgSqlTableImplementationJLabel swingLabelJPgSqlTableImplementation = null;
	protected JPgSqlTableImplementationJEditor swingEditorJPgSqlTableImplementation = null;
	protected JSybaseTableImportJLabel swingLabelJSybaseTableImport = null;
	protected JSybaseTableImportJEditor swingEditorJSybaseTableImport = null;
	protected JSybaseTableMembersJLabel swingLabelJSybaseTableMembers = null;
	protected JSybaseTableMembersJEditor swingEditorJSybaseTableMembers = null;
	protected JSybaseTableImplementationJLabel swingLabelJSybaseTableImplementation = null;
	protected JSybaseTableImplementationJEditor swingEditorJSybaseTableImplementation = null;
	protected JRamTableImportJLabel swingLabelJRamTableImport = null;
	protected JRamTableImportJEditor swingEditorJRamTableImport = null;
	protected JRamTableMembersJLabel swingLabelJRamTableMembers = null;
	protected JRamTableMembersJEditor swingEditorJRamTableMembers = null;
	protected JRamTableImplementationJLabel swingLabelJRamTableImplementation = null;
	protected JRamTableImplementationJEditor swingEditorJRamTableImplementation = null;
	protected JSaxLoaderImportJLabel swingLabelJSaxLoaderImport = null;
	protected JSaxLoaderImportJEditor swingEditorJSaxLoaderImport = null;
	protected JSaxLoaderStartElementJLabel swingLabelJSaxLoaderStartElement = null;
	protected JSaxLoaderStartElementJEditor swingEditorJSaxLoaderStartElement = null;
	protected JSaxLoaderEndElementJLabel swingLabelJSaxLoaderEndElement = null;
	protected JSaxLoaderEndElementJEditor swingEditorJSaxLoaderEndElement = null;
	protected JXMsgTableImportJLabel swingLabelJXMsgTableImport = null;
	protected JXMsgTableImportJEditor swingEditorJXMsgTableImport = null;
	protected JXMsgTableFormattersJLabel swingLabelJXMsgTableFormatters = null;
	protected JXMsgTableFormattersJEditor swingEditorJXMsgTableFormatters = null;
	protected JXMsgRqstTableImportJLabel swingLabelJXMsgRqstTableImport = null;
	protected JXMsgRqstTableImportJEditor swingEditorJXMsgRqstTableImport = null;
	protected JXMsgRspnTableImportJLabel swingLabelJXMsgRspnTableImport = null;
	protected JXMsgRspnTableImportJEditor swingEditorJXMsgRspnTableImport = null;
	protected JXMsgClientTableImportJLabel swingLabelJXMsgClientTableImport = null;
	protected JXMsgClientTableImportJEditor swingEditorJXMsgClientTableImport = null;
	protected JXMsgRqstTableBodyJLabel swingLabelJXMsgRqstTableBody = null;
	protected JXMsgRqstTableBodyJEditor swingEditorJXMsgRqstTableBody = null;
	protected JXMsgRspnTableBodyJLabel swingLabelJXMsgRspnTableBody = null;
	protected JXMsgRspnTableBodyJEditor swingEditorJXMsgRspnTableBody = null;
	protected JXMsgClientTableBodyJLabel swingLabelJXMsgClientTableBody = null;
	protected JXMsgClientTableBodyJEditor swingEditorJXMsgClientTableBody = null;
	protected DefaultVisibilityJLabel swingLabelDefaultVisibility = null;
	protected DefaultVisibilityJEditor swingEditorDefaultVisibility = null;

	public CFBamSwingTableAttrJPanel( ICFBamSwingSchema argSchema, ICFBamTableObj argFocus ) {
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
		setSwingFocusAsTable( argFocus );
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

		label = getSwingLabelContainerSchemaDef();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSchemaDef();
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

		label = getSwingLabelLookupLookupIndex();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupLookupIndex();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupAltIndex();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupAltIndex();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupQualTable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupQualTable();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupLoaderBehaviour();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupLoaderBehaviour();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupPrimaryIndex();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupPrimaryIndex();
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

		label = getSwingLabelLookupSecScope();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupSecScope();
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

		label = getSwingLabelDbName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDbName();
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

		label = getSwingLabelTableClassCode();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTableClassCode();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelPolyBase();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPolyBase();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelIsInstantiable();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsInstantiable();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHasHistory();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHasHistory();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHasAuditColumns();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHasAuditColumns();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelJObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJObjInterface();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjInterface();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJObjImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJEditObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJEditObjInterface();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjInterface();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJEditObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJEditObjImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableInterface();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableInterface();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableObjInterface();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjInterface();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJTableObjImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamTableMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamTableImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderStartElement();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderStartElement();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderEndElement();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderEndElement();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgTableFormatters();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgTableFormatters();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientTableImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientTableImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstTableBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstTableBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnTableBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnTableBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientTableBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientTableBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

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
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamTableObj getSwingFocusAsTable() {
		return( (ICFBamTableObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsTable( ICFBamTableObj value ) {
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

	public ICFBamSchemaDefObj getSwingContainerSchemaDefObj() {
		if( swingContainerSchemaDefObj == null ) {
		}
		return( swingContainerSchemaDefObj );
	}

	public void setSwingContainerSchemaDefObj( ICFBamSchemaDefObj value ) {
		swingContainerSchemaDefObj = value;
	}

	public SchemaDefJLabel getSwingLabelContainerSchemaDef() {
		if( swingLabelContainerSchemaDef == null ) {
			swingLabelContainerSchemaDef = new SchemaDefJLabel();
		}
		return( swingLabelContainerSchemaDef );
	}

	public SchemaDefCFJReferenceEditor getSwingReferenceContainerSchemaDef() {
		if( swingReferenceContainerSchemaDef == null ) {
			swingReferenceContainerSchemaDef = new SchemaDefCFJReferenceEditor();
		}
		return( swingReferenceContainerSchemaDef );
	}

	public void setSwingReferenceContainerSchemaDef( SchemaDefCFJReferenceEditor value ) {
		swingReferenceContainerSchemaDef = value;
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

	public ICFBamIndexObj getSwingLookupLookupIndexObj() {
		return( swingLookupLookupIndexObj );
	}

	public void setSwingLookupLookupIndexObj( ICFBamIndexObj value ) {
		swingLookupLookupIndexObj = value;
	}

	public JLabel getSwingLabelLookupLookupIndex() {
		if( swingLabelLookupLookupIndex == null ) {
			swingLabelLookupLookupIndex = new LookupIndexJLabel();
		}
		return( swingLabelLookupLookupIndex );
	}

	public CFJReferenceEditor getSwingReferenceLookupLookupIndex() {
		if( swingReferenceLookupLookupIndex == null ) {
			swingReferenceLookupLookupIndex = new LookupIndexCFJReferenceEditor();
		}
		return( swingReferenceLookupLookupIndex );
	}

	public void setSwingReferenceLookupLookupIndex( LookupIndexCFJReferenceEditor value ) {
		swingReferenceLookupLookupIndex = value;
	}

	public ICFBamIndexObj getSwingLookupAltIndexObj() {
		return( swingLookupAltIndexObj );
	}

	public void setSwingLookupAltIndexObj( ICFBamIndexObj value ) {
		swingLookupAltIndexObj = value;
	}

	public JLabel getSwingLabelLookupAltIndex() {
		if( swingLabelLookupAltIndex == null ) {
			swingLabelLookupAltIndex = new AltIndexJLabel();
		}
		return( swingLabelLookupAltIndex );
	}

	public CFJReferenceEditor getSwingReferenceLookupAltIndex() {
		if( swingReferenceLookupAltIndex == null ) {
			swingReferenceLookupAltIndex = new AltIndexCFJReferenceEditor();
		}
		return( swingReferenceLookupAltIndex );
	}

	public void setSwingReferenceLookupAltIndex( AltIndexCFJReferenceEditor value ) {
		swingReferenceLookupAltIndex = value;
	}

	public ICFBamTableObj getSwingLookupQualTableObj() {
		return( swingLookupQualTableObj );
	}

	public void setSwingLookupQualTableObj( ICFBamTableObj value ) {
		swingLookupQualTableObj = value;
	}

	public JLabel getSwingLabelLookupQualTable() {
		if( swingLabelLookupQualTable == null ) {
			swingLabelLookupQualTable = new QualifyingTableJLabel();
		}
		return( swingLabelLookupQualTable );
	}

	public CFJReferenceEditor getSwingReferenceLookupQualTable() {
		if( swingReferenceLookupQualTable == null ) {
			swingReferenceLookupQualTable = new QualifyingTableCFJReferenceEditor();
		}
		return( swingReferenceLookupQualTable );
	}

	public void setSwingReferenceLookupQualTable( QualifyingTableCFJReferenceEditor value ) {
		swingReferenceLookupQualTable = value;
	}

	public ICFBamLoaderBehaviourObj getSwingLookupLoaderBehaviourObj() {
		return( swingLookupLoaderBehaviourObj );
	}

	public void setSwingLookupLoaderBehaviourObj( ICFBamLoaderBehaviourObj value ) {
		swingLookupLoaderBehaviourObj = value;
	}

	public JLabel getSwingLabelLookupLoaderBehaviour() {
		if( swingLabelLookupLoaderBehaviour == null ) {
			swingLabelLookupLoaderBehaviour = new LoaderBehaviourJLabel();
		}
		return( swingLabelLookupLoaderBehaviour );
	}

	public CFJReferenceEditor getSwingReferenceLookupLoaderBehaviour() {
		if( swingReferenceLookupLoaderBehaviour == null ) {
			swingReferenceLookupLoaderBehaviour = new LoaderBehaviourCFJReferenceEditor();
		}
		return( swingReferenceLookupLoaderBehaviour );
	}

	public void setSwingReferenceLookupLoaderBehaviour( LoaderBehaviourCFJReferenceEditor value ) {
		swingReferenceLookupLoaderBehaviour = value;
	}

	public ICFBamIndexObj getSwingLookupPrimaryIndexObj() {
		return( swingLookupPrimaryIndexObj );
	}

	public void setSwingLookupPrimaryIndexObj( ICFBamIndexObj value ) {
		swingLookupPrimaryIndexObj = value;
	}

	public JLabel getSwingLabelLookupPrimaryIndex() {
		if( swingLabelLookupPrimaryIndex == null ) {
			swingLabelLookupPrimaryIndex = new PrimaryIndexJLabel();
		}
		return( swingLabelLookupPrimaryIndex );
	}

	public CFJReferenceEditor getSwingReferenceLookupPrimaryIndex() {
		if( swingReferenceLookupPrimaryIndex == null ) {
			swingReferenceLookupPrimaryIndex = new PrimaryIndexCFJReferenceEditor();
		}
		return( swingReferenceLookupPrimaryIndex );
	}

	public void setSwingReferenceLookupPrimaryIndex( PrimaryIndexCFJReferenceEditor value ) {
		swingReferenceLookupPrimaryIndex = value;
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

	public ICFBamSecurityScopeObj getSwingLookupSecScopeObj() {
		return( swingLookupSecScopeObj );
	}

	public void setSwingLookupSecScopeObj( ICFBamSecurityScopeObj value ) {
		swingLookupSecScopeObj = value;
	}

	public JLabel getSwingLabelLookupSecScope() {
		if( swingLabelLookupSecScope == null ) {
			swingLabelLookupSecScope = new SecurityScopeJLabel();
		}
		return( swingLabelLookupSecScope );
	}

	public CFJReferenceEditor getSwingReferenceLookupSecScope() {
		if( swingReferenceLookupSecScope == null ) {
			swingReferenceLookupSecScope = new SecurityScopeCFJReferenceEditor();
		}
		return( swingReferenceLookupSecScope );
	}

	public void setSwingReferenceLookupSecScope( SecurityScopeCFJReferenceEditor value ) {
		swingReferenceLookupSecScope = value;
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

	public TableClassCodeJLabel getSwingLabelTableClassCode() {
		if( swingLabelTableClassCode == null ) {
			swingLabelTableClassCode = new TableClassCodeJLabel();
		}
		return( swingLabelTableClassCode );
	}

	public void setSwingLabelTableClassCode( TableClassCodeJLabel value ) {
		swingLabelTableClassCode = value;
	}

	public TableClassCodeJEditor getSwingEditorTableClassCode() {
		if( swingEditorTableClassCode == null ) {
			swingEditorTableClassCode = new TableClassCodeJEditor();
		}
		return( swingEditorTableClassCode );
	}

	public void setSwingEditorTableClassCode( TableClassCodeJEditor value ) {
		swingEditorTableClassCode = value;
	}

	public PolyBaseJLabel getSwingLabelPolyBase() {
		if( swingLabelPolyBase == null ) {
			swingLabelPolyBase = new PolyBaseJLabel();
		}
		return( swingLabelPolyBase );
	}

	public void setSwingLabelPolyBase( PolyBaseJLabel value ) {
		swingLabelPolyBase = value;
	}

	public PolyBaseJEditor getSwingEditorPolyBase() {
		if( swingEditorPolyBase == null ) {
			swingEditorPolyBase = new PolyBaseJEditor();
		}
		return( swingEditorPolyBase );
	}

	public void setSwingEditorPolyBase( PolyBaseJEditor value ) {
		swingEditorPolyBase = value;
	}

	public IsInstantiableJLabel getSwingLabelIsInstantiable() {
		if( swingLabelIsInstantiable == null ) {
			swingLabelIsInstantiable = new IsInstantiableJLabel();
		}
		return( swingLabelIsInstantiable );
	}

	public void setSwingLabelIsInstantiable( IsInstantiableJLabel value ) {
		swingLabelIsInstantiable = value;
	}

	public IsInstantiableJEditor getSwingEditorIsInstantiable() {
		if( swingEditorIsInstantiable == null ) {
			swingEditorIsInstantiable = new IsInstantiableJEditor();
		}
		return( swingEditorIsInstantiable );
	}

	public void setSwingEditorIsInstantiable( IsInstantiableJEditor value ) {
		swingEditorIsInstantiable = value;
	}

	public HasHistoryJLabel getSwingLabelHasHistory() {
		if( swingLabelHasHistory == null ) {
			swingLabelHasHistory = new HasHistoryJLabel();
		}
		return( swingLabelHasHistory );
	}

	public void setSwingLabelHasHistory( HasHistoryJLabel value ) {
		swingLabelHasHistory = value;
	}

	public HasHistoryJEditor getSwingEditorHasHistory() {
		if( swingEditorHasHistory == null ) {
			swingEditorHasHistory = new HasHistoryJEditor();
		}
		return( swingEditorHasHistory );
	}

	public void setSwingEditorHasHistory( HasHistoryJEditor value ) {
		swingEditorHasHistory = value;
	}

	public HasAuditColumnsJLabel getSwingLabelHasAuditColumns() {
		if( swingLabelHasAuditColumns == null ) {
			swingLabelHasAuditColumns = new HasAuditColumnsJLabel();
		}
		return( swingLabelHasAuditColumns );
	}

	public void setSwingLabelHasAuditColumns( HasAuditColumnsJLabel value ) {
		swingLabelHasAuditColumns = value;
	}

	public HasAuditColumnsJEditor getSwingEditorHasAuditColumns() {
		if( swingEditorHasAuditColumns == null ) {
			swingEditorHasAuditColumns = new HasAuditColumnsJEditor();
		}
		return( swingEditorHasAuditColumns );
	}

	public void setSwingEditorHasAuditColumns( HasAuditColumnsJEditor value ) {
		swingEditorHasAuditColumns = value;
	}

	public JObjMembersJLabel getSwingLabelJObjMembers() {
		if( swingLabelJObjMembers == null ) {
			swingLabelJObjMembers = new JObjMembersJLabel();
		}
		return( swingLabelJObjMembers );
	}

	public void setSwingLabelJObjMembers( JObjMembersJLabel value ) {
		swingLabelJObjMembers = value;
	}

	public JObjMembersJEditor getSwingEditorJObjMembers() {
		if( swingEditorJObjMembers == null ) {
			swingEditorJObjMembers = new JObjMembersJEditor();
		}
		return( swingEditorJObjMembers );
	}

	public void setSwingEditorJObjMembers( JObjMembersJEditor value ) {
		swingEditorJObjMembers = value;
	}

	public JObjInterfaceJLabel getSwingLabelJObjInterface() {
		if( swingLabelJObjInterface == null ) {
			swingLabelJObjInterface = new JObjInterfaceJLabel();
		}
		return( swingLabelJObjInterface );
	}

	public void setSwingLabelJObjInterface( JObjInterfaceJLabel value ) {
		swingLabelJObjInterface = value;
	}

	public JObjInterfaceJEditor getSwingEditorJObjInterface() {
		if( swingEditorJObjInterface == null ) {
			swingEditorJObjInterface = new JObjInterfaceJEditor();
		}
		return( swingEditorJObjInterface );
	}

	public void setSwingEditorJObjInterface( JObjInterfaceJEditor value ) {
		swingEditorJObjInterface = value;
	}

	public JObjImportJLabel getSwingLabelJObjImport() {
		if( swingLabelJObjImport == null ) {
			swingLabelJObjImport = new JObjImportJLabel();
		}
		return( swingLabelJObjImport );
	}

	public void setSwingLabelJObjImport( JObjImportJLabel value ) {
		swingLabelJObjImport = value;
	}

	public JObjImportJEditor getSwingEditorJObjImport() {
		if( swingEditorJObjImport == null ) {
			swingEditorJObjImport = new JObjImportJEditor();
		}
		return( swingEditorJObjImport );
	}

	public void setSwingEditorJObjImport( JObjImportJEditor value ) {
		swingEditorJObjImport = value;
	}

	public JObjImplementationJLabel getSwingLabelJObjImplementation() {
		if( swingLabelJObjImplementation == null ) {
			swingLabelJObjImplementation = new JObjImplementationJLabel();
		}
		return( swingLabelJObjImplementation );
	}

	public void setSwingLabelJObjImplementation( JObjImplementationJLabel value ) {
		swingLabelJObjImplementation = value;
	}

	public JObjImplementationJEditor getSwingEditorJObjImplementation() {
		if( swingEditorJObjImplementation == null ) {
			swingEditorJObjImplementation = new JObjImplementationJEditor();
		}
		return( swingEditorJObjImplementation );
	}

	public void setSwingEditorJObjImplementation( JObjImplementationJEditor value ) {
		swingEditorJObjImplementation = value;
	}

	public JEditObjMembersJLabel getSwingLabelJEditObjMembers() {
		if( swingLabelJEditObjMembers == null ) {
			swingLabelJEditObjMembers = new JEditObjMembersJLabel();
		}
		return( swingLabelJEditObjMembers );
	}

	public void setSwingLabelJEditObjMembers( JEditObjMembersJLabel value ) {
		swingLabelJEditObjMembers = value;
	}

	public JEditObjMembersJEditor getSwingEditorJEditObjMembers() {
		if( swingEditorJEditObjMembers == null ) {
			swingEditorJEditObjMembers = new JEditObjMembersJEditor();
		}
		return( swingEditorJEditObjMembers );
	}

	public void setSwingEditorJEditObjMembers( JEditObjMembersJEditor value ) {
		swingEditorJEditObjMembers = value;
	}

	public JEditObjInterfaceJLabel getSwingLabelJEditObjInterface() {
		if( swingLabelJEditObjInterface == null ) {
			swingLabelJEditObjInterface = new JEditObjInterfaceJLabel();
		}
		return( swingLabelJEditObjInterface );
	}

	public void setSwingLabelJEditObjInterface( JEditObjInterfaceJLabel value ) {
		swingLabelJEditObjInterface = value;
	}

	public JEditObjInterfaceJEditor getSwingEditorJEditObjInterface() {
		if( swingEditorJEditObjInterface == null ) {
			swingEditorJEditObjInterface = new JEditObjInterfaceJEditor();
		}
		return( swingEditorJEditObjInterface );
	}

	public void setSwingEditorJEditObjInterface( JEditObjInterfaceJEditor value ) {
		swingEditorJEditObjInterface = value;
	}

	public JEditObjImportJLabel getSwingLabelJEditObjImport() {
		if( swingLabelJEditObjImport == null ) {
			swingLabelJEditObjImport = new JEditObjImportJLabel();
		}
		return( swingLabelJEditObjImport );
	}

	public void setSwingLabelJEditObjImport( JEditObjImportJLabel value ) {
		swingLabelJEditObjImport = value;
	}

	public JEditObjImportJEditor getSwingEditorJEditObjImport() {
		if( swingEditorJEditObjImport == null ) {
			swingEditorJEditObjImport = new JEditObjImportJEditor();
		}
		return( swingEditorJEditObjImport );
	}

	public void setSwingEditorJEditObjImport( JEditObjImportJEditor value ) {
		swingEditorJEditObjImport = value;
	}

	public JEditObjImplementationJLabel getSwingLabelJEditObjImplementation() {
		if( swingLabelJEditObjImplementation == null ) {
			swingLabelJEditObjImplementation = new JEditObjImplementationJLabel();
		}
		return( swingLabelJEditObjImplementation );
	}

	public void setSwingLabelJEditObjImplementation( JEditObjImplementationJLabel value ) {
		swingLabelJEditObjImplementation = value;
	}

	public JEditObjImplementationJEditor getSwingEditorJEditObjImplementation() {
		if( swingEditorJEditObjImplementation == null ) {
			swingEditorJEditObjImplementation = new JEditObjImplementationJEditor();
		}
		return( swingEditorJEditObjImplementation );
	}

	public void setSwingEditorJEditObjImplementation( JEditObjImplementationJEditor value ) {
		swingEditorJEditObjImplementation = value;
	}

	public JTableImportJLabel getSwingLabelJTableImport() {
		if( swingLabelJTableImport == null ) {
			swingLabelJTableImport = new JTableImportJLabel();
		}
		return( swingLabelJTableImport );
	}

	public void setSwingLabelJTableImport( JTableImportJLabel value ) {
		swingLabelJTableImport = value;
	}

	public JTableImportJEditor getSwingEditorJTableImport() {
		if( swingEditorJTableImport == null ) {
			swingEditorJTableImport = new JTableImportJEditor();
		}
		return( swingEditorJTableImport );
	}

	public void setSwingEditorJTableImport( JTableImportJEditor value ) {
		swingEditorJTableImport = value;
	}

	public JTableMembersJLabel getSwingLabelJTableMembers() {
		if( swingLabelJTableMembers == null ) {
			swingLabelJTableMembers = new JTableMembersJLabel();
		}
		return( swingLabelJTableMembers );
	}

	public void setSwingLabelJTableMembers( JTableMembersJLabel value ) {
		swingLabelJTableMembers = value;
	}

	public JTableMembersJEditor getSwingEditorJTableMembers() {
		if( swingEditorJTableMembers == null ) {
			swingEditorJTableMembers = new JTableMembersJEditor();
		}
		return( swingEditorJTableMembers );
	}

	public void setSwingEditorJTableMembers( JTableMembersJEditor value ) {
		swingEditorJTableMembers = value;
	}

	public JTableInterfaceJLabel getSwingLabelJTableInterface() {
		if( swingLabelJTableInterface == null ) {
			swingLabelJTableInterface = new JTableInterfaceJLabel();
		}
		return( swingLabelJTableInterface );
	}

	public void setSwingLabelJTableInterface( JTableInterfaceJLabel value ) {
		swingLabelJTableInterface = value;
	}

	public JTableInterfaceJEditor getSwingEditorJTableInterface() {
		if( swingEditorJTableInterface == null ) {
			swingEditorJTableInterface = new JTableInterfaceJEditor();
		}
		return( swingEditorJTableInterface );
	}

	public void setSwingEditorJTableInterface( JTableInterfaceJEditor value ) {
		swingEditorJTableInterface = value;
	}

	public JTableImplementationJLabel getSwingLabelJTableImplementation() {
		if( swingLabelJTableImplementation == null ) {
			swingLabelJTableImplementation = new JTableImplementationJLabel();
		}
		return( swingLabelJTableImplementation );
	}

	public void setSwingLabelJTableImplementation( JTableImplementationJLabel value ) {
		swingLabelJTableImplementation = value;
	}

	public JTableImplementationJEditor getSwingEditorJTableImplementation() {
		if( swingEditorJTableImplementation == null ) {
			swingEditorJTableImplementation = new JTableImplementationJEditor();
		}
		return( swingEditorJTableImplementation );
	}

	public void setSwingEditorJTableImplementation( JTableImplementationJEditor value ) {
		swingEditorJTableImplementation = value;
	}

	public JTableObjImportJLabel getSwingLabelJTableObjImport() {
		if( swingLabelJTableObjImport == null ) {
			swingLabelJTableObjImport = new JTableObjImportJLabel();
		}
		return( swingLabelJTableObjImport );
	}

	public void setSwingLabelJTableObjImport( JTableObjImportJLabel value ) {
		swingLabelJTableObjImport = value;
	}

	public JTableObjImportJEditor getSwingEditorJTableObjImport() {
		if( swingEditorJTableObjImport == null ) {
			swingEditorJTableObjImport = new JTableObjImportJEditor();
		}
		return( swingEditorJTableObjImport );
	}

	public void setSwingEditorJTableObjImport( JTableObjImportJEditor value ) {
		swingEditorJTableObjImport = value;
	}

	public JTableObjMembersJLabel getSwingLabelJTableObjMembers() {
		if( swingLabelJTableObjMembers == null ) {
			swingLabelJTableObjMembers = new JTableObjMembersJLabel();
		}
		return( swingLabelJTableObjMembers );
	}

	public void setSwingLabelJTableObjMembers( JTableObjMembersJLabel value ) {
		swingLabelJTableObjMembers = value;
	}

	public JTableObjMembersJEditor getSwingEditorJTableObjMembers() {
		if( swingEditorJTableObjMembers == null ) {
			swingEditorJTableObjMembers = new JTableObjMembersJEditor();
		}
		return( swingEditorJTableObjMembers );
	}

	public void setSwingEditorJTableObjMembers( JTableObjMembersJEditor value ) {
		swingEditorJTableObjMembers = value;
	}

	public JTableObjInterfaceJLabel getSwingLabelJTableObjInterface() {
		if( swingLabelJTableObjInterface == null ) {
			swingLabelJTableObjInterface = new JTableObjInterfaceJLabel();
		}
		return( swingLabelJTableObjInterface );
	}

	public void setSwingLabelJTableObjInterface( JTableObjInterfaceJLabel value ) {
		swingLabelJTableObjInterface = value;
	}

	public JTableObjInterfaceJEditor getSwingEditorJTableObjInterface() {
		if( swingEditorJTableObjInterface == null ) {
			swingEditorJTableObjInterface = new JTableObjInterfaceJEditor();
		}
		return( swingEditorJTableObjInterface );
	}

	public void setSwingEditorJTableObjInterface( JTableObjInterfaceJEditor value ) {
		swingEditorJTableObjInterface = value;
	}

	public JTableObjImplementationJLabel getSwingLabelJTableObjImplementation() {
		if( swingLabelJTableObjImplementation == null ) {
			swingLabelJTableObjImplementation = new JTableObjImplementationJLabel();
		}
		return( swingLabelJTableObjImplementation );
	}

	public void setSwingLabelJTableObjImplementation( JTableObjImplementationJLabel value ) {
		swingLabelJTableObjImplementation = value;
	}

	public JTableObjImplementationJEditor getSwingEditorJTableObjImplementation() {
		if( swingEditorJTableObjImplementation == null ) {
			swingEditorJTableObjImplementation = new JTableObjImplementationJEditor();
		}
		return( swingEditorJTableObjImplementation );
	}

	public void setSwingEditorJTableObjImplementation( JTableObjImplementationJEditor value ) {
		swingEditorJTableObjImplementation = value;
	}

	public JDb2LUWTableImportJLabel getSwingLabelJDb2LUWTableImport() {
		if( swingLabelJDb2LUWTableImport == null ) {
			swingLabelJDb2LUWTableImport = new JDb2LUWTableImportJLabel();
		}
		return( swingLabelJDb2LUWTableImport );
	}

	public void setSwingLabelJDb2LUWTableImport( JDb2LUWTableImportJLabel value ) {
		swingLabelJDb2LUWTableImport = value;
	}

	public JDb2LUWTableImportJEditor getSwingEditorJDb2LUWTableImport() {
		if( swingEditorJDb2LUWTableImport == null ) {
			swingEditorJDb2LUWTableImport = new JDb2LUWTableImportJEditor();
		}
		return( swingEditorJDb2LUWTableImport );
	}

	public void setSwingEditorJDb2LUWTableImport( JDb2LUWTableImportJEditor value ) {
		swingEditorJDb2LUWTableImport = value;
	}

	public JDb2LUWTableMembersJLabel getSwingLabelJDb2LUWTableMembers() {
		if( swingLabelJDb2LUWTableMembers == null ) {
			swingLabelJDb2LUWTableMembers = new JDb2LUWTableMembersJLabel();
		}
		return( swingLabelJDb2LUWTableMembers );
	}

	public void setSwingLabelJDb2LUWTableMembers( JDb2LUWTableMembersJLabel value ) {
		swingLabelJDb2LUWTableMembers = value;
	}

	public JDb2LUWTableMembersJEditor getSwingEditorJDb2LUWTableMembers() {
		if( swingEditorJDb2LUWTableMembers == null ) {
			swingEditorJDb2LUWTableMembers = new JDb2LUWTableMembersJEditor();
		}
		return( swingEditorJDb2LUWTableMembers );
	}

	public void setSwingEditorJDb2LUWTableMembers( JDb2LUWTableMembersJEditor value ) {
		swingEditorJDb2LUWTableMembers = value;
	}

	public JDb2LUWTableImplementationJLabel getSwingLabelJDb2LUWTableImplementation() {
		if( swingLabelJDb2LUWTableImplementation == null ) {
			swingLabelJDb2LUWTableImplementation = new JDb2LUWTableImplementationJLabel();
		}
		return( swingLabelJDb2LUWTableImplementation );
	}

	public void setSwingLabelJDb2LUWTableImplementation( JDb2LUWTableImplementationJLabel value ) {
		swingLabelJDb2LUWTableImplementation = value;
	}

	public JDb2LUWTableImplementationJEditor getSwingEditorJDb2LUWTableImplementation() {
		if( swingEditorJDb2LUWTableImplementation == null ) {
			swingEditorJDb2LUWTableImplementation = new JDb2LUWTableImplementationJEditor();
		}
		return( swingEditorJDb2LUWTableImplementation );
	}

	public void setSwingEditorJDb2LUWTableImplementation( JDb2LUWTableImplementationJEditor value ) {
		swingEditorJDb2LUWTableImplementation = value;
	}

	public JMSSqlTableImportJLabel getSwingLabelJMSSqlTableImport() {
		if( swingLabelJMSSqlTableImport == null ) {
			swingLabelJMSSqlTableImport = new JMSSqlTableImportJLabel();
		}
		return( swingLabelJMSSqlTableImport );
	}

	public void setSwingLabelJMSSqlTableImport( JMSSqlTableImportJLabel value ) {
		swingLabelJMSSqlTableImport = value;
	}

	public JMSSqlTableImportJEditor getSwingEditorJMSSqlTableImport() {
		if( swingEditorJMSSqlTableImport == null ) {
			swingEditorJMSSqlTableImport = new JMSSqlTableImportJEditor();
		}
		return( swingEditorJMSSqlTableImport );
	}

	public void setSwingEditorJMSSqlTableImport( JMSSqlTableImportJEditor value ) {
		swingEditorJMSSqlTableImport = value;
	}

	public JMSSqlTableMembersJLabel getSwingLabelJMSSqlTableMembers() {
		if( swingLabelJMSSqlTableMembers == null ) {
			swingLabelJMSSqlTableMembers = new JMSSqlTableMembersJLabel();
		}
		return( swingLabelJMSSqlTableMembers );
	}

	public void setSwingLabelJMSSqlTableMembers( JMSSqlTableMembersJLabel value ) {
		swingLabelJMSSqlTableMembers = value;
	}

	public JMSSqlTableMembersJEditor getSwingEditorJMSSqlTableMembers() {
		if( swingEditorJMSSqlTableMembers == null ) {
			swingEditorJMSSqlTableMembers = new JMSSqlTableMembersJEditor();
		}
		return( swingEditorJMSSqlTableMembers );
	}

	public void setSwingEditorJMSSqlTableMembers( JMSSqlTableMembersJEditor value ) {
		swingEditorJMSSqlTableMembers = value;
	}

	public JMSSqlTableImplementationJLabel getSwingLabelJMSSqlTableImplementation() {
		if( swingLabelJMSSqlTableImplementation == null ) {
			swingLabelJMSSqlTableImplementation = new JMSSqlTableImplementationJLabel();
		}
		return( swingLabelJMSSqlTableImplementation );
	}

	public void setSwingLabelJMSSqlTableImplementation( JMSSqlTableImplementationJLabel value ) {
		swingLabelJMSSqlTableImplementation = value;
	}

	public JMSSqlTableImplementationJEditor getSwingEditorJMSSqlTableImplementation() {
		if( swingEditorJMSSqlTableImplementation == null ) {
			swingEditorJMSSqlTableImplementation = new JMSSqlTableImplementationJEditor();
		}
		return( swingEditorJMSSqlTableImplementation );
	}

	public void setSwingEditorJMSSqlTableImplementation( JMSSqlTableImplementationJEditor value ) {
		swingEditorJMSSqlTableImplementation = value;
	}

	public JMySqlTableImportJLabel getSwingLabelJMySqlTableImport() {
		if( swingLabelJMySqlTableImport == null ) {
			swingLabelJMySqlTableImport = new JMySqlTableImportJLabel();
		}
		return( swingLabelJMySqlTableImport );
	}

	public void setSwingLabelJMySqlTableImport( JMySqlTableImportJLabel value ) {
		swingLabelJMySqlTableImport = value;
	}

	public JMySqlTableImportJEditor getSwingEditorJMySqlTableImport() {
		if( swingEditorJMySqlTableImport == null ) {
			swingEditorJMySqlTableImport = new JMySqlTableImportJEditor();
		}
		return( swingEditorJMySqlTableImport );
	}

	public void setSwingEditorJMySqlTableImport( JMySqlTableImportJEditor value ) {
		swingEditorJMySqlTableImport = value;
	}

	public JMySqlTableMembersJLabel getSwingLabelJMySqlTableMembers() {
		if( swingLabelJMySqlTableMembers == null ) {
			swingLabelJMySqlTableMembers = new JMySqlTableMembersJLabel();
		}
		return( swingLabelJMySqlTableMembers );
	}

	public void setSwingLabelJMySqlTableMembers( JMySqlTableMembersJLabel value ) {
		swingLabelJMySqlTableMembers = value;
	}

	public JMySqlTableMembersJEditor getSwingEditorJMySqlTableMembers() {
		if( swingEditorJMySqlTableMembers == null ) {
			swingEditorJMySqlTableMembers = new JMySqlTableMembersJEditor();
		}
		return( swingEditorJMySqlTableMembers );
	}

	public void setSwingEditorJMySqlTableMembers( JMySqlTableMembersJEditor value ) {
		swingEditorJMySqlTableMembers = value;
	}

	public JMySqlTableImplementationJLabel getSwingLabelJMySqlTableImplementation() {
		if( swingLabelJMySqlTableImplementation == null ) {
			swingLabelJMySqlTableImplementation = new JMySqlTableImplementationJLabel();
		}
		return( swingLabelJMySqlTableImplementation );
	}

	public void setSwingLabelJMySqlTableImplementation( JMySqlTableImplementationJLabel value ) {
		swingLabelJMySqlTableImplementation = value;
	}

	public JMySqlTableImplementationJEditor getSwingEditorJMySqlTableImplementation() {
		if( swingEditorJMySqlTableImplementation == null ) {
			swingEditorJMySqlTableImplementation = new JMySqlTableImplementationJEditor();
		}
		return( swingEditorJMySqlTableImplementation );
	}

	public void setSwingEditorJMySqlTableImplementation( JMySqlTableImplementationJEditor value ) {
		swingEditorJMySqlTableImplementation = value;
	}

	public JOracleTableImportJLabel getSwingLabelJOracleTableImport() {
		if( swingLabelJOracleTableImport == null ) {
			swingLabelJOracleTableImport = new JOracleTableImportJLabel();
		}
		return( swingLabelJOracleTableImport );
	}

	public void setSwingLabelJOracleTableImport( JOracleTableImportJLabel value ) {
		swingLabelJOracleTableImport = value;
	}

	public JOracleTableImportJEditor getSwingEditorJOracleTableImport() {
		if( swingEditorJOracleTableImport == null ) {
			swingEditorJOracleTableImport = new JOracleTableImportJEditor();
		}
		return( swingEditorJOracleTableImport );
	}

	public void setSwingEditorJOracleTableImport( JOracleTableImportJEditor value ) {
		swingEditorJOracleTableImport = value;
	}

	public JOracleTableMembersJLabel getSwingLabelJOracleTableMembers() {
		if( swingLabelJOracleTableMembers == null ) {
			swingLabelJOracleTableMembers = new JOracleTableMembersJLabel();
		}
		return( swingLabelJOracleTableMembers );
	}

	public void setSwingLabelJOracleTableMembers( JOracleTableMembersJLabel value ) {
		swingLabelJOracleTableMembers = value;
	}

	public JOracleTableMembersJEditor getSwingEditorJOracleTableMembers() {
		if( swingEditorJOracleTableMembers == null ) {
			swingEditorJOracleTableMembers = new JOracleTableMembersJEditor();
		}
		return( swingEditorJOracleTableMembers );
	}

	public void setSwingEditorJOracleTableMembers( JOracleTableMembersJEditor value ) {
		swingEditorJOracleTableMembers = value;
	}

	public JOracleTableImplementationJLabel getSwingLabelJOracleTableImplementation() {
		if( swingLabelJOracleTableImplementation == null ) {
			swingLabelJOracleTableImplementation = new JOracleTableImplementationJLabel();
		}
		return( swingLabelJOracleTableImplementation );
	}

	public void setSwingLabelJOracleTableImplementation( JOracleTableImplementationJLabel value ) {
		swingLabelJOracleTableImplementation = value;
	}

	public JOracleTableImplementationJEditor getSwingEditorJOracleTableImplementation() {
		if( swingEditorJOracleTableImplementation == null ) {
			swingEditorJOracleTableImplementation = new JOracleTableImplementationJEditor();
		}
		return( swingEditorJOracleTableImplementation );
	}

	public void setSwingEditorJOracleTableImplementation( JOracleTableImplementationJEditor value ) {
		swingEditorJOracleTableImplementation = value;
	}

	public JPgSqlTableImportJLabel getSwingLabelJPgSqlTableImport() {
		if( swingLabelJPgSqlTableImport == null ) {
			swingLabelJPgSqlTableImport = new JPgSqlTableImportJLabel();
		}
		return( swingLabelJPgSqlTableImport );
	}

	public void setSwingLabelJPgSqlTableImport( JPgSqlTableImportJLabel value ) {
		swingLabelJPgSqlTableImport = value;
	}

	public JPgSqlTableImportJEditor getSwingEditorJPgSqlTableImport() {
		if( swingEditorJPgSqlTableImport == null ) {
			swingEditorJPgSqlTableImport = new JPgSqlTableImportJEditor();
		}
		return( swingEditorJPgSqlTableImport );
	}

	public void setSwingEditorJPgSqlTableImport( JPgSqlTableImportJEditor value ) {
		swingEditorJPgSqlTableImport = value;
	}

	public JPgSqlTableMembersJLabel getSwingLabelJPgSqlTableMembers() {
		if( swingLabelJPgSqlTableMembers == null ) {
			swingLabelJPgSqlTableMembers = new JPgSqlTableMembersJLabel();
		}
		return( swingLabelJPgSqlTableMembers );
	}

	public void setSwingLabelJPgSqlTableMembers( JPgSqlTableMembersJLabel value ) {
		swingLabelJPgSqlTableMembers = value;
	}

	public JPgSqlTableMembersJEditor getSwingEditorJPgSqlTableMembers() {
		if( swingEditorJPgSqlTableMembers == null ) {
			swingEditorJPgSqlTableMembers = new JPgSqlTableMembersJEditor();
		}
		return( swingEditorJPgSqlTableMembers );
	}

	public void setSwingEditorJPgSqlTableMembers( JPgSqlTableMembersJEditor value ) {
		swingEditorJPgSqlTableMembers = value;
	}

	public JPgSqlTableImplementationJLabel getSwingLabelJPgSqlTableImplementation() {
		if( swingLabelJPgSqlTableImplementation == null ) {
			swingLabelJPgSqlTableImplementation = new JPgSqlTableImplementationJLabel();
		}
		return( swingLabelJPgSqlTableImplementation );
	}

	public void setSwingLabelJPgSqlTableImplementation( JPgSqlTableImplementationJLabel value ) {
		swingLabelJPgSqlTableImplementation = value;
	}

	public JPgSqlTableImplementationJEditor getSwingEditorJPgSqlTableImplementation() {
		if( swingEditorJPgSqlTableImplementation == null ) {
			swingEditorJPgSqlTableImplementation = new JPgSqlTableImplementationJEditor();
		}
		return( swingEditorJPgSqlTableImplementation );
	}

	public void setSwingEditorJPgSqlTableImplementation( JPgSqlTableImplementationJEditor value ) {
		swingEditorJPgSqlTableImplementation = value;
	}

	public JSybaseTableImportJLabel getSwingLabelJSybaseTableImport() {
		if( swingLabelJSybaseTableImport == null ) {
			swingLabelJSybaseTableImport = new JSybaseTableImportJLabel();
		}
		return( swingLabelJSybaseTableImport );
	}

	public void setSwingLabelJSybaseTableImport( JSybaseTableImportJLabel value ) {
		swingLabelJSybaseTableImport = value;
	}

	public JSybaseTableImportJEditor getSwingEditorJSybaseTableImport() {
		if( swingEditorJSybaseTableImport == null ) {
			swingEditorJSybaseTableImport = new JSybaseTableImportJEditor();
		}
		return( swingEditorJSybaseTableImport );
	}

	public void setSwingEditorJSybaseTableImport( JSybaseTableImportJEditor value ) {
		swingEditorJSybaseTableImport = value;
	}

	public JSybaseTableMembersJLabel getSwingLabelJSybaseTableMembers() {
		if( swingLabelJSybaseTableMembers == null ) {
			swingLabelJSybaseTableMembers = new JSybaseTableMembersJLabel();
		}
		return( swingLabelJSybaseTableMembers );
	}

	public void setSwingLabelJSybaseTableMembers( JSybaseTableMembersJLabel value ) {
		swingLabelJSybaseTableMembers = value;
	}

	public JSybaseTableMembersJEditor getSwingEditorJSybaseTableMembers() {
		if( swingEditorJSybaseTableMembers == null ) {
			swingEditorJSybaseTableMembers = new JSybaseTableMembersJEditor();
		}
		return( swingEditorJSybaseTableMembers );
	}

	public void setSwingEditorJSybaseTableMembers( JSybaseTableMembersJEditor value ) {
		swingEditorJSybaseTableMembers = value;
	}

	public JSybaseTableImplementationJLabel getSwingLabelJSybaseTableImplementation() {
		if( swingLabelJSybaseTableImplementation == null ) {
			swingLabelJSybaseTableImplementation = new JSybaseTableImplementationJLabel();
		}
		return( swingLabelJSybaseTableImplementation );
	}

	public void setSwingLabelJSybaseTableImplementation( JSybaseTableImplementationJLabel value ) {
		swingLabelJSybaseTableImplementation = value;
	}

	public JSybaseTableImplementationJEditor getSwingEditorJSybaseTableImplementation() {
		if( swingEditorJSybaseTableImplementation == null ) {
			swingEditorJSybaseTableImplementation = new JSybaseTableImplementationJEditor();
		}
		return( swingEditorJSybaseTableImplementation );
	}

	public void setSwingEditorJSybaseTableImplementation( JSybaseTableImplementationJEditor value ) {
		swingEditorJSybaseTableImplementation = value;
	}

	public JRamTableImportJLabel getSwingLabelJRamTableImport() {
		if( swingLabelJRamTableImport == null ) {
			swingLabelJRamTableImport = new JRamTableImportJLabel();
		}
		return( swingLabelJRamTableImport );
	}

	public void setSwingLabelJRamTableImport( JRamTableImportJLabel value ) {
		swingLabelJRamTableImport = value;
	}

	public JRamTableImportJEditor getSwingEditorJRamTableImport() {
		if( swingEditorJRamTableImport == null ) {
			swingEditorJRamTableImport = new JRamTableImportJEditor();
		}
		return( swingEditorJRamTableImport );
	}

	public void setSwingEditorJRamTableImport( JRamTableImportJEditor value ) {
		swingEditorJRamTableImport = value;
	}

	public JRamTableMembersJLabel getSwingLabelJRamTableMembers() {
		if( swingLabelJRamTableMembers == null ) {
			swingLabelJRamTableMembers = new JRamTableMembersJLabel();
		}
		return( swingLabelJRamTableMembers );
	}

	public void setSwingLabelJRamTableMembers( JRamTableMembersJLabel value ) {
		swingLabelJRamTableMembers = value;
	}

	public JRamTableMembersJEditor getSwingEditorJRamTableMembers() {
		if( swingEditorJRamTableMembers == null ) {
			swingEditorJRamTableMembers = new JRamTableMembersJEditor();
		}
		return( swingEditorJRamTableMembers );
	}

	public void setSwingEditorJRamTableMembers( JRamTableMembersJEditor value ) {
		swingEditorJRamTableMembers = value;
	}

	public JRamTableImplementationJLabel getSwingLabelJRamTableImplementation() {
		if( swingLabelJRamTableImplementation == null ) {
			swingLabelJRamTableImplementation = new JRamTableImplementationJLabel();
		}
		return( swingLabelJRamTableImplementation );
	}

	public void setSwingLabelJRamTableImplementation( JRamTableImplementationJLabel value ) {
		swingLabelJRamTableImplementation = value;
	}

	public JRamTableImplementationJEditor getSwingEditorJRamTableImplementation() {
		if( swingEditorJRamTableImplementation == null ) {
			swingEditorJRamTableImplementation = new JRamTableImplementationJEditor();
		}
		return( swingEditorJRamTableImplementation );
	}

	public void setSwingEditorJRamTableImplementation( JRamTableImplementationJEditor value ) {
		swingEditorJRamTableImplementation = value;
	}

	public JSaxLoaderImportJLabel getSwingLabelJSaxLoaderImport() {
		if( swingLabelJSaxLoaderImport == null ) {
			swingLabelJSaxLoaderImport = new JSaxLoaderImportJLabel();
		}
		return( swingLabelJSaxLoaderImport );
	}

	public void setSwingLabelJSaxLoaderImport( JSaxLoaderImportJLabel value ) {
		swingLabelJSaxLoaderImport = value;
	}

	public JSaxLoaderImportJEditor getSwingEditorJSaxLoaderImport() {
		if( swingEditorJSaxLoaderImport == null ) {
			swingEditorJSaxLoaderImport = new JSaxLoaderImportJEditor();
		}
		return( swingEditorJSaxLoaderImport );
	}

	public void setSwingEditorJSaxLoaderImport( JSaxLoaderImportJEditor value ) {
		swingEditorJSaxLoaderImport = value;
	}

	public JSaxLoaderStartElementJLabel getSwingLabelJSaxLoaderStartElement() {
		if( swingLabelJSaxLoaderStartElement == null ) {
			swingLabelJSaxLoaderStartElement = new JSaxLoaderStartElementJLabel();
		}
		return( swingLabelJSaxLoaderStartElement );
	}

	public void setSwingLabelJSaxLoaderStartElement( JSaxLoaderStartElementJLabel value ) {
		swingLabelJSaxLoaderStartElement = value;
	}

	public JSaxLoaderStartElementJEditor getSwingEditorJSaxLoaderStartElement() {
		if( swingEditorJSaxLoaderStartElement == null ) {
			swingEditorJSaxLoaderStartElement = new JSaxLoaderStartElementJEditor();
		}
		return( swingEditorJSaxLoaderStartElement );
	}

	public void setSwingEditorJSaxLoaderStartElement( JSaxLoaderStartElementJEditor value ) {
		swingEditorJSaxLoaderStartElement = value;
	}

	public JSaxLoaderEndElementJLabel getSwingLabelJSaxLoaderEndElement() {
		if( swingLabelJSaxLoaderEndElement == null ) {
			swingLabelJSaxLoaderEndElement = new JSaxLoaderEndElementJLabel();
		}
		return( swingLabelJSaxLoaderEndElement );
	}

	public void setSwingLabelJSaxLoaderEndElement( JSaxLoaderEndElementJLabel value ) {
		swingLabelJSaxLoaderEndElement = value;
	}

	public JSaxLoaderEndElementJEditor getSwingEditorJSaxLoaderEndElement() {
		if( swingEditorJSaxLoaderEndElement == null ) {
			swingEditorJSaxLoaderEndElement = new JSaxLoaderEndElementJEditor();
		}
		return( swingEditorJSaxLoaderEndElement );
	}

	public void setSwingEditorJSaxLoaderEndElement( JSaxLoaderEndElementJEditor value ) {
		swingEditorJSaxLoaderEndElement = value;
	}

	public JXMsgTableImportJLabel getSwingLabelJXMsgTableImport() {
		if( swingLabelJXMsgTableImport == null ) {
			swingLabelJXMsgTableImport = new JXMsgTableImportJLabel();
		}
		return( swingLabelJXMsgTableImport );
	}

	public void setSwingLabelJXMsgTableImport( JXMsgTableImportJLabel value ) {
		swingLabelJXMsgTableImport = value;
	}

	public JXMsgTableImportJEditor getSwingEditorJXMsgTableImport() {
		if( swingEditorJXMsgTableImport == null ) {
			swingEditorJXMsgTableImport = new JXMsgTableImportJEditor();
		}
		return( swingEditorJXMsgTableImport );
	}

	public void setSwingEditorJXMsgTableImport( JXMsgTableImportJEditor value ) {
		swingEditorJXMsgTableImport = value;
	}

	public JXMsgTableFormattersJLabel getSwingLabelJXMsgTableFormatters() {
		if( swingLabelJXMsgTableFormatters == null ) {
			swingLabelJXMsgTableFormatters = new JXMsgTableFormattersJLabel();
		}
		return( swingLabelJXMsgTableFormatters );
	}

	public void setSwingLabelJXMsgTableFormatters( JXMsgTableFormattersJLabel value ) {
		swingLabelJXMsgTableFormatters = value;
	}

	public JXMsgTableFormattersJEditor getSwingEditorJXMsgTableFormatters() {
		if( swingEditorJXMsgTableFormatters == null ) {
			swingEditorJXMsgTableFormatters = new JXMsgTableFormattersJEditor();
		}
		return( swingEditorJXMsgTableFormatters );
	}

	public void setSwingEditorJXMsgTableFormatters( JXMsgTableFormattersJEditor value ) {
		swingEditorJXMsgTableFormatters = value;
	}

	public JXMsgRqstTableImportJLabel getSwingLabelJXMsgRqstTableImport() {
		if( swingLabelJXMsgRqstTableImport == null ) {
			swingLabelJXMsgRqstTableImport = new JXMsgRqstTableImportJLabel();
		}
		return( swingLabelJXMsgRqstTableImport );
	}

	public void setSwingLabelJXMsgRqstTableImport( JXMsgRqstTableImportJLabel value ) {
		swingLabelJXMsgRqstTableImport = value;
	}

	public JXMsgRqstTableImportJEditor getSwingEditorJXMsgRqstTableImport() {
		if( swingEditorJXMsgRqstTableImport == null ) {
			swingEditorJXMsgRqstTableImport = new JXMsgRqstTableImportJEditor();
		}
		return( swingEditorJXMsgRqstTableImport );
	}

	public void setSwingEditorJXMsgRqstTableImport( JXMsgRqstTableImportJEditor value ) {
		swingEditorJXMsgRqstTableImport = value;
	}

	public JXMsgRspnTableImportJLabel getSwingLabelJXMsgRspnTableImport() {
		if( swingLabelJXMsgRspnTableImport == null ) {
			swingLabelJXMsgRspnTableImport = new JXMsgRspnTableImportJLabel();
		}
		return( swingLabelJXMsgRspnTableImport );
	}

	public void setSwingLabelJXMsgRspnTableImport( JXMsgRspnTableImportJLabel value ) {
		swingLabelJXMsgRspnTableImport = value;
	}

	public JXMsgRspnTableImportJEditor getSwingEditorJXMsgRspnTableImport() {
		if( swingEditorJXMsgRspnTableImport == null ) {
			swingEditorJXMsgRspnTableImport = new JXMsgRspnTableImportJEditor();
		}
		return( swingEditorJXMsgRspnTableImport );
	}

	public void setSwingEditorJXMsgRspnTableImport( JXMsgRspnTableImportJEditor value ) {
		swingEditorJXMsgRspnTableImport = value;
	}

	public JXMsgClientTableImportJLabel getSwingLabelJXMsgClientTableImport() {
		if( swingLabelJXMsgClientTableImport == null ) {
			swingLabelJXMsgClientTableImport = new JXMsgClientTableImportJLabel();
		}
		return( swingLabelJXMsgClientTableImport );
	}

	public void setSwingLabelJXMsgClientTableImport( JXMsgClientTableImportJLabel value ) {
		swingLabelJXMsgClientTableImport = value;
	}

	public JXMsgClientTableImportJEditor getSwingEditorJXMsgClientTableImport() {
		if( swingEditorJXMsgClientTableImport == null ) {
			swingEditorJXMsgClientTableImport = new JXMsgClientTableImportJEditor();
		}
		return( swingEditorJXMsgClientTableImport );
	}

	public void setSwingEditorJXMsgClientTableImport( JXMsgClientTableImportJEditor value ) {
		swingEditorJXMsgClientTableImport = value;
	}

	public JXMsgRqstTableBodyJLabel getSwingLabelJXMsgRqstTableBody() {
		if( swingLabelJXMsgRqstTableBody == null ) {
			swingLabelJXMsgRqstTableBody = new JXMsgRqstTableBodyJLabel();
		}
		return( swingLabelJXMsgRqstTableBody );
	}

	public void setSwingLabelJXMsgRqstTableBody( JXMsgRqstTableBodyJLabel value ) {
		swingLabelJXMsgRqstTableBody = value;
	}

	public JXMsgRqstTableBodyJEditor getSwingEditorJXMsgRqstTableBody() {
		if( swingEditorJXMsgRqstTableBody == null ) {
			swingEditorJXMsgRqstTableBody = new JXMsgRqstTableBodyJEditor();
		}
		return( swingEditorJXMsgRqstTableBody );
	}

	public void setSwingEditorJXMsgRqstTableBody( JXMsgRqstTableBodyJEditor value ) {
		swingEditorJXMsgRqstTableBody = value;
	}

	public JXMsgRspnTableBodyJLabel getSwingLabelJXMsgRspnTableBody() {
		if( swingLabelJXMsgRspnTableBody == null ) {
			swingLabelJXMsgRspnTableBody = new JXMsgRspnTableBodyJLabel();
		}
		return( swingLabelJXMsgRspnTableBody );
	}

	public void setSwingLabelJXMsgRspnTableBody( JXMsgRspnTableBodyJLabel value ) {
		swingLabelJXMsgRspnTableBody = value;
	}

	public JXMsgRspnTableBodyJEditor getSwingEditorJXMsgRspnTableBody() {
		if( swingEditorJXMsgRspnTableBody == null ) {
			swingEditorJXMsgRspnTableBody = new JXMsgRspnTableBodyJEditor();
		}
		return( swingEditorJXMsgRspnTableBody );
	}

	public void setSwingEditorJXMsgRspnTableBody( JXMsgRspnTableBodyJEditor value ) {
		swingEditorJXMsgRspnTableBody = value;
	}

	public JXMsgClientTableBodyJLabel getSwingLabelJXMsgClientTableBody() {
		if( swingLabelJXMsgClientTableBody == null ) {
			swingLabelJXMsgClientTableBody = new JXMsgClientTableBodyJLabel();
		}
		return( swingLabelJXMsgClientTableBody );
	}

	public void setSwingLabelJXMsgClientTableBody( JXMsgClientTableBodyJLabel value ) {
		swingLabelJXMsgClientTableBody = value;
	}

	public JXMsgClientTableBodyJEditor getSwingEditorJXMsgClientTableBody() {
		if( swingEditorJXMsgClientTableBody == null ) {
			swingEditorJXMsgClientTableBody = new JXMsgClientTableBodyJEditor();
		}
		return( swingEditorJXMsgClientTableBody );
	}

	public void setSwingEditorJXMsgClientTableBody( JXMsgClientTableBodyJEditor value ) {
		swingEditorJXMsgClientTableBody = value;
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

		label = getSwingLabelContainerSchemaDef();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSchemaDef();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupLookupIndex();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupLookupIndex();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupAltIndex();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupAltIndex();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupQualTable();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupQualTable();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupLoaderBehaviour();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupLoaderBehaviour();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupPrimaryIndex();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupPrimaryIndex();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDataScope();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDataScope();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupSecScope();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupSecScope();
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

		label = getSwingLabelTableClassCode();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorTableClassCode();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelPolyBase();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPolyBase();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelIsInstantiable();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorIsInstantiable();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelHasHistory();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHasHistory();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelHasAuditColumns();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHasAuditColumns();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelJObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJObjInterface();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjInterface();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJObjImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJObjImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJEditObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJEditObjInterface();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjInterface();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJEditObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJEditObjImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEditObjImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableInterface();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableInterface();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableObjInterface();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjInterface();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJTableObjImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJTableObjImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamTableMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamTableImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamTableImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderStartElement();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderStartElement();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSaxLoaderEndElement();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSaxLoaderEndElement();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgTableFormatters();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgTableFormatters();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientTableImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientTableImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstTableBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstTableBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnTableBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnTableBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientTableBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientTableBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

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
		ICFBamTableObj popObj;
		ICFBamTableObj focus = getSwingFocusAsTable();
		if( focus != null ) {
			popObj = (ICFBamTableObj)(focus.getEdit());
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
			swingContainerSchemaDefObj = null;
		}
		else {
			swingContainerSchemaDefObj = popObj.getRequiredContainerSchemaDef( swingIsInitializing );
		}
		if( swingReferenceContainerSchemaDef != null ) {
			swingReferenceContainerSchemaDef.setReferencedObject( swingContainerSchemaDefObj );
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
			swingLookupLookupIndexObj = null;
		}
		else {
			swingLookupLookupIndexObj = popObj.getOptionalLookupLookupIndex( swingIsInitializing );
		}
		if( swingReferenceLookupLookupIndex != null ) {
			swingReferenceLookupLookupIndex.setReferencedObject( swingLookupLookupIndexObj );
		}

		if( popObj == null ) {
			swingLookupAltIndexObj = null;
		}
		else {
			swingLookupAltIndexObj = popObj.getOptionalLookupAltIndex( swingIsInitializing );
		}
		if( swingReferenceLookupAltIndex != null ) {
			swingReferenceLookupAltIndex.setReferencedObject( swingLookupAltIndexObj );
		}

		if( popObj == null ) {
			swingLookupQualTableObj = null;
		}
		else {
			swingLookupQualTableObj = popObj.getOptionalLookupQualTable( swingIsInitializing );
		}
		if( swingReferenceLookupQualTable != null ) {
			swingReferenceLookupQualTable.setReferencedObject( swingLookupQualTableObj );
		}

		if( popObj == null ) {
			swingLookupLoaderBehaviourObj = null;
		}
		else {
			swingLookupLoaderBehaviourObj = popObj.getRequiredLookupLoaderBehaviour( swingIsInitializing );
		}
		if( swingReferenceLookupLoaderBehaviour != null ) {
			swingReferenceLookupLoaderBehaviour.setReferencedObject( swingLookupLoaderBehaviourObj );
		}

		if( popObj == null ) {
			swingLookupPrimaryIndexObj = null;
		}
		else {
			swingLookupPrimaryIndexObj = popObj.getOptionalLookupPrimaryIndex( swingIsInitializing );
		}
		if( swingReferenceLookupPrimaryIndex != null ) {
			swingReferenceLookupPrimaryIndex.setReferencedObject( swingLookupPrimaryIndexObj );
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
			swingLookupSecScopeObj = null;
		}
		else {
			swingLookupSecScopeObj = popObj.getRequiredLookupSecScope( swingIsInitializing );
		}
		if( swingReferenceLookupSecScope != null ) {
			swingReferenceLookupSecScope.setReferencedObject( swingLookupSecScopeObj );
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
			getSwingEditorDbName().setStringValue( null );
		}
		else {
			getSwingEditorDbName().setStringValue( popObj.getOptionalDbName() );
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
			getSwingEditorTableClassCode().setStringValue( null );
		}
		else {
			getSwingEditorTableClassCode().setStringValue( popObj.getRequiredTableClassCode() );
		}

		if( popObj == null ) {
			getSwingEditorPolyBase().setBooleanValue( null );
		}
		else {
			getSwingEditorPolyBase().setBooleanValue( popObj.getRequiredPolyBase() );
		}

		if( popObj == null ) {
			getSwingEditorIsInstantiable().setBooleanValue( null );
		}
		else {
			getSwingEditorIsInstantiable().setBooleanValue( popObj.getRequiredIsInstantiable() );
		}

		if( popObj == null ) {
			getSwingEditorHasHistory().setBooleanValue( null );
		}
		else {
			getSwingEditorHasHistory().setBooleanValue( popObj.getRequiredHasHistory() );
		}

		if( popObj == null ) {
			getSwingEditorHasAuditColumns().setBooleanValue( null );
		}
		else {
			getSwingEditorHasAuditColumns().setBooleanValue( popObj.getRequiredHasAuditColumns() );
		}

		if( popObj == null ) {
			getSwingEditorJObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJObjMembers().setTextValue( popObj.getOptionalJObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJObjInterface().setTextValue( null );
		}
		else {
			getSwingEditorJObjInterface().setTextValue( popObj.getOptionalJObjInterface() );
		}

		if( popObj == null ) {
			getSwingEditorJObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJObjImport().setTextValue( popObj.getOptionalJObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJObjImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJObjImplementation().setTextValue( popObj.getOptionalJObjImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJEditObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJEditObjMembers().setTextValue( popObj.getOptionalJEditObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJEditObjInterface().setTextValue( null );
		}
		else {
			getSwingEditorJEditObjInterface().setTextValue( popObj.getOptionalJEditObjInterface() );
		}

		if( popObj == null ) {
			getSwingEditorJEditObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJEditObjImport().setTextValue( popObj.getOptionalJEditObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJEditObjImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJEditObjImplementation().setTextValue( popObj.getOptionalJEditObjImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJTableImport().setTextValue( popObj.getOptionalJTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJTableMembers().setTextValue( popObj.getOptionalJTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJTableInterface().setTextValue( null );
		}
		else {
			getSwingEditorJTableInterface().setTextValue( popObj.getOptionalJTableInterface() );
		}

		if( popObj == null ) {
			getSwingEditorJTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJTableImplementation().setTextValue( popObj.getOptionalJTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJTableObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJTableObjImport().setTextValue( popObj.getOptionalJTableObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJTableObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJTableObjMembers().setTextValue( popObj.getOptionalJTableObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJTableObjInterface().setTextValue( null );
		}
		else {
			getSwingEditorJTableObjInterface().setTextValue( popObj.getOptionalJTableObjInterface() );
		}

		if( popObj == null ) {
			getSwingEditorJTableObjImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJTableObjImplementation().setTextValue( popObj.getOptionalJTableObjImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWTableImport().setTextValue( popObj.getOptionalJDb2LUWTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWTableMembers().setTextValue( popObj.getOptionalJDb2LUWTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWTableImplementation().setTextValue( popObj.getOptionalJDb2LUWTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlTableImport().setTextValue( popObj.getOptionalJMSSqlTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlTableMembers().setTextValue( popObj.getOptionalJMSSqlTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlTableImplementation().setTextValue( popObj.getOptionalJMSSqlTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlTableImport().setTextValue( popObj.getOptionalJMySqlTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlTableMembers().setTextValue( popObj.getOptionalJMySqlTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlTableImplementation().setTextValue( popObj.getOptionalJMySqlTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJOracleTableImport().setTextValue( popObj.getOptionalJOracleTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJOracleTableMembers().setTextValue( popObj.getOptionalJOracleTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJOracleTableImplementation().setTextValue( popObj.getOptionalJOracleTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlTableImport().setTextValue( popObj.getOptionalJPgSqlTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlTableMembers().setTextValue( popObj.getOptionalJPgSqlTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlTableImplementation().setTextValue( popObj.getOptionalJPgSqlTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseTableImport().setTextValue( popObj.getOptionalJSybaseTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseTableMembers().setTextValue( popObj.getOptionalJSybaseTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseTableImplementation().setTextValue( popObj.getOptionalJSybaseTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJRamTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJRamTableImport().setTextValue( popObj.getOptionalJRamTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJRamTableMembers().setTextValue( null );
		}
		else {
			getSwingEditorJRamTableMembers().setTextValue( popObj.getOptionalJRamTableMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJRamTableImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJRamTableImplementation().setTextValue( popObj.getOptionalJRamTableImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJSaxLoaderImport().setTextValue( null );
		}
		else {
			getSwingEditorJSaxLoaderImport().setTextValue( popObj.getOptionalJSaxLoaderImport() );
		}

		if( popObj == null ) {
			getSwingEditorJSaxLoaderStartElement().setTextValue( null );
		}
		else {
			getSwingEditorJSaxLoaderStartElement().setTextValue( popObj.getOptionalJSaxLoaderStartElement() );
		}

		if( popObj == null ) {
			getSwingEditorJSaxLoaderEndElement().setTextValue( null );
		}
		else {
			getSwingEditorJSaxLoaderEndElement().setTextValue( popObj.getOptionalJSaxLoaderEndElement() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgTableImport().setTextValue( popObj.getOptionalJXMsgTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgTableFormatters().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgTableFormatters().setTextValue( popObj.getOptionalJXMsgTableFormatters() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstTableImport().setTextValue( popObj.getOptionalJXMsgRqstTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnTableImport().setTextValue( popObj.getOptionalJXMsgRspnTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgClientTableImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgClientTableImport().setTextValue( popObj.getOptionalJXMsgClientTableImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstTableBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstTableBody().setTextValue( popObj.getOptionalJXMsgRqstTableBody() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnTableBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnTableBody().setTextValue( popObj.getOptionalJXMsgRspnTableBody() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgClientTableBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgClientTableBody().setTextValue( popObj.getOptionalJXMsgClientTableBody() );
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
		ICFBamTableObj focus = getSwingFocusAsTable();
		ICFBamTableEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamTableEditObj)(focus.getEdit());
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

		swingLookupLookupIndexObj = (ICFBamIndexObj)( swingReferenceLookupLookupIndex.getReferencedObject() );
		editObj.setOptionalLookupLookupIndex( swingLookupLookupIndexObj );

		swingLookupAltIndexObj = (ICFBamIndexObj)( swingReferenceLookupAltIndex.getReferencedObject() );
		editObj.setOptionalLookupAltIndex( swingLookupAltIndexObj );

		swingLookupQualTableObj = (ICFBamTableObj)( swingReferenceLookupQualTable.getReferencedObject() );
		editObj.setOptionalLookupQualTable( swingLookupQualTableObj );

		swingLookupLoaderBehaviourObj = (ICFBamLoaderBehaviourObj)( swingReferenceLookupLoaderBehaviour.getReferencedObject() );
		editObj.setRequiredLookupLoaderBehaviour( swingLookupLoaderBehaviourObj );

		swingLookupPrimaryIndexObj = (ICFBamIndexObj)( swingReferenceLookupPrimaryIndex.getReferencedObject() );
		editObj.setOptionalLookupPrimaryIndex( swingLookupPrimaryIndexObj );

		swingLookupDataScopeObj = (ICFBamDataScopeObj)( swingReferenceLookupDataScope.getReferencedObject() );
		editObj.setOptionalLookupDataScope( swingLookupDataScopeObj );

		swingLookupSecScopeObj = (ICFBamSecurityScopeObj)( swingReferenceLookupSecScope.getReferencedObject() );
		editObj.setRequiredLookupSecScope( swingLookupSecScopeObj );

		swingLookupVAccSecObj = (ICFBamAccessSecurityObj)( swingReferenceLookupVAccSec.getReferencedObject() );
		editObj.setOptionalLookupVAccSec( swingLookupVAccSecObj );

		swingLookupEAccSecObj = (ICFBamAccessSecurityObj)( swingReferenceLookupEAccSec.getReferencedObject() );
		editObj.setOptionalLookupEAccSec( swingLookupEAccSecObj );

		swingLookupVAccFreqObj = (ICFBamAccessFrequencyObj)( swingReferenceLookupVAccFreq.getReferencedObject() );
		editObj.setOptionalLookupVAccFreq( swingLookupVAccFreqObj );

		swingLookupEAccFreqObj = (ICFBamAccessFrequencyObj)( swingReferenceLookupEAccFreq.getReferencedObject() );
		editObj.setOptionalLookupEAccFreq( swingLookupEAccFreqObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalDbName( getSwingEditorDbName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredTableClassCode( getSwingEditorTableClassCode().getStringValue() );

		editObj.setRequiredPolyBase( getSwingEditorPolyBase().getBooleanValue() );

		editObj.setRequiredIsInstantiable( getSwingEditorIsInstantiable().getBooleanValue() );

		editObj.setRequiredHasHistory( getSwingEditorHasHistory().getBooleanValue() );

		editObj.setRequiredHasAuditColumns( getSwingEditorHasAuditColumns().getBooleanValue() );

		editObj.setOptionalJObjMembers( getSwingEditorJObjMembers().getTextValue() );

		editObj.setOptionalJObjInterface( getSwingEditorJObjInterface().getTextValue() );

		editObj.setOptionalJObjImport( getSwingEditorJObjImport().getTextValue() );

		editObj.setOptionalJObjImplementation( getSwingEditorJObjImplementation().getTextValue() );

		editObj.setOptionalJEditObjMembers( getSwingEditorJEditObjMembers().getTextValue() );

		editObj.setOptionalJEditObjInterface( getSwingEditorJEditObjInterface().getTextValue() );

		editObj.setOptionalJEditObjImport( getSwingEditorJEditObjImport().getTextValue() );

		editObj.setOptionalJEditObjImplementation( getSwingEditorJEditObjImplementation().getTextValue() );

		editObj.setOptionalJTableImport( getSwingEditorJTableImport().getTextValue() );

		editObj.setOptionalJTableMembers( getSwingEditorJTableMembers().getTextValue() );

		editObj.setOptionalJTableInterface( getSwingEditorJTableInterface().getTextValue() );

		editObj.setOptionalJTableImplementation( getSwingEditorJTableImplementation().getTextValue() );

		editObj.setOptionalJTableObjImport( getSwingEditorJTableObjImport().getTextValue() );

		editObj.setOptionalJTableObjMembers( getSwingEditorJTableObjMembers().getTextValue() );

		editObj.setOptionalJTableObjInterface( getSwingEditorJTableObjInterface().getTextValue() );

		editObj.setOptionalJTableObjImplementation( getSwingEditorJTableObjImplementation().getTextValue() );

		editObj.setOptionalJDb2LUWTableImport( getSwingEditorJDb2LUWTableImport().getTextValue() );

		editObj.setOptionalJDb2LUWTableMembers( getSwingEditorJDb2LUWTableMembers().getTextValue() );

		editObj.setOptionalJDb2LUWTableImplementation( getSwingEditorJDb2LUWTableImplementation().getTextValue() );

		editObj.setOptionalJMSSqlTableImport( getSwingEditorJMSSqlTableImport().getTextValue() );

		editObj.setOptionalJMSSqlTableMembers( getSwingEditorJMSSqlTableMembers().getTextValue() );

		editObj.setOptionalJMSSqlTableImplementation( getSwingEditorJMSSqlTableImplementation().getTextValue() );

		editObj.setOptionalJMySqlTableImport( getSwingEditorJMySqlTableImport().getTextValue() );

		editObj.setOptionalJMySqlTableMembers( getSwingEditorJMySqlTableMembers().getTextValue() );

		editObj.setOptionalJMySqlTableImplementation( getSwingEditorJMySqlTableImplementation().getTextValue() );

		editObj.setOptionalJOracleTableImport( getSwingEditorJOracleTableImport().getTextValue() );

		editObj.setOptionalJOracleTableMembers( getSwingEditorJOracleTableMembers().getTextValue() );

		editObj.setOptionalJOracleTableImplementation( getSwingEditorJOracleTableImplementation().getTextValue() );

		editObj.setOptionalJPgSqlTableImport( getSwingEditorJPgSqlTableImport().getTextValue() );

		editObj.setOptionalJPgSqlTableMembers( getSwingEditorJPgSqlTableMembers().getTextValue() );

		editObj.setOptionalJPgSqlTableImplementation( getSwingEditorJPgSqlTableImplementation().getTextValue() );

		editObj.setOptionalJSybaseTableImport( getSwingEditorJSybaseTableImport().getTextValue() );

		editObj.setOptionalJSybaseTableMembers( getSwingEditorJSybaseTableMembers().getTextValue() );

		editObj.setOptionalJSybaseTableImplementation( getSwingEditorJSybaseTableImplementation().getTextValue() );

		editObj.setOptionalJRamTableImport( getSwingEditorJRamTableImport().getTextValue() );

		editObj.setOptionalJRamTableMembers( getSwingEditorJRamTableMembers().getTextValue() );

		editObj.setOptionalJRamTableImplementation( getSwingEditorJRamTableImplementation().getTextValue() );

		editObj.setOptionalJSaxLoaderImport( getSwingEditorJSaxLoaderImport().getTextValue() );

		editObj.setOptionalJSaxLoaderStartElement( getSwingEditorJSaxLoaderStartElement().getTextValue() );

		editObj.setOptionalJSaxLoaderEndElement( getSwingEditorJSaxLoaderEndElement().getTextValue() );

		editObj.setOptionalJXMsgTableImport( getSwingEditorJXMsgTableImport().getTextValue() );

		editObj.setOptionalJXMsgTableFormatters( getSwingEditorJXMsgTableFormatters().getTextValue() );

		editObj.setOptionalJXMsgRqstTableImport( getSwingEditorJXMsgRqstTableImport().getTextValue() );

		editObj.setOptionalJXMsgRspnTableImport( getSwingEditorJXMsgRspnTableImport().getTextValue() );

		editObj.setOptionalJXMsgClientTableImport( getSwingEditorJXMsgClientTableImport().getTextValue() );

		editObj.setOptionalJXMsgRqstTableBody( getSwingEditorJXMsgRqstTableBody().getTextValue() );

		editObj.setOptionalJXMsgRspnTableBody( getSwingEditorJXMsgRspnTableBody().getTextValue() );

		editObj.setOptionalJXMsgClientTableBody( getSwingEditorJXMsgClientTableBody().getTextValue() );

		editObj.setRequiredDefaultVisibility( getSwingEditorDefaultVisibility().getBooleanValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamTableObj focus = getSwingFocusAsTable();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamTableEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamTableEditObj)focus.getEdit();
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
								editObj = (ICFBamTableEditObj)focus.beginEdit();
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
							editObj = (ICFBamTableEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamTableEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamTableEditObj)focus.beginEdit();
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
						focus = (ICFBamTableObj)editObj.create();
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
								editObj = (ICFBamTableEditObj)focus.beginEdit();
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
								editObj = (ICFBamTableEditObj)focus.beginEdit();
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
							editObj = (ICFBamTableEditObj)focus.beginEdit();
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
			ICFBamTableObj focus = getSwingFocusAsTable();
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
		if( swingReferenceContainerSchemaDef != null ) {
			swingReferenceContainerSchemaDef.setEnabled( false );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupLookupIndex != null ) {
			swingReferenceLookupLookupIndex.setEnabled( isEditing );
		}
		if( swingReferenceLookupAltIndex != null ) {
			swingReferenceLookupAltIndex.setEnabled( isEditing );
		}
		if( swingReferenceLookupQualTable != null ) {
			swingReferenceLookupQualTable.setEnabled( isEditing );
		}
		if( swingReferenceLookupLoaderBehaviour != null ) {
			swingReferenceLookupLoaderBehaviour.setEnabled( isEditing );
		}
		if( swingReferenceLookupPrimaryIndex != null ) {
			swingReferenceLookupPrimaryIndex.setEnabled( isEditing );
		}
		if( swingReferenceLookupDataScope != null ) {
			swingReferenceLookupDataScope.setEnabled( isEditing );
		}
		if( swingReferenceLookupSecScope != null ) {
			swingReferenceLookupSecScope.setEnabled( isEditing );
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
		if( swingEditorId != null ) {
			swingEditorId.setEnabled( false );
		}
		if( swingEditorName != null ) {
			swingEditorName.setEnabled( isEditing );
		}
		if( swingEditorDbName != null ) {
			swingEditorDbName.setEnabled( isEditing );
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
		if( swingEditorTableClassCode != null ) {
			swingEditorTableClassCode.setEnabled( isEditing );
		}
		if( swingEditorPolyBase != null ) {
			swingEditorPolyBase.setEnabled( isEditing );
		}
		if( swingEditorIsInstantiable != null ) {
			swingEditorIsInstantiable.setEnabled( isEditing );
		}
		if( swingEditorHasHistory != null ) {
			swingEditorHasHistory.setEnabled( isEditing );
		}
		if( swingEditorHasAuditColumns != null ) {
			swingEditorHasAuditColumns.setEnabled( isEditing );
		}
		if( swingEditorJObjMembers != null ) {
			swingEditorJObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJObjInterface != null ) {
			swingEditorJObjInterface.setEnabled( isEditing );
		}
		if( swingEditorJObjImport != null ) {
			swingEditorJObjImport.setEnabled( isEditing );
		}
		if( swingEditorJObjImplementation != null ) {
			swingEditorJObjImplementation.setEnabled( isEditing );
		}
		if( swingEditorJEditObjMembers != null ) {
			swingEditorJEditObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJEditObjInterface != null ) {
			swingEditorJEditObjInterface.setEnabled( isEditing );
		}
		if( swingEditorJEditObjImport != null ) {
			swingEditorJEditObjImport.setEnabled( isEditing );
		}
		if( swingEditorJEditObjImplementation != null ) {
			swingEditorJEditObjImplementation.setEnabled( isEditing );
		}
		if( swingEditorJTableImport != null ) {
			swingEditorJTableImport.setEnabled( isEditing );
		}
		if( swingEditorJTableMembers != null ) {
			swingEditorJTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJTableInterface != null ) {
			swingEditorJTableInterface.setEnabled( isEditing );
		}
		if( swingEditorJTableImplementation != null ) {
			swingEditorJTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJTableObjImport != null ) {
			swingEditorJTableObjImport.setEnabled( isEditing );
		}
		if( swingEditorJTableObjMembers != null ) {
			swingEditorJTableObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJTableObjInterface != null ) {
			swingEditorJTableObjInterface.setEnabled( isEditing );
		}
		if( swingEditorJTableObjImplementation != null ) {
			swingEditorJTableObjImplementation.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWTableImport != null ) {
			swingEditorJDb2LUWTableImport.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWTableMembers != null ) {
			swingEditorJDb2LUWTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWTableImplementation != null ) {
			swingEditorJDb2LUWTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlTableImport != null ) {
			swingEditorJMSSqlTableImport.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlTableMembers != null ) {
			swingEditorJMSSqlTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlTableImplementation != null ) {
			swingEditorJMSSqlTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJMySqlTableImport != null ) {
			swingEditorJMySqlTableImport.setEnabled( isEditing );
		}
		if( swingEditorJMySqlTableMembers != null ) {
			swingEditorJMySqlTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJMySqlTableImplementation != null ) {
			swingEditorJMySqlTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJOracleTableImport != null ) {
			swingEditorJOracleTableImport.setEnabled( isEditing );
		}
		if( swingEditorJOracleTableMembers != null ) {
			swingEditorJOracleTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJOracleTableImplementation != null ) {
			swingEditorJOracleTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlTableImport != null ) {
			swingEditorJPgSqlTableImport.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlTableMembers != null ) {
			swingEditorJPgSqlTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlTableImplementation != null ) {
			swingEditorJPgSqlTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJSybaseTableImport != null ) {
			swingEditorJSybaseTableImport.setEnabled( isEditing );
		}
		if( swingEditorJSybaseTableMembers != null ) {
			swingEditorJSybaseTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJSybaseTableImplementation != null ) {
			swingEditorJSybaseTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJRamTableImport != null ) {
			swingEditorJRamTableImport.setEnabled( isEditing );
		}
		if( swingEditorJRamTableMembers != null ) {
			swingEditorJRamTableMembers.setEnabled( isEditing );
		}
		if( swingEditorJRamTableImplementation != null ) {
			swingEditorJRamTableImplementation.setEnabled( isEditing );
		}
		if( swingEditorJSaxLoaderImport != null ) {
			swingEditorJSaxLoaderImport.setEnabled( isEditing );
		}
		if( swingEditorJSaxLoaderStartElement != null ) {
			swingEditorJSaxLoaderStartElement.setEnabled( isEditing );
		}
		if( swingEditorJSaxLoaderEndElement != null ) {
			swingEditorJSaxLoaderEndElement.setEnabled( isEditing );
		}
		if( swingEditorJXMsgTableImport != null ) {
			swingEditorJXMsgTableImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgTableFormatters != null ) {
			swingEditorJXMsgTableFormatters.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstTableImport != null ) {
			swingEditorJXMsgRqstTableImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnTableImport != null ) {
			swingEditorJXMsgRspnTableImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgClientTableImport != null ) {
			swingEditorJXMsgClientTableImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstTableBody != null ) {
			swingEditorJXMsgRqstTableBody.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnTableBody != null ) {
			swingEditorJXMsgRspnTableBody.setEnabled( isEditing );
		}
		if( swingEditorJXMsgClientTableBody != null ) {
			swingEditorJXMsgClientTableBody.setEnabled( isEditing );
		}
		if( swingEditorDefaultVisibility != null ) {
			swingEditorDefaultVisibility.setEnabled( isEditing );
		}
	}
}
