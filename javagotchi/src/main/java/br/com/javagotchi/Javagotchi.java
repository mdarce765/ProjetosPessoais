package br.com.javagotchi;

public class Javagotchi {
    private int hp = 100, fome = 0, idade = 0, higiene = 100, energia = 100;
    private String nome;

    public int getHp(){
        return hp;
    }

    public int getFome(){
        return fome;
    }

    public int getIdade(){
        return idade;
    }

    public int getHigiene(){
        return higiene;
    }

    public int getEnergia(){
        return energia;
    }

    public String getNome(){
        return nome;
    }


    public void setHp(int hp){
        this.hp = hp;
    }

    public void setFome(int fome){
        this.fome = fome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setHigiene(int higiene){
        this.higiene = higiene;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
