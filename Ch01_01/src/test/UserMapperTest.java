package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import pojo.User;

public class UserMapperTest {
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Test
	public void test1(){
		String resource = "mybatis-configuration.xml";
		SqlSession sqlSession = null;
		User user = null;
		int count = 0;
		try{
			//读取全局配置文件xml，获取输入流
			InputStream is = Resources.getResourceAsStream(resource);
			//此对象可以完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//创建SqlSession对象
			sqlSession = factory.openSession();
			//调用mapper文件对数据进行操作，必须将mapper文件引入Mybatis-config.xml中
			user =  sqlSession.selectOne("dao.UserMapper.getUserListByName",2017441524);
			
			//selectOne 第一个参数 表示映射的SQL的标识字符串（<mapper>元素中的namespace属性值+<selecet>元素的id属性值组成
			// 第二个参数则是 查询所需要的参数
			
			//count = sqlSession.selectOne("dao.UserMapper.count");
			//logger.debug("该表总数为： "+count);
			logger.debug("查询的信息为："+user);
		}catch(IOException a){
			a.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	

}
