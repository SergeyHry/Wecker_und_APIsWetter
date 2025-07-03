package TestFactory;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherService {
	 private static final String API_KEY = "71905ac5276660b556ee382b6d82e187";
	 private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

	 public static String getWeather(String city) {
		    try {
		        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
		        String url = String.format(BASE_URL, encodedCity, API_KEY);
		        HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		            .uri(URI.create(url))
		            .build();

		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

		        if (json.has("cod") && !json.get("cod").getAsString().equals("200")) {
		            String message = json.has("message") ? json.get("message").getAsString() : "Unbekannter Fehler";
		            return "Wetterdaten nicht gefunden: " + message;
		        }

		        double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
		        int humidity = json.getAsJsonObject("main").get("humidity").getAsInt();
		        String description = json.getAsJsonArray("weather")
		                                 .get(0).getAsJsonObject()
		                                 .get("description").getAsString();

		        return String.format("Temperatur: %.0f°C\nBeschreibung: %s\nLuftfeuchtigkeit: %d%%",
		                              temp, description, humidity);

		    } catch (Exception e) {
		        return "Fehler beim Abrufen des Wetters: " + e.getMessage();
		    }
		}

}