// Description: Java 7 Swing Attribute JPanel implementation for SchemaDef.

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
 *	CFBamSwingSchemaDefAttrJPanel Swing Attribute JPanel implementation
 *	for SchemaDef.
 */
public class CFBamSwingSchemaDefAttrJPanel
extends CFJPanel
implements ICFBamSwingSchemaDefJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class CTenantJLabel
		extends JLabel
	{
		public CTenantJLabel() {
			super();
			setText( "CTenant" );
		}
	}

	protected class CallbackCTenantChosen
	implements ICFBamSwingTenantChosen
	{
		public CallbackCTenantChosen() {
		}

		public void choseTenant( ICFBamTenantObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerCTenant != null ) {
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerCTenant.setReferencedObject( value );
									editObj.setRequiredOwnerCTenant( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewCTenantReference
	extends AbstractAction
	{
		public ActionViewCTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamTenantObj referencedObj = focus.getRequiredOwnerCTenant( swingIsInitializing );
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

	protected class ActionPickCTenantReference
	extends AbstractAction
	{
		public ActionPickCTenantReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamTenantObj referencedObj = focus.getRequiredOwnerCTenant( swingIsInitializing );
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
			JInternalFrame frame = swingSchema.getTenantFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackCTenantChosen() );
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

	protected class CTenantCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public CTenantCFJReferenceEditor() {
			super( new ActionPickCTenantReference(), new ActionViewCTenantReference() );
		}
	}

	protected class DomainJLabel
		extends JLabel
	{
		public DomainJLabel() {
			super();
			setText( "Domain" );
		}
	}

	protected class CallbackDomainChosen
	implements ICFBamSwingDomainBaseChosen
	{
		public CallbackDomainChosen() {
		}

		public void choseDomainBase( ICFBamDomainBaseObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerDomain != null ) {
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerDomain.setReferencedObject( value );
									editObj.setRequiredContainerDomain( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewDomainReference
	extends AbstractAction
	{
		public ActionViewDomainReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamDomainBaseObj referencedObj = focus.getRequiredContainerDomain( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "BDOM".equals( classCode ) ) {
						frame = swingSchema.getDomainBaseFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTopDomainObj obj = (ICFBamTopDomainObj)referencedObj;
					frame = swingSchema.getTopDomainFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamDomainObj obj = (ICFBamDomainObj)referencedObj;
					frame = swingSchema.getDomainFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamProjectBaseObj obj = (ICFBamProjectBaseObj)referencedObj;
					frame = swingSchema.getProjectBaseFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamRealProjectObj obj = (ICFBamRealProjectObj)referencedObj;
					frame = swingSchema.getRealProjectFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamTopProjectObj obj = (ICFBamTopProjectObj)referencedObj;
					frame = swingSchema.getTopProjectFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamSubProjectObj obj = (ICFBamSubProjectObj)referencedObj;
					frame = swingSchema.getSubProjectFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamVersionObj obj = (ICFBamVersionObj)referencedObj;
					frame = swingSchema.getVersionFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamMajorVersionObj obj = (ICFBamMajorVersionObj)referencedObj;
					frame = swingSchema.getMajorVersionFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
					ICFBamMinorVersionObj obj = (ICFBamMinorVersionObj)referencedObj;
					frame = swingSchema.getMinorVersionFactory().newViewEditJInternalFrame( obj );
					cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"ICFBamDomainBaseObj, ICFBamTopDomainObj, ICFBamDomainObj, ICFBamProjectBaseObj, ICFBamRealProjectObj, ICFBamTopProjectObj, ICFBamSubProjectObj, ICFBamVersionObj, ICFBamMajorVersionObj, ICFBamMinorVersionObj" );
					}
				}
			}
		}
	}

	protected class ActionPickDomainReference
	extends AbstractAction
	{
		public ActionPickDomainReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamDomainBaseObj referencedObj = focus.getRequiredContainerDomain( swingIsInitializing );
			java.util.List<ICFBamDomainBaseObj> listOfDomainBase = null;
			listOfDomainBase = schemaObj.getDomainBaseTableObj().readAllDomainBase();
			if( listOfDomainBase == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfDomainBase" );
			}
			Collection<ICFBamDomainBaseObj> cltn = listOfDomainBase;
			JInternalFrame frame = swingSchema.getDomainBaseFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackDomainChosen() );
			((ICFBamSwingDomainBaseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class DomainCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public DomainCFJReferenceEditor() {
			super( new ActionPickDomainReference(), new ActionViewDomainReference() );
		}
	}

	protected class DefaultLicenseJLabel
		extends JLabel
	{
		public DefaultLicenseJLabel() {
			super();
			setText( "Default License" );
		}
	}

	protected class CallbackDefaultLicenseChosen
	implements ICFBamSwingLicenseChosen
	{
		public CallbackDefaultLicenseChosen() {
		}

		public void choseLicense( ICFBamLicenseObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceLookupDefaultLicense != null ) {
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceLookupDefaultLicense.setReferencedObject( value );
									editObj.setOptionalLookupDefaultLicense( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewDefaultLicenseReference
	extends AbstractAction
	{
		public ActionViewDefaultLicenseReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamLicenseObj referencedObj = focus.getOptionalLookupDefaultLicense( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "LIC".equals( classCode ) ) {
						frame = swingSchema.getLicenseFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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
							"ICFBamLicenseObj" );
					}
				}
			}
		}
	}

	protected class ActionPickDefaultLicenseReference
	extends AbstractAction
	{
		public ActionPickDefaultLicenseReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamLicenseObj referencedObj = focus.getOptionalLookupDefaultLicense( swingIsInitializing );
			java.util.List<ICFBamLicenseObj> listOfLicense = null;
			Collection<ICFBamLicenseObj> cltn = null;
			JInternalFrame frame = swingSchema.getLicenseFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackDefaultLicenseChosen() );
			((ICFBamSwingLicenseJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
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

	protected class DefaultLicenseCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public DefaultLicenseCFJReferenceEditor() {
			super( new ActionPickDefaultLicenseReference(), new ActionViewDefaultLicenseReference() );
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
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
						ICFBamSchemaDefObj cur = getSwingFocusAsSchemaDef();
						if( cur != null ) {
							ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)cur.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus != null ) {
				ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			ICFBamSchemaDefEditObj editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
			setMaxLen( 12 );
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

	protected class ExtendCFCoreJLabel
		extends JLabel
	{
		public ExtendCFCoreJLabel() {
			super();
			setText( "ExtendCFCore" );
		}
	}

	protected class ExtendCFCoreJEditor
		extends CFJBoolEditor
	{
		public ExtendCFCoreJEditor() {
			super();
			setIsNullable( false );
		}
	}

	protected class CopyrightPeriodJLabel
		extends JLabel
	{
		public CopyrightPeriodJLabel() {
			super();
			setText( "CopyrightPeriod" );
		}
	}

	protected class CopyrightPeriodJEditor
		extends CFJStringEditor
	{
		public CopyrightPeriodJEditor() {
			super();
			setMaxLen( 10 );
		}
	}

	protected class CopyrightHolderJLabel
		extends JLabel
	{
		public CopyrightHolderJLabel() {
			super();
			setText( "CopyrightHolder" );
		}
	}

	protected class CopyrightHolderJEditor
		extends CFJStringEditor
	{
		public CopyrightHolderJEditor() {
			super();
			setMaxLen( 511 );
		}
	}

	protected class PublishURIJLabel
		extends JLabel
	{
		public PublishURIJLabel() {
			super();
			setText( "PublishURI" );
		}
	}

	protected class PublishURIJEditor
		extends CFJStringEditor
	{
		public PublishURIJEditor() {
			super();
			setMaxLen( 512 );
		}
	}

	protected class JSchemaObjImportJLabel
		extends JLabel
	{
		public JSchemaObjImportJLabel() {
			super();
			setText( "JSchemaObjImport" );
		}
	}

	protected class JSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSchemaObjInterfaceJLabel
		extends JLabel
	{
		public JSchemaObjInterfaceJLabel() {
			super();
			setText( "JSchemaObjInterface" );
		}
	}

	protected class JSchemaObjInterfaceJEditor
		extends CFJTextEditor
	{
		public JSchemaObjInterfaceJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSchemaObjMembersJLabel
		extends JLabel
	{
		public JSchemaObjMembersJLabel() {
			super();
			setText( "JSchemaObjMembers" );
		}
	}

	protected class JSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSchemaObjImplementationJLabel
		extends JLabel
	{
		public JSchemaObjImplementationJLabel() {
			super();
			setText( "JSchemaObjImplementation" );
		}
	}

	protected class JSchemaObjImplementationJEditor
		extends CFJTextEditor
	{
		public JSchemaObjImplementationJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWSchemaObjMembersJLabel
		extends JLabel
	{
		public JDb2LUWSchemaObjMembersJLabel() {
			super();
			setText( "JDb2LUWSchemaObjMembers" );
		}
	}

	protected class JDb2LUWSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JDb2LUWSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWSchemaObjImplJLabel
		extends JLabel
	{
		public JDb2LUWSchemaObjImplJLabel() {
			super();
			setText( "JDb2LUWSchemaObjImpl" );
		}
	}

	protected class JDb2LUWSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JDb2LUWSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JDb2LUWSchemaObjImportJLabel
		extends JLabel
	{
		public JDb2LUWSchemaObjImportJLabel() {
			super();
			setText( "JDb2LUWSchemaObjImport" );
		}
	}

	protected class JDb2LUWSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JDb2LUWSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlSchemaObjMembersJLabel
		extends JLabel
	{
		public JMSSqlSchemaObjMembersJLabel() {
			super();
			setText( "JMSSqlSchemaObjMembers" );
		}
	}

	protected class JMSSqlSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JMSSqlSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlSchemaObjImplJLabel
		extends JLabel
	{
		public JMSSqlSchemaObjImplJLabel() {
			super();
			setText( "JMSSqlSchemaObjImpl" );
		}
	}

	protected class JMSSqlSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JMSSqlSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMSSqlSchemaObjImportJLabel
		extends JLabel
	{
		public JMSSqlSchemaObjImportJLabel() {
			super();
			setText( "JMSSqlSchemaObjImport" );
		}
	}

	protected class JMSSqlSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JMSSqlSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlSchemaObjMembersJLabel
		extends JLabel
	{
		public JMySqlSchemaObjMembersJLabel() {
			super();
			setText( "JMySqlSchemaObjMembers" );
		}
	}

	protected class JMySqlSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JMySqlSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlSchemaObjImplJLabel
		extends JLabel
	{
		public JMySqlSchemaObjImplJLabel() {
			super();
			setText( "JMySqlSchemaObjImpl" );
		}
	}

	protected class JMySqlSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JMySqlSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JMySqlSchemaObjImportJLabel
		extends JLabel
	{
		public JMySqlSchemaObjImportJLabel() {
			super();
			setText( "JMySqlSchemaObjImport" );
		}
	}

	protected class JMySqlSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JMySqlSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleSchemaObjMembersJLabel
		extends JLabel
	{
		public JOracleSchemaObjMembersJLabel() {
			super();
			setText( "JOracleSchemaObjMembers" );
		}
	}

	protected class JOracleSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JOracleSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleSchemaObjImplJLabel
		extends JLabel
	{
		public JOracleSchemaObjImplJLabel() {
			super();
			setText( "JOracleSchemaObjImpl" );
		}
	}

	protected class JOracleSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JOracleSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JOracleSchemaObjImportJLabel
		extends JLabel
	{
		public JOracleSchemaObjImportJLabel() {
			super();
			setText( "JOracleSchemaObjImport" );
		}
	}

	protected class JOracleSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JOracleSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlSchemaObjMembersJLabel
		extends JLabel
	{
		public JPgSqlSchemaObjMembersJLabel() {
			super();
			setText( "JPgSqlSchemaObjMembers" );
		}
	}

	protected class JPgSqlSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JPgSqlSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlSchemaObjImplJLabel
		extends JLabel
	{
		public JPgSqlSchemaObjImplJLabel() {
			super();
			setText( "JPgSqlSchemaObjImpl" );
		}
	}

	protected class JPgSqlSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JPgSqlSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JPgSqlSchemaObjImportJLabel
		extends JLabel
	{
		public JPgSqlSchemaObjImportJLabel() {
			super();
			setText( "JPgSqlSchemaObjImport" );
		}
	}

	protected class JPgSqlSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JPgSqlSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseSchemaObjMembersJLabel
		extends JLabel
	{
		public JSybaseSchemaObjMembersJLabel() {
			super();
			setText( "JSybaseSchemaObjMembers" );
		}
	}

	protected class JSybaseSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JSybaseSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseSchemaObjImplJLabel
		extends JLabel
	{
		public JSybaseSchemaObjImplJLabel() {
			super();
			setText( "JSybaseSchemaObjImpl" );
		}
	}

	protected class JSybaseSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JSybaseSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JSybaseSchemaObjImportJLabel
		extends JLabel
	{
		public JSybaseSchemaObjImportJLabel() {
			super();
			setText( "JSybaseSchemaObjImport" );
		}
	}

	protected class JSybaseSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JSybaseSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamSchemaObjMembersJLabel
		extends JLabel
	{
		public JRamSchemaObjMembersJLabel() {
			super();
			setText( "JRamSchemaObjMembers" );
		}
	}

	protected class JRamSchemaObjMembersJEditor
		extends CFJTextEditor
	{
		public JRamSchemaObjMembersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamSchemaObjImplJLabel
		extends JLabel
	{
		public JRamSchemaObjImplJLabel() {
			super();
			setText( "JRamSchemaObjImpl" );
		}
	}

	protected class JRamSchemaObjImplJEditor
		extends CFJTextEditor
	{
		public JRamSchemaObjImplJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JRamSchemaObjImportJLabel
		extends JLabel
	{
		public JRamSchemaObjImportJLabel() {
			super();
			setText( "JRamSchemaObjImport" );
		}
	}

	protected class JRamSchemaObjImportJEditor
		extends CFJTextEditor
	{
		public JRamSchemaObjImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgSchemaImportJLabel
		extends JLabel
	{
		public JXMsgSchemaImportJLabel() {
			super();
			setText( "JXMsgSchemaImport" );
		}
	}

	protected class JXMsgSchemaImportJEditor
		extends CFJTextEditor
	{
		public JXMsgSchemaImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgSchemaFormattersJLabel
		extends JLabel
	{
		public JXMsgSchemaFormattersJLabel() {
			super();
			setText( "JXMsgSchemaFormatters" );
		}
	}

	protected class JXMsgSchemaFormattersJEditor
		extends CFJTextEditor
	{
		public JXMsgSchemaFormattersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgClientSchemaImportJLabel
		extends JLabel
	{
		public JXMsgClientSchemaImportJLabel() {
			super();
			setText( "JXMsgClientSchemaImport" );
		}
	}

	protected class JXMsgClientSchemaImportJEditor
		extends CFJTextEditor
	{
		public JXMsgClientSchemaImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgClientSchemaBodyJLabel
		extends JLabel
	{
		public JXMsgClientSchemaBodyJLabel() {
			super();
			setText( "JXMsgClientSchemaBody" );
		}
	}

	protected class JXMsgClientSchemaBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgClientSchemaBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstSchemaBodyJLabel
		extends JLabel
	{
		public JXMsgRqstSchemaBodyJLabel() {
			super();
			setText( "JXMsgRqstSchemaBody" );
		}
	}

	protected class JXMsgRqstSchemaBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstSchemaBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstSchemaImportJLabel
		extends JLabel
	{
		public JXMsgRqstSchemaImportJLabel() {
			super();
			setText( "JXMsgRqstSchemaImport" );
		}
	}

	protected class JXMsgRqstSchemaImportJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstSchemaImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstSchemaWireParsersJLabel
		extends JLabel
	{
		public JXMsgRqstSchemaWireParsersJLabel() {
			super();
			setText( "JXMsgRqstSchemaWireParsers" );
		}
	}

	protected class JXMsgRqstSchemaWireParsersJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstSchemaWireParsersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstSchemaXsdSpecJLabel
		extends JLabel
	{
		public JXMsgRqstSchemaXsdSpecJLabel() {
			super();
			setText( "JXMsgRqstSchemaXsdSpec" );
		}
	}

	protected class JXMsgRqstSchemaXsdSpecJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstSchemaXsdSpecJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRqstSchemaXsdElementListJLabel
		extends JLabel
	{
		public JXMsgRqstSchemaXsdElementListJLabel() {
			super();
			setText( "JXMsgRqstSchemaXsdElementList" );
		}
	}

	protected class JXMsgRqstSchemaXsdElementListJEditor
		extends CFJTextEditor
	{
		public JXMsgRqstSchemaXsdElementListJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnSchemaBodyJLabel
		extends JLabel
	{
		public JXMsgRspnSchemaBodyJLabel() {
			super();
			setText( "JXMsgRspnSchemaBody" );
		}
	}

	protected class JXMsgRspnSchemaBodyJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnSchemaBodyJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnSchemaImportJLabel
		extends JLabel
	{
		public JXMsgRspnSchemaImportJLabel() {
			super();
			setText( "JXMsgRspnSchemaImport" );
		}
	}

	protected class JXMsgRspnSchemaImportJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnSchemaImportJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnSchemaWireParsersJLabel
		extends JLabel
	{
		public JXMsgRspnSchemaWireParsersJLabel() {
			super();
			setText( "JXMsgRspnSchemaWireParsers" );
		}
	}

	protected class JXMsgRspnSchemaWireParsersJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnSchemaWireParsersJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnSchemaXsdElementListJLabel
		extends JLabel
	{
		public JXMsgRspnSchemaXsdElementListJLabel() {
			super();
			setText( "JXMsgRspnSchemaXsdElementList" );
		}
	}

	protected class JXMsgRspnSchemaXsdElementListJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnSchemaXsdElementListJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected class JXMsgRspnSchemaXsdSpecJLabel
		extends JLabel
	{
		public JXMsgRspnSchemaXsdSpecJLabel() {
			super();
			setText( "JXMsgRspnSchemaXsdSpec" );
		}
	}

	protected class JXMsgRspnSchemaXsdSpecJEditor
		extends CFJTextEditor
	{
		public JXMsgRspnSchemaXsdSpecJEditor() {
			super();
			setMaxLen( 2000000 );
		}
	}

	protected ICFBamTenantObj swingOwnerCTenantObj = null;
	protected CTenantJLabel swingLabelOwnerCTenant = null;
	protected CTenantCFJReferenceEditor swingReferenceOwnerCTenant = null;
	protected ICFBamDomainBaseObj swingContainerDomainObj = null;
	protected DomainJLabel swingLabelContainerDomain = null;
	protected DomainCFJReferenceEditor swingReferenceContainerDomain = null;
	protected ICFBamLicenseObj swingLookupDefaultLicenseObj = null;
	protected DefaultLicenseJLabel swingLabelLookupDefaultLicense = null;
	protected DefaultLicenseCFJReferenceEditor swingReferenceLookupDefaultLicense = null;
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
	protected ExtendCFCoreJLabel swingLabelExtendCFCore = null;
	protected ExtendCFCoreJEditor swingEditorExtendCFCore = null;
	protected CopyrightPeriodJLabel swingLabelCopyrightPeriod = null;
	protected CopyrightPeriodJEditor swingEditorCopyrightPeriod = null;
	protected CopyrightHolderJLabel swingLabelCopyrightHolder = null;
	protected CopyrightHolderJEditor swingEditorCopyrightHolder = null;
	protected PublishURIJLabel swingLabelPublishURI = null;
	protected PublishURIJEditor swingEditorPublishURI = null;
	protected JSchemaObjImportJLabel swingLabelJSchemaObjImport = null;
	protected JSchemaObjImportJEditor swingEditorJSchemaObjImport = null;
	protected JSchemaObjInterfaceJLabel swingLabelJSchemaObjInterface = null;
	protected JSchemaObjInterfaceJEditor swingEditorJSchemaObjInterface = null;
	protected JSchemaObjMembersJLabel swingLabelJSchemaObjMembers = null;
	protected JSchemaObjMembersJEditor swingEditorJSchemaObjMembers = null;
	protected JSchemaObjImplementationJLabel swingLabelJSchemaObjImplementation = null;
	protected JSchemaObjImplementationJEditor swingEditorJSchemaObjImplementation = null;
	protected JDb2LUWSchemaObjMembersJLabel swingLabelJDb2LUWSchemaObjMembers = null;
	protected JDb2LUWSchemaObjMembersJEditor swingEditorJDb2LUWSchemaObjMembers = null;
	protected JDb2LUWSchemaObjImplJLabel swingLabelJDb2LUWSchemaObjImpl = null;
	protected JDb2LUWSchemaObjImplJEditor swingEditorJDb2LUWSchemaObjImpl = null;
	protected JDb2LUWSchemaObjImportJLabel swingLabelJDb2LUWSchemaObjImport = null;
	protected JDb2LUWSchemaObjImportJEditor swingEditorJDb2LUWSchemaObjImport = null;
	protected JMSSqlSchemaObjMembersJLabel swingLabelJMSSqlSchemaObjMembers = null;
	protected JMSSqlSchemaObjMembersJEditor swingEditorJMSSqlSchemaObjMembers = null;
	protected JMSSqlSchemaObjImplJLabel swingLabelJMSSqlSchemaObjImpl = null;
	protected JMSSqlSchemaObjImplJEditor swingEditorJMSSqlSchemaObjImpl = null;
	protected JMSSqlSchemaObjImportJLabel swingLabelJMSSqlSchemaObjImport = null;
	protected JMSSqlSchemaObjImportJEditor swingEditorJMSSqlSchemaObjImport = null;
	protected JMySqlSchemaObjMembersJLabel swingLabelJMySqlSchemaObjMembers = null;
	protected JMySqlSchemaObjMembersJEditor swingEditorJMySqlSchemaObjMembers = null;
	protected JMySqlSchemaObjImplJLabel swingLabelJMySqlSchemaObjImpl = null;
	protected JMySqlSchemaObjImplJEditor swingEditorJMySqlSchemaObjImpl = null;
	protected JMySqlSchemaObjImportJLabel swingLabelJMySqlSchemaObjImport = null;
	protected JMySqlSchemaObjImportJEditor swingEditorJMySqlSchemaObjImport = null;
	protected JOracleSchemaObjMembersJLabel swingLabelJOracleSchemaObjMembers = null;
	protected JOracleSchemaObjMembersJEditor swingEditorJOracleSchemaObjMembers = null;
	protected JOracleSchemaObjImplJLabel swingLabelJOracleSchemaObjImpl = null;
	protected JOracleSchemaObjImplJEditor swingEditorJOracleSchemaObjImpl = null;
	protected JOracleSchemaObjImportJLabel swingLabelJOracleSchemaObjImport = null;
	protected JOracleSchemaObjImportJEditor swingEditorJOracleSchemaObjImport = null;
	protected JPgSqlSchemaObjMembersJLabel swingLabelJPgSqlSchemaObjMembers = null;
	protected JPgSqlSchemaObjMembersJEditor swingEditorJPgSqlSchemaObjMembers = null;
	protected JPgSqlSchemaObjImplJLabel swingLabelJPgSqlSchemaObjImpl = null;
	protected JPgSqlSchemaObjImplJEditor swingEditorJPgSqlSchemaObjImpl = null;
	protected JPgSqlSchemaObjImportJLabel swingLabelJPgSqlSchemaObjImport = null;
	protected JPgSqlSchemaObjImportJEditor swingEditorJPgSqlSchemaObjImport = null;
	protected JSybaseSchemaObjMembersJLabel swingLabelJSybaseSchemaObjMembers = null;
	protected JSybaseSchemaObjMembersJEditor swingEditorJSybaseSchemaObjMembers = null;
	protected JSybaseSchemaObjImplJLabel swingLabelJSybaseSchemaObjImpl = null;
	protected JSybaseSchemaObjImplJEditor swingEditorJSybaseSchemaObjImpl = null;
	protected JSybaseSchemaObjImportJLabel swingLabelJSybaseSchemaObjImport = null;
	protected JSybaseSchemaObjImportJEditor swingEditorJSybaseSchemaObjImport = null;
	protected JRamSchemaObjMembersJLabel swingLabelJRamSchemaObjMembers = null;
	protected JRamSchemaObjMembersJEditor swingEditorJRamSchemaObjMembers = null;
	protected JRamSchemaObjImplJLabel swingLabelJRamSchemaObjImpl = null;
	protected JRamSchemaObjImplJEditor swingEditorJRamSchemaObjImpl = null;
	protected JRamSchemaObjImportJLabel swingLabelJRamSchemaObjImport = null;
	protected JRamSchemaObjImportJEditor swingEditorJRamSchemaObjImport = null;
	protected JXMsgSchemaImportJLabel swingLabelJXMsgSchemaImport = null;
	protected JXMsgSchemaImportJEditor swingEditorJXMsgSchemaImport = null;
	protected JXMsgSchemaFormattersJLabel swingLabelJXMsgSchemaFormatters = null;
	protected JXMsgSchemaFormattersJEditor swingEditorJXMsgSchemaFormatters = null;
	protected JXMsgClientSchemaImportJLabel swingLabelJXMsgClientSchemaImport = null;
	protected JXMsgClientSchemaImportJEditor swingEditorJXMsgClientSchemaImport = null;
	protected JXMsgClientSchemaBodyJLabel swingLabelJXMsgClientSchemaBody = null;
	protected JXMsgClientSchemaBodyJEditor swingEditorJXMsgClientSchemaBody = null;
	protected JXMsgRqstSchemaBodyJLabel swingLabelJXMsgRqstSchemaBody = null;
	protected JXMsgRqstSchemaBodyJEditor swingEditorJXMsgRqstSchemaBody = null;
	protected JXMsgRqstSchemaImportJLabel swingLabelJXMsgRqstSchemaImport = null;
	protected JXMsgRqstSchemaImportJEditor swingEditorJXMsgRqstSchemaImport = null;
	protected JXMsgRqstSchemaWireParsersJLabel swingLabelJXMsgRqstSchemaWireParsers = null;
	protected JXMsgRqstSchemaWireParsersJEditor swingEditorJXMsgRqstSchemaWireParsers = null;
	protected JXMsgRqstSchemaXsdSpecJLabel swingLabelJXMsgRqstSchemaXsdSpec = null;
	protected JXMsgRqstSchemaXsdSpecJEditor swingEditorJXMsgRqstSchemaXsdSpec = null;
	protected JXMsgRqstSchemaXsdElementListJLabel swingLabelJXMsgRqstSchemaXsdElementList = null;
	protected JXMsgRqstSchemaXsdElementListJEditor swingEditorJXMsgRqstSchemaXsdElementList = null;
	protected JXMsgRspnSchemaBodyJLabel swingLabelJXMsgRspnSchemaBody = null;
	protected JXMsgRspnSchemaBodyJEditor swingEditorJXMsgRspnSchemaBody = null;
	protected JXMsgRspnSchemaImportJLabel swingLabelJXMsgRspnSchemaImport = null;
	protected JXMsgRspnSchemaImportJEditor swingEditorJXMsgRspnSchemaImport = null;
	protected JXMsgRspnSchemaWireParsersJLabel swingLabelJXMsgRspnSchemaWireParsers = null;
	protected JXMsgRspnSchemaWireParsersJEditor swingEditorJXMsgRspnSchemaWireParsers = null;
	protected JXMsgRspnSchemaXsdElementListJLabel swingLabelJXMsgRspnSchemaXsdElementList = null;
	protected JXMsgRspnSchemaXsdElementListJEditor swingEditorJXMsgRspnSchemaXsdElementList = null;
	protected JXMsgRspnSchemaXsdSpecJLabel swingLabelJXMsgRspnSchemaXsdSpec = null;
	protected JXMsgRspnSchemaXsdSpecJEditor swingEditorJXMsgRspnSchemaXsdSpec = null;

	public CFBamSwingSchemaDefAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSchemaDefObj argFocus ) {
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
		setSwingFocusAsSchemaDef( argFocus );
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

		label = getSwingLabelOwnerCTenant();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCTenant();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerDomain();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerDomain();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefaultLicense();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefaultLicense();
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

		label = getSwingLabelExtendCFCore();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorExtendCFCore();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelCopyrightPeriod();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorCopyrightPeriod();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelCopyrightHolder();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorCopyrightHolder();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelPublishURI();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPublishURI();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelJSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjInterface();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjInterface();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjImplementation();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjImplementation();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjMembers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjMembers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjImpl();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjImpl();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgSchemaImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgSchemaImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgSchemaFormatters();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgSchemaFormatters();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientSchemaImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientSchemaImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientSchemaBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientSchemaBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaWireParsers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaWireParsers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaXsdSpec();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaXsdSpec();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaXsdElementList();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaXsdElementList();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaBody();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaBody();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaImport();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaImport();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaWireParsers();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaWireParsers();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaXsdElementList();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaXsdElementList();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, textheight );
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaXsdSpec();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaXsdSpec();
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
		if( ( value == null ) || ( value instanceof ICFBamSchemaDefObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSchemaDefObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSchemaDefObj getSwingFocusAsSchemaDef() {
		return( (ICFBamSchemaDefObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSchemaDef( ICFBamSchemaDefObj value ) {
		setSwingFocus( value );
	}

	public ICFBamTenantObj getSwingOwnerCTenantObj() {
		return( swingOwnerCTenantObj );
	}

	public void setSwingOwnerCTenantObj( ICFBamTenantObj value ) {
		swingOwnerCTenantObj = value;
	}

	public CTenantJLabel getSwingLabelOwnerCTenant() {
		if( swingLabelOwnerCTenant == null ) {
			swingLabelOwnerCTenant = new CTenantJLabel();
		}
		return( swingLabelOwnerCTenant );
	}

	public CFJReferenceEditor getSwingReferenceOwnerCTenant() {
		if( swingReferenceOwnerCTenant == null ) {
			swingReferenceOwnerCTenant = new CTenantCFJReferenceEditor();
		}
		return( swingReferenceOwnerCTenant );
	}

	public void setSwingReferenceOwnerCTenant( CTenantCFJReferenceEditor value ) {
		swingReferenceOwnerCTenant = value;
	}

	public ICFBamDomainBaseObj getSwingContainerDomainObj() {
		if( swingContainerDomainObj == null ) {
		}
		return( swingContainerDomainObj );
	}

	public void setSwingContainerDomainObj( ICFBamDomainBaseObj value ) {
		swingContainerDomainObj = value;
	}

	public DomainJLabel getSwingLabelContainerDomain() {
		if( swingLabelContainerDomain == null ) {
			swingLabelContainerDomain = new DomainJLabel();
		}
		return( swingLabelContainerDomain );
	}

	public DomainCFJReferenceEditor getSwingReferenceContainerDomain() {
		if( swingReferenceContainerDomain == null ) {
			swingReferenceContainerDomain = new DomainCFJReferenceEditor();
		}
		return( swingReferenceContainerDomain );
	}

	public void setSwingReferenceContainerDomain( DomainCFJReferenceEditor value ) {
		swingReferenceContainerDomain = value;
	}

	public ICFBamLicenseObj getSwingLookupDefaultLicenseObj() {
		return( swingLookupDefaultLicenseObj );
	}

	public void setSwingLookupDefaultLicenseObj( ICFBamLicenseObj value ) {
		swingLookupDefaultLicenseObj = value;
	}

	public JLabel getSwingLabelLookupDefaultLicense() {
		if( swingLabelLookupDefaultLicense == null ) {
			swingLabelLookupDefaultLicense = new DefaultLicenseJLabel();
		}
		return( swingLabelLookupDefaultLicense );
	}

	public CFJReferenceEditor getSwingReferenceLookupDefaultLicense() {
		if( swingReferenceLookupDefaultLicense == null ) {
			swingReferenceLookupDefaultLicense = new DefaultLicenseCFJReferenceEditor();
		}
		return( swingReferenceLookupDefaultLicense );
	}

	public void setSwingReferenceLookupDefaultLicense( DefaultLicenseCFJReferenceEditor value ) {
		swingReferenceLookupDefaultLicense = value;
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

	public ExtendCFCoreJLabel getSwingLabelExtendCFCore() {
		if( swingLabelExtendCFCore == null ) {
			swingLabelExtendCFCore = new ExtendCFCoreJLabel();
		}
		return( swingLabelExtendCFCore );
	}

	public void setSwingLabelExtendCFCore( ExtendCFCoreJLabel value ) {
		swingLabelExtendCFCore = value;
	}

	public ExtendCFCoreJEditor getSwingEditorExtendCFCore() {
		if( swingEditorExtendCFCore == null ) {
			swingEditorExtendCFCore = new ExtendCFCoreJEditor();
		}
		return( swingEditorExtendCFCore );
	}

	public void setSwingEditorExtendCFCore( ExtendCFCoreJEditor value ) {
		swingEditorExtendCFCore = value;
	}

	public CopyrightPeriodJLabel getSwingLabelCopyrightPeriod() {
		if( swingLabelCopyrightPeriod == null ) {
			swingLabelCopyrightPeriod = new CopyrightPeriodJLabel();
		}
		return( swingLabelCopyrightPeriod );
	}

	public void setSwingLabelCopyrightPeriod( CopyrightPeriodJLabel value ) {
		swingLabelCopyrightPeriod = value;
	}

	public CopyrightPeriodJEditor getSwingEditorCopyrightPeriod() {
		if( swingEditorCopyrightPeriod == null ) {
			swingEditorCopyrightPeriod = new CopyrightPeriodJEditor();
		}
		return( swingEditorCopyrightPeriod );
	}

	public void setSwingEditorCopyrightPeriod( CopyrightPeriodJEditor value ) {
		swingEditorCopyrightPeriod = value;
	}

	public CopyrightHolderJLabel getSwingLabelCopyrightHolder() {
		if( swingLabelCopyrightHolder == null ) {
			swingLabelCopyrightHolder = new CopyrightHolderJLabel();
		}
		return( swingLabelCopyrightHolder );
	}

	public void setSwingLabelCopyrightHolder( CopyrightHolderJLabel value ) {
		swingLabelCopyrightHolder = value;
	}

	public CopyrightHolderJEditor getSwingEditorCopyrightHolder() {
		if( swingEditorCopyrightHolder == null ) {
			swingEditorCopyrightHolder = new CopyrightHolderJEditor();
		}
		return( swingEditorCopyrightHolder );
	}

	public void setSwingEditorCopyrightHolder( CopyrightHolderJEditor value ) {
		swingEditorCopyrightHolder = value;
	}

	public PublishURIJLabel getSwingLabelPublishURI() {
		if( swingLabelPublishURI == null ) {
			swingLabelPublishURI = new PublishURIJLabel();
		}
		return( swingLabelPublishURI );
	}

	public void setSwingLabelPublishURI( PublishURIJLabel value ) {
		swingLabelPublishURI = value;
	}

	public PublishURIJEditor getSwingEditorPublishURI() {
		if( swingEditorPublishURI == null ) {
			swingEditorPublishURI = new PublishURIJEditor();
		}
		return( swingEditorPublishURI );
	}

	public void setSwingEditorPublishURI( PublishURIJEditor value ) {
		swingEditorPublishURI = value;
	}

	public JSchemaObjImportJLabel getSwingLabelJSchemaObjImport() {
		if( swingLabelJSchemaObjImport == null ) {
			swingLabelJSchemaObjImport = new JSchemaObjImportJLabel();
		}
		return( swingLabelJSchemaObjImport );
	}

	public void setSwingLabelJSchemaObjImport( JSchemaObjImportJLabel value ) {
		swingLabelJSchemaObjImport = value;
	}

	public JSchemaObjImportJEditor getSwingEditorJSchemaObjImport() {
		if( swingEditorJSchemaObjImport == null ) {
			swingEditorJSchemaObjImport = new JSchemaObjImportJEditor();
		}
		return( swingEditorJSchemaObjImport );
	}

	public void setSwingEditorJSchemaObjImport( JSchemaObjImportJEditor value ) {
		swingEditorJSchemaObjImport = value;
	}

	public JSchemaObjInterfaceJLabel getSwingLabelJSchemaObjInterface() {
		if( swingLabelJSchemaObjInterface == null ) {
			swingLabelJSchemaObjInterface = new JSchemaObjInterfaceJLabel();
		}
		return( swingLabelJSchemaObjInterface );
	}

	public void setSwingLabelJSchemaObjInterface( JSchemaObjInterfaceJLabel value ) {
		swingLabelJSchemaObjInterface = value;
	}

	public JSchemaObjInterfaceJEditor getSwingEditorJSchemaObjInterface() {
		if( swingEditorJSchemaObjInterface == null ) {
			swingEditorJSchemaObjInterface = new JSchemaObjInterfaceJEditor();
		}
		return( swingEditorJSchemaObjInterface );
	}

	public void setSwingEditorJSchemaObjInterface( JSchemaObjInterfaceJEditor value ) {
		swingEditorJSchemaObjInterface = value;
	}

	public JSchemaObjMembersJLabel getSwingLabelJSchemaObjMembers() {
		if( swingLabelJSchemaObjMembers == null ) {
			swingLabelJSchemaObjMembers = new JSchemaObjMembersJLabel();
		}
		return( swingLabelJSchemaObjMembers );
	}

	public void setSwingLabelJSchemaObjMembers( JSchemaObjMembersJLabel value ) {
		swingLabelJSchemaObjMembers = value;
	}

	public JSchemaObjMembersJEditor getSwingEditorJSchemaObjMembers() {
		if( swingEditorJSchemaObjMembers == null ) {
			swingEditorJSchemaObjMembers = new JSchemaObjMembersJEditor();
		}
		return( swingEditorJSchemaObjMembers );
	}

	public void setSwingEditorJSchemaObjMembers( JSchemaObjMembersJEditor value ) {
		swingEditorJSchemaObjMembers = value;
	}

	public JSchemaObjImplementationJLabel getSwingLabelJSchemaObjImplementation() {
		if( swingLabelJSchemaObjImplementation == null ) {
			swingLabelJSchemaObjImplementation = new JSchemaObjImplementationJLabel();
		}
		return( swingLabelJSchemaObjImplementation );
	}

	public void setSwingLabelJSchemaObjImplementation( JSchemaObjImplementationJLabel value ) {
		swingLabelJSchemaObjImplementation = value;
	}

	public JSchemaObjImplementationJEditor getSwingEditorJSchemaObjImplementation() {
		if( swingEditorJSchemaObjImplementation == null ) {
			swingEditorJSchemaObjImplementation = new JSchemaObjImplementationJEditor();
		}
		return( swingEditorJSchemaObjImplementation );
	}

	public void setSwingEditorJSchemaObjImplementation( JSchemaObjImplementationJEditor value ) {
		swingEditorJSchemaObjImplementation = value;
	}

	public JDb2LUWSchemaObjMembersJLabel getSwingLabelJDb2LUWSchemaObjMembers() {
		if( swingLabelJDb2LUWSchemaObjMembers == null ) {
			swingLabelJDb2LUWSchemaObjMembers = new JDb2LUWSchemaObjMembersJLabel();
		}
		return( swingLabelJDb2LUWSchemaObjMembers );
	}

	public void setSwingLabelJDb2LUWSchemaObjMembers( JDb2LUWSchemaObjMembersJLabel value ) {
		swingLabelJDb2LUWSchemaObjMembers = value;
	}

	public JDb2LUWSchemaObjMembersJEditor getSwingEditorJDb2LUWSchemaObjMembers() {
		if( swingEditorJDb2LUWSchemaObjMembers == null ) {
			swingEditorJDb2LUWSchemaObjMembers = new JDb2LUWSchemaObjMembersJEditor();
		}
		return( swingEditorJDb2LUWSchemaObjMembers );
	}

	public void setSwingEditorJDb2LUWSchemaObjMembers( JDb2LUWSchemaObjMembersJEditor value ) {
		swingEditorJDb2LUWSchemaObjMembers = value;
	}

	public JDb2LUWSchemaObjImplJLabel getSwingLabelJDb2LUWSchemaObjImpl() {
		if( swingLabelJDb2LUWSchemaObjImpl == null ) {
			swingLabelJDb2LUWSchemaObjImpl = new JDb2LUWSchemaObjImplJLabel();
		}
		return( swingLabelJDb2LUWSchemaObjImpl );
	}

	public void setSwingLabelJDb2LUWSchemaObjImpl( JDb2LUWSchemaObjImplJLabel value ) {
		swingLabelJDb2LUWSchemaObjImpl = value;
	}

	public JDb2LUWSchemaObjImplJEditor getSwingEditorJDb2LUWSchemaObjImpl() {
		if( swingEditorJDb2LUWSchemaObjImpl == null ) {
			swingEditorJDb2LUWSchemaObjImpl = new JDb2LUWSchemaObjImplJEditor();
		}
		return( swingEditorJDb2LUWSchemaObjImpl );
	}

	public void setSwingEditorJDb2LUWSchemaObjImpl( JDb2LUWSchemaObjImplJEditor value ) {
		swingEditorJDb2LUWSchemaObjImpl = value;
	}

	public JDb2LUWSchemaObjImportJLabel getSwingLabelJDb2LUWSchemaObjImport() {
		if( swingLabelJDb2LUWSchemaObjImport == null ) {
			swingLabelJDb2LUWSchemaObjImport = new JDb2LUWSchemaObjImportJLabel();
		}
		return( swingLabelJDb2LUWSchemaObjImport );
	}

	public void setSwingLabelJDb2LUWSchemaObjImport( JDb2LUWSchemaObjImportJLabel value ) {
		swingLabelJDb2LUWSchemaObjImport = value;
	}

	public JDb2LUWSchemaObjImportJEditor getSwingEditorJDb2LUWSchemaObjImport() {
		if( swingEditorJDb2LUWSchemaObjImport == null ) {
			swingEditorJDb2LUWSchemaObjImport = new JDb2LUWSchemaObjImportJEditor();
		}
		return( swingEditorJDb2LUWSchemaObjImport );
	}

	public void setSwingEditorJDb2LUWSchemaObjImport( JDb2LUWSchemaObjImportJEditor value ) {
		swingEditorJDb2LUWSchemaObjImport = value;
	}

	public JMSSqlSchemaObjMembersJLabel getSwingLabelJMSSqlSchemaObjMembers() {
		if( swingLabelJMSSqlSchemaObjMembers == null ) {
			swingLabelJMSSqlSchemaObjMembers = new JMSSqlSchemaObjMembersJLabel();
		}
		return( swingLabelJMSSqlSchemaObjMembers );
	}

	public void setSwingLabelJMSSqlSchemaObjMembers( JMSSqlSchemaObjMembersJLabel value ) {
		swingLabelJMSSqlSchemaObjMembers = value;
	}

	public JMSSqlSchemaObjMembersJEditor getSwingEditorJMSSqlSchemaObjMembers() {
		if( swingEditorJMSSqlSchemaObjMembers == null ) {
			swingEditorJMSSqlSchemaObjMembers = new JMSSqlSchemaObjMembersJEditor();
		}
		return( swingEditorJMSSqlSchemaObjMembers );
	}

	public void setSwingEditorJMSSqlSchemaObjMembers( JMSSqlSchemaObjMembersJEditor value ) {
		swingEditorJMSSqlSchemaObjMembers = value;
	}

	public JMSSqlSchemaObjImplJLabel getSwingLabelJMSSqlSchemaObjImpl() {
		if( swingLabelJMSSqlSchemaObjImpl == null ) {
			swingLabelJMSSqlSchemaObjImpl = new JMSSqlSchemaObjImplJLabel();
		}
		return( swingLabelJMSSqlSchemaObjImpl );
	}

	public void setSwingLabelJMSSqlSchemaObjImpl( JMSSqlSchemaObjImplJLabel value ) {
		swingLabelJMSSqlSchemaObjImpl = value;
	}

	public JMSSqlSchemaObjImplJEditor getSwingEditorJMSSqlSchemaObjImpl() {
		if( swingEditorJMSSqlSchemaObjImpl == null ) {
			swingEditorJMSSqlSchemaObjImpl = new JMSSqlSchemaObjImplJEditor();
		}
		return( swingEditorJMSSqlSchemaObjImpl );
	}

	public void setSwingEditorJMSSqlSchemaObjImpl( JMSSqlSchemaObjImplJEditor value ) {
		swingEditorJMSSqlSchemaObjImpl = value;
	}

	public JMSSqlSchemaObjImportJLabel getSwingLabelJMSSqlSchemaObjImport() {
		if( swingLabelJMSSqlSchemaObjImport == null ) {
			swingLabelJMSSqlSchemaObjImport = new JMSSqlSchemaObjImportJLabel();
		}
		return( swingLabelJMSSqlSchemaObjImport );
	}

	public void setSwingLabelJMSSqlSchemaObjImport( JMSSqlSchemaObjImportJLabel value ) {
		swingLabelJMSSqlSchemaObjImport = value;
	}

	public JMSSqlSchemaObjImportJEditor getSwingEditorJMSSqlSchemaObjImport() {
		if( swingEditorJMSSqlSchemaObjImport == null ) {
			swingEditorJMSSqlSchemaObjImport = new JMSSqlSchemaObjImportJEditor();
		}
		return( swingEditorJMSSqlSchemaObjImport );
	}

	public void setSwingEditorJMSSqlSchemaObjImport( JMSSqlSchemaObjImportJEditor value ) {
		swingEditorJMSSqlSchemaObjImport = value;
	}

	public JMySqlSchemaObjMembersJLabel getSwingLabelJMySqlSchemaObjMembers() {
		if( swingLabelJMySqlSchemaObjMembers == null ) {
			swingLabelJMySqlSchemaObjMembers = new JMySqlSchemaObjMembersJLabel();
		}
		return( swingLabelJMySqlSchemaObjMembers );
	}

	public void setSwingLabelJMySqlSchemaObjMembers( JMySqlSchemaObjMembersJLabel value ) {
		swingLabelJMySqlSchemaObjMembers = value;
	}

	public JMySqlSchemaObjMembersJEditor getSwingEditorJMySqlSchemaObjMembers() {
		if( swingEditorJMySqlSchemaObjMembers == null ) {
			swingEditorJMySqlSchemaObjMembers = new JMySqlSchemaObjMembersJEditor();
		}
		return( swingEditorJMySqlSchemaObjMembers );
	}

	public void setSwingEditorJMySqlSchemaObjMembers( JMySqlSchemaObjMembersJEditor value ) {
		swingEditorJMySqlSchemaObjMembers = value;
	}

	public JMySqlSchemaObjImplJLabel getSwingLabelJMySqlSchemaObjImpl() {
		if( swingLabelJMySqlSchemaObjImpl == null ) {
			swingLabelJMySqlSchemaObjImpl = new JMySqlSchemaObjImplJLabel();
		}
		return( swingLabelJMySqlSchemaObjImpl );
	}

	public void setSwingLabelJMySqlSchemaObjImpl( JMySqlSchemaObjImplJLabel value ) {
		swingLabelJMySqlSchemaObjImpl = value;
	}

	public JMySqlSchemaObjImplJEditor getSwingEditorJMySqlSchemaObjImpl() {
		if( swingEditorJMySqlSchemaObjImpl == null ) {
			swingEditorJMySqlSchemaObjImpl = new JMySqlSchemaObjImplJEditor();
		}
		return( swingEditorJMySqlSchemaObjImpl );
	}

	public void setSwingEditorJMySqlSchemaObjImpl( JMySqlSchemaObjImplJEditor value ) {
		swingEditorJMySqlSchemaObjImpl = value;
	}

	public JMySqlSchemaObjImportJLabel getSwingLabelJMySqlSchemaObjImport() {
		if( swingLabelJMySqlSchemaObjImport == null ) {
			swingLabelJMySqlSchemaObjImport = new JMySqlSchemaObjImportJLabel();
		}
		return( swingLabelJMySqlSchemaObjImport );
	}

	public void setSwingLabelJMySqlSchemaObjImport( JMySqlSchemaObjImportJLabel value ) {
		swingLabelJMySqlSchemaObjImport = value;
	}

	public JMySqlSchemaObjImportJEditor getSwingEditorJMySqlSchemaObjImport() {
		if( swingEditorJMySqlSchemaObjImport == null ) {
			swingEditorJMySqlSchemaObjImport = new JMySqlSchemaObjImportJEditor();
		}
		return( swingEditorJMySqlSchemaObjImport );
	}

	public void setSwingEditorJMySqlSchemaObjImport( JMySqlSchemaObjImportJEditor value ) {
		swingEditorJMySqlSchemaObjImport = value;
	}

	public JOracleSchemaObjMembersJLabel getSwingLabelJOracleSchemaObjMembers() {
		if( swingLabelJOracleSchemaObjMembers == null ) {
			swingLabelJOracleSchemaObjMembers = new JOracleSchemaObjMembersJLabel();
		}
		return( swingLabelJOracleSchemaObjMembers );
	}

	public void setSwingLabelJOracleSchemaObjMembers( JOracleSchemaObjMembersJLabel value ) {
		swingLabelJOracleSchemaObjMembers = value;
	}

	public JOracleSchemaObjMembersJEditor getSwingEditorJOracleSchemaObjMembers() {
		if( swingEditorJOracleSchemaObjMembers == null ) {
			swingEditorJOracleSchemaObjMembers = new JOracleSchemaObjMembersJEditor();
		}
		return( swingEditorJOracleSchemaObjMembers );
	}

	public void setSwingEditorJOracleSchemaObjMembers( JOracleSchemaObjMembersJEditor value ) {
		swingEditorJOracleSchemaObjMembers = value;
	}

	public JOracleSchemaObjImplJLabel getSwingLabelJOracleSchemaObjImpl() {
		if( swingLabelJOracleSchemaObjImpl == null ) {
			swingLabelJOracleSchemaObjImpl = new JOracleSchemaObjImplJLabel();
		}
		return( swingLabelJOracleSchemaObjImpl );
	}

	public void setSwingLabelJOracleSchemaObjImpl( JOracleSchemaObjImplJLabel value ) {
		swingLabelJOracleSchemaObjImpl = value;
	}

	public JOracleSchemaObjImplJEditor getSwingEditorJOracleSchemaObjImpl() {
		if( swingEditorJOracleSchemaObjImpl == null ) {
			swingEditorJOracleSchemaObjImpl = new JOracleSchemaObjImplJEditor();
		}
		return( swingEditorJOracleSchemaObjImpl );
	}

	public void setSwingEditorJOracleSchemaObjImpl( JOracleSchemaObjImplJEditor value ) {
		swingEditorJOracleSchemaObjImpl = value;
	}

	public JOracleSchemaObjImportJLabel getSwingLabelJOracleSchemaObjImport() {
		if( swingLabelJOracleSchemaObjImport == null ) {
			swingLabelJOracleSchemaObjImport = new JOracleSchemaObjImportJLabel();
		}
		return( swingLabelJOracleSchemaObjImport );
	}

	public void setSwingLabelJOracleSchemaObjImport( JOracleSchemaObjImportJLabel value ) {
		swingLabelJOracleSchemaObjImport = value;
	}

	public JOracleSchemaObjImportJEditor getSwingEditorJOracleSchemaObjImport() {
		if( swingEditorJOracleSchemaObjImport == null ) {
			swingEditorJOracleSchemaObjImport = new JOracleSchemaObjImportJEditor();
		}
		return( swingEditorJOracleSchemaObjImport );
	}

	public void setSwingEditorJOracleSchemaObjImport( JOracleSchemaObjImportJEditor value ) {
		swingEditorJOracleSchemaObjImport = value;
	}

	public JPgSqlSchemaObjMembersJLabel getSwingLabelJPgSqlSchemaObjMembers() {
		if( swingLabelJPgSqlSchemaObjMembers == null ) {
			swingLabelJPgSqlSchemaObjMembers = new JPgSqlSchemaObjMembersJLabel();
		}
		return( swingLabelJPgSqlSchemaObjMembers );
	}

	public void setSwingLabelJPgSqlSchemaObjMembers( JPgSqlSchemaObjMembersJLabel value ) {
		swingLabelJPgSqlSchemaObjMembers = value;
	}

	public JPgSqlSchemaObjMembersJEditor getSwingEditorJPgSqlSchemaObjMembers() {
		if( swingEditorJPgSqlSchemaObjMembers == null ) {
			swingEditorJPgSqlSchemaObjMembers = new JPgSqlSchemaObjMembersJEditor();
		}
		return( swingEditorJPgSqlSchemaObjMembers );
	}

	public void setSwingEditorJPgSqlSchemaObjMembers( JPgSqlSchemaObjMembersJEditor value ) {
		swingEditorJPgSqlSchemaObjMembers = value;
	}

	public JPgSqlSchemaObjImplJLabel getSwingLabelJPgSqlSchemaObjImpl() {
		if( swingLabelJPgSqlSchemaObjImpl == null ) {
			swingLabelJPgSqlSchemaObjImpl = new JPgSqlSchemaObjImplJLabel();
		}
		return( swingLabelJPgSqlSchemaObjImpl );
	}

	public void setSwingLabelJPgSqlSchemaObjImpl( JPgSqlSchemaObjImplJLabel value ) {
		swingLabelJPgSqlSchemaObjImpl = value;
	}

	public JPgSqlSchemaObjImplJEditor getSwingEditorJPgSqlSchemaObjImpl() {
		if( swingEditorJPgSqlSchemaObjImpl == null ) {
			swingEditorJPgSqlSchemaObjImpl = new JPgSqlSchemaObjImplJEditor();
		}
		return( swingEditorJPgSqlSchemaObjImpl );
	}

	public void setSwingEditorJPgSqlSchemaObjImpl( JPgSqlSchemaObjImplJEditor value ) {
		swingEditorJPgSqlSchemaObjImpl = value;
	}

	public JPgSqlSchemaObjImportJLabel getSwingLabelJPgSqlSchemaObjImport() {
		if( swingLabelJPgSqlSchemaObjImport == null ) {
			swingLabelJPgSqlSchemaObjImport = new JPgSqlSchemaObjImportJLabel();
		}
		return( swingLabelJPgSqlSchemaObjImport );
	}

	public void setSwingLabelJPgSqlSchemaObjImport( JPgSqlSchemaObjImportJLabel value ) {
		swingLabelJPgSqlSchemaObjImport = value;
	}

	public JPgSqlSchemaObjImportJEditor getSwingEditorJPgSqlSchemaObjImport() {
		if( swingEditorJPgSqlSchemaObjImport == null ) {
			swingEditorJPgSqlSchemaObjImport = new JPgSqlSchemaObjImportJEditor();
		}
		return( swingEditorJPgSqlSchemaObjImport );
	}

	public void setSwingEditorJPgSqlSchemaObjImport( JPgSqlSchemaObjImportJEditor value ) {
		swingEditorJPgSqlSchemaObjImport = value;
	}

	public JSybaseSchemaObjMembersJLabel getSwingLabelJSybaseSchemaObjMembers() {
		if( swingLabelJSybaseSchemaObjMembers == null ) {
			swingLabelJSybaseSchemaObjMembers = new JSybaseSchemaObjMembersJLabel();
		}
		return( swingLabelJSybaseSchemaObjMembers );
	}

	public void setSwingLabelJSybaseSchemaObjMembers( JSybaseSchemaObjMembersJLabel value ) {
		swingLabelJSybaseSchemaObjMembers = value;
	}

	public JSybaseSchemaObjMembersJEditor getSwingEditorJSybaseSchemaObjMembers() {
		if( swingEditorJSybaseSchemaObjMembers == null ) {
			swingEditorJSybaseSchemaObjMembers = new JSybaseSchemaObjMembersJEditor();
		}
		return( swingEditorJSybaseSchemaObjMembers );
	}

	public void setSwingEditorJSybaseSchemaObjMembers( JSybaseSchemaObjMembersJEditor value ) {
		swingEditorJSybaseSchemaObjMembers = value;
	}

	public JSybaseSchemaObjImplJLabel getSwingLabelJSybaseSchemaObjImpl() {
		if( swingLabelJSybaseSchemaObjImpl == null ) {
			swingLabelJSybaseSchemaObjImpl = new JSybaseSchemaObjImplJLabel();
		}
		return( swingLabelJSybaseSchemaObjImpl );
	}

	public void setSwingLabelJSybaseSchemaObjImpl( JSybaseSchemaObjImplJLabel value ) {
		swingLabelJSybaseSchemaObjImpl = value;
	}

	public JSybaseSchemaObjImplJEditor getSwingEditorJSybaseSchemaObjImpl() {
		if( swingEditorJSybaseSchemaObjImpl == null ) {
			swingEditorJSybaseSchemaObjImpl = new JSybaseSchemaObjImplJEditor();
		}
		return( swingEditorJSybaseSchemaObjImpl );
	}

	public void setSwingEditorJSybaseSchemaObjImpl( JSybaseSchemaObjImplJEditor value ) {
		swingEditorJSybaseSchemaObjImpl = value;
	}

	public JSybaseSchemaObjImportJLabel getSwingLabelJSybaseSchemaObjImport() {
		if( swingLabelJSybaseSchemaObjImport == null ) {
			swingLabelJSybaseSchemaObjImport = new JSybaseSchemaObjImportJLabel();
		}
		return( swingLabelJSybaseSchemaObjImport );
	}

	public void setSwingLabelJSybaseSchemaObjImport( JSybaseSchemaObjImportJLabel value ) {
		swingLabelJSybaseSchemaObjImport = value;
	}

	public JSybaseSchemaObjImportJEditor getSwingEditorJSybaseSchemaObjImport() {
		if( swingEditorJSybaseSchemaObjImport == null ) {
			swingEditorJSybaseSchemaObjImport = new JSybaseSchemaObjImportJEditor();
		}
		return( swingEditorJSybaseSchemaObjImport );
	}

	public void setSwingEditorJSybaseSchemaObjImport( JSybaseSchemaObjImportJEditor value ) {
		swingEditorJSybaseSchemaObjImport = value;
	}

	public JRamSchemaObjMembersJLabel getSwingLabelJRamSchemaObjMembers() {
		if( swingLabelJRamSchemaObjMembers == null ) {
			swingLabelJRamSchemaObjMembers = new JRamSchemaObjMembersJLabel();
		}
		return( swingLabelJRamSchemaObjMembers );
	}

	public void setSwingLabelJRamSchemaObjMembers( JRamSchemaObjMembersJLabel value ) {
		swingLabelJRamSchemaObjMembers = value;
	}

	public JRamSchemaObjMembersJEditor getSwingEditorJRamSchemaObjMembers() {
		if( swingEditorJRamSchemaObjMembers == null ) {
			swingEditorJRamSchemaObjMembers = new JRamSchemaObjMembersJEditor();
		}
		return( swingEditorJRamSchemaObjMembers );
	}

	public void setSwingEditorJRamSchemaObjMembers( JRamSchemaObjMembersJEditor value ) {
		swingEditorJRamSchemaObjMembers = value;
	}

	public JRamSchemaObjImplJLabel getSwingLabelJRamSchemaObjImpl() {
		if( swingLabelJRamSchemaObjImpl == null ) {
			swingLabelJRamSchemaObjImpl = new JRamSchemaObjImplJLabel();
		}
		return( swingLabelJRamSchemaObjImpl );
	}

	public void setSwingLabelJRamSchemaObjImpl( JRamSchemaObjImplJLabel value ) {
		swingLabelJRamSchemaObjImpl = value;
	}

	public JRamSchemaObjImplJEditor getSwingEditorJRamSchemaObjImpl() {
		if( swingEditorJRamSchemaObjImpl == null ) {
			swingEditorJRamSchemaObjImpl = new JRamSchemaObjImplJEditor();
		}
		return( swingEditorJRamSchemaObjImpl );
	}

	public void setSwingEditorJRamSchemaObjImpl( JRamSchemaObjImplJEditor value ) {
		swingEditorJRamSchemaObjImpl = value;
	}

	public JRamSchemaObjImportJLabel getSwingLabelJRamSchemaObjImport() {
		if( swingLabelJRamSchemaObjImport == null ) {
			swingLabelJRamSchemaObjImport = new JRamSchemaObjImportJLabel();
		}
		return( swingLabelJRamSchemaObjImport );
	}

	public void setSwingLabelJRamSchemaObjImport( JRamSchemaObjImportJLabel value ) {
		swingLabelJRamSchemaObjImport = value;
	}

	public JRamSchemaObjImportJEditor getSwingEditorJRamSchemaObjImport() {
		if( swingEditorJRamSchemaObjImport == null ) {
			swingEditorJRamSchemaObjImport = new JRamSchemaObjImportJEditor();
		}
		return( swingEditorJRamSchemaObjImport );
	}

	public void setSwingEditorJRamSchemaObjImport( JRamSchemaObjImportJEditor value ) {
		swingEditorJRamSchemaObjImport = value;
	}

	public JXMsgSchemaImportJLabel getSwingLabelJXMsgSchemaImport() {
		if( swingLabelJXMsgSchemaImport == null ) {
			swingLabelJXMsgSchemaImport = new JXMsgSchemaImportJLabel();
		}
		return( swingLabelJXMsgSchemaImport );
	}

	public void setSwingLabelJXMsgSchemaImport( JXMsgSchemaImportJLabel value ) {
		swingLabelJXMsgSchemaImport = value;
	}

	public JXMsgSchemaImportJEditor getSwingEditorJXMsgSchemaImport() {
		if( swingEditorJXMsgSchemaImport == null ) {
			swingEditorJXMsgSchemaImport = new JXMsgSchemaImportJEditor();
		}
		return( swingEditorJXMsgSchemaImport );
	}

	public void setSwingEditorJXMsgSchemaImport( JXMsgSchemaImportJEditor value ) {
		swingEditorJXMsgSchemaImport = value;
	}

	public JXMsgSchemaFormattersJLabel getSwingLabelJXMsgSchemaFormatters() {
		if( swingLabelJXMsgSchemaFormatters == null ) {
			swingLabelJXMsgSchemaFormatters = new JXMsgSchemaFormattersJLabel();
		}
		return( swingLabelJXMsgSchemaFormatters );
	}

	public void setSwingLabelJXMsgSchemaFormatters( JXMsgSchemaFormattersJLabel value ) {
		swingLabelJXMsgSchemaFormatters = value;
	}

	public JXMsgSchemaFormattersJEditor getSwingEditorJXMsgSchemaFormatters() {
		if( swingEditorJXMsgSchemaFormatters == null ) {
			swingEditorJXMsgSchemaFormatters = new JXMsgSchemaFormattersJEditor();
		}
		return( swingEditorJXMsgSchemaFormatters );
	}

	public void setSwingEditorJXMsgSchemaFormatters( JXMsgSchemaFormattersJEditor value ) {
		swingEditorJXMsgSchemaFormatters = value;
	}

	public JXMsgClientSchemaImportJLabel getSwingLabelJXMsgClientSchemaImport() {
		if( swingLabelJXMsgClientSchemaImport == null ) {
			swingLabelJXMsgClientSchemaImport = new JXMsgClientSchemaImportJLabel();
		}
		return( swingLabelJXMsgClientSchemaImport );
	}

	public void setSwingLabelJXMsgClientSchemaImport( JXMsgClientSchemaImportJLabel value ) {
		swingLabelJXMsgClientSchemaImport = value;
	}

	public JXMsgClientSchemaImportJEditor getSwingEditorJXMsgClientSchemaImport() {
		if( swingEditorJXMsgClientSchemaImport == null ) {
			swingEditorJXMsgClientSchemaImport = new JXMsgClientSchemaImportJEditor();
		}
		return( swingEditorJXMsgClientSchemaImport );
	}

	public void setSwingEditorJXMsgClientSchemaImport( JXMsgClientSchemaImportJEditor value ) {
		swingEditorJXMsgClientSchemaImport = value;
	}

	public JXMsgClientSchemaBodyJLabel getSwingLabelJXMsgClientSchemaBody() {
		if( swingLabelJXMsgClientSchemaBody == null ) {
			swingLabelJXMsgClientSchemaBody = new JXMsgClientSchemaBodyJLabel();
		}
		return( swingLabelJXMsgClientSchemaBody );
	}

	public void setSwingLabelJXMsgClientSchemaBody( JXMsgClientSchemaBodyJLabel value ) {
		swingLabelJXMsgClientSchemaBody = value;
	}

	public JXMsgClientSchemaBodyJEditor getSwingEditorJXMsgClientSchemaBody() {
		if( swingEditorJXMsgClientSchemaBody == null ) {
			swingEditorJXMsgClientSchemaBody = new JXMsgClientSchemaBodyJEditor();
		}
		return( swingEditorJXMsgClientSchemaBody );
	}

	public void setSwingEditorJXMsgClientSchemaBody( JXMsgClientSchemaBodyJEditor value ) {
		swingEditorJXMsgClientSchemaBody = value;
	}

	public JXMsgRqstSchemaBodyJLabel getSwingLabelJXMsgRqstSchemaBody() {
		if( swingLabelJXMsgRqstSchemaBody == null ) {
			swingLabelJXMsgRqstSchemaBody = new JXMsgRqstSchemaBodyJLabel();
		}
		return( swingLabelJXMsgRqstSchemaBody );
	}

	public void setSwingLabelJXMsgRqstSchemaBody( JXMsgRqstSchemaBodyJLabel value ) {
		swingLabelJXMsgRqstSchemaBody = value;
	}

	public JXMsgRqstSchemaBodyJEditor getSwingEditorJXMsgRqstSchemaBody() {
		if( swingEditorJXMsgRqstSchemaBody == null ) {
			swingEditorJXMsgRqstSchemaBody = new JXMsgRqstSchemaBodyJEditor();
		}
		return( swingEditorJXMsgRqstSchemaBody );
	}

	public void setSwingEditorJXMsgRqstSchemaBody( JXMsgRqstSchemaBodyJEditor value ) {
		swingEditorJXMsgRqstSchemaBody = value;
	}

	public JXMsgRqstSchemaImportJLabel getSwingLabelJXMsgRqstSchemaImport() {
		if( swingLabelJXMsgRqstSchemaImport == null ) {
			swingLabelJXMsgRqstSchemaImport = new JXMsgRqstSchemaImportJLabel();
		}
		return( swingLabelJXMsgRqstSchemaImport );
	}

	public void setSwingLabelJXMsgRqstSchemaImport( JXMsgRqstSchemaImportJLabel value ) {
		swingLabelJXMsgRqstSchemaImport = value;
	}

	public JXMsgRqstSchemaImportJEditor getSwingEditorJXMsgRqstSchemaImport() {
		if( swingEditorJXMsgRqstSchemaImport == null ) {
			swingEditorJXMsgRqstSchemaImport = new JXMsgRqstSchemaImportJEditor();
		}
		return( swingEditorJXMsgRqstSchemaImport );
	}

	public void setSwingEditorJXMsgRqstSchemaImport( JXMsgRqstSchemaImportJEditor value ) {
		swingEditorJXMsgRqstSchemaImport = value;
	}

	public JXMsgRqstSchemaWireParsersJLabel getSwingLabelJXMsgRqstSchemaWireParsers() {
		if( swingLabelJXMsgRqstSchemaWireParsers == null ) {
			swingLabelJXMsgRqstSchemaWireParsers = new JXMsgRqstSchemaWireParsersJLabel();
		}
		return( swingLabelJXMsgRqstSchemaWireParsers );
	}

	public void setSwingLabelJXMsgRqstSchemaWireParsers( JXMsgRqstSchemaWireParsersJLabel value ) {
		swingLabelJXMsgRqstSchemaWireParsers = value;
	}

	public JXMsgRqstSchemaWireParsersJEditor getSwingEditorJXMsgRqstSchemaWireParsers() {
		if( swingEditorJXMsgRqstSchemaWireParsers == null ) {
			swingEditorJXMsgRqstSchemaWireParsers = new JXMsgRqstSchemaWireParsersJEditor();
		}
		return( swingEditorJXMsgRqstSchemaWireParsers );
	}

	public void setSwingEditorJXMsgRqstSchemaWireParsers( JXMsgRqstSchemaWireParsersJEditor value ) {
		swingEditorJXMsgRqstSchemaWireParsers = value;
	}

	public JXMsgRqstSchemaXsdSpecJLabel getSwingLabelJXMsgRqstSchemaXsdSpec() {
		if( swingLabelJXMsgRqstSchemaXsdSpec == null ) {
			swingLabelJXMsgRqstSchemaXsdSpec = new JXMsgRqstSchemaXsdSpecJLabel();
		}
		return( swingLabelJXMsgRqstSchemaXsdSpec );
	}

	public void setSwingLabelJXMsgRqstSchemaXsdSpec( JXMsgRqstSchemaXsdSpecJLabel value ) {
		swingLabelJXMsgRqstSchemaXsdSpec = value;
	}

	public JXMsgRqstSchemaXsdSpecJEditor getSwingEditorJXMsgRqstSchemaXsdSpec() {
		if( swingEditorJXMsgRqstSchemaXsdSpec == null ) {
			swingEditorJXMsgRqstSchemaXsdSpec = new JXMsgRqstSchemaXsdSpecJEditor();
		}
		return( swingEditorJXMsgRqstSchemaXsdSpec );
	}

	public void setSwingEditorJXMsgRqstSchemaXsdSpec( JXMsgRqstSchemaXsdSpecJEditor value ) {
		swingEditorJXMsgRqstSchemaXsdSpec = value;
	}

	public JXMsgRqstSchemaXsdElementListJLabel getSwingLabelJXMsgRqstSchemaXsdElementList() {
		if( swingLabelJXMsgRqstSchemaXsdElementList == null ) {
			swingLabelJXMsgRqstSchemaXsdElementList = new JXMsgRqstSchemaXsdElementListJLabel();
		}
		return( swingLabelJXMsgRqstSchemaXsdElementList );
	}

	public void setSwingLabelJXMsgRqstSchemaXsdElementList( JXMsgRqstSchemaXsdElementListJLabel value ) {
		swingLabelJXMsgRqstSchemaXsdElementList = value;
	}

	public JXMsgRqstSchemaXsdElementListJEditor getSwingEditorJXMsgRqstSchemaXsdElementList() {
		if( swingEditorJXMsgRqstSchemaXsdElementList == null ) {
			swingEditorJXMsgRqstSchemaXsdElementList = new JXMsgRqstSchemaXsdElementListJEditor();
		}
		return( swingEditorJXMsgRqstSchemaXsdElementList );
	}

	public void setSwingEditorJXMsgRqstSchemaXsdElementList( JXMsgRqstSchemaXsdElementListJEditor value ) {
		swingEditorJXMsgRqstSchemaXsdElementList = value;
	}

	public JXMsgRspnSchemaBodyJLabel getSwingLabelJXMsgRspnSchemaBody() {
		if( swingLabelJXMsgRspnSchemaBody == null ) {
			swingLabelJXMsgRspnSchemaBody = new JXMsgRspnSchemaBodyJLabel();
		}
		return( swingLabelJXMsgRspnSchemaBody );
	}

	public void setSwingLabelJXMsgRspnSchemaBody( JXMsgRspnSchemaBodyJLabel value ) {
		swingLabelJXMsgRspnSchemaBody = value;
	}

	public JXMsgRspnSchemaBodyJEditor getSwingEditorJXMsgRspnSchemaBody() {
		if( swingEditorJXMsgRspnSchemaBody == null ) {
			swingEditorJXMsgRspnSchemaBody = new JXMsgRspnSchemaBodyJEditor();
		}
		return( swingEditorJXMsgRspnSchemaBody );
	}

	public void setSwingEditorJXMsgRspnSchemaBody( JXMsgRspnSchemaBodyJEditor value ) {
		swingEditorJXMsgRspnSchemaBody = value;
	}

	public JXMsgRspnSchemaImportJLabel getSwingLabelJXMsgRspnSchemaImport() {
		if( swingLabelJXMsgRspnSchemaImport == null ) {
			swingLabelJXMsgRspnSchemaImport = new JXMsgRspnSchemaImportJLabel();
		}
		return( swingLabelJXMsgRspnSchemaImport );
	}

	public void setSwingLabelJXMsgRspnSchemaImport( JXMsgRspnSchemaImportJLabel value ) {
		swingLabelJXMsgRspnSchemaImport = value;
	}

	public JXMsgRspnSchemaImportJEditor getSwingEditorJXMsgRspnSchemaImport() {
		if( swingEditorJXMsgRspnSchemaImport == null ) {
			swingEditorJXMsgRspnSchemaImport = new JXMsgRspnSchemaImportJEditor();
		}
		return( swingEditorJXMsgRspnSchemaImport );
	}

	public void setSwingEditorJXMsgRspnSchemaImport( JXMsgRspnSchemaImportJEditor value ) {
		swingEditorJXMsgRspnSchemaImport = value;
	}

	public JXMsgRspnSchemaWireParsersJLabel getSwingLabelJXMsgRspnSchemaWireParsers() {
		if( swingLabelJXMsgRspnSchemaWireParsers == null ) {
			swingLabelJXMsgRspnSchemaWireParsers = new JXMsgRspnSchemaWireParsersJLabel();
		}
		return( swingLabelJXMsgRspnSchemaWireParsers );
	}

	public void setSwingLabelJXMsgRspnSchemaWireParsers( JXMsgRspnSchemaWireParsersJLabel value ) {
		swingLabelJXMsgRspnSchemaWireParsers = value;
	}

	public JXMsgRspnSchemaWireParsersJEditor getSwingEditorJXMsgRspnSchemaWireParsers() {
		if( swingEditorJXMsgRspnSchemaWireParsers == null ) {
			swingEditorJXMsgRspnSchemaWireParsers = new JXMsgRspnSchemaWireParsersJEditor();
		}
		return( swingEditorJXMsgRspnSchemaWireParsers );
	}

	public void setSwingEditorJXMsgRspnSchemaWireParsers( JXMsgRspnSchemaWireParsersJEditor value ) {
		swingEditorJXMsgRspnSchemaWireParsers = value;
	}

	public JXMsgRspnSchemaXsdElementListJLabel getSwingLabelJXMsgRspnSchemaXsdElementList() {
		if( swingLabelJXMsgRspnSchemaXsdElementList == null ) {
			swingLabelJXMsgRspnSchemaXsdElementList = new JXMsgRspnSchemaXsdElementListJLabel();
		}
		return( swingLabelJXMsgRspnSchemaXsdElementList );
	}

	public void setSwingLabelJXMsgRspnSchemaXsdElementList( JXMsgRspnSchemaXsdElementListJLabel value ) {
		swingLabelJXMsgRspnSchemaXsdElementList = value;
	}

	public JXMsgRspnSchemaXsdElementListJEditor getSwingEditorJXMsgRspnSchemaXsdElementList() {
		if( swingEditorJXMsgRspnSchemaXsdElementList == null ) {
			swingEditorJXMsgRspnSchemaXsdElementList = new JXMsgRspnSchemaXsdElementListJEditor();
		}
		return( swingEditorJXMsgRspnSchemaXsdElementList );
	}

	public void setSwingEditorJXMsgRspnSchemaXsdElementList( JXMsgRspnSchemaXsdElementListJEditor value ) {
		swingEditorJXMsgRspnSchemaXsdElementList = value;
	}

	public JXMsgRspnSchemaXsdSpecJLabel getSwingLabelJXMsgRspnSchemaXsdSpec() {
		if( swingLabelJXMsgRspnSchemaXsdSpec == null ) {
			swingLabelJXMsgRspnSchemaXsdSpec = new JXMsgRspnSchemaXsdSpecJLabel();
		}
		return( swingLabelJXMsgRspnSchemaXsdSpec );
	}

	public void setSwingLabelJXMsgRspnSchemaXsdSpec( JXMsgRspnSchemaXsdSpecJLabel value ) {
		swingLabelJXMsgRspnSchemaXsdSpec = value;
	}

	public JXMsgRspnSchemaXsdSpecJEditor getSwingEditorJXMsgRspnSchemaXsdSpec() {
		if( swingEditorJXMsgRspnSchemaXsdSpec == null ) {
			swingEditorJXMsgRspnSchemaXsdSpec = new JXMsgRspnSchemaXsdSpecJEditor();
		}
		return( swingEditorJXMsgRspnSchemaXsdSpec );
	}

	public void setSwingEditorJXMsgRspnSchemaXsdSpec( JXMsgRspnSchemaXsdSpecJEditor value ) {
		swingEditorJXMsgRspnSchemaXsdSpec = value;
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

		label = getSwingLabelOwnerCTenant();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCTenant();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerDomain();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerDomain();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelLookupDefaultLicense();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceLookupDefaultLicense();
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

		label = getSwingLabelExtendCFCore();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorExtendCFCore();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelCopyrightPeriod();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorCopyrightPeriod();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelCopyrightHolder();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorCopyrightHolder();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelPublishURI();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorPublishURI();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelJSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjInterface();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjInterface();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSchemaObjImplementation();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSchemaObjImplementation();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJDb2LUWSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJDb2LUWSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMSSqlSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMSSqlSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJMySqlSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJMySqlSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJOracleSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJOracleSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJPgSqlSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJPgSqlSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJSybaseSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJSybaseSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjMembers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjMembers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjImpl();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjImpl();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJRamSchemaObjImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJRamSchemaObjImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgSchemaImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgSchemaImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgSchemaFormatters();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgSchemaFormatters();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientSchemaImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientSchemaImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgClientSchemaBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgClientSchemaBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaWireParsers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaWireParsers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaXsdSpec();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaXsdSpec();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRqstSchemaXsdElementList();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRqstSchemaXsdElementList();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaBody();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaBody();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaImport();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaImport();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaWireParsers();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaWireParsers();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaXsdElementList();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaXsdElementList();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, textheight );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, textheight  );
		}
		y = y + textvspacing;

		label = getSwingLabelJXMsgRspnSchemaXsdSpec();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJXMsgRspnSchemaXsdSpec();
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
		ICFBamSchemaDefObj popObj;
		ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
		if( focus != null ) {
			popObj = (ICFBamSchemaDefObj)(focus.getEdit());
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
			swingOwnerCTenantObj = null;
		}
		else {
			swingOwnerCTenantObj = popObj.getRequiredOwnerCTenant( swingIsInitializing );
		}
		if( swingReferenceOwnerCTenant != null ) {
			swingReferenceOwnerCTenant.setReferencedObject( swingOwnerCTenantObj );
		}

		if( popObj == null ) {
			swingContainerDomainObj = null;
		}
		else {
			swingContainerDomainObj = popObj.getRequiredContainerDomain( swingIsInitializing );
		}
		if( swingReferenceContainerDomain != null ) {
			swingReferenceContainerDomain.setReferencedObject( swingContainerDomainObj );
		}

		if( popObj == null ) {
			swingLookupDefaultLicenseObj = null;
		}
		else {
			swingLookupDefaultLicenseObj = popObj.getOptionalLookupDefaultLicense( swingIsInitializing );
		}
		if( swingReferenceLookupDefaultLicense != null ) {
			swingReferenceLookupDefaultLicense.setReferencedObject( swingLookupDefaultLicenseObj );
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
			getSwingEditorExtendCFCore().setBooleanValue( null );
		}
		else {
			getSwingEditorExtendCFCore().setBooleanValue( popObj.getRequiredExtendCFCore() );
		}

		if( popObj == null ) {
			getSwingEditorCopyrightPeriod().setStringValue( null );
		}
		else {
			getSwingEditorCopyrightPeriod().setStringValue( popObj.getRequiredCopyrightPeriod() );
		}

		if( popObj == null ) {
			getSwingEditorCopyrightHolder().setStringValue( null );
		}
		else {
			getSwingEditorCopyrightHolder().setStringValue( popObj.getRequiredCopyrightHolder() );
		}

		if( popObj == null ) {
			getSwingEditorPublishURI().setStringValue( null );
		}
		else {
			getSwingEditorPublishURI().setStringValue( popObj.getRequiredPublishURI() );
		}

		if( popObj == null ) {
			getSwingEditorJSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJSchemaObjImport().setTextValue( popObj.getOptionalJSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJSchemaObjInterface().setTextValue( null );
		}
		else {
			getSwingEditorJSchemaObjInterface().setTextValue( popObj.getOptionalJSchemaObjInterface() );
		}

		if( popObj == null ) {
			getSwingEditorJSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJSchemaObjMembers().setTextValue( popObj.getOptionalJSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJSchemaObjImplementation().setTextValue( null );
		}
		else {
			getSwingEditorJSchemaObjImplementation().setTextValue( popObj.getOptionalJSchemaObjImplementation() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWSchemaObjMembers().setTextValue( popObj.getOptionalJDb2LUWSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWSchemaObjImpl().setTextValue( popObj.getOptionalJDb2LUWSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJDb2LUWSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJDb2LUWSchemaObjImport().setTextValue( popObj.getOptionalJDb2LUWSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlSchemaObjMembers().setTextValue( popObj.getOptionalJMSSqlSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlSchemaObjImpl().setTextValue( popObj.getOptionalJMSSqlSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJMSSqlSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJMSSqlSchemaObjImport().setTextValue( popObj.getOptionalJMSSqlSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlSchemaObjMembers().setTextValue( popObj.getOptionalJMySqlSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlSchemaObjImpl().setTextValue( popObj.getOptionalJMySqlSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJMySqlSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJMySqlSchemaObjImport().setTextValue( popObj.getOptionalJMySqlSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJOracleSchemaObjMembers().setTextValue( popObj.getOptionalJOracleSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJOracleSchemaObjImpl().setTextValue( popObj.getOptionalJOracleSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJOracleSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJOracleSchemaObjImport().setTextValue( popObj.getOptionalJOracleSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlSchemaObjMembers().setTextValue( popObj.getOptionalJPgSqlSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlSchemaObjImpl().setTextValue( popObj.getOptionalJPgSqlSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJPgSqlSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJPgSqlSchemaObjImport().setTextValue( popObj.getOptionalJPgSqlSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseSchemaObjMembers().setTextValue( popObj.getOptionalJSybaseSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseSchemaObjImpl().setTextValue( popObj.getOptionalJSybaseSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJSybaseSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJSybaseSchemaObjImport().setTextValue( popObj.getOptionalJSybaseSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJRamSchemaObjMembers().setTextValue( null );
		}
		else {
			getSwingEditorJRamSchemaObjMembers().setTextValue( popObj.getOptionalJRamSchemaObjMembers() );
		}

		if( popObj == null ) {
			getSwingEditorJRamSchemaObjImpl().setTextValue( null );
		}
		else {
			getSwingEditorJRamSchemaObjImpl().setTextValue( popObj.getOptionalJRamSchemaObjImpl() );
		}

		if( popObj == null ) {
			getSwingEditorJRamSchemaObjImport().setTextValue( null );
		}
		else {
			getSwingEditorJRamSchemaObjImport().setTextValue( popObj.getOptionalJRamSchemaObjImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgSchemaImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgSchemaImport().setTextValue( popObj.getOptionalJXMsgSchemaImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgSchemaFormatters().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgSchemaFormatters().setTextValue( popObj.getOptionalJXMsgSchemaFormatters() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgClientSchemaImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgClientSchemaImport().setTextValue( popObj.getOptionalJXMsgClientSchemaImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgClientSchemaBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgClientSchemaBody().setTextValue( popObj.getOptionalJXMsgClientSchemaBody() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstSchemaBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstSchemaBody().setTextValue( popObj.getOptionalJXMsgRqstSchemaBody() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstSchemaImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstSchemaImport().setTextValue( popObj.getOptionalJXMsgRqstSchemaImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstSchemaWireParsers().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstSchemaWireParsers().setTextValue( popObj.getOptionalJXMsgRqstSchemaWireParsers() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstSchemaXsdSpec().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstSchemaXsdSpec().setTextValue( popObj.getOptionalJXMsgRqstSchemaXsdSpec() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRqstSchemaXsdElementList().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRqstSchemaXsdElementList().setTextValue( popObj.getOptionalJXMsgRqstSchemaXsdElementList() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnSchemaBody().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnSchemaBody().setTextValue( popObj.getOptionalJXMsgRspnSchemaBody() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnSchemaImport().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnSchemaImport().setTextValue( popObj.getOptionalJXMsgRspnSchemaImport() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnSchemaWireParsers().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnSchemaWireParsers().setTextValue( popObj.getOptionalJXMsgRspnSchemaWireParsers() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnSchemaXsdElementList().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnSchemaXsdElementList().setTextValue( popObj.getOptionalJXMsgRspnSchemaXsdElementList() );
		}

		if( popObj == null ) {
			getSwingEditorJXMsgRspnSchemaXsdSpec().setTextValue( null );
		}
		else {
			getSwingEditorJXMsgRspnSchemaXsdSpec().setTextValue( popObj.getOptionalJXMsgRspnSchemaXsdSpec() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
		ICFBamSchemaDefEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSchemaDefEditObj)(focus.getEdit());
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

		swingLookupDefaultLicenseObj = (ICFBamLicenseObj)( swingReferenceLookupDefaultLicense.getReferencedObject() );
		editObj.setOptionalLookupDefaultLicense( swingLookupDefaultLicenseObj );

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

		editObj.setRequiredName( getSwingEditorName().getStringValue() );

		editObj.setOptionalDbName( getSwingEditorDbName().getStringValue() );

		editObj.setOptionalShortName( getSwingEditorShortName().getStringValue() );

		editObj.setOptionalLabel( getSwingEditorLabel().getStringValue() );

		editObj.setOptionalShortDescription( getSwingEditorShortDescription().getStringValue() );

		editObj.setOptionalDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredExtendCFCore( getSwingEditorExtendCFCore().getBooleanValue() );

		editObj.setRequiredCopyrightPeriod( getSwingEditorCopyrightPeriod().getStringValue() );

		editObj.setRequiredCopyrightHolder( getSwingEditorCopyrightHolder().getStringValue() );

		editObj.setRequiredPublishURI( getSwingEditorPublishURI().getStringValue() );

		editObj.setOptionalJSchemaObjImport( getSwingEditorJSchemaObjImport().getTextValue() );

		editObj.setOptionalJSchemaObjInterface( getSwingEditorJSchemaObjInterface().getTextValue() );

		editObj.setOptionalJSchemaObjMembers( getSwingEditorJSchemaObjMembers().getTextValue() );

		editObj.setOptionalJSchemaObjImplementation( getSwingEditorJSchemaObjImplementation().getTextValue() );

		editObj.setOptionalJDb2LUWSchemaObjMembers( getSwingEditorJDb2LUWSchemaObjMembers().getTextValue() );

		editObj.setOptionalJDb2LUWSchemaObjImpl( getSwingEditorJDb2LUWSchemaObjImpl().getTextValue() );

		editObj.setOptionalJDb2LUWSchemaObjImport( getSwingEditorJDb2LUWSchemaObjImport().getTextValue() );

		editObj.setOptionalJMSSqlSchemaObjMembers( getSwingEditorJMSSqlSchemaObjMembers().getTextValue() );

		editObj.setOptionalJMSSqlSchemaObjImpl( getSwingEditorJMSSqlSchemaObjImpl().getTextValue() );

		editObj.setOptionalJMSSqlSchemaObjImport( getSwingEditorJMSSqlSchemaObjImport().getTextValue() );

		editObj.setOptionalJMySqlSchemaObjMembers( getSwingEditorJMySqlSchemaObjMembers().getTextValue() );

		editObj.setOptionalJMySqlSchemaObjImpl( getSwingEditorJMySqlSchemaObjImpl().getTextValue() );

		editObj.setOptionalJMySqlSchemaObjImport( getSwingEditorJMySqlSchemaObjImport().getTextValue() );

		editObj.setOptionalJOracleSchemaObjMembers( getSwingEditorJOracleSchemaObjMembers().getTextValue() );

		editObj.setOptionalJOracleSchemaObjImpl( getSwingEditorJOracleSchemaObjImpl().getTextValue() );

		editObj.setOptionalJOracleSchemaObjImport( getSwingEditorJOracleSchemaObjImport().getTextValue() );

		editObj.setOptionalJPgSqlSchemaObjMembers( getSwingEditorJPgSqlSchemaObjMembers().getTextValue() );

		editObj.setOptionalJPgSqlSchemaObjImpl( getSwingEditorJPgSqlSchemaObjImpl().getTextValue() );

		editObj.setOptionalJPgSqlSchemaObjImport( getSwingEditorJPgSqlSchemaObjImport().getTextValue() );

		editObj.setOptionalJSybaseSchemaObjMembers( getSwingEditorJSybaseSchemaObjMembers().getTextValue() );

		editObj.setOptionalJSybaseSchemaObjImpl( getSwingEditorJSybaseSchemaObjImpl().getTextValue() );

		editObj.setOptionalJSybaseSchemaObjImport( getSwingEditorJSybaseSchemaObjImport().getTextValue() );

		editObj.setOptionalJRamSchemaObjMembers( getSwingEditorJRamSchemaObjMembers().getTextValue() );

		editObj.setOptionalJRamSchemaObjImpl( getSwingEditorJRamSchemaObjImpl().getTextValue() );

		editObj.setOptionalJRamSchemaObjImport( getSwingEditorJRamSchemaObjImport().getTextValue() );

		editObj.setOptionalJXMsgSchemaImport( getSwingEditorJXMsgSchemaImport().getTextValue() );

		editObj.setOptionalJXMsgSchemaFormatters( getSwingEditorJXMsgSchemaFormatters().getTextValue() );

		editObj.setOptionalJXMsgClientSchemaImport( getSwingEditorJXMsgClientSchemaImport().getTextValue() );

		editObj.setOptionalJXMsgClientSchemaBody( getSwingEditorJXMsgClientSchemaBody().getTextValue() );

		editObj.setOptionalJXMsgRqstSchemaBody( getSwingEditorJXMsgRqstSchemaBody().getTextValue() );

		editObj.setOptionalJXMsgRqstSchemaImport( getSwingEditorJXMsgRqstSchemaImport().getTextValue() );

		editObj.setOptionalJXMsgRqstSchemaWireParsers( getSwingEditorJXMsgRqstSchemaWireParsers().getTextValue() );

		editObj.setOptionalJXMsgRqstSchemaXsdSpec( getSwingEditorJXMsgRqstSchemaXsdSpec().getTextValue() );

		editObj.setOptionalJXMsgRqstSchemaXsdElementList( getSwingEditorJXMsgRqstSchemaXsdElementList().getTextValue() );

		editObj.setOptionalJXMsgRspnSchemaBody( getSwingEditorJXMsgRspnSchemaBody().getTextValue() );

		editObj.setOptionalJXMsgRspnSchemaImport( getSwingEditorJXMsgRspnSchemaImport().getTextValue() );

		editObj.setOptionalJXMsgRspnSchemaWireParsers( getSwingEditorJXMsgRspnSchemaWireParsers().getTextValue() );

		editObj.setOptionalJXMsgRspnSchemaXsdElementList( getSwingEditorJXMsgRspnSchemaXsdElementList().getTextValue() );

		editObj.setOptionalJXMsgRspnSchemaXsdSpec( getSwingEditorJXMsgRspnSchemaXsdSpec().getTextValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSchemaDefEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSchemaDefEditObj)focus.getEdit();
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
								editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
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
							editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
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
						focus = (ICFBamSchemaDefObj)editObj.create();
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
								editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
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
								editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
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
							editObj = (ICFBamSchemaDefEditObj)focus.beginEdit();
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
			ICFBamSchemaDefObj focus = getSwingFocusAsSchemaDef();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerCTenant != null ) {
			swingReferenceOwnerCTenant.setEnabled( false );
		}
		if( swingReferenceContainerDomain != null ) {
			swingReferenceContainerDomain.setEnabled( false );
		}
		if( swingReferenceLookupDefaultLicense != null ) {
			swingReferenceLookupDefaultLicense.setEnabled( isEditing );
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
		if( swingEditorExtendCFCore != null ) {
			swingEditorExtendCFCore.setEnabled( isEditing );
		}
		if( swingEditorCopyrightPeriod != null ) {
			swingEditorCopyrightPeriod.setEnabled( isEditing );
		}
		if( swingEditorCopyrightHolder != null ) {
			swingEditorCopyrightHolder.setEnabled( isEditing );
		}
		if( swingEditorPublishURI != null ) {
			swingEditorPublishURI.setEnabled( isEditing );
		}
		if( swingEditorJSchemaObjImport != null ) {
			swingEditorJSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJSchemaObjInterface != null ) {
			swingEditorJSchemaObjInterface.setEnabled( isEditing );
		}
		if( swingEditorJSchemaObjMembers != null ) {
			swingEditorJSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJSchemaObjImplementation != null ) {
			swingEditorJSchemaObjImplementation.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWSchemaObjMembers != null ) {
			swingEditorJDb2LUWSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWSchemaObjImpl != null ) {
			swingEditorJDb2LUWSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJDb2LUWSchemaObjImport != null ) {
			swingEditorJDb2LUWSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlSchemaObjMembers != null ) {
			swingEditorJMSSqlSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlSchemaObjImpl != null ) {
			swingEditorJMSSqlSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJMSSqlSchemaObjImport != null ) {
			swingEditorJMSSqlSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJMySqlSchemaObjMembers != null ) {
			swingEditorJMySqlSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJMySqlSchemaObjImpl != null ) {
			swingEditorJMySqlSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJMySqlSchemaObjImport != null ) {
			swingEditorJMySqlSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJOracleSchemaObjMembers != null ) {
			swingEditorJOracleSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJOracleSchemaObjImpl != null ) {
			swingEditorJOracleSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJOracleSchemaObjImport != null ) {
			swingEditorJOracleSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlSchemaObjMembers != null ) {
			swingEditorJPgSqlSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlSchemaObjImpl != null ) {
			swingEditorJPgSqlSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJPgSqlSchemaObjImport != null ) {
			swingEditorJPgSqlSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJSybaseSchemaObjMembers != null ) {
			swingEditorJSybaseSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJSybaseSchemaObjImpl != null ) {
			swingEditorJSybaseSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJSybaseSchemaObjImport != null ) {
			swingEditorJSybaseSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJRamSchemaObjMembers != null ) {
			swingEditorJRamSchemaObjMembers.setEnabled( isEditing );
		}
		if( swingEditorJRamSchemaObjImpl != null ) {
			swingEditorJRamSchemaObjImpl.setEnabled( isEditing );
		}
		if( swingEditorJRamSchemaObjImport != null ) {
			swingEditorJRamSchemaObjImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgSchemaImport != null ) {
			swingEditorJXMsgSchemaImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgSchemaFormatters != null ) {
			swingEditorJXMsgSchemaFormatters.setEnabled( isEditing );
		}
		if( swingEditorJXMsgClientSchemaImport != null ) {
			swingEditorJXMsgClientSchemaImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgClientSchemaBody != null ) {
			swingEditorJXMsgClientSchemaBody.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstSchemaBody != null ) {
			swingEditorJXMsgRqstSchemaBody.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstSchemaImport != null ) {
			swingEditorJXMsgRqstSchemaImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstSchemaWireParsers != null ) {
			swingEditorJXMsgRqstSchemaWireParsers.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstSchemaXsdSpec != null ) {
			swingEditorJXMsgRqstSchemaXsdSpec.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRqstSchemaXsdElementList != null ) {
			swingEditorJXMsgRqstSchemaXsdElementList.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnSchemaBody != null ) {
			swingEditorJXMsgRspnSchemaBody.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnSchemaImport != null ) {
			swingEditorJXMsgRspnSchemaImport.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnSchemaWireParsers != null ) {
			swingEditorJXMsgRspnSchemaWireParsers.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnSchemaXsdElementList != null ) {
			swingEditorJXMsgRspnSchemaXsdElementList.setEnabled( isEditing );
		}
		if( swingEditorJXMsgRspnSchemaXsdSpec != null ) {
			swingEditorJXMsgRspnSchemaXsdSpec.setEnabled( isEditing );
		}
	}
}
