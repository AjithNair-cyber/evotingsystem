package app;

import app.io.github.cdimascio.dotenv.Dotenv;

abstract class Config{
    static Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();
    static final String DATABASE_URL = dotenv.get("DATABASE_URL");
    static final String DATABASE_USER = dotenv.get("DATABASE_USER");
    static final String DATABASE_PASSWORD = dotenv.get("DATABASE_PASSWORD");
}
