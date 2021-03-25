package com.cos.baseball.domain.team.dto;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.where.WhereBase;

import lombok.Data;

@Data
public class TeamPostReqDto {

	private String teamName;
	private int whereBaseId;
	
	public Team toEntity() {
		return Team.builder()
				.teamName(teamName)
				.whereBase(WhereBase.builder().id(whereBaseId).build())
				.build();
	}
}
