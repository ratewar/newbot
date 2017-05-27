# Newbot

Use the following AWS CLI command to create bot lambda function 
-----------------------------------------------------------------
Change role arn and folder location according to you settings and configuration
----------------------------------------------------------------------------------

aws lambda create-function --region us-east-1 --function-name awschatbot --zip-file fileb://D:/git_repositories/git/newbot/awsChatbot/target/awsChatbot-1.0-SNAPSHOT-shaded.jar --role arn:aws:iam::512785838931:role/service-role/testhelloworld --handler com.tech.unleashed.LambdaHook::handleRequest --runtime java8 


To Delete the bot function using AWS CLI use the follwoing command
--------------------------------------------------------------------------
aws lambda delete-function  --function-name awschatbot  --region us-east-1


To test this function use the Lambda sample event for ordering flowers. Note - in JSON PickupDate, PickupTime, FlowerType need to be modified as pickUpDate, pickUpTime, flowerType as json must follow bean naming conventions (camel case).


Generate Java Classes using JSON [http://www.jsonschema2pojo.org/]
