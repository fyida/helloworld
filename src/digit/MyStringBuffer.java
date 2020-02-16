package digit;

public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;
	public MyStringBuffer() {
		value = new char[capacity];
	}
    public MyStringBuffer(String str){
        this();
        if(null==str)
            return;
          
        if(capacity<str.length()){
            capacity  = value.length*2;
            value=new char[capacity];
        }
          
        if(capacity>=str.length())
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
          
        length = str.length();
    }
    public String toString(){
        
        char[] realValue = new char[length];
  
        System.arraycopy(value, 0, realValue, 0, length);
          
        return new String(realValue);
    }
	@Override
	public void append(String str) {
		insert(length,str);
		
	}

	@Override
	public void append(char c) {
		append(String.valueOf(c));
		
	}

	@Override
	public void insert(int pos, char b) {
		insert(pos,String.valueOf(b));
		
	}

	@Override
	public void insert(int pos, String b) {
        if(pos<0)
            return;
          
        if(pos>length)
            return;
          
        if(null==b)
            return;
		
		if((b.length()+length)>capacity) {
			capacity=(b.length()+length)*2;
			char[] newvalue=new char[capacity];
			System.arraycopy(value, 0, newvalue, 0, length);
			value=newvalue;
		}
        char[] cs = b.toCharArray();
        
        //先把已经存在的数据往后移
          
        System.arraycopy(value, pos, value,pos+ cs.length, length-pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
		length+=b.length();

		
	}

	@Override
	public void delete(int start) {
		// TODO 自动生成的方法存根
		delete(start,length);
	}

	@Override
	public void delete(int start, int end) {
        //边界条件判断
        if(start<0)
            return;
         
        if(start>length)
            return;
         
        if(end<0)
            return;
         
        if(end>length)
            return;
         
        if(start>=end)
            return;
        System.arraycopy(value, end, value, start, length-end);
        length-=end-start;
	}

	@Override
	public void reverse() {
		for(int i=0;i<length/2;i++) {
			char temp=value[length-i-1];
			value[length-i-1]=value[i];
			value[i]=temp;
		}
		
	}

	@Override
	public int length() {
		// TODO 自动生成的方法存根
		return length;
	}
    public static void main(String[] args) {
        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);
  
        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.delete(0,4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);
    }
}
