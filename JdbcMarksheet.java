import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.*;
import java.util.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
 

public class JdbcMarksheet{
  public static	void main(String args[])
	 {
	try	{

	Class.forName ("oracle.jdbc.driver.OracleDriver"); 

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:Ankush/qwerty@localhost:1521:xe", "system", "qwerty12345");
	Connection conn2 = DriverManager.getConnection("jdbc:oracle:thin:Ankush/qwerty@localhost:1521:xe", "system", "qwerty12345");
    Statement stmt = conn.createStatement();
	Statement stmt2 = conn2.createStatement();

	Document document =	new	Document();

    ResultSet query_set = stmt.executeQuery("SELECT  Code, NAME, Type, Internal, External, Back_Paper, Grade from Ankush.Marksheet ");
	ResultSet query_set2 = stmt2.executeQuery("SELECT  Code, NAME, Type, Internal, External, Back_Paper, Grade from Ankush.Marksheet2 ");
 
	OutputStream outputStream =	
		new	FileOutputStream(new File("D:\\JdbcMarksheetOracle.txt"));
 
		PdfWriter.getInstance(document,	outputStream);
 
		document.open();
		
		Image image	= Image.getInstance("E:\\m21\\cameracamera\\20201117_213223.jpg");
		Image image2 = Image.getInstance("D:\\logo.png");
		Image image3 = Image.getInstance("D:\\AKTU Logo.png");
		Image image4 = Image.getInstance("D:\\sir-apjn.png");

		image.setAbsolutePosition(450f,	610f);
		image.scalePercent(4.1f);

		image2.scalePercent(45f);
		
		image3.scalePercent(1.4f);
		image3.setAbsolutePosition(110f, 750f);

		image4.scalePercent(23f);
		image4.setAbsolutePosition(520f, 750f);


		document.add(image);
		document.add(image2);
		document.add(image3);
		document.add(image4);
 


		Paragraph p0	= new Paragraph("                               ");
		Paragraph p01	= new Paragraph("                               ");
		Paragraph p1	= new Paragraph("Institute Code & Name		:         (002) FET Agra College, Agra");
		Paragraph p2	= new Paragraph("Course Code & Name			:         (04) B.Tech ");
		Paragraph p3	= new Paragraph("Branch Code & Name			:         (10) Computer Science & Engineering");
		Paragraph p4	= new Paragraph("Roll No & Enroll No							:         2000020100016 & 200002010000141");
		Paragraph p5	= new Paragraph("Student Name															:         Ankush Agarwal");
		Paragraph p6	= new Paragraph("Father's Name 									   	:         Shreeniwas Agarwal");

		Paragraph p7	= new Paragraph("Semester                      :            1                                        Even/Odd          :            Odd ");
		Paragraph p8	= new Paragraph("Total Sub                      :            10                                      Theory Sub       :            5");
		Paragraph p9	= new Paragraph("Practical Sub                :            4                                        Marks Obt.        :            660");
		Paragraph p10	= new Paragraph("Result Status                :            CP(0)                                SGPA                :            7.9");

		Paragraph p11	= new Paragraph("Semester                      :            2                                        Even/Odd          :            Even ");
		Paragraph p12	= new Paragraph("Total Sub                      :            10                                      Theory Sub       :            5");
		Paragraph p13	= new Paragraph("Practical Sub                :            4                                        Marks Obt.        :            722");
		Paragraph p14	= new Paragraph("Result Status                :            PASS                                SGPA                :            8.55");


		PdfPTable pdfPTable = new PdfPTable(7);
		float[] columnWidths = { 1.8f, 1.8f, 1.8f, 1.8f, 1.8f, 1.8f, 1.8f }; 

		pdfPTable.setWidths(columnWidths);

		PdfPCell pdfPCellb1 = new PdfPCell(new Paragraph("Code"));
        PdfPCell pdfPCellb2 = new PdfPCell(new Paragraph("Name"));
        PdfPCell pdfPCellb3 = new PdfPCell(new Paragraph("Type"));
        PdfPCell pdfPCellb4 = new PdfPCell(new Paragraph("Internal"));
		PdfPCell pdfPCellb5 = new PdfPCell(new Paragraph("External"));
        PdfPCell pdfPCellb6 = new PdfPCell(new Paragraph("Back Paper"));
        PdfPCell pdfPCellb7 = new PdfPCell(new Paragraph("Grade"));

		pdfPTable.addCell(pdfPCellb1);
        pdfPTable.addCell(pdfPCellb2);
        pdfPTable.addCell(pdfPCellb3);
        pdfPTable.addCell(pdfPCellb4);
		pdfPTable.addCell(pdfPCellb5);
        pdfPTable.addCell(pdfPCellb6);
        pdfPTable.addCell(pdfPCellb7);


		PdfPTable pdfPTable2 = new PdfPTable(7);
		float[] columnWidths2 = { 1.8f, 1.8f, 1.8f, 1.8f, 1.8f, 1.8f, 1.8f }; 

		pdfPTable2.setWidths(columnWidths2);

		PdfPCell pdfPCellb12 = new PdfPCell(new Paragraph("Code"));
        PdfPCell pdfPCellb22 = new PdfPCell(new Paragraph("Name"));
        PdfPCell pdfPCellb32 = new PdfPCell(new Paragraph("Type"));
        PdfPCell pdfPCellb42 = new PdfPCell(new Paragraph("Internal"));
		PdfPCell pdfPCellb52 = new PdfPCell(new Paragraph("External"));
        PdfPCell pdfPCellb62 = new PdfPCell(new Paragraph("Back Paper"));
        PdfPCell pdfPCellb72 = new PdfPCell(new Paragraph("Grade"));

		pdfPTable2.addCell(pdfPCellb12);
        pdfPTable2.addCell(pdfPCellb22);
        pdfPTable2.addCell(pdfPCellb32);
        pdfPTable2.addCell(pdfPCellb42);
		pdfPTable2.addCell(pdfPCellb52);
        pdfPTable2.addCell(pdfPCellb62);
        pdfPTable2.addCell(pdfPCellb72);


        PdfPTable jdbcT = new PdfPTable(7);

        PdfPCell table_cell;
		
		while (query_set.next())
			{
			
					
              String Code = query_set.getString("Code");
              table_cell=new PdfPCell(new Phrase(Code));
              jdbcT.addCell(table_cell);

              String name =query_set.getString("name");
              table_cell=new PdfPCell(new Phrase(name));
              jdbcT.addCell(table_cell);

              String type =query_set.getString("type");
              table_cell=new PdfPCell(new Phrase(type));
              jdbcT.addCell(table_cell);

			  String Internal = query_set.getString("Internal");
              table_cell=new PdfPCell(new Phrase(Internal));
              jdbcT.addCell(table_cell);

              String External =query_set.getString("External");
              table_cell=new PdfPCell(new Phrase(External));
              jdbcT.addCell(table_cell);

              String Back_Paper =query_set.getString("Back_Paper");
              table_cell=new PdfPCell(new Phrase(Back_Paper));
              jdbcT.addCell(table_cell);

			  String Grade =query_set.getString("Grade");
              table_cell=new PdfPCell(new Phrase(Grade));
              jdbcT.addCell(table_cell);

                            
            }

        PdfPTable jdbcT2 = new PdfPTable(7);

        PdfPCell table_cell2;
		
		while (query_set2.next())
			{
			
					
              String Code = query_set2.getString("Code");
              table_cell2=new PdfPCell(new Phrase(Code));
              jdbcT2.addCell(table_cell2);

              String name =query_set2.getString("name");
              table_cell2=new PdfPCell(new Phrase(name));
              jdbcT2.addCell(table_cell2);

              String type =query_set2.getString("type");
              table_cell2=new PdfPCell(new Phrase(type));
              jdbcT2.addCell(table_cell2);

			  String Internal = query_set2.getString("Internal");
              table_cell2=new PdfPCell(new Phrase(Internal));
              jdbcT2.addCell(table_cell2);

              String External =query_set2.getString("External");
              table_cell2=new PdfPCell(new Phrase(External));
              jdbcT2.addCell(table_cell2);

              String Back_Paper =query_set2.getString("Back_Paper");
              table_cell2=new PdfPCell(new Phrase(Back_Paper));
              jdbcT2.addCell(table_cell2);

			  String Grade =query_set2.getString("Grade");
              table_cell2=new PdfPCell(new Phrase(Grade));
              jdbcT2.addCell(table_cell2);

                            
            }

		
        

		document.add(p0);
		document.add(p01);
		document.add(p1);
		document.add(p2);
		document.add(p3);
		document.add(p4);
		document.add(p5);
		document.add(p6);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add(p7);
		document.add(p8);
		document.add(p9);
		document.add(p10);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		
		document.add(pdfPTable);
        document.add(jdbcT);


		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );

		document.add(p11);
		document.add(p12);
		document.add(p13);
		document.add(p14);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );

		document.add(pdfPTable2);
		document.add(jdbcT2);



		document.close();
		outputStream.close();

	}

	
	catch	(Exception e) 
	{
	e.printStackTrace();
	}

	System.out.println("Pdf created successfully.");
 }
}
