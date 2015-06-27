// Description: Java 7 Swing Display Element Factory for Value.

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
 *	CFBamSwingValueFactory Swing Display Element Factory
 *	for Value.
 */
public class CFBamSwingValueFactory
implements ICFBamSwingValueFactory
{
	protected ICFBamSwingSchema swingSchema = null;

	public CFBamSwingValueFactory( ICFBamSwingSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		swingSchema = argSchema;
	}

	public JPanel newAttrJPanel( ICFBamValueObj argFocus ) {
		CFBamSwingValueAttrJPanel retnew = new CFBamSwingValueAttrJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newListJPanel( ICFBamValueObj argFocus, ICFBamScopeObj argContainer, Collection<ICFBamValueObj> dataCollection, ICFJRefreshCallback refreshCallback, boolean sortByChain ) {
		CFBamSwingValueListJPanel retnew = new CFBamSwingValueListJPanel( swingSchema, argContainer, argFocus, dataCollection, refreshCallback, sortByChain );
		return( retnew );
	}

	public JPanel newAskDeleteJPanel( ICFBamValueObj argFocus ) {
		CFBamSwingValueAskDeleteJPanel retnew = new CFBamSwingValueAskDeleteJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newPickerJPanel( ICFBamValueObj argFocus, ICFBamScopeObj argContainer, Collection<ICFBamValueObj> dataCollection, ICFBamSwingValueChosen whenChosen ) {
		CFBamSwingValuePickerJPanel retnew = new CFBamSwingValuePickerJPanel( swingSchema, argFocus, argContainer, dataCollection, whenChosen );
		return( retnew );
	}

	public JTabbedPane newEltJTabbedPane( ICFBamValueObj argFocus ) {
		CFBamSwingValueEltJTabbedPane retnew = new CFBamSwingValueEltJTabbedPane( swingSchema, argFocus );
		return( retnew );
	}

	public JPanel newViewEditJPanel( ICFBamValueObj argFocus ) {
		CFBamSwingValueViewEditJPanel retnew = new CFBamSwingValueViewEditJPanel( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newAskDeleteJInternalFrame( ICFBamValueObj argFocus ) {
		CFBamSwingValueAskDeleteJInternalFrame retnew = new CFBamSwingValueAskDeleteJInternalFrame( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newViewEditJInternalFrame( ICFBamValueObj argFocus ) {
		CFBamSwingValueViewEditJInternalFrame retnew = new CFBamSwingValueViewEditJInternalFrame( swingSchema, argFocus );
		return( retnew );
	}

	public JInternalFrame newPickerJInternalFrame( ICFBamValueObj argFocus, ICFBamScopeObj argContainer, Collection<ICFBamValueObj> dataCollection, ICFBamSwingValueChosen whenChosen ) {
		CFBamSwingValuePickerJInternalFrame retnew = new CFBamSwingValuePickerJInternalFrame( swingSchema, argFocus, argContainer, dataCollection, whenChosen );
		return( retnew );
	}
}
