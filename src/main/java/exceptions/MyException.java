package exceptions;

/**
 * Created by asus on 2019/12/06.
 */
public class MyException extends RuntimeException{

    public String msg;
    public int code;


    public MyException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /*@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    */
}
