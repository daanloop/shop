package net.malta.web.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import net.malta.model.DbFile;
import net.malta.model.DbFileImpl;

import org.apache.struts.upload.FormFile;

public class AttachmentUtils {
	public static String[] imageExts = new String[]{".jpg",".gif",".png",".eps",".ai",".svg",".mpg",".psd",".tiff",".tif",".bmp",".TIF"};
	public static boolean isImage(String path){
		for (int l = 0; l < imageExts.length; l++) {
			File file = new File(path);
			if(path.endsWith(imageExts[l]) && !file.getName().startsWith(".")){
				return true;
			}
		}
		return false;
	}
	public static String[] getImageExts() {
		return imageExts;
	}
	public static void setImageExts(String[] imageExts) {
		AttachmentUtils.imageExts = imageExts;
	}
	public static DbFile createDbFileFromFile(File file){
		try {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			DbFile dbFile = new DbFileImpl();
			dbFile.setData(createByteArrayFromInputStream(fileInputStream));
			return dbFile;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
//	public static DbFile createThumnailDbFileFromFile(File file){
//		try {
//			DbFile dbFile = new DbFileImpl();
//			System.err.println("thumnail me "+file.getAbsolutePath());
//			dbFile.setData(ThumnailingUtils.thumnailLogoPortrait(file.getAbsolutePath()));
//			return dbFile;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static DbFile createDbFileFromFormFile(FormFile formFile){

		try {
			InputStream is = formFile.getInputStream();
			DbFile dbFile = new DbFileImpl();
			dbFile.setData(createByteArrayFromInputStream(is));
			return dbFile;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] createByteArrayFromInputStream(InputStream is){
		try {
			BufferedInputStream inBuffer = new BufferedInputStream(is);
			ByteArrayOutputStream faos = new ByteArrayOutputStream();
			BufferedOutputStream outBuffer = new BufferedOutputStream(faos);
			int contents = 0;
			while ((contents = inBuffer.read()) != -1) {
				outBuffer.write(contents);
			}
			outBuffer.flush();
			inBuffer.close();
			outBuffer.close();
			byte[] bytes =faos.toByteArray();
			faos.close();
			return  bytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public static String getSuffix(String fileName) {
	    if (fileName == null)
	        return null;
	    int point = fileName.lastIndexOf(".");
	    if (point != -1) {
	        return fileName.substring(point + 1);
	    }
	    return fileName;
	}
	public static String getPreffix(String fileName) {
	    if (fileName == null)
	        return null;
	    int point = fileName.lastIndexOf(".");
	    if (point != -1) {
	        return fileName.substring(0, point);
	    } 
	    return fileName;
	}

}
