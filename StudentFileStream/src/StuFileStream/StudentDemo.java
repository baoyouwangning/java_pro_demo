package StuFileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDemo {

	public StudentDemo() {	
	}
	
	/*
	 * 接收学生人数，返回一个int型正整数
	 */
	public static int getStuNum() {
		Scanner in = new Scanner(System.in);
		int StuCount = 0;
		
		while(true){
			boolean pass=true;
			try {
				StuCount = in.nextInt();
				if( StuCount <= 0 ) {
					pass=false;
					System.out.print("请输入一个正整数:");
				}
			}
			catch (InputMismatchException e) {
				in.nextLine();
				pass=false;
				System.out.print("请输入一个整数:");
			}
			
			if(pass) {
				in.nextLine();
				break;
			}
		}
		return StuCount;
	}
	
	/*
	 * 截取学生姓名和分数的
	 * 返回一个一行两列的String数组,tokenList[0]为name,tokenList[1]为score
	 */
	public static String[] getTokens(String Str){
	    
	    StringTokenizer st = new StringTokenizer(Str);  //默认根据 " \t\n\r\f" 分割
	    int numTokens = st.countTokens();
	    String[] tokenList = new String[numTokens];
	    int i = 0;
	    while (st.hasMoreTokens()){
	        tokenList[i] = st.nextToken();
	        i++;
	    }
	    return tokenList;
	}
	
	public static void main(String[] args) {
		try {
			String str = "124354asdf";
			int b = Integer.valueOf(str);
		} catch ( NumberFormatException e) {
			
		}
	
		
		File fout = new File("//home//wangning//java//InformationLiteracy//practice_material//fileStream//student");
		
		List<Student> stuList = new ArrayList<Student>();
		Scanner in = new Scanner(System.in);
		int StuCount = 0;
		
		//接收学生个数
		System.out.print("请输入存储学生个数:");
		StuCount = getStuNum();
		
		//接收学生信息
		String stuInfo = null;   //一个包含学生姓名和成绩的字符串
		String[] stuInfoList = null;     //一个包含学生姓名和成绩的String数组
		String name = new String();		//学生姓名
		int score = 0;					//学生成绩
		
		for(int i = 0; i < StuCount; i++) {
			System.out.print("请输入第" + (i+1) + "个学生的姓名和分数(以空格隔开):");
			stuInfo = in.nextLine();
			stuInfo.trim();
			
			stuInfoList = getTokens(stuInfo); //
			
			
		}
		
		
		
		Student sout = new Student(1,"王宁",101);
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fout));
			output.writeObject(sout);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		File fin = new File("//home//wangning//java//InformationLiteracy//practice_material//fileStream//student");
		Student sin = new Student();
		
		ObjectInputStream input = null;
	
		try {
			input = new ObjectInputStream(new FileInputStream(fin));	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sin = (Student) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(sin.toString());
	   
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(sin.getId());
//		System.out.println(sin.getName());
//		System.out.println(sin.getScore());
	}

}
