/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.controller;

import com.cdac.filesyncdsk.Constants;
import com.cdac.filesyncdsk.domain.FileMetaJsonResponse;
import com.cdac.filesyncdsk.domain.FormatsJsonResponse;
import com.cdac.filesyncdsk.domain.Organization;
import com.cdac.filesyncdsk.domain.UserJsonResponse;
import com.cdac.filesyncdsk.util.Ciphering;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mahima
 */
@RestController
@RequestMapping(value = "/rest/dskTool", consumes = "application/json",
        produces = "application/json")
public class RestClientController {

    /**
     * To verify the credentials provided by user
     *
     * @param email user's email is
     * @param password user's password
     * @return user's id
     */
    @RequestMapping(value = "/user/{email}")
    public String FileSync(@PathVariable String email, String password) {
        long idd;
        String status = null;
        //Adding "." at the end of URL because spring truncates the path variable after last "."
        String URL = "http://localhost:8080/org-preserve/rest/user/" + email + ".";
        RestTemplate template = new RestTemplate();
        UserJsonResponse userJsonResponse = template.getForObject(URL, UserJsonResponse.class);
        if (userJsonResponse != null) {
            Constants.session.put("who_logged_in", userJsonResponse);
            String FileSyncId, pass;
            String encryptCurrentPwd = Ciphering.stringToMD5(password);
            FileSyncId = userJsonResponse.getFileSyncId();
            pass = userJsonResponse.getPassWord();
            idd = userJsonResponse.getId();
            if (!password.trim().isEmpty()) {
                if (encryptCurrentPwd.equals(pass) && email.equals(FileSyncId)) {
                    status = Constants.COREECT_CREDENTIALS;
                } else {
                    status = Constants.WRONG_PASSWORD;
                }
            }
        } else {
            return status = Constants.WRONG_CREDENTIALS;
        }

        return status;
    }

    /**
     * for adding records in ar_draft_sip
     *
     * @param fileMetaJson object to saved in the table
     * @return int value
     */
    @RequestMapping(value = "/record")
    public FileMetaJsonResponse addRecords(FileMetaJsonResponse fileMetaJson) {
        String URL = "http://localhost:8080/org-preserve/rest/record";
        RestTemplate template = new RestTemplate();
        FileMetaJsonResponse fileMetaJsonResponse = template.postForObject(URL, fileMetaJson, FileMetaJsonResponse.class);
        return fileMetaJsonResponse;
    }
    
    /**
     * sends the directory location to be zipped on server side 
     * @param directoryToZip folder with it's absolute path
     * @return zip status
     */
    @RequestMapping(value = "/zipRecord")
    public String createZipFile(String directoryToZip) {
        String URL = "http://localhost:8080/org-preserve/rest/zipRecord?path="+directoryToZip;
        RestTemplate template = new RestTemplate();
        String status = template.getForObject(URL, String.class);
        return status;
    }
    
    /**
     * gets the list of all organizations from server
     * @return list of all organizations
     */
    @RequestMapping(value = "/organization")
    public List<Organization> getOrganization() {
        String URL = "http://localhost:8080/org-preserve/rest/organization";
        RestTemplate template = new RestTemplate();
        Organization[] organization = template.getForObject(URL, Organization[].class);
        List<Organization> orgs = new ArrayList<>();
        for (Organization org : organization) {
            orgs.add(org);
        }
        return orgs;
    }

    /**
     * gets the list of erm supported formats with extension and their mimeType
     * @return list of formats
     */
    @RequestMapping(value = "/formats")
    public List<FormatsJsonResponse> getFormats() {
        String URL = "http://localhost:8080/org-preserve/rest/formats";
        RestTemplate template = new RestTemplate();
        FormatsJsonResponse[] formatsJsonResponse = template.getForObject(URL, FormatsJsonResponse[].class);
        List<FormatsJsonResponse> formats = new ArrayList<>();
        for (FormatsJsonResponse format : formatsJsonResponse) {
            formats.add(format);
        }
        return formats;
    }
}
