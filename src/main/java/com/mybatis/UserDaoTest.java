package com.mybatis;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by renwujie on 2018/02/24 at 11:35
 */
public class UserDaoTest {

    private static SqlSessionFactory sessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

/**
    //Mybatis通过SqlSessionFactory获取session，然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "Configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }
*/
    public void findUserById(int id) {
        SqlSession sqlSession = sessionFactory.openSession();

        try {
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            User user = userMapper.findUserById(id);
            if (user != null) {
                System.out.println(user.getId() + ":" + user.getUserName()
                        + ":" + user.getUserAddress());
            }
        } finally {
            sqlSession.close();
        }
    }

    public void getUserList(String userName) {
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            List<User> users = userMapper.selectUsersByName(userName);
            for(User user : users) {
                System.out.println(user.getId() + ":" + user.getUserName()
                        + ":" + user.getUserAddress());
            }
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 增加后要commit
     */
    public void addUser() {
        User user = new User();
        user.setUserAddress("place");
        user.setUserName("test_add");
        user.setUserAge(30);

        SqlSession sqlSession = sessionFactory.openSession();
        try{
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            userMapper.addUser(user);
            sqlSession.commit();
            System.out.println("新增用户ID：" + user.getId());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 修改后要commit
     */
    public void updateUser() {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            User user = userMapper.findUserById(1);
            if(user != null) {
                user.setUserAddress("A new place");
                userMapper.updateUser(user);
                sqlSession.commit();
            }
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除后要commit()
     */
    public void deleteUser(int id) {
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            userMapper.deleteUser(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void Test() {
        findUserById(1);
        getUserList("test");
        addUser();
        updateUser();
        //deleteUser(5);
    }
}
