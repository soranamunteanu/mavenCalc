package com.endava.calculator;

import cam.endava.calculator.basic.Basic;
import cam.endava.calculator.basic.BasicOperation;
import cam.endava.calculator.expert.Expert;
import cam.endava.calculator.expert.ExpertOperation;
import cam.endava.extensions.TestReporterExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {
    //GIVEN
    private BasicOperation basic;
    private ExpertOperation expert;
    private static final Logger LOGGER = LogManager.getLogger(TestReporterExtension.class);

    @BeforeAll
    public static void setUpAllTests(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest(){
        basic = new Basic();
        expert = new Expert();
        System.out.println("\nBefore Each");
    }
    @AfterEach
    public void tearDownEachTest(){
        System.out.println("After Each\n");
    }

    @Tags( { @Tag("smoke"), @Tag("ui") } )
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b){

        //WHEN
        Long result = basic.add(a, b);

        //THEN
        LOGGER.info(result);

    }

    public static List<Arguments> numberProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0,2));
        argumentsList.add(Arguments.of(2,0));

        return argumentsList;
    }

    @Tag( "smoke")
    @Test
    public void shouldAddNegativeNumbers(){


        //WHEN
        Long result = basic.add(-2, -4);

        //THEN
        assertEquals(-6L, result);
        assertTrue(result.equals(-6L));
    }

    //BUG Found : JIRA-2154
    @Tags( { @Tag("smoke"), @Tag("api") } )
    @Test
    @DisplayName("Test that adds big number as: MAX INT")
    public void shouldAddBigNumbers(){

        assertThrows(AssertionError.class, () -> {

        //WHEN
        Long result = basic.add(Integer.MAX_VALUE, 1);

        //THEN
        assertThat(result, is(Integer.MAX_VALUE+1L));
        assertThat(result, lessThan(0L));
        assertThat(result, notNullValue());
    });
    }


    @Test
    public void shouldAddMoreThanTwoOperands(){
        //WHEN
        Long result = basic.add(4, 5,6,8, 1);

        //THEN
        LOGGER.info(result);
    }
    @Test
    public void shouldAddNoOperands(){
        //WHEN
        Long result = basic.add();

        //THEN
        LOGGER.info(result);
    }

    @ParameterizedTest //data driven testing (input, output)
    @CsvSource({"1,2,3,6", "2,4,6,12"})
    @CsvFileSource(resources = "numerSource.csv")
    public void shouldAdd1Operands(Integer a, Integer b, Integer c, Long expected){
        //WHEN
        Long result = basic.add(a,b,c);

        //THEN
        assertThat(result, is(expected));
    }

    @Test
    public void shouldMultiplyNegativeNumbers(){
        //WHEN
        Long result = basic.multiply(-3,-7);

        //THEN
        LOGGER.info(result);
    }

    @ParameterizedTest
    @MethodSource("numbersProvider")
    public void shouldMultiplyWith1(int a, int b, long expected) {
        //WHEN
        Long result = basic.multiply(a, b);

        //THEN
        assertThat(result, is(expected));
    }
    public static List<Arguments> numbersProvider(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(32,1, 32));
        argumentsList.add(Arguments.of(1,32, 32));
//        argumentsList.add(Arguments.of(1,1));

        return argumentsList;
    }

    @Test
    public void shouldUsePowWithNegativeNumbers(){
        //WHEN
        double result = expert.pow(3,-2);

        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldUseFactorialWith1(){
        //WHEN
        double result = expert.factRec(1);

        //THEN
        LOGGER.info(result);
    }





    }
