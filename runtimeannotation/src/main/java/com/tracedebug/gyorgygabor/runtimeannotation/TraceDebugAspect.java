package com.tracedebug.gyorgygabor.runtimeannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.logging.Logger;


@Aspect
public class TraceDebugAspect {
    private static final String LOG_TAG = "TraceDebug";
    private static final Logger LOGGER = Logger.getLogger(LOG_TAG);
    private static final String POINTCUT_METHOD =
            "execution(@com.tracedebug.gyorgygabor.runtimeannotation.DebugTrace * *(..))";
    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.tracedebug.gyorgygabor.runtimeannotation.DebugTrace *.new(..))";

    private static final int stackTraceLengthOffset = 3;

    @Pointcut(POINTCUT_METHOD)
    public void annotatedMethod() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void annotatedConstructor() {
    }

    @Around("annotatedMethod() || annotatedConstructor()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method m = ms.getMethod();
        DebugTrace mAnnotation = m.getAnnotation(DebugTrace.class);
        if (mAnnotation != null) {

            int stackTraceLength = mAnnotation.value() + stackTraceLengthOffset > stacktrace.length ? stacktrace.length : mAnnotation.value() + stackTraceLengthOffset;
            for (int i = stackTraceLengthOffset; i < stackTraceLength; ++i) {
                if (stacktrace.length == i) {
                    break;
                }
                String className = stacktrace[i].getClassName().substring(stacktrace[i].getClassName()
                        .lastIndexOf(".") + 1);

                String message = "=> " + stacktrace[i].getClassName() +
                        "." +
                        stacktrace[i].getMethodName() +
                        "(" +
                        className +
                        ".java:" +
                        stacktrace[i].getLineNumber() +
                        ")";
                LOGGER.info(message);
            }
        }
        return joinPoint.proceed();
    }
}
