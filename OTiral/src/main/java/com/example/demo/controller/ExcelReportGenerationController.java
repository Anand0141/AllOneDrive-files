package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExcelReportGenerationService;


@RestController
public class ExcelReportGenerationController {

	@Autowired(required=true)
	private ExcelReportGenerationService excelReportGenerationService;

	@GetMapping("/excelReportGeneration")
	public void excelReportGeneration(HttpServletResponse response) throws IOException {
		excelReportGenerationService.downloadTemplate(response);
	}
}
