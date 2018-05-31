package consumeWebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//import net.webservicex.GeoIP;
//import net.webservicex.GeoIPService;
//import net.webservicex.GeoIPServiceSoap;

public class MicroserviceInAction {
	static URL url;
	static HttpURLConnection conn;
	static String output;
	static String inputToOtherService;
	static String countryCode;
	static String ipAddress;
	static String CountryName;

	public static void main(String[] args) {
		// consuming of your own web service
		try {
			url = new URL("http://localhost:8090/");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				inputToOtherService = output;
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Fetching IP address from the String and other information
//		StringTokenizer st = new StringTokenizer(inputToOtherService);
//		countryCode = st.nextToken("|");
//		CountryName = st.nextToken("|");
//		ipAddress = st.nextToken("|");
//
//		// Call to SOAP web service with output of your web service---
//		// getting the location of our given IP address
//		String Ipaddress = ipAddress;
//		GeoIPService newGeoIPService = new GeoIPService();
//		GeoIPServiceSoap newGeoIPServiceSoap = newGeoIPService.getGeoIPServiceSoap();
//		GeoIP newGeoIP = newGeoIPServiceSoap.getGeoIP(Ipaddress);
//		System.out.println("Country Name from SOAP Webservice ---" + newGeoIP.getCountryName());
//
//		// Call to REST API --to get all the details of our country
		String url1 = "http://services.groupkt.com/country/get/iso3code/"; // customizing the Url
		countryCode="IND";
		url1 = url1.concat(countryCode);

		try {
			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}