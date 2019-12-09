package user;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.css.mapper.TbUserMapper;
import com.css.pojo.TbUser;


/**
 * @author mei
 *	测试数据库是否连通
 */
public class TestUser extends BaseTest{
	@Autowired 
	TbUserMapper tbUserMapper ;
	@Test
	public void test() {
		TbUser tbuser = new TbUser() ;
		tbuser.setUserName("mei");
		tbuser.setUserPassword("mei");
		tbuser.setCreated(new Date());
		tbuser.setUpdated(new Date());
		tbUserMapper.insert(tbuser) ;
	}
}
