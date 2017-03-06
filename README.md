# todo

FIXME

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Dependencies

This app requires a PostgreSQL database running and accessible on "postgresql://localhost:5432/todo". You can also specify a different database by setting the `DATABASE_URL` environment variable.

## Use

This is currently just a JSON api. I have been testign the following endpoints using cURL.

I like to parse the response by piping it through `python -m json.tool`, but you may prefer other ways.

e.g. `curl localhost:3000/api/todos | python -m json.tool`

Get all todos: `localhost:3000/api/todos`

```
curl localhost:3000/api/todos | python -m json.tool
```

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2017 FIXME
