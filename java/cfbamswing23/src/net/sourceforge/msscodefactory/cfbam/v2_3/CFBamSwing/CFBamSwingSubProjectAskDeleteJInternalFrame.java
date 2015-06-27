// Description: Java 7 Swing Ask Delete JInternalFrame implementation for SubProject.

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
 *	CFBamSwingSubProjectAskDeleteJInternalFrame Swing Ask Delete JInternalFrame implementation
 *	for SubProject.
 */
public class CFBamSwingSubProjectAskDeleteJInternalFrame
extends CFJInternalFrame
implements ICFBamSwingSubProjectJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected JPanel swingAskDeleteJPanel = null;

	public CFBamSwingSubProjectAskDeleteJInternalFrame( ICFBamSwingSchema argSchema, ICFBamSubProjectObj argFocus ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		swingSchema = argSchema;
		setSwingFocus( argFocus );
		swingAskDeleteJPanel = argSchema.getSubProjectFactory().newAskDeleteJPanel( argFocus );
		setContentPane( swingAskDeleteJPanel );
		Dimension dim = new Dimension( 1024, 480 );
		setSize( dim );
		dim = new Dimension( 320, 240 );
		setMinimumSize( dim );
		setTitle( "Confirm deletion of SubProject" );
		setIconifiable( false );
		setMaximizable( true );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamSubProjectObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSubProjectObj" );
		}
	}

	public ICFBamSubProjectObj getSwingFocusAsSubProject() {
		return( (ICFBamSubProjectObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSubProject( ICFBamSubProjectObj value ) {
		swingFocus = value;
		((ICFBamSwingSubProjectJPanelCommon)swingAskDeleteJPanel).setSwingFocus( swingFocus );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldMode = getPanelMode();
		if( oldMode == value ) {
			return;
		}
		super.setPanelMode( value );
		if( ( value != CFJPanel.PanelMode.Unknown )
		 && ( value != CFJPanel.PanelMode.View )
		 && ( value != CFJPanel.PanelMode.Delete ) )
		{
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"AskDeleteJInternalFrames only support PanelMode Unknown, View or Delete" );
		}
		((ICFBamSwingSubProjectJPanelCommon)swingAskDeleteJPanel).setPanelMode( value );
	}
}
