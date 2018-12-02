package com.jastrzab.SDA_CardValidator_App.domain.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnCardValidatorServiceTest {


    private LuhnCardValidatorService luhnCardValidatorService;

    @Before
    public void init() {
        this.luhnCardValidatorService = new LuhnCardValidatorService();
    }

    @Test
    public void shouldReturnDigitsArrayWithLength1() {
        // given
        final String number = "1";
        final int expectedLength = 1;
        // when
        Integer[] integers = this.luhnCardValidatorService.toDigitArray(number);
        // then
        assertEquals(expectedLength, integers.length);
    }

    @Test
    public void shouldReturnDigitsArrayWithLength3ForNumber11() {
        // given
        final String number = "11";
        final int expectedLength = 3;
        // when
        Integer[] integers = this.luhnCardValidatorService.toDigitArray(number);
        // then
        assertEquals(expectedLength, integers.length);
    }

    @Test
    public void shouldReturnDigitsArrayWithLength3ForNumber111() {
        // given
        final String number = "111";
        final int expectedLength = 3;
        // when
        Integer[] integers = this.luhnCardValidatorService.toDigitArray(number);
        // then
        assertEquals(expectedLength, integers.length);
    }

    @Test
    public void shouldValidCard() {

        try {
            // given
            final String number = "372722297433301";
            // when
            luhnCardValidatorService.validate(number);
            // then
            assertTrue(true);
        } catch (Exception e) {
            fail("throw exception: " + e.getMessage());
        }
    }

    @Test
    public void shouldValidCardTest2() {

        try {
            // given
            final String number = "4307112749673377";
            // when
            luhnCardValidatorService.validate(number);
            // then
            assertTrue(true);
        } catch (Exception e) {
            fail("throw exception: " + e.getMessage());
        }
    }

    @Test
    public void shouldValidCardTest3() {

        try {
            // given
            final String number = "4880773543682";
            // when
            luhnCardValidatorService.validate(number);
            // then
            assertTrue(true);
        } catch (Exception e) {
            fail("throw exception: " + e.getMessage());
        }
    }

    @Test
    public void shouldNotValidCard() {

        try {
            // given
            final String number = "4880773543681";
            // when
            luhnCardValidatorService.validate(number);
            // then
            fail("should throw exception");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void shouldNotValidCardSwapDigits() {

        try {
            // given
            final String number = "4880737543682";
            // when
            luhnCardValidatorService.validate(number);
            // then
            fail("should throw exception");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void shouldThrowInvalidLengthException() {

        try {
            // given
            final String number = "";
            // when
            luhnCardValidatorService.validate(number);
            fail("not throw exception");
        } catch (InvalidLengthException e) {
            // then
            assertTrue(true);
        }
    }

    @Test
    public void shouldThrowInvalidLengthExceptionForLength11() {

        try {
            // given
            final String number = "12345678912";
            // when
            luhnCardValidatorService.validate(number);
            fail("not throw exception");
        } catch (InvalidLengthException e) {
            // then
            assertTrue(true);
        }
    }
}