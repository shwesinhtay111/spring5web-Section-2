package ssh.springstudy.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;

import ssh.springstudy.spring5web.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

    
}
