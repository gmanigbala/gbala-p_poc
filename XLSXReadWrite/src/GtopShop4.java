import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class GtopShop4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GtopShop4 shopMinus2 = new GtopShop4();
		final File folder = new File("D:\\Bala\\NML\\GTOP\\SHOP4\\Without header\\buyer");
		shopMinus2.listFilesForFolder(folder);
		
	}

	
	 private static final String SHIFT_JIS = "Shift-JIS";
	  private static final String UTF_8 = StandardCharsets.UTF_8.name();
	
	  
	public void listFilesForFolder(final File folder) throws IOException {
		
		String header = "指定年月,拠点コード,部品バイヤーコード(L),部品バイヤーコード(G),部品コモディティコード,部品サプライヤーコード,資材バイヤーコード(L),資材バイヤーコード(G),変動要因コード,区分1,区分2,調達区分コード,通貨コード,影響額累計（＋）,影響額累計（－）";
		//final List<String> charsets = Arrays.asList(SHIFT_JIS, UTF_8);  
		 FileReader fr = null;
		 FileWriter fw = null;
		 Writer out = null;
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	            
	            fr = new FileReader("D:\\Bala\\NML\\GTOP\\SHOP4\\Without header\\buyer\\"+fileEntry.getName());
	            //fw = new FileWriter("D:\\Bala\\NML\\GTOP\\SHOP4\\Without header\\buyer\\output\\"+fileEntry.getName());
	            
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
	            		new File("D:\\Bala\\NML\\GTOP\\SHOP4\\Without header\\buyer\\output\\"+fileEntry.getName())), "SJIS"));
	            
	            int i = 0;
	            String str = "";
	            while ((i = fr.read()) != -1) {
	            	
	            	str += (char)i;
	            }
	            
	            //fw.write(header + "\r\n" + str);
	            String str2 = header + "\r\n" + str;
	            //fw.write(new String(str2.getBytes(Charset.forName("UTF-8"))));
	            //fw.write(new String(str2.getBytes("UTF-8")));
	          // String value = new String(str2.getBytes(Charset.forName("SJIS")));
	           out.write(str2);
	            
	            fr.close();
	            out.close();
	            
	            System.out.println(str);
	        }
	    }
	}

	//final File folder = new File("/home/you/Desktop");
	//listFilesForFolder(folder);

}
