package APITesting.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigManager {
    private static final Dotenv dotenv = Dotenv.configure().load();

    public static String getBaseUrl(){
        return dotenv.get("BASE_URL");
    }

    public static String getName(){
        return dotenv.get("ACCOUNT_USERNAME");
    }

    public static String getPassword(){
        return dotenv.get("ACCOUNT_PASSWORD");
    }

    public static String getToken(){
        return dotenv.get("TOKEN");
    }

    public static String getEmail(){
        return dotenv.get("EMAIL");
    }

    public static String getPasswordForEmail(){
        return dotenv.get("PASSWORD");
    }

    public static String ID() {
        return dotenv.get("ID");
    }
}





