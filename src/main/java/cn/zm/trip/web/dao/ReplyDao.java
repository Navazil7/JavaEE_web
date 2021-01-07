package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
	void deleteByPrimaryKey(Integer tp_rid);

	List<Reply> replyPointSearch(Reply record);
}
