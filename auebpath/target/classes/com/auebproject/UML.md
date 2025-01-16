```mermaid
classDiagram
    class Url {
        - static final String BASE_URL : String
        # static String urlCreator(String endpoint)
    }

    class CodeToName {
        + String getStopName(String stopCode)
        + String[] getStopXY(String stopCode)
        + String getLineName(String lineCode)
        + String getMLName(String MLCode)
        + String getRouteName(String routeCode)
        + String getExactInfoForOne(String urlItem, String object)
    }

    class JSONtoString {
        + List~String~ getExactInfo(String urlItem, String object1, String object2)
        + List~String~ getStopInfo(String stopCode)
    }

    class Location {
        + void location()
        + static void openDestinationWindow(String currentLocation)
    }

    class Main {
        + static void main(String[] args)
    }

    class overpassAPI {
        + static void fetchOverpassAPIData()
    }

    Url <|-- CodeToName : inherits
    CodeToName <|-- JSONtoString : inherits

    Main --> CodeToName : uses
    Main --> JSONtoString : uses
    Main --> Location : uses
    Main --> overpassAPI : uses
