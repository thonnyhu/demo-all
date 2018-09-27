package annotationsql;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Mirana on 03/11/2017.
 */
public class TestClass {
    private static Logger logger = LoggerFactory.getLogger(TestClass.class);

    public static void main(String[] args) throws IOException {
        String resource  = "mybatis-datasource.config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        AccountTingEntryMapper mapper = sqlSession.getMapper(AccountTingEntryMapper.class);
        List<Map<String, Object>> maps = mapper.selectAll();
        List<String> strings = mapper.selectAllPrimaryKey();
        logger.info("stringObjectMap:{}",maps);
        logger.info("strings:{}",strings);
        sqlSession.close();
    }
}
