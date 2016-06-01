# zeromagic

0Magic is the source of the project. We are using Maven to deal with the dependencies that the project has on various libraries (such as StanfordCoreNLP for sentiment analysis of articles, Java-ML and/or Weka for machine learning stuff, and the library for parsing through HTML websites, as well as a Database interaction library). 

We are using Eclipse to write all of the code for the project.

0magic.class.jet is the code blueprint/UML diagram we made (you need this small software JetUML to open it, http://cs.mcgill.ca/~martin/jetuml/). It is incomplete in that it does not deal with the GUI or machine learning aspects as of yet, but this is because we need the first parts (database interaction and HTML parsing) to work before we go on to that stuff. Because the code is encapsulated, the base architecture presented in the diagram won't need to be significantly modified when we add stuff, it will only expand.
