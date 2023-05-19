package com.example.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Data;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfService {

	public byte[] generatePdf(List<Data> data) throws IOException, DocumentException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// create a new document
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		document.open();

		// add the data to the document
		for (Data myData : data) {
			document.add(new Paragraph(myData.getName() + " - " + myData.getAge()));
		}
		document.close();
		return outputStream.toByteArray();
	}

}
