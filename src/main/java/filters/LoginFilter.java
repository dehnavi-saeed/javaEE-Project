package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoginFilter extends BaseFilter {

    @Override
    public void doFilter(RequestWrapper request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String[] whiteList = {"username", "password","remember"};
        checkWhiteList(whiteList, request);

    }
}
