package filters;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestWrapper extends HttpServletRequestWrapper {

    private Map params;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        //So that other request method behave just like before
        super(request);
        this.params = new HashMap(request.getParameterMap());
    }

    @Override
    public String getParameter(String name) {
        //return super.getParameter(name);
        String[] paramArray = getParameterValues(name);
        if (paramArray != null && paramArray.length > 0) {
            return paramArray[0];
        }
        return null;
    }

    @Override
    public Map getParameterMap() {
        return Collections.unmodifiableMap(params);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] result = null;
        String[] temp = (String[]) params.get(name);
        if (temp != null) {
            result = new String[temp.length];
            System.arraycopy(temp, 0, result, 0, temp.length);
        }
        return result;
    }

    public void setParameter(String name, String value) {
        String[] oneParam = {value};
        setParameter(name,oneParam);
    }

    public void setParameter(String name, String[] values) {
        params.put(name,values);
    }

    public void     removeParam(String name){
        params.remove(name);
    }
}