package com.endava.calculator;

import cam.endava.calculator.basic.Basic;
import cam.endava.calculator.basic.BasicOperation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {

    private BasicOperation basic = new Basic();

    @Test
    public void shouldAdd1Operands(){
        //WHEN
        Long result = basic.add(121);

        //THEN
        assertThat(result).isBetween(100L,200L)
                .isGreaterThan(111L)
                .isEqualTo(1231L)
                .isNotNegative()
                .isNull();
        //se opreste la primul assert failed, nu le mai ia pe celelalte, la fel si hamcrest
    }
}
