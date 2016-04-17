# Voting System [![Build Status](https://travis-ci.org/Arquisoft/VotingSystem_1a.svg?branch=master)](https://travis-ci.org/Arquisoft/VotingSystem_1a) [![Codacy Badge](https://api.codacy.com/project/badge/grade/8fe739c734294d5d8e364b4e59592dbd)](https://www.codacy.com/app/jelabra/VotingSystem_1a) [![codecov.io](https://codecov.io/github/Arquisoft/VotingSystem_1a/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/VotingSystem_1a?branch=master) [![Sauce Test Status](https://saucelabs.com/buildstatus/carlvilla)](https://saucelabs.com/u/carlvilla?auth=0233acf3-4700-42f6-90e9-761227147d49)

## Descripción
Sistema de votación que permite la administración de elecciones y que los usuarios puedan votar online. Este proyecto está divido en 2 módulos:

* AdminSystem: permite configurar los parámetros de las elecciones. Estos son las opciones de voto, fecha y localizaciones en los que se puede realizar la votación físicamente. También permite incorporar los votos obtenido en papel.

* VoteSystem: aplicación web en la cual los usuarios podrán realizar las votaciones y donde los miembros de la mesa electoral podrán comunicar aquellos usuarios que realizan la votación en papel.

### AdminSystem


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




