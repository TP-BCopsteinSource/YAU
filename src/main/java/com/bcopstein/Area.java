package main.java.com.bcopstein;

import java.util.List;
import java.util.ArrayList;

public class Area extends Reta {
    public enum SituacaoReta {
        TODA_DENTRO, TODA_FORA, INTERSECTA
    }

    public Area(Ponto pSupEsq, Ponto pInfDir) {
        super(pSupEsq, pInfDir);
        if ((pSupEsq.getX() >= pInfDir.getX()) || (pSupEsq.getY() <= pInfDir.getY())) {
            throw new IllegalArgumentException("O retangulo deve ser definido pela diagonal principal");
        }
    }

    private byte codificaPonto(Ponto p) {
        byte cod = 0;
        if (p.getY() > getP1().getY()) { // Ponto acima da area
            cod = (byte)1;
        } else if (p.getY() < getP2().getY()) { // Ponto abaixo da area
            cod = (byte)2;
        }

        if (p.getX() > getP2().getX()) { // Ponto a direita da area
            cod += (byte)4;
        } else if (p.getX() < getP1().getX()) { // Ponto a esquerda da area
            cod += (byte)8;
        }
        return cod;
    }

    public SituacaoReta classifica(Reta reta){
        byte cod1 = codificaPonto(reta.getP1());
        byte cod2 = codificaPonto(reta.getP2());

        System.out.println("Codigo P1: "+cod1);
        System.out.println("Codigo P2: "+cod2);
        System.out.println("Cod1 | Cod2: "+(cod1|cod2));
        System.out.println("Cod1 & 1: "+(cod1&1));
        System.out.println("Cod1 & 2: "+(cod1&2));
        System.out.println("Cod1 & 4: "+(cod1&4));
        System.out.println("Cod1 & 8: "+(cod1&8));

        if ((cod1 | cod2) == 0){
            return SituacaoReta.TODA_DENTRO;
        }else{
            for(byte val=1;val<=8;val*=2){
                if ((cod1 & val) == val && (cod2 & val) == val){
                    return SituacaoReta.TODA_FORA;
                }
            }
            return SituacaoReta.INTERSECTA;
        }
    }
}