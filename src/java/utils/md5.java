
package utils;

import java.security.MessageDigest;

public abstract class md5 {
    
    public static String toMd5(String input)
    {
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte byteData[] = md.digest();
 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++)
            {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
