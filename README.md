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
1. Fully working tests on macOS. Asserts with polish letters will fail on Windows.
2. Used Thread.sleep(). Better idea is to use WebDriverWait.
3. Scenario "Client can fill Contact form" better describes Feature
