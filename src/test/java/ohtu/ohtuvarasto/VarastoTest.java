package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto1;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    double vertailuTarkkuus = 0.0001;


    @Before
    public void setUp() {
        varasto1 = new Varasto(10);
        varasto2 = new Varasto(-1);
        varasto3 = new Varasto(10, 0);
        varasto4 = new Varasto(-1, -1);
        varasto5 = new Varasto(5, 10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto1.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVarastonSaldolla(){
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto4.getSaldo(), vertailuTarkkuus);
        assertEquals(5, varasto5.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto1.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto1.lisaaVarastoon(-1);
        assertEquals(0, varasto1.getSaldo(), vertailuTarkkuus);

        varasto1.lisaaVarastoon(8);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto1.getSaldo(), vertailuTarkkuus);

        varasto1.lisaaVarastoon(2);
        assertEquals(10, varasto1.getSaldo(),vertailuTarkkuus);

        varasto1.lisaaVarastoon(6);
        assertEquals(10, varasto1.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto1.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto1.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto1.lisaaVarastoon(8);

        double saatuMaara = varasto1.otaVarastosta(-1);
        assertEquals(0, saatuMaara, vertailuTarkkuus);

        saatuMaara = varasto1.otaVarastosta(2);
        assertEquals(2, saatuMaara, vertailuTarkkuus);

        saatuMaara = varasto1.otaVarastosta(8);
        assertEquals(6, saatuMaara, vertailuTarkkuus);
        
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto1.lisaaVarastoon(8);

        varasto1.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto1.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void merkkijonoesitysTesti(){
        Varasto varasto6 = new Varasto(10, 5);
        System.out.println(varasto6.toString());
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto6.toString());
    }

}