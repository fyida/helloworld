package file;

import java.io.File;



public class SearchFile {
	public static void search(String str,String search) {
		
		File file=new File(str);
		if(file.isFile()) {
			if(file.getName().contains(".java")) {
				ThreadSearch ts = new ThreadSearch(str,search);
			    ts.run();
			}
			
		}else if(file.isDirectory()){
			for(String f:file.list()) {
				search(file.getAbsolutePath()+"/"+f,search);
			}
		}else {
			System.out.println("check your file");
		}
	}
	public static void main(String[] args) {
		search("F:/LOLFolder", "Magic");


	}

}
