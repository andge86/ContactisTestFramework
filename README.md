How to run:

1. Open Terminal/Command line and verify jdk and maven installed:
execute: java -version
execute: mvn -v

If not, please, install.

2. Open Terminal/Command line, go to project folder and execute: 
mvn test
or
mvn test -X

Note:
1. Fully working on macOS. Asserts with polish letters will fail on Windows.
2. Used Thread.sleep(). Better idea is to use WebDriverWait.
