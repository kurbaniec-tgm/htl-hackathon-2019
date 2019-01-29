# Prerequisites


## Development Setup

After you installed your development environment you have to install the following dependencies to work effectively in the hackathon.

## Clone your git

Frist of all, to get started you have to clone the right git repo for your team. Just download the .zip file or use git as you know it. If you don't know which folder you have to use just ask your coach.
URL: https://github.com/mathiashoeld

### Retrieve your credentials

You can find your credentials inside your team folder (`/<Your Team>/credentials.json`) of this repo. Please only use the credentials for your team.

- AWS: Credentials for the Amazon Cloud provider
- Alexa: Credentials for the Amazon Developer Console (where you develop/test your Alexa skill)

### NodeJS

**_ NodeJS is needed for every team in order to use the `Serverless Framework`! _**

Before you start, make sure that you have `NodeJS` installed on your machine. To do you go to `https://nodejs.org/en/download/` and install the current LTS version.

### Serverless Framework

After the installation of `NodeJS` start the NodeJS CommandPrompt (NOT the Windows-Terminal) install the Serverless Framework with `npm install -g serverless`. The serverless.yml is already configured in your project folder.

Afterwards set up your serverless config with your AWS `Key` and `Secret` which you retrieved in the step above with this command `serverless config credentials --provider aws --key KEY --secret SECRET`

Now you're able to deploy your functions with serverless `deploy function -f functionname` directly to your aws

### Postman

In order to make different API Calls you can get Postman for free. Go to https://www.getpostman.com/products and download the App. With postman you are able to make quick api calls with easy params editing and you will get a clear and fast response.


### Maven (for Java only)
In order to deploy lambda functions in Java you need to download apache maven (Url: http://maven.apache.org/download.cgi) unzip it in a directory of your choice e.g. C:\opt\apache-maven
1. Add MAVEN_HOME system variable and point it to the maven folder.
2. Go to the advanced system setting --> select advanced --> select environmental variables.
3. In the System variables section select new and add: MAVEN_HOME and point it to c:\opt\apache-maven-3.6.0
4. In system variables, find PATH, click on the Edit Button.
5. Click on the New Button and add this %MAVEN_HOME%\bin

1. Build the package via the maven command (without the quotes): "mvn assembly:assembly -DdescriptorId=jar-with-dependencies package" 
2. Use the "java-lambda-1.0-jar-with-dependencies.jar" as the .jar file for the upload in the lambda function
3. The handler name that will have to be used is (without the quotes): "HelloWorldStreamHandler" 