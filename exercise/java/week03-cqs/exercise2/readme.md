### Exercise 2: Double-edge method

Some methods can be both query & command and are especially hard to separate. Analyse the code below and see how you can refactor it to show the real intention. 

>**Try to write your unit tests and see the changes you want to emerge from them.**


La méthode est non intuitive : on a du mal à comprendre son comportement et même dans quel cas elle pourrait possiblement être utile.
Il est très étrange de récupérer une valeur alors que l'on fournit cette valeur en paramètre, qui est la plus probablement tout le temps vraie.