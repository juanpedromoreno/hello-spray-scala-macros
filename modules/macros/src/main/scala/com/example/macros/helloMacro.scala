package com.example.macros

import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object helloMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._

    val result = {
      annottees.map(_.tree).toList match {
        case q"trait $name extends ..$parents { ..$body }" :: Nil =>
          q"""
            trait $name extends ..$parents {
              def hello: ${typeOf[String]} = "hello from a macro ;)"
              ..$body
            }
          """
      }
    }
    c.Expr[Any](result)
  }
}
