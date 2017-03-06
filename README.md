# todo

This app clearly lacks a front-end. I didn't think that I had time to build out a clojurescript/react front end in the 2-4 hours specified. Instead I built out an API.

This project has been an interesting learning process. Check the git commit comments for more insight into my design decisions. I'm sure I would have made different decisions if I had a better understanding of the idioms of Clojure.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

This app requires a PostgreSQL database running and accessible on "postgresql://localhost:5432/todo". You can also specify a different database by setting the `DATABASE_URL` environment variable.

## Use

This is currently just a JSON api. I have been testing the following endpoints using cURL.

I like to parse the response by piping it through `python -m json.tool`, but you may prefer other ways.

e.g. `curl localhost:3000/api/todos | python -m json.tool`

GET all todos: `localhost:3000/api/todos`

```
curl localhost:3000/api/todos | python -m json.tool
```

GET a todo by id
```
curl localhost:3000/api/todos/:id | python -m json.tool
```

POST a new todo:
```
curl -X POST "localhost:3000/api/todos/" -d '{"body": "A new body", "completed": false}' -H "Content-Type: application/json"
```

update (PATCH) the completeness of a todo
```
curl -X PATCH "localhost:3000/api/todos/" -d '{"completed": false, "id": 1}' -H "Content-Type: application/json"
```

DELETE a todo
```
curl -X DELETE "localhost:3000/api/todos/" -d '{"id": 2}' -H "Content-Type: application/json"
```

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2017 FIXME
