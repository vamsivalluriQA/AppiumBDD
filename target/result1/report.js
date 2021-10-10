$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/batch241/com.mindq.calc/src/test/resources/features/feature1.feature");
formatter.feature({
  "line": 1,
  "name": "calculation",
  "description": "",
  "id": "calculation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1832658,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "validate arithmetic operation",
  "description": "",
  "id": "calculation;validate-arithmetic-operation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "launch app",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "validate operation with given data",
  "rows": [
    {
      "cells": [
        "operation",
        "input1",
        "input2"
      ],
      "line": 5
    },
    {
      "cells": [
        "add",
        "23",
        "34"
      ],
      "line": 6
    },
    {
      "cells": [
        "subtract",
        "23",
        "14"
      ],
      "line": 7
    },
    {
      "cells": [
        "multiply",
        "23",
        "34"
      ],
      "line": 8
    },
    {
      "cells": [
        "divide",
        "21",
        "7"
      ],
      "line": 9
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "close app",
  "keyword": "And "
});
formatter.match({
  "location": "Gluecode.method2()"
});
