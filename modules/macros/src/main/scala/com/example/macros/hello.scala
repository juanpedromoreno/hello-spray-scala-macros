package com.example.macros

import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

class Hello extends StaticAnnotation {
  def macroTransform(annottees: Any*) = macro HelloMacro.impl
}
