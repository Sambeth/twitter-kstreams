# twitter-kstreams
This project demonstrates how to use Kafka Streams to process and transform a stream of tweets from twitter.

# Setup
Make sure you have sbt installed or open project using Intellij IDE.

1. Make sure to replace tag for your docker images in .env.dev file with your preferred tag.
Also remember to set up your environment variables for your twitter consumer and access keys.
```bash
export TWITTER_CONSUMER_TOKEN_KEY=your_consumer_key
export TWITTER_CONSUMER_TOKEN_SECRET=your_consumer_secret
export TWITTER_ACCESS_TOKEN_KEY=your_access_key
export TWITTER_ACCESS_TOKEN_SECRET=your_access_secret
```

2. Now run the below command to create your DockerFile with all the steps to setup your app image.
This would create a Dockerfile in target/docker/ . You can use the generated Dockerfile in conjunction
with the docker-compose.yml file to build your containers locally.
```
sbt docker:stage
```

2. Run
```bash
docker-compose --env-file ./env/.env.dev up -d
```

# Project Scope
- [x] Setup up scala/sbt project
- [x] Set up docker with zookeeper, broker and schema registry
- [x] Set up environment variables
- [x] Get started with twitter streams api
- [x] Seup up docker for kstreams app
- [ ] Build simple kafka producer with twitter streams api
- [ ] Build avro schema-based kafka producer with twitter streams api
