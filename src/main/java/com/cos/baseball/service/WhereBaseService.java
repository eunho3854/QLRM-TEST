package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.where.WhereBase;
import com.cos.baseball.domain.where.WhereRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WhereBaseService {

private final WhereRepository whereRepository;
	
	@Transactional(readOnly = true)
	public List<WhereBase> 구장리스트(){
		return whereRepository.findAll();
	}
	
	@Transactional
	public WhereBase 구장등록(WhereBase whereBase) {
		return whereRepository.save(whereBase);
	}
	
	@Transactional
	public void 구장삭제(int id) {
		whereRepository.deleteById(id);
	}
}
