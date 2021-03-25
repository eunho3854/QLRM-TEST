package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.dto.PlayerPositionReqDto;
import com.cos.baseball.domain.player.dto.PlayerPostReqDto;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/player/position")
	public String 포지션별선수리스트(Model model) {
		List<PlayerPositionReqDto> players = playerService.포지션별선수리스트();
		model.addAttribute("players", players);
		return "board/playerpositionlist";
	}
	
	@GetMapping("/post/player")
	public String 선수등록폼(Model model) {
		List<Team> teamEntity = teamService.팀리스트();
		model.addAttribute("team", teamEntity);
		return "post/playerSaveForm";
	}
	
	@PostMapping("/player")
	public String 선수등록(String name,String position, int teamId) {
		PlayerPostReqDto playerPostReqDto = new PlayerPostReqDto();
		
		playerPostReqDto.setName(name);
		playerPostReqDto.setPosition(position);
		playerPostReqDto.setTeamId(teamId);
		playerService.선수등록(playerPostReqDto.toEntity());
		return "redirect:/player";
		
	}
	
	@GetMapping("/player")
	public String 선수리스트(Model model) {
		List<Player> players = playerService.선수리스트();
		model.addAttribute("players", players);
		
		return "board/playerlist";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody String 선수삭제(@PathVariable int id) {
		playerService.선수삭제(id);
		return "delete";
	}
}
