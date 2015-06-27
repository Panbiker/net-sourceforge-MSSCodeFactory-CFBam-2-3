// Description: Java 7 Swing Display Element Factory for Scope.

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
 *	CFBamSwingScopeFactory Swing Display Element Factory
 *	for Scope.
 */
public class CFBamSwingScopeFactory
implements ICFBamSwingScopeFactory
{
	protected ICFBamSwingSchema swingSchema = null;

	public CFBamSwingScopeFactory( ICFBamSwingSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		swingSchema = argSchema;
	}

	public JPanel newAttrJPanel( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeAttrJPanel retnew = new CFBamSwingScopeAttrJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newListJPanel( ICFBamScopeObj argFocus, ICFLibAnyObj argContainer, Collection<ICFBamScopeObj> dataCollection, ICFJRefreshCallback refreshCallback, boolean sortByChain ) {
		CFBamSwingScopeListJPanel retnew = new CFBamSwingScopeListJPanel( swingSchema, argContainer, argFocus, dataCollection, refreshCallback, sortByChain );
		return( retnew );
	}

	public JPanel newAskDeleteJPanel( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeAskDeleteJPanel retnew = new CFBamSwingScopeAskDeleteJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newPickerJPanel( ICFBamScopeObj argFocus, ICFLibAnyObj argContainer, Collection<ICFBamScopeObj> dataCollection, ICFBamSwingScopeChosen whenChosen ) {
		CFBamSwingScopePickerJPanel retnew = new CFBamSwingScopePickerJPanel( swingSchema, argFocus, argContainer, dataCollection, whenChosen );
		return( retnew );
	}

	public JTabbedPane newEltJTabbedPane( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeEltJTabbedPane retnew = new CFBamSwingScopeEltJTabbedPane( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newViewEditJPanel( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeViewEditJPanel retnew = new CFBamSwingScopeViewEditJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newAskDeleteJInternalFrame( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeAskDeleteJInternalFrame retnew = new CFBamSwingScopeAskDeleteJInternalFrame( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newViewEditJInternalFrame( ICFBamScopeObj argFocus ) {
		CFBamSwingScopeViewEditJInternalFrame retnew = new CFBamSwingScopeViewEditJInternalFrame( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newPickerJInternalFrame( ICFBamScopeObj argFocus, ICFLibAnyObj argContainer, Collection<ICFBamScopeObj> dataCollection, ICFBamSwingScopeChosen whenChosen ) {
		CFBamSwingScopePickerJInternalFrame retnew = new CFBamSwingScopePickerJInternalFrame( swingSchema, argFocus, argContainer, dataCollection, whenChosen );
		return( retnew );
	}
}
