# Spring Data REST considered harmful

Thoughts on [Spring Data REST](https://docs.spring.io/spring-data/rest/reference/index.html) library.

## TLDR


## What is it

Spring Data REST takes your public `@Repository` classes and automatically creates REST endpoints allowing CRUD operations on objects managed by those Repositories. 

The framework follows [HATEOAS](https://github.com/spring-attic/understanding/tree/master/hateoas) constraint to provide resource discoverability. For that it enriches serialized objects with a `_links` object containing hyperlinks to resources related to the current one. See [JSON Hypertext Application Language](https://datatracker.ietf.org/doc/html/draft-kelly-json-hal).

It also provides querying abilities out-of-the-box, including sorting and pagination. 

## Pros


## Cons


## Conclusion

## References
* [Spring Data REST reference documentation](https://docs.spring.io/spring-data/rest/reference/index.html)
* [Spring Data REST source code](https://github.com/spring-projects/spring-data-rest)
* [Example Maven project](https://github.com/sa1nt/spring-data-rest-considered-harmful/tree/main/spring-data-rest-projections)
* [Edgar Dijkstra: Go To Statement Considered Harmful](https://homepages.cwi.nl/~storm/teaching/reader/Dijkstra68.pdf)
