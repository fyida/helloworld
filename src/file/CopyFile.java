package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void copyFile(String srcFile, String destFile) {
		File src = new File(srcFile);
		File dest = new File(destFile);
		if (dest.getParentFile().exists()) {
		} else {
			dest.getParentFile().mkdirs();
		}
		if (src.isFile()) {

			try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(dest)) {
				byte[] all = new byte[(int) src.length()];
				fis.read(all);
				fos.write(all);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else if(src.isDirectory()){
			String[] list=src.list();
			for(String str:list) {
				copyFile(srcFile+"/"+str, destFile+"/"+str);
			}
		}else {
			System.out.println("原文件不存在!");
		}

	}

	public static void main(String[] args) {
		copyFile("F:/LOLFolder", "F:/CFFolder");

	}

}
