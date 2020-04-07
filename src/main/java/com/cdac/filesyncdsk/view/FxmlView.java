package com.cdac.filesyncdsk.view;

import java.util.ResourceBundle;

/**
 * Enum for views
 * @author Mahima
 */
public enum FxmlView {
    
    FILEUPLOAD{

        @Override
        public String getTitle() {
            return getStringFromResourceBundle("fileupload.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/FileUpload.fxml";
        }
    },

    FileSync{

        @Override
        public String getTitle() {
            return getStringFromResourceBundle("FileSync.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/FileSync.fxml";
        }
    };
    
    /**
     * gets the title of the view 
     * @return title of the view
     */
    public abstract String getTitle();
    
    /**
     * gets the fxml view 
     * @return fxml view
     */
    public abstract String getFxmlFile();
    
    public String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
