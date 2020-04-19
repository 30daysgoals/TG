package stubs;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import commons.Utilities;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class Setupmock {
	public String setupStub(String mockpath, int port,String url, WireMockServer wireMockServer)
	{
		wireMockServer = new WireMockServer(options().dynamicPort());
		System.out.println("Setting up stub");
		String mockserviceurl=null;
		if(!wireMockServer.isRunning()) {
			wireMockServer.resetAll();
			wireMockServer.start();
			int dynamicport=wireMockServer.port();
			WireMock.configureFor("localhost", dynamicport);
			wireMockServer.stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withHeader("Content-Type","application/json").withStatus(200)
							.withBody(Utilities.getResponseBody(mockpath))));
			
			mockserviceurl="localhost:"+dynamicport+url;
		}
		return mockserviceurl;
	}

}
