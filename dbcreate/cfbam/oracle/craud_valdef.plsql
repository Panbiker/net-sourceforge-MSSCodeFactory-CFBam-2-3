--
--	@(#) dbcreate/cfbam/oracle/craud_valdef.plsql
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

create or replace procedure cfbam23.aud_valdef(
	argAuditClusterId numeric,
	argAuditUserId varchar,
	argAuditSessionId varchar,
	secClusterId numeric,
	secTenantId numeric,
	argClassCode varchar,
	argTenantId numeric,
	argId numeric,
	argAuditAction integer )
is
	unrecognizedClassCode exception;
begin
	case argClassCode
	when 'VALU' then
		insert into cfbam23.valdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				valu.revision,
				argAuditAction	
			from cfbam23.valdef valu
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TBLC' then
		insert into cfbam23.tblcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				TableId,
				DbName,
				DataId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				tblc.TableId,
				tblc.DbName,
				tblc.DataId,
				valu.revision,
				argAuditAction	
			from cfbam23.tblcol tblc
		inner join cfbam23.valdef valu on
			tblc.TenantId = valu.TenantId
			and tblc.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ATOM' then
		insert into cfbam23.atomdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				valu.revision,
				argAuditAction	
			from cfbam23.atomdef atom
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BLBD' then
		insert into cfbam23.blbdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				blbd.MaxLen,
				blbd.InitVal,
				blbd.DefVal,
				blbd.NullVal,
				blbd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.blbdef blbd
		inner join cfbam23.atomdef atom on
			blbd.TenantId = atom.TenantId
			and blbd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BLBC' then
		insert into cfbam23.blbcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				blbd.MaxLen,
				blbd.InitVal,
				blbd.DefVal,
				blbd.NullVal,
				blbd.UnknownVal,
				blbc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.blbcol blbc
		inner join cfbam23.blbdef blbd on
			blbc.TenantId = blbd.TenantId
			and blbc.Id = blbd.Id
		inner join cfbam23.atomdef atom on
			blbd.TenantId = atom.TenantId
			and blbd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BLBT' then
		insert into cfbam23.blbtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				blbd.MaxLen,
				blbd.InitVal,
				blbd.DefVal,
				blbd.NullVal,
				blbd.UnknownVal,
				blbt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.blbtyp blbt
		inner join cfbam23.blbdef blbd on
			blbt.TenantId = blbd.TenantId
			and blbt.Id = blbd.Id
		inner join cfbam23.atomdef atom on
			blbd.TenantId = atom.TenantId
			and blbd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BOLD' then
		insert into cfbam23.booldef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				FalseString,
				TrueString,
				NullString,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				bold.InitVal,
				bold.DefVal,
				bold.FalseString,
				bold.TrueString,
				bold.NullString,
				valu.revision,
				argAuditAction	
			from cfbam23.booldef bold
		inner join cfbam23.atomdef atom on
			bold.TenantId = atom.TenantId
			and bold.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BOLC' then
		insert into cfbam23.boolcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				FalseString,
				TrueString,
				NullString,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				bold.InitVal,
				bold.DefVal,
				bold.FalseString,
				bold.TrueString,
				bold.NullString,
				bolc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.boolcol bolc
		inner join cfbam23.booldef bold on
			bolc.TenantId = bold.TenantId
			and bolc.Id = bold.Id
		inner join cfbam23.atomdef atom on
			bold.TenantId = atom.TenantId
			and bold.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'BOLT' then
		insert into cfbam23.booltyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				FalseString,
				TrueString,
				NullString,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				bold.InitVal,
				bold.DefVal,
				bold.FalseString,
				bold.TrueString,
				bold.NullString,
				bolt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.booltyp bolt
		inner join cfbam23.booldef bold on
			bolt.TenantId = bold.TenantId
			and bolt.Id = bold.Id
		inner join cfbam23.atomdef atom on
			bold.TenantId = atom.TenantId
			and bold.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I16D' then
		insert into cfbam23.int16def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.int16def i16d
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I16C' then
		insert into cfbam23.int16col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				i16c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.int16col i16c
		inner join cfbam23.int16def i16d on
			i16c.TenantId = i16d.TenantId
			and i16c.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I16T' then
		insert into cfbam23.int16typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				i16t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.int16typ i16t
		inner join cfbam23.int16def i16d on
			i16t.TenantId = i16d.TenantId
			and i16t.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'IG16' then
		insert into cfbam23.idg16_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				DispenserTenantId,
				DispenserId,
				Slice,
				BlockSize,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				i16t.SchemaDefId,
				ig16.DispenserTenantId,
				ig16.DispenserId,
				ig16.Slice,
				ig16.BlockSize,
				valu.revision,
				argAuditAction	
			from cfbam23.idg16 ig16
		inner join cfbam23.int16typ i16t on
			ig16.TenantId = i16t.TenantId
			and ig16.Id = i16t.Id
		inner join cfbam23.int16def i16d on
			i16t.TenantId = i16d.TenantId
			and i16t.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ENMD' then
		insert into cfbam23.enumdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.enumdef enmd
		inner join cfbam23.int16def i16d on
			enmd.TenantId = i16d.TenantId
			and enmd.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ENMC' then
		insert into cfbam23.enumcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				enmc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.enumcol enmc
		inner join cfbam23.enumdef enmd on
			enmc.TenantId = enmd.TenantId
			and enmc.Id = enmd.Id
		inner join cfbam23.int16def i16d on
			enmd.TenantId = i16d.TenantId
			and enmd.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ENMT' then
		insert into cfbam23.enumtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i16d.InitVal,
				i16d.DefVal,
				i16d.MinVal,
				i16d.MaxVal,
				i16d.NullValue,
				i16d.UnknownVal,
				enmt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.enumtyp enmt
		inner join cfbam23.enumdef enmd on
			enmt.TenantId = enmd.TenantId
			and enmt.Id = enmd.Id
		inner join cfbam23.int16def i16d on
			enmd.TenantId = i16d.TenantId
			and enmd.Id = i16d.Id
		inner join cfbam23.atomdef atom on
			i16d.TenantId = atom.TenantId
			and i16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I32D' then
		insert into cfbam23.int32def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i32d.InitVal,
				i32d.DefVal,
				i32d.MinVal,
				i32d.MaxVal,
				i32d.NullValue,
				i32d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.int32def i32d
		inner join cfbam23.atomdef atom on
			i32d.TenantId = atom.TenantId
			and i32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I32C' then
		insert into cfbam23.int32col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i32d.InitVal,
				i32d.DefVal,
				i32d.MinVal,
				i32d.MaxVal,
				i32d.NullValue,
				i32d.UnknownVal,
				i32c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.int32col i32c
		inner join cfbam23.int32def i32d on
			i32c.TenantId = i32d.TenantId
			and i32c.Id = i32d.Id
		inner join cfbam23.atomdef atom on
			i32d.TenantId = atom.TenantId
			and i32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I32T' then
		insert into cfbam23.int32typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i32d.InitVal,
				i32d.DefVal,
				i32d.MinVal,
				i32d.MaxVal,
				i32d.NullValue,
				i32d.UnknownVal,
				i32t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.int32typ i32t
		inner join cfbam23.int32def i32d on
			i32t.TenantId = i32d.TenantId
			and i32t.Id = i32d.Id
		inner join cfbam23.atomdef atom on
			i32d.TenantId = atom.TenantId
			and i32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'IG32' then
		insert into cfbam23.idg32_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				DispenserTenantId,
				DispenserId,
				Slice,
				BlockSize,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i32d.InitVal,
				i32d.DefVal,
				i32d.MinVal,
				i32d.MaxVal,
				i32d.NullValue,
				i32d.UnknownVal,
				i32t.SchemaDefId,
				ig32.DispenserTenantId,
				ig32.DispenserId,
				ig32.Slice,
				ig32.BlockSize,
				valu.revision,
				argAuditAction	
			from cfbam23.idg32 ig32
		inner join cfbam23.int32typ i32t on
			ig32.TenantId = i32t.TenantId
			and ig32.Id = i32t.Id
		inner join cfbam23.int32def i32d on
			i32t.TenantId = i32d.TenantId
			and i32t.Id = i32d.Id
		inner join cfbam23.atomdef atom on
			i32d.TenantId = atom.TenantId
			and i32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I64D' then
		insert into cfbam23.int64def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i64d.InitVal,
				i64d.DefVal,
				i64d.MinVal,
				i64d.MaxVal,
				i64d.NullValue,
				i64d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.int64def i64d
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I64C' then
		insert into cfbam23.int64col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i64d.InitVal,
				i64d.DefVal,
				i64d.MinVal,
				i64d.MaxVal,
				i64d.NullValue,
				i64d.UnknownVal,
				i64c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.int64col i64c
		inner join cfbam23.int64def i64d on
			i64c.TenantId = i64d.TenantId
			and i64c.Id = i64d.Id
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'I64T' then
		insert into cfbam23.int64typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i64d.InitVal,
				i64d.DefVal,
				i64d.MinVal,
				i64d.MaxVal,
				i64d.NullValue,
				i64d.UnknownVal,
				i64t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.int64typ i64t
		inner join cfbam23.int64def i64d on
			i64t.TenantId = i64d.TenantId
			and i64t.Id = i64d.Id
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'IG64' then
		insert into cfbam23.idg64_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				DispenserTenantId,
				DispenserId,
				Slice,
				BlockSize,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				i64d.InitVal,
				i64d.DefVal,
				i64d.MinVal,
				i64d.MaxVal,
				i64d.NullValue,
				i64d.UnknownVal,
				i64t.SchemaDefId,
				ig64.DispenserTenantId,
				ig64.DispenserId,
				ig64.Slice,
				ig64.BlockSize,
				valu.revision,
				argAuditAction	
			from cfbam23.idg64 ig64
		inner join cfbam23.int64typ i64t on
			ig64.TenantId = i64t.TenantId
			and ig64.Id = i64t.Id
		inner join cfbam23.int64def i64d on
			i64t.TenantId = i64d.TenantId
			and i64t.Id = i64d.Id
		inner join cfbam23.atomdef atom on
			i64d.TenantId = atom.TenantId
			and i64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U16D' then
		insert into cfbam23.u16def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u16d.InitVal,
				u16d.DefVal,
				u16d.MinVal,
				u16d.MaxVal,
				u16d.NullValue,
				u16d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.u16def u16d
		inner join cfbam23.atomdef atom on
			u16d.TenantId = atom.TenantId
			and u16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U16C' then
		insert into cfbam23.uint16col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u16d.InitVal,
				u16d.DefVal,
				u16d.MinVal,
				u16d.MaxVal,
				u16d.NullValue,
				u16d.UnknownVal,
				u16c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint16col u16c
		inner join cfbam23.u16def u16d on
			u16c.TenantId = u16d.TenantId
			and u16c.Id = u16d.Id
		inner join cfbam23.atomdef atom on
			u16d.TenantId = atom.TenantId
			and u16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U16T' then
		insert into cfbam23.uint16typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u16d.InitVal,
				u16d.DefVal,
				u16d.MinVal,
				u16d.MaxVal,
				u16d.NullValue,
				u16d.UnknownVal,
				u16t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint16typ u16t
		inner join cfbam23.u16def u16d on
			u16t.TenantId = u16d.TenantId
			and u16t.Id = u16d.Id
		inner join cfbam23.atomdef atom on
			u16d.TenantId = atom.TenantId
			and u16d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U32D' then
		insert into cfbam23.u32def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u32d.InitVal,
				u32d.DefVal,
				u32d.MinVal,
				u32d.MaxVal,
				u32d.NullValue,
				u32d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.u32def u32d
		inner join cfbam23.atomdef atom on
			u32d.TenantId = atom.TenantId
			and u32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U32C' then
		insert into cfbam23.uint32col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u32d.InitVal,
				u32d.DefVal,
				u32d.MinVal,
				u32d.MaxVal,
				u32d.NullValue,
				u32d.UnknownVal,
				u32c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint32col u32c
		inner join cfbam23.u32def u32d on
			u32c.TenantId = u32d.TenantId
			and u32c.Id = u32d.Id
		inner join cfbam23.atomdef atom on
			u32d.TenantId = atom.TenantId
			and u32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U32T' then
		insert into cfbam23.uint32typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u32d.InitVal,
				u32d.DefVal,
				u32d.MinVal,
				u32d.MaxVal,
				u32d.NullValue,
				u32d.UnknownVal,
				u32t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint32typ u32t
		inner join cfbam23.u32def u32d on
			u32t.TenantId = u32d.TenantId
			and u32t.Id = u32d.Id
		inner join cfbam23.atomdef atom on
			u32d.TenantId = atom.TenantId
			and u32d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U64D' then
		insert into cfbam23.u64def_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u64d.InitVal,
				u64d.DefVal,
				u64d.MinVal,
				u64d.MaxVal,
				u64d.NullValue,
				u64d.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.u64def u64d
		inner join cfbam23.atomdef atom on
			u64d.TenantId = atom.TenantId
			and u64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U64C' then
		insert into cfbam23.uint64col_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u64d.InitVal,
				u64d.DefVal,
				u64d.MinVal,
				u64d.MaxVal,
				u64d.NullValue,
				u64d.UnknownVal,
				u64c.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint64col u64c
		inner join cfbam23.u64def u64d on
			u64c.TenantId = u64d.TenantId
			and u64c.Id = u64d.Id
		inner join cfbam23.atomdef atom on
			u64d.TenantId = atom.TenantId
			and u64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'U64T' then
		insert into cfbam23.uint64typ_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				u64d.InitVal,
				u64d.DefVal,
				u64d.MinVal,
				u64d.MaxVal,
				u64d.NullValue,
				u64d.UnknownVal,
				u64t.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.uint64typ u64t
		inner join cfbam23.u64def u64d on
			u64t.TenantId = u64d.TenantId
			and u64t.Id = u64d.Id
		inner join cfbam23.atomdef atom on
			u64d.TenantId = atom.TenantId
			and u64d.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'FLTD' then
		insert into cfbam23.fltdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				fltd.InitVal,
				fltd.DefVal,
				fltd.MinVal,
				fltd.MaxVal,
				fltd.NullValue,
				fltd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.fltdef fltd
		inner join cfbam23.atomdef atom on
			fltd.TenantId = atom.TenantId
			and fltd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'FLTC' then
		insert into cfbam23.fltcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				fltd.InitVal,
				fltd.DefVal,
				fltd.MinVal,
				fltd.MaxVal,
				fltd.NullValue,
				fltd.UnknownVal,
				fltc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.fltcol fltc
		inner join cfbam23.fltdef fltd on
			fltc.TenantId = fltd.TenantId
			and fltc.Id = fltd.Id
		inner join cfbam23.atomdef atom on
			fltd.TenantId = atom.TenantId
			and fltd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'FLTT' then
		insert into cfbam23.flttyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				fltd.InitVal,
				fltd.DefVal,
				fltd.MinVal,
				fltd.MaxVal,
				fltd.NullValue,
				fltd.UnknownVal,
				fltt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.flttyp fltt
		inner join cfbam23.fltdef fltd on
			fltt.TenantId = fltd.TenantId
			and fltt.Id = fltd.Id
		inner join cfbam23.atomdef atom on
			fltd.TenantId = atom.TenantId
			and fltd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DBLD' then
		insert into cfbam23.dbldef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dbld.InitVal,
				dbld.DefVal,
				dbld.MinVal,
				dbld.MaxVal,
				dbld.NullValue,
				dbld.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.dbldef dbld
		inner join cfbam23.atomdef atom on
			dbld.TenantId = atom.TenantId
			and dbld.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DBLC' then
		insert into cfbam23.dblcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dbld.InitVal,
				dbld.DefVal,
				dbld.MinVal,
				dbld.MaxVal,
				dbld.NullValue,
				dbld.UnknownVal,
				dblc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.dblcol dblc
		inner join cfbam23.dbldef dbld on
			dblc.TenantId = dbld.TenantId
			and dblc.Id = dbld.Id
		inner join cfbam23.atomdef atom on
			dbld.TenantId = atom.TenantId
			and dbld.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DBLT' then
		insert into cfbam23.dbltyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dbld.InitVal,
				dbld.DefVal,
				dbld.MinVal,
				dbld.MaxVal,
				dbld.NullValue,
				dbld.UnknownVal,
				dblt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.dbltyp dblt
		inner join cfbam23.dbldef dbld on
			dblt.TenantId = dbld.TenantId
			and dblt.Id = dbld.Id
		inner join cfbam23.atomdef atom on
			dbld.TenantId = atom.TenantId
			and dbld.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NUMD' then
		insert into cfbam23.numdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				Digits,
				Precis,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullVal,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				numd.Digits,
				numd.Precis,
				numd.InitVal,
				numd.DefVal,
				numd.MinVal,
				numd.MaxVal,
				numd.NullVal,
				numd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.numdef numd
		inner join cfbam23.atomdef atom on
			numd.TenantId = atom.TenantId
			and numd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NUMC' then
		insert into cfbam23.numcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				Digits,
				Precis,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullVal,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				numd.Digits,
				numd.Precis,
				numd.InitVal,
				numd.DefVal,
				numd.MinVal,
				numd.MaxVal,
				numd.NullVal,
				numd.UnknownVal,
				numc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.numcol numc
		inner join cfbam23.numdef numd on
			numc.TenantId = numd.TenantId
			and numc.Id = numd.Id
		inner join cfbam23.atomdef atom on
			numd.TenantId = atom.TenantId
			and numd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NUMT' then
		insert into cfbam23.numtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				Digits,
				Precis,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullVal,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				numd.Digits,
				numd.Precis,
				numd.InitVal,
				numd.DefVal,
				numd.MinVal,
				numd.MaxVal,
				numd.NullVal,
				numd.UnknownVal,
				numt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.numtyp numt
		inner join cfbam23.numdef numd on
			numt.TenantId = numd.TenantId
			and numt.Id = numd.Id
		inner join cfbam23.atomdef atom on
			numd.TenantId = atom.TenantId
			and numd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'STRD' then
		insert into cfbam23.strdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				strd.MaxLen,
				strd.ShowLines,
				strd.InitVal,
				strd.DefVal,
				strd.NullValue,
				strd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.strdef strd
		inner join cfbam23.atomdef atom on
			strd.TenantId = atom.TenantId
			and strd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'STRC' then
		insert into cfbam23.strcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				strd.MaxLen,
				strd.ShowLines,
				strd.InitVal,
				strd.DefVal,
				strd.NullValue,
				strd.UnknownVal,
				strc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.strcol strc
		inner join cfbam23.strdef strd on
			strc.TenantId = strd.TenantId
			and strc.Id = strd.Id
		inner join cfbam23.atomdef atom on
			strd.TenantId = atom.TenantId
			and strd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'STRT' then
		insert into cfbam23.strtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				strd.MaxLen,
				strd.ShowLines,
				strd.InitVal,
				strd.DefVal,
				strd.NullValue,
				strd.UnknownVal,
				strt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.strtyp strt
		inner join cfbam23.strdef strd on
			strt.TenantId = strd.TenantId
			and strt.Id = strd.Id
		inner join cfbam23.atomdef atom on
			strd.TenantId = atom.TenantId
			and strd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TXTD' then
		insert into cfbam23.txtdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				txtd.MaxLen,
				txtd.ShowLines,
				txtd.InitVal,
				txtd.DefVal,
				txtd.NullValue,
				txtd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.txtdef txtd
		inner join cfbam23.atomdef atom on
			txtd.TenantId = atom.TenantId
			and txtd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TXTC' then
		insert into cfbam23.txtcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				txtd.MaxLen,
				txtd.ShowLines,
				txtd.InitVal,
				txtd.DefVal,
				txtd.NullValue,
				txtd.UnknownVal,
				txtc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.txtcol txtc
		inner join cfbam23.txtdef txtd on
			txtc.TenantId = txtd.TenantId
			and txtc.Id = txtd.Id
		inner join cfbam23.atomdef atom on
			txtd.TenantId = atom.TenantId
			and txtd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TXTT' then
		insert into cfbam23.txttyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				ShowLines,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				txtd.MaxLen,
				txtd.ShowLines,
				txtd.InitVal,
				txtd.DefVal,
				txtd.NullValue,
				txtd.UnknownVal,
				txtt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.txttyp txtt
		inner join cfbam23.txtdef txtd on
			txtt.TenantId = txtd.TenantId
			and txtt.Id = txtd.Id
		inner join cfbam23.atomdef atom on
			txtd.TenantId = atom.TenantId
			and txtd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTKD' then
		insert into cfbam23.nmtkndef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntkd.MaxLen,
				ntkd.InitVal,
				ntkd.DefVal,
				ntkd.NullValue,
				ntkd.UnknownVal,
				ntkd.ShowLines,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtkndef ntkd
		inner join cfbam23.atomdef atom on
			ntkd.TenantId = atom.TenantId
			and ntkd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTKC' then
		insert into cfbam23.nmtkncol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntkd.MaxLen,
				ntkd.InitVal,
				ntkd.DefVal,
				ntkd.NullValue,
				ntkd.UnknownVal,
				ntkd.ShowLines,
				ntkc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtkncol ntkc
		inner join cfbam23.nmtkndef ntkd on
			ntkc.TenantId = ntkd.TenantId
			and ntkc.Id = ntkd.Id
		inner join cfbam23.atomdef atom on
			ntkd.TenantId = atom.TenantId
			and ntkd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTKT' then
		insert into cfbam23.nmtkntyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntkd.MaxLen,
				ntkd.InitVal,
				ntkd.DefVal,
				ntkd.NullValue,
				ntkd.UnknownVal,
				ntkd.ShowLines,
				ntkt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtkntyp ntkt
		inner join cfbam23.nmtkndef ntkd on
			ntkt.TenantId = ntkd.TenantId
			and ntkt.Id = ntkd.Id
		inner join cfbam23.atomdef atom on
			ntkd.TenantId = atom.TenantId
			and ntkd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTSD' then
		insert into cfbam23.nmtknsdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntsd.MaxLen,
				ntsd.InitVal,
				ntsd.DefVal,
				ntsd.NullValue,
				ntsd.UnknownVal,
				ntsd.ShowLines,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtknsdef ntsd
		inner join cfbam23.atomdef atom on
			ntsd.TenantId = atom.TenantId
			and ntsd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTSC' then
		insert into cfbam23.nmtknscol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntsd.MaxLen,
				ntsd.InitVal,
				ntsd.DefVal,
				ntsd.NullValue,
				ntsd.UnknownVal,
				ntsd.ShowLines,
				ntsc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtknscol ntsc
		inner join cfbam23.nmtknsdef ntsd on
			ntsc.TenantId = ntsd.TenantId
			and ntsc.Id = ntsd.Id
		inner join cfbam23.atomdef atom on
			ntsd.TenantId = atom.TenantId
			and ntsd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'NTST' then
		insert into cfbam23.nmtknstyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				ntsd.MaxLen,
				ntsd.InitVal,
				ntsd.DefVal,
				ntsd.NullValue,
				ntsd.UnknownVal,
				ntsd.ShowLines,
				ntst.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.nmtknstyp ntst
		inner join cfbam23.nmtknsdef ntsd on
			ntst.TenantId = ntsd.TenantId
			and ntst.Id = ntsd.Id
		inner join cfbam23.atomdef atom on
			ntsd.TenantId = atom.TenantId
			and ntsd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TKND' then
		insert into cfbam23.tkndef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tknd.MaxLen,
				tknd.InitVal,
				tknd.DefVal,
				tknd.NullValue,
				tknd.UnknownVal,
				tknd.ShowLines,
				valu.revision,
				argAuditAction	
			from cfbam23.tkndef tknd
		inner join cfbam23.atomdef atom on
			tknd.TenantId = atom.TenantId
			and tknd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TKNC' then
		insert into cfbam23.tkncol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tknd.MaxLen,
				tknd.InitVal,
				tknd.DefVal,
				tknd.NullValue,
				tknd.UnknownVal,
				tknd.ShowLines,
				tknc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.tkncol tknc
		inner join cfbam23.tkndef tknd on
			tknc.TenantId = tknd.TenantId
			and tknc.Id = tknd.Id
		inner join cfbam23.atomdef atom on
			tknd.TenantId = atom.TenantId
			and tknd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TKNT' then
		insert into cfbam23.tkntyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				MaxLen,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				ShowLines,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tknd.MaxLen,
				tknd.InitVal,
				tknd.DefVal,
				tknd.NullValue,
				tknd.UnknownVal,
				tknd.ShowLines,
				tknt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.tkntyp tknt
		inner join cfbam23.tkndef tknd on
			tknt.TenantId = tknd.TenantId
			and tknt.Id = tknd.Id
		inner join cfbam23.atomdef atom on
			tknd.TenantId = atom.TenantId
			and tknd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DATD' then
		insert into cfbam23.dtdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				datd.InitVal,
				datd.DefVal,
				datd.MinVal,
				datd.MaxVal,
				datd.NullValue,
				datd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.dtdef datd
		inner join cfbam23.atomdef atom on
			datd.TenantId = atom.TenantId
			and datd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DATC' then
		insert into cfbam23.dtcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				datd.InitVal,
				datd.DefVal,
				datd.MinVal,
				datd.MaxVal,
				datd.NullValue,
				datd.UnknownVal,
				datc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.dtcol datc
		inner join cfbam23.dtdef datd on
			datc.TenantId = datd.TenantId
			and datc.Id = datd.Id
		inner join cfbam23.atomdef atom on
			datd.TenantId = atom.TenantId
			and datd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DATT' then
		insert into cfbam23.dttyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				datd.InitVal,
				datd.DefVal,
				datd.MinVal,
				datd.MaxVal,
				datd.NullValue,
				datd.UnknownVal,
				datt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.dttyp datt
		inner join cfbam23.dtdef datd on
			datt.TenantId = datd.TenantId
			and datt.Id = datd.Id
		inner join cfbam23.atomdef atom on
			datd.TenantId = atom.TenantId
			and datd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TIMD' then
		insert into cfbam23.tmdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				timd.InitVal,
				timd.DefVal,
				timd.NullValue,
				timd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.tmdef timd
		inner join cfbam23.atomdef atom on
			timd.TenantId = atom.TenantId
			and timd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TIMC' then
		insert into cfbam23.tmcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				timd.InitVal,
				timd.DefVal,
				timd.NullValue,
				timd.UnknownVal,
				timc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.tmcol timc
		inner join cfbam23.tmdef timd on
			timc.TenantId = timd.TenantId
			and timc.Id = timd.Id
		inner join cfbam23.atomdef atom on
			timd.TenantId = atom.TenantId
			and timd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TIMT' then
		insert into cfbam23.tmtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				timd.InitVal,
				timd.DefVal,
				timd.NullValue,
				timd.UnknownVal,
				timt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.tmtyp timt
		inner join cfbam23.tmdef timd on
			timt.TenantId = timd.TenantId
			and timt.Id = timd.Id
		inner join cfbam23.atomdef atom on
			timd.TenantId = atom.TenantId
			and timd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TSPD' then
		insert into cfbam23.tsdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tspd.InitVal,
				tspd.DefVal,
				tspd.MinVal,
				tspd.MaxVal,
				tspd.NullValue,
				tspd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.tsdef tspd
		inner join cfbam23.atomdef atom on
			tspd.TenantId = atom.TenantId
			and tspd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TSPC' then
		insert into cfbam23.tscol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tspd.InitVal,
				tspd.DefVal,
				tspd.MinVal,
				tspd.MaxVal,
				tspd.NullValue,
				tspd.UnknownVal,
				tspc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.tscol tspc
		inner join cfbam23.tsdef tspd on
			tspc.TenantId = tspd.TenantId
			and tspc.Id = tspd.Id
		inner join cfbam23.atomdef atom on
			tspd.TenantId = atom.TenantId
			and tspd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TSPT' then
		insert into cfbam23.tstyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tspd.InitVal,
				tspd.DefVal,
				tspd.MinVal,
				tspd.MaxVal,
				tspd.NullValue,
				tspd.UnknownVal,
				tspt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.tstyp tspt
		inner join cfbam23.tsdef tspd on
			tspt.TenantId = tspd.TenantId
			and tspt.Id = tspd.Id
		inner join cfbam23.atomdef atom on
			tspd.TenantId = atom.TenantId
			and tspd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DAZD' then
		insert into cfbam23.dzdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dazd.InitVal,
				dazd.DefVal,
				dazd.MinVal,
				dazd.MaxVal,
				dazd.NullValue,
				dazd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.dzdef dazd
		inner join cfbam23.atomdef atom on
			dazd.TenantId = atom.TenantId
			and dazd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DAZC' then
		insert into cfbam23.dzcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dazd.InitVal,
				dazd.DefVal,
				dazd.MinVal,
				dazd.MaxVal,
				dazd.NullValue,
				dazd.UnknownVal,
				dazc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.dzcol dazc
		inner join cfbam23.dzdef dazd on
			dazc.TenantId = dazd.TenantId
			and dazc.Id = dazd.Id
		inner join cfbam23.atomdef atom on
			dazd.TenantId = atom.TenantId
			and dazd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'DAZT' then
		insert into cfbam23.dztyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				dazd.InitVal,
				dazd.DefVal,
				dazd.MinVal,
				dazd.MaxVal,
				dazd.NullValue,
				dazd.UnknownVal,
				dazt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.dztyp dazt
		inner join cfbam23.dzdef dazd on
			dazt.TenantId = dazd.TenantId
			and dazt.Id = dazd.Id
		inner join cfbam23.atomdef atom on
			dazd.TenantId = atom.TenantId
			and dazd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TMZD' then
		insert into cfbam23.tmzdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tmzd.InitVal,
				tmzd.DefVal,
				tmzd.NullValue,
				tmzd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.tmzdef tmzd
		inner join cfbam23.atomdef atom on
			tmzd.TenantId = atom.TenantId
			and tmzd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TMZC' then
		insert into cfbam23.tmzcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tmzd.InitVal,
				tmzd.DefVal,
				tmzd.NullValue,
				tmzd.UnknownVal,
				tmzc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.tmzcol tmzc
		inner join cfbam23.tmzdef tmzd on
			tmzc.TenantId = tmzd.TenantId
			and tmzc.Id = tmzd.Id
		inner join cfbam23.atomdef atom on
			tmzd.TenantId = atom.TenantId
			and tmzd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'TMZT' then
		insert into cfbam23.tmztyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				tmzd.InitVal,
				tmzd.DefVal,
				tmzd.NullValue,
				tmzd.UnknownVal,
				tmzt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.tmztyp tmzt
		inner join cfbam23.tmzdef tmzd on
			tmzt.TenantId = tmzd.TenantId
			and tmzt.Id = tmzd.Id
		inner join cfbam23.atomdef atom on
			tmzd.TenantId = atom.TenantId
			and tmzd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ZSTD' then
		insert into cfbam23.zsdef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				zstd.InitVal,
				zstd.DefVal,
				zstd.MinVal,
				zstd.MaxVal,
				zstd.NullValue,
				zstd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.zsdef zstd
		inner join cfbam23.atomdef atom on
			zstd.TenantId = atom.TenantId
			and zstd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ZSTC' then
		insert into cfbam23.zscol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				zstd.InitVal,
				zstd.DefVal,
				zstd.MinVal,
				zstd.MaxVal,
				zstd.NullValue,
				zstd.UnknownVal,
				zstc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.zscol zstc
		inner join cfbam23.zsdef zstd on
			zstc.TenantId = zstd.TenantId
			and zstc.Id = zstd.Id
		inner join cfbam23.atomdef atom on
			zstd.TenantId = atom.TenantId
			and zstd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'ZSTT' then
		insert into cfbam23.zstyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				MinVal,
				MaxVal,
				NullValue,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				zstd.InitVal,
				zstd.DefVal,
				zstd.MinVal,
				zstd.MaxVal,
				zstd.NullValue,
				zstd.UnknownVal,
				zstt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.zstyp zstt
		inner join cfbam23.zsdef zstd on
			zstt.TenantId = zstd.TenantId
			and zstt.Id = zstd.Id
		inner join cfbam23.atomdef atom on
			zstd.TenantId = atom.TenantId
			and zstd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'UIDD' then
		insert into cfbam23.uuiddef_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				uidd.InitVal,
				uidd.DefVal,
				uidd.NullVal,
				uidd.UnknownVal,
				valu.revision,
				argAuditAction	
			from cfbam23.uuiddef uidd
		inner join cfbam23.atomdef atom on
			uidd.TenantId = atom.TenantId
			and uidd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'UIDC' then
		insert into cfbam23.uuidcol_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				TableId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				uidd.InitVal,
				uidd.DefVal,
				uidd.NullVal,
				uidd.UnknownVal,
				uidc.TableId,
				valu.revision,
				argAuditAction	
			from cfbam23.uuidcol uidc
		inner join cfbam23.uuiddef uidd on
			uidc.TenantId = uidd.TenantId
			and uidc.Id = uidd.Id
		inner join cfbam23.atomdef atom on
			uidd.TenantId = atom.TenantId
			and uidd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'UIDT' then
		insert into cfbam23.uuidtyp_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				SchemaDefId,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				uidd.InitVal,
				uidd.DefVal,
				uidd.NullVal,
				uidd.UnknownVal,
				uidt.SchemaDefId,
				valu.revision,
				argAuditAction	
			from cfbam23.uuidtyp uidt
		inner join cfbam23.uuiddef uidd on
			uidt.TenantId = uidd.TenantId
			and uidt.Id = uidd.Id
		inner join cfbam23.atomdef atom on
			uidd.TenantId = atom.TenantId
			and uidd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	when 'IGUU' then
		insert into cfbam23.idguuid_h (
				TenantId,
				Id,
				classcode,
				auditclusterid,
				auditsessionid,
				auditstamp,
				ScopeId,
				defschtentid,
				defschid,
				Name,
				short_name,
				Label,
				short_descr,
				descr,
				IsNullable,
				GenerateId,
				DataScopeId,
				VASecId,
				EASecId,
				VAFId,
				EAFId,
				PrevTenantId,
				PrevId,
				NextTenantId,
				NextId,
				dflt_vis,
				DbName,
				InitVal,
				DefVal,
				NullVal,
				UnknownVal,
				SchemaDefId,
				DispenserTenantId,
				DispenserId,
				Slice,
				BlockSize,
				revision,
				auditaction )
			select
				valu.TenantId,
				valu.Id,
				valu.classcode,
				argAuditClusterId,
				argAuditSessionId,
				sysdate,
				valu.ScopeId,
				valu.defschtentid,
				valu.defschid,
				valu.Name,
				valu.short_name,
				valu.Label,
				valu.short_descr,
				valu.descr,
				valu.IsNullable,
				valu.GenerateId,
				valu.DataScopeId,
				valu.VASecId,
				valu.EASecId,
				valu.VAFId,
				valu.EAFId,
				valu.PrevTenantId,
				valu.PrevId,
				valu.NextTenantId,
				valu.NextId,
				valu.dflt_vis,
				atom.DbName,
				uidd.InitVal,
				uidd.DefVal,
				uidd.NullVal,
				uidd.UnknownVal,
				uidt.SchemaDefId,
				iguu.DispenserTenantId,
				iguu.DispenserId,
				iguu.Slice,
				iguu.BlockSize,
				valu.revision,
				argAuditAction	
			from cfbam23.idguuid iguu
		inner join cfbam23.uuidtyp uidt on
			iguu.TenantId = uidt.TenantId
			and iguu.Id = uidt.Id
		inner join cfbam23.uuiddef uidd on
			uidt.TenantId = uidd.TenantId
			and uidt.Id = uidd.Id
		inner join cfbam23.atomdef atom on
			uidd.TenantId = atom.TenantId
			and uidd.Id = atom.Id
		inner join cfbam23.valdef valu on
			atom.TenantId = valu.TenantId
			and atom.Id = valu.Id
			where
				valu.TenantId = argTenantId
				and valu.Id = argId;
	else
		raise unrecognizedClassCode;
	end case;

end aud_valdef;
/

show errors procedure cfbam23.aud_valdef;
/
