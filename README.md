# Demo for Junit, Jacoco, and CI


The full-demo branch contains the full demo with junit added to the maven file, jacoco coverage being measured, and CI configured and in place.

Each of these steps can also be found separately in the following branches:

- [snadi/basicjunit](https://github.com/snadi/testdemo/tree/snadi/basicjunit): very basic unit tests configured to run with `mvn test`. This is also the state of the main branch.
- [snadi/jacoco](https://github.com/snadi/testdemo/tree/snadi/jacoco): adding jacoco to the pom.xml file and configuring it to measure coverage whenever `mvn test` is run. See README in that branch for a jacoco tutorial.
- [snadi/basicci](https://github.com/snadi/testdemo/tree/snadi/basicci): adding a very basic github actions workflow file that gets triggered on every push to any branch
