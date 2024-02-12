# JaCoCo Maven Tutorial

## Setting up JaCoCo 

To use [JaCoCo](https://www.jacoco.org/jacoco/trunk/index.html), we need to make some changes to our pom.xml file to (1) a dependency and (2) configure it to measure coverage and produce a report when we run `mvn test`.

1. Add it as a dependency. If the `<dependencies>` section already has elements in it, just append add to that section. Make sure to change the version if needed.

```xml
...
<dependencies>
	<dependency>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.11</version>
   </dependency>
</dependencies>
```

2. Add the code coverage report generation step to the `<build>` part of your pom.xml. The first execution initializes the jacoco agent and the second execution triggers the report goal of jacoco during the mvn test phase.

```xml
<build>
...
    <plugins>
      <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.11</version>
        <executions>
          <execution>
            <id>jacoco-initialize</id>
            <goals>
              <goal>prepare-agent</goal>
            </goals>
          </execution>
          <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
              <goal>report</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
...
</build>
```

That's it! Running the `mvn test` command should generate reports in an `index.html` file in the `target/site/jacoco/` directory.

## Seeing coverage results in Visual Studio

You can install the [Coverage Gutters VS Code Extension](https://marketplace.visualstudio.com/items?itemName=ryanluker.vscode-coverage-gutters) and enable watch on the bottom left corner of VS code. This extension will use the results of jacoco to highlight covered code in green and missed code in red.

See [Setting up for VS code](https://medium.com/@karlrombauts/setting-up-unit-testing-for-java-in-vs-code-with-maven-3dc75579122f) for more info.

## Including/Excluding classes, methods

#### Including/Excluding classes

If you want to exclude certain classes from your coverage calculation, you can configure the build plug in above with that info:

```xml
<plugin> 
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>com/baeldung/**/ExcludedPOJO.class</exclude>
            <exclude>com/baeldung/**/*DTO.*</exclude>
            <exclude>**/config/*</exclude>
        </excludes>
     </configuration>
     ...
</plugin>
```

Similarly, there's an [`include`](https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/util/PatternFilterable.html#include-java.lang.String...-) method to only consider the specified classes in the coverage report. [Documentation](https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/util/PatternFilterable.html) contains more information about the file patterns. -- this info is from gradle but in theory, the include option should work for maven too

## Excluding methods

JaCoCo ignores any method that has been annotated with an annnotation that has the substring `Generated` in its name. 

To exclude a method, first, create an annotation that contains `Generated` in its name. Full name does not really matter. Example:

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
private @interface JacocoSkipGenerated {}
```

Then, annotate the method you want to exclude:

```java
@JacocoSkipGenerated
public int skippedMethod(int a) {
    // ...
}
```

This [Stack Overflow thread](https://stackoverflow.com/questions/47824761/how-would-i-add-an-annotation-to-exclude-a-method-from-a-jacoco-code-coverage-re) may have more updated info about excluding methods as more options may be added to Jacoco in the future.

## References

- [Maven JaCoCo Plugin Docs](https://www.jacoco.org/jacoco/trunk/doc/maven.html)
- [wirnis - StackOverflow](https://stackoverflow.com/questions/55716779/generating-a-jacoco-code-coverage-report-with-maven)
- [Baeldung](https://www.baeldung.com/jacoco-report-exclude)
- [Setting up for VS code](https://medium.com/@karlrombauts/setting-up-unit-testing-for-java-in-vs-code-with-maven-3dc75579122f)