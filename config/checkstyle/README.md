## Coding standards

**Configuring IntellijIdea to reformat the code based on predefined coding style.**

- Go to File -> Settings -> Code style -> Select the **Project** schema;
- CTRL + ALT + L to reformat the code you want.

**While executing the build it will check the bellow rules if those aren't complied, the build will fail:**

- Line length should be of 150 characters;
- Headers should have _Copyright (c) 202[0-9] g4share_
- Type name, and the file name should match. For example, the class Foo must be in a file named Foo.java;
- Wildcard import should not be used;
- Each top-level class, interface, enum or annotation should reside in a source file of its own.


**Suppressing checks:**
- If some checkstyle warnings/errors should be suppressed (e.g. for auto-generated classes), the files must be added to [./config/checkstyle/suppressions.xml](config/checkstyle/suppressions.xml)
  - see [Checkstyle filters](https://checkstyle.sourceforge.io/config_filters.html) for details

    
**Configuring IntelliJ for ease of working according to coding standards**

**Copyright insertion:**
  1. File -> Settings -> Editor -> Copyright ->
     1. Copyright Profiles -> Add -> ENTER_NAME -> Add: Copyright (c) $today.year g4share
     2. Default project copyright: NEWLY_CREATED_PROFILE
These settings will add the Copyright to newly created classes and enable the option to "_Update Copyright.._" for any old/new file/package


**Real-time checkstyle scanning**
  1. File -> Settings -> 
     1. Plugins -> Enable "Checkstyle-IDEA"
     2. Tools -> Checkstyle ->
         1. Add configuration file -> Browse for [./config/checkstyle/checkstyle.xml](config/checkstyle/checkstyle.xml)
         2. Check newly created configuration file in the list
         3. Scan scope: Only Java sources (but not tests)

  

**Example of code with violations:**

```
public class Foo { // OK, first top-level class
  // methods
}

class Foo2 { // violation, second top-level class
  // methods
}
```
An example of code without violations:
```
public class Foo { // OK, only one top-level class
  // methods
}
```

- Package, Import, Static Import definitions should not be line-wrapped.

Example:

```
package com.voacalink
        .bps.ips.bridge // violation
```
-  Avoid using empty blocks for **try, finally, if, else and switch**;

-  The brace must be alone on the line.

Example:
```
try {
        ...
    }
    finally {
        ...
    }
```

-  The brace should be on the same line as the next part of a multi-block statement.

Example:
```
 // try-catch-finally blocks
    try {
        ...
    } catch (Exception ex) { // this is OK
        ...
    } finally { // this is OK
        ...
    }
```
- Use space after COMMA, SEMI COMMA, TYPE CAST, LITERAL_IF, LITERAL_ELSE, LITERAL_WHILE, LITERAL_DO, LITERAL_FOR, DO_WHILE;

- Use white space around ASSIGN, DIV_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN, STAR_ASSIGN, MOD_ASSIGN, SR_ASSIGN,BSR_ASSIGN, SL_ASSIGN, BXOR_ASSIGN, BOR_ASSIGN, BAND_ASSIGN;

- Only one statement per line.

An example of code with violations

```
Object obj1 = new Object(); Object obj2 = new Object();
```

- One declaration per line.

Example:

```
int var1; 
int var2;

is preferred over

int var1, var2;
```

- Declare arrays in Java style.

Example:

```
int[] nums; // OK
String strings[]; // violation
```

- Switch statement should have default clause;

- Long constants should be defined with upper L;

- Follow the bellow order when declaring modifiers:

```
1. public
2. protected
3. private
4. abstract
5. default
6. static
7. final
8. transient
9. volatile
10. synchronized
11. native
12. strictfp
```

- Declare empty line after header, package, all import declarations, fields, constructors, methods, nested classes, static initializers and instance initializers;

- Separators **COMMA**, **DOT**, **METHOD_REF** should be on the same line.

Example:

```
int a
    ,b;  // OK

Arrays.sort(stringArray, String::
      compareToIgnoreCase);  // violation
```

- Package name should match `^[a-z]+(\.[a-z][a-z0-9]*)*$`;

- Type name should match `'^[A-Z][a-zA-Z0-9]*$`;

- Member name should match `^[a-z][a-z0-9][a-zA-Z0-9]*$`;

- Parameter name should match `^[a-z]([a-z0-9][a-zA-Z0-9]*)?$`;

- Lambda parameter name should match `^[a-z]([a-z0-9][a-zA-Z0-9]*)?$`;

- Catch parameter name should match `^[a-z]([a-z0-9][a-zA-Z0-9]*)?$`;

- Local variable name should match `^[a-z]([a-z0-9][a-zA-Z0-9]*)?$`;

- Class type parameter name should match `(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)`;

- Method type parameter name should match `(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)`;

- Interface type parameter name should match `(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)`

- Don't use spaces in **Generic** after `<` and before `>`;

Examples with incorrect spacing:

 ```
List a = new ArrayList<> (); // violation ">" is followed by white space
Map<Integer, String>map; //violation ">" not followed by white space
Map< String, String >map; //violation ">" precedeed with white space
```

- Overloaded methods should be grouped together:

Example

 ```
 public void method(int i) {}
 public void method(String s) {}
 public void method(String s, int i) {}
 public void method(int i, String s) {}
 public void anotherMethod() {}
 ```

An example with code violation:

```
 public void method(int i) {}
 public void method(String s) {}
 public void anotherMethod() {}
 public void method(String s, int i) {}
 public void method(int i, String s) {}
 ```

- Import order should be:

 ```
1. THIRD_PARTY_PACKAGE
2. SPECIAL_IMPORTS
3. STANDARD_JAVA_PACKAGE
4. STATIC
  ```

- No white space before **COMMA, SEMI, POST_INC, POST_DEC, DOT, ELLIPSIS, METHOD_RE** ;

- Operators should be on new line in the bellow example.

 ``` 
 String h = "Hello" +
        "World"; // violation, '+' should be on new line

 if (10 == 
        20 ) { // violation '==' should be on new line
     ...
 }
 ```

- Method name should match `^[a-z][a-z0-9][a-zA-Z0-9_]*$`;

- Avoid declaring Empty catch blocks;

# References:

Check style documentation : https://checkstyle.sourceforge.io

Google Java style guide : https://google.github.io/styleguide/javaguide.html

Gradle check style plugin : https://docs.gradle.org/current/userguide/checkstyle_plugin.html
