package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveNote {
	public void removenote(File file) {
		File newfile=new File(file.getParent()+"/removenote-"+file.getName());
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br=new BufferedReader(fr);
				FileWriter fw = new FileWriter(newfile);
				PrintWriter pw = new PrintWriter(fw);
			){
			while(true) {
				String line=br.readLine();
				if(null==line) {
					break;
				}
				char[] all =new char[line.length()];
				all = line.toCharArray();
				if(all[0]=='/'&&all[1]=='/') {
					continue;
				}
				pw.println(line);

			}
			
		} catch ( IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		RemoveNote rn=new RemoveNote();
		File file =new File("f:/LOLFolder/java.txt");
		rn.removenote(file);
	}
}
