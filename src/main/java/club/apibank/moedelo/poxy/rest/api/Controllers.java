package club.apibank.moedelo.poxy.rest.api;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/api")
public class Controllers {

    @GET
    public String getOrders() {
        return "returning all orders";
    }

    @GET
    @Path("/send")
    public String getOrderById() {


        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.
                    newBuilder().uri(new URI("http://www.codenuclear.com")).GET().build();

            HttpResponse <String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.statusCode());

        } catch (Exception e) {
            System.out.println("message " + e);
        }



        return "returning order with id ";
    }

    @GET
    @Path("/{orderId}/items")
    public String getOrderItemsById(@PathParam("orderId") String orderId) {
        return "returning all order items by order id: " + orderId;
    }

    @GET
    @Path("/{orderId}/items/{itemId}")
    public String getOrderItemByItemId(@PathParam("orderId") String orderId,
                                       @PathParam("itemId") String itemId) {
        return "returning order item by order id: " + orderId +
                " and item id: " + itemId;
    }

}