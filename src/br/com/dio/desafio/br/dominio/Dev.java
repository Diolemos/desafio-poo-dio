package br.com.dio.desafio.br.dominio;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Objects;
import java.util.Optional;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); 
        bootcamp.getDevsInscritos().add(this);  
    };

    public void progredir(){
    Optional <Conteudo> conteudo  =  this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
}

    public double calcularTotalXp(){
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    };



    public Dev() {
    }

    public Dev(String nome, Set<Conteudo> conteudosInscritos, Set<Conteudo> conteudosConcluidos) {
        this.nome = nome;
        this.conteudosInscritos = conteudosInscritos;
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return this.conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return this.conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Dev nome(String nome) {
        setNome(nome);
        return this;
    }



   

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dev)) {
            return false;
        }
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", conteudosInscritos='" + getConteudosInscritos() + "'" +
            ", conteudosConcluidos='" + getConteudosConcluidos() + "'" +
            "}";
    }
    

}
