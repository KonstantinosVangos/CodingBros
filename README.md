Description:

AuebPath is an application designed to optimize roots to and from the Athens University of Economics and Business (AUEB) based on the user's location within the Athens geographic area.

To compile the application, follow these steps:

- On VisualStudio Code Terminal write:
    "cd auebpath"
    "mvn package"

To run the application, follow these steps:

- On Cmd/Cygwin write:
    "cd auebpath\target"
    "java -jar auebpath-1.0-SNAPSHOT.jar"

Application User Instructions:

1) Registration: The user creates an account by registering with their desired login credentials.
2) Login: Once registered, the user logs in with the credentials they created.
3) Location Input: After logging in, the user enters their location address within the Athens geographic area.
4) Route Display: Once the address is submitted, a map showing the route is displayed.
5) Drag and Drop: The user can drag and drop a pedestrian icon on the map, which will display the live route with photos to and from Athens University of Economics and Business

Presentation of the structure of the repository:
C:.
├───.vscode
└───auebpath
    ├───src
    │   └───main
    │       ├───java
    │       │   └───com
    │       │       └───auebproject
    │       └───resources
    │           ├───data
    │           ├───images
    │           └───web
    └───target
        ├───classes
        │   ├───com
        │   │   └───auebproject
        │   ├───data
        │   ├───images
        │   └───web
        ├───generated-sources
        │   └───annotations
        ├───maven-archiver
        └───maven-status
            └───maven-compiler-plugin
                ├───compile
                │   └───default-compile
                └───testCompile
                    └───default-testCompile

Overview of data structures and algorithms used by the application:
1.Data Structures:
    JSONArray: It is used to store data in the form of a JSON array (which may contain multiple JSON objects).
    JSONObject: It is used to represent and manage a single JSON object (with key-value pairs).
    Connection: The Connection object represents an open connection to a database. It is used to interact with the database.
    Edge: Represents an edge in a graph.
    JSONArray: Stores an array of results returned by the API.
    JSONObject: Represents each object in the JSON response, such as the top-level object, geometry, and location.
    from and to: References to Node objects, representing the start and end points of the edge.
    distance: A double value representing the weight or distance of the edge. This could represent costs, distances, or other metrics in a graph.
    List<Node>: A list of Node objects represents a path in a graph. Each Node likely contains fields like lat (latitude), lon (longitude), and id.
    Map<String, Node>: A map storing Node objects, where the key is a String identifier, and the value is the corresponding Node.
    List<Edge>: A list of Edge objects represents the connections (edges) in the graph, including their properties (e.g., distance).
    StringBuilder: Used for efficient construction of the GeoJSON string by appending strings incrementally.
    Path: Represents file paths for the exported GeoJSON files.
    String: Used to store the HTML template for rendering the GeoJSON data on a Google Map. Holds the GeoJSON data read from a file and embeds it into the template.
    Path: Represents the file paths for the GeoJSON file and the generated HTML output. lastMapViewerFilePath keeps track of the last generated HTML file path.
    Files: Used to read the contents of the GeoJSON file (Files.readString) and create a temporary file for the HTML output (Files.createTempFile).
    double[] latLon: Stores the latitude and longitude retrieved for the given address using the GeocodingService.
    List<Edge>: Represents the edges of the graph, parsed from a GeoJSON file using MapCreator.parseEdgesFromGeoJson().
    Node: Represents graph nodes, where each node has an id (name), lat (latitude), and lon (longitude).Two Node objects are created: asoee: Represents a fixed starting point (hardcoded coordinates). input: Represents the destination node based on the provided address.
    List<String>: The primary structure used to store data extracted from the JSON responses. For example: infoList: Holds values of specified JSON objects (object1, object2) extracted from the JSON array. stopInfoList: Stores detailed information about a specific stop, including the stop name and route arrival times.
    JSONArray and JSONObject: Used for parsing and accessing JSON-formatted API responses. JSONArray: Represents the array of objects returned by the API. JSONObject: Represents individual objects within the JSON array, used to extract values for specific keys.
    Node: Represents locations with latitude and longitude.
    Edge: Represents connections between nodes.
    User: Holds user information like firstname, lastname, username, etc.
    UserDAO: Manages database-like operations for users.
    Lists (ArrayList): Stores collections of items, such as route codes or stop information. Used in methods like getExactInfo and getStopInfo.
    Map-like Structures (JSON Objects): JSON is parsed into JSONObject and JSONArray for hierarchical data storage.
    Strings: Frequently used for processing and manipulating textual data (e.g., URLs, GeoJSON data, user inputs).
    Temporary Files: Used in GeoJsonToHtmlGenerator to store generated HTML files temporarily.
    Map<String, Node>: Stores nodes with a unique reference ID (ref) as the key.
    List<Edge>: Stores edges between nodes, representing connections with distances.
    AtomicInteger: Used for generating unique IDs for nodes.
    JsonNode: Represents parsed JSON data from GeoJSON files.
    String id: Represents the unique identifier for the node.
    double lat, double lon: Represent the latitude and longitude of the node.
    Node node: Represents a node in the graph.
    double distance: Represents the distance to the associated node.
    Map<String, Node>: Used in the method findClosestNode(Map<String, Node>, double, double) to store nodes and perform distance calculations based on geographic coordinates.
    List<Edge>: Used in the method findClosestNode(List<Edge>, double, double) to store edges and find the closest node from a list of edges.
    Node: The Node class represents a geographical point with latitude and longitude. Nodes are compared to find the closest one to a target location.
    Path: Used to represent the path to the HTML file generated by GeoJsonToHtmlGenerator. It allows for platform-independent file operations.
    URI: A Uniform Resource Identifier that is derived from the Path object and used to identify the location of the HTML file on the web or in the file system.
    StringBuilder: Used to efficiently build the response string by appending lines read from the HTTP response.
    HttpURLConnection: Represents the connection to the URL and is used to make the HTTP request and handle the response.
    BufferedReader: Used to read the response from the input stream of the HTTP connection, allowing efficient reading of the response line-by-line.
    URL: Represents the URL to which the HTTP GET request is sent. It is used to create a connection and retrieve data.
    String firstname: Stores the user's first name.
    String lastname: Stores the user's last name.
    String email: Stores the user's email address.
    String username: Stores the user's username.
    String password: Stores the user's password.
    getFirstname(), getLastname(), getEmail(), getUsername(), getPassword(): Retrieve the corresponding values for each attribute.
    setFirstname(String firstname), setLastname(String lastname), setEmail(String email), setUsername(String username), setPassword(String password): Set the values of the corresponding attributes.
    List<User>: Used to store and return a collection of User objects retrieved from the database in the getUsers() method.
    User: Represents a user object with attributes like firstname, lastname, email, username, and password.
    PreparedStatement: Used to execute SQL queries safely, preventing SQL injection attacks.
    ResultSet: Holds the result of the SQL query. The ResultSet is used to retrieve the data from the database and map it to User objects.
    DB: Presumably a custom class that manages database connections (getConnection() and close() methods).
    Connection: Represents the connection to the database, used to execute SQL queries.
    List<Node>: Stores the list of nodes in the path.
    Map<Node, List<Edge>>: Represents the adjacency list, mapping each node to its list of edges (neighbors).
    Map<Node, Double>: Stores the shortest distance to each node during the Dijkstra algorithm.
    Map<Node, Node>: Stores the predecessors of each node for path reconstruction.
    PriorityQueue<NodeDistance>: A priority queue used to process nodes based on their shortest distance. The NodeDistance class holds the node and its associated distance.
    Set<Node>: Used for tracking unique nodes and visited nodes during graph traversal.
    LinkedList<Node>: A linked list used to reconstruct the shortest path.
    Edge: Represents an edge between two nodes, storing information such as the source node, destination node, and edge distance.
    
2.Algorithms:
    Searching and Retrieving Data from a URL: The code constructs URLs to retrieve data from a remote resource and then processes the returned JSON data. The method getExactInfoForOne processes the JSON and extracts a specific field (e.g., "stop_descr", "line_descr") from the first object in the array.
    Database Connection Algorithm: The getConnection() method loads the MySQL JDBC driver dynamically and establishes a connection to the database using the DriverManager.getConnection() method. It handles exceptions to ensure proper error reporting if something goes wrong during connection.
    Database Disconnection Algorithm: The close() method ensures that the connection to the database is properly closed using the con.close() method, which ends the session and releases resources.
    HTTP Request and Response Handling: The code constructs a URL using the given address, sends a GET request to the Google Geocoding API using HttpURLConnection, and reads the response using a BufferedReader.
    JSON Parsing: Parses the API response to extract the latitude and longitude values from the location object within the geometry field of the first result in the results array.
    Error Handling: Checks the status field in the JSON response. If the status is not "OK", it throws an exception with the error details.
    GeoJSON Creation for Nodes and Edges: The method constructs a valid GeoJSON representation of the graph by iterating through:
    Nodes: Each Node is represented as a Point feature with its id as a property.
    Edges: Each Edge is represented as a LineString feature with its distance as a property.
    Shortest Path Export: The exportShortestPathToGeoJson method: Iterates through a list of Node objects to add each as a Point. Connects consecutive Node objects with LineString features to represent the path.
    Validation: Both methods validate the inputs to ensure no null values exist in the nodes, edges, or paths.
    File Management: Temporary files are created using Files.createTempFile, and the GeoJSON content is written to these files.
    Error Handling: Throws exceptions when invalid data (e.g., null nodes or edges) is encountered.
    HTML Template Generation: A predefined HTML template is stored as a String. The placeholder %%GEOJSON_DATA%% in the template is replaced with the contents of the GeoJSON file using String.replace.
    File Handling: GeoJSON Input: Reads the contents of the GeoJSON file using Files.readString to embed into the HTML template. HTML Output: Creates a temporary file for the generated HTML using Files.createTempFile and writes the processed HTML content using FileWriter.
    Error Handling: Catches exceptions like IOException and URISyntaxException during file reading/writing or path handling and logs the error message.
    Shortest Path Calculation: The ShortestPath.findShortestPath method computes the shortest path from the starting node (asoee) to the destination node (input) using the graph defined by the list of Edge objects.
    GeoJSON Export: The result of the shortest path calculation is exported to a GeoJSON file using GeoJsonExporter.exportShortestPathToGeoJson.
    HTML Generation: The GeoJSON file is used to generate an HTML file for visualizing the path on a map using GeoJsonToHtmlGenerator.generateHtml.
    Visualization: The generated HTML file is opened in a web browser using OpenHtmlFile.openHtml.
    Error Handling: Wraps the entire process in a try-catch block to handle potential exceptions, such as issues with geocoding, file operations, or shortest path computation.
    Thread Sleep: Adds a delay (Thread.sleep(1000)) to ensure the HTML generation and file system updates are complete before opening the file.
    Iterative JSON Parsing: In the getExactInfo method: Iterates through a JSON array (JSONArray), checks if the objects have the required keys (object1 and object2), and retrieves their values. Appends the retrieved values to infoList.
    Conditional Data Extraction: getStopInfo: Retrieves a stop's name using getStopName(stopCode). Iteratively fetches and processes route information and arrival times from a JSON API endpoint. Alternates between route names (using getRouteName) and times (btime2) to populate stopInfoList.
    Handling Missing Data: Checks if the URL response (urlItem) is "null". If so, adds "null" to the stopInfoList to indicate unavailable data.
    String Construction and Transformation: Extracts route and time data, alternating between even (route) and odd (time) indices in the infoList.
    Parsing and Data Extraction: JSON Parsing in JSONtoString.getExactInfo: Loops through JSON arrays, extracting specific fields. GeoJSON Parsing in MapCreator.parseEdgesFromGeoJson: Parses edges (connections) from GeoJSON files.
    File Handling and Template Replacement: In GeoJsonToHtmlGenerator.generateHtml: Reads a GeoJSON file and injects its content into an HTML template.
    Authentication Algorithm: Found in UserDAO.authenticate. Verifies user credentials by checking input data against a database or data store.
    GUI Navigation Algorithm: In Location class: Implements button-based navigation using CardLayout. Handles user actions like login, register, and submit location.
    Event Handling and Validation: Found in GUI-related code: Processes events like button clicks (e.g., loginButton.addActionListener). Validates user input before proceeding with operations.
    Error Handling and Retry Logic: Present in multiple places (e.g., Input.inputForGUI, Location.showTryAgainScreen). Captures exceptions, displays error messages, and provides retry options.
    JSON Parsing: Uses Jackson's ObjectMapper to parse GeoJSON data into JsonNode objects.
    Graph Construction: Processes coordinates to create nodes and edges, ensuring unique nodes using computeIfAbsent.
    Distance Calculation: Calculates distances between nodes, likely using the Haversine formula.
    Object Construction: The constructor initializes the Node with an ID and geographic coordinates (latitude and longitude).
    Find Closest Node: Searches through nodes or edges and calculates the distance to find the closest one.
    Distance Calculation: Uses Euclidean and Haversine formulas for different distance calculations.
    Validation: Ensures valid geographic coordinates are used.
    URL Creation and HTTP Request: urlCreator(String endpoint): This method constructs the full URL by combining the base URL (BASE_URL) and the provided endpoint. It opens an HTTP connection using HttpURLConnection and sends a GET request with the Accept header set to application/json.
    Response Handling: The HTTP response code is checked: If the response code is 500 (Internal Server Error), the method returns null. If the response code is not 200 (OK), an error message is printed, and null is returned. If the response code is 200, the response body is read using a BufferedReader and returned as a string.
    Encapsulation: The class uses private instance variables and public getter and setter methods to access and modify those variables, ensuring data encapsulation.
    reconstructPath(Map<Node, Node> predecessors, Node start, Node end): Reconstructs the path from start to end using the predecessors map, which stores the parent of each node during the shortest path calculation.
    buildAdjacencyList(List<Edge> edges): Builds the adjacency list from the given list of edges. Each node is mapped to a list of edges representing its neighbors.
    validateEdges(List<Edge> edges): Validates the edges by checking that they are not null, the nodes are valid, and the edge distances are positive.
    checkGraphConnectivity(List<Edge> edges): Checks whether the graph is fully connected by performing a depth-first search (DFS) starting from an arbitrary node. It ensures that all nodes in the graph can be reached from any other node.
    dfs(Map<Node, List<Edge>> adjacencyList, Node current, Set<Node> visited): A recursive depth-first search used to explore the graph and mark nodes as visited. This is used in checkGraphConnectivity to ensure all nodes are reachable.
    findShortestPath(Node start, Node end, List<Edge> edges): Implements Dijkstra's algorithm to find the shortest path between the start and end nodes. The algorithm works by processing nodes based on their distance from the start node, updating the distances to neighbors if a shorter path is found. The priority queue ensures that the      next node to process is always the one with the shortest distance.
    
The UML Diagram is (Copy the code in mermaid to see the full Diagram):
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

    Location "1" -- "1..*" UserDAO : "Uses"
    Location "1" -- "1..*" User : "Uses"
    Location "1" -- "1..*" Input : "Uses"
    Location --> "1" JFrame : "Creates"
    Location --> "1" JPanel : "Creates"
    Location --> "1" JButton : "Uses"
    Location --> "1" JTextField : "Uses"
    Location --> "1" JPasswordField : "Uses"
    UserDAO --> "1" User : "Uses"
    User "1" -- "1..*" JTextField : "Uses"
    User "1" -- "1..*" JPasswordField : "Uses"
    UserDAO "1" -- "1..*" User : "Manages"

    class Main {
        +public static void main(String[] args) throws IOException
    }

    class Location {
        +static void showLoginPage()
    }

    Main "1" -- "1" Location : Calls
