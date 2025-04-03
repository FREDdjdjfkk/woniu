import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        SqlSession sqlSession;
        String resource = "mybatis-config.xml";
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource)).openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
