/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.service;

import java.io.IOException;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.impl.DefaultFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

/**
 *
 * @author Mahima
 */
public class FileSyncToServer {

    public static void copyRemoteFiles(String host, String user, String remotePath, String localPath) throws IOException {
        FileSystemOptions fsOptions = new FileSystemOptions();
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(fsOptions, "no");
        SftpFileSystemConfigBuilder.getInstance().setIdentities(fsOptions,
                new File[]{new File(FileUtils.getUserDirectoryPath() + "/.ssh/id_dsa")});
        DefaultFileSystemManager fsManager = (DefaultFileSystemManager) VFS.getManager();
        String uri = "sftp://" + user + "@" + host + "/" + remotePath;

        FileObject fo = fsManager.resolveFile(uri, fsOptions);

        FileObject[] files = fo.getChildren();
        for (FileObject file : files) {
            // We will be dealing with the files here only
            if (file.getType() == FileType.FILE) {
                FileUtils.copyInputStreamToFile(file.getContent().getInputStream(),
                        new File(localPath + "/" + file.getName().getBaseName()));
            }
            file.close();
        }

        fo.close();

        fsManager.close();
    }
    
    public static void main(String[] args) {
        System.out.println("Running...");
    }
}
