package com.example.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.service.ServiceDaoImpl;
import com.example.util.ExcelGenerator;
import com.example.util.PdfGenerator;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ServiceDaoImpl daoImpl;

	@RequestMapping("/loadform")
	public String viewPage(Model model) {

		Product product = new Product();

		model.addAttribute("pro", product);

		return "product";
	}

	@RequestMapping("/register")
	public String handlerForm(@ModelAttribute("pro") Product product, Model model) {

		// interact with service layer
		int count = daoImpl.insert(product);
		String msg = "";
		if (count != 0) {
			msg = "Inserted Successfully";
		} else {
			msg = " Not Inserted";
		}
		model.addAttribute("msg", msg);
		return "product";
	}

	@RequestMapping("/viewrecords")
	public String viewAll(Model model) {

		List<Product> productsById = daoImpl.getProductsById();
		model.addAttribute("viewAllProducts", productsById);
		return "view";
	}

	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("pId") int pId) {
		daoImpl.deleteProduct(pId);
		return "redirect:/viewrecords";

	}

	@RequestMapping("/edit")
	public String editProduct(int pId, Model model) {
		Product editProduct1 = daoImpl.editProduct(pId);
		model.addAttribute("edit", editProduct1);
		return "editPro";

	}

	@RequestMapping("/update")
	public String updateProduct(@ModelAttribute("product") Product product) {
		daoImpl.updateProduct(product);
		return "redirect:/viewrecords";

	}

	@GetMapping("/export-to-pdf")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=product" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		List<Product> listofProducts = daoImpl.getProductsById();
		PdfGenerator generator = new PdfGenerator();
		generator.generate(listofProducts, response);
	}
	
	@GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=product" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Product> listOfProducts = daoImpl.getProductsById();
        ExcelGenerator generator = new ExcelGenerator(listOfProducts);
        generator.generateExcelFile(response);
    }

}
