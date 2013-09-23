package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class DataAccessException extends Exception {
    /**
     *
     * @param msg
     */
    public DataAccessException(String msg) {
        super(msg);
    }
    
    /**
     *
     * @param msg
     * @param cause
     */
    public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
