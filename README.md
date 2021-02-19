# twitter-kstreams
This project demonstrates how to use Kafka Streams to process and transform a stream of tweets from twitter.

# Setup
1. Make sure to replace the keys and secrets in the .env.dev file with your twitter app 
keys and secrets

2. Run
```bash
docker-compose --env-file ./env/.env.dev up -d
```

# Project Scope
- [x] Setup up scala/sbt project
- [x] Set up docker with zookeeper, broker and schema registry
- [x] Set up environment variables
- [x] Get started with twitter streams api
- [ ] Build simple kafka producer with twitter streams api
- [ ] Build avro schema-based kafka producer with twitter streams api

