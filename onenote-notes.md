TLDR: 
My main problem with SDREST is that it's often considered as a good way for junior / mid level devs to quickly create an MVP. In reality, IMO, to use SDREST effectively one must be quite proficient in data modeling, REST best practices, underlying DB, Spring framework internals and conventions, and more. In short, one has to have good understanding of what and how exactly SDREST does what it does.
And since SDREST is quite niche, I don't think getting deep understanding of it is a good way to spend time.

With Spring Data REST it is absolutely mandatory to thoroughly read through documentation to understand what are the defaults, conventions, formats etc for this framework.
It is also very important to model your data in a manner compatible with SDREST. This manner isn't a bad one, but it requires to keep your relations straightforward.
Without that it's extremely easy to misuse SDREST and end up in a spot when evolving the application becomes unnecessarily hard.

Also, the [HAL format](https://stateless.co/hal_specification.html) used in SDREST is something your consumers will have to adapt to, which might incur friction.

1. Intro: what is SDREST 
    - Define @Repository
    - SDREST autogenerates API for them
2. Body: pitfalls
    * For all of those: usually come from misusing SDREST, aka "skill issue"
    * **!!** how to add business validations to incoming mutation requests?
        - especially against related data
3. Outro: 
    * Is SDREST objectively bad?
        * No
    * Can you create a clean maintainable service with it? 
        * Yes
    * Is the effort to create such a service with SDREST worth it? 
        * IMO -- no
        * Considering the amount of intricate library-specific knowledge you must have to do it
    
Meme generation: https://imgflip.com/memegenerator/351767367/Running-Away-Balloon-2---boxes
