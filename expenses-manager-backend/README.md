```
docker exec -it a7 mongo --authenticationDatabase admin -u user -p password
```

```
db.createUser({user: 'test', pwd: 'test', roles: [{role: 'readWrite', db: 'test'}]})
```