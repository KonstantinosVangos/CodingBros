Description:

AuebPath is an application designed to optimize roots to and from the Athens University of Economics and Business (AUEB) based on the user's location within the Athens geographic area.

To compile the application, follow these steps:


To run the application, follow these steps:


Application User Instructions:

1) Registration: The user creates an account by registering with their desired login credentials.
2) Login: Once registered, the user logs in with the credentials they created.
3) Location Input: After logging in, the user enters their location address within the Athens geographic area.
4) Route Display: Once the address is submitted, a map showing the route is displayed.
5) Drag and Drop: The user can drag and drop a pedestrian icon on the map, which will display the live route with photos to and from Athens University of Economics and Business

Presentation of the structure of the repository:


The UML Diagram is:

```mermaid
    classDiagram
    class CodeToName {
        +String getStopName(String stopCode)
        +String[] getStopXY(String stopCode)
        +String getLineName(String lineCode)
        +String getMLName(String MLCode)
        +String getRouteName(String routeCode)
        +String getExactInfoForOne(String urlItem, String object)
    }

    class Url {
        <<abstract>>
        +String urlCreator(String endpoint)
    }

    class DB {
        +Connection getConnection() throws Exception
        +void close() throws SQLException
    }

    class Edge {
        +Node from
        +Node to
        +double distance
        +Edge(Node from, Node to, double distance)
        +Node getFrom()
        +Node getTo()
        +double getDistance()
        +String toString()
    }

    class GeocodingService {
        +double[] getLatLon(String address) throws Exception
    }

    class GeoJsonExporter {
        +static void exportShortestPathToGeoJson(List<Node> pathNodes, String outputFilePath) throws IOException
        +static void exportToGeoJson(Map<String, Node> nodes, List<Edge> edges, String outputFilePath) throws IOException
    }

    class GeoJsonToHtmlGenerator {
        +static void generateHtml(String geoJsonFilePath, String outputHtmlFilePath)
    }

    class HtmlViewerAppSwing {
        +public static void main(String[] args)
    }

    class Input {
        +static void inputForGUI(String address)
    }

    class JSONtoString {
        +List<String> getExactInfo(String urlItem, String object1, String object2)
        +List<String> getStopInfo(String stopCode)
        +String test(String stopCode)
    }

    class Node {
        +String id
        +double lat
        +double lon
        +Node(String id, double lat, double lon)
    }

    class Location {
        +static void showLoginPage()
    }

    CodeToName --|> Url : extends
    JSONtoString --|> CodeToName : extends
    DB o-- "1" Connection : contains
    GeocodingService o-- "1" Node : works with
    GeoJsonExporter o-- "1" Node : works with
    GeoJsonToHtmlGenerator o-- "1" GeoJsonExporter : uses
    HtmlViewerAppSwing o-- "1" GeoJsonToHtmlGenerator : uses
    Input o-- "1" GeocodingService : uses
    Edge o-- "1" Node : works with
    Node --|> Edge : connected by

    Location --|> "1" HtmlViewerAppSwing : launches

    class User {
        +String firstname
        +String lastname
        +String email
        +String username
        +String password
        +User(String firstname, String lastname, String email, String username, String password)
        +String getFirstname()
        +void setFirstname(String firstname)
        +String getLastname()
        +void setLastname(String lastname)
        +String getEmail()
        +void setEmail(String email)
        +String getUsername()
        +void setUsername(String username)
        +String getPassword()
        +void setPassword(String password)
    }

    class UserDAO {
        +List<User> getUsers() throws Exception
        +User findUser(String username) throws Exception
        +User authenticate(String username, String password) throws Exception
        +void register(User user) throws Exception
    }

    class ShortestPath {
        +List<Node> findShortestPath(Node start, Node end, List<Edge> edges)
        +private List<Node> reconstructPath(Map<Node, Node> predecessors, Node start, Node end)
        +private Map<Node, List<Edge>> buildAdjacencyList(List<Edge> edges)
        +private void validateEdges(List<Edge> edges)
        +void checkGraphConnectivity(List<Edge> edges)
        +private void dfs(Map<Node, List<Edge>> adjacencyList, Node current, Set<Node> visited)
        +class NoPathFoundException extends RuntimeException
    }

    class NodeHandling {
        +Node findClosestNode(Map<String, Node> nodes, double targetLat, double targetLon)
        +Node findClosestNode(List<Edge> edges, double targetLat, double targetLon)
        +double calculateDistance(Node from, Node to)
        +double calculateDistance(Node from, double lat, double lon)
        +private boolean isValidCoordinate(double lat, double lon)
        +class NoNodeFoundException extends RuntimeException
    }

    class Edge {
        +Node from
        +Node to
        +double distance
        +Edge(Node from, Node to, double distance)
        +Node getFrom()
        +Node getTo()
        +double getDistance()
    }

    class Node {
        +String id
        +double lat
        +double lon
        +Node(String id, double lat, double lon)
        +String getId()
        +double getLat()
        +double getLon()
    }

    class MapCreator {
        +Map<String, Node> parseNodesFromGeoJson() throws IOException
        +List<Edge> parseEdgesFromGeoJson() throws IOException
    }

    class OpenHtmlInBrowser {
        +void openHtml()
    }

    class NodeDistance {
        +Node node
        +double distance
        +NodeDistance(Node node, double distance)
    }

    UserDAO --> User
    ShortestPath --> Node
    ShortestPath --> Edge
    NodeHandling --> Node
    NodeHandling --> Edge
    MapCreator --> Node
    MapCreator --> Edge
    NodeDistance --> Node
    NodeDistance --> double
    OpenHtmlInBrowser --> URI
    OpenHtmlInBrowser --> Desktop

    Location "1" -- "1..*" UserDAO : Uses
    Location "1" -- "1..*" User : Uses
    Location "1" -- "1..*" Input : Uses
    Location --> "1" JFrame : Creates
    Location --> "1" JPanel : Creates
    Location --> "1" JButton : Uses
    Location --> "1" JTextField : Uses
    Location --> "1" JPasswordField : Uses
    UserDAO --> "1" User : Uses
    User "1" -- "1..*" JTextField : Uses
    User "1" -- "1..*" JPasswordField : Uses
    UserDAO "1" -- "1..*" User : Manages

    class Main {
        +public static void main(String[] args) throws IOException
    }

    class Location {
        +static void showLoginPage()
    }

    Main "1" -- "1" Location : Calls

Overview of data structures and algorithms used by the application:
