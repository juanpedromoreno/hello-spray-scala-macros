package com.example.macros

import scala.reflect.macros.Context
import scala.language.experimental.macros

object helloMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._
    val result = {
      annottees.map(_.tree).toList match {
        case q"trait $name extends ..$parents { ..$body }" :: Nil =>
          q"""
            object $name extends ..$parents {
              def hello: ${typeOf[String]} = "hello from spray macro"
              ..$body
            }
          """
      }
    }
    c.Expr[Any](result)
  }
}
