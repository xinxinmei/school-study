package user;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-trans.xml"}) 

public class BaseTest{}