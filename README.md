Section2 Learning Notes
========================
      Spring Initializr 
              https://github.com/spring-io/initializr
      Spring Boot Starters
      https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters
      Start.spring.io
      Create spring project with online  as  in follows website:
      https://start.spring.io/

      Create Web Project
      Choose follow three dependencies
      Spring Web
      Spring Data JPA
      H2 Database
      Generate zip file from the website
      Extract zip and Open with VS Code
      Project Artifacts


JPA Entities
============
      Plain old Java object (POJO)
      Create package
      domain
      Create classes within domain package
      Author
      Book
      Declare fields in related classes
      Create Constructor in Author Class with all  fields
      Create default/zero argument Constructor in Author Class  with no fields for JPA
      Create Getter/Setter in Author Class 
      Do same actions in Book Class as Author Class
      Declare fields 
      Create default/zero argument constructor with no fields
      Create constructor with all fields 
      Create Getter/Setter with all fields
      
JPA ‘s Id
==========
      @Entity declare above Class
      Declare primary key for JPA - private Long id;
      @GeneratedValue(strategy = GenerationType.AUTO)
      Generate Getter/Setter for id

      Make as above in Author.java and Book.java classes
      
JPA  Relationship
==================

      Author to Book is many to many relationship
      Declare 
      @ManyToMany(mappedBy = "authors") in Author.java
      Declare 
      @ManyToMany
      @JoinTable(name = "author_book",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id")) in Book.java
      
Equality In Hibernate
=====================

      Make the following two steps in Author.java and Book.java classes

      Generate toString () method with all fields
      Generate equals() and hashCode() method with id field

Spring Data Repositories
===========================
      Create new package named ssh.springstudy.spring5web.repositories
      Create BookRepository interface  under ssh.springstudy.spring5web.repositories
      Create AuthorRepository interface under ssh.springstudy.spring5web.repositories
Initializing Data with Spring
=============================
      Create package  named ssh.springstudy.spring5web.bootstrap
      Create class named BootstrapData.java , implements CommandLineRunner under ssh.springstudy.spring5web.bootstrap
      Added @Component annotation above class
      Declare BookRepository and AuthorRepository in BootstrapData.java class
      Create Getter/Setter for these repositories , which can make dependency injection
      Create Author obj, Book obj and get by each other and then save to respective repository
      Create HashSet<>() in Entity ->BookRepository and AuthorRepository
      
Add Publisher Entity
======================

      Create Publisher.java under domain package
      Declare Book in Pushisher.java and Getter/Setter for it
         @OneToMany
            @JoinColumn(name = "publisher_id")
             private Set<Book> book = new HashSet<>();
      Declare Publisher in Book.java and Getter/Setter for it
         @ManyToOne
            private Publisher publisher;
      Create PublisherRepository under repositories package
      Implement Publisher in BootstrapData.java under bootstrap package
         Publisher publisher = new Publisher();
               publisher.setName("Shwe Sin");
               publisher.setCity("Taung Dwin Gyi");
               publisher.setState("Magway");
               publisherRepository.save(publisher);
      Result TEST:
      System.out.println("Number of Books : " + bookRepository.count());
      System.out.println("Publisher of Number : " + publisher.getBook().size());

H2 Database Console
=====================

      - application,.properties file added as :
         spring.h2.console.enabled = true

      - Search  /h2-console in  project console
      Type in browser
         http://localhost:8080/h2-console
      - Update JDBC URL as show in project console
      - Click Connect , your h2 Database reached
      
Configuring Spring MVC Controller
==================================

      Create controller package
      Create BookController.java under controller package
      @Controller annotation declare above class
      Declare book repository and create constructor for it
      @RequestMapping(“/books”) declare above method

Thymeleaf Templates
=========================

      Create list.html file under template folder
      Write thymeleaf style format in list.html
      <html xmlns:th="http://www.thymeleaf.org">
      Return html file name in controller

Learn Reference Code Learn for Spring Pet Clinic
================================================
   https://github.com/spring-projects/spring-petclinic
