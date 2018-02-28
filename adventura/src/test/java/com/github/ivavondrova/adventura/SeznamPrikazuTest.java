package com.github.ivavondrova.adventura;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.ivavondrova.adventura.logika.Hra;
import com.github.ivavondrova.adventura.logika.PrikazJdi;
import com.github.ivavondrova.adventura.logika.PrikazKonec;
import com.github.ivavondrova.adventura.logika.SeznamPrikazu;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu
 * 
 * @author    Luboš Pavlíček
 * @version   pro školní rok 2014/2015
 */
public class SeznamPrikazuTest
{
    private com.github.ivavondrova.adventura.logika.Hra hra;
    private com.github.ivavondrova.adventura.logika.PrikazKonec prKonec;
    private com.github.ivavondrova.adventura.logika.PrikazJdi prJdi;
    
    @Before
    public void setUp() {
        hra = new com.github.ivavondrova.adventura.logika.Hra();
        prKonec = new com.github.ivavondrova.adventura.logika.PrikazKonec(hra);
        prJdi = new com.github.ivavondrova.adventura.logika.PrikazJdi(hra.getHerniPlan());
    }

    @Test
    public void testVlozeniVybrani() {
        com.github.ivavondrova.adventura.logika.SeznamPrikazu seznPrikazu = new com.github.ivavondrova.adventura.logika.SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertEquals(null, seznPrikazu.vratPrikaz("napoveda"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        com.github.ivavondrova.adventura.logika.SeznamPrikazu seznPrikazu = new com.github.ivavondrova.adventura.logika.SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("napoveda"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }
    
    @Test
    public void testNazvyPrikazu() {
        com.github.ivavondrova.adventura.logika.SeznamPrikazu seznPrikazu = new com.github.ivavondrova.adventura.logika.SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
    
}
