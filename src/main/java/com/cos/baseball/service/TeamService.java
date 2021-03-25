package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {

	private final TeamRepository teamRepository;
	
	@Transactional(readOnly = true)
	public List<Team> 팀리스트() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public Team 팀등록(Team team) {
		return teamRepository.save(team);
	}
	@Transactional
	public void 팀삭제(int id) {
		teamRepository.deleteById(id);
	}
}
