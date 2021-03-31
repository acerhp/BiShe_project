package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import dao.UserMapper;
import pojo.User;
import util.MyBatisUtil;
public class findUserListByName{
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Test
	public void test1() throws IOException{
		String resource = "mybatis-configuration.xml";
		SqlSession sqlSession = null;
		List<User> userlist = new ArrayList<User>();
		try{
			//InputStream is = Resources.getResourceAsStream(resource);
			//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//sqlSession = factory.openSession();
			
			sqlSession = MyBatisUtil.createSqlSession();
			//调用getMapper(Maooer.class)执行DAO接口方法来实现对数据库的查询操作
			userlist = sqlSession.getMapper(UserMapper.class).findUserByIdName("黄", 2017442532);
			//提交事务 sqlSession.commit();
		}finally{
			//sqlSession.close();
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user : userlist)
			logger.debug(user);
	}
}
