package com.geekster.RandomJoke_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class RandomJokeApiApplication {

	public static void main(String[] args) {
		String url="https://api.chucknorris.io/jokes/random";
		HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client= HttpClient.newBuilder().build();

		HttpResponse<String> httpResponse=client.send(request,HttpResponse.BodyHandlers.ofString());

		JSONObject obj=new JSONObject(httpResponse.body());
		System.out.println(httpResponse.statusCode());
		System.out.println(obj);
	}

}
