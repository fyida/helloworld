package digit;
   
public class TestString {
	public static String firstLetterUP(String str) {
		char str0=str.charAt(0);
		char newstr0=Character.toUpperCase(str0);
		String strup=str.replaceFirst(String.valueOf(str0), String.valueOf(newstr0));
		return strup;
	}
	public static String DaXiao(String str) {
		char strarr[]=str.toCharArray();
		for(int i=0;i<strarr.length;i+=2) {
			strarr[i]=(char)(strarr[i]-32);
		}
		
		return String.valueOf(strarr);
	}
    public static void main(String[] args) {
    	/*
//      1.给出一句英文句子： "let there be light"
//      得到一个新的字符串，每个单词的首字母都转换为大写
    	String sentence = "let there be light";
    	
    	//根据,进行分割，得到3个子字符串
    	String subSentences[] = sentence.split(" ");
    	for (String sub : subSentences) {
			System.out.print(firstLetterUP(sub)+" ");
		}
    	System.out.println();
//      2.英文绕口令
//      peter piper picked a peck of pickled peppers
//      统计这段绕口令有多少个以p开头的单词
    	String sentence1 = "peter piper picked a peck of pickled peppers";
    	String subSentences1[] = sentence1.split(" ");
    	int m=0;
    	for (String sub : subSentences1) {
			if(sub.indexOf("p")==0){
				m++;
			}
		}
    	System.out.println(m);
//      3.练习-间隔大写小写模式
//      把 lengendary 改成间隔大写小写模式，即 LeNgEnDaRy
    	String sentence2 = "legengary";
    	System.out.println(sentence2);
    	System.out.println(DaXiao(sentence2));
//      4.练习-把最后一个two单词首字母大写
//      Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak
//      把最后一个two单词首字母大写	
    	String str_4="Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
//      思路：找到two最后一次的索引，以这个索引分隔，然后将two在最后一次出现的字串用replace替换
//      str_4.substring(index).replace("two", "Two")
        int index=str_4.lastIndexOf("two");
        str_4=str_4.substring(0,index)+str_4.substring(index,index+1).toUpperCase()+str_4.substring(index+1);
        String str_5=str_4.substring(0,index)+str_4.substring(index).replace("two", "Two");
        System.out.println(str_4);  
        System.out.println(str_5);
//        创建一个长度是100的字符串数组
//        使用长度是2的随机字符填充该字符串数组
//        统计这个字符串数组里重复的字符串有多少种
        Format f=new Format();
//        String[] strarr=new String[] {"12","12","2","12","3","4","12","2"};
        String[] strarr=new String[100];
        char[] chars=new char[2];
		for(int i=0;i<strarr.length;i++) {
			strarr[i]=String.valueOf(f.getChararr(chars));
		}
		for(int i=0;i<strarr.length;i++ ) {
			if(i%25==0)
				System.out.println();
			System.out.print(strarr[i]+  " ");
		}
        System.out.println();
        System.out.print("重复的字符串有:");
        int count=0;
        String[] pass=new String[100];
		for(int i=0;i<strarr.length;i++) {
			for(int j=i+1;j<strarr.length;j++){
				if(strarr[i].equals(strarr[j])) {
					int flag=0;
					for(int n=0;n<pass.length;n++) {
						if(strarr[i].equals(pass[n])) {
							flag=1;
							break;
						}
					}
					if(flag==0) {
						pass[count]=strarr[i];
						count++;
						System.out.print(strarr[i]+" ");
					}

					break;
				}
			}
		}
		
//		append追加
//		delete 删除
//		insert 插入
//		reverse 反转
		System.out.println();
		System.out.println(count);
        String str1 = "let there ";
        
        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
        sb.append("be light"); //在最后追加
         
        System.out.println(sb);
         
        sb.delete(4, 10);//删除4-10之间的字符
         
        System.out.println(sb);
         
        sb.insert(4, "there ");//在4这个位置插入 there
         
        System.out.println(sb);
         
        sb.reverse(); //反转
         
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        */
    	
    
    char[] chars =new char[5];
    Format F=new Format();
    String str="";
    long starttime=System.currentTimeMillis();
    for(int i =0;i<10000;i++) {
    	str+=F.getString(chars);
    }
    long endtime=System.currentTimeMillis();
    long spendtime=endtime-starttime;
    System.out.println("先使用String的+,连接10000个随机字符串,消耗的时间为："+spendtime+"毫秒");
    StringBuffer strb=new StringBuffer();
    starttime=System.currentTimeMillis();
    for(int i =0;i<1000000;i++) {
    	strb.append(F.getString(chars));
    }
    endtime=System.currentTimeMillis();
    spendtime=endtime-starttime;
    System.out.println("使用StringBuffer,连接1000000个随机字符串,消耗的时间为："+spendtime+"毫秒");
    MyStringBuffer mystrb = new MyStringBuffer();
    starttime=System.currentTimeMillis();
    for(int i =0;i<1000000;i++) {
    	mystrb.append(F.getString(chars));
    }
    endtime=System.currentTimeMillis();
    spendtime=endtime-starttime;
    System.out.println("使用myStringBuffer,连接100000个随机字符串,消耗的时间为："+spendtime+"毫秒");
    }
    
}
