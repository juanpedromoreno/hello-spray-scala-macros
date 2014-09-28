package com.example.macros

import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

class hello extends StaticAnnotation {
  def macroTransform(annottees: Any*) = macro helloMacro.impl
}
