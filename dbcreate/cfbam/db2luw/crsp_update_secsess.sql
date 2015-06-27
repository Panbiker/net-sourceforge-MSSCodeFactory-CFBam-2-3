--
--	@(#) dbcreate/cfbam/db2luw/crsp_update_secsess.sql
--
--	CFBam
--
--	Copyright (c) 2014-2015 Mark Sobkow
--	
--	This program is available as free software under the GNU GPL v3, under
--	the Eclipse Public License 1.0, or under a commercial license from Mark
--	Sobkow.  For commercial licensing details, please contact msobkow@sasktel.net.
--	
--	You should have received copies of the complete license text for
--	GPLv3.txt and EPLv1_0.txt, containing the text
--	of the GNU General Public License v 3.0 and the Eclipse Public License v 1.0.
--	
--	Under the terms of the GPL:
--	
--		This program is free software: you can redistribute it and/or modify
--		it under the terms of the GNU General Public License as published by
--		the Free Software Foundation, either version 3 of the License, or
--		(at your option) any later version.
--	  
--		This program is distributed in the hope that it will be useful,
--		but WITHOUT ANY WARRANTY; without even the implied warranty of
--		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--		GNU General Public License for more details.
--	  
--		You should have received a copy of the GNU General Public License
--		along with this program.  If not, see <http://www.gnu.org/licenses/>.
--	
--	This software incorporates code originally Copyright (c) Mark Sobkow 2014-2015
--	and licensed under the BSD 3-Clause license as written by xfree86.org:
--	
--	Redistribution and use in source and binary forms, with or without
--	modification, are permitted provided that the following conditions are
--	met:
--	
--	    (1) Redistributions of source code must retain the above copyright
--	    notice, this list of conditions and the following disclaimer. 
--	
--	    (2) Redistributions in binary form must reproduce the above copyright
--	    notice, this list of conditions and the following disclaimer in
--	    the documentation and/or other materials provided with the
--	    distribution.  
--	    
--	    (3)The name of the author may not be used to
--	    endorse or promote products derived from this software without
--	    specific prior written permission.
--	
--	THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
--	IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
--	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
--	DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
--	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
--	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
--	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
--	HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
--	STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
--	IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
--	POSSIBILITY OF SUCH DAMAGE.
--	
--
-- **********************************************************************
--
--	Code manufactured by MSS Code Factory
--


create or replace procedure sp_update_secsess(	\
	in argAuditClusterId bigint,	\
	in argAuditUserId varchar(36),	\
	in argAuditSessionId varchar(36),	\
	in secClusterId bigint,	\
	in secTenantId bigint,	\
	in argClassCode varchar(4),	\
	in argSecSessionId varchar(36),	\
	in argSecUserId varchar(36),	\
	in argSecDevName varchar(127),	\
	in argStart timestamp,	\
	in argFinish timestamp,	\
	in argSecProxyId varchar(36),	\
	in argRevision integer )	\
dynamic result sets 1	\
language sql	\
begin	\
	declare oldSecSessionId varchar(36);	\
	declare oldSecUserId varchar(36);	\
	declare oldSecDevName varchar(127);	\
	declare oldStart timestamp;	\
	declare oldFinish timestamp;	\
	declare oldSecProxyId varchar(36);	\
	declare oldRevision int;	\
	declare permissionFlag integer;	\
	declare retcursor cursor with return to client for	\
		select	\
				sess.secsessionid as secsessionid,	\
			sess.secuserid as secuserid,	\
			sess.secdevname as secdevname,	\
			to_char( sess.start_ts, 'YYYY-MM-DD-HH24.MI.SS' ) as start_ts,	\
			to_char( sess.finish_ts, 'YYYY-MM-DD-HH24.MI.SS' ) as finish_ts,	\
			sess.secproxyid as secproxyid,	\
			sess.revision as revision	\
		from cfbam23.SecSess as sess	\
		where	\
			sess.secsessionid = argSecSessionId;	\
	begin	\
		select	\
			SecSessionId,	\
			SecUserId,	\
			SecDevName,	\
			start_ts,	\
			finish_ts,	\
			SecProxyId,	\
			revision	\
		into	\
			oldSecSessionId,	\
			oldSecUserId,	\
			oldSecDevName,	\
			oldStart,	\
			oldFinish,	\
			oldSecProxyId,	\
			oldRevision	\
		from cfbam23.SecSess	\
		where	\
			SecSessionId = argSecSessionId	\
		for update;	\
	\
		if argRevision != oldRevision	\
		then	\
			call raise_application_error( -20002, 'sp_update_secsess() Data collision detected' );	\
		end if;	\
	\
		update cfbam23.SecSess	\
		set	\
			revision = argRevision + 1,	\
			secuserid = argSecUserId,	\
			secdevname = argSecDevName,	\
			start_ts = argStart,	\
			finish_ts = argFinish,	\
			secproxyid = argSecProxyId	\
		where	\
			secsessionid = argSecSessionId	\
		and revision = argRevision;	\
	\
		open retcursor;	\
	end;	\
end
