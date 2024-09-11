    
@ApplicationScoped: This scope ensures that only one instance of the bean exists for the entire application lifecycle. This instance is created when it's first needed and is then reused for all subsequent injections or lookups.
    @RequestScoped: Creates a new instance for each HTTP request in a web application.

    @SessionScoped: Creates a new instance for each user session in a web application.

    @Dependent: This is the default scope if no scope is specified. It means a new instance is created whenever it's injected or looked up, unless it's injected into a bean with a narrower scope.

How CDI Manages Scopes:

    Bean Instantiation: When a bean annotated with @ApplicationScoped is first requested, CDI creates an instance.
    Bean Storage: This instance is stored in a context map associated with the application scope. 
    Bean Reuse: For subsequent requests or injections, CDI retrieves the same instance from this map, ensuring it's the same object throughout the application's lifecycle.
    Lifecycle Management: CDI also handles the lifecycle events of these beans, including initialization (@PostConstruct) and destruction (@PreDestroy).

Example in Quarkus:
------------------
If you have:

@ApplicationScoped
public class MyService {
    // Some methods and fields
}

And you inject MyService into multiple classes:

@Inject
private MyService service;

Every injection point will receive the same instance of MyService. 

This ensures that:

    State is Shared: Any state changes in MyService will affect all parts of the application that use it.
    Resource Efficiency: Only one instance is created, reducing memory usage for stateless or shared state scenarios.


Benefits:

    Singleton Behavior: You get singleton behavior without manually implementing the singleton pattern.
    Container Managed: CDI handles the instantiation, lifecycle, and destruction, which is particularly useful for managing resources like database connections or thread pools.
    Easy Testing: CDI containers often provide ways to mock or replace beans for testing purposes.
