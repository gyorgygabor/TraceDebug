# TraceDebug
Prints the annotated method`s stacktrace. Based on Jake Wharton`s hugo library.
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
