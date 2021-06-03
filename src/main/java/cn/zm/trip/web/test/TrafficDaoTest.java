package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.domain.Traffic;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

public class TrafficDaoTest {

    @Test
    public void deleteByPrimaryKey() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        expect(trafficDao.insert(traffic)).andReturn(1);
        expect(trafficDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(trafficDao);
        trafficDao.insert(traffic);
        int answer= trafficDao.deleteByPrimaryKey(1);
        assertEquals(1,answer);
        EasyMock.verify(trafficDao);
    }
    @Test
    public void deleteByPrimaryKeyFail() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        expect(trafficDao.insert(traffic)).andReturn(1);
        expect(trafficDao.deleteByPrimaryKey(1)).andReturn(0);
        EasyMock.replay(trafficDao);
        trafficDao.insert(traffic);
        int answer= trafficDao.deleteByPrimaryKey(1);
        assertEquals(0,answer);
        EasyMock.verify(trafficDao);
    }
    @Test
    public void insert() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        expect(trafficDao.insert(traffic)).andReturn(1);
//        expect(TrafficDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(trafficDao);
        int answer=trafficDao.insert(traffic);
//        int answer= TrafficDao.deleteByPrimaryKey(1);
        assertEquals(1,answer);
        EasyMock.verify(trafficDao);
    }
    @Test
    public void insertFail() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        expect(trafficDao.insert(traffic)).andReturn(0);
//        expect(TrafficDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(trafficDao);
        int answer=trafficDao.insert(traffic);
//        int answer= TrafficDao.deleteByPrimaryKey(1);
        assertEquals(0,answer);
        EasyMock.verify(trafficDao);
    }
    @Test
    public void trafficPointSearch() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic1=new Traffic();
        traffic1.setTpTid(1);
        traffic1.setTpCurrent("杭州");
        Traffic traffic2=new Traffic();
        traffic2.setTpTid(2);
        traffic2.setTpCurrent("北京");
        List<Traffic> TrafficList=new List<Traffic>() {
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
            public Iterator<Traffic> iterator() {
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
            public boolean add(Traffic Traffic) {
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
            public boolean addAll(Collection<? extends Traffic> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Traffic> c) {
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
            public Traffic get(int index) {
                return null;
            }

            @Override
            public Traffic set(int index, Traffic element) {
                return null;
            }

            @Override
            public void add(int index, Traffic element) {

            }

            @Override
            public Traffic remove(int index) {
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
            public ListIterator<Traffic> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Traffic> listIterator(int index) {
                return null;
            }

            @Override
            public List<Traffic> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        TrafficList.add(traffic1);
        TrafficList.add(traffic2);
        expect(trafficDao.insert(traffic1)).andReturn(1);
        expect(trafficDao.insert(traffic2)).andReturn(1);
        expect(trafficDao.trafficPointSearch(traffic1)).andReturn(TrafficList);
        EasyMock.replay(trafficDao);
        trafficDao.insert(traffic1);
        trafficDao.insert(traffic2);
        List<Traffic>TrafficList2=trafficDao.trafficPointSearch(traffic1);
        for(int i=0;i<3;i++)
            assertEquals(TrafficList2.get(i), TrafficList.get(i));
        EasyMock.verify(trafficDao);
    }

    @Test
    public void updateByPrimaryKey() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        traffic.setTpCurrent("杭州");
        expect(trafficDao.updateByPrimaryKey(traffic)).andReturn(1);
        EasyMock.replay(trafficDao);
        int answer= trafficDao.updateByPrimaryKey(traffic);
        assertEquals(1,answer);
        EasyMock.verify(trafficDao);
    }
    @Test
    public void updateByPrimaryKeyFail() {
        TrafficDao trafficDao= EasyMock.createMock(TrafficDao.class);
        Traffic traffic=new Traffic();
        traffic.setTpTid(1);
        traffic.setTpCurrent("杭州");
        expect(trafficDao.updateByPrimaryKey(traffic)).andReturn(0);
        EasyMock.replay(trafficDao);
        int answer= trafficDao.updateByPrimaryKey(traffic);
        assertEquals(0,answer);
        EasyMock.verify(trafficDao);
    }
}