// Description: Java7 configuration file for a CFBam schema.

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

public class CFBamConfigurationFile
{
	protected String fileName = null;
	protected Properties props = new Properties();
	protected int netServerPort = -1;
	protected String dbServerClassName = null;
	protected String dbServer = null;
	protected int dbPort = -1;
	protected String dbDatabase = null;
	protected String dbUserName = null;
	protected String dbPassword = null;

	public CFBamConfigurationFile() {
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
			props.store( writer, "CFBamConfigurationFile" );
			writer.close();
		}
		catch( IOException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				"save",
				"IOException " + e.getMessage(),
				e );
		}
	}

	public int getNetServerPort() {
		if( netServerPort < 0 ) {
			String strValue = get( "NetServerPort" );
			netServerPort = Integer.parseInt( strValue );
		}
		return( netServerPort );
	}

	public void setNetServerPort( int value ) {
		netServerPort = value;
		String strValue = Integer.toString( netServerPort );
		set( "NetServerPort", strValue );
	}

	public String getDbServerClassName() {
		if( dbServerClassName == null ) {
			dbServerClassName = get( "DbServerClassName" );
		}
		return( dbServerClassName );
	}

	public void setDbServerClassName( String value ) {
		dbServerClassName = value;
		set( "DbServerClassName", dbServerClassName );
	}

	public String getDbServer() {
		if( dbServer == null ) {
			dbServer = get( "DbServer" );
		}
		return( dbServer );
	}
	
	public void setDbServer( String value ) {
		dbServer = value;
		set( "DbServer", dbServer );
	}

	public int getDbPort() {
		if( dbPort < 0 ) {
			String strValue = get( "DbPort" );
			dbPort = Integer.parseInt( strValue );
		}
		return( dbPort );
	}

	public void setDbPort( int value ) {
		dbPort = value;
		String strValue = Integer.toString( dbPort );
		set( "DbPort", strValue );
	}

	public String getDbDatabase() {
		if( dbDatabase == null ) {
			dbDatabase = get( "DbDatabase" );
		}
		return( dbDatabase );
	}

	public void setDbDatabase( String value ) {
		dbDatabase = value;
		set( "DbDatabase", dbDatabase );
	}

	public String getDbUserName() {
		if( dbUserName == null ) {
			dbUserName = get( "DbUserName" );
		}
		return( dbUserName );
	}

	public void setDbUserName( String value ) {
		dbUserName = value;
		set( "DbUserName", dbUserName );
	}

	public String getDbPassword() {
		if( dbPassword == null ) {
			dbPassword = get( "DbPassword" );
		}
		return( dbPassword );
	}
	
	public void setDbPassword( String value ) {
		dbPassword = value;
		set( "DbPassword", dbPassword );
	}
}
