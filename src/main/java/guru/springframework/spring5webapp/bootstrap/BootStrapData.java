package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Author rodrigo = new Author("Rodrigo", "Gaspar");
        Book certificacaoJava = new Book("Certificacao Java","1234");
        Publisher casaDoCodigo = new Publisher("Casa do Codigo","Rua do Manifesto","Sao Paulo","SP",
                "04209000");

        authorRepository.save(rodrigo);
        bookRepository.save(certificacaoJava);
        publisherRepository.save(casaDoCodigo);

        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Publisher count:" + publisherRepository.count());

    }
}
