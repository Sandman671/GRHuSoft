/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grhusoft;

import java.security.MessageDigest;

/**
 *
 * @author Sandman <sandman.net@gmail.com>
 */
public class Md5 {

    private String original = "";
    private String md5 = "";
    StringBuffer sb = new StringBuffer();

    public Md5(String original) {
        this.original = original;
    }

    public void encode() {
        if (md5 != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(original.getBytes());
                byte[] digest = md.digest();

                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        System.out.println("original:" + original);
        System.out.println("digested(hex):" + sb.toString());
        md5=sb.toString();
    }
    public String getMd5(){
        return md5;
    }
}
