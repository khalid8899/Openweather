$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("facebook.feature");
formatter.feature({
  "line": 2,
  "name": "Ability to create a new record producer and verify assess state",
  "description": "Sign off - (Pending)",
  "id": "ability-to-create-a-new-record-producer-and-verify-assess-state",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 4882308475,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "validate the response through OpenWeather API",
  "description": "",
  "id": "ability-to-create-a-new-record-producer-and-verify-assess-state;validate-the-response-through-openweather-api",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@TC_004"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "Connect to WeatherAPI",
  "keyword": "Given "
});
formatter.match({
  "location": "copystepdefinition6.connectWeatherAPI()"
});
formatter.result({
  "duration": 3391469617,
  "status": "passed"
});
formatter.after({
  "duration": 2386102203,
  "status": "passed"
});
});