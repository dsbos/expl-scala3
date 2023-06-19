FROM Scala 3 Reference @ https://docs.scala-lang.org/scala3/reference/:

* New Types
  - Intersection Types (A & B, replaces "A with B")
  - Union Types        (A | B)
  - Type Lambdas       (\[T, ...] =>> ...)
  - Match Types
  - Dependent Function Types (now functions, not just methods)
  - Polymorphic Function Types (with [T]; now functions, not just methods)
  - 
* Enums
  - Enumerations
  - Algebraic Data Types
  - Translation of Enums and ADTs

* Contextual Abstractions
  - Given Instances:
    - (replace implicit val/def in contexts)
    - (in more places: "for" generator'; match case)
    - (negation/NotGiven)
  - Using Clauses
    - (replace method implicit parameters)
    - ("summon[...]" replaces "implicitly[]")
    - (other changes)
  - Context Bounds (what changes?)
  - Importing Givens
  - Extension Methods (replace "implicit class ...")
  - Right-Associative Extension Methods: Details
  - Implementing Type classes
  - Type Class Derivation
  - How to write a type class `derived` method using macros
  - Multiversal Equality (CanEqual, strictEquality, .contains vs. .has)
  - Context Functions
  - Implicit Conversions (given Conversion[-A, +B] = ...)
  - By-Name Context Parameters
  - Relationship with Scala 2 Implicits

* Metaprogramming
  - Inline (in-lines methods; "inline", "tranparent" narrow expr. types) - 
    - (in-lines methods, affects exprs., +; "transparent" can narrow types)
  - Compile-time operations (um...)
  - Macros (quotes, splices, ...)
  - Runtime Multi-Stage Programming (-)
  - Reflection (reflection on macro ASTs)
  - TASTy Inspection (reading .tasty-file data)
  - The Meta-theory of Symmetric Metaprogramming

* Other New Features
  - Trait Parameters (obviate early initializers)
  - Transparent Traits (hides in inferred types; e.g., Product, Serializable)
  - Universal Apply Methods ("new NoncasecClasse()" -> "NoncaseClass")
  - Export Clauses (aliases; like identity delegate methods/etc.)
  - Opaque Type Aliases (like "newtypes")
  - Open Classes ("open", adhocExtensions, opposite end as "final")
  - Parameter Untupling
  - Kind Polymorphism
  - The Matchable Trait
  - The @threadUnsafe annotation (allows faster lazy-val initialization)
  - The @targetName annotation (gives "external name" for (symbolic) item)
    - can fix erasure overload problems
  - New Control Syntax (if/then, for/yield, while/do; try/catch; no do-while)
  - Optional Braces (allows indentation-based ~nesting; rejects some bad indentation)
    - colon in "class C:", others; "end ..."
    - combination with "quiet" control syntax (no parens and no "then")
  - Safe Initialization
  - TypeTest
  - Experimental Definitions ("@experimental" marker on definitions)

* Other Changed Features
  - Numeric Literals (\[experimental] FromDigits; user-define digits interpretation)
  - Programmatic Structural Types
  - Rules for Operators ("infix" required for infix of non-symbolic; ... \n <OP> ... now allowed
  - Wildcard Arguments in Types ("List\[_]" -> "List\[*]")
  - Imports                     ("_" -> "*"; "{Orig => New}" -> {Orig as New}")
  - Changes in Type Checking
  - Changes in Type Inference
  - Changes in Implicit Resolution
  - Implicit Conversions ("given ... Conversion\[-From, +To] ...")
  - Changes in Overload Resolution (consults multiple parameters lists; +)
  - Match Expressions (precedence adjusted)
  - Vararg Splices ("arr: _*" -> arr*)
  - Pattern Bindings
  - Option-less pattern matching (non-Option unapply, unapplySeq)
  - Automatic Eta Expansion ("methodM _" syntax no longer needed)
  - Changes in Compiler Plugins
  - Lazy Vals Initialization (reduced chance of deadlock)
  - Main Methods  ("@main" on method; replaces App class?)
  - Escapes in interpolations ('$"' inserts '"')

* Dropped Features
  - Dropped: DelayedInit (modified; use @main or explicit main method)
  - Dropped: Scala 2 Macros (replaced with new macros/etc.)
  - Dropped: Existential Types (those with "forSome { ... }")
  - Dropped: General Type Projection ("T#A" if T is abstract type)
  - Dropped: Do-While (use "while ({ <body> ; <cond> }) ()")
  - Dropped: Procedure Syntax ("def f() { ... }")
  - Dropped: Package Objects (use top-level declarations)
  - Dropped: Early Initializers (use trait parameters)
  - Dropped: Class Shadowing (rare; rename an involved class)
  - Dropped: Limit 22 (no limit left? just gone on functions and tuples?)
  - Dropped: XML Literals (use xml"""...""")
  - Dropped: Symbol Literals (use constructor; migrate toward String literals)
  - Dropped: Auto-Application (null method call needs parens if decl. has parens)
  - Dropped: Weak Conformance (relates to Int in "List(1.0, 2, -3)", etc.)
  - Deprecated: Nonlocal Returns (use NonLocalReturns)
  - Dropped: private\[this] and protected\[this]
  - Dropped: Wildcard Initializer ("var x: A = _"; use scala.compiletime.uninitialized)

* Experimental
  - CanThrow Capabilities (saferExceptions)
  - Erased Definitions (related to compile-time-only phantom types?)
  - Named Type Arguments (like named association for term-level parameters)
  - Numeric Literals (see in "Other Changed Features" section)
  - Explicit Nulls (-Yexplicit-nulls, "T | Null" or unsafeNulls when wanted; .nn at boundary)
  - MainAnnotation (extendable base of @main; can parse input arguements)
  - Capture Checking
  - Tupled Function

* Scala 3 Syntax Summary
  - new terminals:
    - reserved words: enum, export, given, then
    - reserved tokens: =>> (type lambdas), ?=> (context function type)
    - (soft) keywords:
      - soft modifiers:  infix, inline, opaque, open, transparent
      - other: as, derives, end, extension, throws, using
      - changed? same?: |, +, -, *

Missed or not top-level in Scala 3 reference:
- concept of soft keywords(?)
- top-level definitions (obviate package objects)
- syntax . single lambda parameter with type needs parentheses
- tiny . no more "+" and "-" as type parameter names



Dead drafts (seen in presentations, etc.):
  - delegates
  - syntax "def (extendee: Type) extensionMethod(...)" for extension methods

================================================================================
SEMI-SORTED
...

Unsorted: 
- no more reflective calls
- "Return Type of an Override Method" change
- Value eta-expansion change
- no more any2stringadd conversion
- no more "_ As A Type Parameter"
- no more auto-tupling
- no more infix operators with multiple parameters
- parameter untupling
- types . "null safety" - explicit nulls
- types? . no more non-private constructor in private class
- types? . Abstract Override change
- types . case class companion object extension/inheritance changes
- Explicit Call to unapply
- Invisible Bean Property
- types . "=> T as Type Argument" change
- case class unapply changes
- @BeanProperty changes
- @unchecked needed for unsafe pattern definition in val(/var?) definitions
- Selectable (dynamic stuff)
- Matchable

-------------------------

FROM https://www.scala-lang.org/blog/2021/10/21/scala-3.1.0-released.html:
New experimental feature: safer exceptions
Efficient bytecode for matching over strings
Support for -Wconf and @nowarn
Simplified Manifest synthesis
Mirrors for Hierarchical Sealed Types
Other changes

FROM https://www.scala-lang.org/blog/2022/06/21/scala-3.1.3-released.html:
Improved f-interpolator
Better error reporting in inlined code
Possibility to generate arbitrary class implementations in macros

FROM https://www.scala-lang.org/blog/2022/09/05/scala-3.2.0-released.html:
Support for code coverage
Exports in extension clauses
Code completion for refined types
Improved Mirror synthesis
Easier use of class constructors with using clauses
Given instances in for-comprehension
Statistics about code complexity
New experimental APIs
