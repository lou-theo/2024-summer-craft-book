## Week 2: Object Calisthenics.

> Let's look at the steps needed to read better code

### The concepts

9 Steps to improve code readibility

Object Calisthenics are a set of principles intended to help developers write cleaner, more maintainable code. They were introduced by Jeff Bay in his book "The ThoughtWorks Anthology". The rules focus on maintaining simplicity and clarity in code design. They are as stated below:

   1) Only One Level Of Indentation Per Method
   2) Don’t Use The ELSE Keyword
   3) Wrap All Primitives And Strings
   4) First Class Collections
   5) One Dot Per Line
   6) Don’t Abbreviate
   7) Keep All Entities Small
   8) No Classes With More Than 2 Instance Variables
   9) No Getters/Setters/Properties

As illustrated in this [article](https://williamdurand.fr/2013/06/03/object-calisthenics/)

### Reflexion

Which one do you agree and disagree and why? 
Write down your observation about the steps above by your own experience

* Only One Level Of Indentation Per Method
  * réflexion clairement intéressante, étant assez adepte des extractions de méthodes pour donner plus de lisibilité
  * se limiter à 1 niveau est peut-être extrème dans certaines conditions, cela vaut le coût d'essayer. Il ne faut clairement pas plus de 2 niveaux en tout cas
  * => APPROUVE

* Don’t Use The ELSE Keyword
  * Pour les cas où l'on n'a que 2 branches à gérer comme cela est montré dans les exemples de l'article, clairement d'accord, mais je reste sur ma faim quant à des cas plus complexes qui ne peuvent pas se gérer par des switch
  * Il n'est en fait pas claire pour moi de savoir si le point inclus les `else if` ou non
  * => PAS CERTAIN

* Wrap All Primitives And Strings
  * Cela me semble être une bonne pratique
  * Déjà appliqué partiellement (surtout pour les id) mais jamais dans son extrème, cela vaut le coup d'essayer
  * J'ai une grosse problématique pour appliquer cela en JS/TS : par nature les paramètres qui ont la même "forme" (même si de type différent) sont acceptés. J'ai déjà vu des propositions pour le faire avec du duck typing mais cela me semble ajouter pas mal de bruit/complexité. Je suis donc assez mitigé pour ce langage
  * => APPROUVE

* First Class Collections
  * Jamais entendu parler de ce concept avant donc pas d'expérience
  * Concept qui semble assez intéressant pour éviter de permettre un accès trop direct aux données et de trop nombreuses méthodes liées à la collection dans la classe possédant cette dernière
  * Question de savoir si ça ne va pas faire un peu trop de boilerplate pour des cas simples
  * => A TESTER

* One Dot Per Line
  * Le principe semble intéressant de prime abords, mais j'ai peur qu'il ne soit que difficilement applicable dans un bon nombre de cas
  * L'exemple qui est donné avec le Board / Piece / Location me semble assez mauvais.
    * La classe tout en bas se voit forcée de connaitre l'implémentation de la représentation des données des classes du dessus. Cela me semble être une mauvaise pratique.
    * L'exemple n'a que 3 classes très simples avec peu de propriétés. A quoi ça ressemblerait avec des classes plus complexes ? J'ai la sensation que le nombre de méthodes exploserait
  * => PAS CONVAINCU

* Don’t Abbreviate
  * simple mais vrai
  * => APPROUVE

* Keep All Entities Small
  * Pour le nombre de lignes, je trouve que passer un stade cela complique clairement la lecture et compréhension d'une classe
  * Quelques exceptions sur certains types de classes peut-être ? controller notamment
  * Pour le nombre de fichiers par dossier, je suis plus mitigé. Il y a des endroits où cela semble clairement pertinent, mais est-ce le cas pour tous les endroits ? Demande à être testé
  * => APPROUVE

* No Classes With More Than 2 Instance Variables
  * Cette règle me semble vraiment extrème, surtout en parallèle de la règle "One Dot Per Line"
  * Je suis curieux de voir un projet qui respecte les 2 règles, mais en l'état je ne suis pas du tout convaincu et je pense que cela ajoute beaucoup de boilerplate (et complexité) pour pas grand-chose
  * => PAS CONVAINCU

* No Getters/Setters/Properties
  * Clairement d'accord sur le fait d'interdire les setters, ces derniers ne permettant pas ou rarement de véhiculer un sens métier et tendant à rendre les classes anémiques avec des constructeurs vides
  * La précision stipulant que c'est Ok d'utiliser des getters à partir du moment où l'accès à ces données n'est pas utilisé pour prendre des décisions en dehors de la classe me semble important, pour avoir été sur un projet où l'on a essayé d'avoir ni getter ni setter sur les objets du domaine, cela complexifie beaucoup les choses...
  * => APPROUVE

### Exercise 1: Fight Indentation

Exercise => Head to the /exercise folder to the week 2 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 2 - exercise 1 to get the code version

[Exercice pour java complété](../../exercise/java/week02-object-calisthenics/exercise1/readme.md)

### Exercise 2: Identify the steps

Exercise => Head to the /exercise folder to the week 2 - exercise 2 to get the code version

Solution => Head to the /solution folder to the week 2 - exercise 2 to get the code version

[Exercice pour java complété](../../exercise/java/week02-object-calisthenics/exercise2/readme.md)
