import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.testng.annotations.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

public class BingRest {
	private static final int timeOut = 10000;
	private static final String service = "/v2/OAuth2-13/";
	private static final String server = "datamarket.accesscontrol.windows.net";
	private static final String clientId = "TranslatorBing1";
	private static final String clientSecret = "rgLFKkt0euCi3Q+3lsdlqHC2Sv5sETEqhNo8LO+wDNc=";
	private static final String scope = "http://api.microsofttranslator.com";
	private static final String grantType = "client_credentials";

	private final String USER_AGENT = "Mozilla/32.0";

	@Test
	public static void StartTranslate() throws Exception {

		BingRest http = new BingRest();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		// System.out.println("\nTesting 2 - Send Http POST request");
		// http.sendGet();

	}

	private static UrlEncodedFormEntity getOauthBody() throws Exception {
		List<NameValuePair> nameValuePairs = Lists.newArrayListWithCapacity(4);
		nameValuePairs.add(new BasicNameValuePair("client_id", clientId));
		nameValuePairs
				.add(new BasicNameValuePair("client_secret", clientSecret));
		nameValuePairs.add(new BasicNameValuePair("scope", scope));
		nameValuePairs.add(new BasicNameValuePair("grant_type", grantType));
		return new UrlEncodedFormEntity(nameValuePairs);
	}

	private static String token = null;

	// HTTP GET request
	private void sendGet() throws Exception {
		String text = "Hello World!", from = "English", to = "French";
		// String url =
		// "http://api.microsofttranslator.com/V2/Http.svc/Translate";
		String url = "http://api.microsofttranslator.com/v2/Http.svc/Translate?text="
				+ text + "&from=" + from + "&to=" + to;
		String authToken = "Bearer" + " " + token;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		// optional default is GET
		con.setRequestMethod("GET");

		String token = "";
		try {
			// request to get token
			final HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, timeOut);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost post = new HttpPost(
					new URI("https", server, service, null));
			post.setEntity(getOauthBody());

			// response contianing token
			HttpResponse response = client.execute(post);
			InputStreamReader reader = new InputStreamReader(response
					.getEntity().getContent(), Charsets.UTF_8);
			String responseBody = CharStreams.toString(reader);
			token = (new org.json.JSONObject(responseBody))
					.getString("access_token");
			//Displaying the received token
			System.out.println("Token in method def: " + token);
		} catch (Exception e) {
			System.out.println(String.format(
					"Error processing oauth token:\n%s", e.toString()));
			e.printStackTrace();
		}

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		con.setRequestProperty("Authorization", authToken);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine = "How do you do";
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
}
