package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author joao = new Author("Joao", "Silva");
        Author guilherme = new Author("Guilherme", "Silveira");
        authorRepository.save(joao);
        authorRepository.save(guilherme);

        Publisher casaDoCodigo = new Publisher("Casa do Codigo","Rua do Manifesto","Sao Paulo","SP",
                "04209000");
        Publisher editoraAbril = new Publisher("Editora Abril","Rua do Silva","Santos","SP",
                "09909000");
        publisherRepository.save(casaDoCodigo);
        publisherRepository.save(editoraAbril);

        Book certificacaoJava = new Book();
        certificacaoJava.setTitle("Certificacao Java");
        certificacaoJava.setIsbn("0001");
        certificacaoJava.setPublisher(casaDoCodigo);
        certificacaoJava.getAuthors().add(joao);

        Book javaCompleto = new Book();
        javaCompleto.setTitle("Java Completo");
        javaCompleto.setIsbn("0002");
        javaCompleto.setPublisher(editoraAbril);
        javaCompleto.getAuthors().add(guilherme);

        Book intellijCompleto = new Book();
        intellijCompleto.setTitle("Intellij Completo");
        intellijCompleto.setIsbn("0003");
        intellijCompleto.setPublisher(casaDoCodigo);
        intellijCompleto.getAuthors().add(guilherme);

        Book javaForDummies = new Book();
        javaForDummies.setTitle("Java for Dummies");
        javaForDummies.setIsbn("0004");
        javaForDummies.setPublisher(editoraAbril);
        javaForDummies.getAuthors().add(joao);

        bookRepository.save(certificacaoJava);
        bookRepository.save(javaCompleto);
        bookRepository.save(intellijCompleto);
        bookRepository.save(javaForDummies);

        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Publisher count:" + publisherRepository.count());

    }
}
