import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BingRest {
	private final String USER_AGENT = "Mozilla/32.0";

	public static void main(String[] args) throws Exception {

		BingRest http = new BingRest();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		// System.out.println("\nTesting 2 - Send Http POST request");
		// http.sendGet();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://api.microsofttranslator.com/V2/Http.svc/Translate";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine = "How do you do";
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine())!= null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
}
