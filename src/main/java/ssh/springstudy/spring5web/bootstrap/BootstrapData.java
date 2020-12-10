package ssh.springstudy.spring5web.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssh.springstudy.spring5web.domain.Author;
import ssh.springstudy.spring5web.domain.Book;
import ssh.springstudy.spring5web.repositories.AuthorRepository;
import ssh.springstudy.spring5web.repositories.BookRepository;
@Component
public class BootstrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design","123456");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author shwesin = new Author("shwe","sin");
        Book poem = new Book("How Beauty Life","20201212");

        shwesin.getBooks().add(poem);
        poem.getAuthors().add(shwesin);

        authorRepository.save(shwesin);
        bookRepository.save(poem);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books" + bookRepository.count());


    }
    
}
