import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class GtopShopOne {

	public int iFileCount = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GtopShopOne gtopShopOne = new GtopShopOne();
		final File folder = new File("C:\\cleaned member files");
		
		String monthYear = getPreviousMonthYr();
		gtopShopOne.listFilesForFolder(folder, monthYear);
		
		
		
	}

	
	
	public void listFilesForFolder(final File folder, String monthYear) throws IOException {
		
		//String header = "指定年月,拠点コード,部品バイヤーコード(L),部品バイヤーコード(G),部品コモディティコード,部品サプライヤーコード,資材バイヤーコード(L),資材バイヤーコード(G),変動要因コード,区分1,区分2,調達区分コード,通貨コード,影響額累計（＋）,影響額累計（－）";
		//final List<String> charsets = Arrays.asList(SHIFT_JIS, UTF_8);  
		 //FileReader fr = null;
		 //FileWriter fw = null;
		 //Writer out = null;
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry, monthYear);
	        } else {
	        	
	            //System.out.println(fileEntry.getAbsolutePath());
	            
	            
	            String fileName = getFileName(fileEntry.getAbsolutePath(), monthYear);
	            
	            File source = new File(fileEntry.getAbsolutePath());
	            //File destination = new File("C:\\アクセスログ\\アクセスログ管理メンバーリスト"+UUID.randomUUID()+".xls");
	            File destination = new File("C:\\アクセスログ\\アクセスログ管理メンバーリスト.xls");
	            FileUtils.copyFile(source, destination);
	            
	            File macrosource = new File("C:\\GTOP-SHOP1\\ログ編集.xls");
	            File macrodest = new File("C:\\アクセスログ\\ログ編集.xls");
	            FileUtils.copyFile(macrosource, macrodest);
	            iFileCount = iFileCount + 1;
	            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	            System.out.println(iFileCount + "--Start process for " + fileName );
	            System.out.println("...Input  file name .."+fileEntry.getName());
	            System.out.println("...Full path of Input  file name .."+fileEntry.getName());
	            System.out.println("Please run macro and save in C:\\アクセスログ\\ログ編集\\.xls..then type YES or yes");
	            String userInput = myObj.nextLine();  // Read user input
	            if(userInput.equalsIgnoreCase("YES")) {
	            	
	            	System.out.println("do ...");
	            	
	            	File outputsource = new File("C:\\アクセスログ\\ログ編集.xls");
	            	File outputdest = new File("C:\\output\\"+fileName);
	            	FileUtils.copyFile(outputsource, outputdest);
	            	
	            } else {
	            	
	            	System.out.println("Stopped due to invalid input");
	            	System.exit(1);
	            }
	            
	        }
	    }
		
		
	}

	
	public String getFileName(String filepath, String monthYear){
		
		//ArrayList<String> fileNameList = new ArrayList<String>(); 
		String result = "";
		if (filepath.contains("A3A\\アクセスログ管理メンバーリスト＜A3A.xls")) result = "_A3A.xls";                        
		if (filepath.contains("H50\\アクセスログ管理メンバーリスト_H50.xls")) result = "_H50.xls";                       
		if (filepath.contains("H60_NICS\\アクセスログ管理メンバーリスト-NICS1.xls")) result = "_H60_NICS.xls";                 
		if (filepath.contains("H80\\アクセスログ管理メンバーリスト＜H80＞.xls")) result = "_H80.xls";                     
		if (filepath.contains("HC1_2_4_H40\\アクセスログ管理メンバーリスト＜量産＞_HC1_2_4_H40.xls")) result = "_HC1_2_4_H40.xls"; 
		if (filepath.contains("HC2\\アクセスログ管理メンバーリスト-HC2.xls")) result = "_HC2.xls";                        
		if (filepath.contains("HC3\\アクセスログ管理メンバーリスト＜HC3D.xls")) result = "_HC3D.xls";                      
		if (filepath.contains("HC3\\アクセスログ管理メンバーリスト＜HC3E.xls")) result = "_HC3E.xls";                      
		if (filepath.contains("HC3\\アクセスログ管理メンバーリスト＜ＨC3.xls")) result = "_HC3.xls";                       
		if (filepath.contains("HC3_地区購買\\アクセスログ管理メンバーリスト-HC3.xls")) result = "_HC3_地区購買.xls";                
		if (filepath.contains("HC5\\アクセスログ管理メンバーリスト-HC5新.xls")) result = "_HC5新.xls";                      
		if (filepath.contains("HC5\\アクセスログ管理メンバーリスト＜HC5.xls")) result = "_HC5.xls";                       
		if (filepath.contains("HC6\\アクセスログ管理メンバーリスト-HC6.xls")) result = "_HC6.xls";                        
		if (filepath.contains("N14\\アクセスログ管理メンバーリスト(N14-2007.9.14).xls")) result = "_N14_2007.9.14.xls";             
		if (filepath.contains("N14\\アクセスログ管理メンバーリスト＜RN4.xls")) result = "_RN4.xls";                       
		if (filepath.contains("XP0\\アクセスログ管理メンバーリスト＜XP0.xls")) result = "_XP0.xls";
		
		
		result = monthYear + result;
		
		return result;
	}
	
	public static String getPreviousMonthYr(){
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		
		int month = c.get(Calendar.MONTH) + 1; // beware of month indexing from zero
		int year  = c.get(Calendar.YEAR);
		
		String monthYear = new SimpleDateFormat("MMM").format(c.getTime()) + ""+year;
		System.out.println(monthYear);
		//System.out.println(new SimpleDateFormat("MMM").format(c.getTime()));
		
		return  monthYear;
	}
	
	
}
