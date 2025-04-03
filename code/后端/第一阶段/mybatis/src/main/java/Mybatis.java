import Mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Dept;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Mybatis {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = getSqlSession(resource);

        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);

//        Dept dept = deptMapper.findById(15);
//        System.out.println(dept);
//        List<Dept> depts = deptMapper.findAll();
//        for (Dept dept1:depts
//             ) {
//            System.out.println(dept1);
//        }

//        Dept dept2=new Dept(17,"研发部",4, null,66);
//        deptMapper.insetDept(dept2);
//        Dept dept = deptMapper.findById(16);
//        System.out.println(dept);
//        Map<String, Object> map=new HashMap<>();
//        map.put("id",17);
//        map.put("companyId",3);
//        map.put("name","宣传部");
        Dept dept1=new Dept(1,null,null,null,null);
//        deptMapper.updateDept(dept1.getName(),1);
        List<Dept> result =deptMapper.findCondition(dept1);
        for (Dept dept7 : result) {
            System.out.println(dept7);
        }
        sqlSession.commit();
        sqlSession.close();

    }

    private static SqlSession getSqlSession(String resource) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        return sqlSession;
    }
}
