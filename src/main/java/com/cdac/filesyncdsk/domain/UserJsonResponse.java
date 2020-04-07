/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.domain;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mahima
 */
public class UserJsonResponse {

    private Long id;
    private String FileSyncId;
    private String passWord;
    private String roleName;
    private String fond;
    private HashMap<String, List<String>> activityCodes;
    private HashMap<String,Long> subfonds;

    /**
     * getting user's id
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * setting user's id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getting user's FileSync id
     * @return 
     */
    public String getFileSyncId() {
        return FileSyncId;
    }

    /**
     * setiing user's FileSyncid
     * @param FileSyncId 
     */
    public void setFileSyncId(String FileSyncId) {
        this.FileSyncId = FileSyncId;
    }

    /**
     * getting user's password
     * @return 
     */
    public String getPassWord() {
        return passWord;
    }

     /**
     * setiing user's password
     * @param FileSyncId 
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * getting user's RoleName
     * @return 
     */
    public String getRoleName() {
        return roleName;
    }

     /**
     * setiing user's RoleName
     * @param FileSyncId 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * getting user's fond
     * @return 
     */
    public String getFond() {
        return fond;
    }

     /**
     * setiing user's fond
     * @param FileSyncId 
     */
    public void setFond(String fond) {
        this.fond = fond;
    }

    /**
     * getting activity codes and subfonds created by user
     * @return 
     */
    public HashMap<String, List<String>> getActivityCodes() {
        return activityCodes;
    }

     /**
     * setiing activity codes and subfonds created by user
     * @param FileSyncId 
     */
    public void setActivityCodes(HashMap<String, List<String>> activityCodes) {
        this.activityCodes = activityCodes;
    }

    /**
     * gets subfonds with their name and id
     * @return Hashmap of subfond id and subfond name
     */
    public HashMap<String,Long> getSubfonds() {
        return subfonds;
    }

    /**
     * sets subfonds with their name and id
     * @param subfonds 
     */
    public void setSubfonds(HashMap<String,Long> subfonds) {
        this.subfonds = subfonds;
    }

    @Override
    public String toString() {
        return "UserJsonResponse{" + "id=" + id + ", FileSyncId=" + FileSyncId + ", password=" + passWord + ", roleName=" + roleName + ", fond=" + fond + ", activityCodes=" + activityCodes + ", subfonds=" + subfonds + '}';
    }

}
