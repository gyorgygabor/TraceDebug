# TraceDebug
- Prints the annotated method`s stacktrace. It is an extension for the [hugo](https://github.com/JakeWharton/hugo) library by Jake Wharton.
- To use it, you need to add the [hugo](https://github.com/JakeWharton/hugo) library and add the following lines to your app.gradle:

```gradle
repositories {
    maven {
        url 'https://dl.bintray.com/gyorgygabor89/maven/'
    }
}

dependencies {
    compile 'com.gyorgygabor.tracedebug:runtimeannotation:1.0.0'
}
```


How to use
-------

```java
    //prints the first 5 methods from the stacktrace
    @DebugTrace(5)
    private void someMehtod() {
        Log.i(TAG, "someMehtod() called");
    }
```
```java
    //prints the first 40(default) methods from the stacktrace
    @DebugTrace
    private void someOtherMehtod() {
        Log.i(TAG, "someOtherMehtod() called");
    }
```
The output will looks like below:
```java
your-package-name I/TraceDebug: => com.tracedebug.gyorgygabor.tracedebug.MainActivity.someMehtod4(MainActivity.java:34)
your-package-name I/TraceDebug: => com.tracedebug.gyorgygabor.tracedebug.MainActivity.someMehtod3(MainActivity.java:29)
your-package-name I/TraceDebug: => com.tracedebug.gyorgygabor.tracedebug.MainActivity.someMehtod2(MainActivity.java:25)
your-package-name I/TraceDebug: => com.tracedebug.gyorgygabor.tracedebug.MainActivity.someMehtod1(MainActivity.java:21)
your-package-name I/TraceDebug: => com.tracedebug.gyorgygabor.tracedebug.MainActivity.onCreate(MainActivity.java:17)
```

License
--------

    Copyright 2017 Gabor Gyorgy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
