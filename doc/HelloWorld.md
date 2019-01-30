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

#### 1. Invocation

The invocation is the starting point of your skill.<br>
Select a name for the invocation by entering it into the input field. (In your case the invocation name is the name of your projectfolder).

#### 2. Intents

On the alexa developer site under the "Build" section select "Add" next to the "Intents" Button.
Then type "HelloWorldIntent" for your Intent name (Note: be consistent with your Intent-Names) and select "create custom intent".

#### 3. Utterances

Click at the "HelloWorldIntent". Inside that HelloWorldIntent you have to add sample utterances. Create utterances like "Hello, Guten Tag, Hi, Moin, Grüß Gott, Servus, Hallo Alexa".

#### 4. Build

When you are finished with the previous steps you are now ready to save and build your alexa skill.
Click on the "Build" Tab and select "Build Model" on the right side. The model building could take a few secounds be patient.

Congratulation, you just created your first Alexa Skill. Now you're done with the Alexa developer console and you're ready for the next step.

### Step 2 Set up and deploy your first lambda function

You just have created your first alexa skill. Now we need to create the backend - the "brain" of the alexa skill.


#### program your first lambda function

Once you have downloaded the correct folder you will find specific files in there.
As you already know in the `credentials.json` you will find your login informations.
Furthermore, you will find the AWS Key and Secret Key for the serverless framework. Additionally, you will find your regular login Information for AWS as well. <br>

Now open your project folder with an editor of your choice and navigate to the index file.

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

When you are done with coding you are ready to deploy your lambda function.

### Deploy your Lambda function

In order to deploy your lambda function you can find a provided serverless.yml in your project folder.
This .yml gives all the needed information to the serverless framework.
Now deploy your function with the following commands:


With your Node.js Command prompt:

##### NodeJS
(Note: You have to install the project dependencies first for javascript)
1. switch into `./teamfolder/projectfolder`
1. type `npm install` to get all project dependencies
1. now a npm_modules folder should appear in your directory
1. make sure that the `serverless.yml` is in your projectfolder
1. `sls deploy` --> your function is now deployed in the AWS Cloud
1. To get the required ARN that connects your Alexa Skill with your lambda function you need to type `sls info --function functionname --verbose`
1. copy the ARN-URL and go to the alexa developer site. Go to endpoint on the right side and select AWS Lambda. Then copy the ARN in the default region and click "Save Endpoints".

##### Java using Maven

1. switch into `./teamfolder/projectfolder`
2. make sure that the `serverless.yml` and the `pom.xml` is in your projectfolder
3. `mvn assembly:assembly -DdescriptorId=jar-with-dependencies package`
4. `sls deploy` --> your function is now deployed in the AWS Cloud
1. To get the required ARN that connects your Alexa Skill with your lambda function you need to type `sls info --function functionname --verbose`
1. copy the ARN-URL and go to the alexa developer site. Go to endpoint on the right side and select AWS Lambda. Then copy the ARN in the default region and click "Save Endpoints".

##### Python

1. switch into `./teamfolder/projectfolder`
2. make sure that the `serverless.yml` is in your projectfolder
3. `sls deploy` --> your function is now deployed in the AWS Cloud
1. To get the required ARN that connects your Alexa Skill with your lambda function you need to type `sls info --function functionname --verbose`
1. copy the ARN-URL and go to the alexa developer site. Go to endpoint on the right side and select AWS Lambda. Then copy the ARN in the default region and click "Save Endpoints".

<br>
***Now, everytime you make changes in your function you can just type: sls deploy - and the serverless framework uploads and deploys your lambda function and after a few seconds it is ready for testing.***
<br>

### (Optional) Connect your Lambda Function with your Alexa Skill over the AWS Website
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
You can  go to the alexa developer site and go to the "Test" Section. There select Development in the Dropdown and type in your Invocation name to start your skill. You are now ready to make inputs either per voice or text input to alexa. (Be sure that your Skill is saved and built)


### Debug your Skill

In order to debug your skill there are two options.
1. On the alexa developer site under the test section you will get two JSON Files when you gave alexa an input. The JSON Input on the left side will display you every input informations such as input values, slot variables and session varibales. On the right side you will find the alexa output as a json.
2. To get console logs type `sls logs --function FUNCTIONNAME` into your terminal

## (Optional) Amazon AWS Cloudwatch

1. Go to the AWS Website and login in with your credentials (you find them your credentials.json)
1. Go to the AWS Management Console and select "CloudWatch"
1. Select "View logs"
1. Select the latest log
1. You can see the console logs from your application now

### Important notes

- Do not forget to always save and build your model when you make any changes at the alexa dev site
- You do not have to rebuild your model when you edited and deployed your code in the lambda function just reload the "Test" page of your Alexa Skill and you are ready for testing
- In case you don't use serverless frameworkds you have to zip your package directly within your directory and not the whole package folder!