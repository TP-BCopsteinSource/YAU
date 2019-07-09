package test.java.com.bcopstein;

import main.java.com.bcopstein.Ponto;
import main.java.com.bcopstein.Area;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.java.com.bcopstein.Area;

public class AreaTest{
    private Area area;

    @BeforeEach
    public void setup() {
        area = new Area(new Ponto(80,50),new Ponto(140,10));
    }

    @DisplayName("Testa a rotina de classificação de pontos contra area")
    @ParameterizedTest
    @CsvSource({ "90,50,0","90,90,1","90,5,2","160,50,4","30,50,8",
                 "160,90,5","160,5,6","30,90,9","30,5,10" })
    public void evaluateTest(int x,int y,byte rEsp) {
        byte observed = area.codificaPonto(new Ponto(x,y));
        assertEquals(rEsp,observed);
    }
}
