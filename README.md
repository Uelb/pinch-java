Installation
============
There are 2 ways of installing this Java library : 
- [Importing the jar library](importing-the-jar-library)
- [Importing the source code](#using-the-source-code)

## Importing the jar library
At the root of the repository, you will find [a jar file](https://raw.githubusercontent.com/Inchdev/pinch-java/master/Pinch-0.0.1-with-dependencies.jar) that you can import to your java project. If you don't know how to import a jar file, please refer to this SO question : http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse

## Using the source code
If you wish to edit some part of the code for your own purpose, you can choose this method. You should first clone or download the repository using the button above.
Once you have cloned it, you can create a new java project and point the root directory to the newly created one.

Configuration
=======
To authenticate yourself : 
```java
import java.util.List;
import com.inchbase.pinch.PinchClient;

public class Test {
	public static void main(String[] args) {
		String apiKey = "MY_API_KEY";
		String apiEmail = "myemail@example.com";
		PinchClient client = new PinchClient(apiKey, apiEmail);
	}
}
```

Issues
========
If you have any issues : https://github.com/Uelb/pinch-java/issues

Usage
=======
For further documentation, please refer to [the documentation website](http://doc-company.inchbase.com/?java)