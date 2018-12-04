import com.dream.domain.User;
import com.dream.repository.UserInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.WebConfig;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-28 下午8:06
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class JpaTest {

    @Autowired
    private UserInterface userInterface;
    @Test
    public void save(){
        User user = new User();
        user.setAge("12");
        user.setName("ning");
        user.setId(111);
        userInterface.save(user);
        User user1 = userInterface.findOne("88888888");
        System.out.println(user1.getName());

    }


}