--
--	@(#) dbcreate/cfbam/oracle/crupd_iso_ccy.plsql
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
--	Code manufactured MSS Code Factory
--


create or replace procedure cfbam23.upd_iso_ccy(
	retCursor out sys_refcursor,
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar2,
	argId smallint,
	argiso_code varchar2,
	argccy_name varchar2,
	argunit_symbol varchar2,
	argfrac_symbol varchar2,
	argprecis smallint,
	argRevision integer )
is
	oldId smallint;
	oldiso_code varchar2(3);
	oldccy_name varchar2(64);
	oldunit_symbol varchar2(1);
	oldfrac_symbol varchar2(1);
	oldprecis smallint;
	oldRevision integer;
	dataCollision exception;
	dataUpdateFailed exception;
	permissionDenied exception;
	permissionFlag integer;
begin
	if( argClassCode = 'ISCY' )
	then
		permissionFlag := cfbam23.sp_is_system_user( argAuditUserId );
		if( permissionFlag = 0 )
		then
			raise permissionDenied;
		end if;
	end if;

		select
			Id,
			iso_code,
			ccy_name,
			unit_symbol,
			frac_symbol,
			precis,
			revision
		into
			oldId,
			oldiso_code,
			oldccy_name,
			oldunit_symbol,
			oldfrac_symbol,
			oldprecis,
			oldRevision
		from cfbam23.iso_ccy
		where
			Id = argId
		for update;

	if argRevision != oldRevision
	then
		raise dataCollision;
	end if;

	update cfbam23.iso_ccy
	set
		revision = argRevision + 1,
		updatedby = argAuditUserId,
		updatedat = sysdate,
		iso_code = argiso_code,
		ccy_name = argccy_name,
		unit_symbol = argunit_symbol,
		frac_symbol = argfrac_symbol,
		precis = argprecis
	where
		Id = argId
		and revision = argRevision;

	if sql%rowcount != 1 then
		raise dataUpdateFailed;
	end if;


	insert into cfbam23.iso_ccy_h (
			Id,
			revision,
			auditclusterid,
			auditsessionid,
			iso_code,
			ccy_name,
			unit_symbol,
			frac_symbol,
			precis,
			auditaction,
			auditstamp )
		select
			iscy.Id as Id,
			argRevision + 1 as revision,
			argAuditClusterId,
			argAuditSessionId,
			iscy.iso_code as iso_code,
			iscy.ccy_name as ccy_name,
			iscy.unit_symbol as unit_symbol,
			iscy.frac_symbol as frac_symbol,
			iscy.precis as precis,
			2,
			sysdate
		from cfbam23.iso_ccy iscy
		where
			iscy.Id = argId;

	open retCursor for select
			iscy.createdby,
			to_char( iscy.createdat, 'YYYY-MM-DD HH24:MI:SS' ) as createdat,
			iscy.updatedby,
			to_char( iscy.updatedat, 'YYYY-MM-DD HH24:MI:SS' ) as updatedat,
			iscy.Id as Id,
			iscy.iso_code as iso_code,
			iscy.ccy_name as ccy_name,
			iscy.unit_symbol as unit_symbol,
			iscy.frac_symbol as frac_symbol,
			iscy.precis as precis,
		iscy.revision as revision
	from cfbam23.iso_ccy iscy
	where
		iscy.Id = argId;
end upd_iso_ccy;

/

show errors procedure cfbam23.upd_iso_ccy;
/