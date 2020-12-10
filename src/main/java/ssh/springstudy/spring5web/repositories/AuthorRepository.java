package ssh.springstudy.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;

import ssh.springstudy.spring5web.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}
