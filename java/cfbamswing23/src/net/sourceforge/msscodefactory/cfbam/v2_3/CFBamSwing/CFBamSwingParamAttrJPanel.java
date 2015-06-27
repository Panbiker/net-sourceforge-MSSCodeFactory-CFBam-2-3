// Description: Java 7 Swing Attribute JPanel implementation for Param.

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
 *	CFBamSwingParamAttrJPanel Swing Attribute JPanel implementation
 *	for Param.
 */
public class CFBamSwingParamAttrJPanel
extends CFJPanel
implements ICFBamSwingParamJPanelCommon
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
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
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

	protected class ServerMethodJLabel
		extends JLabel
	{
		public ServerMethodJLabel() {
			super();
			setText( "Containing Server Method" );
		}
	}

	protected class CallbackServerMethodChosen
	implements ICFBamSwingServerMethodChosen
	{
		public CallbackServerMethodChosen() {
		}

		public void choseServerMethod( ICFBamServerMethodObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerServerMeth != null ) {
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerServerMeth.setReferencedObject( value );
									editObj.setRequiredContainerServerMeth( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewServerMethodReference
	extends AbstractAction
	{
		public ActionViewServerMethodReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamServerMethodObj referencedObj = focus.getRequiredContainerServerMeth( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SRVM".equals( classCode ) ) {
						frame = swingSchema.getServerMethodFactory().newViewEditJInternalFrame( referencedObj );
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
				else if( "SRVP".equals( classCode ) ) {
					ICFBamServerProcObj obj = (ICFBamServerProcObj)referencedObj;
					frame = swingSchema.getServerProcFactory().newViewEditJInternalFrame( obj );
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
				else if( "SRVO".equals( classCode ) ) {
					ICFBamServerObjFuncObj obj = (ICFBamServerObjFuncObj)referencedObj;
					frame = swingSchema.getServerObjFuncFactory().newViewEditJInternalFrame( obj );
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
				else if( "SRVL".equals( classCode ) ) {
					ICFBamServerListFuncObj obj = (ICFBamServerListFuncObj)referencedObj;
					frame = swingSchema.getServerListFuncFactory().newViewEditJInternalFrame( obj );
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
							"ICFBamServerMethodObj, ICFBamServerProcObj, ICFBamServerObjFuncObj, ICFBamServerListFuncObj" );
					}
				}
			}
		}
	}

	protected class ActionPickServerMethodReference
	extends AbstractAction
	{
		public ActionPickServerMethodReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamServerMethodObj referencedObj = focus.getRequiredContainerServerMeth( swingIsInitializing );
			java.util.List<ICFBamServerMethodObj> listOfServerMethod = null;
			Collection<ICFBamServerMethodObj> cltn = null;
			JInternalFrame frame = swingSchema.getServerMethodFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackServerMethodChosen() );
			((ICFBamSwingServerMethodJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class ServerMethodCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public ServerMethodCFJReferenceEditor() {
			super( new ActionPickServerMethodReference(), new ActionViewServerMethodReference() );
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
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
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

	protected class TypeJLabel
		extends JLabel
	{
		public TypeJLabel() {
			super();
			setText( "Type Specification" );
		}
	}

	protected class CallbackTypeChosen
	implements ICFBamSwingValueChosen
	{
		public CallbackTypeChosen() {
		}

		public void choseValue( ICFBamValueObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupType != null ) {
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupType.setReferencedObject( value );
									editObj.setRequiredLookupType( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewTypeReference
	extends AbstractAction
	{
		public ActionViewTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamValueObj referencedObj = focus.getRequiredLookupType( swingIsInitializing );
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

	protected class ActionPickTypeReference
	extends AbstractAction
	{
		public ActionPickTypeReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamValueObj referencedObj = focus.getRequiredLookupType( swingIsInitializing );
			java.util.List<ICFBamValueObj> listOfValue = null;
			ICFBamServerMethodObj refServerMeth = focus.getRequiredContainerServerMeth( swingIsInitializing );
			if( refServerMeth == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a Containing Server Method before selecting a Type Specification",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			ICFBamTableObj refForTable = refServerMeth.getRequiredContainerForTable( swingIsInitializing );
			if( refForTable == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a For Table before selecting a Type Specification",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			ICFBamSchemaDefObj refSchemaDef = refForTable.getRequiredContainerSchemaDef( swingIsInitializing );
			if( refSchemaDef == null ) {
				JOptionPane.showMessageDialog( null,
					"You must specify a Containing Schema Definition before selecting a Type Specification",
					"Warning",
					JOptionPane.WARNING_MESSAGE );
				return;
			}
			listOfValue = refSchemaDef.getOptionalComponentsTypes( swingIsInitializing );
			if( listOfValue == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfValue" );
			}
			Collection<ICFBamValueObj> cltn = listOfValue;
			JInternalFrame frame = swingSchema.getValueFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackTypeChosen() );
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

	protected class TypeCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public TypeCFJReferenceEditor() {
			super( new ActionPickTypeReference(), new ActionViewTypeReference() );
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
	implements ICFBamSwingParamChosen
	{
		public CallbackPrevChosen() {
		}

		public void choseParam( ICFBamParamObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupPrev != null ) {
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamParamObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SPRM".equals( classCode ) ) {
						frame = swingSchema.getParamFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamParamObj" );
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamParamObj referencedObj = focus.getOptionalLookupPrev( swingIsInitializing );
			java.util.List<ICFBamParamObj> listOfParam = null;
			Collection<ICFBamParamObj> cltn = null;
			JInternalFrame frame = swingSchema.getParamFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackPrevChosen() );
			((ICFBamSwingParamJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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
	implements ICFBamSwingParamChosen
	{
		public CallbackNextChosen() {
		}

		public void choseParam( ICFBamParamObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupNext != null ) {
						ICFBamParamObj cur = getSwingFocusAsParam();
						if( cur != null ) {
							ICFBamParamEditObj editObj = (ICFBamParamEditObj)cur.getEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			if( focus != null ) {
				ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamParamObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SPRM".equals( classCode ) ) {
						frame = swingSchema.getParamFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamParamObj" );
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
			ICFBamParamObj focus = getSwingFocusAsParam();
			ICFBamParamEditObj editObj  = (ICFBamParamEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamParamObj referencedObj = focus.getOptionalLookupNext( swingIsInitializing );
			java.util.List<ICFBamParamObj> listOfParam = null;
			Collection<ICFBamParamObj> cltn = null;
			JInternalFrame frame = swingSchema.getParamFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackNextChosen() );
			((ICFBamSwingParamJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected ICFBamTenantObj swingOwnerTenantObj = null;
	protected TenantJLabel swingLabelOwnerTenant = null;
	protected TenantCFJReferenceEditor swingReferenceOwnerTenant = null;
	protected ICFBamServerMethodObj swingContainerServerMethObj = null;
	protected ServerMethodJLabel swingLabelContainerServerMeth = null;
	protected ServerMethodCFJReferenceEditor swingReferenceContainerServerMeth = null;
	protected ICFBamSchemaDefObj swingLookupDefSchemaObj = null;
	protected DefSchemaJLabel swingLabelLookupDefSchema = null;
	protected DefSchemaCFJReferenceEditor swingReferenceLookupDefSchema = null;
	protected ICFBamValueObj swingLookupTypeObj = null;
	protected TypeJLabel swingLabelLookupType = null;
	protected TypeCFJReferenceEditor swingReferenceLookupType = null;
	protected ICFBamParamObj swingLookupPrevObj = null;
	protected PrevJLabel swingLabelLookupPrev = null;
	protected PrevCFJReferenceEditor swingReferenceLookupPrev = null;
	protected ICFBamParamObj swingLookupNextObj = null;
	protected NextJLabel swingLabelLookupNext = null;
	protected NextCFJReferenceEditor swingReferenceLookupNext = null;
	protected IdJLabel swingLabelId = null;
	protected IdJEditor swingEditorId = null;
	protected NameJLabel swingLabelName = null;
	protected NameJEditor swingEditorName = null;
	protected ShortDescriptionJLabel swingLabelShortDescription = null;
	protected ShortDescriptionJEditor swingEditorShortDescription = null;
	protected DescriptionJLabel swingLabelDescription = null;
	protected DescriptionJEditor swingEditorDescription = null;
	protected IsNullableJLabel swingLabelIsNullable = null;
	protected IsNullableJEditor swingEditorIsNullable = null;

	public CFBamSwingParamAttrJPanel( ICFBamSwingSchema argSchema, ICFBamParamObj argFocus ) {
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
		setSwingFocusAsParam( argFocus );
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

		label = getSwingLabelContainerServerMeth();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerServerMeth();
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

		label = getSwingLabelLookupType();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupType();
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
		if( ( value == null ) || ( value instanceof ICFBamParamObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamParamObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamParamObj getSwingFocusAsParam() {
		return( (ICFBamParamObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsParam( ICFBamParamObj value ) {
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

	public ICFBamServerMethodObj getSwingContainerServerMethObj() {
		if( swingContainerServerMethObj == null ) {
		}
		return( swingContainerServerMethObj );
	}

	public void setSwingContainerServerMethObj( ICFBamServerMethodObj value ) {
		swingContainerServerMethObj = value;
	}

	public ServerMethodJLabel getSwingLabelContainerServerMeth() {
		if( swingLabelContainerServerMeth == null ) {
			swingLabelContainerServerMeth = new ServerMethodJLabel();
		}
		return( swingLabelContainerServerMeth );
	}

	public ServerMethodCFJReferenceEditor getSwingReferenceContainerServerMeth() {
		if( swingReferenceContainerServerMeth == null ) {
			swingReferenceContainerServerMeth = new ServerMethodCFJReferenceEditor();
		}
		return( swingReferenceContainerServerMeth );
	}

	public void setSwingReferenceContainerServerMeth( ServerMethodCFJReferenceEditor value ) {
		swingReferenceContainerServerMeth = value;
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

	public ICFBamValueObj getSwingLookupTypeObj() {
		return( swingLookupTypeObj );
	}

	public void setSwingLookupTypeObj( ICFBamValueObj value ) {
		swingLookupTypeObj = value;
	}

	public JLabel getSwingLabelLookupType() {
		if( swingLabelLookupType == null ) {
			swingLabelLookupType = new TypeJLabel();
		}
		return( swingLabelLookupType );
	}

	public CFJReferenceEditor getSwingReferenceLookupType() {
		if( swingReferenceLookupType == null ) {
			swingReferenceLookupType = new TypeCFJReferenceEditor();
		}
		return( swingReferenceLookupType );
	}

	public void setSwingReferenceLookupType( TypeCFJReferenceEditor value ) {
		swingReferenceLookupType = value;
	}

	public ICFBamParamObj getSwingLookupPrevObj() {
		return( swingLookupPrevObj );
	}

	public void setSwingLookupPrevObj( ICFBamParamObj value ) {
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

	public ICFBamParamObj getSwingLookupNextObj() {
		return( swingLookupNextObj );
	}

	public void setSwingLookupNextObj( ICFBamParamObj value ) {
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

		label = getSwingLabelContainerServerMeth();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerServerMeth();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefSchema();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefSchema();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupType();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupType();
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

	}

	public void populateFields()
	{
		ICFBamParamObj popObj;
		ICFBamParamObj focus = getSwingFocusAsParam();
		if( focus != null ) {
			popObj = (ICFBamParamObj)(focus.getEdit());
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
			swingContainerServerMethObj = null;
		}
		else {
			swingContainerServerMethObj = popObj.getRequiredContainerServerMeth( swingIsInitializing );
		}
		if( swingReferenceContainerServerMeth != null ) {
			swingReferenceContainerServerMeth.setReferencedObject( swingContainerServerMethObj );
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
			swingLookupTypeObj = null;
		}
		else {
			swingLookupTypeObj = popObj.getRequiredLookupType( swingIsInitializing );
		}
		if( swingReferenceLookupType != null ) {
			swingReferenceLookupType.setReferencedObject( swingLookupTypeObj );
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
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamParamObj focus = getSwingFocusAsParam();
		ICFBamParamEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamParamEditObj)(focus.getEdit());
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

		swingLookupTypeObj = (ICFBamValueObj)( swingReferenceLookupType.getReferencedObject() );
		editObj.setRequiredLookupType( swingLookupTypeObj );

		swingLookupPrevObj = (ICFBamParamObj)( swingReferenceLookupPrev.getReferencedObject() );
		editObj.setOptionalLookupPrev( swingLookupPrevObj );

		swingLookupNextObj = (ICFBamParamObj)( swingReferenceLookupNext.getReferencedObject() );
		editObj.setOptionalLookupNext( swingLookupNextObj );

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredIsNullable( getSwingEditorIsNullable().getBooleanValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamParamObj focus = getSwingFocusAsParam();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamParamEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamParamEditObj)focus.getEdit();
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
								editObj = (ICFBamParamEditObj)focus.beginEdit();
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
							editObj = (ICFBamParamEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamParamEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamParamEditObj)focus.beginEdit();
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
						focus = (ICFBamParamObj)editObj.create();
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
								editObj = (ICFBamParamEditObj)focus.beginEdit();
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
								editObj = (ICFBamParamEditObj)focus.beginEdit();
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
							editObj = (ICFBamParamEditObj)focus.beginEdit();
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
			ICFBamParamObj focus = getSwingFocusAsParam();
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
		if( swingReferenceContainerServerMeth != null ) {
			swingReferenceContainerServerMeth.setEnabled( false );
		}
		if( swingReferenceLookupDefSchema != null ) {
			swingReferenceLookupDefSchema.setEnabled( isEditing );
		}
		if( swingReferenceLookupType != null ) {
			swingReferenceLookupType.setEnabled( isEditing );
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
		if( swingEditorShortDescription != null ) {
			swingEditorShortDescription.setEnabled( isEditing );
		}
		if( swingEditorDescription != null ) {
			swingEditorDescription.setEnabled( isEditing );
		}
		if( swingEditorIsNullable != null ) {
			swingEditorIsNullable.setEnabled( isEditing );
		}
	}
}
