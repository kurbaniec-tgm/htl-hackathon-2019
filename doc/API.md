# API Doku

## Important Information for required APIs

Use the swagger file for testing and detailed API documentation.
How-to:
1. Go to: https://editor.swagger.io/
2. Copy your swagger.yaml that you can find in your doc folder in the swagger editor
3. Now you are ready to use the APIs. You are able to make API calls and get responses directly with swagger

### Movies
URL: https://efs.film.at/api/v1/cfs/filmat/screenings/nested/movie/2019-01-31\city=Wien 
API-Key: not required
You will get movies, genre, cinemas and screen-times from this API.

### OMDB
URL: http://www.omdbapi.com/
API-Key: dc083806
With this API you are able to get the IMDB rating for a given movie.

### CinemaAddress
URL: https://api.jsonbin.io/b/5c41ac9b81fe89272a8f1b65/
API-Key: not required
You get a JSON response with coordinates and addresses for every cinema in vienna.

### Bing Maps:
URL: https://docs.microsoft.com/en-us/bingmaps/rest-services/
API-Key: AlAjGN01UHlZTHLekvUHvBuMZAY1dlZFK70aS2cLcx2VWN5sw3G9hwvLXPK1qdIL
You can use the Bing Maps API for the static map picture and the public transport navigation.
To get the correct locations you need to swap the longitude and latitude coordinates from the addresses JSON.

### Open Routes:
URL: https://openrouteservice.org/dev/#/api-docs
API-Key: 5b3ce3597851110001cf6248da7dc8a7d74e490997af6273e3330f98
With the open routes API you can navigate from your starting point (e.g. Schottenring 18) to the destination point (cinema you want to go to).

### OpenWeather
URL: openweathermap.org
API-Key: fd9fa1baba434b74b359c8112aef30bf
A weather API that gives you the weather information for today.