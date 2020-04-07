/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk;

import java.util.HashMap;

/**
 *
 * @author Mahima
 */
public class Constants {

    public final static String INFORMATION = "information";

    public final static String ERROR = "error";

    public final static String ZIP_LOCATION = "C:/";

    public final static String UPLOAD_FAILED = "upload failed";

    public final static String UPLOAD_SUCCESSFUL = "upload successful";

    public final static String FileSync_FAILED = "FileSync failed";

    public final static String SINGLE_DEPOSITE = "Deposite New Record";

    public final static String BULK_DEPOSITE = "Deposite Bulk Records";

    public static final String RECORD_DEPOSITER="SIP Creator";
    public static final String WRONG_CREDENTIALS="Invalid User, try FileSync by another user";
    public static final String COREECT_CREDENTIALS="Correct Credentials";
    public static final String WRONG_PASSWORD="Wrong Password";
    
    public static HashMap<String, Object> session=new HashMap<>();
    

}
