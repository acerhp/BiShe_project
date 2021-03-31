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
			//����getMapper(Maooer.class)ִ��DAO�ӿڷ�����ʵ�ֶ����ݿ�Ĳ�ѯ����
			userlist = sqlSession.getMapper(UserMapper.class).findUserByIdName("��", 2017442532);
			//�ύ���� sqlSession.commit();
		}finally{
			//sqlSession.close();
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user : userlist)
			logger.debug(user);
	}
}
