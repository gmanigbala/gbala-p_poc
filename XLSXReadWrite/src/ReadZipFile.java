import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.*;
 
/**
 * This program reads contents of a ZIP file.
 *
 * @author www.codejava.net
 */
public class ReadZipFile {
 
    private static void read(String zipFilePath) {
        try {
        	
        	zipFilePath = "D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\GEX_WE_QA.ear";
            ZipFile zipFile = new ZipFile(zipFilePath);
 
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
 
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String name = entry.getName();
                long compressedSize = entry.getCompressedSize();
                long normalSize = entry.getSize();
                String type = entry.isDirectory() ? "DIR" : "FILE";
 
                System.out.println(name);
                System.out.format("\t %s - %d - %d\n", type, compressedSize, normalSize);
                
                
                Enumeration<? extends ZipEntry> entries2 = zipFile.entries();
                
                while (entries.hasMoreElements()) {
                	
                }
                if(name.equals("GEXWAR.war")) {
                	ZipEntry entry2 = zipFile.getEntry(name);
                	//while (entry2.nhasMoreElements()) {
                		
                	//}
                }
                
            }
 
            zipFile.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
 
    
    public static void addFileToNsfzJar() {
        Path myFilePath = Paths.get("D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\nsfz.zip");
        String zipFilePath1 = "D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\GEXWAR.zip";
        Path zipFilePath = Paths.get(zipFilePath1);
        try( java.nio.file.FileSystem fs = FileSystems.newFileSystem(zipFilePath, null) ){
            Path fileInsideZipPath = fs.getPath("/nsfz.zip");
            Files.delete( fileInsideZipPath);
            Files.copy(myFilePath, fileInsideZipPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] argv) {
    	
    	addFileToNsfzJar();
    	addFileToGEXWEBWar();
    }
    
    public static void addFileToGEXWEBWar() {
        Path myFilePath = Paths.get("D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\nsfz.zip");
        String zipFilePath1 = "D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\GEXWAR.zip";
        Path zipFilePath = Paths.get(zipFilePath1);
        try( java.nio.file.FileSystem fs = FileSystems.newFileSystem(zipFilePath, null) ){
            Path fileInsideZipPath = fs.getPath("/nsfz.zip");
            Files.delete( fileInsideZipPath);
            Files.copy(myFilePath, fileInsideZipPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void lookupSomethingInZip(InputStream fileInputStream) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        String entryName = "";
        ZipEntry entry = zipInputStream.getNextEntry();
        
        Path myFilePath = Paths.get("d:/Bala/mytextfile.txt");
        while (entry!=null) {
            entryName = entry.getName();
            System.out.println(entryName);
            if (entryName.endsWith("nsfz.zip")) {
                //recur if the entry is a zip file
                lookupSomethingInZip(zipInputStream);
            }
            
            if (entryName.endsWith("FMWEBServiceclass")) {
            	//Files.copy(myFilePath, fileInsideZipPath);
            }
            //Files.copy(myFilePath, fileInsideZipPath);
            //do other operation with the entries..

            entry=zipInputStream.getNextEntry();
        }
    }
    
    public final static int BUF_SIZE = 1024; //can be much bigger, see comment below


    public static void copyFile(FileInputStream fis , File out) throws Exception {
      //FileInputStream fis  = new FileInputStream(in);
      FileOutputStream fos = new FileOutputStream(out);
      try {
        byte[] buf = new byte[BUF_SIZE];
        int i = 0;
        while ((i = fis.read(buf)) != -1) {
            fos.write(buf, 0, i);
        }
      } 
      catch (Exception e) {
        throw e;
      }
      finally {
        if (fis != null) fis.close();
        if (fos != null) fos.close();
      }
    }
    
    public static void main3(String[] args) throws IOException {
    	
    	String zipFilePath = "D:\\Bala\\NML\\GEX_WEB\\GEXEAR\\GEX_WE_QA.ear";
        ZipFile zipFile = new ZipFile(zipFilePath);

        File f = new File("D:\\\\Bala\\\\NML\\\\GEX_WEB\\\\GEXEAR\\\\GEX_WE_QA--1.ear");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        byte[] data = new byte[2048];
        int b = -1;
        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            
            String name = entry.getName();
            System.out.println(name);
            if(name.equals("GEXWAR.war")) {
            	InputStream stream = zipFile.getInputStream(entry);
            	
            	lookupSomethingInZip(stream);
            	
            	 /*int read;
                 byte[] bytes = new byte[1024];
            	 while ((read = stream.read(bytes)) != -1) {
            		 out.write(bytes, 0, read);
                 }*/
            	 
            	//FileInputStream ss = new FileInputStream(new File(stream));
            	//copyFile(ss,  f);
            	
            	/*while ((b = stream.read(data)) != -1)
            	{
            		out.write(data, 0, b);
            	}*/

            }
        }
    }
 
    public static void main1(String[] args) {
        String zipFilePath = "";//args[0];
        read(zipFilePath);
    }
    
    public static void main2(String[] args) {
        String zipFilePath = "";//args[0];
        read(zipFilePath);
    }
}