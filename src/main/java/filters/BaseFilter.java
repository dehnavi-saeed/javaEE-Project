package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

abstract public class BaseFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        RequestWrapper request = new RequestWrapper(httpServletRequest);
        doFilter(request,servletResponse,filterChain);
        filterChain.doFilter(request, servletResponse);
    }
    abstract public void doFilter(RequestWrapper request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException;

    public void destroy(){

    }

    protected void checkWhiteList(String[] whiteList, RequestWrapper request){
        ArrayList<String> paramNames = Collections.list(request.getParameterNames());
        ArrayList<String> wList = new ArrayList<String>( Arrays.asList(whiteList));
        paramNames.removeAll(wList);
        for (int i = 0; i < paramNames.size(); i++) {
            request.removeParam(paramNames.get(i));
        }
        
    }
}
