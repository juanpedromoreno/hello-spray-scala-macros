# Spray services annotated with Scala Macros

This simple app is a getting started with spray and scala macros.

## Annotate with @hello

It shows how to annotate a Spray Service:

```
@hello
trait MyService extends HttpService {

    val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>This spray service says: <i>{this.hello}</i></h1>
              </body>
            </html>
          }
        }
      }
    }
}
```

In compilation time, this code is expanded to:

```
trait MyService extends HttpService {

    def hello: String = "hello from a scala macro ;)"

    val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>This spray service says: <i>{this.hello}</i></h1>
              </body>
            </html>
          }
        }
      }
    }
}
```

## Macro

The macro implementation:

    val result = {
      annottees.map(_.tree).toList match {
        case q"trait $name extends ..$parents { ..$body }" :: Nil =>
          q"""
            trait $name extends ..$parents {
              def hello: ${typeOf[String]} = "hello from a scala macro ;)"
              ..$body
            }
          """
      }
    }
    c.Expr[Any](result)
    
## Usage

``