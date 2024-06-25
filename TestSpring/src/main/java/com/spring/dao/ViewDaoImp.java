package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ViewDaoImp implements ViewDao {
	@Autowired
	private final SqlSession session;
	
	public TempDTO test(TempDTO dto) {
		return session.selectOne("sql.findOne", dto);
	}
	
	public List<TempDTO> findAll(TempDTO dto){
		return session.selectList("sql.findAll", dto);
	}
	
	public void accept(TempDTO dto) {
	    //transaction(session.update("sql.accept", dto));
	    session.update("sql.accept", dto); // autocommit 일경우는 바로 호출
	  }
	
	 public TempDTO findOne(TempDTO dto) {
		    return session.selectOne("sql.findOne", dto);
		  }
	 public TempDTO edit(TempDTO dto) {
		    //transaction(session.update("sql.edit", dto));
		    session.update("sql.edit", dto); // autocommit 일경우는 바로 호출
		    return dto;
		  }
	 public TempDTO save(TempDTO dto) {
		    //transaction(session.insert("sql.save", dto));
		    session.insert("sql.save", dto); // autocommit 일경우는 바로 호출
		    return dto;
		  }
	 
	

	
}
