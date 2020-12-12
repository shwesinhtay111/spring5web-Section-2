package ssh.springstudy.spring5web.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssh.springstudy.spring5web.domain.Author;
import ssh.springstudy.spring5web.domain.Book;
import ssh.springstudy.spring5web.domain.Publisher;
import ssh.springstudy.spring5web.repositories.AuthorRepository;
import ssh.springstudy.spring5web.repositories.BookRepository;
import ssh.springstudy.spring5web.repositories.PublisherRepository;
@Component
public class BootstrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design","123456");

        Publisher publisher = new Publisher();
        publisher.setName("Shwe Sin");
        publisher.setCity("Taung Dwin Gyi");
        publisher.setState("Magway");
        publisherRepository.save(publisher);

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        
        book.setPublisher(publisher);
        publisher.getBook().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author shwesin = new Author("shwe","sin");
        Book poem = new Book("How Beauty Life","20201212");

        shwesin.getBooks().add(poem);
        poem.getAuthors().add(shwesin);

        poem.setPublisher(publisher);
        publisher.getBook().add(poem);

        authorRepository.save(shwesin);
        bookRepository.save(poem);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher of Number : " + publisher.getBook().size());


    }
    
}
