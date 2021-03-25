package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.dto.TeamPostReqDto;
import com.cos.baseball.domain.where.WhereBase;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.service.WhereBaseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	private final WhereBaseService whereBaseService;
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody String 팀삭제(@PathVariable int id) {
		teamService.팀삭제(id);
		return "delete";
	}
	
	@GetMapping("/team")
	public String 팀리스트(Model model) {
		List<Team> teamEntity = teamService.팀리스트();
		model.addAttribute("teams", teamEntity);
		return "board/teamlist";
	}
	
	@GetMapping("/post/team")
	public String 팀등록폼(Model model) {
		List<WhereBase> whereBaseEntity = whereBaseService.구장리스트();
		model.addAttribute("teams", whereBaseEntity);
		return "post/teampost";
	}
	
	@PostMapping("/team")
	public String 팀등록(String teamName, int whereBaseId) {
		TeamPostReqDto teamPostReqDto = new TeamPostReqDto();
		teamPostReqDto.setTeamName(teamName);
		teamPostReqDto.setWhereBaseId(whereBaseId);
		teamService.팀등록(teamPostReqDto.toEntity());
		return "redirect:/team";
	}
	
}
