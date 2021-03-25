package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.where.WhereBase;
import com.cos.baseball.domain.where.dto.WherePostReqDto;
import com.cos.baseball.service.WhereBaseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WhereBaseController {

private final WhereBaseService whereBaseService;
	
	@GetMapping("/wherebase")
	public String 구장리스트(Model model) {
		List<WhereBase> whereBaseEntity = whereBaseService.구장리스트();
		model.addAttribute("whereBases", whereBaseEntity);
		return "board/wherebaselist";
	}
	
	@GetMapping("/post/wherebase")
	public String 구장등록폼() {
		return "post/wherebasepost";
	}
	
	@PostMapping("/wherebase")
	public String 구장등록(String whereName) {
		WherePostReqDto wherePostReqDto = new WherePostReqDto();
		wherePostReqDto.setWhereName(whereName);
		whereBaseService.구장등록(wherePostReqDto.toEntity());
		return "redirect:/wherebase";
	}
	
	@DeleteMapping("/wherebase/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		whereBaseService.구장삭제(id);
		return "delete";
	}
}
