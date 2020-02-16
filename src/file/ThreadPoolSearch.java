package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadPoolSearch {
	public static void search(String str,String search,ThreadPoolExecutor tpe) {
		
		File file=new File(str);
		if(file.isFile()) {
			if(file.getName().contains(".java")) {
				tpe.execute(new Runnable() {
					
					@Override
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
				});
			}
			
		}else if(file.isDirectory()){
			for(String f:file.list()) {
				search(file.getAbsolutePath()+"/"+f,search,tpe);
			}
		}else {
			System.out.println("check your file");
		}
	}
	public static void main(String[] args) {
		
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 15, 60,
	            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		search("F:/LOLFolder", "Magic",tpe);

	}

}
