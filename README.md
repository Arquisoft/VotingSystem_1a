# Voting System [![Build Status](https://travis-ci.org/Arquisoft/VotingSystem_1a.svg?branch=master)](https://travis-ci.org/Arquisoft/VotingSystem_1a) [![Codacy Badge](https://api.codacy.com/project/badge/grade/8fe739c734294d5d8e364b4e59592dbd)](https://www.codacy.com/app/jelabra/VotingSystem_1a) [![codecov.io](https://codecov.io/github/Arquisoft/VotingSystem_1a/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/VotingSystem_1a?branch=master) [![Sauce Test Status](https://saucelabs.com/buildstatus/carlvilla)](https://saucelabs.com/u/carlvilla?auth=0233acf3-4700-42f6-90e9-761227147d49)

## Descripción
Sistema de votación que permite la administración de elecciones y que los usuarios puedan votar online. Este proyecto está divido en 2 módulos:

* AdminSystem: permite configurar los parámetros de las elecciones. Estos son las opciones de voto, fecha y localizaciones en los que se puede realizar la votación físicamente. También permite incorporar los votos obtenido en papel.

* VoteSystem: aplicación web en la cual los usuarios podrán realizar las votaciones y donde los miembros de la mesa electoral podrán comunicar aquellos usuarios que realizan la votación en papel.

### AdminSystem

Para ejecutar la aplicación utilizamos el comando <b>java -jar AdminSystem/target/adminSystem-0.0.1.jar </b> y una las siguientes opciones:
* Si queremos añadir la configuración del sistema añadimos la opcion <b>conf</b> seguido de la ubicacion de los ficheros y el tipo de fichero que sean, en este orden.
  * Fichero de configuracion de la votacion: Ej. <b>AdminSystem/conf.xls</b> , desde un .xls <b>-x</b>.
  * Fichero de las opciones de voto: Ej. <b>AdminSystem/conf.xls</b> , desde un .xls <b>-x</b>.
  * Fichero de los lugares donde se realiza la votación: Ej. <b>AdminSystem/conf.xls</b> , desde un .xls <b>-x</b>.

Ejemplo completo: <b>java -jar AdminSystem/target/adminSystem-0.0.1.jar conf AdminSystem/conf.xls -x AdminSystem/options.xls -x AdminSystem/places.xls -x</b>

* Si queremos añadir el recuento de votos al sistema añadimos la opcion <b>count</b> seguido de la ubicacion del fichero con los votos y el tipo de fichero que es.
  * Fichero de recuento de votos: Ej. <b>AdminSystem/votes.xls</b> , desde un .xls <b>-x</b>.

Ejemplo completo: <b>java -jar AdminSystem/target/adminSystem-0.0.1.jar count AdminSystem/votes.xls -x</b>


### VoteSystem

Para ejecutar la aplicación utilizamos el comando <b>mvn spring-boot:run</b> en la carpeta VoteSystem del proyecto y nos dirigimos a la URI <a href="http://localhost:8080">http://localhost:8080</a> de un navegador. 

En el siguiente <a href="https://saucelabs.com/u/carlvilla?auth=0233acf3-4700-42f6-90e9-761227147d49">enlace</a> puede ver demos de la utilización de la aplicación. Estos demos son las ejecuciones de los tests realizados en la plataforma de pruebas automatizadas Sauce.

### Base de datos

La base de datos utilizada la puedes encontrar en el siguiente <a href= "https://www.dropbox.com/s/x0v8g983pde20cw/Base%20de%20datos%20%28hsqldb%29.zip?dl=0"> enlace </a>


## Authors

* Jose Labra
* Pablo Blanco Pacho
* Jairo Montes Presa
* Carlos Villa Blanco




