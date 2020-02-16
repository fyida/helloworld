package digit;

import java.util.Arrays;

import java.util.Scanner;

public class Format {
	public String[] sort(String[] strarr) {
		for (int i = 0; i < strarr.length; i++) {
			for (int j = i + 1; j < strarr.length; j++) {
				if (strarr[i].compareToIgnoreCase(strarr[j]) > 0) {
					String temp = strarr[j];
					strarr[j] = strarr[i];
					strarr[i] = temp;
				}
			}
		}
		return strarr;
	}
	public String getString(char[] arr) {
		String str=String.valueOf(getChararr(arr));
		return str;
	}
	public char[] getChararr(char[] arr) {
		int i = 0;
		while (i < arr.length) {
			arr[i] = getChar();
			i++;
		}
		return arr;
	}

	public char getChar() {
		while (true) {
			char j = (char) (48 + (int) (Math.random() * (122 - 48 + 1)));
			if (Character.isDigit(j) || Character.isLetter(j)) {
				return j;
			}
		}
	}

	public static void main(String[] args) {
		char[] chars=new char[5];
		String[] strarr=new String[8];
		Format f=new Format();
		for(int i=0;i<strarr.length;i++) {
			strarr[i]=String.valueOf(f.getChararr(chars));
		}
		System.out.println("Initial string array is:");
		for(String i:strarr) {
			System.out.println(i);
		}
		f.sort(strarr);
		System.out.println("Sorted string array is:");
		for(String i:strarr) {
			System.out.println(i);
		}
//		char[] chararr = new char[3];
//		Format f = new Format();
//		chararr = f.getChararr(chararr);
//		System.out.println("密码是："+Arrays.toString(chararr));
//		char[] guess = new char[3];
//		for (int i = 0; i < chararr.length; i++) {
//			while (true) {
//				char temp = f.getChar();
//				if (temp == chararr[i]) {
//					guess[i] = temp;
//					break;
//				}
//			}
//		}
//		System.out.println("密码是："+Arrays.toString(guess));
		
	}
}
