package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.ForumDao;
import cn.zm.trip.web.dao.ReplyDao;
import cn.zm.trip.web.dao.WordsDao;
import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.Words;
import cn.zm.trip.web.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    WordsDao wordsDao;
    @Autowired
    ReplyDao replyDao;
    /**
     * 保存留言信息功能
     * @param words
     * @return
     */
    @Override
    public void saveWords(Words words) {
        wordsDao.saveWords(words);
    }
    /**
     * 保存回复信息
     * @param reply
     */
    @Override
    public void saveReply(Reply reply) {
        replyDao.saveReply(reply);
    }
    /**
     * 查询所有留言信息
     * @return
     */
    @Override
    public List<Words> findByWords() {
        return wordsDao.findByWords();
    }
    /**
     * 	查询所有回复信息
     */
    @Override
    public List<Reply> findByReply() {
        return replyDao.findByReply();
    }
}
