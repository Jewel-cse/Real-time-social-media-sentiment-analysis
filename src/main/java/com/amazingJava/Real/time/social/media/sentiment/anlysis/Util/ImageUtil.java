package com.amazingJava.Real.time.social.media.sentiment.anlysis.Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {
    public static byte[] compressImage(byte[] data){
        Deflater deflater = new Deflater();
        deflater.setLevel(deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        try
        {
            byte[] tmp = new byte[4*1024];
            while (!deflater.finished()){
                int size = deflater.deflate(tmp);
                outputStream.write(tmp,0,size);
            }
            outputStream.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return outputStream.toByteArray();
    }

    public static byte[]decompressImage(byte[]data){
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try
        {
            while (!inflater.finished()){
                int count = inflater.inflate(tmp);
                outputStream.write(tmp,0,count);
            }
            outputStream.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return outputStream.toByteArray();
    }
}
