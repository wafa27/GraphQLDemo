# Getting started with GraphQL on Android
This is a demo application using apollo library for GraphQL with Android. 
We are using an instance of Apollo Server hosted on Heroku, including the corresponding GraphQL Playground.
Following are the main steps:

#####  1. In your app Gradle file, apply the com.apollographql.apollo plugin:
```
plugins {
    .....
    id("com.apollographql.apollo").version("2.4.1")
}
```

#####  2. Configure the plugin
```
apollo {
  // instruct the compiler to generate Kotlin models
  generateKotlinModels.set(true)
}
```
#####  3. Add the runtime dependencies
```
implementation("com.apollographql.apollo:apollo-runtime:2.4.1")
implementation("com.apollographql.apollo:apollo-coroutines-support:2.4.1")
```
#####  4. Download your Schema.json file
There are many ways to do this:

###### 4.1 You can download a json schema directly from GraphQL Playground by clicking Schema > Download in the right pane.

###### 4.2 Another way is to download the schema file using the downloadApolloSchema task:
```
./gradlew downloadApolloSchema \
  --endpoint="https://your.domain/graphql/endpoint" \
  --schema="src/main/graphql/com/example/schema.json"
  ```

###### 4.3 However, I had issues with both of the above mentioned methods. So, I tried to use the graphqlconfig file to generate the schema.
In order to do this, click on the GraphQL tab in Android Studio 

(insert screenshot here)

Click on `Endpoints` folder and then click on plus icon on left pane to add a graphql configuration file.
Edit the configuartion file and update the Default GraphQL endpoint url to the following:
https://apollo-fullstack-tutorial.herokuapp.com/graphql

Also change the value for `schemaPath` to `schema.json`

<Insert screenshot for config file>

Now click on the green play button in the left gutter. 
This should generate the correct schema.json file.

##### 5. Add a query 

 ###### 5.1 Prototype your query in GraphQL Playground
 https://apollo-fullstack-tutorial.herokuapp.com/

 <Insert screenshot here>

 ###### 5.2 Next, add the query to the project. For this, create a new file named LaunchList.graphql under the folder:
 src/main/graphql/app/android/wfn/graphqldemo

 Ensure that the query file is at the same level as the schema.json file.
