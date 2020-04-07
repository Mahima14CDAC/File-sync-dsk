package com.cdac.filesyncdsk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Piyush Patel
 * @version 1
 * @since 1
 */
public class FixityGeneration {

    private MessageDigest md = null;
    private FileInputStream fis = null;
    private StringBuffer sb = null;

    /**
     * Method generate fixity of file based on provided algorithms
     *
     * @param file input file whose fixity need to generate
     * @param algorithm algorithms
     * @return
     */
    public String generate(File file, String algorithm) {
        try {
            md = MessageDigest.getInstance(algorithm);
            // Dont generate fixity for analysis_result.json and Thumbs.db because these are the files generated and used by SAFE system
            fis = new FileInputStream(file);
            byte[] dataBytes = new byte[1024];
            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            };
            byte[] mdbytes = md.digest();
            //convert the byte to hex format
            sb = new StringBuffer("");
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}