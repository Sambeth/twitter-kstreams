# twitter-kstreams
This project demonstrates how to use Kafka Streams to process and transform a stream of tweets from twitter.

# Setup
Make sure you have sbt installed or open project using Intellij IDE.

1. Run
```bash
docker-compose up -d
```

# Project Scope
- [x] Setup up scala/sbt project
- [x] Set up docker with zookeeper, broker and schema registry
- [x] Set up environment variables
- [x] Get started with twitter streams api
- [x] Setup up docker for kstreams app
- [x] Figure out how to push image to docker hub
- [x] Figure out how to autobuild image as update pushed to github
- [x] Build simple kafka producer with twitter streams api
- [x] Figure out data you will need from stream filtered data
- [x] Changed kakfa avro producer scala code to using kafka connect
- [x] Add volumes to docker containers
- [ ] Build graph model of twitter tweet data using arrow for neo4j graph database
- [ ] ~~Build avro schema-based kafka producer with twitter streams api and schema registry~~
- [ ] Figure out how to write tests for this project
- [ ] Setup github actions at a point
- [ ] Structure build.sbt file more professionally
- [ ] Create development branch named `dev` for development