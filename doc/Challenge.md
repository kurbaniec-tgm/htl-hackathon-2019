# HTL-HACKATHON 2018 Challenge

## Angabe

Nach einer anstrengenden Schulwoche möchtest du am Freitag Abend mit deinen Freunden einen Film im Kino ansehen. Wie cool wäre es wenn es eine App gäbe, welche mich bei deiner Entscheidung unterstützen könnte.

Glücklicherweise hast du zu Weihnachen einen Amazon Echo bekommmen. Bei der Suche nach einem geeigneten Alexa Skill fällt dir auf, dass es hier keinen passenden Skill gibt. Du witterst die Chance und möchtest selbst einen Skill entwickeln, welcher dich bei deiner Suche nach Kino Filmen unterstützt!

## Aufgabe

Entwickle einen Alexa Skill zu dem oben genannten Thema und präsentiere ihn einer Jury. Dabei solltest du folgende Punkte beachten:

- Mach dir vorab Gedanken über den Funktionsumfang des Skills. Wir haben dir eine Reihe an [Schnittstellen](./API.md) zur Verfügung gestellt mit welchen du deinen Skill mit mehr Feature versehen kannst. Gerne kannst du auch eigenen Schnittstellen verwenden.
- Mach dir Gedanken über das Sprachinterface des Skills (dazu gibt es hier gute Tipps: ([Link](https://developer.amazon.com/de/docs/alexa-design/voice-experience.html)))
- Entwickle das Sprachinterface auf der Alexa Console
- Entwickle dein Backend indem du eine oder mehrere Serverless-Functions verwendest
- Der Skill wird auf dem Surface Hub über ein FireTV präsentiert. Überlege wie du nicht nur Antworten auf der Tonspur zurückgibst sonder auch wie du die visuelle Ausgabe von Alexa am Surface Hub verwenden kannst ([Link](https://developer.amazon.com/docs/custom-skills/include-a-card-in-your-skills-response.html))
- Überlege dir eine gute Präsentation mit welcher du die Jury beeindruckst

## Tipps

Mit den folgenden Feature solltet ihr beginnen:

- Der Nutzer kann ein vorgeschlagenes Genre wählen
- Der Nutzer kann eine Uhrzeit wählen
- Der Nutzer bekommt einen Film zum gewählten Genre und zur gewählten Uhrzeit vorgeschlagen
- Für den vorgeschlagenen Film werden ein oder mehrere Kinos samt der Spielzeiten vorgeschlagen

Features:
- Der Nutzer möchte wissen wie er ins gewünschte Kino kommt (Route)
- Der Nutzer möchte nur gute Filme vorgeschlagen bekommen. (Bewertungen)
- Optional kann man dem Nutzer noch Wetterinformationen zukommen lassen (Wetter)
Überlege dir wie man diese APIs sinnvoll in den Alexa Skill integrieren kann um dem Nutzer ein gutes Erlebnis zu ermöglichen.


## API Doku

### Important Information for required APIs

Use the swagger file for testing and detailed API documentation.
How-to:
1. Go to: https://editor.swagger.io/
2. Copy your swagger.yaml that you can find in your doc folder in the swagger editor
3. Now you are ready to use the APIs. You are able to make API calls and get responses directly with swagger

### Movies
- URL: https://efs.film.at/api/v1/cfs/filmat/screenings/nested/movie/2019-01-31\city=Wien 
- API-Key: not required
- You will get movies, genre, cinemas and screen-times from this API.

### OMDB
- URL: http://www.omdbapi.com/
- API-Key: dc083806
- With this API you are able to get the IMDB rating for a given movie.

### CinemaAddress
- URL: https://api.jsonbin.io/b/5c41ac9b81fe89272a8f1b65/
- API-Key: not required
- You get a JSON response with coordinates and addresses for every cinema in vienna.

### Bing Maps:
- URL: https://docs.microsoft.com/en-us/bingmaps/rest-services/
- API-Key: AlAjGN01UHlZTHLekvUHvBuMZAY1dlZFK70aS2cLcx2VWN5sw3G9hwvLXPK1qdIL
- You can use the Bing Maps API for the static map picture and the public transport navigation.
- To get the correct locations you need to swap the longitude and latitude coordinates from the addresses JSON.

### Open Routes:
- URL: https://openrouteservice.org/dev/#/api-docs
- API-Key: 5b3ce3597851110001cf6248da7dc8a7d74e490997af6273e3330f98
- With the open routes API you can navigate from your starting point (e.g. Schottenring 18) to the destination point (cinema you want to go to).

### OpenWeather
- URL: openweathermap.org
- API-Key: fd9fa1baba434b74b359c8112aef30bf
- A weather API that gives you the weather information for today.