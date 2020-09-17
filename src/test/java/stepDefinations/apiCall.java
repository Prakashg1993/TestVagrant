package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.weatherReport;

import static io.restassured.RestAssured.*;

public class apiCall extends apiInitialze{
public ResponseSpecification requestvalue;
public weatherReport Resp;

	 @Given("^set api call for weather$")
	    public void set_api_call_for_weather() throws Throwable {
	      
	       requestvalue=given().log().all().spec(requestinitializer()).expect().defaultParser(Parser.JSON);
		 
	    }

	    @When("^hit the api call$")
	    public void hit_the_api_call() throws Throwable {
	    	
	    	
	    	Resp=requestvalue.when().get("/data/2.5/weather").as(weatherReport.class);
	    		//JsonPath js=new JsonPath(Resp);	
	   		System.out.println();
	    			
	    }

	    @Then("^get the responce into object class$")
	    public void get_the_responce_into_object_class() throws Throwable {
	    	System.out.println(Resp.getMain().getTemp());
	    	for(int i=0;i<Resp.getWeather().size();i++) {
	    		System.out.println(Resp.getWeather().get(i).getDescription());
	    		System.out.println(Resp.getWeather().get(i).getIcon());
	    		System.out.println(Resp.getWeather().get(i).getId());
	    		System.out.println(Resp.getWeather().get(i).getMain());
	    	}
	    
	    }
}
