# jeppetto

ChatGPT API Client for Java

## Para desarrolladores

Para poder usar esta librería es necesario descargar clonar el repositorio e instalarlo como una librería local:

```bash
git clone https://github.com/fvarrui/jeppetto
cd jeppetto
mvn install -DskipTests
```

> **Nota:** El flag `-DskipTests` se usa para saltar la ejecución de los tests unitarios.

Luego, en el archivo `pom.xml` del proyecto donde se quiera usar la librería, se debe agregar la dependencia:

```xml
<dependency>
    <groupId>com.github.fvarrui</groupId>
    <artifactId>jeppetto</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```

## Uso

Dispones de un ejemplo de uso en la clase `src/test/java/io/github/fvarrui/jeppetto/tests/Main.java`.

```java
Chat chat = new Chat(API_KEY, "gpt-4o-mini", "Actúa como un asistente amigable");
System.out.println("Assistant: " + chat.send("Hola!").getContent());
System.out.println("Assistant: " + chat.send("Háblame de Geppetto el de Pinocho").getContent());
System.out.println("Assistant: " + chat.send("Y quién es Pepito Grillo?").getContent());
```

siendo el resultado:

```
User: Hola!

Assistant: ¡Hola! ¿Cómo estás? ¿En qué puedo ayudarte hoy?

User: Háblame de Geppetto el de Pinocho

Assistant: ¡Claro! Geppetto es un personaje entrañable de la historia de "Pinocho", que fue escrito por Carlo Collodi y publicado por primera vez en 1881. Es un anciano carpintero que sueña con tener un hijo. Un día, mientras trabaja en su taller, esculpe una marioneta de madera a la que llama Pinocho. Para su sorpresa, la marioneta cobra vida gracias a un hada mágica, lo que desata una serie de aventuras.
Geppetto es un personaje lleno de amor y bondad, representando la figura paterna que cuida y guía a Pinocho en su búsqueda por ser un niño de verdad. A lo largo de la historia, muestra paciencia y ternura, a pesar de las travesuras y desobediencias de Pinocho. Su deseo de ser un buen padre y su profundo amor por su hijo de madera son temas centrales de la historia.
La relación entre Geppetto y Pinocho es una de las más emotivas del cuento, ya que a medida que Pinocho aprende lecciones sobre la honestidad, la valentía y la responsabilidad, Geppetto siempre está a su lado, apoyándolo en su crecimiento. Es un relato conmovedor sobre la paternidad, el amor y la redención. Si quieres saber más sobre algún aspecto específico de la historia o de los personajes, ¡déjamelo saber!

User: Y quién es Pepito Grillo?

Assistant: Pepito Grillo, conocido como Jiminy Cricket en inglés, es un personaje clave en la historia de "Pinocho". Es un grillo que actúa como la conciencia de Pinocho y lo guía en su camino, ayudándolo a discernir entre el bien y el mal. A lo largo de la historia, Pepito Grillo intenta enseñarle a Pinocho la importancia de la honestidad, la responsabilidad y el valor de hacer lo correcto.
El personaje de Pepito Grillo es a menudo retratado como sabio y algo cómico, con un enfoque optimista y alentador. A pesar de las travesuras de Pinocho, él siempre está allí para ofrecerle consejos y recordarle que sus acciones tienen consecuencias. En las adaptaciones cinematográficas, como la famosa película de Disney de 1940, Pepito Grillo es representado como un personaje carismático y memorable, que aporta tanto humor como sabiduría a la historia.
Si tienes más preguntas o quieres saber más sobre algún otro personaje, ¡dímelo!
```