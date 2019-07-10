package test.java.com.bcopstein;

import main.java.com.bcopstein.Ponto;
import main.java.com.bcopstein.Reta;
import main.java.com.bcopstein.Reta.SituacaoReta;
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
        area = new Area(new Ponto(50,80),new Ponto(140,10));
    }

    @DisplayName("Classifica pontos")
    @ParameterizedTest
    @CsvSource({ "90,50,0","90,90,1","90,5,2","160,50,4","30,50,8",
                 "160,90,5","160,5,6","30,90,9","30,5,10",
                 "140,40,0","70,10,0","70,80,0","50,50,0" })
    public void codPontoTest(int x,int y,byte rEsp) {
        byte observed = area.codificaPonto(new Ponto(x,y));
        assertEquals(rEsp,observed);
    }

    @DisplayName("Classifica retas")
    @ParameterizedTest
    @CsvSource({"60,15,130,70,TODA_DENTRO",
                "30,50,90,50,INTERSECTA",
                "90,50,160,50,INTERSECTA",
                "90,50,90,5,INTERSECTA",
                "90,90,90,50,INTERSECTA",
                "30,50,30,100,TODA_FORA",
                "200,90,130,500,TODA_FORA"
                })
    public void codRetaTest(int xi,int yi,int xf,int yf,SituacaoReta rEsp) {
        Reta reta = new Reta(new Ponto(xi,yi),new Ponto(xf,yf));
        SituacaoReta observed = area.classifica(reta);
        assertEquals(rEsp,observed);
    }
}
