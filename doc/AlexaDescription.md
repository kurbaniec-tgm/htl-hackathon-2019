### Invocation

The invocation is the starting point of your skill.
To start your skill in the "Test" Section you need to use your Invocation name.
Select a name for the invocation by entering it into the input field.

### Intents

Intents describe specific interactions with Alexa. As an example: One intent could be the GreetIntent. This intent triggers an handler back in the lambda function. Whereas each intent is triggered by an _utterance_.

### Utterances

Utterances are combination of words that trigger your intent. You can add multiple utterances to each intent and it will be triggered when Alexa hears one of those utterances. 
Inside an intent you can add sample utterances. Create utterances like "Hello, Guten Tag, Hi, Moin, Grüß Gott, Servus, Hallo Alexa" for a HelloIntent.

#### Slots

You can use placeholders called _slots_. You can choose either slots provided by Amazon like locations, movies, airlines, cities, etc. or you can create your own slot types and fill them with custom data. Slots are required for parsing specific information from a users input. For instance if the user answer is like: "I want to see Iron man". The slot-type for "Iron-man" will be AMAZON.MOVIE and thus Alexa recognizes that the user gave alexa a movie information.

#### JSON Editor

The configuration of your skill (Invocation, Intents, Utterances and Slots) are described in a JSON file which can be directly edited in the JSON editor.

#### Endpoint

1. The endpoint controls the communication with a backend
1. We will work with AWS Lambda in our case, which is the recommended option
1. You are given a skill ID - copy it and head over to your serverless.yml (see below)
1. You should already find this skill ID in the serverless.yml so you don't have to do anything more here

#### Interfaces

The interface menu contains controls for various outputs like audio players or displays. Activate the Display Interface to display the map images.
Since we don't have much time during the hackathon we won't be covering any of the other interfaces.