# T2

> Patricio López Juri (1263476J)

## Resultados

Ver [`RESULTS.html`](./RESULTS.html).

## Análisis

### 1.A

Las ventajas es que permite abstraerse de definir valores del dominio manualmente. Esto permite evitar sesgos del implementador del test y posiblemente probar elementos que una persona común no probaría.

Con esto podemos probar más valores que los típicos que uno suele considerar. Por ejemplo si queremos probar una función cuyo dominio sean los enteros, una persona usaría:

```java
int[] pruebas = [-2, -1, 0 , 1, 2];
```

Con eso en teoría puede abordar los números bordes y críticos de los enteros, pero deja de lado números aleatorios y _novedosos_. Además ayuda a la mantenibilidad a encapsular el dominio en una clase generadora.

Otra ventaja es la formalidad matemática. Como ejemplo si se hace un correcto estudio del dominio del _input_, es posible obtener un mayor grado de coverage y mejor correctitud.

### 1.B

Nuevamente, puede confirmar correctitud del funcionamiento pero no puede asegurar la ausencia de _bugs_.

Finalmente, su garantía es que dentro del espacio de input definido y con cierta probabilidad, el software funciona.

Al ser dominios de _input_ cuyos elementos finales son tomados de manera no-determinista, puede resultar difícil testear el software e incluso se necesitaría correr la _suite_ de testing numerosas veces para intentar mininizar la probabilidad de pasar por alto un valor que genere desperfectos.

Por ejemplo puede pasar por alto un valor como `Integer.MAX_VALUE` que puede causar problemas de _overflow_ en el computador. Este comportamiento no suele definirse formalmente en matemática y por ende es una fuente de _bugs_.

Otro ejemplo es que si el mismo espacio de input no está bien definido entonces no podemos asegurar que el software funcione. Al menos no se me ocurre una manera de testar que el dominio esté definido "programaticamente" y no de manera matemática.
