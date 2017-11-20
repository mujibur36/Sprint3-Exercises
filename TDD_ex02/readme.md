<link rel='stylesheet' href='web/swiss.css'/>

# :star::star: Exercise 02: Using Spock with a plain old Java project

In this exercise, we are going to practise how to use the [Spock Framework](http://spockframework.org/) to test a Java application in the Spring Tool Suite by using Gradle as build tool of choice.

The [code](src/main/java/labSpock/Belly.java) that was explained in [lecture 07](https://github.com/uol-inf/CO2006-17-18/tree/master/sprint3/#behaviour-driven-development) is available in this project.
				    
## :star::star: Exercises

1. Create a feature specification in a new Groovy class under `src/test/groovy/code` (where `code` is a package). 
2. Rewrite the solution to the exercises proposed for the [worksheet on TDD](https://github.com/uol-inf/CO2006-17-18/blob/master/sprint3/TDD_ex01/readme.md) using BDD with Spock. That is, test cases must be rewritten as feature methods using Hamcrest matchers as found appropriate.
3. Use the command `./gradlew clean test` to run your tests. Congrats! At this stage, you have an executable specification together with a first working release that has been tested. 
4. The command in step `3` above generates two test reports:
    * a **JUnit report** in the file `build/reports/tests/test/index.html`, which can be accessed on a web browser:
      * select file
      * right click
      * open with > `Web Browser`
    * a **Spock report** in the file `build/spock-reports/index.html`, which can be accessed on a web browser, as explained above.


## Additional Resources

* [Spock primer](http://spockframework.org/spock/docs/1.1/spock_primer.html): skip `with` and extensions.

## Credits

The example of the growling `Belly` has been adapted from [this tutorial on Cucumber (another tool for BDD)](http://www.thinkcode.se/blog/2014/05/29/cucumberjvm-hello-world).

***
&copy; Artur Boronat, 2017
