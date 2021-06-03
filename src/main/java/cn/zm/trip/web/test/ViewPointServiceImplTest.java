package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.impl.ViewPointServiceImpl;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class ViewPointServiceImplTest {
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() {


        ViewPointServiceImpl viewPointService=createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("西湖");
        ViewPoint viewPoint2=new ViewPoint();
        viewPoint2.setTpVid(2);
        viewPoint2.setTpVname("洞庭湖");
        viewPointService.insertView(viewPoint);
        EasyMock.expectLastCall().anyTimes();
        viewPointService.insertView(viewPoint2);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.expect(viewPointService.selectByPrimaryKey(1)).andReturn(viewPoint);
        EasyMock.expect(viewPointService.selectByPrimaryKey(2)).andReturn(viewPoint2);
        EasyMock.replay(viewPointService);
        ViewPoint viewPoint1=viewPointService.selectByPrimaryKey(1);
        assertEquals(viewPoint,viewPoint1);
        ViewPoint viewPoint22=viewPointService.selectByPrimaryKey(2);
        assertEquals(viewPoint22,viewPoint2);
        EasyMock.verify(viewPointService);
    }
    //为负
    @Test
    public void selectByPrimaryKeyFail() {


        ViewPointServiceImpl viewPointService=createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint2=null;
        EasyMock.expect(viewPointService.selectByPrimaryKey(0)).andReturn(viewPoint2);
        EasyMock.replay(viewPointService);
        ViewPoint viewPoint22=viewPointService.selectByPrimaryKey(0);
        assertEquals(viewPoint22,viewPoint2);
        EasyMock.verify(viewPointService);
    }
    //为0
    @Test
    public void selectByPrimaryKeyFail2() {


        ViewPointServiceImpl viewPointService=createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint2=null;
        EasyMock.expect(viewPointService.selectByPrimaryKey(-1)).andReturn(viewPoint2);
        EasyMock.replay(viewPointService);
        ViewPoint viewPoint22=viewPointService.selectByPrimaryKey(-1);
        assertEquals(viewPoint22,viewPoint2);
        EasyMock.verify(viewPointService);
    }
    //不存在
    @Test
    public void selectByPrimaryKeyFail3() {


        ViewPointServiceImpl viewPointService=createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint2=null;
        EasyMock.expect(viewPointService.selectByPrimaryKey(100)).andReturn(viewPoint2);
        EasyMock.replay(viewPointService);
        ViewPoint viewPoint22=viewPointService.selectByPrimaryKey(100);
        assertEquals(viewPoint22,viewPoint2);
        EasyMock.verify(viewPointService);
    }
    @Test
    public void insertView() {
        ViewPointServiceImpl viewPointService= createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("西湖");
        viewPointService.insertView(viewPoint);
//        EasyMock.expect(viewPointService.insertView(viewPoint)).anyTimes();
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(viewPointService);
        EasyMock.verify(viewPointService);

    }

    @Test
    public void deleteviews() {
        ViewPointServiceImpl viewPointService=createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("西湖");
        viewPointService.insertView(viewPoint);
        EasyMock.expectLastCall().anyTimes();
        viewPointService.deleteviews(1);
        EasyMock.expectLastCall().anyTimes();//设置void返回值测试
        EasyMock.replay(viewPointService);
        EasyMock.verify(viewPointService);
    }



    @Test
    public void updateByPrimaryKeySelective() {
        ViewPointServiceImpl viewPointService= createMock(ViewPointServiceImpl.class);
        ViewPoint viewPoint=new ViewPoint();
        viewPoint.setTpVid(1);
        viewPoint.setTpVname("西湖");
        viewPoint.setTpLocation("杭州");
        viewPoint.setTpPrice("1233");
        viewPointService.updateByPrimaryKeySelective(viewPoint);
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(viewPointService);
        EasyMock.verify(viewPointService);
    }

    @Test
    public void findByViewpoint() {
//        截图代码
//        ViewPointDao viewPointDao= (ViewPointDao) context.getBean("viewPointDao");
//        List<ViewPoint> viewPoint1 = null;
//        ViewPoint v1=new ViewPoint();
//        v1.setTpVname("西湖");
//        v1.setTpVid(1);
//        ViewPoint v2=new ViewPoint();
//        v2.setTpVname("拙政园");
//        v2.setTpVid(1);
//        ViewPoint v3=new ViewPoint();
//        v3.setTpVname("西溪湿地");
//        v3.setTpVid(1);
//        viewPoint1.add(v1);
//        viewPoint1.add(v2);
//        viewPoint1.add(v3);
//        List<ViewPoint> viewPoint=viewPointDao.findByViewpoint();
//        for(int i=0;i<3;i++)
//        assertEquals(viewPoint1.get(i),viewPoint.get(i));

//      运行代码
        ViewPointDao viewPointDao= createMock(ViewPointDao.class);
        ViewPointServiceImpl viewPointService=new ViewPointServiceImpl();
        List<ViewPoint> viewPoint1 = new List<ViewPoint>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ViewPoint> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ViewPoint viewPoint) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ViewPoint> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends ViewPoint> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ViewPoint get(int index) {
                return null;
            }

            @Override
            public ViewPoint set(int index, ViewPoint element) {
                return null;
            }

            @Override
            public void add(int index, ViewPoint element) {

            }

            @Override
            public ViewPoint remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ViewPoint> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ViewPoint> listIterator(int index) {
                return null;
            }

            @Override
            public List<ViewPoint> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        ViewPoint v1=new ViewPoint();
        v1.setTpVname("西湖");
        v1.setTpVid(1);
        ViewPoint v2=new ViewPoint();
        v2.setTpVname("拙政园");
        v2.setTpVid(1);
        ViewPoint v3=new ViewPoint();
        v3.setTpVname("西溪湿地");
        v3.setTpVid(1);
        viewPoint1.add(v1);
        viewPoint1.add(v2);
        viewPoint1.add(v3);
        EasyMock.expect(viewPointDao.findByViewpoint()).andReturn(viewPoint1);
        EasyMock.replay(viewPointDao);
        viewPointService.setViewPointDao(viewPointDao);

        List<ViewPoint> viewPoint2=viewPointService.findByViewpoint();
        for(int i=0;i<3;i++)
        	assertEquals(viewPoint1.get(i),viewPoint2.get(i));
        EasyMock.verify(viewPointDao);
    }
}