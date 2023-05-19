package com.example.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.PlanHistoryRepository;
import com.example.Repository.PlansRepository;
import com.example.entity.PlanHistory;
import com.example.entity.PlansEntity;

@Service
public class PlansDaoImpl implements PlanServiceDao {

	@Autowired
	private PlansRepository plansRepository;

	@Autowired
	private PlanHistoryRepository planHistoryRepository;

	public String insert(PlansEntity plan) {

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//		LocalDateTime date = LocalDateTime.now();

		// System.out.println(date);
		plan.setPublishedDate(LocalDateTime.now());
		PlansEntity save1 = plansRepository.save(plan);

		PlanHistory planHistory = new PlanHistory();
		planHistory.setPublishedDate(LocalDateTime.now());
		BeanUtils.copyProperties(save1, planHistory);
		planHistoryRepository.save(planHistory);
		if (save1 != null) {
			return "Successfully Inserted...";
		} else {
			return "Not Inserted,try Again..";
		}

	}

	@Override
	public List<PlansEntity> viewAll() {
		return plansRepository.findAll();
	}

	@Override
	public PlansEntity viewById(int pId) {
		return plansRepository.findById(pId).get();
	}

	public PlansEntity update(PlansEntity plan) {

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//		LocalDateTime date = LocalDateTime.now();
//
//		PlanHistory planHistory = new PlanHistory();
//		
//		plan.setPublishedDate(date);
//		PlansEntity save1 = plansRepository.save(plan);
//
////		planHistory.setPublishedDate(date);
//		BeanUtils.copyProperties(save1, planHistory);
//		
//		planHistoryRepository.save(planHistory);
//		
//		if (save1 != null) {
//			return "Successfully updated...";
//		} else {
//			return "Not Inserted,try Again..";
//		}

		PlanHistory history = new PlanHistory();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
		plan.setPublishedDate(LocalDateTime.now());
		PlansEntity temporaryPlan = plansRepository.save(plan);

		BeanUtils.copyProperties(temporaryPlan, history);
		System.out.println(plan);
		history.setPublishedDate(LocalDateTime.now());
		planHistoryRepository.save(history);
		return plansRepository.save(plan);
	}

	public void delete(int pId) {
		plansRepository.deleteById(pId);
	}

}
