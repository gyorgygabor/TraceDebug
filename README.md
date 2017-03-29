# TraceDebug
- Prints the annotated method`s stacktrace. Based on hugo library by Jake Wharton.
- To add to your project, you need the add Jake Wharton`s hugo library and add the following lines to your app.gradle:

```gradle
repositories {
    maven {
        url 'https://dl.bintray.com/gyorgygabor89/maven/'
    }
}

dependencies {
    compile 'com.gyorgygabor.tracedebug:runtimeannotation:0.1.1'
}
```
NOTE
-------
The library is still in alpha version.


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
