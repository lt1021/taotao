import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * @author lt
 * @date 2021/4/21 16:17
 */
public class test01 {
    public static void main(String[] args) {
        if (1==2) {
            throw new BadCredentialsException("未登陆");
        } {
            System.out.println(1);
            return ;
        }

    }
}
