package com.example.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Branches;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
public class GitApiRepo {

//	@Value("${git.token}")
//	private static String gitApiToken;

	private static final String GitHub_Api_BASEURL = "https://api.github.com/";
	// private static final String owner = null;

	@PostMapping("/branches")
	public int getBranchCount(@RequestBody Branches gitApiRepo) throws IOException {
		String accessToken = "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";
		OkHttpClient client = new OkHttpClient();
		List<Branches> branches = null;
		int count = 0;
		String url = GitHub_Api_BASEURL + "repos/" + gitApiRepo.getOwner() + "/" + gitApiRepo.getRepo() + "/branches";
		Request request = new Request.Builder().url(url).header("Authorization", "token " + accessToken).build();

		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			String responseData = response.body().string();
			Gson gson = new Gson();
			Type type = new TypeToken<List<Branches>>() {
			}.getType();
			branches = gson.fromJson(responseData, type);
			System.out.println(branches);

			count = branches.size();
			
			// return branches;
		}

		return count;

	}
}
