package com.cos.baseball.domain.player.dto;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.team.Team;

import lombok.Data;

@Data
public class PlayerPostReqDto {

	private String name;
	private String position;
	private int teamId;
	
	public Player toEntity() {
		return Player.builder()
				.name(name)
				.position(position)
				.team(Team.builder().id(teamId).build())
				.build();
	}
}
