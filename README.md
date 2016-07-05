# Algo3TP2
TP final de Algoritmos y Programación 3 de FIUBA

## Build Status

Next: [![Build Status](https://travis-ci.org/DiegoAlfonso2/Algo3TP2.svg?branch=next)](https://travis-ci.org/DiegoAlfonso2/Algo3TP2)

Master: [![Build Status](https://travis-ci.org/DiegoAlfonso2/Algo3TP2.svg?branch=master)](https://travis-ci.org/DiegoAlfonso2/Algo3TP2)

## Coverage Status

Next: [![codecov.io](http://codecov.io/github/DiegoAlfonso2/Algo3TP2/coverage.svg?branch=next)](http://codecov.io/github/DiegoAlfonso2/Algo3TP2?branch=next)

Master: [![codecov.io](http://codecov.io/github/DiegoAlfonso2/Algo3TP2/coverage.svg?branch=master)](http://codecov.io/github/DiegoAlfonso2/Algo3TP2?branch=master)

## Workflow de control de cambios propuesto

Basado en [A successful Git branching model](http://nvie.com/posts/a-successful-git-branching-model/) con algunas modificaciones.

En `master` van las entregas.
- Siempre tiene que pasar las pruebas de integracion (always-green), las de cobertura y el linter.
- No recibe commits. No recibe push. Sólamente se mergean cosas desde Pull Requests revisados.
- Solamente recibe pull requests de cosas en next

En `next` van los cambios que ya estan listos para una entrega, pero todavía no forman un release completo. 
- Siempre tiene que pasar las pruebas de integracion (always-green). Podría no pasar cobertura o linter.
- No recibe commits. No recibe push. Sólamente se mergean cosas desde Pull Requests revisados.

Las nuevas funcionalidades van en ramas `dev/`, por ejemplo `dev/mapa-con-texturas`. Una vez que termina el desarrollo, la rama se mergea con next a traves de un PR y se borra.

Las correcciones de errores van en ramas `bugfix/`, por ejemplo `bugfix/issue-2` o `bugfix/algoformer-fuera-de-rango-del-mapa`. Una vez que termina el desarrollo, la rama se mergea con next a traves de un PR y se borra.

## Integrantes del Grupo:

Cabrera, Agustín (92512, agustin.cabrera@hotmail.com)
Oderigo, Diego Alfonso (83969, diego.alfonso@gmail.com)
Raña, Cristian Ezequiel (95457, cristian.rana@hotmail.com)
