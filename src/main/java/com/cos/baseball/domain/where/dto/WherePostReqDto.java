package com.cos.baseball.domain.where.dto;

import com.cos.baseball.domain.where.WhereBase;

import lombok.Data;

@Data
public class WherePostReqDto {

	private String whereName;
	
	public WhereBase toEntity() {
		return WhereBase.builder()
				.whereName(whereName)
				.build();
	}
}
