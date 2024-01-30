package edu.miu.WebAppArchLab.domain;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectOne {

    @After("@annotation(LogMethod)")

    public void logMethod(Joinpo) {

    }





}
