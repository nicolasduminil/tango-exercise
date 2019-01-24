# Exercise proposed by Tango Luxembourg

## Abstract

This exercise has been proposed by Tango Luxembourg and aims at verifying some basic Java programming skills of the candidates to developers roles.

This exercise is purely a school case and doesn't reflect, at any point, any real business case.

## Artifacts

* **lu.tango.online-store:shopping-basket:1.0.SNAPSHOT:jar **

## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```
This should display the following output:

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running lu.tango.online_store.tests.TestBroadbandService
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.341 s - in lu.tango.online_store.tests.TestBroadbandService
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.1.1:jar (default-jar) @ shopping-basket ---
[INFO] Building jar: /home/nicolas/shopping-basket/target/shopping-basket.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.1.2.RELEASE:repackage (repackage) @ shopping-basket ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.542 s
[INFO] Finished at: 2019-01-24T16:20:03+01:00
[INFO] ------------------------------------------------------------------------
```

