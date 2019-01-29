# Hello World Alexa-How-To

## Alexa Developer Console - Preparation

### Step 1 Create an Alexa Skill:


The Alexa developer console is the place where you develop and configure your Alexa Skill.

1. Go to developer.amazon.com
1. Login with your developer account (you can find your credentials in `/<Your Team>/credentials.json`)
1. Select Alexa
1. Go to the Alexa menu -> "Produkte" -> "Alexa Skills Kit"
1. Select "Skill entwickeln"
1. On the next page, go to the skill you are assigned to
1. This takes you to the overview page of your skill

#### Invocation

The invocation is the starting point of your skill.
To start your skill in the "Test" Section you need to use your Invocation name.

**HelloWorld:** <br>
Select a name for the invocation by entering it into the input field. (The invocation name is provided by your coach).

#### Intents

Intents describe specific interactions with Alexa. As an example: One intent could be the GreetIntent. This intent triggers an handler back in the lambda function. Whereas each intent is triggered by an _utterance_.

**HelloWorld:** <br>
On the alexa developer site under the Build section select "Add" next to the "Intents" Button.
Then type "HelloWorldIntent" for your Intent name (Note: be consistent with your Intent-Names) and select "create custom intent"

#### Utterances

Utterances are combination of words that trigger your intent. You can add multiple utterances to each intent and it will be triggered when Alexa hears one of those utterances. 

**HelloWorld:** <br>
Inside the HelloWorldIntent you have to add sample utterances. Create utterances like "Hello, Guten Tag, Hi, Moin, Grüß Gott, Servus, Hallo Alexa".

Congratulation, you just created your first Alexa Skill. Now you're done with the Alexa developer console and you're ready for the next step.

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

### Step 2 Set up and deploy your first lambda function

You just have created your first alexa skill. Now we need to create the backend - the "brain" of the alexa skill.


#### program your first lambda function

Once you have downloaded the correct folder you will find specific files in there.
In the ´credentials.json´ you will find your specific login informations for the amazon developer console.
Furthermore, you will find the AWS Key and Secret Key for the serverless framework. Additionally, you will find your regular login Information for AWS as well.

#### NodeJS

Here you can see your Handlerfunction. This function will be invoked when alexa thinks the user called the HelloWorldIntent

```javascript
const HelloWorldIntentHandler = {
  canHandle(handlerInput) {
    return (
      handlerInput.requestEnvelope.request.type === "IntentRequest" && //Intentrequest
      handlerInput.requestEnvelope.request.intent.name === "HelloWorldIntent"
    ); //Intent from your Alexa Skillskit
  },
  handle(handlerInput) {
    const speechText = "Hello World!";

    return handlerInput.responseBuilder
      .speak(speechText)
      .withSimpleCard("Hello World", speechText)
      .getResponse();
  }
};
```

You have to add every Handler to your Lambda Handler:

```javascript
let skill;
exports.handler = async function (event, context) {
  console.log(`REQUEST++++${JSON.stringify(event)}`);
  if (!skill) {
    skill = Alexa.SkillBuilders.custom()
      .addRequestHandlers( // here you need to add your handler
        LaunchRequestHandler,
        HelloWorldIntentHandler, // The Handler
        SessionEndedRequestHandler
      )
      .addErrorHandlers(ErrorHandler)
      .create();
  }
```

#### Java

Here you can see your Handlerfunction. This function will be invoked when alexa thinks the user called the HelloWorldIntent

```java
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("HelloWorldIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Hello world";
       return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HelloWorld", speechText)
                .build();
    }
```

You have to add every Handler to your Lambda Handler:

```java
    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new HelloWorldIntentHandler())
                .withSkillId(SKILL_ID)
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }
```

#### Python

Here you can see your Handlerfunction. This function will be invoked when alexa thinks the user called the HelloWorldIntent

```python
class HelloWorldIntentHandler(AbstractRequestHandler):
    """Handler für Hello World Intent."""
    def can_handle(self, handler_input):
        # type: (HandlerInput) -> bool
        return is_intent_name("HelloIntent")(handler_input)

    def handle(self, handler_input):
        # type: (HandlerInput) -> Response
        speech_text = "Hallo"

        handler_input.response_builder.speak(speech_text).set_card(
            SimpleCard("Hello World", speech_text)).set_should_end_session(
            True)
        return handler_input.response_builder.response
```

```python
sb.add_request_handler(LaunchRequestHandler())
sb.add_request_handler(HelloWorldIntentHandler())
sb.add_request_handler(CancelOrStopIntentHandler())
sb.add_request_handler(SessionEndedRequestHandler())

sb.add_exception_handler(CatchAllExceptionHandler())

handler = sb.lambda_handler()
```

### Deploy your Lambda function

When you have edited your code and think you are ready you can deploy your lambda function with the provided serverless.yml with the following commands:


With your Node.js Command prompt:

##### NodeJS

1. switch into `./teamfolder/projectfolder`
2. make sure that the `serverless.yml` is in your projectfolder
3. `sls deploy`

##### Java using Maven

1. switch into `./teamfolder/projectfolder`
2. make sure that the `serverless.yml` and the `pom.xml` is in your projectfolder
3. `sls deploy`

##### Python

1. switch into `./teamfolder/projectfolder`
2. make sure that the `serverless.yml` is in your projectfolder
3. `sls deploy`

### Connect your Lambda Function with your Alexa Skill
With the serverless.yml the correct Alexa Skill ID is already given to the lambda function. So the lambda function knows where it has to give the outputs. However, the alexa skill also needs to know from what function the information is coming so you need to copy your ARN from the lamba function into the alexa endpoint.
1. Go to: https://eu-west-1.console.aws.amazon.com/console/home?region=eu-west-1
2. Login with your credentials and search for lambda.
3. Select your deployed lambda function from the step above.
4. Now you can see your ARN in the upper right corner --> copy it.
5. Go back to the alexa developer site
6. Select "Endpoint" from the right section
7. Paste your ARN in the "Default Region" input field.
8. Save your Endpoints


### Test your Lamba Function

When your function is deployed and connected to your alexa skill you are ready for testing.
Go back to the amazon alexa developer skill site and select the "Test" Button. (Be sure that your Skill is saved and built). Start your skill with your invocation name and then you are ready to make inputs either per voice or text input.


### Debug your Skill

In order to debug your skill there are two sources.
1. On the alexa developer site under the test section you will get two JSON Files when you gave alexa an input. The JSON Input on the left side will display you every input informations such as input values, slot variables and session varibales. On the right side you will find the alexa output as a json.
2. To get console logs you have to use amazon AWS Cloudwatch. You can find a detailed description for that below.

## Amazon AWS Cloudwatch

1. Go to the AWS Website and login in with your credentials (you find them your credentials.json)
1. Go to the AWS Management Console and select "CloudWatch"
1. Select "View logs"
1. Select the latest log
1. You can see the console logs from your application now

### Important notes

- Do not forget to always save and build your model when you make any changes at the alexa dev site
- You do not need to rebuild your model when you edited and deployed your code in the lambda function just reload the "Test" page of your Alexa Skill and you are ready for testing
- In case you don't use serverless frameworkds you have to zip your package directly within your directory and not the whole package folder!
