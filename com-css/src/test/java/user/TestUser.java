package user;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.css.mapper.TbUserMapper;
import com.css.pojo.TbItem;
import com.css.pojo.TbOrder;
import com.css.pojo.TbUser;
import com.css.service.OrderService;


/**
 * @author mei
 *	测试数据库是否连通
 */
public class TestUser extends BaseTest{
	@Autowired 
	TbUserMapper tbUserMapper ;
	@Autowired
	OrderService orderService ;
//	@Test
//	public void test() {
//		TbUser tbuser = new TbUser() ;
//		tbuser.setUserName("mei");
//		tbuser.setUserPassword("mei");
//		tbuser.setCreated(new Date());
//		tbuser.setUpdated(new Date());
//		tbUserMapper.insert(tbuser) ;
//	}
	@Test
	public void testInsertOrder() {
		TbOrder t = new TbOrder() ;
		t.setNum(3L);
		t.setItemId(1L);
		t.setUserId(1L);
		t.setState(0);
		t.setCreated(new Date());
		t.setUpdated(new Date());
		orderService.addOrder(t) ;
		
		
	}
}
