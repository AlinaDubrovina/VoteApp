# VoteApp
VoteApp

Endpoints

/genres

/artists

/vote

/statistics

Examples

/genres

To get a list of genres:

(GET)http://host:port/WarFileName/genres

To create:

Send POST request on http://host:port/WarFileName/genres

And pass following in the body of request in JSON format:

{
"genreTitle": "example"
}

To update:

Send PUT request on http://host:port/WarFileName/genres/{id}

And pass following in the body of request in JSON format:

{
"genreTitle": "example"
}

To delete:

Send DELETE request on http://host:port/WarFileName/genres/{id}

/artists

To get a list of artists:

(GET)http://host:port/WarFileName/artists

To create:

Send POST request on http://host:port/WarFileName/artists

And pass following in the body of request in JSON format:

{
"name": "example"
}

To update:

Send PUT request on http://host:port/WarFileName/artists/{id}

And pass following in the body of request in JSON format:

{
"name": "example"
}

To delete:

Send DELETE request on http://host:port/WarFileName/artist/{id}

/vote
(1 vote for artist, 3-5 votes for genre)

Send POST request on http://host:port/WarFileName/vote

And pass following in the body of request in JSON format:

{
"artistId": 1,
"genreIds": [1,2,3],
"about": "example"
}

/statistics

Send GET request http://host:port/WarFileName/statistics