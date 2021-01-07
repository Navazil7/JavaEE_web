package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Words;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsDao {
	void deleteByPrimaryKey(Integer tp_wid);

	List<Words> wordsPointSearch(Words record);
}
