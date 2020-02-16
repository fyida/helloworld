package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class EnCode {
	public static void encodeFile(File encodingFile, File encodedFile) {
		if(encodingFile!=null) {
			char[] encodingData = new char[(int) encodingFile.length()];
			try (FileReader fr = new FileReader(encodingFile);){
				fr.read(encodingData);
			} catch ( IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("加密前的内容：");
			for(char c:encodingData) {
				System.out.print(c);
			}
			System.out.println();
			for(int i=0;i<encodingData.length;i++) {
				if('0'<=encodingData[i]&&encodingData[i]<='8') {
					encodingData[i]=(char) (encodingData[i]+1);
				}else if (encodingData[i]=='9' ) {
					encodingData[i]='0';
				}else if('A'<=encodingData[i]&&encodingData[i]<='Y') {
					encodingData[i]=(char) (encodingData[i]+1);
				}else if(encodingData[i]==90) {
					encodingData[i]='A';
				}else if('a'<=encodingData[i]&&encodingData[i]<='y') {
					encodingData[i]=(char) (encodingData[i]+1);
				}else if(encodingData[i]=='z') {
					encodingData[i]='a';
				}
			}
			
			try(FileWriter fw =new FileWriter(encodedFile);) {
				fw.write(encodingData);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("加密后的内容：");
			for(char c:encodingData) {
				System.out.print(c);
			}
			System.out.println();
			System.out.println("加密完成");
		}
	}
	public static void main(String[] args) {
		File encodingFile=new File("f:/LOLFolder/char.txt");
		File encodedFile=new File("f:/LOLFolder/chared.txt");
		encodeFile(encodingFile, encodedFile);
		System.out.println("默认编码方式:"+Charset.defaultCharset());
	}

}
