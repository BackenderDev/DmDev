package com.bakdaulet.spring.bpp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transaction {
}


/// 1,2,3,4

// 1  2,3,4
// 2  1,3,4
// 3  1,2,4
// 4  1,2,3