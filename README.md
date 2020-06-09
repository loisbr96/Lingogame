# LoLingo game
An application to practise the lingo game.
Devloped by loisbr96

![Build](https://github.com/loisbr96/Lingogame/workflows/Workflow/badge.svg)

# Lolingo !

Welkom bij de LoLingo applicatie waar je het wel bekende spel kunt oefenen. 
Ben jij een master in Lingo, zorg dan dat je als hoogste op het score board komt!

Hieronder wordt aan de hand van de beoordeling voor de Lingogame uitgelegd wat er is toegepast en waar. Er wordt niet diep op de stof ingegaan, want daarvoor is het verslag. Het dient voornamelijk als hulpmiddel om alle onderdelen aan te geven.


## Build tools en pipeline
De applicatie gebruikt de **build tool** Maven. Daarnaast is er op Github Action een workflow aangemaakt die zorgt dat er een **pipeline** draait als er naar master wordt gepusht. **Heroku** deployed automatisch de applicatie zodra de pipeline is geslaagd.


## Mate van functionaliteit
Deze webapplicatie kan woorden toevoegen en ophalen. Deze worden gebruikt om een spel te spelen met een random woord en een maximaal aantal rondes. Na elke poging krijgt de gebruiker feedback per letter of deze correct, incorrect of verkeerde plaats heeft. Zodra de gebruiker heeft gewonnen kan de gebruiker de spelersnaam en het spel toevoegen aan het scoreboard. De applicatie heeft een welkomspagina, maar verder geen GUI.  


## Testorganisatie
Er is op verschillende lagen getest. **Unit** voor het domeinen, **integration** voor de repository's, **unit** voor de services en **end-to-end** voor de controllers. 

## Mate van clean test
Er is gebruik gemaakt van Springboottest. Deze heeft speciaal voor de repository een **DataJpaTest** waar er met een **in-memory database**(H2 Database) de repository getest. Voor de end-to-end testen is er gebruik gemaakt van een **WebTestClient** die op een random **LocalServerPort** test of het endpoint werkt. Om de services onafhankelijk te testen zijn er **Stubs** van de repository's gemaakt die neppe data terug stuurt.


## Coverage en mutation testen
[![codecov](https://codecov.io/gh/loisbr96/Lingogame/branch/master/graph/badge.svg?token=QPSXGH19M9)](https://codecov.io/gh/loisbr96/Lingogame) <br>
CodeCov controleert via de **build** standaard de code kwaliteit. Via Codecov is de **badge** beschikbaar in deze README. Er is een coverage van hoger dan 75%. 


## Mate van structuur
Er is gebruik gemaakt van Springboot. Daarnaast is er een package structuur van 4 layers gebruikt. Alles is los van elkaar en de logica zit in de services.

## Mate van netheid
Er is gebruik gemaakt van van de Clean code principles. De namen van methodes en variabelen zijn verklaarbaar. Input wordt bij de methodes gevalideerd en er wordt een exceptie gegooid wanneer de validatie niet goed was. 
SonarLint gebruikt

## Static analysis tools
PMD  en Jdepend via Maven verify

## Perfomance en security analysis
Dependency-check-maven inbuild via maven site en Sonarlint via Intelij

## Deployment
Op Heroku. Daar wordt het via Liberato en Papertrail gemonitord. (beperkte ivm gratis versies)

## Creatieve ruimte
Geen bewuste extra inspanning gedaan. Overnagedacht om Thymeleaves te gebruiken, maar uiteindelijk gekozen alleen een welkomspagina te doen.  
