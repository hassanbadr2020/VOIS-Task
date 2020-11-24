$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featureFiles/AccessManagement/login.feature");
formatter.feature({
  "name": "login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I send post request with valid credentials",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ]
    },
    {
      "cells": [
        "\u003cEmail\u003e",
        "\u003cPassword\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "status code is \"422\"",
  "keyword": "Then "
});
formatter.step({
  "name": "response error message is \"The email and password fields are required.\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ]
    },
    {
      "cells": [
        "hassan@badr.com",
        "123456"
      ]
    }
  ]
});
formatter.scenario({
  "name": "login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I send post request with valid credentials",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.MyStepdefs.\u003cinit\u003e(MyStepdefs.java:18)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code is \"422\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.MyStepdefs.\u003cinit\u003e(MyStepdefs.java:27)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response error message is \"The email and password fields are required.\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.MyStepdefs.\u003cinit\u003e(MyStepdefs.java:30)"
});
formatter.result({
  "status": "passed"
});
});