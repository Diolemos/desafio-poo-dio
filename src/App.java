import java.time.LocalDate;

import br.com.dio.desafio.br.dominio.Bootcamp;
import br.com.dio.desafio.br.dominio.Curso;
import br.com.dio.desafio.br.dominio.Dev;
import br.com.dio.desafio.br.dominio.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {
      
        Curso curso1 = new Curso("cuso java","Descriçaõ do curso",8);
        Curso curso2 = new Curso("cuso javaScript","Descriçaõ do curso",4);
        // // System.out.println(curso1);
        // // System.out.println(curso2);
        
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Mentoria Java",LocalDate.now()); 
        // // System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp java");
        bootcamp.setDescricao("Descrição do curso Java developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev compareibou = new Dev();
        compareibou.setNome("compareibou");

        Dev joao = new Dev();
        joao.setNome("João");
        
    }
}
