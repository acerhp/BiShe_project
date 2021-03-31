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
			//��ȡȫ�������ļ�xml����ȡ������
			InputStream is = Resources.getResourceAsStream(resource);
			//�˶��������ɶ������ļ��Ķ�ȡ
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//����SqlSession����
			sqlSession = factory.openSession();
			//����mapper�ļ������ݽ��в��������뽫mapper�ļ�����Mybatis-config.xml��
			user =  sqlSession.selectOne("dao.UserMapper.getUserListByName",2017441524);
			
			//selectOne ��һ������ ��ʾӳ���SQL�ı�ʶ�ַ�����<mapper>Ԫ���е�namespace����ֵ+<selecet>Ԫ�ص�id����ֵ���
			// �ڶ����������� ��ѯ����Ҫ�Ĳ���
			
			//count = sqlSession.selectOne("dao.UserMapper.count");
			//logger.debug("�ñ�����Ϊ�� "+count);
			logger.debug("��ѯ����ϢΪ��"+user);
		}catch(IOException a){
			a.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	

}
