
# <p align="center">Automated API tests for [REQRES.IN](https://reqres.in)</p>

<p align="center" ><a href="https://reqres.in">
<img width=60% title="REQRES.IN" src="media/images/reqres-logo.jpg">
</a></p>

# :link: Contents
- [Tools and Istruments](#wrench-tools-and-instruments)
- [How to run the automated tests](#gear-running-the-api-tests)
- - [Local](#computer-local-test-run)
- - [Using Jenkins](#img-width3-titlejenkins-srcmediaimagesjenkins-logosvg-remote-with-jenkins)
- [Allure TestOps](#img-width3-titleallure-testops-srcmediaimagesallure-testops-logosvg-allure-testops-integration)
- [Allure Reports](#img-width3-titleallure-reports-srcmediaimagesallure-report-logosvg-allure-reports-integration)
- [Test Results](#ledger-test-results)
- - [Report](#example-of-a-test-run-report)
- - [Telegram](#img-width3-titletelegram-srcmediaimagestelegram-logosvg-telegram-test-result-notification)
- [Jira](#img-width4-titlejira-srcmediaimagesjira-logosvgjira-integration)


# 	:wrench: Tools and Instruments

<p  align="center">
  <code><img width="6%" title="IntelliJ IDEA" src="media/images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="media/images/java-logo.svg"></code>
  <code><img width="6%" title="Selenide" src="media/images/restAssured-logo.png"></code>
  <code><img width="5%" title="Gradle" src="media/images/gradle-logo.svg "></code>
  <code><img width="5%" title="JUnit5" src="media/images/junit5-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="media/images/jenkins-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="media/images/allure-report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="media/images/allure-testOps-logo.svg"></code>
  <code><img width="5%" title="Jira" src="media/images/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="media/images/telegram-logo.svg"></code>
</p>

# Example of API automation test

- [x] <code>GET</code> single user data list
- [x] Testing <code>DELETE</code> a user
- [x] Unsuccessful user registration with <code>POST</code>
- [x] Method <code>GET</code> for resource list
- [x] Testing for <code>Status Codes</code>

# :gear: Running the API tests

## :computer: Local Test Run

To run the API tests locally:
```bash
gradle clean test
```

## <img width="3%" title="Jenkins" src="media/images/jenkins-logo.svg"> Remote with [Jenkins](https://jenkins.autotests.cloud/job/C23-mikenvico-reqresApiTests/)


<p align="center">
<img src="media/images/jenkins_autotests_cloud-status.png" alt="Run Test" width="80%">
</p>

### How to run the remote API tests in Jenkins

>To run this test through Jenkins, press button :arrow_forward:<code>Build Now</code>.\
You can see the results via Allure Reports, or use the link to Allure TestOps on the same page.
<p align="center">
<img src="media/images/jenkins_autotests_cloud-run_test.png" alt="Run Test" width="60%">
</p>


## [<img width="3%" title="Allure TestOps" src="media/images/allure-testOps-logo.svg">Allure TestOps](https://allure.autotests.cloud/project/4070/dashboards) Integration

### Dashboard

<p align="center">
<img src="media/images/allure_autotests_cloud-overview.png" alt="Allure TestOps Dashboard" width="80%">
</p>

---

### Test Cases

<p align="center">
<img src="media/images/allure_reports-report.png" alt="Allure TestOps Test Cases" width="80%">
</p>

---

### Launches

 <p align="center">
 <img src="media/images/allure_autotests_cloud-launches_live.png" alt="Allure TestOps Launches" width="80%">
 </p>


## [<img width="3%" title="Allure Reports" src="media/images/allure-report-logo.svg">Allure Reports](https://jenkins.autotests.cloud/job/C23-mikenvico-visitacityTests/allure/) Integration

### Local Allure Overview

<p align="center">
<img src="media/images/allure_locale-overview.png" alt="Allure Reports Overview" width="80%">
</p>

---

### Jenkins Allure Overview

<p align="center">
<img src="media/images/allure_reports-overview.png" alt="Allure Reports Overview" width="80%">
</p>

---

### Graphs

<p align="center">
<img src="media/images/allure_reports-graphs.png" alt="Allure Reports Overview" width="80%">
</p>

## :ledger: Test Results

---

### Example of a Test Run report

> This page presents the standard distribution of the tests run by user stories and test suites.
> 
<p align="center">
<img src="media/images/allure_reports-report.png" alt="Allure Test Result" width="80%">
</p>

>Extra addon .ftl files fot easier user reading mode.

<p align="center">
<img src="media/images/allure_reports-ftl_css.png" alt="Test content display" width="80%">
</p>

---

### <img width="3%" title="Telegram" src="media/images/telegram-logo.svg"> Telegram test result notification

> After tests are finished Telegram Bot sends test result notification.

<p align="center">
<img src="media/images/telegram-report.png" alt="Telegram Notification" width="60%">
</p>

---

## <img width="4%" title="Jira" src="media/images/jira-logo.svg">Jira Integration

<p align="center">
<img src="media/images/jira_autotests_cloud-Todo.png" alt="Jira" width="80%">
</p>
