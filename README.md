# 7th Homework of the Java Test Automation Course (2nd block) - Solvd Laba
This repository stores the 7th homework given by our mentor in the 2nd block of 
the Java Test Automation Course at Solvd Laba. It consists in creating five
JSON files that represent the structure of five classes from the current 
hierarchy, adding the Jackson library to the project and using its annotations to
map the JSON files into Java objects. Edit: It was necessary as well implementing
the logic to convert the Java objects into both XML and JSON files, so I did
few changes in the Main.java class in order to accomplish this requirement.

## Explanation

To accomplish the requirements of the homework, I've created a folder named
json in the resources folder and then created there JSON files which represent
an exact class type in my models' hierarchy. I consider that creating this JSON
files was pretty much simpler than with XML. After, I added the Jackson 
dependency into the pom.xml and used its annotations to define each JSON 
property from the Java classes. Finally, in the main class I just created 
instances of the JSON files to consume them in a method which uses the 
ObjectMapper object from Jackson and parses the content in a Java object,
following the previously assigned annotations.

## What did I learn?

In this homework I learnt about the Jackson library used to parse JSON files
to Java objects and vice versa. This tool makes the work with JSON files very
much easier, since it does almost everything automatically. I want to highlight
that I already had knowledge about the JSON format, however, this task was useful
to refresh this information and, of course, to learn how to use Jackson in the
practice.

## Technologies

- Java
- Maven
- MySQL
- JDBC
- MyBatis
- XML, XSD, SAX Parser
- Jackson

## Set-Up

To run this project you will need an updated version of Java.
First, clone this repository in a folder of your PC.
You have to put the following command in a terminal:

```bash
  git clone this-repo-url
```
You will need an IDE to open the project folder and, finally, run the 
Main.java file to see the program output.

## Author

- [@Nazareno Bucciarelli](https://github.com/nazabucciarelli)
