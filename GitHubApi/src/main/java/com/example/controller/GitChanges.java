package com.example.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Branches;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
public class GitChanges {

	private static final String GITHUB_API_BASE_URL = "https://api.github.com/";

	@GetMapping("/commits/{owner}/{repo}")
	public void getTotalChanges(@PathVariable String owner, @PathVariable String repo) throws IOException {

		String accessToken = "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";

		// Create an OkHttpClient instance to make HTTP requests
		OkHttpClient client = new OkHttpClient();

		// Construct the URL for the Git API endpoint that returns the repository's
		// commits
		String url = GITHUB_API_BASE_URL + "repos/" + owner + "/" + repo + "/commits";

		// Construct an HTTP request to get the repository's commits
		Request request = new Request.Builder().url(url).header("Authorization", "token " + accessToken).build();

		// Execute the HTTP request and get the response
		Response response = client.newCall(request).execute();

		// If the response was successful, deserialize the JSON response into a list of
		// GitCommit objects
		if (response.isSuccessful()) {
			String responseData = response.body().string();
			JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray();

			for (JsonElement j : jsonArray) {
				JsonObject jsonObject = j.getAsJsonObject();
				String message = jsonObject.get("commit").getAsJsonObject().get("message").getAsString();
				System.out.println(message);
				// System.out.println(j);
			}
			// System.out.println(jsonArray);
//			return jsonArray.size();
		}
		// else {
//			return 0;
//		}
	}

}
