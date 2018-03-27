How to run:

1. Open Terminal/Command line and verify jdk and maven installed:
execute: java -version
and
execute: mvn -v

If not, please, install.

2. Download ContactisTestFramework folder from git.

3. Open Terminal/Command line, go to downloaded project folder (use cd) and execute: 
mvn test
or
mvn test -X


Note:
1. To use web/mobile test run, uncomment required line in config.properties file.
2. Fully working tests on macOS. Asserts with polish letters will fail on Windows.
3. Used Thread.sleep(). Better idea is to use WebDriverWait.
4. Scenario "Client can fill Contact form" is better for testing Feature
