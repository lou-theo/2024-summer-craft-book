1. Typo : dans `FileStore` le type de la propriété `messageReadListener` a un problème de casse
2. Commentaires des méthodes `read` et `save` de `FileStore` sont inutiles
3. `FileStore` devrait avoir autre chose qu'un `NoArgsConstructor` et n'avoir aucune propriété en public ni exposée avec un setter
4. Les exceptions devraient être gérées au niveau des méthodes `read` et `save`, car elles sont de leur responsabilité
5. l'extension des fichiers (`.txt`) devrait être une constante ou on pourrait avoir une méthode privée chargée de construire le chemin du fichier (actuellement code dupliqué)