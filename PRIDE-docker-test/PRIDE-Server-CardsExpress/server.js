
var express = require("express");
var app = express();
var PORT = process.env.PORT || 8085;
var bodyparser = require("body-parser");
var cors = require('cors');
const cards = require('./cardsRoute');

app.set('view engine', 'ejs');
app.use(bodyparser.json())
app.use(bodyparser.urlencoded({ extended: true }));
app.use(cors());

/**
 * The below app.use will allow incoming requests to be checked against the cardsRoute file.
 */
app.use('/cards', cards);

app.listen(PORT, () => {
    console.log(`Server started on port ${PORT}`)
});
