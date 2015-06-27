--
--	@(#) dbcreate/cfbam/pgsql/crsp_delete_valdef_by_vaccsecidx.pgsql
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

create or replace function cfbam23.sp_delete_valdef_by_vaccsecidx(
	argAuditClusterId bigint,
	argAuditUserId varchar(36),
	argAuditSessionId varchar(36),
	secClusterId bigint,
	secTenantId bigint,
	argViewAccessSecurityId smallint )
returns boolean as $$
declare
	RowsAffected integer;
	cur record;
	subret boolean;
	classCode varchar(4);
begin
	select cfbam23.sp_is_system_user( argAuditUserId ) into subret;
	if( subret )
	then
		for cur in
			select
					valu.classcode,
						valu.tenantid as tenantid,
						valu.id as id,
					valu.revision as revision
			from cfbam23.valdef as valu
			where
					( ( ( argViewAccessSecurityId is null ) and ( valu.vasecid is null ) )
				or ( ( argViewAccessSecurityId is not null ) and ( valu.vasecid = argViewAccessSecurityId ) ) )
		loop
				select cur.classcode into classCode;
				case classCode
				when 'VALU' then
					select cfbam23.sp_delete_valdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TBLC' then
					select cfbam23.sp_delete_tblcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ATOM' then
					select cfbam23.sp_delete_atomdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBD' then
					select cfbam23.sp_delete_blbdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBC' then
					select cfbam23.sp_delete_blbcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBT' then
					select cfbam23.sp_delete_blbtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLD' then
					select cfbam23.sp_delete_booldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLC' then
					select cfbam23.sp_delete_boolcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLT' then
					select cfbam23.sp_delete_booltyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16D' then
					select cfbam23.sp_delete_int16def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16C' then
					select cfbam23.sp_delete_int16col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16T' then
					select cfbam23.sp_delete_int16typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG16' then
					select cfbam23.sp_delete_idg16( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMD' then
					select cfbam23.sp_delete_enumdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMC' then
					select cfbam23.sp_delete_enumcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMT' then
					select cfbam23.sp_delete_enumtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32D' then
					select cfbam23.sp_delete_int32def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32C' then
					select cfbam23.sp_delete_int32col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32T' then
					select cfbam23.sp_delete_int32typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG32' then
					select cfbam23.sp_delete_idg32( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64D' then
					select cfbam23.sp_delete_int64def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64C' then
					select cfbam23.sp_delete_int64col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64T' then
					select cfbam23.sp_delete_int64typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG64' then
					select cfbam23.sp_delete_idg64( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16D' then
					select cfbam23.sp_delete_u16def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16C' then
					select cfbam23.sp_delete_uint16col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16T' then
					select cfbam23.sp_delete_uint16typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32D' then
					select cfbam23.sp_delete_u32def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32C' then
					select cfbam23.sp_delete_uint32col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32T' then
					select cfbam23.sp_delete_uint32typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64D' then
					select cfbam23.sp_delete_u64def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64C' then
					select cfbam23.sp_delete_uint64col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64T' then
					select cfbam23.sp_delete_uint64typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTD' then
					select cfbam23.sp_delete_fltdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTC' then
					select cfbam23.sp_delete_fltcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTT' then
					select cfbam23.sp_delete_flttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLD' then
					select cfbam23.sp_delete_dbldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLC' then
					select cfbam23.sp_delete_dblcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLT' then
					select cfbam23.sp_delete_dbltyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMD' then
					select cfbam23.sp_delete_numdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMC' then
					select cfbam23.sp_delete_numcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMT' then
					select cfbam23.sp_delete_numtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRD' then
					select cfbam23.sp_delete_strdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRC' then
					select cfbam23.sp_delete_strcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRT' then
					select cfbam23.sp_delete_strtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTD' then
					select cfbam23.sp_delete_txtdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTC' then
					select cfbam23.sp_delete_txtcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTT' then
					select cfbam23.sp_delete_txttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKD' then
					select cfbam23.sp_delete_nmtkndef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKC' then
					select cfbam23.sp_delete_nmtkncol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKT' then
					select cfbam23.sp_delete_nmtkntyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTSD' then
					select cfbam23.sp_delete_nmtknsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTSC' then
					select cfbam23.sp_delete_nmtknscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTST' then
					select cfbam23.sp_delete_nmtknstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKND' then
					select cfbam23.sp_delete_tkndef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKNC' then
					select cfbam23.sp_delete_tkncol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKNT' then
					select cfbam23.sp_delete_tkntyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATD' then
					select cfbam23.sp_delete_dtdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATC' then
					select cfbam23.sp_delete_dtcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATT' then
					select cfbam23.sp_delete_dttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMD' then
					select cfbam23.sp_delete_tmdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMC' then
					select cfbam23.sp_delete_tmcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMT' then
					select cfbam23.sp_delete_tmtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPD' then
					select cfbam23.sp_delete_tsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPC' then
					select cfbam23.sp_delete_tscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPT' then
					select cfbam23.sp_delete_tstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZD' then
					select cfbam23.sp_delete_dzdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZC' then
					select cfbam23.sp_delete_dzcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZT' then
					select cfbam23.sp_delete_dztyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZD' then
					select cfbam23.sp_delete_tmzdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZC' then
					select cfbam23.sp_delete_tmzcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZT' then
					select cfbam23.sp_delete_tmztyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTD' then
					select cfbam23.sp_delete_zsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTC' then
					select cfbam23.sp_delete_zscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTT' then
					select cfbam23.sp_delete_zstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDD' then
					select cfbam23.sp_delete_uuiddef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDC' then
					select cfbam23.sp_delete_uuidcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDT' then
					select cfbam23.sp_delete_uuidtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IGUU' then
					select cfbam23.sp_delete_idguuid( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				else
					raise exception 'sp_delete_valdef_by_vaccsecidx() Unrecognized cur.classcode value';
				end case;
		end loop;
	else
		for cur in
			select
					valu.classcode,
						valu.tenantid as tenantid,
						valu.id as id,
					valu.revision as revision
			from cfbam23.valdef as valu
			where
					( ( ( argViewAccessSecurityId is null ) and ( valu.vasecid is null ) )
				or ( ( argViewAccessSecurityId is not null ) and ( valu.vasecid = argViewAccessSecurityId ) ) )
					and valu.TenantId = secTenantId
		loop
				select cur.classcode into classCode;
				case classCode
				when 'VALU' then
					select cfbam23.sp_delete_valdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TBLC' then
					select cfbam23.sp_delete_tblcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ATOM' then
					select cfbam23.sp_delete_atomdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBD' then
					select cfbam23.sp_delete_blbdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBC' then
					select cfbam23.sp_delete_blbcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BLBT' then
					select cfbam23.sp_delete_blbtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLD' then
					select cfbam23.sp_delete_booldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLC' then
					select cfbam23.sp_delete_boolcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'BOLT' then
					select cfbam23.sp_delete_booltyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16D' then
					select cfbam23.sp_delete_int16def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16C' then
					select cfbam23.sp_delete_int16col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I16T' then
					select cfbam23.sp_delete_int16typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG16' then
					select cfbam23.sp_delete_idg16( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMD' then
					select cfbam23.sp_delete_enumdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMC' then
					select cfbam23.sp_delete_enumcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ENMT' then
					select cfbam23.sp_delete_enumtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32D' then
					select cfbam23.sp_delete_int32def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32C' then
					select cfbam23.sp_delete_int32col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I32T' then
					select cfbam23.sp_delete_int32typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG32' then
					select cfbam23.sp_delete_idg32( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64D' then
					select cfbam23.sp_delete_int64def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64C' then
					select cfbam23.sp_delete_int64col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'I64T' then
					select cfbam23.sp_delete_int64typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IG64' then
					select cfbam23.sp_delete_idg64( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16D' then
					select cfbam23.sp_delete_u16def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16C' then
					select cfbam23.sp_delete_uint16col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U16T' then
					select cfbam23.sp_delete_uint16typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32D' then
					select cfbam23.sp_delete_u32def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32C' then
					select cfbam23.sp_delete_uint32col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U32T' then
					select cfbam23.sp_delete_uint32typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64D' then
					select cfbam23.sp_delete_u64def( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64C' then
					select cfbam23.sp_delete_uint64col( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'U64T' then
					select cfbam23.sp_delete_uint64typ( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTD' then
					select cfbam23.sp_delete_fltdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTC' then
					select cfbam23.sp_delete_fltcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'FLTT' then
					select cfbam23.sp_delete_flttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLD' then
					select cfbam23.sp_delete_dbldef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLC' then
					select cfbam23.sp_delete_dblcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DBLT' then
					select cfbam23.sp_delete_dbltyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMD' then
					select cfbam23.sp_delete_numdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMC' then
					select cfbam23.sp_delete_numcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NUMT' then
					select cfbam23.sp_delete_numtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRD' then
					select cfbam23.sp_delete_strdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRC' then
					select cfbam23.sp_delete_strcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'STRT' then
					select cfbam23.sp_delete_strtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTD' then
					select cfbam23.sp_delete_txtdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTC' then
					select cfbam23.sp_delete_txtcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TXTT' then
					select cfbam23.sp_delete_txttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKD' then
					select cfbam23.sp_delete_nmtkndef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKC' then
					select cfbam23.sp_delete_nmtkncol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTKT' then
					select cfbam23.sp_delete_nmtkntyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTSD' then
					select cfbam23.sp_delete_nmtknsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTSC' then
					select cfbam23.sp_delete_nmtknscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'NTST' then
					select cfbam23.sp_delete_nmtknstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKND' then
					select cfbam23.sp_delete_tkndef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKNC' then
					select cfbam23.sp_delete_tkncol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TKNT' then
					select cfbam23.sp_delete_tkntyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATD' then
					select cfbam23.sp_delete_dtdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATC' then
					select cfbam23.sp_delete_dtcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DATT' then
					select cfbam23.sp_delete_dttyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMD' then
					select cfbam23.sp_delete_tmdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMC' then
					select cfbam23.sp_delete_tmcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TIMT' then
					select cfbam23.sp_delete_tmtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPD' then
					select cfbam23.sp_delete_tsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPC' then
					select cfbam23.sp_delete_tscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TSPT' then
					select cfbam23.sp_delete_tstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZD' then
					select cfbam23.sp_delete_dzdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZC' then
					select cfbam23.sp_delete_dzcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'DAZT' then
					select cfbam23.sp_delete_dztyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZD' then
					select cfbam23.sp_delete_tmzdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZC' then
					select cfbam23.sp_delete_tmzcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'TMZT' then
					select cfbam23.sp_delete_tmztyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTD' then
					select cfbam23.sp_delete_zsdef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTC' then
					select cfbam23.sp_delete_zscol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'ZSTT' then
					select cfbam23.sp_delete_zstyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDD' then
					select cfbam23.sp_delete_uuiddef( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDC' then
					select cfbam23.sp_delete_uuidcol( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'UIDT' then
					select cfbam23.sp_delete_uuidtyp( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				when 'IGUU' then
					select cfbam23.sp_delete_idguuid( argAuditClusterId,
							argAuditUserId,
							argAuditSessionId,
							secClusterId,
							secTenantId,
							cur.tenantid,
							cur.id,
							cur.revision )
						into subret;
				else
					raise exception 'sp_delete_valdef_by_vaccsecidx() Unrecognized cur.classcode value';
				end case;
		end loop;
	end if;
	return true;
end;
$$ language plpgsql;
