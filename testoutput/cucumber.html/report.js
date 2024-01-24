$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/SimpleForm/form.feature");
formatter.feature({
  "name": "Filling form",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.scenario({
  "name": "To validate firstname,lastname,email,contact functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "open browser \u0026 enter the url",
  "keyword": "Given "
});
formatter.match({
  "location": "simpleform.open_browser_enter_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check url is validated",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.check_url_is_validated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users enter username",
  "keyword": "When "
});
formatter.match({
  "location": "simpleform.users_enter_username()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users enter lastname",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.users_enter_lastname()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users enter email",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.users_enter_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users enter contact",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.users_enter_contact()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users enter message",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.users_enter_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "simpleform.user_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pop-up show thank you for reaching out to us",
  "keyword": "And "
});
formatter.match({
  "location": "simpleform.pop_up_show_thank_you_for_reaching_out_to_us()"
});
formatter.result({
  "error_message": "org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : Thank You for reaching out to us, dipali Sonawane}\n  (Session info: chrome\u003d120.0.6099.225): Thank You for reaching out to us, dipali Sonawane\nBuild info: version: \u00274.16.1\u0027, revision: \u00279b4c83354e\u0027\nSystem info: os.name: \u0027Windows 11\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.9\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCommand: [132549a9e6f0e1237f244341e8fa5edb, findElement {using\u003dxpath, value\u003d//input[@class \u003d \u0027ui green button\u0027]}]\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 120.0.6099.225, chrome: {chromedriverVersion: 120.0.6099.109 (3419140ab66..., userDataDir: C:\\Users\\asus\\AppData\\Local...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:56143}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:56143/devtoo..., se:cdpVersion: 120.0.6099.225, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 132549a9e6f0e1237f244341e8fa5edb\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:131)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:52)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:191)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:200)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:175)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:523)\r\n\tat org.openqa.selenium.remote.ElementLocation$ElementFinder$2.findElement(ElementLocation.java:165)\r\n\tat org.openqa.selenium.remote.ElementLocation.findElement(ElementLocation.java:59)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:354)\r\n\tat formfillup.simpleform.pop_up_show_thank_you_for_reaching_out_to_us(simpleform.java:64)\r\n\tat ✽.pop-up show thank you for reaching out to us(file:src/test/resources/SimpleForm/form.feature:31)\r\n",
  "status": "failed"
});
});