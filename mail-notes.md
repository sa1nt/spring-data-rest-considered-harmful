# Complaints from email as of 2025-02-26

1. Squashes your domain objects with your DTOs and DAOs
    * While it's not always necessary to separate those, SDRest makes it hard to introduce this separation if / when it becomes necessary
    * It's especially annoying to me to mix up Jackson @JsonIgnore and JPA @ManyToOne annotation in same class. [Example from SDRest docs](https://docs.spring.io/spring-data/rest/reference/projections-excerpts.html#projections-excerpts.projections.hidden-data)
2. Requires your domain / DAO objects (those returned / accepted by your @Repository interfaces) to be meaningful without relations
    * i.e. given a domain where 1 Library can have [0 .. *] Books, the SDRest way to create a Library and add 2 Books in it would be: 
        1. POST new Library
        2. POST new  Book 1
        3. PUT a Library reference to Book 1
        4. POST new Book 2
        5. PUT a Library reference to Book 2
    * Note that [SDRest Docs](https://docs.spring.io/spring-data/rest/reference/projections-excerpts.html#projections-excerpts.excerpting-commonly-accessed-data) state that one can inline related Objects for retrieving. TODO: experiment if it's possible for POST / PUT.
    * In short: SDRest forces every exposed @Repository to be effectively a [DDD Aggregate Root](https://martinfowler.com/bliki/DDD_Aggregate.html)
    * And there no standard SDRest way to create this in less than 2 requests per Book
3. Amount of SDRest-specific configuration one has to use to customize behavior is huge
    * e.g. to introduce an endpoint like /api/library/{libraryId}/burn one'd have to use an SDRest-specific @RepositoryRestController annotation
   * or, to introduce programmatic validation one'd have to do, [quoting docs](https://docs.spring.io/spring-data/rest/reference/validation.html#page-title), "_... to validate instances of the Person class before new ones are saved into the repository, you would declare an instance of a Validator<Person> in your ApplicationContext with a bean name of beforeCreatePersonValidator. Since the beforeCreate prefix matches a known Spring Data REST event, that validator is wired to the correct event_" 
