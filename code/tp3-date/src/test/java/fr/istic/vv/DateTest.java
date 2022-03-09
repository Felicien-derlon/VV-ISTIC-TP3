package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void isValidate(){
           assertTrue(Date.isValidDate(20,10,2022) );
    }

    @Test
    public void isNotValidate(){
        assertFalse(Date.isValidDate(35,10,2022) );
    }

    @Test
    public void nextDateValidate(){
        try {
            Date date = new Date(03,10,2022);
            assertEquals(date.nextDate().compareTo(new Date(04,10,2022)), 0);
        } catch (Exception e) {
            fail("problème dans le changement de la date");
        }
    }

    @Test
    public void previousDateValidate(){
        try {
            Date date = new Date(03,10,2022);
            assertEquals(date.previousDate().compareTo(new Date(02,10,2022)), 0);
        } catch (Exception e) {
            fail("problème dans le changement de la date");
        }
    }

    @Test
    public void compareToSup(){
        try {
            Date date = new Date(03,10,2022);
            assertEquals(date.compareTo(new Date(01,10,2022)), 1);
        } catch (Exception e) {
            fail("problème dans le compareTo de la date");
        }
    }

    @Test
    public void compareToInf(){
        try {
            Date date = new Date(03,10,2022);
            assertEquals(date.compareTo(new Date(05,10,2022)), -1);
        } catch (Exception e) {
            fail("problème dans le compareTo de la date");
        }
    }
}