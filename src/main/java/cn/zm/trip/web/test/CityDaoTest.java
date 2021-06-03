package cn.zm.trip.web.test;

import cn.zm.trip.web.dao.CityDao;
import cn.zm.trip.web.domain.City;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

public class CityDaoTest {

    @Test
    public void deleteByPrimaryKey() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city=new City();
        city.setTpCid(1);
        expect(cityDao.insert(city)).andReturn(1);
        expect(cityDao.deleteByPrimaryKey(1)).andReturn(1);
        EasyMock.replay(cityDao);
        cityDao.insert(city);
        int answer= cityDao.deleteByPrimaryKey(1);
        assertEquals(1,answer);
        EasyMock.verify(cityDao);
    }
    @Test
    public void deleteByPrimaryKeyFail() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city=new City();
        city.setTpCid(1);
        expect(cityDao.insert(city)).andReturn(1);
        expect(cityDao.deleteByPrimaryKey(1)).andReturn(0);
        EasyMock.replay(cityDao);
        cityDao.insert(city);
        int answer= cityDao.deleteByPrimaryKey(1);
        assertEquals(0,answer);
        EasyMock.verify(cityDao);
    }
    @Test
    public void insert() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city=new City();
        city.setTpCid(1);
        expect(cityDao.insert(city)).andReturn(1);
        EasyMock.replay(cityDao);
        int answer= cityDao.insert(city);
        assertEquals(1,answer);
        EasyMock.verify(cityDao);
    }
    @Test
    public void insertFail() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city=new City();
        city.setTpCid(1);
        expect(cityDao.insert(city)).andReturn(0);
        EasyMock.replay(cityDao);
        int answer= cityDao.insert(city);
        assertEquals(0,answer);
        EasyMock.verify(cityDao);
    }


    @Test
    public void updateByPrimaryKeyFail() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city=new City();
        city.setTpCid(1);
        city.setTpCname("杭州");
        expect(cityDao.updateByPrimaryKey(city)).andReturn(0);
        EasyMock.replay(cityDao);
        int answer= cityDao.updateByPrimaryKey(city);
        assertEquals(0,answer);
        EasyMock.verify(cityDao);
    }

    @Test
    public void selectAllCity() {
        CityDao cityDao= EasyMock.createMock(CityDao.class);
        City city1=new City();
        city1.setTpCid(1);
        city1.setTpCname("杭州");
        City city2=new City();
        city2.setTpCid(2);
        city2.setTpCname("北京");
        List<City> cityList=new List<City>() {
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
            public Iterator<City> iterator() {
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
            public boolean add(City city) {
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
            public boolean addAll(Collection<? extends City> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends City> c) {
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
            public City get(int index) {
                return null;
            }

            @Override
            public City set(int index, City element) {
                return null;
            }

            @Override
            public void add(int index, City element) {

            }

            @Override
            public City remove(int index) {
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
            public ListIterator<City> listIterator() {
                return null;
            }

            @Override
            public ListIterator<City> listIterator(int index) {
                return null;
            }

            @Override
            public List<City> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        cityList.add(city1);
        cityList.add(city2);
        expect(cityDao.insert(city1)).andReturn(1);
        expect(cityDao.insert(city2)).andReturn(1);
        expect(cityDao.selectAllCity()).andReturn(cityList);
        EasyMock.replay(cityDao);
        cityDao.insert(city1);
        cityDao.insert(city2);
        List<City>cityList2=cityDao.selectAllCity();
        for(int i=0;i<3;i++)
        assertEquals(cityList2.get(i), cityList.get(i));
        EasyMock.verify(cityDao);
    }
}