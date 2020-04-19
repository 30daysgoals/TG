package test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;

import stubs.Setupmock;

public class Setupmock_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Setupmock mock = new Setupmock();
		WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
		String mockserviceurl=mock.setupStub("./resources_test/stub_files/schemar.json", 8092, "/fetchuser", wireMockServer);
		System.out.println("Mock service endpoint is : "+mockserviceurl);

	}

}
