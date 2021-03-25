package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.player.dto.PlayerPositionReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final EntityManager em;
	
	@Transactional
	public Player 선수등록(Player player) {
		return playerRepository.save(player);
	}
	
	@Transactional
	public List<Player> 선수리스트() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 선수삭제(int id) {
		playerRepository.deleteById(id);
	}
	
	@Transactional
	public List<PlayerPositionReqDto> 포지션별선수리스트() {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.position as 'position', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 1 THEN p.name ELSE null END)) as 'lotte', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 2 THEN p.name ELSE null END)) as 'nc', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 3 THEN p.name ELSE null END)) as 'samsung' ");
		sb.append("from player p GROUP BY p.position");
		System.out.println("sb : " + sb.toString());
		
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		Query query = em.createNativeQuery(sb.toString());
		List<PlayerPositionReqDto> playerPositionReqDto = jpaResultMapper.list(query, PlayerPositionReqDto.class);
		return playerPositionReqDto;
	}
}
