package demo1.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// 마크업 어노테이션
// 어노테이션 요소가 정의되어있지 않은 어노테이션
@Retention(RUNTIME)
@Target(METHOD)
public @interface Test {
	// 어노테이션 요소 정의하는 곳
}
