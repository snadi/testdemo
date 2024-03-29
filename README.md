# Demo for Junit, Jacoco, and CI

![Coverage](.github/badges/jacoco.svg) ![Branches](.github/badges/branches.svg)

The main branch contains the full demo with junit added to the maven file, jacoco coverage being measured, and CI configured with measuring coverage and producing a badge. Additionally, in the main branch, the CI is also configured to measure mutation coverage only on PRs and fail if it is less than 80% mutation score.

Some of these individual steps can also be found separately in the following branches:

- [snadi/basicjunit](https://github.com/snadi/testdemo/tree/snadi/basicjunit): very basic unit tests configured to run with `mvn test`.
- [snadi/jacoco](https://github.com/snadi/testdemo/tree/snadi/jacoco): adding jacoco to the pom.xml file and configuring it to measure coverage whenever `mvn test` is run. The README in that branch has a jacoco tutorial explaining where to find the jacoco report.
- [snadi/pitest](https://github.com/snadi/testdemo/tree/snadi/pitest): configures pitest. The README in that branch explains how to configure and run pitest with maven.
- [snadi/basicci](https://github.com/snadi/testdemo/tree/snadi/basicci): adding a very basic github actions workflow file that gets triggered on every push to any branch.
- [snadi/cievents](https://github.com/snadi/testdemo/tree/snadi/ci-events): changes github actions workflow to be triggered on every push to main and any Pull Request.
- [snadi/javamatrix](https://github.com/snadi/testdemo/tree/snadi/javamatrix): shows how to configure a workflow to run on multiple java versions (using a matrix setup for the job). This is not currently integrated in main. See [PR](https://github.com/snadi/testdemo/pulls) for how several checks get triggered.
