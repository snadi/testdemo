# Pitest Maven Tutorial

Please refer to [Pitest](https://pitest.org) for more detailed info.

## Setting up Pitest 

Add pitest as a plugin in the `<build><plugins> .... </plugins></build>` section of your pom.xml file. Make sure to check available versions on maven central and update the version number accordingly.

```xml
<build>
...
    <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.15.8</version>
      </plugin>
    </plugins>
...
</build>
```

Note that because we are using junit5 in this project, we need to add another dependency for pitest to work. So in the `<dependencies>` section of your pom.xml, add the following dependency:

```xml
<dependencies>
  ...
    <dependency>
      <groupId>org.pitest</groupId>
      <artifactId>pitest-junit5-plugin</artifactId>
      <version>1.2.1</version>
    </dependency>
    ...
</dependencies>
```

Once you have the above set, you can generate the mutation testing report using:

`mvn test-compile org.pitest:pitest-maven:mutationCoverage`

This will output an html report to target/pit-reports/index.html

There are additional configurations you can make (e.g., only focusing on certain classes in your report). Please check [https://pitest.org/quickstart/maven/](https://pitest.org/quickstart/maven/) for additional options.