/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.util;

import com.cdac.filesyncdsk.controller.RestClientController;
import com.cdac.filesyncdsk.domain.Organization;
import java.util.List;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mahima
 */
public class Alerts {
    
    @Autowired
    private RestClientController rcc;

    /**
     * getting Alert box and message as per user's requirement
     *
     * @param info type of alert i.e. INFORMATION/ERROR
     * @param message message to be displayed on alert
     */
    public void getAlerts(String info, String title,String message) {
        if (info.equalsIgnoreCase("information")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText("Success :");
            alert.setContentText(message);
            alert.showAndWait();
        } else if (info.equalsIgnoreCase("error")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText("Failed :");
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

    /**
     * Generates folderName for new record to be saved in
     * @param fileName record name being uploaded
     * @param type 0
     * @param activityCode activity code selected for the record
     * @return 
     */
    public String generateFolderName(String fileName, String type, String activityCode) {
        StringBuilder builder = new StringBuilder();
        String constantIdentifer = null; //Helper.ORGANIZATION_CODE;
        try {
            if (constantIdentifer == null) {
                rcc=new RestClientController();
                List<Organization> listOfOrganization = rcc.getOrganization();
                if (listOfOrganization.size() == 1) {
                    Organization organization = listOfOrganization.get(0);
                    constantIdentifer = organization.getOrganizationCode();
//                    Helper.ORGANIZATION_CODE = constantIdentifer;
                }
            }
            String idenfierOfFileName = constantIdentifer + System.currentTimeMillis() + activityCode;
            int fileNameSize = 45 - idenfierOfFileName.length();
            if (fileName.length() > fileNameSize) {
                fileName = fileName.substring(0, fileNameSize);
            }
            fileName = fileName.replaceAll("[\\s]", "_");
            fileName = fileName.replaceAll("[!\\”#$%&'()*+-./:;<=>?@\\^{|}~`,.\\[\\]]*", "");
            if (activityCode != null && !("").equals(activityCode.trim())
                    && !("misc").equalsIgnoreCase(activityCode) && !("select").equalsIgnoreCase(activityCode)) {
                builder.append(activityCode).append("_");
            }
            builder.append(fileName).append("_");
            builder.append(constantIdentifer).append(type).append("_");
            builder.append(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
//            LOGGER.error(e.getMessage());
        }
        return builder.toString();
    }
}
