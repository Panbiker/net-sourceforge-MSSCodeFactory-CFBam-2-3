// Description: Java7 client configuration file for a CFBam schema.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBam;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;

public class CFBamClientConfigurationFile
{
	protected String fileName = null;
	protected Properties props = new Properties();
	protected String keyStore = null;
	protected String deviceName = null;

	public CFBamClientConfigurationFile() {
	}

	public String getFileName() {
		return( fileName );
	}

	public void setFileName( String value ) {
		fileName = value;
	}

	public String get( String theKey ) {
		return( props.getProperty( theKey ) );
	}

	public void set( String theKey, String theValue ) {
		set( theKey, theValue, false );
	}

	public void set(String theKey, String theValue, boolean doSave ) {
		props.put( theKey, theValue );
		if( doSave ) {
			save();
		}
	}

	public void load() {
		load( fileName );
	}

	public void load( String configFileName ) {
		boolean doSave = false;
		try {
			FileReader reader = new FileReader( configFileName );
			props.load( reader );
			reader.close();
			keyStore = null;
			deviceName = null;
			loadServerURLProperties();
		}
		catch( FileNotFoundException e ) {
			doSave = true;
		}
		catch( IOException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				"load",
				"IOException " + e.getMessage(),
				e );
		}
		if( doSave ) {
			save();
		}
	}

	public void save() {
		try {
			FileWriter writer = new FileWriter( fileName );
			props.store( writer, "CFBamClientConfigurationFile" );
			writer.close();
		}
		catch( IOException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				"save",
				"IOException " + e.getMessage(),
				e );
		}
	}

	public String getKeyStore() {
		if( keyStore == null ) {
			keyStore = get( "KeyStore" );
		}
		return( keyStore );
	}
	
	public void setKeyStore( String value ) {
		keyStore = value;
		set( "KeyStore", keyStore );
	}

	public String getDeviceName() {
		if( deviceName == null ) {
			deviceName = get( "DeviceName" );
		}
		return( deviceName );
	}

	public void setDeviceName( String value ) {
		deviceName = value;
		set( "DeviceName", deviceName );
	}

	public final int maxServerURL = 20;
	public final int maxServerURLIndex = maxServerURL - 1;
	public final String attrNamePrefix = "ServerURL";

	protected String arrServerURL[] = new String[0];

	public String[] getServerURLArray() {
		return( arrServerURL );
	}

	public void loadServerURLProperties() {
		int curIdx;
		int maxURL = 0;
		String curURL;
		String attrName;
		for( curIdx = 0; curIdx < maxServerURL; curIdx ++ ) {
			attrName = attrNamePrefix + Integer.toString( curIdx );
			curURL = get( attrName );
			if( ( curURL != null ) && ( curURL.length() > 0 ) ) {
				maxURL = curIdx + 1;
			}
		}
		if( maxURL > 0 ) {
			String newServerURL[] = new String[ maxURL ];
			for( curIdx = 0; curIdx < maxURL; curIdx ++ ) {
				attrName = attrNamePrefix + Integer.toString( curIdx );
				curURL = get( attrName );
				newServerURL[curIdx] = curURL;
			}
			arrServerURL = newServerURL;
		}
	}

	public String getLatestServerURL() {
		String latest;
		String curServerURL[] = arrServerURL;
		if( curServerURL.length > 0 ) {
			latest = curServerURL[0];
		}
		else {
			latest = null;
		}
		return( latest );
	}

	public void setLatestServerURL( String value ) {
		final String S_ProcName = "setLatestServerURL";
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}

		int foundServerURLAtIndex = -1;
		String curServerURLArray[] = arrServerURL;
		int numIdx = curServerURLArray.length;
		int curIdx;
		String curServerURL;

		for( curIdx = 0; curIdx < numIdx; curIdx ++ ) {
			curServerURL = curServerURLArray[curIdx];
			if( value.equals( curServerURL ) ) {
				foundServerURLAtIndex = curIdx;
				curIdx = numIdx;
			}
		}

		if( foundServerURLAtIndex == 0 ) {
			// Do nothing -- it's already at the top
			return;
		}

		String attrName;
		String curValue;
		String newServerURL[];
		
		if( foundServerURLAtIndex < 0 ) {
			// Not found, needs to be inserted at head
			newServerURL = new String[ numIdx + 1 ];
			newServerURL[0] = value;
			for( curIdx = 0; curIdx < numIdx; curIdx ++ ) {
				newServerURL[ curIdx + 1 ] = arrServerURL[ curIdx ];
			}
			arrServerURL = newServerURL;
			numIdx = newServerURL.length;
			curIdx = numIdx - 1;
			while( curIdx >= 0 ) {
				attrName = attrNamePrefix + Integer.toString( curIdx );
				curValue = newServerURL[ curIdx ];
				set( attrName, curValue );
				curIdx --;
			}
			save();
		}
		else if( foundServerURLAtIndex < maxServerURL ) {
			// Found, needs to move up
			newServerURL = new String[ numIdx ];
			newServerURL[0] = value;
			for( curIdx = 0; curIdx < foundServerURLAtIndex; curIdx ++ ) {
				newServerURL[ curIdx + 1 ] = curServerURLArray[curIdx];
			}
			curIdx ++;
			while( curIdx < numIdx ) {
				newServerURL[ curIdx + 1 ] = curServerURLArray[curIdx];
				curIdx ++;
			}
		}
		else {
			// Found past maximum allowable index, trim array of serverURL.
			newServerURL = new String[ maxServerURL ];
			newServerURL[0] = value;
			for( curIdx = 0; curIdx < maxServerURL; curIdx ++ ) {
				newServerURL[ curIdx + 1 ] = curServerURLArray[curIdx];
			}
		}

		arrServerURL = newServerURL;
		numIdx = newServerURL.length;
		for( curIdx = 0; curIdx < numIdx; curIdx -- ) {
			attrName = attrNamePrefix + Integer.toString( curIdx );
			curValue = newServerURL[ curIdx ];
			set( attrName, curValue );
		}

		save();
	}
}
