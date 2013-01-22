# Ejercicio 2.6 - Hola Mundo (Maven)

En este ejercicio instalará creará un proyecto maven.

1. Abra Netbeans
2. Cree un nuevo proyecto de tipo "Maven > Java Application" con la siguiente información:
Project Name: 02_06
Project Location: <carpeta de este ejercicio>
Group ID: curso
Package: curso.ej02_06
3. Consulte la nueva estructura de carpetas.
* ¿Dónde se almacena el código fuente?
* ¿Dónde se configura el proyecto?

4. Modifique el código existente y cree las clases necesarias para que el programa imprima "Hello World!" al ejecutarse.

5. Compile y ejecute el proyecto.
* ¿Dónde se almacenan las clases compiladas?

6. Genere un jar ejecutable utilizando maven y ejecútelo con java -jar desde línea de comandos. Para ello, añada la siguiente configuración al pom.xml (y reconstruya el proyecto):

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>2.4</version>
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>curso.ej02_06.App</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </build>