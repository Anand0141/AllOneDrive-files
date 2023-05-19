 package com.ojas.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;
import com.ojas.model.Product;
import com.ojas.service.impl.ProductServiceImpl;
import com.ojas.util.ExcelGenerator;
import com.ojas.util.PdfGenerator;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl daoService;
	
	//load the form
	@RequestMapping("/loadForm")
	public String loadForm(Model model)
	{
		Product productInfo=new Product();
		
		model.addAttribute("product", productInfo);
		
		
		return "product_dtls";
	}
	
	@RequestMapping("/register")
	public String handleForm(@ModelAttribute("product")   Product pro,Model model)
	{
		//interact with service layer
		int count = daoService.addProduct(pro);
		String msg="";
		if(count!=0)
			msg="Registred SuccessFully";
			else
				msg="Registred Not SuccessFully";
		model.addAttribute("msg", msg);
		return "product_dtls";
	}
	
	@RequestMapping("/viewrecords")
	public String viewAll(Model model)
	{
		List<Product> viewProducts = daoService.viewProducts();
		model.addAttribute("listProducts", viewProducts);
		return "view";
	}
	
	
	
	
	@GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=product" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Product> listOfProducts = daoService.viewProducts();
        ExcelGenerator generator = new ExcelGenerator(listOfProducts);
        generator.generateExcelFile(response);
    }
	
	@GetMapping("/export-to-pdf")
	  public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException 
	  {
	    response.setContentType("application/pdf");
	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=product" + currentDateTime + ".pdf";
	    response.setHeader(headerkey, headervalue);
	    List < Product > listofStudents = daoService.viewProducts();
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(listofStudents, response);
	  }
	
	
	
	
	
	
}
