### Exercise 1: Identify the issue and its consequences

Please read the code well and try to understand the issue and the underlying bad consequences such a code can have.

>**Analyse the main issue and what changes you would make below.**

Correct the code to respect the CQS principle.

Code avant changement :

```java
package account;

import java.util.Map;
import java.util.stream.Collectors;

public class Client {
    private final Map<String, Double> orderLines;
    private double totalAmount;

    public Client(Map<String, Double> orderLines) {
        this.orderLines = orderLines;
    }

    public String toStatement() {
        return orderLines.entrySet().stream()
                .map(entry -> formatLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()))
                .concat(System.lineSeparator() + "Total : " + totalAmount + "€");
    }

    private String formatLine(String name, Double value) {
        totalAmount += value;
        return name + " for " + value + "€";
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
```

Problématiques :
- `formatLine` fait de la mise en forme (query) et modifie une propriété de la classe : elle a un effet de bord
  - rend le code très compliqué à comprendre
  - rend compliqué à tester
  - sujet à des bugs et non réutilisabilité de la méthode