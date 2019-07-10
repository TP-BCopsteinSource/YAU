package main.java.com.bcopstein;

public class Reta {
    public enum SituacaoReta {
        TODA_DENTRO, TODA_FORA, INTERSECTA
    }

    private Ponto p1,p2;

    public Reta(Ponto p1,Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Ponto getP1(){
        return p1;
    }

    public Ponto getP2(){
        return p2;
    }
}