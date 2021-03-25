package com.cos.baseball.domain.player.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPositionReqDto {

	private String position;
	private String lotte;
	private String nc;
	private String samsung;
}
