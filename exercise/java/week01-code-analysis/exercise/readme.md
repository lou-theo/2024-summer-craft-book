### Exercise 1: First things first

You are about to look at a pretty complicated and big code base. Be prepared to look at the big picture before nitpicking every single details you come across.

What do you see? 

>**Write down all the things you would change and prefix them with a number.**

Note: For this exercise, we recommend using the summer book but if you are using only the coding version, feel free to have your own notepad or put TODO comments in the code. It's important that you index them for the part 2 and 3.


1. MovieStore
   1. constructeur vide : Pas de paramètres ni builder (l.9)
   2. beaucoup de if/else dont imbriqués
   3. méthode `displayMovies` inutilisée (l.88)
   4. les if devraient être inversés pour gérer le cas exceptionnel en premier
   5. les noms des attributs `allMovies` et `sales` ne semblent pas des plus pertinents (l.6-7)
   6. Pas d'exception ou autre système permettant de voir que la méthode a échouée (println inutiles)
   7. `buyMovie` décroit le stock avant de vérifier que le film est vendable et sans rollback (l.18-20)
   8. on devrait avoir une méthode pour vérifier si un film est vendable et qui vérifie tout (sur notre classe de stock par exemple)
   9. `addMovie` peut aussi faire un update de manière implicite si l'id est déjà existant, c'est louche / non explicite (l.32)
   10. `allMovies` est une hashmap dont le 1er paramètre est un string : impossible de savoir ce que c'est. Dans notre cas une List ferait probablement bien mieux le travail (l.6)
   11. `removeMovie` est questionnable d'un point de vue métier. Quel est le cas d'usage de cette méthode ? Est-ce qu'il n'y a vraiment aucune vérification à faire sur le stock avant de supprimer un film ? (l.54)
   12. `findMoviesByTitle` pourrait être largement simplifié en utilisant un stream (l.95-101)
   13. `findMoviesByTitle` est probablement peu utile tel quel d'un point de vue métier, on voudrait probablement plus de tolerance sur le titre (ponctuation facultative, titre incomplet, etc.) (l.94)
2. StoreAccount
   1. `allSales` expose une nested class dont la visibilité est privée (l.9)
   2. `totalSold` n'a pas un nom très clair (l.7)
   3. `totalSold` ne devrait pas être une propriété, mais calculé à la volée à partir de l'historique de vente afin d'éviter des problèmes d'incohérences (l.7)
   4. `MovieSale` devrait probablement avoir une référence à `Movie` et non juste un nom (l.20)
   5. `MovieSale` est-elle vraiment pertinente en tant que nested classe ? (l.20)
3. Movie
   1. les propriétés `totalCopies` et `borrowedCopies` ne définissent pas un film mais un stock, on devrait avoir une autre classe pour ça (l.8-9)
   2. `movieID` est visiblement un nombre. Etrange de le manipuler au format string (l.4)
4. MovieStoreTest
   1. `testAddMovie` ajoute un film déjà ajouté dans `setUp` qui est en `@BeforeEach`, c'est très confusant (l.23)
   2. `testBuyMovie` : pourquoi modifier le prix du film pour le test ? cela ne semble avoir aucun intérêt (l.44)
   3. `testReturnMovie` ne test a priori rien étant donné qu'il n'y avait pas de film emprunté et que `borrowedCopies` était donc déjà à 0 (l.54)
   4. `getFirst` plutôt que `get(0)` (l.61)
5. Global
   1. propriétés de classe devraient toutes être privées
   2. on devrait avoir une classe pour le prix plutôt qu'un `Double` (`Movie` l.7, `StoreAccount` l.7)
   3. Il n'y a des tests que sur `MovieStore`
   4. `MovieStore` fait trop de choses et les autres classes (surtout `Movie`) sont quasiment anémiques

### Exercise 2: Arrange by type.

Use the numbers on each smell to arrange them in three categories:

* CS: Code smells
  * 1.1
  * 1.2
  * 1.3
  * 1.4
  * 1.6
  * 1.9
  * 1.10
  * 2.2
  * 3.2
  * 4.1
  * 4.2
  * 5.1
  * 5.4
* I: Improvements
  * 1.5
  * 1.8
  * 1.11
  * 1.12
  * 1.13
  * 2.3
  * 3.1
  * 5.2
* V: Vulnerabilities
  * 1.7
  * 2.1
  * 4.3
  * 5.3

If you are using only the coding version, prefix your TODOs with the code.

### Exercise 3: Use your own category.

You may use another system to prefix the TODOs in your code. Use your own category that seems better for you.