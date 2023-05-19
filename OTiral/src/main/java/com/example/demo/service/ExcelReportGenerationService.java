package com.example.demo.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class ExcelReportGenerationService {

	public void downloadTemplate(HttpServletResponse response) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		// logo
		File ff = new ClassPathResource("image/logo.png").getFile();
		BufferedImage bufferImg = ImageIO.read(ff);

		// Convert the image to a byte array
		ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
		ImageIO.write(bufferImg, "png", imgBytes);
		imgBytes.flush();
		byte[] bytes = imgBytes.toByteArray();
		imgBytes.close();

		// First Sheet
		XSSFSheet sheet1 = workbook.createSheet("First");
		writeHeaderLine(sheet1);

		// Add the image to the first sheet
		int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		CreationHelper helper = workbook.getCreationHelper();
		Drawing drawing = sheet1.createDrawingPatriarch();
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(0);
		anchor.setRow1(0);
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize();

		// Write the workbook to a file

		// Create Second sheet
		XSSFSheet sheet2 = workbook.createSheet("Second");
		writeSecondSheet(sheet2);
		
		int pictureIdx1 = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		CreationHelper helper1 = workbook.getCreationHelper();
		Drawing drawing1 = sheet2.createDrawingPatriarch();
		ClientAnchor anchor1 = helper1.createClientAnchor();
		anchor1.setCol1(0);
		anchor1.setRow1(0);
		Picture pict1 = drawing.createPicture(anchor1, pictureIdx1);
		pict1.resize();

		// Create third sheet
		XSSFSheet sheet3 = workbook.createSheet("Third");
		writeSecondSheet(sheet3);
		
		int pictureIdx2 = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		CreationHelper helper2 = workbook.getCreationHelper();
		Drawing drawing2 = sheet3.createDrawingPatriarch();
		ClientAnchor anchor2 = helper2.createClientAnchor();
		anchor2.setCol1(0);
		anchor2.setRow1(0);
		Picture pict2 = drawing.createPicture(anchor2, pictureIdx2);
		pict2.resize();

		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		byte[] outArray = outByteStream.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length);
		response.setHeader("Expires:", "0"); // eliminates browser
		// caching
		response.setHeader("Content-Disposition", "attachment; filename=CustomerDetails.xlsx");
		OutputStream outStream = response.getOutputStream();
		outStream.write(outArray);
		outStream.flush();
	}

	private void writeSecondSheet(XSSFSheet sheet) {

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
		Row row = sheet.getRow(0);
		if (row == null) {
			row = sheet.createRow(0);
		}

		Cell cell = row.createCell(0);
		cell.setCellValue("Heading with Calibri font 18 and Text Color and Background Color");

		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = sheet.getWorkbook().createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setFontHeightInPoints((short) 17);
		style.setFont(font);
		cell.setCellStyle(style);
	}

	private void writeHeaderLine(XSSFSheet sheet) {

		// first row
		Row firstRow = sheet.createRow(0);

		// image
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));

		Cell reportId = firstRow.createCell(10);
		reportId.setCellValue("Report Id");

		Cell reportValue = firstRow.createCell(11);
		reportValue.setCellValue("1111122");

		// second row

		Row secondRow = sheet.createRow(1);
		Cell date = secondRow.createCell(10);
		date.setCellValue("Date");

		Cell dateValue = secondRow.createCell(11);
		dateValue.setCellValue(String.valueOf(LocalDate.now()));

		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 11));
		Row row = sheet.getRow(2);
		if (row == null) {
			row = sheet.createRow(2);
		}

		Cell cell = row.createCell(0);
		cell.setCellValue("Heading with Calibri font 18 and Text Color and Background Color");

		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = sheet.getWorkbook().createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setFontHeightInPoints((short) 17);
		style.setFont(font);
		cell.setCellStyle(style);

		// Header columns

		Row headerRow = sheet.createRow(3);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("CurrentDateMonth");

		CellStyle style1 = sheet.getWorkbook().createCellStyle();
		Font font1 = sheet.getWorkbook().createFont();
		font1.setColor(IndexedColors.BLUE.getIndex());
		font1.setBold(true);
		font1.setFontHeightInPoints((short) 12);
		style1.setFont(font1);
		headerCell.setCellStyle(style1);

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Day Name");

		CellStyle style2 = sheet.getWorkbook().createCellStyle();
		Font font2 = sheet.getWorkbook().createFont();
		font2.setColor(IndexedColors.BLUE.getIndex());
		font2.setBold(true);
		font2.setFontHeightInPoints((short) 12);
		style2.setFont(font2);
		headerCell.setCellStyle(style2);

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Description");
		CellStyle style3 = sheet.getWorkbook().createCellStyle();
		Font font3 = sheet.getWorkbook().createFont();
		font3.setColor(IndexedColors.BLUE.getIndex());
		font3.setBold(true);
		font3.setFontHeightInPoints((short) 12);
		style3.setFont(font3);
		headerCell.setCellStyle(style3);

//		headerCell = headerRow.createCell(3);
//		headerCell.setCellValue("Salary");
//
//		CellStyle style4 = sheet.getWorkbook().createCellStyle();
//		Font font4 = sheet.getWorkbook().createFont();
//		font4.setColor(IndexedColors.BLUE.getIndex());
//		font4.setBold(true);
//		font4.setFontHeightInPoints((short) 12);
//		style4.setFont(font4);
//		headerCell.setCellStyle(style4);

		// values

		LocalDate start = YearMonth.now().atDay(1);
		LocalDate end = YearMonth.now().atEndOfMonth();

		for (int i = start.getDayOfMonth(); i <= end.getDayOfMonth(); i++) {
			LocalDate dates = YearMonth.now().atDay(i);
			System.out.print(dates + "  ");

			DayOfWeek dayNames = dates.getDayOfWeek();
			System.out.print(dayNames + " ");

			System.out.println("Bla Bla..." + i);

			Row row4 = sheet.createRow(i + 3);

			Cell headerCell2 = row4.createCell(0);
			headerCell2.setCellValue("" + dates);
			headerCell2 = row4.createCell(1);
			headerCell2.setCellValue(" "+dayNames);
			headerCell2 = row4.createCell(2);
			headerCell2.setCellValue("BLaa BLaa ..."+i);
			
		}
		// row 6

//		Row row5 = sheet.createRow(5);
//
//		Cell headerCell3 = row5.createCell(0);
//		headerCell3.setCellValue("112");
//		headerCell3 = row5.createCell(1);
//		headerCell3.setCellValue("Dan");
//		headerCell3 = row5.createCell(2);
//		headerCell3.setCellValue("3/13/1982");
//		headerCell3 = row5.createCell(3);
//		headerCell3.setCellValue("58000.18");
//
//		// row 7
//
//		Row row6 = sheet.createRow(6);
//
//		Cell headerCell4 = row6.createCell(0);
//		headerCell4.setCellValue("113");
//		headerCell4 = row6.createCell(1);
//		headerCell4.setCellValue("Milan");
//		headerCell4 = row6.createCell(2);
//		headerCell4.setCellValue("11/24/1980");
//		headerCell4 = row6.createCell(3);
//		headerCell4.setCellValue("51000.45");
//		// row 8
//
//		Row row8 = sheet.createRow(8);
//
//		Cell headerCell5 = row8.createCell(0);
//		headerCell5.setCellValue("");
//		headerCell5 = row8.createCell(1);
//		headerCell5.setCellValue("");
//		headerCell5 = row8.createCell(2);
//		headerCell5.setCellValue("TotalSalary");
//		headerCell5 = row8.createCell(3);
//		// headerCell5.setCellFormula("SUM(D5:D8)");
//		// headerCell5.setCellType(Cell.CELL_TYPE_FORMULA);
//		headerCell5.setCellValue("1,64,000.78");
//
//		// row 9
//		Row row9 = sheet.createRow(9);
//
//		Cell headerCell6 = row9.createCell(0);
//		headerCell6.setCellValue("");
//		headerCell6 = row9.createCell(1);
//		headerCell6.setCellValue("");
//		headerCell6 = row9.createCell(2);
//		headerCell6.setCellValue("Avg Salary");
//		headerCell6 = row9.createCell(3);
//
//		// headerCell6.setCellFormula("=ROUNDUP(D9/3,0)");
//		headerCell6.setCellValue("54667");
	}

}
