package com.cafe.managing;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class ProgramCafe {

	public static void main(String[] args) {
		
		 
		Ticket ticket1 = new Ticket(15291);
		Consommation con1 = new Consommation("ENGLISH CAKE", 1,8.0);
		Consommation con = new Consommation("ENGLISH CAKE", 2,8.0);
//		Consommation con2 = new Consommation("Cafe Italien", 12);
		Consommation con3 = new Consommation("Jus D'orange",2, 15);
		ticket1.addConsommation(con1);
//		ticket1.addConsommation(con2);
		ticket1.addConsommation(con3);
		
		String dte = ticket1.getDateTime().getYear()+"-"+ticket1.getDateTime().getMonthValue()+"-"+ticket1.getDateTime().getDayOfMonth()+" "+ticket1.getDateTime().getHour()+":"+ticket1.getDateTime().getMinute()+":"+ticket1.getDateTime().getSecond();
		/// Affichage de ticket
		String par1 = "                 J'eeron"; 
		String par2 = "Ticket Nm:  \t"+ ticket1.getCode();
		String par3 ="Date :  \t"+dte;
		String par4 ="Terminal :\tcaisse-PC";
		String par5 ="Servi par :\tmarwane";
		String par6 ="Table :\t\tTable 16";
		String par7 ="Article \t\tPrix\tQte\tVleur";
		String par8=null;
		
	  
		System.out.println(""); 
		System.out.println("Article \t\tPrix\tQte\tVleur"); //add la class table
		System.out.println("----------------------------------------------");
		for (Consommation cm : ticket1.getConsommations()) {
			System.out.println(cm.getDesigniation()+"\t\t"+cm.getPrix()+"\tx"+cm.getQte()+"\t"+cm.getPrix()*cm.getQte());
			  par8=" "+cm.getDesigniation()+"   "+cm.getPrix()+" "+cm.getQte()+"  "+cm.getPrix()*cm.getQte();

		}
		System.out.println("----------------------------------------------");
		System.out.println("Nbr Article: " +ticket1.getNbrArticle());
		System.out.println(""); 
		System.out.println("Total \t\t\t\t\t"+ticket1.getTotal()); 
		System.out.println("TOTAL \t\t\t\t\t"+ticket1.getTotal()); 

		System.out.println(""); 
		
		
		  // Creating a PdfWriter       
	      String dest = "C:/testIText/sample1.pdf";       
	      PdfWriter writer=null;
		try {
			writer = new PdfWriter(dest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   
	      // Creating a PdfDocument       
	      PdfDocument pdfDoc = new PdfDocument(writer);              
	      Paragraph paragraph1 = new Paragraph(par1);             
	      Paragraph paragraph2 = new Paragraph(par2);
	      Paragraph paragraph3 = new Paragraph(par3);             
	      Paragraph paragraph4 = new Paragraph(par4);
	      Paragraph paragraph5 = new Paragraph(par5);             
	      Paragraph paragraph6 = new Paragraph(par6);
	      Paragraph paragraph7 = new Paragraph(par7);
	      Paragraph paragraph8 = new Paragraph(par8);

	      // Adding a new page 
	      pdfDoc.addNewPage();               
	   
	      // Creating a Document        
	      Document document = new Document(pdfDoc);               
	      document.add(paragraph1);       
	      document.add(paragraph2);        
	      document.add(paragraph3);       
	      document.add(paragraph4);        
	      document.add(paragraph5);       
	      document.add(paragraph6);        
	      document.add(paragraph7);  
	      document.add(paragraph8);  
	      // Closing the document    
	      document.close();              
	      System.out.println("PDF Created");    
	   }
	 


}
