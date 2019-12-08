import java.util.List;

public interface SecurityUser {
    String fetchToken();

    Long fetchUserId();

    String fetchUserName();

    String fetchUserAccount();

    List<String> fetchOrganizations();

    List<String> fetchPurchaseGroups();

    List<String> fetchLocations();


}
