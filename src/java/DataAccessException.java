/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class DataAccessException extends Exception {
    public DataAccessException(String msg) {
        super(msg);
    }
    
    public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
