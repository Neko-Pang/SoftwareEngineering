/**
 * 
 */
package FileHandle;

import java.io.*;
import java.util.Date;


/**
 * @author KaiwenZhou
 * @version 1.0
 * This class is designed for methods of process Text files
 */
public class FileProcess
{

	File processingFile;
	
	/*
	 * set the file which is needed to process
	 * @param name
	 */
	public void setFile(File name)
	{
		processingFile = name;
	}

	/*
	 * get the filename of the file
	 * @return filename
	 */
	public String getName()
	{
		return processingFile.getName();
	}
	
	/*
	 * get the size in KiloByte of File
	 * @return fileSize
	 */
	public double getSize()
	{
		return (processingFile.length()) / 1024;
	}
	/*
	 * get the date of last change of the file
	 * @return lastChange
	 */
	public Date getLastChange()
	{
		Date lastChange = new Date(processingFile.lastModified());
		return lastChange;
	}
	
	
	/*
	 * 
	 */
	public boolean hasFile()
	{
		if (processingFile == null)
			return false;
		else
			return true;
	}
	
	/*
	 * get the content of file
	 * @return content
	 * 
	 */
	public String getContent() throws IOException
	{
		String content = new String();
		String line;
		BufferedReader contentReader = new BufferedReader(new FileReader(processingFile));
		line = contentReader.readLine();
		while (line != null)
		{
			content = content + line + "\n";
			line = contentReader.readLine();
		}
		contentReader.close();
		return content;
	}
	/*
	 * get the number of lines of the file
	 * @return lineNumber
	 */
	public int getLine() throws IOException
	{
		BufferedReader bR = new BufferedReader(new FileReader(processingFile));
		int lineNumber = 0;
		try
		{
			String strLine = bR.readLine();
			while (strLine != null)
			{
				++lineNumber;
				strLine = bR.readLine();
			}
			// bR.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bR.close();
		return lineNumber;
	}
	
	/*
	 * write the content into file
	 * @param content
	 */
	public void writeContent(String content) throws IOException
	{
		FileWriter writeFile = new FileWriter(processingFile);
		writeFile.write(content);
		writeFile.close();
	}
}
