/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.domain;

/**
 *
 * @author Mahima
 */
public class FormatsJsonResponse {
    
    /**
     * name of format
     */
    private String name;
    /**
     * mime type of format
     */
    private String mimeType;
    /**
     * extension of file of the format
     */
    private String extension;
    /**
     * give extension of format
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     * set extension of format
     *
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * give format
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set format
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * give mime type of format
     *
     * @return
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * set mime type of format
     *
     * @param mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return "FormatsJsonResponse{" + "name=" + name + ", mimeType=" + mimeType + ", extension=" + extension + '}';
    }
}
