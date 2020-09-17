$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01webAutomate.feature");
formatter.feature({
  "line": 2,
  "name": "Web Automate NDTV Weather Report",
  "description": "",
  "id": "web-automate-ndtv-weather-report",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag1"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Get the details",
  "description": "",
  "id": "web-automate-ndtv-weather-report;get-the-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Launch NDTV web Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Reach the weather section",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Use the \u0027Pin your city\u0027 section, Select Bangalore city",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Store city with temperature information",
  "keyword": "Then "
});
formatter.match({
  "location": "webPage.launch_ndtv_web_page()"
});
formatter.result({
  "duration": 10664030500,
  "status": "passed"
});
formatter.match({
  "location": "webPage.reach_the_weather_section()"
});
formatter.result({
  "duration": 2076035400,
  "status": "passed"
});
formatter.match({
  "location": "webPage.use_the_pin_your_city_section_select_bangalore_city()"
});
formatter.result({
  "duration": 1321471500,
  "status": "passed"
});
formatter.match({
  "location": "webPage.store_city_with_temperature_information()"
});
formatter.result({
  "duration": 1304234000,
  "status": "passed"
});
formatter.uri("02restapiAutomate.feature");
formatter.feature({
  "line": 2,
  "name": "Get value from api call",
  "description": "",
  "id": "get-value-from-api-call",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag2"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "get weather details for City",
  "description": "",
  "id": "get-value-from-api-call;get-weather-details-for-city",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "set api call for weather",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "hit the api call",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "get the responce into object class",
  "keyword": "Then "
});
formatter.match({
  "location": "apiCall.set_api_call_for_weather()"
});
formatter.result({
  "duration": 852759900,
  "status": "passed"
});
formatter.match({
  "location": "apiCall.hit_the_api_call()"
});
formatter.result({
  "duration": 1618445900,
  "status": "passed"
});
formatter.match({
  "location": "apiCall.get_the_responce_into_object_class()"
});
formatter.result({
  "duration": 496100,
  "status": "passed"
});
});