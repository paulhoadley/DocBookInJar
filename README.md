[![License](https://img.shields.io/badge/License-BSD-blue.svg)](https://opensource.org/licenses/BSD-2-Clause)

DocBookInJar
============

What is this?
-------------
DocBookInJar is merely a demonstration of one approach to running XSLT
transformations on DocBook documents "out of the JAR". That is, we
don't need the stylesheets on the filesystem: they're provided as
resources in the JAR. This demonstration uses:

* DocBook 1.79.2 stylesheets
* Saxon-HE 12.3
* Java 9

Getting started
---------------
To demonstrate that this approach works, you can clone this repository
and run:

```
mvn clean test
```

That's it. It's just a proof of concept.

Background
----------
The motivation for doing this is described in [a post to Stack
Overflow](https://stackoverflow.com/questions/76848364/how-can-i-embed-docbook-xslt-transformation-in-a-java-web-app/).
The approach itself, provided by [Jukka
Matilainen](https://github.com/jkmatila), is described in [this
comprehensive answer](https://stackoverflow.com/a/76857673/18493), and
[this pull
request](https://github.com/paulhoadley/DocBookInJar/pull/1).
