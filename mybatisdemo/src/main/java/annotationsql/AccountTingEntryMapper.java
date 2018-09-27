package annotationsql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Mirana on 03/11/2017.
 */

@Mapper
public interface AccountTingEntryMapper {

    @Select("SELECT * FROM ACCOUNTING_ENTRY;")
    public List<Map<String,Object>> selectAll();

    @Select("SELECT `ID` FROM ACCOUNTING_ENTRY;")
    List<String> selectAllPrimaryKey();
}
