package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Createclass {
	public static void createclass(String lei,String type,String property,File file) {
		File format=new File("f:/LOLFolder/java.txt");
		try (
				FileReader fr=new FileReader(format);
				BufferedReader br=new BufferedReader(fr);
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
			){
			while(true) {
				String line =br.readLine();
				if(line==null) {
					break;
				}
				line=line.replace("@class@", lei);
				line=line.replace("@type@", type);
				line=line.replace("@property@", property);
				bw.write(line);
				bw.newLine();
			}
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入类的名称：");
		String lei=sc.nextLine();
		System.out.println("请输入类型的名称：");
		String type =sc.nextLine();
		System.out.println("请输入属性的名称：");
		String property = sc.nextLine();
		sc.close();
		File file=new File("f:/LOLFolder/newclass.java");
		createclass(lei,type,property,file);
	}

}
