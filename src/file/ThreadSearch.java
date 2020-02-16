package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThreadSearch extends Thread {
	File file;
	String search;
	public ThreadSearch(String str,String search) {
		file=new File(str);
		this.search=search;
	}
	public void run() {
		try(                
	            FileReader reader = new FileReader(file);
	            BufferedReader br = new BufferedReader(reader);
	            ) {
			while(true) {
                String line = br.readLine();
                if(line==null) {
                    break;
                }
                if(line.contains(search)) {
                    System.out.println("找到子目标字符串:"+search+",在文件:"+file.getAbsolutePath());
                }
			}

	            } catch (IOException e) {
	                e.printStackTrace();
	}
	}
}

