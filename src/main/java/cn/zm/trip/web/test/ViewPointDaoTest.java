package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPoint;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

public class ViewPointDaoTest {



    @Test
    public void insert() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.insert(viewPoint1)).andReturn(1);
        EasyMock.replay(viewPointDao);
        int answer=viewPointDao.insert(viewPoint1);
        assertEquals(1, answer);
        EasyMock.verify(viewPointDao);
    }
    //已存在
    @Test
    public void insertFail() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.insert(viewPoint1)).andReturn(0);
        EasyMock.replay(viewPointDao);
        int answer=viewPointDao.insert(viewPoint1);
        assertEquals(0, answer);
        EasyMock.verify(viewPointDao);
    }
    @Test
    public void deleteByPrimaryKey() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.insert(viewPoint1)).andReturn(1);
        expect(viewPointDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(viewPointDao);
        viewPointDao.insert(viewPoint1);
        int answer=viewPointDao.deleteByPrimaryKey(1);
        assertEquals(1, answer);
        EasyMock.verify(viewPointDao);
    }
    //不存在
    @Test
    public void deleteByPrimaryKeyFail() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.insert(viewPoint1)).andReturn(1);
        expect(viewPointDao.deleteByPrimaryKey(1)).andReturn(0);
        EasyMock.replay(viewPointDao);
        viewPointDao.insert(viewPoint1);
        int answer=viewPointDao.deleteByPrimaryKey(1);
        assertEquals(0, answer);
        EasyMock.verify(viewPointDao);
    }

    @Test
    public void selectByPrimaryKey() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.selectByPrimaryKey(1)).andReturn(viewPoint1);
        EasyMock.replay(viewPointDao);
        ViewPoint answer=viewPointDao.selectByPrimaryKey(1);
        assertEquals(viewPoint1, answer);
        EasyMock.verify(viewPointDao);
    }
    //不存在
    @Test
    public void selectByPrimaryKeyFail() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=null;
        expect(viewPointDao.selectByPrimaryKey(1)).andReturn(viewPoint1);
        EasyMock.replay(viewPointDao);
        ViewPoint answer=viewPointDao.selectByPrimaryKey(1);
        assertEquals(viewPoint1, answer);
        EasyMock.verify(viewPointDao);
    }


    @Test
    public void updateByPrimaryKey() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.updateByPrimaryKey(viewPoint1)).andReturn(1);
        EasyMock.replay(viewPointDao);
        int answer=viewPointDao.updateByPrimaryKey(viewPoint1);
        assertEquals(1, answer);
        EasyMock.verify(viewPointDao);
    }
    @Test
    public void updateByPrimaryKeyFail() {
        ViewPointDao viewPointDao= EasyMock.createMock(ViewPointDao.class);
        ViewPoint viewPoint1=new ViewPoint();
        viewPoint1.setTpVid(1);
        viewPoint1.setTpVname("游乐园");
        expect(viewPointDao.updateByPrimaryKey(viewPoint1)).andReturn(0);
        EasyMock.replay(viewPointDao);
        int answer=viewPointDao.updateByPrimaryKey(viewPoint1);
        assertEquals(0, answer);
        EasyMock.verify(viewPointDao);
    }


}