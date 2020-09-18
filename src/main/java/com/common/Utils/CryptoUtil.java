package com.common.Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

/**
 * 密码明文加密
 * Created by Zhouxin on 2020/9/18;
 */
public class CryptoUtil {

    public static Key DEFAULT_KEY = null;
    public static final String DEFAULT_SECRET_KEY = "1qaz2wsx3edc$RFV%TGB^YHN&UJM";
    public static final String DES = "DES";
    static {
        DEFAULT_KEY = obtainKey(DEFAULT_SECRET_KEY);
    }


    /**
     * 获得key
     **/
    public static Key obtainKey(String key) {
        if (key == null) {
            return DEFAULT_KEY;
        }
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance(DES);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        generator.init(new SecureRandom(key.getBytes()));
        Key key1 = generator.generateKey();
        generator = null;
        return key1;
    }


    /**
     * 加密<br>
     * String明文输入,String密文输出
     */
    public static String encode(String str) {
        return encode(null, str);
    }

    /**
     * 带key加密<br>
     * String明文输入,String密文输出
     */
    public static String encode(String key, String str) {
        return Base64.encodeBase64URLSafeString(obtainEncode(key, str.getBytes()));
        // return Hex.encodeHexString(obtainEncode(key, str.getBytes()));
        // 可以转化为16进制数据
    }


    /**
     * 解密<br>
     * 以String密文输入,String明文输出
     */
    public static String decode(String str) {
        return decode(null, str);
    }


    /**
     * 带key解密<br>
     * 以String密文输入,String明文输出
     */
    public static String decode(String key, String str) {
        return new String(obtainDecode(key, Base64.decodeBase64(str)));
        // 可以转化为16进制的数据
//      try {
//          return new String(obtainDecode(key, Hex.decodeHex(str.toCharArray())));
//      } catch (DecoderException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//      }
    }


    /**
     * 加密<br>
     * 以byte[]明文输入,byte[]密文输出
     */
    private static byte[] obtainEncode(String key, byte[] str) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            Key key1 = obtainKey(key);
            cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.ENCRYPT_MODE, key1);
            byteFina = cipher.doFinal(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    /**
     * 解密<br>
     * 以byte[]密文输入,以byte[]明文输出
     */
    private static byte[] obtainDecode(String key, byte[] str) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            Key key1 = obtainKey(key);
            cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.DECRYPT_MODE, key1);
            byteFina = cipher.doFinal(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    //public static void main(String[] args) {
        /*调用CryptoUtil.encode()加密
        调用CryptoUtil.decode()解密
        key可以不使用，使用时直接加到encode(a,key)和decode(a,key)参数里
        DEFAULT_SECRET_KEY的"^"符号后的值不同，加密后的密文不同
        可能出现的问题：有线上线下密文不一致问题，
        原因是：Base64加密，会有linux和Windows环境密文不同的问题。window默认编码GBK(gb2312)，Linux默认可能UTFlinux支持UTF8，所以你要添加BGK支持。
        解决方案：String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组。所以给以上代码中getBytes(''UTF-8'')或者getBytes("GBK")
        */
//        String a = "123456789";
//        String key = "lfzn";
//        System.out.println("加密前的密码："+a);
//        System.out.println("加密前的key:"+key);
//        System.out.println("-----------------------------------");
//        String m1 = encode(a);
//        String m2 = encode(key,a);
//        System.out.println("普通加密："+m1);
//        System.out.println("通过key加密:"+m2);
//        System.out.println("-----------------------------------");
//        String n1 = decode(m1);
//        String n2 = decode(key,m2);
//        System.out.println("普通解密："+n1);
//        System.out.println("通过key解密:"+n2);
    //}
}