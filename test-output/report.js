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
  "duration": 9371776200,
  "status": "passed"
});
formatter.match({
  "location": "webPage.reach_the_weather_section()"
});
formatter.result({
  "duration": 963568900,
  "status": "passed"
});
formatter.match({
  "location": "webPage.use_the_pin_your_city_section_select_bangalore_city()"
});
formatter.result({
  "duration": 1682389700,
  "status": "passed"
});
formatter.match({
  "location": "webPage.store_city_with_temperature_information()"
});
formatter.result({
  "duration": 1274021100,
  "status": "passed"
});
});