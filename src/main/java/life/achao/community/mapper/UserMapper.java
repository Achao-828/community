package life.achao.community.mapper;

import life.achao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PackageName: life.achao.community.mapper
 * @ClassName: UserMapper
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/14 18:54
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
