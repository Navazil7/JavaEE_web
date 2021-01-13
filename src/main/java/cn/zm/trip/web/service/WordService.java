package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.Words;

import java.util.List;

public interface WordService {
    /**
     * 保存留言信息功能
     * @param words
     * @return
     */
    public void saveWords(Words words);
    /**
     * 保存回复信息
     * @param reply
     */
    public void saveReply(Reply reply);
    /**
     * 查询所有留言信息
     * @return
     */
    public List<Words> findByWords();
    /**
     * 	查询所有回复信息
     */
    public List<Reply> findByReply();
}
