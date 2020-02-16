package file;
  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
  
public class TestFile {
	static long min = 10000;
	static long max =0;
	static File minfile=new File("null");
	static File maxfile=new File("null");
	static void listfiles(File file) {
		if(file.isDirectory()) {
			File[] fs =file.listFiles();
			if(fs!=null) {
				for(File f:fs) {
					listfiles(f);
				}
			}

			
		}else if(file.isFile()) {
			if(file.length()>max) {
				max=file.length();
				maxfile=file;
			}
			if(file.length()<min&&file.length()!=0) {
				min=file.length();
				minfile=file;
			}
		}
	}
	public static void splitFile(File file,int size) throws FileNotFoundException {
		if(file.length() == 0)
            throw new RuntimeException("文件长度为零");
        FileInputStream fis =new FileInputStream(file);
        byte[] fileData=new byte[(int) file.length()];
        try {
			fis.read(fileData);
			fis.close();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
        int max=(int) Math.ceil(file.length()*1.0/size);
        System.out.println("文件大小为："+file.length());
        System.out.println("文件数为："+max);
        for(int i=0;i<max;i++) {
        	try{
        		FileOutputStream fos= new FileOutputStream(file.getAbsolutePath()+"-"+i);
        		if(i==max-1) {
        			fos.write(fileData,i * size,fileData.length - i * size);
        		}else{
        			fos.write(fileData,i*size,size);
        		}
        	}catch(IOException e) {
        		e.printStackTrace();}
        }
	}
	public static void merge(File file) throws IOException {
		if(file.isDirectory()) {
			File[] fs = file.listFiles();
			int length =0;
			int flag =0;
			for(File f:fs) {
				length+=f.length();
			}
			byte[] wantData=new byte[length];
			File want = new File(fs[0].getParent()+"/merged-"+fs[0].getName());
			for(int i=0;i<fs.length;i++) {
				FileInputStream fis = new FileInputStream(fs[i]);
				byte[] fileData=new byte[(int) fs[i].length()];
				fis.read(fileData);
				System.arraycopy(fileData, 0, wantData, flag, fileData.length);
				flag+=fileData.length;
				fis.close();
			}
			FileOutputStream fos =new FileOutputStream(want);
			fos.write(wantData);
			fos.close();
			System.out.println("合并完成，文件名为："+"merged-"+fs[0].getName());
		}else {
			System.out.println("请输入要合并的文件所在的文件夹路径");
		}
	}
    public static void main(String[] args) throws IOException {
  
        File f = new File("F:\\LOLFolder");
        //splitFile(f,1024 * 1024);
        merge(f);

    }
}