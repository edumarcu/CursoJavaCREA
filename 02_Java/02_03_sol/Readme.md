# Ejercicio 2.3

Empaquete el programa HelloWorld en un archivo jar ejecutable y ejecútelo desde línea de comandos.

1. Compile HelloWorld.java desde la línea de comandos
$ cd C:/Ruta/a/la/carpeta
$ javac HelloWorld.java

2. Genere un nuevo archivo jar con la clase HelloWorld:
$ jar cvf HelloWorld.jar HelloWorld.class
manifest agregado
agregando: HelloWorld.class (entrada = 426) (salida = 288) (desinflado 32%)

3. Intente ejecutar el jar:
$ java -jar HelloWorld.jar
Failed to load Main-Class manifest attribute from
HelloWorld.jar

El archivo no es ejecutable, pero podemos usar sus clases:

$ java -cp HelloWorld.jar HelloWorld
Hello World!

4. Cree un archivo MANIFEST.MF para que el archivo jar sea ejecutable. Debe contener el siguiente contenido:

Main-Class: HelloWorld

5. Vuelva a crear el archivo jar incluyendo el archivo Manifest:
$ java cvfm HelloWorld.jar MANIFEST.MF HelloWorld.class
manifest agregado
agregando: HelloWorld.class (entrada = 426) (salida = 288) (desinflado 32%)

6. Vuelva a ejecutar el archivo .jar:
$ java -jar HelloWorld.jar 
Hello World!